package com.ss.android.ainote;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ainote.model.AINoteScene;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.vfs.VFSFile;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "file", "Lcom/ss/android/lark/vfs/VFSFile;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AINoteCacheStore$getCachedMeetingIds$2 extends Lambda implements Function1<VFSFile, String> {
    final /* synthetic */ String $userId;
    final /* synthetic */ AINoteCacheStore this$0;

    public AINoteCacheStore$getCachedMeetingIds$2(AINoteCacheStore r100, String r101) {
        this.this$0 = r100;
        this.$userId = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        AINoteCacheStore r101 = this.this$0;
        String r102 = r100.getName();
        String r103 = this.$userId;
        int r104 = AINoteCacheStore.f406468b;
        r101.getClass();
        String r105 = AINoteCacheStore.d(r103, AINoteScene.Meeting);
        Object r106 = null;
        if (StringsKt.startsWith$default(r102, r105, false, 2, null) == true) goto L5;
        return null;
    L5:
        if (StringsKt.endsWith$default(r102, InvRouter.FLOW_SUFFIX, false, 2, null) == false) goto L21;
        String r107 = r102.substring(r105.length(), r102.length() - 5);
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L10
        Object r109 = Result.m9449constructorimpl(URLDecoder.decode(r107, StandardCharsets.UTF_8.name()));     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r109) == true) goto L17;
        r106 = r109;
    L17:
        return (String) r106;
    L10:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L21:
        return null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(VFSFile r100) {
        return invoke2(r100);
    }
}
