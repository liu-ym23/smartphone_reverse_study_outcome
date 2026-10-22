package com.ss.android.lark.richtextmd.parse.impl;

import android.content.Context;
import b3c.d;
import com.ss.android.lark.coremd.utils.BISURelocator;
import com.ss.android.lark.coremd.utils.NodeBISUUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.richtextmd.RichTextBISUUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.e;
import v7b.s;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f439637f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f439638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<RichTextElement.RichTextTag, b3c.a> f439639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b3c.c> f439640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BISURelocator f439641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C5274b f439642e;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.richtextmd.parse.impl.b$b, reason: collision with other inner class name */
    public static final class C5274b implements b3c.a {
        public C5274b() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final s b(b3c.b r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return null;
        }
    }

    static {
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f439638a = r100;
        this.f439639b = new ConcurrentHashMap();
        this.f439640c = new ArrayList();
        this.f439641d = new BISURelocator();
        this.f439642e = new C5274b();
    }

    public final s b(Object r100) {
        RichText r101 = (RichText) r100;
        if (r101 != null) goto L5;
        r101 = com.ss.android.lark.widget.richtext.c.a();
    L5:
        Intrinsics.checkNotNull(r101);
        Iterator r102 = ((ArrayList) this.f439640c).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((b3c.c) r102.next()).onParseStart();
        goto L7
    L9:
        e r103 = new e();
        List<String> r104 = r101.getElementIds();
        RichText.RichTextElements r105 = r101.getElements();
        if (r105 == null) goto L25;
        Map r106 = r105.getDictionary();
        if (r106 == null) goto L25;
        Intrinsics.checkNotNull(r104);
        Iterator<T> r107 = r104.iterator();
    L16:
        if (r107.hasNext() == false) goto L21;
        RichTextElement r108 = r106.get((String) r107.next());
        if (r108 == null) goto L16;
        c(r106, r108, r103, r101.getExtraInfo());
        goto L16
    L21:
        this.f439641d.d(r103);
        Iterator r109 = ((ArrayList) this.f439640c).iterator();
    L23:
        if (r109.hasNext() == false) goto L25;
        ((b3c.c) r109.next()).onParseEnd();
    L25:
        return r103;
    }

    @Override // b3c.d
    public final d a(RichTextElement.RichTextTag r100, b3c.a r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "nodeMapper");
        this.f439639b.put(r100, r101);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    public final void c(Map r100, RichTextElement r101, s r110, RichTextExtraInfo r111) {
        c r102 = new c(this.f439638a, r101, this, r111, r100);
        Iterator r103 = ((ArrayList) this.f439640c).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((b3c.c) r103.next()).a();
        goto L4
    L6:
        b3c.a r104 = this.f439639b.get(r101.getTag());
        if (r104 != null) goto L9;
        r104 = this.f439642e;
    L9:
        s r105 = r104.b(r102);
        if (r105 == null) goto L26;
        Lazy r106 = RichTextBISUUtils.f439556a;
        Map<String, String> r107 = r101.getStyle();
        if (r107 != null) goto L14;
        r107 = MapsKt.emptyMap();
    L14:
        Intrinsics.checkNotNullParameter(r107, "styles");
        NodeBISUUtils r108 = NodeBISUUtils.f419961c;
        boolean r109 = RichTextBISUUtils.a(r107);
        boolean r112 = RichTextBISUUtils.b(r107);
        boolean r113 = RichTextBISUUtils.d(r107);
        boolean r114 = RichTextBISUUtils.c(r107);
        r108.getClass();
        ?? r115 = r109;
        if (r112 == false) goto L17;
        r115 = (r109 ? 1 : 0) | 2;
    L17:
        if (r113 == false) goto L19;
        r115 = (r115 == true ? 1 : 0) | '\b';
    L19:
        if (r114 == false) goto L21;
        r115 = (r115 == true ? 1 : 0) | 4;
    L21:
        Intrinsics.checkNotNullParameter(r105, "node");
        NodeBISUUtils.b(r105, r115);
        r110.e(r105);     // Catch: Exception -> L24
    L24:
        Log.e("RichTextToNodeGenerator", "parent node type is " + r110.getClass().getSimpleName() + ", node type is " + r105.getClass().getSimpleName());
    L26:
        if (r104.a() == false) goto L39;
        if (r105 == null) goto L30;
        r110 = r105;
    L30:
        List<String> r116 = r101.getChildIds();
        if (r116 == null) goto L39;
        Iterator r117 = r116.iterator();
    L34:
        if (r117.hasNext() == false) goto L39;
        RichTextElement r118 = (RichTextElement) r100.get((String) r117.next());
        if (r118 == null) goto L34;
        c(r100, r118, r110, r111);
    L39:
        Iterator r119 = ((ArrayList) this.f439640c).iterator();
    L41:
        if (r119.hasNext() == false) goto L43;
        ((b3c.c) r119.next()).b();
        goto L41
    }
}
