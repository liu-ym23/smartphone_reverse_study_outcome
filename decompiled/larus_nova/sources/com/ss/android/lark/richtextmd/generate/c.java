package com.ss.android.lark.richtextmd.generate;

import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larksuite.framework.utils.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.richtextmd.RichTextBISUUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.a0;
import v7b.e0;
import v7b.f;
import v7b.r;
import v7b.s;
import v7b.z;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f439561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<? extends s>, InterfaceC5271c<s>> f439562b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<? extends s>, InterfaceC5271c<s>> f439563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f439564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, RichTextElement> f439565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f439566d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinkedList<String> f439567e;

        public b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f439563a, r101.f439563a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f439564b, r101.f439564b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f439565c, r101.f439565c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f439566d, r101.f439566d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f439567e, r101.f439567e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f439563a.hashCode() * 31) + this.f439564b.hashCode()) * 31) + this.f439565c.hashCode()) * 31) + this.f439566d.hashCode()) * 31) + this.f439567e.hashCode();
        }

        public final String toString() {
            return "NodeHandleContext(nodeHandlers=" + this.f439563a + ", context=" + this.f439564b + ", eleMap=" + this.f439565c + ", idGen=" + this.f439566d + ", idStack=" + this.f439567e + ')';
        }

        public final Context getContext() {
            return this.f439564b;
        }

        public b(Map r100, Context r101) {
            LinkedHashMap r102 = new LinkedHashMap();
            AtomicInteger r103 = new AtomicInteger();
            LinkedList<String> r104 = new LinkedList();
            Intrinsics.checkNotNullParameter(r100, "nodeHandlers");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "eleMap");
            Intrinsics.checkNotNullParameter(r103, "idGen");
            Intrinsics.checkNotNullParameter(r104, "idStack");
            this.f439563a = r100;
            this.f439564b = r101;
            this.f439565c = r102;
            this.f439566d = r103;
            this.f439567e = r104;
        }

        public final void a(RichTextElement r100, RichTextElement r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            String r102 = String.valueOf(this.f439566d.getAndIncrement());
            this.f439565c.put(r102, r101);
            List<String> r103 = r100.getChildIds();
            if (r103 != null) goto L5;
            r103 = new ArrayList();
        L5:
            r103.add(r102);
            r100.setChildIds(r103);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.richtextmd.generate.c$c, reason: collision with other inner class name */
    public interface InterfaceC5271c<N extends s> {
        RichTextElement a(b r100, N r101);
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f439568a = null;

        static {
            int[] r100 = new int[RichTextElement.RichTextTag.values().length];
            r100[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[RichTextElement.RichTextTag.IMG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[RichTextElement.RichTextTag.MEDIA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[RichTextElement.RichTextTag.AT_USER_GROUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[RichTextElement.RichTextTag.AT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[RichTextElement.RichTextTag.DOCS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[RichTextElement.RichTextTag.MARKDOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f439568a = r100;
        }
    }

    static {
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f439561a = r100;
        this.f439562b = new LinkedHashMap();
    }

    public final RichText b(s r110) {
        Intrinsics.checkNotNullParameter(r110, "node");
        StringBuilder r100 = new StringBuilder("generate richText , node tree is ");
        boolean r101 = false;
        r100.append(r.a(r110, false));
        Log.d("MarkdownRichTextGenerator", r100.toString());
        b r102 = new b(this.f439562b, this.f439561a);
        a(r110, r102);
        RichText r111 = new RichText();
        Map<String, RichTextElement> r103 = r102.f439565c;
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        ArrayList r107 = new ArrayList();
        ArrayList r108 = new ArrayList();
        ArrayList r109 = new ArrayList();
        ArrayList r112 = new ArrayList();
        Iterator<Map.Entry<String, RichTextElement>> r113 = r103.entrySet().iterator();
    L4:
        if (r113.hasNext() == false) goto L18;
        Map.Entry<String, RichTextElement> r114 = r113.next();
        RichTextElement.RichTextTag r115 = r114.getValue().getTag();
        if (r115 != null) goto L8;
        int r116 = -1;
    L9:
        switch(r116) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L4;
        };
    L11:
        r112.add(r114.getKey());
        goto L4
    L12:
        r109.add(r114.getKey());
        goto L4
    L13:
        r108.add(r114.getKey());
        goto L4
    L14:
        r107.add(r114.getKey());
        goto L4
    L15:
        r106.add(r114.getKey());
        goto L4
    L16:
        r105.add(r114.getKey());
        goto L4
    L17:
        r104.add(r114.getKey());
        goto L4
    L8:
        r116 = d.f439568a[r115.ordinal()];
        goto L9
    L18:
        r111.setAnchorIds(r104);
        r111.setImageIds(r105);
        r111.setMediaIds(r106);
        r111.setAtIds(r108);
        r111.setDocsIds(r109);
        r111.setMarkdownIds(r112);
        r111.setAtUserGroupIds(r107);
        r111.setElementIds(p.a(r102.f439567e));
        RichText.RichTextElements r117 = new RichText.RichTextElements();
        r117.setDictionary(r102.f439565c);
        r111.setElements(r117);
        Lazy r118 = RichTextBISUUtils.f439556a;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        RichText.RichTextElements r119 = r111.getElements();
        if (r119 == null) goto L38;
        Map<String, RichTextElement> r120 = r119.getDictionary();
        if (r120 == null) goto L38;
        List<String> r121 = r111.getElementIds();
        Intrinsics.checkNotNull(r121);
        Iterator<T> r122 = r121.iterator();
    L25:
        if (r122.hasNext() == false) goto L38;
        RichTextElement r123 = r120.get((String) r122.next());
        if (r123 == null) goto L25;
        List<String> r124 = r123.getChildIds();
        if (r124 == null) goto L25;
        Iterator<T> r125 = r124.iterator();
    L33:
        if (r125.hasNext() == false) goto L25;
        RichTextElement r126 = r120.get((String) r125.next());
        if (r126 == null) goto L33;
        Lazy r127 = RichTextBISUUtils.f439556a;
        RichTextBISUUtils.e(r123.getStyle(), r126);
    L38:
        StringBuilder r128 = new StringBuilder("generate richText, richText is ");
        int r129 = com.ss.android.lark.widget.richtext.utils.d.f448390a;
        Intrinsics.checkNotNullParameter(r111, "richText");
        List<String> r130 = r111.getElementIds();
        List<String> r131 = r130;
        if (r131 != null) goto L41;
    L42:
        r101 = true;
    L43:
        if (r101 == false) goto L45;
        List r132 = CollectionsKt.emptyList();
    L57:
        r128.append(r132);
        Log.d("MarkdownRichTextGenerator", r128.toString());
        return r111;
    L45:
        RichText.RichTextElements r133 = r111.getElements();
        if (r133 == null) goto L49;
        Map<String, RichTextElement> r134 = r133.getDictionary();
        if (r134 == null) goto L49;
    L50:
        ArrayList r135 = new ArrayList();
        Iterator<T> r136 = r130.iterator();
    L52:
        if (r136.hasNext() == false) goto L56;
        String r137 = (String) r136.next();
        RichTextElement r138 = r134.get(r137);
        if (r138 == null) goto L52;
        int r139 = com.ss.android.lark.widget.richtext.utils.d.f448390a;
        Intrinsics.checkNotNull(r137);
        com.ss.android.lark.widget.richtext.utils.d.b(r137, r138, r134, r135, "Root");
        goto L52
    L56:
        r132 = r135;
    L49:
        r134 = MapsKt.emptyMap();
        goto L50
    L41:
        if (r131.isEmpty() == false) goto L43;
        goto L42
    }

    public final void a(s r110, b r111) {
        LinkedList<String> r100 = r111.f439567e;
        Map<String, RichTextElement> r101 = r111.f439565c;
        AtomicInteger r102 = r111.f439566d;
        InterfaceC5271c r103 = (InterfaceC5271c) ((LinkedHashMap) this.f439562b).get(r110.getClass());
        if (r103 == null) goto L5;
        RichTextElement r104 = r103.a(r111, r110);
    L6:
        int r105 = r100.size();
        if (r104 == null) goto L9;
        String r106 = String.valueOf(r102.getAndIncrement());
        r101.put(r106, r104);
        r100.push(r106);
        Map r107 = null;
    L23:
        s r112 = r110.f553569e;
    L24:
        if (r112 == null) goto L26;
        a(r112, r111);
        r112 = r112.f553572h;
        goto L24
    L26:
        boolean r113 = false;
        if (r106.length() <= 0) goto L29;
        boolean r114 = true;
    L30:
        if (r114 == false) goto L52;
        if (r104 == null) goto L52;
        ArrayList r115 = new ArrayList();
        LinkedList r108 = new LinkedList();
        if (r104.getTag() != RichTextElement.RichTextTag.PARAGRAPH) goto L36;
        r113 = true;
    L36:
        if ((!r100.isEmpty()) == false) goto L48;
        if (Intrinsics.areEqual(r100.getFirst(), r106) == true) goto L48;
        RichTextElement r109 = r101.get(r100.getFirst());
        if (r113 == false) goto L47;
        if (r109 == null) goto L43;
        RichTextElement.RichTextTag r116 = r109.getTag();
    L45:
        if (r116 != RichTextElement.RichTextTag.PARAGRAPH) goto L47;
        List<String> r117 = r109.getChildIds();
        Intrinsics.checkNotNull(r117);
        r109.setChildIds(CollectionsKt.plus(r117, p.a(r108)));
        r108.clear();
        r115.add(r100.pop());
        goto L36
    L43:
        r116 = null;
    L47:
        r108.add(r100.pop());
    L48:
        List<String> r118 = r104.getChildIds();
        Intrinsics.checkNotNull(r118);
        r104.setChildIds(CollectionsKt.plus(r118, p.a(r108)));
        Iterator r119 = p.a(r115).iterator();
    L50:
        if (r119.hasNext() == false) goto L76;
        r100.push((String) r119.next());
        goto L50
    L76:
        return;
    L52:
        if (r107 == null) goto L61;
        int r120 = r100.size() - r105;
        Iterator<String> r121 = r100.iterator();
    L54:
        int r122 = r120 - 1;
        if (r120 <= 0) goto L77;
        RichTextElement r123 = r101.get(r121.next());
        if (r123 == null) goto L60;
        RichTextBISUUtils.e(r107, r123);
    L60:
        r120 = r122;
        goto L54
    L77:
        return;
    L61:
        return;
    L29:
        r114 = false;
        goto L30
    L9:
        Lazy r124 = RichTextBISUUtils.f439556a;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if ((r110 instanceof a0) == false) goto L13;
        Map r125 = MapsKt.mapOf(TuplesKt.to("fontWeight", (String) RichTextBISUUtils.f439556a.getValue()));
    L22:
        r107 = r125;
        r106 = "";
        goto L23
    L13:
        if ((r110 instanceof f) == false) goto L16;
        r125 = MapsKt.mapOf(TuplesKt.to("fontStyle", (String) RichTextBISUUtils.f439557b.getValue()));
        goto L22
    L16:
        if ((r110 instanceof e0) == false) goto L19;
        r125 = MapsKt.mapOf(TuplesKt.to("-lark-textDecoration", (String) RichTextBISUUtils.f439559d.getValue()));
        goto L22
    L19:
        if ((r110 instanceof z) == false) goto L21;
        r125 = MapsKt.mapOf(TuplesKt.to("-lark-textDecoration", (String) RichTextBISUUtils.f439558c.getValue()));
        goto L22
    L21:
        r125 = null;
        goto L22
    L5:
        r104 = null;
        goto L6
    }

    public final <N extends s> void c(Class<N> r100, InterfaceC5271c<N> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f439562b.put(r100, r101);
    }
}
