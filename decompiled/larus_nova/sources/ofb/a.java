package ofb;

import com.bytedance.lark.pb.media.v1.BrowseFolderResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes35.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nfb.b f523135a;

    public a(nfb.b r100) {
        this.f523135a = r100;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        b r101 = b.f523136a;
        return b.b(BrowseFolderResponse.ADAPTER.decode(r100), this.f523135a.f519007i);
    }
}
