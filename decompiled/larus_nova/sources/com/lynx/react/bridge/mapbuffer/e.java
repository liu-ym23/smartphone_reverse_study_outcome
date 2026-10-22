package com.lynx.react.bridge.mapbuffer;

import com.lynx.react.bridge.PiperData;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements ReadableArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MapBuffer f381462a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381463a = null;

        static {
            int[] r100 = new int[MapBuffer.DataType.values().length];
            f381463a = r100;
            r100[MapBuffer.DataType.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f381463a[MapBuffer.DataType.DOUBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f381463a[MapBuffer.DataType.ARRAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f381463a[MapBuffer.DataType.NULL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f381463a[MapBuffer.DataType.LONG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f381463a[MapBuffer.DataType.INT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f381463a[MapBuffer.DataType.BOOL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ArrayList<Object> asArrayList() {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final byte[] getByteArray(int r100) {
        return new byte[0];
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final char getChar(int r100) {
        return 0;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ReadableMap getMap(int r100) {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final PiperData getPiperData(int r100) {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final boolean isNull(int r100) {
        return false;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ArrayList<Object> toArrayList() {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f381462a.count();
    }

    public e(MapBuffer r100) {
        this.f381462a = r100;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final ReadableArray getArray(int r100) {
        return new e(this.f381462a.b(r100));
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final boolean getBoolean(int r100) {
        return this.f381462a.getBoolean(r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final byte getByte(int r100) {
        return (byte) getInt(r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final double getDouble(int r100) {
        return this.f381462a.getDouble(r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final f6a.a getDynamic(int r100) {
        return new g6a.a(this, r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final int getInt(int r100) {
        return this.f381462a.getInt(r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final long getLong(int r100) {
        return this.f381462a.getLong(r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final short getShort(int r100) {
        return (short) getInt(r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public final String getString(int r100) {
        return this.f381462a.getString(r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public ReadableType getType(int r100) {
        MapBuffer.DataType r101 = this.f381462a.getType(r100);
        switch(a.f381463a[r101.ordinal()]) {
            case 1: goto L12;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L13;
        };
    L13:
        return ReadableType.Null;
    L14:
        return ReadableType.Boolean;
    L15:
        return ReadableType.Int;
    L16:
        return ReadableType.Long;
    L17:
        return ReadableType.Null;
    L18:
        return ReadableType.Array;
    L19:
        return ReadableType.Number;
    L12:
        return ReadableType.String;
    }
}
