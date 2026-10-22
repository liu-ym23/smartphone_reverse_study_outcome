package com.ss.android.lark.storage.file.statistics;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p", "", SoloKtvContext.SOLO_PAGE_FIRST, "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FileMonitor$onOpenFile$1$1 extends Lambda implements Function2<String, Boolean, Unit> {
    final /* synthetic */ String $path;

    public FileMonitor$onOpenFile$1$1(String r100) {
        this.$path = r100;
        super(2);
    }

    public final void invoke(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "p");
        if (r101 == false) goto L6;
        new c(r100, String.valueOf(this.$path.hashCode())).a();
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }
}
