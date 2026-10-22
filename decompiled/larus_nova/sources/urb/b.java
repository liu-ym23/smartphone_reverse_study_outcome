package urb;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f551390a = 0;

    public static final class a {
        public static void a(String r100, String r101, String r102, Message.Type r103) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            Intrinsics.checkNotNullParameter(r101, "messageId");
            Intrinsics.checkNotNullParameter(r102, "cId");
            Intrinsics.checkNotNullParameter(r103, "messageType");
            Map<String, Object> r104 = ChatParamUtils.f(r100);
            if (r104 != null) goto L5;
            return;
        L5:
            Statistics.sendEvent("im_chat_main_click", new JSONObject(r104).put("msg_id", r101).put("cid", r102).put(SeiMessageConst.MSG_TYPE, ChatParamUtils.k(r103)).put("click", BrowserDependency.UrlClickType.CARD).put(PickerReporterConstants.KEY.TARGET, "none"));
        }
    }

    static {
    }
}
