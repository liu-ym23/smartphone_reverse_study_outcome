package rf5;

import com.bytedance.ee.bear.middleground.drive.export.ProgressingEntity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface e {
    void onExistUploadingFile();

    void onFileCountChange(int r1, int r2);

    void onFileProgressChange(int r1, ProgressingEntity r2);

    void onUploadError(int r1);

    void onUploadErrorCode(String r1, int r2, long r3);

    void onUploadFileSuccess(String r1, d r2);

    void onUploadFinished();
}
