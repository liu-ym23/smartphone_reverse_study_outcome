package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public StatsEvent() {
    }

    public abstract int a();

    public abstract long b();

    public abstract String c();

    public final String toString() {
        return b() + "\t" + a() + "\t-1" + c();
    }
}
