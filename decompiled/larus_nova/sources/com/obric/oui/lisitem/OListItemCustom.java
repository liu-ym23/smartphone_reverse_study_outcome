package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.nova.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b9\u0010:J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010\r\u001a\u00020\fH\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b\u0005\u0010#R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R.\u00104\u001a\u0004\u0018\u00010\u00022\b\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006;"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCustom;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "", "text", "", "setTrailingText", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageView", "", "enabled", "setListItemSettingsEnabled", "", "getContentDefaultOneChildWidth", "Landroid/widget/FrameLayout;", BaseSwitches.V, "Landroid/widget/FrameLayout;", "getMTitleInfo", "()Landroid/widget/FrameLayout;", "setMTitleInfo", "(Landroid/widget/FrameLayout;)V", "mTitleInfo", "Lcom/obric/oui/layout/OUIFrameLayout;", "w", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentImgBackground", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentImgBackground", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentImgBackground", "Lcom/obric/oui/text/OTextView;", "x", "Lcom/obric/oui/text/OTextView;", "getTrailingText", "()Lcom/obric/oui/text/OTextView;", "(Lcom/obric/oui/text/OTextView;)V", "trailingText", "Landroid/widget/ImageView;", "y", "Landroid/widget/ImageView;", "getTrailingImageView", "()Landroid/widget/ImageView;", "setTrailingImageView", "(Landroid/widget/ImageView;)V", "trailingImageView", "value", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "Ljava/lang/String;", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "(Ljava/lang/String;)V", "trailingTextString", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OListItemCustom extends OListItemGeneral {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FrameLayout f401350v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OUIFrameLayout f401351w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OTextView f401352x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView f401353y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f401354z;

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r100 = this.f401351w;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentImgBackground");
        return null;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r100 = this.f401350v;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTitleInfo");
        return null;
    }

    public final ImageView getTrailingImageView() {
        ImageView r100 = this.f401353y;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("trailingImageView");
        return null;
    }

    public final OTextView getTrailingText() {
        OTextView r100 = this.f401352x;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("trailingText");
        return null;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_custom_trailing, this);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(getResources().getDimension(R.dimen.oui_listitem_content_width_large));
    }

    public final String getTrailingTextString() {
        return this.f401354z;
    }

    public final void setContentImgBackground(OUIFrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401351w = r100;
    }

    public final void setImageView(Drawable r100) {
        getTrailingImageView().setImageDrawable(r100);
    }

    public final void setListItemSettingsEnabled(boolean r100) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r100);
        if (r100 == false) goto L5;
        getMLeadingElement().setAlpha(1.0f);
        getMClContent().setAlpha(1.0f);
        getMContentElement().setAlpha(1.0f);
        return;
    L5:
        getMLeadingElement().setAlpha(0.3f);
        getMClContent().setAlpha(0.3f);
        getMContentElement().setAlpha(0.3f);
    }

    public final void setMTitleInfo(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401350v = r100;
    }

    public final void setTrailingImageView(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401353y = r100;
    }

    public final void setTrailingText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        getTrailingText().setText(r100);
    }

    public final void setTrailingTextString(String r100) {
        this.f401354z = r100;
        f();
        String r101 = this.f401354z;
        if (r101 == null) goto L7;
        setTrailingText(r101);
        return;
    }

    public final void setTrailingText(OTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401352x = r100;
    }

    public OListItemCustom(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setMTitleInfo((FrameLayout) findViewById(R.id.title_info));
        setContentImgBackground((OUIFrameLayout) findViewById(R.id.iv_content_img_background));
        setTrailingText((OTextView) findViewById(R.id.trailingText));
        setTrailingImageView((ImageView) findViewById(R.id.trailingImage));
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_list_item_content_image, R.attr.oui_list_item_content_width, R.attr.oui_list_item_show_background, R.attr.oui_list_item_show_divider, R.attr.oui_list_item_subtitle, R.attr.oui_list_item_title, R.attr.oui_list_item_trailing_image, R.attr.oui_list_item_trailing_text});
        setTrailingTextString(r102.getString(7));
        r102.recycle();
        if (getContentImage() == null) goto L6;
        getContentImgBackground().setVisibility(0);
        return;
    }
}
