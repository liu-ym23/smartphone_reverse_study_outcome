package p04;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment;
import com.bytedance.awemeopen.apps.framework.profile.likes.UserProfileLikesFragmentViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final View a;
    public final ViewGroup b;
    public final LifecycleOwner c;
    public final UserProfileLikesFragmentViewModel d;
    public final FragmentActivity e;

    public final FragmentActivity getActivity() {
        return this.e;
    }

    public a(View r2, ViewGroup r3, AosRecyclerListFragment r4, UserProfileLikesFragmentViewModel r5, FragmentActivity r6) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "vm");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
