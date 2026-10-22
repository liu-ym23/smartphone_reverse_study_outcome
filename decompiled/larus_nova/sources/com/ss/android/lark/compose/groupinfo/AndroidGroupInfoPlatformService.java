package com.ss.android.lark.compose.groupinfo;

import android.content.Context;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lark.kmp.pb.basic.v1.LarkError;
import com.lark.kmp.rustclient.api.model.RustClientException;
import com.ss.android.lark.auditsdk.security.SecurityService;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.utils.ApiUtils;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.j;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
public final class AndroidGroupInfoPlatformService implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f417687a;

    public AndroidGroupInfoPlatformService(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "appContext");
        this.f417687a = r100;
    }

    @Override // com.ss.android.lark.compose.groupinfo.d
    public final boolean b(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        String r101 = null;
        if ((r100 instanceof RustClientException) == false) goto L5;
        RustClientException r102 = (RustClientException) r100;
    L6:
        int r103 = 0;
        if (r102 == null) goto L19;
        LarkError r104 = r102.getRustError();
        if (r104 == null) goto L19;
        Integer r105 = r104.getCode();
        if (r105 == null) goto L14;
        r103 = r105.intValue();
    L14:
        ByteString r106 = r104.getExtra();
        if (r106 == null) goto L18;
        r101 = new String(r106.toByteArray(), Charsets.UTF_8);
    L18:
        return SecurityService.f409594a.getValue().a(r103, r101);
    L19:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.lark.compose.groupinfo.d
    public final Object c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        String r102 = UriProtector.parse(r100).getPath();     // Catch: Throwable -> L16
        if (r102 == null) goto L15;
        if (r102.length() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L15;
        return Result.m9449constructorimpl(r102);
    L8:
        r103 = false;
    L15:
        throw new IllegalArgumentException("Avatar URI has no upload path");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.ss.android.lark.compose.groupinfo.d
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "avatarKey");
        ChatCoreModule.a().getAuditDependency().f(r100, r101);
    }

    @Override // com.ss.android.lark.compose.groupinfo.d
    public final Object d(String r100, Continuation<? super Result<String>> r101) {
        if ((r101 instanceof AndroidGroupInfoPlatformService$uploadAvatar$1) == false) goto L7;
        AndroidGroupInfoPlatformService$uploadAvatar$1 r102 = (AndroidGroupInfoPlatformService$uploadAvatar$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r107 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L29:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        final j r108 = new j(IntrinsicsKt.intercepted(r102), 1);
        r108.C();
        ((dkc.a) ApiUtils.getApi(dkc.a.class)).uploadGroupAvatar(this.f417687a, r100, new AndroidGroupInfoPlatformService$uploadAvatar$2$1(r108));     // Catch: Exception -> L17
    L23:
        r104 = r108.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L26:
        if (r104 != r105) goto L29;
        return r105;
    L17:
        e = move-exception;
        if ((e instanceof CancellationException) == false) goto L21;
        throw e;
    L21:
        if (r108.isActive() == false) goto L23;
        Result.Companion r109 = Result.Companion;
        r108.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(e)))));
    L7:
        r102 = new AndroidGroupInfoPlatformService$uploadAvatar$1(this, r101);
        goto L8
    }
}
