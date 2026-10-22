package com.ss.android.lark.picker.base.view;

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
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/ss/android/lark/picker/base/view/AvatarItemViewWithMask;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Landroid/view/View;", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView;", "getItem", "()Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView;", "setItem", "(Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView;)V", "chatPreviewIcon", "Landroid/widget/ImageView;", "getChatPreviewIcon", "()Landroid/widget/ImageView;", "setChatPreviewIcon", "(Landroid/widget/ImageView;)V", "value", "", "isEnablePressBackground", "()Z", "setEnablePressBackground", "(Z)V", "showShadow", "", "hideShadow", "showDivider", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarItemViewWithMask extends RelativeLayout {
    private ImageView chatPreviewIcon;
    private boolean isEnablePressBackground;
    private AvatarItemView item;
    private View shadow;

    public AvatarItemViewWithMask(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public AvatarItemViewWithMask(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public final void hideShadow() {
        this.shadow.setVisibility(8);
    }

    public final void showShadow() {
        this.shadow.setVisibility(0);
    }

    public final ImageView getChatPreviewIcon() {
        return this.chatPreviewIcon;
    }

    public final AvatarItemView getItem() {
        return this.item;
    }

    public final boolean isEnablePressBackground() {
        return this.isEnablePressBackground;
    }

    public final void setChatPreviewIcon(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.chatPreviewIcon = r100;
    }

    public final void setEnablePressBackground(boolean r100) {
        this.isEnablePressBackground = r100;
        if (r100 == false) goto L5;
        Drawable r101 = AppCompatResources.getDrawable(getContext(), R.drawable.avatar_item_selector_bg);
    L6:
        setBackground(r101);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void setItem(AvatarItemView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.item = r100;
    }

    public final void showDivider(boolean r100) {
        this.item.showDivider(r100);
    }

    public AvatarItemViewWithMask(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.isEnablePressBackground = true;
        if (KeyboardSelectionAdapter.Companion.getFG_DISABLE_SELECT_BG() == true) goto L5;
        setAddStatesFromChildren(true);
    L5:
        setBackground(AppCompatResources.getDrawable(r100, R.drawable.avatar_item_selector_bg));
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        LayoutInflater.from(r100).inflate(R.layout.avatar_item_view_with_mask, this);
        this.item = (AvatarItemView) findViewById(R.id.avatar_item);
        this.shadow = findViewById(R.id.avatar_item_mask);
        this.chatPreviewIcon = (ImageView) findViewById(R.id.chat_preview_icon);
        this.item.setBackground(null);
    }

    public /* synthetic */ AvatarItemViewWithMask(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
