package org.apache.commons.lang3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/* JADX INFO: loaded from: classes42.dex */
public class AnnotationUtils {
    private static final ToStringStyle TO_STRING_STYLE = null;

    static {
        TO_STRING_STYLE = new AnonymousClass1();
    }

    public static String toString(Annotation r100) {
        ToStringBuilder r101 = new ToStringBuilder(r100, TO_STRING_STYLE);
        Method[] r102 = r100.annotationType().getDeclaredMethods();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L15;
        Method r105 = r102[r104];
        if (r105.getParameterTypes().length > 0) goto L8;
        r101.append(r105.getName(), r105.invoke(r100, new Object[0]));     // Catch: Exception -> L9 RuntimeException -> L12
    L12:
        e = move-exception;
        throw e;
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L8:
        r104 = r104 + 1;
        goto L3
    L15:
        return r101.build();
    }
}
