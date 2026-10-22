package com.obric.assistant.cocreationreview.modules.proactive;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import com.obric.assistant.cocreationreview.c4;
import com.obric.assistant.cocreationreview.j5;
import com.obric.assistant.cocreationreview.k5;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements k5<q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f387467a = null;

    static {
        f387467a = new b();
    }

    public b() {
    }

    @Override // com.obric.assistant.cocreationreview.k5
    public final View a(j5 r100, com.obric.assistant.cocreationreview.a r101) {
        q r102 = (q) r101;
        Intrinsics.checkNotNullParameter(r100, "buildContext");
        Intrinsics.checkNotNullParameter(r102, "record");
        Context r103 = r100.getContext();
        LinearLayout r104 = c4.k(r103);
        r104.setPadding(0, 0, 0, 0);
        GradientDrawable r105 = new GradientDrawable();
        r105.setColor(0);
        r104.setBackground(r105);
        c4.b(r104, c4.f(r103, r102.f387502l, 14.0f, -15656921, 0), 0, 0, 0, 14);
        Iterator<T> r106 = r102.f387503m.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        c4.b(r104, c.a(r103, (a) r106.next()), 0, c4.c(r103, 8), 0, 10);
        goto L4
    L6:
        return r104;
    }
}
