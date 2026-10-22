package com.suite.lark.emm.impl.clipboard.utils.snapshot;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ClipboardSnapshotUtilsKt$sha256$1 extends Lambda implements Function1<Byte, CharSequence> {
    public static final ClipboardSnapshotUtilsKt$sha256$1 INSTANCE = null;

    static {
        INSTANCE = new ClipboardSnapshotUtilsKt$sha256$1();
    }

    public ClipboardSnapshotUtilsKt$sha256$1() {
        super(1);
    }

    public final CharSequence invoke(byte r100) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r100)}, 1));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Byte r100) {
        return invoke(r100.byteValue());
    }
}
