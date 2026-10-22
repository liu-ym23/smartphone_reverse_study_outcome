package com.story.ai.biz.comment.adapter;

import android.animation.Animator;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f459841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f459842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f459843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f459844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f459845e;

    /* JADX WARN: Type inference failed for: r2v3, types: [com.story.ai.biz.comment.adapter.x] */
    public z(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f459841a = ColorProtector.parseColor("#21000000");
        this.f459842b = (View) dnc.b.a(r100, R.id.root);
        this.f459844d = new x(this);
    }

    public final void a(MotionEvent r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "source");
        if (r100.getAction() != 0) goto L12;
        Object r102 = this.f459842b.getTag();
        if ((r102 instanceof Animator) == false) goto L7;
        Animator r103 = (Animator) r102;
    L8:
        if (r103 == null) goto L10;
        r103.cancel();
    L10:
        this.f459845e = SystemClock.elapsedRealtime();
        this.f459843c = false;
        this.f459842b.postDelayed(this.f459844d, 100);
        return;
    L7:
        r103 = null;
        goto L8
    L12:
        if (r100.getAction() == 1) goto L16;
        if (r100.getAction() == 3) goto L16;
        return;
    L16:
        if (this.f459843c == false) goto L18;
        return;
    L18:
        this.f459843c = true;
        this.f459842b.removeCallbacks(this.f459844d);
        if (r100.getAction() == 1) goto L21;
    L23:
        this.f459842b.setBackgroundColor(0);
        return;
    L21:
        if ((SystemClock.elapsedRealtime() - this.f459845e) >= 100) goto L23;
        this.f459842b.setBackgroundColor(this.f459841a);
        this.f459842b.postDelayed(new y(this), 80);
    }
}
