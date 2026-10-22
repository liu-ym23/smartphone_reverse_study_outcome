package com.larksuite.component.card.component.personlist;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larksuite.component.card.component.personlist.avatar.SimpleUserLoader;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larus.nova.R;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y6a.i;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J6\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0017\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001eH\u0002J\u000e\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonListShadowNode;", "Lcom/lynx/tasm/behavior/shadow/ShadowNode;", "Lcom/lynx/tasm/behavior/shadow/MeasureFunc;", "<init>", "()V", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "mText", "", "mProp", "Lcom/larksuite/component/card/component/personlist/PersonListProps;", "setContext", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "setContent", SlcElement.KEY_PROPS, "Lcom/lynx/react/bridge/ReadableMap;", "onLayout", "left", "", "top", "width", "height", "measure", "", "node", "Lcom/lynx/tasm/behavior/shadow/LayoutNode;", "", "widthMode", "Lcom/lynx/tasm/behavior/shadow/MeasureMode;", "heightMode", "getExtraBundle", "", "getAndroidMode", "measureWidthMode", "setClickPersonListener", "clickPersonListener", "Lcom/larksuite/component/card/component/personlist/IClickPersonListener;", "setClickMoreListener", "clickMoreListener", "Lcom/larksuite/component/card/component/personlist/PersonListLynxUI$ClickMoreListener;", "mClickPersonListener", "mClickMoreListener", "Lcom/larksuite/component/card/component/personlist/IClickMoreListener;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonListShadowNode extends ShadowNode implements y6a.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AppCompatTextView f283424v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f283425w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PersonListProps f283426x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.larksuite.component.card.component.personlist.b f283427y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PersonListLynxUI.a f283428z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f283429a = null;

        static {
            int[] r100 = new int[MeasureMode.values().length];
            r100[MeasureMode.EXACTLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MeasureMode.UNDEFINED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MeasureMode.AT_MOST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f283429a = r100;
        }
    }

    static {
    }

    public PersonListShadowNode() {
        i(this);
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final Object m() {
        return this.f283425w;
    }

    public static int C(MeasureMode r100) {
        int r101 = b.f283429a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 1073741824;
    L5:
        if (r101 != 2) goto L7;
        return 0;
    L7:
        if (r101 != 3) goto L10;
        return Integer.MIN_VALUE;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @LynxProp(name = SlcElement.KEY_PROPS)
    public final void setContent(ReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        ICardDependency r101 = null;
        this.f283425w = null;
        Gson r102 = com.larksuite.component.card.component.g.f283368a;     // Catch: Throwable -> L5
        PersonListProps r103 = (PersonListProps) com.larksuite.component.card.component.g.c(r100, PersonListProps.class);     // Catch: Throwable -> L5
    L7:
        if (r103 != null) goto L10;
        Log.e("PersonListShadowNode", "setContent fail, content is empty");
        return;
    L10:
        this.f283426x = r103;
        AppCompatTextView r104 = this.f283424v;
        if (r104 == null) goto L16;
        TextPaint r105 = r104.getPaint();
        g r106 = g.f283510a;
        PersonListProps r107 = this.f283426x;
        r106.getClass();
        r105.setTextSize(g.h(r107));
        int r108 = g.g(this.f283426x);
        AppCompatTextView r109 = this.f283424v;
        if (r109 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r109 = null;
    L15:
        r109.getPaint().setColor(r108);
    L16:
        com.larksuite.component.card.cardcontainer.c r110 = (com.larksuite.component.card.cardcontainer.c) getContext().getSharedData("card_share_data", com.larksuite.component.card.cardcontainer.c.class);
        if (r110 == null) goto L21;
        CardContext r111 = r110.f283235c;
        if (r111 == null) goto L21;
        r101 = r111.getDependency();
    L21:
        PersonListLynxUI.b r112 = new PersonListLynxUI.b(this, r101);
        Intrinsics.checkNotNullParameter(r112, "clickPersonListener");
        this.f283427y = r112;
        q();
        return;
    L5:
        th = move-exception;
        Log.e("PersonListShadowNode", "props from lynx transform failed", th);
        r103 = null;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void w(LynxContext r100) {
        this.f382220m = r100;
        if (r100 == null) goto L6;
        AppCompatTextView r101 = new AppCompatTextView(r100.getContext());
        r101.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        TextPaint r102 = r101.getPaint();
        g.f283510a.getClass();
        r102.setTextSize(g.h(null));
        this.f283424v = r101;
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void f(int r100, int r101) {
        TraceEvent.beginSection("PersonListShadowNode.onLayout");
        this.f382206e = false;
        TraceEvent.endSection("PersonListShadowNode.onLayout");
    }

    @Override // y6a.h
    public final long c(LayoutNode r610, float r611, MeasureMode r612, float r613, MeasureMode r614) {
        MeasureMode r100 = r612;
        String r101 = "PersonListShadowNode.measure";
        TraceEvent.beginSection("PersonListShadowNode.measure");
        Log.d("PersonListShadowNode", "\n***************** measure start **********************\n");
        Log.d("PersonListShadowNode", "\n***************** origin width: " + r611 + " height:" + r613 + "  widthMode:" + r100 + "  heightMode:" + r614 + " **********************\n");
        MeasureMode r102 = MeasureMode.UNDEFINED;
        Float r110 = Float.valueOf(0.0f);
        if (r100 == r102) goto L17;
        if (r614 == r102) goto L17;
        if (r611 != 0.0f) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L17;
        if (r613 != 0.0f) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L17;
        return i.b(0, 0);
    L13:
        r104 = false;
        goto L14
    L8:
        r103 = false;
    L17:
        MeasureMode r105 = MeasureMode.EXACTLY;
        if (r100 == r105) goto L20;
    L25:
        float r111 = 32767.0f;
    L27:
        if (r611 != 0.0f) goto L29;
        boolean r112 = true;
    L30:
        if (r112 == false) goto L33;
        if (r100 != r102) goto L33;
        r100 = MeasureMode.AT_MOST;
    L33:
        MeasureMode r106 = r100;
        if (r614 == r105) goto L36;
    L41:
        float r113 = 32767.0f;
    L42:
        if (r614 == r105) goto L44;
    L49:
        r105 = MeasureMode.AT_MOST;
    L50:
        MeasureMode r410 = r105;
        PersonListProps r114 = this.f283426x;
        if (r114 != null) goto L53;
    L331:
        r101 = "PersonListShadowNode.measure";
    L332:
        float r107 = r611;
    L333:
        float r108 = r613;
    L334:
        TraceEvent.endSection(r101);
        return i.a(r107, r108);
    L53:
        if (this.f283424v == null) goto L331;
        Integer r109 = r114.getLines();
        AppCompatTextView r411 = null;
        if (r109 != null) goto L57;
    L68:
        AppCompatTextView r115 = this.f283424v;
        if (r115 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r115 = null;
    L71:
        r115.setMaxLines(Integer.MAX_VALUE);
    L72:
        int r116 = h.f283520a;
        AppCompatTextView r117 = this.f283424v;
        if (r117 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r117 = null;
    L75:
        Context r118 = r117.getContext();
        AppCompatTextView r119 = this.f283424v;
        if (r119 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r119 = null;
    L78:
        TextPaint r120 = r119.getPaint();
        PersonListLynxUI.a r121 = this.f283428z;
        float r615 = r113;
        com.larksuite.component.card.component.personlist.b r122 = this.f283427y;
        Intrinsics.checkNotNullParameter(r118, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r120, "paint");
        Intrinsics.checkNotNullParameter(r114, SlcElement.KEY_PROPS);
        if (r114.getLines() != null) goto L81;
    L83:
        int r123 = 100;
    L85:
        if (r114.getPersons().isEmpty() == false) goto L87;
        float r124 = r615;
        r101 = "PersonListShadowNode.measure";
        MeasureMode r510 = r106;
        float r125 = r111;
        SpannableStringBuilder r126 = null;
    L308:
        if (r126 == null) goto L332;
        if (r510 == null) goto L332;
        this.f283425w = r126;
        AppCompatTextView r127 = this.f283424v;
        if (r127 != null) goto L313;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r127 = null;
    L313:
        r127.setText(r126);
        AppCompatTextView r128 = this.f283424v;
        if (r128 != null) goto L316;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r128 = null;
    L316:
        r128.measure(View.MeasureSpec.makeMeasureSpec((int) r125, C(r510)), View.MeasureSpec.makeMeasureSpec((int) r124, C(r410)));
        MeasureMode r129 = MeasureMode.EXACTLY;
        if (r510 == r129) goto L322;
        AppCompatTextView r130 = this.f283424v;
        if (r130 != null) goto L321;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r130 = null;
    L321:
        r107 = r130.getMeasuredWidth();
    L324:
        if (r614 == r129) goto L333;
        AppCompatTextView r131 = this.f283424v;
        if (r131 != null) goto L328;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L329:
        r108 = r411.getMeasuredHeight();
        goto L334
    L328:
        r411 = r131;
        goto L329
    L322:
        r107 = r611;
        goto L324
    L87:
        String r132 = UIHelper.getString(R.string.Lark_SmartCard_Comma);
        int r133 = r114.getPersons().size();
        SpannableStringBuilder r134 = new SpannableStringBuilder();
        g.f283510a.getClass();
        boolean r412 = g.i(r114);
        int r413 = g.g(r114);
        int r414 = g.d(r114);
        int r511 = g.e(r114);
        PersonStyle r135 = r114.getStyles();
        if (r135 == null) goto L105;
        String r136 = r135.getMoreTextColor();
        if (r136 == null) goto L105;
        if (r136.length() <= 0) goto L94;
        boolean r137 = true;
    L95:
        if (r137 == true) goto L98;
        r136 = null;
    L98:
        if (r136 == null) goto L105;
        int r138 = Color.parseColor(r136);     // Catch: Throwable -> L101
        r101 = "PersonListShadowNode.measure";
    L108:
        g.f283510a.getClass();
        int r139 = g.b(r114);
        PersonStyle r140 = r114.getStyles();
        if (r140 == null) goto L121;
        PersonMargin r141 = r140.getMargin();
        if (r141 == null) goto L121;
        Integer r142 = Integer.valueOf(r141.getRight());
        if (r142.intValue() <= 0) goto L115;
        boolean r143 = true;
    L116:
        if (r143 == true) goto L119;
        r142 = null;
    L119:
        if (r142 == null) goto L121;
        float r144 = zz7.b.j(UIHelper.dp2px(r142.intValue()));
    L135:
        int r145 = (int) r144;
        PersonStyle r146 = r114.getStyles();
        if (r146 == null) goto L148;
        PersonMargin r147 = r146.getMargin();
        if (r147 == null) goto L148;
        Integer r148 = Integer.valueOf(r147.getTop());
        if (r148.intValue() <= 0) goto L142;
        boolean r149 = true;
    L143:
        if (r149 == true) goto L146;
        r148 = null;
    L146:
        if (r148 == null) goto L148;
        float r150 = zz7.b.j(UIHelper.dp2px(r148.intValue()));
        r510 = r106;
    L163:
        int r151 = (int) r150;
        int r152 = g.c(r114);
        PersonStyle r153 = r114.getStyles();
        if (r153 == null) goto L174;
        Integer r154 = Integer.valueOf(r153.getNameLineHeight());
        if (r154.intValue() <= 0) goto L168;
        boolean r155 = true;
    L169:
        if (r155 == true) goto L172;
        r154 = null;
    L172:
        if (r154 == null) goto L174;
        int r156 = UIHelper.dp2px(r154.intValue());
    L175:
        if (r412 == false) goto L177;
        float r157 = r145;
    L178:
        if (r412 == false) goto L180;
        int r158 = r414 + g.f283513d;
    L181:
        float r512 = r157;
        int r159 = 0;
        int r160 = 1;
        float r513 = 0.0f;
    L182:
        if (r160 > r123) goto L291;
        if (r159 >= r133) goto L291;
        int r514 = r156;
        PersonInfo r161 = (PersonInfo) ListProtector.get(r114.getPersons(), r159);
        g.f283510a.getClass();
        String r162 = g.f(r161);
        int r616 = r152;
        if (r159 != (r133 - 1)) goto L187;
        boolean r163 = true;
    L188:
        int r617 = r133;
        float r164 = r120.measureText(r162) + r158;
        if (r163 == true) goto L191;
        float r165 = r512;
    L192:
        float r166 = r165 + r164;
        float r167 = r111 - r513;
        List<PersonInfo> r168 = r114.getPersons();
        Intrinsics.checkNotNull(r132);
        float r310 = r513 + r166;
        if (r160 != r123) goto L195;
        boolean r311 = true;
    L197:
        if (r166 <= r111) goto L199;
        boolean r312 = true;
    L200:
        h.d r169 = new h.d(r118, r120, r168, r132, r111, r414, r145, r151, r139, r511, r138, r616, r514, r413, r166, r512, r310, r311, r160, r159, r167, r312, r412, r158, r121, r122);
        int r170 = r138;
        if (r166 <= r167) goto L242;
        PersonInfo r171 = (PersonInfo) ListProtector.get(r169.f283530c, r169.f283547t);
        String r172 = g.f(r171);
        int r173 = r145;
        if (r169.f283547t != (r169.f283530c.size() - 1)) goto L205;
        boolean r174 = true;
    L206:
        if (r174 == true) goto L208;
    L217:
        int r175 = r139;
        int r210 = r151;
        SpannableStringBuilder r176 = r134;
        if (r169.f283545r == false) goto L223;
        h.a(r176, r169);
        h.a r177 = new h.a(false, null, false, true, 7);
    L220:
        r124 = r615;
        TextPaint r211 = r120;
        Context r212 = r118;
        PersonListProps r213 = r114;
        int r415 = r158;
        r125 = r111;
        int r214 = r123;
        com.larksuite.component.card.component.personlist.b r215 = r122;
    L279:
        if (r177.f283524d == true) goto L292;
        if (r177.f283523c == false) goto L285;
        r160 = r160 + 1;
    L285:
        if (r177.f283521a == false) goto L287;
        r159 = r159 + 1;
    L287:
        Float r178 = r177.f283522b;
        if (r178 == null) goto L290;
        r513 = r178.floatValue();
    L290:
        r615 = r124;
        r134 = r176;
        r111 = r125;
        r138 = r170;
        r145 = r173;
        r139 = r175;
        r151 = r210;
        r120 = r211;
        r118 = r212;
        r114 = r213;
        r122 = r215;
        r123 = r214;
        r158 = r415;
        r156 = r514;
        r152 = r616;
        r133 = r617;
    L292:
        com.larksuite.component.card.component.personlist.avatar.a[] r179 = (com.larksuite.component.card.component.personlist.avatar.a[]) r176.getSpans(0, r176.length(), com.larksuite.component.card.component.personlist.avatar.a.class);
        if (r179 == null) goto L307;
        int r180 = r179.length;
        int r181 = 0;
    L295:
        if (r181 >= r180) goto L307;
        com.larksuite.component.card.component.personlist.avatar.a r182 = r179[r181];
        if (TextUtils.isEmpty(r182.f283482h) == false) goto L306;
        if (TextUtils.isEmpty(r182.f283483i) == true) goto L306;
        String r183 = r182.f283483i;
        if (r183 == null) goto L306;
        Lazy<SimpleUserLoader> r184 = SimpleUserLoader.f283460d;
        SimpleUserLoader r185 = SimpleUserLoader.a.a();
        Intrinsics.checkNotNull(r182);
        r185.getClass();
        Intrinsics.checkNotNullParameter(r183, "userId");
        Intrinsics.checkNotNullParameter(r182, "listener");
        ArrayList<WeakReference<com.larksuite.component.card.component.personlist.avatar.c>> r186 = (ArrayList) ((LinkedHashMap) r185.f283463c).get(r183);
        if (r186 != null) goto L305;
        r186 = new ArrayList();
        r185.f283463c.put(r183, r186);
    L305:
        r186.add(new WeakReference(r182));
    L306:
        r181 = r181 + 1;
    L307:
        r126 = r176;
        goto L308
    L223:
        if (r169.f283549v == false) goto L241;
        r211 = r120;
        r212 = r118;
        CharSequence r187 = TextUtils.ellipsize(r172, r169.f283529b, (r169.f283548u - r169.f283543p) - r169.f283551x, TextUtils.TruncateAt.END);
        CharSequence r216 = r172.subSequence(0, 1);
        Intrinsics.checkNotNull(r187);
        if (StringsKt.lastIndexOf$default(r187, r216.toString(), 0, false, 6, null) == (-1)) goto L227;
        boolean r188 = true;
    L228:
        r213 = r114;
        int r217 = r158;
        CharSequence r313 = TextUtils.ellipsize(r172, r169.f283529b, (r169.f283532e - r169.f283543p) - r169.f283551x, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNull(r313);
        if (StringsKt.lastIndexOf$default(r313, r216.toString(), 0, false, 6, null) == (-1)) goto L231;
        boolean r189 = true;
    L232:
        if (r188 == false) goto L234;
        h.b(r176, r187.toString(), r171, r174, r169);
        r176.append("\n");
        r415 = r217;
        r215 = r122;
        r214 = r123;
        r177 = new h.a(true, r110, true, false, 8);
        r124 = r615;
        r125 = r111;
        goto L279
    L234:
        r124 = r615;
        r214 = r123;
        r415 = r217;
        r215 = r122;
        float r190 = r111;
        if (r189 == false) goto L237;
        r176.append("\n");
        r125 = r190;
        r177 = new h.a(false, r110, true, false, 9);
        goto L279
    L237:
        r125 = r190;
        if (r169.f283548u >= r169.f283532e) goto L240;
        r176.append("\n");
    L240:
        h.a(r176, r169);
        r177 = new h.a(false, null, false, true, 7);
        goto L279
    L231:
        r189 = false;
        goto L232
    L227:
        r188 = false;
        goto L228
    L241:
        r124 = r615;
        r211 = r120;
        r212 = r118;
        r213 = r114;
        r415 = r158;
        r125 = r111;
        r214 = r123;
        r215 = r122;
        r176.append("\n");
        r177 = new h.a(false, r110, true, false, 9);
        goto L279
    L208:
        if (r169.f283545r == false) goto L217;
        r175 = r139;
        float r191 = r169.f283548u - r169.f283551x;
        r210 = r151;
        CharSequence r192 = TextUtils.ellipsize(r172, r169.f283529b, r191, TextUtils.TruncateAt.END);
        if (r169.f283550w == true) goto L212;
    L216:
        String r193 = r192.toString();
        r176 = r134;
        h.b(r176, r193, r171, r174, r169);
        r177 = new h.a(true, null, false, true, 6);
        goto L220
    L212:
        if (TextUtils.equals(r192, "") == false) goto L216;
        if (r169.f283529b.measureText("...") > r191) goto L216;
        r192 = "...";
        goto L216
    L205:
        r174 = false;
        goto L206
    L242:
        r124 = r615;
        r173 = r145;
        r175 = r139;
        r210 = r151;
        r211 = r120;
        r212 = r118;
        r213 = r114;
        r415 = r158;
        r125 = r111;
        r214 = r123;
        r176 = r134;
        r215 = r122;
        PersonInfo r194 = (PersonInfo) ListProtector.get(r169.f283530c, r169.f283547t);
        String r195 = g.f(r194);
        int r196 = r169.f283530c.size();
        int r197 = r169.f283547t;
        int r198 = r196 - 1;
        if (r197 != r198) goto L245;
        boolean r199 = true;
    L246:
        if (r199 == false) goto L248;
    L277:
        h.b(r176, r195, r194, r199, r169);
        r177 = new h.a(true, Float.valueOf(r169.f283544q), false, false, 12);
        goto L279
    L248:
        if (r169.f283545r == false) goto L277;
        if (r197 != (r196 - 2)) goto L265;
        String r200 = g.f((PersonInfo) ListProtector.get(r169.f283530c, r198));
        CharSequence r1100 = r200.subSequence(0, 1);
        if (r169.f283550w == true) goto L257;
        String r201 = r195 + r169.f283531d;
        CharSequence r218 = TextUtils.ellipsize(r201 + r200, r169.f283529b, r169.f283548u, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNull(r218);
        if (StringsKt.lastIndexOf$default(r218, r201 + r1100, 0, false, 6, null) != (-1)) goto L259;
    L260:
        boolean r202 = false;
    L261:
        if (r202 == false) goto L263;
        h.b(r176, r195, r194, r199, r169);
        r177 = new h.a(true, Float.valueOf(r169.f283544q), false, false, 12);
        goto L279
    L263:
        h.a(r176, r169);
        r177 = new h.a(false, null, false, true, 7);
    L259:
        r202 = true;
        goto L261
    L257:
        CharSequence r219 = TextUtils.ellipsize(r200, r169.f283529b, (r169.f283548u - r169.f283542o) - r169.f283551x, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNull(r219);
        if (StringsKt.lastIndexOf$default(r219, String.valueOf(r1100), 0, false, 6, null) == (-1)) goto L260;
    L265:
        if (r169.f283550w == false) goto L271;
        if ((r169.f283542o + r169.f283533f) >= r169.f283548u) goto L273;
    L272:
        boolean r203 = true;
    L274:
        if (r203 == false) goto L276;
        h.b(r176, r195, r194, r199, r169);
        r177 = new h.a(true, Float.valueOf(r169.f283544q), false, false, 12);
        goto L279
    L276:
        h.a(r176, r169);
        r177 = new h.a(false, null, false, true, 7);
    L273:
        r203 = false;
        goto L274
    L271:
        if (r169.f283529b.measureText(r195 + r169.f283531d + h.c(String.valueOf((r196 - r197) - 1))) >= r169.f283548u) goto L273;
    L245:
        r199 = false;
        goto L246
    L199:
        r312 = false;
        goto L200
    L195:
        r311 = false;
        goto L197
    L191:
        r165 = 0.0f;
        goto L192
    L187:
        r163 = false;
    L291:
        r124 = r615;
        r125 = r111;
        r176 = r134;
        goto L292
    L180:
        r158 = 0;
        goto L181
    L177:
        r157 = r120.measureText(r132);
        goto L178
    L168:
        r155 = false;
    L174:
        r156 = ((int) g.h(r114)) + g.f283514e;
        goto L175
    L142:
        r149 = false;
    L148:
        PersonStyle r204 = r114.getStyles();
        if (r204 == null) goto L161;
        Integer r205 = Integer.valueOf(r204.getAvatarSize());
        r510 = r106;
        int r206 = r205.intValue();
        if (r206 > 0) goto L153;
    L155:
        boolean r207 = false;
    L156:
        if (r207 == true) goto L159;
        r205 = null;
    L159:
        if (r205 == null) goto L162;
        r205.intValue();
        r150 = zz7.b.j(g.f283512c);
    L162:
        r150 = zz7.b.j(g.f283511b);
        goto L163
    L153:
        if (r206 > 32.0f) goto L155;
        r207 = true;
        goto L156
    L161:
        r510 = r106;
        goto L162
    L115:
        r143 = false;
    L121:
        PersonStyle r208 = r114.getStyles();
        if (r208 == null) goto L134;
        Integer r209 = Integer.valueOf(r208.getAvatarSize());
        int r220 = r209.intValue();
        if (r220 > 0) goto L126;
    L128:
        boolean r221 = false;
    L129:
        if (r221 == true) goto L132;
        r209 = null;
    L132:
        if (r209 == null) goto L134;
        r209.intValue();
        r144 = zz7.b.j(g.f283512c);
        goto L135
    L126:
        if (r220 > 32.0f) goto L128;
        r221 = true;
    L134:
        r144 = zz7.b.j(g.f283511b);
    L101:
        th = move-exception;
        Log.e("PersonListUtils", "parse more text Color failed", th);
        goto L105
    L94:
        r137 = false;
    L105:
        if (g.i(r114) == false) goto L107;
        r138 = UIHelper.getColor(R.color.text_caption);
        goto L108
    L107:
        r138 = UIHelper.getColor(R.color.text_link_hover);
        goto L108
    L81:
        if (r114.getLines().intValue() <= 0) goto L83;
        r123 = r114.getLines().intValue();
        goto L85
    L57:
        if (r109.intValue() <= 0) goto L59;
        boolean r222 = true;
    L60:
        if (r222 == true) goto L63;
        r109 = null;
    L63:
        if (r109 == null) goto L68;
        int r223 = r109.intValue();
        AppCompatTextView r224 = this.f283424v;
        if (r224 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r224 = null;
    L67:
        r224.setMaxLines(r223);
        goto L72
    L59:
        r222 = false;
        goto L60
    L44:
        if (r613 != 0.0f) goto L46;
        boolean r225 = true;
    L47:
        if (r225 == true) goto L49;
    L46:
        r225 = false;
        goto L47
    L36:
        if (r613 != 0.0f) goto L38;
        boolean r226 = true;
    L39:
        if (r226 == true) goto L41;
        r113 = r613;
        goto L42
    L38:
        r226 = false;
        goto L39
    L29:
        r112 = false;
        goto L30
    L20:
        if (r611 != 0.0f) goto L22;
        boolean r1101 = true;
    L23:
        if (r1101 == true) goto L25;
        r111 = r611;
        goto L27
    L22:
        r1101 = false;
        goto L23
    }
}
