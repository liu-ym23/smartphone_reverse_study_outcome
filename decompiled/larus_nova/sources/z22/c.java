package z22;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f569779a = 0;

    static {
    }

    public static boolean a(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L9;
        if (r101.isDirectory() == false) goto L9;
        return true;
    L9:
        if (r101.exists() == false) goto L15;
        if (r101.delete() == true) goto L15;
        Logger.e("VideoRecordUtils", "Can not delete file: " + r101.getAbsolutePath());
        return false;
    L15:
        return r101.mkdirs();
    }

    public static void b(String r100) {
        ALogger.i("VideoRecordUtils", "safeDeleteFile " + r100);
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L15;
        ALogger.i("VideoRecordUtils", "safeDeleteFile file not exist");
        return;
    L15:
        ALogger.i("VideoRecordUtils", "safeDeleteFile result = " + r102.delete());
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @JvmStatic
    public static final Observable<ILiveRecordService.RecordMetaData> c(String r110, String r111, long r112, long r113, long r114, String r115) {
        Intrinsics.checkNotNullParameter(r110, "originFilePath");
        Intrinsics.checkNotNullParameter(r115, "source");
        IMiddlewareRoomService r100 = (IMiddlewareRoomService) k.f(IMiddlewareRoomService.class);
        if (r100 == null) goto L7;
        ILiveRecordService r101 = r100.getMiddlewareRecordService();
        if (r101 == null) goto L7;
        return r101.startReqAndWriteMetadata(r110, r111, r112, r113, r114, r115);
    L7:
        return null;
    }
}
