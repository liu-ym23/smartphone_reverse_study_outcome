package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.impl.service.CreateGroupService;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorKey;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorType;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$TextType;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupHitPointNew;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@InterceptorKey(InterceptorType.HIT_POINT)
public final class f implements com.ss.android.lark.create.groupchat.impl.service.c {
    @Inject
    public f() {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.c
    public final boolean a(Context r100, CreateGroupScene r101, ErrorResult r102, Function1<? super Boolean, Unit> r103, Fragment r104, CreateGroupService.c r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "err");
        CreateGroupExtraParams$TextType r106 = a.b(r101);
        int r107 = CreateGroupHitPointNew.f420247a;
        Intrinsics.checkNotNullParameter(r106, "extraParams");
        Statistics.sendEvent("im_chat_member_toplimit_view", s5c.b.a(ChatParamUtils.e(), r106).toJson());
        return false;
    }
}
