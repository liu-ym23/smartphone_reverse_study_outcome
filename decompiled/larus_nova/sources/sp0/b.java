package sp0;

import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.livesdk.message.model.pf;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.live.datacontext.n;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends ro0.b<pf> {
    @Override // ro0.b
    public final MessageType a() {
        return MessageType.LIVE_MOUNT_MICRO_APP_LIMIT_DATA_MESSAGE;
    }

    public b(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
    }

    @Override // ro0.b
    public final void b(d r100) {
        pf r101 = (pf) r100;
        Intrinsics.checkNotNullParameter(r101, "message");
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r102 = AnchorMiniAppDataContext.a.a();
        if (r102 == null) goto L8;
        n<pf.a> r103 = r102.getMicroAppLiveMountLimitData();
        if (r103 == null) goto L9;
        r103.setValue(r101.data);
        return;
    L9:
        return;
    }
}
