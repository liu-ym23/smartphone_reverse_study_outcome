package sp0;

import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.livesdk.message.model.qh;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends ro0.b<qh> {
    @Override // ro0.b
    public final MessageType a() {
        return MessageType.OPEN_PLATFORM_LIVE_BIND_MICRO_APP_MESSAGE;
    }

    public a(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
    }

    @Override // ro0.b
    public final void b(d r100) {
        qh r101 = (qh) r100;
        Intrinsics.checkNotNullParameter(r101, "message");
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r102 = AnchorMiniAppDataContext.a.a();
        if (r102 == null) goto L8;
        m<Boolean> r103 = r102.getMicroAppMountPunishing();
        if (r103 == null) goto L9;
        r103.setValue(Boolean.valueOf(!r101.canBind));
        return;
    L9:
        return;
    }
}
