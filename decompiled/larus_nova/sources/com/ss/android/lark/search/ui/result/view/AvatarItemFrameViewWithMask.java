package com.ss.android.lark.search.ui.result.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/ss/android/lark/search/ui/result/view/AvatarItemFrameViewWithMask;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Landroid/view/View;", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/search/ui/result/view/AvatarItemFrameView;", "getItem", "()Lcom/ss/android/lark/search/ui/result/view/AvatarItemFrameView;", "setItem", "(Lcom/ss/android/lark/search/ui/result/view/AvatarItemFrameView;)V", "chatPreviewIcon", "Landroid/widget/ImageView;", "getChatPreviewIcon", "()Landroid/widget/ImageView;", "setChatPreviewIcon", "(Landroid/widget/ImageView;)V", "value", "", "isEnablePressBackground", "()Z", "setEnablePressBackground", "(Z)V", "showShadow", "", "hideShadow", "showDivider", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarItemFrameViewWithMask extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f440321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AvatarItemFrameView f440322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f440323c;

    public AvatarItemFrameViewWithMask(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AvatarItemFrameViewWithMask(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final ImageView getChatPreviewIcon() {
        return this.f440323c;
    }

    public final AvatarItemFrameView getItem() {
        return this.f440322b;
    }

    public final void setChatPreviewIcon(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440323c = r100;
    }

    public final void setEnablePressBackground(boolean r100) {
        if (r100 == false) goto L4;
        Drawable r101 = AppCompatResources.getDrawable(getContext(), R.drawable.avatar_item_selector_bg);
    L5:
        setBackground(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final void setItem(AvatarItemFrameView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440322b = r100;
    }

    public AvatarItemFrameViewWithMask(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setBackground(AppCompatResources.getDrawable(r100, R.drawable.avatar_item_selector_bg));
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        LayoutInflater.from(r100).inflate(R.layout.avatar_item_frame_view_with_mask, this);
        this.f440322b = (AvatarItemFrameView) findViewById(R.id.avatar_item);
        this.f440321a = findViewById(R.id.avatar_item_mask);
        this.f440323c = (ImageView) findViewById(R.id.chat_preview_icon);
        this.f440322b.setBackground(null);
    }

    public /* synthetic */ AvatarItemFrameViewWithMask(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
