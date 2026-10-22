package kd4;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f502720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f502721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f502722c;

    public /* synthetic */ a(String r100, JSONObject r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = new JSONObject();
    L6:
        if ((r102 & 4) == 0) goto L8;
        long r103 = System.currentTimeMillis();
    L9:
        this(r100, r101, r103);
        return;
    L8:
        r103 = 0;
        goto L9
    }

    public a(String r100, JSONObject r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f502720a = r100;
        this.f502721b = r101;
        this.f502722c = r102;
    }
}
