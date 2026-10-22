package dq2;

import android.graphics.PointF;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.MultiLinkScriptInfo;
import com.bytedance.android.livesdk.revenue.interact.animation.ScriptInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class o extends com.bytedance.android.livesdk.revenue.util.b<tf0.h> implements d {
    @Override // dq2.d
    public final boolean a() {
        return ((tf0.h) this.f157529a).a();
    }

    @Override // dq2.d
    public final boolean c() {
        return ((tf0.h) this.f157529a).c();
    }

    public o(tf0.h r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        super(r100);
    }

    @Override // dq2.d
    public final PointF d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return ((tf0.h) this.f157529a).d(r100);
    }

    @Override // dq2.d
    public final void h(eq2.a r210, eq2.c r211, eq2.d r310, String r311, ScriptInfo r312, eq2.e r313) {
        Intrinsics.checkNotNullParameter(r211, "giftInfo");
        Intrinsics.checkNotNullParameter(r313, "positionInfo");
        tf0.h r100 = (tf0.h) this.f157529a;
        n r101 = new n(r210);
        Intrinsics.checkNotNullParameter(r211, "$this$toOriginType");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r212 = new com.bytedance.android.live.liveinteract.videotalk.emoji.model.c(r211.f473459a, r211.f473460b, r211.f473461c, r211.f473462d, r211.f473463e, r211.f473464f, r211.f473465g, r211.f473466h, r211.f473467i, r211.f473468j, r211.f473469k, r211.f473470l, r211.f473471m);
        MultiLinkScriptInfo r102 = null;
        if (r310 == null) goto L5;
        String r103 = "$this$toOriginType";
        Intrinsics.checkNotNullParameter(r310, r103);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r104 = new com.bytedance.android.live.liveinteract.videotalk.emoji.model.n(r310.f473472a, r310.f473473b, r310.f473474c, r310.f473475d, r310.f473476e, r310.f473477f);
    L7:
        if (r312 == null) goto L9;
        Intrinsics.checkNotNullParameter(r312, "$this$toMultiLinkScriptInfo");
        r102 = new MultiLinkScriptInfo(r312.getName(), r312.getDuration(), r312.getScript());
    L9:
        MultiLinkScriptInfo r110 = r102;
        Intrinsics.checkNotNullParameter(r313, r103);
        PointF r105 = r313.f473478a;
        List<String> r106 = r313.f473479b;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L11:
        if (r108.hasNext() == false) goto L13;
        r107.add((String) r108.next());
        goto L11
    L13:
        r100.f(r101, r212, r104, null, r311, r110, new com.bytedance.android.live.liveinteract.videotalk.emoji.model.o(r105, r107, r313.f473480c));
        return;
    L5:
        r103 = "$this$toOriginType";
        r104 = null;
        goto L7
    }
}
