package lc7;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class a<T extends IService> implements ReadOnlyProperty<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<T> f508603a;

    public a(Class<T> r100) {
        this.f508603a = r100;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object r100, KProperty r101) {
        Class<T> r102 = this.f508603a;
        int r103 = c.f508605a;
        return (IService) ServiceManager.getService(r102);
    }
}
