package sp7;

import androidx.core.util.Pools;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pools.SimplePool<b> f542903c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReadableArray f542904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f542905b;

    static {
        f542903c = new Pools.SimplePool(10);
    }

    @Override // sp7.a
    public final ReadableArray asArray() {
        ReadableArray r100 = this.f542904a;
        if (r100 == null) goto L7;
        return r100.getArray(this.f542905b);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // sp7.a
    public final boolean asBoolean() {
        ReadableArray r100 = this.f542904a;
        if (r100 == null) goto L7;
        return r100.getBoolean(this.f542905b);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // sp7.a
    public final double asDouble() {
        ReadableArray r100 = this.f542904a;
        if (r100 == null) goto L7;
        return r100.getDouble(this.f542905b);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // sp7.a
    public final ReadableMap asMap() {
        ReadableArray r100 = this.f542904a;
        if (r100 == null) goto L7;
        return r100.getMap(this.f542905b);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // sp7.a
    public final String asString() {
        ReadableArray r100 = this.f542904a;
        if (r100 == null) goto L7;
        return r100.getString(this.f542905b);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // sp7.a
    public ReadableType getType() {
        ReadableArray r100 = this.f542904a;
        if (r100 == null) goto L7;
        return r100.getType(this.f542905b);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public b() {
        this.f542905b = -1;
    }
}
