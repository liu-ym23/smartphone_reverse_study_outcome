package i26;

import com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableTypeWrapper;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements DynamicWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f6a.a f488043a;

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
    public final ReadableArrayWrapper asArray() {
        return g.a(this.f488043a.asArray());
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
    public final boolean asBoolean() {
        return this.f488043a.asBoolean();
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
    public final double asDouble() {
        return this.f488043a.asDouble();
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
    public final int asInt() {
        return this.f488043a.asInt();
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
    public final ReadableMapWrapper asMap() {
        return g.b(this.f488043a.asMap());
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
    public final String asString() {
        return this.f488043a.asString();
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
    public ReadableTypeWrapper getType() {
        return g.c(this.f488043a.getType());
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
    public final boolean isNull() {
        return this.f488043a.isNull();
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
    public final void recycle() {
        this.f488043a.recycle();
    }

    public c(f6a.a r100) {
        this.f488043a = r100;
    }
}
