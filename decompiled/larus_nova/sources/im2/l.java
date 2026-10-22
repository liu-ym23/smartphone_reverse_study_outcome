package im2;

import com.bytedance.android.livesdk.config.q80;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements amc.d, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f490503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f490504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final amc.d f490505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final amc.d f490506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.network.l f490507e;

    @Override // amc.d
    public final Map<String, String> a() {
        if (this.f490503a == true) goto L6;
        return this.f490506d.a();
    L6:
        return this.f490505c.a();
    }

    @Override // im2.b
    public final List<p> getInfo() {
        if (this.f490504b == false) goto L24;
        ArrayList r100 = new ArrayList();
        amc.d r101 = this.f490506d;
        amc.d r102 = null;
        if ((r101 instanceof b) == true) goto L7;
        r101 = null;
    L7:
        b r103 = (b) r101;
        if (r103 == null) goto L13;
        List<p> r104 = r103.getInfo();
        if (r104 == null) goto L13;
        r100.addAll(r104);
    L13:
        if ((!Intrinsics.areEqual(this.f490506d, this.f490505c)) == false) goto L25;
        amc.d r105 = this.f490505c;
        if ((r105 instanceof b) == false) goto L18;
        r102 = r105;
    L18:
        b r106 = (b) r102;
        if (r106 == null) goto L26;
        List<p> r107 = r106.getInfo();
        if (r107 == null) goto L27;
        r100.addAll(r107);
        return r100;
    L27:
        return r100;
    L26:
        return r100;
    L25:
        return r100;
    L24:
        return CollectionsKt.emptyList();
    }

    public l(com.ss.ugc.live.sdk.msg.network.l r100) {
        this.f490507e = r100;
        int r101 = vs1.f.f556978a;
        boolean r102 = q80.f121034a.getValue().a();
        this.f490504b = r102;
        if (r102 == false) goto L5;
        amc.d r103 = new a();
    L6:
        this.f490505c = r103;
        int r104 = m.f490508a;
        byte[] r105 = m.f490509b;
        if (m.f() == false) goto L10;
        if (r105 == null) goto L10;
        r103 = new q(r105, m.f490508a, r103);
    L10:
        this.f490506d = r103;
        return;
    L5:
        r103 = new com.ss.ugc.live.sdk.msg.network.c();
        goto L6
    }

    @Override // amc.d
    public final byte[] b(tlc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
        if (this.f490503a == false) goto L20;
        return this.f490505c.b(r100);
    L15:
        th = move-exception;
        int r101 = m.f490508a;
        m.c(DownloadHelper.GZIP, "decompress exception", th);
        return new byte[0];
    L20:
        return this.f490506d.b(r100);
    L6:
        bc2.c.b("zstd decompress failed, fallback");
        this.f490503a = true;
        com.ss.ugc.live.sdk.msg.network.l r102 = this.f490507e;
        if ((r102 instanceof k) == true) goto L9;
        r102 = null;
    L9:
        k r103 = (k) r102;
        if (r103 == null) goto L22;
        r103.b("zstd decompress failed");
    L22:
        return new byte[0];
    }
}
