package me7;

import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class b extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f513507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f513508b;

    public interface a {
        void onFailure(int r100, String r101);

        void onSuccess(i66.b r100, String r101);
    }

    /* JADX INFO: renamed from: me7.b$b, reason: collision with other inner class name */
    public static final class C6810b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f513509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f513510b;

        public C6810b(b r100, XBridgeMethod.Callback r101) {
            this.f513509a = r100;
            this.f513510b = r101;
        }

        @Override // me7.b.a
        public final void onFailure(int r100, String r110) {
            Intrinsics.checkNotNullParameter(r110, "msg");
            XCoreBridgeMethod.onFailure$default(this.f513509a, this.f513510b, r100, r110, null, 8, null);
        }

        @Override // me7.b.a
        public final void onSuccess(i66.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = i66.b.f488436a;
            Map<String, Object> r103 = i66.b.a.a(r100);
            this.f513509a.onSuccess(this.f513510b, r103, r101);
        }
    }

    public b() {
        this.f513507a = "x.preloadResource";
        this.f513508b = XBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f513508b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f513507a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<t> provideParamModel() {
        return t.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<i66.b> provideResultModel() {
        return i66.b.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        int r100 = t.f513559h;
        Intrinsics.checkNotNullParameter(r110, "params");
        String r101 = com.bytedance.ies.xbridge.s.f(r110, "mainUrl", "");
        int r102 = com.bytedance.ies.xbridge.s.d(r110, "maxAge", 0);
        if (r110.isNull("subRes") == true) goto L8;
        XReadableMap r113 = com.bytedance.ies.xbridge.s.e(r110, "subRes");
        if (r113 == null) goto L8;
        Map<String, ? extends Object> r114 = com.bytedance.ies.xbridge.s.h(r113);
    L9:
        String r115 = com.bytedance.ies.xbridge.s.f(r110, "containerType", "");
        boolean r116 = com.bytedance.ies.xbridge.s.b(r110, "usePreloadJson", false);
        String r103 = com.bytedance.ies.xbridge.s.f(r110, "processType", "");
        boolean r104 = com.bytedance.ies.xbridge.s.b(r110, "enableMemory", true);
        t r117 = new t();
        r117.f513560a = r101;
        r117.f513561b = Integer.valueOf(r102);
        r117.f513562c = r114;
        r117.f513563d = r115;
        r117.f513564e = Boolean.valueOf(r116);
        r117.f513565f = r103;
        r117.f513566g = Boolean.valueOf(r104);
        C6810b r105 = new C6810b(this, r111);
        s r106 = (s) this;
        Intrinsics.checkNotNullParameter(r117, "params");
        Intrinsics.checkNotNullParameter(r105, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        String r107 = r117.f513560a;
        if (r107 != null) goto L12;
    L15:
        boolean r108 = true;
    L17:
        if (r108 == false) goto L22;
        if (Intrinsics.areEqual(r117.f513564e, Boolean.TRUE) == false) goto L27;
        s.f(r105, -3, "when usePreloadJson is true, mainUrl cannot be null");
        return;
    L27:
        if (Intrinsics.areEqual(r117.f513563d, "web") == false) goto L29;
        PreloadType r109 = PreloadType.WEB;
    L30:
        r106.f513558c = Observable.just(1).subscribeOn(Schedulers.io()).map(new p(r117, r109, r107, r106)).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(r106, r105), new r(r106, r105));
        return;
    L29:
        r109 = PreloadType.LYNX;
        goto L30
    L22:
        if (StringsKt.startsWith$default(r107, "http://", false, 2, null) == true) goto L27;
        if (StringsKt.startsWith$default(r107, "https://", false, 2, null) == true) goto L27;
        s.f(r105, -3, "mainUrl must start with http(s) or null");
        return;
    L12:
        if (r107.length() == 0) goto L15;
        r108 = false;
    L8:
        r114 = null;
        goto L9
    }
}
