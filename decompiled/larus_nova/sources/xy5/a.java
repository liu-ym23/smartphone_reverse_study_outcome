package xy5;

import dz5.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f565406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f565407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f565408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f565409d;

    /* JADX INFO: renamed from: xy5.a$a, reason: collision with other inner class name */
    public class C8288a extends dz5.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f565410b;

        @Override // dz5.a
        public final int b() {
            return 2;
        }

        @Override // dz5.a
        public final void a() {
            this.f565410b.f565406a.execute();
            this.f565410b.a();
        }

        public C8288a(a r100) {
            this.f565410b = r100;
        }
    }

    public a() {
        com.bytedance.iesgurd.settings.a r100 = com.bytedance.iesgurd.settings.a.f250846a;
        this.f565407b = 0;
        this.f565408c = 0;
        this.f565409d = new AtomicBoolean(false);
        this.f565406a = r100;
    }

    public final void a() {
        int r100 = this.f565407b + 1;
        this.f565407b = r100;
        long r101 = (long) Math.floor(((Math.random() + 0.5d) * Math.pow(2.0d, Math.min(r100 - 2, 8))) * 5.0d);
        int r102 = (int) (((long) this.f565408c) + r101);
        this.f565408c = r102;
        if (r102 <= 5115) goto L6;
        b();
        return;
    L6:
        C8288a r103 = new C8288a(this);
        long r104 = r101 * 1000;
        dz5.b r105 = c.a.f470586a.f470585a;
        if (r104 >= 0) goto L9;
        r105.getClass();
        return;
    L9:
        r105.b(r103, r104, 0);
    }

    public final void b() {
        if (this.f565409d.get() == false) goto L10;
        this.f565407b = 0;
        dz5.b.a r100 = c.a.f470586a.f470585a.f470581a;
        if (r100 == null) goto L8;
        r100.removeMessages(2);
    L8:
        this.f565409d.set(false);
        return;
    }
}
