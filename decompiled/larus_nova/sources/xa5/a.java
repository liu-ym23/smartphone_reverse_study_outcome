package xa5;

import java.util.Locale;
import sa5.h;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements qu5.a.InterfaceC7393a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f563066a;

    public a() {
    }

    @Override // qu5.a.InterfaceC7393a
    public final Locale getLocale() {
        if (this.f563066a != null) goto L6;
        this.f563066a = new h();
    L6:
        return this.f563066a.getLocale();
    }

    @Override // qu5.a.InterfaceC7393a
    public final String getToken() {
        if (this.f563066a != null) goto L6;
        this.f563066a = new h();
    L6:
        return this.f563066a.getToken();
    }
}
