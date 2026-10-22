package com.bytedance.awemeopen.apps.framework.feed.ui.information.leftcomponent;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.awemeopen.apps.framework.base.view.RoundImageView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.servicesapi.image.AoImageService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;
import r14.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0012\u0010\u0016B#\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0012\u0010\u0019R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/leftcomponent/LeftComponentItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/awemeopen/servicesapi/image/AoImageService;", "l", "Lkotlin/Lazy;", "getImageService", "()Lcom/bytedance/awemeopen/servicesapi/image/AoImageService;", "imageService", "", "n", "Ljava/lang/String;", "getContentScene", "()Ljava/lang/String;", "setContentScene", "(Ljava/lang/String;)V", "contentScene", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class LeftComponentItemView extends ConstraintLayout {
    public static final /* synthetic */ int o = 0;
    public View a;
    public View b;
    public View c;
    public RoundImageView d;
    public DmtTextView e;
    public DmtTextView f;
    public DmtTextView g;
    public DmtTextView h;
    public AoImageView i;
    public final Pair<Float, Float> j;
    public final Pair<Float, Float> k;
    public final Lazy l;
    public final Lazy m;
    public String n;

    private final AoImageService getImageService() {
        return (AoImageService) this.l.getValue();
    }

    public final String getContentScene() {
        return this.n;
    }

    public LeftComponentItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        new LinkedHashMap();
        super(r4);
        this.j = new Pair(Float.valueOf(33.0f), Float.valueOf(44.0f));
        this.k = new Pair(Float.valueOf(48.0f), Float.valueOf(64.0f));
        this.l = LazyKt.lazy(LeftComponentItemView$imageService$2.INSTANCE);
        this.m = LazyKt.lazy(LeftComponentItemView$isCheckBookButtonSingleClick$2.INSTANCE);
        this.n = "";
        init(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void init(Context r3) {
        View r4 = LayoutInflater.from(r3).inflate(2131558615, this, true);
        this.a = r4;
        AoImageView r0 = null;
        if (r4 == null) goto L5;
        View r5 = r4.findViewById(2131377748);
    L6:
        this.b = r5;
        View r6 = this.a;
        if (r6 == null) goto L9;
        View r7 = r6.findViewById(2131377747);
    L10:
        this.c = r7;
        View r8 = this.a;
        if (r8 == null) goto L13;
        RoundImageView r9 = (RoundImageView) r8.findViewById(2131377750);
    L14:
        this.d = r9;
        View r10 = this.a;
        if (r10 == null) goto L17;
        DmtTextView r11 = (DmtTextView) r10.findViewById(2131377746);
    L18:
        this.e = r11;
        View r12 = this.a;
        if (r12 == null) goto L21;
        DmtTextView r13 = (DmtTextView) r12.findViewById(2131377745);
    L22:
        this.f = r13;
        View r14 = this.a;
        if (r14 == null) goto L25;
        DmtTextView r15 = (DmtTextView) r14.findViewById(2131377751);
    L26:
        this.g = r15;
        View r16 = this.a;
        if (r16 == null) goto L29;
        DmtTextView r17 = (DmtTextView) r16.findViewById(2131377749);
    L30:
        this.h = r17;
        View r18 = this.a;
        if (r18 == null) goto L33;
        r0 = (AoImageView) r18.findViewById(2131377744);
    L33:
        this.i = r0;
        AppCompatTextView r19 = this.f;
        if (r19 == null) goto L37;
        r19.setText((String) AoBizCardSettingsConfig.a.getValue());
    L37:
        AppCompatTextView r20 = this.e;
        if (r20 == null) goto L42;
        r20.setText((String) AoBizCardSettingsConfig.a.getValue());
        return;
    L42:
        return;
    L29:
        r17 = null;
        goto L30
    L25:
        r15 = null;
        goto L26
    L21:
        r13 = null;
        goto L22
    L17:
        r11 = null;
        goto L18
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final void setContentScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.n = r2;
    }

    public LeftComponentItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        new LinkedHashMap();
        super(r3, r4);
        this.j = new Pair(Float.valueOf(33.0f), Float.valueOf(44.0f));
        this.k = new Pair(Float.valueOf(48.0f), Float.valueOf(64.0f));
        this.l = LazyKt.lazy(LeftComponentItemView$imageService$2.INSTANCE);
        this.m = LazyKt.lazy(LeftComponentItemView$isCheckBookButtonSingleClick$2.INSTANCE);
        this.n = "";
        init(r3);
    }

    public LeftComponentItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.j = new Pair(Float.valueOf(33.0f), Float.valueOf(44.0f));
        this.k = new Pair(Float.valueOf(48.0f), Float.valueOf(64.0f));
        this.l = LazyKt.lazy(LeftComponentItemView$imageService$2.INSTANCE);
        this.m = LazyKt.lazy(LeftComponentItemView$isCheckBookButtonSingleClick$2.INSTANCE);
        this.n = "";
        init(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(final w r8, final i r9, final l r10, final int r11) {
        Intrinsics.checkNotNullParameter(r9, "leftComponentEvent");
        Intrinsics.checkNotNullParameter(r10, "model");
        if (r8 != null) goto L5;
        return;
    L5:
        com.bytedance.awemeopen.infra.base.image.b r0 = new com.bytedance.awemeopen.infra.base.image.b(r8.c());
        AppCompatImageView r1 = this.d;
        Intrinsics.checkNotNullParameter(r0, "aoAppLoadImageOptions");
        r0.b(2131100274);
        r0.d = r1;
        getImageService().Q0(getContext(), r0.a());
        View r2 = this.c;
        if (r2 == null) goto L9;
        r2.setOnClickListener(new j(r8, r11, r9, r10));
    L9:
        if (((Boolean) this.m.getValue()).booleanValue() == false) goto L13;
        AppCompatTextView r3 = this.f;
        if (r3 == null) goto L13;
        r3.setOnClickListener(new k(r10, r11, r8, r9));
    L13:
        AppCompatTextView r12 = this.g;
        if (r12 == null) goto L17;
        r12.setText(r8.i());
    L17:
        AppCompatTextView r13 = this.h;
        if (r13 == null) goto L21;
        r13.setText(r8.a());
    L21:
        int r14 = r8.g();
        int r15 = com.bytedance.awemeopen.infra.util.e.a(getContext(), 8.0f);
        int r16 = com.bytedance.awemeopen.infra.util.e.a(getContext(), 12.0f);
        if (this.n.length() != 0) goto L24;
        boolean r4 = true;
    L26:
        if (r4 == false) goto L31;
        if (((Number) AoBizCardSettingsConfig.e.getValue()).intValue() == 2) goto L32;
    L33:
        boolean r5 = false;
    L34:
        ViewGroup.LayoutParams r6 = null;
        ViewGroup.LayoutParams r7 = null;
        LinearLayout.LayoutParams r17 = null;
        if (r14 == 0) goto L135;
        if (r14 == 1) goto L77;
        if (r14 != 2) goto L179;
        AppCompatImageView r18 = this.d;
        if (r18 == null) goto L42;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
    L43:
        if (r19 == null) goto L46;
        r19.width = com.bytedance.awemeopen.infra.util.e.a(getContext(), ((Number) this.j.getFirst()).floatValue());
    L46:
        AppCompatImageView r20 = this.d;
        if (r20 == null) goto L49;
        r7 = r20.getLayoutParams();
    L49:
        if (r7 == null) goto L52;
        r7.height = com.bytedance.awemeopen.infra.util.e.a(getContext(), ((Number) this.j.getSecond()).floatValue());
    L52:
        if (r5 == true) goto L60;
        AppCompatTextView r21 = this.e;
        if (r21 == null) goto L57;
        r21.setVisibility(0);
    L57:
        DmtTextView r22 = this.e;
        if (r22 == null) goto L63;
        r22.setBackgroundResource(2131231536);
    L63:
        AppCompatTextView r23 = this.f;
        if (r23 == null) goto L67;
        r23.setVisibility(8);
    L67:
        View r24 = this.c;
        if (r24 == null) goto L71;
        r24.setVisibility(8);
    L71:
        AppCompatTextView r25 = this.h;
        if (r25 == null) goto L74;
        r25.setLines(1);
    L74:
        View r26 = this.b;
        if (r26 == null) goto L174;
        r26.setPadding(r15, r15, r15, r15);
        return;
    L174:
        return;
    L60:
        AoImageView r27 = this.i;
        if (r27 == null) goto L63;
        x54.b.d(r27);
        goto L63
    L42:
        r19 = null;
        goto L43
    L179:
        return;
    L77:
        AppCompatImageView r28 = this.d;
        if (r28 == null) goto L80;
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
    L81:
        if (r29 == null) goto L84;
        r29.width = com.bytedance.awemeopen.infra.util.e.a(getContext(), ((Number) this.k.getFirst()).floatValue());
    L84:
        AppCompatImageView r30 = this.d;
        if (r30 == null) goto L87;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
    L88:
        if (r31 == null) goto L91;
        r31.height = com.bytedance.awemeopen.infra.util.e.a(getContext(), ((Number) this.k.getSecond()).floatValue());
    L91:
        if (r5 == true) goto L96;
        AppCompatTextView r32 = this.e;
        if (r32 == null) goto L99;
        r32.setVisibility(8);
    L99:
        AppCompatTextView r33 = this.f;
        if (r33 == null) goto L103;
        r33.setVisibility(0);
    L103:
        View r34 = this.c;
        if (r34 == null) goto L107;
        r34.setVisibility(0);
    L107:
        AppCompatTextView r35 = this.g;
        if (r35 == null) goto L111;
        r35.setTextSize(15.0f);
    L111:
        AppCompatTextView r36 = this.h;
        if (r36 == null) goto L115;
        r36.setMaxLines(2);
    L115:
        AppCompatTextView r37 = this.h;
        if (r37 == null) goto L118;
        r37.setLines(2);
    L118:
        AppCompatTextView r38 = this.h;
        if (r38 == null) goto L121;
        ViewGroup.LayoutParams r39 = r38.getLayoutParams();
    L122:
        Intrinsics.checkNotNull(r39, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        Resources r40 = Resources.getSystem();
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) r39)).topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r40, r40.getDisplayMetrics())));
        AppCompatTextView r41 = this.f;
        if (r41 == null) goto L125;
        ViewGroup.LayoutParams r42 = r41.getLayoutParams();
    L127:
        if ((r42 instanceof LinearLayout.LayoutParams) == false) goto L129;
        r17 = (LinearLayout.LayoutParams) r42;
    L129:
        if (r17 == null) goto L132;
        r17.topMargin = com.bytedance.awemeopen.infra.util.e.a(getContext(), 8.0f);
    L132:
        View r43 = this.b;
        if (r43 == null) goto L176;
        r43.setPadding(r16, r16, r16, r16);
        return;
    L176:
        return;
    L125:
        r42 = null;
        goto L127
    L121:
        r39 = null;
        goto L122
    L96:
        AoImageView r44 = this.i;
        if (r44 == null) goto L99;
        x54.b.a(r44);
        goto L99
    L87:
        r31 = null;
        goto L88
    L80:
        r29 = null;
        goto L81
    L135:
        AppCompatImageView r45 = this.d;
        if (r45 == null) goto L138;
        ViewGroup.LayoutParams r46 = r45.getLayoutParams();
    L139:
        if (r46 == null) goto L142;
        r46.width = com.bytedance.awemeopen.infra.util.e.a(getContext(), ((Number) this.j.getFirst()).floatValue());
    L142:
        AppCompatImageView r47 = this.d;
        if (r47 == null) goto L145;
        r6 = r47.getLayoutParams();
    L145:
        if (r6 == null) goto L148;
        r6.height = com.bytedance.awemeopen.infra.util.e.a(getContext(), ((Number) this.j.getSecond()).floatValue());
    L148:
        if (r5 == true) goto L156;
        AppCompatTextView r48 = this.e;
        if (r48 == null) goto L153;
        r48.setVisibility(0);
    L153:
        DmtTextView r49 = this.e;
        if (r49 == null) goto L159;
        r49.setBackgroundResource(2131231535);
    L159:
        AppCompatTextView r50 = this.f;
        if (r50 == null) goto L163;
        r50.setVisibility(8);
    L163:
        View r51 = this.c;
        if (r51 == null) goto L167;
        r51.setVisibility(8);
    L167:
        AppCompatTextView r52 = this.h;
        if (r52 == null) goto L170;
        r52.setLines(1);
    L170:
        View r53 = this.b;
        if (r53 == null) goto L178;
        r53.setPadding(r15, r15, r15, r15);
        return;
    L178:
        return;
    L156:
        AoImageView r54 = this.i;
        if (r54 == null) goto L159;
        x54.b.d(r54);
        goto L159
    L138:
        r46 = null;
    L32:
        r5 = true;
        goto L34
    L31:
        if (((JSONObject) AoBizCardSettingsConfig.f.getValue()).optInt(this.n, -1) != 2) goto L33;
    L24:
        r4 = false;
        goto L26
    }
}
