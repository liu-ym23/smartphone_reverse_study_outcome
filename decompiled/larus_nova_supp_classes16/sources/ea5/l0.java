package ea5;

import com.bytedance.ee.bear.drive.view.preview.video.VideoView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l0 implements Consumer<Long> {
    public final /* synthetic */ VideoView a;

    public l0(VideoView r1) {
        this.a = r1;
    }

    public final void accept(Object r3) throws Exception {
        Long r4 = (Long) r3;
        int r5 = (int) this.a.q.getCurrentPosition();
        if (r5 < 0) goto L7;
        VideoView r0 = this.a;
        r0.h = r5;
        r0.e.setProgress(r5);
        VideoView r6 = this.a;
        int r1 = r6.h;
        r6.p();
        return;
    }
}
