package d75;

import com.bytedance.ee.bear.drive.biz.versions.model.DriveVersionHistoryRecord;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public interface c extends m75.e {
    void iG(Throwable r100);

    void q70(boolean r100, List<DriveVersionHistoryRecord.RecordBean> r101, Map<String, DriveVersionHistoryRecord.UserBean> r102);

    void showLoading();

    void sp(boolean r100, List<DriveVersionHistoryRecord.RecordBean> r101, Map<String, DriveVersionHistoryRecord.UserBean> r102);
}
