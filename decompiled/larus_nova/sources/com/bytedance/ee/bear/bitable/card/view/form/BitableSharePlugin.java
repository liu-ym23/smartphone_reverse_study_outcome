package com.bytedance.ee.bear.bitable.card.view.form;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardPlugin;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.card.viewmodel.share.BitableShareParams;
import com.bytedance.ee.bear.bitable.card.viewmodel.share.ShareMeta;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.share.ShareModel;
import com.bytedance.ee.bear.bitable.share.model.CommentShareModel;
import com.bytedance.ee.bear.bitable.share.sharepanel.BitableShareBaseAddDelegate;
import com.bytedance.ee.bear.bitable.share.sharepanel.BitableShareCardCommentFragmentDelegate;
import com.bytedance.ee.bear.bitable.share.sharepanel.BitableShareCardV2FragmentDelegate;
import com.bytedance.ee.bear.bitable.share.sharepanel.BitableShareFragmentDelegate;
import com.bytedance.ee.bear.bitable.share.sharepanel.FormBitableShareFragmentDelegate;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.bear.share.IShareMeta;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.util.io.NonProguard;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import gq4.v;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: classes15.dex */
public class BitableSharePlugin extends DocumentPlugin implements p, sa5.a {
    private static final String BITABLE_SHARE = "biz.bitable.share";
    private static final String BUNDLE_KEY_SHARE_META = "key_share_meta";
    public static final String FORMS_SEND_NOTIFICATION = "javascript:window.lark.biz.forms.remindNotificationClick";
    private static final String FORM_SHARE_ACTION_NOTICE_ME = "noticeMe";
    private static final String FORM_SHARE_ACTION_SEND_NOTIFICATION = "sendNotification";
    private static final String FORM_SHARE_SOURCE_MANUAL_CLICK = "manualClick";
    private static final int REQUEST_CODE_RESPONSE = 1;
    private static final int REQUEST_CODE_SHARE_TO_LARK = 2;
    private static final String SHARE_FORM = "biz.bitable.form.share";
    private static final String SHARE_FORM_UPDATE = "biz.bitable.form.shareUpdate";
    private static final String TAG = "ShareFormPlugin";
    private BitableCardViewModel bitableCardViewModel;
    private final CompositeDisposable compositeDisposable;
    private FormBitableShareFragmentDelegate currentFormShareDelegate;
    private DialogFragment dialogFragment;
    private boolean isNewFormEnable;
    private com.bytedance.ee.bear.share.export.e lifecycleCallbacks;
    private boolean useNewShareToLark;

    public static class FormMeta implements NonProguard {
        public String baseToken;
        public boolean formEditable;
        public String formName;
        public Boolean noticeMe;
        public boolean showNoticeMe;
        public boolean showRemindMe;
        public String tableId;
        public String viewId;

        public FormMeta() {
        }
    }

    public static class FormShareUpdateData implements NonProguard {
        public Boolean noticeMe;

        public FormShareUpdateData() {
        }
    }

    public static class FormsShareModel implements NonProguard {
        public String bannerURL;
        public String baseToken;
        public String formName;
        public boolean noticeMe;
        public String onClick;
        public String[] panelComponents;
        public String panelTitle;
        public String tableId;
        public String viewId;

