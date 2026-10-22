package se6;

import com.bytedance.lark.pb.tool.v1.OnFetchResponse;
import com.bytedance.lark.sdk.LarkResponse;

/* JADX INFO: loaded from: classes20.dex */
public interface j {
    void a(OnFetchResponse.OnErrorResponse r100);

    void b(OnFetchResponse.OnProgressResponse r100);

    void c(OnFetchResponse.OnSuccessResponse r100);

    void d(LarkResponse r100);

    void e(OnFetchResponse.OnHeaderResponse r100);

    void f(OnFetchResponse.OnBodyResponse r100);

    void g(OnFetchResponse.OnCancelResponse r100);
}
