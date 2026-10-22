package com.ss.android.lark.commonmark.html;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.b0;
import v7b.k;
import v7b.s;
import w7b.e;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f417161b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f417162c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f417163d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.commonmark.html.a f417164a;

    public static final class a {
    }

    static {
        f417161b = PatternProtector.compile("^<([a-zA-Z0-9\\-]+)([^>]*?)\\s*(\\/)?>$");
        f417162c = PatternProtector.compile("^</([a-zA-Z\\d\\-]+)>$");
        f417163d = PatternProtector.compile("\\s+([a-zA-Z0-9\\-_]+)(?:\\s*=\\s*(?:\"([^\"]*)\"|'([^']*)'|([^\\s>]+)))?");
    }

    public b(com.ss.android.lark.commonmark.html.a r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        this.f417164a = r100;
    }

    @Override // w7b.e
    public final s a(s r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        b(r100);
        return r100;
    }

    public final void b(s r110) {
        s r100 = r110.f553569e;
    L3:
        if (r100 == null) goto L5;
        b(r100);
        r100 = r100.f553572h;
        goto L3
    L5:
        s r111 = r110.f553569e;
    L6:
        if (r111 == null) goto L85;
        String r101 = "";
        s r102 = null;
        if ((r111 instanceof k) == false) goto L12;
        Matcher r103 = f417161b.matcher(((k) r111).f553558j);
        if (r103.find() == false) goto L12;
        String r104 = r103.group(1);
        if (r104 == null) goto L16;
        String r105 = r104.toLowerCase(Locale.getDefault());
    L17:
        if (r105 != null) goto L19;
        r105 = "";
    L19:
        String r106 = r103.group(2);
        if (r106 != null) goto L22;
    L25:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L29;
        Map r108 = MapsKt.emptyMap();
    L41:
        String r109 = r103.group(3);
        if (r109 != null) goto L44;
    L49:
        boolean r112 = false;
    L50:
        Triple r113 = new Triple(r105, r108, Boolean.valueOf(r112));
    L51:
        if (r113 == null) goto L84;
        String r114 = (String) r113.component1();
        Map r115 = (Map) r113.component2();
        if (((Boolean) r113.component3()).booleanValue() == true) goto L54;
        ArrayList r116 = new ArrayList(8);
        s r117 = r111.f553572h;
    L58:
        if (r117 == null) goto L76;
        if ((r117 instanceof k) == false) goto L67;
        Matcher r118 = f417162c.matcher(((k) r117).f553558j);
        if (r118.find() == false) goto L67;
        String r119 = r118.group(1);
        if (r119 == null) goto L67;
        String r120 = r119.toLowerCase(Locale.getDefault());
    L68:
        if (r120 != null) goto L70;
    L72:
        r116.add(r117);
        if ((r117 instanceof b0) == false) goto L75;
        r101 = r101 + ((b0) r117).f553548j;
    L75:
        r117 = r117.f553572h;
        goto L58
    L70:
        if (Intrinsics.areEqual(r120, r114) == false) goto L72;
        r102 = r117;
    L67:
        r120 = null;
    L76:
        if (r102 == null) goto L84;
        s r121 = this.f417164a.a(r114, r115);
        if (r121 == null) goto L84;
        r111.l(r121);
        List r122 = CollectionsKt.mutableListOf(new s[]{r111});
        r122.addAll(r116);
        r122.add(r102);
        Iterator r123 = r122.iterator();
    L81:
        if (r123.hasNext() == false) goto L83;
        ((s) r123.next()).p();
        goto L81
    L83:
        r111 = r121.f553572h;
        goto L6
    L54:
        s r124 = this.f417164a.a(r114, r115);
        if (r124 == null) goto L84;
        r111.l(r124);
        r111.p();
        r111 = r124.f553572h;
    L84:
        r111 = r111.f553572h;
        goto L6
    L44:
        if (r109.length() <= 0) goto L46;
        boolean r125 = true;
    L47:
        if (r125 != true) goto L49;
        r112 = true;
        goto L50
    L46:
        r125 = false;
        goto L47
    L29:
        LinkedHashMap r126 = new LinkedHashMap();
        Matcher r127 = f417163d.matcher(r106);
    L31:
        if (r127.find() == false) goto L40;
        String r128 = r127.group(1);
        String r129 = r127.group(2);
        if (r129 != null) goto L39;
        r129 = r127.group(3);
        if (r129 != null) goto L39;
        r129 = r127.group(4);
        if (r129 != null) goto L39;
        r129 = "";
    L39:
        r126.put(r128, r129);
        goto L31
    L40:
        r108 = r126;
        goto L41
    L22:
        if (StringsKt.isBlank(r106) == true) goto L25;
        r107 = false;
        goto L27
    L16:
        r105 = null;
    L12:
        r113 = null;
        goto L51
    }
}
