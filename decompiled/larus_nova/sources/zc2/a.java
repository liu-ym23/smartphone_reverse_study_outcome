package zc2;

import com.bytedance.android.live.browser.jsbridge.base.LiveAddStickerResultModel;
import com.bytedance.android.livesdk.chatroom.model.e3;
import com.bytedance.android.livesdk.chatroom.viewmodule.v2;
import com.bytedance.android.livesdk.chatroom.viewmodule.w2;
import com.bytedance.android.livesdk.config.bi1;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w20.ga;
import w20.h2;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends h2<ga, LiveAddStickerResultModel> {
    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        ga r102 = (ga) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        w2 r103 = v2.a();
        if (r103 == null) goto L5;
        e3 r104 = r103.Qn();
    L6:
        if (r104 != null) goto L8;
        LiveAddStickerResultModel.Code r105 = LiveAddStickerResultModel.Code.FetchStickerListFail;
        LiveAddStickerResultModel r106 = new LiveAddStickerResultModel();
        r106.a(r105);
        Unit r107 = Unit.INSTANCE;
        finishWithResult(r106);
        return;
    L8:
        String r108 = r102.a();
        if (r108 == null) goto L13;
        Long r109 = StringsKt.toLongOrNull(r108);
        if (r109 == null) goto L13;
        long r110 = r109.longValue();
    L15:
        if (r110 != (-1)) goto L17;
    L23:
        LiveAddStickerResultModel.Code r111 = LiveAddStickerResultModel.Code.NotFoundSticker;
        LiveAddStickerResultModel r112 = new LiveAddStickerResultModel();
        r112.a(r111);
        Unit r113 = Unit.INSTANCE;
        finishWithResult(r112);
        return;
    L17:
        if (r104.a(r110) == null) goto L23;
        boolean r114 = r103.Z5(r110);
        LiveAddStickerResultModel r115 = new LiveAddStickerResultModel();
        Object r116 = bi1.a(Boolean.valueOf(r114), LiveAddStickerResultModel.Code.Success);
        LiveAddStickerResultModel.Code r117 = LiveAddStickerResultModel.Code.CanNotOperateSticker;
        if (r116 != null) goto L22;
        r116 = r117;
    L22:
        r115.a((LiveAddStickerResultModel.Code) r116);
        Unit r118 = Unit.INSTANCE;
        finishWithResult(r115);
        return;
    L13:
        r110 = -1;
        goto L15
    L5:
        r104 = null;
        goto L6
    }
}
