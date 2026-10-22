package fo1;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: classes8.dex */
public interface i {
    FragmentManager getChildFragmentManager();

    boolean isAdded();

    void setArguments(Bundle r100);

    void show(FragmentManager r100, String r101);
}
