package com.bytedance.timon_monitor_impl;

import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import java.util.Map;
import jz5.h;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IStoreRepo f270749a;

    @Override // jz5.h
    public final void clear() {
        this.f270749a.clear();
    }

    @Override // jz5.h
    public final Map<String, ?> getAll() {
        return this.f270749a.getAll();
    }

    public c(IStoreRepo r100) {
        this.f270749a = r100;
    }

    @Override // jz5.h
    public final long getLong(String r100) {
        return this.f270749a.getLong(r100, 0);
    }

    @Override // jz5.h
    public final void remove(String r100) {
        this.f270749a.remove(r100);
    }

    @Override // jz5.h
    public final String getString(String r100, String r101) {
        return this.f270749a.getString(r100, r101);
    }

    @Override // jz5.h
    public final void putLong(String r100, long r101) {
        this.f270749a.putLong(r100, r101);
    }

    @Override // jz5.h
    public final void putString(String r100, String r101) {
        this.f270749a.putString(r100, r101);
    }
}
