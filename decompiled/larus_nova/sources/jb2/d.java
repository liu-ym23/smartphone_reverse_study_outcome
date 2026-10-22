package jb2;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends fk6.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f497991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gk6.a f497992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ek6.c f497993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f497994g;

    @Override // fk6.b
    public final ek6.c b() {
        return this.f497993f;
    }

    @Override // fk6.b
    public final String c() {
        return this.f497991d;
    }

    @Override // fk6.b
    public final gk6.a d() {
        return this.f497992e;
    }

    public /* synthetic */ d(String r100, gk6.a r101, ib2.a r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r103 & 8) == 0) goto L11;
        boolean r104 = true;
    L12:
        this(r100, r101, r102, r104);
        return;
    L11:
        r104 = false;
        goto L12
    }

    public d(String r100, gk6.a r101, ek6.c r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        super(r100, r101, r102);
        this.f497991d = r100;
        this.f497992e = r101;
        this.f497993f = r102;
        this.f497994g = r103;
    }
}
