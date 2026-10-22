package fn9;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.larus.office.base.plugins.toolbar.editpanel.EditPanelsManager;

/* JADX INFO: loaded from: classes29.dex */
public interface a {
    LiveData<Boolean> getActive();

    int getPanelHeight(Context r100);

    String getPanelName();

    void onBecomeActive(EditPanelsManager r100, a r101);

    void onBecomeInactive(EditPanelsManager r100, a r101);
}
