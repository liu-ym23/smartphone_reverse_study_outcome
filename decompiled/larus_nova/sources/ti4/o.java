package ti4;

import androidx.lifecycle.LiveData;
import com.ss.android.ugc.tools.view.widget.state.CommonUiState;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface o<DATA> {
    LiveData<List<DATA>> getListData();

    LiveData<CommonUiState> getPageState();

    void requestData(boolean r100);
}
