package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/jedi/arch/Fail;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/arch/Async;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Fail<T> extends Async<T> {
    private final Throwable error;

    public static /* synthetic */ Fail copy$default(Fail r100, Throwable r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.error;
    L6:
        return r100.copy(r101);
    }

    public final Throwable component1() {
        return this.error;
    }

    public final Fail<T> copy(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        return new Fail(r100);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Reflection.getOrCreateKotlinClass(this.error.getClass()), this.error.getMessage(), this.error.getStackTrace()[0]});
    }

    public String toString() {
        return "Fail(error=" + this.error + ')';
    }

    public final Throwable getError() {
        return this.error;
    }

    public Fail(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        super(null);
        this.error = r100;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Fail) == true) goto L5;
        return false;
    L5:
        Throwable r101 = ((Fail) r100).error;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(this.error.getClass()), Reflection.getOrCreateKotlinClass(r101.getClass())) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.error.getMessage(), r101.getMessage()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.error.getStackTrace()[0], r101.getStackTrace()[0]) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
