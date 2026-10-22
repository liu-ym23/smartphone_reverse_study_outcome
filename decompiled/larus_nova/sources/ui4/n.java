package ui4;

import android.view.View;
import com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class n<DATA> implements ti4.x<DATA, BaseMediaViewHolder.a>, com.bytedance.creativex.mediaimport.view.internal.validator.d<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f550176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f550177b;

    public static class a extends n<ki4.r> {
        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public n(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        this.f550176a = r100;
        this.f550177b = LazyKt.lazy(new m(this));
    }

    @Override // ti4.x
    public final void c(Object r100, int r101, BaseMediaViewHolder.a r102) {
        BaseMediaViewHolder.a r103 = r102;
        Intrinsics.checkNotNullParameter(r103, "state");
        ci4.a.a((View) this.f550177b.getValue(), r103.g());
    }
}
