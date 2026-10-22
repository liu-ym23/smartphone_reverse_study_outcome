package oo9;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.aiedit.SheetSelection;
import com.larus.office.plugins.aiedit.SheetSelectionChangeData;
import com.larus.office.plugins.aiedit.SheetUserSelection;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f524659a = 0;

    static {
    }

    public static void a(Map r100, OfficeInputParam r101, String r102, String r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "ext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "artifactMetaId");
        boolean r103 = true;
        if (r101.getSlidesToken().length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return;
    L8:
        JSONObject r105 = new JSONObject();
        r105.put("action", 0);
        JSONObject r106 = new JSONObject();
        r106.put("artifact_meta_id", r102);
        r106.put("artifact_version_id", r110);
        if (r111 != null) goto L11;
    L14:
        if (r103 == true) goto L65;
        SheetSelectionChangeData r107 = (SheetSelectionChangeData) GsonProtectorUtils.fromJson(new Gson(), r111, SheetSelectionChangeData.class);
        if (r112 == false) goto L24;
        SheetUserSelection r108 = r107.getSelected();
        if (r108 == null) goto L20;
        String r109 = r108.getPlainText();
    L21:
        if (r109 != null) goto L23;
        r109 = "";
    L23:
        r100.put(ReferenceMessage.KEY_REFERENCE_TEXT, r109);
        goto L24
    L20:
        r109 = null;
    L24:
        r106.put("spreadsheet_token", r107.getSpreadsheetToken());
        r106.put("spreadsheet_version", r107.getSpreadsheetVersion());
        SheetUserSelection r113 = r107.getSelected();
        if (r113 == null) goto L65;
        JSONObject r114 = new JSONObject();
        r114.put("active_sheet_id", r113.getActiveSheetId());
        r114.put("active_sheet_name", r113.getActiveSheetName());
        JSONArray r115 = new JSONArray();
        List<SheetSelection> r116 = r113.getSheets();
        if (r116 == null) goto L62;
        Iterator<T> r117 = r116.iterator();
    L30:
        if (r117.hasNext() == false) goto L62;
        SheetSelection r118 = (SheetSelection) r117.next();
        JSONObject r119 = new JSONObject();
        if (r118 == null) goto L34;
        String r120 = r118.getSheetId();
    L35:
        if (r120 != null) goto L37;
        r120 = "";
    L37:
        r119.put("sheet_id", r120);
        if (r118 == null) goto L40;
        String r121 = r118.getSheetName();
    L41:
        if (r121 != null) goto L43;
        r121 = "";
    L43:
        r119.put("sheet_name", r121);
        if (r118 == null) goto L46;
        List<String> r122 = r118.getRanges();
    L47:
        if (r122 != null) goto L49;
        r122 = CollectionsKt.emptyList();
    L49:
        r119.put("ranges", new JSONArray(r122));
        if (r118 == null) goto L52;
        List<String> r123 = r118.getCharts();
    L53:
        if (r123 != null) goto L55;
        r123 = CollectionsKt.emptyList();
    L55:
        r119.put("charts", new JSONArray(r123));
        if (r118 == null) goto L58;
        List<String> r124 = r118.getFloatImages();
    L59:
        if (r124 != null) goto L61;
        r124 = CollectionsKt.emptyList();
    L61:
        r119.put("float_images", new JSONArray(r124));
        r115.put(r119);
        goto L30
    L58:
        r124 = null;
        goto L59
    L52:
        r123 = null;
        goto L53
    L46:
        r122 = null;
        goto L47
    L40:
        r121 = null;
        goto L41
    L34:
        r120 = null;
    L62:
        Unit r125 = Unit.INSTANCE;
        r114.put("sheets", r115);
        r106.put("selected_sheets", r114);
        if (r112 == false) goto L65;
        r106.put("ref_sheets", r114);
    L65:
        r105.put(PerfLog.PARAM_KEY_CONTEXT_ID, r106);
        r100.put("office_sheet_ref_block_info", r105.toString());
        return;
    L11:
        if (r111.length() == 0) goto L14;
        r103 = false;
        goto L14
    L5:
        r104 = false;
        goto L6
    }
}
