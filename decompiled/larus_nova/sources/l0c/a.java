package l0c;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.Scene;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f506907a;

    @Inject
    public a() {
        this.f506907a = new ConcurrentHashMap();
    }

    @Override // l0c.d
    public final void a(j0c.b r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "executeStrategy");
        this.f506907a.put(r100.f496844a, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // l0c.d
    public final void b(j0c.b r110, String r111, Scene r112) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "executeStrategy");
        Long r100 = this.f506907a.get(r110.f496844a);
        String r101 = null;
        if (r100 != null) goto L8;
        StringBuilder r102 = new StringBuilder("[");
        r102.append(r110.f496844a);
        r102.append("] task miss start time , executeStrategy = ");
        r102.append(r111);
        r102.append(", scene=");
        if (r112 == null) goto L7;
        r101 = r112.name();
    L7:
        r102.append(r101);
        Log.w("ComponentTask", r102.toString());
        return;
    L8:
        long r103 = System.currentTimeMillis() - r100.longValue();
        StringBuilder r104 = new StringBuilder("[");
        r104.append(r110.f496844a);
        r104.append("] task cost = ");
        r104.append(r103);
        r104.append(" ms , executeStrategy = ");
        r104.append(r111);
        r104.append(", scene=");
        if (r112 == null) goto L11;
        r101 = r112.name();
    L11:
        r104.append(r101);
        Log.i("ComponentTask", r104.toString());
    }
}
