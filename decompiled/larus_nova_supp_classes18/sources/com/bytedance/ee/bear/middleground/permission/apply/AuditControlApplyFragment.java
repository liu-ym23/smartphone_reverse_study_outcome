package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import io.reactivex.disposables.CompositeDisposable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001SB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0016J\u0012\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020$H\u0016J\b\u00108\u001a\u00020$H\u0016J\b\u00109\u001a\u00020$H\u0002J&\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010@\u001a\u00020$H\u0016J\u001a\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020;2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010C\u001a\u00020$H\u0016J\u0010\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020$2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010H\u001a\u00020$H\u0002J\b\u0010I\u001a\u00020$H\u0002J\b\u0010J\u001a\u00020$H\u0002J\u0012\u0010K\u001a\u00020$2\b\u0010L\u001a\u0004\u0018\u00010/H\u0016J\u0012\u0010M\u001a\u00020$2\b\u0010N\u001a\u0004\u0018\u000101H\u0016J\n\u0010O\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010P\u001a\u00020$2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010&\u001a\u00020'X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/AuditControlApplyFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "<init>", "()V", "permissionTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getPermissionTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setPermissionTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "editOptionalFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getEditOptionalFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setEditOptionalFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "noDataEmptyStateFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getNoDataEmptyStateFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setNoDataEmptyStateFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "sendRequestFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getSendRequestFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setSendRequestFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "permissionTypeChooseFromXml", "Landroid/widget/LinearLayout;", "getPermissionTypeChooseFromXml", "()Landroid/widget/LinearLayout;", "setPermissionTypeChooseFromXml", "(Landroid/widget/LinearLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "params", "Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "getParams", "()Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "setParams", "(Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "customBackDrawable", "Landroid/graphics/drawable/Drawable;", "customBackListener", "Landroid/view/View$OnClickListener;", "fetcher", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyAuditEscapeFetcher;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "parseArgs", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "bindView", "onViewCreated", "view", "onDestroy", "handleLoading", "loading", "", "handleLoadingInner", "bindListener", "saveSoftInputMode", "revertSoftInputMode", "setBackIcon", "drawable", "setBackListener", "listener", "getTitleBar", "setViewVisibleListener", "visibleListener", "Lcom/bytedance/ee/permission/view/IViewVisibleListener;", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AuditControlApplyFragment extends BaseFragment implements au5.a {
    public static final /* synthetic */ int p = 0;
    public BaseTitleBar e;
    public SpaceEditText f;
    public SpaceEmptyState g;
    public UDButton h;
    public LinearLayout i;
    public NoPermission j;
    public final CompositeDisposable k;
    public Drawable l;
    public View.OnClickListener m;
    public final com.bytedance.ee.bear.middleground.permission.apply.a n;
    public au5.b o;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ View NW() {
        return null;
    }

    public final SpaceEditText U90() {
        UDEditText r0 = this.f;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131371423);
    L8:
        this.f = (SpaceEditText) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (SpaceEditText) r0;
    }

    public final SpaceEmptyState V90() {
        UDEmptyState r0 = this.g;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131380922);
    L8:
        this.g = (SpaceEmptyState) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (SpaceEmptyState) r0;
    }

    public final NoPermission W90() {
        NoPermission r0 = this.j;
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

    public AuditControlApplyFragment() {
        this.k = new CompositeDisposable();
        this.n = new com.bytedance.ee.bear.middleground.permission.apply.a();
    }

    public final View getTitleBar() {
        return X90();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.k.dispose();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
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
        this.o = r1;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Serializable r3 = requireArguments().getSerializable("Params");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.apply.NoPermission");
        NoPermission r4 = (NoPermission) r3;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.j = r4;
    }

    public final void setBackIcon(Drawable r1) {
        this.l = r1;
    }

    public final void setBackListener(View.OnClickListener r1) {
        this.m = r1;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        X90().setDividerVisible(false);
        X90().setLeftIconVisibility(W90().getBackVisible());
        if (W90().getFromDocXInBase() == false) goto L5;
        X90().setVisibility(8);
    L5:
        com.bytedance.ee.bear.middleground.permission.apply.a r12 = this.n;
        Context r0 = requireContext();
        r12.getClass();
        Spanned r13 = com.bytedance.ee.bear.middleground.permission.apply.a.a(r0);
        float r1 = (getResources().getDimension(2131169381) * 2) + getResources().getDimension(2131168380);
        ViewGroup.LayoutParams r2 = U90().getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2;
        r3.setMargins(r3.leftMargin, y9c.d.a(18) + r3.topMargin, r3.rightMargin, r3.bottomMargin);
        ViewGroup.LayoutParams r4 = V90().getLayoutParams();
        r4.width = (int) r1;
        V90().setLayoutParams(r4);
        UDButton r5 = Y90();
        Context r6 = getContext();
        View r7 = null;
        if (r6 == null) goto L8;
        String r8 = r6.getString(2131887714);
    L9:
        r5.setText(r8);
        SpaceEmptyState r9 = V90();
        Context r14 = getContext();
        if (r14 == null) goto L12;
        String r15 = r14.getString(2131888103);
    L13:
        r9.setTitle(r15);
        V90().setDesc(r13);
        if (this.l == null) goto L18;
        ImageView r16 = X90().getLeftImage();
        if (r16 == null) goto L18;
        r16.setImageDrawable(this.l);
    L18:
        View r17 = this.i;
        if (r17 != null) goto L24;
        View r18 = getView();
        if (r18 == null) goto L23;
        r7 = r18.findViewById(2131382178);
    L23:
        this.i = (LinearLayout) r7;
        r17 = r7;
    L24:
        ((LinearLayout) r17).setVisibility(8);
        if (X90().isAttachedToWindow() == false) goto L29;
        tt5.a.h("AuditControlApplyFragment", "permission_title_bar isAttachedToWindow");
        au5.b r19 = this.o;
        if (r19 == null) goto L29;
        r19.a(true);
    L29:
        X90().addOnAttachStateChangeListener(new y(this));
        if (this.m == null) goto L32;
        X90().setLeftClickListener(this.m);
    L33:
        Y90().setOnClickListener(new x(this));
        com.bytedance.ee.bear.middleground.permission.c.z(W90().getToken(), sbb.e.g(W90().getDocumentType()), W90().getSubType(), W90().getFromVc(), W90().isWiki(), W90().getModule(), W90().getUserPerm(), W90().getPublicPerm(), "admin_forbidden");
        return;
    L32:
        X90().setLeftClickListener(new w(this));
        goto L33
    L12:
        r15 = null;
        goto L13
    L8:
        r8 = null;
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564177, r3, false);
    }
}
