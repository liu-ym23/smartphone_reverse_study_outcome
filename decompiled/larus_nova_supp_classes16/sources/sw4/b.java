package sw4;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.imageviewer.edit.EditImageFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface b {
    void a(FragmentManager r1);

    String e(FragmentActivity r1, String r2, String r3, int r4, ImageData.Image r5);

    EditImageFragment h(Context r1, FragmentManager r2, s r3, ViewGroup r4);
}
