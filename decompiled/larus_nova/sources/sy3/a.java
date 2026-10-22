package sy3;

import com.bytedance.awemeopen.apps.framework.comment.view.holder.BaseCommentViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.bytedance.awemeopen.search.serviceapi.AoSearchService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class a implements MentionTextView.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseCommentViewHolder f543867a;

    public /* synthetic */ a(BaseCommentViewHolder r100) {
        this.f543867a = r100;
    }

    public final void a(TextExtraStruct r100) {
        BaseCommentViewHolder r101 = this.f543867a;
        int r102 = BaseCommentViewHolder.B;
        Intrinsics.checkNotNullParameter(r101, "this$0");
        if (r100 == null) goto L23;
        boolean r103 = false;
        if (r100.getType() != 5) goto L15;
        AoSearchService r104 = (AoSearchService) j64.a.a(AoSearchService.class);
        if (r104 != null) goto L10;
    L12:
        if (r103 == false) goto L21;
        r101.f194272b.getClass();
        return;
    L21:
        return;
    L10:
        if (r104.isAvailable() != true) goto L12;
        r103 = true;
        goto L12
    L15:
        if (com.bytedance.awemeopen.apps.framework.launchconfig.a.f197224a == null) goto L17;
        r103 = true;
    L17:
        if (r103 == false) goto L24;
        r101.V3(r100.getUserId());
        return;
    L24:
        return;
    }
}
