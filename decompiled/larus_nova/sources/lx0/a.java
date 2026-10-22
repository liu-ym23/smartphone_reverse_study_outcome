package lx0;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.record.LiveScreenRecordPublishGuideDialog;
import com.bytedance.android.live.room.api.record.guide.PublishDialogInfo;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements IMiddlewareHostBusiness.OnLiveHighlightPublish {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveScreenRecordPublishGuideDialog f511105a;

    public a(LiveScreenRecordPublishGuideDialog r100) {
        this.f511105a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.OnLiveHighlightPublish
    public final void onPublish(int r100) {
        if (r100 != 1) goto L6;
        f2.c("发布失败", 0);
    L6:
        LiveScreenRecordPublishGuideDialog r101 = this.f511105a;
        int r102 = LiveScreenRecordPublishGuideDialog.G;
        r101.W0(false);
        PublishDialogInfo r103 = this.f511105a.F;
        if (r103.f99105a == false) goto L10;
        int r104 = z22.c.f569779a;
        z22.c.b(r103.f99111g);
        return;
    }
}