        public FormsShareModel() {
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f208381a = null;

        static {
            int[] r100 = new int[EFieldUIType.values().length];
            f208381a = r100;
            r100[EFieldUIType.USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f208381a[EFieldUIType.ATTACHMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f208381a[EFieldUIType.FORMULA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f208381a[EFieldUIType.LOOKUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f208381a[EFieldUIType.SINGLE_LINK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f208381a[EFieldUIType.DUPLEX_LINK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public class b implements i<ShareModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSharePlugin f208382a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(BitableSharePlugin r100) {
            this.f208382a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            ShareModel r102 = (ShareModel) r100;
            if (r102 != null) goto L6;
            tt5.a.d(BitableSharePlugin.TAG, "shareFormHandler, data is null");
            return;
        L6:
            if (BitableSharePlugin.access$300(this.f208382a) != null) goto L8;
        L10:
            this.f208382a.showSharePanel(r102, false);
            return;
        L8:
            if (BitableSharePlugin.access$300(this.f208382a).isAdded() == false) goto L10;
            tt5.a.h(BitableSharePlugin.TAG, "shareFormHandler, bitableShareFragment is already added");
        }
    }

    public interface c {
        void a(JSONObject r100);
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IShareMeta f208383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f208384b;

        public d(IShareMeta r100, boolean r101) {
            this.f208384b = false;
            this.f208383a = r100;
            this.f208384b = r101;
        }
    }

    public class e implements i<FormMeta> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSharePlugin f208385a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(BitableSharePlugin r100) {
            this.f208385a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, final m r110) {
            final FormMeta r101 = (FormMeta) r100;
            if (r101 != null) goto L6;
            tt5.a.d(BitableSharePlugin.TAG, "shareFormHandler, data is null");
            return;
        L6:
            if (BitableSharePlugin.access$300(this.f208385a) != null) goto L8;
        L10:
            final Long r102 = Long.valueOf(System.currentTimeMillis());
            Disposable r103 = Flowable.zip(((com.bytedance.ee.bear.share.b) org.koin.java.a.a(com.bytedance.ee.bear.share.b.class)).i(r101.baseToken, r101.tableId, r101.viewId, Integer.valueOf(EShareType.FORM.getType()), ""), BitableSharePlugin.access$400(this.f208385a).getShowingTableMetaFlow(r101.baseToken, r101.tableId, r101.viewId, ETableType.CARD).onErrorResumeNext(new gq4.f()), new gq4.g()).subscribe(new gq4.h(this, r101, r102, r110), new gq4.i());
            BitableSharePlugin.access$500(this.f208385a).add(r103);
            return;
        L8:
            if (BitableSharePlugin.access$300(this.f208385a).isAdded() == false) goto L10;
            tt5.a.h(BitableSharePlugin.TAG, "shareFormHandler, bitableShareFragment is already added");
        }
    }

    public class f implements i<FormShareUpdateData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSharePlugin f208386a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(BitableSharePlugin r100) {
            this.f208386a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            FormShareUpdateData r102 = (FormShareUpdateData) r100;
            if (r102 != null) goto L6;
            tt5.a.d(BitableSharePlugin.TAG, "shareFormUpdateHandler, data is null");
            return;
        L6:
            if (BitableSharePlugin.access$300(this.f208386a) != null) goto L8;
        L17:
            tt5.a.h(BitableSharePlugin.TAG, "shareFormUpdateHandler, bitableShareFragment is not added");
            return;
        L8:
            if (BitableSharePlugin.access$300(this.f208386a).isAdded() == false) goto L17;
            if (BitableSharePlugin.access$1200(this.f208386a) == null) goto L16;
            FormBitableShareFragmentDelegate r103 = BitableSharePlugin.access$1200(this.f208386a);
            Boolean r104 = r102.noticeMe;
            r103.f215368n = true;
            UDSwitch r105 = r103.f215365k;
            if (r105 == null) goto L15;
            r105.setChecked(Intrinsics.areEqual(r104, Boolean.TRUE));
        L15:
            r103.f215368n = false;
            return;
        L16:
            tt5.a.d(BitableSharePlugin.TAG, "shareFormUpdateHandler, currentFormShareDelegate is null");
        }
    }

    public static /* synthetic */ void c(BitableSharePlugin r100, ShareModel r101, Long r102, IShareMeta r103) {
        r100.lambda$showSharePanel$3(r101, r102, r103);
    }

    public static /* synthetic */ void d(Throwable r100) {
        lambda$showSharePanel$2(r100);
    }

    public static /* synthetic */ void e(BitableSharePlugin r100, ShareModel r101, Long r102, d r103) {
        r100.lambda$showSharePanel$1(r101, r102, r103);
    }

    public static /* synthetic */ d f(IDocUserPermission r100, IShareMeta r101) {
        return lambda$showSharePanel$0(r100, r101);
    }

    public static /* synthetic */ void g(Throwable r100) {
        lambda$showSharePanel$4(r100);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public BitableSharePlugin() {
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.useNewShareToLark = r100.h("ccm.bitable.use_new_share_to_lark");
        this.compositeDisposable = new CompositeDisposable();
        this.isNewFormEnable = r100.h("ccm.bitable.larkform.new.enable");
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        if (ku5.c.k(getContext()) == false) goto L6;
        return false;
    L6:
        return true;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_card_view_form_BitableSharePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DialogFragment r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static /* synthetic */ com.bytedance.ee.bear.share.export.e access$1000(BitableSharePlugin r100) {
        return r100.lifecycleCallbacks;
    }

    public static /* synthetic */ k access$1100(BitableSharePlugin r100) {
        return r100.getWeb();
    }

    public static /* synthetic */ FormBitableShareFragmentDelegate access$1200(BitableSharePlugin r100) {
        return r100.currentFormShareDelegate;
    }

    public static /* synthetic */ DialogFragment access$300(BitableSharePlugin r100) {
        return r100.dialogFragment;
    }

    public static /* synthetic */ BitableCardViewModel access$400(BitableSharePlugin r100) {
        return r100.bitableCardViewModel;
    }

    public static /* synthetic */ CompositeDisposable access$500(BitableSharePlugin r100) {
        return r100.compositeDisposable;
    }

    public static /* synthetic */ FragmentActivity access$600(BitableSharePlugin r100) {
        return r100.getActivity();
    }

    public static /* synthetic */ DocViewModel access$700(BitableSharePlugin r100) {
        return r100.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$800(BitableSharePlugin r100) {
        return r100.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$900(BitableSharePlugin r100) {
        return r100.getDocViewModel();
    }

    private static void lambda$showSharePanel$2(Throwable r100) throws Exception {
        tt5.a.e(TAG, "fetchShareMeta failed with request permission", r100, false);
    }

    private static void lambda$showSharePanel$4(Throwable r100) throws Exception {
        tt5.a.e(TAG, "fetchShareMeta failed", r100, false);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        r100.put(SHARE_FORM, new e(this));
        r100.put(SHARE_FORM_UPDATE, new f(this));
        r100.put(BITABLE_SHARE, new b(this));
    }

    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
        this.bitableCardViewModel = (BitableCardViewModel) viewModel(BitableCardViewModel.class);
        this.lifecycleCallbacks = new v(r100, this);
        if (this.isNewFormEnable == false) goto L6;
        r100.findPlugin(BitableCardPlugin.class);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DocumentPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    public void onDetachFromHost(DocumentPluginHost r100) {
        super.onDetachFromHost(r100);
    }

    public static /* synthetic */ FormBitableShareFragmentDelegate access$1202(BitableSharePlugin r100, FormBitableShareFragmentDelegate r101) {
        r100.currentFormShareDelegate = r101;
        return r101;
    }

    public static /* synthetic */ DialogFragment access$302(BitableSharePlugin r100, DialogFragment r101) {
        r100.dialogFragment = r101;
        return r101;
    }

    private static /* synthetic */ d lambda$showSharePanel$0(IDocUserPermission r100, IShareMeta r101) throws Exception {
        if (r100.getPermissionStatusCode() != 10013) goto L5;
        boolean r102 = true;
    L7:
        return new d(r101, r102);
    L5:
        r102 = false;
        goto L7
    }

    public void onDetachFromUIContainer(DocumentPluginHost r100, t r101) {
        this.compositeDisposable.clear();
        DialogFragment r102 = this.dialogFragment;
        if (r102 != null) goto L16;
    L14:
        super.onDetachFromUIContainer(r100, r101);
        return;
    L16:
        INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_card_view_form_BitableSharePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r102);     // Catch: Throwable -> L7 Exception -> L9
    L6:
        this.currentFormShareDelegate = null;
        goto L14
    L7:
        th = move-exception;
        this.currentFormShareDelegate = null;
        throw th;
    L9:
        e = move-exception;
        iu5.d.a(TAG, e);     // Catch: Throwable -> L7
        goto L6
    }

    public void showSharePanel(final ShareModel r110, boolean r111) {
        final Long r100 = Long.valueOf(System.currentTimeMillis());
        Flowable<IDocUserPermission> r101 = ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().c(getDocViewModel().getToken(), 8);
        Flowable<IShareMeta> r102 = ((com.bytedance.ee.bear.share.b) org.koin.java.a.a(com.bytedance.ee.bear.share.b.class)).i(r110.getBaseToken(), r110.getTableId(), r110.getViewId(), Integer.valueOf(r110.getShareType()), r110.getRecordId());
        if (r111 == false) goto L6;
        Disposable r112 = Flowable.zip(r101, r102, new gq4.a()).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new gq4.b(this, r110, r100), new gq4.c());
    L14:
        if (r112 == null) goto L17;
        this.compositeDisposable.add(r112);
        return;
    L17:
        return;
    L6:
        if (r110.getShareType() != EShareType.Record.getType()) goto L8;
    L13:
        handleShowBitableShareFragment(new ShareMeta(), r110, r100.longValue());
        r112 = null;
        goto L14
    L8:
        if (r110.getShareType() == EShareType.BASE_ADD.getType()) goto L13;
        if (r110.getShareType() == EShareType.BASE_ADD_SUBMIT.getType()) goto L13;
        r112 = r102.subscribe(new gq4.d(this, r110, r100), new gq4.e());
        goto L14
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleShowBitableShareFragment(IShareMeta r100, ShareModel r101, long r102) {
        if (r100.isOpen() == true) goto L6;
        r100.setShareType(r101.getShareType());
    L8:
        String r103 = null;
        if (com.bytedance.ee.bear.bitable.c.i() == true) goto L11;
    L13:
        WebFragment r104 = null;
    L14:
        ShareParams.ShareParamsBuilder r105 = new BitableShareParams.BitableShareParamsBuilder(getActivity(), r104).bitableShareMeta(r100).tableId(r101.getTableId()).viewId(r101.getViewId()).recordId(r101.getRecordId()).bitableType(com.bytedance.ee.bear.bitable.card.view.form.e.a(getDocViewModel())).token(r101.getBaseToken());
        sbb.e r106 = sbb.e.f541307r;
        ShareParams r107 = r105.type(r106.f541317b).realToken(r101.getBaseToken()).realType(r106.f541317b).docName(r101.getTableId()).url(getDocViewModel().getUrl()).originUrl(getDocViewModel().getOriginUrl()).build();
        Bundle r108 = new Bundle();
        r108.putLong("analytics_open_time_t1_start", r102);
        if (r100.getShareType() != EShareType.Record) goto L23;
        r107.setDocName(r101.getTitle());
        r107.setExpandAtInit(Boolean.TRUE);
        com.bytedance.ee.bear.bitable.share.sharepanel.a r109 = new BitableShareCardV2FragmentDelegate(this.lifecycleCallbacks, r101.getRecordId());
        r100.getShareType().appendExtra("type", "record");
        if ((r101 instanceof CommentShareModel) == false) goto L21;
        CommentShareModel r110 = (CommentShareModel) r101;
        String r111 = r110.getCommentId();
        String r112 = r110.getReplyId();
        if (TextUtils.isEmpty(r111) == true) goto L21;
        r100.getShareType().appendExtra("type", "discussion");
        r100.getShareType().appendExtra("comment_id", r111);
        r109 = new BitableShareCardCommentFragmentDelegate(this.lifecycleCallbacks, r101.getRecordId(), r111, r112);
    L21:
        this.dialogFragment = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).ka(r107, r108, r109, r109);
        return;
    L23:
        EShareType r113 = r100.getShareType();
        EShareType r114 = EShareType.BASE_ADD;
        if (r113 != r114) goto L26;
    L30:
        r107.setType(sbb.e.f541299j.f541317b);
        r107.setDocName(r101.getTitle());
        r107.setExpandAtInit(Boolean.TRUE);
        if (r100.getShareType() != r114) goto L33;
        r103 = getDocViewModel().getUrl();
    L33:
        BitableShareBaseAddDelegate r115 = new BitableShareBaseAddDelegate(this.lifecycleCallbacks, r103);
        this.dialogFragment = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).ka(r107, r108, r115, r115);
        return;
    L26:
        if (r100.getShareType() == EShareType.BASE_ADD_SUBMIT) goto L30;
        BitableShareFragmentDelegate r116 = new BitableShareFragmentDelegate(this.lifecycleCallbacks);
        this.dialogFragment = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).ka(r107, r108, r116, r116);
        return;
    L11:
        if (ForsetiHelper.s(((DocumentPluginHost) getHost()).c()) == false) goto L13;
        r104 = ((DocumentPluginHost) getHost()).c();
        goto L14
    L6:
        if (r100.getShareType() != EShareType.UNSUPPORT) goto L8;
    }

    private /* synthetic */ void lambda$showSharePanel$1(ShareModel r100, Long r101, d r102) throws Exception {
        if (r102.f208384b == false) goto L5;
        UDToast.show(getContext(), R.string.Bitable_Share_RecordVioloteTOS);
        tt5.a.d(TAG, "user is forbidden to shareExternal");
        return;
    L5:
        handleShowBitableShareFragment(r102.f208383a, r100, r101.longValue());
    }

    private /* synthetic */ void lambda$showSharePanel$3(ShareModel r100, Long r101, IShareMeta r102) throws Exception {
        handleShowBitableShareFragment(r102, r100, r101.longValue());
    }

    @Override // sa5.a
    public void onActivityResult(int r100, int r101, Intent r102) {
        if (this.useNewShareToLark == true) goto L5;
        return;
    L5:
        if (r100 == 2) goto L7;
        return;
    L7:
        if (r101 != (-1)) goto L12;
        UDToast.show(getContext(), R.string.CreationMobile_mention_sharing_success, R.drawable.ud_icon_yes_outlined);
        return;
    }
}
