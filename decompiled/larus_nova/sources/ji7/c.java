package ji7;

import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.larus.apm.impl.protector.RunnableProtector;
import mi7.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f499212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f499213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IZlinkDepend f499214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f499215d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f499216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f499217b;

        @Override // java.lang.Runnable
        public final void run() {
            boolean r100 = this.f499217b.f499214c.dealWithSchema(this.f499216a);     // Catch: Throwable -> L4
            this.f499217b.f499215d.getClass();     // Catch: Throwable -> L4
            mi7.e.a("DeepLinkResolver", "host deal result= " + r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100, String r101) {
            this.f499217b = r100;
            this.f499216a = r101;
        }
    }

    public final void a() {
        JSONObject r100 = new JSONObject();
        String r101 = this.f499212a;
        String r102 = "";
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r102 = ci7.a.a(r101, "", r100);
    L6:
        mi7.c.a("zlink_token_verify", r100);
        if (TextUtils.isEmpty(r102) == false) goto L10;
        r102 = this.f499213b;
    L10:
        this.f499215d.getClass();
        mi7.e.c("DeepLinkResolver", "finalSchema: " + r102);
        if (TextUtils.isEmpty(r102) == true) goto L14;
        h.f(new a(this, r102));
        return;
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

    public c(d r100, String r101, String r102, IZlinkDepend r103) {
        this.f499215d = r100;
        this.f499212a = r101;
        this.f499213b = r102;
        this.f499214c = r103;
    }
}
