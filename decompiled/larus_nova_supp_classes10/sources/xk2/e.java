package xk2;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import si2.g;
import vi2.h;
import vi2.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements Runnable {
    public final /* synthetic */ a a;

    public final void a() {
        a r0 = this.a;
        JSONObject r1 = r0.d;
        if (r1 == null) goto L5;
        String r2 = r1.optString("ad_adv_id");
    L6:
        String r3 = r0.a;
        JSONObject r4 = r0.d;
        if (r4 == null) goto L9;
        String r5 = r4.optString("ad_room_id");
    L11:
        if ((!Intrinsics.areEqual(r3, r5)) == false) goto L13;
        r2 = null;
    L13:
        String r6 = r0.a;
        String r7 = r0.b;
        String r8 = r0.c;
        String r9 = h.a;
        bk2.c.a(h.e(null, null, g.O, new h0(r6, r7, r8, r2)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r0), new d(r0)), r0);
        return;
    L9:
        r5 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(a r1) {
        this.a = r1;
    }
}
