package g45;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;

/* JADX INFO: loaded from: classes16.dex */
public interface a {
    LiveData<Boolean> getActive();

    KeyboardShowingStatusMode getKeyboardShowingStatusMode();

    int getPanelHeight(Context r100);

    String getPanelName();

    void onBecomeActive(d r100, a r101);

    void onBecomeInactive(d r100, a r101);

    void requestNotFocus(Context r100);
}
