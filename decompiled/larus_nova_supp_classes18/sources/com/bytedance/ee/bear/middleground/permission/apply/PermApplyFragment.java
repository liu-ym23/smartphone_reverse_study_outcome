package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import io.reactivex.disposables.CompositeDisposable;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0016J\u0012\u0010>\u001a\u00020*2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020*H\u0016J\b\u0010B\u001a\u00020*H\u0016J\b\u0010C\u001a\u00020*H\u0002J&\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010J\u001a\u00020*H\u0016J\b\u0010K\u001a\u00020*H\u0002J\u001a\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020E2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010N\u001a\u00020*H\u0016J\u0010\u0010O\u001a\u00020*2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020*H\u0002J\b\u0010S\u001a\u00020*H\u0002J\b\u0010T\u001a\u00020*H\u0002J\b\u0010U\u001a\u00020*H\u0002J\u0012\u0010V\u001a\u00020*2\b\u0010W\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010X\u001a\u00020*2\b\u0010Y\u001a\u0004\u0018\u00010=H\u0016J\n\u0010Z\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010[\u001a\u00020*2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0004\u0018\u00010$8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010,\u001a\u00020-X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00102\u001a\u0002038DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b4\u00105R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/PermApplyFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "<init>", "()V", "permissionTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getPermissionTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setPermissionTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "noDataEmptyStateFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getNoDataEmptyStateFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setNoDataEmptyStateFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "permissionTypeFromXml", "Landroid/widget/TextView;", "getPermissionTypeFromXml", "()Landroid/widget/TextView;", "setPermissionTypeFromXml", "(Landroid/widget/TextView;)V", "sendRequestFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getSendRequestFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setSendRequestFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "permissionTypeChooseFromXml", "Landroid/widget/LinearLayout;", "getPermissionTypeChooseFromXml", "()Landroid/widget/LinearLayout;", "setPermissionTypeChooseFromXml", "(Landroid/widget/LinearLayout;)V", "editOptionalFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getEditOptionalFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setEditOptionalFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "clearFromXmlViewCache", "", "onDestroyView", "params", "Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "getParams", "()Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "setParams", "(Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;)V", "viewModel", "Lcom/bytedance/ee/bear/middleground/permission/apply/PermApplyViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/middleground/permission/apply/PermApplyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "customBackDrawable", "Landroid/graphics/drawable/Drawable;", "customBackListener", "Landroid/view/View$OnClickListener;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "parseArgs", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "bindView", "handleSpanClick", "onViewCreated", "view", "onDestroy", "handleLoading", "loading", "", "bindListener", "showActionSheet", "saveSoftInputMode", "revertSoftInputMode", "setBackIcon", "drawable", "setBackListener", "listener", "getTitleBar", "setViewVisibleListener", "visibleListener", "Lcom/bytedance/ee/permission/view/IViewVisibleListener;", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PermApplyFragment extends BaseFragment implements au5.a {
    public static final /* synthetic */ int q = 0;
    public BaseTitleBar e;
    public SpaceEmptyState f;
    public TextView g;
    public UDButton h;
    public LinearLayout i;
    public SpaceEditText j;
    public NoPermission k;
    public final Lazy l;
    public final CompositeDisposable m;
    public Drawable n;
    public View.OnClickListener o;
    public au5.b p;

    public static final class a {
    }

    public static final class b extends ClickableSpan {
        public final /* synthetic */ PermApplyFragment a;

        public b(PermApplyFragment r1) {
            this.a = r1;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "widget");
            if (TextUtils.isEmpty(this.a.W90().getOwnerId()) == true) goto L6;
            ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6)).e(this.a.W90().getOwnerId(), "");
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            r2.setUnderlineText(false);
        }
    }

    static {
    }

    public final /* synthetic */ View NW() {
        return null;
    }

    public final SpaceEmptyState V90() {
        UDEmptyState r0 = this.f;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131380922);
    L8:
        this.f = (SpaceEmptyState) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (SpaceEmptyState) r0;
    }

    public final NoPermission W90() {
        NoPermission r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return null;
    }

    public final BaseTitleBar X90() {
        View r0 = this.e;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131382173);
    L8:
        this.e = (BaseTitleBar) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (BaseTitleBar) r0;
    }

    public final UDButton Y90() {
        View r0 = this.h;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131385928);
    L8:
        this.h = (UDButton) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (UDButton) r0;
    }

    public final PermApplyViewModel Z90() {
        return (PermApplyViewModel) this.l.getValue();
    }

    public PermApplyFragment() {
        this.l = LazyKt.lazy(new PermApplyFragment$viewModel$2(this));
        this.m = new CompositeDisposable();
    }

    public final void aa0() {
        if (Z90().getOwnerText().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        SpannableString r1 = new SpannableString(Z90().getOwnerText());
        int r2 = StringsKt.indexOf$default(Z90().getOwnerText(), Z90().getOwnerStr(), 0, false, 6, null);
        int r3 = Z90().getOwnerStr().length() + r2;
        if (r2 < r3) goto L10;
        return;
    L10:
        if (r1.length() < r3) goto L17;
        if (r2 < 0) goto L18;
        r1.setSpan(new b(this), r2, r3, 33);
        V90().setDesc(r1);
        return;
    L18:
        return;
    L17:
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final View getTitleBar() {
        return X90();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.m.dispose();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        Intent r1 = r0.getIntent();
        if (r1 == null) goto L7;
        int r2 = r1.getIntExtra("softInputMode", -1);
    L8:
        if (r2 == (-1)) goto L15;
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L16;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L17;
        r4.setSoftInputMode(r2);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r2 = -1;
        goto L8
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        FragmentActivity r0 = getActivity();
        int r1 = -1;
        if (r0 == null) goto L7;
        Intent r2 = r0.getIntent();
        if (r2 == null) goto L7;
        int r3 = r2.getIntExtra("softInputMode", -1);
    L8:
        if (r3 != (-1)) goto L21;
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L16;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L16;
        WindowManager.LayoutParams r6 = r5.getAttributes();
        if (r6 == null) goto L16;
        r1 = r6.softInputMode;
    L16:
        FragmentActivity r7 = getActivity();
        if (r7 == null) goto L21;
        Intent r8 = r7.getIntent();
        if (r8 == null) goto L21;
        r8.putExtra("softInputMode", r1);
    L21:
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L27;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L28;
        r10.setSoftInputMode(16);
        return;
    L28:
        return;
    L27:
        return;
    L7:
        r3 = -1;
        goto L8
    }

    public final void mY(au5.b r1) {
        this.p = r1;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Serializable r3 = requireArguments().getSerializable("Params");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.apply.NoPermission");
        NoPermission r4 = (NoPermission) r3;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.k = r4;
    }

    public final void setBackIcon(Drawable r1) {
        this.n = r1;
    }

    public final void setBackListener(View.OnClickListener r1) {
        this.o = r1;
    }

    public static final void U90(final PermApplyFragment r2, boolean r3) {
        if (r2.Y90() == null) goto L10;
        if (r3 == false) goto L7;
        com.larksuite.component.universe_design.button.e.h(r2.Y90(), new PermApplyFragment$handleLoading$1(r2));
        r2.Y90().setTextColor(UDColorUtils.getColor(r2.requireContext(), 2131109013));
        r2.Y90().setBackgroundColor(UDColorUtils.getColor(r2.requireContext(), 2131105550));
        return;
    L7:
        com.larksuite.component.universe_design.button.e.c(r2.Y90(), 2131888124);
        r2.Y90().setTextColor(UDColorUtils.getColor(r2.requireContext(), 2131106521));
        r2.Y90().setBackgroundColor(UDColorUtils.getColor(r2.requireContext(), 2131105548));
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        X90().setDividerVisible(false);
        X90().setLeftIconVisibility(W90().getBackVisible());
        if (W90().getFromDocXInBase() == false) goto L5;
        X90().setVisibility(8);
    L5:
        float r12 = (getResources().getDimension(2131169381) * 2) + getResources().getDimension(2131168380);
        ViewGroup.LayoutParams r0 = V90().getLayoutParams();
        r0.width = (int) r12;
        V90().setLayoutParams(r0);
        V90().setTitle(Z90().getTipsText());
        V90().setDesc(Z90().getOwnerText());
        aa0();     // Catch: Throwable -> L8
    L11:
        if (this.n == null) goto L15;
        ImageView r13 = X90().getLeftImage();
        if (r13 == null) goto L15;
        r13.setImageDrawable(this.n);
    L15:
        Z90().getPermType().observe(getViewLifecycleOwner(), new e1(this));
        if (X90().isAttachedToWindow() == false) goto L20;
        tt5.a.h("PermApplyFragment", "permission_title_bar isAttachedToWindow");
        au5.b r14 = this.p;
        if (r14 == null) goto L20;
        r14.a(true);
    L20:
        X90().addOnAttachStateChangeListener(new f1(this));
        if (this.o == null) goto L23;
        X90().setLeftClickListener(this.o);
    L24:
        View r15 = this.i;
        if (r15 != null) goto L31;
        View r16 = getView();
        if (r16 == null) goto L29;
        r15 = r16.findViewById(2131382178);
    L30:
        this.i = (LinearLayout) r15;
        goto L31
    L29:
        r15 = null;
    L31:
        ((LinearLayout) r15).setOnClickListener(new c1(this));
        Y90().setOnClickListener(new d1(this));
        int r1 = sbb.e.g(W90().getDocumentType());
        com.bytedance.ee.bear.route.h r17 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        String r18 = W90().getOriginalBearUrlToken();
        if (r18 == null) goto L34;
        r17.N9(r18, requireContext().getResources().getString(2131888095));
    L34:
        com.bytedance.ee.bear.middleground.permission.c.z(W90().getToken(), r1, W90().getSubType(), W90().getFromVc(), W90().isWiki(), W90().getModule(), W90().getUserPerm(), W90().getPublicPerm(), "apply_permission");
        return;
    L23:
        X90().setLeftClickListener(new b1(this));
    L8:
        th = move-exception;
        tt5.a.f("", th, false);
        iu5.d.a("", th);
        goto L11
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564177, r3, false);
    }
}
