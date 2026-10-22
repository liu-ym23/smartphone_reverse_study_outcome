package com.bytedance.locallife.live.dsl;

import androidx.lifecycle.MutableLiveData;
import com.alibaba.gaiax.data.assets.GXBinParser;
import com.alibaba.gaiax.template.GXTemplate;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.locallife.common.utils.k;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<String> f259464a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f259465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f259466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f259467c;

        public a(String r100, Ref.ObjectRef<String> r101, JSONObject r102) {
            this.f259465a = r100;
            this.f259466b = r101;
            this.f259467c = r102;
        }

        public final void a() {
            Lazy<GeckoBinarySource> r100 = GeckoBinarySource.f259402d;
            GeckoBinarySource r101 = GeckoBinarySource.a.a();
            String r110 = this.f259465a;
            String r111 = this.f259466b.element;
            JSONObject r112 = this.f259467c;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r110, GXTemplateKey.GAIAX_TEMPLATE_ID);
            Intrinsics.checkNotNullParameter(r111, "version");
            Intrinsics.checkNotNullParameter(r112, "data");
            String r102 = r112.optString(GXTemplateKey.GAIAX_LAYER);
            String r103 = r112.optString(GXTemplateKey.GAIAX_CSS);
            String r104 = r112.optString(GXTemplateKey.GAIAX_DATABINDING);
            String r105 = r112.optString(GXTemplateKey.GAIAX_JS);
            r101.f259403a.put(r110 + r111, new GXTemplate(r110, "live_life_templates", r111, r102, r103, r104, r105));
            GXTemplateInfoSourceDelegate r106 = (GXTemplateInfoSourceDelegate) r101.f259405c.getValue();
            r106.getClass();
            Intrinsics.checkNotNullParameter("live_life_templates", GXTemplateKey.GAIAX_TEMPLATE_BIZ);
            Intrinsics.checkNotNullParameter(r110, GXTemplateKey.GAIAX_TEMPLATE_ID);
            it6.d r107 = r106.f259401a;
            if (r107 == null) goto L6;
            r107.a(r110);
        L6:
            if (r101.f259403a.get(r110 + r111) != null) goto L11;
            Iterator r108 = ((ArrayList) r101.f259404b).iterator();
        L9:
            if (r108.hasNext() == false) goto L15;
            ((GeckoBinarySource.b) r108.next()).a(r110, r111, r112);
            goto L9
        L15:
            return;
        L11:
            Iterator r109 = ((ArrayList) r101.f259404b).iterator();
        L13:
            if (r109.hasNext() == false) goto L18;
            ((GeckoBinarySource.b) r109.next()).b(r110, r111, r112);
            goto L13
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

    public j(List<String> r100) {
        this.f259464a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v4, types: [T, java.lang.String] */
    public final void a() {
        boolean r100 = TemplateLoader.f259411a;
        TemplateLoader.f259411a = true;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = this.f259464a.iterator();
    L3:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L13;
        String r104 = (String) r102.next();
        Ref.ObjectRef r105 = new Ref.ObjectRef();
        r105.element = "-1";
        String r106 = h.b(r104);     // Catch: Exception -> L10
        if (r106 == null) goto L12;
        r105.element = h.c();     // Catch: Exception -> L10
        k.d(new a(r104, r105, GXBinParser.INSTANCE.parser(new PolarisFileWrapper(r106))));     // Catch: Exception -> L10
        LiveLifeSaaSUtil.t().i("TemplateLoader", "加载 " + r104 + " 完成 version:" + ((String) r105.element));     // Catch: Exception -> L10
        r103 = true;
    L12:
        r101.add(new TemplateLoader.a(r104, (String) r105.element, r103));
    L10:
        e = move-exception;
        LiveLifeSaaSUtil.t().e("TemplateLoader", "模板文件加载异常 " + r104 + " version:" + ((String) r105.element), e);
        qv6.e.a("live_life_dsl_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("error_code", "-87"), TuplesKt.to("error_msg", String.valueOf(e.getMessage()))}), true, null);
        goto L12
    L13:
        boolean r107 = TemplateLoader.f259411a;
        TemplateLoader.f259411a = false;
        MutableLiveData<List<TemplateLoader.a>> r108 = TemplateLoader.f259412b;
        if (r108 == null) goto L16;
        r108.postValue(r101);
    L16:
        TemplateLoader.f259412b = null;
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
