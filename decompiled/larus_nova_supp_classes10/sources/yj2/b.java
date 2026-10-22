package yj2;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.livecommerce.room.api.c;
import com.bytedance.android.livesdk.livecommerce.utils.p0;
import io.reactivex.Observable;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static WeakReference<c> a;

    static {
    }

    @JvmStatic
    public static final void a(Context r4, ge.b r5, p0 r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "observer");
        if (r4 != null) goto L6;
        new Throwable("no context");
        return;
    L6:
        WeakReference<c> r0 = a;
        if (r0 == null) goto L16;
        c r1 = r0.get();
        if (r1 == null) goto L17;
        int r2 = ge.b.h;
        ge.b.a r3 = new ge.b.a();
        String r7 = r5.d;
        Intrinsics.checkNotNullParameter(r7, "source");
        r3.d = r7;
        String r8 = r5.f;
        Intrinsics.checkNotNullParameter(r8, "actionType");
        r3.f = r8;
        String r9 = r5.e;
        Intrinsics.checkNotNullParameter(r9, "enterFrom");
        r3.e = r9;
        r3.c = r5.c;
        String r10 = r5.b;
        Intrinsics.checkNotNullParameter(r10, "imageUrl");
        r3.b = r10;
        String r11 = r5.a;
        Intrinsics.checkNotNullParameter(r11, "msg");
        r3.a = r11;
        Bundle r12 = r5.g;
        Intrinsics.checkNotNullParameter(r12, "bundle");
        r3.g = r12;
        Observable<ge.a> r13 = r1.g(r4, new ge.b(r3));
        if (r13 == null) goto L18;
        Observable r14 = r13.map(a.a);
        if (r14 == null) goto L19;
        r14.subscribe(r6);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }
}
