package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes23.dex */
public class AccountAccessor extends IAccountAccessor.Stub {
    public final boolean equals(Object r100) {
        throw null;
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zzb() {
        throw null;
    }

    public static Account getAccountBinderSafe(IAccountAccessor r100) {
        Account r101 = null;
        if (r100 == null) goto L10;
        long r102 = Binder.clearCallingIdentity();
        r101 = r100.zzb();     // Catch: RemoteException -> L11 Throwable -> L7
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(r102);
        throw th;
    L6:
        Binder.restoreCallingIdentity(r102);
    L10:
        return r101;
    }
}
