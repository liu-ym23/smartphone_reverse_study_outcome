package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.android.flexbox.FlexboxLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.cot.detail.j;
import com.ss.android.lark.chat.cot.detail.u;
import com.ss.android.lark.chat.cot.detail.v;
import com.ss.android.lark.chat.cot.detail.w;
import com.ss.android.lark.chat.cot.detail.widget.CollapsibleFlexboxLayout;
import com.ss.android.lark.movable.MarkdownMovableView;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class CotToolCallBlock extends com.ss.android.lark.chat.cot.detail.blueprint.block.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Regex f414895r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Regex f414896s = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f414897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.chat.cot.a f414898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f414899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f414900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.chat.cot.detail.blueprint.b.e f414901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f414902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f414903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f414904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f414905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f414906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f414907m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f414908n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f414909o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f414910p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f414911q;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.cot.detail.blueprint.block.CotToolCallBlock$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    public static final class b implements k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f414912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f414913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f414914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f414915d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinearLayout f414916e;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f414912a;
        }

        public final void a(d r100) {
            Iterator r101 = CollectionsKt.listOf(new View[]{this.f414913b, this.f414914c, this.f414915d}).iterator();
        L4:
            if (r101.hasNext() == false) goto L10;
            View r102 = (View) r101.next();
            r102.setOnClickListener(r100);
            if (r100 == null) goto L8;
            boolean r103 = true;
        L9:
            r102.setClickable(r103);
            goto L4
        L8:
            r103 = false;
            goto L9
        }

        public b(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f414912a = r100;
            View r102 = r100.findViewById(R.id.cot_tool_call_title_row);
            this.f414913b = r102;
            this.f414914c = (TextView) r100.findViewById(R.id.cot_tool_call_title);
            this.f414915d = (ImageView) r100.findViewById(R.id.cot_tool_call_arrow);
            this.f414916e = (LinearLayout) r100.findViewById(R.id.cot_tool_call_content);
            r102.setPaddingRelative(r101, r102.getPaddingTop(), r102.getPaddingEnd(), r102.getPaddingBottom());
        }
    }

    static {
        f414895r = new Regex("`+");
        f414896s = new Regex("[A-Za-z0-9_+.#-]+");
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f414901g;
    }

    public static void g(ViewGroup r100) {
        int r101 = r100.getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        h(r100.getChildAt(r102));
        r102 = r102 + 1;
        goto L3
    }

    public static void h(View r100) {
        if ((r100 instanceof MarkdownMovableView) == false) goto L12;
        MarkdownMovableView r101 = (MarkdownMovableView) r100;
        CotMovableSetup.f414878a.getClass();
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r101, "view");
        Object r102 = r101.getTag(R.id.cot_movable_render_delegate);
        if ((r102 instanceof c) == false) goto L7;
        c r103 = (c) r102;
    L8:
        if (r103 == null) goto L10;
        r103.b();
        return;
    L10:
        r101.d();
        return;
    L7:
        r103 = null;
        goto L8
    L12:
        if ((r100 instanceof ViewGroup) == false) goto L17;
        g((ViewGroup) r100);
        return;
    }

    @Override // com.ss.android.lark.chat.cot.detail.blueprint.block.a
    public final void d(k<?> r100) {
        if ((r100 instanceof b) == false) goto L5;
        b r101 = (b) r100;
    L6:
        if (r101 == null) goto L9;
        g(r101.f414916e);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final MarkdownMovableView f(LinearLayout r100, View r110, String r111) {
        if (r111.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L42;
        CotMovableSetup r102 = CotMovableSetup.f414878a;
        com.ss.android.lark.chat.cot.a r103 = this.f414898d;
        r102.getClass();
        if (CotMovableSetup.a(r103) == true) goto L12;
        return null;
    L12:
        if ((r110 instanceof MarkdownMovableView) == false) goto L14;
        MarkdownMovableView r112 = (MarkdownMovableView) r110;
    L16:
        if (r112 != null) goto L39;
        r112 = new MarkdownMovableView(r100.getContext(), null);
        r112.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        CotMovableSetup.d(r102, r112, "text-caption", 4);
    L39:
        float r104 = CotMovableSetup.c(r100);     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r112, "view");     // Catch: Throwable -> L27
        Object r105 = r112.getTag(R.id.cot_movable_render_delegate);     // Catch: Throwable -> L27
        if ((r105 instanceof c) == false) goto L22;
        c r106 = (c) r105;     // Catch: Throwable -> L27
    L23:
        if (r106 != null) goto L25;
        r106 = CotMovableSetup.d(r102, r112, "text-caption", 4);     // Catch: Throwable -> L27
    L25:
        r106.c(r111, r104);     // Catch: Throwable -> L27
        return r112;
    L22:
        r106 = null;
    L27:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L36
        CotMovableSetup.f414878a.getClass();     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r112, "view");     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r112, "view");     // Catch: Throwable -> L36
        Object r108 = r112.getTag(R.id.cot_movable_render_delegate);     // Catch: Throwable -> L36
        if ((r108 instanceof c) == false) goto L30;
        c r109 = (c) r108;     // Catch: Throwable -> L36
    L31:
        if (r109 == null) goto L33;
        r109.b();     // Catch: Throwable -> L36
    L34:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
        return null;
    L33:
        r112.d();     // Catch: Throwable -> L36
        goto L34
    L30:
        r109 = null;
    L36:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    L14:
        r112 = null;
        goto L16
    L42:
        return null;
    L5:
        r101 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v5, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.ss.android.lark.chat.cot.detail.blueprint.block.CotToolCallBlock, com.ss.android.lark.chat.cot.detail.blueprint.block.a] */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v20, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r6v12, types: [android.view.ViewGroup, com.google.android.flexbox.FlexboxLayout, com.ss.android.lark.chat.cot.detail.widget.CollapsibleFlexboxLayout] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(m<com.ss.android.lark.chat.cot.detail.k> r210, q<com.ss.android.lark.chat.cot.detail.k> r211, com.ss.android.lark.chat.cot.detail.k r212) {
        Intrinsics.checkNotNullParameter(r210, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r211, "layout");
        Intrinsics.checkNotNullParameter(r212, "data");
        b r100 = (b) r211.c(this.f414901g, this.f414922b, new CotToolCallBlock$update$$inlined$acquireBlockView$1(this));
        Context r101 = r100.f414912a.getContext();
        if (this.f414899e == false) goto L11;
        com.ss.android.lark.chat.cot.detail.widget.a r102 = com.ss.android.lark.chat.cot.detail.widget.a.f415041a;
        Intrinsics.checkNotNull(r101);
        u r103 = r212.c();
        if (r103 == null) goto L7;
        com.ss.android.lark.chat.cot.c r104 = r103.f415008a;
    L8:
        r102.getClass();
        if (com.ss.android.lark.chat.cot.detail.widget.a.h(r101, r104) == false) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        int r106 = this.f414911q;
    L15:
        View r107 = r100.f414913b;
        r107.setPaddingRelative(r106, r107.getPaddingTop(), r100.f414913b.getPaddingEnd(), r100.f414913b.getPaddingBottom());
        String r108 = r212.f414984c;
        if (r108 != null) goto L18;
    L25:
        r108 = r101.getString(R.string.Lark_IM_AgentCot_TaskRunning_Text);
    L26:
        ?? r109 = r100.f414916e;
        u r110 = r212.c();
        if (r110 == null) goto L35;
        List<v> r111 = r110.f415009b;
        if (r111 == null) goto L35;
        if ((!r111.isEmpty()) == true) goto L34;
        r111 = null;
    L34:
        if (r111 == null) goto L35;
    L50:
        if (r111.isEmpty() == false) goto L60;
        int r112 = r109.getChildCount() - 1;
        if (r112 < 0) goto L59;
    L53:
        View r113 = r109.getChildAt(r112);
        if (r113 == null) goto L57;
        h(r113);
        r109.removeViewAt(r112);
    L57:
        if (r112 == 0) goto L59;
        r112 = r112 - 1;
    L59:
        r109.setVisibility(8);
        boolean r114 = true;
    L191:
        if (this.f414899e == true) goto L208;
        r100.f414914c.setText(r108);
        TextView r115 = r100.f414914c;
        if (r108.length() != 0) goto L195;
        boolean r116 = true;
    L196:
        if (r116 == false) goto L198;
        int r117 = 8;
    L199:
        r115.setVisibility(r117);
        r100.f414915d.setVisibility(8);
        r100.a(null);
        r100.f414913b.setSelected(false);
        LinearLayout r118 = r100.f414916e;
        if (r118.getChildCount() > 0) goto L203;
        r114 = false;
    L203:
        if (r114 == false) goto L205;
        int r119 = 0;
    L206:
        r118.setVisibility(r119);
        ViewCompat.setAccessibilityDelegate(r100.f414913b, null);
    L239:
        e(r100.f414912a, r212);
        e(r100.f414914c, r212);
        return;
    L205:
        r119 = 8;
        goto L206
    L198:
        r117 = 0;
        goto L199
    L195:
        r116 = false;
        goto L196
    L208:
        if (r100.f414916e.getChildCount() <= 0) goto L210;
        boolean r120 = true;
    L211:
        if (r120 == false) goto L215;
        j r121 = this.f414897c;
        String r122 = r212.f414982a;
        r121.getClass();
        Intrinsics.checkNotNullParameter(r122, "stableId");
        if (r121.a(r122 + "#tool-call") == false) goto L215;
        boolean r123 = true;
    L216:
        r100.f414914c.setText(r108);
        TextView r124 = r100.f414914c;
        if (r108.length() == 0) goto L220;
        r114 = false;
    L220:
        if (r114 == false) goto L222;
        int r125 = 8;
    L223:
        r124.setVisibility(r125);
        ImageView r126 = r100.f414915d;
        if (r120 == false) goto L226;
        int r127 = 0;
    L227:
        r126.setVisibility(r127);
        LinearLayout r128 = r100.f414916e;
        if (r123 == false) goto L230;
        int r129 = 0;
    L231:
        r128.setVisibility(r129);
        r100.f414913b.setSelected(r123);
        if (r120 == true) goto L234;
        r100.a(null);
        ViewCompat.setAccessibilityDelegate(r100.f414913b, null);
        goto L239
    L234:
        ImageView r130 = r100.f414915d;
        if (r123 == false) goto L237;
        int r131 = R.drawable.ud_icon_down_small_ccm_outlined;
    L238:
        r130.setImageResource(r131);
        r100.a(new d(this, r212, r100));
        ViewCompat.setAccessibilityDelegate(r100.f414913b, new CotToolCallBlock$bindExpansion$2());
        goto L239
    L237:
        r131 = R.drawable.ud_icon_right_small_ccm_outlined;
        goto L238
    L230:
        r129 = 8;
        goto L231
    L226:
        r127 = 8;
        goto L227
    L222:
        r125 = 0;
    L215:
        r123 = false;
        goto L216
    L210:
        r120 = false;
        goto L211
    L60:
        Iterator r132 = r111.iterator();
        int r133 = 0;
    L62:
        if (r132.hasNext() == false) goto L174;
        Object r134 = r132.next();
        int r135 = r133 + 1;
        if (r133 >= 0) goto L66;
        CollectionsKt.throwIndexOverflow();
    L66:
        v r136 = (v) r134;
        View r137 = r109.getChildAt(r133);
        String r138 = r212.f414982a;
        if ((r136 instanceof v.c) == false) goto L74;
        v.c r139 = (v.c) r136;
        MarkdownMovableView r140 = f(r109, r137, r139.f415014a);
        if (r140 != null) goto L71;
        String r141 = r139.f415014a;
        TextView r142 = new TextView(r109.getContext());
        r142.setText(r141);
        r142.setTextColor(UDColorUtils.getColor(r142.getContext(), R.color.text_caption));
        r142.setTextSize(16.0f);
        r142.setLineSpacing(h18.d.a(r142.getContext(), 2.0f), 1.0f);
        Object r143 = r142;
    L72:
        int r144 = r135;
        Object r145 = r143;
    L120:
        ?? r146 = r145;
    L152:
        if (r146 == r137) goto L159;
        if (r137 == null) goto L155;
        h(r137);
        r109.removeViewAt(r133);
    L155:
        LinearLayout.LayoutParams r147 = new LinearLayout.LayoutParams(-1, -2);
        if (r133 <= 0) goto L158;
        r147.topMargin = this.f414902h;
    L158:
        r109.addView(r146, r133, r147);
    L171:
        r132 = r132;
        r133 = r144;
        goto L62
    L159:
        ViewGroup.LayoutParams r148 = r146.getLayoutParams();
        if ((r148 instanceof LinearLayout.LayoutParams) == false) goto L162;
        LinearLayout.LayoutParams r149 = (LinearLayout.LayoutParams) r148;
    L163:
        if (r149 == null) goto L171;
        if (r133 <= 0) goto L167;
        int r150 = this.f414902h;
    L169:
        if (r149.topMargin == r150) goto L171;
        r149.topMargin = r150;
        r146.setLayoutParams(r149);
        goto L171
    L167:
        r150 = 0;
        goto L169
    L162:
        r149 = null;
        goto L163
    L71:
        r143 = r140;
        goto L72
    L74:
        if ((r136 instanceof v.a) == false) goto L121;
        v.a r151 = (v.a) r136;
        String r152 = r151.f415011a;
        if (StringsKt.equals(r151.f415012b, "json", true) == false) goto L94;
        String r153 = StringsKt.trim(r152).toString();
        if (r153.length() != 0) goto L81;
        boolean r154 = true;
    L82:
        if (r154 == true) goto L94;
        char r155 = StringsKt.first(r153);     // Catch: JSONException -> L93
        if (r155 != '[') goto L87;
        String r156 = new JSONArray(r153).toString(2);     // Catch: JSONException -> L93
    L91:
        Intrinsics.checkNotNull(r156);     // Catch: JSONException -> L93
        r152 = r156;
        goto L94
    L87:
        if (r155 == '{') goto L89;
        r156 = r152;
        goto L91
    L89:
        r156 = new JSONObject(r153).toString(2);     // Catch: JSONException -> L93
        goto L91
    L81:
        r154 = false;
    L94:
        String r157 = r151.f415012b;
        r132 = r132;
        r144 = r135;
        Integer r158 = (Integer) SequencesKt.maxOrNull(SequencesKt.map(Regex.findAll$default(f414895r, r152, 0, 2, null), CotToolCallBlock$buildCodeFence$maxBacktickCount$1.INSTANCE));
        if (r158 == null) goto L97;
        int r159 = r158.intValue();
    L98:
        String r160 = StringsKt.repeat(InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER, Math.max(3, r159 + 1));
        if (r157 == null) goto L113;
        String r161 = StringsKt.trim(r157).toString();
        if (r161 == null) goto L113;
        if (r161.length() <= 0) goto L105;
        boolean r162 = true;
    L106:
        if (r162 == true) goto L108;
    L110:
        boolean r163 = false;
    L111:
        if (r163 == false) goto L113;
    L114:
        if (r161 != null) goto L116;
        r161 = "";
    L116:
        MarkdownMovableView r164 = f(r109, r137, r160 + r161 + '\n' + r152 + '\n' + r160);
        if (r164 != null) goto L119;
        String r165 = r151.f415012b;
        Intrinsics.checkNotNullParameter(r152, "code");
        v.a r166 = new v.a(r152, r165);
        TextView r167 = new TextView(r109.getContext());
        r167.setText(r166.f415011a);
        r167.setTextColor(UDColorUtils.getColor(r167.getContext(), R.color.text_caption));
        r167.setTextSize(16.0f);
        r167.setLineSpacing(h18.d.a(r167.getContext(), 2.0f), 1.0f);
        int r168 = this.f414903i;
        int r169 = this.f414904j;
        r167.setPadding(r168, r169, r168, r169);
        GradientDrawable r170 = new GradientDrawable();
        r170.setCornerRadius(this.f414905k);
        r170.setColor(UDColorUtils.getColor(r167.getContext(), R.color.bg_float));
        r167.setBackground(r170);
        r145 = r167;
        goto L120
    L119:
        r145 = r164;
        goto L120
    L108:
        if (f414896s.matches(r161) == false) goto L110;
        r163 = true;
        goto L111
    L105:
        r162 = false;
    L113:
        r161 = null;
        goto L114
    L97:
        r159 = 0;
        goto L98
    L121:
        r132 = r132;
        r144 = r135;
        if ((r136 instanceof v.b) == false) goto L173;
        v.b r171 = (v.b) r136;
        int r172 = j.f414980b;
        Intrinsics.checkNotNullParameter(r138, "stableId");
        final String r173 = r138 + "#list#" + r133;
        if (r171.f415013a.isEmpty() == false) goto L127;
        final ?? r174 = 0;
    L149:
        if (r174 == 0) goto L151;
        r146 = r174;
        goto L152
    L151:
        r146 = new View(r109.getContext());
        goto L152
    L127:
        r174 = new CollapsibleFlexboxLayout(r109.getContext(), null, 6, 0);
        r174.setFlexWrap(1);
        r174.setCollapsedMaxLines(4);
        r174.setItemHorizontalSpacing(this.f414908n);
        r174.setItemVerticalSpacing(this.f414908n);
        r174.setShowCollapseButtonWhenExpanded(false);
        r174.setExpanded(this.f414897c.a(r173));
        r174.setOnFoldButtonClickListener(new CotToolCallBlock$createListResultAreaView$1$1(this, r173));
        r174.setFoldButtonConfigProvider(new CotToolCallBlock$createListResultAreaView$1$2(r174, this));
        Iterator r175 = r171.f415013a.iterator();
    L129:
        if (r175.hasNext() == false) goto L149;
        w r176 = (w) r175.next();
        ?? r177 = new LinearLayout(r174.getContext());
        r177.setOrientation(0);
        r177.setGravity(17);
        r177.setTag(r176);
        r177.setBackgroundResource(R.drawable.bg_translation_entry);
        int r178 = this.f414906l;
        int r179 = this.f414907m;
        r177.setPadding(r178, r179, r178, r179);
        CotMovableSetup r180 = CotMovableSetup.f414878a;
        String r181 = r176.f415016b;
        r180.getClass();
        String r182 = CotMovableSetup.b(r181);
        if (r182 == null) goto L133;
        r177.setClickable(true);
        r177.setOnClickListener(new e(r182));
    L133:
        com.ss.android.lark.chat.cot.c r183 = r176.f415017c;
        if (r183 == null) goto L138;
        ImageView r184 = new ImageView(r177.getContext());
        com.ss.android.lark.chat.cot.detail.widget.a.f415041a.getClass();
        if (com.ss.android.lark.chat.cot.detail.widget.a.e(r184, r183) == false) goto L138;
        int r185 = this.f414909o;
        LinearLayout.LayoutParams r186 = new LinearLayout.LayoutParams(r185, r185);
        r186.setMarginEnd(this.f414910p);
        r184.setLayoutParams(r186);
    L140:
        if (r184 == null) goto L142;
        r177.addView(r184);
    L142:
        TextView r187 = new TextView(r177.getContext());
        String r188 = r176.f415015a;
        if (r188 != null) goto L148;
        r188 = r176.f415016b;
        if (r188 != null) goto L148;
        r188 = "";
    L148:
        r187.setText(r188);
        r187.setTextColor(UDColorUtils.getColor(r187.getContext(), R.color.text_caption));
        r187.setTextSize(14.0f);
        r187.setMaxLines(1);
        r187.setEllipsize(TextUtils.TruncateAt.END);
        r187.setGravity(17);
        r177.addView(r187);
        FlexboxLayout.LayoutParams r189 = new FlexboxLayout.LayoutParams(-2, -2);
        r189.setMargins(0, 0, 0, 0);
        r177.setLayoutParams(r189);
        r174.addView(r177);
    L138:
        r184 = null;
        goto L140
    L173:
        throw new NoWhenBranchMatchedException();
    L174:
        r114 = true;
        int r190 = r111.size();
        int r191 = r109.getChildCount() - 1;
        if (r190 > r191) goto L183;
    L176:
        View r192 = r109.getChildAt(r191);
        if (r192 == null) goto L180;
        h(r192);
        r109.removeViewAt(r191);
    L180:
        if (r191 == r190) goto L183;
        r191 = r191 - 1;
    L183:
        if (r109.getChildCount() != 0) goto L185;
        boolean r193 = true;
    L186:
        if (r193 == false) goto L188;
        int r194 = 8;
    L189:
        r109.setVisibility(r194);
        goto L191
    L188:
        r194 = 0;
        goto L189
    L185:
        r193 = false;
    L35:
        CharSequence r195 = r212.f414985d;
        if (r195 == null) goto L48;
        String r196 = r195.toString();
        if (r196 == null) goto L48;
        if (r196.length() <= 0) goto L42;
        boolean r197 = true;
    L43:
        if (r197 == true) goto L46;
        r196 = null;
    L46:
        if (r196 == null) goto L48;
        r111 = CollectionsKt.listOf(new v.c(r196));
        goto L50
    L42:
        r197 = false;
    L48:
        r111 = CollectionsKt.emptyList();
        goto L50
    L18:
        if (r108.length() <= 0) goto L20;
        boolean r198 = true;
    L21:
        if (r198 == true) goto L24;
        r108 = null;
    L24:
        if (r108 != null) goto L26;
    L20:
        r198 = false;
        goto L21
    L14:
        r106 = 0;
        goto L15
    L7:
        r104 = null;
    L11:
        r105 = false;
        goto L12
    }

    @Override // com.ss.android.lark.chat.cot.detail.blueprint.block.a, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(m<com.ss.android.lark.chat.cot.detail.k> r100, q<com.ss.android.lark.chat.cot.detail.k> r101, com.ss.android.lark.chat.cot.detail.k r102) {
        update2(r100, r101, r102);
    }

    public CotToolCallBlock(g r100, j r101, com.ss.android.lark.chat.cot.a r102, boolean r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "expandStore");
        Intrinsics.checkNotNullParameter(r102, "cotFeatureGate");
        Intrinsics.checkNotNullParameter(r104, "onToolCallToggle");
        super(r100);
        this.f414897c = r101;
        this.f414898d = r102;
        this.f414899e = r103;
        this.f414900f = r104;
        this.f414901g = com.ss.android.lark.chat.cot.detail.blueprint.b.f414860c;
        this.f414902h = (int) h18.d.a(r100.getContext(), 8.0f);
        this.f414903i = (int) h18.d.a(r100.getContext(), 8.0f);
        this.f414904j = (int) h18.d.a(r100.getContext(), 6.0f);
        this.f414905k = h18.d.a(r100.getContext(), 6.0f);
        this.f414906l = (int) h18.d.a(r100.getContext(), 10.0f);
        this.f414907m = (int) h18.d.a(r100.getContext(), 4.0f);
        this.f414908n = (int) h18.d.a(r100.getContext(), 8.0f);
        this.f414909o = (int) h18.d.a(r100.getContext(), 14.0f);
        this.f414910p = (int) h18.d.a(r100.getContext(), 4.0f);
        this.f414911q = (int) h18.d.a(r100.getContext(), 24.0f);
    }
}
