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
@InterceptorKey(InterceptorType.GROUP_MEMBER_LIMIT)
public final class GroupMemberLimitInterceptor implements com.ss.android.lark.create.groupchat.impl.service.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f420220a = 0;

    public static final class a {
    }

    static {
    }

    @Inject
    public GroupMemberLimitInterceptor() {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.c
    public final boolean a(Context r100, CreateGroupScene r101, ErrorResult r102, Function1<? super Boolean, Unit> r110, Fragment r111, CreateGroupService.c r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "err");
        if (r102.getErrorCode() == 4013) goto L6;
        return false;
    L6:
        BuildersKt.launch$default(com.ss.android.lark.create.groupchat.impl.service.interceptor.a.a(r100), Dispatchers.getMain(), null, new GroupMemberLimitInterceptor$intercept$1(r102, r100, r101, null), 2, null);
        return true;
    }
}
