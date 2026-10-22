package lk3;

import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "type");
        g r1 = g.a;
        JSONObject r2 = new JSONObject();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        r2.putOpt("url", r4);     // Catch: Throwable -> L9
        r2.putOpt("container_type", r5);     // Catch: Throwable -> L9
        if (r6 == false) goto L6;
        String r7 = CommentScene.COMMENTSCENE_NO_AWEME;
    L7:
        Result.constructor-impl(r2.putOpt("success", r7));     // Catch: Throwable -> L9
    L11:
        Unit r8 = Unit.INSTANCE;
        r1.logV3("ec_tabkit_create_hybrid_component", r2);
        return;
    L6:
        r7 = "0";
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static void b(String r3, String r4, boolean r5, Map r6) {
        g r0 = g.a;
        JSONObject r1 = new JSONObject();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        r1.putOpt("load_url", r3);     // Catch: Throwable -> L20
        r1.putOpt("load_type", r4);     // Catch: Throwable -> L20
        if (r5 == false) goto L9;
        String r7 = CommentScene.COMMENTSCENE_NO_AWEME;
    L10:
        r1.putOpt("success", r7);     // Catch: Throwable -> L20
        if (r6 == null) goto L17;
        Iterator r8 = r6.entrySet().iterator();     // Catch: Throwable -> L20
    L14:
        if (r8.hasNext() == false) goto L16;
        Map.Entry r9 = (Map.Entry) r8.next();     // Catch: Throwable -> L20
        r1.putOpt((String) r9.getKey(), r9.getValue());     // Catch: Throwable -> L20
        goto L14
    L16:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Result.constructor-impl(r10);     // Catch: Throwable -> L20
    L22:
        Unit r11 = Unit.INSTANCE;
        r0.logV3("ec_tabkit_anniex_lynx_load", r1);
        return;
    L17:
        r10 = null;
        goto L18
    L9:
        r7 = "0";
    L20:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public static void c(String r3, String r4, String r5, boolean r6) {
        g r0 = g.a;
        JSONObject r1 = new JSONObject();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        r1.putOpt("load_url", r3);     // Catch: Throwable -> L12
        r1.putOpt("load_type", r4);     // Catch: Throwable -> L12
        r1.putOpt("stage", r5);     // Catch: Throwable -> L12
        if (r6 == false) goto L9;
        String r7 = CommentScene.COMMENTSCENE_NO_AWEME;
    L10:
        Result.constructor-impl(r1.putOpt("is_downgrade", r7));     // Catch: Throwable -> L12
    L14:
        Unit r8 = Unit.INSTANCE;
        r0.logV3("ec_tabkit_anniex_lynx_load_process", r1);
        return;
    L9:
        r7 = "0";
    L12:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
