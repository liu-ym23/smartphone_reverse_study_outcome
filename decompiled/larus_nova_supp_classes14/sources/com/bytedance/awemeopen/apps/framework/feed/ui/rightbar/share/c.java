package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.share;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.utils.l;
import com.bytedance.awemeopen.apps.framework.utils.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<d, f> {

    public static final class a extends o {
        public final /* synthetic */ ImageView d;
        public final /* synthetic */ c e;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            l.a(this.d);
            ((d) this.e.b).a.b(Unit.INSTANCE);
        }

        public a(ImageView r1, c r2) {
            this.d = r1;
            this.e = r2;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        LinearLayout r0 = (LinearLayout) b().findViewById(2131386147);
        ImageView r1 = (ImageView) b().findViewById(2131386083);
        final TextView r2 = (TextView) b().findViewById(2131386141);
        r0.setOnClickListener(new a(r1, this));
        f r3 = (f) this.c;
        Observer<Long> r4 = new b(r2);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "observer");
        r3.a.a(r4);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        return LayoutInflater.from(r4.getContext()).inflate(2131558613, r4, false);
    }

    public c(Context r2, d r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
    }
}
