package f50;

import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import c50.c;
import c50.d;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.common.utility.reflect.Reflect;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f475607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f475608b;

    public a(boolean r100, boolean r101) {
        this.f475607a = false;
        this.f475608b = false;
        if (v.a() == false) goto L6;
        this.f475607a = r100;
        this.f475608b = r101;
        return;
    }

    public final void a(HashMap<Integer, d> r100, c r101) {
        if (this.f475607a == false) goto L12;
        if (r101 == null) goto L13;
        if (r100 == null) goto L11;
        d r102 = r100.get(Integer.valueOf(r101.f22450d));
        if (r102 == null) goto L11;
        r102.b();
    L11:
        return;
    L13:
        return;
    }

    public final void b(Handler r110, HashMap<Integer, d> r111) {
        if (this.f475607a == true) goto L6;
        return;
    L6:
        if (this.f475608b == true) goto L8;
        if (r110 == null) goto L49;
        HashMap r100 = new HashMap();
        Message r112 = (Message) Reflect.on((MessageQueue) Reflect.on(r110).get("mQueue", new Class[0])).get("mMessages", new Class[0]);     // Catch: Exception -> L45
    L33:
        if (r112 == null) goto L47;
        int r101 = r112.what;     // Catch: Exception -> L45
        Integer r102 = (Integer) r100.get(Integer.valueOf(r101));     // Catch: Exception -> L45
        if (r102 != null) goto L37;
    L39:
        int r103 = 0;
    L40:
        r100.put(Integer.valueOf(r101), Integer.valueOf(r103 + 1));     // Catch: Exception -> L45
        r112.getWhen();     // Catch: Exception -> L45
        Runnable r104 = r112.getCallback();     // Catch: Exception -> L45
        if (r104 == null) goto L43;
        Runnable r105 = (Runnable) Reflect.on(r104).get(PlayerResolution.SDKKEY.ORIGIN, new Class[0]);     // Catch: Exception -> L60
    L43:
        r112.getTarget();     // Catch: Exception -> L45
        r112 = (Message) Reflect.on(r112).get(TeaEventTrack.ACTION_DRAMA_NEXT, new Class[0]);     // Catch: Exception -> L45
        goto L33
    L37:
        if (r102.intValue() < 0) goto L39;
        r103 = r102.intValue();     // Catch: Exception -> L45
    L47:
        r100.toString();
    L45:
        e = move-exception;
        e.printStackTrace();
    L49:
        if (r111 == null) goto L59;
        Iterator<Map.Entry<Integer, d>> r113 = r111.entrySet().iterator();
        if (r113.hasNext() == false) goto L77;
    L54:
        d r114 = r113.next().getValue();
        if (r114 == null) goto L58;
        r114.b();
    L58:
        if (r113.hasNext() == true) goto L54;
        return;
    L77:
        return;
    L59:
        return;
    L8:
        if (r110 == null) goto L49;
        HashMap r106 = new HashMap();
        StringBuilder r107 = new StringBuilder();
        Message r115 = (Message) Reflect.on((MessageQueue) Reflect.on(r110).get("mQueue", new Class[0])).get("mMessages", new Class[0]);     // Catch: Exception -> L25
        int r108 = 0;
    L13:
        if (r115 == null) goto L28;
        r108 = r108 + 1;
        int r109 = r115.what;     // Catch: Exception -> L23
        Integer r116 = (Integer) r106.get(Integer.valueOf(r109));     // Catch: Exception -> L23
        if (r116 != null) goto L18;
    L20:
        int r117 = 0;
    L21:
        r106.put(Integer.valueOf(r109), Integer.valueOf(r117 + 1));     // Catch: Exception -> L23
        r107.append("Msg:");     // Catch: Exception -> L23
        r107.append(r115.what);     // Catch: Exception -> L23
        r107.append("; ");     // Catch: Exception -> L23
        r115 = (Message) Reflect.on(r115).get(TeaEventTrack.ACTION_DRAMA_NEXT, new Class[0]);     // Catch: Exception -> L23
        goto L13
    L18:
        if (r116.intValue() < 0) goto L20;
        r117 = r116.intValue();     // Catch: Exception -> L23
    L23:
        e = e;
    L27:
        e.printStackTrace();
    L28:
        r107.insert(0, "MessageQueue Info: size= " + r108 + "; " + r106.toString());
    L25:
        e = e;
        r108 = 0;
        goto L27
    }
}
