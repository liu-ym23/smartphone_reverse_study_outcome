package com.ss.android.lark.conditional.access.web.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.alipay.sdk.m.p.e;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.android.lark.conditional.access.network.model.response.BindDeviceWebData;
import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import com.ss.android.lark.conditional.access.utils.DisposableViewModel;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import io.reactivex.Observable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n8b.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/conditional/access/web/viewmodel/BindDeviceWebViewModel;", "Lcom/ss/android/lark/conditional/access/utils/DisposableViewModel;", "<init>", "()V", "networkDependency", "Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency;", "getNetworkDependency", "()Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency;", "setNetworkDependency", "(Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency;)V", "_bindDeviceWebLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/conditional/access/network/model/response/BindDeviceWebData;", "bindDeviceWebLiveData", "Landroidx/lifecycle/LiveData;", "getBindDeviceWebLiveData", "()Landroidx/lifecycle/LiveData;", "bindDeviceWeb", "", "webdid", "", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BindDeviceWebViewModel extends DisposableViewModel {
    public static final a Companion = null;
    private static final String TAG = "SecurityPolicy_UserScopeBindDeviceWebViewModel";
    private final MutableLiveData<BindDeviceWebData> _bindDeviceWebLiveData;
    private final LiveData<BindDeviceWebData> bindDeviceWebLiveData;

    @Inject
    public ConditionalAccessNetDependency networkDependency;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final ConditionalAccessNetDependency getNetworkDependency() {
        ConditionalAccessNetDependency r100 = this.networkDependency;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("networkDependency");
        return null;
    }

    @Inject
    public BindDeviceWebViewModel() {
        MutableLiveData<BindDeviceWebData> r100 = new MutableLiveData();
        this._bindDeviceWebLiveData = r100;
        this.bindDeviceWebLiveData = r100;
    }

    public final LiveData<BindDeviceWebData> getBindDeviceWebLiveData() {
        return this.bindDeviceWebLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_bindDeviceWebLiveData$p(BindDeviceWebViewModel r100) {
        return r100._bindDeviceWebLiveData;
    }

    public final void bindDeviceWeb(String r110) {
        Intrinsics.checkNotNullParameter(r110, "webdid");
        ConditionalAccessNetDependency r100 = getNetworkDependency();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "webdid");
        HttpMethod r101 = HttpMethod.GET;
        HttpParams r102 = new HttpParams();
        HttpHeaders r103 = new HttpHeaders();
        LinkedHashMap r104 = new LinkedHashMap();
        HttpMethod r105 = HttpMethod.POST;
        Intrinsics.checkNotNullParameter(r105, e.f25671s);
        Intrinsics.checkNotNullParameter("/lark/scs/compliance/device/bind_web/", "path");
        Map r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("webdid", r110)});
        Intrinsics.checkNotNullParameter(r111, ContainerPosition.BODY);
        r104.putAll(r111);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r112 = new com.ss.android.lark.security.compliance.infra.network.a("/lark/scs/compliance/device/bind_web/", r105, r102, r103, new JSONObject(r104), true);
        r112.c("");
        t4c.a.b(t4c.a.a(Observable.create(new c(r100.f418077b, r112)).singleOrError()), getDisposables(), new AnonymousClass1(this), new AnonymousClass2(this));
    }

    public final void setNetworkDependency(ConditionalAccessNetDependency r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.networkDependency = r100;
    }
}
