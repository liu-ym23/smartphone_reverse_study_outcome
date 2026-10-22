package mk1;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f514291d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f514292e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f514293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f514294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IRoomAuthStatusStyle f514295c;

    /* JADX INFO: renamed from: mk1.a$a, reason: collision with other inner class name */
    public static final class C6824a {
    }

    public a() {
        this(0, 7);
    }

    static {
        int r100 = 6;
        f514291d = new a(0, r100);
        f514292e = new a(1, r100);
    }

    public final boolean a() {
        if (this.f514293a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean b() {
        if (this.f514293a != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ a(int r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100, null, null);
    }

    public a(int r100, String r101, IRoomAuthStatusStyle r102) {
        this.f514293a = r100;
        this.f514294b = r101;
        this.f514295c = r102;
    }
}
