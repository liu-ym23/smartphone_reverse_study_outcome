package com.bytedance.upc.bridge.impl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "upc.checkFace", owner = "wanglijie.skin")
public final class UpcCheckFaceMethodIDLImpl extends gp7.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f272417g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f272418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f272419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f272420f;

    /* JADX INFO: renamed from: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$handle$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
    final class AnonymousClass1 extends Lambda implements Function1<JSONObject, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JSONObject r100) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$handle$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
    final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        final /* synthetic */ CompletionBlock $callback;
        final /* synthetic */ UpcCheckFaceMethodIDLImpl this$0;

        /* JADX INFO: renamed from: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$handle$2$a */
        public static final class a implements gp7.c.InterfaceC6053c {
            public a() {
            }

            @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
            public final Map<String, Object> convert() {
                return MapsKt.mapOf(new Pair[]{TuplesKt.to("errorCode", 0), TuplesKt.to("errorMsg", "sucess")});
            }

            @Override // gp7.c.InterfaceC6053c
            public final Number getErrorCode() {
                return 0;
            }

            @Override // gp7.c.InterfaceC6053c
            public final String getErrorMsg() {
                return "验证成功";
            }

            @Override // gp7.c.InterfaceC6053c
            public final void setErrorCode(Number r100) {
            }

            @Override // gp7.c.InterfaceC6053c
            public final void setErrorMsg(String r100) {
            }

            @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
            public final JSONObject toJSON() {
                return new JSONObject();
            }
        }

        public AnonymousClass2(UpcCheckFaceMethodIDLImpl r100, CompletionBlock r101) {
            this.this$0 = r100;
            this.$callback = r101;
            super(1);
        }

        public final void invoke(long r100) {
            if (r100 == 0) goto L9;
            UpcCheckFaceMethodIDLImpl r101 = this.this$0;
            int r102 = (int) r100;
            CompletionBlock r103 = this.$callback;
            int r104 = UpcCheckFaceMethodIDLImpl.f272417g;
            r101.getClass();
            r103.onFailure(-1, "", new f(r102));
            return;
        L9:
            UpcCheckFaceMethodIDLImpl r105 = this.this$0;     // Catch: Throwable -> L8
            int r106 = UpcCheckFaceMethodIDLImpl.f272417g;     // Catch: Throwable -> L8
            ((com.bytedance.upc.a) r105.f272418d.getValue()).f272402c.d();     // Catch: Throwable -> L8
        L5:
            CompletionBlock.DefaultImpls.onSuccess$default(this.$callback, new a(), null, 2, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long r100) {
            invoke(r100.longValue());
            return Unit.INSTANCE;
        }
    }

    public UpcCheckFaceMethodIDLImpl() {
        this.f272418d = LazyKt.lazy(UpcCheckFaceMethodIDLImpl$mConfiguration$2.INSTANCE);
        this.f272419e = LazyKt.lazy(UpcCheckFaceMethodIDLImpl$mDefaultCertBusinessService$2.INSTANCE);
        this.f272420f = LazyKt.lazy(UpcCheckFaceMethodIDLImpl$mDefaultCertInitService$2.INSTANCE);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, final CompletionBlock r102) {
        gp7.c.b r103 = (gp7.c.b) r101;
        r103.getName();     // Catch: Throwable -> L17
        r103.getIdCard();     // Catch: Throwable -> L17
        ((com.bytedance.upc.a) this.f272418d.getValue()).getClass();     // Catch: Throwable -> L17
        Object r104 = this.f272420f.getValue();     // Catch: Throwable -> L17
        if (r104 == null) goto L16;
        ((com.bytedance.upc.i) r104).init();     // Catch: Throwable -> L17
        Object r105 = this.f272419e.getValue();     // Catch: Throwable -> L17
        if (r105 == null) goto L14;
        AnonymousClass3 r106 = AnonymousClass3.INSTANCE;     // Catch: Throwable -> L17
        ((com.bytedance.upc.h) r105).a();     // Catch: Throwable -> L17
        Object r107 = this.f272419e.getValue();     // Catch: Throwable -> L17
        if (r107 == null) goto L12;
        new AnonymousClass4(this, r102);     // Catch: Throwable -> L17
        ((com.bytedance.upc.h) r107).b();     // Catch: Throwable -> L17
        return;
    L12:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.upc.IUpcCertBusinessService");     // Catch: Throwable -> L17
    L14:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.upc.IUpcCertBusinessService");     // Catch: Throwable -> L17
    L16:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.upc.IUpcCertInitServive");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        ip7.b.a(th);
        r102.onFailure(-1, "", new f(-1));
    }
}
