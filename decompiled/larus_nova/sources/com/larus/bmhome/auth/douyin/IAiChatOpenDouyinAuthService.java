package com.larus.bmhome.auth.douyin;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwner;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bg\u0018\u00002\u00020\u0001:\u0002'(J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\u000bH&J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H&J$\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u000eH&J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0012H&J\n\u0010\u001e\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\fH&J\u0012\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\fH&J*\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u0012H&¨\u0006)"}, d2 = {"Lcom/larus/bmhome/auth/douyin/IAiChatOpenDouyinAuthService;", "", "removeAiChatDouyinAuthResultHandler", "", "handler", "Lcom/larus/bmhome/auth/douyin/IAiChatDouyinAuthResultHandler;", "addAiChatDouyinAuthResultHandler", "addOnMessageNeedAuthListener", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "listener", "Lkotlin/Function1;", "Lcom/larus/im/bean/message/Message;", "showPreAskingDialog", "", "json", "Lorg/json/JSONObject;", "title", "", "cancel", "confirm", "callback", "Lcom/larus/bmhome/auth/douyin/IAiChatOpenDouyinAuthService$IDouyinAuthPreAskingCallback;", "handleSchema", "parse", "Landroid/net/Uri;", "traceInfo", "ignore", "handleTraceInfo", "jumpUrl", "currentMessage", "checkIfAuthMessage", "message", "setAuthMessage", "requestAuthorizeCardMessage", "messageId", "musicPlatform", "cvsId", "botId", "IAiChatDouyinAuthCallback", "IDouyinAuthPreAskingCallback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAiChatOpenDouyinAuthService {

    public static final class a {
        public static /* synthetic */ void a(IAiChatOpenDouyinAuthService r100, Uri r101, JSONObject r102, boolean r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = new JSONObject();
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = false;
        L8:
            r100.l(r101, r102, r103);
        }
    }

    public interface b {

        public static final class a {
            public static /* synthetic */ void a(b r100, boolean r101, Integer r102, String r103, String r104, String r105, String r106, int r107) {
                if ((r107 & 2) == 0) goto L5;
                r102 = null;
            L5:
                r100.a(r101, r102);
            }
        }

        void a(boolean r100, Integer r101);
    }

    public interface c {
        void onResult(boolean r100);
    }

    void f(Message r100);

    void g();

    JSONObject h(String r100);

    Message i();

    void j(ya8.a r100);

    void k(String r100, String r101, String r102, String r103);

    void l(Uri r100, JSONObject r101, boolean r102);

    void m(ya8.a r100);

    boolean n(JSONObject r100, String r101, String r102, String r103, c r104);

    void o(LifecycleOwner r100, Function1<? super Message, Unit> r101);
}
