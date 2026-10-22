package com.bytedance.android.livesdk.mergecomponents.context;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livesdk.locallife.LiveLocalLifeDataViewModel;
import com.bytedance.android.livesdkapi.arch.CommonRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.arch.IInjectBusinessContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveLocalLifeInjectContext implements IInjectBusinessContext {
    public final Lazy a;

    public final void injectPreviewBusinessDataCenter(DataCenter r1, Room r2) {
    }

    public LiveLocalLifeInjectContext() {
        this.a = LazyKt.lazy(LiveLocalLifeInjectContext$liveLocalLifeService$2.INSTANCE);
    }

    public final void injectPreviewRoomController(DataCenter r1, Room r2) {
        IInjectBusinessContext.DefaultImpls.injectPreviewRoomController(this, r1, r2);
    }

    public final void injectPreviewBusinessRoomContext(Context r5, CommonRoomContext r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r7 != null) goto L5;
        return;
    L5:
        if ((r5 instanceof FragmentActivity) == false) goto L12;
        IHostLiveLocalLife r8 = (IHostLiveLocalLife) this.a.getValue();
        if (r8 == null) goto L9;
        r8.setLiveActivity((FragmentActivity) r5, z.d(r7, null), true);
    L9:
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of((FragmentActivity) r5).get(LiveLocalLifeDataViewModel.class)).setPreviewData(r7, z.d(r7, null));
        return;
    }
}
