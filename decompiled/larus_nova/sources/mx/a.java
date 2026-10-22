package mx;

import com.bytedance.android.live.ui.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class a extends s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f516129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f516130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f516131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f516132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f516133i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f516134j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f516135k;

    /* JADX INFO: renamed from: mx.a$a, reason: collision with other inner class name */
    public static final class C6867a {
    }

    static {
    }

    public a(String r100, String r101, boolean r102, boolean r103, boolean r104, String r105, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = false;
    L12:
        if ((r110 & 16) == 0) goto L15;
        r104 = true;
    L15:
        if ((r110 & 32) == 0) goto L18;
        r105 = "";
    L18:
        if ((r110 & 128) == 0) goto L20;
        Long r111 = 0L;
    L21:
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "description");
        Intrinsics.checkNotNullParameter(r105, "disableToast");
        this.f516129e = r100;
        this.f516130f = r101;
        this.f516131g = r102;
        this.f516132h = r103;
        this.f516133i = r104;
        this.f516134j = r105;
        this.f516135k = r111;
        return;
    L20:
        r111 = null;
        goto L21
    }
}
