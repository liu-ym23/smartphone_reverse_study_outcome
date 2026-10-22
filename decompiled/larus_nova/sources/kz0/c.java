package kz0;

import com.bytedance.android.annie.api.data.subscribe.g;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.scope.o;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements o, b {
    public c() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // kz0.b
    public final a getCurrentLinkMicState() {
        com.bytedance.android.annie.service.data.b r100 = com.bytedance.android.annie.service.data.b.f39869a;
        i.g.f r101 = i.g.f.f63216b;
        g r102 = com.bytedance.android.annie.service.data.b.a("linkmic");
        Object r103 = null;
        if (r102 == null) goto L5;
        Object r104 = r102.g();
    L7:
        if ((r104 instanceof JsonObject) == false) goto L10;
        r103 = r104;
    L10:
        JsonObject r105 = (JsonObject) r103;
        if (r105 != null) goto L15;
        return new a(0);
    L15:
        return new a(a(r105));
    L5:
        r104 = null;
        goto L7
    }

    public static JsonObject a(JsonObject r100) {
        JsonObject r101 = new JsonObject();
        Iterator<T> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L20;
        Map.Entry r103 = (Map.Entry) r102.next();
        JsonElement r104 = (JsonElement) r103.getValue();
        if ((r104 instanceof JsonPrimitive) == true) goto L7;
        if ((r104 instanceof JsonObject) == true) goto L18;
        r101.add((String) r103.getKey(), (JsonElement) r103.getValue());
        goto L4
    L18:
        r101.add((String) r103.getKey(), a((JsonObject) r104));
        goto L4
    L7:
        JsonPrimitive r105 = (JsonPrimitive) r104;
        if (r105.isNumber() == true) goto L10;
        r101.add((String) r103.getKey(), (JsonElement) r103.getValue());
        goto L4
    L10:
        if (r105.getAsLong() > Integer.MAX_VALUE) goto L14;
        if (r105.getAsLong() < (-2147483647)) goto L14;
        r101.add((String) r103.getKey(), r104);
    L14:
        r101.add((String) r103.getKey(), new JsonPrimitive(r105.getAsString()));
        goto L4
    L20:
        return r101;
    }
}
