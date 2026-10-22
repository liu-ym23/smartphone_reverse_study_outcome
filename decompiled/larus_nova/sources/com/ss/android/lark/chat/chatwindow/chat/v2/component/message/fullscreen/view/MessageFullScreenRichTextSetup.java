package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.ContentData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.RichTextData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.ContentLongClickListener;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.ActionContextCreator;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.span.e0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@RichTextSetupDsl
public final class MessageFullScreenRichTextSetup {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f414007k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f414008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f414009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c f414010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f414011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ActionContextCreator f414012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Integer> f414013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.a> f414014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ContentLongClickListener f414015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ContentLongClickListener f414016i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l f414017j;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/view/MessageFullScreenRichTextSetup$ClickHandlerDsl;", "", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface ClickHandlerDsl {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/view/MessageFullScreenRichTextSetup$ContentViewsDsl;", "", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface ContentViewsDsl {
    }

    @ClickHandlerDsl
    public static final class a {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ int f414018m = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public mcc.l f414019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public mcc.o f414020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public mcc.b f414021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public mcc.i f414022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public mcc.g f414023e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public mcc.h f414024f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public mcc.e f414025g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public mcc.n f414026h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public mcc.f f414027i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public mcc.a f414028j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View.OnClickListener f414029k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public View.OnLongClickListener f414030l;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.MessageFullScreenRichTextSetup$a$a, reason: collision with other inner class name */
        public static final class C4832a {
        }

        static {
        }

        public a() {
        }
    }

    public static final class b {
    }

    @ContentViewsDsl
    public static final class c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int f414034f = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LKUILightTextView f414035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LKUILightTextView f414036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f414037c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ViewGroup f414038d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewGroup f414039e;

        public static final class a {
        }

        static {
        }

