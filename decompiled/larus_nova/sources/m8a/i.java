package m8a;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile i f512536b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Integer> f512537a;

    public i() {
        this.f512537a = new HashMap();
    }

    public final int a(Context r100, String r101) {
        if (r101 != null) goto L4;
        return 0;
    L4:
        if (r101.isEmpty() == true) goto L26;
        String r102 = r101.toLowerCase().replace("-", "_");
        return CastIntegerProtector.parseInt(r102);
    L9:
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L11:
        if (((HashMap) this.f512537a).containsKey(r102) == true) goto L14;
        int r103 = r100.getResources().getIdentifier(r102, "drawable", r100.getPackageName());     // Catch: Throwable -> L18
        Map<String, Integer> r104 = this.f512537a;     // Catch: Throwable -> L18
        HashMap r105 = (HashMap) r104;     // Catch: Throwable -> L18
        r105.put(r102, Integer.valueOf(r103));     // Catch: Throwable -> L18
        return r103;
    L14:
        return ((Integer) ((HashMap) this.f512537a).get(r102)).intValue();
    L26:
        return 0;
    }
}
