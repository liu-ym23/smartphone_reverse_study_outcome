package nb0;

import com.bytedance.android.live.ktv.common.karaokestation.model.d;
import com.bytedance.android.live.ktv.common.karaokestation.model.x;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.model.z;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a implements b {
    public a() {
    }

    @Override // nb0.b
    public final String c() {
        return null;
    }

    @Override // nb0.b
    public final t61 e() {
        return null;
    }

    @Override // nb0.b
    public final String h() {
        return null;
    }

    @Override // nb0.b
    public final x getRoomInfo() {
        return new x(0);
    }

    @Override // nb0.b
    public final Map<String, y> f(d r100) {
        Intrinsics.checkNotNullParameter(r100, "firstLevelTabData");
        Map<String, y> r101 = r100.f69501a;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.putAll(r101);
        Iterator<Map.Entry<String, y>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        y r104 = r103.next().getValue();
        if (r104.a() == false) goto L4;
        r102.remove(r104.f69578c);
        ArrayList<y> r105 = r104.f69576a;
        if (r105 == null) goto L4;
        Iterator<T> r106 = r105.iterator();
    L11:
        if (r106.hasNext() == false) goto L4;
        y r107 = (y) r106.next();
        r102.put(r107.f69578c, r107);
        goto L11
    L13:
        return r102;
    }

    @Override // nb0.b
    public final void postSyncSongListData(y r100) {
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
    }

    @Override // nb0.b
    public final void postSyncTabListData(d r100) {
        Intrinsics.checkNotNullParameter(r100, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r100, "firstLevelTabData");
    }

    @Override // nb0.b
    public final void updateMusicPanelState(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
    }

    @Override // nb0.b
    public final void a(d r110, List<o0> r111) {
        Intrinsics.checkNotNullParameter(r110, "firstLevelTabData");
        if (r111 == null) goto L25;
        Iterator<T> r112 = r111.iterator();
        int r100 = 0;
    L6:
        if (r112.hasNext() == false) goto L33;
        Object r101 = r112.next();
        int r102 = r100 + 1;
        if (r100 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        o0 r103 = (o0) r101;
        if (r103.f() == false) goto L24;
        y r104 = r110.f69501a.get(r103.c());
        if (r104 == null) goto L24;
        ArrayList<y> r105 = new ArrayList();
        List<o0> r106 = r103.d();
        if (r106 == null) goto L23;
        Iterator<T> r107 = r106.iterator();
        int r108 = 0;
    L18:
        if (r107.hasNext() == false) goto L23;
        Object r109 = r107.next();
        int r113 = r108 + 1;
        if (r108 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        y r114 = new y(r110.f69504d, r108, 48127);
        y r115 = z.update(r114, (o0) r109);
        r115.f69577b = r104;
        r105.add(r115);
        r108 = r113;
    L23:
        r104.f69576a = r105;
    L24:
        r100 = r102;
        goto L6
    L33:
        return;
    }

    @Override // nb0.b
    public final void b(boolean r100, Throwable r101, y r102, long r103) {
        Intrinsics.checkNotNullParameter(r102, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r102, "secondLevelTabData");
    }

    @Override // nb0.b
    public final void d(boolean r100, Throwable r101, d r102, long r103) {
        Intrinsics.checkNotNullParameter(r102, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r102, "firstLevelTabData");
    }
}