        public c() {
        }
    }

    static {
    }

    public final Context getContext() {
        return this.f414008a;
    }

    public MessageFullScreenRichTextSetup(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f414008a = r100;
        this.f414014g = new HashMap();
    }

    public static void f(LKUILightTextView r100) {
        r100.setTextSize(p.a(r100.getContext()));
        Context r101 = r100.getContext();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.setSpacingExtra(zz7.b.g(r101, 19));
    }

    public final void a(MessageFullScreenViewModel.c r110) {
        Intrinsics.checkNotNullParameter(r110, "initData");
        ContentLongClickListener r100 = this.f414015h;
        if (r100 == null) goto L5;
        r100.d();
    L5:
        ContentLongClickListener r101 = this.f414016i;
        if (r101 == null) goto L8;
        r101.d();
    L8:
        ContentData r102 = r110.f413958a.getContentData();
        if (r102 == null) goto L238;
        int r103 = r102.getContentType();
        c r104 = this.f414011d;
        if (r104 == null) goto L15;
        LKUILightTextView r105 = r104.f414035a;
        if (r105 == null) goto L15;
        f(r105);
    L15:
        c r106 = this.f414011d;
        if (r106 == null) goto L20;
        LKUILightTextView r107 = r106.f414036b;
        if (r107 == null) goto L20;
        f(r107);
    L20:
        c r108 = this.f414011d;
        if (r108 == null) goto L26;
        ViewGroup r109 = r108.f414038d;
        if (r109 == null) goto L26;
        r109.setVisibility(0);
    L26:
        if (r103 == 0) goto L95;
        if (r103 == 1) goto L71;
        if (r103 != 2) goto L119;
        c r111 = this.f414011d;
        if (r111 == null) goto L35;
        LKUILightTextView r112 = r111.f414035a;
        if (r112 == null) goto L35;
        r112.setVisibility(0);
    L35:
        c r113 = this.f414011d;
        if (r113 == null) goto L40;
        View r114 = r113.f414037c;
        if (r114 == null) goto L40;
        r114.setVisibility(0);
    L40:
        c r115 = this.f414011d;
        if (r115 == null) goto L45;
        LKUILightTextView r116 = r115.f414036b;
        if (r116 == null) goto L45;
        r116.setVisibility(0);
    L45:
        c r117 = this.f414011d;
        if (r117 == null) goto L54;
        LKUILightTextView r118 = r117.f414036b;
        if (r118 == null) goto L54;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if (r119 == null) goto L53;
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r119;
        Context r121 = this.f414008a;
        Intrinsics.checkNotNullParameter(r121, PerfLog.PARAM_KEY_CONTEXT_ID);
        r120.topMargin = UIUtils.dp2px(r121, 16.0f);
        r118.setLayoutParams(r120);
        goto L54
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L54:
        c r122 = this.f414011d;
        ConstraintLayout r123 = null;
        if (r122 == null) goto L57;
        ViewGroup r124 = r122.f414038d;
    L59:
        if ((r124 instanceof ConstraintLayout) == false) goto L61;
        r123 = (ConstraintLayout) r124;
    L61:
        if (r123 == null) goto L119;
        if (r122 == null) goto L119;
        LKUILightTextView r125 = r122.f414035a;
        if (r125 == null) goto L119;
        LKUILightTextView r126 = r122.f414036b;
        if (r126 == null) goto L119;
        ConstraintSet r127 = new ConstraintSet();
        r127.clone(r123);
        r127.connect(r125.getId(), 6, 0, 6);
        r127.clear(r125.getId(), 7);
        r127.connect(r126.getId(), 6, 0, 6);
        r127.clear(r126.getId(), 7);
        r127.applyTo(r123);
        goto L119
    L57:
        r124 = null;
    L119:
        MessageFullScreenLaunchData r128 = r110.f413958a;
        Chat r129 = r110.f413960c;
        if (r129 == null) goto L244;
        Log.i("MsgFSRichTextSetup", "render launch data for " + r128.getMessageId());
        ContentData r130 = r128.getContentData();
        if (r130 == null) goto L239;
        int r131 = r130.getContentType();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r132 = this.f414010c;
        if (r132 == null) goto L176;
        if (r131 == 0) goto L155;
        if (r131 == 1) goto L146;
        if (r131 != 2) goto L164;
        c r133 = this.f414011d;
        if (r133 == null) goto L176;
        LKUILightTextView r134 = r133.f414035a;
        if (r134 == null) goto L176;
        LKUILightTextView r135 = r133.f414036b;
        if (r135 == null) goto L176;
        ContentLongClickListener r136 = this.f414016i;
        if (r136 == null) goto L142;
        r136.b();
    L142:
        this.f414016i = new ContentLongClickListener(r135, r132, this.f414012e, new MessageFullScreenRichTextSetup$prepareLongClickListener$1(this));
        ContentLongClickListener r137 = this.f414015h;
        if (r137 == null) goto L145;
        r137.b();
    L145:
        this.f414015h = new ContentLongClickListener(r134, r132, this.f414012e, new MessageFullScreenRichTextSetup$prepareLongClickListener$2(this));
    L164:
        c r138 = this.f414011d;
        if (r138 == null) goto L171;
        ViewGroup r139 = r138.f414039e;
        if (r139 == null) goto L171;
        ViewTreeObserver r140 = r139.getViewTreeObserver();
        if (r140 == null) goto L171;
        r140.addOnPreDrawListener(new m(this));
    L171:
        GestureDetector r141 = new GestureDetector(r132.getContext(), new o(this, r132));
        c r142 = this.f414011d;
        if (r142 == null) goto L176;
        ViewGroup r143 = r142.f414039e;
        if (r143 == null) goto L176;
        r143.setOnTouchListener(new n(r141));
        goto L176
    L146:
        c r144 = this.f414011d;
        if (r144 == null) goto L176;
        LKUILightTextView r145 = r144.f414036b;
        if (r145 == null) goto L176;
        ContentLongClickListener r146 = this.f414016i;
        if (r146 == null) goto L154;
        r146.b();
    L154:
        this.f414016i = new ContentLongClickListener(r145, r132, this.f414012e);
        goto L164
    L155:
        c r147 = this.f414011d;
        if (r147 == null) goto L176;
        LKUILightTextView r148 = r147.f414035a;
        if (r148 == null) goto L176;
        ContentLongClickListener r149 = this.f414015h;
        if (r149 == null) goto L163;
        r149.b();
    L163:
        this.f414015h = new ContentLongClickListener(r148, r132, this.f414012e);
    L176:
        if (r131 == 0) goto L210;
        if (r131 == 1) goto L200;
        if (r131 != 2) goto L220;
        RichTextData r150 = r128.getContentData().getOriginText();
        if (r150 == null) goto L245;
        Layout r151 = b(r131, r150, c(r128, r129));
        if (r151 == null) goto L190;
        c r152 = this.f414011d;
        if (r152 == null) goto L190;
        LKUILightTextView r153 = r152.f414035a;
        if (r153 == null) goto L190;
        r153.setContentLayout(r151);
        g(r153, r151);
        e(r153, r150.getRichText(), false);
    L190:
        RichTextData r154 = r128.getContentData().getTranslateText();
        if (r154 == null) goto L246;
        Layout r155 = b(r131, r154, d(r128, r129));
        if (r155 == null) goto L220;
        c r156 = this.f414011d;
        if (r156 == null) goto L220;
        LKUILightTextView r157 = r156.f414036b;
        if (r157 == null) goto L220;
        r157.setContentLayout(r155);
        g(r157, r155);
        e(r157, r154.getRichText(), true);
        goto L220
    L246:
        return;
    L245:
        return;
    L220:
        Function0<c> r158 = new MessageFullScreenRichTextSetup$bindContent$updateContentGroupGravity$1(this);
        c r159 = this.f414011d;
        if (r159 == null) goto L228;
        ViewGroup r160 = r159.f414038d;
        if (r160 == null) goto L228;
        l r161 = this.f414017j;
        if (r161 == null) goto L227;
        r160.removeOnLayoutChangeListener(r161);
    L227:
        l r162 = new l(r158);
        this.f414017j = r162;
        r160.addOnLayoutChangeListener(r162);
    L228:
        r158.invoke();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r163 = this.f414010c;
        if (r163 == null) goto L240;
        Fragment r164 = r163.f414070b;
        if (r164 == null) goto L241;
        LifecycleOwner r165 = r164.getViewLifecycleOwner();
        if (r165 == null) goto L242;
        final Lifecycle r166 = r165.getLifecycle();
        if (r166 == null) goto L243;
        r166.addObserver(new MessageFullScreenRichTextSetup$bindContent$6$1(this, r166));
        return;
    L243:
        return;
    L242:
        return;
    L241:
        return;
    L240:
        return;
    L200:
        RichTextData r167 = r128.getContentData().getTranslateText();
        if (r167 == null) goto L247;
        Layout r168 = b(r131, r167, d(r128, r129));
        if (r168 == null) goto L220;
        c r169 = this.f414011d;
        if (r169 == null) goto L220;
        LKUILightTextView r170 = r169.f414036b;
        if (r170 == null) goto L220;
        r170.setContentLayout(r168);
        g(r170, r168);
        e(r170, r167.getRichText(), true);
        goto L220
    L247:
        return;
    L210:
        RichTextData r171 = r128.getContentData().getOriginText();
        if (r171 == null) goto L248;
        Layout r172 = b(r131, r171, c(r128, r129));
        if (r172 == null) goto L220;
        c r173 = this.f414011d;
        if (r173 == null) goto L220;
        LKUILightTextView r174 = r173.f414035a;
        if (r174 == null) goto L220;
        r174.setContentLayout(r172);
        g(r174, r172);
        e(r174, r171.getRichText(), false);
        goto L220
    L248:
        return;
    L239:
        return;
    L244:
        return;
    L71:
        c r175 = this.f414011d;
        if (r175 == null) goto L76;
        LKUILightTextView r176 = r175.f414035a;
        if (r176 == null) goto L76;
        r176.setVisibility(8);
    L76:
        c r177 = this.f414011d;
        if (r177 == null) goto L81;
        View r178 = r177.f414037c;
        if (r178 == null) goto L81;
        r178.setVisibility(8);
    L81:
        c r179 = this.f414011d;
        if (r179 == null) goto L86;
        LKUILightTextView r180 = r179.f414036b;
        if (r180 == null) goto L86;
        r180.setVisibility(0);
    L86:
        c r181 = this.f414011d;
        if (r181 == null) goto L119;
        LKUILightTextView r182 = r181.f414036b;
        if (r182 == null) goto L119;
        ViewGroup.LayoutParams r183 = r182.getLayoutParams();
        if (r183 == null) goto L94;
        ViewGroup.MarginLayoutParams r184 = (ViewGroup.MarginLayoutParams) r183;
        Context r185 = this.f414008a;
        Intrinsics.checkNotNullParameter(r185, PerfLog.PARAM_KEY_CONTEXT_ID);
        r184.topMargin = UIUtils.dp2px(r185, 0.0f);
        r182.setLayoutParams(r184);
        goto L119
    L94:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L95:
        c r186 = this.f414011d;
        if (r186 == null) goto L100;
        LKUILightTextView r187 = r186.f414035a;
        if (r187 == null) goto L100;
        r187.setVisibility(0);
    L100:
        c r188 = this.f414011d;
        if (r188 == null) goto L105;
        View r189 = r188.f414037c;
        if (r189 == null) goto L105;
        r189.setVisibility(8);
    L105:
        c r190 = this.f414011d;
        if (r190 == null) goto L110;
        LKUILightTextView r191 = r190.f414036b;
        if (r191 == null) goto L110;
        r191.setVisibility(8);
    L110:
        c r192 = this.f414011d;
        if (r192 == null) goto L119;
        LKUILightTextView r193 = r192.f414036b;
        if (r193 == null) goto L119;
        ViewGroup.LayoutParams r194 = r193.getLayoutParams();
        if (r194 == null) goto L118;
        ViewGroup.MarginLayoutParams r195 = (ViewGroup.MarginLayoutParams) r194;
        Context r196 = this.f414008a;
        Intrinsics.checkNotNullParameter(r196, PerfLog.PARAM_KEY_CONTEXT_ID);
        r195.topMargin = UIUtils.dp2px(r196, 16.0f);
        r193.setLayoutParams(r195);
        goto L119
    L118:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public static void g(LKUILightTextView r100, Layout r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L11;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r101.getLineCount() != 1) goto L7;
        int r104 = -2;
    L8:
        r103.width = r104;
        r100.setLayoutParams(r103);
        return;
    L7:
        r104 = -1;
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final q c(MessageFullScreenLaunchData r100, Chat r110) {
        int r101 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.d.f413962a;
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("messener.im.refactor_richtext_biz") == true) goto L5;
        int r102 = j.f414127b;
        Context r103 = this.f414008a;
        Function0<Integer> r104 = this.f414013f;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "chat");
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r105 = j.a.b(r100);
        j.a.d(r105, r103);
        r105.f412415h = false;
        Message r106 = r100.getMessage();
        if (r106 == null) goto L11;
        MessageEditInfo r107 = r106.getEditInfo();
        if (r107 == null) goto L11;
        boolean r108 = r107.isEdited();
    L12:
        r105.f412425r = r108;
        r105.f412416i = false;
        r105.f412428u = 21;
        r105.f412420m = true;
        Message r109 = r100.getMessage();
        if (r109 == null) goto L15;
        boolean r111 = r109.isPreMessage();
    L16:
        r105.f412406c = r111;
        Message r112 = r100.getMessage();
        if (r112 == null) goto L19;
        boolean r113 = r112.isFromMe();
    L20:
        r105.f412408d = r113;
        Message r114 = r100.getMessage();
        if (r114 == null) goto L24;
        List<String> r115 = r114.getReadAtChatterIds();
        if (r115 == null) goto L24;
    L25:
        Intrinsics.checkNotNullParameter(r115, "readAtChatterIds");
        r105.f412402a = r115;
        Message r116 = r100.getMessage();
        if (r116 == null) goto L28;
        Message.Status r117 = r116.getStatus();
    L30:
        if (r117 != Message.Status.DELETED) goto L32;
        boolean r118 = true;
    L33:
        r105.f412410e = r118;
        Message r119 = r100.getMessage();
        if (r119 == null) goto L36;
        boolean r120 = r119.isFlag();
    L37:
        r105.f412414g = r120;
        String r121 = r110.getAnonymousId();
        if (r121 == null) goto L40;
        r105.f412419l = r121;
    L40:
        r105.f412418k = false;
        r105.f412401J = true;
        r105.K = true;
        j.a.c(r105, r103, r104);
        return new r(r105, this.f414013f);
    L36:
        r120 = false;
        goto L37
    L32:
        r118 = false;
        goto L33
    L28:
        r117 = null;
    L24:
        r115 = CollectionsKt.emptyList();
        goto L25
    L19:
        r113 = false;
        goto L20
    L15:
        r111 = true;
    L11:
        r108 = false;
        goto L12
    L5:
        return new s(false, this.f414010c, r100, this.f414013f);
    }

    public final q d(MessageFullScreenLaunchData r100, Chat r110) {
        int r101 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.d.f413962a;
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("messener.im.refactor_richtext_biz") == true) goto L5;
        int r102 = j.f414127b;
        Context r103 = this.f414008a;
        Function0<Integer> r104 = this.f414013f;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "chat");
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r105 = j.a.b(r100);
        j.a.d(r105, r103);
        boolean r106 = false;
        r105.f412415h = false;
        Message r107 = r100.getMessage();
        if (r107 == null) goto L11;
        MessageEditInfo r108 = r107.getEditInfo();
        if (r108 == null) goto L11;
        boolean r109 = r108.isEdited();
    L12:
        r105.f412425r = r109;
        r105.f412416i = false;
        r105.f412428u = 21;
        r105.f412420m = true;
        Message r111 = r100.getMessage();
        if (r111 == null) goto L15;
        boolean r112 = r111.isPreMessage();
    L16:
        r105.f412406c = r112;
        Message r113 = r100.getMessage();
        if (r113 == null) goto L19;
        boolean r114 = r113.isFromMe();
    L20:
        r105.f412408d = r114;
        List<String> r115 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r115, "readAtChatterIds");
        r105.f412402a = r115;
        Message r116 = r100.getMessage();
        if (r116 == null) goto L23;
        Message.Status r117 = r116.getStatus();
    L25:
        if (r117 != Message.Status.DELETED) goto L27;
        boolean r118 = true;
    L28:
        r105.f412410e = r118;
        Message r119 = r100.getMessage();
        if (r119 == null) goto L31;
        r106 = r119.isFlag();
    L31:
        r105.f412414g = r106;
        String r120 = r110.getAnonymousId();
        if (r120 == null) goto L34;
        r105.f412419l = r120;
    L34:
        r105.f412418k = true;
        r105.f412401J = true;
        r105.K = true;
        j.a.c(r105, r103, r104);
        return new r(r105, this.f414013f);
    L27:
        r118 = false;
        goto L28
    L23:
        r117 = null;
        goto L25
    L19:
        r114 = false;
        goto L20
    L15:
        r112 = true;
    L11:
        r109 = false;
        goto L12
    L5:
        return new s(true, this.f414010c, r100, this.f414013f);
    }

    public final Layout b(int r100, RichTextData r101, q r110) {
        if ((r110 instanceof r) == false) goto L5;
        j r102 = new j(this.f414008a);
    L6:
        ((HashMap) this.f414014g).put(Integer.valueOf(r100), r102);
        CharSequence r103 = r102.a(r101.getRichText(), r110);
        if (r103 != null) goto L10;
        Log.e("MsgFSRichTextSetup", "no charSequence parsed");
        return null;
    L10:
        String r104 = r101.getTitle();
        Intrinsics.checkNotNullParameter(r103, "charSequence");
        Intrinsics.checkNotNullParameter(r110, "config");
        SpannableStringBuilder r111 = new SpannableStringBuilder();
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L19;
        SpannableStringBuilder r106 = new SpannableStringBuilder();
        StyleSpan r107 = new StyleSpan(1);
        int r108 = r106.length();
        r106.append(r104);
        r106.setSpan(r107, r108, r106.length(), 17);
        r106.append("\n");
        int r109 = zz7.b.g(r102.f414128a, 10);
        e0.a r112 = new e0.a();
        r112.f448672a = r109;
        e0 r113 = new e0(r112);
        Intrinsics.checkNotNull(r113);
        int r114 = r106.length();
        r106.append("\n");
        r106.setSpan(r113, r114, r106.length(), 17);
        new AbsoluteSizeSpan(p.a(r102.f414128a));
        r111.append(new SpannedString(r106));
    L19:
        r111.append(r103);
        TextLayoutBuilder r115 = new TextLayoutBuilder();
        r115.h(r111);
        r115.j(p.a(r102.f414128a));
        r115.c(Layout.Alignment.ALIGN_NORMAL);
        r115.l(1.0f);
        r115.k(UIHelper.dp2px(8.0f));
        r115.i(UIUtils.getColor(r102.f414128a, R.color.text_title));
        Layout r116 = r115.a();
        if (r116 != null) goto L23;
        Log.e("MsgFSRichTextSetup", "no layout generated");
        return null;
    L23:
        return r116;
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
        goto L17
    L5:
        r102 = new MessageFullScreenRichTextParser2(this.f414008a);
        goto L6
    }

    public final void e(final LKUILightTextView r100, final RichText r101, final boolean r110) {
        if (r101 != null) goto L4;
        return;
    L4:
        final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r102 = this.f414010c;
        if (r102 == null) goto L43;
        int r103 = a.f414018m;
        Function1<a, Unit> r104 = new MessageFullScreenRichTextSetup$setClickHandler$1$1(r102, r101, r110, r100, this);
        Intrinsics.checkNotNullParameter(r104, "click");
        a r105 = new a();
        r104.invoke(r105);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r105, "clickHandler");
        mcc.l r111 = r105.f414019a;
        if (r111 == null) goto L9;
        r100.setPhoneSpanClickListener(r111);
    L9:
        mcc.o r112 = r105.f414020b;
        if (r112 == null) goto L12;
        r100.setUrlSpanClickListener(r112);
    L12:
        mcc.b r113 = r105.f414021c;
        if (r113 == null) goto L15;
        r100.setAtSpanClickListener(r113);
    L15:
        mcc.i r114 = r105.f414022d;
        if (r114 == null) goto L18;
        r100.setMentionSpanClickListener(r114);
    L18:
        mcc.g r115 = r105.f414023e;
        if (r115 == null) goto L21;
        r100.setImageSpanClickListener(r115);
    L21:
        mcc.h r116 = r105.f414024f;
        if (r116 == null) goto L24;
        r100.setMediaSpanClickListener(r116);
    L24:
        mcc.e r117 = r105.f414025g;
        if (r117 == null) goto L27;
        r100.setCodeBlockV2SpanCLickListener(r117);
    L27:
        mcc.n r118 = r105.f414026h;
        if (r118 == null) goto L30;
        r100.setTableSpanClickListener(r118);
    L30:
        mcc.f r119 = r105.f414027i;
        if (r119 == null) goto L33;
        r100.setColumnsSpanClickListener(r119);
    L33:
        mcc.a r120 = r105.f414028j;
        if (r120 == null) goto L36;
        r100.setAbbreviationClickListener(r120);
    L36:
        View.OnClickListener r121 = r105.f414029k;
        if (r121 == null) goto L39;
        r100.setOnClickListener(r121);
    L39:
        View.OnLongClickListener r106 = r105.f414030l;
        if (r106 == null) goto L44;
        r100.setOnLongClickListener(r106);
        return;
    L44:
        return;
    }
}
