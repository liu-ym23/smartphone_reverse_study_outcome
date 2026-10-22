package sbb;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.docs.url.MiaodaUrlRoute;
import com.ss.android.lark.log.Log;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f541290a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f541291a = null;

        static {
            int[] r100 = new int[MiaodaUrlRoute.values().length];
            r100[MiaodaUrlRoute.PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MiaodaUrlRoute.App.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f541291a = r100;
        }
    }

    static {
        f541290a = new c();
    }

    public c() {
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (d(r100, false) == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static obb.b e(String r110) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Log.i("DOCS_ICON_DocMetaUtil", "parseUrlToDocsMetaInfo");
        sbb.a r100 = new sbb.a(new b(SettingManager.getInstance().getSettingConfig("domain_config", true)));
        String r101 = UriProtector.parse(r110).getPath();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (b(r110) == false) goto L25;
        ubb.a r111 = d(r110, true);
        if (r111 != null) goto L11;
        return null;
    L11:
        if (r111.f549412b == MiaodaUrlRoute.App) goto L13;
    L15:
        int r102 = a.f541291a[r111.f549412b.ordinal()];
        if (r102 != 1) goto L18;
        int r103 = 113;
    L24:
        return new obb.b(r103, r111.f549411a, null, null, null, null, null, null, 384);
    L18:
        if (r102 != 2) goto L21;
        r103 = 114;
        goto L24
    L21:
        throw new NoWhenBranchMatchedException();
    L13:
        if ((!idb.f.a().isEnable("ccm.workspace.miaoda_app_url_infer_disable")) == false) goto L15;
        return new obb.b(e.f541294e.f541317b, null, null, null, null, null, null, null, 384);
    L25:
        String r112 = r100.b(r101);
        return new obb.b(e.g(r112), r100.a(r101), null, null, null, null, null, null, 384);
    }

    public static obb.b a(String r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "token");
        return new obb.b(r111, r110, null, null, null, null, null, null, 384);
    }

    public static obb.b c(obb.b r110, String r210) {
        if (r210 != null) goto L32;
    L31:
        return null;
    L32:
    L29:
        e = move-exception;
        Log.e("DOCS_ICON_DocMetaUtil", "parseDocMetaInfo fail " + e.getMessage());
        goto L31
    L5:
        if (TextUtils.isEmpty(r210) == true) goto L31;
        JSONObject r100 = new JSONObject(r210);     // Catch: Exception -> L29
        if (r110 == null) goto L10;
        String r101 = r110.f522638b;     // Catch: Exception -> L29
        if (r101 == null) goto L10;
    L11:
        String r111 = r100.optString("token", r101);     // Catch: Exception -> L29
        if (r100.has("obj_type") == false) goto L15;
        int r102 = r100.optInt("obj_type");     // Catch: Exception -> L29
    L14:
        int r112 = r102;
        String r113 = r100.optString("file_type");     // Catch: Exception -> L29
        int r103 = r100.optInt("type");     // Catch: Exception -> L29
        String r114 = r100.optString("key");     // Catch: Exception -> L29
        int r104 = r100.optInt("version");     // Catch: Exception -> L29
        if (r100.has("obj_sub_type") == true) goto L21;
    L23:
        if (r110 == null) goto L26;
        Long r105 = r110.f522645i;     // Catch: Exception -> L29
    L25:
        Long r115 = r105;
    L27:
        Integer r106 = Integer.valueOf(r103);     // Catch: Exception -> L29
        obb.b r107 = new obb.b(r112, r111, r113, r106, r114, Integer.valueOf(r104), null, r115, 128);     // Catch: Exception -> L29
        Log.i("DOCS_ICON_DocMetaUtil", "parseDocMetaInfo success " + r107.getType() + ' ' + r106);     // Catch: Exception -> L29
        return r107;
    L26:
        r115 = null;
        goto L27
    L21:
        if (r100.isNull("obj_sub_type") == true) goto L23;
        r105 = Long.valueOf(r100.optLong("obj_sub_type"));     // Catch: Exception -> L29
        goto L25
    L15:
        if (r110 == null) goto L17;
        r102 = r110.getType();     // Catch: Exception -> L29
        goto L14
    L17:
        r102 = e.f541294e.f541317b;     // Catch: Exception -> L29
    L10:
        r101 = "";
        goto L11
    }

    public static ubb.a d(String r110, boolean r111) {
        ubb.b r100 = ubb.b.f549413a;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl((String[]) jcb.b.c().b("suite_main_domain").toArray(new String[0]));     // Catch: Throwable -> L5
    L7:
        String[] r103 = new String[0];
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = r103;
    L10:
        String[] r104 = (String[]) r102;
        Object r105 = null;
        JSONArray r106 = new JSONArray(SettingManager.getInstance().getSettingConfig("miaoda_domain", true));     // Catch: Throwable -> L28
        ArrayList r107 = new ArrayList(r106.length());     // Catch: Throwable -> L28
        int r108 = r106.length();     // Catch: Throwable -> L28
        int r109 = 0;
    L12:
        if (r109 >= r108) goto L26;
        Object r112 = r106.opt(r109);     // Catch: Throwable -> L28
        if ((r112 instanceof String) == false) goto L16;
        String r113 = (String) r112;     // Catch: Throwable -> L28
    L17:
        if (r113 == null) goto L25;
        String r114 = StringsKt.trim(r113).toString();     // Catch: Throwable -> L28
        if (r114.length() <= 0) goto L22;
        boolean r115 = true;
    L23:
        if (r115 == false) goto L25;
        r107.add(r114);     // Catch: Throwable -> L28
        goto L25
    L22:
        r115 = false;
    L25:
        r109 = r109 + 1;     // Catch: Throwable -> L28
        goto L12
    L16:
        r113 = null;
        goto L17
    L26:
        Object r116 = Result.m9449constructorimpl((String[]) r107.toArray(new String[0]));     // Catch: Throwable -> L28
    L30:
        String[] r117 = new String[0];
        if (Result.m9455isFailureimpl(r116) == false) goto L33;
        r116 = r117;
    L33:
        List r118 = ArraysKt.asList((String[]) ArraysKt.plus(r104, (String[]) r116));
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r118, "allowedDomains");
        URI r119 = new URI(r110);     // Catch: Throwable -> L63
        if (ubb.b.a(r119, r118, r111) == false) goto L86;
        String r120 = r119.getPath();     // Catch: Throwable -> L63
        if (r120 != null) goto L40;
        r120 = "";
    L40:
        List r121 = StringsKt.split$default(r120, new char[]{'/'}, false, 0, 6, null);     // Catch: Throwable -> L63
        ArrayList r122 = new ArrayList();     // Catch: Throwable -> L63
        Iterator r123 = r121.iterator();     // Catch: Throwable -> L63
    L42:
        if (r123.hasNext() == false) goto L50;
        Object r124 = r123.next();     // Catch: Throwable -> L63
        if (((String) r124).length() <= 0) goto L46;
        boolean r125 = true;
    L47:
        if (r125 == false) goto L42;
        r122.add(r124);     // Catch: Throwable -> L63
        goto L42
    L46:
        r125 = false;
        goto L47
    L50:
        if (r122.size() != 2) goto L87;
        String r126 = (String) ListProtector.get(r122, 1);     // Catch: Throwable -> L63
        String r127 = (String) ListProtector.get(r122, 0);     // Catch: Throwable -> L63
        if (Intrinsics.areEqual(r127, "page") == false) goto L56;
        MiaodaUrlRoute r128 = MiaodaUrlRoute.PAGE;     // Catch: Throwable -> L63
    L61:
        Object r129 = Result.m9449constructorimpl(new ubb.a(r126, r128));     // Catch: Throwable -> L63
    L66:
        if (Result.m9455isFailureimpl(r129) == true) goto L70;
        r105 = r129;
    L70:
        return (ubb.a) r105;
    L56:
        if (Intrinsics.areEqual(r127, "app") == true) goto L58;
        return null;
    L58:
        if (StringsKt.startsWith$default(r126, "app_", false, 2, null) == false) goto L89;
        r128 = MiaodaUrlRoute.App;     // Catch: Throwable -> L63
        goto L61
    L89:
        return null;
    L87:
        return null;
    L86:
        return null;
    L63:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L28:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
