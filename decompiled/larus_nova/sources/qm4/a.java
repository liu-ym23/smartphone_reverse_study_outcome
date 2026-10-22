package qm4;

import com.bytedance.apm.constant.UploadTypeInf;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f533872a = 0;

    /* JADX INFO: renamed from: qm4.a$a, reason: collision with other inner class name */
    public static final class C7357a {
        public static void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileSize");
            Statistics.sendEvent("im_send_file_rejected", new JSONObject().put("file_size", r100));
        }

        public static void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "fileType");
            Intrinsics.checkNotNullParameter(r101, "type");
            Intrinsics.checkNotNullParameter(UploadTypeInf.DISK, "diskType");
            JSONObject r102 = new JSONObject();
            r102.put("file_type", r100);
            r102.put("type", r101);
            r102.put("disk_type", UploadTypeInf.DISK);
            Statistics.sendEvent("click_driver_list_file", r102);
        }
    }

    static {
    }
}
