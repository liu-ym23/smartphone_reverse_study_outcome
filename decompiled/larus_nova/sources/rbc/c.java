package rbc;

import com.bytedance.lark.pb.vote.v1.RetransmitVoteResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class c<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f537020a = null;

    static {
        f537020a = new c();
    }

    public c() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        RetransmitVoteResponse r101 = RetransmitVoteResponse.ADAPTER.decode(r100);
        Log.d("VoteMessageCell", "RetransmitVoteResponse: " + r101 + "} ");
        return r101;
    }
}
