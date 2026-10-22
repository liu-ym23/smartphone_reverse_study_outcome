package com.larus.kmp.voice_setting.voice.dialog.v2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f353122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Float> f353123b;

    public i() {
        this(0);
    }

    public i(int r100) {
        this.f353122a = 10;
        this.f353123b = new ArrayList();
    }

    public final void a(float r100) {
        List<Float> r101 = this.f353123b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(Float.valueOf(RangesKt.coerceIn(r100, 0.0f, 1.0f)));
    L4:
        if (((ArrayList) this.f353123b).size() <= this.f353122a) goto L6;
        ListProtector.remove(this.f353123b, 0);
        goto L4
    }
}
