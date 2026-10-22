package com.bytedance.bdp.bdpbase.ipc;

import android.util.Pair;
import com.bytedance.bdp.bdpbase.ipc.annotation.Callback;
import com.bytedance.bdp.bdpbase.ipc.annotation.Event;
import com.bytedance.bdp.bdpbase.ipc.annotation.NotDispatched;
import com.bytedance.bdp.bdpbase.ipc.annotation.OneWay;
import com.bytedance.bdp.bdpbase.ipc.annotation.SyncIpc;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes11.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f201243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f201244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f201245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f201246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f201247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f201248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f201249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f201250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f201251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f201252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f201253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f201254l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Class<?> f201255m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f201256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Annotation[][] f201257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Type[] f201258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f201259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f201260e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f201261f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f201262g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f201263h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f201264i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f201265j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f201266k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public byte[] f201267l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f201268m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f201269n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Class<?> f201270o;

        public final w a() {
            Pair<String, String> r100 = t.r(this.f201256a.getDeclaringClass(), true);
            this.f201259d = (String) r100.first;
            Object r101 = r100.second;
            this.f201260e = (String) r101;
            this.f201261f = !t.k((String) r101);
            this.f201262g = t.s(this.f201256a);
            this.f201263h = this.f201256a.isAnnotationPresent(OneWay.class);
            boolean r102 = this.f201256a.isAnnotationPresent(SyncIpc.class);
            this.f201265j = r102;
            if (r102 == false) goto L5;
        L10:
            boolean r103 = true;
        L11:
            this.f201264i = r103;
            if (this.f201256a.isAnnotationPresent(Event.class) == false) goto L16;
            Event r104 = (Event) this.f201256a.getAnnotation(Event.class);
            if (r104 == null) goto L16;
            this.f201266k = r104.type();
        L16:
            int r105 = this.f201257b.length;
            this.f201267l = new byte[r105];
            int r106 = 0;
        L18:
            if (r106 >= r105) goto L45;
            Type r107 = this.f201258c[r106];
            if (t.i(r107) == true) goto L44;
            Annotation[] r108 = this.f201257b[r106];
            byte[] r109 = this.f201267l;
            Class<?> r110 = t.g(r107);
            if (r108 != null) goto L24;
        L41:
            byte r111 = t.h(r110);
        L42:
            r109[r106] = r111;
            r106 = r106 + 1;
            goto L18
        L24:
            if (r108.length == 0) goto L41;
            int r112 = r108.length;
            int r113 = 0;
        L27:
            if (r113 >= r112) goto L40;
            if ((r108[r113] instanceof Callback) == true) goto L31;
            r113 = r113 + 1;
            goto L27
        L31:
            if (this.f201268m != (-1)) goto L33;
            this.f201268m = r106;
        L35:
            this.f201269n = r110.getSimpleName();
            r111 = 27;
            goto L42
        L33:
            g94.b.b("IPC_ServiceMethod", new Object[]{"Only one @Callback parameter is allowed! Please put the @Callback parameter in the last position"});
            if (t.j() == false) goto L35;
            throw new IllegalArgumentException("Only one @Callback parameter is allowed! Please put the @Callback parameter in the last position");
        L40:
            throw b(r106, "No support annotation found.", new Object[0]);
        L44:
            throw b(r106, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r107});
        L45:
            int r114 = this.f201268m;
            if (r114 == (-1)) goto L55;
            if (r114 == (r105 - 1)) goto L55;
            String r115 = "Please put the @Callback parameter in the last position, current position is " + (this.f201268m + 1);
            g94.b.b("IPC_ServiceMethod", new Object[]{r115});
            if (t.j() == false) goto L55;
            throw new IllegalArgumentException(r115);
        L55:
            return new w(this);
        L5:
            if (this.f201263h == true) goto L10;
            if (this.f201256a.isAnnotationPresent(NotDispatched.class) == true) goto L10;
            r103 = false;
            goto L11
        }

        public a(Method r100) {
            this.f201259d = "";
            this.f201260e = "";
            this.f201261f = false;
            this.f201262g = "";
            this.f201263h = false;
            this.f201264i = false;
            this.f201265j = false;
            this.f201266k = -1;
            this.f201256a = r100;
            this.f201270o = r100.getReturnType();
            this.f201257b = r100.getParameterAnnotations();
            this.f201258c = r100.getGenericParameterTypes();
            this.f201268m = -1;
        }

        public final RuntimeException b(int r100, String r101, Object... r102) {
            return new IllegalArgumentException(String.format(r101 + " (parameter #" + (r100 + 1) + ")", r102) + "\n    for method " + this.f201256a.getDeclaringClass().getSimpleName() + "." + this.f201256a.getName(), null);
        }
    }

    public w(a r100) {
        this.f201243a = r100.f201259d;
        this.f201244b = r100.f201260e;
        this.f201249g = r100.f201261f;
        this.f201245c = r100.f201262g;
        this.f201246d = r100.f201263h;
        this.f201247e = r100.f201264i;
        this.f201248f = r100.f201266k;
        this.f201250h = r100.f201267l;
        int r101 = r100.f201268m;
        this.f201251i = r101;
        this.f201253k = r100.f201269n;
        this.f201255m = r100.f201270o;
        if (r101 == (-1)) goto L5;
        boolean r102 = true;
    L6:
        this.f201252j = r102;
        this.f201254l = r100.f201265j;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static Request a(w r110, Object[] r111, long r112) {
        byte[] r100 = r110.f201250h;
        if (r111 == null) goto L5;
        int r101 = r111.length;
    L7:
        if (r101 != r100.length) goto L19;
        boolean r113 = r110.f201252j;
        if (r113 == false) goto L15;
        int r102 = r110.f201251i;
        String r103 = r110.f201253k;
        ParameterList r104 = new ParameterList(r101, r100, r111);
        Object r105 = r111[r102];
        if (r105 != null) goto L13;
        boolean r106 = true;
    L14:
        r111[r102] = new ba4.a(r103, r105, r106);
    L16:
        Request r107 = new Request(r110.f201243a, r110.f201244b, r110.f201245c, r104, r110.f201246d, r110.f201247e, r110.f201249g, r113, r112);
        g94.b.d("IPC_ServiceMethod", new Object[]{"create request: " + r107});
        return r107;
    L13:
        r106 = false;
        goto L14
    L15:
        r104 = new ParameterList(r101, r100, r111);
        goto L16
    L19:
        throw new IllegalArgumentException("Argument count (" + r101 + ") doesn't match expected count (" + r100.length + ")");
    L5:
        r101 = 0;
        goto L7
    }
}
