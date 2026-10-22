package ntc;

import com.alipay.sdk.m.u.i;
import io.opentelemetry.api.trace.StatusCode;

/* JADX INFO: loaded from: classes41.dex */
public final class b extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StatusCode f520572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f520573c;

    public final int hashCode() {
        return ((this.f520572b.hashCode() ^ 1000003) * 1000003) ^ this.f520573c.hashCode();
    }

    public final String toString() {
        return "ImmutableStatusData{statusCode=" + this.f520572b + ", description=" + this.f520573c + i.f25855d;
    }

    public b(StatusCode r100) {
        if (r100 == null) goto L7;
        this.f520572b = r100;
        this.f520573c = "";
        return;
    L7:
        throw new NullPointerException("Null statusCode");
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (this.f520572b.equals(((b) r101).f520572b) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.f520573c.equals(((b) r101).f520573c) == false) goto L12;
        return true;
    L14:
        return false;
    }
}
