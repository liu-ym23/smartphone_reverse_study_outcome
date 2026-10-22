package com.ss.android.lark.vfs;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/OutputStream;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class VFSFileOutputStream$delegateStream$2 extends Lambda implements Function0<OutputStream> {
    final /* synthetic */ boolean $append;
    final /* synthetic */ VFSPath $path;
    final /* synthetic */ h $vfs;

    public VFSFileOutputStream$delegateStream$2(h r100, VFSPath r101, boolean r102) {
        this.$vfs = r100;
        this.$path = r101;
        this.$append = r102;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final OutputStream invoke() {
        return this.$vfs.s(this.$path, this.$append);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ OutputStream invoke() {
        return invoke();
    }
}
