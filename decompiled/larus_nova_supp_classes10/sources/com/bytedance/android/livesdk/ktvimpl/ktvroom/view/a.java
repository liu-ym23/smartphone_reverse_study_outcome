package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a implements t {
    public final float a;
    public final float b;
    public com.bytedance.android.live.ktv.common.midi.f c;
    public com.bytedance.android.live.ktv.common.midi.g d;
    public db0.a e;
    public v f;
    public MidiSkinDressInfo g;
    public long h;
    public final int i;
    public s j;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.view.a$a, reason: collision with other inner class name */
    public static final class C0029a {
    }

    static {
    }

    public void e() {
        this.e = null;
        this.d = null;
    }

    public void f() {
    }

    public a() {
        this.a = s1.f(72.0f);
        this.b = s1.y();
        this.i = vm2.h.I();
    }

    public final boolean c(com.bytedance.android.live.ktv.common.midi.k r5) {
        Intrinsics.checkNotNullParameter(r5, "scoreInfo");
        float r0 = r5.a;
        float r2 = 0;
        if (r0 <= r2) goto L10;
        float r6 = r5.b;
        if (r6 > r2) goto L7;
        return false;
    L7:
        if (Math.abs(r0 - r6) > this.i) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public void d(db0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        this.e = r2;
    }

    public void g(long r1) {
        this.h = r1;
    }

    public void h(MidiSkinDressInfo r1) {
        this.g = r1;
    }

    public void b(com.bytedance.android.live.ktv.common.midi.k r1, Long r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "scoreInfo");
        if (r2 == null) goto L6;
        this.h = r2.longValue();
        return;
    }
}
