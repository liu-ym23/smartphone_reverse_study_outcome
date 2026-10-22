package d8c;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.todo.v1.GetRecommendedContentsResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class c<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f467449a = null;

    static {
        f467449a = new c();
    }

    public c() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        GetRecommendedContentsResponse r101 = GetRecommendedContentsResponse.ADAPTER.decode(r100);
        Map<String, Chatter> r102 = null;
        if (r101 == null) goto L5;
        List<GetRecommendedContentsResponse.RecommendContent> r103 = r101.recommend_contents;
    L6:
        if (r101 == null) goto L9;
        r102 = r101.chatters;
    L9:
        return new e8c.b(r103, r102);
    L5:
        r103 = null;
        goto L6
    }
}
