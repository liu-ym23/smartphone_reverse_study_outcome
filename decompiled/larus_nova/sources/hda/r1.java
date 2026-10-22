package hda;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.obric.assistant.cocreationreview.modules.memory.MemoryDataReviewModuleKey;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r1 f484750a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f484751b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f484752c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f484753d = null;

    public r1() {
    }

    static {
        f484750a = new r1();
        f484751b = CollectionsKt.listOf(new String[]{"sandboxImageUri", "imageUri", "screenshotUri", "sourceImageUri", "sourceScreenshot", "source_screenshot", "screenshotPath", "screenshot_path", "contentUrl", "content_url", "uri", "url", "path", "localPath", "local_path", "filePath", "file_path", IHostShare.ShareType.SCREENSHOT});
        f484752c = CollectionsKt.listOf(new String[]{"sourceText", "source_text", "originalText", "original_text", "rawText", "raw_text", "screenText", "screen_text", "pageText", "page_text", "ocrText", "ocr_text", "text", "content", "message"});
        f484753d = CollectionsKt.listOf(new String[]{"sourceQuery", "source_query", "query"});
    }

    public static List j() {
        return CollectionsKt.listOf(new String[]{"rawObservations", "sourceEvidence", "evidenceList", "sources"});
    }

    public static String c(String r100) {
        if (r100 == null) goto L7;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L7;
        String r102 = r101.toLowerCase(Locale.ROOT);
    L9:
        if (Intrinsics.areEqual(r102, "user") == false) goto L12;
        return "用户";
    L12:
        if (Intrinsics.areEqual(r102, "assistant") == false) goto L14;
        return "豆包";
    L14:
        if (r100 == null) goto L19;
        if ((!StringsKt.isBlank(r100)) == false) goto L19;
        return r100;
    L19:
        return null;
    L7:
        r102 = null;
        goto L9
    }

    public static List d(final Object r100) {
        int r101 = 0;
        if ((r100 instanceof String) == false) goto L48;
        String r102 = StringsKt.trim((String) r100).toString();
        if (StringsKt.isBlank(r102) == false) goto L58;
        return CollectionsKt.emptyList();
    L58:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
        if (StringsKt.startsWith$default(r102, "{", false, 2, null) == false) goto L12;
        List r104 = d(new JSONObject(r102));     // Catch: Throwable -> L17
    L15:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L17
    L19:
        List r106 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r105) == false) goto L22;
        r105 = r106;
    L22:
        List r107 = (List) r105;
        if ((!r107.isEmpty()) == true) goto L62;
        String r108 = StringsKt.trim(r102).toString();
        if (StringsKt.isBlank(r108) == false) goto L29;
    L41:
        r108 = null;
    L42:
        if (r108 == null) goto L44;
        List r109 = CollectionsKt.listOf(r108);
    L45:
        if (r109 == null) goto L64;
        return r109;
    L64:
        return CollectionsKt.emptyList();
    L44:
        r109 = null;
        goto L45
    L29:
        if (StringsKt.startsWith$default(r108, "http://", false, 2, null) == true) goto L41;
        if (StringsKt.startsWith$default(r108, "https://", false, 2, null) == true) goto L41;
        if (StringsKt.startsWith$default(r108, "content://", false, 2, null) == true) goto L42;
        if (StringsKt.startsWith$default(r108, MSkiaImageRegionDecoder.FILE_PREFIX, false, 2, null) == true) goto L42;
        if (StringsKt.startsWith$default(r108, HTTP.URL_DEFAULT, false, 2, null) == false) goto L41;
        r108 = MSkiaImageRegionDecoder.FILE_PREFIX + r108;
        goto L42
    L62:
        return r107;
    L12:
        if (StringsKt.startsWith$default(r102, "[", false, 2, null) == false) goto L14;
        r104 = d(new JSONArray(r102));     // Catch: Throwable -> L17
        goto L15
    L14:
        r104 = CollectionsKt.emptyList();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L48:
        if ((r100 instanceof JSONObject) == false) goto L51;
        return SequencesKt.toList(SequencesKt.distinct(SequencesKt.flatMap(SequencesKt.filter(CollectionsKt.asSequence(f484751b), new m1(r100)), new n1(r100))));
    L51:
        if ((r100 instanceof JSONArray) == false) goto L57;
        ArrayList r111 = new ArrayList();
        JSONArray r112 = (JSONArray) r100;
        int r113 = r112.length();
    L53:
        if (r101 >= r113) goto L66;
        r111.addAll(d(r112.opt(r101)));
        r101 = r101 + 1;
        goto L53
    L66:
        return CollectionsKt.distinct(r111);
    L57:
        return CollectionsKt.emptyList();
    }

    public static boolean e(JSONObject r100) {
        if (Intrinsics.areEqual(f1.a(r100, new String[]{"type", "sourceType", "source_type"}), "dialog_bubble") == false) goto L5;
        return true;
    L5:
        boolean r101 = false;
        String[] r102 = (String[]) f484753d.toArray(new String[0]);
        String r103 = f1.a(r100, (String[]) Arrays.copyOf(r102, r102.length));
        if (r103 != null) goto L8;
    L9:
        r101 = true;
    L11:
        return !r101;
    L8:
        if (StringsKt.isBlank(r103) == false) goto L11;
        goto L9
    }

    public static e1 f(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        return h(r100, true);
    }

    public static boolean i(o0 r100) {
        if (Intrinsics.areEqual(r100.c(new String[]{"sourceType"}), "dialog_bubble") == false) goto L5;
        return true;
    L5:
        boolean r101 = false;
        String[] r102 = (String[]) f484753d.toArray(new String[0]);
        String r103 = r100.c((String[]) Arrays.copyOf(r102, r102.length));
        if (r103 != null) goto L8;
    L9:
        r101 = true;
    L10:
        if (r101 == true) goto L12;
        return true;
    L12:
        final Ref.BooleanRef r104 = new Ref.BooleanRef();
        Iterator r105 = j().iterator();
    L14:
        if (r105.hasNext() == false) goto L19;
        JSONArray r106 = r100.a((String) r105.next());
        if (r106 == null) goto L14;
        f1.b(r106, new q1(r104));
        goto L14
    L19:
        return r104.element;
    L8:
        if (StringsKt.isBlank(r103) == false) goto L10;
        goto L9
    }

    public final List<d> g(String r100) {
        String r101 = StringsKt.trim(r100).toString();
        List<d> r102 = null;
        if (StringsKt.startsWith$default(r101, "[", false, 2, null) == false) goto L5;
    L31:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        if (StringsKt.startsWith$default(r101, "[", false, 2, null) == false) goto L10;
        JSONArray r104 = new JSONArray(r101);     // Catch: Throwable -> L13
    L11:
        final ArrayList r105 = new ArrayList();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L13
        f1.b(r104, new h1(r105, this));     // Catch: Throwable -> L13
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L13
    L15:
        List r107 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r106) == false) goto L18;
        r106 = r107;
    L18:
        List<d> r108 = (List) r106;
    L20:
        if ((!r108.isEmpty()) == true) goto L23;
        r108 = null;
    L23:
        if (r108 == null) goto L25;
        return r108;
    L25:
        List<d> r109 = SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.mapNotNull(StringsKt.lineSequence(r100), new o1()), new p1()));
        if ((!r109.isEmpty()) == false) goto L28;
        r102 = r109;
    L28:
        if (r102 == null) goto L30;
        return r102;
    L30:
        return CollectionsKt.emptyList();
    L10:
        r104 = new JSONArray().put(new JSONObject(r101));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (StringsKt.startsWith$default(r101, "{", false, 2, null) == true) goto L31;
        r108 = CollectionsKt.emptyList();
        goto L20
    }

    public static final void b(List<String> r100, String r101) {
        String r102 = c1.c(r101);
        if (r102 != null) goto L5;
        return;
    L5:
        List<String> r103 = r100;
        boolean r104 = true;
        if ((r103 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r105 = r103.iterator();
    L12:
        if (r105.hasNext() == false) goto L16;
        if (Intrinsics.areEqual((String) r105.next(), r102) == false) goto L12;
        r104 = false;
    L16:
        if (r104 == false) goto L22;
        r100.add(r102);
        return;
    L22:
        return;
    L8:
        if (r103.isEmpty() == false) goto L10;
        goto L10
    }

    public static e1 h(final q0 r310, boolean r311) {
        o0 r100 = new o0(r310);
        String r101 = r100.c(new String[]{"title"});
        if (r101 != null) goto L10;
        r101 = r310.f484742c;
        if (r101 != null) goto L10;
        r101 = r100.c(new String[]{"displayTitle", "name", "topic", "keyPhrase", "tagPath", "sourceEntityId", "entityId"});
        if (r101 != null) goto L10;
        r101 = r310.f484740a;
    L10:
        if (r310.f484741b != MemoryDataReviewModuleKey.AUTO_MEMORY_PRO) goto L12;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        String r102 = StringsKt.trim(r101).toString();
    L13:
        String r103 = r102;
        String r104 = r310.f484743d;
        String r105 = "";
        if (r104 != null) goto L18;
        r104 = r100.c(new String[]{"displaySummary", "summaryText", "summary", "memoryContent", "currentContent", "content", "description", "embeddingContent", "transcriptText"});
        if (r104 != null) goto L18;
        r104 = "";
    L18:
        Intrinsics.checkNotNullParameter(r104, "<this>");
        String r110 = b1.a(r104);
        String r111 = c1.c(r100.c(new String[]{"currentContent", "memoryContent", "content", "description", "embeddingContent", "summaryText", "displaySummary", "transcriptText"}));
        String r210 = c1.c(r100.c(new String[]{"previousContent", "oldContent", "oldDescription", "previousSummary", "oldSummary", "previousTranscript", "oldTranscript"}));
        String r106 = c1.c(r100.c(new String[]{"diffCurrentContent", "diffCurrentText", "currentKeyPhrase", "keyPhrase"}));
        if (r310.f484741b != MemoryDataReviewModuleKey.PERSONAL_MEMORY) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == true) goto L25;
        r106 = null;
    L25:
        if (r106 != null) goto L29;
        r106 = c1.c(r100.c(new String[]{"diffCurrentContent", "diffCurrentText"}));
        if (r106 != null) goto L29;
        String r211 = r111;
    L30:
        String r108 = c1.c(r100.c(new String[]{"diffPreviousContent", "diffOldContent", "diffOldText", "previousKeyPhrase", "oldKeyPhrase"}));
        if (r108 != null) goto L33;
        String r212 = r210;
    L35:
        if (r310.f484741b == MemoryDataReviewModuleKey.COLLECTION_MEMORY) goto L37;
        if (r111 != null) goto L45;
        String r109 = r110;
    L46:
        final ArrayList r112 = new ArrayList();
        Iterator r113 = CollectionsKt.listOf(new String[]{"chatBubbles", "conversation", "dialogBubbles", "messageBubbles"}).iterator();
    L48:
        if (r113.hasNext() == false) goto L52;
        JSONArray r114 = r100.a((String) r113.next());
        if (r114 == null) goto L48;
        f1.b(r114, new j1(r112));
        goto L48
    L52:
        Iterator r115 = j().iterator();
    L54:
        if (r115.hasNext() == false) goto L59;
        JSONArray r116 = r100.a((String) r115.next());
        if (r116 == null) goto L54;
        f1.b(r116, new k1(r112));
        goto L54
    L59:
        if (r112.isEmpty() == false) goto L66;
        if (i(r100) == false) goto L66;
        String r117 = r100.c(new String[]{"sourceText", "source_text"});
        if (r117 == null) goto L66;
        r112.addAll(f484750a.g(r117));
    L66:
        if (r311 == false) goto L70;
        JSONArray r118 = r100.a("versionRecords");
        if (r118 == null) goto L70;
        Integer r119 = Integer.valueOf(r118.length());
    L72:
        if (r310.f484741b != MemoryDataReviewModuleKey.PERSONAL_MEMORY) goto L92;
        String[] r120 = {"type", "productType", "product_type"};
        Intrinsics.checkNotNullParameter(r120, "keys");
        int r121 = 0;
    L76:
        if (r121 >= 3) goto L86;
        String r122 = r120[r121];
        if (r100.f484737a.has(r122) == false) goto L85;
        if (r100.f484737a.isNull(r122) == true) goto L85;
        Integer r123 = StringsKt.toIntOrNull(r100.f484737a.optString(r122));
        if (r123 == null) goto L85;
        Integer r124 = Integer.valueOf(r123.intValue());
    L87:
        if (r124 == null) goto L92;
        if (r124.intValue() != 1001) goto L92;
        boolean r125 = true;
    L94:
        if (r310.f484741b != MemoryDataReviewModuleKey.AUTO_MEMORY_PRO) goto L112;
        Long r126 = r100.b(new String[]{"modifyTime", "modify_time"});
        if (r126 != null) goto L98;
    L111:
        r105 = p0.a(r310);
    L113:
        String r127 = r310.f484740a;
        MemoryDataReviewModuleKey r128 = r310.f484741b;
        String r213 = r105;
        String r214 = r109;
        String r129 = r100.c(new String[]{"sourceEntityId", "source_entity_id", "entityId", PickerReporterConstants.KEY.ENTITY_ID});
        String r130 = r100.d();
        JSONObject r131 = r100.f484737a.optJSONObject("sourceInfo");
        if (r131 == null) goto L117;
        String r132 = p0.b(r131, "packageName");
        if (r132 == null) goto L117;
    L120:
        String r133 = r132;
        if (r125 == false) goto L123;
        final List r134 = CollectionsKt.emptyList();
        String r312 = r129;
        String r313 = r110;
        String r215 = r130;
    L139:
        if (r125 == false) goto L141;
        List r135 = CollectionsKt.emptyList();
    L142:
        if (r125 == false) goto L144;
        List r136 = CollectionsKt.emptyList();
    L156:
        String r137 = r100.c(new String[]{"availableVersionCount", "versionCount"});
        if (r137 == null) goto L161;
        Integer r138 = StringsKt.toIntOrNull(r137);
        if (r138 == null) goto L161;
        int r139 = RangesKt.coerceAtLeast(r138.intValue() - 1, 0);
    L181:
        int r314 = r139;
    L183:
        if (r311 == false) goto L188;
        final ArrayList r140 = new ArrayList();
        JSONArray r141 = r100.a("versionRecords");
        if (r141 == null) goto L187;
        f1.b(r141, new i1(r310, r140));
    L187:
        List<e1> r142 = f1.d(r140);
    L190:
        return new e1(r127, r128, r103, r313, r214, r312, r213, r215, r133, r134, r135, r136, r111, r210, r211, r212, r314, r142, r310.f484744e, r310.f484746g);
    L188:
        r142 = CollectionsKt.emptyList();
    L161:
        if (r119 != null) goto L163;
    L171:
        String r143 = r100.c(new String[]{"updateCount", "updateTimes"});
        if (r143 == null) goto L176;
        Integer r144 = StringsKt.toIntOrNull(r143);
        if (r144 == null) goto L176;
        r139 = RangesKt.coerceAtLeast(r144.intValue(), 0);
    L176:
        String r145 = r100.c(new String[]{"snapshotVersion", "version"});
        if (r145 == null) goto L182;
        Integer r146 = StringsKt.toIntOrNull(r145);
        if (r146 == null) goto L182;
        r139 = RangesKt.coerceAtLeast(r146.intValue() - 1, 0);
    L182:
        r314 = 0;
        goto L183
    L163:
        if (r119.intValue() <= 0) goto L165;
        boolean r147 = true;
    L166:
        if (r147 == false) goto L168;
        Integer r148 = r119;
    L169:
        if (r148 == null) goto L171;
        r139 = RangesKt.coerceAtLeast(r148.intValue() - 1, 0);
        goto L181
    L168:
        r148 = null;
        goto L169
    L165:
        r147 = false;
        goto L166
    L144:
        final ArrayList r149 = new ArrayList();
        if (r112.isEmpty() == true) goto L147;
    L149:
        b(r149, r100.c(new String[]{"originalText", "original_text", "rawText", "raw_text"}));
        b(r149, r100.c(new String[]{"screenText", "screen_text", "pageText", "page_text", "ocrText", "ocr_text"}));
        Iterator r150 = j().iterator();
    L151:
        if (r150.hasNext() == false) goto L155;
        JSONArray r151 = r100.a((String) r150.next());
        if (r151 == null) goto L151;
        f1.b(r151, new l1(r149));
        goto L151
    L155:
        r136 = r149;
        goto L156
    L147:
        if (i(r100) == true) goto L149;
        b(r149, r100.c(new String[]{"sourceText", "source_text"}));
        goto L149
    L141:
        r135 = r112;
        goto L142
    L123:
        r134 = new ArrayList();
        final HashSet r152 = new HashSet();
        Iterator<T> r216 = f484751b.iterator();
    L125:
        if (r216.hasNext() == false) goto L133;
        String r217 = r130;
        String r153 = (String) r216.next();
        String r315 = r129;
        if (r100.f484737a.has(r153) == false) goto L132;
        if (r100.f484737a.isNull(r153) == true) goto L132;
        a(r152, r134, "图片", r100.f484737a.opt(r153), null);
    L132:
        r130 = r217;
        r129 = r315;
        r110 = r110;
        goto L125
    L133:
        r312 = r129;
        r313 = r110;
        r215 = r130;
        Iterator r154 = CollectionsKt.plus(j(), CollectionsKt.listOf(new String[]{"images", "screenshots"})).iterator();
    L135:
        if (r154.hasNext() == false) goto L139;
        final String r155 = (String) r154.next();
        JSONArray r156 = r100.a(r155);
        if (r156 == null) goto L135;
        f1.b(r156, new g1(r155, r152, r134));
        r154 = r154;
    L117:
        r132 = p0.b(r100.f484737a, "sourcePackageName");
        if (r132 != null) goto L120;
        r132 = p0.b(r100.f484737a, "sourceAppPackage");
        goto L120
    L98:
        if (r126.longValue() <= 0) goto L100;
        boolean r157 = true;
    L101:
        if (r157 == true) goto L104;
        r126 = null;
    L104:
        if (r126 == null) goto L111;
        long r158 = r126.longValue();
        if (r158 <= 0) goto L109;
        r105 = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(r158));
    L109:
        if (r105 == null) goto L111;
    L100:
        r157 = false;
        goto L101
    L112:
        r105 = p0.a(r310);
    L85:
        r121 = r121 + 1;
        goto L76
    L86:
        r124 = null;
    L92:
        r125 = false;
    L70:
        r119 = null;
    L45:
        r109 = r111;
        goto L46
    L37:
        if ((!StringsKt.isBlank(r110)) == false) goto L39;
        r109 = r110;
    L40:
        if (r109 != null) goto L46;
        if (r111 != null) goto L45;
        r109 = "";
        goto L46
    L39:
        r109 = null;
        goto L40
    L33:
        r212 = r108;
    L29:
        r211 = r106;
        goto L30
    L21:
        r107 = false;
        goto L22
    L12:
        r102 = c1.b(r101);
        goto L13
    }

    public static final void a(HashSet<String> r100, List<h0> r101, String r102, Object r103, String r104) {
        f484750a.getClass();
        Iterator r105 = d(r103).iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        String r106 = (String) r105.next();
        if (r100.add(r106) == false) goto L4;
        r101.add(new h0(r102, r106, r104));
        goto L4
    }
}
