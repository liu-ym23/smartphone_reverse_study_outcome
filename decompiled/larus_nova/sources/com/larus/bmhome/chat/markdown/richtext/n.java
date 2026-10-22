package com.larus.bmhome.chat.markdown.richtext;

import android.net.Uri;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.larus.bmhome.chat.layout.holder.helper.r0;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.utils.y0;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f307218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f307219b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f307220c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f307221d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f307222e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f307223f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f307224g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set<String> f307225h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<String> f307226i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<String> f307227j = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((t) r100).c()), Integer.valueOf(((t) r101).c()));
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f307228a;

        public b(a r100) {
            this.f307228a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f307228a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(Integer.valueOf(((t) r101).b()), Integer.valueOf(((t) r100).b()));
        }
    }

    public n() {
    }

    static {
        f307218a = new Regex("oc_[A-Za-z0-9_-]+");
        f307219b = CollectionsKt.listOf(new String[]{"user_id", "data-user-id", "data_user_id", Constants.JumpUrlConstants.URL_KEY_OPENID, "id"});
        f307220c = LazyKt.lazy(new k());
        f307221d = LazyKt.lazy(new l());
        f307222e = LazyKt.lazy(new m());
        f307223f = SetsKt.setOf(new String[]{"bear-test.bytedance.net", "docs-staging.bytedance.net", "docs.bytedance.net", "doubao.com", "feishu-boe.cn", "feishu-pre.cn", "feishu-staging.cn", "feishu.cn", "feishu.net", "larkoffice-pre.com", "larkoffice.com", "larksuite-pre.com", "larksuite-staging.com", "larksuite.com"});
        f307224g = SetsKt.setOf(new String[]{"base", DocumentType.BITABLE_NAME, "doc", "docs", DocumentType.DOCX_NAME, "file", DocumentType.FOLDER_NAME, "isv", DocumentType.MINDNOTE_NAME, "mindnotes", DocumentType.SHEET_NAME, "sheets", "slide", "slides", "wiki"});
        f307225h = SetsKt.setOf(new String[]{"drive", "space"});
        f307226i = SetsKt.setOf(new String[]{"app", "record"});
        f307227j = SetsKt.setOf(new String[]{"add", "record"});
    }

    public static final String a(String r110) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "&", "&amp;", false, 4, null), "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null), "\"", "&quot;", false, 4, null), "'", "&#39;", false, 4, null);
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= r100.length()) goto L14;
        int r103 = r100.codePointAt(r101);
        if (r103 > 127) goto L8;
        int r104 = 1;
    L9:
        r102 = r102 + r104;
        if (r102 > 32) goto L12;
        r101 = r101 + Character.charCount(r103);
        goto L4
    L12:
        return r100.substring(0, r101) + "...";
    L8:
        r104 = 2;
        goto L9
    L14:
        return r100;
    }

    public static List c(List r100) {
        List r101 = CollectionsKt.sortedWith(r100, new b(new a()));
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L21;
        t r104 = (t) r103.next();
        boolean r105 = true;
        if (r102.isEmpty() == true) goto L19;
        Iterator r106 = r102.iterator();
    L10:
        if (r106.hasNext() == false) goto L19;
        t r107 = (t) r106.next();
        if (r104.c() < r107.b()) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == false) goto L10;
        r105 = false;
        goto L19
    L14:
        if (r107.c() >= r104.b()) goto L16;
        r108 = true;
    L19:
        if (r105 == false) goto L4;
        r102.add(r104);
        goto L4
    L21:
        return r102;
    }

    public static List d(String r110) {
        ArrayList r100 = new ArrayList();
        Matcher r111 = ((Pattern) f307220c.getValue()).matcher(r110);
    L4:
        if (r111.find() == false) goto L89;
        String r101 = r111.group();
        String r102 = "";
        if (r101 != null) goto L8;
        String r103 = "";
    L9:
        String r104 = r111.group(2);
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        boolean r105 = false;
        if (StringsKt.isBlank(r104) == false) goto L15;
        Map r106 = MapsKt.emptyMap();
    L31:
        String r107 = r111.group(3);
        if (r107 != null) goto L35;
        r107 = "";
    L35:
        if (StringsKt.isBlank(r107) == false) goto L51;
        r107 = (String) r106.get("name");
        if (r107 != null) goto L51;
        r107 = (String) r106.get("data-user-name");
        if (r107 != null) goto L51;
        r107 = (String) r106.get(IGoogleService.ResponseKey.DISPLAY_NAME);
        if (r107 != null) goto L51;
        r107 = (String) r106.get("data_user_name");
        if (r107 != null) goto L51;
        r107 = (String) r106.get(ITwitterService.ResponseConstants.USER_NAME);
        if (r107 != null) goto L51;
        r107 = (String) r106.get("text");
        if (r107 != null) goto L51;
        r107 = (String) r106.get("title");
        if (r107 != null) goto L51;
        r107 = "";
    L51:
        String r108 = StringsKt.trim(StringsKt.trimStart(StringsKt.trim(q(r107)).toString(), new char[]{'@'})).toString();
        if (r108.length() != 0) goto L54;
        boolean r109 = true;
    L55:
        if (r109 == true) goto L58;
        r102 = "@".concat(r108);
    L58:
        String r112 = r102;
        if (r112.length() <= 0) goto L61;
        boolean r113 = true;
    L62:
        if (r113 == false) goto L4;
        Pair r114 = j(r106);
        String r115 = (String) r114.component1();
        String r116 = (String) r114.component2();
        if (r115 != null) goto L68;
        if (r116 != null) goto L68;
        boolean r117 = false;
    L69:
        int r118 = r111.start();
        int r119 = r111.end();
        String r120 = (String) r106.get("avatar_key");
        if (r120 == null) goto L78;
        if (r117 == true) goto L73;
    L75:
        boolean r121 = false;
    L76:
        if (r121 == false) goto L78;
        String r122 = r120;
    L79:
        String r123 = (String) r106.get(PickerReporterConstants.KEY.ENTITY_ID);
        if (r123 == null) goto L87;
        if (r117 == true) goto L83;
    L85:
        if (r105 == false) goto L87;
    L88:
        r100.add(new f(r118, r119, r112, r103, r115, r116, r122, r123));
        goto L4
    L83:
        if ((!StringsKt.isBlank(r123)) == false) goto L85;
        r105 = true;
    L87:
        r123 = null;
        goto L88
    L73:
        if ((!StringsKt.isBlank(r120)) == false) goto L75;
        r121 = true;
    L78:
        r122 = null;
    L68:
        r117 = true;
        goto L69
    L61:
        r113 = false;
        goto L62
    L54:
        r109 = false;
        goto L55
    L15:
        LinkedHashMap r124 = new LinkedHashMap();
        Matcher r125 = ((Pattern) f307222e.getValue()).matcher(r104);
    L17:
        if (r125.find() == false) goto L30;
        String r126 = r125.group(1);
        if (r126 != null) goto L21;
        r126 = "";
    L21:
        String r127 = r126.toLowerCase(Locale.ROOT);
        String r128 = r125.group(3);
        if (r128 != null) goto L25;
        r128 = "";
    L25:
        if (r127.length() <= 0) goto L27;
        boolean r129 = true;
    L28:
        if (r129 == false) goto L17;
        r124.put(r127, q(r128));
        goto L17
    L27:
        r129 = false;
        goto L28
    L30:
        r106 = r124;
        goto L31
    L8:
        r103 = r101;
        goto L9
    L89:
        return r100;
    }

    public static boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        return StringsKt.equals(UriProtector.parse(r100).getScheme(), "ailypartner", true);
    }

    public static boolean h(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        Uri r101 = UriProtector.parse(r(r100));
        if (StringsKt.equals(r101.getScheme(), "https", true) == false) goto L5;
    L7:
        String r102 = r101.getHost();
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        String r103 = r102.toLowerCase(Locale.ROOT);
        Set<String> r104 = f307223f;
        if ((r104 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r105 = r104.iterator();
    L17:
        if (r105.hasNext() == false) goto L27;
        String r106 = (String) r105.next();
        if (Intrinsics.areEqual(r103, r106) == false) goto L21;
    L24:
        boolean r107 = true;
    L25:
        if (r107 == false) goto L17;
        boolean r108 = false;
    L28:
        if (r108 == false) goto L30;
        return false;
    L30:
        List<String> r109 = r101.getPathSegments();
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r111 = r109.iterator();
    L32:
        if (r111.hasNext() == false) goto L34;
        r110.add(((String) r111.next()).toLowerCase(Locale.ROOT));
        goto L32
    L34:
        boolean r112 = CollectionsKt.contains(f307225h, CollectionsKt.firstOrNull(r110));
        if (CollectionsKt.contains(f307224g, CollectionsKt.getOrNull(r110, r112 ? 1 : 0)) == false) goto L40;
        if (r110.size() <= ((r112 ? 1 : 0) + 1)) goto L40;
        return true;
    L40:
        if (r110.size() != 2) goto L45;
        if (f307226i.contains(CollectionsKt.first(r110)) == false) goto L45;
        return true;
    L45:
        if (r110.size() == 4) goto L47;
    L53:
        return false;
    L47:
        if (Intrinsics.areEqual(ListProtector.get(r110, 0), "share") == false) goto L53;
        if (Intrinsics.areEqual(ListProtector.get(r110, 1), "base") == false) goto L53;
        if (f307227j.contains(ListProtector.get(r110, 2)) == false) goto L53;
        return true;
    L21:
        if (StringsKt.endsWith$default(r103, "." + r106, false, 2, null) == true) goto L24;
        r107 = false;
    L27:
        r108 = true;
        goto L28
    L13:
        if (r104.isEmpty() == false) goto L15;
    L5:
        if (StringsKt.equals(r101.getScheme(), "http", true) == true) goto L7;
        return false;
    }

    public static boolean i(char r100) {
        if ('a' <= r100) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
    L25:
        boolean r102 = true;
    L26:
        if (r102 == false) goto L28;
        return true;
    L28:
        if (StringsKt.contains$default(".-~!@#$%^&*+?:_/=<>%", r100, false, 2, null) == true) goto L33;
        return false;
    L33:
        return true;
    L10:
        if ('A' <= r100) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L25;
        if ('0' <= r100) goto L19;
    L21:
        boolean r104 = false;
    L22:
        if (r104 == true) goto L25;
        r102 = false;
        goto L26
    L19:
        if (r100 >= ':') goto L21;
        r104 = true;
        goto L22
    L12:
        if (r100 >= '[') goto L14;
        r103 = true;
        goto L15
    L5:
        if (r100 >= '{') goto L7;
        r101 = true;
        goto L8
    }

    public static Pair j(Map r100) {
        String r101 = (String) r100.get("user_id");
        if (r101 != null) goto L11;
        r101 = (String) r100.get("data-user-id");
        if (r101 != null) goto L11;
        r101 = (String) r100.get("data_user_id");
        if (r101 != null) goto L11;
        r101 = (String) r100.get(Constants.JumpUrlConstants.URL_KEY_OPENID);
        if (r101 != null) goto L11;
        r101 = (String) r100.get("id");
    L11:
        boolean r102 = true;
        String r103 = null;
        if (r101 != null) goto L14;
    L16:
        r101 = null;
    L17:
        List<String> r104 = f307219b;
        if ((r104 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r105 = r104.iterator();
    L24:
        if (r105.hasNext() == false) goto L35;
        CharSequence r106 = (CharSequence) r100.get((String) r105.next());
        if (r106 != null) goto L28;
    L31:
        boolean r107 = true;
    L33:
        if ((!r107) == false) goto L24;
        boolean r108 = true;
    L36:
        CharSequence r109 = (CharSequence) r100.get("chat_id");
        if (r109 != null) goto L39;
    L42:
        boolean r110 = true;
    L43:
        boolean r111 = !r110;
        String r112 = (String) r100.get("chat_id");
        if (r112 == null) goto L52;
        if (r108 == false) goto L47;
    L49:
        r102 = false;
    L50:
        if (r102 == false) goto L52;
    L53:
        if (r111 == true) goto L56;
        r103 = r101;
    L56:
        return TuplesKt.to(r103, r112);
    L47:
        if (f307218a.matches(r112) == false) goto L49;
    L52:
        r112 = null;
        goto L53
    L39:
        if (StringsKt.isBlank(r109) == true) goto L42;
        r110 = false;
        goto L43
    L28:
        if (StringsKt.isBlank(r106) == true) goto L31;
        r107 = false;
    L35:
        r108 = false;
        goto L36
    L20:
        if (r104.isEmpty() == false) goto L22;
    L14:
        if ((!StringsKt.isBlank(r101)) == false) goto L16;
        goto L16
    }

    public static String k(String r110) {
        Intrinsics.checkNotNullParameter(r110, "content");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return r110;
    L8:
        ArrayList r101 = (ArrayList) c(d(r110));
        if (r101.isEmpty() == false) goto L11;
        return r110;
    L11:
        StringBuilder r102 = new StringBuilder(r110.length());
        Iterator r103 = r101.iterator();
        int r104 = 0;
    L13:
        if (r103.hasNext() == false) goto L56;
        t r105 = (t) r103.next();
        if (r105.c() < r104) goto L13;
        r102.append(r110, r104, r105.c());
        String r106 = null;
        if ((r105 instanceof f) == false) goto L20;
        f r107 = (f) r105;
    L21:
        if (r107 == null) goto L54;
        String r108 = r107.f307194f;
        if (r108 == null) goto L26;
        Pair r109 = TuplesKt.to("chat_id", r108);
        if (r109 == null) goto L26;
    L29:
        String r111 = r107.f307195g;
        if (r111 != null) goto L32;
    L53:
        if (r106 == null) goto L54;
    L55:
        r102.append(r106);
        r104 = r105.b();
        goto L13
    L32:
        if ((!StringsKt.isBlank(r111)) == true) goto L35;
        r111 = null;
    L35:
        if (r111 == null) goto L53;
        String r112 = r107.f307196h;
        if (r112 == null) goto L53;
        Long r113 = StringsKt.toLongOrNull(r112);
        if (r113 == null) goto L42;
        long r114 = r113.longValue();
    L44:
        if (r114 <= 0) goto L46;
        boolean r115 = true;
    L47:
        if (r115 == true) goto L50;
        r112 = null;
    L50:
        if (r112 == null) goto L53;
        r106 = "<at " + ((String) r109.getFirst()) + "=\"" + a((String) r109.getSecond()) + "\" avatar_key=\"" + a(r111) + "\" entity_id=\"" + a(r112) + "\">" + a(r107.f307191c) + "</at>";
        goto L53
    L46:
        r115 = false;
        goto L47
    L42:
        r114 = 0;
    L26:
        String r116 = r107.f307193e;
        if (r116 == null) goto L53;
        r109 = TuplesKt.to("user_id", r116);
    L54:
        r106 = r105.a();
        goto L55
    L20:
        r107 = null;
        goto L21
    L56:
        r102.append(r110, r104, r110.length());
        return r102.toString();
    L5:
        r100 = false;
        goto L6
    }

    public static String l(String r100) {
        String r101 = StringsKt.trim(r100).toString();
        if (y0.e(r101) == false) goto L6;
        return r101;
    L6:
        return "https://" + r101;
    }

    public static r o(String r110) {
        Intrinsics.checkNotNullParameter(r110, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        Uri r111 = UriProtector.parse(r110);
        if (r111.isHierarchical() == true) goto L5;
        return null;
    L5:
        if (r111.getFragment() != null) goto L200;
        String r100 = r111.getScheme();
        if (r100 == null) goto L182;
        boolean r101 = false;
        switch(r100.hashCode()) {
            case -1963501277: goto L146;
            case 3143036: goto L104;
            case 109496913: goto L34;
            case 740154499: goto L13;
            default: goto L201;
        };
    L201:
        return null;
    L13:
        if (r100.equals("conversation") == false) goto L202;
        Intrinsics.checkNotNull(r111);
        String r102 = r111.getAuthority();
        if (r102 != null) goto L18;
        return null;
    L18:
        if ((!StringsKt.isBlank(r102)) == true) goto L21;
        r102 = null;
    L21:
        if (r102 == null) goto L203;
        String r103 = r111.getPath();
        if (r103 != null) goto L26;
    L27:
        r101 = true;
    L28:
        if (r101 == true) goto L30;
        return null;
    L30:
        if (r111.getQuery() == null) goto L185;
        return null;
    L185:
        return new r.b(r102);
    L26:
        if (r103.length() != 0) goto L28;
    L203:
        return null;
    L202:
        return null;
    L34:
        if (r100.equals(SlashMentionConfig.SLASH_CONTENT_SKILL) == false) goto L205;
        Set<Integer> r104 = s.f307240a;
        Intrinsics.checkNotNull(r111);
        Intrinsics.checkNotNullParameter(r111, "uri");
        if (Intrinsics.areEqual(r111.getScheme(), SlashMentionConfig.SLASH_CONTENT_SKILL) == false) goto L186;
        String r105 = r111.getAuthority();
        if (r105 != null) goto L41;
    L44:
        boolean r106 = true;
    L45:
        if (r106 == true) goto L187;
        String r107 = r111.getPath();
        if (r107 != null) goto L49;
    L52:
        boolean r108 = true;
    L53:
        if (r108 == false) goto L206;
        String r109 = UriProtector.getQueryParameter(r111, "type");
        if (r109 == null) goto L188;
        Integer r112 = StringsKt.toIntOrNull(r109);
        if (r112 == null) goto L189;
        int r113 = r112.intValue();
        Integer r114 = Integer.valueOf(r113);
        if (r114 == null) goto L66;
        if (r114.intValue() != 4) goto L66;
        String r115 = "path";
    L69:
        if (r115 == null) goto L207;
        Set r116 = ArraysKt.toSet(new String[]{"type", r115});
        if (Intrinsics.areEqual(UriProtector.getQueryParameterNames(r111), r116) == false) goto L90;
        Set r117 = r116;
        if ((r117 instanceof Collection) == true) goto L76;
    L78:
        Iterator r118 = r117.iterator();
    L80:
        if (r118.hasNext() == false) goto L87;
        if (UriProtector.getQueryParameters(r111, (String) r118.next()).size() != 1) goto L84;
        boolean r119 = true;
    L85:
        if (r119 == true) goto L80;
        boolean r120 = false;
    L88:
        if (r120 == false) goto L90;
        r101 = true;
        goto L90
    L84:
        r119 = false;
    L87:
        r120 = true;
        goto L88
    L76:
        if (r117.isEmpty() == false) goto L78;
    L90:
        if (r101 == false) goto L208;
        String r121 = UriProtector.getQueryParameter(r111, r115);
        if (r121 != null) goto L95;
        return null;
    L95:
        if ((!StringsKt.isBlank(r121)) == true) goto L98;
        r121 = null;
    L98:
        if (r121 != null) goto L100;
        return null;
    L100:
        if (Intrinsics.areEqual(r115, "path") == false) goto L102;
        r r122 = new r.d(r113, null, r121, 2);
    L175:
        return r122;
    L102:
        r122 = new r.d(r113, r121, null, 4);
        goto L175
    L208:
        return null;
    L207:
        return null;
    L66:
        if (CollectionsKt.contains(s.f307240a, r114) == false) goto L68;
        r115 = "id";
        goto L69
    L68:
        r115 = null;
        goto L69
    L189:
        return null;
    L188:
        return null;
    L206:
        return null;
    L49:
        if (r107.length() == 0) goto L52;
        r108 = false;
        goto L53
    L187:
        return null;
    L41:
        if (StringsKt.isBlank(r105) == true) goto L44;
        r106 = false;
        goto L45
    L186:
        return null;
    L205:
        return null;
    L104:
        if (r100.equals("file") == false) goto L209;
        Intrinsics.checkNotNull(r111);
        String r123 = r111.getAuthority();
        if (r123 != null) goto L109;
    L112:
        boolean r124 = true;
    L113:
        if (r124 == true) goto L115;
        return null;
    L115:
        if (f(r111, new String[]{"kind"}) == false) goto L210;
        String r125 = r111.getPath();
        if (r125 != null) goto L120;
        return null;
    L120:
        if (StringsKt.startsWith$default(r125, '/', false, 2, null) == true) goto L122;
    L124:
        if (r101 == true) goto L127;
        r125 = null;
    L127:
        if (r125 == null) goto L211;
        String r126 = UriProtector.getQueryParameter(r111, "kind");
        if (r126 == null) goto L194;
        int r127 = r126.hashCode();
        if (r127 == (-962584979)) goto L141;
        if (r127 == 3143036) goto L137;
        return null;
    L137:
        if (r126.equals("file") == false) goto L213;
        MessageFileKind r128 = MessageFileKind.FILE;
    L195:
        return new r.c(r125, r128);
    L213:
        return null;
    L141:
        if (r126.equals("directory") == false) goto L214;
        r128 = MessageFileKind.DIRECTORY;
        goto L195
    L214:
        return null;
    L194:
        return null;
    L211:
        return null;
    L122:
        if (r125.length() <= 1) goto L124;
        r101 = true;
        goto L124
    L210:
        return null;
    L109:
        if (r123.length() == 0) goto L112;
        r124 = false;
        goto L113
    L209:
        return null;
    L146:
        if (r100.equals(SlashMentionConfig.MENTION_CONTENT_ATTACHMENT) == false) goto L215;
        Intrinsics.checkNotNull(r111);
        String r129 = r111.getAuthority();
        if (r129 != null) goto L151;
        return null;
    L151:
        if ((!StringsKt.isBlank(r129)) == true) goto L154;
        r129 = null;
    L154:
        if (r129 != null) goto L157;
        return null;
    L157:
        if (f(r111, new String[]{"type"}) == false) goto L217;
        String r130 = UriProtector.getQueryParameter(r111, "type");
        if (r130 == null) goto L197;
        Integer r131 = StringsKt.toIntOrNull(r130);
        if (r131 != null) goto L164;
        return null;
    L164:
        if (r131.intValue() <= 0) goto L166;
        r101 = true;
    L166:
        if (r101 == true) goto L169;
        r131 = null;
    L169:
        if (r131 == null) goto L199;
        int r132 = r131.intValue();
        String r133 = r111.getPath();
        if (r133 != null) goto L173;
        r133 = "";
    L173:
        r122 = new r.a(r129.concat(r133), r132);
        goto L175
    L199:
        return null;
    L197:
        return null;
    L217:
        return null;
    L215:
        return null;
    L182:
        return null;
    L200:
        return null;
    }

    public static String q(String r110) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "&amp;", "&", false, 4, null), "&lt;", "<", false, 4, null), "&gt;", ">", false, 4, null), "&quot;", "\"", false, 4, null), "&apos;", "'", false, 4, null), "&#39;", "'", false, 4, null);
    }

    public static String r(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        StringBuilder r101 = new StringBuilder(r100.length());
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L14;
        char r103 = r100.charAt(r102);
        if (r103 != '\\') goto L12;
        int r104 = r102 + 1;
        if (r104 >= r100.length()) goto L12;
        if (i(r100.charAt(r104)) == false) goto L12;
        r101.append(r100.charAt(r104));
        r102 = r102 + 2;
    L12:
        r101.append(r103);
        r102 = r102 + 1;
        goto L4
    L14:
        return r101.toString();
    }

    public static String s(String r110) {
        Intrinsics.checkNotNullParameter(r110, "label");
        StringBuilder r100 = new StringBuilder(r110.length());
        int r101 = 0;
    L4:
        if (r101 >= r110.length()) goto L13;
        char r102 = r110.charAt(r101);
        int r103 = r101 + 1;
        Character r104 = StringsKt.getOrNull(r110, r103);
        if (r102 != '\\') goto L11;
        if (r104 == null) goto L11;
        if (StringsKt.contains$default("\\[]", r104.charValue(), false, 2, null) == false) goto L11;
        r100.append(r104.charValue());
        r101 = r101 + 2;
    L11:
        r100.append(r102);
        r101 = r103;
        goto L4
    L13:
        return r100.toString();
    }

    public static List e(String r110, List r111) {
        List r100 = r0.a(r110);
        ArrayList r101 = null;
        if (r100 == null) goto L52;
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((ArrayList) r100).iterator();
    L6:
        if (r103.hasNext() == false) goto L51;
        Triple r104 = (Triple) r103.next();
        int r105 = ((Number) r104.getFirst()).intValue();
        int r106 = ((Number) r104.getSecond()).intValue();
    L9:
        if (r106 >= r110.length()) goto L21;
        char r107 = r110.charAt(r106);
        if (i(r107) == true) goto L12;
        if (r107 != '\\') goto L20;
        int r108 = r106 + 1;
        if (r108 >= r110.length()) goto L20;
        if (i(r110.charAt(r108)) == false) goto L20;
        r106 = r106 + 2;
    L20:
        int r109 = p(r110, r106);
    L22:
        String r112 = l(r(r110.substring(r105, r109)));
        if (r105 >= 0) goto L25;
    L48:
        g r113 = null;
    L49:
        if (r113 == null) goto L6;
        r102.add(r113);
        goto L6
    L25:
        if (r109 > r110.length()) goto L48;
        if (r105 >= r109) goto L48;
        if (StringsKt.isBlank(r112) == true) goto L48;
        List r114 = r111;
        boolean r115 = false;
        if ((r114 instanceof Collection) == true) goto L32;
    L34:
        Iterator r116 = r114.iterator();
    L36:
        if (r116.hasNext() == false) goto L45;
        g r117 = (g) r116.next();
        if (r105 < r117.f307198b) goto L40;
    L42:
        boolean r118 = false;
    L43:
        if (r118 == false) goto L36;
        r115 = true;
        goto L45
    L40:
        if (r117.f307197a >= r109) goto L42;
        r118 = true;
    L45:
        if (r115 == true) goto L48;
        r113 = new g(r105, r109, r112, MessageMarkdownLinkSource.PLAIN_URL);
        goto L49
    L32:
        if (r114.isEmpty() == false) goto L34;
    L12:
        r106 = r106 + 1;
        goto L9
    L21:
        r109 = p(r110, r106);
        goto L22
    L51:
        r101 = r102;
    L52:
        if (r101 == null) goto L54;
        return r101;
    L54:
        return CollectionsKt.emptyList();
    }

    public static boolean f(Uri r100, String... r101) {
        Set r102 = ArraysKt.toSet(r101);
        if (Intrinsics.areEqual(UriProtector.getQueryParameterNames(r100), r102) == false) goto L27;
        Set r103 = r102;
        if ((r103 instanceof Collection) == true) goto L7;
    L9:
        Iterator r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L18;
        if (UriProtector.getQueryParameters(r100, (String) r104.next()).size() != 1) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == true) goto L11;
        boolean r106 = false;
    L19:
        if (r106 == false) goto L28;
        return true;
    L28:
        return false;
    L15:
        r105 = false;
    L18:
        r106 = true;
        goto L19
    L7:
        if (r103.isEmpty() == false) goto L9;
    L27:
        return false;
    }

    public static int p(String r100, int r101) {
    L2:
        if (r101 <= 0) goto L6;
        int r102 = r101 - 1;
        if (SetsKt.setOf(new Character[]{'.', ',', ';', '!', '?', ':'}).contains(Character.valueOf(r100.charAt(r102))) == false) goto L6;
        r101 = r102;
    L6:
        return r101;
    }

    public static i m(String r100, boolean r101, int r102) {
        boolean r103 = true;
        if ((r102 & 2) == 0) goto L6;
        r101 = true;
    L6:
        if ((r102 & 4) != 0) goto L9;
        r103 = false;
    L9:
        Intrinsics.checkNotNullParameter(r100, "content");
        return n(r100, r101, r103, false);
    }

    public static i n(String r210, boolean r211, boolean r212, boolean r213) {
        int r100 = 0;
        if (r210.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L9;
        ArrayList r102 = new ArrayList();
        if (r211 == false) goto L13;
        r102.addAll(d(r210));
    L13:
        ArrayList r103 = new ArrayList();
        Matcher r104 = ((Pattern) f307221d.getValue()).matcher(r210);
    L15:
        if (r104.find() == false) goto L64;
        String r105 = r104.group(1);
        String r106 = "";
        if (r105 != null) goto L19;
        r105 = "";
    L19:
        String r110 = s(r105);
        String r107 = r104.group(2);
        if (r107 == null) goto L23;
        r106 = r107;
    L23:
        String r111 = r(r106);
        if ((!StringsKt.isBlank(r110)) == false) goto L15;
        if ((!StringsKt.isBlank(r111)) == false) goto L15;
        r r112 = o(r111);
        if (r112 != null) goto L29;
        if (g(r111) == true) goto L56;
        String r108 = StringsKt.trim(r106).toString();
        if (StringsKt.startsWith$default(r108, "http://", false, 2, null) == false) goto L35;
    L54:
        boolean r109 = true;
    L55:
        if (r109 == false) goto L15;
    L35:
        if (StringsKt.startsWith$default(r108, "https://", false, 2, null) == true) goto L54;
        List r113 = r0.a(r108);
        if (r113 == null) goto L53;
        ArrayList r114 = (ArrayList) r113;
        if (r114.isEmpty() == true) goto L53;
        Iterator r115 = r114.iterator();
    L44:
        if (r115.hasNext() == false) goto L53;
        Triple r116 = (Triple) r115.next();
        if (((Number) r116.getFirst()).intValue() == 0) goto L48;
    L50:
        boolean r117 = false;
    L51:
        if (r117 == false) goto L44;
    L48:
        if (((Number) r116.getSecond()).intValue() != r108.length()) goto L50;
        r117 = true;
    L53:
        r109 = false;
    L56:
        int r118 = r104.start();
        int r119 = r104.end();
        if (h(r111) == false) goto L60;
        r110 = b(r110);
    L60:
        if (g(r111) == true) goto L63;
        r111 = l(r111);
    L63:
        r103.add(new com.larus.bmhome.chat.markdown.richtext.a(r118, r119, r110, r111));
        goto L15
    L29:
        r103.add(new u(r104.start(), r104.end(), b(r110), r110, r111, r112));
        goto L15
    L64:
        if (r212 == false) goto L66;
        r102.addAll(r103);
    L84:
        ArrayList r120 = (ArrayList) c(r102);
        if (r120.isEmpty() == false) goto L92;
        List r121 = e(r210, CollectionsKt.emptyList());
        List r122 = r121;
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
        Iterator r124 = r122.iterator();
    L88:
        if (r124.hasNext() == false) goto L91;
        r123.add(((g) r124.next()).f307199c);
        goto L88
    L91:
        return new i(r210, r121, CollectionsKt.take(CollectionsKt.distinct(r123), 25), 12);
    L92:
        StringBuilder r125 = new StringBuilder(r210.length());
        ArrayList r126 = new ArrayList();
        ArrayList r127 = new ArrayList();
        ArrayList r128 = new ArrayList();
        Iterator r129 = r120.iterator();
    L94:
        if (r129.hasNext() == false) goto L111;
        t r130 = (t) r129.next();
        if (r130.c() < r100) goto L94;
        r125.append(r210, r100, r130.c());
        int r131 = r125.length();
        r125.append(r130.a());
        int r132 = r125.length();
        if ((r130 instanceof com.larus.bmhome.chat.markdown.richtext.a) == false) goto L102;
        r126.add(new g(r131, r132, ((com.larus.bmhome.chat.markdown.richtext.a) r130).f307181d, MessageMarkdownLinkSource.MARKDOWN_LINK));
    L107:
        r100 = r130.b();
        goto L94
    L102:
        if ((r130 instanceof f) == false) goto L105;
        f r133 = (f) r130;
        r127.add(new h(r131, r132, r133.f307193e, r133.f307192d, r133.f307194f, r133.f307195g, r133.f307196h));
        goto L107
    L105:
        if ((r130 instanceof u) == false) goto L110;
        u r134 = (u) r130;
        r128.add(new j(r131, r132, r134.f307244d, r134.f307245e, r134.f307246f));
        goto L107
    L110:
        throw new NoWhenBranchMatchedException();
    L111:
        r125.append(r210, r100, r210.length());
        String r135 = r125.toString();
        List r136 = CollectionsKt.plus(r126, e(r135, r126));
        ArrayList r137 = new ArrayList();
        Iterator r138 = r136.iterator();
    L113:
        if (r138.hasNext() == false) goto L117;
        Object r139 = r138.next();
        if (o.a((g) r139) == true) goto L113;
        r137.add(r139);
        goto L113
    L117:
        ArrayList r140 = new ArrayList();
        Iterator r141 = r137.iterator();
    L119:
        if (r141.hasNext() == false) goto L123;
        Object r142 = r141.next();
        if (g(((g) r142).f307199c) == true) goto L119;
        r140.add(r142);
        goto L119
    L123:
        ArrayList r143 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r140, 10));
        Iterator r144 = r140.iterator();
    L125:
        if (r144.hasNext() == false) goto L128;
        r143.add(((g) r144.next()).f307199c);
        goto L125
    L128:
        return new i(r135, r136, r127, r128, CollectionsKt.take(CollectionsKt.distinct(r143), 25));
    L66:
        if (r213 == false) goto L84;
        ArrayList r145 = new ArrayList();
        Iterator r146 = r103.iterator();
    L69:
        if (r146.hasNext() == false) goto L83;
        Object r147 = r146.next();
        t r148 = (t) r147;
        if ((r148 instanceof u) == false) goto L74;
    L79:
        boolean r149 = true;
    L81:
        if (r149 == false) goto L69;
        r145.add(r147);
        goto L69
    L74:
        if ((r148 instanceof com.larus.bmhome.chat.markdown.richtext.a) == false) goto L80;
        com.larus.bmhome.chat.markdown.richtext.a r150 = (com.larus.bmhome.chat.markdown.richtext.a) r148;
        if (h(r150.f307181d) == true) goto L79;
        if (g(r150.f307181d) == true) goto L79;
    L80:
        r149 = false;
        goto L81
    L83:
        r102.addAll(r145);
        goto L84
    L9:
        return new i(r210, null, null, 30);
    L5:
        r101 = false;
        goto L7
    }
}
