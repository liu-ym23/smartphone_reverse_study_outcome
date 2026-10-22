package f6a;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadableMap f475722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475723b;

    @Override // f6a.a
    public final void recycle() {
    }

    @Override // f6a.a
    public final ReadableArray asArray() {
        return this.f475722a.getArray(this.f475723b);
    }

    @Override // f6a.a
    public final boolean asBoolean() {
        return this.f475722a.getBoolean(this.f475723b);
    }

    @Override // f6a.a
    public final byte[] asByteArray() {
        return this.f475722a.getByteArray(this.f475723b);
    }

    @Override // f6a.a
    public final double asDouble() {
        return this.f475722a.getDouble(this.f475723b);
    }

    @Override // f6a.a
    public final int asInt() {
        return this.f475722a.getInt(this.f475723b);
    }

    @Override // f6a.a
    public final long asLong() {
        return this.f475722a.getLong(this.f475723b);
    }

    @Override // f6a.a
    public final ReadableMap asMap() {
        return this.f475722a.getMap(this.f475723b);
    }

    @Override // f6a.a
    public final String asString() {
        return this.f475722a.getString(this.f475723b);
    }

    @Override // f6a.a
    public ReadableType getType() {
        return this.f475722a.getType(this.f475723b);
    }

    @Override // f6a.a
    public final boolean isNull() {
        return this.f475722a.isNull(this.f475723b);
    }

    public c(ReadableMap r100, String r101) {
        this.f475722a = r100;
        this.f475723b = r101;
    }
}
