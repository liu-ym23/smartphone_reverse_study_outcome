package zc2;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetStickerInfoResultModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.v2;
import com.bytedance.android.livesdk.chatroom.viewmodule.w2;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w20.ta;
import w20.x2;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends x2<ta, LiveGetStickerInfoResultModel> {
    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        ta r102 = (ta) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        w2 r103 = v2.a();
        String r104 = r102.a();
        if (r104 == null) goto L7;
        Long r105 = StringsKt.toLongOrNull(r104);
        if (r105 == null) goto L7;
        long r106 = r105.longValue();
    L9:
        if (r106 == (-1)) goto L17;
        if (r103 == null) goto L17;
        int r107 = r103.wm(r106);
        LiveGetStickerInfoResultModel r108 = new LiveGetStickerInfoResultModel();
        r108.a(LiveGetStickerInfoResultModel.Code.Success);
        boolean r109 = true;
        if (r107 == 1) goto L16;
        r109 = false;
    L16:
        r108.b(Boolean.valueOf(r109));
        Unit r110 = Unit.INSTANCE;
        finishWithResult(r108);
        return;
    L17:
        LiveGetStickerInfoResultModel r111 = new LiveGetStickerInfoResultModel();
        r111.a(LiveGetStickerInfoResultModel.Code.Failed);
        r111.b(Boolean.FALSE);
        Unit r112 = Unit.INSTANCE;
        finishWithResult(r111);
        return;
    L7:
        r106 = -1;
        goto L9
    }
}
