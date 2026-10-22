package rs5;

import com.ss.android.lark.log.Log;
import java.util.HashMap;
import js5.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements ts5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Class<?>, Class<? extends f>> f539107a;

    /* JADX INFO: renamed from: rs5.a$a, reason: collision with other inner class name */
    public static final class C7529a {
    }

    static {
    }

    public a() {
        this.f539107a = new HashMap();
        new HashMap();
    }

    @Override // ts5.a
    public final void b(Class<? extends f> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceImplClass");
        Class<?>[] r101 = r100.getInterfaces();
        int r102 = 0;
        boolean r103 = true;
        if (r101 != null) goto L5;
    L11:
        if (r103 == false) goto L14;
        Log.i("NativeComponentBizService", r100.getName().concat(" does not implement INativeComponentService"));
        return;
    L14:
        int r104 = r101.length;
    L15:
        if (r102 >= r104) goto L21;
        Class<?> r105 = r101[r102];
        if (f.class.isAssignableFrom(r105) == true) goto L18;
        r102 = r102 + 1;
        goto L15
    L18:
        this.f539107a.put(r105, r100);
        return;
    L21:
        return;
    L5:
        if (r101.length != 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L11;
        r103 = false;
        goto L11
    L7:
        r106 = false;
        goto L8
    }
}
