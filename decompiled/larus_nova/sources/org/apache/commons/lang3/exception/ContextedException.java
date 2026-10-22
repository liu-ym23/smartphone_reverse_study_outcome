package org.apache.commons.lang3.exception;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

/* JADX INFO: loaded from: classes42.dex */
public class ContextedException extends Exception implements ExceptionContext {
    private static final long serialVersionUID = 20110706;
    private final ExceptionContext exceptionContext;

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Pair<String, Object>> getContextEntries() {
        return this.exceptionContext.getContextEntries();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Set<String> getContextLabels() {
        return this.exceptionContext.getContextLabels();
    }

    public ContextedException() {
        this.exceptionContext = new DefaultExceptionContext();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return getFormattedExceptionMessage(super.getMessage());
    }

    public String getRawMessage() {
        return super.getMessage();
    }

    public ContextedException(String r100) {
        super(r100);
        this.exceptionContext = new DefaultExceptionContext();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Object> getContextValues(String r100) {
        return this.exceptionContext.getContextValues(r100);
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Object getFirstContextValue(String r100) {
        return this.exceptionContext.getFirstContextValue(r100);
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public String getFormattedExceptionMessage(String r100) {
        return this.exceptionContext.getFormattedExceptionMessage(r100);
    }

    public ContextedException(Throwable r100) {
        super(r100);
        this.exceptionContext = new DefaultExceptionContext();
    }

    public ContextedException(String r100, Throwable r101) {
        super(r100, r101);
        this.exceptionContext = new DefaultExceptionContext();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public ContextedException addContextValue(String r100, Object r101) {
        this.exceptionContext.addContextValue(r100, r101);
        return this;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public ContextedException setContextValue(String r100, Object r101) {
        this.exceptionContext.setContextValue(r100, r101);
        return this;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public /* bridge */ /* synthetic */ ExceptionContext addContextValue(String r100, Object r101) {
        return addContextValue(r100, r101);
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public /* bridge */ /* synthetic */ ExceptionContext setContextValue(String r100, Object r101) {
        return setContextValue(r100, r101);
    }

    public ContextedException(String r100, Throwable r101, ExceptionContext r102) {
        super(r100, r101);
        if (r102 != null) goto L5;
        r102 = new DefaultExceptionContext();
    L5:
        this.exceptionContext = r102;
    }
}
