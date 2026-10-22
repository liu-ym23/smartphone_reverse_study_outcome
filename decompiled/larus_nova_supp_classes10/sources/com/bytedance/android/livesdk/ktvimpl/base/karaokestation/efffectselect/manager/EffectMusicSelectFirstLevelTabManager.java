package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.efffectselect.manager;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.karaokestation.model.OrderSongRequiredConfig;
import com.bytedance.android.live.ktv.common.karaokestation.model.u;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfig;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfigData;
import com.bytedance.android.livesdkapi.model.ModeType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/efffectselect/manager/EffectMusicSelectFirstLevelTabManager;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseFirstLevelTabManager;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EffectMusicSelectFirstLevelTabManager extends BaseFirstLevelTabManager {
    public static final /* synthetic */ int q = 0;
    public final LiveKtvFirstLevelTabConfigData p;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final void s() {
        throw null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final LiveKtvFirstLevelTabConfigData m() {
        return this.p;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final com.bytedance.android.live.ktv.common.karaokestation.model.a b(Function0<Unit> r25) {
        return new com.bytedance.android.live.ktv.common.karaokestation.model.a(new OrderSongRequiredConfig(this.k, h(), i(), f()), new u(null, null, w(), null, null, null, null, Integer.valueOf(s1.f(541.0f)), false, null, null, EffectMusicSelectFirstLevelTabManager$createCommonOrderSongConfig$1.INSTANCE, EffectMusicSelectFirstLevelTabManager$createCommonOrderSongConfig$2.INSTANCE, EffectMusicSelectFirstLevelTabManager$createCommonOrderSongConfig$3.INSTANCE, new EffectMusicSelectFirstLevelTabManager$createCommonOrderSongConfig$4(this), 3835));
    }

    public EffectMusicSelectFirstLevelTabManager(Integer r9, Context r10, b r11, com.bytedance.android.live.ktv.common.search.viewmodel.a r12, d r13, com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r14) {
        super(r9, "recommend", r10, r11, r12, r13, r14);
        LiveKtvFirstLevelTabConfig r15 = h.n();
        LiveKtvFirstLevelTabConfigData r16 = null;
        Object r17 = null;
        r16 = null;
        if (r15 == null) goto L13;
        List r18 = r15.getLiveKtvFirstLevelTabConfig();
        if (r18 == null) goto L13;
        Iterator r19 = r18.iterator();
    L8:
        if (r19.hasNext() == false) goto L12;
        Object r110 = r19.next();
        if (Intrinsics.areEqual(((LiveKtvFirstLevelTabConfigData) r110).getModeType(), ModeType.MUSIC_EFFECT.getValue()) == false) goto L8;
        r17 = r110;
    L12:
        r16 = (LiveKtvFirstLevelTabConfigData) r17;
    L13:
        this.p = r16;
    }
}
