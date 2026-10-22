package tv3;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.platform.service.o;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f547673a = 0;

    static {
    }

    public static JSONObject a(d r110, boolean r111) {
        JSONObject r100 = new JSONObject();
        r100.put("start_point", r110.f547681b);
        r100.put("end_point", r110.f547682c);
        r100.put(WsConstants.KEY_TRANSPORT_MODE, r110.f547683d);
        r100.put("outlink_id", r110.f547680a);
        r100.put("outlink_mode", r110.f547684e);
        r100.put("is_direct_fallback", r111 ? 1 : 0);
        r100.put("installed_app_list", CollectionsKt.joinToString$default(r110.f547688i, ",", null, null, 0, null, null, 62, null));
        r100.put("allowed_app_list", CollectionsKt.joinToString$default(r110.f547689j, ",", null, null, 0, null, null, 62, null));
        r100.put("dialog_app_list", CollectionsKt.joinToString$default(r110.f547687h, ",", null, null, 0, null, null, 62, null));
        r100.put("backup", r110.f547686g);
        r100.put("from_detail", r110.f547685f);
        return r100;
    }

    public static void b(String r100, JSONObject r101) {
        int r102 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.a("nav_chooser_track", r100 + " params=" + r101);
        o.f365780a.reportEvent(r100, r101);
    }

    public static void c(d r100, boolean r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r102, "outcome");
        boolean r103 = r102 instanceof c.C7781c;
        if (r103 == false) goto L6;
        StringBuilder r104 = new StringBuilder("Pick(toDetail=");
        c.C7781c r105 = (c.C7781c) r102;
        r104.append(r105.f547677a);
        r104.append(", appRank=");
        r104.append(r105.f547678b);
        r104.append(", isAppStore=");
        r104.append(r105.f547679c);
        r104.append(')');
        String r106 = r104.toString();
    L11:
        int r107 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("nav_chooser_track", "trackPopupClick: enter outlinkId=" + r100.f547680a + " outlinkMode=" + r100.f547684e + " isDirectFallback=" + r101 + " outcome=" + r106);
        JSONObject r108 = a(r100, r101);
        if (r103 == false) goto L15;
        r108.put("is_close", 0);
        c.C7781c r109 = (c.C7781c) r102;
        r108.put("is_app_store", r109.f547679c ? 1 : 0);
        r108.put("app_rank", r109.f547678b);
        r108.put("to_detail", r109.f547677a);
    L20:
        b("doubao_apps_map_nav_outlink_popup_click", r108);
        return;
    L15:
        if (Intrinsics.areEqual(r102, c.a.f547675a) == false) goto L18;
        r108.put("is_close", 1);
        r108.put("is_app_store", 0);
        r108.put("to_detail", "cancel");
        goto L20
    L18:
        if ((r102 instanceof c.b) == false) goto L23;
        r108.put("is_close", 0);
        r108.put("is_app_store", 0);
        r108.put("app_rank", 1);
        r108.put("to_detail", ((c.b) r102).f547676a);
        goto L20
    L23:
        throw new NoWhenBranchMatchedException();
    L6:
        if (Intrinsics.areEqual(r102, c.a.f547675a) == false) goto L9;
        r106 = "Cancel";
        goto L11
    L9:
        if ((r102 instanceof c.b) == false) goto L25;
        r106 = "Direct(toDetail=" + ((c.b) r102).f547676a + ')';
        goto L11
    L25:
        throw new NoWhenBranchMatchedException();
    }
}
