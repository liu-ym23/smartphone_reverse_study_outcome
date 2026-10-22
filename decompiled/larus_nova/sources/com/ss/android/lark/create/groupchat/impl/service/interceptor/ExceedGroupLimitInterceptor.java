package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.impl.service.CreateGroupService;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorKey;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorType;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes35.dex */
@InterceptorKey(InterceptorType.EXCEED_GROUP_LIMIT)
public final class ExceedGroupLimitInterceptor implements com.ss.android.lark.create.groupchat.impl.service.c {
    @Inject
    public ExceedGroupLimitInterceptor() {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.c
    public final boolean a(Context r100, CreateGroupScene r101, ErrorResult r102, Function1<? super Boolean, Unit> r110, Fragment r111, CreateGroupService.c r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "err");
        if (r102.getErrorCode() == 7010) goto L6;
        return false;
    L6:
        BuildersKt.launch$default(a.a(r100), Dispatchers.getMain(), null, new ExceedGroupLimitInterceptor$intercept$1(r102, r100, this, null), 2, null);
        return true;
    }
}
