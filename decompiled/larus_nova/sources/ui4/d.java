package ui4;

import android.view.View;
import com.bytedance.creativex.mediaimport.view.internal.base.BaseSelectorViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class d<DATA> implements ti4.x<DATA, BaseSelectorViewHolder.a>, com.bytedance.creativex.mediaimport.view.internal.validator.d<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f550156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f550157b;

    public static class a extends d<ki4.r> {
        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        this.f550156a = r100;
        this.f550157b = LazyKt.lazy(new c(this));
    }

    @Override // ti4.x
    public final void c(Object r100, int r101, BaseSelectorViewHolder.a r102) {
        BaseSelectorViewHolder.a r103 = r102;
        Intrinsics.checkNotNullParameter(r103, "state");
        ci4.a.a((View) this.f550157b.getValue(), r103.b().isSelected());
    }
}
