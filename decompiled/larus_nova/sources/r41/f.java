package r41;

import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f536019a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f536020b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f536021c = false;

    static {
        y41.f r100 = y41.f.N;
        r100.getClass();
        ReadOnlyProperty r101 = y41.f.f565976q;
        KProperty<?>[] r102 = y41.f.f565960a;
        boolean r103 = ((Boolean) r101.getValue(r100, r102[15])).booleanValue();
        f536019a = r103;
        if (r103 == false) goto L5;
        int r104 = 9;
    L6:
        f536020b = r104;
        if (((Boolean) r101.getValue(r100, r102[15])).booleanValue() == true) goto L9;
    L11:
        boolean r105 = false;
    L12:
        f536021c = r105;
        return;
    L9:
        if (((Boolean) y41.f.f565977r.getValue(r100, r102[16])).booleanValue() == false) goto L11;
        r105 = true;
        goto L12
    L5:
        r104 = 4;
        goto L6
    }
}
