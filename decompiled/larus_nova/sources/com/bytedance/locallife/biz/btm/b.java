package com.bytedance.locallife.biz.btm;

import android.content.Context;
import android.view.View;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.common.utils.j;
import com.bytedance.locallife.host.btm.SaasBtmItem;
import com.bytedance.locallife.host.btm.SaasPageFinder;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Deprecated(message = "此类为旧版本的BTM工具类，已经废弃", replaceWith = @ReplaceWith(expression = "BtmKitV2", imports = {}))
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f256555a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f256556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f256557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SaasBtmItem.SaasBtmItemBuilder f256558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f256559d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f256560e;

        public final JSONObject a() {
            vs6.a r100 = HostServiceUtilsKt.p();
            SaasBtmItem r101 = this.f256558c.build();
            SaasPageFinder r102 = r101.f258857d;
            r102.f258860a = this.f256557b;
            JSONObject r103 = r100.r(r101);
            if (r103.length() != 0) goto L20;
            int r104 = j.f257151a;
            if (j.a(r101.f258857d.f258860a) == false) goto L8;
            int r105 = ErrorUploader.f256554a;
            ErrorUploader.a(this.f256556a, this.f256559d, this.f256560e);
            return r103;
        L8:
            int r106 = b.f256555a;
            String r107 = C3644b.d(r101.f258857d.f258862c);
            if (r107 != null) goto L11;
        L14:
            boolean r108 = true;
        L15:
            if (r108 == false) goto L17;
            int r109 = ErrorUploader.f256554a;
            ErrorUploader.a(this.f256556a, this.f256559d, this.f256560e);
            goto L20
        L17:
            r101.f258857d.f258860a = r107;
            r103 = r100.r(r101);
            if (r103.length() != 0) goto L20;
            int r110 = ErrorUploader.f256554a;
            ErrorUploader.a(this.f256556a, this.f256559d, this.f256560e);
            goto L20
        L11:
            if (r107.length() == 0) goto L14;
            r108 = false;
        L20:
            return r103;
        }

        @Deprecated(message = "根据View来找页面很不靠谱，非常不推荐使用该方式来埋BTM", replaceWith = @ReplaceWith(expression = "withBtmPageId(btmPageId)", imports = {}))
        public final void b(View r100) {
            this.f256559d = r100;
            this.f256558c.withView(r100);
        }

        public a(String r100, Boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "btm");
            this.f256556a = r100;
            this.f256558c = new SaasBtmItem.SaasBtmItemBuilder(r100, r101);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.locallife.biz.btm.b$b, reason: collision with other inner class name */
    public static final class C3644b {
        public final Context getContext() {
            return HostServiceUtilsKt.p().i();
        }

        public C3644b() {
        }

        public static String d(View r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            String r101 = "";
        L6:
            Object r102 = r100.getTag(R.id.poi_toolkit_btm_page_id);
            if ((r102 instanceof String) == false) goto L9;
            r101 = (String) r102;
        L14:
            if (r101.length() != 0) goto L16;
            boolean r103 = true;
        L17:
            if (r103 == false) goto L19;
            if (r100 != null) goto L6;
        L19:
            return r101;
        L16:
            r103 = false;
            goto L17
        L9:
            Object r104 = r100.getParent();
            if ((r104 instanceof View) == false) goto L12;
            r100 = (View) r104;
            goto L14
        L12:
            r100 = null;
            goto L14
        }

        public static void a(Map r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "btmItemBuilder");
            JSONObject r102 = r101.a();
            Iterator<String> r103 = r102.keys();
        L4:
            if (r103.hasNext() == false) goto L6;
            String r104 = r103.next();
            r100.put(r104, r102.optString(r104));
            goto L4
        }

        public static void b(mq6.c r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "btmItemBuilder");
            JSONObject r102 = r101.a();
            Iterator<String> r103 = r102.keys();
        L4:
            if (r103.hasNext() == false) goto L6;
            String r104 = r103.next();
            r100.d(r104, r102.optString(r104));
            goto L4
        }

        public static void e(Object r100, String r101) {
            int r102 = b.f256555a;
            Intrinsics.checkNotNullParameter(r100, "page");
            Intrinsics.checkNotNullParameter(r101, "btm");
            HostServiceUtilsKt.p().s(r100, r101, true);
        }

        public static void f(Object r100, String r101) {
            int r102 = b.f256555a;
            Intrinsics.checkNotNullParameter(r100, "page");
            Intrinsics.checkNotNullParameter(r101, "bitCode");
            HostServiceUtilsKt.p().h(r100, r101, true);
        }

        public static void c(mq6.c r100, View r101, String r102) {
            int r103 = b.f256555a;
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "abcd");
            a r104 = new a(r102, Boolean.FALSE);
            r104.b(r101);
            r104.f256558c.setAddBtmChain(false);
            JSONObject r105 = r104.a();
            Iterator<String> r106 = r105.keys();
        L4:
            if (r106.hasNext() == false) goto L6;
            String r107 = r106.next();
            r100.d(r107, r105.optString(r107));
            goto L4
        }
    }

    static {
        new C3644b();
    }
}
