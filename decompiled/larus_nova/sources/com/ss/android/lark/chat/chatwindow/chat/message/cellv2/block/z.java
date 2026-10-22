package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larus.nova.R;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chatwindow.view.readstate.ReadStateView;
import com.ss.android.lark.chatwindow.view.widget.DelayDisplayProgressbar;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class z extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e6b.c f413301i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e6b.c f413302j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e6b.c f413303k = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Slots f413304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b3b.f f413305h;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f413306a = null;

        static {
            int[] r100 = new int[SendStatus.values().length];
            r100[SendStatus.SENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SendStatus.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f413306a = r100;
        }
    }

    static {
        f413301i = new e6b.c("KEY_READ_STATUS");
        f413302j = new e6b.c("KEY_SENDING_STATUS");
        f413303k = new e6b.c("KEY_SEND_FAIL_STATUS");
    }

    public z(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        IMMessageKeys$Blocks r101 = IMMessageKeys$Blocks.UNKNOWN_CONTENT;
        this.f413304g = IMMessageKeys$Slots.CORNER_1;
        b3b.f r102 = this.f412674d;
        if ((r102 instanceof b3b.o) == true) goto L6;
        r102 = null;
    L6:
        this.f413305h = r102;
    }

    public final void h(com.ss.android.lark.blueprint.q<?> r100) {
        e6b.c r101 = f413301i;
        Object r102 = r100.f(r101, this.f413304g);
        if ((r102 instanceof ReadStateView) == false) goto L5;
        ReadStateView r103 = (ReadStateView) r102;
    L6:
        if (r103 == null) goto L8;
        r103.setProgress(0.0f);
    L8:
        com.ss.android.lark.blueprint.k<?> r104 = r100.f(r101, this.f413304g);
        if (r104 == null) goto L13;
        View r105 = r104.getView();
        if (r105 == null) goto L13;
        r105.setOnClickListener(null);
    L13:
        com.ss.android.lark.blueprint.k<?> r106 = r100.f(r101, this.f413304g);
        if (r106 == null) goto L18;
        View r107 = r106.getView();
        if (r107 == null) goto L18;
        r107.setOnLongClickListener(null);
    L18:
        g(r100, r101, this.f413304g);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void i(com.ss.android.lark.blueprint.q<?> r100) {
        e6b.c r101 = f413302j;
        com.ss.android.lark.blueprint.k<?> r102 = r100.f(r101, this.f413304g);
        DelayDisplayProgressbar r103 = null;
        if (r102 == null) goto L5;
        View r104 = r102.getView();
    L7:
        if ((r104 instanceof DelayDisplayProgressbar) == false) goto L9;
        r103 = (DelayDisplayProgressbar) r104;
    L9:
        if (r103 == null) goto L11;
        r103.setTag(R.id.delay_progress_visible_tag, Boolean.FALSE);
        r103.removeCallbacks(r103.f417128a);
        r103.setVisibility(8);
    L11:
        g(r100, r101, this.f413304g);
        return;
    L5:
        r104 = null;
        goto L7
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r110, com.ss.android.lark.blueprint.q<y6b.a<?>> r111, y6b.a<?> r112) {
        Intrinsics.checkNotNullParameter(r110, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r111, "layout");
        Intrinsics.checkNotNullParameter(r112, "data");
        b0 r100 = null;
        if ((r112 instanceof y6b.c) == false) goto L5;
        y6b.c r101 = (y6b.c) r112;
    L6:
        boolean r102 = true;
        int r103 = 0;
        if (r101 == null) goto L56;
        y6b.c r104 = (y6b.c) r112;
        if (r104.isPreMessage() == false) goto L16;
        SendStatus r105 = r104.f566507s;
        if (r105 != SendStatus.SENDING) goto L14;
    L15:
        boolean r106 = true;
    L18:
        if (r101.f566492i == true) goto L20;
    L37:
        boolean r107 = false;
    L38:
        if (r107 == true) goto L40;
        h(r111);
        goto L56
    L40:
        Chat r108 = this.f412673c.getChat();
        if (r108 == null) goto L56;
        int r109 = r101.P0 - 1;
        int r113 = r101.V0;
        int r114 = r109 + r113;
        Log.i("MessageStatusBlock", r101.f566482c + ", unread:" + r114 + '/' + r109 + '/' + r113);
        if (this.f412673c.B8() == false) goto L46;
        h(r111);
        goto L56
    L46:
        com.ss.android.lark.blueprint.k r115 = r111.c(f413301i, this.f413304g, new MessageStatusBlock$requireReadStatusView$1(this));
        if (r114 <= 0) goto L49;
        ((ReadStateView) r115.getView()).setProgress((r109 * 1.0f) / r114);
    L52:
        ((ReadStateView) r115.getView()).setTag(Boolean.FALSE);
        b0 r116 = new b0(r101, r108, this);
        ReadStateView r117 = (ReadStateView) r115.getView();
        if (this.f412673c.isGroup() == false) goto L55;
        r100 = r116;
    L55:
        r117.setOnClickListener(r100);
        ((ReadStateView) r115.getView()).setOnLongClickListener(new a0(this, r110, r101));
        goto L56
    L49:
        if (r114 != 0) goto L51;
        ((ReadStateView) r115.getView()).setProgress(1.0f);
        goto L52
    L51:
        h(r111);
        goto L52
    L20:
        if (this.f412673c.X() == true) goto L37;
        if (this.f412673c.B8() == true) goto L37;
        if (this.f412673c.h() == true) goto L37;
        if (this.f412673c.o() == true) goto L37;
        if (r101.D == MessageDLPState.BLOCK) goto L37;
        if (r101.f566520z == true) goto L37;
        if (this.f412673c.isAIChat() == true) goto L37;
        if (this.f412673c.e0() == true) goto L37;
        if (r106 == true) goto L37;
        r107 = true;
        goto L38
    L14:
        if (r105 == SendStatus.FAIL) goto L15;
    L16:
        r106 = false;
    L56:
        boolean r118 = this.f412673c.s8();
        e6b.c r119 = f413303k;
        if (r118 == false) goto L59;
    L103:
        g(r111, r119, this.f413304g);
        i(r111);
        return;
    L59:
        if (this.f412673c.o() == true) goto L103;
        if (r112.h() == true) goto L63;
    L65:
        boolean r120 = false;
    L66:
        if (r120 == true) goto L103;
        Object r121 = r112.b();
        if (r112.G() != SendStatus.SUCCESS) goto L71;
        boolean r122 = true;
    L73:
        if (r112.isPreMessage() == false) goto L102;
        if (r122 == true) goto L102;
        int r123 = b.f413306a[r112.G().ordinal()];
        if (r123 != 1) goto L78;
        h(r111);
        g(r111, r119, this.f413304g);
        Message.Type r124 = r112.getType();
        if (r124 == Message.Type.MEDIA) goto L84;
        boolean r125 = true;
    L86:
        if ((r121 instanceof AudioContentVO) == false) goto L93;
        if (((AudioContentVO) r121).f411849s != AudioContent.AudioState.RECORDING) goto L91;
        r102 = false;
    L91:
        r125 = r125 & r102;
    L93:
        if (r124 != Message.Type.IMAGE) goto L95;
        r125 = false;
    L95:
        if (r125 == false) goto L101;
        com.ss.android.lark.blueprint.k r126 = r111.c(f413302j, this.f413304g, new MessageStatusBlock$requireSendingStatusView$1(this));
        ((DelayDisplayProgressbar) r126.getView()).setVisibility(0);
        DelayDisplayProgressbar r127 = (DelayDisplayProgressbar) r126.getView();
        if ((System.currentTimeMillis() - (r112.getCreateTime() * ((long) 1000))) > 2000) goto L100;
        r103 = h7b.l.c();
    L100:
        r127.setTag(R.id.delay_progress_visible_tag, Boolean.TRUE);
        r127.setVisibility(4);
        r127.postDelayed(r127.f417128a, r103);
        return;
    L101:
        i(r111);
        return;
    L84:
        r125 = false;
        goto L86
    L78:
        if (r123 != 2) goto L109;
        h(r111);
        i(r111);
        g(r111, r119, this.f413304g);
        com.ss.android.lark.blueprint.k r128 = r111.c(r119, this.f413304g, new MessageStatusBlock$requireSendFailStatusView$1(this));
        ((ImageView) r128.getView()).setVisibility(0);
        ((ImageView) r128.getView()).setOnClickListener(new c0(this, r112));
        return;
    L109:
        return;
    L102:
        i(r111);
        g(r111, r119, this.f413304g);
        return;
    L71:
        r122 = false;
        goto L73
    L63:
        if (MessageDLPState.BLOCK != r112.t()) goto L65;
        r120 = true;
        goto L66
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
