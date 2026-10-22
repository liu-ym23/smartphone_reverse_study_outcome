package i6c;

import android.text.TextUtils;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f488449a = 0;

    static {
    }

    public static JSONObject a() {
        JSONObject r100 = new JSONObject().put("current_page", "chat");
        Chat r101 = ChatParamUtils.f416600b;
        if (r101 != null) goto L5;
        String r102 = null;
    L9:
        if (r102 == null) goto L11;
        r100.put("chat_type", r102);
    L11:
        Intrinsics.checkNotNull(r100);
        return r100;
    L5:
        if (r101.isP2PChat() == false) goto L7;
        r102 = BridgePrivilege.PRIVATE;
        goto L9
    L7:
        r102 = "group";
        goto L9
    }

    public static String b(Throwable r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof ErrorResult) == false) goto L12;
        ErrorResult r101 = (ErrorResult) r100;
        if (TextUtils.isEmpty(r101.getDisplayMsg()) == true) goto L12;
        return r101.getDisplayMsg();
    L12:
        return r100.getMessage();
    }

    public static void c(String r100, JSONObject r101) {
        Statistics.sendEvent(r100, r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.e("OfficeCustomStickerHitPoint", "send " + r100 + " failed", th);
    }
}
