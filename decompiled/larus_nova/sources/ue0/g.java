package ue0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.feed.datamerge.k;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.service.MessageHub;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: classes46.dex */
public final class g extends com.bytedance.android.live.liveinteract.feed.datamerge.a implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IRoom f549789b;

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
        ALogger.i("RadioStageContainerWidget", "MultiLinkFeedViewRadioGiftMessageHandler atatch:" + c().getShowFrom());
        int r100 = com.bytedance.android.live.liveinteract.voicechat.radio.e.f80544a;
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(c().getShowFrom()) == false) goto L14;
        k r101 = this.f72943a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L7:
        MessageHub r102 = r101.getMessageHub();
        if ((r102 instanceof xlc.a) == true) goto L10;
        r102 = null;
    L10:
        xlc.a r103 = (xlc.a) r102;
        if (r103 == null) goto L15;
        r103.D(MessageType.GIFT_COMMENT_MESSAGE.getIntType(), this, "MetaSubSyncKey");
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
        k r100 = this.f72943a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        MessageHub r101 = r100.getMessageHub();
        if (r101 == null) goto L9;
        r101.removeMessageListener(MessageType.GIFT_COMMENT_MESSAGE.getIntType(), this);
        return;
    }

    public g(IRoom r100) {
        this.f549789b = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.a
    public final void d(k r100) {
        Intrinsics.checkNotNullParameter(r100, "proxy");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f72943a = r100;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        ALogger.i("RadioStageContainerWidget", "MultiLinkFeedViewRadioGiftMessageHandler onMessage:" + r100);
        if ((r100 instanceof cj) == false) goto L6;
        c().q((cj) r100);
        return;
    }
}
