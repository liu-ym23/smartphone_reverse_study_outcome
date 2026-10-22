package od8;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements sr9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f522863a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f522864b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, HashMap<String, String>> f522865c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Pair<Integer, Integer>> f522866d = null;

    public d() {
    }

    static {
        f522863a = new d();
        f522864b = LazyKt.lazy(new c());
        f522865c = new HashMap();
        f522866d = new ConcurrentHashMap();
    }

    public static void i(Map r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L10
        if (r100 == null) goto L8;
        ArrayList r103 = new ArrayList(r100.size());     // Catch: Throwable -> L10
        Iterator r104 = r100.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r104.hasNext() == false) goto L8;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L10
        r103.add(r102.put((String) r105.getKey(), r105.getValue()));     // Catch: Throwable -> L10
    L8:
        Object r106 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L10
    L12:
        String r107 = null;
        if (Result.m9455isFailureimpl(r106) == false) goto L15;
        r106 = null;
    L15:
        JSONObject r108 = (JSONObject) r106;
        if (r108 == null) goto L18;
        r107 = r108.toString();
    L18:
        ((Keva) f522864b.getValue()).storeString("SAVE_KEY_INSTRUCT_EXT_", r107);
        return;
    L10:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static String p(String r100) {
        if (r100 != null) goto L4;
    L45:
        return null;
    L4:
        switch(r100.hashCode()) {
            case -1775152378: goto L42;
            case -1519652696: goto L39;
            case -1104494850: goto L36;
            case -751697127: goto L33;
            case -701204130: goto L30;
            case -106106972: goto L27;
            case 120426756: goto L23;
            case 451709046: goto L20;
            case 1086767678: goto L16;
            case 1504163779: goto L13;
            case 1840109215: goto L10;
            case 1970358852: goto L7;
            default: goto L45;
        };
    L7:
        if (r100.equals("send_photo_preview") == false) goto L45;
    L44:
        return "SAVE_KEY_TAB_COMMON";
    L10:
        if (r100.equals("common_bottom_menu") == true) goto L44;
    L13:
        if (r100.equals("prompt_direct_send") == true) goto L44;
    L16:
        if (r100.equals("edu_photo_search") == false) goto L45;
        return "SAVE_KEY_TAB_EDU_PHOTO_SEARCH";
    L20:
        if (r100.equals("common_input") == true) goto L44;
    L23:
        if (r100.equals("edu_homework_correct") == false) goto L45;
        return "SAVE_KEY_TAB_EDU_HOMEWORK_CORRECT";
    L27:
        if (r100.equals("welcome_back") == true) goto L44;
    L30:
        if (r100.equals("common_action_bar") == true) goto L44;
    L33:
        if (r100.equals("attach_menu") == false) goto L45;
    L36:
        if (r100.equals("inject_input_photo_picker") == true) goto L44;
    L39:
        if (r100.equals("message_sug_action") == true) goto L44;
    L42:
        if (r100.equals("outer_input") == true) goto L44;
        goto L44
    }

    @Override // sr9.d
    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        HashMap<String, String> r101 = f522865c.get(r100);
        if (r101 == null) goto L6;
        String r102 = r101.get("is_photo_marked");
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "0";
    }

    @Override // sr9.d
    public final Pair<Integer, Integer> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return f522866d.get(r100);
    }

    @Override // sr9.d
    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        HashMap<String, String> r101 = f522865c.get(r100);
        if (r101 == null) goto L6;
        String r102 = r101.get("previous_page");
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "-1";
    }

    @Override // sr9.d
    public final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        HashMap<String, String> r101 = f522865c.get(r100);
        if (r101 == null) goto L6;
        String r102 = r101.get(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "-1";
    }

    @Override // sr9.d
    public final boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        HashMap<String, String> r101 = f522865c.get(r100);
        if (r101 == null) goto L5;
        String r102 = r101.get("is_from_photo_edit");
    L7:
        return Intrinsics.areEqual(r102, "1");
    L5:
        r102 = null;
        goto L7
    }

    @Override // sr9.d
    public final String h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        HashMap<String, String> r101 = f522865c.get(r100);
        if (r101 == null) goto L6;
        String r102 = r101.get("if_edu_intention");
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "-1";
    }

    public static void j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        String r102 = p(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        ((Keva) f522864b.getValue()).storeString(r102, r101);
        FLogger.f375446a.i("ChatCameraCache", "saveTab, scene:" + r100 + ",saveKey:" + r102 + ",mode:" + r101);
    }

    public static void l(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "localUri");
        Intrinsics.checkNotNullParameter(r101, "detectIntent");
        k(r100, "if_edu_intention", r101);
    }

    public static void m(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "localUri");
        if (r101 == false) goto L5;
        String r102 = "1";
    L6:
        k(r100, "is_from_photo_edit", r102);
        return;
    L5:
        r102 = "0";
        goto L6
    }

    public static void n(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "localUri");
        if (r101 == false) goto L5;
        String r102 = "1";
    L6:
        k(r100, "is_photo_marked", r102);
        return;
    L5:
        r102 = "0";
        goto L6
    }

    @Override // sr9.d
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "localUri");
        Intrinsics.checkNotNullParameter(r101, "contentSource");
        k(r100, com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, r101);
    }

    @Override // sr9.d
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "localUri");
        Intrinsics.checkNotNullParameter(r101, "previousPage");
        k(r100, "previous_page", r101);
    }

    public static void k(String r100, String r101, String r102) {
        HashMap<String, HashMap<String, String>> r103 = f522865c;
        if (r103.get(r100) != null) goto L5;
        HashMap<String, String> r104 = new HashMap();
        r104.put(r101, r102);
        r103.put(r100, r104);
        return;
    L5:
        HashMap<String, String> r105 = r103.get(r100);
        if (r105 == null) goto L10;
        String r106 = r105.put(r101, r102);
        return;
    }

    public static void o(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "localUri");
        FLogger.f375446a.i("lsy", "saveUriToVideoSize, localUri:" + r100 + ", width:" + r101 + ", height:" + r102);
        f522866d.put(r100, new Pair(Integer.valueOf(r101), Integer.valueOf(r102)));
    }
}
