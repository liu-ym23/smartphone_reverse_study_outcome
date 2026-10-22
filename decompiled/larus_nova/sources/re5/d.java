package re5;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class d extends s66.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f537428c;

    public d() {
        this.f537428c = "ccm.removeStorageItem";
    }

    @Override // s66.c, com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f537428c;
    }

    @Override // s66.c
    public final void e(u66.d r100, s66.c.a r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        if (((Context) provideContext(Context.class)) != null) goto L6;
        r101.a(0, "Context not provided in host");
        return;
    L6:
        String r103 = r100.f548935a;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("key");
        r103 = null;
    L10:
        c.f537426a.a(r103);
        r101.b(new i66.b(), "");
    }
}
