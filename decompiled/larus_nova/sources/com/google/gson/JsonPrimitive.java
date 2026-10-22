package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class JsonPrimitive extends JsonElement {
    private final Object value;

    @Override // com.google.gson.JsonElement
    public JsonPrimitive deepCopy() {
        return this;
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        Object r100 = this.value;
        if ((r100 instanceof BigDecimal) == false) goto L6;
        return (BigDecimal) r100;
    L6:
        return new BigDecimal(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        Object r100 = this.value;
        if ((r100 instanceof BigInteger) == false) goto L6;
        return (BigInteger) r100;
    L6:
        return new BigInteger(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        Object r100 = this.value;
        if ((r100 instanceof Number) == false) goto L7;
        return (Number) r100;
    L7:
        if ((r100 instanceof String) == false) goto L11;
        return new LazilyParsedNumber((String) r100);
    L11:
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        Object r100 = this.value;
        if ((r100 instanceof String) == false) goto L7;
        return (String) r100;
    L7:
        if (isNumber() == false) goto L11;
        return getAsNumber().toString();
    L11:
        if (isBoolean() == false) goto L15;
        return ((Boolean) this.value).toString();
    L15:
        throw new AssertionError("Unexpected value type: " + this.value.getClass());
    }

    public int hashCode() {
        if (this.value != null) goto L7;
        return 31;
    L7:
        if (isIntegral(this) == false) goto L11;
        long r100 = getAsNumber().longValue();
    L10:
        return (int) ((r100 >>> 32) ^ r100);
    L11:
        Object r101 = this.value;
        if ((r101 instanceof Number) == false) goto L15;
        r100 = Double.doubleToLongBits(getAsNumber().doubleValue());
        goto L10
    L15:
        return r101.hashCode();
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (isBoolean() == false) goto L7;
        return ((Boolean) this.value).booleanValue();
    L7:
        return Boolean.parseBoolean(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        if (isNumber() == false) goto L6;
        return getAsNumber().byteValue();
    L6:
        return Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        String r100 = getAsString();
        if (r100.isEmpty() == true) goto L7;
        return r100.charAt(0);
    L7:
        throw new UnsupportedOperationException("String value is empty");
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (isNumber() == false) goto L6;
        return getAsNumber().doubleValue();
    L6:
        return Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        if (isNumber() == false) goto L6;
        return getAsNumber().floatValue();
    L6:
        return Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        if (isNumber() == false) goto L6;
        return getAsNumber().intValue();
    L6:
        return Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (isNumber() == false) goto L6;
        return getAsNumber().longValue();
    L6:
        return Long.parseLong(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        if (isNumber() == false) goto L6;
        return getAsNumber().shortValue();
    L6:
        return Short.parseShort(getAsString());
    }

    public JsonPrimitive(Character r100) {
        Objects.requireNonNull(r100);
        this.value = r100.toString();
    }

    private static boolean isIntegral(JsonPrimitive r100) {
        Object r101 = r100.value;
        if ((r101 instanceof Number) == false) goto L16;
        Number r102 = (Number) r101;
        if ((r102 instanceof BigInteger) == false) goto L7;
    L14:
        return true;
    L7:
        if ((r102 instanceof Long) == true) goto L14;
        if ((r102 instanceof Integer) == true) goto L14;
        if ((r102 instanceof Short) == true) goto L14;
        if ((r102 instanceof Byte) == true) goto L14;
        return false;
    L16:
        return false;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L41:
        return false;
    L8:
        if (JsonPrimitive.class != r100.getClass()) goto L41;
        JsonPrimitive r101 = (JsonPrimitive) r100;
        if (this.value != null) goto L18;
        if (r101.value == null) goto L42;
        return false;
    L42:
        return true;
    L18:
        if (isIntegral(this) == true) goto L20;
    L26:
        Object r102 = this.value;
        if ((r102 instanceof Number) == false) goto L40;
        if ((r101.value instanceof Number) == false) goto L40;
        double r103 = getAsNumber().doubleValue();
        double r104 = r101.getAsNumber().doubleValue();
        if (r103 != r104) goto L33;
        return true;
    L33:
        if (Double.isNaN(r103) == true) goto L35;
    L37:
        return false;
    L35:
        if (Double.isNaN(r104) == false) goto L37;
        return true;
    L40:
        return r102.equals(r101.value);
    L20:
        if (isIntegral(r101) == false) goto L26;
        if (getAsNumber().longValue() == r101.getAsNumber().longValue()) goto L43;
        return false;
    L43:
        return true;
    }

    public JsonPrimitive(Boolean r100) {
        Objects.requireNonNull(r100);
        this.value = r100;
    }

    public JsonPrimitive(Number r100) {
        Objects.requireNonNull(r100);
        this.value = r100;
    }

    public JsonPrimitive(String r100) {
        Objects.requireNonNull(r100);
        this.value = r100;
    }
}
