package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes25.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f298733a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f298734b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntRange f298735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d0 f298736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f298737c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f298735a, r101.f298735a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f298736b, r101.f298736b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f298737c, r101.f298737c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f298735a.hashCode() * 31;
            d0 r101 = this.f298736b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f298737c.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "DecodedReferenceMatch(range=" + this.f298735a + ", reference=" + this.f298736b + ", fallbackText=" + this.f298737c + ')';
        }

        public a(IntRange r100, d0 r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, FilterData.FilterOptionItem.Type.RANGE);
            Intrinsics.checkNotNullParameter(r102, "fallbackText");
            this.f298735a = r100;
            this.f298736b = r101;
            this.f298737c = r102;
        }
    }

    static {
        f298733a = new Regex("<(at|mention)\\b([^>]*)>(.*?)</\\1>", SetsKt.setOf(new RegexOption[]{RegexOption.IGNORE_CASE, RegexOption.DOT_MATCHES_ALL}));
        f298734b = new Regex("(?<!\\\\)\\[((?:\\\\[^\\r\\n]|[^\\x5D\\\\\\r\\n])+)]\\(([^\\s)]+)\\)");
    }

    public static String a(String r110) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "&", "&amp;", false, 4, null), "\"", "&quot;", false, 4, null), "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
    }

    public static String b(String r110) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "&", "&amp;", false, 4, null), "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
    }

    public static String h(d0 r210) {
        String r100 = r210.f298721g;
        String r101 = null;
        if (r100 != null) goto L5;
    L10:
        String r102 = r210.f298718d;
        if (r102 != null) goto L13;
    L15:
        if (r101 == null) goto L19;
        return "[" + StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(k0.a(r210), "\r\n", " ", false, 4, null), '\r', ' ', false, 4, null), '\n', ' ', false, 4, null), "\\", "\\\\", false, 4, null), "[", "\\[", false, 4, null), "]", "\\]", false, 4, null) + "](" + r101 + ')';
    L19:
        throw new IllegalArgumentException(("Reference protocol destination is required for " + r210.getType()).toString());
    L13:
        if ((!StringsKt.isBlank(r102)) == false) goto L15;
        r101 = r102;
        goto L15
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        return r100;
    }

    public static String c(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "entities");
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L15;
        UplinkFileEntity r104 = (UplinkFileEntity) r103.next();
        String r105 = r104.getFileIdentifier();
        Pair r106 = null;
        if (r105 != null) goto L8;
    L13:
        if (r106 == null) goto L4;
        r102.add(r106);
        goto L4
    L8:
        if ((!StringsKt.isBlank(r105)) == true) goto L11;
        r105 = null;
    L11:
        if (r105 == null) goto L13;
        r106 = TuplesKt.to(r105, r104);
        goto L13
    L15:
        final Map r107 = MapsKt.toMap(r102);
        if (r107.isEmpty() == false) goto L19;
        return r100;
    L19:
        return f298734b.replace(r100, new e0(r107));
    }

    public static boolean d(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "entities");
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L3:
        String r104 = null;
        if (r103.hasNext() == false) goto L12;
        String r105 = ((UplinkFileEntity) r103.next()).getFileIdentifier();
        if (r105 != null) goto L8;
    L10:
        if (r104 == null) goto L3;
        r102.add(r104);
        goto L3
    L8:
        if ((true ^ StringsKt.isBlank(r105)) == false) goto L10;
        r104 = r105;
        goto L10
    L12:
        Set r106 = CollectionsKt.toSet(r102);
        if (r106.isEmpty() == false) goto L15;
        return false;
    L15:
        Iterator r107 = Regex.findAll$default(f298734b, r100, 0, 2, null).iterator();
    L17:
        if (r107.hasNext() == false) goto L40;
        MatchResult r108 = (MatchResult) r107.next();
        MatchGroup r109 = r108.getGroups().get(1);
        if (r109 == null) goto L21;
        String r110 = r109.getValue();
    L22:
        String r111 = "";
        if (r110 != null) goto L25;
        r110 = "";
    L25:
        MatchGroup r112 = r108.getGroups().get(2);
        if (r112 == null) goto L28;
        String r113 = r112.getValue();
    L29:
        if (r113 == null) goto L32;
        r111 = r113;
    L32:
        d0 r114 = f(r110, r111);
        if (r114 == null) goto L37;
        String r115 = r114.f298715a;
        if (r115 == null) goto L37;
        boolean r116 = r106.contains(r115);
    L38:
        if (r116 == false) goto L17;
        return true;
    L37:
        r116 = false;
        goto L38
    L28:
        r113 = null;
        goto L29
    L21:
        r110 = null;
        goto L22
    L40:
        return false;
    }

    public static d0 f(String r100, String r101) {
        Regex r102 = com.larus.bmhome.chat.markdown.richtext.n.f307218a;
        d0 r103 = g(r100, com.larus.bmhome.chat.markdown.richtext.n.r(r101));
        if (r103 != null) goto L5;
    L10:
        return null;
    L5:
        if (r103.getType() != InputReferenceType.ATTACHMENT) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        return r103;
    L7:
        r104 = false;
        goto L8
    }

    public static d0 g(String r110, String r111) {
        Regex r100 = com.larus.bmhome.chat.markdown.richtext.n.f307218a;
        com.larus.bmhome.chat.markdown.richtext.r r101 = com.larus.bmhome.chat.markdown.richtext.n.o(r111);
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof com.larus.bmhome.chat.markdown.richtext.r.d) == false) goto L14;
        com.larus.bmhome.chat.markdown.richtext.r.d r102 = (com.larus.bmhome.chat.markdown.richtext.r.d) r101;
        String r103 = r102.f307238b;
        if (r103 != null) goto L12;
        r103 = r102.f307239c;
        if (r103 != null) goto L12;
        return null;
    L12:
        Pair r104 = TuplesKt.to(r103, InputReferenceType.SKILL);
    L23:
        return new d0((String) r104.component1(), r110, (InputReferenceType) r104.component2(), r111, null, null, null, null, null, null, 1008);
    L14:
        if ((r101 instanceof com.larus.bmhome.chat.markdown.richtext.r.b) == false) goto L17;
        r104 = TuplesKt.to(((com.larus.bmhome.chat.markdown.richtext.r.b) r101).f307234a, InputReferenceType.CONVERSATION);
        goto L23
    L17:
        if ((r101 instanceof com.larus.bmhome.chat.markdown.richtext.r.c) == false) goto L20;
        r104 = TuplesKt.to(((com.larus.bmhome.chat.markdown.richtext.r.c) r101).f307235a, InputReferenceType.FILE);
        goto L23
    L20:
        if ((r101 instanceof com.larus.bmhome.chat.markdown.richtext.r.a) == false) goto L25;
        r104 = TuplesKt.to(((com.larus.bmhome.chat.markdown.richtext.r.a) r101).f307232a, InputReferenceType.ATTACHMENT);
        goto L23
    L25:
        throw new NoWhenBranchMatchedException();
    }

    public static d0 e(String r110, String r111, String r112, String r113) {
        String r100 = null;
        if (r110 != null) goto L5;
    L56:
        return null;
    L5:
        if (new Regex("oc_[A-Za-z0-9_-]+").matches(r110) == false) goto L7;
        String r101 = r110;
    L8:
        if (r101 == null) goto L56;
        if (r111 == null) goto L56;
        String r102 = StringsKt.trim(r111).toString();
        if (r102 == null) goto L56;
        boolean r103 = true;
        if ((!StringsKt.isBlank(r102)) == false) goto L16;
        String r104 = r102;
    L17:
        if (r104 == null) goto L56;
        if (r113 == null) goto L31;
        Long r105 = StringsKt.toLongOrNull(r113);
        if (r105 == null) goto L24;
        long r106 = r105.longValue();
    L26:
        if (r106 <= 0) goto L28;
        boolean r107 = true;
    L29:
        if (r107 == false) goto L31;
        String r108 = r113;
    L32:
        if (r112 != null) goto L34;
    L40:
        String r114 = null;
    L41:
        String r109 = "";
        if (r114 == null) goto L48;
        StringBuilder r115 = new StringBuilder(" avatar_key=\"");
        r115.append(a(r114));
        r115.append("\" entity_id=\"");
        if (r108 == null) goto L47;
        r109 = r108;
    L47:
        r115.append(a(r109));
        r115.append(Typography.quote);
        r109 = r115.toString();
    L48:
        InputReferenceType r116 = InputReferenceType.GROUP;
        String r117 = "<at chat_id=\"" + a(r101) + Typography.quote + r109 + Typography.greater + b(r104) + "</at>";
        if (r114 != null) goto L52;
        r103 = false;
    L52:
        if (r103 == false) goto L55;
        r100 = r108;
    L55:
        return new d0(r101, r104, r116, null, null, null, r117, null, r114, r100, 184);
    L34:
        if ((!StringsKt.isBlank(r112)) == false) goto L37;
        if (r108 == null) goto L37;
        boolean r118 = true;
    L38:
        if (r118 == false) goto L40;
        r114 = r112;
    L37:
        r118 = false;
        goto L38
    L28:
        r107 = false;
        goto L29
    L24:
        r106 = 0;
    L31:
        r108 = null;
        goto L32
    L16:
        r104 = null;
        goto L17
    L7:
        r101 = null;
        goto L8
    }
}
