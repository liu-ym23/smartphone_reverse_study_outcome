package ot7;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f526681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, String>> f526682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f526683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f526684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f526685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f526686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f526687h;

    public a() {
        this("", -1, new ArrayList(), null, "", "", 0, "");
    }

    public final String toString() {
        return "NativeResponse(url='" + this.f526680a + "', httpStatusCode=" + this.f526681b + ", headers=" + this.f526682c + ", logId='" + this.f526684e + "', requestLog='" + this.f526685f + "', errorCode=" + this.f526686g + ", errorMessage='" + this.f526687h + "')";
    }

    public a(String r100, int r101, List<Pair<String, String>> r102, byte[] r103, String r104, String r105, int r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "headers");
        Intrinsics.checkNotNullParameter(r104, "logId");
        Intrinsics.checkNotNullParameter(r105, "requestLog");
        Intrinsics.checkNotNullParameter(r107, "errorMessage");
        this.f526680a = r100;
        this.f526681b = r101;
        this.f526682c = r102;
        this.f526683d = r103;
        this.f526684e = r104;
        this.f526685f = r105;
        this.f526686g = r106;
        this.f526687h = r107;
    }
}
