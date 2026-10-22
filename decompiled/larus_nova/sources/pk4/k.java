package pk4;

import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f529631a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f529632a = null;

        static {
            f529632a = new k();
        }
    }

    public k() {
        KevaBuilder.getInstance().setContext(n.f529659c);
        this.f529631a = Keva.getRepo("_d_multi_process", 1);
    }

    public final void a(String[] r100) {
        int r101 = 0;
        if (this.f529631a.getBoolean("_d_bind_migrated", false) == false) goto L5;
        return;
    L5:
        StringBuilder r102 = new StringBuilder("migrateDoraBindMacsIfNeeded size: ");
        if (r100 == null) goto L9;
        r101 = r100.length;
    L9:
        r102.append(r101);
        j.d("MultiProcessKevaUtils", r102.toString());
        if (r100 != null) goto L12;
    L15:
        b(new LinkedHashSet());
    L16:
        this.f529631a.storeBoolean("_d_bind_migrated", true);
        return;
    L12:
        if (r100.length == 0) goto L15;
        b(new LinkedHashSet(Arrays.asList(r100)));
        goto L16
    }

    public final void b(Set<String> r100) {
        this.f529631a.storeStringArray("_d_bind", (String[]) r100.toArray(new String[0]));
    }
}
