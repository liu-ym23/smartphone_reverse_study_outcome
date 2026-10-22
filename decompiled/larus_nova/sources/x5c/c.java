package x5c;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends c0c.b implements o5c.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o5c.b f562573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f562574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<o5c.b> f562575d;

    public static final class a {
    }

    static {
    }

    @Override // o5c.b
    public final void sendEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f562573b.sendEvent(r100, r101);
    }

    public c(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<o5c.b> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), o5c.b.class), o5c.b.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f562573b = r103.b();
        this.f562574c = r101;
        this.f562575d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        Log.i("StatisticsImplProxy", "preparing StatisticsImplProxy");
        v r102 = this.f562574c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        o5c.b r104 = (o5c.b) k.b(r102.c(r103), o5c.b.class);
        this.f562575d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
