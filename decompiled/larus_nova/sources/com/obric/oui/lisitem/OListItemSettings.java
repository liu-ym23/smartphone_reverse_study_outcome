package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.nova.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b5\u00106J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R.\u00100\u001a\u0004\u0018\u00010\u00022\b\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00067"}, d2 = {"Lcom/obric/oui/lisitem/OListItemSettings;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "", "text", "", "setTrailingText", "", "minWidth", "setTrailingViewMinWidth", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageView", "", "enabled", "setListItemSettingsEnabled", "getContentDefaultOneChildWidth", "Lcom/obric/oui/lisitem/ListItemHeightMode;", "mode", "setListItemHeightMode", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "w", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getSettingsTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", "settingsTrailingView", "Landroid/widget/FrameLayout;", "x", "Landroid/widget/FrameLayout;", "getMTitleInfo", "()Landroid/widget/FrameLayout;", "setMTitleInfo", "(Landroid/widget/FrameLayout;)V", "mTitleInfo", "Lcom/obric/oui/layout/OUIFrameLayout;", "y", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentImgBackground", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentImgBackground", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentImgBackground", "value", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "Ljava/lang/String;", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "(Ljava/lang/String;)V", "trailingTextString", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OListItemSettings extends OListItemGeneral {
    public int A;
    public ListItemHeightMode B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f401372v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SettingsTrailingView f401373w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public FrameLayout f401374x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OUIFrameLayout f401375y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f401376z;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f401377a = null;

        static {
            int[] r100 = new int[ListItemHeightMode.values().length];
            r100[ListItemHeightMode.DEFAULT.ordinal()] = 1;
            r100[ListItemHeightMode.COMPACT.ordinal()] = 2;
            f401377a = r100;
        }
    }

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r100 = this.f401375y;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentImgBackground");
        return null;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r100 = this.f401374x;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTitleInfo");
        return null;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_settings, this);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return this.A;
    }

    public final SettingsTrailingView getSettingsTrailingView() {
        return this.f401373w;
    }

    public final String getTrailingTextString() {
        return this.f401376z;
    }

    public final void setContentImgBackground(OUIFrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401375y = r100;
    }

    @Deprecated(message = "use showTrailingImageView instead", replaceWith = @ReplaceWith(expression = "showTrailingImageView(drawable)", imports = {}))
    public final void setImageView(Drawable r100) {
        this.f401373w.setTrailingImage(r100);
    }

    public final void setListItemHeightMode(ListItemHeightMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        if (this.B != r100) goto L5;
        return;
    L5:
        int r101 = a.f401377a[r100.ordinal()];
        if (r101 != 1) goto L8;
        int r102 = getResources().getDimensionPixelSize(R.dimen.oui_listitem_content_width_large);
    L13:
        this.f401372v.setMinimumHeight(r102);
        getMClContent().setMinimumHeight(r102);
        getMClContent().setMinHeight(r102);
        ViewGroup.LayoutParams r103 = getMTrailingElement().getLayoutParams();
        if (r103 != null) goto L17;
    L21:
        this.A = r102;
        f();
        this.B = r100;
        return;
    L17:
        if ((r103 instanceof ConstraintLayout.LayoutParams) == false) goto L21;
        int r104 = (r102 - getMClContent().getPaddingTop()) - getMClContent().getPaddingBottom();
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r103;
        if (r104 >= r105.matchConstraintMinHeight) goto L21;
        FrameLayout r106 = getMTrailingElement();
        r105.matchConstraintMinHeight = r104;
        r106.setLayoutParams(r103);
        goto L21
    L8:
        if (r101 != 2) goto L11;
        r102 = getResources().getDimensionPixelSize(R.dimen.oui_listitem_content_width_middle);
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
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
        this.f401374x = r100;
    }

    public final void setTrailingText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f401373w.setTrailingText(r100);
    }

    public final void setTrailingTextString(String r100) {
        this.f401376z = r100;
        f();
        String r101 = this.f401376z;
        if (r101 == null) goto L6;
        setTrailingText(r101);
    L6:
        setTrailingView(this.f401373w);
    }

    public final void setTrailingViewMinWidth(int r100) {
        ViewGroup.LayoutParams r101 = getMTrailingElement().getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        FrameLayout r102 = getMTrailingElement();
        ((ConstraintLayout.LayoutParams) r101).matchConstraintMinWidth = r100;
        r102.setLayoutParams(r101);
        return;
    }

    public OListItemSettings(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.A = r100.getResources().getDimensionPixelSize(R.dimen.oui_listitem_content_width_large);
        this.B = ListItemHeightMode.DEFAULT;
        this.f401372v = (ViewGroup) findViewById(R.id.ll_root);
        this.f401373w = new SettingsTrailingView(r100, null, 6, 0);
        setMTitleInfo((FrameLayout) findViewById(R.id.title_info));
        setContentImgBackground((OUIFrameLayout) findViewById(R.id.iv_content_img_background));
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_list_item_content_image, R.attr.oui_list_item_content_width, R.attr.oui_list_item_show_background, R.attr.oui_list_item_show_divider, R.attr.oui_list_item_subtitle, R.attr.oui_list_item_title, R.attr.oui_list_item_trailing_image, R.attr.oui_list_item_trailing_text});
        setTrailingTextString(r102.getString(7));
        r102.recycle();
        if (getContentImage() == null) goto L6;
        getContentImgBackground().setVisibility(0);
        return;
    }
}
