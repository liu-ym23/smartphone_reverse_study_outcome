package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.manager;

import android.content.Context;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfig;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfigData;
import com.bytedance.android.livesdkapi.model.ModeType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/manager/KtvModeFirstLevelTabManager;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseFirstLevelTabManager;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvModeFirstLevelTabManager extends BaseFirstLevelTabManager {
    public static final /* synthetic */ int q = 0;
    public final LiveKtvFirstLevelTabConfigData p;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseFirstLevelTabManager
    public final LiveKtvFirstLevelTabConfigData m() {
        return this.p;
    }

    public KtvModeFirstLevelTabManager(Integer r1, String r2, Context r3, b r4, com.bytedance.android.live.ktv.common.search.viewmodel.a r5, d r6, com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r7) {
        super(r1, r2, r3, r4, r5, r6, r7);
        LiveKtvFirstLevelTabConfig r8 = h.n();
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
        if (Intrinsics.areEqual(((LiveKtvFirstLevelTabConfigData) r13).getModeType(), ModeType.KTV_MODE.getValue()) == false) goto L8;
        r10 = r13;
    L12:
        r9 = (LiveKtvFirstLevelTabConfigData) r10;
    L13:
        this.p = r9;
    }
}
