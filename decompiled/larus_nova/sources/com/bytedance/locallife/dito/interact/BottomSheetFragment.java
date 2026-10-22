package com.bytedance.locallife.dito.interact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/dito/interact/BottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public abstract class BottomSheetFragment extends Fragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f258325e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f258326d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetFragment f258327a;

        public a(BottomSheetFragment r100) {
            this.f258327a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BottomSheetFragment r100 = this.f258327a;     // Catch: Throwable -> L4
            int r101 = BottomSheetFragment.f258325e;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract void S90();

    public BottomSheetFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        CoordinatorLayout r102 = (CoordinatorLayout) r100.findViewById(R.id.poi_bottom_sheet_container);
        if (r102 == null) goto L5;
        int r103 = r102.getChildCount();
    L6:
        if (r103 <= 0) goto L19;
        if (r102 == null) goto L20;
        View r104 = r102.getChildAt(0);
        if (r104 == null) goto L21;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof CoordinatorLayout.LayoutParams) == false) goto L13;
        CoordinatorLayout.LayoutParams r106 = (CoordinatorLayout.LayoutParams) r105;
    L14:
        if (r106 == null) goto L17;
        r106.setBehavior(null);
    L17:
        r100.post(new a(this));
        return;
    L13:
        r106 = null;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.poi_bottom_sheet_fragment_saas, r101, false);
        CoordinatorLayout r104 = (CoordinatorLayout) r103.findViewById(R.id.poi_bottom_sheet_container);
        S90();
        this.f258326d = r103;
        return r103;
    }
}
