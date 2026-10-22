package u7a;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import i8a.n;

/* JADX INFO: loaded from: classes32.dex */
public final class i extends g8a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxContext f549110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g8a.a f549111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f549112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i8a.e f549113d;

    @Override // g8a.a
    public final void a(LynxResourceRequest r100, com.lynx.tasm.ui.image.j r101) {
    }

    public i(LynxContext r100) {
        this.f549110a = r100;
        if (r100.isAsyncRedirect() == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        this.f549112c = r101;
        this.f549111b = r100.getMediaResourceFetcher();
        this.f549113d = (i8a.e) n.c().a(i8a.e.class);
        return;
    L5:
        if (r100.getAsyncImageInterceptor() == null) goto L7;
        r101 = true;
        goto L8
    }

    @Override // g8a.a
    public final OptionalBool b(String r100) {
        g8a.a r101 = this.f549111b;
        if (r101 != null) goto L5;
        i8a.e r102 = this.f549113d;
        if (r102 == null) goto L19;
        int r103 = r102.isLocalResource(r100);
        if (r103 != (-1)) goto L12;
        return OptionalBool.UNDEFINED;
    L12:
        if (r103 == 1) goto L21;
        if (r103 != 0) goto L17;
        return OptionalBool.FALSE;
    L17:
        return OptionalBool.UNDEFINED;
    L21:
        return OptionalBool.TRUE;
    L19:
        return OptionalBool.UNDEFINED;
    L5:
        return r101.b(r100);
    }

    @Override // g8a.a
    public final String c(LynxResourceRequest r100) {
        g8a.a r101 = this.f549111b;
        if (r101 == null) goto L7;
        return r101.c(r100);
    L7:
        if (this.f549112c == false) goto L11;
        return d7a.a.b(this.f549110a, r100.f383704a, true);
    L11:
        return d7a.a.b(this.f549110a, r100.f383704a, false);
    }
}
