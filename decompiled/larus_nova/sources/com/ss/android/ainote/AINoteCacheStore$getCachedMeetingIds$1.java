package com.ss.android.ainote;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/vfs/VFSFile;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/vfs/VFSFile;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AINoteCacheStore$getCachedMeetingIds$1 extends Lambda implements Function1<VFSFile, Boolean> {
    public static final AINoteCacheStore$getCachedMeetingIds$1 INSTANCE = null;

    static {
        INSTANCE = new AINoteCacheStore$getCachedMeetingIds$1();
    }

    public AINoteCacheStore$getCachedMeetingIds$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Boolean.valueOf(r100.isFile());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(VFSFile r100) {
        return invoke2(r100);
    }
}
