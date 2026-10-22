package com.larus.community.impl.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/community/impl/viewholder/CreationAvatarEntranceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/platform/api/creation/ICreationFeedViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarDesc", "Landroid/widget/TextView;", "avatarCreateDesc", "avatarDescMask", "avatarCreateStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "bindData", "", "itemWidth", "initView", "createDigitalAvatar", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationAvatarEntranceViewHolder extends RecyclerView.ViewHolder implements zp9.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f329945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f329946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f329947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f329948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z0<Integer> f329949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LifecycleCoroutineScope f329950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zp9.f f329951g;

    public static final class a {
    }

    static {
    }

    @Override // zp9.q
    public final void onViewRecycled() {
    }

    public CreationAvatarEntranceViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f329945a = (SimpleDraweeView) r100.findViewById(R.id.item_image);
        this.f329946b = (TextView) r100.findViewById(R.id.avatar_desc);
        this.f329947c = (TextView) r100.findViewById(R.id.avatar_create_desc);
        this.f329948d = r100.findViewById(R.id.avatar_desc_mask);
        ICreationPageService r101 = (ICreationPageService) ServiceManager.get().getService(ICreationPageService.class);
        if (r101 == null) goto L5;
        StateFlowImpl r102 = r101.e();
    L6:
        this.f329949e = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void T3(int r100, LifecycleCoroutineScope r110, zp9.f r111) {
        Intrinsics.checkNotNullParameter(r110, "lifecycleScope");
        SimpleDraweeView r101 = this.f329945a;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = r100;
        r101.setLayoutParams(r102);
        this.f329950f = r110;
        this.f329951g = r111;
        if (r110 == null) goto L6;
        BuildersKt.launch$default(r110, null, null, new CreationAvatarEntranceViewHolder$initView$1(this, null), 3, null);
        return;
    }
}
