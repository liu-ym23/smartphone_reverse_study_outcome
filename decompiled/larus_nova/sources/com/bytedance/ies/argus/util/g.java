package com.bytedance.ies.argus.util;

import com.bytedance.ies.argus.repository.ArgusConfigManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f246257a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f246258b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, Integer> f246259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, Integer> f246260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<String> f246261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<String> f246262d;

        public a() {
        }

        public final boolean a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L60
            List<String> r104 = this.f246262d;     // Catch: Throwable -> L60
            if (r104 == null) goto L12;
            List<String> r105 = r104;     // Catch: Throwable -> L60
            ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));     // Catch: Throwable -> L60
            Iterator<T> r107 = r105.iterator();     // Catch: Throwable -> L60
        L7:
            if (r107.hasNext() == false) goto L12;
            if (CommonUtils.h(r100, (String) r107.next()) == true) goto L10;
            r106.add(Unit.INSTANCE);     // Catch: Throwable -> L60
            goto L7
        L10:
            return false;
        L12:
            if (r101 != null) goto L14;
            r101 = CommonUtils.d(r100);     // Catch: Throwable -> L60
        L14:
            Object r108 = null;
            if (r101 == null) goto L47;
            Map<String, Integer> r109 = this.f246259a;     // Catch: Throwable -> L60
            if (r109 != null) goto L19;
        L21:
            boolean r110 = false;
        L22:
            if (r110 == false) goto L24;
        L46:
            return true;
        L24:
            if (g.f246257a.containsKey(r101) == true) goto L46;
            if (r102 != null) goto L33;
            r102 = CommonUtils.f(r101);     // Catch: Throwable -> L60
            if (r102 != null) goto L33;
            Intrinsics.checkNotNullParameter(r100, "url");     // Catch: Throwable -> L60
            String r111 = CommonUtils.d(r100);     // Catch: Throwable -> L60
            if (r111 == null) goto L32;
            r102 = CommonUtils.f(r111);     // Catch: Throwable -> L60
            goto L33
        L32:
            r102 = null;
        L33:
            if (r102 == null) goto L45;
            Map<String, Integer> r112 = this.f246260b;     // Catch: Throwable -> L60
            if (r112 != null) goto L37;
        L39:
            boolean r113 = false;
        L40:
            if (r113 == false) goto L42;
        L43:
            return true;
        L42:
            if (g.f246258b.containsKey(r102) == false) goto L45;
        L37:
            if (r112.containsKey(r102) != true) goto L39;
            r113 = true;
        L45:
            if (g.a(r101) == false) goto L47;
        L19:
            if (r109.containsKey(r101) != true) goto L21;
            r110 = true;
        L47:
            List<String> r114 = this.f246261c;     // Catch: Throwable -> L60
            if (r114 == null) goto L56;
            Iterator<T> r115 = r114.iterator();     // Catch: Throwable -> L60
        L51:
            if (r115.hasNext() == false) goto L55;
            Object r116 = r115.next();     // Catch: Throwable -> L60
            if (CommonUtils.h(r100, (String) r116) == false) goto L51;
            r108 = r116;
        L55:
            r108 = (String) r108;     // Catch: Throwable -> L60
        L56:
            if (r108 == null) goto L58;
            return true;
        L58:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L60
        L62:
            return false;
        L60:
            th = move-exception;
            Result.Companion r117 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L62
        }
    }

    static {
        List r100 = CollectionsKt.listOf(new String[]{"lf-dy-sourcecdn-tos.bytegecko.com", "lf-ecom-gr-sourcecdn.bytegecko.com", "lf-webcast-gr-sourcecdn.bytegecko.com", "lf-dy-gr-sourcecdn.bytegecko.com", "lf1-cdn-tos.bytegoofy.com", "m.baike.com", "sf1-scmcdn-tos.pstatp.com", "api.amemv.com", "aweme.snssdk.com", "lf3-cdn-tos.bytegoofy.com", "leads.oceanengine.com", "ugh5.cn", "lf1-cdn-tos.bytescm.com", "creator.amemv.com", "alliance.jinritemai.com", "fe.amemv.com", "f-cashloan.snssdk.com", "douplus-fe.amemv.com", "interactive.douyin.com", "api.fanqiesdk.com", "zjsms.com", "lf3-static.bytednsdoc.com"});
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Object r103 = r102.next();
        String r104 = (String) r103;
        r101.put(r103, 1);
        goto L4
    L6:
        f246257a = r101;
        List r105 = CollectionsKt.listOf(new String[]{"bytegecko.com", "douyin.com", "bytegoofy.com", "baike.com", "amemv.com", "snssdk.com", "bytescm.com", "jinritemai.com", "bytedance.com", "toutiaoapi.com", "ecombdpage.com", "baohuaxia.com", "bytesfield.com", "dcdapp.com", "xingtu.cn", "juliangyinqing.com", "douyinhanyu.com", "open-douyin.com", "cluerich.com", "zhuxiaobang.com", "bytednsdoc.com", "xiaohe-jiankang.com", "ulikecam.com", "searchpstatp.com", "scsjsd.com", "dcarstatic.com", "changdunovel.com", "iaoligame.com", "jishitailai.com", "yangyi07.com", "magich5page.com", "xflapp.com", "pipix.com", "draftstatic.com", "xiaohe.cn", "shidianguji.com", "ulpay.com", "retouchpics.com", "bytedance.net", "byteug.com", "dcarapi.com", "byteky.com", "douyinpay.com", "douyinec.com", "huoshan.com", "ixigua.com", "oceancus.com", "moonton.com", "csjdeveloper.com", "fanqienovel.com", "nextvid.net", "iyincaishijiao.com", "editorjianying.com", "shidianhanyu.com", "lifexue.com", "doupay.com", "volcengine.com", "bestv.com.cn", "douyinpay.com", "iesdouyin.com", "xsgtvacct.com"});
        LinkedHashMap r106 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r105, 10)), 16));
        Iterator r107 = r105.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        Object r108 = r107.next();
        String r109 = (String) r108;
        r106.put(r108, 1);
        goto L8
    L10:
        f246258b = r106;
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Lazy<ArgusConfigManager> r101 = ArgusConfigManager.f246083j;
        com.bytedance.ies.argus.repository.f r102 = ArgusConfigManager.a.a().f246085b.f246125e;
        if (r102 == null) goto L5;
        com.bytedance.ies.argus.bean.config.e r103 = r102.f246121b;
    L7:
        if (r103 == null) goto L16;
        List<String> r104 = r103.c();
        if (r104 == null) goto L16;
        if ((!r104.isEmpty()) == true) goto L14;
        r104 = null;
    L14:
        if (r104 == null) goto L16;
    L24:
        List<String> r105 = r104;
        if ((r105 instanceof Collection) == true) goto L27;
    L29:
        Iterator<T> r106 = r105.iterator();
    L31:
        if (r106.hasNext() == false) goto L41;
        String r107 = (String) r106.next();
        if (Intrinsics.areEqual(r100, r107) == false) goto L35;
    L38:
        boolean r108 = true;
    L39:
        if (r108 == false) goto L31;
        return true;
    L35:
        if (StringsKt.endsWith$default(r100, "." + r107, false, 2, null) == true) goto L38;
        r108 = false;
    L41:
        return false;
    L27:
        if (r105.isEmpty() == false) goto L29;
    L16:
        com.bytedance.ies.argus.bean.a r109 = ArgusConfigManager.a.a().b();
        if (r109 == null) goto L23;
        com.bytedance.ies.argus.bean.g r110 = r109.f();
        if (r110 == null) goto L23;
        r104 = r110.a();
        if (r104 != null) goto L24;
    L23:
        r104 = CollectionsKt.emptyList();
        goto L24
    L5:
        r103 = null;
        goto L7
    }
}
