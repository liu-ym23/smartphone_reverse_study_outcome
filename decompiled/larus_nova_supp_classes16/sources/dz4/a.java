package dz4;

import com.bytedance.lark.pb.space.drive.v1.DownloadNormalResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class a implements SdkSender.IParser {
    public /* synthetic */ a() {
    }

    public final Object parse(byte[] r2) {
        return ((DownloadNormalResponse) DownloadNormalResponse.ADAPTER.decode(r2)).key;
    }
}
