package com.larus.office.card.doc.content;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\"\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/office/card/doc/content/OfficeCardDocContentApi;", "", "getDocContent", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/card/doc/content/OfficeCardGetDocContentResponse;", "request", "Lcom/larus/office/card/doc/content/OfficeCardGetDocContentRequest;", "(Lcom/larus/office/card/doc/content/OfficeCardGetDocContentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
interface OfficeCardDocContentApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f361363a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f361364a = null;

        static {
            f361364a = new a();
        }

        public a() {
        }
    }

    static {
        f361363a = a.f361364a;
    }

    @POST("samantha/otter/export/page/to_markdown")
    Object getDocContent(@Body c r100, Continuation<? super BizResponse<d>> r101);
}
