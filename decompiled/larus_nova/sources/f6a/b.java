package f6a;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadableArray f475720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f475721b;

    @Override // f6a.a
    public final void recycle() {
    }

    @Override // f6a.a
    public final ReadableArray asArray() {
        return this.f475720a.getArray(this.f475721b);
    }

    @Override // f6a.a
    public final boolean asBoolean() {
        return this.f475720a.getBoolean(this.f475721b);
    }

    @Override // f6a.a
    public final byte[] asByteArray() {
        return this.f475720a.getByteArray(this.f475721b);
    }

    @Override // f6a.a
    public final double asDouble() {
        return this.f475720a.getDouble(this.f475721b);
    }

    @Override // f6a.a
    public final int asInt() {
        return this.f475720a.getInt(this.f475721b);
    }

    @Override // f6a.a
    public final long asLong() {
        return this.f475720a.getLong(this.f475721b);
    }

    @Override // f6a.a
    public final ReadableMap asMap() {
        return this.f475720a.getMap(this.f475721b);
    }

    @Override // f6a.a
    public final String asString() {
        return this.f475720a.getString(this.f475721b);
    }

    @Override // f6a.a
    public ReadableType getType() {
        return this.f475720a.getType(this.f475721b);
    }

    @Override // f6a.a
    public final boolean isNull() {
        return this.f475720a.isNull(this.f475721b);
    }

    public b(ReadableArray r100, int r101) {
        this.f475720a = r100;
        this.f475721b = r101;
    }
}
