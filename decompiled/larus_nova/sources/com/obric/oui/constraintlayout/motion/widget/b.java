package com.obric.oui.constraintlayout.motion.widget;

import android.util.Pair;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class b {
    static {
        HashMap r100 = new HashMap();
        HashMap r101 = new HashMap();
        r100.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        r100.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        r100.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        r100.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        r100.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        r100.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        r100.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        r100.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        r100.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        r100.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        r100.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        r100.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        r100.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        r101.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        r101.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        r101.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        r101.put("layout_constraintTop_toTopOf", "layout_marginTop");
        r101.put("layout_constraintStart_toStartOf", "layout_marginStart");
        r101.put("layout_constraintStart_toEndOf", "layout_marginStart");
        r101.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        r101.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        r101.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        r101.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        r101.put("layout_constraintRight_toRightOf", "layout_marginRight");
        r101.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public b() {
    }
}
