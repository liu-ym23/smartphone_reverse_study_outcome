package if7;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes22.dex */
public interface a {
    Method a(Class<?> r100, String r101, Class<?>... r102) throws NoSuchMethodException;

    Class<?> b(String r100) throws ClassNotFoundException;

    Field c(Class r100) throws NoSuchFieldException;
}
