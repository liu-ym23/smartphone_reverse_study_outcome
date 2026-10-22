package ea5;

import com.bytedance.ee.bear.drive.view.preview.video.VideoView;
import io.reactivex.functions.Predicate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n0 implements Predicate<Long> {
    public final /* synthetic */ VideoView a;

    public n0(VideoView r1) {
        this.a = r1;
    }

    public final boolean test(Object r3) throws Exception {
        Long r4 = (Long) r3;
        VideoView r5 = this.a;
        if (r5.h <= r5.g) goto L5;
    L7:
        return false;
    L5:
        if (r5.m != 4) goto L7;
        return true;
    }
}
