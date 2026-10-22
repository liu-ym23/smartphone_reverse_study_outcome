package rf5;

import com.bytedance.ee.bear.middleground.drive.export.ProgressingEntity;

/* JADX INFO: loaded from: classes18.dex */
public interface e {
    void onExistUploadingFile();

    void onFileCountChange(int r100, int r101);

    void onFileProgressChange(int r100, ProgressingEntity r101);

    void onUploadError(int r100);

    void onUploadErrorCode(String r100, int r101, long r102);

    void onUploadFileSuccess(String r100, d r101);

    void onUploadFinished();
}
