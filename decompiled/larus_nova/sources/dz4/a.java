package dz4;

import com.bytedance.lark.pb.space.drive.v1.DownloadNormalResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class a implements SdkSender.IParser {
    public /* synthetic */ a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return DownloadNormalResponse.ADAPTER.decode(r100).key;
    }
}
