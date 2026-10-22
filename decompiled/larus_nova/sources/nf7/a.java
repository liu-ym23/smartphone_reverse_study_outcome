package nf7;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f518959a = 0;

    static {
    }

    public static boolean a() {
        lf7.b r100 = lf7.d.f509087a;
        if (r100 == null) goto L10;
        Function0<Boolean> r101 = r100.f509074h;
        if (r101 == null) goto L10;
        Boolean r102 = r101.invoke();
        if (r102 == null) goto L10;
        boolean r103 = r102.booleanValue();
    L12:
        lf7.b r104 = lf7.d.f509087a;
        if (r104 != null) goto L15;
        boolean r105 = false;
    L16:
        if (r105 == false) goto L19;
        return false;
    L19:
        return r103;
    L15:
        r105 = r104.f509073g;
    L10:
        r103 = false;
        goto L12
    }
}
