package com.larus.uaigc.avatar.instruction;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorHolderCallback;", "<init>", "(Landroid/view/View;Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorHolderCallback;)V", "getItemView", "()Landroid/view/View;", "getCallback", "()Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorHolderCallback;", "img", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imgTemplateCreateView", "Landroid/widget/TextView;", "imgTemplateCreateContainer", "Landroid/widget/FrameLayout;", "imgRetryView", "Landroid/widget/ImageView;", "bindData", "", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarDigitalAvatarTemplateItem;", "loadImage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DigitalAvatarSelectorHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f370291g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f370292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f370293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f370294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f370295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f370296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f370297f;

    public DigitalAvatarSelectorHolder(View r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f370292a = r100;
        this.f370293b = r101;
        this.f370294c = (SimpleDraweeView) r100.findViewById(R.id.image_template_cover);
        this.f370295d = (TextView) r100.findViewById(R.id.image_template_create_view);
        this.f370296e = (FrameLayout) r100.findViewById(R.id.image_template_create_container);
        this.f370297f = (ImageView) r100.findViewById(R.id.retry_icon);
    }
}
