package py;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.util.MessageTypeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public interface m {

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    public static final a f530972l2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AtomicInteger f530973a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final MessageTypeMap f530974b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a f530975c = null;

        public a() {
        }

        static {
            f530975c = new a();
            f530973a = new AtomicInteger(1000000);
            f530974b = new MessageTypeMap(new ConcurrentHashMap());
        }

        public static void a(MessageType r100) {
            Intrinsics.checkNotNullParameter(r100, "messageType");
            MessageTypeMap r101 = f530974b;
            if (r101.getMessageIntType(r100.getWsMethod()) != null) goto L6;
            r101.put(Integer.valueOf(f530973a.getAndIncrement()), r100.getWsMethod());
            return;
        }
    }

    static {
        f530972l2 = a.f530975c;
    }

    int getIntTypeExt();

    String getWsMethod();
}
