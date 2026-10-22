package p04;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment;
import com.bytedance.awemeopen.apps.framework.profile.likes.UserProfileLikesFragmentViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f527277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f527278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f527279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UserProfileLikesFragmentViewModel f527280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentActivity f527281e;

    public final FragmentActivity getActivity() {
        return this.f527281e;
    }

    public a(View r100, ViewGroup r101, AosRecyclerListFragment r102, UserProfileLikesFragmentViewModel r103, FragmentActivity r104) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r103, "vm");
        this.f527277a = r100;
        this.f527278b = r101;
        this.f527279c = r102;
        this.f527280d = r103;
        this.f527281e = r104;
    }
}
