package pd2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import mb0.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends mb0.a<f> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528660c;

    public e() {
        this.f528659b = "func2";
        this.f528660c = "1";
    }

    @Override // mb0.a
    public final long c(f r100) {
        f r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "param");
        return r101.f528661a;
    }

    @Override // mb0.a
    public final void d(String r100, f r101) {
        f r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r102, "param");
        HashMap<String, String> r103 = r102.f528662b;
        if (r103 == null) goto L5;
        r103.put(this.f528659b, this.f528660c);
    L5:
        d r104 = d.f528658n;
        long r105 = r102.f528661a;
        HashMap<String, String> r106 = r102.f528662b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "process");
        if (d.f528650f == false) goto L17;
        JSONObject r107 = mb0.b.r(mb0.b.p(new JSONObject(), r105), r100);
        if (r106 == null) goto L14;
        Iterator<Map.Entry<String, String>> r108 = r106.entrySet().iterator();
    L12:
        if (r108.hasNext() == false) goto L14;
        Map.Entry<String, String> r109 = r108.next();
        r107.put(r109.getKey(), r109.getValue());
    L14:
        d.w(LinkMonitorData.BusinessMusicStartSing, r107);
        return;
    }

    public final void e(String r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "param");
        StringBuilder r102 = new StringBuilder("recordLinkPath:");
        r102.append(r100);
        r102.append("---");
        Intrinsics.checkNotNullParameter(r101, "param");
        r102.append(r101.f528661a);
        ALogger.i("onSingPathReport", r102.toString());
        int r103 = r100.hashCode();
        if (r103 == 96784904) goto L16;
        if (r103 == 505589906) goto L13;
        if (r103 == 1985308523) goto L10;
    L26:
        Intrinsics.checkNotNullParameter(r100, "path");
        b(c(r101)).add(new g(r100, r101));
        return;
    L10:
        if (r100.equals("set_bgm") == false) goto L26;
    L18:
        if (Intrinsics.areEqual(r100, "sing_cut") == false) goto L23;
        HashMap<Long, LinkedList<g<T>>> r104 = this.f512757a;
        Intrinsics.checkNotNullParameter(r101, "param");
        if (r104.get(Long.valueOf(r101.f528661a)) != null) goto L25;
        return;
    L25:
        a(r100, r101);
        return;
    L23:
        if (Intrinsics.areEqual(r100, "song_arrive") == false) goto L25;
        HashMap<Long, LinkedList<g<T>>> r105 = this.f512757a;
        Intrinsics.checkNotNullParameter(r101, "param");
        r105.get(Long.valueOf(r101.f528661a));
        goto L25
    L13:
        if (r100.equals("sing_cut") == false) goto L26;
    L16:
        if (r100.equals("error") == false) goto L26;
        goto L26
    }
}
