package kz3;

import android.os.Message;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements r0.a {
    public static final /* synthetic */ int l = 0;
    public final r0 a;
    public long b;
    public long c;
    public float d;
    public boolean e;
    public InterfaceC0142a f;
    public boolean g;
    public boolean h;
    public float i;
    public long j;
    public long k;

    /* JADX INFO: renamed from: kz3.a$a, reason: collision with other inner class name */
    public interface InterfaceC0142a {
        boolean a();

        void b(float r1, float r2, long r3);
    }

    public static final class b {
    }

    static {
    }

    public final void e() {
        this.g = false;
        this.h = false;
        a();
    }

    public a() {
        Intrinsics.checkNotNullParameter("slides_photos", "key");
        this.a = new r0(this);
        this.b = 3000;
        this.c = 300;
        this.d = (300 / 3000) * 100.0f;
    }

    public final void a() {
        this.k = 0;
        this.i = 0.0f;
        this.a.removeMessages(10001);
    }

    public final void b() {
        if (this.g == true) goto L5;
        return;
    L5:
        if (this.h == false) goto L9;
        this.h = false;
        this.a.removeMessages(10001);
        Message r0 = Message.obtain();
        r0.what = 10001;
        r0.obj = Float.valueOf(this.i);
        this.a.sendMessage(r0);
        return;
    }

    public final void c(float r3) {
        if (this.g == false) goto L6;
        this.a.removeMessages(10001);
        Message r0 = Message.obtain();
        r0.what = 10001;
        r0.obj = Float.valueOf(r3);
        this.a.sendMessage(r0);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r9) {
        boolean r0 = true;
        if (r9 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L38;
        Object r10 = r9.obj;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Float");
        float r11 = ((Float) r10).floatValue();
        if (r11 >= 100.0f) goto L23;
        this.i = r11;
        long r3 = this.c;
        this.j = r3;
        float r1 = this.d;
        float r5 = r11 + r1;
        if (r5 < 100.0f) goto L19;
        this.j = (long) ((((100.0f - r11) * 1.0f) / r1) * r3);
        long r4 = System.currentTimeMillis() - this.k;
        long r6 = this.b;
        if (r4 >= r6) goto L16;
        this.j = Math.min(this.j, r6 - r4);
    L16:
        InterfaceC0142a r7 = this.f;
        if (r7 == null) goto L22;
        r7.b(this.i, 99.0f, this.j);
    L22:
        Message r8 = Message.obtain();
        r8.what = 10001;
        r8.obj = Float.valueOf(r11 + this.d);
        this.a.sendMessageDelayed(r8, this.j);
        return;
    L19:
        InterfaceC0142a r12 = this.f;
        if (r12 == null) goto L22;
        r12.b(r11, r5, r3);
        goto L22
    L23:
        a();
        InterfaceC0142a r13 = this.f;
        if (r13 == null) goto L26;
        r13.b(100.0f, 100.0f, this.j);
    L26:
        InterfaceC0142a r14 = this.f;
        if (r14 == null) goto L29;
        r0 = r14.a();
    L29:
        if (r0 == true) goto L31;
        return;
    L31:
        if (this.e == true) goto L33;
        return;
    L33:
        if (this.g == true) goto L35;
        return;
    L35:
        if (this.a.hasMessages(10001) == true) goto L43;
        Message r15 = Message.obtain();
        r15.what = 10001;
        r15.obj = Float.valueOf(0.0f);
        this.a.sendMessageDelayed(r15, this.c);
        return;
    L43:
        return;
    L38:
        return;
    L5:
        if (r9.what != 10001) goto L7;
        r2 = true;
        goto L8
    }

    public final void d(boolean r5, long r6, boolean r8) {
        InterfaceC0142a r0 = this.f;
        if (r0 == null) goto L5;
        boolean r1 = r0.a();
    L6:
        if (r1 == true) goto L8;
        return;
    L8:
        if (r8 == false) goto L11;
        e();
    L11:
        if (this.g == true) goto L13;
    L15:
        this.e = r5;
        if (r6 <= 0) goto L18;
        this.b = r6;
        this.d = (this.c / r6) * 100.0f;
    L18:
        this.g = true;
        this.a.removeMessages(10001);
        this.k = System.currentTimeMillis();
        Message r7 = Message.obtain();
        r7.what = 10001;
        r7.obj = Float.valueOf(0.0f);
        this.a.sendMessage(r7);
        return;
    L13:
        if (this.h == true) goto L15;
        return;
    L5:
        r1 = true;
        goto L6
    }
}
