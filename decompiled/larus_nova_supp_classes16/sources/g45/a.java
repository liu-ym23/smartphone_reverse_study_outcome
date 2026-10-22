package g45;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a {
    LiveData<Boolean> getActive();

    KeyboardShowingStatusMode getKeyboardShowingStatusMode();

    int getPanelHeight(Context r1);

    String getPanelName();

    void onBecomeActive(d r1, a r2);

    void onBecomeInactive(d r1, a r2);

    void requestNotFocus(Context r1);
}
