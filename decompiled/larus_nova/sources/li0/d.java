package li0;

import android.view.View;
import com.bytedance.android.live.liveinteract.multiscene.f;
import com.bytedance.android.live.liveinteract.multiscene.j;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {
    public static final boolean e() {
        return g(null);
    }

    public static final j a(com.bytedance.android.live.liveinteract.multiscene.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$blueTeamInfo");
        if (r100.getTeamInfos() == null) goto L29;
        List<j> r101 = r100.getTeamInfos();
        if (r101 == null) goto L10;
        if (r101.isEmpty() == true) goto L29;
    L10:
        if (r100.getFightType() != 1) goto L20;
        List<j> r102 = r100.getTeamInfos();
        Intrinsics.checkNotNull(r102);
        Iterator<j> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L29;
        j r104 = r103.next();
        if (r104 == null) goto L13;
        if (r104.getTeamId() != 2) goto L13;
        return r104;
    L20:
        if (r100.getFightType() != 2) goto L29;
        List<j> r105 = r100.getTeamInfos();
        Intrinsics.checkNotNull(r105);
        Iterator<j> r106 = r105.iterator();
    L23:
        if (r106.hasNext() == false) goto L29;
        j r107 = r106.next();
        if (r107 == null) goto L23;
        if (r107.getTeamId() == je0.d.a0()) goto L23;
        return r107;
    L29:
        return null;
    }

    public static final int b(int r100) {
        com.bytedance.android.live.liveinteract.multiscene.a r101 = TeamFightContext.Companion.b();
        if (r101 == null) goto L7;
        List<j> r102 = r101.getTeamInfos();
        if (r102 == null) goto L7;
        int r103 = r102.size();
    L9:
        if (r103 >= 2) goto L12;
        return -1;
    L12:
        if (r101 == null) goto L27;
        List<j> r104 = r101.getTeamInfos();
        if (r104 == null) goto L27;
        j r105 = (j) ListProtector.get(r104, 0);
        if (r105 == null) goto L27;
        List<Long> r106 = r105.getPositionList();
        if (r106 == null) goto L27;
        if (r106.contains(Long.valueOf(r100)) != true) goto L27;
        List<j> r107 = r101.getTeamInfos();
        if (r107 == null) goto L42;
        j r108 = (j) ListProtector.get(r107, 0);
        if (r108 != null) goto L26;
        return -1;
    L26:
        return (int) r108.getTeamId();
    L42:
        return -1;
    L27:
        if (r101 == null) goto L44;
        List<j> r109 = r101.getTeamInfos();
        if (r109 == null) goto L45;
        j r110 = (j) ListProtector.get(r109, 1);
        if (r110 == null) goto L46;
        List<Long> r111 = r110.getPositionList();
        if (r111 != null) goto L35;
        return -1;
    L35:
        if (r111.contains(Long.valueOf(r100)) != true) goto L48;
        List<j> r112 = r101.getTeamInfos();
        if (r112 == null) goto L49;
        j r113 = (j) ListProtector.get(r112, 1);
        if (r113 != null) goto L41;
        return -1;
    L41:
        return (int) r113.getTeamId();
    L49:
        return -1;
    L48:
        return -1;
    L46:
        return -1;
    L45:
        return -1;
    L44:
        return -1;
    L7:
        r103 = 0;
        goto L9
    }

    public static final int c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        com.bytedance.android.live.liveinteract.multiscene.a r101 = TeamFightContext.Companion.b();
        if (r101 == null) goto L42;
        List<j> r102 = r101.getTeamInfos();
        if (r102 == null) goto L46;
        j r103 = (j) CollectionsKt.getOrNull(r102, 0);
        if (r103 == null) goto L43;
        List<f> r104 = r103.getPlayers();
        if (r104 == null) goto L47;
        Iterator<f> r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(r105.next().getUserIdString(), r100) == false) goto L14;
        j r106 = (j) CollectionsKt.getOrNull(r102, 0);
        if (r106 != null) goto L20;
        return -1;
    L20:
        return (int) r106.getTeamId();
    L21:
        j r107 = (j) CollectionsKt.getOrNull(r102, 1);
        if (r107 == null) goto L44;
        List<f> r108 = r107.getPlayers();
        if (r108 == null) goto L48;
        Iterator<f> r109 = r108.iterator();
    L28:
        if (r109.hasNext() == false) goto L49;
        if (Intrinsics.areEqual(r109.next().getUserIdString(), r100) == false) goto L28;
        j r110 = (j) CollectionsKt.getOrNull(r102, 1);
        if (r110 != null) goto L34;
        return -1;
    L34:
        return (int) r110.getTeamId();
    L49:
        return -1;
    L48:
        return -1;
    L44:
        return -1;
    L47:
        return -1;
    L43:
        return -1;
    L46:
        return -1;
    L42:
        return -1;
    }

    public static final int d(int r100) {
        if (((r100 - 1) % 4) < 2) goto L7;
        return 2;
    L7:
        return 1;
    }

    public static final boolean f(com.bytedance.android.live.liveinteract.multiscene.a r100) {
        if (r100 != null) goto L4;
        r100 = TeamFightContext.Companion.b();
    L4:
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.getTeamBattleType() != 1) goto L8;
        return true;
    }

    public static final boolean g(com.bytedance.android.live.liveinteract.multiscene.a r100) {
        if (r100 != null) goto L4;
        r100 = TeamFightContext.Companion.b();
    L4:
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.getTeamBattleType() != 2) goto L8;
        return true;
    }

    public static final int h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$measureAndGetWidth");
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r100.getMeasuredWidth();
    }

    public static final j i(com.bytedance.android.live.liveinteract.multiscene.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$redTeamInfo");
        if (r100.getTeamInfos() == null) goto L29;
        List<j> r101 = r100.getTeamInfos();
        if (r101 == null) goto L10;
        if (r101.isEmpty() != true) goto L10;
        return null;
    L10:
        if (r100.getFightType() != 1) goto L20;
        List<j> r102 = r100.getTeamInfos();
        Intrinsics.checkNotNull(r102);
        Iterator<j> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L45;
        j r104 = r103.next();
        if (r104 == null) goto L13;
        if (r104.getTeamId() != 1) goto L13;
        return r104;
    L45:
        return null;
    L20:
        if (r100.getFightType() != 2) goto L43;
        List<j> r105 = r100.getTeamInfos();
        Intrinsics.checkNotNull(r105);
        Iterator<j> r106 = r105.iterator();
    L23:
        if (r106.hasNext() == false) goto L46;
        j r107 = r106.next();
        if (r107 == null) goto L23;
        if (r107.getTeamId() != je0.d.a0()) goto L23;
        return r107;
    L46:
        return null;
    L43:
        return null;
    L29:
        return null;
    }
}
