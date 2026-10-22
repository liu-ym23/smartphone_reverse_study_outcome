package ia5;

import com.bytedance.ee.bear.drive.view.preview.video.VideoPlayerControllerView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f488920a;

    public c(b r100) {
        this.f488920a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        tt5.a.h("VideoProgressTimerManager", "video timer interval, instance=" + this.f488920a.f488915a.hashCode() + " mIsTouchSeekBar=" + this.f488920a.f488917c);
        b r102 = this.f488920a;
        if (r102.f488917c == false) goto L5;
        r102.f488919e = -1;
    L5:
        int r103 = r102.f488919e + 1;
        r102.f488919e = r103;
        if (r103 >= 2) goto L8;
        return;
    L8:
        if (b.f488914f.contains(Integer.valueOf(r102.f488916b)) == false) goto L31;
        VideoPlayerControllerView r104 = (VideoPlayerControllerView) this.f488920a.f488915a;
        boolean r105 = false;
        if (r104.f225495y == false) goto L12;
    L14:
        boolean r106 = false;
    L15:
        if (r106 == false) goto L17;
    L28:
        this.f488920a.a();
        return;
    L17:
        if (r104.f225496z == true) goto L19;
    L21:
        if (r105 == true) goto L28;
        if (r104.f225491u != 0) goto L28;
        r104.f225483m.liveInnerToggleFullScreen().postValue(r104.f225486p.f225835c);
        if (r104.A == true) goto L28;
        r104.f225493w = true;
        r104.f225474d.setVideoControlBarClearScreen(true);
        r104.q();
        r104.B.c();
        goto L28
    L19:
        if (r104.j() == false) goto L21;
        r105 = true;
        goto L21
    L12:
        if (r104.j() == false) goto L14;
        r106 = true;
        goto L15
    }
}
