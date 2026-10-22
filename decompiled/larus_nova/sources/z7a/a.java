package z7a;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f570696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f570697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f570698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f570699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f570700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f570701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f570702g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f570703h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f570704i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f570705j;

    public a() {
    }

    public static int a(HashMap r100, String r101, int r102) {
        if (r100 != null) goto L4;
        return r102;
    L4:
        Object r103 = r100.get(r101);
        if (r103 != null) goto L8;
        return r102;
    L8:
        if ((r103 instanceof String) == false) goto L13;
        return CastIntegerProtector.parseInt(((String) r103).trim());
    L21:
        return r102;
    L13:
        if ((r103 instanceof Number) == true) goto L15;
        return r102;
    L15:
        return ((Number) r103).intValue();
    }
}
