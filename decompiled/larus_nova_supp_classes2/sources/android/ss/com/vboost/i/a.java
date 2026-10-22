package android.ss.com.vboost.i;

import android.ss.com.vboost.CapabilityType;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<CapabilityType> f113a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f114b;

    static {
        f113a = new HashSet();
        f114b = false;
    }

    public a() {
    }

    public Set<CapabilityType> a() {
        return f113a;
    }

    public void a(Set<CapabilityType> r2) {
        f113a.addAll(r2);
    }

    public boolean b(CapabilityType r2) {
        return f113a.contains(r2);
    }
}
