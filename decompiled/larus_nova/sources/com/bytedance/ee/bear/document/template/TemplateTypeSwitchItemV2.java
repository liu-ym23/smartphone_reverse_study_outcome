package com.bytedance.ee.bear.document.template;

import android.content.DialogInterface;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.bytedance.ee.bear.templates.TemplateViewModel;
import com.bytedance.ee.bear.templates.g;
import com.bytedance.ee.util.ui.m;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\bH\u0002J4\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u000eH\u0002J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u000bH\u0002J \u0010&\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0006\u0010'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u0011H\u0002J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/document/template/TemplateTypeSwitchItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ISwitchMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "<init>", "(Lcom/bytedance/ee/bear/document/DocumentPluginHost;)V", "getId", "", "getTitle", "getIcon", "", "getIconTint", "isCheck", "", "isVisible", "onCheckStateChange", "", "delegate", "Lcom/bytedance/ee/bear/more/moreprotocol/ISwitchMoreItem$ItemNotifyDelegate;", "isBaseApp", "reportClick", "click", "showPermissionCheckDialog", "titleRes", "message", "", com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE, "Lkotlin/Function0;", "cancel", "reportProDialogClickEvent", "notifyTemplateTagBannerUpdate", "show", "deleteDocWithTemplateTag", "moreInfo", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "updateTemplateType", "type", "addDocWithTemplateTag", "isPro", "notifyWebCallback", "notifyItemChange", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateTypeSwitchItemV2 extends BaseMoreItem implements ISwitchMoreItem {
    public static final a Companion = null;
    public static final String TAG = "TemplateTypeSwitchItemV2";
    private final DocumentPluginHost pluginHost;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.ee.bear.templates.dto.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f221976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TemplateTypeSwitchItemV2 f221977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ISwitchMoreItem.a f221978c;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TemplateTypeSwitchItemV2 f221979a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ISwitchMoreItem.a f221980b;

            public a(TemplateTypeSwitchItemV2 r100, ISwitchMoreItem.a r101) {
                this.f221979a = r100;
                this.f221980b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TemplateTypeSwitchItemV2.access$notifyItemChange(this.f221979a, this.f221980b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.template.TemplateTypeSwitchItemV2$b$b, reason: collision with other inner class name */
        public static final class RunnableC3168b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TemplateTypeSwitchItemV2 f221981a;

            public RunnableC3168b(TemplateTypeSwitchItemV2 r100) {
                this.f221981a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TemplateTypeSwitchItemV2.access$updateTemplateType(this.f221981a, 2);     // Catch: Throwable -> L4
                TemplateTypeSwitchItemV2.access$notifyTemplateTagBannerUpdate(this.f221981a, true);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.ee.bear.templates.dto.d
        public final void onFail(int r100, String r101) {
            m.a(new a(this.f221977b, this.f221978c));
            if (((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).o(r100) == false) goto L5;
            return;
        L5:
            String r102 = TemplateTypeSwitchItemV2.access$getPluginHost$p(this.f221977b).getActivity().getString(R.string.Drive_Drive_LikeFail);
            Toast.showFailureText(eu5.b.f474075a, r102);
        }

        @Override // com.bytedance.ee.bear.templates.dto.d
        public final void onSuccess(int r100, String r101) {
            m.a(new RunnableC3168b(this.f221977b));
            Toast.showSuccessText(eu5.b.f474075a, R.string.CreationMobile_Template_TransformDone_Toast);
            if (this.f221976a == false) goto L6;
            TemplateTypeSwitchItemV2.access$notifyWebCallback(this.f221977b);
            return;
        }

        public b(boolean r100, TemplateTypeSwitchItemV2 r101, ISwitchMoreItem.a r102) {
            this.f221976a = r100;
            this.f221977b = r101;
            this.f221978c = r102;
        }
    }

    public static final class c implements com.bytedance.ee.bear.templates.dto.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemplateTypeSwitchItemV2 f221982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ISwitchMoreItem.a f221983b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TemplateTypeSwitchItemV2 f221984a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ISwitchMoreItem.a f221985b;

            public a(TemplateTypeSwitchItemV2 r100, ISwitchMoreItem.a r101) {
                this.f221984a = r100;
                this.f221985b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TemplateTypeSwitchItemV2.access$notifyItemChange(this.f221984a, this.f221985b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TemplateTypeSwitchItemV2 f221986a;

            public b(TemplateTypeSwitchItemV2 r100) {
                this.f221986a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TemplateTypeSwitchItemV2.access$updateTemplateType(this.f221986a, -1);     // Catch: Throwable -> L4
                TemplateTypeSwitchItemV2.access$notifyTemplateTagBannerUpdate(this.f221986a, false);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(TemplateTypeSwitchItemV2 r100, ISwitchMoreItem.a r101) {
            this.f221982a = r100;
            this.f221983b = r101;
        }

        @Override // com.bytedance.ee.bear.templates.dto.d
        public final void onFail(int r100, String r101) {
            m.a(new a(this.f221982a, this.f221983b));
            if (((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).o(r100) == false) goto L5;
            return;
        L5:
            String r102 = TemplateTypeSwitchItemV2.access$getPluginHost$p(this.f221982a).getActivity().getString(R.string.Drive_Drive_LikeFail);
            Toast.showFailureText(eu5.b.f474075a, r102);
        }

        @Override // com.bytedance.ee.bear.templates.dto.d
        public final void onSuccess(int r100, String r101) {
            m.a(new b(this.f221982a));
        }
    }

    public static final class d implements UDCheckBox.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemplateTypeSwitchItemV2 f221987a;

        public d(TemplateTypeSwitchItemV2 r100) {
            this.f221987a = r100;
        }

        @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
        public final void a(UDCheckBox r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "buttonView");
            if (r101 == false) goto L6;
            TemplateTypeSwitchItemV2.access$reportProDialogClickEvent(this.f221987a, "tick");
            return;
        }
    }

    public static final class e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f221988a;

        public e(Function0<Unit> r100) {
            this.f221988a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f221988a.invoke();
        }
    }

    public static final class f implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f221989a;

        public f(Function0<Unit> r100) {
            this.f221989a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f221989a.invoke();
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.ud_icon_template_outlined;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
    }

    private final boolean isBaseApp() {
        return ((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6)).a(this.pluginHost);
    }

    private final void notifyWebCallback() {
        JSONObject r100 = new JSONObject();
        r100.put("needSendCS", Boolean.FALSE);
        r100.put("checked", Boolean.TRUE);
        this.pluginHost.getWeb().j("window.lark.biz.bitable.upgradeBase", r100);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.TEMPLATE_SWITCH.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem
    public boolean isCheck() {
        int r100 = g.f239075a;
        oj5.c r101 = getMoreInfo();
        if (r101 == null) goto L5;
        int r102 = r101.getTemplateType();
    L6:
        boolean r103 = g.a(r102);
        tt5.a.h(TAG, "isCheck. flag:" + r103);
        return r103;
    L5:
        r102 = -1;
        goto L6
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        Set<Integer> r100 = com.bytedance.ee.bear.document.template.b.f221990a;
        if (com.bytedance.ee.bear.document.template.b.c(this.pluginHost) == false) goto L6;
        return false;
    L6:
        if (isItemInvisibleByBenefit() == false) goto L9;
        return false;
    L9:
        if (isItemInvisibleByJSMsg() == false) goto L11;
        return false;
    L11:
        oj5.c r101 = getMoreInfo();
        if (r101 != null) goto L15;
        return false;
    L15:
        if (r101.m() == false) goto L18;
        return false;
    L18:
        if (com.bytedance.ee.bear.document.template.b.a(r101) == true) goto L21;
        return false;
    L21:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.f("bitable.template.bitable_advanced_permission_mobile") == false) goto L23;
    L28:
        boolean r102 = com.bytedance.ee.bear.document.template.b.b(this.pluginHost, r101);
        y.b(TAG, getId(), r102, r102, "", "template_switch_visible");
        return r102;
    L23:
        if ((r101 instanceof oj5.a) == false) goto L28;
        if (((oj5.a) r101).A == false) goto L28;
        tt5.a.h(TemplateMoreItemV2.TAG, "doc is pro, template op not");
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(R.string.LarkCCM_Docs_ConvertToTemplate_Menu_Mob);
    }

    public TemplateTypeSwitchItemV2(DocumentPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        this.pluginHost = r100;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_template_TemplateTypeSwitchItemV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(UDDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static final /* synthetic */ DocumentPluginHost access$getPluginHost$p(TemplateTypeSwitchItemV2 r100) {
        return r100.pluginHost;
    }

    public static final /* synthetic */ void access$notifyWebCallback(TemplateTypeSwitchItemV2 r100) {
        r100.notifyWebCallback();
    }

    private final void notifyItemChange(ISwitchMoreItem.a r100) {
        if (com.bytedance.ee.util.ui.b.a(getHost().getHostFragment().getActivity()) == true) goto L5;
    L7:
        tt5.a.d(TAG, "activity is not active or panel not showing");
        return;
    L5:
        if (getHost().isShowing() == false) goto L7;
        r100.notifyItemChanged();
    }

    private final void notifyTemplateTagBannerUpdate(boolean r100) {
        ((TemplateViewModel) ViewModelProviders.of(this.pluginHost.getActivity()).get(TemplateViewModel.class)).getTemplateTagStatueLiveData().setValue(Boolean.valueOf(r100));
    }

    private final void reportClick(String r110) {
        if ((getMoreInfo() instanceof oj5.a) == false) goto L6;
        oj5.c r100 = getMoreInfo();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
        oj5.a r101 = (oj5.a) r100;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new i(getHost().getHostFragment().getArguments(), r101.f523532c, r101.getType(), false, r101.b(), r110, "none", "", "", r101 instanceof oj5.f, r101.f523540k, r101.f523547r, r101.isOwner(), r101.L()));
        return;
    }

    private final void reportProDialogClickEvent(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("click", r100);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_bitable_premium_permission_template_warning_click", r101);
    }

    private final void updateTemplateType(int r100) {
        oj5.c r101 = getMoreInfo();
        if (r101 == null) goto L5;
        r101.z(r100);
    L5:
        DocViewModel r102 = this.pluginHost.a();
        if (r102 == null) goto L13;
        DocumentInfo r103 = r102.getDocumentInfoData();
        if (r103 == null) goto L14;
        DocMetaInfo r104 = r103.getDocMetaInfo();
        if (r104 == null) goto L15;
        r104.setTemplate_type(r100);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem
    public void onCheckStateChange(final ISwitchMoreItem.a r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        if (y.a() == false) goto L9;
        if (j.a.f217090a.getNetworkState().a() == true) goto L9;
        UDToast.show(this.pluginHost.getActivity(), R.string.Doc_List_OperateFailedNoNet);
        y.b(TAG, getId(), true, false, "network", "network");
        notifyItemChange(r100);
        return;
    L9:
        if (y.a() == true) goto L11;
        y.c(TAG, getId());
    L11:
        final oj5.c r101 = getMoreInfo();
        if (r101 != null) goto L15;
        UDToast.show(this.pluginHost.getActivity(), R.string.Drive_Drive_GetFileInformationFail);
        tt5.a.h(TAG, "onCheckStateChange. moreInfo == null");
        return;
    L15:
        final boolean r102 = true;
        tt5.a.h(TAG, "onItemClick. newState:" + (!isCheck()));
        int r103 = g.f239075a;
        if (g.a(r101.getTemplateType()) == false) goto L19;
        deleteDocWithTemplateTag(r100, r101);
        reportClick("change_to_template_close");
        return;
    L19:
        if ((r101 instanceof oj5.a) == true) goto L21;
    L23:
        r102 = false;
    L24:
        boolean r104 = isBaseApp();
        if (r102 == true) goto L29;
        if (r104 == true) goto L29;
        addDocWithTemplateTag(r100, r101, false);
        reportClick("change_to_template_open");
        return;
    L29:
        if (r104 == false) goto L31;
        int r105 = R.string.Bitable_AppMode_ConvertToTemplate_Title;
    L32:
        if (r104 == false) goto L34;
        String r106 = this.pluginHost.getContext().getString(R.string.Bitable_AppMode_ConvertToTemplate_OnceConvertedAppPermDisabled_Desc) + this.pluginHost.getContext().getString(R.string.Bitable_AppMode_ConvertToTemplate_LinkedBaseCopyCreatedOnceUsed_Desc);
    L35:
        showPermissionCheckDialog(r105, r106, new AnonymousClass1(this, r100, r101, r102), new AnonymousClass2(this, r100));
        return;
    L34:
        r106 = this.pluginHost.getContext().getString(R.string.Bitable_AdvancedPermission_ConvertToTemplatePopupContent);
        Intrinsics.checkNotNull(r106);
        goto L35
    L31:
        r105 = R.string.Bitable_AdvancedPermission_ConvertToTemplatePopupTitle;
        goto L32
    L21:
        if (((oj5.a) r101).A == false) goto L23;
        goto L23
    }

    public static final /* synthetic */ void access$notifyItemChange(TemplateTypeSwitchItemV2 r100, ISwitchMoreItem.a r101) {
        r100.notifyItemChange(r101);
    }

    public static final /* synthetic */ void access$notifyTemplateTagBannerUpdate(TemplateTypeSwitchItemV2 r100, boolean r101) {
        r100.notifyTemplateTagBannerUpdate(r101);
    }

    public static final /* synthetic */ void access$reportClick(TemplateTypeSwitchItemV2 r100, String r101) {
        r100.reportClick(r101);
    }

    public static final /* synthetic */ void access$reportProDialogClickEvent(TemplateTypeSwitchItemV2 r100, String r101) {
        r100.reportProDialogClickEvent(r101);
    }

    public static final /* synthetic */ void access$updateTemplateType(TemplateTypeSwitchItemV2 r100, int r101) {
        r100.updateTemplateType(r101);
    }

    private final void deleteDocWithTemplateTag(ISwitchMoreItem.a r100, oj5.c r101) {
        ((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).m(r101.getType(), r101.getToken(), new c(this, r100));
    }

    private final void addDocWithTemplateTag(ISwitchMoreItem.a r100, oj5.c r101, boolean r110) {
        yn5.e r102 = new yn5.e(r101.getType(), r101.getToken(), r101.getTitle(), false, "1");
        ((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).a(this.pluginHost.getActivity(), r102, new b(r110, this, r100));
    }

    public static final /* synthetic */ void access$addDocWithTemplateTag(TemplateTypeSwitchItemV2 r100, ISwitchMoreItem.a r101, oj5.c r102, boolean r103) {
        r100.addDocWithTemplateTag(r101, r102, r103);
    }

    private final void showPermissionCheckDialog(int r100, CharSequence r101, Function0<Unit> r102, Function0<Unit> r103) {
        hp5.a r104 = new hp5.a(this.pluginHost.getContext()).messageTextColor(R.color.text_title).messageGravity(GravityCompat.START).message(r101).messageTextSize(16).title(r100).titleColor(R.color.text_title).titleSize(17).titleBold(true).cancelOnTouchOutside(false).gravity(17);
        r104.f486434e = true;
        r104.f486430a = false;
        String r105 = this.pluginHost.getContext().getString(R.string.Bitable_AdvancedPermission_DisablePopupContent2);
        Intrinsics.checkNotNullParameter(r105, "value");
        r104.f486431b = r105;
        r104.f486433d = R.color.text_caption;
        d r106 = new d(this);
        Intrinsics.checkNotNullParameter(r106, "value");
        r104.f486435f = r106;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_template_TemplateTypeSwitchItemV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r104.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.Bitable_AdvancedPermission_ConvertToTemplatePopupButtonYes).onClickListener(new e(r102))).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_secondary).text(R.string.Bitable_Common_ButtonCancel).onClickListener(new f(r103)).textColorRes(R.color.text_title)).build());
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_bitable_premium_permission_template_warning_view", new JSONObject());
    }
}
