package com.larus.community.impl.detail.header;

import android.view.View;
import com.larus.community.impl.detail.image.CreationDetailImageView;
import com.larus.community.impl.detail.image.d;
import com.larus.community.impl.detail.prompt.CreationDetailPromptView;
import com.larus.community.impl.detail.prompt.a;
import com.larus.community.impl.detail.video.CreationDetailVideoView;
import com.larus.nova.R;
import com.larus.platform.api.creation.AbsCreationFeedHeaderViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/community/impl/detail/header/CreationDetailHeadInspirationViewHolder;", "Lcom/larus/platform/api/creation/AbsCreationFeedHeaderViewHolder;", "creationDetailImageAbility", "Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;", "creationDetailPromptAbility", "Lcom/larus/community/impl/detail/prompt/CreationDetailPromptAbility;", "creationDetailFullImageAbility", "Lcom/larus/community/impl/detail/image/CreationDetailFullImageAbility;", "creationDetailVideoAbility", "Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;Lcom/larus/community/impl/detail/prompt/CreationDetailPromptAbility;Lcom/larus/community/impl/detail/image/CreationDetailFullImageAbility;Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;Landroid/view/View;)V", "onBindViewHolder", "", "position", "", "onViewRecycled", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailHeadInspirationViewHolder extends AbsCreationFeedHeaderViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f329273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f329274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.community.impl.detail.image.a f329275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.community.impl.detail.video.a f329276d;

    @Override // zp9.q
    public final void onViewRecycled() {
    }

    @Override // com.larus.platform.api.creation.AbsCreationFeedHeaderViewHolder
    public final void T3() {
        a r100 = this.f329274b;
        if (r100 == null) goto L5;
        r100.ut((CreationDetailPromptView) this.itemView.findViewById(R.id.creation_detail_prompt_view));
    L5:
        d r101 = this.f329273a;
        if (r101 == null) goto L8;
        r101.P9((CreationDetailImageView) this.itemView.findViewById(R.id.creation_detail_image_view));
    L8:
        com.larus.community.impl.detail.image.a r102 = this.f329275c;
        if (r102 == null) goto L11;
        r102.P9((CreationDetailImageView) this.itemView.findViewById(R.id.creation_detail_image_view));
    L11:
        com.larus.community.impl.detail.video.a r103 = this.f329276d;
        if (r103 == null) goto L15;
        r103.jG((CreationDetailVideoView) this.itemView.findViewById(R.id.creation_detail_video_view));
        return;
    }

    public CreationDetailHeadInspirationViewHolder(d r100, a r101, com.larus.community.impl.detail.image.a r102, com.larus.community.impl.detail.video.a r103, View r104) {
        Intrinsics.checkNotNullParameter(r104, "itemView");
        super(r104);
        this.f329273a = r100;
        this.f329274b = r101;
        this.f329275c = r102;
        this.f329276d = r103;
    }
}
