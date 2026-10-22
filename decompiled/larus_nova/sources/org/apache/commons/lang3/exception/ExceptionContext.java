package org.apache.commons.lang3.exception;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

/* JADX INFO: loaded from: classes42.dex */
public interface ExceptionContext {
    ExceptionContext addContextValue(String r100, Object r101);

    List<Pair<String, Object>> getContextEntries();

    Set<String> getContextLabels();

    List<Object> getContextValues(String r100);

    Object getFirstContextValue(String r100);

    String getFormattedExceptionMessage(String r100);

    ExceptionContext setContextValue(String r100, Object r101);
}
