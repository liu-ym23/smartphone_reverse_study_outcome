package ida;

import com.obric.assistant.cocreationreview.ModuleKey;
import hda.b1;
import hda.c1;
import hda.e1;
import hda.o0;
import hda.p0;
import hda.q0;
import hda.r0;
import hda.r1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class l implements r0<u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f489416a = null;

    static {
        f489416a = new l();
    }

    public l() {
    }

    public static JSONObject d(o0 r100) {
        String r101 = r100.c(new String[]{"transcript"});
        Object r102 = null;
        if (r101 != null) goto L15;
        return null;
    L15:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(new JSONObject(r101));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r104) == true) goto L14;
        r102 = r104;
    L14:
        return (JSONObject) r102;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // hda.r0
    public final String a(com.obric.assistant.cocreationreview.a r100) {
        u r101 = (u) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f489446n;
    }

    @Override // hda.r0
    public final String b(com.obric.assistant.cocreationreview.a r100) {
        u r101 = (u) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f489447o;
    }

    @Override // hda.r0
    public final com.obric.assistant.cocreationreview.a c(q0 r210) {
        Intrinsics.checkNotNullParameter(r210, "record");
        o0 r100 = new o0(r210);
        r1.f484750a.getClass();
        e1 r110 = r1.f(r210);
        String r101 = r210.f484743d;
        if (r101 != null) goto L7;
        r101 = r100.c(new String[]{"summaryText", "displaySummary", "summary"});
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        Intrinsics.checkNotNullParameter(r101, "<this>");
        String r102 = b1.a(r101);
        String r103 = r100.c(new String[]{"transcriptText"});
        if (r103 != null) goto L29;
        JSONObject r104 = r100.f484737a.optJSONObject("transcript");
        if (r104 == null) goto L17;
        String r105 = p0.b(r104, "content");
        if (r105 != null) goto L16;
        r105 = p0.b(r104, "text");
        if (r105 != null) goto L16;
        r105 = p0.b(r104, "value");
    L16:
        r103 = r105;
    L18:
        if (r103 != null) goto L29;
        JSONObject r106 = d(r100);
        if (r106 == null) goto L28;
        String r107 = p0.b(r106, "content");
        if (r107 != null) goto L27;
        String r108 = p0.b(r106, "text");
        if (r108 != null) goto L26;
        r103 = p0.b(r106, "value");
        goto L29
    L26:
        r103 = r108;
        goto L29
    L27:
        r103 = r107;
        goto L29
    L28:
        r103 = null;
        goto L29
    L17:
        r103 = null;
    L29:
        String r111 = c1.c(r103);
        Long r109 = r100.b(new String[]{"productType"});
        if (r109 == null) goto L32;
        Integer r112 = Integer.valueOf((int) r109.longValue());
    L33:
        boolean r113 = false;
        if (r112 != null) goto L37;
    L39:
        boolean r114 = false;
    L40:
        String r115 = r210.f484740a;
        ModuleKey r116 = ModuleKey.AUDIO_MEMORY;
        String r117 = p0.a(r210);
        Long r118 = r100.b(new String[]{"startTimestamp", "createTime"});
        if (r118 != null) goto L43;
    L50:
        String r119 = r117;
        String r120 = r100.d();
        if (r120 != null) goto L53;
        r120 = r100.c(new String[]{"topic"});
    L53:
        String r121 = r120;
        String r122 = r110.f484657c;
        JSONObject r123 = r100.f484737a.optJSONObject("audioInfo");
        if (r123 == null) goto L60;
        JSONObject r124 = r123.optJSONObject("file");
        if (r124 == null) goto L60;
        String r125 = p0.b(r124, "fileName");
        if (r125 == null) goto L60;
    L78:
        String r126 = r100.c(new String[]{"transcriptContentUrl", "transcriptUrl"});
        if (r126 != null) goto L89;
        JSONObject r127 = r100.f484737a.optJSONObject("transcript");
        if (r127 == null) goto L83;
        r126 = p0.b(r127, "contentUrl");
    L84:
        if (r126 != null) goto L89;
        JSONObject r128 = d(r100);
        if (r128 == null) goto L88;
        String r129 = p0.b(r128, "contentUrl");
    L91:
        return new u(r115, r116, r119, r121, r122, r102, r125, r111, r129, r114, !r114, r110, r210.f484744e, r210.f484746g);
    L88:
        r129 = null;
        goto L91
    L83:
        r126 = null;
    L89:
        r129 = r126;
    L60:
        JSONObject r130 = r100.f484737a.optJSONObject("file");
        if (r130 == null) goto L63;
        r125 = p0.b(r130, "fileName");
    L64:
        if (r125 != null) goto L78;
        r125 = r100.c(new String[]{"fileName", "audioFileName", "recordingFileName"});
        if (r125 != null) goto L78;
        String r131 = r100.c(new String[]{"file"});
        if (r131 != null) goto L92;
        r125 = null;
        goto L78
    L92:
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L72
        Object r133 = Result.m9449constructorimpl(p0.b(new JSONObject(r131), "fileName"));     // Catch: Throwable -> L72
    L75:
        if (Result.m9455isFailureimpl(r133) == false) goto L77;
        r133 = null;
    L77:
        r125 = (String) r133;
    L72:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L75
    L63:
        r125 = null;
        goto L64
    L43:
        if (r118.longValue() <= 0) goto L45;
        r113 = true;
    L45:
        if (r113 == true) goto L48;
        r118 = null;
    L48:
        if (r118 == null) goto L50;
        r117 = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(r118.longValue()));
        goto L50
    L37:
        if (r112.intValue() != 1006) goto L39;
        r114 = true;
        goto L40
    L32:
        r112 = null;
        goto L33
    }
}
