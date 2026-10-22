package d75;

import com.bytedance.ee.bear.drive.biz.versions.model.DriveVersionHistoryRecord;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface c extends m75.e {
    void iG(Throwable r1);

    void q70(boolean r1, List<DriveVersionHistoryRecord.RecordBean> r2, Map<String, DriveVersionHistoryRecord.UserBean> r3);

    void showLoading();

    void sp(boolean r1, List<DriveVersionHistoryRecord.RecordBean> r2, Map<String, DriveVersionHistoryRecord.UserBean> r3);
}
