package br5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.v2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.w2;
import idb.f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sbb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements v2.b {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.util.List] */
    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.v2.b
    public final d3 a(WikiTreeModel r12) {
        Intrinsics.checkNotNullParameter(r12, "treeModel");
        ?? r1 = new d3();
        e3 r2 = w2.a(r12);
        if (w2.d(r12) == false) goto L55;
        ?? r3 = r2.k(r2.d);
        String r4 = r2.d;
        f r5 = f.a();
        boolean r7 = true;
        if (r5.isEnable("ccm.workspace.pin_document_supported_type_filter") == true) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L53;
        ArrayList r8 = (ArrayList) r3;
        if (r8.isEmpty() == true) goto L53;
        if (r4 != null) goto L15;
    L18:
        boolean r9 = true;
    L19:
        if (r9 == true) goto L53;
        r3 = new ArrayList();
        Iterator r10 = r8.iterator();
    L23:
        if (r10.hasNext() == false) goto L33;
        Object r11 = r10.next();
        j r13 = (j) r11;
        if (Intrinsics.areEqual(r13.b, r4) == false) goto L27;
    L29:
        boolean r14 = false;
    L30:
        if (r14 == true) goto L23;
        r3.add(r11);
        goto L23
    L27:
        if (g.b(r13.d) == false) goto L29;
        r14 = true;
        goto L30
    L33:
        if (r3.isEmpty() == true) goto L49;
        Iterator r15 = r3.iterator();
    L37:
        if (r15.hasNext() == false) goto L49;
        j r16 = (j) r15.next();
        if (Intrinsics.areEqual(r16.b, r4) == false) goto L41;
    L46:
        boolean r17 = false;
    L47:
        if (r17 == false) goto L37;
    L50:
        if (r7 == true) goto L53;
        r3 = CollectionsKt.emptyList();
        goto L53
    L41:
        if (r16.h != (-3)) goto L43;
        boolean r18 = true;
    L44:
        if (r18 == true) goto L46;
        r17 = true;
        goto L47
    L43:
        r18 = false;
    L49:
        r7 = false;
        goto L50
    L15:
        if (r4.length() == 0) goto L18;
        r9 = false;
    L53:
        r1.a(r3);
        goto L55
    L7:
        if (r5.isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L9;
        r6 = true;
    L55:
        if (w2.f(r12) == false) goto L58;
        r1.a(r2.k(r2.e));
    L58:
        if (w2.e(r12) == false) goto L61;
        r1.a(r2.k(r2.c));
    L61:
        if (w2.b(r12) == false) goto L63;
        r1.a(r2.k(r2.b));
    L63:
        Intrinsics.checkNotNullParameter(r12, "treeModel");
        Intrinsics.checkNotNullParameter(r1, "uiList");
        r12.filterSingleNode(r1);
        r1.b();
        return r1;
    }
}
