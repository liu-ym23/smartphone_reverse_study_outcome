package com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/ContentWraperTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/ContentWraper;", "<init>", "()V", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "read", "input", "Lcom/google/gson/stream/JsonReader;", "Companion", "middleground-feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentWraperTypeAdapter extends TypeAdapter<ContentWraper<?>> {
    public static final Map<String, wf5.a<?>> a = null;

    public static final class a {
    }

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(SegmentStyle.FONT_STYLE_NORMAL, new yf5.a()), TuplesKt.to("reaction", new zf5.a()), TuplesKt.to("multiLevel", new xf5.a())});
    }

    public ContentWraperTypeAdapter() {
    }

    public final Object read(JsonReader r9) {
        if (r9 != null) goto L5;
        tt5.a.h("ContentTypeAdapter", "input is null");     // Catch: Exception -> L35
        return null;
    L5:
        JsonElement r10 = JsonParser.parseReader(r9);     // Catch: Exception -> L35
        if (r10.isJsonObject() == true) goto L8;
        tt5.a.h("ContentTypeAdapter", "content json is not object");     // Catch: Exception -> L35
        return null;
    L8:
        JsonObject r11 = r10.getAsJsonObject();     // Catch: Exception -> L35
        JsonElement r5 = r11.get("dataType");     // Catch: Exception -> L35
        boolean r6 = true;
        if (r5 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == false) goto L16;
        String r8 = r5.getAsString();     // Catch: Exception -> L35
    L17:
        if (r8 != null) goto L19;
    L22:
        if (r6 == false) goto L24;
        tt5.a.h("ContentTypeAdapter", "dataType is empty");     // Catch: Exception -> L35
        return null;
    L24:
        JsonElement r12 = r11.get(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L35
        if (r12 != null) goto L27;
    L33:
        tt5.a.h("ContentTypeAdapter", "data is empty, dataType=" + r8);     // Catch: Exception -> L35
        ContentWraper r13 = new ContentWraper();     // Catch: Exception -> L35
        r13.setDataType(r8);     // Catch: Exception -> L35
    L43:
        return r13;
    L27:
        if (r12.isJsonNull() == true) goto L33;
        wf5.a<?> r1 = a.get(r8);     // Catch: Exception -> L35
        if (r1 != null) goto L42;
        tt5.a.h("ContentTypeAdapter", "unsupported dataType=" + r8);     // Catch: Exception -> L35
        r13 = new ContentWraper();     // Catch: Exception -> L35
        r13.setDataType(r8);     // Catch: Exception -> L35
        goto L43
    L42:
        return r1.a(r8, r12);
    L19:
        if (r8.length() == 0) goto L22;
        r6 = false;
        goto L22
    L16:
        r8 = null;
        goto L17
    L11:
        if (r5.isJsonPrimitive() != true) goto L13;
        r7 = true;
    L35:
        e = move-exception;
        tt5.a.f("ContentTypeAdapter", e, false);
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(JsonWriter r1, Object r2) {
        ContentWraper r3 = (ContentWraper) r2;
    }
}
