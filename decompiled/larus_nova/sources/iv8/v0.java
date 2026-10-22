package iv8;

import com.larus.browsertakeover.cdp.BrowserCdpClient;
import com.larus.browsertakeover.cdp.RemoteInputCommand;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class v0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrowserCdpClient f496109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RemoteInputCommand.Key f496110b;

    public /* synthetic */ v0(BrowserCdpClient r100, RemoteInputCommand.Key r101) {
        this.f496109a = r100;
        this.f496110b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        BrowserCdpClient r101 = this.f496109a;
        RemoteInputCommand.Key r102 = this.f496110b;
        BrowserCdpClient.m r103 = (BrowserCdpClient.m) r100;
        Intrinsics.checkNotNullParameter(r103, "it");
        com.larus.browsertakeover.cdp.b<BrowserCdpClient.m> r104 = r101.f319398r;
        monitor-enter(r104);
        Intrinsics.checkNotNullParameter(r102, "key");     // Catch: Throwable -> L15
        if (2 > (r104.f319464a - (r104.f319468e - r104.f319469f))) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L12;
        b1 r106 = new b1(false, 0);     // Catch: Throwable -> L15
        monitor-exit(r104);
    L14:
        return r106;
    L12:
        r104.a(r103, r102, 1);     // Catch: Throwable -> L15
        r104.f319468e += 2;     // Catch: Throwable -> L15
        r106 = new b1(true, 2);     // Catch: Throwable -> L15
        monitor-exit(r104);
        goto L14
    L7:
        r105 = false;
    L15:
        th = move-exception;
        throw th;
    }
}
