package rbc;

import com.bytedance.lark.pb.vote.v1.CloseVoteResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f537018a = null;

    static {
        f537018a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        CloseVoteResponse r101 = CloseVoteResponse.ADAPTER.decode(r100);
        Log.d("VoteMessageCell", "CloseVoteResponse: " + r101 + "} ");
        return r101;
    }
}
