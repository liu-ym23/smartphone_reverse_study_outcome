package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.search;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.ItemExposureCheckHelper;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.t;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CommonSongListView;
import com.bytedance.android.live.ktv.common.ordersong.view.DialogLoadingView;
import com.bytedance.android.live.ktv.common.search.view.q;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.model.ModeType;
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
public final class SearchOuterCallback implements q {
    public final Map<Long, Boolean> a;
    public final Lazy b;
    public final com.bytedance.android.live.ktv.common.search.viewmodel.a c;
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b d;
    public final d e;
    public final Function0<Unit> f;

    public final String a() {
        d r0 = this.e;
        if (r0 == null) goto L5;
        ModeType r1 = r0.getModeType();
    L7:
        if (r1 != ModeType.MUSIC_EFFECT) goto L10;
        return "music_effect";
    L10:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean f() {
        d r0 = this.e;
        if (r0 == null) goto L5;
        ModeType r1 = r0.getModeType();
    L7:
        if (r1 == ModeType.MUSIC_EFFECT) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final me.drakeet.multitype.b<MusicPanel, RecyclerView.ViewHolder> g() {
        return new b(new c(this.c, this.d, this.e));
    }

    public final void onSearchEnter() {
        d r0 = this.e;
        if (r0 == null) goto L6;
        r0.onSearchEnter();
        return;
    }

    public final void onSearchExit() {
        ((LinkedHashMap) this.a).clear();
        this.f.invoke();
        d r0 = this.e;
        if (r0 == null) goto L6;
        r0.onSearchExit();
        return;
    }

    public final void onSearchReset() {
        d r0 = this.e;
        if (r0 == null) goto L6;
        r0.onSearchReset();
        return;
    }

    public final Function1<MultiTypeAdapter, Unit> b() {
        return SearchOuterCallback$getCustomItemViewBinderAction$1.INSTANCE;
    }

    public final com.bytedance.android.live.ktv.common.search.viewmodel.a e() {
        return this.c;
    }

    public final void c(CommonSongListView r7) {
        ((LinkedHashMap) this.a).clear();
        ((ItemExposureCheckHelper) this.b.getValue()).b(r7, new a(this.a, FirstLevelTab.OrderSongTab, this.c, this.e));
    }

    public final Function1<t, Unit> d(final DialogLoadingView r2) {
        return new SearchOuterCallback$getHandleLoadMoreAction$1(this, r2);
    }

    public SearchOuterCallback(com.bytedance.android.live.ktv.common.search.viewmodel.a r2, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3, d r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "exitSearchCallback");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.a = new LinkedHashMap();
        this.b = LazyKt.lazy(SearchOuterCallback$itemExposureCheckHelper$2.INSTANCE);
    }
}
