package ui4;

import android.view.View;
import android.widget.TextView;
import com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder;
import com.bytedance.creativex.mediaimport.view.internal.base.BaseSelectorViewHolder;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class l<DATA, STATE> implements ti4.x<DATA, STATE>, com.bytedance.creativex.mediaimport.view.internal.validator.d<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f550171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f550172b;

    public static class a extends l<ki4.r, BaseMediaViewHolder.a> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.creativex.mediaimport.view.internal.validator.d.a f550173c;

        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f550173c = com.bytedance.creativex.mediaimport.view.internal.validator.d.f204098o1;
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final String getFormattedDuration(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            return this.f550173c.a(r101);
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final boolean isVideo(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f550173c.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return com.bytedance.creativex.mediaimport.repository.api.a.d(r101);
        }
    }

    public static class b extends l<ki4.r, BaseSelectorViewHolder.a> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.creativex.mediaimport.view.internal.validator.d.a f550174c;

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f550174c = com.bytedance.creativex.mediaimport.view.internal.validator.d.f204098o1;
        }

        @Override // ui4.l
        public final TextView d(View r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            return (TextView) r100.findViewById(R.id.duration_text);
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final String getFormattedDuration(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            return this.f550174c.a(r101);
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final boolean isVideo(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f550174c.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return com.bytedance.creativex.mediaimport.repository.api.a.d(r101);
        }
    }

    public l(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        this.f550171a = r100;
        this.f550172b = LazyKt.lazy(new k(this));
    }

    public TextView d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return (TextView) r100.findViewById(R.id.duration_view);
    }

    @Override // ti4.x
    public final void c(DATA r100, int r101, STATE r102) {
        if (isVideo(r100) == false) goto L5;
        ((TextView) this.f550172b.getValue()).setVisibility(0);
        ((TextView) this.f550172b.getValue()).setText(getFormattedDuration(r100));
        return;
    L5:
        ((TextView) this.f550172b.getValue()).setVisibility(8);
    }
}
