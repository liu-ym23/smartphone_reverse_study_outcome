package com.bytedance.iesgurd;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/io/File;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "(Ljava/io/File;)Ljava/lang/Long;"}, k = 3, mv = {1, 1, 16})
final class IESGurdKit$getChannelAllVersionsOnlyOffline$2 extends Lambda implements Function1<File, Long> {
    public static final IESGurdKit$getChannelAllVersionsOnlyOffline$2 INSTANCE = null;

    static {
        INSTANCE = new IESGurdKit$getChannelAllVersionsOnlyOffline$2();
    }

    public IESGurdKit$getChannelAllVersionsOnlyOffline$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Long invoke2(File r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Long.valueOf(CastLongProtector.parseLong(r100.getName(), CharsKt.checkRadix(10))));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        return (Long) r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(File r100) {
        return invoke2(r100);
    }
}
