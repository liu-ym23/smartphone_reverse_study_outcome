package b08;

import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements c {
    public static final Map<Class<? extends c>, Map<C0004a<?, ? extends View>, b<? extends View, ?>>> d = null;
    public final Map<C0004a<?, ?>, b<? extends View, ?>> a;
    public final Map<C0004a<?, ?>, b<? extends View, ?>> b;
    public final Map<b, View> c;

    /* JADX INFO: renamed from: b08.a$a, reason: collision with other inner class name */
    public static class C0004a<M, V extends View> {
        public final Class<M> a;
        public final Class<V> b;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.a, this.b});
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L17:
            return false;
        L8:
            if (C0004a.class != r5.getClass()) goto L17;
            C0004a r6 = (C0004a) r5;
            if (Objects.equals(this.a, r6.a) == true) goto L13;
        L15:
            return false;
        L13:
            if (Objects.equals(this.b, r6.b) == false) goto L15;
            return true;
        }

        public C0004a(Class<M> r1, Class<V> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        d = new HashMap();
    }

    public a() {
        this.a = new LinkedHashMap();
        this.b = new HashMap();
        this.c = new HashMap();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static b c(Map r6, Class r7, Class r8) {
        b r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.isEmpty() == true) goto L36;
        Iterator r9 = r6.entrySet().iterator();
    L9:
        if (r9.hasNext() == false) goto L37;
        Map.Entry r1 = (Map.Entry) r9.next();
        C0004a r2 = (C0004a) r1.getKey();
        boolean r4 = false;
        if (r2.a == r7) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L35;
        if (r2.a.isAssignableFrom((Class<?>) r7) == true) goto L21;
    L23:
        if (r4 == false) goto L9;
        if (r0 != null) goto L9;
        r0 = (b) r1.getValue();
        goto L9
    L21:
        if (r2.b.isAssignableFrom((Class<?>) r8) == false) goto L23;
        r4 = true;
        goto L23
    L35:
        return (b) r1.getValue();
    L13:
        if (r2.b.isAssignableFrom((Class<?>) r8) == false) goto L15;
        r3 = true;
        goto L16
    L37:
        return r0;
    L36:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Class<? extends c> r3, View r4, Object r5) {
        Class<?> r0 = r5.getClass();
        b r6 = b(r3, r4.getClass(), r0);
        if (r6 == null) goto L6;
        r6.bind(r4, r5);
        ((HashMap) this.c).put(r6, r4);
        return;
    }

    public final b b(Class<? extends c> r3, Class<? extends View> r4, Class<?> r5) {
        C0004a r0 = new C0004a(r5, r4);
        b r1 = (b) ((HashMap) this.b).get(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        b r2 = c(this.a, r5, r4);
        if (r2 != null) goto L8;
        r2 = c((Map) ((HashMap) d).get(r3), r5, r4);
    L8:
        if (r2 == null) goto L10;
        ((HashMap) this.b).put(r0, r2);
    L10:
        return r2;
    }

    @Override // b08.c
    public final <M, V extends View> void registerModelBinder(Class<M> r3, Class<V> r4, b<? super V, ? super M> r5) {
        this.a.put(new C0004a(r3, r4), r5);
    }
}
