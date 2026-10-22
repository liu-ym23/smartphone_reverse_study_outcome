package com.larus.dorag.widget.api;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/larus/dorag/widget/api/DoraWidgetGetNoteUrlApi;", "", "getNoteUrl", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/dorag/widget/api/NoteUrl;", "productId", "", "serialNumber", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dorag_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DoraWidgetGetNoteUrlApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f340996a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f340997a = null;

        static {
            f340997a = new a();
        }

        public a() {
        }
    }

    static {
        f340996a = a.f340997a;
    }

    @GET("/alice/w/note/url")
    Object getNoteUrl(@Query("product_id") String r100, @Query("w_did") String r101, Continuation<? super BizResponse<NoteUrl>> r102);
}
