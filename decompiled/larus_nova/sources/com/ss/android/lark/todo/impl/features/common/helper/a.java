package com.ss.android.lark.todo.impl.features.common.helper;

import android.content.Context;
import com.bytedance.lark.pb.todo.v1.CustomComplete;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f442447a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.common.helper.a$a, reason: collision with other inner class name */
    public interface InterfaceC5344a {
        void a(String r100);
    }

    static {
    }

    public static boolean a(Context r100, CustomComplete.Action r101, InterfaceC5344a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "completeAction");
        Intrinsics.checkNotNullParameter(r102, "listener");
        if (r101.href.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        TodoDependencyHolder.a().browserDependency().openUrl(r100, r101.href);
        return true;
    L10:
        if ((!r101.tip.isEmpty()) == false) goto L13;
        Lazy r104 = LanguageHelper.f442435a;
        r102.a(LanguageHelper.b(r101.tip));
        return true;
    L13:
        return false;
    L5:
        r103 = false;
        goto L6
    }
}
