package sy3;

import com.bytedance.awemeopen.apps.framework.comment.view.holder.BaseCommentViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.bytedance.awemeopen.search.serviceapi.AoSearchService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class a implements MentionTextView.e {
    public final /* synthetic */ BaseCommentViewHolder a;

    public /* synthetic */ a(BaseCommentViewHolder r1) {
        this.a = r1;
    }

    public final void a(TextExtraStruct r6) {
        BaseCommentViewHolder r0 = this.a;
        int r1 = BaseCommentViewHolder.B;
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r6 == null) goto L23;
        boolean r2 = false;
        if (r6.getType() != 5) goto L15;
        AoSearchService r7 = j64.a.a(AoSearchService.class);
        if (r7 != null) goto L10;
    L12:
        if (r2 == false) goto L21;
        r0.b.getClass();
        return;
    L21:
        return;
    L10:
        if (r7.isAvailable() != true) goto L12;
        r2 = true;
        goto L12
    L15:
        if (com.bytedance.awemeopen.apps.framework.launchconfig.a.a == null) goto L17;
        r2 = true;
    L17:
        if (r2 == false) goto L24;
        r0.V3(r6.getUserId());
        return;
    L24:
        return;
    }
}
