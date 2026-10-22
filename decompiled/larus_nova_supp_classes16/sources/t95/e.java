package t95;

import android.webkit.JavascriptInterface;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.view.preview.markdown.MarkdownView;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final /* synthetic */ DriveFilePath a;
    public final /* synthetic */ MarkdownView b;

    @JavascriptInterface
    public void javaScriptFinishLoaded() {
        final MarkdownView r0 = this.b;
        DriveFilePath r1 = this.a;
        int r2 = MarkdownView.i;
        if (r0.isAttachedToWindow() == true) goto L5;
        tt5.a.d("MarkdownView", "showMarkdownText: isAttachedToWindow is false");
        return;
    L5:
        r0.b = Flowable.just(r1).map(new a(r0)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new b(r0), new c(r0));
    }

    public e(MarkdownView r1, DriveFilePath r2) {
        this.b = r1;
        this.a = r2;
    }
}
