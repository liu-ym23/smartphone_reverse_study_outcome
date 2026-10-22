package xs4;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.lark.lark_bitable_android.a0;
import com.bytedance.lark.lark_bitable_android.c0;
import er5.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f565002a;

    public d(c.d.a r100) {
        this.f565002a = r100;
    }

    @Override // com.bytedance.lark.lark_bitable_android.a0
    public final void a(c0 r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "msg");
        StringBuilder r103 = new StringBuilder("createBitable: ");
        if (r100 == null) goto L5;
        String r104 = r100.f252989a;
    L6:
        r103.append(r104);
        r103.append(' ');
        r103.append(r101);
        r103.append(' ');
        r103.append(r102);
        tt5.a.b("WorkspaceServiceImpl", r103.toString());
        if (r101 == 0) goto L12;
        f r105 = this.f565002a;
        if (r105 == null) goto L41;
        r105.a(new NetService.ServerErrorException((int) r101, r102, null, null));
        return;
    L41:
        return;
    L12:
        if (r100 == null) goto L14;
        String r106 = r100.f252989a;
    L15:
        boolean r107 = true;
        if (r106 != null) goto L18;
    L21:
        boolean r108 = true;
    L22:
        if (r108 == true) goto L37;
        if (r100 == null) goto L25;
        String r109 = r100.f252990b;
    L26:
        if (r109 != null) goto L28;
    L31:
        if (r107 == true) goto L37;
        if (r100 == null) goto L42;
        f r110 = this.f565002a;
        if (r110 == null) goto L43;
        r110.onSuccess(r100.f252989a, r100.f252990b);
        return;
    L43:
        return;
    L42:
        return;
    L28:
        if (r109.length() == 0) goto L31;
        r107 = false;
        goto L31
    L25:
        r109 = null;
    L37:
        f r111 = this.f565002a;
        if (r111 == null) goto L45;
        r111.a(new NetService.ServerErrorException(-1, "error code == 0, but data is null or empty", null, null));
        return;
    L45:
        return;
    L18:
        if (r106.length() == 0) goto L21;
        r108 = false;
        goto L22
    L14:
        r106 = null;
        goto L15
    L5:
        r104 = null;
        goto L6
    }
}
