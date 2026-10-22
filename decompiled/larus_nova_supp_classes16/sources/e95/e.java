package e95;

import android.util.Log;
import com.bytedance.ee.bear.drive.view.preview.archive.ArchivePreviewView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.LoadingAnimView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ b.InterfaceC0219b a;

    public e(ArchivePreviewView.b r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        tt5.a.e("ArchiveTreeDataLoader", "extractFile() local file parse failed", r6, false);
        b.InterfaceC0219b r0 = this.a;
        Intrinsics.checkNotNull(r6);
        ArchivePreviewView.b r1 = (ArchivePreviewView.b) r0;
        LoadingAnimView r2 = ArchivePreviewView.access$100(r1.c).d;
        r2.a.clear();
        r2.c.cancelAnimation();
        r2.setVisibility(8);
        Toast.showFailureText(r1.c.getView().getContext(), 2131888398);
        r1.a(Log.getStackTraceString(r6), false);
    }
}
