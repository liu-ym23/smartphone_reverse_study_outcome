package un7;

import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.nova.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import oo7.o;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements io7.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WXMediaMessage f550850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f550851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ShareContent f550852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f550853d;

    public final void a(boolean r100, String r101) {
        if (r100 == false) goto L4;
        WXMediaMessage r102 = this.f550850a;
        r102.msgSignature = r101;
        this.f550853d.q(r102, this.f550851b, this.f550852c);
        return;
    L4:
        o.a(this.f550853d.f510132a, this.f550852c, 213, R.string.share_sdk_share_illegal_content_tips);
        kn7.b.a(10300, this.f550852c);
    }

    public c(a r100, WXMediaMessage r101, int r102, ShareContent r103) {
        this.f550853d = r100;
        this.f550850a = r101;
        this.f550851b = r102;
        this.f550852c = r103;
    }
}
