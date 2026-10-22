package com.larus.contextwindow.impl.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w29.g;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/contextwindow/impl/actionbar/ContextWindowActionBarHolder;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "<init>", "(Landroid/view/View;Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;)V", "icon", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "usageIconDrawable", "Landroid/graphics/drawable/Drawable;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowActionBarHolder extends BaseActionBarHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f330278e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1 f330279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f330280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f330281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f330282d;

    public ContextWindowActionBarHolder(View r100, t1 r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f330279a = r101;
        this.f330280b = (ImageView) r100.findViewById(R.id.context_window_icon);
        this.f330281c = (TextView) r100.findViewById(R.id.context_window_title);
        g r102 = g.f558053a;
        Context r103 = r100.getContext();
        r102.getClass();
        this.f330282d = g.a(r103);
    }
}
