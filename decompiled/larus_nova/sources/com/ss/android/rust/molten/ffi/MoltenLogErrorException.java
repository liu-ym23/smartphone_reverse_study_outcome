package com.ss.android.rust.molten.ffi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/rust/molten/ffi/MoltenLogErrorException;", "Ljava/lang/Exception;", "error", "Lcom/ss/android/rust/molten/ffi/MoltenLogError;", "<init>", "(Lcom/ss/android/rust/molten/ffi/MoltenLogError;)V", "getError", "()Lcom/ss/android/rust/molten/ffi/MoltenLogError;", "molten-log_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoltenLogErrorException extends Exception {
    private final MoltenLogError error;

    public final MoltenLogError getError() {
        return this.error;
    }

    public MoltenLogErrorException(MoltenLogError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        super(r100.toString());
        this.error = r100;
    }
}
