package ia5;

import com.bytedance.ee.bear.drive.view.preview.video.VideoPlayerControllerView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        tt5.a.h("VideoProgressTimerManager", "video timer interval, instance=" + this.a.a.hashCode() + " mIsTouchSeekBar=" + this.a.c);
        b r9 = this.a;
        if (r9.c == false) goto L5;
        r9.e = -1;
    L5:
        int r0 = r9.e + 1;
        r9.e = r0;
        if (r0 >= 2) goto L8;
        return;
    L8:
        if (b.f.contains(Integer.valueOf(r9.b)) == false) goto L31;
        VideoPlayerControllerView r10 = (VideoPlayerControllerView) this.a.a;
        boolean r2 = false;
        if (r10.y == false) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L17;
    L28:
        this.a.a();
        return;
    L17:
        if (r10.z == true) goto L19;
    L21:
        if (r2 == true) goto L28;
        if (r10.u != 0) goto L28;
        r10.m.liveInnerToggleFullScreen().postValue(r10.p.c);
        if (r10.A == true) goto L28;
        r10.w = true;
        r10.d.setVideoControlBarClearScreen(true);
        r10.q();
        r10.B.c();
        goto L28
    L19:
        if (r10.j() == false) goto L21;
        r2 = true;
        goto L21
    L12:
        if (r10.j() == false) goto L14;
        r1 = true;
        goto L15
    }
}
