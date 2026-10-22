package ui4;

import android.view.View;
import com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class p<DATA> implements ti4.x<DATA, BaseMediaViewHolder.a>, com.bytedance.creativex.mediaimport.view.internal.validator.d<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f550179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f550180b;

    public static class a extends p<ki4.r> {
        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public p(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        this.f550179a = r100;
        this.f550180b = LazyKt.lazy(new o(this));
    }

    @Override // ti4.x
    public final void c(Object r100, int r101, BaseMediaViewHolder.a r102) {
        BaseMediaViewHolder.a r103 = r102;
        Intrinsics.checkNotNullParameter(r103, "state");
        ci4.a.a((View) this.f550180b.getValue(), r103.c());
    }
}
