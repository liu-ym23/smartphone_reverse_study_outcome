package com.bytedance.ee.lark.infra.file;

import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.io.OnErrorAction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/io/OnErrorAction;", "file", "Ljava/io/File;", "e", "Ljava/io/IOException;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AbsVFSFileManager$copy$1$act$1 extends Lambda implements Function2<File, IOException, OnErrorAction> {
    public static final AbsVFSFileManager$copy$1$act$1 INSTANCE = null;

    static {
        INSTANCE = new AbsVFSFileManager$copy$1$act$1();
    }

    public AbsVFSFileManager$copy$1$act$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final OnErrorAction invoke2(File r100, IOException r101) {
        AppBrandLogger.e("AbsVFSFileManager", new Object[]{"file exception", r100, r101});
        return OnErrorAction.TERMINATE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ OnErrorAction invoke(File r100, IOException r101) {
        return invoke2(r100, r101);
    }
}
