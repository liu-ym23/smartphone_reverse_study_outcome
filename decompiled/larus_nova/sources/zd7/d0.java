package zd7;

import android.app.Activity;
import android.content.Context;
import com.bytedance.applet.impl.i2;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.uploadImagesToImageX")
public final class d0 extends yd7.j implements com.bytedance.sdk.xbridge.cn.protocol.h {

    public static final class a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f571338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<String> f571339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f571340c;

        @Override // zd7.b0
        public final String a() {
            return this.f571338a;
        }

        @Override // zd7.b0
        public final ArrayList<String> b() {
            return this.f571339b;
        }

        @Override // zd7.b0
        public final Boolean isBoeEnable() {
            return this.f571340c;
        }

        public a(String r100, ArrayList<String> r101, d0 r102) {
            this.f571338a = r100;
            this.f571339b = r101;
            r102.getClass();
            XBaseRuntime.f270095a.getClass();
            IHostContextDepend r103 = XBaseRuntime.f270100f;
            if (r103 == null) goto L5;
            Boolean r104 = Boolean.valueOf(r103.isBoeEnable());
        L6:
            this.f571340c = r104;
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class b implements zd7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<yd7.j.h> f571341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f571342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<ArrayList<yd7.j.e>> f571343c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f571344d;

        @Override // zd7.b
        public final void onComplete() {
            CompletionBlock<yd7.j.h> r100 = this.f571341a;
            XBaseModel r101 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.j.h.class));
            String r102 = this.f571342b;
            Ref.ObjectRef<ArrayList<yd7.j.e>> r103 = this.f571343c;
            yd7.j.h r104 = (yd7.j.h) r101;
            r104.setTraceId(r102);
            r104.setImageInfos(r103.element);
            CompletionBlock.DefaultImpls.onSuccess$default(r100, (XBaseResultModel) r101, null, 2, null);
        }

        @Override // zd7.b
        public final void b(i2.b r100) {
            ArrayList r101 = this.f571343c.element;
            XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.j.e.class));
            yd7.j.e r103 = (yd7.j.e) r102;
            r103.setUri(r100.f191951a);
            int r104 = ne7.d.f518889a;
            Map<String, ? extends Object> r105 = ne7.d.b(new JSONObject(r100.f191953c));
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            r103.setMetaInfo(r105);
            i2.a r106 = r100.f191954d;
            if (r106 == null) goto L7;
            String r107 = r106.f191950a;
            if (r107 == null) goto L7;
            LinkedHashMap r108 = new LinkedHashMap();
            r108.put("aesKey", r107);
            r103.setEncryptionInfo(r108);
        L7:
            r101.add(r102);
            IBDXBridgeContext r109 = this.f571344d;
            Map r110 = ne7.d.b(new JSONObject(r100.f191953c));
            Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            r109.sendEvent("uploadImagesToImageXSingleImageComplete", MapsKt.mapOf(new Pair[]{TuplesKt.to("traceID", this.f571342b), TuplesKt.to("traceId", this.f571342b), TuplesKt.to("fileIndex", r100.f191952b), TuplesKt.to("uri", r100.f191951a), TuplesKt.to("metaInfo", r110)}));
        }

        @Override // zd7.b
        public final void a(Long r100, String r101) {
            CompletionBlock<yd7.j.h> r102 = this.f571341a;
            XBaseModel r103 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.j.h.class));
            yd7.j.h r104 = (yd7.j.h) r103;
            r104.setTraceId(this.f571342b);
            yd7.j.d r105 = (yd7.j.d) ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.j.d.class));
            r105.setErrorCode(r100);
            r105.setErrorMessage(r101);
            r104.setErrorInfo(r105);
            Unit r106 = Unit.INSTANCE;
            r102.onFailure(-7, "upload cancelled", (XBaseResultModel) r103);
        }

        @Override // zd7.b
        public final void c(Integer r100, long r101) {
            this.f571344d.sendEvent("uploadImagesToImageXProgress", MapsKt.mapOf(new Pair[]{TuplesKt.to("traceID", this.f571342b), TuplesKt.to("traceId", this.f571342b), TuplesKt.to("fileIndex", r100), TuplesKt.to("progress", Float.valueOf(r101 / 100))}));
        }

        @Override // zd7.b
        public final void e(Long r100, String r101) {
            CompletionBlock<yd7.j.h> r102 = this.f571341a;
            XBaseModel r103 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.j.h.class));
            yd7.j.h r104 = (yd7.j.h) r103;
            r104.setTraceId(this.f571342b);
            yd7.j.d r105 = (yd7.j.d) ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.j.d.class));
            r105.setErrorCode(r100);
            r105.setErrorMessage(r101);
            r104.setErrorInfo(r105);
            Unit r106 = Unit.INSTANCE;
            r102.onFailure(0, "upload failed", (XBaseResultModel) r103);
        }

        @Override // zd7.b
        public final void d(Exception r100, Long r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "e");
            CompletionBlock<yd7.j.h> r103 = this.f571341a;
            String r104 = "some exception happened: " + r100.getMessage() + "; metaInfo : " + r102;
            XBaseModel r105 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.j.h.class));
            yd7.j.h r106 = (yd7.j.h) r105;
            r106.setTraceId(this.f571342b);
            yd7.j.d r107 = (yd7.j.d) ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.j.d.class));
            r107.setErrorCode(r101);
            r107.setErrorMessage(r102);
            r106.setErrorInfo(r107);
            Unit r108 = Unit.INSTANCE;
            r103.onFailure(0, r104, (XBaseResultModel) r105);
        }

        public b(CompletionBlock<yd7.j.h> r100, String r101, Ref.ObjectRef<ArrayList<yd7.j.e>> r102, IBDXBridgeContext r103) {
            this.f571341a = r100;
            this.f571342b = r101;
            this.f571343c = r102;
            this.f571344d = r103;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        XBaseRuntime.f270095a.getClass();
        IHostMediaDependV2 r100 = XBaseRuntime.f270098d;
        if (r100 == null) goto L6;
        r100.closeImageXUpload();
        return;
    }

    public d0() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        yd7.j.g r100 = (yd7.j.g) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r101 = r110.getOwnerActivity();
        if (r101 != null) goto L6;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
    L50:
        return;
    L6:
        Activity r102 = com.bytedance.sdk.xbridge.cn.utils.k.f270262a.getActivity(r101);
        if (r102 != null) goto L10;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "context can not convert to activity", null, 4, null);
        goto L50
    L10:
        if (r100.getFilePaths().isEmpty() == false) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "filePaths is empty", null, 4, null);
        goto L50
    L12:
        String r103 = r100.getMainNetworkType();
        boolean r104 = true;
        boolean r105 = false;
        if (r103 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == false) goto L21;
        r100.setMainNetworkType(TrafficMetrics.FRPM_TTNET);
    L21:
        ae7.a r107 = ae7.a.f3109a;
        List<String> r108 = r100.getFilePaths();
        r107.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r108, "filePaths");
        Iterator<T> r109 = r108.iterator();
    L23:
        if (r109.hasNext() == false) goto L27;
        String r113 = (String) r109.next();
        ae7.a.f3109a.getClass();
        if (ae7.a.e(r101, r113) == true) goto L23;
        r104 = false;
    L27:
        if (r104 == true) goto L29;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "file does not exist", null, 4, null);
        goto L50
    L29:
        IHostPermissionDepend r114 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r114 == null) goto L32;
        String[] r115 = ae7.h.e();
        r105 = r114.isPermissionAllGranted(r102, (String[]) Arrays.copyOf(r115, r115.length));
    L32:
        if (r105 == true) goto L42;
        ae7.a r116 = ae7.a.f3109a;
        List<String> r117 = r100.getFilePaths();
        r116.getClass();
        if (ae7.a.c(r101, r117) == true) goto L42;
        IHostPermissionDepend r118 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r118 == null) goto L39;
        String r119 = this.f567341a;
        String[] r120 = ae7.h.e();
        r118.requestPermission(r102, r110, r119, (String[]) Arrays.copyOf(r120, r120.length), new c0(r101, r100, r112, this, r110));
        Unit r121 = Unit.INSTANCE;
    L40:
        if (r121 != null) goto L51;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "uploadFileDepend is null", null, 4, null);
        return;
    L51:
        return;
    L39:
        r121 = null;
    L42:
        ae7.a r122 = ae7.a.f3109a;
        List<String> r123 = r100.getFilePaths();
        r122.getClass();
        ArrayList<String> r124 = ae7.a.b(r101, r123);
        if (r124.size() == r100.getFilePaths().size()) goto L45;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "get absolute file path failed, please check it", null, 4, null);
        return;
    L45:
        a(r110, r101, r124, r100, r112);
        return;
    L15:
        if (r103.length() == 0) goto L18;
        r106 = false;
        goto L19
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.util.ArrayList] */
    public final void a(IBDXBridgeContext r110, Context r111, ArrayList<String> r112, yd7.j.g r113, CompletionBlock<yd7.j.h> r114) {
        Iterator<String> r100 = r112.iterator();
    L3:
        Unit r101 = null;
        com.bytedance.ies.argus.bean.i r102 = null;
        if (r100.hasNext() == false) goto L16;
        String r103 = r100.next();
        Lazy<ArgusGlobalDelegate> r104 = ArgusGlobalDelegate.f245624c;
        ArgusGlobalDelegate r105 = ArgusGlobalDelegate.a.a();
        if (r105 == null) goto L8;
        r102 = r105.b(new com.bytedance.ies.argus.api.params.b(r103, "x.uploadImagesToImageX"));
    L8:
        if (r102 == null) goto L12;
        boolean r106 = true;
        if (r102.c() != true) goto L12;
    L13:
        if (r106 == false) goto L3;
        CompletionBlock.DefaultImpls.onFailure$default(r114, 0, "file path " + r103 + " contains sensitive content, can not upload.", null, 4, null);
        return;
    L12:
        r106 = false;
        goto L13
    L16:
        yd7.j.f r107 = r113.getUploadConfig();
        if (r107 == null) goto L20;
        String r108 = r107.getTraceId();
        if (r108 == null) goto L20;
    L21:
        Ref.ObjectRef r109 = new Ref.ObjectRef();
        r109.element = new ArrayList();
        b r115 = new b(r114, r108, r109, r110);
        a r116 = new a(r108, r112, this);
        XBaseRuntime.f270095a.getClass();
        IHostMediaDependV2 r117 = XBaseRuntime.f270098d;
        if (r117 == null) goto L24;
        r117.startImageXUpload(r111, r113, r116, r115);
        r101 = Unit.INSTANCE;
    L24:
        if (r101 != null) goto L32;
        CompletionBlock.DefaultImpls.onFailure$default(r114, 0, "hostMediaDepend is null", null, 4, null);
        return;
    L32:
        return;
    L20:
        r108 = "bridge_" + UUID.randomUUID();
        goto L21
    }
}
