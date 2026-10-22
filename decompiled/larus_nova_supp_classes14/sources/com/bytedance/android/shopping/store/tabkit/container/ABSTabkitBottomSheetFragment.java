package com.bytedance.android.shopping.store.tabkit.container;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.n1;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/ABSTabkitBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "a", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ABSTabkitBottomSheetFragment extends BottomSheetDialogFragment {
    public TabKitBottomSheetBehavior<View> d;
    public View e;
    public Function0<Boolean> f;
    public final LinkedList<b> g;
    public int h;
    public boolean i;
    public boolean j;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ABSTabkitBottomSheetFragment a;

        public c(ABSTabkitBottomSheetFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Dialog r0 = this.a.getDialog();     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            Window r1 = r0.getWindow();     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.setWindowAnimations(2131954184);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    public abstract int S90();

    public void U90(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public void V90(boolean r1) {
    }

    public void W90(float r1) {
    }

    public abstract int getLayoutId();

    public int T90() {
        if (this.h != 3) goto L5;
        return 0;
    L5:
        n1.i.getClass();
        return n1.a.b();
    }

    public ABSTabkitBottomSheetFragment() {
        this.g = new LinkedList();
        this.h = 1;
        this.i = true;
        this.j = true;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        View r0 = getView();     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.postDelayed(new c(this), 300);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void X90(int r3) {
        this.h = r3;
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L8;
        return;
    L8:
        if (this.j == true) goto L14;
        TabKitBottomSheetBehavior<View> r4 = this.d;
        if (r4 == null) goto L12;
        r4.e = true;
    L12:
        if (r4 == null) goto L14;
        r4.j = true;
    L14:
        TabKitBottomSheetBehavior<View> r5 = this.d;
        if (r5 == null) goto L28;
        r5.setState(3);
        return;
    L28:
        return;
    L18:
        if (this.j == true) goto L24;
        TabKitBottomSheetBehavior<View> r6 = this.d;
        if (r6 == null) goto L22;
        r6.e = false;
    L22:
        if (r6 == null) goto L24;
        r6.j = false;
    L24:
        TabKitBottomSheetBehavior<View> r7 = this.d;
        if (r7 == null) goto L30;
        r7.setState(4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActivityCreated(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r3);
        if (this.h != 3) goto L5;
    L23:
        Dialog r4 = getDialog();
        if (r4 == null) goto L28;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L28;
        r5.setBackgroundDrawableResource(2131101135);
    L28:
        Dialog r6 = getDialog();
        if (r6 == null) goto L31;
        r6.setOnDismissListener(this);
    L31:
        Dialog r7 = getDialog();
        if (r7 == null) goto L34;
        r7.setOnShowListener(new com.bytedance.android.shopping.store.tabkit.container.a(this));
    L34:
        Dialog r8 = getDialog();
        if (r8 == null) goto L37;
        r8.setOnKeyListener(new com.bytedance.android.shopping.store.tabkit.container.b(this));
    L37:
        Dialog r9 = getDialog();
        if (r9 == null) goto L43;
        View r10 = r9.findViewById(2131389274);
        if (r10 == null) goto L44;
        r10.setOnClickListener(new com.bytedance.android.shopping.store.tabkit.container.c(this));
        return;
    L44:
        return;
    L43:
        return;
    L5:
        if (this.e != null) goto L23;
        Dialog r11 = getDialog();
        ViewGroup.LayoutParams r0 = null;
        if (r11 == null) goto L11;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L11;
        View r13 = r12.findViewById(2131371216);
    L12:
        this.e = r13;
        this.d = new TabKitBottomSheetBehavior();
        View r14 = this.e;
        if (r14 == null) goto L15;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
    L17:
        if ((r15 instanceof CoordinatorLayout.LayoutParams) == false) goto L20;
        r0 = r15;
    L20:
        CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) r0;
        if (r1 == null) goto L23;
        r1.setBehavior(this.d);
        goto L23
    L15:
        r15 = null;
    L11:
        r13 = null;
        goto L12
    }

    public void onCreate(Bundle r3) {
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        r0.requestWindowFeature(1);
    L5:
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
    }

    public final Dialog onCreateDialog(Bundle r3) {
        return new TabKitToggleBottomSheetDialog(requireContext(), S90());
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Context r5 = getContext();
        if (r5 != null) goto L7;
        return null;
    L7:
        return th.a.c(r5, getLayoutId(), r3, false);
    }
}
