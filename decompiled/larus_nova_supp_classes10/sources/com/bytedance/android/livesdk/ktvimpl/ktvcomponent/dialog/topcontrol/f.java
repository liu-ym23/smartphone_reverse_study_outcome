package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.r3;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public ImageView a;
    public final CompositeDisposable b;
    public boolean c;
    public final LifecycleOwner d;
    public final com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c e;
    public final boolean f;
    public final boolean g;
    public final String h;

    public final void a(boolean r4) {
        ImageView r0 = this.a;
        if (r0 == null) goto L22;
        StringBuilder r1 = new StringBuilder();
        r1.append(s1.B(2131918485));
        if (r4 == false) goto L7;
        int r2 = 2131914862;
    L8:
        r1.append(s1.B(r2));
        String r3 = r1.toString();
        r3.a(this.a, r3);
        if (r4 == false) goto L17;
        if (this.g == false) goto L14;
        r0.setBackgroundResource(2131252108);
        goto L22
    L14:
        if (this.f == false) goto L22;
        FrescoLoader r5 = FrescoLoader.with(r0.getContext());
        int r6 = com.bytedance.android.live.ktv.common.util.h.a;
        r5.load("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ktv_component_top_bar_origin_open_ic_new.png").into(r0);
        goto L22
    L17:
        if (this.g == false) goto L20;
        r0.setBackgroundResource(2131252107);
        goto L22
    L20:
        if (this.f == false) goto L22;
        FrescoLoader r7 = FrescoLoader.with(r0.getContext());
        int r8 = com.bytedance.android.live.ktv.common.util.h.a;
        r7.load("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ktv_component_top_bar_origin_close_ic_new.png").into(r0);
        goto L22
    L7:
        r2 = 2131914861;
    L22:
        this.c = r4;
    }

    public f(LifecycleOwner r2, com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r3, boolean r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.b = new CompositeDisposable();
    }
}
