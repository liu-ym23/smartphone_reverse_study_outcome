package ke6;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.lark.policy.event.Event;
import com.bytedance.lark.policy.event.EventManager;
import com.bytedance.lark.policy.event.InnerEvent;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a extends Handler {
    public a(Looper r100) {
        super(r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        int r101 = r100.what;
        if (r101 != 100) goto L5;
        CopyOnWriteArraySet<com.bytedance.lark.policy.event.a> r102 = EventManager.f253801a;
        EventManager.b(InnerEvent.EVENT_TIMER);
        sendEmptyMessageDelayed(100, b.f503031b);
        return;
    L5:
        if (r101 != 101) goto L11;
        CopyOnWriteArraySet<com.bytedance.lark.policy.event.a> r103 = EventManager.f253801a;
        EventManager.a(Event.EVENT_DECISION_CONTEXT_CHANGE);
        return;
    }
}
