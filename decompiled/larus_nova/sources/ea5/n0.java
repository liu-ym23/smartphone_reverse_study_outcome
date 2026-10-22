package ea5;

import com.bytedance.ee.bear.drive.view.preview.video.VideoView;
import io.reactivex.functions.Predicate;

/* JADX INFO: loaded from: classes16.dex */
public final class n0 implements Predicate<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoView f471611a;

    public n0(VideoView r100) {
        this.f471611a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Long r100) throws Exception {
        VideoView r101 = this.f471611a;
        if (r101.f225507h <= r101.f225506g) goto L5;
    L7:
        return false;
    L5:
        if (r101.f225512m != 4) goto L7;
        return true;
    }
}
