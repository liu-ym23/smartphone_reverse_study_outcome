package com.ss.android.lark.integrator.ccm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bytedance.ee.bear.attachment.filereader.FileClickData;
import com.bytedance.ee.bear.attachment.filereader.x;
import com.bytedance.ee.bear.basesdk.apisupport.q;
import com.bytedance.ee.bear.basesdk.apisupport.s;
import com.bytedance.ee.bear.basesdk.apisupport.w;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.lark.SpaceRouteBean;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.document.associated.QuickLaunchBarItemType;
import com.bytedance.ee.bear.facade.common.ExtensionActivityImpl;
import com.bytedance.ee.bear.integrator.dto.FileClickModel;
import com.bytedance.ee.bear.lark.selector.DocModuleInner;
import com.bytedance.ee.bear.lark.selector.DocSelectorActivity;
import com.bytedance.ee.bear.lark.selector.auth.DocAuthSelectorDialog;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.screenshot.FastPngEncoder;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.space.doc.v1.CreateDocFeedRequest;
import com.bytedance.lark.pb.space.doc.v1.MGetDocFeedsRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.ccm_api.ICCMApi;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.doc.entity.DocCard;
import com.ss.android.lark.doc.entity.DocFeed;
import com.ss.android.lark.doc.entity.DocPermPair;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.doc.entity.Extra;
import com.ss.android.lark.doc.entity.Icon;
import com.ss.android.lark.doc.entity.ThumbnailDetail;
import com.ss.android.lark.integrator.ccm.config.viewbinder.DocCardViewBinder;
import com.ss.android.lark.integrator.ccm.im.PreloadDocConfig;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;
import com.ss.android.lark.integrator.ccm.spacekit.j;
import com.ss.android.lark.integrator.ccm.spacekit.l;
import com.ss.android.lark.integrator.ccm.spacekit.m;
import com.ss.android.lark.integrator.ccm.spacekit.n;
import com.ss.android.lark.integrator.ccm.spacekit.o;
import com.ss.android.lark.integrator.ccm.spacekit.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.preload.moment.PreloadMoment;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.l0;
import com.ss.android.lark.utils.o0;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.utils.statistics.PerfLog;
import h0b.g;
import io.reactivex.Flowable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pn4.i;
import pn4.k;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(ICCMApi.class)
public class CCMApiImpl implements ICCMApi {
    private static final String TAG = "CCMApiImpl";
    private static final Map<j5b.a, g> sPushSaveToNutStateListenerMap = null;
    private static final Map<j5b.a, g> sPushSaveToSpaceStateListenerMap = null;
    private FastPngEncoder fastPngEncoder;
    private hz4.b mScreenshotWrapper;

    public class a implements RequestListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f427780a;

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onResourceReady(Object r100, Object r101, Target r102, DataSource r103, boolean r104) {
            return false;
        }

        public a(WeakReference r100) {
            this.f427780a = r100;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onLoadFailed(GlideException r100, Object r101, Target r102, boolean r103) {
            tt5.a.f(CCMApiImpl.TAG, r100, false);
            ((ImageView) this.f427780a.get()).setImageResource(R.drawable.common_failed_chat_picture);
            return true;
        }
    }

    public class b implements i5b.a {
        public b() {
        }
    }

    public class c implements com.bytedance.ee.bear.lark.selector.auth.c {
        public c() {
        }
    }

    public class d implements DocAuthSelectorDialog.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f427781a;

        @Override // com.bytedance.ee.bear.lark.selector.auth.DocAuthSelectorDialog.d
        public final void a(Map<String, DocPermPair.PermType> r100) {
        }

        @Override // com.bytedance.ee.bear.lark.selector.auth.DocAuthSelectorDialog.d
        public final void b() {
        }

        @Override // com.bytedance.ee.bear.lark.selector.auth.DocAuthSelectorDialog.d
        public final void onCanceled() {
        }

