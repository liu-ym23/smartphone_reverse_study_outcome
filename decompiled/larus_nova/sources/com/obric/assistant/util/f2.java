package com.obric.assistant.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes33.dex */
public final class f2 {
    public static final ConstraintLayout a(ViewGroup r100) {
        FLogger.f375446a.i("ViewUtils", "findInputAreaContainer: " + r100);
        if ((r100 instanceof ConstraintLayout) == true) goto L5;
        if (r100 == null) goto L16;
        Sequence<View> r101 = ViewGroupKt.getChildren(r100);
        if (r101 == null) goto L21;
        Iterator<View> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L22;
        View r103 = r102.next();
        if ((r103 instanceof ConstraintLayout) == false) goto L11;
        return (ConstraintLayout) r103;
    L22:
        return null;
    L21:
        return null;
    L16:
        return null;
    L5:
        return (ConstraintLayout) r100;
    }
}
