package com.bytedance.platform.aio.router.param.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import k57.a;
import k57.c;
import k57.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/platform/aio/router/param/model/AioInitialModelSerializableObjectImpl;", "Lk57/a;", "", "", "Lk57/c;", "rpcs", "Ljava/util/Map;", "V0", "()Ljava/util/Map;", "Lk57/d;", "constants", "o7", "<init>", "()V", "Adapter", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AioInitialModelSerializableObjectImpl implements a {

    @SerializedName("constants")
    private final Map<String, d> constants;

    @SerializedName("rpcs")
    private final Map<String, c> rpcs;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/platform/aio/router/param/model/AioInitialModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AioInitialModelSerializableObjectImpl.class);
        }
    }

    public AioInitialModelSerializableObjectImpl() {
        this.rpcs = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
        this.constants = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // k57.a
    public final Map<String, c> V0() {
        return this.rpcs;
    }

    @Override // k57.a
    public final Map<String, d> o7() {
        return this.constants;
    }
}
