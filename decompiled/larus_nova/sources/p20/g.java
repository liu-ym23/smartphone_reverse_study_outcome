package p20;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f527371a = null;

    static {
        f527371a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        e.a r111 = (e.a) r110;
        String r100 = e.f527362a;
        Intrinsics.checkNotNullParameter(r111, "jsbInfo");
        if (e.a() == false) goto L47;
        List<e.a> r101 = e.f527363b;
        e.a r102 = null;
        Object r103 = null;
        if (r101 == null) goto L21;
        Iterator r104 = ((ArrayList) r101).iterator();
    L9:
        if (r104.hasNext() == false) goto L20;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((e.a) r105).f527367c, r111.f527367c) == false) goto L17;
        boolean r106 = true;
        if ((!Intrinsics.areEqual(r111.f527367c, "")) == false) goto L17;
        if ((!Intrinsics.areEqual(r111.f527367c, "0")) == false) goto L17;
    L18:
        if (r106 == false) goto L9;
        r103 = r105;
    L17:
        r106 = false;
    L20:
        r102 = (e.a) r103;
    L21:
        if (r102 != null) goto L23;
    L38:
        if (r111 == null) goto L40;
        ((ArrayList) e.f527363b).add(r111);
    L40:
        ALogger.i("DebugHybridTools", "addRequestJsbCallInfo-> jsbInfo=" + r111);
        return;
    L23:
        if (Intrinsics.areEqual(r111.f527365a, "") == false) goto L25;
        String r107 = "Jsb名称：" + r102.f527365a;
    L26:
        String r108 = r107;
        int r109 = r111.f527366b;
        if (r109 != (-100020)) goto L29;
        r109 = r102.f527366b;
    L29:
        int r112 = r109;
        String r113 = r111.f527367c;
        if (Intrinsics.areEqual(r111.f527368d, "") == false) goto L32;
        String r114 = r102.f527368d;
    L33:
        String r115 = r114;
        if (Intrinsics.areEqual(r111.f527369e, "") == false) goto L36;
        String r116 = r102.f527369e;
    L37:
        r111 = new e.a(r108, r112, r113, r115, r116);
        goto L38
    L36:
        r116 = r111.f527369e;
        goto L37
    L32:
        r114 = r111.f527368d;
        goto L33
    L25:
        r107 = "Jsb名称：" + r111.f527365a;
        goto L26
    }
}
