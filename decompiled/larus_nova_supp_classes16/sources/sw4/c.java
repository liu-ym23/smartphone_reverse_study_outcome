package sw4;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.imageviewer.ImageViewerDialogFragment;
import com.bytedance.ee.bear.imageviewer.ImageViewerFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface c {
    ImageViewerDialogFragment b(Context r1, FragmentManager r2, ImageData r3, String r4, String r5, int r6, String r7);

    void c(FragmentManager r1, String r2);

    ImageViewerFragment d(Context r1, FragmentManager r2, s r3, ViewGroup r4, ImageData r5, String r6, String r7, int r8, String r9);

    void f(FragmentManager r1, String r2);

    s g();
}
