package com.obric.assistant.card.manager;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.card.layout.viewholder.LarkMessageViewHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CountDownTimer> f386514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f386515b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, InterfaceC4593a> f386516c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f386517d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f386518e = null;

    /* JADX INFO: renamed from: com.obric.assistant.card.manager.a$a, reason: collision with other inner class name */
    public interface InterfaceC4593a {
        void onFinish();

        void onTick(long r100);
    }

    public static final class b implements IIMCallback<Message> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f386519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f386520b;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            FLogger.f375446a.i("LarkMessageTimerManager", "larkMessage notifyStatusChange updateStatus failure localMsgId:" + this.f386519a);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(Message r100) {
            Message r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "message");
            Map<String, String> r102 = r101.getExt();
            if (r102 == null) goto L6;
            final Map r103 = MapsKt.toMutableMap(r102);
            if (r103 == null) goto L6;
        L7:
            r103.put("lark_message_card_status", String.valueOf(this.f386520b));
            com.larus.im.d.e().x(this.f386519a, new e(r103), null);
            FLogger.f375446a.i("LarkMessageTimerManager", "larkMessage notifyStatusChange updateStatus success localMsgId:" + r101.getLocalMessageId());
            return;
        L6:
            r103 = new LinkedHashMap();
            goto L7
        }

        public b(String r100, int r101) {
            this.f386519a = r100;
            this.f386520b = r101;
        }
    }

    static {
        f386514a = new ConcurrentHashMap();
        f386515b = new ConcurrentHashMap();
        f386516c = new ConcurrentHashMap();
        f386517d = new Handler(Looper.getMainLooper());
        f386518e = new ConcurrentHashMap();
    }

    public static void a(String r100, LarkMessageViewHolder.b r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        if (r101 == null) goto L5;
        f386516c.put(r100, r101);
    L6:
        ConcurrentHashMap<String, CountDownTimer> r102 = f386514a;
        if (r102.containsKey(r100) == false) goto L14;
        Long r103 = f386515b.get(r100);
        if (r103 == null) goto L18;
        long r104 = r103.longValue();
        if (r101 == null) goto L19;
        r101.onTick(r104);
        return;
    L19:
        return;
    L18:
        return;
    L14:
        d r105 = new d(r100);
        r102.put(r100, r105);
        r105.start();
        if (r101 == null) goto L20;
        r101.onTick(5000);
        return;
    L20:
        return;
    L5:
        f386516c.remove(r100);
        goto L6
    }

    public static void b(String r100, int r101) {
        Integer r102 = Integer.valueOf(r101);
        f386518e.put(r100, r102);
        com.larus.im.d.e().m(r100, new b(r100, r101));
        IAgentAppIntentIDL r103 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r103 == null) goto L6;
        r103.notifyLarkSendStausChanged(r100, r101);
        return;
    }
}
