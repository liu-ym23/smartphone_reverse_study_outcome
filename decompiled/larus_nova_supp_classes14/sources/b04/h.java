package b04;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<i, j> {
    public com.bytedance.awemeopen.apps.framework.base.view.e e;
    public FrameLayout f;
    public AoImageView g;
    public AoImageView h;
    public final int i;
    public long j;
    public ValueAnimator k;
    public final f l;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        KeyEvent.Callback r0 = b().findViewById(2131381013);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.base.view.IPeriscopeView");
        this.e = (com.bytedance.awemeopen.apps.framework.base.view.e) r0;
        this.f = (FrameLayout) b().findViewById(2131380487);
        this.g = b().findViewById(2131381671);
        this.h = b().findViewById(2131381672);
        j r1 = (j) this.c;
        Observer<e24.b> r2 = new c(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "observer");
        r1.c.a(r2);
        j r3 = (j) this.c;
        Observer<Boolean> r4 = new d(this);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "observer");
        r3.a.a(r4);
        j r5 = (j) this.c;
        Observer<Boolean> r6 = new e(this);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "observer");
        r5.b.a(r6);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        return LayoutInflater.from(r4.getContext()).inflate(2131558607, r4, false);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [b04.f] */
    public h(Context r2, i r3, j r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
        this.i = 64;
        this.l = new f(this);
    }
}
