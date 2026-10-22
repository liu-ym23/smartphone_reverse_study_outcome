package sm5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertFragment;
import io.reactivex.functions.Consumer;
import java.io.File;
import rm5.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ ScreenshotImageAlertFragment a;

    public f(ScreenshotImageAlertFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        FragmentActivity r0 = this.a.getActivity();
        o.b(r0, (File) r4, new e(this.a));
    }
}
