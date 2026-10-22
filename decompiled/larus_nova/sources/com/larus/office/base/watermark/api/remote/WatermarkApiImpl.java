package com.larus.office.base.watermark.api.remote;

import androidx.core.app.NotificationCompat;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.utils.logger.FLogger;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class WatermarkApiImpl implements nn9.a {

    public static abstract class a<T> {

        /* JADX INFO: renamed from: com.larus.office.base.watermark.api.remote.WatermarkApiImpl$a$a, reason: collision with other inner class name */
        public static final class C4438a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f361230a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4438a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f361230a, ((C4438a) r100).f361230a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f361230a.hashCode();
            }

            public final String toString() {
                return "Failure(reason=" + this.f361230a + ')';
            }

            public C4438a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f361230a = r100;
            }
        }

        public static final class b<T> extends a<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final T f361231a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f361231a, ((b) r100).f361231a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f361231a.hashCode();
            }

            public final String toString() {
                return "Success(data=" + this.f361231a + ')';
            }

            public b(T r100) {
                Intrinsics.checkNotNullParameter(r100, "data");
                this.f361231a = r100;
            }
        }

        public a() {
        }
    }

    public static final class b {
    }

    /* JADX INFO: renamed from: com.larus.office.base.watermark.api.remote.WatermarkApiImpl$call$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.office.base.watermark.api.remote.WatermarkApiImpl", f = "WatermarkApiImpl.kt", i = {0}, l = {150}, m = NotificationCompat.CATEGORY_CALL, n = {"tag"}, s = {"L$0"})
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WatermarkApiImpl this$0;

        public AnonymousClass1(WatermarkApiImpl r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return WatermarkApiImpl.b(this.this$0, this);
        }
    }

    static {
    }

    public WatermarkApiImpl() {
    }

    public static String d(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        String r103 = null;
        if (r102 == false) goto L12;
        return null;
    L12:
        String r104 = StringsKt.substringAfterLast(StringsKt.substringBefore$default(StringsKt.substringBefore$default(r100, '?', null, 2, null), '#', null, 2, null), '.', "").toLowerCase(Locale.ROOT);
        if (r104.length() <= 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == true) goto L18;
    L20:
        r101 = false;
    L21:
        if (r101 == false) goto L24;
        r103 = r104;
    L24:
        if (Intrinsics.areEqual(r103, "image") == false) goto L27;
        return "webp";
    L27:
        return r103;
    L18:
        if (r104.length() > 8) goto L20;
    L15:
        r105 = false;
        goto L16
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static final /* synthetic */ Object b(WatermarkApiImpl r100, Continuation r101) {
        return r100.call(null, null, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nn9.a
    public final Object a(String r100, Continuation<? super nn9.a.b> r101) {
        if ((r101 instanceof WatermarkApiImpl$queryTask$1) == false) goto L7;
        WatermarkApiImpl$queryTask$1 r102 = (WatermarkApiImpl$queryTask$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        a r108 = (a) r104;
        if ((r108 instanceof a.C4438a) == false) goto L21;
        return new nn9.a.b.C6946a(((a.C4438a) r108).f361230a);
    L21:
        if ((r108 instanceof a.b) == false) goto L39;
        a.b r109 = (a.b) r108;
        String r110 = ((WatermarkData) r109.f361231a).getStatus();
        if (Intrinsics.areEqual(r110, "ready") == false) goto L34;
        String r111 = ((WatermarkData) r109.f361231a).getDownloadUrl();
        if (r111 != null) goto L27;
    L30:
        if (r107 == false) goto L42;
        FLogger.f375446a.e("WatermarkApiImpl", "queryTask: ready but empty url taskId=" + r100);
        return new nn9.a.b.C6946a("ready_but_empty_url");
    L42:
        return new nn9.a.b.c(r111);
    L27:
        if (r111.length() == 0) goto L30;
        r107 = false;
        goto L30
    L34:
        if (Intrinsics.areEqual(r110, "processing") == true) goto L43;
        FLogger.f375446a.w("WatermarkApiImpl", "queryTask: unknown status=" + ((WatermarkData) r109.f361231a).getStatus() + " taskId=" + r100);
        return new nn9.a.b.C6946a("unknown_status_" + ((WatermarkData) r109.f361231a).getStatus());
    L43:
        return nn9.a.b.C6947b.f519682a;
    L39:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        WatermarkApiImpl$queryTask$r$1 r112 = new WatermarkApiImpl$queryTask$r$1(r100, null);
        r102.L$0 = r100;
        r102.label = 1;
        r104 = call("watermarkTask", r112, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new WatermarkApiImpl$queryTask$1(this, r101);
        goto L8
    }

    private final <T> Object call(String r110, Function2<? super WatermarkRetrofitApi, ? super Continuation<? super BizResponse<T>>, ? extends Object> r111, Continuation<? super a<? extends T>> r112) {
        if ((r112 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r100 = (AnonymousClass1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r110 = (String) r102.L$0;
        ResultKt.throwOnFailure(r113);
    L17:
        dm9.a r114 = (dm9.a) r113;
        if ((r114 instanceof dm9.a.C5690a) == false) goto L24;
        FLogger r115 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder();
        r105.append(r110);
        r105.append(" http error code=");
        dm9.a.C5690a r116 = (dm9.a.C5690a) r114;
        r105.append(r116.f469228a);
        r105.append(" msg=");
        r105.append(r116.f469229b);
        r115.e("WatermarkApiImpl", r105.toString());
        StringBuilder r117 = new StringBuilder("http_");
        r117.append(r116.f469228a);
        r117.append(':');
        String r118 = r116.f469229b;
        if (r118 != null) goto L22;
        r118 = "";
    L22:
        r117.append(r118);
        return new a.C4438a(r117.toString());
    L24:
        if ((r114 instanceof dm9.a.b) == false) goto L40;
        BizResponse<T> r119 = ((dm9.a.b) r114).f469231a;
        T r120 = r119.getData();
        if (r119.getCode() != 0) goto L29;
        if (r120 == null) goto L29;
        return new a.b(r120);
    L29:
        int r121 = com.larus.office.base.watermark.api.remote.a.f361234a;
        long r106 = r119.getCode();
        String r122 = r119.getMsg();
        if (r122 != null) goto L32;
    L36:
        r122 = "biz_code_" + r106;
    L37:
        FLogger.f375446a.e("WatermarkApiImpl", r110 + " biz error code=" + r119.getCode() + " msg=" + r119.getMsg());
        return new a.C4438a(r122);
    L32:
        if ((!StringsKt.isBlank(r122)) == true) goto L35;
        r122 = null;
    L35:
        if (r122 != null) goto L37;
    L40:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        WatermarkRetrofitApi.a r123 = WatermarkRetrofitApi.f361232a;
        r102.L$0 = r110;
        r102.label = 1;
        r123.getClass();
        FlowHttpConnection r124 = FlowHttpConnection.f359975a;
        r113 = FlowHttpConnection.g(ServiceType.BASIC_SERVICE, WatermarkRetrofitApi.class, r111, false, null, null, null, r102, 248);
        if (r113 != r103) goto L17;
        return r103;
    L7:
        r100 = new AnonymousClass1(this, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(String r110, String r111, String r112, DownloadWatermarkScene r210, Continuation<? super nn9.a.AbstractC6944a> r211) {
        if ((r211 instanceof WatermarkApiImpl$createWatermarkDownload$1) == false) goto L7;
        WatermarkApiImpl$createWatermarkDownload$1 r100 = (WatermarkApiImpl$createWatermarkDownload$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = false;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        DownloadWatermarkScene r106 = (DownloadWatermarkScene) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r107 = r102;
        DownloadWatermarkScene r108 = r106;
    L32:
        a r109 = (a) r107;
        if ((r109 instanceof a.C4438a) == false) goto L36;
        return new nn9.a.AbstractC6944a.C6945a(((a.C4438a) r109).f361230a);
    L36:
        if ((r109 instanceof a.b) == false) goto L60;
        a.b r113 = (a.b) r109;
        String r114 = ((WatermarkData) r113.f361231a).getStatus();
        if (Intrinsics.areEqual(r114, "ready") == false) goto L48;
        String r115 = ((WatermarkData) r113.f361231a).getDownloadUrl();
        if (r115 != null) goto L42;
    L43:
        r105 = true;
    L44:
        if (r105 == false) goto L63;
        FLogger.f375446a.e("WatermarkApiImpl", "createWatermarkDownload: ready but empty url scene=" + r108.getSubScene());
        return new nn9.a.AbstractC6944a.C6945a("ready_but_empty_url");
    L63:
        return new nn9.a.AbstractC6944a.c(r115);
    L42:
        if (r115.length() != 0) goto L44;
    L48:
        if (Intrinsics.areEqual(r114, "processing") == false) goto L57;
        String r116 = ((WatermarkData) r113.f361231a).getTaskId();
        if (r116 != null) goto L52;
    L53:
        r105 = true;
    L54:
        if (r105 == false) goto L65;
        FLogger.f375446a.e("WatermarkApiImpl", "createWatermarkDownload: empty taskId scene=" + r108.getSubScene());
        return new nn9.a.AbstractC6944a.C6945a("empty_task_id");
    L65:
        return new nn9.a.AbstractC6944a.b(r116);
    L52:
        if (r116.length() != 0) goto L54;
    L57:
        FLogger.f375446a.e("WatermarkApiImpl", "createWatermarkDownload: unknown status=" + ((WatermarkData) r113.f361231a).getStatus());
        return new nn9.a.AbstractC6944a.C6945a("unknown_status_" + ((WatermarkData) r113.f361231a).getStatus());
    L60:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r117 = d(r111);
        if (r117 != null) goto L17;
        r117 = d(r110);
    L17:
        String r118 = r117;
        String r119 = r210.getScene();
        String r120 = r210.getSubScene();
        Locale r121 = Locale.getDefault();
        String r122 = r121.getLanguage();
        Locale r123 = Locale.ROOT;
        String r124 = r122.toLowerCase(r123);
        if (r124.length() != 0) goto L20;
        boolean r125 = true;
    L21:
        if (r125 == false) goto L23;
        r124 = "zh";
    L23:
        String r126 = r121.getCountry().toLowerCase(r123);
        if (r126.length() != 0) goto L26;
        boolean r127 = true;
    L27:
        if (r127 == false) goto L29;
        r126 = "cn";
    L29:
        WatermarkApiImpl$createWatermarkDownload$r$1 r128 = new WatermarkApiImpl$createWatermarkDownload$r$1(new WatermarkDownloadRequest(r110, r111, r119, r120, r112, r118, r124 + '_' + r126), null);
        r108 = r210;
        r100.L$0 = r108;
        r100.label = 1;
        r107 = call("watermarkDownload", r128, r100);
        if (r107 != r103) goto L32;
        return r103;
    L26:
        r127 = false;
        goto L27
    L20:
        r125 = false;
    L7:
        r100 = new WatermarkApiImpl$createWatermarkDownload$1(this, r211);
        goto L8
    }
}
