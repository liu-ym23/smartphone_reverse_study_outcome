package gn9;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d extends DiffUtil.ItemCallback<in9.g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f481836a = null;

    static {
        f481836a = new d();
    }

    public d() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(in9.g r100, in9.g r101) {
        in9.g r102 = r100;
        in9.g r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        return Intrinsics.areEqual(r102, r103);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(in9.g r100, in9.g r101) {
        in9.g r102 = r100;
        in9.g r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        return Intrinsics.areEqual(r102.a(), r103.a());
    }
}
