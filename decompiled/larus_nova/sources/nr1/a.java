package nr1;

import com.bytedance.android.livesdk.chatroom.helper.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements wr1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f520166a;

    @Override // wr1.c
    public final void b() {
        f r100 = this.f520166a;
        r100.f106451n = r100.toString();
    }

    @Override // wr1.c
    public final void c() {
        this.f520166a.i();
    }

    @Override // wr1.c
    public final void d() {
        this.f520166a.e();
    }

    @Override // wr1.c
    public final void reset() {
        f r100 = this.f520166a;
        r100.f106457t = false;
        r100.f106458u = false;
        r100.f106461x = false;
    }

    public a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "enterRoomMonitor");
        this.f520166a = r100;
    }

    @Override // wr1.c
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f520166a.c(r100, true);
    }

    @Override // wr1.c
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f520166a.d(r100);
    }

    @Override // wr1.c
    public final void f(boolean r100) {
        f r101 = this.f520166a;
        r101.f106458u = true;
        long r102 = System.currentTimeMillis();
        r101.f106454q = r102;
        if (r101.f106455r != 0) goto L6;
        r101.f106455r = r102;
    L6:
        if (r101.f106461x == true) goto L9;
        r101.f106461x = r100;
        return;
    }
}