        public d(Map r100) {
            this.f427781a = r100;
        }
    }

    public class e implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j5b.a f427782a;

        public e(j5b.a r100) {
            this.f427782a = r100;
        }

        @Override // h0b.g
        public final void a(String r100, int r101) {
            this.f427782a.a(r100, r101);
        }
    }

    public class f implements com.bytedance.ee.bear.templates.dto.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGetDataCallback f427783a;

        public f(IGetDataCallback r100) {
            this.f427783a = r100;
        }
    }

    public CCMApiImpl() {
    }

    public static /* synthetic */ void a(NetService r100, String r101, Context r102, e05.c r103) {
        lambda$getQuickLaunchBarItemForWebContainer$2(null, r100, r101, r102, r103);
    }

    public static /* synthetic */ void b(int r100) {
        lambda$showAdjustExternalPanel$0(null, r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getImportTextRes(int r100) {
        if (r100 != 102) goto L5;
        return R.string.Doc_Facade_ImportAsSheet;
    L5:
        if (r100 == 103) goto L7;
        return R.string.Doc_Facade_ImportAsDoc;
    L7:
        return R.string.Doc_Facade_ImportAsMindnote;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean isP0MergeToMainProc() {
        return true;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void reloadTabPageSpecUrl(wqb.b r100, boolean r101) {
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void setupServices(Context r100) {
    }

    static {
        sPushSaveToNutStateListenerMap = new ConcurrentHashMap();
        sPushSaveToSpaceStateListenerMap = new ConcurrentHashMap();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void destroyTtsSession() {
        SpacekitSdkWrapper.b.f427892a.c();     // Catch: Exception -> L11
        if (((mo5.e) org.koin.java.a.a(mo5.e.class)).isEnable() == true) goto L7;
        tt5.a.h(TAG, "isTtsSessionActive, TTS FG not enabled.");     // Catch: Exception -> L11
        return;
    L7:
        mo5.f r100 = ((mo5.e) org.koin.java.a.a(mo5.e.class)).V6(false);     // Catch: Exception -> L11
        if (r100 == null) goto L15;
        tt5.a.h(TAG, "destroyTtsSession");     // Catch: Exception -> L11
        r100.j();     // Catch: Exception -> L11
        return;
    L15:
        return;
    L11:
        e = move-exception;
        tt5.a.e(TAG, "destroyTtsSession, get session error:", e, false);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public Map<String, String> getDocArgsMessage() {
        HashMap r100 = new HashMap();
        j0b.a.a(r100, "from", "message");
        j0b.a.a(r100, "chat_type", "single");
        j0b.a.a(r100, "message_type", "text");
        j0b.a.a(r100, "botId", null);
        return r100;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public Map<String, String> getDocArgsMessageCard() {
        HashMap r100 = new HashMap();
        j0b.a.a(r100, "from", "message_card");
        j0b.a.a(r100, "chat_type", "single");
        j0b.a.a(r100, "message_type", "text");
        j0b.a.a(r100, "botId", null);
        return r100;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public Map<String, String> getDocArgsOther() {
        HashMap r100 = new HashMap();
        j0b.a.a(r100, "from", "lark_other");
        j0b.a.a(r100, "chat_type", "single");
        j0b.a.a(r100, "message_type", "text");
        j0b.a.a(r100, "botId", null);
        return r100;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean hasLeader() {
        return qa5.b.a.f532259a.f532258a.providePermissionProvider().hasLeader();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean isTtsSessionActive() {
    L14:
        e = move-exception;
        tt5.a.e(TAG, "isTtsSessionActive, get session error:", e, false);
        return false;
    L4:
        if (w.c() == true) goto L6;
        return false;
    L6:
        SpacekitSdkWrapper.b.f427892a.c();     // Catch: Exception -> L14
        mo5.e r100 = (mo5.e) org.koin.java.a.a(mo5.e.class);     // Catch: Exception -> L14
        if (r100.isEnable() == true) goto L11;
        tt5.a.h(TAG, "isTtsSessionActive, TTS FG not enabled.");     // Catch: Exception -> L14
        return false;
    L11:
        if (r100.V6(false) == null) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public i provideFollowSdk() {
        return qa5.b.a.f532259a.f532258a.provideFollowSdk();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public k providePermissionProvider() {
        return qa5.b.a.f532259a.f532258a.providePermissionProvider();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void stopWebScreenShot() {
        hz4.b r100 = this.mScreenshotWrapper;
        if (r100 == null) goto L6;
        r100.stop();
        this.mScreenshotWrapper = null;
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void stopWriteBitmapToFastPNG() {
        FastPngEncoder r100 = this.fastPngEncoder;
        if (r100 == null) goto L6;
        r100.a();
        this.fastPngEncoder = null;
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void unregisterLeaderShare() {
        SpacekitSdkWrapper.b.f427892a.c();
        qa5.b.a.f532259a.f532258a.providePermissionProvider().a();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public q apiGroups() {
        cmb.f.a().getClass();
        return qa5.b.a.f532259a.f532258a;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void checkAndInit() {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.c();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public String getDocPageName() {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        return "space";
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public pn4.g getDriveSdkWrapper() {
        cmb.f.a().getClass();
        return qa5.b.a.f532259a.f532258a.a();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void injectSessionCookies() {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        Log.i("SpacekitSdkWrapper", "DocsImpl.injectSessionCookies ");
        if (((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).isLogin() == false) goto L10;
        String r100 = jl5.a.a();
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return;
    L7:
        if (qa5.b.a() == false) goto L12;
        qa5.b.a.f532259a.f532258a.h().b(r100);
        return;
    L12:
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean isEnableWikiTab() {
        WikiModuleProvider.a().getClass();
        int r100 = WikiModuleProvider.a.f427785a;
        return true;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public Map<String, String> getAutoInitModuleConfigMap() {
        return wrb.a.f560911a;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public Map<Integer, Integer> getLayoutResIdMap() {
        return jmb.b.f499715a;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public Map<String, String> getThirdPartyModuleConfigMap() {
        return wrb.a.f560912b;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public Map<String, String> getThirdPartyPrefixModuleConfigMap() {
        return wrb.a.f560913c;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void addListenerToDriveSaveStateEventPush(g r100) {
        int r101 = com.ss.android.lark.integrator.ccm.a.f427786a;
        new l0();
        if (r100 == null) goto L7;
        acb.e r102 = acb.e.a.f2910a;
        com.ss.android.lark.sdk.f.a(r102.f2908a, r100, new acb.a(r102));
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean canImImport(int r100) {
        checkAndInit();
        boolean r101 = ((BenefitManagerAPI) org.koin.java.a.a(BenefitManagerAPI.class)).n1().hasBenefit("ccm_convert_to_doc");
        if (r100 != 101) goto L5;
    L6:
        if (r101 == false) goto L8;
        return true;
    L8:
        return false;
    L5:
        if (r100 != 102) goto L8;
        goto L6
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean canOpen(String r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        return SpacekitSdkWrapper.b(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void clearCache(IGetDataCallback<Boolean> r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        boolean[] r101 = {false};
        ((com.bytedance.ee.bear.basesdk.apisupport.c) qa5.b.a.f532259a.f532258a.f()).clearCache().observeOn(LarkRxSchedulers.io()).subscribe(new m(r101), new n(r100), new o(r100, r101));
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void createDoc(Activity r100) {
        cmb.f.a().getClass();
        qa5.b.a.f532259a.f532258a.b().createDoc(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void destroyQuickLaunchBarItem(Context r100) {
        cmb.f.a().getClass();
        qa5.b.a.f532259a.f532258a.b().destroyQuickLaunchBarItem(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void forceStopKeepAliveService(Context r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        r100.stopService(new Intent(r100, xl5.a.class));
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void getCacheSize(IGetDataCallback<Long> r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        if (r100 == null) goto L7;
        long[] r101 = {0};
        ((com.bytedance.ee.bear.basesdk.apisupport.c) qa5.b.a.f532259a.f532258a.f()).getCacheSize().observeOn(LarkRxSchedulers.io()).subscribe(new j(r101), new com.ss.android.lark.integrator.ccm.spacekit.k(r100), new l(r100, r101));
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public Map<String, String> getDocArgs(String r100) {
        HashMap r101 = new HashMap();
        j0b.a.a(r101, "from", r100);
        j0b.a.a(r101, "chat_type", "single");
        j0b.a.a(r101, "message_type", "text");
        j0b.a.a(r101, "botId", null);
        return r101;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public ibb.c getDocCardViewBinder(Context r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        return new DocCardViewBinder(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getDocFilterIcon(DocType r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        int r101 = DocModuleInner.a.f227455a[r100.ordinal()];
        if (r101 != 2) goto L5;
        return R.drawable.ic_svg_filter_doc_sheet;
    L5:
        if (r101 != 3) goto L7;
        return R.drawable.ic_svg_filter_doc_bitable;
    L7:
        if (r101 != 4) goto L9;
        return R.drawable.ic_svg_filter_doc_mindnote;
    L9:
        if (r101 != 5) goto L11;
        return R.drawable.ic_svg_filter_doc_file;
    L11:
        if (r101 == 10) goto L13;
        return R.drawable.ic_svg_filter_doc_doc;
    L13:
        return R.drawable.ic_svg_filter_doc_slide;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getDocInlineBlueIcon(int r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r101 = SpacekitSdkWrapper.b.f427892a;
        DocType r102 = DocType.forNumber(r100);
        r101.getClass();
        return SpacekitSdkWrapper.d(r102);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getDocInlineGrayIcon(int r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r101 = SpacekitSdkWrapper.b.f427892a;
        DocType r102 = DocType.forNumber(r100);
        r101.getClass();
        return SpacekitSdkWrapper.d(r102);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getDocMiniIcon(DocType r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        int r101 = DocModuleInner.a.f227455a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return R.drawable.icon_doc_mini_doc;
    L5:
        if (r101 != 2) goto L7;
        return R.drawable.icon_doc_mini_sheet;
    L7:
        if (r101 != 3) goto L9;
        return R.drawable.icon_doc_mini_bitable;
    L9:
        if (r101 != 4) goto L11;
        return R.drawable.icon_doc_mini_mindnote;
    L11:
        if (r101 == 10) goto L13;
        return 0;
    L13:
        return R.drawable.icon_doc_mini_slide;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public i5b.a getDocPageLoader(String r100) {
        return new b();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void getDrivePreviewUrl(pw4.e r100) {
        int r101 = com.ss.android.lark.integrator.ccm.a.f427786a;
        l0 r102 = new l0();
        Object r103 = ((ConcurrentHashMap) r102.f444740a).get(zbb.a.class);
        if (r103 != null) goto L12;
        monitor-enter(r102);
        if (r103 == null) goto L14;
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L14:
        r103 = new acb.f();     // Catch: Throwable -> L9
        ((ConcurrentHashMap) r102.f444740a).put(zbb.a.class, r103);     // Catch: Throwable -> L9
    L12:
        ((zbb.a) r103).b();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getFolderIcon(boolean r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        if (r100 == false) goto L5;
        int r101 = R.drawable.ud_icon_file_round_sharefolder_colorful;
    L7:
        return kac.a.b(r101);
    L5:
        r101 = R.drawable.ud_icon_file_round_folder_colorful;
        goto L7
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getImportType(String r100) {
        return i55.f.a(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean getLeaderShareSetting(IGetDataCallback<Boolean> r100) {
        SpacekitSdkWrapper.b.f427892a.c();
        return qa5.b.a.f532259a.f532258a.providePermissionProvider().getLeaderShareSetting(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public List<d1c.a> getPreloadTasks(PreloadMoment r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r101 = SpacekitSdkWrapper.b.f427892a;
        if (r101 == null) goto L12;
        if (DevicePerfManager.b.f432386a.f432372e.f20370h == true) goto L7;
    L9:
        ArrayList r102 = new ArrayList();
        gmb.a r103 = new gmb.a();
        ((CopyOnWriteArrayList) r101.f427890c).add(r103);
        r102.add(r103);
        return r102;
    L7:
        if (r100 != PreloadMoment.IDLE) goto L9;
    L12:
        return new ArrayList();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public Map<String, String> getUrlParamsMap(String r100) {
        HashMap r101 = new HashMap();
        j0b.a.a(r101, "from", r100);
        j0b.a.a(r101, "chat_type", "single");
        j0b.a.a(r101, "message_type", "text");
        j0b.a.a(r101, "botId", null);
        return r101;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void initDocPlugin(Context r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r101 = SpacekitSdkWrapper.b.f427892a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (o0.b(r100) == false) goto L7;
        int r102 = 0;
    L8:
        r101.i(r102);
        return;
    L7:
        r102 = 5000;
        goto L8
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void initProcessorDoInit(String r100) {
        if (r100 == null) goto L27;
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1131972944: goto L16;
            case -722239547: goto L12;
            case 1873137938: goto L8;
            default: goto L19;
        };
    L19:
        switch(r101) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            default: goto L28;
        };
    L21:
        int r102 = com.ss.android.lark.integrator.ccm.a.f427786a;
        new ConcurrentHashMap();
        return;
    L22:
        WikiModuleProvider.a();
        return;
    L23:
        cmb.f.a();
        return;
    L28:
        return;
    L8:
        if (r100.equals("com.ss.android.lark.drive.DriveModule") == false) goto L19;
        r101 = 2;
        goto L19
    L12:
        if (r100.equals("com.ss.android.lark.integrator.ccm.WikiModuleProvider.WikiModule") == false) goto L19;
        r101 = 1;
        goto L19
    L16:
        if (r100.equals("com.ss.android.lark.integrator.ccm.spacekit.LarkSpacekitModule") == false) goto L19;
        r101 = 0;
        goto L19
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void loadThumbnail(ec5.a r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        Log.i("SpacekitSdkWrapper", "DocsImpl.loadThumbnail ");
        RxScheduledExecutor.justInIO(new com.ss.android.lark.integrator.ccm.spacekit.e(r100));
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void onLoginStatusChangedEvent(int r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r101 = SpacekitSdkWrapper.b.f427892a;
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void openDocs(SpaceRouteBean r100) {
        cmb.f.a().getClass();
        qa5.b.a.f532259a.f532258a.b().f(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public String[] parseDocUrl(String r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        qa5.b r101 = qa5.b.a.f532259a;
        String r102 = r101.f532258a.b().j(r100);
        return new String[]{r101.f532258a.b().l(r100), r102};
    L5:
        return null;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void preloadDoc(List<String> r100) {
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Iterator<String> r101 = r100.iterator();
        boolean r102 = false;
    L7:
        if (r101.hasNext() == false) goto L10;
        String r103 = r101.next();
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        r102 = r102 | SpacekitSdkWrapper.b(r103);
        if (r102 == false) goto L7;
    L10:
        if (r102 == false) goto L16;
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        SpacekitSdkWrapper.h(r100);
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void preloadDocFromFeed(List<String> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<String> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(av5.c.a(r102.next(), "from=docs_feed"));
        goto L4
    L6:
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        SpacekitSdkWrapper.h(r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void preloadWikiTabPageData(Context r100) {
        WikiModuleProvider.a().getClass();
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).a();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void registerPushSaveToNutStateListener(j5b.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        e r101 = new e(r100);
        sPushSaveToNutStateListenerMap.put(r100, r101);
        int r102 = com.ss.android.lark.integrator.ccm.a.f427786a;
        new ConcurrentHashMap();
        acb.e r103 = acb.e.a.f2910a;
        com.ss.android.lark.sdk.f.a(r103.f2908a, r101, new acb.a(r103));
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void registerPushSaveToSpaceStateListener(final j5b.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Objects.requireNonNull(r100);
        g r101 = new cmb.c(r100);
        sPushSaveToSpaceStateListenerMap.put(r100, r101);
        int r102 = com.ss.android.lark.integrator.ccm.a.f427786a;
        new l0();
        acb.e r103 = acb.e.a.f2910a;
        com.ss.android.lark.sdk.f.a(r103.f2909b, r101, new acb.d(r103));
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void removeListenerToDriveSaveStateEventPush(g r100) {
        if (r100 == null) goto L24;
        int r101 = com.ss.android.lark.integrator.ccm.a.f427786a;
        new l0();
        if (r100 == null) goto L31;
        List<g> r102 = acb.e.a.f2910a.f2908a;
        monitor-enter(r102);
        r102.remove(r100);     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        if (r102.isEmpty() == false) goto L29;
        monitor-enter(r102);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (r102.isEmpty() == false) goto L16;
        com.ss.android.lark.sdk.g.e.f439875a.c(Command.PUSH_SAVE_TO_NUT_STORE_STATE);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r102);     // Catch: Throwable -> L18
        return;
    L29:
        return;
    L21:
        th = move-exception;
        throw th;
    L31:
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void setCCMConfig(String r100) {
        cmb.f.a().getClass();
        qa5.b.a.f532259a.f532258a.e().setCCMConfig(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void setIsAppInFront(boolean r100) {
        cmb.f.a().getClass();
        qa5.b.a.f532259a.f532258a.c().setIsAppInFront(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void setOnWebViewCreateListener(h0b.f r100) {
        cmb.f.a().getClass();
        if (SpacekitSdkWrapper.b.f427892a == null) goto L6;
        pn4.e r101 = qa5.b.a.f532259a.f532258a.b();
        com.bytedance.ee.bear.basesdk.apisupport.f r102 = (com.bytedance.ee.bear.basesdk.apisupport.f) r101;
        r102.h(new com.ss.android.lark.integrator.ccm.spacekit.i());
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void startWebScreenShot(i0b.d r100) {
        stopWebScreenShot();
        throw null;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void startWriteBitmapToFastPNG(i0b.e r100) {
        stopWriteBitmapToFastPNG();
        throw null;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void stopClip(WebView r100) {
        qa5.b.a.f532259a.f532258a.b().stopClip(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public ibb.a syncPullDocFeedsByIds(List<String> r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        MGetDocFeedsRequest.Builder r101 = new MGetDocFeedsRequest.Builder().ids(r100);
        ibb.a r102 = (ibb.a) SdkSender.sendRequest(Command.MGET_DOC_FEEDS, r101, new com.ss.android.lark.integrator.ccm.spacekit.f());
        if (r102 != null) goto L6;
        Log.w("SpacekitSdkWrapper", "syncPullDocFeedsByIds() docFeedsResult is null");
        return new ibb.a(new HashMap(), new HashMap());
    L6:
        return new ibb.a(r102.f489142a, r102.f489143b);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void timingCleanData(long r100) {
        cmb.f.a().getClass();
        qa5.b.a.f532259a.f532258a.e().timingCleanData(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void unRegisterPushSaveToNutStateListener(j5b.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Map<j5b.a, g> r101 = sPushSaveToNutStateListenerMap;
        g r102 = r101.get(r100);
        if (r102 == null) goto L24;
        r101.remove(r100);
        int r103 = com.ss.android.lark.integrator.ccm.a.f427786a;
        new l0();
        List<g> r104 = acb.e.a.f2910a.f2908a;
        monitor-enter(r104);
        r104.remove(r102);     // Catch: Throwable -> L21
        monitor-exit(r104);     // Catch: Throwable -> L21
        if (r104.isEmpty() == false) goto L29;
        monitor-enter(r104);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (r104.isEmpty() == false) goto L16;
        com.ss.android.lark.sdk.g.e.f439875a.c(Command.PUSH_SAVE_TO_NUT_STORE_STATE);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r104);     // Catch: Throwable -> L18
        return;
    L29:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void unRegisterPushSaveToSpaceStateListener(j5b.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        g r101 = sPushSaveToSpaceStateListenerMap.remove(r100);
        int r102 = com.ss.android.lark.integrator.ccm.a.f427786a;
        new l0();
        if (r101 == null) goto L26;
        if (r101 == null) goto L33;
        List<g> r103 = acb.e.a.f2910a.f2909b;
        monitor-enter(r103);
        CopyOnWriteArrayList r104 = (CopyOnWriteArrayList) r103;     // Catch: Throwable -> L23
        r104.remove(r101);     // Catch: Throwable -> L23
        monitor-exit(r103);     // Catch: Throwable -> L23
        if (r104.isEmpty() == false) goto L31;
        monitor-enter(r103);
    L20:
        th = move-exception;
        throw th;
    L16:
        if (r104.isEmpty() == false) goto L18;
        com.ss.android.lark.sdk.g.e.f439875a.c(Command.PUSH_SAVE_TO_SPACE_STORE_STATE);     // Catch: Throwable -> L20
    L18:
        monitor-exit(r103);     // Catch: Throwable -> L20
        return;
    L31:
        return;
    L23:
        th = move-exception;
        throw th;
    L33:
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void writeBitmapToFastPNG(i0b.f r100) {
        if (this.fastPngEncoder != null) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getDocInlineBlueIcon(DocType r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        return SpacekitSdkWrapper.d(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getDocInlineGrayIcon(DocType r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        return SpacekitSdkWrapper.d(r100);
    }

    private static /* synthetic */ void lambda$showAdjustExternalPanel$0(ICCMApi.a r100, int r101) {
        r100.a();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void clip(WebView r100, String r101) {
        qa5.b.a.f532259a.f532258a.b().clip(r100, r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public Flowable<DocPermission> fetchDocPermission(String r100, int r101) {
        wh5.d r102 = new wh5.d();
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return r102.b(r100, r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getDocIcon(int r100, String r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r102 = SpacekitSdkWrapper.b.f427892a;
        DocType r103 = DocType.forNumber(r100);
        r102.getClass();
        return DocModuleInner.a(r103, DocType.UNKNOWN_DOC_TYPE, r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getDocInlineIcon(DocType r100, int r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        return SpacekitSdkWrapper.d(r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public String getDocUrlWithFromQuery(String r100, String r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        HashMap r102 = new HashMap();
        r102.put("from", r101);
        if (r102.isEmpty() == false) goto L6;
        return r100;
    L6:
        return av5.c.b(r100, r102, true);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public String getDocUrlWithId(String r100, String r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        return SpacekitSdkWrapper.e(r100, r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public String getDocUrlWithParams(String r100, Map<String, String> r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        return av5.c.b(r100, r101, false);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public String getDocUrlWithQuerys(String r100, Map<String, String> r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (r101.isEmpty() == false) goto L8;
        return r100;
    L8:
        return av5.c.b(r100, r101, true);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public String getDocumentDefaultName(Context r100, int r101) {
        return qa5.b.a.f532259a.f532258a.b().getDocumentDefaultName(r100, r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public d5b.a getGroupCollaborationPlusPlugin(Context r100, Chat r101) {
        return new com.ss.android.lark.integrator.ccm.im.a(r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public d5b.a getSendKBPlugin(Context r100, Chat r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r102 = SpacekitSdkWrapper.b.f427892a;
        r102.getClass();
        if (r101.isCrossTenant() == false) goto L6;
        return null;
    L6:
        return new xb5.d(r100, r101, null, new com.ss.android.lark.integrator.ccm.spacekit.g(r102));
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getWikiIcon(int r100, String r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r102 = SpacekitSdkWrapper.b.f427892a;
        DocType r103 = DocType.forNumber(r100);
        r102.getClass();
        return DocModuleInner.b(r103, r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getWikiSearchIcon(int r100, String r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r102 = SpacekitSdkWrapper.b.f427892a;
        DocType r103 = DocType.forNumber(r100);
        r102.getClass();
        if (r103 != null) goto L6;
        return R.drawable.ud_icon_wiki_unknow_circle_colorful;
    L6:
        switch(DocModuleInner.a.f227455a[r103.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L7:
        int r104 = -1;
    L16:
        String r105 = va5.a.a(r101);
        if (r104 != sbb.e.f541301l.f541317b) goto L20;
        return ua5.a.h(com.bytedance.ee.util.io.a.c(r105));
    L20:
        return ua5.a.i(r104);
    L8:
        r104 = 22;
        goto L16
    L9:
        r104 = 44;
        goto L16
    L10:
        r104 = 30;
        goto L16
    L11:
        r104 = 12;
        goto L16
    L12:
        r104 = 11;
        goto L16
    L13:
        r104 = 8;
        goto L16
    L14:
        r104 = 3;
        goto L16
    L15:
        r104 = 2;
        goto L16
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void loadDocThumbnail(ImageView r100, i0b.a r101) {
        WeakReference r102 = new WeakReference(r100);
        ec5.a.C5766a r103 = new ec5.a.C5766a();
        r103.f472105a = r100.getContext();
        r103.f472106b = r101.f487910a;
        r103.f472109e = (ImageView) r102.get();
        r103.f472107c = r101.f487911b;
        r103.f472115k = r101.f487916g;
        r103.f472108d = new a(r102);
        r103.f472114j = "chat";
        r103.f472113i = r101.f487912c;
        r103.f472110f = r101.f487913d;
        r103.f472111g = r101.f487914e;
        r103.f472112h = r101.f487915f;
        cmb.f.a().getClass();
        SpacekitSdkWrapper r104 = SpacekitSdkWrapper.b.f427892a;
        ec5.a r105 = new ec5.a(r103);
        r104.getClass();
        Log.i("SpacekitSdkWrapper", "DocsImpl.loadThumbnail ");
        RxScheduledExecutor.justInIO(new com.ss.android.lark.integrator.ccm.spacekit.e(r105));
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void onConfigurationChanged(String r100, Configuration r101) {
        cmb.f.a().getClass();
        com.ss.android.lark.integrator.ccm.spacekit.a r102 = com.ss.android.lark.integrator.ccm.spacekit.a.f427893b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "newConfig");
        ExtensionActivityImpl r103 = (ExtensionActivityImpl) ((ConcurrentHashMap) r102.f427894a).get(r100);
        if (r103 == null) goto L6;
        r103.d(r101);
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean open(String r100, Map<String, String> r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        return SpacekitSdkWrapper.g(r100, r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void openFileReader(FileClickModel r100, String r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        FileClickData r102 = new FileClickData();
        r102.setFile_id(r100.getFile_id());
        r102.setDrive_file_key(r100.getDrive_file_key());
        r102.setFile_mime_type(r100.getFile_mime_type());
        r102.setFile_name(r100.getFile_name());
        r102.setFile_size(r100.getFile_size());
        r102.setMount_node_token(r100.getMount_node_token());
        r102.setMount_point(r100.getMount_point());
        r102.setDownLoadPath(r100.getDownLoadPath());
        r102.setType(r100.getType());
        String r103 = x.f206422a;
        x.a.d(r101, r102);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public DocResult parseDocResultFromPb(String r110, Entity r111) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        if (r111 == null) goto L57;
        Map<String, Entity.DocPermissionInfo> r100 = r111.message_id2doc_permission_infos;
        Map<String, Doc> r101 = r111.docs;
        Entity.DocPermissionInfo r102 = r100.get(r110);
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r102.token2doc_permissions.size() != 1) goto L55;
        com.bytedance.lark.pb.basic.v1.DocPermission r103 = r102.token2doc_permissions.values().iterator().next();
        ThumbnailDetail r104 = yb5.d.a(r111, r110, r102.url2doc_permissions);     // Catch: Exception -> L12
    L14:
        String r105 = r103.key;
        if (TextUtils.isEmpty(r105) == false) goto L17;
    L45:
        tt5.a.h("ModelParserDoc", "docResult return null");
        return null;
    L17:
        if (r101.containsKey(r105) == false) goto L45;
        List<com.bytedance.lark.pb.basic.v1.DocPermission.Permission> r106 = r103.optional_permissions;
        DocCard r107 = new DocCard();
        r107.setMessageId(r110);
        r107.setDocId(r105);
        r107.setGroupId(r103.channel_id);
        r107.setShareInfo(r103.share_text);
        r107.setShouldRender(r103.should_render.booleanValue());
        int r108 = r103.user_perm.intValue();
        com.ss.android.lark.doc.entity.DocPermission r112 = new com.ss.android.lark.doc.entity.DocPermission();
        r112.setIsSet(true);
        r112.setPermCode(r108);
        r107.setUserPermission(r112);
        int r109 = r103.receiver_perm.intValue();
        com.ss.android.lark.doc.entity.DocPermission r113 = new com.ss.android.lark.doc.entity.DocPermission();
        r113.setIsSet(true);
        r113.setPermCode(r109);
        r107.setReceiverPermission(r113);
        r107.setSenderIsExternal(r103.sender_is_external);
        r107.setShareStatus(r103.share_status.longValue());
        ArrayList r114 = new ArrayList();
        if (r106 == null) goto L27;
        int r115 = r103.selected_permission_index.intValue();
        int r116 = r106.size();
        int r117 = 0;
    L21:
        if (r117 >= r116) goto L27;
        com.ss.android.lark.doc.entity.DocPermission r118 = new com.ss.android.lark.doc.entity.DocPermission();
        com.bytedance.lark.pb.basic.v1.DocPermission.Permission r119 = (com.bytedance.lark.pb.basic.v1.DocPermission.Permission) ListProtector.get(r106, r117);
        if (r117 != r115) goto L25;
        boolean r120 = true;
    L26:
        r118.setIsSet(r120);
        r118.setPermCode(r119.code.intValue());
        r118.setPermName(r119.name);
        r114.add(r118);
        r117 = r117 + 1;
        goto L21
    L25:
        r120 = false;
    L27:
        r107.setPermissions(r114);
        String r121 = r103.extra;
        tt5.a.h("ModelParserDoc", "extra = " + r121);
        if (r121 != null) goto L47;
    L33:
        Doc r122 = r101.get(r105);
        com.ss.android.lark.doc.entity.Doc r123 = new com.ss.android.lark.doc.entity.Doc();
        if (r122 == null) goto L43;
        r123.setName(r122.name);
        r123.setAbstract(r122.abstract_);
        r123.setOwnerName(r122.owner_name);
        r123.setUrl(r122.url);
        r123.setId(r105);
        r123.setDocType(DocType.forNumber(r122.type.getValue()));
        Long r124 = r122.owner_id;
        if (r124 == null) goto L38;
        String r125 = r124.toString();
    L39:
        r123.setOwnerId(r125);
        r123.setCreateTime(r122.create_time.longValue());
        r123.setUpdateTime(r122.update_time.longValue());
        r123.setIconKey(r122.icon_key);
        r123.setThumbnaimDetail(r104);
        Icon r126 = new Icon();
        com.bytedance.lark.pb.basic.v1.Icon r127 = r122.icon;
        if (r127 == null) goto L42;
        r126.setType(r127.type.getValue());
        r126.setValue(r122.icon.value);
    L42:
        r123.setIcon(r126);
    L56:
        return new DocResult(r123, r107);
    L38:
        r125 = "";
        goto L39
    L43:
        tt5.a.d("ModelParserDoc", "docsMap.get(docId) pbDoc is null");
        goto L56
    L47:
        r107.setExtra((Extra) JSON.parseObject(r121, Extra.class));     // Catch: Exception -> L31
    L31:
        e = move-exception;
        tt5.a.e("ModelParserDoc", "JSON.parseObject(extraStr,Extra.class) fail", e, false);
    L12:
        e = move-exception;
        tt5.a.f("ModelParserDoc", e, false);
        r104 = null;
        goto L14
    L55:
        return null;
    L57:
        return null;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void preloadDocFromChat(List<String> r100, int r101) {
        if (((PreloadDocConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.d("preload_doc_chat_types", new PreloadDocConfig())).supportTypes.contains(Integer.valueOf(r101)) == false) goto L6;
        preloadDoc(r100);
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void preloadDocSdk(Context r100, int r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r102 = SpacekitSdkWrapper.b.f427892a;
        if (r102 == null) goto L6;
        LarkContext.getApplication();
        r102.i(r101);
        return;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void pullDocFeed(String r100, IGetDataCallback<DocFeed> r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.j(r100, r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void saveToNutStore(String r100, pw4.e r101) {
        int r102 = com.ss.android.lark.integrator.ccm.a.f427786a;
        l0 r103 = new l0();
        Object r104 = ((ConcurrentHashMap) r103.f444740a).get(zbb.a.class);
        if (r104 != null) goto L12;
        monitor-enter(r103);
        if (r104 == null) goto L14;
    L7:
        monitor-exit(r103);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L14:
        r104 = new acb.f();     // Catch: Throwable -> L9
        ((ConcurrentHashMap) r103.f444740a).put(zbb.a.class, r104);     // Catch: Throwable -> L9
    L12:
        ((zbb.a) r104).c();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean startDriveSDKActivity(Context r100, qb5.a r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        Log.i("SpacekitSdkWrapper", "params invalid");
        return false;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void syncThumbnail(final String r100, final IGetDataCallback<String> r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        Log.i("SpacekitSdkWrapper", "DocsImpl.syncThumbnail ");
        RxScheduledExecutor.justInIO(new com.ss.android.lark.integrator.ccm.spacekit.d(r100, r101));
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void updateLeaderShareSetting(boolean r100, IGetDataCallback<Boolean> r101) {
        SpacekitSdkWrapper.b.f427892a.c();
        qa5.b.a.f532259a.f532258a.providePermissionProvider().updateLeaderShareSetting(r100, r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getDocIcon(DocType r100, String r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        return DocModuleInner.a(r100, DocType.UNKNOWN_DOC_TYPE, r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public int getWikiIcon(DocType r100, String r101) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        return DocModuleInner.b(r100, r101);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean open(Context r100, i0b.b r101) {
        cmb.f.a().getClass();
        if (SpacekitSdkWrapper.b.f427892a != null) goto L7;
        return false;
    L7:
        throw null;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void createDocFeed(String r100, DocType r101, IGetDataCallback<ibb.a> r102) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        CreateDocFeedRequest.Builder r103 = new CreateDocFeedRequest.Builder();
        if (r101 != null) goto L5;
        Doc.Type r104 = Doc.Type.DOC;
    L6:
        CreateDocFeedRequest.Builder r105 = r103.type(r104).key(r100);
        SdkSender.asynSendRequestNonWrap(Command.CREATE_DOC_FEED, r105, r102, new p());
        return;
    L5:
        r104 = Doc.Type.fromValue(r101.getNumber());
        goto L6
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void doDocPermAuthBeforeChatP2pToGroup(Activity r100, Map<String, Map<String, DocResult>> r101, ICCMApi.b r102) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r103 = SpacekitSdkWrapper.b.f427892a;
        c r104 = new c();
        r103.getClass();
        com.bytedance.ee.bear.lark.selector.auth.b.a(r100, r101, r104);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public String getCCMInnerFilePath(Context r100, Biz r101, String r102) {
        int r103 = ay4.c.f16749a;
        return ay4.c.a.f(r101, r102, false, false, 12).getRealPath();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void getQuickLaunchBarItemForWebContainer(String r100, Context r101, i0b.c r102) {
        SpacekitSdkWrapper.b.f427892a.c();
        NetService r103 = (NetService) org.koin.java.a.a(NetService.class);
        cmb.f.a().getClass();
        pn4.e r104 = qa5.b.a.f532259a.f532258a.b();
        com.bytedance.ee.bear.basesdk.apisupport.f r105 = (com.bytedance.ee.bear.basesdk.apisupport.f) r104;
        r105.k(r103, r101, r100, new cmb.a(r103, r100, r101));
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public d5b.a getSendKBPlugin(Context r100, Chat r101, Object r102) {
        if ((r102 instanceof com.ss.android.lark.keyboard.b) == false) goto L5;
        com.ss.android.lark.keyboard.b r103 = (com.ss.android.lark.keyboard.b) r102;
    L6:
        cmb.f.a().getClass();
        SpacekitSdkWrapper r104 = SpacekitSdkWrapper.b.f427892a;
        r104.getClass();
        if (r101.isCrossTenant() == false) goto L10;
        return null;
    L10:
        return new xb5.d(r100, r101, r103, new com.ss.android.lark.integrator.ccm.spacekit.g(r104));
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean open(String r100, String r101, Map<String, String> r102) {
        cmb.f.a().getClass();
        if (SpacekitSdkWrapper.b.f427892a != null) goto L5;
        return false;
    L5:
        return SpacekitSdkWrapper.g(SpacekitSdkWrapper.e(r100, r101), r102);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void openAINotes(Context r100, String r101, Fragment r102) {
        checkAndInit();
        RouteBean r103 = new RouteBean();
        r103.f236647l = "/list/space/activity";
        if (r102 != null) goto L5;
    L7:
        ((h) org.koin.java.a.a(h.class)).yd("/list/space/activity", r103).j("extra_destination", NavigationEnum.AI_NOTE.f228307id).i("extra_from", r101).e();
        return;
    L5:
        if (ku5.c.k(r100) == false) goto L7;
        r103.f236652q = RouteBean.DestStyle.FULL_SCREEN;
        r103.f236636a = R.anim.facade_hold;
        r103.f236637b = R.anim.facade_hold;
        r103.a(r102);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [cmb.b] */
    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void showAdjustExternalPanel(Activity r100, String r101, ICCMApi.a r102) {
        SpacekitSdkWrapper.b.f427892a.c();
        ?? r103 = new cmb.b();
        ((s) qa5.b.a.f532259a.f532258a.providePermissionProvider()).b(r100, r101, r103);
    }

    private static Unit lambda$getQuickLaunchBarItemForWebContainer$1(NetService r100, String r101, Context r102, e05.c r103) {
        cmb.f.a().getClass();
        qa5.b.a.f532259a.f532258a.b().d(r100, r101, r102, r103);
        return null;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void createDocByTemplate(String r100, String r101, String r102, IGetDataCallback<String> r103) {
        f r104 = new f(r103);
        cmb.f.a().getClass();
        ((com.bytedance.ee.bear.basesdk.apisupport.f) qa5.b.a.f532259a.f532258a.b()).b(r100, r101, r102, r104);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void doDocPermAuthBeforeChatP2pToGroupNew(Activity r100, List<DocResult> r101, Map<String, Map<String, DocResult>> r102, ICCMApi.b r103) {
        DocAuthSelectorDialog r104 = new DocAuthSelectorDialog();
        r104.f227486e = r101;
        r104.f227485d = new d(r102);
        r104.S90((FragmentActivity) r100);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public Map<String, String> getDocArgsMessage(boolean r100, boolean r101, boolean r102, String r103) {
        HashMap r104 = new HashMap();
        if (r100 == false) goto L5;
        String r105 = "meeting";
    L6:
        j0b.a.a(r104, "from", "message");
        j0b.a.a(r104, "chat_type", r105);
        if (r102 == false) goto L9;
        String r106 = GXViewKey.VIEW_TYPE_RICH_TEXT;
    L10:
        j0b.a.a(r104, "message_type", r106);
        j0b.a.a(r104, "botId", r103);
        return r104;
    L9:
        r106 = "text";
        goto L10
    L5:
        r105 = "single";
        goto L6
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean open(Context r100, String r101, String r102, Map<String, String> r110) {
        return open(r100, r101, r102, r110, null);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void saveToSpaceStore(pw4.e r100, String r101, String r102, String r103) {
        int r104 = com.ss.android.lark.integrator.ccm.a.f427786a;
        l0 r105 = new l0();
        Object r106 = ((ConcurrentHashMap) r105.f444740a).get(zbb.a.class);
        if (r106 != null) goto L12;
        monitor-enter(r105);
        if (r106 == null) goto L14;
    L7:
        monitor-exit(r105);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L14:
        r106 = new acb.f();     // Catch: Throwable -> L9
        ((ConcurrentHashMap) r105.f444740a).put(zbb.a.class, r106);     // Catch: Throwable -> L9
    L12:
        ((zbb.a) r106).a();
    }

    private static void lambda$getQuickLaunchBarItemForWebContainer$2(i0b.c r100, NetService r101, String r102, Context r103, e05.c r104) {
        int r105 = cmb.d.f24249a;
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r104 == null) goto L17;
        new j2c.a.b();
        j2c.a.d.C6388a r106 = new j2c.a.d.C6388a();
        r106.f497063a = kac.a.b(R.drawable.ud_icon_file_link_word_outlined);
        r106.f497064b = Integer.valueOf(UIUtils.getColor(r103, R.color.icon_n2));
        QuickLaunchBarItemType r107 = r104.getType();
        int r108 = cmb.d.a.C0461a.f24250a[r107.ordinal()];
        if (r108 == 1) goto L14;
        if (r108 == 2) goto L14;
        if (r108 != 3) goto L12;
        j2c.a.c.C6387a r109 = new j2c.a.c.C6387a();
        cmb.e r110 = new cmb.e();
        r109.f497060d = r110;
        Intrinsics.checkNotNullParameter(new j2c.a.e.C6389a(new j2c.a.c(r109.f497057a, r109.f497058b, r109.f497059c, r110)), "value");
        goto L14
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        if (r104.f470640c == false) goto L16;
        j2c.a.AbstractC6385a.C6386a r111 = j2c.a.AbstractC6385a.C6386a.f497052a;
    L16:
        Intrinsics.checkNotNullParameter(new j2c.a.d(r106.f497063a, r106.f497064b), "value");
    L17:
        r100.a();
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void goDocsSelector(Context r100, int r101, String r102, int r103, String r104) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        Bundle r105 = new Bundle();
        r105.putString("extra_title", r102);
        r105.putInt("extra_max_num", r103);
        r105.putString("extra_confirm_text", r104);
        com.bytedance.ee.bear.lark.selector.a.a((Activity) r100, r101, r105);
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean open(Context r100, String r101, String r110, Map<String, String> r111, Fragment r112) {
        return open(r100, r101, r110, r111, r112, "");
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean open(Context r100, String r101, String r102, Map<String, String> r110, Fragment r111, String r112) {
        cmb.f.a().getClass();
        if (SpacekitSdkWrapper.b.f427892a == null) goto L7;
        String r103 = SpacekitSdkWrapper.e(r101, r102);
        if (SpacekitSdkWrapper.b(r103) == false) goto L7;
        String r104 = SpacekitSdkWrapper.a(r103);
        return ((com.bytedance.ee.bear.basesdk.apisupport.f) qa5.b.a.f532259a.f532258a.b()).i(r100, r104, r110, r111, r112);
    L7:
        return false;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public boolean open(Context r110, String r111, int r112, int r113, Map<String, String> r114, String r115) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        if (SpacekitSdkWrapper.b(r111) == false) goto L5;
        String r100 = SpacekitSdkWrapper.a(r111);
        return ((com.bytedance.ee.bear.basesdk.apisupport.f) qa5.b.a.f532259a.f532258a.b()).e(r110, r100, r112, r113, r114, null, r115);
    L5:
        return false;
    }

    @Override // com.ss.android.lark.ccm_api.ICCMApi
    public void goDocsSelector(Activity r100, Fragment r101, int r102, String r103, String r104, String r105, boolean r106) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.getClass();
        Bundle r107 = new Bundle();
        if (r103 == null) goto L5;
        r107.putString("chat_id", r103);
    L5:
        r107.putString("extra_title", r104);
        r107.putString("extra_confirm_text", r105);
        r107.putBoolean("extra_disable_new_doc", r106);
        if (r101 == null) goto L8;
        Intent r108 = new Intent(r100, DocSelectorActivity.class);
        r108.putExtras(r107);
        r101.startActivityForResult(r108, r102);
        return;
    L8:
        com.bytedance.ee.bear.lark.selector.a.a(r100, r102, r107);
    }
}
