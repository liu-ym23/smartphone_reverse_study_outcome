package com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/ContentWraperTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/ContentWraper;", "<init>", "()V", "write", "", Argument.OUT, "Lcom/google/gson/stream/JsonWriter;", "value", "read", "input", "Lcom/google/gson/stream/JsonReader;", "Companion", "middleground-feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentWraperTypeAdapter extends TypeAdapter<ContentWraper<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, wf5.a<?>> f232613a = null;

    public static final class a {
    }

    static {
        f232613a = MapsKt.mapOf(new Pair[]{TuplesKt.to("normal", new yf5.a()), TuplesKt.to(INotificationHitPoint.NoticeType.REACTION, new zf5.a()), TuplesKt.to("multiLevel", new xf5.a())});
    }

    public ContentWraperTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final ContentWraper<?> read(JsonReader r100) {
        if (r100 != null) goto L5;
        tt5.a.h("ContentTypeAdapter", "input is null");     // Catch: Exception -> L35
        return null;
    L5:
        JsonElement r101 = JsonParser.parseReader(r100);     // Catch: Exception -> L35
        if (r101.isJsonObject() == true) goto L8;
        tt5.a.h("ContentTypeAdapter", "content json is not object");     // Catch: Exception -> L35
        return null;
    L8:
        JsonObject r102 = r101.getAsJsonObject();     // Catch: Exception -> L35
        JsonElement r103 = r102.get("dataType");     // Catch: Exception -> L35
        boolean r104 = true;
        if (r103 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == false) goto L16;
        String r106 = r103.getAsString();     // Catch: Exception -> L35
    L17:
        if (r106 != null) goto L19;
    L22:
        if (r104 == false) goto L24;
        tt5.a.h("ContentTypeAdapter", "dataType is empty");     // Catch: Exception -> L35
        return null;
    L24:
        JsonElement r107 = r102.get("data");     // Catch: Exception -> L35
        if (r107 != null) goto L27;
    L33:
        tt5.a.h("ContentTypeAdapter", "data is empty, dataType=" + r106);     // Catch: Exception -> L35
        ContentWraper<?> r108 = new ContentWraper();     // Catch: Exception -> L35
        r108.setDataType(r106);     // Catch: Exception -> L35
    L43:
        return r108;
    L27:
        if (r107.isJsonNull() == true) goto L33;
        wf5.a<?> r109 = f232613a.get(r106);     // Catch: Exception -> L35
        if (r109 != null) goto L42;
        tt5.a.h("ContentTypeAdapter", "unsupported dataType=" + r106);     // Catch: Exception -> L35
        r108 = new ContentWraper();     // Catch: Exception -> L35
        r108.setDataType(r106);     // Catch: Exception -> L35
        goto L43
    L42:
        return r109.a(r106, r107);
    L19:
        if (r106.length() == 0) goto L22;
        r104 = false;
        goto L22
    L16:
        r106 = null;
        goto L17
    L11:
        if (r103.isJsonPrimitive() != true) goto L13;
        r105 = true;
    L35:
        e = move-exception;
        tt5.a.f("ContentTypeAdapter", e, false);
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public final /* bridge */ /* synthetic */ void write(JsonWriter r100, ContentWraper<?> r101) {
    }
}
