package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MessageReplyCountBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f412825h;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f412826a = null;

        static {
            int[] r100 = new int[ReplyInThreadUtil.ReplyOptimizeFGState.values().length];
            r100[ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f412826a = r100;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageReplyCountBlock f412827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.c<?> f412828b;

        public b(MessageReplyCountBlock r100, y6b.c<?> r101) {
            this.f412827a = r100;
            this.f412828b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b3b.f r101 = (b3b.f) this.f412827a.f412825h.getValue();
            if (r101 == null) goto L6;
            r101.z(this.f412828b.f566482c, z5c.u0.f570379c.f540772b);
            return;
        }
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412824g;
    }

    public MessageReplyCountBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412824g = IMMessageKeys$Blocks.REPLY_COUNT;
        this.f412825h = LazyKt.lazy(new MessageReplyCountBlock$replyClickListener$2(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f412824g, IMMessageKeys$Slots.BOTTOM);
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r110, y6b.a<?> r111) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r110, "layout");
        Intrinsics.checkNotNullParameter(r111, "data");
        y6b.c r112 = (y6b.c) r111;
        int r101 = r112.f566497l;
        Boolean r102 = ReplyInThreadUtil.f416628a;
        Intrinsics.checkNotNullParameter(r112, "messageVO");
        boolean r103 = ReplyInThreadUtil.b(r112);
        if (r103 == false) goto L8;
        if (r112.T1 > 0) goto L8;
        Log.i("ReplyInThreadUtil", "message is thread message, but reply count = " + r112.T1);
    L8:
        if (r103 == true) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == true) goto L52;
        if (r101 == 0) goto L52;
        com.ss.android.lark.blueprint.k r113 = r110.c(this.f412824g, IMMessageKeys$Slots.BOTTOM, new MessageReplyCountBlock$update$blockView$1(this));
        ReplyInThreadUtil.ReplyOptimizeFGState r105 = ReplyInThreadUtil.e(com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.f412673c).C(), this.f412673c.getChat());
        int[] r106 = a.f412826a;
        int r107 = r106[r105.ordinal()];
        if (r107 == 1) goto L23;
        if (r107 == 2) goto L23;
        if (r101 != 1) goto L22;
        ((AppCompatTextView) r113.getView()).setText(UIHelper.mustacheFormat(R.string.Lark_Legacy_ChatNumReplySinglular, "count", String.valueOf(r101)));
    L24:
        ((AppCompatTextView) r113.getView()).setOnClickListener(new b(this, r112));
        ChatThemeInfo r108 = this.f412673c.r8();
        if (r108 == null) goto L27;
        ChatThemeInfo.Scene r109 = r108.getComponentScene();
    L28:
        boolean r114 = com.ss.android.lark.chat.utils.p.g(r109);
        if (r114 == false) goto L37;
        ChatThemeInfo r115 = this.f412673c.r8();
        if (r115 == null) goto L33;
        ChatThemeInfo.Scene r116 = r115.getComponentScene();
    L35:
        if (com.ss.android.lark.chat.utils.p.f(r116) == false) goto L37;
        boolean r117 = true;
    L38:
        int r118 = zz7.b.g(getContext(), 12);
        int r119 = r106[ReplyInThreadUtil.e(com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.f412673c).C(), this.f412673c.getChat()).ordinal()];
        if (r119 == 1) goto L42;
        if (r119 == 2) goto L42;
        Drawable r120 = UIUtils.getDrawable(getContext(), R.drawable.ic_svg_message_tag_reply);
    L43:
        r120.setBounds(0, 0, r118, r118);
        if (r114 == true) goto L46;
    L49:
        int r121 = com.ss.android.lark.chat.utils.p.d(getContext());
        ((AppCompatTextView) r113.getView()).setTextColor(r121);
        r120.setTint(r121);
    L50:
        ((AppCompatTextView) r113.getView()).setCompoundDrawables(r120, null, null, null);
        return;
    L46:
        if (h18.f.a(getContext()) == true) goto L48;
        if (r117 == false) goto L49;
    L48:
        Context r122 = getContext();
        Intrinsics.checkNotNullParameter(r122, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r123 = UIUtils.getColor(r122, R.color.text_link_normal_color_in_dark_mode);
        ((AppCompatTextView) r113.getView()).setTextColor(r123);
        r120.setTint(r123);
    L42:
        r120 = UIUtils.getDrawable(getContext(), R.drawable.ic_svg_quote_filled);
        goto L43
    L33:
        r116 = null;
    L37:
        r117 = false;
        goto L38
    L27:
        r109 = null;
        goto L28
    L22:
        ((AppCompatTextView) r113.getView()).setText(UIHelper.mustacheFormat(R.string.Lark_Legacy_ChatNumReplyPlural, "count", String.valueOf(r101)));
    L23:
        ((AppCompatTextView) r113.getView()).setText(ICUUtils.icuFormat(UIHelper.getQuantityString(R.plurals.Lark_IM_QuotedReply_Test_Desc, r101), "num", String.valueOf(r101)));
    L52:
        g(r110, this.f412824g, IMMessageKeys$Slots.BOTTOM);
        return;
    L10:
        if (r112.T1 <= 0) goto L12;
        r104 = true;
        goto L13
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
