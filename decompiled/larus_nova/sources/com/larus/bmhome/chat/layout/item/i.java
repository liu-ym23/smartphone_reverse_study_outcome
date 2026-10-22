package com.larus.bmhome.chat.layout.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.obric.assistant.spi.chat.ObricChatSPIServiceDelegate;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public class i extends LinearLayout {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f304393o = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f304394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1 f304395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f304396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f304397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public dh8.a f304398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f304399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f304400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f304401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f304402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f304403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f304404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f304405l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f304406m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f304407n;

    public static final class a {
    }

    static {
        f304393o = com.larus.platform.service.z2.f365865a.G2();
    }

    public Drawable getInboxBackground() {
        return com.larus.utils.e1.j(this, c7.c(Float.valueOf(16.0f)), v19.c.b(R.attr.larus_base_2_overlay, getContext(), R.color.larus_base_2_overlay));
    }

    public int getMaxWidth() {
        Integer r100 = this.f304396c;
        if (r100 == null) goto L6;
        return r100.intValue();
    L6:
        return j();
    }

    public final int j() {
        Resources r100 = getResources();
        if (getImmerseBgColor() == null) goto L5;
        int r101 = r100.getDimensionPixelSize(R.dimen.larus_message_item_immerse_start_margin);
        int r102 = r100.getDimensionPixelSize(R.dimen.larus_message_item_immerse_end_margin);
    L6:
        int r103 = r101 + r102;
        Lazy r104 = com.larus.bmhome.utils.z1.f315157a;
        t1a.b r105 = ei9.c.a(this);
        if (r105 == null) goto L11;
        va8.m r106 = (va8.m) r105.getAbility(va8.m.class);
        if (r106 == null) goto L11;
        Fragment r107 = r106.getChatFragment();
    L13:
        return RangesKt.coerceAtLeast(com.larus.bmhome.utils.z1.e(r107) - r103, i5.B());
    L11:
        r107 = null;
        goto L13
    L5:
        r101 = r100.getDimensionPixelSize(R.dimen.larus_message_item_start_margin);
        r102 = r100.getDimensionPixelSize(R.dimen.larus_message_item_end_margin);
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f304395b.f304350e = -1;
    }

    public int getBoxType() {
        return this.f304405l;
    }

    public Integer getImmerseBgColor() {
        return this.f304403j;
    }

    public boolean getUseSubscribedColor() {
        return this.f304404k;
    }

    public i(Context r100) {
        super(r100);
        setOrientation(1);
        setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.f304395b = new f1(0);
        this.f304402i = new int[2];
        this.f304405l = -1;
        this.f304407n = -1;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        com.larus.platform.service.e2 r101 = com.larus.platform.service.e2.f365734a;
        Context r102 = getContext();
        if ((r102 instanceof Activity) == false) goto L5;
        Activity r103 = (Activity) r102;
    L7:
        if (r101.a(r103, r100) == false) goto L9;
        this.f304395b.f304350e = -1;
    L9:
        int r104 = getResources().getConfiguration().uiMode & 48;
        if (r104 == this.f304406m) goto L14;
        this.f304406m = r104;
        this.f304397d = true;
        setBoxType(getBoxType());
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public void setBoxType(int r110) {
        boolean r100 = true;
        if (this.f304397d == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        this.f304397d = false;
        this.f304405l = r110;
        Fragment r102 = null;
        Fragment r103 = null;
        r103 = null;
        Fragment r104 = null;
        r104 = null;
        Drawable r105 = null;
        r102 = null;
        if (r101 == true) goto L12;
        this.f304396c = null;
    L12:
        if (r110 != 0) goto L14;
        ed8.j.f472232a.getClass();
        Intrinsics.checkNotNullParameter(this, "boxView");
        Context r111 = getContext();
        if (r111 != null) goto L60;
    L61:
        iga.d r112 = null;
    L63:
        if (r112 == null) goto L93;
        String r113 = StringsKt.trim(r112.f489757a).toString();
        if (r113.length() != 0) goto L68;
        boolean r106 = true;
    L69:
        if (r106 == false) goto L72;
    L81:
        Integer r114 = null;
    L91:
        if (r114 == null) goto L93;
        Drawable r115 = com.larus.utils.e1.e(i5.q(), r114.intValue());
    L94:
        if (r115 != null) goto L96;
        r100 = false;
    L97:
        if (r100 == false) goto L99;
    L111:
        ViewGroup.LayoutParams r116 = getLayoutParams();
        if (r116 == null) goto L121;
        ConstraintLayout.LayoutParams r117 = (ConstraintLayout.LayoutParams) r116;
        Lazy r107 = com.larus.bmhome.utils.z1.f315157a;
        t1a.b r108 = ei9.c.a(this);
        if (r108 == null) goto L118;
        va8.m r109 = (va8.m) r108.getAbility(va8.m.class);
        if (r109 == null) goto L118;
        r102 = r109.getChatFragment();
    L118:
        r117.setMarginStart(com.larus.bmhome.utils.z1.f(r102));
        r117.setMarginEnd(0);
        setLayoutParams(r117);
        return;
    L121:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L99:
        if (getImmerseBgColor() == null) goto L107;
        Integer r118 = getImmerseBgColor();
        if (r118 == null) goto L111;
        int r119 = r118.intValue();
        if (com.larus.platform.service.z2.f365865a.enableUgcBotBlockSwitch() == false) goto L105;
        Drawable r120 = com.larus.utils.e1.e(i5.q(), r119);
    L106:
        setBackground(r120);
        goto L111
    L105:
        r120 = com.larus.utils.e1.f(getWidth(), getHeight(), i5.q(), r119);
        goto L106
    L107:
        Drawable r121 = getInboxBackground();
        IFlowThemeConfigProvider r122 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r122 == null) goto L110;
        ThemeConfigScene r123 = ThemeConfigScene.CHAT;
        ThemeColorKey r124 = ThemeColorKey.MESSAGE_RECEIVE_BUBBLE_COLOR;
        AdaptThemeFeatureKey r125 = AdaptThemeFeatureKey.RECEIVE_MESSAGE_BUBBLE;
        boolean r126 = v19.h.f552477a;
        r122.g(r121, r124, r123, r125, Boolean.valueOf(v19.h.b(getContext())));
    L110:
        setBackground(r121);
        goto L111
    L96:
        setBackground(r115);
        goto L97
    L72:
        if (StringsKt.startsWith$default(r113, "#", false, 2, null) == false) goto L75;
        r113 = r113.substring(1);
    L77:
        int r127 = r113.length();
        if (r127 != 6) goto L80;
        r113 = "FF".concat(r113);
    L122:
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L85
        Object r129 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor("#" + r113)));     // Catch: Throwable -> L85
    L88:
        if (Result.m9455isFailureimpl(r129) == false) goto L90;
        r129 = null;
    L90:
        r114 = (Integer) r129;
    L85:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L88
    L80:
        if (r127 == 8) goto L122;
    L75:
        if (StringsKt.startsWith(r113, "0x", true) == false) goto L77;
        r113 = r113.substring(2);
        goto L77
    L68:
        r106 = false;
    L93:
        r115 = null;
        goto L94
    L60:
        if (ChatWindowServiceDelegate.f392926b.d(r111) == false) goto L61;
        ObricChatSPIServiceDelegate r131 = ObricChatSPIServiceDelegate.f392856b;
        boolean r132 = v19.h.f552477a;
        r112 = r131.e(v19.h.b(r111));
        goto L63
    L14:
        if (r110 == 1) goto L36;
        if (r110 != 2) goto L17;
        Resources r133 = AppHost.f326268a.getApplication().getResources();
        Lazy r134 = com.larus.bmhome.utils.z1.f315157a;
        t1a.b r135 = ei9.c.a(this);
        if (r135 == null) goto L30;
        va8.m r136 = (va8.m) r135.getAbility(va8.m.class);
        if (r136 == null) goto L30;
        r104 = r136.getChatFragment();
    L30:
        this.f304396c = Integer.valueOf(com.larus.bmhome.utils.z1.e(r104) - (r133.getDimensionPixelSize(R.dimen.larus_message_item_start_margin) * 2));
        ViewGroup.LayoutParams r137 = getLayoutParams();
        if (r137 == null) goto L34;
        ConstraintLayout.LayoutParams r138 = (ConstraintLayout.LayoutParams) r137;
        r138.setMarginStart(getResources().getDimensionPixelSize(R.dimen.larus_message_item_start_margin));
        r138.setMarginEnd(getResources().getDimensionPixelSize(R.dimen.larus_message_item_start_margin));
        setLayoutParams(r138);
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L17:
        if (r110 != 3) goto L127;
        Lazy r139 = com.larus.bmhome.utils.z1.f315157a;
        t1a.b r140 = ei9.c.a(this);
        if (r140 == null) goto L24;
        va8.m r141 = (va8.m) r140.getAbility(va8.m.class);
        if (r141 == null) goto L24;
        r103 = r141.getChatFragment();
    L24:
        this.f304396c = Integer.valueOf(com.larus.bmhome.utils.z1.e(r103));
        return;
    L127:
        return;
    L36:
        if (getImmerseBgColor() == null) goto L39;
        r105 = ContextCompat.getDrawable(getContext(), R.drawable.larus_bg_outbox_immerse);
    L47:
        setBackground(r105);
        ViewGroup.LayoutParams r142 = getLayoutParams();
        if (r142 == null) goto L55;
        ConstraintLayout.LayoutParams r143 = (ConstraintLayout.LayoutParams) r142;
        if (com.larus.platform.service.e2.f365734a.isPad() == false) goto L52;
        int r144 = 0;
    L53:
        r143.setMarginEnd(r144);
        r143.setMarginStart(0);
        setLayoutParams(r143);
        return;
    L52:
        r144 = getResources().getDimensionPixelSize(R.dimen.larus_message_item_start_margin);
        goto L53
    L55:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L39:
        if (getUseSubscribedColor() == false) goto L41;
        r105 = ContextCompat.getDrawable(getContext(), R.drawable.larus_bg_outbox_subscribed);
        goto L47
    L41:
        Drawable r145 = ContextCompat.getDrawable(getContext(), v19.c.b(R.attr.larus_bg_outbox, getContext(), R.drawable.larus_bg_outbox));
        if (r145 == null) goto L47;
        IFlowThemeConfigProvider r146 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r146 == null) goto L46;
        ThemeConfigScene r147 = ThemeConfigScene.CHAT;
        ThemeColorKey r148 = ThemeColorKey.MESSAGE_BUBBLE_COLOR;
        AdaptThemeFeatureKey r149 = AdaptThemeFeatureKey.SEND_MESSAGE_BUBBLE;
        boolean r150 = v19.h.f552477a;
        r146.g(r145, r148, r147, r149, Boolean.valueOf(v19.h.b(getContext())));
    L46:
        r105 = r145;
        goto L47
    L5:
        if (this.f304405l != r110) goto L7;
        r101 = true;
        goto L8
    }

    public void setImmerseBgColor(Integer r100) {
        this.f304403j = r100;
        if (f304393o == false) goto L6;
        setMaxWidth(j());
        return;
    }

    public void setMaxWidth(int r100) {
        this.f304396c = Integer.valueOf(r100);
    }

    public final void setRequestFocus(boolean r100) {
        this.f304394a = r100;
    }

    public void setUseSubscribedColor(boolean r100) {
        this.f304404k = r100;
    }

    public static View h(View r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        Intrinsics.checkNotNullParameter(r101, "targetType");
        if ((r100 instanceof ViewGroup) == false) goto L14;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L19;
        View r105 = r102.getChildAt(r104);
        if (r101.isInstance(r105) == true) goto L8;
        Intrinsics.checkNotNull(r105);
        View r106 = h(r105, r101);
        if (r106 != null) goto L12;
        r104 = r104 + 1;
        goto L5
    L12:
        return r106;
    L8:
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type T of com.larus.bmhome.chat.layout.item.BaseMessageBox.findChildViewByType");
        return r105;
    L19:
        return null;
    L14:
        return null;
    }

    public void l(boolean r100, boolean r101) {
        Lazy r102 = com.larus.bmhome.utils.z1.f315157a;
        if (com.larus.bmhome.utils.z1.c(getBoxType(), getImmerseBgColor(), r100, r101) == false) goto L27;
        f1 r103 = this.f304395b;
        Fragment r104 = null;
        if (r103.f304350e != (-1)) goto L13;
        int r105 = getBoxType();
        Integer r106 = getImmerseBgColor();
        t1a.b r107 = ei9.c.a(this);
        if (r107 == null) goto L11;
        va8.m r108 = (va8.m) r107.getAbility(va8.m.class);
        if (r108 == null) goto L11;
        r104 = r108.getChatFragment();
    L11:
        int r109 = com.larus.bmhome.utils.z1.g(r105, r106, r100, r101, Integer.valueOf(com.larus.bmhome.utils.z1.e(r104)));
        f1 r110 = this.f304395b;
        r110.f304350e = r109;
        r110.f304346a = getBoxType();
        r110.f304347b = getImmerseBgColor();
        r110.f304348c = Boolean.valueOf(r100);
        r110.f304349d = Boolean.valueOf(r101);
        int r111 = this.f304395b.f304350e;
    L28:
        this.f304396c = Integer.valueOf(r111);
        ViewGroup.LayoutParams r112 = getLayoutParams();
        if (r112 != null) goto L31;
        return;
    L31:
        if (r112.width == r111) goto L35;
        r112.width = r111;
        setLayoutParams(r112);
        return;
    L35:
        return;
    L13:
        if (Intrinsics.areEqual(r103.f304348c, Boolean.valueOf(r100)) == true) goto L15;
    L21:
        int r113 = getBoxType();
        Integer r114 = getImmerseBgColor();
        t1a.b r115 = ei9.c.a(this);
        if (r115 == null) goto L26;
        va8.m r116 = (va8.m) r115.getAbility(va8.m.class);
        if (r116 == null) goto L26;
        r104 = r116.getChatFragment();
    L26:
        int r117 = com.larus.bmhome.utils.z1.g(r113, r114, r100, r101, Integer.valueOf(com.larus.bmhome.utils.z1.e(r104)));
        f1 r118 = this.f304395b;
        r118.f304350e = r117;
        r118.f304346a = getBoxType();
        r118.f304347b = getImmerseBgColor();
        r118.f304348c = Boolean.valueOf(r100);
        r118.f304349d = Boolean.valueOf(r101);
        r111 = this.f304395b.f304350e;
        goto L28
    L15:
        if (Intrinsics.areEqual(this.f304395b.f304349d, Boolean.valueOf(r101)) == false) goto L21;
        if (this.f304395b.f304346a != getBoxType()) goto L21;
        if (Intrinsics.areEqual(this.f304395b.f304347b, getImmerseBgColor()) == false) goto L21;
        r111 = this.f304395b.f304350e;
        goto L28
    L27:
        r111 = j();
        goto L28
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        Lazy r102 = com.larus.bmhome.utils.z1.f315157a;
        t1a.b r103 = ei9.c.a(this);
        dh8.a r104 = null;
        if (r103 == null) goto L7;
        va8.m r105 = (va8.m) r103.getAbility(va8.m.class);
        if (r105 == null) goto L7;
        Fragment r106 = r105.getChatFragment();
    L8:
        int r107 = com.larus.bmhome.utils.z1.e(r106);
        final boolean r108 = false;
        if (this.f304407n == r107) goto L20;
        if (r107 <= 0) goto L20;
        this.f304407n = r107;
        this.f304396c = null;
        f1 r109 = this.f304395b;
        r109.f304350e = -1;
        Boolean r110 = r109.f304348c;
        if (r110 == null) goto L14;
        boolean r111 = r110.booleanValue();
    L15:
        Boolean r112 = this.f304395b.f304349d;
        if (r112 == null) goto L18;
        boolean r113 = r112.booleanValue();
    L19:
        l(r111, r113);
        goto L20
    L18:
        r113 = false;
        goto L19
    L14:
        r111 = false;
    L20:
        i(r100, r101, this.f304402i);
        int[] r114 = this.f304402i;
        super.onMeasure(r114[0], r114[1]);
        int r115 = getMeasuredHeight();
        dh8.a r116 = this.f304398e;
        if (r116 == null) goto L41;
        dh8.b r117 = dh8.b.f468639a;
        Context r118 = getContext();
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r116, "config");
        if (r116.f468624a == true) goto L26;
    L38:
        r104 = r116;
        this.f304398e = r104;
        goto L41
    L26:
        if (Intrinsics.areEqual(r116.f468631h, "send") == false) goto L28;
        int r119 = ra9.a.f536860a;
        boolean r120 = ga9.a.b("message_send_long_message_collapse_enabled", false);
    L29:
        if (r120 == true) goto L31;
        r116 = dh8.a.a(r116, 0, 0, false, 32766);
        goto L38
    L31:
        int r121 = dh8.b.b(r118);
        int r122 = dh8.b.e(r121);
        if (Intrinsics.areEqual(r116.f468631h, "send") == false) goto L35;
        r121 = r121 / 3;
    L35:
        if (r116.f468625b == r122) goto L37;
    L39:
        r116 = dh8.a.a(r116, r122, r121, false, 32761);
        goto L38
    L37:
        if (r116.f468626c != r121) goto L39;
    L28:
        int r123 = ra9.a.f536860a;
        r120 = ga9.a.b("message_reply_long_message_collapse_enabled", false);
    L41:
        if (r104 != null) goto L43;
    L71:
        setClipToOutline(r108);
        if (r108 == false) goto L78;
        if (r104 == null) goto L76;
        setMeasuredDimension(getMeasuredWidth(), r104.f468625b);
        goto L78
    L76:
        throw new IllegalArgumentException("Required value was null.".toString());
    L78:
        if (this.f304399f == r108) goto L100;
        this.f304399f = r108;
        final dh8.a r124 = this.f304398e;
        if (r124 == null) goto L97;
        if (r108 == false) goto L84;
    L85:
        dh8.b r125 = dh8.b.f468639a;
        String r126 = r124.f468630g;
        String r127 = r124.f468629f;
        r125.getClass();
        Intrinsics.checkNotNullParameter(r126, "stateScope");
        Intrinsics.checkNotNullParameter(r127, "messageKey");
        if (StringsKt.isBlank(r126) == true) goto L97;
        if (StringsKt.isBlank(r127) == true) goto L97;
        String r128 = dh8.b.d(r126, r127);
        if (r108 == false) goto L96;
        LinkedHashSet<String> r129 = dh8.b.f468643e;
        r129.remove(r128);
        r129.add(r128);
    L93:
        LinkedHashSet<String> r130 = dh8.b.f468643e;
        if (r130.size() <= 500) goto L97;
        r130.remove(CollectionsKt.first(r130));
        goto L93
    L96:
        dh8.b.f468643e.remove(r128);
        goto L97
    L84:
        if (r124.f468627d == false) goto L85;
    L97:
        final Function1<? super Boolean, Unit> r131 = this.f304401h;
        post(new h(this, r124, r131, r108));
        return;
    L100:
        return;
    L43:
        if (r104.f468624a == true) goto L45;
    L47:
        boolean r132 = false;
    L48:
        if (r132 == false) goto L68;
        if (r115 <= 0) goto L68;
        Boolean r133 = this.f304400g;
        if (r133 == null) goto L53;
        boolean r134 = r133.booleanValue();
    L64:
        if (r134 == false) goto L68;
        if (r115 <= r104.f468625b) goto L68;
        boolean r135 = true;
    L69:
        if (r135 != true) goto L71;
        r108 = true;
        goto L71
    L53:
        dh8.b r136 = dh8.b.f468639a;
        String r137 = r104.f468629f;
        r136.getClass();
        Intrinsics.checkNotNullParameter(r137, "key");
        Map<String, Boolean> r138 = dh8.b.f468648j;
        Boolean r139 = (Boolean) ((LinkedHashMap) r138).get(r137);
        if (r139 == null) goto L57;
        r134 = r139.booleanValue();
        goto L64
    L57:
        if (r115 <= Math.max(r104.f468626c, r104.f468625b)) goto L59;
        boolean r140 = true;
    L60:
        String r141 = r104.f468629f;
        Intrinsics.checkNotNullParameter(r141, "key");
        if (r138.containsKey(r141) == true) goto L63;
        r138.put(r141, Boolean.valueOf(r140));
    L63:
        r134 = r140;
        goto L64
    L59:
        r140 = false;
    L68:
        r135 = false;
        goto L69
    L45:
        if (r104.f468627d == true) goto L47;
        r132 = true;
    L7:
        r106 = null;
        goto L8
    }

    public void i(int r100, int r101, int[] r102) {
        Intrinsics.checkNotNullParameter(r102, "outSpec");
        r102[0] = View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE);
        r102[1] = r101;
    }
}
