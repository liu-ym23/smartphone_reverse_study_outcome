package t66;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends s66.b {
    public b() {
    }

    @Override // s66.b
    public final void e(u66.b r100, s66.b.a r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Context r103 = (Context) provideContext(Context.class);
        if (r103 != null) goto L6;
        r101.a();
        return;
    L6:
        String r104 = r100.f548930a;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("key");
        r104 = null;
    L10:
        String r105 = r100.f548931b;
        p56.d r106 = com.bytedance.ies.xbridge.storage.utils.a.a(r103);
        Intrinsics.checkNotNullParameter(r106, "<this>");
        if (r105 != null) goto L13;
    L16:
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
    L21:
        Object r108 = r106.d(r104);
    L22:
        u66.c r109 = new u66.c();
        r109.f548933a = r108;
        r101.b(r109, "");
        return;
    L19:
        if ((r106 instanceof p56.a) == false) goto L21;
        Intrinsics.checkNotNull(r105);
        r108 = ((p56.a) r106).g(r105, r104);
        goto L22
    L13:
        if (r105.length() == 0) goto L16;
        r107 = false;
        goto L17
    }
}
