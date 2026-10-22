package mi9;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.c;
import com.larus.live.api.ILiveService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements q97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f514127a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f514127a = LazyKt.lazy(new mi9.a());
    }

    @Override // q97.a
    public final boolean b(c r100) {
        if (r100 != null) goto L4;
    L17:
        return false;
    L4:
        if (c(r100) == true) goto L17;
        Uri r101 = r100.f267530d;
        if (r101 == null) goto L9;
        String r102 = r101.getHost();
    L11:
        if (Intrinsics.areEqual(r102, SchemaHandlerHostConstants.ROOM_SCHEMA_HOST) == false) goto L14;
        return true;
    L14:
        ILiveService r103 = (ILiveService) this.f514127a.getValue();
        if (r103 == null) goto L17;
        return r103.g(r100.f267530d);
    L9:
        r102 = null;
        goto L11
    }

    public final boolean c(c r100) {
        Uri r101 = r100.f267530d;
        if (r101 != null) goto L5;
        return false;
    L5:
        ILiveService r102 = (ILiveService) this.f514127a.getValue();
        if (r102 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r101.getHost(), SchemaHandlerHostConstants.ROOM_SCHEMA_HOST) == true) goto L15;
    L16:
        return true;
    L15:
        if (UriProtector.getQueryParameterNames(r101).contains("schema") == true) goto L16;
        return false;
    L8:
        if (r102.b() != true) goto L10;
        r103 = true;
        goto L11
    }

    @Override // q97.a
    public final boolean a(Context r100, c r101) {
        if (r100 == null) goto L27;
        if (r101 == null) goto L27;
        if (c(r101) == true) goto L27;
        ILiveService r102 = (ILiveService) this.f514127a.getValue();
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r102.a() == true) goto L19;
        Object r103 = r102.f();
        if (Result.m9455isFailureimpl(r103) == false) goto L16;
    L17:
        Result.m9452exceptionOrNullimpl(r103);
        return false;
    L16:
        if (r102.a() == false) goto L17;
    L19:
        Uri r104 = r101.f267530d;
        if (r104 != null) goto L23;
        return false;
    L23:
        if (r102.e() == false) goto L25;
        r104 = r104.buildUpon().appendQueryParameter("doubao_live_router_source_7f3a9c2d", "1").build();
    L25:
        Intrinsics.checkNotNull(r104);
        return r102.c(r100, r104);
    L27:
        return false;
    }
}
