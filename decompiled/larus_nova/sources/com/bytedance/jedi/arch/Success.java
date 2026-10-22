package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00028\u0000HÂ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u000e\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/bytedance/jedi/arch/Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/arch/Async;", "value", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "component1", "()Ljava/lang/Object;", "copy", "(Ljava/lang/Object;)Lcom/bytedance/jedi/arch/Success;", "equals", "", "other", "", "hashCode", "", AbsMethodDelegate.TAG_INVOKE, "toString", "", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Success<T> extends Async<T> {
    private final T value;

    private final T component1() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Success copy$default(Success r100, Object r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.value;
    L6:
        return r100.copy(r101);
    }

    public final Success<T> copy(T r100) {
        return new Success(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Success) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.value, ((Success) r100).value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        T r100 = this.value;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "Success(value=" + this.value + ')';
    }

    @Override // com.bytedance.jedi.arch.Async
    public T invoke() {
        return this.value;
    }

    public Success(T r100) {
        super(null);
        this.value = r100;
    }
}
