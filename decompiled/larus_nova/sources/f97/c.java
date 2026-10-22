package f97;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends f97.a<Method[]> {

    public class a extends f97.a<Method[]>.AbstractC5872a {
        @Override // f97.a.AbstractC5872a
        public final Method a() throws NoSuchMethodException {
            return Class.class.getDeclaredMethod("getDeclaredMethods", new Class[]{Boolean.TYPE, List.class});
        }

        public a() {
        }

        @Override // f97.a.AbstractC5872a
        public final Method[] b(Object r100, Object[] r101) throws InvocationTargetException, IllegalAccessException, ClassCastException {
            ArrayList r102 = new ArrayList();
            super.b(r100, new Object[]{Boolean.FALSE, r102});
            return (Method[]) r102.toArray(new Method[r102.size()]);
        }
    }

    public class b extends f97.a<Method[]>.AbstractC5872a {
        @Override // f97.a.AbstractC5872a
        public final Method a() throws NoSuchMethodException {
            return Class.class.getDeclaredMethod("getDeclaredMethodsUnchecked", new Class[]{Boolean.TYPE});
        }

        public b() {
        }

        @Override // f97.a.AbstractC5872a
        public final Method[] b(Object r100, Object[] r101) throws InvocationTargetException, IllegalAccessException, ClassCastException {
            return (Method[]) super.b(r100, new Object[]{Boolean.FALSE});
        }
    }

    @Override // f97.a
    public final List<? extends f97.a<Method[]>.AbstractC5872a> a() {
        return Arrays.asList(new f97.a.AbstractC5872a[]{new b(), new a()});
    }

    public c() {
    }
}
