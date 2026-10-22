package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/datasource/im/ListDevicesApi;", "", "listDevices", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/home/impl/main/side_bar/view/group/datasource/im/ListDevicesResponse;", "request", "Lcom/larus/home/impl/main/side_bar/view/group/datasource/im/ListDevicesRequest;", "(Lcom/larus/home/impl/main/side_bar/view/group/datasource/im/ListDevicesRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ListDevicesApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f345311a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f345312a = null;

        static {
            f345312a = new a();
        }

        public a() {
        }
    }

    static {
        f345311a = a.f345312a;
    }

    @POST("/alice/dispatch/list_devices")
    Object listDevices(@Body ListDevicesRequest r100, Continuation<? super BizResponse<ListDevicesResponse>> r101);
}
