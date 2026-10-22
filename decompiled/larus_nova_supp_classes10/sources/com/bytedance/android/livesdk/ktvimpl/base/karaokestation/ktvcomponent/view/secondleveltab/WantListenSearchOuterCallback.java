package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.ItemExposureCheckHelper;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.t;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CommonSongListView;
import com.bytedance.android.live.ktv.common.ordersong.view.DialogLoadingView;
import com.bytedance.android.live.ktv.common.search.view.q;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class WantListenSearchOuterCallback implements q {
    public final Map<Long, Boolean> a;
    public final Lazy b;
    public final com.bytedance.android.live.ktv.common.search.viewmodel.a c;
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b d;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d e;
    public final Function0<Unit> f;

    public final String a() {
        return null;
    }

    public final Function1<MultiTypeAdapter, Unit> b() {
        return null;
    }

    public final boolean f() {
        return true;
    }

    public final void onSearchEnter() {
    }

    public final void onSearchReset() {
    }

    public final me.drakeet.multitype.b<MusicPanel, RecyclerView.ViewHolder> g() {
        return new f(new i(this.c, this.d, this.e));
    }

    public final void onSearchExit() {
        ((LinkedHashMap) this.a).clear();
        this.f.invoke();
    }

    public final com.bytedance.android.live.ktv.common.search.viewmodel.a e() {
        return this.c;
    }

    public final void c(CommonSongListView r7) {
        ((LinkedHashMap) this.a).clear();
        ((ItemExposureCheckHelper) this.b.getValue()).b(r7, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.search.a(this.a, FirstLevelTab.WantListenTab, this.c, this.e));
    }

    public final Function1<t, Unit> d(final DialogLoadingView r2) {
        return new WantListenSearchOuterCallback$getHandleLoadMoreAction$1(this, r2);
    }

    public WantListenSearchOuterCallback(com.bytedance.android.live.ktv.common.search.viewmodel.a r2, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "exitSearchCallback");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.a = new LinkedHashMap();
        this.b = LazyKt.lazy(WantListenSearchOuterCallback$itemExposureCheckHelper$2.INSTANCE);
    }
}
