package nv3;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.applet.aibridge.health.HealthAuthFragment;
import com.hihonor.cloudservice.common.ApiException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class g implements kw7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f520830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ iw7.a f520831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f520832c;

    public /* synthetic */ g(String r100, iw7.a r101, FragmentActivity r102) {
        this.f520830a = r100;
        this.f520831b = r101;
        this.f520832c = r102;
    }

    public final void a(Exception r100) {
        final String r101 = this.f520830a;
        iw7.a r102 = this.f520831b;
        FragmentActivity r103 = this.f520832c;
        com.bytedance.applet.aibridge.health.a.f191159a.getClass();
        com.bytedance.applet.aibridge.health.a.C2775a r104 = com.bytedance.applet.aibridge.health.a.f191161c;
        Integer r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.f191163a;
    L7:
        if (Intrinsics.areEqual(r106, r101) == true) goto L10;
        return;
    L10:
        if ((r100 instanceof ApiException) == false) goto L12;
        ApiException r107 = (ApiException) r100;
    L13:
        if (r107 == null) goto L15;
        r105 = Integer.valueOf(r107.getStatusCode());
    L15:
        if (r105 != null) goto L18;
    L19:
        f3.a r108 = f3.a.f475268i;
        StringBuilder r109 = new StringBuilder("Honor health authorization failed, statusCode=");
        Object r110 = r105;
        if (r105 != null) goto L22;
        r110 = "unknown";
    L22:
        r109.append(r110);
        com.bytedance.applet.aibridge.health.a.b(r101, r108, r109.toString());
        return;
    L18:
        if (r105.intValue() != 55) goto L19;
        Intent r111 = r102.getSignInIntent();
        if (r111 != null) goto L26;
        com.bytedance.applet.aibridge.health.a.b(r101, f3.a.f475266g, "Honor health sign-in is unavailable");
        return;
    L26:
        HealthAuthFragment.a r112 = HealthAuthFragment.f191151i;
        Function2 r113 = new i(r101);
        Function0 r114 = new j(r101);
        r112.getClass();
        HealthAuthFragment.a.a(r103, r111, r113, r114);
        return;
    L12:
        r107 = null;
        goto L13
    L5:
        r106 = null;
        goto L7
    }
}
