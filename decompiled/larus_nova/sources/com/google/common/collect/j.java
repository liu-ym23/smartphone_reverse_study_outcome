package com.google.common.collect;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
public final class j extends Tables.b<Object, Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f275476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f275477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayTable f275478c;

    @Override // com.google.common.collect.t2.a
    public final Object getColumnKey() {
        return ArrayTable.access$100(this.f275478c).get(this.f275477b);
    }

    @Override // com.google.common.collect.t2.a
    public final Object getRowKey() {
        return ArrayTable.access$200(this.f275478c).get(this.f275476a);
    }

    @Override // com.google.common.collect.t2.a
    @CheckForNull
    public final Object getValue() {
        return this.f275478c.at(this.f275476a, this.f275477b);
    }

    public j(ArrayTable r100, int r101) {
        this.f275478c = r100;
        this.f275476a = r101 / ArrayTable.access$100(r100).size();
        this.f275477b = r101 % ArrayTable.access$100(r100).size();
    }
}
