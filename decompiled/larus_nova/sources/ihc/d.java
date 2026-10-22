package ihc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f489933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f489934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f489935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f489936d;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "{launchMode = " + this.f489936d + ", isColdBoot = " + this.f489933a + ", gdLabel = " + this.f489934b + ", extra = " + this.f489935c + '}';
    }

    public d(String r100) {
        this.f489936d = r100;
        this.f489934b = "";
        this.f489935c = new ConcurrentHashMap();
    }
}
