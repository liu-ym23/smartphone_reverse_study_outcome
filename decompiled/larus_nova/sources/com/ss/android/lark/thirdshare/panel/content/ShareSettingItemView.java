package com.ss.android.lark.thirdshare.panel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.platform.comapi.map.MapController;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001e\u0010 \u001a\u0004\u0018\u00010!8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/ss/android/lark/thirdshare/panel/content/ShareSettingItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "shareSettingItemIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getShareSettingItemIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setShareSettingItemIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "shareSettingItemLabelFromXml", "Landroid/widget/TextView;", "getShareSettingItemLabelFromXml", "()Landroid/widget/TextView;", "setShareSettingItemLabelFromXml", "(Landroid/widget/TextView;)V", "shareSettingItemDescriptionFromXml", "getShareSettingItemDescriptionFromXml", "setShareSettingItemDescriptionFromXml", "shareSettingItemRightArrowFromXml", "getShareSettingItemRightArrowFromXml", "setShareSettingItemRightArrowFromXml", "shareSettingItemCustomSlotFromXml", "Landroid/widget/FrameLayout;", "getShareSettingItemCustomSlotFromXml", "()Landroid/widget/FrameLayout;", "setShareSettingItemCustomSlotFromXml", "(Landroid/widget/FrameLayout;)V", "setItemContent", "", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/thirdshare/panel/content/ShareSettingItem;", "third-share-panel_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareSettingItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f441281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f441282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f441283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatImageView f441284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f441285e;

    public static final class a implements View.OnClickListener {
        public a(b r100) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            throw null;
        }
    }

    public final FrameLayout getShareSettingItemCustomSlotFromXml() {
        KeyEvent.Callback r100 = this.f441285e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.share_setting_item_custom_slot);
        this.f441285e = (FrameLayout) r100;
    L6:
        return (FrameLayout) r100;
    }

    public final TextView getShareSettingItemDescriptionFromXml() {
        KeyEvent.Callback r100 = this.f441283c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.share_setting_item_description);
        this.f441283c = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final AppCompatImageView getShareSettingItemIconFromXml() {
        KeyEvent.Callback r100 = this.f441281a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.share_setting_item_icon);
        this.f441281a = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final TextView getShareSettingItemLabelFromXml() {
        KeyEvent.Callback r100 = this.f441282b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.share_setting_item_label);
        this.f441282b = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final AppCompatImageView getShareSettingItemRightArrowFromXml() {
        KeyEvent.Callback r100 = this.f441284d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.share_setting_item_right_arrow);
        this.f441284d = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public ShareSettingItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(getContext()).inflate(R.layout.item_share_setting, this, true);
        int r101 = (int) new UDDimension.Dp(16).toPixels(getContext());
        int r102 = (int) new UDDimension.Dp(13).toPixels(getContext());
        setPadding(r101, r102, r101, r102);
    }

    public final void setItemContent(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        AppCompatImageView r101 = getShareSettingItemIconFromXml();
        r100.getClass();
        r101.setImageResource(0);
        getShareSettingItemLabelFromXml().setText(null);
        getShareSettingItemDescriptionFromXml().setVisibility(8);
        getShareSettingItemRightArrowFromXml().setVisibility(8);
        setOnClickListener(new a(r100));
    }

    public final void setShareSettingItemCustomSlotFromXml(FrameLayout r100) {
        this.f441285e = r100;
    }

    public final void setShareSettingItemDescriptionFromXml(TextView r100) {
        this.f441283c = r100;
    }

    public final void setShareSettingItemIconFromXml(AppCompatImageView r100) {
        this.f441281a = r100;
    }

    public final void setShareSettingItemLabelFromXml(TextView r100) {
        this.f441282b = r100;
    }

    public final void setShareSettingItemRightArrowFromXml(AppCompatImageView r100) {
        this.f441284d = r100;
    }

    public ShareSettingItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(getContext()).inflate(R.layout.item_share_setting, this, true);
        int r102 = (int) new UDDimension.Dp(16).toPixels(getContext());
        int r103 = (int) new UDDimension.Dp(13).toPixels(getContext());
        setPadding(r102, r103, r102, r103);
    }

    public ShareSettingItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.item_share_setting, this, true);
        int r103 = (int) new UDDimension.Dp(16).toPixels(getContext());
        int r104 = (int) new UDDimension.Dp(13).toPixels(getContext());
        setPadding(r103, r104, r103, r104);
    }
}
