package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/PhotoViewDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoViewDialogFragment extends DialogFragment {
    public RecyclerView d;
    public FrameLayout e;
    public OnPageSelectedListener f;
    public Function0<Unit> g;
    public int h;
    public boolean i;
    public final ArrayList<IIndicatorView> j;
    public float k;
    public float l;
    public final TransitionPagerAdapter<?> m;

    public void T90(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
    }

    public void U90(RecyclerView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
    }

    public void onPageSelected(int r1, boolean r2) {
    }

    public final RecyclerView V90() {
        RecyclerView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pager");
    L5:
        return r0;
    }

    public final FrameLayout W90() {
        FrameLayout r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L5:
        return r0;
    }

    public final void dismiss() {
        this.m.onDestroy();
        super.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public void Y90() {
        dismiss();     // Catch: Exception -> L4
    L8:
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L14;
        r0.finish();
        return;
    L14:
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L8;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
    L12:
        this.m.onDestroy();
    L13:
        Function0<Unit> r1 = this.g;
        if (r1 == null) goto L19;
        Unit r2 = (Unit) r1.invoke();
        return;
    L19:
        return;
    L5:
        if (r0.isShowing() != true) goto L12;
        dismiss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L13;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L13
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L12;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L13;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r1.setLayout(-1, -1);
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r1.clearFlags(2);
        int r3 = Build.VERSION.SDK_INT;
        r1.addFlags(Integer.MIN_VALUE);
        S90(r1).setSystemUiVisibility(1280);
        if (r3 <= 28) goto L10;
        r2.layoutInDisplayCutoutMode = 1;
    L10:
        S90(r1).setPadding(0, 0, 0, 0);
        return;
    L13:
        return;
    }

    public PhotoViewDialogFragment(TransitionPagerAdapter<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "transitionAdapter");
        this.m = r4;
        this.h = -1;
        Rect r5 = new Rect();
        Dialog r0 = getDialog();
        int r1 = 0;
        if (r0 == null) goto L11;
        Window r2 = r0.getWindow();
        if (r2 == null) goto L11;
        WindowManager r3 = r2.getWindowManager();
        if (r3 == null) goto L11;
        Display r6 = r3.getDefaultDisplay();
        if (r6 == null) goto L11;
        int r7 = r6.getWidth();
    L12:
        Dialog r8 = getDialog();
        if (r8 == null) goto L21;
        Window r9 = r8.getWindow();
        if (r9 == null) goto L21;
        WindowManager r10 = r9.getWindowManager();
        if (r10 == null) goto L21;
        Display r11 = r10.getDefaultDisplay();
        if (r11 == null) goto L21;
        r1 = r11.getHeight();
    L21:
        int r12 = r7 / 2;
        r5.left = r12;
        int r13 = r1 / 2;
        r5.top = r13;
        r5.right = r12;
        r5.bottom = r13;
        Unit r14 = Unit.INSTANCE;
        this.j = new ArrayList();
        this.k = 1.0f;
        this.l = 1.0f;
        return;
    L11:
        r7 = 0;
        goto L12
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public void X90(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        FrameLayout r0 = new FrameLayout(r5);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r1 = Unit.INSTANCE;
        this.e = r0;
        RecyclerView r2 = new RecyclerView(r5);
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.d = r2;
        final LinearLayoutManager r3 = new LinearLayoutManager(r5);
        RecyclerView r6 = this.d;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pager");
    L5:
        r3.setOrientation(0);
        r6.setLayoutManager(r3);
        PagerSnapHelper r7 = new PagerSnapHelper();
        RecyclerView r4 = this.d;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pager");
    L8:
        r7.attachToRecyclerView(r4);
        FrameLayout r8 = this.e;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L11:
        RecyclerView r9 = this.d;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pager");
    L14:
        r8.addView(r9, 0);
        RecyclerView r10 = this.d;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("pager");
    L17:
        r10.addOnScrollListener(new PhotoViewDialogFragment$initAllViews$4(this, r3));
        RecyclerView r11 = this.d;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("pager");
    L20:
        r11.setAdapter(this.m);
        this.m.setInternalTransitionListener(new k(this));
        this.m.registerAdapterDataObserver(new PhotoViewDialogFragment$initAdapter$2(this));
    }

    public final void Z90(int r3) {
        if (this.h == r3) goto L13;
        this.h = r3;
        Iterator<IIndicatorView> r4 = this.j.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r4.next().onPageSelected(this.h);
        goto L6
    L8:
        onPageSelected(this.h, false);
        OnPageSelectedListener r5 = this.f;
        if (r5 == null) goto L14;
        r5.onPageSelected(this.h);
        return;
    L14:
        return;
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        X90(r2);
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 0);
    }

    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FrameLayout r4 = this.e;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L17:
        r4.setBackgroundColor(com.bytedance.android.shopping.extensions.j.b(2131100641));     // Catch: Throwable -> L8
    L11:
        if (this.i == false) goto L16;
        FrameLayout r5 = this.e;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L15:
        r5.getBackground().setAlpha(0);
        this.k = 0.0f;
    L16:
        return r4;
    L8:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L11
    }
}
