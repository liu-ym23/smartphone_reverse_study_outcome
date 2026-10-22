package com.bytedance.ug.sdk.luckydog.base.pagecollect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f271761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f271762b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f271763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<String> f271764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<String> f271765c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<String> f271766d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f271767e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f271768f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f271769g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f271770h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f271771i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f271772j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f271773k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f271774l;

        public a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L56:
            return true;
        L5:
            if ((r100 instanceof a) == false) goto L55;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f271763a, r101.f271763a) == false) goto L55;
            if (Intrinsics.areEqual(this.f271764b, r101.f271764b) == false) goto L55;
            if (Intrinsics.areEqual(this.f271765c, r101.f271765c) == false) goto L55;
            if (Intrinsics.areEqual(this.f271766d, r101.f271766d) == false) goto L55;
            if (this.f271767e != r101.f271767e) goto L17;
            boolean r102 = true;
        L18:
            if (r102 == false) goto L55;
            if (this.f271768f != r101.f271768f) goto L22;
            boolean r103 = true;
        L23:
            if (r103 == false) goto L55;
            if (this.f271769g != r101.f271769g) goto L27;
            boolean r104 = true;
        L28:
            if (r104 == false) goto L55;
            if (this.f271770h != r101.f271770h) goto L32;
            boolean r105 = true;
        L33:
            if (r105 == false) goto L55;
            if (this.f271771i != r101.f271771i) goto L37;
            boolean r106 = true;
        L38:
            if (r106 == false) goto L55;
            if (this.f271772j != r101.f271772j) goto L42;
            boolean r107 = true;
        L43:
            if (r107 == false) goto L55;
            if (this.f271773k != r101.f271773k) goto L47;
            boolean r108 = true;
        L48:
            if (r108 == false) goto L55;
            if (this.f271774l != r101.f271774l) goto L52;
            boolean r109 = true;
        L53:
            if (r109 == false) goto L55;
        L52:
            r109 = false;
            goto L53
        L47:
            r108 = false;
            goto L48
        L42:
            r107 = false;
            goto L43
        L37:
            r106 = false;
            goto L38
        L32:
            r105 = false;
            goto L33
        L27:
            r104 = false;
            goto L28
        L22:
            r103 = false;
            goto L23
        L17:
            r102 = false;
        L55:
            return false;
        }

        public final int hashCode() {
            List<String> r100 = this.f271763a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.f271764b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            List<String> r107 = this.f271765c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            List<String> r110 = this.f271766d;
            if (r110 == null) goto L17;
            r101 = r110.hashCode();
        L17:
            int r111 = (r109 + r101) * 31;
            long r112 = this.f271767e;
            int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
            long r114 = this.f271768f;
            int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
            long r116 = this.f271769g;
            return ((((((((((r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31) + this.f271770h) * 31) + this.f271771i) * 31) + this.f271772j) * 31) + this.f271773k) * 31) + this.f271774l;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "MemCollectStrategy(nativeScenes=" + this.f271763a + ", feScenes=" + this.f271764b + ", routerScenes=" + this.f271765c + ", routeScenesParams=" + this.f271766d + ", interval=" + this.f271767e + ", minCollectDuration=" + this.f271768f + ", maxCollectDuration=" + this.f271769g + ", strategy=" + this.f271770h + ", compareCnt=" + this.f271771i + ", threshold=" + this.f271772j + ", collectPageStart=" + this.f271773k + ", collectPageShow=" + this.f271774l + ")";
        }

        public a(Object r100) {
            ArrayList r101 = new ArrayList();
            ArrayList r102 = new ArrayList();
            ArrayList r103 = new ArrayList();
            ArrayList r104 = new ArrayList();
            this.f271763a = r101;
            this.f271764b = r102;
            this.f271765c = r103;
            this.f271766d = r104;
            this.f271767e = 300;
            this.f271768f = 1000;
            this.f271769g = 10000;
            this.f271770h = 2;
            this.f271771i = 3;
            this.f271772j = 10;
            this.f271773k = 1;
            this.f271774l = 0;
        }
    }

    public final String toString() {
        return "memCollectEnable:" + this.f271761a + "memCollectStrategies:" + this.f271762b;
    }

    public d() {
        this.f271762b = new CopyOnWriteArrayList();
    }

    public static List b(JSONArray r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(r100.optString(r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public final a a(String r100) {
        CopyOnWriteArrayList<a> r101 = this.f271762b;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
        Iterator<a> r103 = this.f271762b.iterator();
    L15:
        if (r103.hasNext() == false) goto L32;
        a r104 = r103.next();
        if ((!r104.f271763a.isEmpty()) == false) goto L22;
        if (r104.f271763a.contains(r100) == false) goto L22;
        return r104;
    L22:
        if ((!r104.f271764b.isEmpty()) == false) goto L27;
        if (r104.f271764b.contains(r100) == false) goto L27;
        return r104;
    L27:
        if ((!r104.f271765c.isEmpty()) == false) goto L15;
        if (r104.f271765c.contains(r100) == false) goto L15;
        return r104;
    L32:
        return new a(null);
    L12:
        return new a(null);
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }

    public final boolean c(String r100) {
        boolean r101 = false;
        if (this.f271761a == true) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageMemCollectConfig", "collectPage memCollectEnable is disable:" + r100);
        return false;
    L6:
        CopyOnWriteArrayList<a> r102 = this.f271762b;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageMemCollectConfig", "collectPage memCollectStrategies is empty" + r100);
        return false;
    L16:
        Iterator<T> r104 = this.f271762b.iterator();
    L18:
        if (r104.hasNext() == false) goto L34;
        a r105 = (a) r104.next();
        if ((!r105.f271763a.isEmpty()) == false) goto L25;
        if (r105.f271763a.contains(r100) == false) goto L25;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageMemCollectConfig", "collectPage is in native path" + r100);
        r101 = true;
    L25:
        if ((!r105.f271764b.isEmpty()) == false) goto L30;
        if (r105.f271764b.contains(r100) == false) goto L30;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageMemCollectConfig", "collectPage is in fe path" + r100);
        r101 = true;
    L30:
        if ((!r105.f271765c.isEmpty()) == false) goto L18;
        if (r105.f271765c.contains(r100) == false) goto L18;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageMemCollectConfig", "collectPage is in router path" + r100);
        r101 = true;
        goto L18
    L34:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageMemCollectConfig", "isTargetCollectPage :" + r100 + r101);
        return r101;
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    }
}
