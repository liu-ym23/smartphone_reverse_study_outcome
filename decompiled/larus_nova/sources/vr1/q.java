package vr1;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface q {
    Boolean allowQuickRecordShare();

    Boolean allowQuickShotShare();

    HashMap<String, String> generateShareLogParams(DataCenter r100, String r101);

    void launchMatchShare(Context r100, boolean r101, MatchShareParam r102);

    void logQuickRecordAudioOpen(Map<String, String> r100);

    void logQuickRecordBtnClick(long r100);

    void logQuickRecordBtnShow(DataCenter r100);

    void logQuickRecordShareDialogClick();

    void logQuickRecordShareDialogShow(long r100, long r101);

    void logQuickRecordTaskFinish(Map<String, String> r100);

    void logQuickShotBtnClick(long r100);

    void logQuickShotBtnShow(DataCenter r100);

    void logQuickShotFinish(Map<String, String> r100);

    void logQuickShotShareDialogClick();

    void logQuickShotShareDialogShow(long r100);

    void showShareDialog(FragmentActivity r100, MatchShareParam r101, CollectionItem r102);
}
