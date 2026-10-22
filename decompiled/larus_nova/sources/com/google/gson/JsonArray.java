package com.google.gson;

import com.google.gson.internal.NonNullElementWrapperList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final ArrayList<JsonElement> elements;

    private JsonElement getAsSingleElement() {
        int r100 = this.elements.size();
        if (r100 != 1) goto L7;
        return this.elements.get(0);
    L7:
        throw new IllegalStateException("Array must have size 1, but has size " + r100);
    }

    public List<JsonElement> asList() {
        return new NonNullElementWrapperList(this.elements);
    }

    @Override // com.google.gson.JsonElement
    public JsonArray deepCopy() {
        if (this.elements.isEmpty() == true) goto L10;
        JsonArray r100 = new JsonArray(this.elements.size());
        Iterator<JsonElement> r101 = this.elements.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r100.add(r101.next().deepCopy());
        goto L6
    L8:
        return r100;
    L10:
        return new JsonArray();
    }

    public int hashCode() {
        return this.elements.hashCode();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }

    public int size() {
        return this.elements.size();
    }

    public JsonArray() {
        this.elements = new ArrayList();
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        return getAsSingleElement().getAsBigDecimal();
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        return getAsSingleElement().getAsBigInteger();
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        return getAsSingleElement().getAsBoolean();
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        return getAsSingleElement().getAsByte();
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        return getAsSingleElement().getAsCharacter();
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        return getAsSingleElement().getAsDouble();
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        return getAsSingleElement().getAsFloat();
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        return getAsSingleElement().getAsInt();
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        return getAsSingleElement().getAsLong();
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        return getAsSingleElement().getAsNumber();
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        return getAsSingleElement().getAsShort();
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        return getAsSingleElement().getAsString();
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public JsonArray(int r100) {
        this.elements = new ArrayList(r100);
    }

    public void add(Boolean r100) {
        ArrayList<JsonElement> r101 = this.elements;
        if (r100 != null) goto L5;
        JsonElement r102 = JsonNull.INSTANCE;
    L6:
        r101.add(r102);
        return;
    L5:
        r102 = new JsonPrimitive(r100);
        goto L6
    }

    public void addAll(JsonArray r100) {
        this.elements.addAll(r100.elements);
    }

    public boolean contains(JsonElement r100) {
        return this.elements.contains(r100);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r100 instanceof JsonArray) == true) goto L6;
    L8:
        return false;
    L6:
        if (((JsonArray) r100).elements.equals(this.elements) == false) goto L8;
        goto L8
    }

    public JsonElement get(int r100) {
        return this.elements.get(r100);
    }

    public JsonElement remove(int r100) {
        return this.elements.remove(r100);
    }

    public void add(Character r100) {
        ArrayList<JsonElement> r101 = this.elements;
        if (r100 != null) goto L5;
        JsonElement r102 = JsonNull.INSTANCE;
    L6:
        r101.add(r102);
        return;
    L5:
        r102 = new JsonPrimitive(r100);
        goto L6
    }

    public boolean remove(JsonElement r100) {
        return this.elements.remove(r100);
    }

    public void add(Number r100) {
        ArrayList<JsonElement> r101 = this.elements;
        if (r100 != null) goto L5;
        JsonElement r102 = JsonNull.INSTANCE;
    L6:
        r101.add(r102);
        return;
    L5:
        r102 = new JsonPrimitive(r100);
        goto L6
    }

    public void add(String r100) {
        ArrayList<JsonElement> r101 = this.elements;
        if (r100 != null) goto L5;
        JsonElement r102 = JsonNull.INSTANCE;
    L6:
        r101.add(r102);
        return;
    L5:
        r102 = new JsonPrimitive(r100);
        goto L6
    }

    public void add(JsonElement r100) {
        if (r100 != null) goto L4;
        r100 = JsonNull.INSTANCE;
    L4:
        this.elements.add(r100);
    }

    public JsonElement set(int r100, JsonElement r101) {
        ArrayList<JsonElement> r102 = this.elements;
        if (r101 != null) goto L6;
        r101 = JsonNull.INSTANCE;
    L6:
        return r102.set(r100, r101);
    }
}
