package com.bytedance.android.livesdk.ktvimpl.realtimechorus.dialog;

import android.content.Context;
import com.bytedance.android.live.ktv.common.karaokestation.model.OrderSongRequiredConfig;
import com.bytedance.android.live.ktv.common.karaokestation.model.u;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/dialog/RTChorusFirstLevelTabManager;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseFirstLevelTabManager;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RTChorusFirstLevelTabManager extends BaseFirstLevelTabManager {
    public static final /* synthetic */ int r = 0;
    public final LiveKtvFirstLevelTabConfigData p;
    public Function0<Unit> q;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final LiveKtvFirstLevelTabConfigData m() {
        return this.p;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final com.bytedance.android.live.ktv.common.karaokestation.model.a b(Function0<Unit> r25) {
        this.q = r25;
        return new com.bytedance.android.live.ktv.common.karaokestation.model.a(new OrderSongRequiredConfig(this.k, h(), i(), f()), new u(t(), x(), w(), z(), j(), y(), r(), null, false, null, new RTChorusFirstLevelTabManager$updateOrderSongDialogTopAreaAction$1(this), null, null, null, null, 63360));
    }

    public RTChorusFirstLevelTabManager(Integer r1, String r2, Context r3, b r4, com.bytedance.android.live.ktv.common.search.viewmodel.a r5, d r6, com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r7) {
        super(r1, r2, r3, r4, r5, r6, r7);
        List r8 = h.n().getLiveKtvFirstLevelTabConfig();
        LiveKtvFirstLevelTabConfigData r9 = null;
        Object r10 = null;
        if (r8 == null) goto L11;
        Iterator r11 = r8.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((LiveKtvFirstLevelTabConfigData) r12).getModeType(), ModeType.KTV_MODE.getValue()) == false) goto L6;
        r10 = r12;
    L10:
        r9 = (LiveKtvFirstLevelTabConfigData) r10;
    L11:
        this.p = r9;
        this.q = RTChorusFirstLevelTabManager$dismissDialogAction$1.INSTANCE;
    }
}
