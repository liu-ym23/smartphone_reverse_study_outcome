package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.nova.R;
import com.obric.oui.button.OIconButton;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R.\u0010+\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R.\u00102\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R.\u00106\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101¨\u0006="}, d2 = {"Lcom/obric/oui/lisitem/OListItemCircleImg;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "", "text", "", "setTrailingText", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageView", "", "enabled", "setListItemSettingsEnabled", "", "getContentDefaultOneChildWidth", "Lcom/obric/oui/lisitem/SettingsTrailingView;", BaseSwitches.V, "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getSettingsTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", "settingsTrailingView", "Lcom/obric/oui/button/OIconButton;", "w", "Lcom/obric/oui/button/OIconButton;", "getContentImgCircle", "()Lcom/obric/oui/button/OIconButton;", "setContentImgCircle", "(Lcom/obric/oui/button/OIconButton;)V", "contentImgCircle", "Landroid/widget/ImageView;", "x", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "setIvIcon", "(Landroid/widget/ImageView;)V", "ivIcon", "value", "y", "Ljava/lang/String;", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "(Ljava/lang/String;)V", "trailingTextString", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "Landroid/graphics/drawable/Drawable;", "getCircleImage", "()Landroid/graphics/drawable/Drawable;", "setCircleImage", "(Landroid/graphics/drawable/Drawable;)V", "circleImage", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getIconImage", "setIconImage", "iconImage", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OListItemCircleImg extends OListItemGeneral {
    public Drawable A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final SettingsTrailingView f401345v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OIconButton f401346w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ImageView f401347x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f401348y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f401349z;

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_circle_img, this);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(getResources().getDimension(R.dimen.oui_listitem_content_width_large));
    }

    public final Drawable getCircleImage() {
        return this.f401349z;
    }

    public final OIconButton getContentImgCircle() {
        return this.f401346w;
    }

    public final Drawable getIconImage() {
        return this.A;
    }

    public final ImageView getIvIcon() {
        return this.f401347x;
    }

    public final SettingsTrailingView getSettingsTrailingView() {
        return this.f401345v;
    }

    public final String getTrailingTextString() {
        return this.f401348y;
    }

    public final void setCircleImage(Drawable r100) {
        this.f401349z = r100;
        if (r100 == null) goto L5;
        this.f401346w.setImageDrawable(r100);
        this.f401346w.setVisibility(0);
        getMContentElement().setVisibility(0);
    L6:
        f();
        return;
    L5:
        this.f401346w.setVisibility(8);
        getMContentElement().setVisibility(8);
        goto L6
    }

    public final void setContentImgCircle(OIconButton r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401346w = r100;
    }

    public final void setIconImage(Drawable r100) {
        this.A = r100;
        if (r100 == null) goto L5;
        this.f401347x.setImageDrawable(r100);
        this.f401347x.setVisibility(0);
    L6:
        f();
        return;
    L5:
        this.f401347x.setVisibility(8);
        goto L6
    }

    @Deprecated(message = "use showTrailingImageView instead", replaceWith = @ReplaceWith(expression = "showTrailingImageView(drawable)", imports = {}))
    public final void setImageView(Drawable r100) {
        this.f401345v.setTrailingImage(r100);
    }

    public final void setIvIcon(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401347x = r100;
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

    public final void setTrailingText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f401345v.setTrailingText(r100);
    }

    public final void setTrailingTextString(String r100) {
        this.f401348y = r100;
        f();
        String r101 = this.f401348y;
        if (r101 == null) goto L6;
        setTrailingText(r101);
    L6:
        setTrailingView(this.f401345v);
    }

    public OListItemCircleImg(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f401345v = new SettingsTrailingView(r100, null, 6, 0);
        this.f401346w = (OIconButton) findViewById(R.id.contentImgCircle);
        this.f401347x = (ImageView) findViewById(R.id.iv_icon);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_list_item_content_image, R.attr.oui_list_item_content_width, R.attr.oui_list_item_show_background, R.attr.oui_list_item_show_divider, R.attr.oui_list_item_subtitle, R.attr.oui_list_item_title, R.attr.oui_list_item_trailing_image, R.attr.oui_list_item_trailing_text});
        setTrailingTextString(r102.getString(7));
        r102.recycle();
        if (this.f401349z == null) goto L5;
        this.f401346w.setVisibility(0);
        getMContentElement().setVisibility(0);
        return;
    L5:
        this.f401346w.setVisibility(8);
        getMContentElement().setVisibility(8);
    }
}
