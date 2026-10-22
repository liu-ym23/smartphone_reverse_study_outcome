package os7;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.dtf.face.config.OSSConfig;
import com.dtf.face.network.APICallback;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f526539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ os7.a.d f526540b;

    public class a implements APICallback<Map<String, Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f526541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f526542b;

        @Override // com.dtf.face.network.APICallback
        public final void onSuccess(Map<String, Object> r100) {
            this.f526541a.put("result", Boolean.TRUE);
            Object r101 = this.f526542b;
            monitor-enter(r101);
            this.f526542b.notifyAll();     // Catch: Throwable -> L10
        L13:
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public a(Map r100, Object r101) {
            this.f526541a = r100;
            this.f526542b = r101;
        }

        @Override // com.dtf.face.network.APICallback
        public final void onError(String r100, String r101, String r102) {
            this.f526541a.put("result", Boolean.FALSE);
            if (TextUtils.isEmpty(r101) == true) goto L5;
            this.f526541a.put("msg", r101);
        L5:
            Object r103 = this.f526542b;
            monitor-enter(r103);
            this.f526542b.notifyAll();     // Catch: Throwable -> L13
        L14:
            monitor-exit(r103);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public final void a() {
        OSSConfig r100 = ((os7.a.b) ListProtector.get(this.f526539a, 0)).f526533e;
        Object r101 = new Object();
        HashMap r102 = new HashMap();
        Iterator r103 = this.f526539a.iterator();
        boolean r104 = false;
        int r105 = 0;
    L4:
        if (r103.hasNext() == false) goto L27;
        os7.a.b r106 = (os7.a.b) r103.next();
        r102.clear();
        r102.put("result", Boolean.FALSE);
        HashMap r107 = new HashMap();
        r107.put("fileName", r106.f526531c);
        r107.put("fileContent", r106.f526532d);
        r107.put("ossConfig", r100);
        r107.put("callback", new a(r102, r101));
        ls7.a.f().d(r107, (APICallback) r107.get("callback"));
        monitor-enter(r101);
    L24:
        th = move-exception;
        throw th;
    L8:
        if (r102.size() == 0) goto L35;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L24
        Object r108 = r102.get("result");
        if (r108 == null) goto L21;
        if ((r108 instanceof Boolean) == false) goto L21;
        if (((Boolean) r108).booleanValue() == false) goto L21;
        r105 = r105 + 1;
        os7.a.d r109 = this.f526540b;
        if (r109 == null) goto L4;
        r109.b(r106.f526529a, r106.f526530b, r106.f526531c);
        r104 = false;
    L21:
        os7.a.d r110 = this.f526540b;
        if (r110 == null) goto L4;
        r104 = r110.a(r106.f526529a, r106.f526530b, r106.f526531c, (String) r102.get("msg"));
        goto L4
    L35:
        r101.wait(20000);     // Catch: Throwable -> L32
        goto L11
    L27:
        os7.a.d r111 = this.f526540b;
        if (r111 == null) goto L49;
        if (r104 == true) goto L50;
        r111.d(this.f526539a.size(), r105, r100.BucketName, null);
        return;
    L50:
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

    public c(ArrayList r100, b r101) {
        this.f526539a = r100;
        this.f526540b = r101;
    }
}
