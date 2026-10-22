package xmb;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import nza.b;
import yya.k;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKUserScope
public final class a implements b {

    /* JADX INFO: renamed from: xmb.a$a, reason: collision with other inner class name */
    public static final class C8258a {
    }

    static {
    }

    @Inject
    public a() {
    }

    @Override // nza.b
    public final void a(y6b.a<?> r100, m<y6b.a<?>> r101, List<k> r102) {
        Intrinsics.checkNotNullParameter(r100, "messageVO");
        Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r102, "messageActionList");
        y5b.a r103 = (y5b.a) r101.c().f410652c.a(y5b.a.class);
        if (r103 != null) goto L6;
        Log.w("OfficeMessageMenuServic", "message menu env not found.");
        return;
    L6:
        r103.e(r100, r101, r102);
    }
}
