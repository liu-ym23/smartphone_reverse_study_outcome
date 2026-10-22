package com.ss.android.lark.todo.impl.features.common.share.helper;

import android.content.Context;
import com.bytedance.ee.lark.infra.foundation.utils.c;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;
import com.ss.android.lark.todo.impl.features.common.share.entity.ShareEntity;
import com.ss.android.lark.todo.impl.features.common.share.entity.ShareStatus;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f442481a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.common.share.helper.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C5345a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f442482a = null;

        static {
            int[] r100 = new int[ShareStatus.values().length];
            r100[ShareStatus.NO_LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ShareStatus.SHARE_LOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ShareStatus.SHARE_SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f442482a = r100;
        }
    }

    static {
    }

    public static void a(Context r110, ShareEntity r111) {
        Intrinsics.checkNotNullParameter(r111, "entity");
        ShareStatus r100 = r111.getStatus();
        int r101 = C5345a.f442482a[r100.ordinal()];
        boolean r102 = true;
        if (r101 != 1) goto L5;
        OperationToastHelper r112 = OperationToastHelper.f442443a;
        LKUIToast.cancelLoading();
        return;
    L5:
        if (r101 != 2) goto L7;
        OperationToastHelper r113 = OperationToastHelper.f442443a;
        if (r110 == null) goto L24;
        LKUIToast.showLoading(r110, R.string.Todo_Task_Sharing);
        Unit r114 = Unit.INSTANCE;
        return;
    L24:
        return;
    L7:
        if (r101 != 3) goto L9;
        OperationToastHelper.f(r110, R.string.Todo_Task_ShareSucTip, null, null, null, 124);
        return;
    L9:
        if (r111.getErrorStr().length() > 0) goto L12;
        r102 = false;
    L12:
        if (r102 == false) goto L14;
        OperationToastHelper r103 = OperationToastHelper.f442443a;
        LKUIToast.cancelLoading();
        c.a(new b(r110, r111));
        return;
    L14:
        OperationToastHelper.b(r110, R.string.Todo_Task_FailToShare, null, null, null, 60);
    }
}
