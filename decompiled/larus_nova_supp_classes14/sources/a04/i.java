package a04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<n, o> {
    public final int e;
    public final int f;
    public LinearLayout g;
    public ImageView h;
    public TextView i;

    public static final class a extends com.bytedance.awemeopen.apps.framework.utils.o {
        public final /* synthetic */ i d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((n) this.d.b).a.b(Unit.INSTANCE);
        }

        public a(i r1) {
            this.d = r1;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        this.g = (LinearLayout) b().findViewById(2131369103);
        this.h = (ImageView) b().findViewById(2131369088);
        this.i = (TextView) b().findViewById(2131369093);
        LinearLayout r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("diggContainer");
        r0 = null;
    L5:
        r0.setOnClickListener(new a(this));
        o r1 = (o) this.c;
        Observer<Boolean> r2 = new f();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "observer");
        r1.a.a(r2);
        o r3 = (o) this.c;
        Observer<Boolean> r4 = new g(this);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "observer");
        r3.c.a(r4);
        o r5 = (o) this.c;
        Observer<Long> r6 = new h(this);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "observer");
        r5.b.a(r6);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        return LayoutInflater.from(r4.getContext()).inflate(2131558612, r4, false);
    }

    public i(Context r2, n r3, o r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
        this.e = r5;
        this.f = r6;
    }
}
