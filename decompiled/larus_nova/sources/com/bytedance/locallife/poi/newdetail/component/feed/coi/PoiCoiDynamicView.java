package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.lighten.core.CircleOptions;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.poi.experiment.PoiBigFontExperiment;
import com.bytedance.locallife.poi.newdetail.component.PoiRankView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.coi.CoiCellTypeInfo;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import df6.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/feed/coi/PoiCoiDynamicView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiCoiDynamicView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorDrawable f263169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoiStyles f263170b;

    public static final class a {
    }

    static {
    }

    public PoiCoiDynamicView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiCoiDynamicView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static void b(DuxTextView r100, int r101) {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        TextPaint r102 = r100.getPaint();
        Typeface r103 = r100.getPaint().getTypeface();
        Typeface r104 = r100.getPaint().getTypeface();
        if (r104 != null) goto L7;
    L9:
        boolean r105 = false;
    L10:
        r102.setTypeface(Typeface.create(r103, r101, r105));
        return;
    L7:
        if (r104.getStyle() != 2) goto L9;
        r105 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(List<CoiCellTypeInfo> r310, boolean r311) {
        List<CoiCellTypeInfo> r100 = r310;
        int r101 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        setVisibility(8);
        return;
    L12:
        boolean r103 = PoiBigFontExperiment.a();
        setVisibility(0);
        ArrayList r104 = new ArrayList();
        int r105 = getChildCount();
        int r106 = 0;
    L13:
        if (r106 >= r105) goto L15;
        r104.add(getChildAt(r106));
        r106 = r106 + 1;
        goto L13
    L15:
        removeAllViews();
        Iterator<CoiCellTypeInfo> r107 = r310.iterator();
    L17:
        if (r107.hasNext() == false) goto L192;
        CoiCellTypeInfo r108 = r107.next();
        String r109 = r108.getStyleType();
        if (r109 != null) goto L21;
    L24:
        boolean r110 = true;
    L25:
        if (r110 == true) goto L17;
        List<CoiDoubleUICell> r111 = this.f263170b.getStyles();
        List<String> r112 = null;
        Object[] r113 = 0;
        if (r111 == null) goto L37;
        Iterator<T> r114 = r111.iterator();
    L30:
        if (r114.hasNext() == false) goto L34;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((CoiDoubleUICell) r115).getStyleType(), r109) == false) goto L30;
    L35:
        final CoiDoubleUICell r116 = (CoiDoubleUICell) r115;
        if (r116 == null) goto L37;
    L38:
        String r117 = r108.getType();
        int r118 = 6;
        if (Intrinsics.areEqual(r117, CoiUIType.TEXT.getType()) == true) goto L40;
        if (Intrinsics.areEqual(r117, CoiUIType.ICON.getType()) == true) goto L91;
        if (Intrinsics.areEqual(r117, CoiUIType.RANK.getType()) == false) goto L17;
        Iterator r119 = r104.iterator();
        int r120 = 0;
    L182:
        if (r119.hasNext() == false) goto L187;
        if ((((View) r119.next()) instanceof PoiRankView) == true) goto L188;
        r120 = r120 + 1;
    L188:
        if (r120 == (-1)) goto L190;
        Object r121 = ListProtector.remove(r104, r120);
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type com.bytedance.locallife.poi.newdetail.component.PoiRankView");
        PoiRankView r122 = (PoiRankView) r121;
    L191:
        r122.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r122.setSupportFontScale(r311);
        addView(r122);
        Intrinsics.checkNotNullParameter(r108, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        r122.f263106c.setText(r108.getTextContent());
        goto L17
    L190:
        r122 = new PoiRankView(getContext(), r113 == true ? 1 : 0, r118, r101);
        goto L191
    L187:
        r120 = -1;
        goto L188
    L91:
        Iterator r123 = r104.iterator();
        int r124 = 0;
    L93:
        if (r123.hasNext() == false) goto L98;
        if ((((View) r123.next()) instanceof SmartImageView) == true) goto L99;
        r124 = r124 + 1;
    L99:
        if (r311 == false) goto L111;
        if (r103 == false) goto L106;
        Integer r125 = r116.getIconWidth();
        if (r125 == null) goto L104;
        int r126 = r125.intValue();
    L105:
        int r127 = com.bytedance.dux.largefont.a.b(Integer.valueOf(r126));
    L117:
        if (r311 == false) goto L129;
        if (r103 == false) goto L124;
        Integer r128 = r116.getIconHeight();
        if (r128 == null) goto L122;
        int r129 = r128.intValue();
    L123:
        int r130 = com.bytedance.dux.largefont.a.b(Integer.valueOf(r129));
    L135:
        if (r124 == (-1)) goto L137;
        Object r131 = ListProtector.remove(r104, r124);
        Intrinsics.checkNotNull(r131, "null cannot be cast to non-null type com.bytedance.lighten.loader.SmartImageView");
        SmartImageView r132 = (SmartImageView) r131;
    L138:
        LinearLayout.LayoutParams r133 = new LinearLayout.LayoutParams(r127, r130);
        r133.gravity = 16;
        Integer r134 = r116.getMarginLeft();
        if (r134 == null) goto L141;
        r133.setMarginStart((int) UIUtils.dip2Px(r132.getContext(), r134.intValue()));
    L141:
        r132.setLayoutParams(r133);
        addView(r132);
        PoiImageUrlModel r135 = r108.getIconUrl();
        if (r135 == null) goto L144;
        r112 = r135.getUrlList();
    L144:
        u r136 = df6.q.c(new ef6.a(r112));
        r136.f468284j = this.f263169a;
        if (r116.isCircle() != null) goto L196;
        String r137 = r116.getBorderColor();
        if (r137 != null) goto L149;
    L152:
        boolean r138 = true;
    L153:
        if (r138 == false) goto L196;
        if (r116.getBorderWidth() != null) goto L196;
    L177:
        r136.b("poi_coi_dynamic_icon_image");
        r136.f468281g = r127;
        r136.f468282h = r130;
        r136.f468294t = r132;
        r136.c();
        goto L17
    L149:
        if (r137.length() == 0) goto L152;
        r138 = false;
    L196:
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L175
        CircleOptions.a r140 = new CircleOptions.a();     // Catch: Throwable -> L175
        Boolean r141 = r116.isCircle();     // Catch: Throwable -> L175
        if (r141 == null) goto L159;
        boolean r142 = r141.booleanValue();     // Catch: Throwable -> L175
    L160:
        r140.f254607a = r142;     // Catch: Throwable -> L175
        float r143 = 0.0f;
        if (r311 == false) goto L166;
        Context r144 = r136.getContext();     // Catch: Throwable -> L175
        Float r145 = r116.getBorderWidth();     // Catch: Throwable -> L175
        if (r145 == null) goto L165;
        r143 = r145.floatValue();     // Catch: Throwable -> L175
    L165:
        float r146 = UIUtils.sp2px(r144, r143);     // Catch: Throwable -> L175
    L170:
        r140.f254608b = r146;     // Catch: Throwable -> L175
        String r147 = r116.getBorderColor();     // Catch: Throwable -> L175
        if (r147 != null) goto L173;
        r147 = "#00000000";
    L173:
        r140.f254609c = Color.parseColor(r147);     // Catch: Throwable -> L175
        r136.f468289o = new CircleOptions(r140);     // Catch: Throwable -> L175
        Result.m9449constructorimpl(r136);     // Catch: Throwable -> L175
        goto L177
    L166:
        Context r148 = r136.getContext();     // Catch: Throwable -> L175
        Float r149 = r116.getBorderWidth();     // Catch: Throwable -> L175
        if (r149 == null) goto L169;
        r143 = r149.floatValue();     // Catch: Throwable -> L175
    L169:
        r146 = UIUtils.dip2Px(r148, r143);     // Catch: Throwable -> L175
        goto L170
    L159:
        r142 = false;
    L175:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L177
    L137:
        r132 = new SmartImageView(getContext());
        goto L138
    L122:
        r129 = 16;
        goto L123
    L124:
        Context r151 = getContext();
        Integer r152 = r116.getIconHeight();
        if (r152 == null) goto L127;
        int r153 = r152.intValue();
    L128:
        float r154 = UIUtils.sp2px(r151, r153);
    L134:
        r130 = (int) r154;
        goto L135
    L127:
        r153 = 16;
        goto L128
    L129:
        Context r155 = getContext();
        Integer r156 = r116.getIconHeight();
        if (r156 == null) goto L132;
        int r157 = r156.intValue();
    L133:
        r154 = UIUtils.dip2Px(r155, r157);
        goto L134
    L132:
        r157 = 16;
        goto L133
    L104:
        r126 = 16;
        goto L105
    L106:
        Context r158 = getContext();
        Integer r159 = r116.getIconWidth();
        if (r159 == null) goto L109;
        int r160 = r159.intValue();
    L110:
        float r161 = UIUtils.sp2px(r158, r160);
    L116:
        r127 = (int) r161;
        goto L117
    L109:
        r160 = 16;
        goto L110
    L111:
        Context r162 = getContext();
        Integer r163 = r116.getIconWidth();
        if (r163 == null) goto L114;
        int r164 = r163.intValue();
    L115:
        r161 = UIUtils.dip2Px(r162, r164);
        goto L116
    L114:
        r164 = 16;
        goto L115
    L98:
        r124 = -1;
        goto L99
    L40:
        Iterator r165 = r104.iterator();
        int r166 = 0;
    L42:
        if (r165.hasNext() == false) goto L47;
        if ((((View) r165.next()) instanceof DuxTextView) == true) goto L48;
        r166 = r166 + 1;
    L48:
        if (r166 == (-1)) goto L50;
        Object r167 = ListProtector.remove(r104, r166);
        Intrinsics.checkNotNull(r167, "null cannot be cast to non-null type com.bytedance.dux.text.DuxTextView");
        final DuxTextView r168 = (DuxTextView) r167;
    L51:
        LinearLayout.LayoutParams r169 = new LinearLayout.LayoutParams(-2, -2);
        r168.setIncludeFontPadding(false);
        r168.setText(r108.getTextContent());
        Result.Companion r170 = Result.Companion;     // Catch: Throwable -> L57
        String r171 = r116.getFontColor();     // Catch: Throwable -> L57
        if (r171 != null) goto L55;
        r171 = "#80161823";
    L55:
        r168.setTextColor(Color.parseColor(r171));     // Catch: Throwable -> L57
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L57
    L59:
        int r172 = 12;
        if (r311 == false) goto L70;
        if (r103 == false) goto L66;
        Integer r173 = r116.getFontSize();
        if (r173 == null) goto L65;
        r172 = r173.intValue();
    L65:
        com.bytedance.dux.largefont.a.c(r168, r172);
    L75:
        if (Intrinsics.areEqual(r116.getFontWeight(), CoiUIFoneWeight.BOLD.getWeight()) == false) goto L77;
        b(r168, 550);
    L78:
        final String r174 = r116.getBackgroundColor();
        if (r174 == null) goto L81;
        r168.setBackground(com.bytedance.locallife.dito.utils.o.a(new PoiCoiDynamicView$bindData$textView$1$2$1(r168, r116, r174)));
        r168.setPadding((int) UIUtils.dip2Px(r168.getContext(), 3.0f), (int) UIUtils.dip2Px(r168.getContext(), 2.0f), (int) UIUtils.dip2Px(r168.getContext(), 3.0f), (int) UIUtils.dip2Px(r168.getContext(), 2.0f));
    L81:
        Integer r175 = r116.getMarginLeft();
        if (r175 == null) goto L84;
        r169.setMarginStart((int) UIUtils.dip2Px(r168.getContext(), r175.intValue()));
    L84:
        r168.setMaxLines(1);
        r168.setEllipsize(TextUtils.TruncateAt.END);
        if (Intrinsics.areEqual(r116.getGravity(), CoiUIGravity.GRAVITY_BOTTOM.getGravity()) == false) goto L87;
        r169.gravity = 80;
        r168.setPadding(0, 0, 0, (int) UIUtils.dip2Px(r168.getContext(), 2.0f));
    L88:
        r168.setLayoutParams(r169);
        addView(r168);
        goto L17
    L87:
        r169.gravity = 16;
        goto L88
    L77:
        b(r168, 400);
        goto L78
    L66:
        Integer r176 = r116.getFontSize();
        if (r176 == null) goto L69;
        r172 = r176.intValue();
    L69:
        r168.setTextSize(2, r172);
        goto L75
    L70:
        Integer r177 = r116.getFontSize();
        if (r177 == null) goto L73;
        r172 = r177.intValue();
    L73:
        r168.setTextSize(1, r172);
    L57:
        th = move-exception;
        Result.Companion r178 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L59
    L50:
        r168 = new DuxTextView(getContext(), null, 6, 0);
        goto L51
    L47:
        r166 = -1;
        goto L48
    L34:
        r115 = null;
    L37:
        r116 = new CoiDoubleUICell(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        goto L38
    L21:
        if (r109.length() == 0) goto L24;
        r110 = false;
        goto L25
    L192:
        r104.clear();
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public PoiCoiDynamicView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f263169a = new ColorDrawable(r100.getResources().getColor(R.color.BGPlaceholderDefault));
        setOrientation(0);
        CoiStyles r103 = com.bytedance.locallife.poi.newdetail.component.feed.coi.a.f263176a;
        CoiStyles r104 = (CoiStyles) HostServiceUtilsKt.g0().a("poi_coi_double_item_styles", CoiStyles.class, null);     // Catch: Throwable -> L7
        if (r104 != null) goto L8;
        r104 = com.bytedance.locallife.poi.newdetail.component.feed.coi.a.f263176a;     // Catch: Throwable -> L7
    L8:
        this.f263170b = r104;
        setImportantForAccessibility(4);
        return;
    L7:
        r104 = com.bytedance.locallife.poi.newdetail.component.feed.coi.a.f263176a;
        goto L8
    }

    public /* synthetic */ PoiCoiDynamicView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
