package qs7;

import android.util.Pair;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile List<c> f534677g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f534678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f534679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ms7.a> f534680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public qs7.a f534681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, Object> f534682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f534683f;

    public class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f534684a;

        @Override // qs7.c.b
        public final void d() {
            Iterator r100 = ((CopyOnWriteArrayList) this.f534684a.f534680c).iterator();
        L4:
            if (r100.hasNext() == false) goto L8;
            ms7.a r101 = (ms7.a) r100.next();
            if ((r101 instanceof b) == false) goto L4;
            ((b) r101).d();
            goto L4
        }

        @Override // ms7.a
        public final void onSuccess() {
            Iterator r100 = ((CopyOnWriteArrayList) this.f534684a.f534680c).iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((ms7.a) r100.next()).onSuccess();
            goto L4
        }

        public a(c r100) {
            this.f534684a = r100;
        }

        @Override // ms7.a
        public final void a(String r100) {
            Iterator r101 = ((CopyOnWriteArrayList) this.f534684a.f534680c).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((ms7.a) r101.next()).a(r100);
            goto L4
        }

        @Override // qs7.c.b
        public final boolean c(c r100, List<Pair<Integer, String>> r101) {
            Iterator r102 = ((CopyOnWriteArrayList) this.f534684a.f534680c).iterator();
            boolean r103 = false;
        L4:
            if (r102.hasNext() == false) goto L8;
            ms7.a r104 = (ms7.a) r102.next();
            if ((r104 instanceof b) == false) goto L4;
            r103 = ((b) r104).c(this.f534684a, r101);
            goto L4
        L8:
            return r103;
        }

        @Override // ms7.a
        public final void onError(String r100, String r101) {
            Iterator r102 = ((CopyOnWriteArrayList) this.f534684a.f534680c).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((ms7.a) r102.next()).onError(r100, r101);
            goto L4
        }

        @Override // ms7.a
        public final void onServerError(String r100, String r101) {
            Iterator r102 = ((CopyOnWriteArrayList) this.f534684a.f534680c).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((ms7.a) r102.next()).onServerError(r100, r101);
            goto L4
        }

        @Override // ms7.a
        public final void b(String r100, String r101, String r102) {
            Iterator r103 = ((CopyOnWriteArrayList) this.f534684a.f534680c).iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((ms7.a) r103.next()).b(r100, r101, r102);
            goto L4
        }
    }

    public static abstract class b implements ms7.a {
        public boolean c(c r100, List<Pair<Integer, String>> r101) {
            return false;
        }

        public void d() {
        }

        public b() {
        }
    }

    static {
        f534677g = new CopyOnWriteArrayList();
    }

    public final void a() {
        if (this.f534682e != null) goto L6;
        RecordService.getInstance().recordEvent(2, "VerifyTask", new String[]{"msg", "verifyNull"});
        this.f534678a.onError("Z1027", null);
        return;
    L6:
        Runnable r100 = this.f534683f;
        if (r100 == null) goto L9;
        r100.run();
    L9:
        ls7.a r101 = ls7.a.f();
        Map<String, Object> r102 = this.f534682e;
        r101.e(r102, (APICallback) r102.get("callback"));
    }

    public c() {
        this.f534679b = -1;
        this.f534680c = new CopyOnWriteArrayList();
        this.f534678a = new a(this);
    }
}
