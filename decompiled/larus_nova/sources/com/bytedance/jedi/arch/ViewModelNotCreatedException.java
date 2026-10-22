package com.bytedance.jedi.arch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/arch/ViewModelNotCreatedException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "msg", "", "(Ljava/lang/String;)V", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewModelNotCreatedException extends IllegalStateException {
    public ViewModelNotCreatedException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        super(r100);
    }
}
