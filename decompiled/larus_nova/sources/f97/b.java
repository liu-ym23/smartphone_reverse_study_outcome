package f97;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends f97.a<Field[]> {

    public class a extends f97.a<Field[]>.AbstractC5872a {
        @Override // f97.a.AbstractC5872a
        public final Method a() throws NoSuchMethodException {
            return Class.class.getDeclaredMethod("getDeclaredFields", new Class[]{Boolean.TYPE, List.class});
        }

        public a() {
        }

        @Override // f97.a.AbstractC5872a
        public final Field[] b(Object r100, Object[] r101) throws InvocationTargetException, IllegalAccessException, ClassCastException {
            ArrayList r102 = new ArrayList();
            super.b(r100, new Object[]{Boolean.FALSE, r102});
            return (Field[]) r102.toArray(new Field[r102.size()]);
        }
    }

    /* JADX INFO: renamed from: f97.b$b, reason: collision with other inner class name */
    public class C5873b extends f97.a<Field[]>.AbstractC5872a {
        @Override // f97.a.AbstractC5872a
        public final Method a() throws NoSuchMethodException {
            return Class.class.getDeclaredMethod("getDeclaredFieldsUnchecked", new Class[]{Boolean.TYPE});
        }

        public C5873b() {
        }

        @Override // f97.a.AbstractC5872a
        public final Field[] b(Object r100, Object[] r101) throws InvocationTargetException, IllegalAccessException, ClassCastException {
            return (Field[]) super.b(r100, new Object[]{Boolean.FALSE});
        }
    }

    @Override // f97.a
    public final List<? extends f97.a<Field[]>.AbstractC5872a> a() {
        return Arrays.asList(new f97.a.AbstractC5872a[]{new C5873b(), new a()});
    }

    public b() {
    }
}
