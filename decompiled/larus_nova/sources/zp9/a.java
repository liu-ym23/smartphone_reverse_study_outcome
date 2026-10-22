package zp9;

import com.larus.platform.api.creation.UserCreation;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f573205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UserCreation f573206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f573207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f573208d;

    public a(boolean r100, UserCreation r101, String r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this.f573205a = r100;
        this.f573206b = r101;
        this.f573207c = r102;
        this.f573208d = r103;
    }
}
