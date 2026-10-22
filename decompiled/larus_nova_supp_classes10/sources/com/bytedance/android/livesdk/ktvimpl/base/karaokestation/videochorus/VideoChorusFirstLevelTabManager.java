package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.videochorus;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.OrderSongRequiredConfig;
import com.bytedance.android.live.ktv.common.karaokestation.model.u;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b;
import com.bytedance.android.livesdk.config.k40;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfig;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfigData;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.live.datacontext.n;
import com.google.android.material.tabs.TabLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/videochorus/VideoChorusFirstLevelTabManager;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseFirstLevelTabManager;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoChorusFirstLevelTabManager extends BaseFirstLevelTabManager {
    public static final /* synthetic */ int q = 0;
    public final LiveKtvFirstLevelTabConfigData p;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final void e() {
        super.e();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final LiveKtvFirstLevelTabConfigData m() {
        return this.p;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final void s() {
        super.s();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final com.bytedance.android.live.ktv.common.karaokestation.model.a b(Function0<Unit> r25) {
        OrderSongRequiredConfig r1 = new OrderSongRequiredConfig(this.k, h(), i(), f());
        Function0<Unit> r8 = t();
        Function3<View, TabLayout, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r9 = x();
        Function0<Unit> r10 = w();
        Function0<Unit> r11 = z();
        Function3<Integer, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> r12 = j();
        Function5<HSImageView, Function0<Unit>, FragmentActivity, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> r14 = r();
        return new com.bytedance.android.live.ktv.common.karaokestation.model.a(r1, new u(r8, r9, r10, r11, r12, y(), r14, Integer.valueOf(s1.f(541.0f)), true, VideoChorusFirstLevelTabManager$initTopControlBarAction$1.INSTANCE, VideoChorusFirstLevelTabManager$updateOrderSongDialogTopAreaAction$1.INSTANCE, null, null, null, null, 61568));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final Pair<Integer, String> k(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "secondLevelTabName");
        String r0 = this.i;
        if (r0 != null) goto L5;
        r0 = r5;
    L5:
        int r1 = FirstLevelTab.OrderSongTab.getValue();
        Integer r2 = this.h;
        if (r2 == null) goto L10;
        if (r2 == null) goto L9;
        r4 = r2.intValue();
    L9:
        r1 = r4;
    L10:
        String r6 = this.i;
        if (r6 == null) goto L16;
        if (r6 == null) goto L15;
        r5 = r6;
    L15:
        r0 = r5;
    L16:
        KtvComponentContext r7 = KtvComponentContext.Companion.getContext();
        if (r7 == null) goto L24;
        n<KtvComponentUIContext> r8 = r7.getKtvComponentUIContext();
        if (r8 == null) goto L24;
        KtvComponentUIContext r9 = (KtvComponentUIContext) r8.getValue();
        if (r9 == null) goto L24;
        r9.setLastApplyMsgType(null);
    L24:
        return new Pair(Integer.valueOf(r1), r0);
    }

    public VideoChorusFirstLevelTabManager(Integer r1, String r2, Context r3, b r4, com.bytedance.android.live.ktv.common.search.viewmodel.a r5, d r6, com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r7) {
        super(r1, r2, r3, r4, r5, r6, r7);
        LiveKtvFirstLevelTabConfig r8 = (LiveKtvFirstLevelTabConfig) k40.a.getValue();
        LiveKtvFirstLevelTabConfigData r9 = null;
        Object r10 = null;
        r9 = null;
        if (r8 == null) goto L13;
        List r11 = r8.getLiveKtvFirstLevelTabConfig();
        if (r11 == null) goto L13;
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((LiveKtvFirstLevelTabConfigData) r13).getModeType(), ModeType.VIDEO_CHORUS.getValue()) == false) goto L8;
        r10 = r13;
    L12:
        r9 = (LiveKtvFirstLevelTabConfigData) r10;
    L13:
        this.p = r9;
    }
}
