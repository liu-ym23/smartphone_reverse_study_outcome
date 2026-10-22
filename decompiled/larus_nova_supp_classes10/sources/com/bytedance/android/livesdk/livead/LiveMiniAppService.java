package com.bytedance.android.livesdk.livead;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.CoverImageModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livehostapi.business.depend.livead.IMiniAppNetworkCallback;
import com.bytedance.android.livehostapi.business.depend.livead.model.DeleteStampRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.LiveAdAuthResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.SaveStampRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampInfoResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSearchRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSearchResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSelectionRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSelectionResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSensitiveResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.UpdateStampRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.UploadImageResponse;
import com.bytedance.android.livesdk.config.p90;
import com.bytedance.android.livesdk.floatview.IFloatWindowManager;
import com.bytedance.android.livesdk.floatview.VideoFloatWindowManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J/\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u001e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fH\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0016\u0010\u001a\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fH\u0016J\u001e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u001d2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000fH\u0016J\u001e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0016J\u001e\u0010#\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020$2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020%0\u000fH\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\bH\u0016J\u001e\u0010+\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020,2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fH\u0016J \u0010-\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020/0\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/livead/LiveMiniAppService;", "Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveMiniAppService;", "()V", "miniAppShow", "", "changeLiveStreamStatus", "", "status", "", "checkSensitiveTitle", "Lio/reactivex/disposables/Disposable;", "businessType", "title", "", "callback", "Lcom/bytedance/android/livehostapi/business/depend/livead/IMiniAppNetworkCallback;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSensitiveResponse;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/livehostapi/business/depend/livead/IMiniAppNetworkCallback;)Lio/reactivex/disposables/Disposable;", "closeFloatWindow", "deleteStamp", "data", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/DeleteStampRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "getCurrentRoomInfo", "", "getMiniAppActivityState", "hasChangeCoverAuth", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/LiveAdAuthResponse;", "saveStamp", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/SaveStampRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampInfoResponse;", "searchStamp", "request", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSearchRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSearchResponse;", "selectStamp", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionResponse;", "setMiniAppActivityStatue", "showing", "supportMiniApp", "updateCommerceCount", "count", "updateStamp", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/UpdateStampRequest;", "uploadImage", "filePath", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/UploadImageResponse;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveMiniAppService implements ILiveMiniAppService {
    private boolean miniAppShow;

    public static final class a<T> implements Predicate {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "response");
            if (((BaseResponse) r3).data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public b(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.onSuccess((com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse) ((BaseResponse) ((Response) r2)).data);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public c(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IMiniAppNetworkCallback r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public static final class d<T> implements Predicate {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final boolean test(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "response");
            if (((BaseResponse) r3).data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public e(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.onSuccess((com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse) ((BaseResponse) ((Response) r2)).data);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public f(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IMiniAppNetworkCallback r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public g(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IMiniAppNetworkCallback r0 = this.a;
            r0.onSuccess((LiveAdAuthResponse) r2);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public h(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IMiniAppNetworkCallback r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public static final class i<T> implements Predicate {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final boolean test(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "response");
            if (((BaseResponse) r3).data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public j(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.onSuccess((com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse) ((BaseResponse) ((Response) r2)).data);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public k(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IMiniAppNetworkCallback r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public static final class l<T> implements Predicate {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final boolean test(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "response");
            if (((BaseResponse) r3).data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public m(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.onSuccess((com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse) ((BaseResponse) ((Response) r2)).data);
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public n(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IMiniAppNetworkCallback r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public static final class o<T> implements Predicate {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final boolean test(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "response");
            if (((BaseResponse) r3).data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public p(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.onSuccess((com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse) ((BaseResponse) ((Response) r2)).data);
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public q(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IMiniAppNetworkCallback r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public static final class r<T> implements Predicate {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
        }

        public final boolean test(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "response");
            if (((BaseResponse) r3).data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public s(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.onSuccess((com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse) ((BaseResponse) ((Response) r2)).data);
        }
    }

    public static final class t<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public t(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IMiniAppNetworkCallback r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public static final class u<T> implements Predicate {
        public static final u a = null;

        static {
            a = new u();
        }

        public u() {
        }

        public final boolean test(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "response");
            if (((BaseResponse) r3).data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class v<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public v(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            IMiniAppNetworkCallback r0 = this.a;
            UploadImageResponse r1 = new UploadImageResponse();
            r1.setImageModel((CoverImageModel) ((BaseResponse) ((Response) r3)).data);
            Unit r4 = Unit.INSTANCE;
            r0.onSuccess(r1);
        }
    }

    public static final class w<T> implements Consumer {
        public final /* synthetic */ IMiniAppNetworkCallback a;

        public w(IMiniAppNetworkCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IMiniAppNetworkCallback r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public LiveMiniAppService() {
    }

    public void closeFloatWindow() {
        com.bytedance.android.livesdk.floatview.q r0 = VideoFloatWindowManager.f;
        IFloatWindowManager.a.a(VideoFloatWindowManager.b.a(), false, 3);
    }

    public Map<String, String> getCurrentRoomInfo() {
        IRoomService r0 = jc1.k.f(IRoomService.class);
        if (r0 == null) goto L5;
        Room r1 = r0.getCurrentRoom();
    L6:
        HashMap r2 = new HashMap();
        String r3 = BDLocationException.ERROR_TIMEOUT;
        if (r1 != null) goto L17;
        IUserService r4 = jc1.k.f(IUserService.class);
        if (r4 == null) goto L16;
        com.bytedance.android.livesdk.user.f r5 = r4.user();
        if (r5 == null) goto L16;
        String r6 = r5.n();
        if (r6 == null) goto L16;
        r3 = r6;
    L16:
        r2.put("anchor_id", r3);
    L22:
        return r2;
    L17:
        String r7 = String.valueOf(r1.getId());
        if (r7 == null) goto L21;
        r3 = r7;
    L21:
        r2.put("room_id", r3);
        r2.put("anchor_id", r1.getOwnerUserIdString());
        goto L22
    L5:
        r1 = null;
        goto L6
    }

    public boolean getMiniAppActivityState() {
        return this.miniAppShow;
    }

    public boolean supportMiniApp() {
        return tb1.c.a;
    }

    public void changeLiveStreamStatus(int r3) {
        if (r3 != 0) goto L5;
        xs2.b.a().post(new h1(32));
        return;
    L5:
        if (r3 != 1) goto L9;
        xs2.b.a().post(new h1(42));
        return;
    }

    public Disposable hasChangeCoverAuth(IMiniAppNetworkCallback<LiveAdAuthResponse> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L6;
        String r1 = r0.getHostDomain();
        if (r1 == null) goto L6;
    L7:
        String r2 = r1.concat("/aweme/v1/microapp/webcast/auth/");
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).checkMiniappAuthList(r2).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r4), new h(r4));
    L6:
        r1 = "";
        goto L7
    }

    public void setMiniAppActivityStatue(boolean r1) {
        this.miniAppShow = r1;
    }

    public void updateCommerceCount(int r2) {
        if (((Boolean) p90.a.getValue()).booleanValue() == false) goto L6;
        jc1.k.n(IHostCommerceServiceLive.class).notifyPromotionNum(r2);
        return;
    }

    public Disposable deleteStamp(DeleteStampRequest r6, IMiniAppNetworkCallback<com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse> r7) {
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "callback");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L6;
        String r1 = r0.getHostDomain();
        if (r1 == null) goto L6;
    L7:
        String r2 = r1.concat("/webcast/stamp/delete/");
        String r3 = GsonProtectorUtils.toJson(GsonHelper.get(), r6.getStamps());
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).deleteStamp(r2, String.valueOf(r6.getRoomId()), r3).filter(d.a).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r7), new f(r7));
    L6:
        r1 = "";
        goto L7
    }

    public Disposable saveStamp(SaveStampRequest r6, IMiniAppNetworkCallback<StampInfoResponse> r7) {
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "callback");
        String r0 = GsonProtectorUtils.toJson(GsonHelper.get(), r6.getStampInfo());
        IHostLiveAd r1 = TTLiveSDK.hostService().hostLiveAd();
        if (r1 == null) goto L6;
        String r2 = r1.getHostDomain();
        if (r2 == null) goto L6;
    L7:
        String r3 = r2.concat("/webcast/stamp/save/");
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).saveStamp(r3, String.valueOf(r6.getRoomId()), r0).filter(i.a).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(r7), new k(r7));
    L6:
        r2 = "";
        goto L7
    }

    public Disposable searchStamp(StampSearchRequest r5, IMiniAppNetworkCallback<StampSearchResponse> r6) {
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "callback");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L6;
        String r1 = r0.getHostDomain();
        if (r1 == null) goto L6;
    L7:
        String r2 = r1.concat("/webcast/stamp/search/");
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).searchStamp(r2, r5.getType(), r5.getKeyword()).filter(l.a).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(r6), new n(r6));
    L6:
        r1 = "";
        goto L7
    }

    public Disposable selectStamp(StampSelectionRequest r10, IMiniAppNetworkCallback<StampSelectionResponse> r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "callback");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L6;
        String r1 = r0.getHostDomain();
        if (r1 == null) goto L6;
    L7:
        String r3 = r1.concat("/webcast/stamp/selection/");
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).selectStamp(r3, r10.getType(), r10.getTabId(), r10.getPage(), r10.getPageSize()).filter(o.a).compose(RxUtil.rxSchedulerHelper()).subscribe(new p(r11), new q(r11));
    L6:
        r1 = "";
        goto L7
    }

    public Disposable updateStamp(UpdateStampRequest r9, IMiniAppNetworkCallback<com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse> r10) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "callback");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L6;
        String r1 = r0.getHostDomain();
        if (r1 == null) goto L6;
    L7:
        String r3 = r1.concat("/webcast/stamp/status/update/");
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).updateStamp(r3, String.valueOf(r9.getRoomId()), r9.getType(), r9.getStampId(), r9.getStatus()).filter(r.a).compose(RxUtil.rxSchedulerHelper()).subscribe(new s(r10), new t(r10));
    L6:
        r1 = "";
        goto L7
    }

    public Disposable uploadImage(String r4, IMiniAppNetworkCallback<UploadImageResponse> r5) {
        Intrinsics.checkNotNullParameter(r4, "filePath");
        Intrinsics.checkNotNullParameter(r5, "callback");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r4);
        if (r0.exists() == true) goto L6;
        r5.onError(new Exception("avatar file don't exists in path " + r4));
        return null;
    L6:
        TypedOutput r6 = new MultipartTypedOutput();
        r6.addPart("file", new TypedFile("multipart/form-data", r0));
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).uploadAvatar(r6).filter(u.a).compose(RxUtil.rxSchedulerHelper()).subscribe(new v(r5), new w(r5));
    }

    public Disposable checkSensitiveTitle(Integer r4, String r5, IMiniAppNetworkCallback<StampSensitiveResponse> r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L6;
        String r1 = r0.getHostDomain();
        if (r1 == null) goto L6;
    L7:
        String r2 = r1.concat("/webcast/stamp/check/");
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).checkStamp(r2, r4, r5).filter(a.a).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r6), new c(r6));
    L6:
        r1 = "";
        goto L7
    }
}
