package com.ss.android.lark.keyboard.event;

import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class o implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.b f429301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Object, p> f429302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Object, p> f429303c;

    public interface a {
        void dispose();
    }

    @Override // com.ss.android.lark.keyboard.event.k
    public final Function1<h, Unit> b() {
        return IKeyboardEventCenter$emptyAction$1.INSTANCE;
    }

    public o(BasicKeyboard r100) {
        Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
        this.f429301a = r100;
        this.f429302b = new ConcurrentHashMap();
        this.f429303c = new KeyboardEventCenter$handleFactory$1(this);
    }

    @Override // com.ss.android.lark.keyboard.event.k
    public final l of(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ConcurrentHashMap<Object, p> r101 = this.f429302b;
        p r102 = r101.get(r100);
        if (r102 != null) goto L9;
        r102 = this.f429303c.invoke(r100);
        p r103 = r101.putIfAbsent(r100, r102);
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.ss.android.lark.keyboard.event.k
    public final o a(j r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, "buildAction");
        EventContextImpl.Factory r100 = EventContextImpl.f429283c;
        com.ss.android.lark.keyboard.b r101 = this.f429301a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, ObricActionBarTrackType.KEY_BOARD);
        EventContextImpl r102 = r100.a();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, ObricActionBarTrackType.KEY_BOARD);
        r102.f429284a = r101;
        r102.f429285b.clear();
        r111.invoke(r102);
        Iterator<T> r112 = this.f429302b.values().iterator();
    L3:
        Object r103 = null;
        if (r112.hasNext() == false) goto L45;
        p r104 = (p) r112.next();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator r105 = ((ArrayList) r104.f429310g).iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        Object r106 = r105.next();
        if (((Boolean) ((Function2) r106).invoke(r102, r110)).booleanValue() == false) goto L7;
        r103 = r106;
    L11:
        if (r103 != null) goto L12;
        if ((r110 instanceof q) == true) goto L15;
        if ((r110 instanceof t) == false) goto L44;
        t r107 = (t) r110;
        Set r108 = CollectionsKt.intersect(r104.f429309f.a((Class<? extends m>) r107.f429317a.getClass()), r104.f429309f.a((Class<? extends m>) r107.f429318b.getClass()));
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r113 = r108.iterator();
    L32:
        if (r113.hasNext() == false) goto L35;
        r109.add(r104.f429307d.get((Class) r113.next()));
        goto L32
    L35:
        if (r109.isEmpty() == true) goto L3;
        Iterator r114 = r109.iterator();
    L39:
        if (r114.hasNext() == false) goto L3;
        Function3 r115 = (Function3) r114.next();
        if (r115 == null) goto L39;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.ss.android.lark.keyboard.event.Transform<S of com.ss.android.lark.keyboard.event.KeyboardEventHandle.handleTransformNoCheck>");
        Log.d(ObricActionBarTrackType.KEY_BOARD, "handleTransform: form " + r107.f429317a.getTag() + " tp " + r107.f429318b.getTag());
        r115.invoke(r102, r107.f429317a, r107.f429318b);
        goto L39
    L44:
        throw new NoWhenBranchMatchedException();
    L15:
        q r116 = (q) r110;
        Set<Class<? extends q>> r117 = r104.f429308e.a((Class<? extends q>) r116.getClass());
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r119 = r117.iterator();
    L17:
        if (r119.hasNext() == false) goto L20;
        r118.add(r104.f429306c.get((Class) r119.next()));
        goto L17
    L20:
        if (r118.isEmpty() == true) goto L3;
        Iterator r120 = r118.iterator();
    L24:
        if (r120.hasNext() == false) goto L3;
        Function2 r121 = (Function2) r120.next();
        if (r121 == null) goto L24;
        Log.d(ObricActionBarTrackType.KEY_BOARD, "handleNotify: notify is " + r116.getTag());
        r121.invoke(r102, r116);
        goto L24
    L12:
        Log.d(ObricActionBarTrackType.KEY_BOARD, "onSend: event is intercepted");
        goto L3
    L45:
        r102.f429285b.clear();
        r102.f429284a = null;
        EventContextImpl.Factory r122 = EventContextImpl.f429283c;
        if (r122.f429315b.size() >= 3) goto L49;
        r122.f429315b.add((T) r102);
    L49:
        if ((r110 instanceof s.b) == false) goto L51;
        ((s.b) r110).recycle();
    L51:
        return this;
    }
}
