package org.threeten.bp.temporal;

import org.threeten.bp.Duration;

/* JADX INFO: loaded from: classes41.dex */
public interface i {
    <R extends a> R addTo(R r100, long r101);

    long between(a r100, a r101);

    Duration getDuration();

    boolean isDateBased();

    boolean isDurationEstimated();

    boolean isSupportedBy(a r100);

    boolean isTimeBased();
}
