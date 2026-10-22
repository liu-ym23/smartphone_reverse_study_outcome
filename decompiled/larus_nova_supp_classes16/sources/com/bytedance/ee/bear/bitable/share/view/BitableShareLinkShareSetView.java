package com.bytedance.ee.bear.bitable.share.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission;
import com.bytedance.ee.bear.bitable.share.sharepanel.BitableFormShareLinkSettingPanelFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.framework.utils.l0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mu4.f;
import sbb.e;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001AB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0005\u0010\fB-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u0005\u0010\u000fJ\u0010\u0010'\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002JU\u0010(\u001a\u00020#2M\u0010\u001b\u001aI\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010\u001cJ\u0014\u0010)\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0%J\u000e\u0010*\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0013J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0011H\u0016J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0013H\u0016J\b\u0010/\u001a\u00020#H\u0016J\b\u00100\u001a\u00020#H\u0002J\u000e\u00103\u001a\u00020#2\u0006\u00104\u001a\u000202J,\u00105\u001a\u001e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806j\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208`92\u0006\u0010:\u001a\u00020\u0011H\u0002J\b\u0010;\u001a\u00020\u0013H\u0002J\b\u0010<\u001a\u00020\u0011H\u0002J\u0018\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020!2\u0006\u0010.\u001a\u00020\u0013H\u0002J\u0010\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020\u0013H\u0002R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000RU\u0010\u001b\u001aI\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/view/BitableShareLinkShareSetView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ee/bear/bitable/share/IBitableSharePermSetInfo;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sourceFragment", "Landroidx/fragment/app/Fragment;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;I)V", "mBitableSharePermSetInfo", "Lcom/bytedance/ee/bear/bitable/share/BitableSharePermSetInfo;", "hasPullPermission", "", "linkShareSubTitle", "Landroid/view/View;", "linkShareMore", "linkShareTitle", "Landroid/widget/TextView;", "linkShareIcon", "Landroid/widget/ImageView;", "updateUIDelegate", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "linkTitle", "linkIcon", "Lcom/bytedance/ee/bear/bitable/share/permission/IBitableSharePublicPermission;", "bitablePermission", "", "unableClickListener", "Lkotlin/Function0;", "isNewLarkForm", "init", "setUIDelegate", "setUnableClickListener", "setIsNewLarkForm", "setBitableSharePermSetInfo", "bitableSharePermSetInfo", "setEnable", "enable", "failToFetchPerm", "onClickView", "delegateImpl", "Lcom/bytedance/ee/bear/bitable/share/view/BitableShareLinkShareSetView$Delegate;", "setDelegate", "delegate", "addReportParameters", "Ljava/util/HashMap;", "", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "permSetInfo", "removeOrg", "getPermSetInfo", "updateUI", "publicPermission", "setCanClick", "clickable", "Delegate", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShareLinkShareSetView extends ConstraintLayout implements mu4.d {
    public BitableSharePermSetInfo a;
    public final Fragment b;
    public boolean c;
    public View d;
    public View e;
    public TextView f;
    public ImageView g;
    public Function3<? super TextView, ? super ImageView, ? super IBitableSharePublicPermission, Unit> h;
    public Function0<Unit> i;
    public boolean j;
    public a k;

    public interface a {
        void a();

        k b();

        FragmentManager getFragmentManager();
    }

    public static final class b extends t {
        public final /* synthetic */ BitableShareLinkShareSetView c;

        public b(BitableShareLinkShareSetView r1) {
            this.c = r1;
        }

        public final void a(View r3) {
            Toast.showFailureText(this.c.getContext(), this.c.getContext().getString(2131888342));
        }
    }

    public static final class c extends t {
        public final /* synthetic */ BitableShareLinkShareSetView c;

        public c(BitableShareLinkShareSetView r1) {
            this.c = r1;
        }

        public final void a(View r1) {
            BitableShareLinkShareSetView.R5(this.c);
        }
    }

    public static final class d extends t {
        public final /* synthetic */ BitableShareLinkShareSetView c;

        public d(BitableShareLinkShareSetView r1) {
            this.c = r1;
        }

        public final void a(View r1) {
            Function0<Unit> r2 = this.c.i;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    private final BitableSharePermSetInfo getPermSetInfo() {
        BitableSharePermSetInfo r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new BitableSharePermSetInfo(0, null, 63);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mu4.d
    public final void s() {
        if (this.c == false) goto L5;
        return;
    L5:
        setAlpha(0.3f);
        setOnClickListener(new b(this));
    }

    public BitableShareLinkShareSetView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void R5(BitableShareLinkShareSetView r12) {
        r12.getClass();
        HashMap r2 = new HashMap();
        r2.put("token", r12.getPermSetInfo().c);
        r2.put("type", Integer.valueOf(e.r.b));
        r2.put("shareToken", r12.getPermSetInfo().d.getShareToken());
        r2.put("shareType", Integer.valueOf(r12.getPermSetInfo().d.getShareType().getType()));
        r2.put("isConstraintExternal", Boolean.valueOf(r12.getPermSetInfo().d.isConstraintExternal()));
        r2.put("hasAttachmentField", Boolean.valueOf(r12.getPermSetInfo().f.hasAttachmentField()));
        r2.put("hasUserField", Boolean.valueOf(r12.getPermSetInfo().f.hasUserField()));
        AccountService$Account r0 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (((com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6)).c() == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        r2.put("isUserToC", Boolean.valueOf(r1));
        BitableSharePermSetInfo r3 = r12.getPermSetInfo();
        HashMap r4 = new HashMap();
        r4.put("file_id", du5.b.g(r3.c));
        r4.put("file_type", e.f(r3.getType()));
        r4.put("app_form", "none");
        r4.put("module", "");
        r4.put("file_permission", r3.e.b.getReportJson());
        r2.put("statisticParams", r4);
        r2.put("isNewLarkForm", Boolean.valueOf(r12.j));
        r2.put("isFormsNewShareEnable", Boolean.valueOf(com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.base.lark_form_new_share_panel.enable")));
        Bundle r5 = new Bundle();
        if (r12.j == false) goto L20;
        a r6 = r12.k;
        if (r6 == null) goto L30;
        int r7 = BitableFormShareLinkSettingPanelFragment.j;
        String r8 = l0.a().toString();
        Intrinsics.checkNotNullParameter(r2, "templateData");
        Intrinsics.checkNotNullParameter(r8, "shareCtxId");
        Bundle r9 = new Bundle();
        r9.putSerializable("template_data", r2);
        r9.putString("share_ctx_id", r8);
        BitableFormShareLinkSettingPanelFragment r10 = new BitableFormShareLinkSettingPanelFragment();
        r10.setArguments(r9);
        com.bytedance.ee.bear.bitable.share.view.a r11 = new com.bytedance.ee.bear.bitable.share.view.a(r6, r12);
        Intrinsics.checkNotNullParameter(r11, "delegate");
        r10.i = r11;
        FragmentManager r13 = r6.getFragmentManager();
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, "BitableFormShareLinkSettingPanelFragment", r14);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r10, r14) == false) goto L28;
    L18:
        int r16 = f.a;
        f.d(r12.getPermSetInfo().d.getShareType());
        return;
    L28:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L17:
        r10.show(r13, "BitableFormShareLinkSettingPanelFragment");
        goto L18
    L30:
        return;
    L20:
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L22;
    L24:
        de5.a r17 = new de5.a(l0.a().toString(), r2, r5, 20);
    L25:
        ((CCMLynxPageRouter) org.koin.java.a.c(CCMLynxPageRouter.class, null, null, 6)).c(r12.getContext(), 1206, r17);
        int r18 = f.a;
        f.d(r12.getPermSetInfo().d.getShareType());
        return;
    L22:
        if (ForsetiHelper.s(r12.b) == false) goto L24;
        r17 = new de5.a(l0.a().toString(), r2, null, r5, null, r12.b, false, 84);
        goto L25
    L5:
        if (ui5.c.b(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setCanClick(boolean r4) {
        if (r4 == false) goto L5;
        animate().alpha(1.0f).setDuration(150).start();
        setOnClickListener(new c(this));
        return;
    L5:
        animate().alpha(0.3f).setDuration(150).start();
        setOnClickListener(new d(this));
    }

    @Override // mu4.d
    public void setBitableSharePermSetInfo(BitableSharePermSetInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "bitableSharePermSetInfo");
        this.a = r5;
        this.c = true;
        IBitableSharePublicPermission r0 = r5.e.b;
        setCanClick(r5.d.isOpen());
        Function3<? super TextView, ? super ImageView, ? super IBitableSharePublicPermission, Unit> r6 = this.h;
        if (r6 == null) goto L13;
        TextView r1 = this.f;
        ImageView r2 = null;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("linkShareTitle");
        r1 = null;
    L7:
        ImageView r3 = this.g;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("linkShareIcon");
    L11:
        r6.invoke(r1, r2, r0);
        return;
    L10:
        r2 = r3;
        goto L11
    }

    public final void setDelegate(a r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.k = r2;
    }

    @Override // mu4.d
    public void setEnable(boolean r2) {
        if (this.c == true) goto L5;
        return;
    L5:
        setCanClick(r2);
    }

    public final void setIsNewLarkForm(boolean r1) {
        this.j = r1;
    }

    public final void setUIDelegate(Function3<? super TextView, ? super ImageView, ? super IBitableSharePublicPermission, Unit> r1) {
        this.h = r1;
    }

    public final void setUnableClickListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "unableClickListener");
        this.i = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BitableShareLinkShareSetView(Context r4, Fragment r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r4, "context");
        View r0 = null;
        super(r4, null, 0);
        setAlpha(0.3f);
        View r6 = LayoutInflater.from(r4).inflate(2131564186, this);
        this.d = r6.findViewById(2131377958);
        this.e = r6.findViewById(2131377957);
        this.f = (TextView) r6.findViewById(2131377960);
        this.g = (ImageView) r6.findViewById(2131377956);
        View r7 = this.d;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkShareSubTitle");
        r7 = null;
    L5:
        r7.setVisibility(8);
        View r8 = this.e;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("linkShareMore");
    L9:
        r0.setVisibility(0);
        this.b = r5;
        return;
    L8:
        r0 = r8;
        goto L9
    }
}
