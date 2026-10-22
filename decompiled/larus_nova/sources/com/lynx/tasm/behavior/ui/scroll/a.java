package com.lynx.tasm.behavior.ui.scroll;

import java.util.Comparator;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements Comparator<b.C4567b> {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(b.C4567b r100, b.C4567b r101) {
        return Integer.compare(Math.abs(r100.f382940d), Math.abs(r101.f382940d));
    }
}
