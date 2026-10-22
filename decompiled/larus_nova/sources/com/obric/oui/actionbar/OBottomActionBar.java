package com.obric.oui.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.obric.oui.divider.ODivider;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.Keys;
import ila.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vma.c;

/* JADX INFO: loaded from: classes44.dex */
@Deprecated(message = "请根据设计稿，使用 v2 包下的对应样式的 OBottomActionBar(Floating/NormalHorizontal/NormalVertical) 代替")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u0001\fB\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\r"}, d2 = {"Lcom/obric/oui/actionbar/OBottomActionBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/actionbar/OBottomActionBar$a;", "l", "", "setBottomButtonClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OBottomActionBar extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f398689f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f398690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f398691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f398692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ODivider f398693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<OButton> f398694e;

    public interface a {
    }

    public final void setBottomButtonClickListener(a r100) {
    }

    public OBottomActionBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public OBottomActionBar(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        this.f398690a = "OBottomActionBar";
        FrameLayout.inflate(r110, R.layout.o_widget_bottom_action_bar, this);
        setBackgroundColor(ContextCompat.getColor(r110, R.color.Transparent));
        this.f398692c = (LinearLayout) findViewById(R.id.root_layout);
        this.f398693d = (ODivider) findViewById(R.id.top_divider);
        TypedArray r100 = r110.getTheme().obtainStyledAttributes(r111, new int[]{R.attr.oui_bottomActionBarType, R.attr.oui_buttonImgIds, R.attr.oui_buttonLastPrimary, R.attr.oui_buttonStyle, R.attr.oui_buttonTexts, R.attr.oui_hasDivider, R.attr.oui_widgetBlurBlendModes, R.attr.oui_widgetBlurColors, R.attr.oui_widgetBlurRadius, R.attr.oui_widgetEnableMaterial, R.attr.oui_widgetFitInsetBottom, R.attr.oui_widgetMaterialSrcType}, 0, 0);
        boolean r101 = r100.getBoolean(5, true);
        boolean r102 = r100.getBoolean(2, false);
        String r103 = r100.getString(3);
        int r112 = r100.getResourceId(4, 0);
        int r113 = r100.getResourceId(1, 0);
        Object r114 = null;
        if (r112 != 0) goto L5;
        List r115 = null;
    L6:
        if (r113 != 0) goto L8;
        List r116 = null;
    L13:
        if (r103 != null) goto L15;
        r103 = "l1";
    L15:
        Intrinsics.checkNotNullParameter(r103, "buttonStyle");
        r100.recycle();
        int r104 = r103.hashCode();
        if (r104 == (-1612256902)) goto L49;
        if (r104 == 3397) goto L45;
        if (r104 == 104387) goto L41;
        if (r104 == 678742426) goto L37;
        if (r104 == 3428) goto L33;
        if (r104 != 3429) goto L53;
        if (r103.equals(Keys.API_PARAM_KEY_M2) == false) goto L53;
        this.f398691b = FrameLayout.inflate(getContext(), R.layout.o_widget_bottom_action_bar_m2, null);
        this.f398692c.addView(this.f398691b, new LinearLayout.LayoutParams(-1, -1));
        this.f398694e = CollectionsKt.mutableListOf(new OButton[]{(OButton) findViewById(R.id.action_button_m20), (OButton) findViewById(R.id.action_button_m21), (OButton) findViewById(R.id.action_button_m22)});
    L53:
        if (r103.compareTo("img") != 0) goto L74;
        List<OButton> r105 = this.f398694e;
        if (r105 == null) goto L105;
        if (r116 == null) goto L64;
        int r106 = Math.min(r116.size(), r105.size());
        if (r116.size() <= r105.size()) goto L61;
        Intrinsics.stringPlus("Exceeded the maximum number of buttons Max is ", Integer.valueOf(r105.size()));
    L61:
        int r107 = r106 - 1;
        int r108 = 0;
    L62:
        if (r108 >= r106) goto L66;
        ((OButton) ListProtector.get(r105, r108)).setVisibility(0);
        ((OButton) ListProtector.get(r105, r108)).setButtonSourceBitmap(((Number) ListProtector.get(r116, r108)).intValue());
        r108 = r108 + 1;
    L66:
        if (r107 != (-1)) goto L68;
        r107 = r105.size() - 1;
    L68:
        if (r107 < 0) goto L105;
        final int r109 = 0;
    L70:
        int r117 = r109 + 1;
        ((OButton) ListProtector.get(r105, r109)).setOnClickListener(new ila.a(this, r109));
        if (r109 == r107) goto L105;
        r109 = r117;
        goto L70
    L64:
        r107 = -1;
    L105:
        if (r101 == false) goto L107;
        this.f398693d.setVisibility(0);
        return;
    L107:
        this.f398693d.setVisibility(8);
        return;
    L74:
        List<OButton> r118 = this.f398694e;
        if (r118 == null) goto L105;
        if (r115 == null) goto L85;
        int r119 = Math.min(r115.size(), r118.size());
        if (r115.size() <= r118.size()) goto L81;
        Intrinsics.stringPlus("Exceeded the maximum number of buttons Max is ", Integer.valueOf(r118.size()));
    L81:
        int r120 = r119 - 1;
        int r121 = 0;
    L82:
        if (r121 >= r119) goto L84;
        ((OButton) ListProtector.get(r118, r121)).setVisibility(0);
        ((OButton) ListProtector.get(r118, r121)).setText((CharSequence) ListProtector.get(r115, r121));
        r121 = r121 + 1;
        goto L82
    L84:
        int r122 = -1;
    L86:
        if (r120 != r122) goto L88;
        r120 = r118.size() - 1;
    L88:
        if (r102 == false) goto L99;
        ((OButton) ListProtector.get(r118, r120)).setBackgroundColor(getResources().getColor(R.color.oui_accent_bg_high_contrast));
        ((OButton) ListProtector.get(r118, r120)).setTextColor(getResources().getColor(R.color.oui_on_accent_default));
        int r123 = c.f556351a;
        Object r124 = ListProtector.get(r118, r120);
        if (r124 != null) goto L93;
    L95:
        com.obric.oui.common.style.a r125 = (com.obric.oui.common.style.a) r114;
        if (r125 == null) goto L99;
        r125.m1(this.f398690a);
        goto L99
    L93:
        if ((r124 instanceof com.obric.oui.common.style.a) == false) goto L95;
        r114 = r124;
    L99:
        if (r120 < 0) goto L105;
        final int r126 = 0;
    L101:
        int r127 = r126 + 1;
        ((OButton) ListProtector.get(r118, r126)).setOnClickListener(new b(this, r126));
        if (r126 == r120) goto L105;
        r126 = r127;
        goto L101
    L85:
        r122 = -1;
        r120 = -1;
        goto L86
    L33:
        if (r103.equals(Keys.API_PARAM_KEY_M1) == false) goto L53;
        this.f398691b = FrameLayout.inflate(getContext(), R.layout.o_widget_bottom_action_bar_m1, null);
        this.f398692c.addView(this.f398691b, new LinearLayout.LayoutParams(-1, -1));
        this.f398694e = CollectionsKt.mutableListOf(new OButton[]{(OButton) findViewById(R.id.action_button_0), (OButton) findViewById(R.id.action_button_1), (OButton) findViewById(R.id.action_button_2), (OButton) findViewById(R.id.action_button_3), (OButton) findViewById(R.id.action_button_4)});
        goto L53
    L37:
        if (r103.equals("m2-primary") == false) goto L53;
        this.f398691b = FrameLayout.inflate(getContext(), R.layout.o_widget_bottom_action_bar_m2_primary, null);
        this.f398692c.addView(this.f398691b, new LinearLayout.LayoutParams(-1, -1));
        this.f398694e = CollectionsKt.mutableListOf(new OButton[]{(OButton) findViewById(R.id.action_button_m2_primary0), (OButton) findViewById(R.id.action_button_m2_primary1)});
        goto L53
    L41:
        if (r103.equals("img") == false) goto L53;
        this.f398691b = FrameLayout.inflate(getContext(), R.layout.o_widget_bottom_action_bar_img, null);
        this.f398692c.addView(this.f398691b, new LinearLayout.LayoutParams(-1, -1));
        this.f398694e = CollectionsKt.mutableListOf(new OButton[]{(OButton) findViewById(R.id.action_button_0), (OButton) findViewById(R.id.action_button_1), (OButton) findViewById(R.id.action_button_2), (OButton) findViewById(R.id.action_button_3), (OButton) findViewById(R.id.action_button_4), (OButton) findViewById(R.id.action_button_5)});
        goto L53
    L45:
        if (r103.equals("l1") == false) goto L53;
        this.f398691b = FrameLayout.inflate(getContext(), R.layout.o_widget_bottom_action_bar_l1, null);
        this.f398692c.addView(this.f398691b, new LinearLayout.LayoutParams(-1, -1));
        this.f398694e = CollectionsKt.mutableListOf(new OButton[]{(OButton) findViewById(R.id.action_button_L10), (OButton) findViewById(R.id.action_button_L11)});
        goto L53
    L49:
        if (r103.equals("l1-primary") == false) goto L53;
        this.f398691b = FrameLayout.inflate(getContext(), R.layout.o_widget_bottom_action_bar_l1_primary, null);
        this.f398692c.addView(this.f398691b, new LinearLayout.LayoutParams(-1, -1));
        this.f398694e = CollectionsKt.mutableListOf(new OButton[]{(OButton) findViewById(R.id.action_button_L1_primary)});
        goto L53
    L8:
        TypedArray r128 = r100.getResources().obtainTypedArray(r113);
        ArrayList r129 = new ArrayList();
        int r130 = r128.length();
        int r131 = 0;
    L9:
        if (r131 >= r130) goto L11;
        r129.add(Integer.valueOf(r128.getResourceId(r131, 0)));
        r131 = r131 + 1;
        goto L9
    L11:
        r116 = CollectionsKt.toMutableList(r129);
        r128.recycle();
        goto L13
    L5:
        r115 = ArraysKt.toMutableList(r100.getResources().getStringArray(r112));
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
