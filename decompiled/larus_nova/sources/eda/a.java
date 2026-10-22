package eda;

import com.obric.assistant.chat.component.list.pipeline.update.RecordingOperationCardKind;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.ugc.aweme.search.common.result.recycler.ECSaasScrollViewController;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f472237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f472238b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<b> f472239c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<C5769a> f472240d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Set<String>> f472241e = null;

    /* JADX INFO: renamed from: eda.a$a, reason: collision with other inner class name */
    public static final class C5769a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f472242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f472243b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5769a) == true) goto L8;
            return false;
        L8:
            C5769a r101 = (C5769a) r100;
            if (Intrinsics.areEqual(this.f472242a, r101.f472242a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f472243b, r101.f472243b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f472242a.hashCode() * 31) + this.f472243b.hashCode();
        }

        public final String toString() {
            return "MultiSelectionProtocol(widgetId=" + this.f472242a + ", type=" + this.f472243b + ')';
        }

        public final String getType() {
            return this.f472243b;
        }

        public C5769a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "widgetId");
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f472242a = r100;
            this.f472243b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f472244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f472245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f472246c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f472244a, r101.f472244a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f472245b, r101.f472245b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f472246c, r101.f472246c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f472244a.hashCode() * 31) + this.f472245b.hashCode()) * 31) + this.f472246c.hashCode();
        }

        public final String toString() {
            return "SingleSelectionProtocol(widgetId=" + this.f472244a + ", sourceIntent=" + this.f472245b + ", type=" + this.f472246c + ')';
        }

        public final String getType() {
            return this.f472246c;
        }

        public b(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "widgetId");
            Intrinsics.checkNotNullParameter(r101, "sourceIntent");
            Intrinsics.checkNotNullParameter(r102, "type");
            this.f472244a = r100;
            this.f472245b = r101;
            this.f472246c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JSONObject f472247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f472248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JSONObject f472249c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f472250d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f472247a, r101.f472247a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f472248b, r101.f472248b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f472249c, r101.f472249c) == true) goto L18;
            return false;
        L18:
            if (this.f472250d == r101.f472250d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f472247a.hashCode() * 31) + this.f472248b.hashCode()) * 31) + this.f472249c.hashCode()) * 31;
            if (this.f472250d == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "WidgetDocument(widgetInfo=" + this.f472247a + ", widgetId=" + this.f472248b + ", widgetData=" + this.f472249c + ", widgetDataEncodedAsString=" + this.f472250d + ')';
        }

        public c(JSONObject r100, String r101, JSONObject r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "widgetInfo");
            Intrinsics.checkNotNullParameter(r101, "widgetId");
            Intrinsics.checkNotNullParameter(r102, "widgetData");
            this.f472247a = r100;
            this.f472248b = r101;
            this.f472249c = r102;
            this.f472250d = r103;
        }
    }

    public a() {
    }

    static {
        f472237a = new a();
        f472238b = SetsKt.setOf("appintent_alarm");
        f472239c = SetsKt.setOf(new b[]{new b("appintent_contact", "Contacts_Update", "contact"), new b("appintent_contact", "Phone_Call", "telephone"), new b("appintent_contact", "Messages_Send", "telephone"), new b("appintent_contact", "Appfc_Handoff", "telephone")});
        f472240d = SetsKt.setOf(new C5769a("appintent_contact", "contact"));
        f472241e = MapsKt.mapOf(new Pair[]{TuplesKt.to("Contacts_Delete", SetsKt.setOf("appintent_contact")), TuplesKt.to("Phone_Delete", SetsKt.setOf("appintent_phone")), TuplesKt.to("Messages_Delete", SetsKt.setOf("appintent_message")), TuplesKt.to("Clock_DeleteAlarm", SetsKt.setOf("appintent_alarm")), TuplesKt.to("Clock_DeleteCountdown", SetsKt.setOf("appintent_countdown")), TuplesKt.to("Memory_Delete", SetsKt.setOf("appintent_memory")), TuplesKt.to("Photo_DeletePhoto", SetsKt.setOf("appintent_photo")), TuplesKt.to("Recorder_Delete", SetsKt.setOf("appintent_soundrecord"))});
    }

    public static JSONObject a(JSONObject r100) {
        Object r101 = null;
        if (r100.has("inputParam") == false) goto L6;
        Object r102 = r100.opt("inputParam");
    L13:
        if ((r102 instanceof JSONObject) == false) goto L16;
        return (JSONObject) r102;
    L16:
        if ((r102 instanceof String) == false) goto L30;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L19
        Object r104 = Result.m9449constructorimpl(new JSONObject((String) r102));     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r104) == true) goto L26;
        r101 = r104;
    L26:
        return (JSONObject) r101;
    L19:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L30:
        return null;
    L6:
        if (r100.has("inputParams") == false) goto L9;
        r102 = r100.opt("inputParams");
        goto L13
    L9:
        if (r100.has("input_param") == false) goto L11;
        r102 = r100.opt("input_param");
        goto L13
    L11:
        r102 = null;
        goto L13
    }

    public static c b(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        Object r102 = null;
        if (r101 == false) goto L34;
        return null;
    L34:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L26
        JSONObject r104 = new JSONObject(r100);     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(r104.optString("applet_id"), "ability.intent.card") == true) goto L14;
        return null;
    L14:
        String r105 = r104.optString("widget_id");     // Catch: Throwable -> L26
        Object r106 = r104.opt("widget_data");     // Catch: Throwable -> L26
        if (r106 != null) goto L18;
        return null;
    L18:
        if ((r106 instanceof JSONObject) == false) goto L21;
        JSONObject r107 = (JSONObject) r106;     // Catch: Throwable -> L26
    L23:
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L26
        Object r108 = Result.m9449constructorimpl(new c(r104, r105, r107, r106 instanceof String));     // Catch: Throwable -> L26
    L29:
        if (Result.m9455isFailureimpl(r108) == true) goto L33;
        r102 = r108;
    L33:
        return (c) r102;
    L21:
        if ((r106 instanceof String) == false) goto L25;
        r107 = new JSONObject((String) r106);     // Catch: Throwable -> L26
        goto L23
    L25:
        return null;
    L26:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public static Set c(String r110, JSONObject r111) {
        if (Intrinsics.areEqual(r110, "appintent_soundrecord") == false) goto L5;
        LinkedHashSet r112 = new LinkedHashSet();
        JSONArray r113 = r111.optJSONArray("cards");
        if (r113 != null) goto L9;
        return r112;
    L9:
        int r100 = r113.length();
        int r101 = 0;
    L10:
        if (r101 >= r100) goto L83;
        JSONObject r102 = r113.optJSONObject(r101);
        if (r102 == null) goto L82;
        JSONArray r103 = r102.optJSONArray("items");
        if (r103 == null) goto L82;
        int r104 = r103.length();
        int r105 = 0;
    L16:
        if (r105 >= r104) goto L82;
        JSONObject r106 = r103.optJSONObject(r105);
        if (r106 == null) goto L81;
        String r107 = r106.optString("intentName");
        if (StringsKt.isBlank(r107) == false) goto L24;
        r107 = r106.optString(Ext.KEY_INTENT_NAME);
    L24:
        if (Intrinsics.areEqual(r107, "Recorder_Operate") == false) goto L81;
        JSONObject r108 = a(r106);
        RecordingOperationCardKind r109 = null;
        if (r108 == null) goto L32;
        String r114 = d(r108, "action");
        if (r114 == null) goto L32;
        String r115 = StringsKt.trim(r114).toString();
        if (r115 == null) goto L32;
        String r116 = r115.toLowerCase(Locale.ROOT);
    L33:
        if (r116 != null) goto L35;
    L51:
        JSONObject r117 = r106.optJSONObject("entity");
        if (r117 == null) goto L58;
        String r118 = r117.optString("recordStatus");
        if (r118 == null) goto L58;
        String r119 = StringsKt.trim(r118).toString();
        if (r119 == null) goto L58;
        String r120 = r119.toLowerCase(Locale.ROOT);
    L59:
        if (r120 == null) goto L78;
        int r121 = r120.hashCode();
        if (r121 == (-995321554)) goto L75;
        if (r121 == 3227604) goto L71;
        if (r121 != 993558001) goto L78;
        if (r120.equals("recording") == false) goto L78;
    L77:
        r109 = RecordingOperationCardKind.TRANSIENT;
        goto L78
    L71:
        if (r120.equals(ECSaasScrollViewController.SEARCH_SCROLL_STATE_IDLE) == false) goto L78;
        r109 = RecordingOperationCardKind.TERMINAL;
        goto L78
    L75:
        if (r120.equals("paused") == true) goto L77;
    L78:
        RecordingOperationCardKind r122 = r109;
    L79:
        if (r122 == null) goto L81;
        r112.add(r122);
    L58:
        r120 = null;
        goto L59
    L35:
        switch(r116.hashCode()) {
            case -934426579: goto L48;
            case 3540994: goto L44;
            case 106440182: goto L41;
            case 109757538: goto L38;
            default: goto L51;
        };
    L38:
        if (r116.equals("start") == false) goto L51;
    L50:
        r122 = RecordingOperationCardKind.TRANSIENT;
        goto L79
    L41:
        if (r116.equals("pause") == false) goto L51;
    L44:
        if (r116.equals("stop") == false) goto L51;
        r122 = RecordingOperationCardKind.TERMINAL;
        goto L79
    L48:
        if (r116.equals("resume") == true) goto L50;
    L32:
        r116 = null;
    L81:
        r105 = r105 + 1;
    L82:
        r101 = r101 + 1;
        goto L10
    L83:
        return r112;
    L5:
        return SetsKt.emptySet();
    }

    public static String d(JSONObject r100, String r101) {
        Object r102 = r100.opt(r101);
        if ((r102 instanceof String) == false) goto L6;
        return (String) r102;
    L6:
        if ((r102 instanceof JSONObject) == false) goto L10;
        String r103 = ((JSONObject) r102).optString("value");
        Intrinsics.checkNotNull(r103);
        if ((!StringsKt.isBlank(r103)) == false) goto L10;
        return r103;
    L10:
        return null;
    }
}
