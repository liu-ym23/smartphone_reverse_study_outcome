package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/jedi/arch/Async;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Object;", "Lcom/bytedance/jedi/arch/Fail;", "Lcom/bytedance/jedi/arch/Loading;", "Lcom/bytedance/jedi/arch/Success;", "Lcom/bytedance/jedi/arch/Uninitialized;", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class Async<T> {
    private Async() {
    }

    public /* synthetic */ Async(DefaultConstructorMarker r100) {
        this();
    }

    public T invoke() {
        return null;
    }
}
