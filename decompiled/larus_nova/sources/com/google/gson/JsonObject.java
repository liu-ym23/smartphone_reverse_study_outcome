package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class JsonObject extends JsonElement {
    private final LinkedTreeMap<String, JsonElement> members;

    @Override // com.google.gson.JsonElement
    public JsonObject deepCopy() {
        JsonObject r100 = new JsonObject();
        Iterator<Map.Entry<String, JsonElement>> r101 = this.members.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, JsonElement> r102 = r101.next();
        r100.add(r102.getKey(), r102.getValue().deepCopy());
        goto L4
    L6:
        return r100;
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public boolean isEmpty() {
        if (this.members.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Set<String> keySet() {
        return this.members.keySet();
    }

    public int size() {
        return this.members.size();
    }

    public JsonObject() {
        this.members = new LinkedTreeMap(false);
    }

    public Map<String, JsonElement> asMap() {
        return this.members;
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r100 instanceof JsonObject) == true) goto L6;
    L8:
        return false;
    L6:
        if (((JsonObject) r100).members.equals(this.members) == false) goto L8;
        goto L8
    }

    public JsonElement get(String r100) {
        return this.members.get(r100);
    }

    public JsonArray getAsJsonArray(String r100) {
        return (JsonArray) this.members.get(r100);
    }

    public JsonObject getAsJsonObject(String r100) {
        return (JsonObject) this.members.get(r100);
    }

    public JsonPrimitive getAsJsonPrimitive(String r100) {
        return (JsonPrimitive) this.members.get(r100);
    }

    public boolean has(String r100) {
        return this.members.containsKey(r100);
    }

    public JsonElement remove(String r100) {
        return this.members.remove(r100);
    }

    public void add(String r100, JsonElement r101) {
        LinkedTreeMap<String, JsonElement> r102 = this.members;
        if (r101 != null) goto L5;
        r101 = JsonNull.INSTANCE;
    L5:
        r102.put(r100, r101);
    }

    public void addProperty(String r100, Boolean r101) {
        if (r101 != null) goto L4;
        JsonElement r102 = JsonNull.INSTANCE;
    L5:
        add(r100, r102);
        return;
    L4:
        r102 = new JsonPrimitive(r101);
        goto L5
    }

    public void addProperty(String r100, Character r101) {
        if (r101 != null) goto L4;
        JsonElement r102 = JsonNull.INSTANCE;
    L5:
        add(r100, r102);
        return;
    L4:
        r102 = new JsonPrimitive(r101);
        goto L5
    }

    public void addProperty(String r100, Number r101) {
        if (r101 != null) goto L4;
        JsonElement r102 = JsonNull.INSTANCE;
    L5:
        add(r100, r102);
        return;
    L4:
        r102 = new JsonPrimitive(r101);
        goto L5
    }

    public void addProperty(String r100, String r101) {
        if (r101 != null) goto L4;
        JsonElement r102 = JsonNull.INSTANCE;
    L5:
        add(r100, r102);
        return;
    L4:
        r102 = new JsonPrimitive(r101);
        goto L5
    }
}
