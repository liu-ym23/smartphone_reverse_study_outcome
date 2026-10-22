package g45;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.browser.plugin.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface d extends i {
    LiveData<a> getActiveEditPanel();

    void registerEditPanel(LifecycleOwner r1, a r2);

    void requestUpdateWebContentHeight();

    void requestUpdateWebContentHeight(long r1);
}
