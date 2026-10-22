package com.bytedance.ee.bear.document.template;

import android.content.DialogInterface;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
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
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\bH\u0002J4\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u000eH\u0002J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u000bH\u0002J \u0010&\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0006\u0010'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u0011H\u0002J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/document/template/TemplateTypeSwitchItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ISwitchMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "<init>", "(Lcom/bytedance/ee/bear/document/DocumentPluginHost;)V", "getId", "", "getTitle", "getIcon", "", "getIconTint", "isCheck", "", "isVisible", "onCheckStateChange", "", "delegate", "Lcom/bytedance/ee/bear/more/moreprotocol/ISwitchMoreItem$ItemNotifyDelegate;", "isBaseApp", "reportClick", "click", "showPermissionCheckDialog", "titleRes", "message", "", "ok", "Lkotlin/Function0;", "cancel", "reportProDialogClickEvent", "notifyTemplateTagBannerUpdate", "show", "deleteDocWithTemplateTag", "moreInfo", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "updateTemplateType", "type", "addDocWithTemplateTag", "isPro", "notifyWebCallback", "notifyItemChange", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateTypeSwitchItemV2 extends BaseMoreItem implements ISwitchMoreItem {
    public static final a Companion = null;
    public static final String TAG = "TemplateTypeSwitchItemV2";
    private final DocumentPluginHost pluginHost;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.ee.bear.templates.dto.d {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TemplateTypeSwitchItemV2 b;
        public final /* synthetic */ ISwitchMoreItem.a c;

        public static final class a implements Runnable {
            public final /* synthetic */ TemplateTypeSwitchItemV2 a;
            public final /* synthetic */ ISwitchMoreItem.a b;

            public a(TemplateTypeSwitchItemV2 r1, ISwitchMoreItem.a r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TemplateTypeSwitchItemV2.access$notifyItemChange(this.a, this.b);     // Catch: Throwable -> L4
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
        public static final class RunnableC0112b implements Runnable {
            public final /* synthetic */ TemplateTypeSwitchItemV2 a;

            public RunnableC0112b(TemplateTypeSwitchItemV2 r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TemplateTypeSwitchItemV2.access$updateTemplateType(this.a, 2);     // Catch: Throwable -> L4
                TemplateTypeSwitchItemV2.access$notifyTemplateTagBannerUpdate(this.a, true);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void onFail(int r3, String r4) {
            m.a(new a(this.b, this.c));
            if (((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).o(r3) == false) goto L5;
            return;
        L5:
            String r5 = TemplateTypeSwitchItemV2.access$getPluginHost$p(this.b).getActivity().getString(2131888415);
            Toast.showFailureText(eu5.b.a, r5);
        }

        public final void onSuccess(int r1, String r2) {
            m.a(new RunnableC0112b(this.b));
            Toast.showSuccessText(eu5.b.a, 2131887449);
            if (this.a == false) goto L6;
            TemplateTypeSwitchItemV2.access$notifyWebCallback(this.b);
            return;
        }

        public b(boolean r1, TemplateTypeSwitchItemV2 r2, ISwitchMoreItem.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements com.bytedance.ee.bear.templates.dto.d {
        public final /* synthetic */ TemplateTypeSwitchItemV2 a;
        public final /* synthetic */ ISwitchMoreItem.a b;

        public static final class a implements Runnable {
            public final /* synthetic */ TemplateTypeSwitchItemV2 a;
            public final /* synthetic */ ISwitchMoreItem.a b;

            public a(TemplateTypeSwitchItemV2 r1, ISwitchMoreItem.a r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TemplateTypeSwitchItemV2.access$notifyItemChange(this.a, this.b);     // Catch: Throwable -> L4
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
            public final /* synthetic */ TemplateTypeSwitchItemV2 a;

            public b(TemplateTypeSwitchItemV2 r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TemplateTypeSwitchItemV2.access$updateTemplateType(this.a, -1);     // Catch: Throwable -> L4
                TemplateTypeSwitchItemV2.access$notifyTemplateTagBannerUpdate(this.a, false);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(TemplateTypeSwitchItemV2 r1, ISwitchMoreItem.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFail(int r3, String r4) {
            m.a(new a(this.a, this.b));
            if (((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).o(r3) == false) goto L5;
            return;
        L5:
            String r5 = TemplateTypeSwitchItemV2.access$getPluginHost$p(this.a).getActivity().getString(2131888415);
            Toast.showFailureText(eu5.b.a, r5);
        }

        public final void onSuccess(int r1, String r2) {
            m.a(new b(this.a));
        }
    }

    public static final class d implements UDCheckBox.c {
        public final /* synthetic */ TemplateTypeSwitchItemV2 a;

        public d(TemplateTypeSwitchItemV2 r1) {
            this.a = r1;
        }

        public final void a(UDCheckBox r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "buttonView");
            if (r3 == false) goto L6;
            TemplateTypeSwitchItemV2.access$reportProDialogClickEvent(this.a, "tick");
            return;
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0<Unit> a;

        public e(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.invoke();
        }
    }

    public static final class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0<Unit> a;

        public f(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.invoke();
        }
    }

    static {
        Companion = new a();
    }

    public int getIcon() {
        return 2131255983;
    }

    public int getIconTint() {
        return 2131102418;
    }

    private final boolean isBaseApp() {
        return ((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6)).a(this.pluginHost);
    }

    private final void notifyWebCallback() {
        JSONObject r0 = new JSONObject();
        r0.put("needSendCS", Boolean.FALSE);
        r0.put("checked", Boolean.TRUE);
        this.pluginHost.getWeb().j("window.lark.biz.bitable.upgradeBase", r0);
    }

    public String getId() {
        return CommonMoreItemId.TEMPLATE_SWITCH.getId();
    }

    public boolean isCheck() {
        int r0 = g.a;
        oj5.c r1 = getMoreInfo();
        if (r1 == null) goto L5;
        int r2 = r1.getTemplateType();
    L6:
        boolean r3 = g.a(r2);
        tt5.a.h(TAG, "isCheck. flag:" + r3);
        return r3;
    L5:
        r2 = -1;
        goto L6
    }

    public boolean isVisible() {
        Set<Integer> r0 = com.bytedance.ee.bear.document.template.b.a;
        if (com.bytedance.ee.bear.document.template.b.c(this.pluginHost) == false) goto L6;
        return false;
    L6:
        if (isItemInvisibleByBenefit() == false) goto L9;
        return false;
    L9:
        if (isItemInvisibleByJSMsg() == false) goto L11;
        return false;
    L11:
        oj5.a r1 = getMoreInfo();
        if (r1 != null) goto L15;
        return false;
    L15:
        if (r1.m() == false) goto L18;
        return false;
    L18:
        if (com.bytedance.ee.bear.document.template.b.a(r1) == true) goto L21;
        return false;
    L21:
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("bitable.template.bitable_advanced_permission_mobile") == false) goto L23;
    L28:
        boolean r2 = com.bytedance.ee.bear.document.template.b.b(this.pluginHost, r1);
        y.b(TAG, getId(), r2, r2, "", "template_switch_visible");
        return r2;
    L23:
        if ((r1 instanceof oj5.a) == false) goto L28;
        if (r1.A == false) goto L28;
        tt5.a.h(TemplateMoreItemV2.TAG, "doc is pro, template op not");
        return false;
    }

    public String getTitle() {
        return getString(2131889019);
    }

    public TemplateTypeSwitchItemV2(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.pluginHost = r2;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_template_TemplateTypeSwitchItemV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(UDDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static final /* synthetic */ DocumentPluginHost access$getPluginHost$p(TemplateTypeSwitchItemV2 r0) {
        return r0.pluginHost;
    }

    public static final /* synthetic */ void access$notifyWebCallback(TemplateTypeSwitchItemV2 r0) {
        r0.notifyWebCallback();
    }

    private final void notifyItemChange(ISwitchMoreItem.a r2) {
        if (com.bytedance.ee.util.ui.b.a(getHost().getHostFragment().getActivity()) == true) goto L5;
    L7:
        tt5.a.d(TAG, "activity is not active or panel not showing");
        return;
    L5:
        if (getHost().isShowing() == false) goto L7;
        r2.notifyItemChanged();
    }

    private final void notifyTemplateTagBannerUpdate(boolean r3) {
        ViewModelProviders.of(this.pluginHost.getActivity()).get(TemplateViewModel.class).getTemplateTagStatueLiveData().setValue(Boolean.valueOf(r3));
    }

    private final void reportClick(String r19) {
        if ((getMoreInfo() instanceof oj5.a) == false) goto L6;
        oj5.a r0 = getMoreInfo();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
        oj5.a r1 = r0;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new i(getHost().getHostFragment().getArguments(), r1.c, r1.getType(), false, r1.b(), r19, "none", "", "", r1 instanceof oj5.f, r1.k, r1.r, r1.isOwner(), r1.L()));
        return;
    }

    private final void reportProDialogClickEvent(String r4) {
        Map r0 = new JSONObject();
        r0.put("click", r4);
        r0.put("target", "none");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_bitable_premium_permission_template_warning_click", r0);
    }

    private final void updateTemplateType(int r2) {
        oj5.c r0 = getMoreInfo();
        if (r0 == null) goto L5;
        r0.z(r2);
    L5:
        DocViewModel r1 = this.pluginHost.a();
        if (r1 == null) goto L13;
        DocumentInfo r3 = r1.getDocumentInfoData();
        if (r3 == null) goto L14;
        DocMetaInfo r4 = r3.getDocMetaInfo();
        if (r4 == null) goto L15;
        r4.setTemplate_type(r2);
        return;
    L15:
        return;
    L14:
        return;
    }

    public void onCheckStateChange(final ISwitchMoreItem.a r9) {
        Intrinsics.checkNotNullParameter(r9, "delegate");
        if (y.a() == false) goto L9;
        if (j.a.a.getNetworkState().a() == true) goto L9;
        UDToast.show(this.pluginHost.getActivity(), 2131887951);
        y.b(TAG, getId(), true, false, "network", "network");
        notifyItemChange(r9);
        return;
    L9:
        if (y.a() == true) goto L11;
        y.c(TAG, getId());
    L11:
        final oj5.a r0 = getMoreInfo();
        if (r0 != null) goto L15;
        UDToast.show(this.pluginHost.getActivity(), 2131888399);
        tt5.a.h(TAG, "onCheckStateChange. moreInfo == null");
        return;
    L15:
        final boolean r3 = true;
        tt5.a.h(TAG, "onItemClick. newState:" + (!isCheck()));
        int r1 = g.a;
        if (g.a(r0.getTemplateType()) == false) goto L19;
        deleteDocWithTemplateTag(r9, r0);
        reportClick("change_to_template_close");
        return;
    L19:
        if ((r0 instanceof oj5.a) == true) goto L21;
    L23:
        r3 = false;
    L24:
        boolean r2 = isBaseApp();
        if (r3 == true) goto L29;
        if (r2 == true) goto L29;
        addDocWithTemplateTag(r9, r0, false);
        reportClick("change_to_template_open");
        return;
    L29:
        if (r2 == false) goto L31;
        int r4 = 2131886251;
    L32:
        if (r2 == false) goto L34;
        String r5 = this.pluginHost.getContext().getString(2131886250) + this.pluginHost.getContext().getString(2131886249);
    L35:
        showPermissionCheckDialog(r4, r5, new AnonymousClass1(this, r9, r0, r3), new AnonymousClass2(this, r9));
        return;
    L34:
        r5 = this.pluginHost.getContext().getString(2131886136);
        Intrinsics.checkNotNull(r5);
        goto L35
    L31:
        r4 = 2131886137;
        goto L32
    L21:
        if (r0.A == false) goto L23;
        goto L23
    }

    public static final /* synthetic */ void access$notifyItemChange(TemplateTypeSwitchItemV2 r0, ISwitchMoreItem.a r1) {
        r0.notifyItemChange(r1);
    }

    public static final /* synthetic */ void access$notifyTemplateTagBannerUpdate(TemplateTypeSwitchItemV2 r0, boolean r1) {
        r0.notifyTemplateTagBannerUpdate(r1);
    }

    public static final /* synthetic */ void access$reportClick(TemplateTypeSwitchItemV2 r0, String r1) {
        r0.reportClick(r1);
    }

    public static final /* synthetic */ void access$reportProDialogClickEvent(TemplateTypeSwitchItemV2 r0, String r1) {
        r0.reportProDialogClickEvent(r1);
    }

    public static final /* synthetic */ void access$updateTemplateType(TemplateTypeSwitchItemV2 r0, int r1) {
        r0.updateTemplateType(r1);
    }

    private final void deleteDocWithTemplateTag(ISwitchMoreItem.a r4, oj5.c r5) {
        ((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).m(r5.getType(), r5.getToken(), new c(this, r4));
    }

    private final void addDocWithTemplateTag(ISwitchMoreItem.a r8, oj5.c r9, boolean r10) {
        yn5.e r6 = new yn5.e(r9.getType(), r9.getToken(), r9.getTitle(), false, DiagramData$RESULT.SUCCESS);
        ((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).a(this.pluginHost.getActivity(), r6, new b(r10, this, r8));
    }

    public static final /* synthetic */ void access$addDocWithTemplateTag(TemplateTypeSwitchItemV2 r0, ISwitchMoreItem.a r1, oj5.c r2, boolean r3) {
        r0.addDocWithTemplateTag(r1, r2, r3);
    }

    private final void showPermissionCheckDialog(int r4, CharSequence r5, Function0<Unit> r6, Function0<Unit> r7) {
        hp5.a r8 = new hp5.a(this.pluginHost.getContext()).messageTextColor(2131106622).messageGravity(8388611).message(r5).messageTextSize(16).title(r4).titleColor(2131106622).titleSize(17).titleBold(true).cancelOnTouchOutside(false).gravity(17);
        r8.e = true;
        r8.a = false;
        String r9 = this.pluginHost.getContext().getString(2131886148);
        Intrinsics.checkNotNullParameter(r9, "value");
        r8.b = r9;
        r8.d = 2131106607;
        d r10 = new d(this);
        Intrinsics.checkNotNullParameter(r10, "value");
        r8.f = r10;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_template_TemplateTypeSwitchItemV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r8.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131886135).onClickListener(new e(r6))).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391778).text(2131886350).onClickListener(new f(r7)).textColorRes(2131106622)).build());
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_bitable_premium_permission_template_warning_view", new JSONObject());
    }
}
