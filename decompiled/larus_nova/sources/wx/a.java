package wx;

import kotlin.jvm.internal.Intrinsics;
import nx.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends c {
    public a(String r100, JSONObject r101, com.bytedance.android.livesdk.chatroom.wornhole.a r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        super(r100, r102, "user_quit_room", r101);
    }
}
