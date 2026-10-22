package vy6;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Class<? extends wy6.a>> f557622a = null;

    static {
        f557622a = new LinkedHashMap();
    }

    public static wy6.a a(String r100) {
        Class r101 = (Class) ((LinkedHashMap) f557622a).get(r100);
        if (r101 == null) goto L6;
        return (wy6.a) r101.getConstructor(new Class[0]).newInstance(new Object[0]);
    L6:
        return new com.bytedance.locallife.poi.poidetail.container.ability.common.a();
    }
}
