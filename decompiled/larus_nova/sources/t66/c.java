package t66;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends s66.c {
    public c() {
    }

    @Override // s66.c
    public final void e(u66.d r100, s66.c.a r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Context r103 = (Context) provideContext(Context.class);
        boolean r104 = false;
        if (r103 != null) goto L6;
        r101.a(0, "Context not provided in host");
        return;
    L6:
        String r105 = r100.f548935a;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("key");
        r105 = null;
    L10:
        String r106 = r100.f548936b;
        p56.d r107 = com.bytedance.ies.xbridge.storage.utils.a.a(r103);
        Intrinsics.checkNotNullParameter(r107, "<this>");
        if (r106 != null) goto L13;
    L14:
        r104 = true;
    L15:
        if (r104 == false) goto L17;
    L19:
        boolean r108 = r107.a(r105);
    L20:
        if (r108 == false) goto L22;
        r101.b(new i66.b(), "");
        return;
    L22:
        r101.a(2, "Key not found in certain storage");
        return;
    L17:
        if ((r107 instanceof p56.a) == false) goto L19;
        Intrinsics.checkNotNull(r106);
        r108 = ((p56.a) r107).b(r106, r105);
        goto L20
    L13:
        if (r106.length() != 0) goto L15;
        goto L14
    }
}
