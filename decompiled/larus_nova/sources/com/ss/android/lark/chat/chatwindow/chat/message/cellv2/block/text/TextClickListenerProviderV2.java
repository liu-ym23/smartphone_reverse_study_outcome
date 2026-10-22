package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text;

import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.message.params.o;
import com.ss.android.lark.biz.im.api.message.params.y;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.k0;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.message.menu.MessageLongPressTextSelectHelper;
import com.ss.android.lark.chatbase.view.TextChatView2;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class TextClickListenerProviderV2 implements BaseTextContentRender.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2b.a f413260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f413261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f413262c;

    public interface a {
        boolean a(y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r100);

        void b(y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r100);

        void c(y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r100);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender.b
    public final com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.a b(y6b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.a(this, r100);
    }

    public TextClickListenerProviderV2(m2b.a r100, TextChatView2 r101, k0 r102) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        Intrinsics.checkNotNullParameter(r101, "popupAnchorView");
        this.f413260a = r100;
        this.f413261b = r101;
        this.f413262c = r102;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender.b
    public final TextClickListenerProviderV2$getDoubleClickListener$1 a(y6b.a r100, boolean r101, TextChatView2 r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r102, "textChatView2");
        return new TextClickListenerProviderV2$getDoubleClickListener$1(this, r102, r100, r101);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender.b
    public final b c(y6b.a r100, boolean r101, TextChatView2 r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r102, "targetView");
        return new b(this, r102, r100, r101);
    }

    public final void d(LKUILightTextView r100, final y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r101, boolean r110, final Function1<? super y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "selectableView");
        Intrinsics.checkNotNullParameter(r101, "messageVO");
        m2b.a r102 = this.f413260a;
        Function3<CharSequence, Boolean, PartialReplyInfo.PartialContentRelativePosition, Unit> r103 = new TextClickListenerProviderV2$showTextSelect$1(r101);
        Function0<Unit> r104 = new TextClickListenerProviderV2$showTextSelect$2(r111, r101, this);
        y r112 = (y) this.f413260a.d0(y.class);
        y6b.c r105 = null;
        if (r112 == null) goto L18;
        o r113 = r112.f410405j;
        if (r113 == null) goto L18;
        if ((r101 instanceof y6b.c) == false) goto L9;
        r105 = (y6b.c) r101;
    L9:
        if (r105 == null) goto L13;
        boolean r106 = r105.f566492i;
        boolean r107 = true;
        if (r106 != true) goto L13;
    L14:
        if (r107 == false) goto L16;
        int r108 = r113.f410372a;
    L17:
        Integer r109 = Integer.valueOf(UIUtils.getColor(r100.getContext(), r108));
    L19:
        MessageLongPressTextSelectHelper.f(r100, r102, r110, r103, r104, r109);
        return;
    L16:
        r108 = r113.f410373b;
    L13:
        r107 = false;
    L18:
        r109 = null;
        goto L19
    }
}
