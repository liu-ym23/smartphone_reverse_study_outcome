package zz3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.utils.l;
import com.bytedance.awemeopen.apps.framework.utils.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<g, h> {
    public LinearLayout e;
    public FrameLayout f;
    public ImageView g;
    public TextView h;
    public final a i;

    public static final class a extends o {
        public final /* synthetic */ f d;
        public final /* synthetic */ g e;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ImageView r0 = this.d.g;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("commentImage");
            r0 = null;
        L5:
            l.a(r0);
            this.e.a.b(Boolean.FALSE);
        }

        public a(f r1, g r2) {
            this.d = r1;
            this.e = r2;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        this.e = (LinearLayout) b().findViewById(2131367468);
        this.f = (FrameLayout) b().findViewById(2131367328);
        this.g = (ImageView) b().findViewById(2131367358);
        this.h = (TextView) b().findViewById(2131390345);
        FrameLayout r1 = null;
        LinearLayout r2 = null;
        if (AosExtConfig.b.getCommentConfig().e == false) goto L9;
        LinearLayout r0 = this.e;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("commentLayout");
    L8:
        r2.setOnClickListener(this.i);
    L14:
        h r3 = (h) this.c;
        Observer<Long> r4 = new e(this);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "observer");
        r3.a.a(r4);
        return;
    L7:
        r2 = r0;
        goto L8
    L9:
        FrameLayout r5 = this.f;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
    L13:
        r1.setOnClickListener(this.i);
        goto L14
    L12:
        r1 = r5;
        goto L13
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        return LayoutInflater.from(r4.getContext()).inflate(2131558609, r4, false);
    }

    public f(Context r2, g r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
        this.i = new a(this, r3);
    }
}
