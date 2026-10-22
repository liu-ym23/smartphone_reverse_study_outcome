package com.larus.xbridge.custom;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "flow.refreshImageAuth")
public final class FlowRefreshImageAuthMethod extends XCoreIDLBridgeMethod<e, f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f379675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f379676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeMethodName(name = "flow.refreshImageAuth", params = {"url"})
    public final String f379677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f379678d;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bb\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH'¨\u0006\n"}, d2 = {"Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshImageAuthApi;", "", "refreshFileUrl", "Lcom/bytedance/retrofit2/Call;", "Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlResp;", ContainerPosition.BODY, "Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlReq;", "headers", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface RefreshImageAuthApi {
        @POST("/alice/upload/refresh_file_url")
        Call<d> refreshFileUrl(@Body c r100, @HeaderMap Map<String, String> r101);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrl;", "", "mainUrl", "", "<init>", "(Ljava/lang/String;)V", "getMainUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("main_url")
        private final String mainUrl;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.mainUrl, ((a) r100).mainUrl) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.mainUrl;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "RefreshFileUrl(mainUrl=" + this.mainUrl + ')';
        }

        public a() {
            this.mainUrl = null;
        }

        public final String a() {
            return this.mainUrl;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlData;", "", "fileUrls", "", "Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrl;", "<init>", "(Ljava/util/List;)V", "getFileUrls", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("file_urls")
        private final List<a> fileUrls;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.fileUrls, ((b) r100).fileUrls) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<a> r100 = this.fileUrls;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "RefreshFileUrlData(fileUrls=" + this.fileUrls + ')';
        }

        public b() {
            this.fileUrls = null;
        }

        public final List<a> a() {
            return this.fileUrls;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlReq;", "", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        @SerializedName("url")
        private final String url;

        public c() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.url, ((c) r100).url) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.url;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "RefreshFileUrlReq(url=" + this.url + ')';
        }

        public c(String r100) {
            this.url = r100;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlResp;", "", "code", "", "msg", "", "data", "Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlData;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlData;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlData;)Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlResp;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d {

        @SerializedName("code")
        private final Integer code;

        @SerializedName("data")
        private final b data;

        @SerializedName("msg")
        private final String msg;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.code, r101.code) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.data, r101.data) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.code;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.msg;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            b r107 = this.data;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "RefreshFileUrlResp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public d() {
            this.code = null;
            this.msg = null;
            this.data = null;
        }

        public final Integer a() {
            return this.code;
        }

        public final b b() {
            return this.data;
        }

        public final String c() {
            return this.msg;
        }
    }

    @XBridgeParamModel
    public interface e extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();
    }

    @XBridgeResultModel
    public interface f extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();

        @XBridgeParamField(isGetter = false, keyPath = "url", required = true)
        void setUrl(String r100);
    }

    /* JADX INFO: renamed from: com.larus.xbridge.custom.FlowRefreshImageAuthMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.xbridge.custom.FlowRefreshImageAuthMethod$handle$1", f = "FlowRefreshImageAuthMethod.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletionBlock<f> $callback;
        final /* synthetic */ String $originUrl;
        final /* synthetic */ String $safeOriginUrl;
        int label;
        final /* synthetic */ FlowRefreshImageAuthMethod this$0;

        /* JADX INFO: renamed from: com.larus.xbridge.custom.FlowRefreshImageAuthMethod$handle$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.xbridge.custom.FlowRefreshImageAuthMethod$handle$1$1", f = "FlowRefreshImageAuthMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C45371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CompletionBlock<f> $callback;
            final /* synthetic */ String $refreshedUrl;
            final /* synthetic */ String $safeOriginUrl;
            int label;
            final /* synthetic */ FlowRefreshImageAuthMethod this$0;

            public C45371(String r100, FlowRefreshImageAuthMethod r101, String r102, CompletionBlock<f> r103, Continuation<? super C45371> r104) {
                this.$refreshedUrl = r100;
                this.this$0 = r101;
                this.$safeOriginUrl = r102;
                this.$callback = r103;
                super(2, r104);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C45371(this.$refreshedUrl, this.this$0, this.$safeOriginUrl, this.$callback, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C45371) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L17;
                ResultKt.throwOnFailure(r100);
                String r101 = this.$refreshedUrl;
                if (r101 != null) goto L7;
            L10:
                boolean r102 = true;
            L11:
                if (r102 == false) goto L14;
                FLogger.f375446a.e(this.this$0.f379675a, "[handle] refresh failed, url=" + this.$safeOriginUrl);
                CompletionBlock.DefaultImpls.onFailure$default(this.$callback, 0, "refresh failed", null, 4, null);
                return Unit.INSTANCE;
            L14:
                FLogger.f375446a.i(this.this$0.f379675a, "[handle] refresh success, url=" + this.$safeOriginUrl);
                f r103 = (f) ne7.e.b(f.class);
                r103.setUrl(this.$refreshedUrl);
                CompletionBlock.DefaultImpls.onSuccess$default(this.$callback, r103, null, 2, null);
                return Unit.INSTANCE;
            L7:
                if (StringsKt.isBlank(r101) == true) goto L10;
                r102 = false;
                goto L11
            L17:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(FlowRefreshImageAuthMethod r100, String r101, String r102, CompletionBlock<f> r103, Continuation<? super AnonymousClass1> r104) {
            this.this$0 = r100;
            this.$originUrl = r101;
            this.$safeOriginUrl = r102;
            this.$callback = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$originUrl, this.$safeOriginUrl, this.$callback, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L23:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            FlowRefreshImageAuthMethod r111 = this.this$0;
            String r102 = this.$originUrl;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
            Object r112 = Result.m9449constructorimpl(FlowRefreshImageAuthMethod.a(r111, r102));     // Catch: Throwable -> L11
        L13:
            FlowRefreshImageAuthMethod r104 = this.this$0;
            String r105 = this.$safeOriginUrl;
            Throwable r106 = Result.m9452exceptionOrNullimpl(r112);
            if (r106 == null) goto L17;
            FLogger.f375446a.e(r104.f379675a, "[handle] refresh exception, url=" + r105, r106);
        L17:
            if (Result.m9455isFailureimpl(r112) == false) goto L19;
            r112 = null;
        L19:
            String r107 = (String) r112;
            MainCoroutineDispatcher r113 = Dispatchers.getMain();
            C45371 r108 = new C45371(r107, this.this$0, this.$safeOriginUrl, this.$callback, null);
            this.label = 1;
            if (BuildersKt.withContext(r113, r108, this) != r100) goto L23;
            return r100;
        L11:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L13
        }
    }

    public FlowRefreshImageAuthMethod() {
        this.f379675a = "FlowRefreshImageAuth";
        this.f379676b = 1;
        this.f379677c = "flow.refreshImageAuth";
        this.f379678d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new m1());
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f379677c;
    }

    public static final String a(FlowRefreshImageAuthMethod r100, String r101) {
        Call<d> r102 = ((RefreshImageAuthApi) r100.f379678d.getValue()).refreshFileUrl(new c(r101), MapsKt.emptyMap());
        if (r102 == null) goto L5;
        SsResponse<d> r103 = r102.execute();
    L6:
        boolean r104 = true;
        if (r103 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == true) goto L18;
        FLogger r106 = FLogger.f375446a;
        String r107 = r100.f379675a;
        StringBuilder r108 = new StringBuilder("[refreshUrl] request failed, httpCode=");
        if (r103 == null) goto L16;
        Integer r109 = Integer.valueOf(r103.code());
    L17:
        r108.append(r109);
        r106.e(r107, r108.toString());
        return null;
    L16:
        r109 = null;
        goto L17
    L18:
        d r110 = r103.body();
        if (r110 == null) goto L33;
        b r111 = r110.b();
        if (r111 == null) goto L33;
        List<a> r112 = r111.a();
        if (r112 == null) goto L33;
        a r113 = (a) CollectionsKt.firstOrNull(r112);
        if (r113 == null) goto L33;
        String r114 = r113.a();
        if (r114 == null) goto L33;
        String r115 = StringsKt.trim(r114).toString();
        if (r115 == null) goto L33;
        String r116 = StringsKt.trim(r115, new char[]{'`'});
        if (r116 == null) goto L33;
        String r117 = StringsKt.trim(r116).toString();
    L34:
        FLogger r118 = FLogger.f375446a;
        String r119 = r100.f379675a;
        StringBuilder r120 = new StringBuilder("[refreshUrl] serverCode=");
        if (r110 == null) goto L37;
        Integer r121 = r110.a();
    L38:
        r120.append(r121);
        r120.append(", serverMsg=");
        if (r110 == null) goto L41;
        String r122 = r110.c();
    L42:
        r120.append(r122);
        r120.append(", hasUrl=");
        if (r117 != null) goto L45;
    L48:
        boolean r123 = true;
    L49:
        r120.append(!r123);
        r118.i(r119, r120.toString());
        if (r117 != null) goto L52;
    L55:
        boolean r124 = true;
    L56:
        if (r124 == false) goto L78;
        if (r110 == null) goto L65;
        Integer r125 = r110.a();
        int r126 = r100.f379676b;
        if (r125 == null) goto L65;
        if (r125.intValue() != r126) goto L65;
    L66:
        if (r104 == true) goto L79;
        String r127 = r100.f379675a;
        StringBuilder r128 = new StringBuilder("[refreshUrl] server error, code=");
        if (r110 == null) goto L70;
        Integer r129 = r110.a();
    L71:
        r128.append(r129);
        r128.append(", msg=");
        if (r110 == null) goto L74;
        String r130 = r110.c();
    L75:
        r128.append(r130);
        r118.e(r127, r128.toString());
        return null;
    L74:
        r130 = null;
        goto L75
    L70:
        r129 = null;
        goto L71
    L79:
        return null;
    L65:
        r104 = false;
        goto L66
    L78:
        return r117;
    L52:
        if (StringsKt.isBlank(r117) == true) goto L55;
        r124 = false;
        goto L56
    L45:
        if (StringsKt.isBlank(r117) == true) goto L48;
        r123 = false;
        goto L49
    L41:
        r122 = null;
        goto L42
    L37:
        r121 = null;
    L33:
        r117 = null;
        goto L34
    L9:
        if (r103.isSuccessful() != true) goto L11;
        r105 = true;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        e r113 = (e) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = r113.getUrl();
        if (StringsKt.isBlank(r100) == false) goto L5;
        FLogger.f375446a.e(this.f379675a, "[handle] invalid url");
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "invalid url", null, 4, null);
        return;
    L5:
        String r114 = StringsKt.substringBefore$default(r100, '?', null, 2, null);
        if (r114.length() == r100.length()) goto L9;
        r114 = r114.concat("?…");
    L9:
        String r101 = r114;
        FLogger.f375446a.i(this.f379675a, "[handle] start, url=" + r101);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass1(this, r100, r101, r112, null), 2, null);
    }
}
