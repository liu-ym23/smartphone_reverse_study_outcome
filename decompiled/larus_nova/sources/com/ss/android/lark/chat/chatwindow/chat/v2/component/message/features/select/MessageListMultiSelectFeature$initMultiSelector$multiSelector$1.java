package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.select;

import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import com.ss.android.lark.chat.chatwindow.chat.a;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.widget.recyclerview.MultiSelector;
import e4b.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w4b.u;
import y6b.c;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/select/MessageListMultiSelectFeature$initMultiSelector$multiSelector$1", "Lcom/ss/android/lark/widget/recyclerview/MultiSelector;", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "Lcom/ss/android/lark/chat/chatwindow/chat/IChatAdapter;", "isItemSelectable", "", MapController.ITEM_LAYER_TAG, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 extends MultiSelector<c<?>, a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ b f413934f;

    @Override // com.ss.android.lark.widget.recyclerview.MultiSelector
    public final boolean b(c<?> r100) {
        c<?> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        ValidateIMFileResult r102 = r101.F;
        if (r102 == null) goto L5;
        IMFileResult r103 = r102.getResultType();
    L7:
        if (r103 != null) goto L9;
        u r104 = MessagePermissionUtil.f416615a;
        boolean r105 = false;
    L11:
        if (this.f448175d == false) goto L14;
        if (r105 == true) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == true) goto L18;
        return false;
    L18:
        if (this.f413934f.f471029b != ListMode.SELECT_MESSAGES_FOR_CALLER) goto L40;
        if (r101.isPreMessage() == false) goto L22;
    L36:
        boolean r107 = false;
    L37:
        if (r107 == false) goto L40;
    L43:
        return true;
    L22:
        if (r101.j() == true) goto L36;
        if (r101.G != null) goto L36;
        if (r101.f566517y == true) goto L36;
        if (r101.f566520z == true) goto L36;
        if (r101.getType() == Message.Type.SYSTEM) goto L36;
        if (r101.getType() == Message.Type.RED_PACKET) goto L36;
        if (r101.getType() == Message.Type.UNKNOWN) goto L36;
        r107 = true;
    L40:
        if (this.f413934f.f471029b == ListMode.MULTI_SELECT) goto L42;
        return false;
    L42:
        if (r101.X() == true) goto L43;
        return false;
    L14:
        r106 = false;
        goto L15
    L9:
        r105 = MessagePermissionUtil.g(MessagePermissionUtil.h(r103));
        goto L11
    L5:
        r103 = null;
        goto L7
    }

    public MessageListMultiSelectFeature$initMultiSelector$multiSelector$1(a r100, b r101) {
        this.f413934f = r101;
        super(r100);
    }
}
