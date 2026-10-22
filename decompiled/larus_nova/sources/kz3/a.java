package kz3;

import android.os.Message;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements r0.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f506735l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f506736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f506737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f506738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f506739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f506740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InterfaceC6635a f506741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f506742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f506743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f506744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f506745j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f506746k;

    /* JADX INFO: renamed from: kz3.a$a, reason: collision with other inner class name */
    public interface InterfaceC6635a {
        boolean a();

        void b(float r100, float r101, long r102);
    }

    public static final class b {
    }

    static {
    }

    public final void e() {
        this.f506742g = false;
        this.f506743h = false;
        a();
    }

    public a() {
        Intrinsics.checkNotNullParameter("slides_photos", "key");
        this.f506736a = new r0(this);
        this.f506737b = 3000;
        this.f506738c = 300;
        this.f506739d = (300 / 3000) * 100.0f;
    }

    public final void a() {
        this.f506746k = 0;
        this.f506744i = 0.0f;
        this.f506736a.removeMessages(10001);
    }

    public final void b() {
        if (this.f506742g == true) goto L5;
        return;
    L5:
        if (this.f506743h == false) goto L9;
        this.f506743h = false;
        this.f506736a.removeMessages(10001);
        Message r100 = Message.obtain();
        r100.what = 10001;
        r100.obj = Float.valueOf(this.f506744i);
        this.f506736a.sendMessage(r100);
        return;
    }

    public final void c(float r100) {
        if (this.f506742g == false) goto L6;
        this.f506736a.removeMessages(10001);
        Message r101 = Message.obtain();
        r101.what = 10001;
        r101.obj = Float.valueOf(r100);
        this.f506736a.sendMessage(r101);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L38;
        Object r103 = r100.obj;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Float");
        float r104 = ((Float) r103).floatValue();
        if (r104 >= 100.0f) goto L23;
        this.f506744i = r104;
        long r105 = this.f506738c;
        this.f506745j = r105;
        float r106 = this.f506739d;
        float r107 = r104 + r106;
        if (r107 < 100.0f) goto L19;
        this.f506745j = (long) ((((100.0f - r104) * 1.0f) / r106) * r105);
        long r108 = System.currentTimeMillis() - this.f506746k;
        long r109 = this.f506737b;
        if (r108 >= r109) goto L16;
        this.f506745j = Math.min(this.f506745j, r109 - r108);
    L16:
        InterfaceC6635a r110 = this.f506741f;
        if (r110 == null) goto L22;
        r110.b(this.f506744i, 99.0f, this.f506745j);
    L22:
        Message r111 = Message.obtain();
        r111.what = 10001;
        r111.obj = Float.valueOf(r104 + this.f506739d);
        this.f506736a.sendMessageDelayed(r111, this.f506745j);
        return;
    L19:
        InterfaceC6635a r112 = this.f506741f;
        if (r112 == null) goto L22;
        r112.b(r104, r107, r105);
        goto L22
    L23:
        a();
        InterfaceC6635a r113 = this.f506741f;
        if (r113 == null) goto L26;
        r113.b(100.0f, 100.0f, this.f506745j);
    L26:
        InterfaceC6635a r114 = this.f506741f;
        if (r114 == null) goto L29;
        r101 = r114.a();
    L29:
        if (r101 == true) goto L31;
        return;
    L31:
        if (this.f506740e == true) goto L33;
        return;
    L33:
        if (this.f506742g == true) goto L35;
        return;
    L35:
        if (this.f506736a.hasMessages(10001) == true) goto L43;
        Message r115 = Message.obtain();
        r115.what = 10001;
        r115.obj = Float.valueOf(0.0f);
        this.f506736a.sendMessageDelayed(r115, this.f506738c);
        return;
    L43:
        return;
    L38:
        return;
    L5:
        if (r100.what != 10001) goto L7;
        r102 = true;
        goto L8
    }

    public final void d(boolean r100, long r101, boolean r102) {
        InterfaceC6635a r103 = this.f506741f;
        if (r103 == null) goto L5;
        boolean r104 = r103.a();
    L6:
        if (r104 == true) goto L8;
        return;
    L8:
        if (r102 == false) goto L11;
        e();
    L11:
        if (this.f506742g == true) goto L13;
    L15:
        this.f506740e = r100;
        if (r101 <= 0) goto L18;
        this.f506737b = r101;
        this.f506739d = (this.f506738c / r101) * 100.0f;
    L18:
        this.f506742g = true;
        this.f506736a.removeMessages(10001);
        this.f506746k = System.currentTimeMillis();
        Message r105 = Message.obtain();
        r105.what = 10001;
        r105.obj = Float.valueOf(0.0f);
        this.f506736a.sendMessage(r105);
        return;
    L13:
        if (this.f506743h == true) goto L15;
        return;
    L5:
        r104 = true;
        goto L6
    }
}
