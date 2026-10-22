package bm2;

import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.u0;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdk.log.h;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements h {
    public final Map<Class<?>, o<?>> a;
    public final Map<Class<?>, o<?>> b;
    public final Map<Object, v> c;
    public final String d;

    @Override // com.bytedance.android.livesdk.log.h
    public final Map<Class<?>, o<?>> getFakeTempMap() {
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().isLiveInitArcOpt() == false) goto L7;
        return this.b;
    L7:
        return new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final void initConfig() {
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().isLiveInitArcOpt() == true) goto L5;
        Map<Class<?>, o<?>> r0 = this.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.putAll(a(this.d));
    L9:
        addSendLogFilter(u0.class, new u0());
        return;
    L5:
        if (((ConcurrentHashMap) this.b).isEmpty() == true) goto L7;
        Map<Class<?>, o<?>> r2 = this.a;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.putAll(this.b);
        goto L9
    L7:
        Map<Class<?>, o<?>> r4 = this.a;
        ConcurrentHashMap r5 = (ConcurrentHashMap) r4;
        r5.putAll(a(this.d));
        goto L9
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final Map<Class<?>, o<?>> getMap() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final Map<Object, v> getSendLogFilter() {
        return this.c;
    }

    public b(String r1) {
        this.d = r1;
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
    }

    public static Map a(String r3) {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        HashMap<Class<?>, o<?>> r1 = a.a;
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        HashMap r4 = null;
    L15:
        if (r4 == null) goto L17;
        r0.putAll(r4);
    L17:
        r0.putAll(a.b);
        r0.putAll(a.a);
        r0.putAll(a.a());
        return r0;
    L11:
        ConcurrentHashMap r5 = (ConcurrentHashMap) a.c;
        if (r5.containsKey(r3) == false) goto L14;
        r4 = (HashMap) r5.get(r3);
        goto L15
    L14:
        HashMap r6 = a.b();
        r5.put(r3, r6);
        r4 = r6;
        goto L15
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final v removeSendLogFilter(Object r2) {
        v r3 = (v) ((ConcurrentHashMap) this.c).remove(r2);
        if (r3 == null) goto L5;
        r3.onRemove();
    L5:
        return r3;
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final <T> void unregister(Class<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        ((ConcurrentHashMap) this.a).remove(r2);
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final boolean addSendLogFilter(Object r2, v r3) {
        Intrinsics.checkNotNullParameter(r3, "filter");
        if (((ConcurrentHashMap) this.c).containsKey(r2) == false) goto L5;
        return false;
    L5:
        ((ConcurrentHashMap) this.c).put(r2, r3);
        r3.Rd();
        return true;
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final <T> void register(Class<? extends T> r2, o<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "filter");
        ((ConcurrentHashMap) this.a).put(r2, r3);
    }
}
