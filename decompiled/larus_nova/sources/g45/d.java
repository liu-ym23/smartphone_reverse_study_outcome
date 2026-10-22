package g45;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.browser.plugin.i;

/* JADX INFO: loaded from: classes16.dex */
public interface d extends i {
    LiveData<a> getActiveEditPanel();

    void registerEditPanel(LifecycleOwner r100, a r101);

    void requestUpdateWebContentHeight();

    void requestUpdateWebContentHeight(long r100);
}
