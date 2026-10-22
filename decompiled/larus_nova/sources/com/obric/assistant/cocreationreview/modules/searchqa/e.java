package com.obric.assistant.cocreationreview.modules.searchqa;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.assistant.cocreationreview.c4;
import com.obric.assistant.cocreationreview.j5;
import com.obric.assistant.cocreationreview.k5;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements k5<c0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f387548a = null;

    static {
        f387548a = new e();
    }

    public e() {
    }

    @Override // com.obric.assistant.cocreationreview.k5
    public final View a(j5 r210, com.obric.assistant.cocreationreview.a r211) {
        c0 r100 = (c0) r211;
        Intrinsics.checkNotNullParameter(r210, "buildContext");
        Intrinsics.checkNotNullParameter(r100, "record");
        final Context r101 = r210.getContext();
        LinearLayout r102 = c4.k(r101);
        LinearLayout r103 = c4.k(r101);
        View r104 = new View(r101);
        r104.setBackgroundColor(-1512723);
        r104.setMinimumHeight(c4.c(r101, 1));
        c4.b(r103, r104, c4.c(r101, 1), 0, c4.c(r101, 8), 4);
        if ((!r100.f387543j.isEmpty()) == false) goto L35;
        List<s> r105 = r100.f387543j;
        LinearLayout r106 = c4.k(r101);
        c4.b(r106, c4.f(r101, "搜到的本地资料", 11.0f, h.f387551a.f387362e, 1), 0, 0, c4.c(r101, 6), 6);
        Iterator r107 = CollectionsKt.take(r105, 3).iterator();
        int r108 = 0;
    L6:
        if (r107.hasNext() == false) goto L34;
        Object r109 = r107.next();
        int r110 = r108 + 1;
        if (r108 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        final s r111 = (s) r109;
        LinearLayout r112 = c4.k(r101);
        r112.setPadding(c4.c(r101, 10), c4.c(r101, 8), c4.c(r101, 10), c4.c(r101, 8));
        r112.setBackground(c4.h(r101, -263172, 9, -1512723, 1));
        if (f.b(r111) == false) goto L13;
        r112.setClickable(true);
        r112.setOnClickListener(new b(r111));
    L27:
        if (f.c(r111) == false) goto L29;
        int r113 = -5721662;
    L30:
        c4.b(r112, c4.f(r101, r110 + ". " + r111.f387580a, 12.0f, r113, 1), 0, 0, 0, 14);
        if (f.b(r111) == false) goto L33;
        c4.b(r112, f.g(r101, r111), 0, c4.c(r101, 8), 0, 10);
    L33:
        c4.b(r106, r112, 0, 0, c4.c(r101, 7), 6);
        r108 = r110;
        goto L6
    L29:
        r113 = -15656921;
        goto L30
    L13:
        Intrinsics.checkNotNullParameter(r111, "<this>");
        String r114 = r111.f387589j;
        if (r114 != null) goto L16;
    L19:
        boolean r115 = true;
    L21:
        if ((!r115) == false) goto L24;
        r112.setClickable(true);
        r112.setOnClickListener(new c(r101, r111));
        goto L27
    L24:
        if (f.a(r111) == false) goto L27;
        r112.setClickable(true);
        r112.setOnClickListener(new d(r111));
        goto L27
    L16:
        if (StringsKt.isBlank(r114) == true) goto L19;
        r115 = false;
        goto L21
    L34:
        c4.b(r103, r106, 0, 0, c4.c(r101, 4), 6);
    L35:
        LinearLayout r116 = c4.e(r101);
        r116.setGravity(16);
        r116.setPadding(c4.c(r101, 12), c4.c(r101, 12), c4.c(r101, 12), c4.c(r101, 12));
        r116.setBackground(c4.h(r101, -262657, 16, -1512723, 1));
        r116.addView(c4.f(r101, "豆包回复", 13.0f, h.f387551a.f387362e, 1));
        TextView r117 = c4.f(r101, r100.f387542i, 14.0f, -11908796, 1);
        r117.setMaxLines(5);
        r117.setEllipsize(TextUtils.TruncateAt.END);
        r117.setPadding(c4.c(r101, 12), 0, c4.c(r101, 8), 0);
        r116.addView(r117, new LinearLayout.LayoutParams(0, -2, 1.0f));
        c4.b(r103, r116, 0, 0, c4.c(r101, 4), 6);
        c4.b(r102, r103, 0, 0, 0, 14);
        return r102;
    }
}
