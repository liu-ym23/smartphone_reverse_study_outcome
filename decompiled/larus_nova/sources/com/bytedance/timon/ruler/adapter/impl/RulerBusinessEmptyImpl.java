package com.bytedance.timon.ruler.adapter.impl;

import com.bytedance.ruler.base.models.f;
import java.util.Map;
import kotlin.Metadata;
import v97.b;
import v97.d;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/timon/ruler/adapter/impl/RulerBusinessEmptyImpl;", "Lcom/bytedance/timon/ruler/adapter/impl/IRulerBusinessService;", "<init>", "()V", "ruler-adapter-api_release"}, k = 1, mv = {1, 4, 0})
public final class RulerBusinessEmptyImpl implements IRulerBusinessService {
    public RulerBusinessEmptyImpl() {
    }

    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService
    public final void a(d<?> r100) {
    }

    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService
    public final void c(b r100) {
    }

    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService
    public final String d() {
        return "";
    }

    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService
    public final f b(Map<String, ?> r100) {
        return new f(0, null, null, null, null, false, 1023);
    }
}
