package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.api.params.PrefetchType;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.pia.core.metrics.ErrorType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class InternalConfigLoader implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InternalConfigLoader f247498a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f247499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f247500b;

        public a(Uri r100, String r101) {
            this.f247499a = r100;
            this.f247500b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.a("异步更新配置");     // Catch: Throwable -> L4
            InternalConfigLoader r100 = InternalConfigLoader.f247498a;     // Catch: Throwable -> L4
            InternalConfigLoader.b(this.f247499a, this.f247500b);     // Catch: Throwable -> L4
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
        f247498a = new InternalConfigLoader();
    }

    public InternalConfigLoader() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
    public static h b(final Uri r110, final String r111) {
        final String r100 = a36.b.a(r110, r111);
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = a36.b.e(r110, "prefetch_channel");
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = a36.b.e(r110, "prefetch_bundle");
        CharSequence r103 = (CharSequence) r101.element;
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L10:
        if (r105 == true) goto L19;
        CharSequence r106 = (CharSequence) r102.element;
        if (r106 != null) goto L14;
    L17:
        boolean r107 = true;
    L18:
        if (r107 == true) goto L19;
    L30:
        final String r108 = a36.b.e(r110, "prefetch_ak");
        k.a(new InternalConfigLoader$loadConfigFromRL$1(r100, r101, r102, r108));
        v26.l r109 = new v26.l();
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r109.f552701d = r111;
        Intrinsics.checkNotNullParameter(ErrorType.PREFETCH, "<set-?>");
        r109.f552711n = ErrorType.PREFETCH;
        r109.f552702e = 3500;
        r109.f552703f = 0;
        if (Intrinsics.areEqual(a36.b.e(r110, "prefetch_res_from"), "disable_cdn") == false) goto L34;
        v26.a r112 = new v26.a(false);
        r112.f552675e = CollectionsKt.mutableListOf(new Class[]{CDNLoader.class});
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r109.f552699b = r112;
    L34:
        if (r100 != null) goto L110;
    L36:
        String r113 = (String) r101.element;     // Catch: Throwable -> L45
        if (r113 == null) goto L39;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");     // Catch: Throwable -> L45
        r109.f552705h = r113;     // Catch: Throwable -> L45
    L39:
        String r114 = (String) r102.element;     // Catch: Throwable -> L45
        if (r114 == null) goto L42;
        String r115 = c.a(r114, "prefetch.json");     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r115, "<set-?>");     // Catch: Throwable -> L45
        r109.f552706i = r115;     // Catch: Throwable -> L45
    L42:
        if (r108 == null) goto L47;
        Intrinsics.checkNotNullParameter(r108, "<set-?>");     // Catch: Throwable -> L45
        r109.f552698a = r108;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        int r116 = j.f247548a;
        j.b("Prefetch resourceloader 配置创建失败: " + th.getMessage());
    L47:
        String r117 = "";
        d1 r118 = com.bytedance.ies.bullet.kit.resourceloader.i.b(r111, 2).h("", r109);
        if (r118 != null) goto L51;
        int r119 = j.f247548a;
        j.b("Prefetch配置加载失败, url可能不合法: " + r110);
        return null;
    L51:
        Lazy<ArgusGlobalDelegate> r120 = ArgusGlobalDelegate.f245624c;
        ArgusGlobalDelegate r121 = ArgusGlobalDelegate.a.a();
        if (r121 != null) goto L54;
    L57:
        InputStream r122 = r118.c();
        if (r122 == null) goto L64;
        r117 = new String(ByteStreamsKt.readBytes(r122), Charsets.UTF_8);     // Catch: Throwable -> L62
    L64:
        if (r117.length() != 0) goto L66;
        boolean r123 = true;
    L67:
        if (r123 == false) goto L70;
        int r124 = j.f247548a;
        j.b("Prefetch配置加载失败: " + r118.f247869l + '-' + r118.f247873p);
        return null;
    L70:
        Intrinsics.checkNotNullParameter(r117, "<this>");
        final h r125 = new h(new JSONObject(r117));     // Catch: Exception -> L73
    L75:
        if (r125 == null) goto L107;
        List<t> r126 = r125.f247546c;
        if (r126 != null) goto L79;
    L82:
        boolean r127 = true;
    L83:
        if (r127 == false) goto L85;
        j.b("apis为空");
    L103:
        r104 = false;
    L104:
        if (r104 == false) goto L107;
        String r128 = r118.a();
        Intrinsics.checkNotNullParameter(r128, "<set-?>");
        r125.f247545b = r128;
        a0 r129 = a0.f247513a;
        Runnable r130 = new InternalConfigLoader$loadConfigFromRL$2(r110, r125, r111);
        Intrinsics.checkNotNullParameter(r130, "runnable");
        a0.f247515c.execute(r130);
        return r125;
    L85:
        Iterator r131 = ((ArrayList) r125.f247546c).iterator();
    L87:
        if (r131.hasNext() == false) goto L104;
        t r132 = (t) r131.next();
        String r133 = r132.f247584a;
        if (r133 != null) goto L91;
    L94:
        boolean r134 = true;
    L95:
        if (r134 == false) goto L98;
        j.b("url为空");
    L100:
        boolean r135 = false;
    L102:
        if (r135 == true) goto L87;
    L98:
        if (i.a(r132.f247585b) == true) goto L101;
        int r136 = j.f247548a;
        j.b("不支持的请求类型: " + r132.f247585b);
        goto L100
    L101:
        r135 = true;
        goto L102
    L91:
        if (r133.length() == 0) goto L94;
        r134 = false;
        goto L95
    L79:
        if (((ArrayList) r126).isEmpty() == true) goto L82;
        r127 = false;
    L107:
        return null;
    L73:
        e = move-exception;
        int r137 = j.f247548a;
        j.b("Prefetch配置解析失败: " + e.getMessage() + "，json: " + r117);
        r125 = null;
        goto L75
    L66:
        r123 = false;
        goto L67
    L54:
        if (r121.a(new com.bytedance.ies.argus.api.params.a0(r118.E, r118.f247878u, r118.f247879v, PrefetchType.PrefetchV2)).d() == true) goto L57;
        int r138 = j.f247548a;
        j.b("disable prefetch for security reason by Argus. prefetch.json url: " + r118.E);
        return null;
    L110:
        r109.c(c.b(r100, "prefetch.json"));     // Catch: Throwable -> L45
        goto L36
    L14:
        if (r106.length() == 0) goto L17;
        r107 = false;
    L19:
        a26.a r139 = com.bytedance.ies.bullet.kit.resourceloader.i.b(r111, 2).i(r100);
        if (r139 == null) goto L23;
        String r140 = r139.a();
        T r141 = r140;
        if (r140 == null) goto L23;
    L24:
        r101.element = r141;
        if (r139 == null) goto L28;
        String r142 = r139.b();
        T r143 = r142;
        if (r142 == null) goto L28;
    L29:
        r102.element = r143;
    L28:
        r143 = a36.b.e(r110, "bundle");
    L23:
        r141 = a36.b.e(r110, "channel");
        goto L24
    L5:
        if (r103.length() == 0) goto L8;
        r105 = false;
        goto L10
    }

    @Override // com.bytedance.ies.bullet.prefetchv2.b
    public final h a(Uri r100, String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "pageUri");
        Intrinsics.checkNotNullParameter(r101, "targetBid");
        if (com.bytedance.ies.bullet.core.h.f246501h.f246502a == true) goto L5;
    L8:
        if (r102 == null) goto L11;
        com.bytedance.ies.bullet.prefetchv2.a r103 = com.bytedance.ies.bullet.prefetchv2.a.f247510a;
        final h r104 = com.bytedance.ies.bullet.prefetchv2.a.b(r102);
        if (r104 == null) goto L11;
    L12:
        int r105 = j.f247548a;
        j.a("configCache: " + r104);
        if (r104 == null) goto L17;
        Intrinsics.checkNotNullParameter("memory", "<set-?>");
        r104.f247545b = "memory";
        k.a(new InternalConfigLoader$loadConfig$1$1(r104, r102));
        a0 r106 = a0.f247513a;
        a r107 = new a(r100, r101);
        Intrinsics.checkNotNullParameter(r107, "runnable");
        a0.f247515c.execute(r107);
        return r104;
    L17:
        return b(r100, r101);
    L11:
        r104 = com.bytedance.ies.bullet.prefetchv2.a.f247510a.a(r100);
        goto L12
    L5:
        if (Intrinsics.areEqual(w36.a.a(r100, "__dev"), "1") == false) goto L8;
        return b(r100, r101);
    }
}
