package ds2;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f469852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f469853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f469854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f469855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f469856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f469857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f469858g;

    public e() {
        this.f469852a = "";
        this.f469853b = "";
        this.f469854c = "";
        this.f469855d = "";
        this.f469857f = "";
        this.f469858g = Bundle.EMPTY;
    }

    @Override // ds2.b
    public final Bundle B() {
        return this.f469858g;
    }

    @Override // ds2.b
    public final int c() {
        return this.f469856e;
    }

    @Override // ds2.b
    public final String getActionType() {
        return this.f469855d;
    }

    @Override // ds2.b
    public final String getEnterFrom() {
        return this.f469853b;
    }

    @Override // ds2.b
    public final String getImageUrl() {
        return this.f469857f;
    }

    @Override // ds2.b
    public final String getMessage() {
        return this.f469852a;
    }

    @Override // ds2.b
    public final String getSource() {
        return this.f469854c;
    }

    @Override // ds2.b
    public final void a(int r100) {
        this.f469856e = r100;
    }

    @Override // ds2.b
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f469857f = r100;
    }

    @Override // ds2.b
    public final void setActionType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f469855d = r100;
    }

    @Override // ds2.b
    public final void setBundle(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f469858g = r100;
    }

    @Override // ds2.b
    public final void setEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f469853b = r100;
    }

    @Override // ds2.b
    public final void setMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f469852a = r100;
    }

    @Override // ds2.b
    public final void setSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f469854c = r100;
    }
}
