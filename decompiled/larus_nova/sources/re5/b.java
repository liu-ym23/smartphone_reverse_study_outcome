package re5;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class b extends s66.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f537425c;

    public b() {
        this.f537425c = "ccm.getStorageItem";
    }

    @Override // s66.b, com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f537425c;
    }

    @Override // s66.b
    public final void e(u66.b r100, s66.b.a r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        if (((Context) provideContext(Context.class)) != null) goto L6;
        r101.a();
        return;
    L6:
        String r103 = r100.f548930a;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("key");
        r103 = null;
    L10:
        Object r104 = c.f537426a.d(r103);
        u66.c r105 = new u66.c();
        r105.f548933a = r104;
        r101.b(r105, "");
    }
}
