package com.larus.community.impl.detail.header;

import android.view.View;
import android.view.ViewGroup;
import com.larus.community.impl.detail.image.CreationDetailImageView;
import com.larus.community.impl.detail.image.d;
import com.larus.community.impl.detail.prompt.CreationDetailPromptView;
import com.larus.community.impl.detail.prompt.a;
import com.larus.community.impl.detail.video.CreationDetailVideoView;
import com.larus.nova.R;
import com.larus.platform.model.comment.api.AbsCustomCommentHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/community/impl/detail/header/CreationDetailCommentViewHolder;", "Lcom/larus/platform/model/comment/api/AbsCustomCommentHolder;", "creationDetailImageAbility", "Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;", "creationDetailPromptAbility", "Lcom/larus/community/impl/detail/prompt/CreationDetailPromptAbility;", "creationDetailFullImageAbility", "Lcom/larus/community/impl/detail/image/CreationDetailFullImageAbility;", "creationDetailVideoAbility", "Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;", "creationDetailCommentAbility", "Lcom/larus/community/impl/detail/comment/CreationDetailCommentAbility;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;Lcom/larus/community/impl/detail/prompt/CreationDetailPromptAbility;Lcom/larus/community/impl/detail/image/CreationDetailFullImageAbility;Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;Lcom/larus/community/impl/detail/comment/CreationDetailCommentAbility;Landroid/view/View;)V", "onBindViewHolder", "", "position", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailCommentViewHolder extends AbsCustomCommentHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f329268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f329269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.community.impl.detail.image.a f329270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.community.impl.detail.video.a f329271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.community.impl.detail.comment.a f329272e;

    @Override // com.larus.platform.model.comment.api.AbsCustomCommentHolder
    public final void T3() {
        a r100 = this.f329269b;
        if (r100 == null) goto L5;
        r100.ut((CreationDetailPromptView) this.itemView.findViewById(R.id.creation_detail_prompt_view));
    L5:
        d r101 = this.f329268a;
        if (r101 == null) goto L8;
        r101.P9((CreationDetailImageView) this.itemView.findViewById(R.id.creation_detail_image_view));
    L8:
        com.larus.community.impl.detail.image.a r102 = this.f329270c;
        if (r102 == null) goto L11;
        r102.P9((CreationDetailImageView) this.itemView.findViewById(R.id.creation_detail_image_view));
    L11:
        com.larus.community.impl.detail.video.a r103 = this.f329271d;
        if (r103 == null) goto L14;
        r103.jG((CreationDetailVideoView) this.itemView.findViewById(R.id.creation_detail_video_view));
    L14:
        com.larus.community.impl.detail.comment.a r104 = this.f329272e;
        if (r104 == null) goto L18;
        r104.s30((ViewGroup) this.itemView.findViewById(R.id.creation_detail_header_layout));
        return;
    }

    public CreationDetailCommentViewHolder(d r100, a r101, com.larus.community.impl.detail.image.a r102, com.larus.community.impl.detail.video.a r103, com.larus.community.impl.detail.comment.a r104, View r105) {
        Intrinsics.checkNotNullParameter(r105, "itemView");
        super(r105);
        this.f329268a = r100;
        this.f329269b = r101;
        this.f329270c = r102;
        this.f329271d = r103;
        this.f329272e = r104;
    }
}
