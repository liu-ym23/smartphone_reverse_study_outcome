package zd7;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.anniex.ability.service.IAnnieXCustomActivityService;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.chooseAndUpload")
public final class f extends yd7.b {

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yd7.b.e f571345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f571346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap<String, File> f571347c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f571348d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<yd7.b.f> f571349e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ List<re7.d.a> f571350f;

        public static final class a implements te7.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CompletionBlock<yd7.b.f> f571351a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f571352b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ List<re7.d.a> f571353c;

            public a(CompletionBlock<yd7.b.f> r100, f r101, List<re7.d.a> r102) {
                this.f571351a = r100;
                this.f571352b = r101;
                this.f571353c = r102;
            }

            @Override // te7.a
            public final void a(JSONObject r110, LinkedHashMap<String, String> r111, Integer r112, int r113) {
                Intrinsics.checkNotNullParameter(r110, ContainerPosition.BODY);
                Intrinsics.checkNotNullParameter(r111, "responseHeader");
                if (r112 != null) goto L31;
                int r114 = -1;
            L8:
                Gson r115 = te7.c.f545587a;     // Catch: Throwable -> L5
                ae7.b r116 = ((ae7.g) te7.c.a(r110.toString(), ae7.g.class)).a();     // Catch: Throwable -> L5
                if (r116 == null) goto L11;
                List<String> r117 = r116.b();     // Catch: Throwable -> L5
            L12:
                CompletionBlock<yd7.b.f> r100 = this.f571351a;     // Catch: Throwable -> L5
                XBaseModel r101 = ne7.e.b(yd7.b.f.class);     // Catch: Throwable -> L5
                List<re7.d.a> r102 = this.f571353c;     // Catch: Throwable -> L5
                yd7.b.f r103 = (yd7.b.f) r101;     // Catch: Throwable -> L5
                r103.setClientCode(1);     // Catch: Throwable -> L5
                List<re7.d.a> r104 = r102;     // Catch: Throwable -> L5
                ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));     // Catch: Throwable -> L5
                Iterator<T> r106 = r104.iterator();     // Catch: Throwable -> L5
            L14:
                if (r106.hasNext() == false) goto L16;
                re7.d.a r107 = (re7.d.a) r106.next();     // Catch: Throwable -> L5
                XBaseModel r108 = ne7.e.b(yd7.b.c.class);     // Catch: Throwable -> L5
                yd7.b.c r109 = (yd7.b.c) r108;     // Catch: Throwable -> L5
                r109.setPath(r107.f537445a);     // Catch: Throwable -> L5
                r109.setSize(Long.valueOf(r107.f537446b));     // Catch: Throwable -> L5
                r109.setMimeType("image/png");     // Catch: Throwable -> L5
                r109.setMediaType(r107.f537447c);     // Catch: Throwable -> L5
                r109.setBase64Data(r107.f537448d);     // Catch: Throwable -> L5
                r105.add((yd7.b.c) r108);     // Catch: Throwable -> L5
                goto L14
            L16:
                if (r117 == null) goto L20;
                int r118 = RangesKt.coerceAtMost(r105.size(), r117.size());     // Catch: Throwable -> L5
                int r119 = 0;
            L18:
                if (r119 >= r118) goto L20;
                ((yd7.b.c) ListProtector.get(r105, r119)).setUrl((String) ListProtector.get(r117, r119));     // Catch: Throwable -> L5
                r119 = r119 + 1;     // Catch: Throwable -> L5
            L20:
                r103.setHttpCode(Integer.valueOf(r114));     // Catch: Throwable -> L5
                r103.setClientCode(Integer.valueOf(r113));     // Catch: Throwable -> L5
                r103.setTempFiles(r105);     // Catch: Throwable -> L5
                LinkedHashMap r120 = new LinkedHashMap();     // Catch: Throwable -> L5
                Iterator<String> r121 = r110.keys();     // Catch: Throwable -> L5
            L22:
                if (r121.hasNext() == false) goto L24;
                String r122 = r121.next();     // Catch: Throwable -> L5
                r120.put(r122, r110.get(r122));     // Catch: Throwable -> L5
                goto L22
            L24:
                r103.setResponse(r120);     // Catch: Throwable -> L5
                CompletionBlock.DefaultImpls.onSuccess$default(r100, (XBaseResultModel) r101, null, 2, null);     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                CompletionBlock<yd7.b.f> r123 = this.f571351a;
                String r124 = th.getMessage();
                if (r124 != null) goto L29;
                r124 = "";
            L29:
                CompletionBlock.DefaultImpls.onFailure$default(r123, 0, r124, null, 4, null);
                String r125 = this.f571352b.f567317a;
                return;
            L11:
                r117 = null;
                goto L12
            L31:
                r114 = r112.intValue();     // Catch: Throwable -> L5
                goto L8
            }

            @Override // te7.a
            public final void c(Integer r100, LinkedHashMap<String, String> r101, Throwable r110, int r111) {
                Intrinsics.checkNotNullParameter(r110, LynxError.LYNX_THROWABLE);
                if ((r110 instanceof NetworkNotAvailabeException) == false) goto L5;
                int r102 = -1001;
            L6:
                CompletionBlock<yd7.b.f> r103 = this.f571351a;
                String r104 = r110.getMessage();
                if (r104 != null) goto L9;
                r104 = "";
            L9:
                XBaseModel r105 = ne7.e.b(yd7.b.f.class);
                yd7.b.f r106 = (yd7.b.f) r105;
                int r107 = -408;
                if (r100 == null) goto L12;
                Integer r108 = r100;
            L13:
                r106.setHttpCode(r108);
                r106.setClientCode(Integer.valueOf(r111));
                LinkedHashMap r112 = new LinkedHashMap();
                if (r100 == null) goto L16;
                r107 = r100.intValue();
            L16:
                r112.put("errCode", Integer.valueOf(r107));
                String r109 = r110.getMessage();
                if (r109 != null) goto L19;
                r109 = "";
            L19:
                r112.put("message", r109);
                r112.put("prompts", "");
                r106.setResponse(r112);
                Unit r113 = Unit.INSTANCE;
                r103.onFailure(r102, r104, (XBaseResultModel) r105);
                return;
            L12:
                r108 = -408;
                goto L13
            L5:
                r102 = 0;
                goto L6
            }

            @Override // te7.a
            public final Unit b(JSONObject r100, LinkedHashMap<String, String> r101, String r102, Throwable r103, Integer r104, int r105) {
                te7.a.C7714a.a(r100, r101, r102, r103);
                return null;
            }
        }

        public b(yd7.b.e r100, IBDXBridgeContext r101, LinkedHashMap<String, File> r102, f r103, CompletionBlock<yd7.b.f> r104, List<re7.d.a> r105) {
            this.f571345a = r100;
            this.f571346b = r101;
            this.f571347c = r102;
            this.f571348d = r103;
            this.f571349e = r104;
            this.f571350f = r105;
        }

        public final void a() {
            te7.e r100 = te7.e.f545589a;
            Map<String, Object> r101 = this.f571345a.getHeader();
            r100.getClass();
            LinkedHashMap r102 = te7.e.f(r101);
            Map r103 = te7.e.c(this.f571345a.getParams());
            te7.e.b(r102, this.f571346b);
            a r104 = new a(this.f571349e, this.f571348d, this.f571350f);
            String r105 = this.f571345a.getUrl();
            LinkedHashMap<String, File> r106 = this.f571347c;
            f r107 = this.f571348d;
            IBDXBridgeContext r108 = this.f571346b;
            r107.getClass();
            if (((XBaseRuntime) r108.getService(XBaseRuntime.class)) == null) goto L6;
            IHostNetworkDepend r109 = XBaseRuntime.f270104j;
            if (r109 == null) goto L6;
        L9:
            te7.e.s(r100, r105, r102, r106, r103, r104, r109, this.f571345a.getNeedCommonParams(), 128);
            return;
        L6:
            XBaseRuntime.f270095a.getClass();
            r109 = XBaseRuntime.f270104j;
            if (r109 != null) goto L9;
            r109 = new te7.g();
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public f() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        yd7.b.e r113 = (yd7.b.e) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r100 = r110.getOwnerActivity();
        if (r100 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        int r101 = r113.getMaxCount().intValue();
        if (r101 != 0) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "maxCount can not be 0", null, 4, null);
        return;
    L8:
        List<String> r102 = r113.getMediaType();
        String r103 = r113.getSourceType();
        Boolean r104 = Boolean.valueOf(r113.getSaveToPhotoAlbum());
        String r105 = r113.getCameraType();
        if (r105 != null) goto L11;
        r105 = "back";
    L11:
        String r106 = r105;
        yd7.b.InterfaceC8329b r107 = r113.getImageParams();
        if (r107 == null) goto L14;
        r107.getCropWidth();
    L14:
        yd7.b.InterfaceC8329b r108 = r113.getImageParams();
        if (r108 == null) goto L17;
        r108.getCropWidth();
    L17:
        yd7.b.InterfaceC8329b r109 = r113.getImageParams();
        if (r109 == null) goto L22;
        Number r114 = r109.getCompressMaxSize();
        if (r114 == null) goto L22;
        r114.intValue();
    L22:
        yd7.b.d r115 = r113.getVideoParams();
        if (r115 == null) goto L27;
        Number r116 = r115.getDurationLimit();
        if (r116 == null) goto L27;
        r116.intValue();
    L27:
        re7.c r117 = new re7.c(r102, r103, r101, Boolean.FALSE, r104, r106, false, 0, 0);
        r117.f537443g = r113.getNeedBase64Data();
        g r118 = new g(this, r110, r113, r112);
        IAnnieXCustomActivityService r119 = (IAnnieXCustomActivityService) r110.getService(IAnnieXCustomActivityService.class);
        if (r119 == null) goto L31;
        r119.i();
    L31:
        if (((XBaseRuntime) r110.getService(XBaseRuntime.class)) == null) goto L34;
        IHostMediaDepend r120 = XBaseRuntime.f270097c;
        if (r120 == null) goto L34;
    L35:
        if (r120 == null) goto L37;
        r120.handleJsInvoke(r100, r117, r118);
        Unit r121 = Unit.INSTANCE;
    L38:
        if (r121 != null) goto L43;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "hostMediaDepend is null", null, 4, null);
        return;
    L43:
        return;
    L37:
        r121 = null;
    L34:
        XBaseRuntime.f270095a.getClass();
        r120 = XBaseRuntime.f270097c;
        goto L35
    }

    public final void a(IBDXBridgeContext r110, Context r111, List<re7.d.a> r112, yd7.b.e r113, CompletionBlock<yd7.b.f> r210) {
        if ((!r112.isEmpty()) == false) goto L39;
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator<T> r101 = r112.iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L38;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        String r105 = ((re7.d.a) r103).f537445a;
        if (r105 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L19;
        CompletionBlock.DefaultImpls.onFailure$default(r210, -3, "The file path should not be empty.The key is filePath", null, 4, null);
    L34:
        PolarisFileWrapper r107 = null;
    L35:
        if (r107 == null) goto L40;
        r100.put("file", r107);
        r102 = r104;
    L40:
        LinkedHashMap r108 = null;
    L41:
        if (r108 != null) goto L44;
        return;
    L44:
        if (((XBaseRuntime) r110.getService(XBaseRuntime.class)) == null) goto L48;
        IHostThreadPoolExecutorDepend r109 = XBaseRuntime.f270109o;
        if (r109 != null) goto L51;
        r109 = new qe7.d();
    L51:
        ExecutorService r114 = r109.getNormalThreadExecutor();
        if (r114 != null) goto L55;
        r114 = TTExecutors.getNormalExecutor();
    L55:
        r114.execute(new b(r113, r110, r108, this, r210, r112));
        return;
    L48:
        XBaseRuntime.f270095a.getClass();
        r109 = XBaseRuntime.f270109o;
        if (r109 != null) goto L51;
        r109 = new qe7.d();
        goto L51
    L19:
        ae7.a.f3109a.getClass();
        String r115 = ae7.a.a(r111, r105);
        if (r115 != null) goto L22;
    L25:
        boolean r116 = true;
    L26:
        if (r116 == false) goto L28;
        CompletionBlock.DefaultImpls.onFailure$default(r210, -9, "File is not exist.The key is filePath", null, 4, null);
        goto L34
    L28:
        r107 = new PolarisFileWrapper(r115);
        if (r107.exists() == true) goto L32;
        CompletionBlock.DefaultImpls.onFailure$default(r210, -9, "File is not exist.The key is filePath", null, 4, null);
        goto L34
    L32:
        if (r107.isFile() == true) goto L35;
        CompletionBlock.DefaultImpls.onFailure$default(r210, -9, "File is not file.The key is filePath", null, 4, null);
        goto L34
    L22:
        if (r115.length() == 0) goto L25;
        r116 = false;
        goto L26
    L13:
        if (r105.length() == 0) goto L16;
        r106 = false;
        goto L17
    L38:
        r108 = r100;
        goto L41
    L39:
        CompletionBlock.DefaultImpls.onFailure$default(r210, -3, "filePath or formDataBody can not be null.", null, 4, null);
        goto L40
    }
}
