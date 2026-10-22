package t95;

import android.webkit.JavascriptInterface;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.view.preview.markdown.MarkdownView;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveFilePath f545096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MarkdownView f545097b;

    @JavascriptInterface
    public void javaScriptFinishLoaded() {
        final MarkdownView r100 = this.f545097b;
        DriveFilePath r101 = this.f545096a;
        int r102 = MarkdownView.f225067i;
        if (r100.isAttachedToWindow() == true) goto L5;
        tt5.a.d("MarkdownView", "showMarkdownText: isAttachedToWindow is false");
        return;
    L5:
        r100.f224801b = Flowable.just(r101).map(new a(r100)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new b(r100), new c(r100));
    }

    public e(MarkdownView r100, DriveFilePath r101) {
        this.f545097b = r100;
        this.f545096a = r101;
    }
}
