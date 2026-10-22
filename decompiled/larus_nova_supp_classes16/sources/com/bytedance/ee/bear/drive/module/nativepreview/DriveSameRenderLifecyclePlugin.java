package com.bytedance.ee.bear.drive.module.nativepreview;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.drive.core.fragment.DrivePreviewFragment;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import com.bytedance.ee.bear.drive.module.nativepreview.model.FileBlockResModel;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.webview_api.platform.PlatformPluginVersion;
import j85.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import pw4.g;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveSameRenderLifecyclePlugin extends DocumentPlugin {
    private static final String ENABLE_UNREGISTER_NATIVE_RENDER_FROM_RESUME = "ccm.mobile.unregister_native_render_from_resume";
    private static final String SEND_ATTCHMENT_INFO = "javascript:lark.biz.util.notifyAttachFileOpen";
    public static final String TAG = "CCMFollow_DriveSameRenderLifecyclePlugin";
    private static final String TOGGLE_EVENT_HANDLED = "javascript:lark.biz.event.native.toggleHandled";
    private static final String TOGGLE_RENDER_HANDLED = "biz.file.toggleRenderAll";
    private static final String VC_MEETING_ID = "vc_meeting_id";
    private f followWrapper;
    private final LifecycleObserver hostLifecycleObserver;
    private boolean isRegisterNativeRenderOnResume;
    private com.bytedance.ee.bear.drive.biz.docplugin.c mAttachmentFollowManager;
    private boolean mNativeRenderRegistered;
    private l85.b mRenderPlatform;
    private String mWebViewHashCode;
    private final View.OnAttachStateChangeListener webViewLifecycleObserver;

    public static class FileBlockRender implements NonProguard {

        @JSONField(name = "render")
        private Boolean render;

        public FileBlockRender() {
        }

        public String toString() {
            return "FileBlockRender{ render=" + this.render + "}";
        }

        public Boolean getRender() {
            return this.render;
        }

        public static /* synthetic */ Boolean access$1700(FileBlockRender r0) {
            return r0.render;
        }

        public void setRender(Boolean r1) {
            this.render = r1;
        }
    }

    public class a implements LifecycleObserver {
        public final /* synthetic */ DriveSameRenderLifecyclePlugin a;

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public void onCreate() {
            n85.b r0 = n85.b.a.a;
            int r1 = r0.h;
            tt5.a.h(DriveSameRenderLifecyclePlugin.TAG, "onActivityCreated count=" + r1);
            if (r1 != 0) goto L5;
            DriveSameRenderLifecyclePlugin.access$000(this.a);
        L5:
            r0.h = r1 + 1;
            tt5.a.b(DriveSameRenderLifecyclePlugin.TAG, "onActivityCreated finished");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            n85.b r0 = n85.b.a.a;
            int r1 = r0.h;
            tt5.a.h(DriveSameRenderLifecyclePlugin.TAG, "onActivityDestroyed pluginCount=" + r1);
            boolean r2 = true;
            if (r1 != 1) goto L5;
            DriveSameRenderLifecyclePlugin.access$100(this.a);
            DriveSameRenderLifecyclePlugin.access$200(this.a);
        L6:
            tt5.a.h(DriveSameRenderLifecyclePlugin.TAG, "onActivityDestroyed: isRegisterNativeRenderOnResume:" + DriveSameRenderLifecyclePlugin.access$300(this.a) + " hasUnRegisterNativeRender:" + r2);
            if (DriveSameRenderLifecyclePlugin.access$400(this.a) == true) goto L9;
        L12:
            r0.h = r1 - 1;
            return;
        L9:
            if (DriveSameRenderLifecyclePlugin.access$300(this.a) == false) goto L12;
            if (r2 == true) goto L12;
            DriveSameRenderLifecyclePlugin.access$200(this.a);
            goto L12
        L5:
            r2 = false;
            goto L6
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void onResume() {
            tt5.a.h(DriveSameRenderLifecyclePlugin.TAG, "onActivityResumed");
            String r0 = n85.b.a.a.c;
            if (TextUtils.isEmpty(r0) == false) goto L5;
            return;
        L5:
            if (r0.equals(DriveSameRenderLifecyclePlugin.access$500(this.a)) == true) goto L9;
            tt5.a.h(DriveSameRenderLifecyclePlugin.TAG, "onResume registerNativeRender");
            DriveSameRenderLifecyclePlugin.access$000(this.a);
            DriveSameRenderLifecyclePlugin.access$302(this.a, true);
            return;
        }

        public a(DriveSameRenderLifecyclePlugin r1) {
            this.a = r1;
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ DriveSameRenderLifecyclePlugin a;

        public b(DriveSameRenderLifecyclePlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r7) {
            if ((r7 instanceof WebView) == true) goto L5;
            return;
        L5:
            if (DriveSameRenderLifecyclePlugin.access$600(this.a) == true) goto L13;
            n85.b r0 = n85.b.a.a;
            int r1 = r0.h;
            tt5.a.h(DriveSameRenderLifecyclePlugin.TAG, "webViewLifecycleObserver - onViewAttachedToWindow, plugin: " + this.a + ", webView: " + r7.hashCode() + ", pluginCount: " + r1 + ", topTaskKey: " + r0.c + ", selfTaskKey: " + DriveSameRenderLifecyclePlugin.access$500(this.a));
            if (DriveSameRenderLifecyclePlugin.access$700(this.a, (WebView) r7) == false) goto L12;
            DriveSameRenderLifecyclePlugin.access$602(this.a, true);
            r0.h = r1 + 1;
            return;
        L12:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r5) {
            if ((r5 instanceof WebView) == true) goto L5;
            return;
        L5:
            if (DriveSameRenderLifecyclePlugin.access$600(this.a) == false) goto L19;
            n85.b r0 = n85.b.a.a;
            int r1 = r0.h;
            tt5.a.h(DriveSameRenderLifecyclePlugin.TAG, "webViewLifecycleObserver - onViewDetachedFromWindow, plugin: " + this.a + ", webView: " + r5.hashCode() + ", pluginCount: " + r1);
            if (r1 != 1) goto L11;
            DriveSameRenderLifecyclePlugin.access$100(this.a);
        L11:
            if (DriveSameRenderLifecyclePlugin.access$800(this.a, (WebView) r5) == false) goto L17;
            DriveSameRenderLifecyclePlugin.access$602(this.a, false);
            if (r1 <= 0) goto L18;
            r0.h = r1 - 1;
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public class c extends com.bytedance.ee.bear.drive.biz.docplugin.d {
        public final /* synthetic */ DriveSameRenderLifecyclePlugin a;

        public c(DriveSameRenderLifecyclePlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.docplugin.d
        public final void b(com.bytedance.ee.bear.drive.biz.docplugin.d.a r3) {
            tt5.a.h(DriveSameRenderLifecyclePlugin.TAG, "fileBlock onCallback, native return data . result=" + r3.toString());
            if (r3.a != 100) goto L6;
            this.a.exitAttachFileFragmentIfNeed();
            return;
        }
    }

    public class d implements f {
        public final /* synthetic */ DriveSameRenderLifecyclePlugin a;

        @Override // j85.f
        public final com.bytedance.ee.bear.drive.module.nativepreview.b b() {
            return new com.bytedance.ee.bear.drive.module.nativepreview.b(this);
        }

        public d(DriveSameRenderLifecyclePlugin r1) {
            this.a = r1;
        }

        @Override // j85.f
        public final UserContainerDriveMainFragment a(SpaceThirdPartyOpenEntity r5) {
            com.bytedance.ee.bear.drive.biz.docplugin.c r0 = DriveSameRenderLifecyclePlugin.access$1200(this.a);
            DriveSameRenderLifecyclePlugin r1 = this.a;
            String r2 = DriveSameRenderLifecyclePlugin.access$1100(r1, DriveSameRenderLifecyclePlugin.access$1000(r1));
            com.bytedance.ee.bear.drive.module.nativepreview.a r3 = new com.bytedance.ee.bear.drive.module.nativepreview.a(this);
            r0.getClass();
            ArrayList r4 = new ArrayList();
            r4.add(r5);
            return r0.b(r4, 0, r2, r3);
        }
    }

    public class e implements i<FileBlockRender> {
        public final /* synthetic */ DriveSameRenderLifecyclePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(DriveSameRenderLifecyclePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r6, m r7) {
            FileBlockRender r8 = (FileBlockRender) r6;
            tt5.a.h(DriveSameRenderLifecyclePlugin.TAG, "DriveFileBlockRenderHandler handle: data= " + r8);
            WebView r9 = DriveSameRenderLifecyclePlugin.access$1500(this.a).getWebView();
            if (DriveSameRenderLifecyclePlugin.access$1600(this.a) == null) goto L39;
            if (r8 == null) goto L39;
            if (FileBlockRender.access$1700(r8) == null) goto L39;
            if (r9 == null) goto L39;
            if (DriveSameRenderLifecyclePlugin.access$1600(this.a).b == false) goto L53;
            n85.b r0 = n85.b.a.a;
            String r10 = Integer.toString(r9.hashCode());
            if (Boolean.FALSE.equals(r8.getRender()) == false) goto L14;
            int r11 = 8;
        L15:
            r0.getClass();
            tt5.a.h("FileBlockResPoll", "handleSingleWebViewComponentVisibility: webViewHashCode=" + r10 + ", visibility=" + r11);
            CopyOnWriteArraySet r12 = (CopyOnWriteArraySet) ((ConcurrentHashMap) r0.k).get(r10);
            if (r12 != null) goto L18;
        L38:
            tt5.a.k("FileBlockResPoll", "handleSingleWebViewComponentVisibility collection is empty");
            return;
        L18:
            if (r12.isEmpty() == true) goto L38;
            Iterator r13 = r12.iterator();
        L22:
            if (r13.hasNext() == false) goto L55;
            String r1 = (String) r13.next();
            Iterator<FileBlockResModel> r2 = r0.a.values().iterator();
        L25:
            if (r2.hasNext() == false) goto L22;
            FileBlockResModel r3 = r2.next();
            if (r3 == null) goto L25;
            FileBlockResModel.NativeViewHolder r4 = r3.getNativeViewHolder();
            if (r4 == null) goto L25;
            if (TextUtils.equals(r1, r4.getComponentHashCode()) == false) goto L25;
            View r5 = r4.getContainerView().get();
            if (r5 == null) goto L25;
            r5.setVisibility(r11);
            goto L25
        L55:
            return;
        L14:
            r11 = 0;
            goto L15
        L53:
            return;
        L39:
            tt5.a.d(DriveSameRenderLifecyclePlugin.TAG, "DriveFileBlockRenderHandler handle: mRenderPlatform=" + DriveSameRenderLifecyclePlugin.access$1600(this.a) + ", webView=" + r9);
        }
    }

    public boolean isVc() {
        if (getDocViewModel().getOpenSource() != DocsOpenSource.vc) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        tt5.a.d(TAG, "isVc error" + e);
        return false;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private boolean enableUnRegisterNativeRenderFromResume() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g(ENABLE_UNREGISTER_NATIVE_RENDER_FROM_RESUME);
        tt5.a.h(TAG, "isUnRegisterNativeRenderFromResume enable:" + r0);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean exitAttachFileFragmentIfNeed() {
        Pair<Boolean, List<SpaceThirdPartyOpenEntity>> r0 = this.mAttachmentFollowManager.a();
        if (((Boolean) r0.first).booleanValue() == false) goto L12;
        if (((dn4.a) ((DocumentPluginHost) getHost()).getUserComponent().a(dn4.a.class)).a().isCurrentEnable("ccm.drive.mobile.enable_thirdparty_exit_info") == false) goto L10;
        List r1 = (List) r0.second;
        int r2 = 0;
    L8:
        if (r2 >= r1.size()) goto L12;
        ((g) getHostAbility(g.class)).closeAttachFile((SpaceThirdPartyOpenEntity) ListProtector.get(r1, r2));
        r2 = r2 + 1;
        goto L8
    L10:
        ((g) getHostAbility(g.class)).closeAttachFile(null);
    L12:
        return ((Boolean) r0.first).booleanValue();
    }

    public DriveSameRenderLifecyclePlugin() {
        this.isRegisterNativeRenderOnResume = false;
        this.mNativeRenderRegistered = false;
        this.hostLifecycleObserver = new a(this);
        this.webViewLifecycleObserver = new b(this);
        this.followWrapper = new d(this);
    }

    private void clearNativeRenderRes() {
        WebView r0 = getWeb().getWebView();
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        if (getActivity() != null) goto L10;
        tt5.a.k(TAG, "clearNativeRenderRes skipped because activity is null, webView=" + r1);
        return;
    L10:
        n85.b r2 = n85.b.a.a;
        String r3 = getActivity().toString();
        r2.getClass();
        if (TextUtils.isEmpty(r3) == false) goto L13;
    L15:
        tt5.a.b("FileBlockResPoll", "clearAllRes() ");
        Iterator<Map.Entry<String, FileBlockResModel>> r4 = r2.a.entrySet().iterator();
    L17:
        if (r4.hasNext() == false) goto L35;
        Map.Entry<String, FileBlockResModel> r5 = r4.next();
        if (r5 == null) goto L17;
        FileBlockResModel r6 = r5.getValue();
        if (r6 == null) goto L17;
        if (r6.getNativeViewHolder() == null) goto L17;
        FileBlockResModel.NativeViewHolder r7 = r6.getNativeViewHolder();
        r7.release();
        if (r7.getContainerView() == null) goto L17;
        if (r7.getContainerView().get() == null) goto L17;
        ViewGroup r8 = (ViewGroup) r7.getContainerView().get();
        if (r8 == null) goto L17;
        if (r8.getParent() == null) goto L17;
        ((ViewGroup) r8.getParent()).removeView(r8);
        goto L17
    L35:
        r2.b.clear();
        r2.d = null;
        r2.f = null;
        r2.a.clear();
        ((ConcurrentHashMap) r2.j).clear();
    L36:
        tt5.a.h(TAG, "clearNativeRenderRes done, webView: " + r1);
        return;
    L13:
        if (r3.equals(r2.d) == true) goto L15;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    private String getTopTaskKey() {
        if (getActivity() != null) goto L5;
    L11:
        tt5.a.h(TAG, "getTopTaskKey() error, use uptimeMillis");
        return String.valueOf(SystemClock.uptimeMillis());
    L5:
        if (getWeb() == null) goto L11;
        if (getWeb().getWebView() == null) goto L11;
        String r0 = getActivity().toString() + OfflineDoc.DASH_DELIMITER + getWeb().getWebView().hashCode();
        tt5.a.h(TAG, "getTopTaskKey() key=" + r0);
        return r0;
    }

    private void registerNativeRender() {
        registerNativeRender(getWeb().getWebView());
    }

    private void unRegisterNativeRender() {
        unRegisterNativeRender(getWeb().getWebView());
    }

    public static /* synthetic */ void access$000(DriveSameRenderLifecyclePlugin r0) {
        r0.registerNativeRender();
    }

    public static /* synthetic */ void access$100(DriveSameRenderLifecyclePlugin r0) {
        r0.clearNativeRenderRes();
    }

    public static /* synthetic */ String access$1000(DriveSameRenderLifecyclePlugin r0) {
        return r0.getUrl();
    }

    public static /* synthetic */ com.bytedance.ee.bear.drive.biz.docplugin.c access$1200(DriveSameRenderLifecyclePlugin r0) {
        return r0.mAttachmentFollowManager;
    }

    public static /* synthetic */ k access$1500(DriveSameRenderLifecyclePlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ l85.b access$1600(DriveSameRenderLifecyclePlugin r0) {
        return r0.mRenderPlatform;
    }

    public static /* synthetic */ void access$200(DriveSameRenderLifecyclePlugin r0) {
        r0.unRegisterNativeRender();
    }

    public static /* synthetic */ boolean access$300(DriveSameRenderLifecyclePlugin r0) {
        return r0.isRegisterNativeRenderOnResume;
    }

    public static /* synthetic */ boolean access$400(DriveSameRenderLifecyclePlugin r0) {
        return r0.enableUnRegisterNativeRenderFromResume();
    }

    public static /* synthetic */ String access$500(DriveSameRenderLifecyclePlugin r0) {
        return r0.getTopTaskKey();
    }

    public static /* synthetic */ boolean access$600(DriveSameRenderLifecyclePlugin r0) {
        return r0.mNativeRenderRegistered;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private pxb.a asCommonWebView(WebView r2) {
        if ((r2 instanceof OfficeWebView) == false) goto L7;
        return com.ss.android.lark.officewebview.webview_api.adapter.d.a((OfficeWebView) r2);
    L7:
        if ((r2 instanceof DocBridgeWebViewV2) == true) goto L9;
        return null;
    L9:
        return com.bytedance.ee.larkwebview.webview_api.adapter.d.a((DocBridgeWebViewV2) r2);
    }

    private String encryptedMeetingId(String r3) {
        tt5.a.h(TAG, "encryptedMeetingId: " + du5.b.g(r3));
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return "";
    L5:
        String r4 = UriProtector.getQueryParameter(UriProtector.parse(r3), VC_MEETING_ID);
        if (r4 != null) goto L9;
        return "";
    L9:
        return du5.b.e(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void notifyOpenAttachFileToWeb(SpaceThirdPartyOpenEntity r4) {
        tt5.a.h(TAG, "notifyOpenAttachFileToWeb");
        JSONObject r0 = new JSONObject();
        r0.put("file_token", r4.getFileId());
        r0.put(DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN, r4.getMountNodeToken());
        r0.put(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r4.getMountPoint());
        r0.put("extra", r4.getExtras());
        r0.put("bussinessId", "docx");
        ap5.a.a(((DocumentPluginHost) getHost()).getWeb().getWebView(), SEND_ATTCHMENT_INFO, r0, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void notifyToggleEventToWeb(boolean r4) {
        if (this.mRenderPlatform.b == true) goto L5;
        return;
    L5:
        tt5.a.h(TAG, "notifyToggleEventToWeb: " + r4);
        JSONObject r0 = new JSONObject();
        r0.put("handled", Boolean.valueOf(r4));
        ap5.a.a(((DocumentPluginHost) getHost()).getWeb().getWebView(), TOGGLE_EVENT_HANDLED, r0, null);
    }

    private l85.b platform(WebView r6) {
        if (this.mRenderPlatform != null) goto L24;
        pxb.a r7 = asCommonWebView(r6);
        if (r7 != null) goto L8;
        return null;
    L8:
        int r0 = l85.b.c;
        Intrinsics.checkNotNullParameter(r7, "webView");
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.drive.embed_enable");
        txb.b r8 = r7.getServiceManager();
        boolean r2 = false;
        if (r8 != null) goto L11;
        tt5.a.h("DriveRenderPlatformInitializer", "isWebViewSupportEmbed embedEnable= false, getServiceManager is null");
    L14:
        boolean r9 = false;
    L16:
        if (r1 == false) goto L19;
        if (r9 == false) goto L19;
        r2 = true;
    L19:
        if (r2 == false) goto L21;
        l85.d r3 = new l85.a();
    L22:
        l85.b r4 = new l85.b(r3);
        r4.b = r2;
        tt5.a.h("DriveRenderPlatformInitializer", "Initializer(" + r4.hashCode() + ") init called, embedEnable=" + r1 + ", isWebViewSupportEmbed=" + r9);
        this.mRenderPlatform = r4;
        goto L24
    L21:
        r3 = new l85.c();
        goto L22
    L11:
        txb.a r10 = r8.getService(txb.a.class);
        if (r10 != null) goto L15;
        tt5.a.h("DriveRenderPlatformInitializer", "isWebViewSupportEmbed embedEnable= false, getService is null");
        goto L14
    L15:
        Boolean r11 = (Boolean) r10.x().get(PlatformPluginVersion.EMBED);
        tt5.a.h("DriveRenderPlatformInitializer", "isWebViewSupportEmbed embedEnable=" + r11);
        r9 = Intrinsics.areEqual(Boolean.TRUE, r11);
    L24:
        return this.mRenderPlatform;
    }

    private boolean registerNativeRender(WebView r5) {
        pxb.a r0 = asCommonWebView(r5);
        l85.b r1 = platform(r5);
        if (r0 == null) goto L10;
        if (r1 == null) goto L10;
        if (getActivity() == null) goto L10;
        r1.b(getActivity(), r0);
        n85.b.a.a.c = getTopTaskKey();
        tt5.a.h(TAG, "registerNativeRender done, webView=" + r5.hashCode() + " activity:" + getActivity());
        return true;
    L10:
        tt5.a.k(TAG, "registerNativeRender skipped, webView=" + r5 + ", renderPlatform=" + r1 + ", activity=" + getActivity());
        return false;
    }

    private boolean unRegisterNativeRender(WebView r5) {
        pxb.a r0 = asCommonWebView(r5);
        if (r0 != null) goto L5;
    L11:
        tt5.a.k(TAG, "unRegisterNativeRender skipped, webView=" + r5 + ", renderPlatform=" + this.mRenderPlatform + ", activity=" + getActivity());
        return false;
    L5:
        if (this.mRenderPlatform == null) goto L11;
        if (getActivity() == null) goto L11;
        this.mRenderPlatform.d(getActivity(), r0);
        tt5.a.h(TAG, "unRegisterNativeRender done, webView: " + r5.hashCode() + " activity:" + getActivity());
        return true;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        super.getBridgeHandlers(r3);
        r3.put(TOGGLE_RENDER_HANDLED, new e(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(DocumentPluginHost r6) {
        super.onAttachToHost(r6);
        WebView r0 = ((DocumentPluginHost) getHost()).getWeb().getWebView();
        if (r0 == null) goto L5;
        String r1 = Integer.toString(r0.hashCode());
    L6:
        this.mWebViewHashCode = r1;
        this.mAttachmentFollowManager = new com.bytedance.ee.bear.drive.biz.docplugin.c(this, getActivity(), getLifecycleOwner(), new c(this));
        l85.b r2 = platform(r0);
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L17;
        r0.removeOnAttachStateChangeListener(this.webViewLifecycleObserver);
        r0.addOnAttachStateChangeListener(this.webViewLifecycleObserver);
        if (r0.isAttachedToWindow() == false) goto L23;
        this.webViewLifecycleObserver.onViewAttachedToWindow(r0);
    L23:
        n85.b r4 = n85.b.a.a;
        FragmentManager r7 = r6.c().getChildFragmentManager();
        r4.g.add(new WeakReference(r7));
        f r8 = this.followWrapper;
        r4.getClass();
        r4.i = new WeakReference(r8);
        return;
    L17:
        if (ForsetiHelper.p() == false) goto L22;
        if (r6 == null) goto L23;
        LifecycleOwner r5 = r6.getLifecycleOwner();
        if (r5 == null) goto L23;
        r5.getLifecycle().addObserver(this.hostLifecycleObserver);
        goto L23
    L22:
        getActivity().getLifecycle().addObserver(this.hostLifecycleObserver);
        goto L23
    L9:
        if (r2.b == false) goto L11;
        r3 = true;
        goto L12
    L5:
        r1 = "";
        goto L6
    }

    public void onDetachFromHost(DocumentPluginHost r9) {
        super.onDetachFromHost(r9);
        WebView r0 = getWeb().getWebView();
        n85.b r1 = n85.b.a.a;
        int r2 = r1.h;
        l85.b r3 = this.mRenderPlatform;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        tt5.a.h(TAG, "onActivityDestroyed pluginCount=" + r2);
        if (isVc() == false) goto L12;
        if (r4 == true) goto L12;
        clearNativeRenderRes();
        unRegisterNativeRender();
    L12:
        FragmentManager r5 = r9.c().getChildFragmentManager();
        if (r5 == null) goto L23;
        if (r1.g.size() <= 0) goto L23;
        Iterator<WeakReference<FragmentManager>> r6 = r1.g.iterator();
    L18:
        if (r6.hasNext() == false) goto L25;
        if (r5 != r6.next().get()) goto L18;
        r6.remove();
    L25:
        n85.b r7 = n85.b.a.a;
        String r8 = Integer.toString(getWeb().getWebView().hashCode());
        if (((CopyOnWriteArraySet) ((ConcurrentHashMap) r7.k).get(r8)) != null) goto L28;
    L35:
        if (r0 == null) goto L42;
        if (r4 == true) goto L38;
    L40:
        r0.removeOnAttachStateChangeListener(this.webViewLifecycleObserver);
        goto L42
    L38:
        if (this.mNativeRenderRegistered == false) goto L40;
        this.webViewLifecycleObserver.onViewDetachedFromWindow(r0);
    L42:
        if (ForsetiHelper.p() == false) goto L46;
        LifecycleOwner r10 = r9.getLifecycleOwner();
        if (r10 == null) goto L47;
        r10.getLifecycle().removeObserver(this.hostLifecycleObserver);
    L47:
        com.bytedance.ee.bear.drive.biz.docplugin.c r11 = this.mAttachmentFollowManager;
        if (r11 == null) goto L58;
        r11.d();
        return;
    L58:
        return;
    L46:
        getActivity().getLifecycle().removeObserver(this.hostLifecycleObserver);
        goto L47
    L28:
        monitor-enter(n85.b.class);
        ((ConcurrentHashMap) r7.k).remove(r8);     // Catch: Throwable -> L32
        monitor-exit(n85.b.class);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L23:
        if (r1.g.size() < 1) goto L25;
        ArrayList<WeakReference<FragmentManager>> r12 = r1.g;
        ListProtector.remove(r12, r12.size() - 1);
        goto L25
    L5:
        if (r3.b == false) goto L7;
        r4 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean openBlockFileAndFullScreen(SpaceThirdPartyOpenEntity r7) {
        Pair<Boolean, List<SpaceThirdPartyOpenEntity>> r0 = this.mAttachmentFollowManager.a();
        if (((Boolean) r0.first).booleanValue() == true) goto L5;
    L11:
        com.bytedance.ee.bear.drive.biz.docplugin.c r1 = this.mAttachmentFollowManager;
        String r2 = this.mWebViewHashCode;
        r1.getClass();
        String r8 = r2 + OfflineDoc.DASH_DELIMITER + r7.getMountNodeToken() + OfflineDoc.DASH_DELIMITER + r7.getFileId();
        tt5.a.h("CCMFollow_AttachmentFollowManager", "doBlockAttachFileFragmentOpen key=" + du5.b.g(r8));
        n85.b.a.a.getClass();
        DrivePreviewFragment r9 = n85.b.e(r8);
        if (r9 == null) goto L17;
        ((DriveBlockPreviewVM) q.c(r9.g, DriveBlockPreviewVM.class, null)).getEnterFullScreen().postValue(null);
        tt5.a.h("CCMFollow_AttachmentFollowManager", "doBlockAttachFileFragmentOpen success");
        return true;
    L17:
        return false;
    L5:
        if (((dn4.a) ((DocumentPluginHost) getHost()).getUserComponent().a(dn4.a.class)).a().isCurrentEnable("ccm.drive.mobile.enable_thirdparty_exit_info") == false) goto L10;
        List r3 = (List) r0.second;
        int r4 = 0;
    L8:
        if (r4 >= r3.size()) goto L11;
        ((g) getHostAbility(g.class)).closeAttachFile((SpaceThirdPartyOpenEntity) ListProtector.get(r3, r4));
        r4 = r4 + 1;
        goto L8
    L10:
        ((g) getHostAbility(g.class)).closeAttachFile(null);
        goto L11
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ String access$1100(DriveSameRenderLifecyclePlugin r0, String r1) {
        return r0.encryptedMeetingId(r1);
    }

    public static /* synthetic */ void access$1300(DriveSameRenderLifecyclePlugin r0, SpaceThirdPartyOpenEntity r1) {
        r0.notifyOpenAttachFileToWeb(r1);
    }

    public static /* synthetic */ void access$1400(DriveSameRenderLifecyclePlugin r0, boolean r1) {
        r0.notifyToggleEventToWeb(r1);
    }

    public static /* synthetic */ boolean access$302(DriveSameRenderLifecyclePlugin r0, boolean r1) {
        r0.isRegisterNativeRenderOnResume = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$602(DriveSameRenderLifecyclePlugin r0, boolean r1) {
        r0.mNativeRenderRegistered = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$700(DriveSameRenderLifecyclePlugin r0, WebView r1) {
        return r0.registerNativeRender(r1);
    }

    public static /* synthetic */ boolean access$800(DriveSameRenderLifecyclePlugin r0, WebView r1) {
        return r0.unRegisterNativeRender(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r5, t r6) {
        super.onAttachToUIContainer(r5, r6);
        WebView r0 = getWeb().getWebView();
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        tt5.a.h(TAG, "onAttachToUIContainer#" + hashCode() + ", webview=" + r1);
        l85.b r2 = platform(r0);
        if (r2 == null) goto L10;
        r2.a(r5, r6);
        return;
    L10:
        return;
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public void onDetachFromUIContainer(DocumentPluginHost r5, t r6) {
        super.onDetachFromUIContainer(r5, r6);
        WebView r0 = getWeb().getWebView();
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        tt5.a.h(TAG, "onDetachFromUIContainer#" + hashCode() + ", webview=" + r1);
        l85.b r2 = platform(r0);
        if (r2 == null) goto L10;
        r2.c(r5, r6);
        return;
    L10:
        return;
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
