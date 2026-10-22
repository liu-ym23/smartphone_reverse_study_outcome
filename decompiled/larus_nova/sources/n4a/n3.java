package n4a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<m3> f517556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f517557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f517558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f517559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f517560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f517561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f517562g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n3 f517563a;

        public a(n3 r100) {
            this.f517563a = r100;
        }

        public final void a() {
            n3 r100 = this.f517563a;
            if (r100.f517558c == false) goto L5;
            return;
        L5:
            if (r100.f517561f == false) goto L18;
            StringBuilder r101 = new StringBuilder();
            Iterator<m3> r102 = r100.f517556a.iterator();
        L8:
            if (r102.hasNext() == false) goto L14;
            r101.append(y4.d(t3.c(r102.next().a().getBytes("UTF-8"), r100.f517560e)) + "\n");     // Catch: UnsupportedEncodingException -> L12
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L8
        L14:
            String r103 = r101.toString();
            if (TextUtils.isEmpty(r103) == true) goto L17;
            j4.h(r100.f517557b, r103);
        L17:
            this.f517563a.f517561f = false;
        L18:
            n3 r104 = this.f517563a;
            Handler r105 = r104.f517559d;
            if (r105 == null) goto L29;
            r105.postDelayed(r104.f517562g, 60000);
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
    }

    public final void b(m3 r110, int r111) {
        Iterator<m3> r100 = this.f517556a.iterator();
        m3 r101 = null;
        m3 r102 = null;
        int r103 = 0;
    L4:
        if (r100.hasNext() == false) goto L11;
        m3 r104 = r100.next();
        if (r104.f517521a != r111) goto L4;
        if (r102 != null) goto L9;
        r102 = r104;
    L9:
        r103 = r103 + 1;
        r101 = r104;
        goto L4
    L11:
        if (r101 == null) goto L18;
        if ((r110.f517524d - r101.f517524d) >= 20000) goto L18;
        if (j4.c(new double[]{r110.f517522b, r110.f517523c, r101.f517522b, r101.f517523c}) >= 20.0f) goto L18;
        return;
    L18:
        if (r103 < 5) goto L21;
        this.f517556a.remove(r102);
    L21:
        if (this.f517556a.size() < 10) goto L23;
        this.f517556a.removeFirst();
    L23:
        this.f517556a.add(r110);
        this.f517561f = true;
    }

    public n3(Context r100, Handler r101) {
        this.f517556a = new LinkedList();
        this.f517558c = false;
        this.f517560e = null;
        this.f517562g = new a(this);
        this.f517559d = r101;
        String r102 = r100.getFilesDir().getPath();
        this.f517560e = j4.I(r100);
        this.f517557b = new PolarisFileWrapper(r102, "hisloc");     // Catch: Throwable -> L5
    L6:
        LinkedList<m3> r103 = this.f517556a;
        if (r103 != null) goto L9;
    L11:
        Iterator r104 = ((ArrayList) j4.g(this.f517557b)).iterator();
    L13:
        if (r104.hasNext() == false) goto L21;
        String r105 = new String(t3.e(y4.e((String) r104.next()), this.f517560e), "UTF-8");     // Catch: JSONException -> L17 UnsupportedEncodingException -> L19
        m3 r106 = new m3();     // Catch: JSONException -> L17 UnsupportedEncodingException -> L19
        r106.b(new JSONObject(r105));     // Catch: JSONException -> L17 UnsupportedEncodingException -> L19
        this.f517556a.add(r106);     // Catch: JSONException -> L17 UnsupportedEncodingException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L17:
        e = move-exception;
        e.printStackTrace();
    L21:
        Handler r107 = this.f517559d;
        if (r107 == null) goto L34;
        r107.removeCallbacks(this.f517562g);
        this.f517559d.postDelayed(this.f517562g, 60000);
        return;
    L34:
        return;
    L9:
        if (r103.size() <= 0) goto L11;
        goto L11
    }

    public final List<m3> a(ArrayList<k3> r110, ArrayList<v2> r111) {
        int r100 = 0;
        if (r110 != null) goto L5;
    L17:
        boolean r112 = true;
    L18:
        if (r112 == false) goto L28;
        long r113 = System.currentTimeMillis();
        ArrayList r101 = new ArrayList();
        Iterator<m3> r102 = this.f517556a.iterator();
    L21:
        if (r102.hasNext() == false) goto L27;
        m3 r103 = r102.next();
        if ((r113 - r103.f517524d) >= 21600000000L) goto L26;
        r101.add(r103);
        r100 = r100 + 1;
    L26:
        if (r100 != 10) goto L21;
    L27:
        return r101;
    L28:
        return null;
    L5:
        if (r110.size() <= 0) goto L17;
        if (r111 == null) goto L17;
        if (r111.size() <= 0) goto L17;
        if (r110.size() < 4) goto L15;
    L13:
        r112 = false;
        goto L18
    L15:
        if (r111.size() < 20) goto L17;
        goto L17
    }
}
