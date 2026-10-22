package com.bytedance.locallife.live.lynx.syncjsb;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import com.bytedance.locallife.live.util.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class TimerMethod extends com.bytedance.locallife.live.lynx.syncjsb.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f260596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f260597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f260598f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        String r100 = this.f260596d;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final List<o> g() {
        return (List) this.f260597e.getValue();
    }

    public TimerMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
        this.f260597e = LazyKt.lazy(TimerMethod$timerList$2.INSTANCE);
        this.f260598f = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final boolean a(String r100) {
        this.f260596d = r100;
        if (Intrinsics.areEqual(r100, "startTimer") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "fireTimer") == true) goto L8;
        return false;
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        String r100 = this.f260596d;
        boolean r101 = false;
        if (Intrinsics.areEqual(r100, "startTimer") == false) goto L29;
        String r111 = w.f(r110, "key");
        Long r102 = w.c(r110, "duration");
        if (r102 == null) goto L7;
        long r112 = r102.longValue();
    L8:
        LiveLocalLifeLynxView r103 = this.f260600b;
        if (r103 == null) goto L79;
        if (r111 != null) goto L12;
    L13:
        r101 = true;
    L14:
        if (r101 == true) goto L79;
        if (r112 <= 0) goto L79;
        Iterator<T> r104 = g().iterator();
    L20:
        if (r104.hasNext() == false) goto L26;
        o r105 = (o) r104.next();
        if (Intrinsics.areEqual(r105.f260609c, r103) == false) goto L20;
        if (Intrinsics.areEqual(r105.f260607a, r111) == false) goto L20;
        return com.bytedance.locallife.live.lynx.syncjsb.a.b("already has same timer");
    L26:
        o r106 = new o(r111, r112, r103, this.f260598f);
        g().add(r106);
        this.f260598f.removeCallbacks(r106);
        this.f260598f.postDelayed(r106, r112);
        g().size();
        return com.bytedance.locallife.live.lynx.syncjsb.a.d(this, null, 3);
    L12:
        if (r111.length() != 0) goto L14;
    L79:
        return com.bytedance.locallife.live.lynx.syncjsb.a.b("param error");
    L7:
        r112 = 0;
        goto L8
    L29:
        if (Intrinsics.areEqual(r100, "fireTimer") == false) goto L65;
        String r107 = w.f(r110, "key");
        LiveLocalLifeLynxView r108 = this.f260600b;
        if (r108 == null) goto L82;
        if (r107 != null) goto L34;
    L37:
        boolean r109 = true;
    L38:
        if (r109 == true) goto L82;
        Iterator<T> r113 = g().iterator();
    L42:
        if (r113.hasNext() == false) goto L51;
        Object r114 = r113.next();
        o r115 = (o) r114;
        if (Intrinsics.areEqual(r115.f260609c, r108) == true) goto L46;
    L48:
        boolean r116 = false;
    L49:
        if (r116 == false) goto L42;
    L52:
        o r117 = (o) r114;
        if (r117 != null) goto L56;
        r117 = null;
    L56:
        if (r117 == null) goto L80;
        List<o> r118 = g();
        if (r118 == null) goto L62;
        TypeIntrinsics.asMutableCollection(r118).remove(r117);
        this.f260598f.removeCallbacks(r117);
        r117.f260611e = true;
        g().size();
        return com.bytedance.locallife.live.lynx.syncjsb.a.d(this, null, 3);
    L62:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L80:
        return com.bytedance.locallife.live.lynx.syncjsb.a.b("no task");
    L46:
        if (Intrinsics.areEqual(r115.f260607a, r107) == false) goto L48;
        r116 = true;
        goto L49
    L51:
        r114 = null;
        goto L52
    L34:
        if (r107.length() == 0) goto L37;
        r109 = false;
    L82:
        return com.bytedance.locallife.live.lynx.syncjsb.a.b("param error");
    L65:
        return com.bytedance.locallife.live.lynx.syncjsb.a.b("error method name");
    }
}
