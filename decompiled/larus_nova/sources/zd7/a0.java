package zd7;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.image.entity.LoadParams;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.uploadImage")
public final class a0 extends yd7.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f571321d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yd7.i.c f571322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f571323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap<String, File> f571324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<yd7.i.d> f571325d;

        /* JADX INFO: renamed from: zd7.a0$a$a, reason: collision with other inner class name */
        public static final class C8443a implements te7.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CompletionBlock<yd7.i.d> f571326a;

            public C8443a(CompletionBlock<yd7.i.d> r100) {
                this.f571326a = r100;
            }

            @Override // te7.a
            public final void a(JSONObject r100, LinkedHashMap<String, String> r101, Integer r102, int r110) {
                Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
                Intrinsics.checkNotNullParameter(r101, "responseHeader");
                Gson r103 = te7.c.f545587a;     // Catch: Throwable -> L32
                ae7.b r104 = ((ae7.g) te7.c.a(r100.toString(), ae7.g.class)).a();     // Catch: Throwable -> L32
                if (r104 == null) goto L7;
                List<String> r111 = r104.b();     // Catch: Throwable -> L32
                if (r111 == null) goto L7;
            L8:
                CompletionBlock<yd7.i.d> r105 = this.f571326a;     // Catch: Throwable -> L32
                XBaseModel r106 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.i.d.class));     // Catch: Throwable -> L32
                yd7.i.d r107 = (yd7.i.d) r106;     // Catch: Throwable -> L32
                boolean r108 = true;
                if ((!r111.isEmpty()) == false) goto L11;
                String r112 = (String) ListProtector.get(r111, 0);     // Catch: Throwable -> L32
            L12:
                r107.setUrl(r112);     // Catch: Throwable -> L32
                Map<String, Map<Class<?>, Object>> r113 = x26.a.f562251a;     // Catch: Throwable -> L32
                w26.g r114 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L32
                if (r114 == null) goto L20;
                w26.e r115 = (w26.e) r114.n0(w26.e.class);     // Catch: Throwable -> L32
                if (r115 == null) goto L20;
                Boolean r116 = r115.Q1();     // Catch: Throwable -> L32
                if (r116 == null) goto L20;
                r108 = r116.booleanValue();     // Catch: Throwable -> L32
            L20:
                if (r108 == false) goto L25;
                if (r104 == null) goto L23;
                String r109 = r104.a();     // Catch: Throwable -> L32
            L24:
                String r117 = String.valueOf(r109);     // Catch: Throwable -> L32
            L26:
                r107.setUri(r117);     // Catch: Throwable -> L32
                LinkedHashMap r118 = new LinkedHashMap();     // Catch: Throwable -> L32
                Iterator<String> r119 = r100.keys();     // Catch: Throwable -> L32
            L28:
                if (r119.hasNext() == false) goto L30;
                String r120 = r119.next();     // Catch: Throwable -> L32
                r118.put(r120, r100.get(r120));     // Catch: Throwable -> L32
                goto L28
            L30:
                r107.setResponse(r118);     // Catch: Throwable -> L32
                CompletionBlock.DefaultImpls.onSuccess$default(r105, (XBaseResultModel) r106, null, 2, null);     // Catch: Throwable -> L32
                return;
            L23:
                r109 = null;
                goto L24
            L25:
                r117 = String.valueOf(r104);     // Catch: Throwable -> L32
                goto L26
            L11:
                r112 = "";
            L7:
                r111 = new ArrayList();     // Catch: Throwable -> L32
            L32:
                th = move-exception;
                CompletionBlock<yd7.i.d> r121 = this.f571326a;
                String r122 = th.getMessage();
                if (r122 != null) goto L36;
                String r123 = "";
            L37:
                CompletionBlock.DefaultImpls.onFailure$default(r121, 0, r123, null, 4, null);
                id7.c.a("parse post response body failed " + th.getMessage());
                return;
            L36:
                r123 = r122;
                goto L37
            }

            @Override // te7.a
            public final void c(Integer r100, LinkedHashMap<String, String> r101, Throwable r102, int r110) {
                Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
                CompletionBlock<yd7.i.d> r103 = this.f571326a;
                String r104 = r102.getMessage();
                if (r104 != null) goto L5;
                r104 = "";
            L5:
                CompletionBlock.DefaultImpls.onFailure$default(r103, 0, r104, null, 4, null);
            }

            @Override // te7.a
            public final Unit b(JSONObject r100, LinkedHashMap<String, String> r101, String r102, Throwable r103, Integer r104, int r105) {
                te7.a.C7714a.a(r100, r101, r102, r103);
                return null;
            }
        }

        public a(yd7.i.c r100, IBDXBridgeContext r101, LinkedHashMap<String, File> r102, CompletionBlock<yd7.i.d> r103) {
            this.f571322a = r100;
            this.f571323b = r101;
            this.f571324c = r102;
            this.f571325d = r103;
        }

        public final void a() {
            te7.e r100 = te7.e.f545589a;
            Map<String, Object> r101 = this.f571322a.getHeader();
            r100.getClass();
            LinkedHashMap r102 = te7.e.f(r101);
            Map r103 = te7.e.c(this.f571322a.getParams());
            te7.e.b(r102, this.f571323b);
            C8443a r104 = new C8443a(this.f571325d);
            String r105 = this.f571322a.getUrl();
            LinkedHashMap<String, File> r106 = this.f571324c;
            int r107 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
            te7.e.s(r100, r105, r102, r106, r103, r104, com.bytedance.sdk.xbridge.cn.utils.g.d(), false, 192);
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

    public a0() {
        new String[]{"jpg", LoadParams.ImageFormat.JPEG, LoadParams.ImageFormat.PNG, "gif", "bmp", "webp"};
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        yd7.i.c r100 = (yd7.i.c) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r101 = r110.getOwnerActivity();
        if (r101 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        Activity r102 = com.bytedance.sdk.xbridge.cn.utils.k.f270262a.getActivity(r101);
        if (r102 != null) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "context can not convert to activity", null, 4, null);
        return;
    L8:
        ae7.a r103 = ae7.a.f3109a;
        String r104 = r100.getFilePath();
        r103.getClass();
        if (ae7.a.e(r101, r104) == true) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "file does not exist", null, 4, null);
        return;
    L11:
        IHostPermissionDepend r105 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r105 == null) goto L14;
        String[] r106 = ae7.h.e();
        boolean r107 = r105.isPermissionAllGranted(r102, (String[]) Arrays.copyOf(r106, r106.length));
    L15:
        this.f571321d = r107;
        if (r107 == false) goto L18;
    L26:
        b(r110, r101, r100, r112);
        return;
    L18:
        if (ae7.a.d(r101, r100.getFilePath()) == true) goto L26;
        IHostPermissionDepend r113 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r113 == null) goto L23;
        String r114 = this.f567338a;
        String[] r108 = ae7.h.e();
        r113.requestPermission(r102, r110, r114, (String[]) Arrays.copyOf(r108, r108.length), new z(this, r110, r101, r100, r112));
        Unit r109 = Unit.INSTANCE;
    L24:
        if (r109 != null) goto L31;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "uploadImageDepend is null", null, 4, null);
        return;
    L31:
        return;
    L23:
        r109 = null;
        goto L24
    L14:
        r107 = false;
        goto L15
    }

    public final File a(Context r210, String r211, CompletionBlock<yd7.i.d> r212, String r213) {
        boolean r100 = false;
        if (r211 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "The file path should not be empty.The key is " + r213, null, 4, null);
        return null;
    L13:
        ae7.a.f3109a.getClass();
        String r102 = ae7.a.a(r210, r211);
        if (r102 != null) goto L16;
    L19:
        boolean r103 = true;
    L21:
        if (r103 == false) goto L24;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -9, "File is not exist.The key is " + r213, null, 4, null);
        return null;
    L24:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102);
        s26.d r105 = s26.d.f540305c;
        m0 r106 = (m0) s26.d.f540305c.c(m0.class);
        if (r106 == null) goto L28;
        r106.a0();
    L28:
        if (r104.exists() == false) goto L49;
        if (r104.length() == 0) goto L49;
        if (r104.isFile() == true) goto L36;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -9, "File is not file.The key is " + r213, null, 4, null);
        return null;
    L36:
        Lazy<ArgusGlobalDelegate> r107 = ArgusGlobalDelegate.f245624c;
        ArgusGlobalDelegate r108 = ArgusGlobalDelegate.a.a();
        if (r108 == null) goto L39;
        com.bytedance.ies.argus.bean.i r109 = r108.b(new com.bytedance.ies.argus.api.params.b(r102, "x.uploadImage"));
    L40:
        if (r109 != null) goto L42;
    L44:
        if (r100 == false) goto L47;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "file path " + r102 + " contains sensitive content, can not upload.", null, 4, null);
        return null;
    L47:
        return r104;
    L42:
        if (r109.c() != true) goto L44;
        r100 = true;
        goto L44
    L39:
        r109 = null;
    L49:
        if (r104.exists() == false) goto L56;
        if (r104.length() != 0) goto L56;
        if (this.f571321d == true) goto L56;
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, "file.length is 0, permission denied", null, 4, null);
    L57:
        return null;
    L56:
        CompletionBlock.DefaultImpls.onFailure$default(r212, -9, "File is not exist.The key is " + r213, null, 4, null);
        goto L57
    L16:
        if (r102.length() == 0) goto L19;
        r103 = false;
        goto L21
    L5:
        if (r211.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final void b(IBDXBridgeContext r100, Context r101, yd7.i.c r102, CompletionBlock<yd7.i.d> r110) {
        if (r102.getFormDataBody() == null) goto L16;
        List<yd7.i.b> r103 = r102.getFormDataBody();
        Intrinsics.checkNotNull(r103);
        List<yd7.i.b> r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L6:
        if (r106.hasNext() == false) goto L11;
        yd7.i.b r107 = (yd7.i.b) r106.next();
        File r108 = a(r101, r107.getValue(), r110, r107.getKey());
        if (r108 == null) goto L25;
        r105.add(new Pair(r107.getKey(), r108));
    L25:
        LinkedHashMap r109 = null;
    L26:
        if (r109 != null) goto L28;
        return;
    L28:
        com.bytedance.sdk.xbridge.cn.utils.g.a().execute(new a(r102, r100, r109, r110));
        return;
    L11:
        r109 = new LinkedHashMap();
        Iterator r111 = r105.iterator();
    L13:
        if (r111.hasNext() == false) goto L26;
        Pair r112 = (Pair) r111.next();
        r109.put(r112.getFirst(), r112.getSecond());
        goto L13
    L16:
        if (r102.getFilePath().length() <= 0) goto L18;
        boolean r113 = true;
    L19:
        if (r113 == false) goto L24;
        File r114 = a(r101, r102.getFilePath(), r110, "filePath");
        if (r114 == null) goto L25;
        r109 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("file", r114)});
        goto L26
    L24:
        CompletionBlock.DefaultImpls.onFailure$default(r110, -3, "filePath or formDataBody can not be null.", null, 4, null);
        goto L25
    L18:
        r113 = false;
        goto L19
    }
}
