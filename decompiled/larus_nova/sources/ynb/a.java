package ynb;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.lark.pb.im.v1.DoubaoTyping;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.bytedance.lark.pb.im.v1.TypingMessage;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.biz.im.api.extension.chat_window.h;
import com.ss.android.lark.chat.entity.ComponentType;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.dependency.KeyboardAssemblerModule;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.parser.internal.j;
import com.ss.android.lark.utils.UIHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wnb.e;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements wnb.b<a> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C8362a f568578o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f568579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f568580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wnb.c f568581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f568582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f568583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f568584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f568585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f568586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f568587i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f568588j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Chatter f568589k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f568590l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f568591m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f568592n;

    /* JADX INFO: renamed from: ynb.a$a, reason: collision with other inner class name */
    public static final class C8362a implements wnb.b.a<a> {
        public C8362a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f568593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f568594b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f568593a == r101.f568593a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f568594b, r101.f568594b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f568593a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f568594b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "TypingUiState(visible=" + this.f568593a + ", displayName=" + this.f568594b + ')';
        }

        public b(boolean r100, String r101) {
            this.f568593a = r100;
            this.f568594b = r101;
        }
    }

    public static final class c extends aqb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f568595a;

        public c(a r100) {
            this.f568595a = r100;
        }

        @Override // aqb.a, m6b.o
        public final void e(DoubaoTyping r110) {
            Intrinsics.checkNotNullParameter(r110, "doubaoTyping");
            Log.i("InputStateTopExpandPlugin", "receives doubaoTyping push: chatId: " + r110.chat_id + ", messageIds: " + r110.message_ids + ", updateMs: " + r110.update_time_ms);
            if (Intrinsics.areEqual(this.f568595a.g(), r110.chat_id.toString()) == true) goto L6;
            Log.e("InputStateTopExpandPlugin", "receives doubaoTyping push ignored: pushChatId=" + r110.chat_id + ", currentChatId=" + this.f568595a.g());
            return;
        L6:
            long r100 = r110.update_time_ms.longValue();
            a r101 = this.f568595a;
            if (r100 >= r101.f568588j) goto L10;
            Log.w("InputStateTopExpandPlugin", "receive doubaoTyping push but not latest: " + r110.update_time_ms + " < " + this.f568595a.f568588j);
            return;
        L10:
            r101.f568588j = r110.update_time_ms.longValue();
            a r102 = this.f568595a;
            if (r102.f568582d == null) goto L181;
            List<TypingMessage> r103 = r110.messages;
            h r104 = r102.f568579a.f410100e;
            boolean r105 = true;
            if (r104 == null) goto L23;
            ComponentType r106 = r104.f410101a;
            if (r106 == null) goto L23;
            ComponentType.Companion.getClass();
            Intrinsics.checkNotNullParameter(r106, "<this>");
            if (r106 != ComponentType.CHAT) goto L20;
            boolean r107 = true;
        L21:
            if (r107 != true) goto L23;
            boolean r108 = true;
        L24:
            if (r108 == false) goto L42;
            Intrinsics.checkNotNull(r103);
            List<TypingMessage> r109 = r103;
            if ((r109 instanceof Collection) == true) goto L28;
        L30:
            Iterator<T> r111 = r109.iterator();
        L32:
            if (r111.hasNext() == false) goto L71;
            TypingMessage r112 = (TypingMessage) r111.next();
            Long r113 = r112.thread_id;
            if (r113 != null) goto L36;
        L39:
            boolean r114 = true;
        L40:
            if (r114 == false) goto L32;
        L70:
            boolean r115 = true;
        L73:
            if (r115 == true) goto L75;
            b r116 = new b(false, null);
        L86:
            Log.i("InputStateTopExpandPlugin", "renderTyping: visible=" + r116.f568593a);
            boolean r117 = r116.f568593a;
            if (r117 == true) goto L89;
        L91:
            boolean r118 = false;
        L92:
            r102.f568591m = r117;
            if (r117 == true) goto L107;
            View r119 = r102.f568582d;
            if (r119 != null) goto L97;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r119 = null;
        L97:
            r119.animate().cancel();
            View r120 = r102.f568582d;
            if (r120 != null) goto L100;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r120 = null;
        L100:
            r120.setTranslationY(0.0f);
            View r121 = r102.f568582d;
            if (r121 != null) goto L103;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r121 = null;
        L103:
            r121.setAlpha(1.0f);
            View r122 = r102.f568582d;
            if (r122 != null) goto L106;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r122 = null;
        L106:
            r122.setVisibility(8);
        L135:
            boolean r123 = r116.f568593a;
            ImageView r124 = r102.f568583e;
            if (r124 == null) goto L156;
            if (r123 == true) goto L146;
            Animator r125 = r102.f568584f;
            if (r125 == null) goto L142;
            r125.cancel();
        L142:
            r102.f568584f = null;
            Drawable r126 = r124.getBackground();
            if (r126 == null) goto L145;
            r126.setAlpha(0);
        L145:
            r124.setAlpha(1.0f);
            r124.setVisibility(0);
            goto L156
        L146:
            Animator r127 = r102.f568584f;
            if (r127 != null) goto L149;
        L151:
            boolean r128 = false;
        L152:
            if (r128 == true) goto L156;
            ValueAnimator r129 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r129.setDuration(1000);
            r129.setRepeatCount(-1);
            r129.setRepeatMode(1);
            r129.addUpdateListener(new ynb.b(r124));
            r129.start();
            r102.f568584f = r129;
            goto L156
        L149:
            if (r127.isRunning() != true) goto L151;
            r128 = true;
        L156:
            if (r116.f568593a == false) goto L178;
            String r130 = r116.f568594b;
            if (r130 != null) goto L160;
        L163:
            if (r105 == true) goto L179;
            TextView r131 = r102.f568585g;
            if (r131 == null) goto L180;
            r131.setText(r102.f(r130));
            return;
        L180:
            return;
        L179:
            return;
        L160:
            if (StringsKt.isBlank(r130) == true) goto L163;
            r105 = false;
            goto L163
        L178:
            return;
        L107:
            View r132 = r102.f568582d;
            if (r132 != null) goto L110;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r132 = null;
        L110:
            r132.setVisibility(0);
            if (r118 == true) goto L122;
            View r133 = r102.f568582d;
            if (r133 != null) goto L115;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r133 = null;
        L115:
            r133.animate().cancel();
            View r134 = r102.f568582d;
            if (r134 != null) goto L118;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r134 = null;
        L118:
            r134.setTranslationY(0.0f);
            View r135 = r102.f568582d;
            if (r135 != null) goto L121;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r135 = null;
        L121:
            r135.setAlpha(1.0f);
            goto L135
        L122:
            View r136 = r102.f568582d;
            if (r136 != null) goto L125;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r136 = null;
        L125:
            r136.animate().cancel();
            View r137 = r102.f568582d;
            if (r137 != null) goto L128;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r137 = null;
        L128:
            r137.setAlpha(0.0f);
            View r138 = r102.f568582d;
            if (r138 != null) goto L131;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r138 = null;
        L131:
            r138.setTranslationY(0.0f);
            View r139 = r102.f568582d;
            if (r139 != null) goto L134;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r139 = null;
        L134:
            r139.post(new ynb.c(r102));
            goto L135
        L89:
            if (r102.f568591m == true) goto L91;
            r118 = true;
            goto L92
        L75:
            Chatter r140 = j.a(r110.chatter);
            if (r140 == null) goto L78;
            String r141 = r140.getId();
        L80:
            if (r102.f568589k == null) goto L84;
            if (r141 != null) goto L83;
        L85:
            r116 = new b(true, m.b(r102.f568589k, ChatterNameDisplayRule.ALIAS_NAME, false));
            goto L86
        L83:
            if (Intrinsics.areEqual(r141, r102.f568590l) == true) goto L85;
        L84:
            r102.f568589k = r140;
            r102.f568590l = r141;
            goto L85
        L78:
            r141 = null;
            goto L80
        L36:
            if (Intrinsics.areEqual(r113, r112.msg_id) == true) goto L39;
            r114 = false;
        L71:
            r115 = false;
            goto L73
        L28:
            if (r109.isEmpty() == false) goto L30;
        L42:
            if (r104 == null) goto L51;
            ComponentType r142 = r104.f410101a;
            if (r142 == null) goto L51;
            ComponentType.Companion.getClass();
            Intrinsics.checkNotNullParameter(r142, "<this>");
            if (r142 != ComponentType.REPLY_IN_THREAD) goto L48;
            boolean r143 = true;
        L49:
            if (r143 != true) goto L51;
            boolean r144 = true;
        L52:
            if (r144 == false) goto L71;
            Intrinsics.checkNotNull(r103);
            List<TypingMessage> r145 = r103;
            if ((r145 instanceof Collection) == true) goto L56;
        L58:
            Iterator<T> r146 = r145.iterator();
        L60:
            if (r146.hasNext() == false) goto L71;
            TypingMessage r147 = (TypingMessage) r146.next();
            Long r148 = r147.thread_id;
            if (r148 != null) goto L64;
        L68:
            boolean r149 = false;
        L69:
            if (r149 == false) goto L60;
        L64:
            if (Intrinsics.areEqual(r148.toString(), r104.f410102b) == false) goto L68;
            if (Intrinsics.areEqual(r147.thread_id, r147.msg_id) == true) goto L68;
            r149 = true;
            goto L69
        L56:
            if (r145.isEmpty() == false) goto L58;
        L48:
            r143 = false;
        L51:
            r144 = false;
            goto L52
        L20:
            r107 = false;
        L23:
            r108 = false;
            goto L24
        }
    }

    static {
        f568578o = new C8362a();
    }

    @Override // wnb.b
    public final boolean i() {
        return false;
    }

    @Override // wnb.b
    public final View a() {
        itb.a r100 = (itb.a) OfficeSDKManager.getHostGlobalService(itb.a.class);
        if (r100 == null) goto L7;
        String r101 = r100.i();
        if (r101 == null) goto L7;
    L8:
        View r102 = LayoutInflater.from(this.f568579a.f410096a.requireContext()).inflate(R.layout.top_extend_view, null);
        ((TextView) r102.findViewById(R.id.text_view)).setText(f(r101));
        Intrinsics.checkNotNull(r102);
        r102.setVisibility(8);
        this.f568582d = r102;
        this.f568583e = (ImageView) r102.findViewById(R.id.ellipse);
        View r103 = this.f568582d;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r103 = null;
    L11:
        this.f568585g = (TextView) r103.findViewById(R.id.text_view);
        View r104 = this.f568582d;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r104 = null;
    L14:
        r104.findViewById(R.id.icon_view).setVisibility(8);
        ImageView r105 = this.f568583e;
        if (r105 == null) goto L21;
        GradientDrawable r106 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorProtector.parseColor("#00000000"), ColorProtector.parseColor("#55000000"), ColorProtector.parseColor("#00000000")});
        r106.setShape(1);
        r106.setGradientType(1);
        r106.setGradientRadius(32.0f);
        r105.setBackground(r106);
        Drawable r107 = r105.getBackground();
        if (r107 == null) goto L21;
        r107.setAlpha(0);
    L21:
        if (this.f568587i == true) goto L24;
        KeyboardAssemblerModule.a().registerPushChatRelation(this.f568586h, g(), SubscribeChatEventRequest.SubscriptionKey.DOUBAO_TYPING, this.f568592n);
        this.f568587i = true;
    L24:
        View r108 = this.f568582d;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        return null;
    L28:
        return r108;
    L7:
        r101 = "";
        goto L8
    }

    @Override // wnb.b
    public final e b() {
        return new e(UIHelper.dp2px(12.0f), 0, 0, 0);
    }

    public final String g() {
        String r100 = this.f568579a.f410098c.getId();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r100 = this.f568581c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final void onDestroy() {
        View r100 = this.f568582d;
        if (r100 == null) goto L5;
        r100.setOnClickListener(null);
    L5:
        Animator r101 = this.f568584f;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f568584f = null;
        this.f568583e = null;
        this.f568585g = null;
        if (this.f568587i == false) goto L13;
        KeyboardAssemblerModule.a().unregisterPushChatRelation(this.f568586h, g(), SubscribeChatEventRequest.SubscriptionKey.DOUBAO_TYPING);
        this.f568587i = false;
        return;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.TopExpand;
    }

    @Override // wnb.b
    public final wnb.b.a<a> getKey() {
        return f568578o;
    }

    public a(com.ss.android.lark.biz.im.api.extension.chat_window.b r100) {
        Intrinsics.checkNotNullParameter(r100, "keyboardPluginContext");
        this.f568579a = r100;
        this.f568586h = String.valueOf(hashCode());
        this.f568592n = new c(this);
    }

    @Override // wnb.b
    public final void e(InputInnerController r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f568581c = r100;
    }

    public final String f(String r100) {
        String r101 = UIUtils.getString(this.f568579a.f410096a.requireContext(), R.string.LarkIM_Group_DoubaoTyping_Text);
        ICUUtils.FormatArgsBuilder r102 = new ICUUtils.FormatArgsBuilder();
        r102.b("brandName", r100);
        return ICUUtils.icuFormat(r101, r102.f285892a);
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f568580b = r100;
    }
}
