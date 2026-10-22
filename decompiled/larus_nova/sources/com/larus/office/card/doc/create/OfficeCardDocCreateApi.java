package com.larus.office.card.doc.create;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bb\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ8\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH§@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/office/card/doc/create/OfficeCardDocCreateApi;", "", "createDocByMessage", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/card/doc/create/OfficeCardCreateDocByMessageResponse;", "request", "Lcom/larus/office/card/doc/create/OfficeCardCreateDocByMessageRequest;", "headers", "", "", "(Lcom/larus/office/card/doc/create/OfficeCardCreateDocByMessageRequest;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
interface OfficeCardDocCreateApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f361371a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f361372a = null;

        static {
            f361372a = new a();
        }

        public a() {
        }
    }

    static {
        f361371a = a.f361372a;
    }

    @POST("samantha/creation/artifact/create_by_message")
    Object createDocByMessage(@Body com.larus.office.card.doc.create.a r100, @HeaderMap Map<String, String> r101, Continuation<? super BizResponse<b>> r102);
}
