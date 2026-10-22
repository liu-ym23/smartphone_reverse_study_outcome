package vxb;

import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import com.bytedance.ee.lark.infra.sandbox.context.IBaseService;

/* JADX INFO: loaded from: classes37.dex */
public abstract class c implements IBaseService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f557536a;

    public c() {
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IBaseService
    public final IAppContext getAppContext() {
        return this.f557536a;
    }
}
