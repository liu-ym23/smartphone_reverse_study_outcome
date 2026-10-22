package un7;

import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements wn7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WXMediaMessage f550846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShareContent f550847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WXVideoObject f550848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f550849d;

    @Override // wn7.a
    public final void a(byte[] r100) {
        WXMediaMessage r101 = this.f550846a;
        r101.thumbData = r100;
        ShareContent r102 = this.f550847b;
        WXVideoObject r103 = this.f550848c;
        a r104 = this.f550849d;
        r104.getClass();
        xn7.e.c(r102, r103, r101, new c(r104, r101, a.p(r102), r102));
    }

    public b(a r100, WXMediaMessage r101, ShareContent r102, WXVideoObject r103) {
        this.f550849d = r100;
        this.f550846a = r101;
        this.f550847b = r102;
        this.f550848c = r103;
    }
}
