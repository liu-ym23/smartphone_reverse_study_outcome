package com.larus.bmhome.share.api;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.component.share.q0;
import com.larus.bmhome.share.panel.h;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import sr8.b;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&JR\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H¦@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/share/api/IConversationSharePanelService;", "", "isAvailable", "", "show", "Lcom/larus/bmhome/share/api/ConversationSharePanelResult;", "activity", "Landroidx/fragment/app/FragmentActivity;", "token", "", "type", "", "shareUrl", "exportImageRunnable", "Ljava/lang/Runnable;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "displayInfo", "Lcom/larus/bmhome/share/api/ConversationShareDisplayInfo;", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Runnable;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/larus/bmhome/share/api/ConversationShareDisplayInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IConversationSharePanelService {
    Object a(FragmentActivity r100, String r101, int r102, String r103, q0 r104, h r105, b r106, Continuation r107);

    boolean isAvailable();
}
