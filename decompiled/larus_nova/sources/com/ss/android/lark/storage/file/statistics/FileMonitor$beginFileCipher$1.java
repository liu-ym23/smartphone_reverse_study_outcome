package com.ss.android.lark.storage.file.statistics;

import android.os.SystemClock;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/storage/file/statistics/FileMonitor$FileEventSession;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FileMonitor$beginFileCipher$1 extends Lambda implements Function1<FileMonitor.a, Unit> {
    public static final FileMonitor$beginFileCipher$1 INSTANCE = null;

    static {
        INSTANCE = new FileMonitor$beginFileCipher$1();
    }

    public FileMonitor$beginFileCipher$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FileMonitor.a r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.f441014h = SystemClock.elapsedRealtime();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FileMonitor.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
