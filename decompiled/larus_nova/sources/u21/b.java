package u21;

import android.text.TextUtils;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.d;
import com.bytedance.android.livesdk.link.model.a1;
import com.bytedance.android.livesdk.link.model.c3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public b() {
    }

    public static Map a(List r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap r101 = new HashMap();
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L26;
        af2.b r103 = (af2.b) r102.next();
        String r104 = af2.c.a(r103);
        if (r104 == null) goto L7;
        Iterator r105 = r100.iterator();
    L13:
        if (r105.hasNext() == false) goto L16;
        TextUtils.equals(((af2.b) r105.next()).getScoreText(), "0");
        goto L13
    L16:
        if (r103.isHugeRewardPk() == false) goto L18;
        r103.getScoreRelativeText();
    L20:
        if (r103.isHugeRewardPk() == true) goto L22;
        r103.getScoreRelativeText();
    L22:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.c r106 = new com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.c();
        r103.getBattleRank();
        r103.isHugeRewardPk();
        if (r103.getScoreText() != null) goto L25;
        String.valueOf(0);
    L25:
        r106.f94296a = Integer.valueOf((int) af2.c.b(r103));
        Unit r107 = Unit.INSTANCE;
        r101.put(r104, r106);
        goto L7
    L18:
        r103.getScoreText();
        goto L20
    L26:
        return r101;
    }

    public static d b(c3 r100) {
        Map<String, ? extends com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.a> r101 = null;
        if (r100 != null) goto L5;
        Map<String, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.c> r102 = null;
    L6:
        if (r100 == null) goto L11;
        List<a1> r103 = r100.getBattleScorePairList();
        if (r103 == null) goto L11;
        r101 = new com.bytedance.android.live.revlink.impl.multianchor.pk.d(com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.a.c.f94280b, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.a.b.f94279b, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.a.C1456a.f94278b).a(r103);
    L11:
        d r104 = new d();
        r104.f94297a = r102;
        r104.f94298b = r101;
        return r104;
    L5:
        r102 = a(r100.getBattleScorePairList());
        goto L6
    }
}
