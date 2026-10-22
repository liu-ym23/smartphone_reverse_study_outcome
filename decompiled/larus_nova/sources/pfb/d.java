package pfb;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.filedetail.impl.folder.manage.entity.FileType;
import com.ss.android.lark.filedetail.impl.folder.manage.service.ExtractConfig;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f529030a = 0;

    public static final class a {
        @JvmStatic
        public static Map a(FileType r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            if (r101 == null) goto L5;
            String r103 = FileUtils.m(r101);
        L6:
            if (r103 != null) goto L8;
        L10:
            String r104 = "unknown";
        L11:
            HashMap r105 = new HashMap();
            if (r100 != FileType.FOLDER) goto L14;
            r104 = DocumentType.FOLDER_NAME;
        L20:
            r105.put("file_type", r104);
            return r105;
        L14:
            if (r101 == null) goto L20;
            if (r102 == (-1)) goto L20;
            if (ExtractConfig.a(r102, r101) == false) goto L20;
            r104 = "compress_file";
            goto L20
        L8:
            if (r103.length() <= 1) goto L10;
            r104 = r103.substring(1);
            goto L11
        L5:
            r103 = null;
            goto L6
        }

        public static void b(String r100, String r101, Map r102) {
            Map<String, Object> r103 = ChatParamUtils.f(r100);
            if (r103 != null) goto L5;
            r103 = MapsKt.mapOf(TuplesKt.to("chat_id", r100));
        L5:
            JSONObject r104 = new JSONObject(r103);
            if (r102 == null) goto L11;
            Iterator r105 = r102.entrySet().iterator();
        L9:
            if (r105.hasNext() == false) goto L11;
            Map.Entry r106 = (Map.Entry) r105.next();
            r104.put((String) r106.getKey(), r106.getValue());
        L11:
            Statistics.sendEvent(r101, r104);
        }

        public static void c(String r100, String r101, Map r102) {
            Intrinsics.checkNotNullParameter(r101, "click");
            Intrinsics.checkNotNullParameter("none", PickerReporterConstants.KEY.TARGET);
            if (r100 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L11;
            return;
        L11:
            Map r104 = MapsKt.mapOf(new Pair[]{TuplesKt.to("click", r101), TuplesKt.to(PickerReporterConstants.KEY.TARGET, "none"), TuplesKt.to("page_type", "folder_view")});
            if (r102 != null) goto L14;
            r102 = MapsKt.emptyMap();
        L14:
            b(r100, "im_chat_file_list_click", MapsKt.plus(r104, r102));
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r103 = false;
            goto L9
        }

        public static void d(String r100, int r101, int r102) {
            if (r100 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L11;
            return;
        L11:
            Pair[] r104 = new Pair[3];
            r104[0] = TuplesKt.to("page_type", "folder_view");
            if (r101 != 1) goto L14;
            String r105 = "square";
        L15:
            r104[1] = TuplesKt.to(BytedCertConstant.IntentKey.VIEW_TYPE, r105);
            if (r102 == 0) goto L27;
            if (r102 == 1) goto L27;
            if (r102 == 2) goto L27;
            if (r102 == 3) goto L27;
            if (r102 != 8) goto L23;
            String r106 = "from_search_folder";
        L28:
            r104[2] = TuplesKt.to("source", r106);
            b(r100, "im_chat_file_list_view", MapsKt.mapOf(r104));
            return;
        L23:
            if (r102 == 10) goto L25;
            r106 = "other";
            goto L28
        L25:
            r106 = "from_file_tab";
        L27:
            r106 = "from_msg_folder";
            goto L28
        L14:
            r105 = "list";
            goto L15
        L5:
            if (r100.length() == 0) goto L8;
            r103 = false;
            goto L9
        }

        public static void e(String r100, String r101, String r102, Map r103) {
            Intrinsics.checkNotNullParameter(r101, "click");
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            if (r100 != null) goto L5;
        L8:
            boolean r104 = true;
        L9:
            if (r104 == false) goto L11;
            return;
        L11:
            if (r103 != null) goto L13;
            r103 = new HashMap();
        L13:
            Map r105 = MapsKt.toMutableMap(r103);
            r105.put("click", r101);
            r105.put(PickerReporterConstants.KEY.TARGET, r102);
            b(r100, "im_chat_file_manage_click", r105);
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r104 = false;
            goto L9
        }

        public static void f(String r100, String r101, String r102, Map r103) {
            Intrinsics.checkNotNullParameter(r101, "click");
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            if (r100 != null) goto L5;
        L8:
            boolean r104 = true;
        L9:
            if (r104 == false) goto L11;
            return;
        L11:
            Map r105 = MapsKt.toMutableMap(r103);
            r105.put("click", r101);
            r105.put(PickerReporterConstants.KEY.TARGET, r102);
            b(r100, "im_chat_file_manage_more_click", r105);
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r104 = false;
            goto L9
        }
    }

    static {
    }
}
