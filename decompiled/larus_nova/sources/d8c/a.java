package d8c;

import com.bytedance.lark.pb.im.v1.GetChatLimitInfoResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f467446a = null;

    static {
        f467446a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return GetChatLimitInfoResponse.ADAPTER.decode(r100).open_security;
    }
}
