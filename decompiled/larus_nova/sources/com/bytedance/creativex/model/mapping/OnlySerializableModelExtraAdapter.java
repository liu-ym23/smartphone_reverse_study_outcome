package com.bytedance.creativex.model.mapping;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/creativex/model/mapping/OnlySerializableModelExtraAdapter;", "Lcom/google/gson/TypeAdapter;", "Ljava/util/HashMap;", "", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class OnlySerializableModelExtraAdapter extends TypeAdapter<HashMap<String, Serializable>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f204228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f204229b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public final HashMap<String, Serializable> read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        HashMap<String, Serializable> r101 = new HashMap();
        r100.beginObject();
    L4:
        if (r100.hasNext() == false) goto L13;
        String r102 = r100.nextName();
        Class<?> r103 = this.f204229b.get(r102);
        Object r104 = GsonProtectorUtils.fromJson(this.f204228a, r100.nextString(), r103);
        if (r104 == null) goto L7;
        if ((r104 instanceof Serializable) == false) goto L12;
        r101.put(r102, r104);
        goto L4
    L12:
        throw new IllegalStateException("type not supported yet".toString());
    L7:
        r101.put(r102, r104);
        goto L4
    L13:
        r100.endObject();
        return r101;
    }

    public OnlySerializableModelExtraAdapter(Gson r100, InitialModelExtraMapping r101) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(r101, "mapping");
        this.f204228a = r100;
        this.f204229b = r101;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, HashMap<String, Serializable> r101) {
        HashMap<String, Serializable> r102 = r101;
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Intrinsics.checkNotNullParameter(r102, "map");
        r100.beginObject();
        Iterator<Map.Entry<String, Serializable>> r103 = r102.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, Serializable> r104 = r103.next();
        String r105 = r104.getKey();
        Serializable r106 = r104.getValue();
        Class<?> r107 = this.f204229b.get(r105);
        r100.name(r105);
        r100.value(GsonProtectorUtils.toJson(this.f204228a, r106, r107));
        goto L4
    L6:
        r100.endObject();
    }
}
