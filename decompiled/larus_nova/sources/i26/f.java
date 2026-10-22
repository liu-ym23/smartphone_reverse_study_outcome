package i26;

import com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableTypeWrapper;
import com.lynx.react.bridge.ReadableMap;
import java.util.HashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements ReadableMapWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReadableMap f488046a;

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final int size() {
        return this.f488046a.size();
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final HashMap<String, Object> toHashMap() {
        return this.f488046a.toHashMap();
    }

    public f(ReadableMap r100) {
        this.f488046a = r100;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final ReadableArrayWrapper getArray(String r100) {
        return g.a(this.f488046a.getArray(r100));
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final boolean getBoolean(String r100) {
        return this.f488046a.getBoolean(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final byte[] getByteArray(String r100) {
        return this.f488046a.getByteArray(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final double getDouble(String r100) {
        return this.f488046a.getDouble(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final DynamicWrapper getDynamic(String r100) {
        return new c(new f6a.c(this.f488046a, r100));
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final int getInt(String r100) {
        return this.f488046a.getInt(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final Long getLong(String r100) {
        return Long.valueOf(this.f488046a.getLong(r100));
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final ReadableMapWrapper getMap(String r100) {
        return g.b(this.f488046a.getMap(r100));
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final String getString(String r100) {
        return this.f488046a.getString(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public ReadableTypeWrapper getType(String r100) {
        return g.c(this.f488046a.getType(r100));
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final boolean hasKey(String r100) {
        return this.f488046a.hasKey(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final boolean isNull(String r100) {
        return this.f488046a.isNull(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final ReadableArrayWrapper getArray(String r100, ReadableArrayWrapper r101) {
        e r102 = g.a(this.f488046a.getArray(r100));
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final boolean getBoolean(String r100, boolean r101) {
        return this.f488046a.getBoolean(r100, r101);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final byte[] getByteArray(String r100, byte[] r101) {
        return this.f488046a.getByteArray(r100, r101);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final double getDouble(String r100, double r101) {
        return this.f488046a.getDouble(r100, r101);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final int getInt(String r100, int r101) {
        return this.f488046a.getInt(r100, r101);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final Long getLong(String r100, long r101) {
        return Long.valueOf(this.f488046a.getLong(r100, r101));
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final ReadableMapWrapper getMap(String r100, ReadableMapWrapper r101) {
        f r102 = g.b(this.f488046a.getMap(r100));
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
    public final String getString(String r100, String r101) {
        return this.f488046a.getString(r100, r101);
    }
}
