package e89;

import android.app.Dialog;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.file.download.DriveDownloadPriority;
import com.larus.drive.sdk.impl.DriveSdkServiceImpl;
import com.larus.drive.sdk.impl.utils.t;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes27.dex */
public interface c {
    String a(DriveFileItem r100, Context r101, DriveDownloadPriority r102, t79.a r103);

    Object b(String r100, int r101, boolean r102, Continuation<? super DriveFileItem> r103);

    boolean c(String r100);

    MutableLiveData d(String r100);

    nc5.b e(List r100, DriveSdkServiceImpl.k r101);

    void f(DriveFileItem r100, Context r101);

    boolean g(List<String> r100);

    nc5.b h(String r100, int r101, boolean r102, v79.b<Boolean> r103);

    Object i(String r100, int r101, String r102, Continuation<? super Integer> r103);

    nc5.b j(DriveFileItem r100, String r101, t.a r102);

    void k(DriveFileItem r100, kw9.d r101);

    void l(u79.a r100);

    nc5.b m(List<DriveFileItem> r100, v79.a r101);

    Object n(String r100, int r101, Continuation<? super Boolean> r102);

    void o(String r100, int r101, Dialog r102);

    nc5.b p(String r100, int r101, v79.b<Boolean> r102);

    void q(String r100, int r101);
}
