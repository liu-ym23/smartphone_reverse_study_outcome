package a75;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter.h;
import com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter.w;
import io.reactivex.Flowable;
import on4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends m75.a<Object> {
    public w e;
    public final g85.f f;

    @Override // m75.a, m75.d
    public final void onDestroy() {
        super.onDestroy();
        w r0 = this.e;
        if (r0 == null) goto L6;
        final h r1 = r0.a;
        r1.getClass();
        Flowable.just("").subscribeOn(fo5.d.b()).map(new com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter.a()).doOnNext(new com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter.b(r1)).subscribe(new i(), new com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter.c());
        this.e.f.clear();
        return;
    }

    public f(FragmentActivity r1) {
        super(r1);
        this.f = o75.b.a().getMimeTypeManager();
    }
}
