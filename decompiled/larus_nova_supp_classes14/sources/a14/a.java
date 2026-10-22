package a14;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.photo.viewmodel.AosPictureDetailViewModel;
import kotlin.jvm.internal.Intrinsics;
import r14.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final c a;
    public final View b;
    public final AosPictureDetailViewModel c;
    public final LifecycleOwner d;
    public final ViewModelStoreOwner e;
    public final Activity f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "PictureDetailParameters(aweme=" + this.a + ", rootView=" + this.b + ", viewModel=" + this.c + ", lifecycleOwner=" + this.d + ", viewModelStoreOwner=" + this.e + ", activity=" + this.f + ')';
    }

    public final Activity getActivity() {
        return this.f;
    }

    public a(c r2, View r3, AosPictureDetailViewModel r4, LifecycleOwner r5, ViewModelStoreOwner r6, Activity r7) {
        Intrinsics.checkNotNullParameter(r2, "aweme");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r6, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(r7, "activity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
