package com.lynx.tasm.animation.keyframe;

import android.animation.Keyframe;
import java.util.Comparator;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Comparator<Keyframe> {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(Keyframe r100, Keyframe r101) {
        return Float.compare(r100.getFraction(), r101.getFraction());
    }
}
