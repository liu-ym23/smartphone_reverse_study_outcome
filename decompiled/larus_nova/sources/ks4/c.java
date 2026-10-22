package ks4;

import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements ILynxContainerContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f505910a;

    @Override // com.ss.android.lark.lynxkit.container.ILynxContainerContext
    public final String getContainerType() {
        return "BitableChart";
    }

    public c() {
        this.f505910a = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.lynxkit.container.ILynxContainerContext
    public final Map<String, Object> getBizExtra() {
        return this.f505910a;
    }
}
