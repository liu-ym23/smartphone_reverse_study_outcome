package i95;

import android.webkit.JavascriptInterface;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.view.preview.document.DocumentView;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes16.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveFilePath f488799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DocumentView f488800b;

    @JavascriptInterface
    public void javaScriptFinishLoaded() {
        final DocumentView r100 = this.f488800b;
        DriveFilePath r101 = this.f488799a;
        int r102 = DocumentView.f224809j;
        if (r100.isAttachedToWindow() == true) goto L5;
        tt5.a.d("DocumentView", "showHighLightText: isAttachedToWindow is false");
        return;
    L5:
        r100.f224801b = Flowable.just(r101).map(new g(r100)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new h(r100), new i(r100));
    }

    public m(DocumentView r100, DriveFilePath r101) {
        this.f488800b = r100;
        this.f488799a = r101;
    }
}
