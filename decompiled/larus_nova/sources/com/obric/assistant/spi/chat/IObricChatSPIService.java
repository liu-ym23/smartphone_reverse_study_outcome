package com.obric.assistant.spi.chat;

import android.content.Intent;
import android.os.Bundle;
import com.larus.im.bean.message.Message;
import com.ss.android.common.applog.EventVerify;
import iga.c;
import iga.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import t1a.b;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J:\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00072\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH¦@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0012H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0007H&J\b\u0010\u0019\u001a\u00020\u0007H&J\b\u0010\u001a\u001a\u00020\u0007H&J\b\u0010\u001b\u001a\u00020\u0007H&J\b\u0010\u001c\u001a\u00020\u0007H&J\b\u0010\u001d\u001a\u00020\u0007H&J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u001fH&J\n\u0010 \u001a\u0004\u0018\u00010!H&J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0007H&J$\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00030)H&¨\u0006*"}, d2 = {"Lcom/obric/assistant/spi/chat/IObricChatSPIService;", "", "tryBreakLatestAnswer", "", "curCvsId", "", "onCheckAsrContentRelative", "", "taskid", "asrContent", "ensureContextSafe", "cvsId", "canRetry", "extra", "", "(Ljava/lang/String;ZLjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReGenerate", "questionMsg", "Lcom/larus/im/bean/message/Message;", "shouldSkipAsLatestRegenerateMessage", "message", "markChatListBottomReached", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "isEnabledAssistantOpenPageMethod", "isBluetoothHeadSetConnected", "enableLiveTutorAsrOpt", "enableCameraCommandOpt", "enableCameraSuggestedToDeferred", "enableCameraOpenResultPage", "openChatWindowForCameraResult", "Landroid/os/Bundle;", "getCachedMainChatSnapshot", "Lcom/obric/assistant/spi/chat/ObricMainChatSnapshot;", "getWindowInboxBackgroundStyle", "Lcom/obric/assistant/spi/chat/ObricWindowInboxBackgroundStyle;", "isDarkMode", "tryLaunchFilePicker", "defaultIntent", "Landroid/content/Intent;", EventVerify.TYPE_LAUNCH, "Lkotlin/Function1;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricChatSPIService {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object a(IObricChatSPIService r100, String r101, boolean r102, Map r103, Continuation r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r101 = "";
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = false;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = null;
        L12:
            return r100.n(r101, r102, r103, r104);
        }
    }

    boolean a();

    void b(Message r100);

    c c();

    boolean d();

    d e(boolean r100);

    boolean f(Intent r100, li8.c r101);

    void g(String r100);

    boolean h(Message r100);

    boolean i();

    boolean j();

    void k(b r100);

    boolean l();

    boolean m(Bundle r100);

    Object n(String r100, boolean r101, Map<String, String> r102, Continuation<? super Boolean> r103);
}
