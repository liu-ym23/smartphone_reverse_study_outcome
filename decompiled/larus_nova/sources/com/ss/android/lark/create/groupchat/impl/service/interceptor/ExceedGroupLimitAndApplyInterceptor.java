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
@InterceptorKey(InterceptorType.EXCEED_GROUP_LIMIT_NEED_APPLY)
public final class ExceedGroupLimitAndApplyInterceptor implements com.ss.android.lark.create.groupchat.impl.service.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f420217a = 0;

    public static final class a {
    }

    static {
    }

    @Inject
    public ExceedGroupLimitAndApplyInterceptor() {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.c
    public final boolean a(Context r110, CreateGroupScene r111, ErrorResult r112, Function1<? super Boolean, Unit> r113, Fragment r114, CreateGroupService.c r115) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r112, "err");
        boolean r100 = false;
        if (r112.getErrorCode() == 7011) goto L8;
        if (r112.getErrorCode() == 7012) goto L8;
        return false;
    L8:
        if (r112.getErrorCode() != 7012) goto L10;
        r100 = true;
    L10:
        BuildersKt.launch$default(com.ss.android.lark.create.groupchat.impl.service.interceptor.a.a(r110), Dispatchers.getMain(), null, new ExceedGroupLimitAndApplyInterceptor$intercept$1(r112, r110, r100, r113, null), 2, null);
        return true;
    }
}
