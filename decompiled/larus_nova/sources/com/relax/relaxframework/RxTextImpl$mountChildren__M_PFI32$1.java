package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "value", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RxTextImpl$mountChildren__M_PFI32$1 extends Lambda implements Function1<Integer, String> {
    public static final RxTextImpl$mountChildren__M_PFI32$1 INSTANCE = null;

    static {
        INSTANCE = new RxTextImpl$mountChildren__M_PFI32$1();
    }

    public RxTextImpl$mountChildren__M_PFI32$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Integer r100) {
        return invoke(r100.intValue());
    }

    public final String invoke(int r100) {
        return String.valueOf(r100);
    }
}
