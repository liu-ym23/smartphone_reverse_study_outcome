package com.bytedance.android.shopping.store.home;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.store.utils.playable.PlayAbleType;
import com.bytedance.android.ec.store.utils.playable.controller.RestrictMarginAreaProcessor;
import com.bytedance.android.ec.store.utils.playable.controller.playcontrol.PlayControlStrategy;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r {
    public RecyclerView a;
    public final Lazy b;
    public final Rect c;
    public final ECShopRecyclerItemController$scrollListener$1 d;
    public final com.bytedance.android.ec.store.utils.playable.controller.a e;
    public final ln.d f;
    public final RestrictMarginAreaProcessor g;
    public final PlayControlStrategy h;

    public final void a() {
        RecyclerView r0 = this.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getScrollState() == 0) goto L8;
        return;
    L8:
        List r1 = CollectionsKt.toMutableList(this.f.a(this.g));
        if (Intrinsics.areEqual(r1, this.e.a()) == false) goto L50;
        List r2 = r1;
        boolean r3 = r2 instanceof Collection;
        boolean r4 = true;
        if (r3 == true) goto L13;
    L15:
        Iterator r6 = r2.iterator();
    L17:
        if (r6.hasNext() == false) goto L26;
        ln.c r7 = (ln.c) r6.next();
        if (r7.P() == PlayAbleType.MAIN_IMAGE) goto L21;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == false) goto L17;
        boolean r9 = true;
    L27:
        if (r9 == true) goto L47;
        if (r3 == true) goto L30;
    L32:
        Iterator r5 = r2.iterator();
    L34:
        if (r5.hasNext() == false) goto L43;
        ln.c r10 = (ln.c) r5.next();
        if (r10.P() == PlayAbleType.VIDEO) goto L38;
    L40:
        boolean r11 = false;
    L41:
        if (r11 == false) goto L34;
        boolean r12 = true;
    L44:
        if (r12 == true) goto L47;
        r4 = false;
        goto L47
    L38:
        if (r10.isPlaying() == false) goto L40;
        r11 = true;
    L43:
        r12 = false;
        goto L44
    L30:
        if (r2.isEmpty() == false) goto L32;
    L47:
        if (r4 == false) goto L50;
        dm.a.a("测试播放范围").a("可播放个数:" + r1.size() + ",由于播放内容没变,且目前有卡在播,return");
        return;
    L21:
        if (r7.isPlaying() == false) goto L23;
        r8 = true;
    L26:
        r9 = false;
        goto L27
    L13:
        if (r2.isEmpty() == false) goto L15;
    L50:
        r0.getGlobalVisibleRect(this.c);
        RestrictMarginAreaProcessor r13 = this.g;
        if (r13 == null) goto L53;
        r13.a(this.c);
    L53:
        ((mn.d) this.b.getValue()).d(r1, this.e, this.c);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.shopping.store.home.ECShopRecyclerItemController$scrollListener$1] */
    public r(nn.e r2, on.b r3, RestrictMarginAreaProcessor r4, PlayControlStrategy r5) {
        Intrinsics.checkNotNullParameter(r2, "mgr");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r5, "playControlStrategy");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.b = LazyKt.lazy(new ECShopRecyclerItemController$playController$2(this));
        this.c = new Rect();
        this.d = new ECShopRecyclerItemController$scrollListener$1(this);
    }
}
