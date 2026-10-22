package com.google.firebase;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public class FirebaseException extends Exception {
    public FirebaseException() {
    }

    public FirebaseException(String r100) {
        Preconditions.checkNotEmpty(r100, "Detail message must not be empty");
        super(r100);
    }

    public FirebaseException(String r100, Throwable r101) {
        Preconditions.checkNotEmpty(r100, "Detail message must not be empty");
        super(r100, r101);
    }
}
