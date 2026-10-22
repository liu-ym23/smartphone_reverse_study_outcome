package xk2;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import si2.g;
import vi2.h;
import vi2.h0;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f564190a;

    public final void a() {
        a r100 = this.f564190a;
        JSONObject r101 = r100.f564183d;
        if (r101 == null) goto L5;
        String r102 = r101.optString("ad_adv_id");
    L6:
        String r103 = r100.f564180a;
        JSONObject r104 = r100.f564183d;
        if (r104 == null) goto L9;
        String r105 = r104.optString("ad_room_id");
    L11:
        if ((!Intrinsics.areEqual(r103, r105)) == false) goto L13;
        r102 = null;
    L13:
        String r106 = r100.f564180a;
        String r107 = r100.f564181b;
        String r108 = r100.f564182c;
        String r109 = h.f555073a;
        bk2.c.a(h.e(null, null, g.O, new h0(r106, r107, r108, r102)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r100), new d(r100)), r100);
        return;
    L9:
        r105 = null;
        goto L11
    L5:
        r102 = null;
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

    public e(a r100) {
        this.f564190a = r100;
    }
}
