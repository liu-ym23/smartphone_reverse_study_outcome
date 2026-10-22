package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.structure.Structure;
import com.bytedance.ee.plugin.common.ttpdfreader.Bookmark;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j0 {
    public final String a;
    public final HashMap<String, b> b;
    public final HashMap<String, List<String>> c;

    public static final class a {
    }

    public static final class b extends Bookmark {
        public final String a;
        public boolean b;
        public final int c;

        public b(String r2, int r3, String r4, long r5, List r7) {
            Intrinsics.checkNotNullParameter(r2, "hash");
            Intrinsics.checkNotNullParameter(r4, "title");
            Intrinsics.checkNotNullParameter(r7, "children");
            super(r7, r4, r5);
            this.a = r2;
            this.b = false;
            this.c = r3;
        }
    }

    static {
    }

    public j0(List<? extends Bookmark> r11) {
        Intrinsics.checkNotNullParameter(r11, "outline");
        this.a = "/";
        HashMap<String, b> r8 = new HashMap();
        this.b = r8;
        this.c = new HashMap();
        b r9 = new b("/", 0, "", 0, r11);
        r8.put(r9.a, r9);
        b("/", r9, r9.c);
    }

    public final void a(String r11, ArrayList<Structure.Paragraph> r12) {
        b r0 = this.b.get(r11);
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r11, this.a) == true) goto L9;
        r12.add(new Structure.Paragraph(r0.a, r0.getTitle(), r0.c, 0, true, !hu5.a.d(r0.getChildren()), r0.b));
    L9:
        if (r0.b == false) goto L11;
        return;
    L11:
        if (this.c.get(r11) == null) goto L18;
        List<String> r13 = this.c.get(r11);
        Intrinsics.checkNotNull(r13);
        Iterator<String> r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L19;
        a(r14.next(), r12);
        goto L14
    L19:
        return;
    }

    public final void b(String r12, Bookmark r13, int r14) {
        if (hu5.a.d(r13.getChildren()) == false) goto L5;
        return;
    L5:
        Iterator r16 = r13.getChildren().iterator();
    L7:
        if (r16.hasNext() == false) goto L15;
        Bookmark r0 = (Bookmark) r16.next();
        int r8 = r14 + 1;
        String r9 = du5.d.a(r0.getTitle() + r0.getPageIdx() + r8);
        Intrinsics.checkNotNull(r9);
        this.b.put(r9, new b(r9, r8, r0.getTitle(), r0.getPageIdx(), r0.getChildren()));
        List<String> r1 = this.c.get(r12);
        if ((r1 instanceof ArrayList) == false) goto L11;
        ArrayList r2 = (ArrayList) r1;
    L12:
        if (r2 != null) goto L14;
        r2 = new ArrayList();
        this.c.put(r12, r2);
    L14:
        r2.add(r9);
        Intrinsics.checkNotNull(r0);
        b(r9, r0, r8);
        goto L7
    L11:
        r2 = null;
        goto L12
    }
}
