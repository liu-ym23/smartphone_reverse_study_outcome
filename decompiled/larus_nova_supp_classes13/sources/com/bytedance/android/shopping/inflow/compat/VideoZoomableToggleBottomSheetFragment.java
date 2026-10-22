package com.bytedance.android.shopping.inflow.compat;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import n83.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/inflow/compat/VideoZoomableToggleBottomSheetFragment;", "Lcom/bytedance/android/shopping/inflow/compat/ToggleBottomSheetFragment;", "<init>", "()V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class VideoZoomableToggleBottomSheetFragment extends ToggleBottomSheetFragment {
    public m m;
    public ValueAnimator n;
    public float o;
    public boolean p;
    public ValueAnimator q;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ VideoZoomableToggleBottomSheetFragment a;

        public b(VideoZoomableToggleBottomSheetFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoZoomableToggleBottomSheetFragment r0 = this.a;     // Catch: Throwable -> L9
            ValueAnimator r1 = r0.n;     // Catch: Throwable -> L9
            if (r1 != null) goto L5;
        L7:
            ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{-1.0f, 0.0f});     // Catch: Throwable -> L9
            r2.setDuration(150);     // Catch: Throwable -> L9
            r2.addUpdateListener(new d(r0));     // Catch: Throwable -> L9
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
            r0.n = r2;     // Catch: Throwable -> L9
            r2.start();     // Catch: Throwable -> L9
            return;
        L5:
            if (r1.isRunning() != true) goto L7;
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ValueAnimator r0 = this.q;
        if (r0 != null) goto L5;
    L7:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.o, -1.0f});
        r1.setDuration(150);
        r1.addUpdateListener(new e(this));
        Unit r2 = Unit.INSTANCE;
        this.q = r1;
        r1.start();
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public void onResume() {
        super.onResume();
        if (this.p == true) goto L8;
        this.p = true;
        View r0 = getView();
        if (r0 == null) goto L9;
        r0.post(new b(this));
        return;
    L9:
        return;
    }

    public VideoZoomableToggleBottomSheetFragment() {
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public void W90(float r3) {
        this.o = r3;
        ValueAnimator r0 = this.n;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L6:
        ValueAnimator r2 = this.q;
        if (r2 != null) goto L9;
    L11:
        r1 = false;
    L12:
        if (r1 == true) goto L15;
        Z90(r3);
        return;
    L15:
        return;
    L9:
        if (r2.isRunning() != true) goto L11;
    L5:
        if (r0.isRunning() == true) goto L12;
        goto L6
    }

    public void Z90(float r2) {
        U90();
        Math.min(r2, 0.0f);
        m r3 = this.m;
        if (r3 == null) goto L6;
        r3.a();
        return;
    }

    @Override // com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetFragment
    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L5;
        View r4 = r3.findViewById(2131389274);
    L6:
        if (r4 == null) goto L9;
        r4.setBackgroundColor(0);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
