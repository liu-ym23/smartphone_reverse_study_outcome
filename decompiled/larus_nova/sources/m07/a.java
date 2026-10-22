package m07;

import android.content.Context;
import com.bytedance.lynx.media.view.BaseMediaView;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends BaseMediaView implements f07.c.e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f511489h;

    @Override // f07.c.e
    public final void c() {
    }

    @Override // f07.c.e
    public final void onVideoPlay() {
    }

    @Override // f07.c.e
    public final void onVideoSizeChanged(int r100, int r101) {
    }

    @Override // f07.c.e
    public final void a() {
        i07.a r100 = this.f264840e;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public final void h() {
        if (d() == true) goto L5;
        return;
    L5:
        f07.c r100 = this.f264837b;
        if (r100.f474996m == true) goto L9;
        return;
    L9:
        if (r100.c() == true) goto L11;
    L13:
        this.f264837b.d();
        LLog.i("AudioMediaView", "Did trigger VideoController play in AudioMediaView");
        if (this.f511489h == true) goto L17;
        this.f511489h = true;
        return;
    L17:
        return;
    L11:
        if (this.f264837b.f475000q == true) goto L13;
    }

    public a(Context r100) {
        super(r100);
        this.f511489h = false;
    }

    @Override // f07.c.e
    public final void b(Runnable r100) {
        r100.run();
    }

    @Override // com.bytedance.lynx.media.view.BaseMediaView
    public final void g(g07.b r100, f07.a r101) {
        super.g(r100, r101);
        f07.c r102 = this.f264837b;
        if (r102 == null) goto L6;
        r102.f474993j = this;
        return;
    }
}
