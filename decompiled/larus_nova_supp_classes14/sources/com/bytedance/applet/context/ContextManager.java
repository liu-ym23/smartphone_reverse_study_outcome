package com.bytedance.applet.context;

import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.ai.monitor.b;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.api.IAppletPayloadProviderService;
import com.larus.bmhome.chat.api.t0;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import k5.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ4\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/applet/context/ContextManager;", "Lcom/larus/bmhome/chat/api/IAppletPayloadProviderService;", "<init>", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "providers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ai/context/IContextProvider;", "appletPayloadChangedListeners", "Lcom/larus/bmhome/chat/api/OnAppletPayloadChangedListener;", "addContextProvider", "", "provider", "removeContextProvider", "getAppletPayload", "", "conversationId", "botId", "msgId", "addOnAppletPayloadChangedListener", "listener", "removeOnAppletPayloadChangedListener", "getWidgetContext", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidgetContext", "context", "onAppletPayloadChanged", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextManager implements IAppletPayloadProviderService {
    public static final ContextManager a = null;
    public static final Gson b = null;
    public static final CopyOnWriteArrayList<t4.a> c = null;
    public static final CopyOnWriteArrayList<t0> d = null;

    public static final class a implements j {
        public final /* synthetic */ String a;
        public final /* synthetic */ Map<String, String> b;

        public final void a(AppletMonitorableEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "event");
            String r0 = this.a;
            if (r0 == null) goto L5;
            r6.f("message_id", r0);
        L5:
            Gson r1 = new Gson();
            Map<String, String> r2 = this.b;
            LinkedHashMap r3 = new LinkedHashMap();
            Iterator<Map.Entry<String, String>> r4 = r2.entrySet().iterator();
        L7:
            if (r4.hasNext() == false) goto L14;
            Map.Entry<String, String> r5 = r4.next();
            if (r5.getKey() == null) goto L11;
            boolean r7 = true;
        L12:
            if (r7 == false) goto L7;
            r3.put(r5.getKey(), r5.getValue());
            goto L7
        L11:
            r7 = false;
            goto L12
        L14:
            r6.i(new JSONObject(GsonProtectorUtils.toJson(r1, r3)));
        }

        public a(String r1, Map<String, String> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    private ContextManager() {
    }

    static {
        a = new ContextManager();
        b = new Gson();
        CopyOnWriteArrayList<t4.a> r0 = new CopyOnWriteArrayList();
        c = r0;
        d = new CopyOnWriteArrayList();
        AppletRuntimeManager r1 = AppletRuntimeManager.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "provider");
        r0.add(r1);
    }

    public final void a(t0 r2) {
        d.remove(r2);
    }

    public final void c(CommonAppletPlugin.initAppletPayloadChangeListener.1 r2) {
        d.add(r2);
    }

    public static void d(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "msgId");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ContextManager$updateWidgetContext$1(r7, r8, null), 3, null);
    }

    public final Map<String, String> b(String r9, String r10, String r11) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<t4.a> r1 = c.iterator();
    L4:
        if (r1.hasNext() == false) goto L25;
        t4.a r2 = r1.next();
        if (r9 != null) goto L8;
        String r4 = "";
    L9:
        if (r10 != null) goto L11;
        String r5 = "";
    L12:
        if (r11 != null) goto L14;
        String r6 = "";
    L15:
        Map r3 = r2.getContext(r4, r5, r6);
        if (r3 == null) goto L4;
        Iterator r7 = r3.entrySet().iterator();
    L19:
        if (r7.hasNext() == false) goto L4;
        Map.Entry r8 = (Map.Entry) r7.next();
        if (o0.d((String) r0.get(r8.getKey())) == false) goto L23;
        String r12 = (String) r8.getKey();
        r0.put(r12, ((String) r0.get(r12)) + '\n');
    L24:
        String r13 = (String) r8.getKey();
        r0.put(r13, ((String) r0.get(r13)) + ((String) r8.getValue()));
        goto L19
    L23:
        r0.put(r8.getKey(), "");
        goto L24
    L14:
        r6 = r11;
        goto L15
    L11:
        r5 = r10;
        goto L12
    L8:
        r4 = r9;
        goto L9
    L25:
        Iterator r14 = r0.entrySet().iterator();
    L27:
        if (r14.hasNext() == false) goto L34;
        if (((CharSequence) ((Map.Entry) r14.next()).getValue()).length() != 0) goto L31;
        boolean r15 = true;
    L32:
        if (r15 == false) goto L27;
        r14.remove();
        goto L27
    L31:
        r15 = false;
        goto L32
    L34:
        b.d("applet_payload", new a(r11, r0));
        if (r0.isEmpty() == false) goto L50;
        return null;
    L50:
        return r0;
    }
}
