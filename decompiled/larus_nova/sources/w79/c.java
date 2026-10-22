package w79;

import com.larus.drive.sdk.api.file.DriveFileItem;
import java.util.List;

/* JADX INFO: loaded from: classes27.dex */
public interface c {
    void a(DriveFileItem r100);

    void b(DriveFileItem r100);

    boolean c(DriveFileItem r100);

    void d(List<DriveFileItem> r100);

    a e(DriveFileItem r100);

    void onCanceled();

    void onChanged(List<DriveFileItem> r100);

    void onSelectMoreClick();
}
