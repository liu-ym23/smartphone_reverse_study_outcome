package tx9;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f547881a = null;

    static {
        f547881a = new ConcurrentHashMap();
    }

    public static final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        f547881a.put(r100, Long.valueOf(System.currentTimeMillis()));
    }

    public static final void c(String r100, String r101, boolean r110, Long r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        Long r103 = f547881a.remove(r101);     // Catch: Throwable -> L17
        if (r103 == null) goto L15;
        long r104 = r103.longValue();     // Catch: Throwable -> L17
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L17
        if (r105 <= r104) goto L15;
        com.larus.platform.service.g r106 = com.larus.platform.service.g.f365738a;     // Catch: Throwable -> L17
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L17
        if (r110 == false) goto L10;
        int r113 = 1;
    L11:
        r107.put("is_success", r113);     // Catch: Throwable -> L17
        if (r112 == null) goto L14;
        r107.put("error_code", r112.intValue());     // Catch: Throwable -> L17
    L14:
        r107.put("scene", r100);     // Catch: Throwable -> L17
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L17
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L17
        r109.put("file_size", r111);     // Catch: Throwable -> L17
        r109.put("duration", r105 - r104);     // Catch: Throwable -> L17
        r106.monitorEventForSlardar("avatar_video_upload_result", r107, r109, new JSONObject());     // Catch: Throwable -> L17
        goto L15
    L10:
        r113 = 0;
    L15:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static final void a(String r100, String r101, boolean r102, Integer r110, Long r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
        Long r104 = f547881a.remove(r101);     // Catch: Throwable -> L17
        if (r104 == null) goto L15;
        long r105 = r104.longValue();     // Catch: Throwable -> L17
        long r106 = System.currentTimeMillis();     // Catch: Throwable -> L17
        if (r106 <= r105) goto L15;
        com.larus.platform.service.o r107 = com.larus.platform.service.o.f365780a;     // Catch: Throwable -> L17
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L17
        r108.put("scene", r100);     // Catch: Throwable -> L17
        if (r102 == false) goto L10;
        int r109 = 1;
    L11:
        r108.put("is_success", r109);     // Catch: Throwable -> L17
        if (r110 == null) goto L14;
        r108.put("error_code", r110.intValue());     // Catch: Throwable -> L17
    L14:
        r108.put("duration", r106 - r105);     // Catch: Throwable -> L17
        r108.putOpt("file_size", r111);     // Catch: Throwable -> L17
        r108.putOpt("file_type", r112);     // Catch: Throwable -> L17
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r107.reportEvent("creation_image_upload_result", r108);     // Catch: Throwable -> L17
        goto L15
    L10:
        r109 = 0;
    L15:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static /* synthetic */ void b(String r100, String r101, boolean r110, Integer r111, Long r112, String r113, int r114) {
        if ((r114 & 8) == 0) goto L5;
        Integer r102 = null;
    L7:
        if ((r114 & 16) == 0) goto L9;
        Long r103 = null;
    L11:
        if ((r114 & 32) == 0) goto L13;
        String r104 = null;
    L14:
        a(r100, r101, r110, r102, r103, r104);
        return;
    L13:
        r104 = r113;
        goto L14
    L9:
        r103 = r112;
        goto L11
    L5:
        r102 = r111;
        goto L7
    }
}
