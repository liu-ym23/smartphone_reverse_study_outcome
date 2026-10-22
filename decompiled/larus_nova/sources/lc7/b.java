package lc7;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.sdk.account.service.manager.ServiceNotFoundException;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class b<T extends IService> implements ReadOnlyProperty<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<T> f508604a;

    public b(Class<T> r100) {
        this.f508604a = r100;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object r100, KProperty r101) {
        Class<T> r102 = this.f508604a;
        int r103 = c.f508605a;
        IService r104 = (IService) ServiceManager.getService(r102);
        if (r104 == null) goto L6;
        return r104;
    L6:
        throw new ServiceNotFoundException(r102);
    }
}
