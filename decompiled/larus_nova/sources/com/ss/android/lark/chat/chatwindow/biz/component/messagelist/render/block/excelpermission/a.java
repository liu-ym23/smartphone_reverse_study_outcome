package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.excelpermission;

import androidx.core.app.NotificationCompat;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock$generatePermChangeDialog$1$onItemClick$1;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetFilePermission f412133a;

    public a(ExcelMessagePermissionBlock$generatePermChangeDialog$1$onItemClick$1 r100) {
        this.f412133a = r100;
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call r100, IOException r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "e");
        Log.e("ExcelPermissionNetService", "changeFilePermission failed, error: " + r101);
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call r100, Response r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "response");
        IGetFilePermission r102 = this.f412133a;
        int r103 = r101.code();     // Catch: Throwable -> L9
        Log.i("ExcelPermissionNetService", "changeFilePermission success, http status code: " + r103);     // Catch: Throwable -> L9
        if (r103 != 200) goto L6;
        r102.onSuccess();     // Catch: Throwable -> L9
    L6:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r101, null);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    }
}
