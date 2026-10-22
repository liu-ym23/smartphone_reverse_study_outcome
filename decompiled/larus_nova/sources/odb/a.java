package odb;

import com.ss.android.lark.featuregatingv2impl.entity.ErrorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f522906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f522907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f522908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ErrorType f522909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f522910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f522911f;

    public a() {
        this.f522906a = "";
        this.f522909d = ErrorType.NORMAL;
        this.f522910e = "";
    }

    public final void a(ErrorType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f522909d = r100;
    }
}
