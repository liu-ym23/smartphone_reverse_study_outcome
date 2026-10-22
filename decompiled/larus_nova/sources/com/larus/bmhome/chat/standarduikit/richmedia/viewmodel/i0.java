package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f309695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f309696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f309697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f309698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f309699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f309700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f309701g;

    public final Map<String, Object> c() {
        Map<String, Object> r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("chat_id", this.f309695a), TuplesKt.to("agent_mode", Integer.valueOf(this.f309696b)), TuplesKt.to("card_source", this.f309697c), TuplesKt.to("card_group_id", this.f309698d), TuplesKt.to("card_id", this.f309699e)});
        String r101 = this.f309700f;
        if (r101 == null) goto L5;
        r100.put("doc_id", r101);
    L5:
        String r102 = this.f309701g;
        if (r102 == null) goto L8;
        r100.put("req_id", r102);
    L8:
        return r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f309695a, r101.f309695a) == true) goto L12;
        return false;
    L12:
        if (this.f309696b == r101.f309696b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309697c, r101.f309697c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309698d, r101.f309698d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f309699e, r101.f309699e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f309700f, r101.f309700f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f309701g, r101.f309701g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f309695a.hashCode() * 31) + this.f309696b) * 31) + this.f309697c.hashCode()) * 31) + this.f309698d.hashCode()) * 31) + this.f309699e.hashCode()) * 31;
        String r101 = this.f309700f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f309701g;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RichMediaTraceContext(chatId=" + this.f309695a + ", agentMode=" + this.f309696b + ", cardSource=" + this.f309697c + ", cardGroupId=" + this.f309698d + ", cardId=" + this.f309699e + ", docId=" + this.f309700f + ", reqId=" + this.f309701g + ')';
    }

    public final JSONObject b() {
        JSONObject r100 = new JSONObject();
        a(r100);
        return r100;
    }

    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Iterator<Map.Entry<String, Object>> r101 = c().entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, Object> r102 = r101.next();
        r100.putOpt(r102.getKey(), r102.getValue());
        goto L4
    }

    public i0(String r100, int r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r102, "cardSource");
        Intrinsics.checkNotNullParameter(r103, "cardGroupId");
        Intrinsics.checkNotNullParameter(r104, "cardId");
        this.f309695a = r100;
        this.f309696b = r101;
        this.f309697c = r102;
        this.f309698d = r103;
        this.f309699e = r104;
        this.f309700f = r105;
        this.f309701g = r106;
    }
}
