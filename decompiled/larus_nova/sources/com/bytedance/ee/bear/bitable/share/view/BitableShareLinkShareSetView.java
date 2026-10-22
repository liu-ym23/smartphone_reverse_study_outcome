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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mu4.f;
import sbb.e;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001AB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0005\u0010\fB-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u0005\u0010\u000fJ\u0010\u0010'\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002JU\u0010(\u001a\u00020#2M\u0010\u001b\u001aI\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010\u001cJ\u0014\u0010)\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0%J\u000e\u0010*\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0013J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0011H\u0016J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0013H\u0016J\b\u0010/\u001a\u00020#H\u0016J\b\u00100\u001a\u00020#H\u0002J\u000e\u00103\u001a\u00020#2\u0006\u00104\u001a\u000202J,\u00105\u001a\u001e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806j\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208`92\u0006\u0010:\u001a\u00020\u0011H\u0002J\b\u0010;\u001a\u00020\u0013H\u0002J\b\u0010<\u001a\u00020\u0011H\u0002J\u0018\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020!2\u0006\u0010.\u001a\u00020\u0013H\u0002J\u0010\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020\u0013H\u0002R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000RU\u0010\u001b\u001aI\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/view/BitableShareLinkShareSetView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ee/bear/bitable/share/IBitableSharePermSetInfo;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sourceFragment", "Landroidx/fragment/app/Fragment;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;I)V", "mBitableSharePermSetInfo", "Lcom/bytedance/ee/bear/bitable/share/BitableSharePermSetInfo;", "hasPullPermission", "", "linkShareSubTitle", "Landroid/view/View;", "linkShareMore", "linkShareTitle", "Landroid/widget/TextView;", "linkShareIcon", "Landroid/widget/ImageView;", "updateUIDelegate", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "linkTitle", "linkIcon", "Lcom/bytedance/ee/bear/bitable/share/permission/IBitableSharePublicPermission;", "bitablePermission", "", "unableClickListener", "Lkotlin/Function0;", "isNewLarkForm", "init", "setUIDelegate", "setUnableClickListener", "setIsNewLarkForm", "setBitableSharePermSetInfo", "bitableSharePermSetInfo", "setEnable", "enable", "failToFetchPerm", "onClickView", "delegateImpl", "Lcom/bytedance/ee/bear/bitable/share/view/BitableShareLinkShareSetView$Delegate;", "setDelegate", "delegate", "addReportParameters", "Ljava/util/HashMap;", "", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "permSetInfo", "removeOrg", "getPermSetInfo", "updateUI", "publicPermission", "setCanClick", "clickable", "Delegate", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShareLinkShareSetView extends ConstraintLayout implements mu4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BitableSharePermSetInfo f215474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f215475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f215476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f215477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f215478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f215479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f215480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function3<? super TextView, ? super ImageView, ? super IBitableSharePublicPermission, Unit> f215481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f215482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f215483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f215484k;

    public interface a {
        void a();

        k b();

        FragmentManager getFragmentManager();
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableShareLinkShareSetView f215485c;

        public b(BitableShareLinkShareSetView r100) {
            this.f215485c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Toast.showFailureText(this.f215485c.getContext(), this.f215485c.getContext().getString(R.string.Doc_Wiki_SeverError));
        }
    }

    public static final class c extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableShareLinkShareSetView f215486c;

        public c(BitableShareLinkShareSetView r100) {
            this.f215486c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            BitableShareLinkShareSetView.R5(this.f215486c);
        }
    }

    public static final class d extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableShareLinkShareSetView f215487c;

        public d(BitableShareLinkShareSetView r100) {
            this.f215487c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Function0<Unit> r101 = this.f215487c.f215482i;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    private final BitableSharePermSetInfo getPermSetInfo() {
        BitableSharePermSetInfo r100 = this.f215474a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new BitableSharePermSetInfo(0, null, 63);
    }

    @Override // mu4.d
    public final void s() {
        if (this.f215476c == false) goto L5;
        return;
    L5:
        setAlpha(0.3f);
        setOnClickListener(new b(this));
    }

    public BitableShareLinkShareSetView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final void R5(BitableShareLinkShareSetView r110) {
        r110.getClass();
        HashMap r100 = new HashMap();
        r100.put("token", r110.getPermSetInfo().f215307c);
        r100.put("type", Integer.valueOf(e.f541307r.f541317b));
        r100.put("shareToken", r110.getPermSetInfo().f215308d.getShareToken());
        r100.put("shareType", Integer.valueOf(r110.getPermSetInfo().f215308d.getShareType().getType()));
        r100.put("isConstraintExternal", Boolean.valueOf(r110.getPermSetInfo().f215308d.isConstraintExternal()));
        r100.put("hasAttachmentField", Boolean.valueOf(r110.getPermSetInfo().f215310f.hasAttachmentField()));
        r100.put("hasUserField", Boolean.valueOf(r110.getPermSetInfo().f215310f.hasUserField()));
        AccountService$Account r101 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (((com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6)).c() == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        r100.put("isUserToC", Boolean.valueOf(r102));
        BitableSharePermSetInfo r103 = r110.getPermSetInfo();
        HashMap r104 = new HashMap();
        r104.put("file_id", du5.b.g(r103.f215307c));
        r104.put("file_type", e.f(r103.getType()));
        r104.put("app_form", "none");
        r104.put(EventConstant.Key.MODULE, "");
        r104.put("file_permission", r103.f215309e.f215333b.getReportJson());
        r100.put("statisticParams", r104);
        r100.put("isNewLarkForm", Boolean.valueOf(r110.f215483j));
        r100.put("isFormsNewShareEnable", Boolean.valueOf(com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.base.lark_form_new_share_panel.enable")));
        Bundle r105 = new Bundle();
        if (r110.f215483j == false) goto L20;
        a r106 = r110.f215484k;
        if (r106 == null) goto L30;
        int r107 = BitableFormShareLinkSettingPanelFragment.f215334j;
        String r108 = l0.a().toString();
        Intrinsics.checkNotNullParameter(r100, "templateData");
        Intrinsics.checkNotNullParameter(r108, "shareCtxId");
        Bundle r109 = new Bundle();
        r109.putSerializable("template_data", r100);
        r109.putString("share_ctx_id", r108);
        BitableFormShareLinkSettingPanelFragment r111 = new BitableFormShareLinkSettingPanelFragment();
        r111.setArguments(r109);
        com.bytedance.ee.bear.bitable.share.view.a r112 = new com.bytedance.ee.bear.bitable.share.view.a(r106, r110);
        Intrinsics.checkNotNullParameter(r112, "delegate");
        r111.f215336i = r112;
        FragmentManager r113 = r106.getFragmentManager();
        LandscapeRestrictionOperation r114 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r111, "BitableFormShareLinkSettingPanelFragment", r114);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r113, r111, r114) == false) goto L28;
    L18:
        int r115 = f.f515752a;
        f.d(r110.getPermSetInfo().f215308d.getShareType());
        return;
    L28:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L17:
        r111.show(r113, "BitableFormShareLinkSettingPanelFragment");
        goto L18
    L30:
        return;
    L20:
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L22;
    L24:
        de5.a r116 = new de5.a(l0.a().toString(), r100, r105, 20);
    L25:
        ((CCMLynxPageRouter) org.koin.java.a.c(CCMLynxPageRouter.class, null, null, 6)).c(r110.getContext(), 1206, r116);
        int r117 = f.f515752a;
        f.d(r110.getPermSetInfo().f215308d.getShareType());
        return;
    L22:
        if (ForsetiHelper.s(r110.f215475b) == false) goto L24;
        r116 = new de5.a(l0.a().toString(), r100, null, r105, null, r110.f215475b, false, 84);
        goto L25
    L5:
        if (ui5.c.b(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    private final void setCanClick(boolean r100) {
        if (r100 == false) goto L5;
        animate().alpha(1.0f).setDuration(150).start();
        setOnClickListener(new c(this));
        return;
    L5:
        animate().alpha(0.3f).setDuration(150).start();
        setOnClickListener(new d(this));
    }

    @Override // mu4.d
    public void setBitableSharePermSetInfo(BitableSharePermSetInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "bitableSharePermSetInfo");
        this.f215474a = r100;
        this.f215476c = true;
        IBitableSharePublicPermission r101 = r100.f215309e.f215333b;
        setCanClick(r100.f215308d.isOpen());
        Function3<? super TextView, ? super ImageView, ? super IBitableSharePublicPermission, Unit> r102 = this.f215481h;
        if (r102 == null) goto L13;
        TextView r103 = this.f215479f;
        ImageView r104 = null;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("linkShareTitle");
        r103 = null;
    L7:
        ImageView r105 = this.f215480g;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("linkShareIcon");
    L11:
        r102.invoke(r103, r104, r101);
        return;
    L10:
        r104 = r105;
        goto L11
    }

    public final void setDelegate(a r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f215484k = r100;
    }

    @Override // mu4.d
    public void setEnable(boolean r100) {
        if (this.f215476c == true) goto L5;
        return;
    L5:
        setCanClick(r100);
    }

    public final void setIsNewLarkForm(boolean r100) {
        this.f215483j = r100;
    }

    public final void setUIDelegate(Function3<? super TextView, ? super ImageView, ? super IBitableSharePublicPermission, Unit> r100) {
        this.f215481h = r100;
    }

    public final void setUnableClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "unableClickListener");
        this.f215482i = r100;
    }

    public BitableShareLinkShareSetView(Context r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = null;
        super(r100, null, 0);
        setAlpha(0.3f);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.permission_link_share_layout, this);
        this.f215477d = r103.findViewById(R.id.linkShareSubTitle);
        this.f215478e = r103.findViewById(R.id.linkShareMore);
        this.f215479f = (TextView) r103.findViewById(R.id.linkShareTitle);
        this.f215480g = (ImageView) r103.findViewById(R.id.linkShareIcon);
        View r104 = this.f215477d;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkShareSubTitle");
        r104 = null;
    L5:
        r104.setVisibility(8);
        View r105 = this.f215478e;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("linkShareMore");
    L9:
        r102.setVisibility(0);
        this.f215475b = r101;
        return;
    L8:
        r102 = r105;
        goto L9
    }
}
