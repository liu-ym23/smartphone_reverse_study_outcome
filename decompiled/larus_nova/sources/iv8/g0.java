package iv8;

import com.larus.browsertakeover.cdp.BrowserCdpClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class g0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrowserCdpClient f496016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f496017b;

    public /* synthetic */ g0(BrowserCdpClient r100, int r101) {
        this.f496016a = r100;
        this.f496017b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        BrowserCdpClient r100 = this.f496016a;
        int r101 = this.f496017b;
        BrowserCdpClient.j r102 = r100.d();
        if (r102 == null) goto L28;
        BrowserCdpClient.h r103 = r100.K;
        if (r103 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == true) goto L27;
        if (r101 < 0) goto L14;
    L15:
        if (r101 > 0) goto L17;
    L19:
        r100.f319389i.incrementAndGet();
        r100.c(false, true);
        if (r100.v(r102) == true) goto L23;
        return Unit.INSTANCE;
    L23:
        if (r100.K == null) goto L25;
        r100.P();
    L25:
        r100.t();
        r100.L = null;
        BrowserCdpClient.h r105 = r100.b(r102, true);
        Integer r106 = Integer.valueOf(r101);
        r100.Z(r105, "Page.getNavigationHistory", new JSONObject(), new k0(r100, r105, r106));
        return Unit.INSTANCE;
    L17:
        if (r100.f319380J.f319434b == true) goto L19;
    L14:
        if (r100.f319380J.f319433a == true) goto L15;
    L27:
        return Unit.INSTANCE;
    L8:
        if (r103.f319432c != true) goto L10;
        r104 = true;
        goto L11
    L28:
        return Unit.INSTANCE;
    }
}
