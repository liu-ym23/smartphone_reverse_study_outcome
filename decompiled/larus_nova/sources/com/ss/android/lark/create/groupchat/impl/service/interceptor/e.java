package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.DialogInterface;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$Click;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$TextType;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupHitPointNew;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import s5c.h;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreateGroupScene f420229a;

    public e(CreateGroupScene r100) {
        this.f420229a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        r100.dismiss();
        CreateGroupExtraParams$Click r102 = CreateGroupExtraParams$Click.CONFIRM;
        h r103 = h.f540777a;
        CreateGroupExtraParams$TextType r104 = a.b(this.f420229a);
        int r105 = CreateGroupHitPointNew.f420247a;
        s5c.d r106 = r102.plus(r103).plus(r104);
        Intrinsics.checkNotNullParameter(r106, "extraParams");
        Statistics.sendEvent("im_chat_member_toplimit_click", s5c.b.a(ChatParamUtils.e(), r106).toJson());
    }
}
