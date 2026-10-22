package g6a;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.mapbuffer.e;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements f6a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f480176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f480177b;

    @Override // f6a.a
    public final void recycle() {
    }

    @Override // f6a.a
    public final ReadableArray asArray() {
        return this.f480176a.getArray(this.f480177b);
    }

    @Override // f6a.a
    public final boolean asBoolean() {
        return this.f480176a.getBoolean(this.f480177b);
    }

    @Override // f6a.a
    public final byte[] asByteArray() {
        this.f480176a.getClass();
        return new byte[0];
    }

    @Override // f6a.a
    public final double asDouble() {
        return this.f480176a.getDouble(this.f480177b);
    }

    @Override // f6a.a
    public final int asInt() {
        return this.f480176a.getInt(this.f480177b);
    }

    @Override // f6a.a
    public final long asLong() {
        return this.f480176a.getLong(this.f480177b);
    }

    @Override // f6a.a
    public final ReadableMap asMap() {
        this.f480176a.getClass();
        return null;
    }

    @Override // f6a.a
    public final String asString() {
        return this.f480176a.getString(this.f480177b);
    }

    @Override // f6a.a
    public ReadableType getType() {
        return this.f480176a.getType(this.f480177b);
    }

    @Override // f6a.a
    public final boolean isNull() {
        this.f480176a.getClass();
        return false;
    }

    public a(e r100, int r101) {
        this.f480176a = r100;
        this.f480177b = r101;
    }
}
