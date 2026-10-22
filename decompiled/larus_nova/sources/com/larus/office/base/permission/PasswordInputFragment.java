package com.larus.office.base.permission;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.larus.office.base.impl.databinding.LarusViewOfficePasswordInputBinding;
import com.larus.office.base.preview.DocMeta;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\rH\u0002J\u001c\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020$\u0018\u00010#j\n\u0012\u0004\u0012\u00020$\u0018\u0001`%H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\u001a\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0014\u0010-\u001a\u00020\u00182\n\b\u0002\u0010.\u001a\u0004\u0018\u00010 H\u0002J(\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020$2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%H\u0002J0\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u0002042\u0006\u00100\u001a\u00020$2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%H\u0002J\u0010\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u0007H\u0002J\u0010\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u0007H\u0002J\b\u0010:\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/office/base/permission/PasswordInputFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/office/base/impl/databinding/LarusViewOfficePasswordInputBinding;", "isSubmitting", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", SVGRenderEngine.RECT, "Landroid/graphics/Rect;", "originalPaddingBottom", "", "isKeyboardListenerSetup", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "initViews", "setupPasswordInput", "setupConfirmButton", "setupBackButton", "getDocToken", "", "getDocType", "getDocListToApplyPermission", "Ljava/util/ArrayList;", "Lcom/larus/office/base/preview/DocMeta;", "Lkotlin/collections/ArrayList;", "submitPassword", "password", "onPasswordVerifySuccess", "handlePasswordError", "code", "error", "", "onPasswordVerifyFailed", "errorMessage", "jumpToNextDoc", "nextDoc", "fullList", "jumpToNextDocByType", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "restDocList", "updateConfirmButtonState", "enabled", "setSubmittingState", "submitting", "setupKeyboardAwarePadding", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PasswordInputFragment extends Fragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<Integer> f360630j = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusViewOfficePasswordInputBinding f360631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f360632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public v f360633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f360634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f360635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f360636i;

    public static final class a {
    }

    static {
        f360630j = SetsKt.setOf(0);
    }

    public PasswordInputFragment() {
        this.f360634g = new Rect();
    }

    public final ArrayList<DocMeta> S90() {
        Fragment r100 = getParentFragment();
        if (r100 == null) goto L7;
        Bundle r101 = r100.getArguments();
        if (r101 == null) goto L7;
        return com.larus.office.base.preview.a.a(r101, "office_permission_doc_list_to_apply_permission");
    L7:
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        v r100 = this.f360633f;
        if (r100 == null) goto L9;
        View r101 = getView();
        if (r101 == null) goto L9;
        ViewTreeObserver r102 = r101.getViewTreeObserver();
        if (r102 == null) goto L9;
        r102.removeOnGlobalLayoutListener(r100);
    L9:
        this.f360633f = null;
        this.f360631d = null;
    }

    public static void U90(PasswordInputFragment r100) {
        if (r100.isAdded() == true) goto L5;
        return;
    L5:
        if (r100.f360631d == null) goto L13;
        FLogger.f375446a.i("PasswordInputFragment", "onPasswordVerifyFailed: msg=null");
        r100.V90(false);
        Context r101 = r100.getContext();
        if (r101 == null) goto L12;
        String r102 = r100.getString(R.string.larus_mobile_docPermission_toast_applyFail_default);
        t19.s.f544207a.getClass();
        t19.s.t(r101, r102);
        return;
    L12:
        return;
    }

    public final void V90(boolean r100) {
        this.f360632e = r100;
        boolean r101 = false;
        if (r100 == false) goto L29;
        LarusViewOfficePasswordInputBinding r102 = this.f360631d;
        if (r102 == null) goto L9;
        ProgressBar r103 = r102.f360566f;
        if (r103 == null) goto L9;
        r103.setVisibility(0);
    L9:
        LarusViewOfficePasswordInputBinding r104 = this.f360631d;
        if (r104 == null) goto L14;
        TextView r105 = r104.f360567g;
        if (r105 == null) goto L14;
        r105.setVisibility(8);
    L14:
        LarusViewOfficePasswordInputBinding r106 = this.f360631d;
        if (r106 == null) goto L19;
        LinearLayout r107 = r106.f360563c;
        if (r107 == null) goto L19;
        r107.setEnabled(false);
    L19:
        LarusViewOfficePasswordInputBinding r108 = this.f360631d;
        if (r108 == null) goto L24;
        LinearLayout r109 = r108.f360563c;
        if (r109 == null) goto L24;
        r109.setAlpha(0.3f);
    L24:
        LarusViewOfficePasswordInputBinding r110 = this.f360631d;
        if (r110 == null) goto L56;
        EditText r111 = r110.f360564d;
        if (r111 == null) goto L57;
        r111.setEnabled(false);
        return;
    L57:
        return;
    L56:
        return;
    L29:
        LarusViewOfficePasswordInputBinding r112 = this.f360631d;
        if (r112 == null) goto L34;
        ProgressBar r113 = r112.f360566f;
        if (r113 == null) goto L34;
        r113.setVisibility(8);
    L34:
        LarusViewOfficePasswordInputBinding r114 = this.f360631d;
        if (r114 == null) goto L39;
        TextView r115 = r114.f360567g;
        if (r115 == null) goto L39;
        r115.setVisibility(0);
    L39:
        LarusViewOfficePasswordInputBinding r116 = this.f360631d;
        if (r116 == null) goto L44;
        EditText r117 = r116.f360564d;
        if (r117 == null) goto L44;
        r117.setEnabled(true);
    L44:
        LarusViewOfficePasswordInputBinding r118 = this.f360631d;
        if (r118 == null) goto L49;
        EditText r119 = r118.f360564d;
        if (r119 == null) goto L49;
        Editable r120 = r119.getText();
    L50:
        if (r120 != null) goto L52;
    L53:
        r101 = true;
    L54:
        W90(!r101);
        return;
    L52:
        if (r120.length() != 0) goto L54;
    L49:
        r120 = null;
        goto L50
    }

    public final void W90(boolean r100) {
        LarusViewOfficePasswordInputBinding r101 = this.f360631d;
        if (r101 == null) goto L7;
        LinearLayout r102 = r101.f360563c;
        if (r102 == null) goto L7;
        r102.setEnabled(r100);
    L7:
        LarusViewOfficePasswordInputBinding r103 = this.f360631d;
        if (r103 == null) goto L16;
        LinearLayout r104 = r103.f360563c;
        if (r104 == null) goto L17;
        if (r100 == false) goto L13;
        float r105 = 1.0f;
    L14:
        r104.setAlpha(r105);
        return;
    L13:
        r105 = 0.3f;
        goto L14
    L17:
        return;
    }

    public final void T90(final DocMeta r100, ArrayList<DocMeta> r101) {
        final ArrayList r102 = new ArrayList(CollectionsKt.drop(r101, 1));
        SoftReference<Handler> r103 = com.larus.utils.y.f375498a;
        Runnable r104 = new x(this, r100, r102);
        Intrinsics.checkNotNullParameter(r104, "action");
        com.larus.utils.y.d(r104, 700);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.office.base.permission.v] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        int r102 = 0;
        W90(false);
        LarusViewOfficePasswordInputBinding r103 = this.f360631d;
        if (r103 == null) goto L7;
        EditText r104 = r103.f360564d;
        if (r104 == null) goto L7;
        r104.addTextChangedListener(new y(this));
    L7:
        LarusViewOfficePasswordInputBinding r105 = this.f360631d;
        if (r105 == null) goto L12;
        LinearLayout r106 = r105.f360563c;
        if (r106 == null) goto L12;
        e1.d(r106, new u(this));
    L12:
        LarusViewOfficePasswordInputBinding r107 = this.f360631d;
        if (r107 == null) goto L18;
        ImageView r108 = r107.f360562b;
        if (r108 == null) goto L18;
        e1.d(r108, new w(this));
    L18:
        if (this.f360636i == true) goto L33;
        this.f360636i = true;
        LarusViewOfficePasswordInputBinding r109 = this.f360631d;
        if (r109 == null) goto L25;
        LinearLayout r110 = r109.f360565e;
        if (r110 == null) goto L25;
        r102 = r110.getPaddingBottom();
    L25:
        this.f360635h = r102;
        this.f360633f = new v(this);
        View r111 = getView();
        if (r111 == null) goto L31;
        ViewTreeObserver r112 = r111.getViewTreeObserver();
        if (r112 == null) goto L32;
        r112.addOnGlobalLayoutListener(this.f360633f);
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.larus_view_office_password_input, r110, false);
        int r112 = R.id.btn_back;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r101, R.id.btn_back);
        if (r102 == null) goto L21;
        r112 = R.id.btn_confirm;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.btn_confirm);
        if (r103 == null) goto L21;
        r112 = R.id.et_password;
        EditText r104 = (EditText) ViewBindings.findChildViewById(r101, R.id.et_password);
        if (r104 == null) goto L21;
        r112 = R.id.iv_lock;
        if (((ImageView) ViewBindings.findChildViewById(r101, R.id.iv_lock)) == null) goto L21;
        r112 = R.id.password_container;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.password_container);
        if (r105 == null) goto L21;
        r112 = R.id.pb_loading;
        ProgressBar r106 = (ProgressBar) ViewBindings.findChildViewById(r101, R.id.pb_loading);
        if (r106 == null) goto L21;
        r112 = R.id.tv_btn_text;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r101, R.id.tv_btn_text);
        if (r107 == null) goto L21;
        r112 = R.id.tv_password_title;
        if (((TextView) ViewBindings.findChildViewById(r101, R.id.tv_password_title)) == null) goto L21;
        ConstraintLayout r108 = (ConstraintLayout) r101;
        this.f360631d = new LarusViewOfficePasswordInputBinding(r108, r102, r103, r104, r105, r106, r107);
        return r108;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }
}
