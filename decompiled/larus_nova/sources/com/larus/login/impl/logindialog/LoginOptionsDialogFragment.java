package com.larus.login.impl.logindialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.login.impl.databinding.LarusLoginOptionsDialogFragmentBinding;
import com.larus.login.impl.utils.RecyclerViewItemSpacingDecoration;
import com.larus.login.impl.view.DragCloseLinearLayout;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import zj9.c;
import zj9.d;
import zj9.e;
import zj9.f;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u000b\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\u0006\u0010\u001a\u001a\u00020\u000eJ\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J&\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0 H\u0002J \u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006&"}, d2 = {"Lcom/larus/login/impl/logindialog/LoginOptionsDialogFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/login/impl/databinding/LarusLoginOptionsDialogFragmentBinding;", "data", "Lcom/larus/login/impl/logindialog/LoginOptionsDialogModel;", "adapter", "Lcom/larus/login/impl/logindialog/LoginOptionsAdapter;", "onBackPressedCallback", "com/larus/login/impl/logindialog/LoginOptionsDialogFragment$onBackPressedCallback$1", "Lcom/larus/login/impl/logindialog/LoginOptionsDialogFragment$onBackPressedCallback$1;", "setData", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "notifyOpen", "notifyClose", "startEnterAnimation", "background", "content", "startExitAnimation", "finishCallback", "Lkotlin/Function0;", "startPageAnimation", "Landroid/animation/Animator;", "isEnter", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginOptionsDialogFragment extends Fragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f357840h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusLoginOptionsDialogFragmentBinding f357841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f357842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LoginOptionsAdapter f357843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LoginOptionsDialogFragment$onBackPressedCallback$1 f357844g;

    public static final class a {
    }

    public static final class b implements DragCloseLinearLayout.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoginOptionsDialogFragment f357845a;

        @Override // com.larus.login.impl.view.DragCloseLinearLayout.a
        public final void close() {
            this.f357845a.S90();
        }

        public b(LoginOptionsDialogFragment r100) {
            this.f357845a = r100;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [zj9.b] */
    public final void S90() {
        f r100 = this.f357842e;
        if (r100 == null) goto L7;
        Function0<Unit> r101 = r100.f572523d;
        if (r101 == null) goto L7;
        r101.invoke();
    L7:
        remove();
        LarusLoginOptionsDialogFragmentBinding r102 = this.f357841d;
        if (r102 == null) goto L17;
        DragCloseLinearLayout r103 = r102.f357592c;
        if (r103 == null) goto L18;
        View r104 = r102.f357591b;
        if (r104 == null) goto L19;
        ?? r105 = new zj9.b(this);
        T90(r104, r103, false).addListener(new e(r105));
        return;
    L19:
        return;
    L18:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.login.impl.logindialog.LoginOptionsDialogFragment$onBackPressedCallback$1] */
    public LoginOptionsDialogFragment() {
        this.f357844g = new LoginOptionsDialogFragment$onBackPressedCallback$1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        f r102 = this.f357842e;
        if (r102 == null) goto L28;
        LoginOptionsAdapter r103 = new LoginOptionsAdapter(r102.f572521b);
        this.f357843f = r103;
        LarusLoginOptionsDialogFragmentBinding r104 = this.f357841d;
        if (r104 == null) goto L9;
        RecyclerView r105 = r104.f357594e;
        if (r105 == null) goto L9;
        r105.setAdapter(r103);
    L9:
        LarusLoginOptionsDialogFragmentBinding r106 = this.f357841d;
        if (r106 == null) goto L14;
        RecyclerView r107 = r106.f357594e;
        if (r107 == null) goto L14;
        r107.setLayoutManager(new LinearLayoutManager(getContext()));
    L14:
        RecyclerViewItemSpacingDecoration r108 = new RecyclerViewItemSpacingDecoration(new com.larus.login.impl.utils.a(c7.b(6), c7.b(6), 21));
        LarusLoginOptionsDialogFragmentBinding r109 = this.f357841d;
        if (r109 == null) goto L19;
        RecyclerView r110 = r109.f357594e;
        if (r110 == null) goto L19;
        r110.addItemDecoration(r108);
    L19:
        LoginOptionsAdapter r111 = this.f357843f;
        if (r111 == null) goto L22;
        r111.notifyItemRangeInserted(0, r102.f572521b.size());
    L22:
        LarusLoginOptionsDialogFragmentBinding r112 = this.f357841d;
        if (r112 == null) goto L27;
        TextView r113 = r112.f357595f;
        if (r113 == null) goto L27;
        r113.setText(getString(r102.f572520a));
    L27:
        r102.f572522c.invoke();
    L28:
        LarusLoginOptionsDialogFragmentBinding r114 = this.f357841d;
        if (r114 == null) goto L33;
        View r115 = r114.f357591b;
        if (r115 == null) goto L33;
        r115.setOnClickListener(new c(this));
    L33:
        LarusLoginOptionsDialogFragmentBinding r116 = this.f357841d;
        if (r116 == null) goto L38;
        DragCloseLinearLayout r117 = r116.f357592c;
        if (r117 == null) goto L38;
        r117.setLayoutCloseListener(new b(this));
    L38:
        r100.post(new d(this));
        requireActivity().getOnBackPressedDispatcher().addCallback(this.f357844g);
    }

    public final Animator T90(View r100, DragCloseLinearLayout r101, boolean r110) {
        AnimatorSet r102 = new AnimatorSet();
        float r103 = 1.0f;
        if (r110 == false) goto L5;
        float r104 = 0.0f;
    L6:
        if (r110 == true) goto L9;
        r103 = 0.0f;
    L9:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r100, View.ALPHA, new float[]{r104, r103});
        if (r110 == false) goto L12;
        float r106 = r101.getMeasuredHeight();
    L13:
        if (r110 == false) goto L15;
        float r111 = r101.getTranslationY();
    L16:
        r102.playTogether(new Animator[]{r105, ObjectAnimator.ofFloat(r101, View.TRANSLATION_Y, new float[]{r106, r111})});
        r102.setDuration(150);
        r102.setInterpolator(new LinearInterpolator());
        r102.start();
        e1.x(r101);
        return r102;
    L15:
        r111 = r101.getMeasuredHeight();
        goto L16
    L12:
        r106 = r101.getTranslationY();
        goto L13
    L5:
        r104 = 1.0f;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_login_options_dialog_fragment, r101, false);
        int r103 = R.id.bgView;
        View r104 = ViewBindings.findChildViewById(r102, R.id.bgView);
        if (r104 == null) goto L15;
        r103 = R.id.contentLayout;
        DragCloseLinearLayout r105 = (DragCloseLinearLayout) ViewBindings.findChildViewById(r102, R.id.contentLayout);
        if (r105 == null) goto L15;
        r103 = R.id.divider;
        View r106 = ViewBindings.findChildViewById(r102, R.id.divider);
        if (r106 == null) goto L15;
        r103 = R.id.recyclerView;
        RecyclerView r107 = (RecyclerView) ViewBindings.findChildViewById(r102, R.id.recyclerView);
        if (r107 == null) goto L15;
        r103 = R.id.title;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r102, R.id.title);
        if (r108 == null) goto L15;
        FrameLayout r109 = (FrameLayout) r102;
        this.f357841d = new LarusLoginOptionsDialogFragmentBinding(r109, r104, r105, r106, r107, r108);
        return r109;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
