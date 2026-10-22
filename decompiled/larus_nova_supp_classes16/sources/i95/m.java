package i95;

import android.webkit.JavascriptInterface;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.view.preview.document.DocumentView;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m {
    public final /* synthetic */ DriveFilePath a;
    public final /* synthetic */ DocumentView b;

    @JavascriptInterface
    public void javaScriptFinishLoaded() {
        final DocumentView r0 = this.b;
        DriveFilePath r1 = this.a;
        int r2 = DocumentView.j;
        if (r0.isAttachedToWindow() == true) goto L5;
        tt5.a.d("DocumentView", "showHighLightText: isAttachedToWindow is false");
        return;
    L5:
        r0.b = Flowable.just(r1).map(new g(r0)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new h(r0), new i(r0));
    }

    public m(DocumentView r1, DriveFilePath r2) {
        this.b = r1;
        this.a = r2;
    }
}
