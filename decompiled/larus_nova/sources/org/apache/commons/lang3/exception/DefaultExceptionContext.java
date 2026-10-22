package org.apache.commons.lang3.exception;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/* JADX INFO: loaded from: classes42.dex */
public class DefaultExceptionContext implements ExceptionContext, Serializable {
    private static final long serialVersionUID = 20110706;
    private final List<Pair<String, Object>> contextValues;

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Set<String> getContextLabels() {
        HashSet r100 = new HashSet();
        Iterator<Pair<String, Object>> r101 = this.contextValues.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add(r101.next().getKey());
        goto L4
    L6:
        return r100;
    }

    public DefaultExceptionContext() {
        this.contextValues = new ArrayList();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Pair<String, Object>> getContextEntries() {
        return this.contextValues;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Object> getContextValues(String r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Pair<String, Object>> r102 = this.contextValues.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Pair<String, Object> r103 = r102.next();
        if (StringUtils.equals(r100, r103.getKey()) == false) goto L4;
        r101.add(r103.getValue());
        goto L4
    L8:
        return r101;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Object getFirstContextValue(String r100) {
        Iterator<Pair<String, Object>> r101 = this.contextValues.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Pair<String, Object> r102 = r101.next();
        if (StringUtils.equals(r100, r102.getKey()) == false) goto L4;
        return r102.getValue();
    L9:
        return null;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public String getFormattedExceptionMessage(String r100) {
        StringBuilder r101 = new StringBuilder(256);
        if (r100 == null) goto L6;
        r101.append(r100);
    L6:
        if (this.contextValues.isEmpty() == true) goto L24;
        if (r101.length() <= 0) goto L10;
        r101.append('\n');
    L10:
        r101.append("Exception Context:\n");
        Iterator<Pair<String, Object>> r102 = this.contextValues.iterator();
        int r103 = 0;
    L12:
        if (r102.hasNext() == false) goto L22;
        Pair<String, Object> r104 = r102.next();
        r101.append("\t[");
        r103 = r103 + 1;
        r101.append(r103);
        r101.append(':');
        r101.append(r104.getKey());
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        Object r105 = r104.getValue();
        if (r105 != null) goto L25;
        r101.append("null");
    L21:
        r101.append("]\n");
        goto L12
    L25:
        String r106 = r105.toString();     // Catch: Exception -> L18
    L20:
        r101.append(r106);
    L18:
        e = move-exception;
        r106 = "Exception thrown on toString(): " + ExceptionUtils.getStackTrace(e);
        goto L20
    L22:
        r101.append("---------------------------------");
    L24:
        return r101.toString();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public DefaultExceptionContext addContextValue(String r100, Object r101) {
        this.contextValues.add(new ImmutablePair(r100, r101));
        return this;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public DefaultExceptionContext setContextValue(String r100, Object r101) {
        Iterator<Pair<String, Object>> r102 = this.contextValues.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (StringUtils.equals(r100, r102.next().getKey()) == false) goto L4;
        r102.remove();
        goto L4
    L8:
        addContextValue(r100, r101);
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
}
