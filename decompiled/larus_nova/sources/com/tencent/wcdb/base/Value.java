package com.tencent.wcdb.base;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.tencent.wcdb.winq.ColumnType;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class Value {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Object value;

    /* JADX INFO: renamed from: com.tencent.wcdb.base.Value$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$wcdb$winq$ColumnType = null;

        static {
            int[] r100 = new int[ColumnType.values().length];
            $SwitchMap$com$tencent$wcdb$winq$ColumnType = r100;
            r100[ColumnType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Integer.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Float.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Text.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.BLOB.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public byte[] getBLOB() {
        Object r100 = this.value;
        if (r100 != null) goto L7;
        return null;
    L7:
        if ((r100 instanceof byte[]) == false) goto L11;
        return (byte[]) r100;
    L11:
        return r100.toString().getBytes();
    }

    public double getDouble() {
        Object r100 = this.value;
        if ((r100 instanceof Double) == false) goto L7;
        return ((Double) r100).doubleValue();
    L7:
        if ((r100 instanceof Long) == false) goto L11;
        return ((Double) r100).doubleValue();
    L11:
        if ((r100 instanceof String) == true) goto L17;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L17:
        return CastDoubleProtector.parseDouble((String) r100);
    L19:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public long getLong() {
        Object r100 = this.value;
        if ((r100 instanceof Long) == false) goto L7;
        return ((Long) r100).longValue();
    L7:
        if ((r100 instanceof Double) == false) goto L11;
        return ((Long) r100).longValue();
    L11:
        if ((r100 instanceof String) == true) goto L17;
        return 0;
    L17:
        return CastLongProtector.parseLong((String) r100);
    L19:
        return 0;
    }

    public String getText() {
        Object r100 = this.value;
        if ((r100 instanceof String) == false) goto L7;
        return (String) r100;
    L7:
        if ((r100 instanceof byte[]) == true) goto L9;
        if (r100 != null) goto L13;
        return null;
    L13:
        return r100.toString();
    L9:
        return new String((byte[]) r100);
    }

    public ColumnType getType() {
        Object r100 = this.value;
        if (r100 == null) goto L5;
        Class<?> r101 = r100.getClass();
        if (r101 != Long.class) goto L11;
        return ColumnType.Integer;
    L11:
        if (r101 != String.class) goto L15;
        return ColumnType.Text;
    L15:
        if (r101 != byte[].class) goto L19;
        return ColumnType.BLOB;
    L19:
        if (r101 != Double.class) goto L23;
        return ColumnType.Float;
    L23:
        throw new AssertionError();
    L5:
        return ColumnType.Null;
    }

    public int hashCode() {
        Object r100 = this.value;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public Value() {
        this.value = null;
    }

    public boolean getBool() {
        if (getLong() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public byte getByte() {
        return (byte) getLong();
    }

    public float getFloat() {
        return (float) getDouble();
    }

    public int getInt() {
        return (int) getLong();
    }

    public short getShort() {
        return (short) getLong();
    }

    static {
    }

    public Value(Object r100) {
        if (r100 != null) goto L6;
        this.value = null;
        return;
    L6:
        Class<?> r101 = r100.getClass();
        if (r101 != Long.class) goto L9;
    L27:
        this.value = r100;
        return;
    L9:
        if (r101 == Double.class) goto L27;
        if (r101 == String.class) goto L27;
        if (r101 == byte[].class) goto L27;
        if (r101 != Integer.class) goto L18;
    L26:
        this.value = Long.valueOf(((Number) r100).longValue());
        return;
    L18:
        if (r101 == Short.class) goto L26;
        if (r101 == Byte.class) goto L26;
        if (r101 != Float.class) goto L25;
        this.value = Double.valueOf(((Number) r100).doubleValue());
        return;
    L25:
        this.value = r100.toString();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L5;
    L41:
        return true;
    L5:
        if (r100 == this.value) goto L41;
        if ((r100 instanceof Value) == false) goto L40;
        Value r101 = (Value) r100;
        int r102 = AnonymousClass1.$SwitchMap$com$tencent$wcdb$winq$ColumnType[getType().ordinal()];
        if (r102 == 1) goto L35;
        if (r102 == 2) goto L30;
        if (r102 == 3) goto L25;
        if (r102 == 4) goto L23;
        if (r102 != 5) goto L40;
        return Arrays.equals((byte[]) this.value, r101.getBLOB());
    L23:
        return this.value.equals(r101.getText());
    L25:
        if (((Double) this.value).doubleValue() == r101.getDouble()) goto L42;
        return false;
    L42:
        return true;
    L30:
        if (((Long) this.value).longValue() == r101.getLong()) goto L43;
        return false;
    L43:
        return true;
    L35:
        if (r101.getLong() == 0) goto L44;
        return false;
    L44:
        return true;
    L40:
        return Objects.deepEquals(r100, this.value);
    }

    public Value(byte r100) {
        this.value = Long.valueOf(r100);
    }

    public Value(float r100) {
        this.value = Double.valueOf(r100);
    }

    public Value(int r100) {
        this.value = Long.valueOf(r100);
    }

    public Value(boolean r100) {
        this.value = Long.valueOf(r100 ? 1 : 0);
    }

    public Value(double r100) {
        this.value = Double.valueOf(r100);
    }

    public Value(long r100) {
        this.value = Long.valueOf(r100);
    }

    public Value(Value r100) {
        if (r100 != null) goto L4;
        Object r101 = null;
    L5:
        this(r101);
        return;
    L4:
        r101 = r100.value;
        goto L5
    }

    public Value(String r100) {
        this.value = r100;
    }

    public Value(byte[] r100) {
        this.value = r100;
    }
}
