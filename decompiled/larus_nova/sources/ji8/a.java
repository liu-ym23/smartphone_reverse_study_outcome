package ji8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<InterfaceC6442a> f499224a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Set<Object>> f499225b = null;

    /* JADX INFO: renamed from: ji8.a$a, reason: collision with other inner class name */
    public interface InterfaceC6442a {
        void onActivityDestroy(String r100);

        void onActivityPaused(String r100);

        void onActivityResumed(String r100);

        void onContextCleared(String r100);

        void onViewCreated(String r100);

        void onViewDestroyed(String r100);
    }

    static {
        f499224a = new CopyOnWriteArrayList();
        f499225b = new LinkedHashMap();
    }
}
