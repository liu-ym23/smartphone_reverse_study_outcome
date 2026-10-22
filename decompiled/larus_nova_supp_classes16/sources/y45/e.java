package y45;

import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming.StreamingCache;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static void a(final com.bytedance.ee.bear.drive.config.strategy.d r10, final w75.c r11, final StreamingCache r12, final a95.a r13) {
        if (r10 == null) goto L8;
        if (r11 == null) goto L8;
        if (r12 == null) goto L8;
        final com.bytedance.ee.bear.drive.cache.t r6 = com.bytedance.ee.bear.drive.cache.t.l();
        final w75.a r4 = r11.getDetails();
        final String r3 = r10.i(r4);
        Flowable.just(r12.getFilePath()).observeOn(fo5.d.b()).filter(new a(r13)).flatMap(new b(r12, r11, r3, r4, r10, r6, r13)).subscribeOn(fo5.d.b()).observeOn(fo5.d.b()).subscribe(new c(), new d());
        return;
    L8:
        StringBuilder r14 = new StringBuilder("saveStreamingFileCache param error, previewFileStrategy=");
        r14.append(r10);
        r14.append(", fileModel is null=");
        if (r11 != null) goto L11;
        boolean r16 = true;
    L12:
        r14.append(r16);
        tt5.a.d("DriveComponent", r14.toString());
        return;
    L11:
        r16 = false;
        goto L12
    }
}
