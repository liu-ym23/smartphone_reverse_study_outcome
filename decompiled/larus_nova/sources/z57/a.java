package z57;

import android.text.TextUtils;
import com.bytedance.praisedialoglib.manager.g;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import org.json.JSONObject;
import y57.d;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f570111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC8421a f570112b;

    /* JADX INFO: renamed from: z57.a$a, reason: collision with other inner class name */
    public interface InterfaceC8421a {
    }

    public final void a() {
        HashMap r100 = new HashMap();     // Catch: Throwable -> L21
        r100.put("uid", this.f570111a);     // Catch: Throwable -> L21
        com.bytedance.praisedialoglib.manager.a r101 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a;     // Catch: Throwable -> L21
        y57.a r102 = r101.f266636b;     // Catch: Throwable -> L21
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getHost();     // Catch: Throwable -> L21
    L7:
        if (TextUtils.isEmpty(r104) == false) goto L9;
        return;
    L9:
        String r105 = r104 + "/zebra/praise";     // Catch: Throwable -> L21
        d r106 = r101.f266635a;     // Catch: Throwable -> L21
        if (r106 == null) goto L13;
        r103 = r106.a(r105, r100);     // Catch: Throwable -> L21
    L13:
        if (TextUtils.isEmpty(r103) == false) goto L16;
        ((g.a) this.f570112b).a();     // Catch: Throwable -> L21
        return;
    L16:
        JSONObject r107 = new JSONObject(r103);     // Catch: Throwable -> L21
        r107.optInt("errCode");     // Catch: Throwable -> L21
        r107.optString("message");     // Catch: Throwable -> L21
        r107.optString("data");     // Catch: Throwable -> L21
        if (r107.optInt("dialogShow", -1) != 0) goto L19;
        ((g.a) this.f570112b).b();     // Catch: Throwable -> L21
        return;
    L19:
        ((g.a) this.f570112b).a();     // Catch: Throwable -> L21
        return;
    L5:
        r104 = null;
    L21:
        th = move-exception;
        th.printStackTrace();
        ((g.a) this.f570112b).a();
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

    public a(String r100, g.a r101) {
        this.f570111a = r100;
        this.f570112b = r101;
    }
}
