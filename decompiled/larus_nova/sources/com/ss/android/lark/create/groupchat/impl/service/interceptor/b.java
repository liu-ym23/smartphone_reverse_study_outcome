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

/* JADX INFO: loaded from: classes35.dex */
@InterceptorKey(InterceptorType.DLP)
public final class b implements com.ss.android.lark.create.groupchat.impl.service.c {
    @Inject
    public b() {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.c
    public final boolean a(Context r100, CreateGroupScene r101, ErrorResult r102, Function1<? super Boolean, Unit> r103, Fragment r104, CreateGroupService.c r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "err");
        int r106 = iab.a.f488974c;
        hab.a r107 = iab.a.C6248a.a().f488976b;
        if (r107 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("auditDependency");
        r107 = null;
    L7:
        return r107.d(r102.getCode(), r102.getExtra());
    }
}
