package sp7;

import androidx.core.util.Pools;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pools.SimplePool<c> f542906c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReadableMap f542907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f542908b;

    public c() {
    }

    static {
        f542906c = new Pools.SimplePool(10);
    }

    @Override // sp7.a
    public final ReadableArray asArray() {
        ReadableMap r100 = this.f542907a;
        if (r100 == null) goto L9;
        String r101 = this.f542908b;
        if (r101 == null) goto L9;
        return r100.getArray(r101);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // sp7.a
    public final boolean asBoolean() {
        ReadableMap r100 = this.f542907a;
        if (r100 == null) goto L9;
        String r101 = this.f542908b;
        if (r101 == null) goto L9;
        return r100.getBoolean(r101);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // sp7.a
    public final double asDouble() {
        ReadableMap r100 = this.f542907a;
        if (r100 == null) goto L9;
        String r101 = this.f542908b;
        if (r101 == null) goto L9;
        return r100.getDouble(r101);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // sp7.a
    public final ReadableMap asMap() {
        ReadableMap r100 = this.f542907a;
        if (r100 == null) goto L9;
        String r101 = this.f542908b;
        if (r101 == null) goto L9;
        return r100.getMap(r101);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // sp7.a
    public final String asString() {
        ReadableMap r100 = this.f542907a;
        if (r100 == null) goto L9;
        String r101 = this.f542908b;
        if (r101 == null) goto L9;
        return r100.getString(r101);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // sp7.a
    public ReadableType getType() {
        ReadableMap r100 = this.f542907a;
        if (r100 == null) goto L9;
        String r101 = this.f542908b;
        if (r101 == null) goto L9;
        return r100.getType(r101);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }
}
