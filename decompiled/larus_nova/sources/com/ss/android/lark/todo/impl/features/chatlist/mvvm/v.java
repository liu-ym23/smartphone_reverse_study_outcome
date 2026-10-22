package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import androidx.lifecycle.Observer;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes38.dex */
public final class v<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoChatListFragment f442407a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f442408a = null;

        static {
            int[] r100 = new int[OperationToastHelper.ToastType.values().length];
            r100[OperationToastHelper.ToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[OperationToastHelper.ToastType.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[OperationToastHelper.ToastType.PROMPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f442408a = r100;
        }
    }

    public v(TodoChatListFragment r100) {
        this.f442407a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        n7c.a r101 = (n7c.a) r100;
        OperationToastHelper.ToastType r102 = r101.getType();
        int r103 = a.f442408a[r102.ordinal()];
        if (r103 != 1) goto L5;
        OperationToastHelper r104 = OperationToastHelper.f442443a;
        OperationToastHelper.f(this.f442407a.getContext(), r101.f518234a, null, null, null, 124);
        return;
    L5:
        if (r103 != 2) goto L7;
        OperationToastHelper r105 = OperationToastHelper.f442443a;
        OperationToastHelper.b(this.f442407a.getContext(), r101.f518234a, null, null, null, 60);
        return;
    L7:
        if (r103 != 3) goto L10;
        OperationToastHelper r106 = OperationToastHelper.f442443a;
        OperationToastHelper.c(this.f442407a.getContext(), r101.f518234a, r101.f518236c, 56);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
