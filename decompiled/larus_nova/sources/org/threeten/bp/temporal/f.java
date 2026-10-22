package org.threeten.bp.temporal;

import java.util.Map;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes41.dex */
public interface f {
    <R extends a> R adjustInto(R r100, long r101);

    long getFrom(b r100);

    boolean isDateBased();

    boolean isSupportedBy(b r100);

    boolean isTimeBased();

    ValueRange range();

    ValueRange rangeRefinedBy(b r100);

    b resolve(Map<f, Long> r100, b r101, ResolverStyle r102);
}
