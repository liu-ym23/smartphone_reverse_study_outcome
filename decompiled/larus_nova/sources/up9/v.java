package up9;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaSelectorBinding;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class v implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BottomSheetViewModel f551148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f551149b;

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f551150a;

        public a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f551150a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f551150a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f551150a.invoke(r100);
        }
    }

    @Override // up9.i0
    public void onDestroyView() {
    }

    @Override // up9.i0
    public void f(LarusFragmentMediaSelectorBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        boolean r101 = kp9.b.f505530a.c(r100.f364386a.getContext(), this.f551149b);
        wp9.i.c(r100.f364398m.f364438a, r101);
        if (r101 == false) goto L6;
        r100.f364398m.f364438a.setOnClickListener(new s(this));
        return;
    }

    public v(BottomSheetViewModel r100, boolean r101) {
        this.f551148a = r100;
        this.f551149b = r101;
    }

    public static void p(v r100, final ViewPager2 r101, boolean r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "view");
        int r103 = r101.getChildCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L14;
        View r105 = r101.getChildAt(r104);
        if ((r105 instanceof RecyclerView) == true) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        RecyclerView r106 = (RecyclerView) r105;
        if (r106.isNestedScrollingEnabled() == r102) goto L10;
        r106.setNestedScrollingEnabled(r102);
        r101.post(new t(r101));
        return;
    L10:
        return;
    }

    @Override // up9.i0
    public void g(LifecycleOwner r100, final LarusFragmentMediaSelectorBinding r101, BottomSheetViewModel r102, final MediaGalleryLiveDataViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "binding");
        Intrinsics.checkNotNullParameter(r102, "nonNullBottomSheetViewModel");
        Intrinsics.checkNotNullParameter(r103, "mediaGalleryViewModel");
        r102.getBottomSheetOnStateChanged().observe(r100, new a(new u(this, r101, r103)));
    }
}
