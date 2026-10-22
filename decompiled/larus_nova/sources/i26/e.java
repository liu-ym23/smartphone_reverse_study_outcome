package i26;

import com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableTypeWrapper;
import com.lynx.react.bridge.ReadableArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements ReadableArrayWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReadableArray f488045a;

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final int size() {
        return this.f488045a.size();
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final ArrayList<Object> toArrayList() {
        return this.f488045a.toArrayList();
    }

    public e(ReadableArray r100) {
        this.f488045a = r100;
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final ReadableArrayWrapper getArray(int r100) {
        return g.a(this.f488045a.getArray(r100));
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final boolean getBoolean(int r100) {
        return this.f488045a.getBoolean(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final byte getByte(int r100) {
        return this.f488045a.getByte(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final byte[] getByteArray(int r100) {
        return this.f488045a.getByteArray(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final char getChar(int r100) {
        return this.f488045a.getChar(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final double getDouble(int r100) {
        return this.f488045a.getDouble(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final DynamicWrapper getDynamic(int r100) {
        return new c(new f6a.b(this.f488045a, r100));
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final int getInt(int r100) {
        return this.f488045a.getInt(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final long getLong(int r100) {
        return this.f488045a.getLong(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final ReadableMapWrapper getMap(int r100) {
        return g.b(this.f488045a.getMap(r100));
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final short getShort(int r100) {
        return this.f488045a.getShort(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final String getString(int r100) {
        return this.f488045a.getString(r100);
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public ReadableTypeWrapper getType(int r100) {
        return g.c(this.f488045a.getType(r100));
    }

    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
    public final boolean isNull(int r100) {
        return this.f488045a.isNull(r100);
    }
}
