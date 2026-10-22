package kl6;

import os6.c;
import os6.d;

/* JADX INFO: loaded from: classes20.dex */
public abstract class a implements d {
    public a() {
    }

    @Override // os6.d
    public final String getSecUid() {
        return ((c) this).getUid();
    }

    @Override // os6.d
    public final String getUniqueId() {
        return String.valueOf(((c) this).a());
    }
}
