package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.pb.security.v1.CustomDisplayConfig;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionRequest;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionResponse;
import io.reactivex.Single;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface g {

    public static final class a {
        public static /* synthetic */ void a(g r100, List r101) {
            r100.S5(r101, false);
        }
    }

    Single<? extends CustomDisplayConfig> Ld(String r100, String r101);

    void S5(List<String> r100, boolean r101);

    Single<QueryPolicyCenterResourceBlockActionResponse> U(QueryPolicyCenterResourceBlockActionRequest.Builder r100);

    Single v5(String r100);

    Single<CustomDisplayModel> ye(String r100, String r101);
}
