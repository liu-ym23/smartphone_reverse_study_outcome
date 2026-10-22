package pd2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import mb0.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends mb0.a<f> {
    public final String b;
    public final String c;

    public e() {
        this.b = "func2";
        this.c = "1";
    }

    public final long c(Object r3) {
        f r4 = (f) r3;
        Intrinsics.checkNotNullParameter(r4, "param");
        return r4.a;
    }

    public final void d(String r4, Object r5) {
        f r6 = (f) r5;
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r6, "param");
        HashMap<String, String> r0 = r6.b;
        if (r0 == null) goto L5;
        r0.put(this.b, this.c);
    L5:
        d r1 = d.n;
        long r2 = r6.a;
        HashMap<String, String> r7 = r6.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "process");
        if (d.f == false) goto L17;
        JSONObject r8 = mb0.b.r(mb0.b.p(new JSONObject(), r2), r4);
        if (r7 == null) goto L14;
        Iterator<Map.Entry<String, String>> r9 = r7.entrySet().iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        Map.Entry<String, String> r3 = r9.next();
        r8.put(r3.getKey(), r3.getValue());
    L14:
        d.w(LinkMonitorData.BusinessMusicStartSing, r8);
        return;
    }

    public final void e(String r6, f r7) {
        Intrinsics.checkNotNullParameter(r6, "path");
        Intrinsics.checkNotNullParameter(r7, "param");
        StringBuilder r2 = new StringBuilder("recordLinkPath:");
        r2.append(r6);
        r2.append("---");
        Intrinsics.checkNotNullParameter(r7, "param");
        r2.append(r7.a);
        ALogger.i("onSingPathReport", r2.toString());
        int r3 = r6.hashCode();
        if (r3 == 96784904) goto L16;
        if (r3 == 505589906) goto L13;
        if (r3 == 1985308523) goto L10;
    L26:
        Intrinsics.checkNotNullParameter(r6, "path");
        b(c(r7)).add(new g(r6, r7));
        return;
    L10:
        if (r6.equals("set_bgm") == false) goto L26;
    L18:
        if (Intrinsics.areEqual(r6, "sing_cut") == false) goto L23;
        HashMap r0 = ((mb0.a) this).a;
        Intrinsics.checkNotNullParameter(r7, "param");
        if (r0.get(Long.valueOf(r7.a)) != null) goto L25;
        return;
    L25:
        a(r6, r7);
        return;
    L23:
        if (Intrinsics.areEqual(r6, "song_arrive") == false) goto L25;
        HashMap r1 = ((mb0.a) this).a;
        Intrinsics.checkNotNullParameter(r7, "param");
        r1.get(Long.valueOf(r7.a));
        goto L25
    L13:
        if (r6.equals("sing_cut") == false) goto L26;
    L16:
        if (r6.equals("error") == false) goto L26;
        goto L26
    }
}
