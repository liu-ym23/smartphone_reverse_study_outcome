package com.larus.uaigc.instruction.widget;

import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsConstants;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import vz9.c;
import vz9.d;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020\u001fJ\u0006\u0010(\u001a\u00020\u001fJ\u0006\u0010)\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/uaigc/instruction/widget/ImageSelectorHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;", "disableGifAnim", "", "<init>", "(Landroid/view/View;Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;Z)V", "getItemView", "()Landroid/view/View;", "getCallback", "()Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;", "getDisableGifAnim", "()Z", "img", "Lcom/facebook/drawee/view/SimpleDraweeView;", "title", "Landroid/widget/TextView;", "selectedIcon", "Landroid/widget/ImageView;", "selectedColor", "", "selectedRoundParams", "Lcom/facebook/drawee/generic/RoundingParams;", "kotlin.jvm.PlatformType", "unSelectedRoundParams", "animatable", "Landroid/graphics/drawable/Animatable;", "bindData", "", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "bindPayload", WsConstants.KEY_PAYLOAD, "Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter$ChangePayload$Status;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "startGifAnim", "stopGifAnim", "isFullyVisible", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageSelectorHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f373438h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f373439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f373440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f373441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f373442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f373443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f373444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animatable f373445g;

    public static final class a extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageSelectorHolder f373446a;

        public a(ImageSelectorHolder r100) {
            this.f373446a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            super.onFailure(r100, r101);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            super.onFinalImageSet(r100, (ImageInfo) r101, this.f373446a.f373445g);
            this.f373446a.f373445g = r102;
        }
    }

    public final boolean U3() {
        if (this.f373439a.isShown() == true) goto L5;
        return false;
    L5:
        Rect r100 = new Rect();
        this.f373439a.getLocalVisibleRect(r100);
        if (r100.top <= 0) goto L8;
        return false;
    L8:
        if (r100.bottom < this.f373439a.getHeight()) goto L12;
        return true;
    L12:
        return false;
    }

    public final void V3() {
        if (this.f373441c == false) goto L5;
        return;
    L5:
        Animatable r100 = this.f373445g;
        boolean r101 = false;
        if (r100 != null) goto L8;
    L10:
        if (r101 == false) goto L15;
        Animatable r102 = this.f373445g;
        if (r102 == null) goto L16;
        r102.stop();
        return;
    L16:
        return;
    L15:
        return;
    L8:
        if (r100.isRunning() != true) goto L10;
        r101 = true;
        goto L10
    }

    public final void T3(final w r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f373443e.setText(r100.f295511b);
        Integer r101 = r100.f295528s;
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L13:
        SimpleDraweeView r102 = this.f373442d;
        g1 r103 = r100.f295515f;
        if (r103 == null) goto L16;
        String r104 = r103.f295156b;
    L17:
        ImageLoaderKt.y(r102, r104, "custom_actionbar_icon_instruction", new vz9.b(this), 4);
        this.f373440b.b(r100, getAdapterPosition());
        e1.d(this.f373439a, new c(this, r100));
        return;
    L16:
        r104 = null;
        goto L17
    L11:
        if (r101.intValue() != 1) goto L13;
        e1.x(this.f373444f);
        goto L13
    L6:
        if (r101.intValue() != 0) goto L8;
        e1.o(this.f373444f);
        goto L13
    }

    public ImageSelectorHolder(View r100, d r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f373439a = r100;
        this.f373440b = r101;
        this.f373441c = r102;
        this.f373442d = (SimpleDraweeView) r100.findViewById(R.id.image_template_cover);
        this.f373443e = (TextView) r100.findViewById(R.id.tv_item_name);
        this.f373444f = (ImageView) r100.findViewById(R.id.icon_img_selected_check);
        new RoundingParams().setCornersRadius(i5.m()).setBorder(ContextCompat.getColor(r100.getContext(), v19.c.b(R.attr.larus_primary_50, r100.getContext(), R.color.larus_primary_50)), i5.z());
        new RoundingParams().setCornersRadius(i5.m());
    }
}
