package com.bytedance.ee.bear.bitable.pro.applypro;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.bitable.pro.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.edittext.UDTextInputLayout;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.disposables.CompositeDisposable;
import ju4.e;
import ju4.f;
import ju4.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import s45.g;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0011\u0018\u0000 i2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001iB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000201H\u0016J\u0012\u0010C\u001a\u0002012\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010F\u001a\u000201H\u0002J&\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u001a\u0010M\u001a\u0002012\u0006\u0010N\u001a\u00020H2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010O\u001a\u000201H\u0016J\b\u0010P\u001a\u000201H\u0016J\b\u0010Q\u001a\u000201H\u0002J\u0010\u0010R\u001a\u0002012\u0006\u0010S\u001a\u000208H\u0002J\b\u0010T\u001a\u000201H\u0002J\u0010\u0010U\u001a\u0002012\u0006\u0010V\u001a\u00020WH\u0002J\u0018\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020W2\u0006\u0010[\u001a\u000204H\u0002J\u0006\u0010\\\u001a\u00020YJ\b\u0010]\u001a\u000208H\u0016J\u0012\u0010^\u001a\u0002012\b\u0010_\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010`\u001a\u0002012\b\u0010a\u001a\u0004\u0018\u00010@H\u0016J\n\u0010b\u001a\u0004\u0018\u00010HH\u0016J\u0012\u0010c\u001a\u0002012\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010d\u001a\u0002012\u0006\u0010e\u001a\u00020\u0007H\u0002J\b\u0010f\u001a\u000201H\u0016J\b\u0010g\u001a\u000201H\u0002J\b\u0010h\u001a\u000201H\u0002R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0004\u0018\u00010%8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010+8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "<init>", "()V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "emptyStateFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getEmptyStateFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setEmptyStateFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "applyProFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getApplyProFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setApplyProFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "inputNoteFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getInputNoteFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setInputNoteFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "inputTipsFromXml", "Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;", "getInputTipsFromXml", "()Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;", "setInputTipsFromXml", "(Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;)V", "useProTipsFromXml", "Landroid/widget/TextView;", "getUseProTipsFromXml", "()Landroid/widget/TextView;", "setUseProTipsFromXml", "(Landroid/widget/TextView;)V", "applyPermissionLayoutFromXml", "Landroid/widget/LinearLayout;", "getApplyPermissionLayoutFromXml", "()Landroid/widget/LinearLayout;", "setApplyPermissionLayoutFromXml", "(Landroid/widget/LinearLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "ownerName", "", "ownerId", "token", "skipHostSoftInputModeChange", "", "fetcher", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProFetcher;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "customBackDrawable", "Landroid/graphics/drawable/Drawable;", "customBackListener", "Landroid/view/View$OnClickListener;", "visibleListener", "Lcom/bytedance/ee/permission/view/IViewVisibleListener;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "parseArguments", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "initView", "updateApplyLayoutVisibility", "visible", ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "showToast", "errCode", "", "getDesc", "", "resId", "userKey", "getProDesc", "onBackPressed", "setBackIcon", "drawable", "setBackListener", "listener", "getTitleBar", "setViewVisibleListener", "bindVisibleListener", "titleBar", LiveCommonConstants.REASON_ON_DEDTROY, "saveSoftInputMode", "revertSoftInputMode", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableApplyProFragment extends BaseFragment implements l, au5.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f215126u = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f215127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SpaceEmptyState f215128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDButton f215129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SpaceEditText f215130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public UDTextInputLayout f215131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f215132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f215133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f215134l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f215135m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f215136n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f215137o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public BitableApplyProFetcher f215138p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CompositeDisposable f215139q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f215140r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View.OnClickListener f215141s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public au5.b f215142t;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableApplyProFragment f215143a;

        public b(BitableApplyProFragment r100) {
            this.f215143a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f215143a.f215135m.length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L9;
            ((k) org.koin.java.a.c(k.class, null, null, 6)).e(this.f215143a.f215135m, "");
            int r102 = d.f215166a;
            JSONObject r103 = new JSONObject();
            r103.put("click", "owner_name");
            r103.put(PickerReporterConstants.KEY.TARGET, "none");
            d.b("ccm_bitable_premium_permission_application_click", r103);
            return;
        L9:
            return;
        L5:
            r101 = false;
            goto L6
        }
    }

    static {
    }

    @Override // au5.a
    public final /* synthetic */ View NW() {
        return null;
    }

    public final SpaceEditText X90() {
        View r100 = this.f215130h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.input_note);
    L8:
        this.f215130h = (SpaceEditText) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (SpaceEditText) r100;
    }

    public final BaseTitleBar Y90() {
        View r100 = this.f215127e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.title_bar);
    L8:
        this.f215127e = (BaseTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (BaseTitleBar) r100;
    }

    public final TextView Z90() {
        View r100 = this.f215132j;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.use_pro_tips);
    L8:
        this.f215132j = (TextView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (TextView) r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        int r100 = c.f207079a;
        int r101 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.apply_pro_back_press_fix_enable") == false) goto L6;
        return false;
    L6:
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L11;
        r102.finish();
        return true;
    L11:
        return true;
    }

    public BitableApplyProFragment() {
        this.f215134l = "";
        this.f215135m = "";
        this.f215136n = "";
        this.f215139q = new CompositeDisposable();
    }

    @Override // au5.a
    public final View getTitleBar() {
        return Y90();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f215139q.dispose();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f215127e = null;
        this.f215128f = null;
        this.f215129g = null;
        this.f215130h = null;
        this.f215131i = null;
        this.f215132j = null;
        this.f215133k = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.f215137o == false) goto L5;
        this.f215137o = false;
        return;
    L5:
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L10;
        Intent r101 = r100.getIntent();
        if (r101 == null) goto L10;
        int r102 = r101.getIntExtra("softInputMode", -1);
    L11:
        if (r102 == (-1)) goto L19;
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L20;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L21;
        r104.setSoftInputMode(r102);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r102 = -1;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        boolean r100 = ForsetiHelper.x(this);
        this.f215137o = r100;
        if (r100 == true) goto L32;
        FragmentActivity r101 = getActivity();
        int r102 = -1;
        if (r101 == null) goto L10;
        Intent r103 = r101.getIntent();
        if (r103 == null) goto L10;
        int r104 = r103.getIntExtra("softInputMode", -1);
    L11:
        if (r104 != (-1)) goto L24;
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L19;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L19;
        WindowManager.LayoutParams r107 = r106.getAttributes();
        if (r107 == null) goto L19;
        r102 = r107.softInputMode;
    L19:
        FragmentActivity r108 = getActivity();
        if (r108 == null) goto L24;
        Intent r109 = r108.getIntent();
        if (r109 == null) goto L24;
        r109.putExtra("softInputMode", r102);
    L24:
        FragmentActivity r110 = getActivity();
        if (r110 == null) goto L30;
        Window r111 = r110.getWindow();
        if (r111 == null) goto L31;
        r111.setSoftInputMode(32);
        return;
    L31:
        return;
    L30:
        return;
    L10:
        r104 = -1;
        goto L11
    }

    @Override // au5.a
    public final void mY(au5.b r100) {
        this.f215142t = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        String r102 = "";
        if (r101 == null) goto L6;
        String r103 = r101.getString("owner_name", "");
        if (r103 == null) goto L6;
    L7:
        this.f215134l = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L11;
        String r105 = r104.getString("owner_id", "");
        if (r105 == null) goto L11;
    L12:
        this.f215135m = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L18;
        String r107 = r106.getString("token", "");
        if (r107 == null) goto L18;
        r102 = r107;
    L18:
        this.f215136n = r102;
        this.f215138p = new BitableApplyProFetcher(this.f215136n);
        return;
    L11:
        r105 = "";
    L6:
        r103 = "";
        goto L7
    }

    @Override // au5.a
    public final void setBackIcon(Drawable r100) {
        this.f215140r = r100;
        if (r100 == null) goto L10;
        BaseTitleBar r101 = Y90();
        if (r101 == null) goto L11;
        ImageView r102 = r101.getLeftImage();
        if (r102 == null) goto L12;
        r102.setImageDrawable(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // au5.a
    public final void setBackListener(View.OnClickListener r100) {
        this.f215141s = r100;
        BaseTitleBar r101 = Y90();
        if (r101 == null) goto L6;
        r101.setLeftClickListener(r100);
        return;
    }

    public static final void U90(BitableApplyProFragment r100, int r101) {
        Context r102 = r100.getContext();
        if (r102 != null) goto L5;
        tt5.a.d("BitableApplyProFragment", "context is null");
        return;
    L5:
        if (r101 != 0) goto L7;
        int r103 = R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_ApplySent_Toast;
    L14:
        if (r101 != 0) goto L16;
        int r104 = R.drawable.ud_icon_yes_outlined;
    L17:
        UDToast.show(r102, r103, r104);
        return;
    L16:
        r104 = R.drawable.ud_icon_more_close_outlined;
        goto L17
    L7:
        if (r101 != 800004006) goto L9;
        r103 = R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_ApplySentFailed_NotesContainSensitiveInfo_Toast;
        goto L14
    L9:
        if (r101 == 800004106) goto L11;
        r103 = R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_ApplySentFailed_Toast;
        goto L14
    L11:
        r103 = R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_ApplySentFailed_AlreadyHavePerm_Toast;
        goto L14
    }

    public static final void V90(BitableApplyProFragment r100, boolean r101) {
        View r102 = r100.f215133k;
        View r103 = null;
        if (r102 != null) goto L9;
        View r104 = r100.getView();
        if (r104 == null) goto L7;
        r102 = r104.findViewById(R.id.apply_permission_layout);
    L8:
        r100.f215133k = (LinearLayout) r102;
        goto L9
    L7:
        r102 = null;
    L9:
        LinearLayout r105 = (LinearLayout) r102;
        if (r101 == false) goto L12;
        int r106 = 0;
    L13:
        r105.setVisibility(r106);
        if (r101 == false) goto L16;
        CharSequence r107 = r100.W90(R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_Description, "userName");
    L17:
        View r108 = r100.f215128f;
        if (r108 != null) goto L23;
        View r109 = r100.getView();
        if (r109 == null) goto L22;
        r103 = r109.findViewById(R.id.empty_state);
    L22:
        r100.f215128f = (SpaceEmptyState) r103;
        r108 = r103;
    L23:
        ((SpaceEmptyState) r108).setDesc(r107);
        return;
    L16:
        r107 = r100.W90(R.string.Bitable_AdvancedPermissions_NoPermissionToAccess_Desc, "name");
        goto L17
    L12:
        r106 = 8;
        goto L13
    }

    public final CharSequence W90(int r100, String r101) {
        String r102 = this.f215134l;
        String r103 = xo5.a.c(getContext(), r100, r101, r102);
        if (r102.length() <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L13;
        SpannableStringBuilder r105 = new SpannableStringBuilder();
        r105.append(r103);
        Intrinsics.checkNotNull(r103);
        int r106 = StringsKt.indexOf$default(r103, r102, 0, false, 6, null);
        int r107 = r102.length() + r106;
        if (r106 < 0) goto L13;
        if (r107 > r103.length()) goto L13;
        r105.setSpan(new UDEmptyState.b(new b(this)), r106, r107, 34);
        return r105;
    L13:
        Intrinsics.checkNotNull(r103);
        return r103;
    L5:
        r104 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        BitableApplyProFetcher r112 = this.f215138p;
        if (r112 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fetcher");
        r112 = null;
    L5:
        this.f215139q.add(r112.b().subscribe(new com.bytedance.ee.bear.bitable.pro.applypro.a(this), new h(this)));
        boolean r100 = false;
        Y90().setDividerVisible(false);
        BaseTitleBar r113 = Y90();
        Drawable r101 = this.f215140r;
        if (r101 == null) goto L10;
        ImageView r102 = r113.getLeftImage();
        if (r102 == null) goto L10;
        r102.setImageDrawable(r101);
    L10:
        View.OnClickListener r103 = this.f215141s;
        if (r103 != null) goto L13;
        r103 = new ju4.d(this);
    L13:
        r113.setLeftClickListener(r103);
        if (r113.isAttachedToWindow() == false) goto L18;
        au5.b r104 = this.f215142t;
        if (r104 == null) goto L18;
        r104.a(true);
    L18:
        r113.addOnAttachStateChangeListener(new ju4.a(this, r113));
        View r114 = this.f215128f;
        if (r114 != null) goto L25;
        View r115 = getView();
        if (r115 == null) goto L23;
        r114 = r115.findViewById(R.id.empty_state);
    L24:
        this.f215128f = (SpaceEmptyState) r114;
        goto L25
    L23:
        r114 = null;
    L25:
        ((SpaceEmptyState) r114).setDesc(W90(R.string.Bitable_AdvancedPermission_NoPermToAccessBitable_Description, "userName"));
        View r116 = this.f215129g;
        if (r116 != null) goto L32;
        View r117 = getView();
        if (r117 == null) goto L30;
        r116 = r117.findViewById(R.id.apply_pro);
    L31:
        this.f215129g = (UDButton) r116;
        goto L32
    L30:
        r116 = null;
    L32:
        ((UDButton) r116).setOnClickListener(new e(this));
        X90().setOnFocusChangeListener(f.f500488a);
        X90().addTextChangedListener(new ju4.c(this));
        int r118 = com.bytedance.ee.bear.bitable.pro.e.f215169a;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.advanced_permission.role_inheritance") == false) goto L50;
        Z90().setVisibility(0);
        TextView r119 = Z90();
        Context r105 = getContext();
        if (r105 == null) goto L38;
        String r106 = r105.getString(R.string.Bitable_AdvancedPermissionsInherit_RequestCard_HowToAssign_Link);
        if (r106 == null) goto L38;
    L39:
        String r107 = xo5.a.c(getContext(), R.string.Bitable_AdvancedPermissionsInherit_RequestCard_ViewDoc_Desc, "docName", r106);
        s45.h r108 = g.f540568a;
        String r120 = g.a.b("173353144094", "067313445121", null);
        if (r106.length() <= 0) goto L42;
        r100 = true;
    L42:
        if (r100 == false) goto L48;
        SpannableStringBuilder r109 = new SpannableStringBuilder();
        r109.append(r107);
        Intrinsics.checkNotNull(r107);
        int r121 = StringsKt.indexOf$default(r107, r106, 0, false, 6, null);
        int r122 = r106.length() + r121;
        if (r121 < 0) goto L48;
        if (r122 > r107.length()) goto L48;
        r109.setSpan(new UDEmptyState.b(new ju4.b(r120)), r121, r122, 34);
        CharSequence r123 = r109;
    L49:
        r119.setText(r123);
        Z90().setMovementMethod(LinkMovementMethod.getInstance());
    L48:
        Intrinsics.checkNotNull(r107);
        r123 = r107;
    L38:
        r106 = "";
    L50:
        View r124 = getView();
        if (r124 == null) goto L53;
        r124.setOnClickListener(new ju4.g(this));
    L53:
        int r125 = d.f215166a;
        d.b("ccm_bitable_premium_permission_application_view", new JSONObject());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.bitable_apply_pro_fragment, r101, false);
    }
}
