package org.threeten.bp.temporal;

/* JADX INFO: loaded from: classes41.dex */
public interface a extends b {
    a minus(long r100, i r101);

    a plus(long r100, i r101);

    @Override // org.threeten.bp.temporal.b
    /* synthetic */ <R> R query(h<R> r100);

    long until(a r100, i r101);

    a with(c r100);

    a with(f r100, long r101);
}
