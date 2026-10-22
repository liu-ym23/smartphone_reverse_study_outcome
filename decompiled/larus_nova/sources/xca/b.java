package xca;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;

/* JADX INFO: loaded from: classes32.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f563247a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f563248a = null;

        static {
            f563248a = new a();
        }

        public a() {
        }

        public static AppIntentMessage a(Message r100) {
            zda.a r101 = zda.a.f571485a;     // Catch: Exception -> L11
            if (r100 == null) goto L6;
            String r102 = r100.getContent();     // Catch: Exception -> L11
        L7:
            if (r102 != null) goto L9;
            r102 = "";
        L9:
            r101.getClass();     // Catch: Exception -> L11
            return zda.a.e(r102);
        L6:
            r102 = null;
        L11:
            e = move-exception;
            FLogger.f375446a.e("IMsgProcessor", "parseAppIntentMessageHybridEntity failed e = " + e);
            return null;
        }
    }

    static {
        f563247a = a.f563248a;
    }
}
