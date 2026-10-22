package com.ss.android.lark.picker.doubao.view.pickercommon;

import com.larus.nova.R;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoThreadAvatar;", "", "<init>", "()V", "mainIconRes", "", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)Ljava/lang/Integer;", "badgeIconRes", "avatarEntityId", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoThreadAvatar {
    public static final DoubaoThreadAvatar INSTANCE = null;

    static {
        INSTANCE = new DoubaoThreadAvatar();
    }

    private DoubaoThreadAvatar() {
    }

    public final String avatarEntityId(SearchBaseInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        if ((r100 instanceof SearchReplyInThreadInfo) == false) goto L6;
        return ((SearchReplyInThreadInfo) r100).getEntityId();
    L6:
        if ((r100 instanceof SearchThreadInfo) == false) goto L24;
        SearchThreadInfo r101 = (SearchThreadInfo) r100;
        Channel r102 = r101.getChannel();
        if (r102 == null) goto L21;
        String r103 = r102.getId();
        if (r103 == null) goto L21;
        if (r103.length() <= 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L18;
        r103 = null;
    L18:
        if (r103 == null) goto L21;
        return r103;
    L14:
        r104 = false;
    L21:
        String r105 = r101.getChatId();
        if (r105 == null) goto L27;
        return r105;
    L27:
        return "";
    L24:
        String r106 = r100.getId();
        if (r106 == null) goto L27;
        return r106;
    }

    public final Integer badgeIconRes(SearchBaseInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        if ((r100 instanceof SearchChatInfo) == true) goto L5;
        return null;
    L5:
        if (((SearchChatInfo) r100).isThread() == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(R.drawable.icon_flow_forward_thread);
    }

    public final Integer mainIconRes(SearchBaseInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        if ((r100 instanceof SearchReplyInThreadInfo) == true) goto L9;
        if ((r100 instanceof SearchThreadInfo) == true) goto L9;
        return null;
    L9:
        return Integer.valueOf(R.drawable.icon_flow_forward_msg_thread);
    }
}
