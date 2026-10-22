package d90;

import android.content.Context;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class a extends d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IAbilityCenter f467450j;

    public final RoomContext b() {
        MiddlewareRoomContext r100 = this.f467477e;
        if ((r100 instanceof RoomContext) == true) goto L6;
        r100 = null;
    L6:
        return (RoomContext) r100;
    }

    @Override // d90.d, h70.b
    public IAbilityCenter a() {
        return this.f467450j;
    }

    public a(Context r100, DataCenter r101, AbilityCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "abilityCenter");
        super(r100, r101, r102);
        this.f467450j = r102;
    }
}
