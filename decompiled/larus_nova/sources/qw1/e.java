package qw1;

import com.bytedance.android.livesdk.feed.preview.f;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f534966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f534967b;

    public final void a() {
        d r100 = this.f534966a;
        if (r100.f534963d == true) goto L7;
        r100.f534963d = true;
        r100.a();
        return;
    }

    public final void b() {
        d r100 = this.f534966a;
        if (r100.f534963d == false) goto L7;
        r100.f534963d = false;
        r100.f534960a.removeCallbacksAndMessages(null);
        return;
    }

    public e(long r100, long r101, f r102) {
        this.f534966a = new d(r100, this);
        this.f534967b = r102;
    }
}
