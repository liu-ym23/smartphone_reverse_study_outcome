package com.larus.office.card.urlpreview;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bb\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\"\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/office/card/urlpreview/WikiObjectApi;", "", "getObjectInfo", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/card/urlpreview/WikiObjectInfo;", WikiFolderPushPlugin.WIKI_TOKEN, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
interface WikiObjectApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f361819a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f361820a = null;

        static {
            f361820a = new a();
        }

        public a() {
        }
    }

    static {
        f361819a = a.f361820a;
    }

    @GET("/space/api/wiki/v2/obj/info/")
    Object getObjectInfo(@Query("wiki_token") String r100, Continuation<? super BizResponse<m2>> r101);
}
