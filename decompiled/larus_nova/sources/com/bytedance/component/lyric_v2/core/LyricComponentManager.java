package com.bytedance.component.lyric_v2.core;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ng4.d;
import ng4.e;
import ng4.g;
import ng4.h;
import ng4.i;
import ng4.k;
import ng4.l;
import ng4.m;
import ng4.n;
import pg4.c;

/* JADX INFO: loaded from: classes15.dex */
public final class LyricComponentManager implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f203042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f203043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LyricComponentManager$downloadCallback$1 f203044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LyricComponentManager$parseCallback$1 f203045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<m> f203046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f203047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f203048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f203049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i f203050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f203051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f203052k;

    public static final class a implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LyricComponentManager f203053a;

        public a(LyricComponentManager r100) {
            this.f203053a = r100;
        }

        @Override // ng4.n
        public final void a(int r100) {
            if (r100 <= 0) goto L9;
            float r101 = r100;
            LyricComponentManager r102 = this.f203053a;
            c r103 = r102.f203051j;
            if (r103.A == r101) goto L10;
            r103.A = r101;
            r102.f203052k.a(new Object[]{"load: 最大宽度更新", Float.valueOf(r101)});
            LyricComponentManager r104 = this.f203053a;
            final l r105 = r104.f203043b;
            if (r105 == null) goto L11;
            r104.f203049h.a(r105, r104.f203051j);
            this.f203053a.f(new LyricComponentManager$1$onSizeChanged$1$1(r105));
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f203054a = null;

        public b() {
        }

        static {
            f203054a = new b();
        }
    }

    @Override // ng4.e
    public final void c() {
        this.f203046e.clear();
    }

    @Override // ng4.e
    public final void release() {
        this.f203052k.a(new Object[]{"release: 释放资源"});
        l r100 = this.f203043b;
        if (r100 == null) goto L5;
        this.f203047f.b(r100);
    L5:
        this.f203050i.reset();
        this.f203043b = null;
    }

    @Override // ng4.e
    public final i a() {
        return this.f203050i;
    }

    @Override // ng4.e
    public final void b(m r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f203046e.add(r100);
    }

    @Override // ng4.e
    public final void d(int r100) {
        l r101 = this.f203043b;
        if (r101 != null) goto L6;
        return;
    L6:
        if (((ArrayList) r101.f519071c).isEmpty() == false) goto L8;
        return;
    L8:
        this.f203049h.b(r101, r100, this.f203050i);
        ng4.c r102 = r101.f519072d;
        if (r102 == null) goto L12;
        this.f203050i.a(r101, r102, this.f203051j);
        return;
    }

    public final boolean e(l r100) {
        l r101 = this.f203043b;
        if (r101 == null) goto L17;
        Intrinsics.checkNotNullParameter(r100, "request");
        if (Intrinsics.areEqual(r101.f519074f, r100.f519074f) == true) goto L7;
    L13:
        boolean r102 = false;
    L14:
        if (r102 != true) goto L18;
        return true;
    L18:
        return false;
    L7:
        if (r101.f519070b != r100.f519070b) goto L13;
        if (Intrinsics.areEqual(r101.f519076h, r100.f519076h) == false) goto L13;
        if (Intrinsics.areEqual(r101.f519075g, r100.f519075g) == false) goto L13;
        r102 = true;
        goto L14
    L17:
        return false;
    }

    public final void f(Function1<? super m, Unit> r100) {
        Iterator<m> r101 = this.f203046e.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke(r101.next());
        goto L4
    }

    @Override // ng4.e
    public final void load(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r111, "path");
        int r100 = ug4.a.f549992a;
        Intrinsics.checkNotNullParameter(r111, "filePath");
        String r112 = File.separator;
        int r101 = StringsKt.lastIndexOf$default(r111, r112, 0, false, 6, null);
        final String r113 = null;
        boolean r114 = false;
        if (r101 == (-1)) goto L5;
        String r102 = r111.substring(0, r101);
    L7:
        if (r102 != null) goto L9;
        String r103 = "";
    L10:
        Intrinsics.checkNotNullParameter(r111, "filePath");
        String r115 = r103;
        int r104 = StringsKt.lastIndexOf$default(r111, r112, 0, false, 6, null);
        if (r104 == (-1)) goto L13;
        String r105 = r111.substring(r104 + 1);
    L14:
        if (r105 != null) goto L16;
        String r106 = "";
    L17:
        b r107 = this.f203042a;
        c r108 = this.f203051j;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r115, DBDefinition.SAVE_PATH);
        Intrinsics.checkNotNullParameter(r106, "fileName");
        Intrinsics.checkNotNullParameter(r108, "config");
        Intrinsics.checkNotNullParameter(r111, "localPath");
        final l r109 = new l(r110, r115, r106, r108, r111);
        Intrinsics.checkNotNullParameter(r109, "request");
        if (e(r109) == false) goto L28;
        l r116 = this.f203043b;
        if (r116 == null) goto L26;
        List<pg4.d> r117 = r116.f519069a;
        if (r117 == null) goto L26;
        if ((!r117.isEmpty()) != true) goto L26;
    L27:
        this.f203052k.a(new Object[]{"load: 相同请求，直接返回", r109});
        return;
    L26:
        if (this.f203047f.c() == true) goto L27;
    L28:
        release();
        if (r109.f519074f.length() != 0) goto L31;
        boolean r118 = true;
    L32:
        if (r118 == false) goto L35;
        r113 = "URL为空";
    L46:
        if (r113 == null) goto L48;
        this.f203052k.b(new Object[]{"load: 参数错误", r109, 100, r113});
        f(new LyricComponentManager$load$$inlined$let$lambda$1(r113, this, r109));
        return;
    L48:
        this.f203043b = r109;
        List<pg4.d> r119 = r109.f519069a;
        if (r119 != null) goto L51;
    L52:
        r114 = true;
    L53:
        if (r114 == false) goto L55;
        this.f203047f.a(r109, this.f203044c);
        return;
    L55:
        this.f203045d.b(r109);
        return;
    L51:
        if (r119.isEmpty() == false) goto L53;
    L35:
        if (r109.f519075g.length() != 0) goto L37;
        boolean r120 = true;
    L38:
        if (r120 == false) goto L41;
        r113 = "保存路径为空";
        goto L46
    L41:
        if (r109.f519076h.length() != 0) goto L43;
        boolean r121 = true;
    L44:
        if (r121 == false) goto L46;
        r113 = "文件名为空";
        goto L46
    L43:
        r121 = false;
        goto L44
    L37:
        r120 = false;
        goto L38
    L31:
        r118 = false;
        goto L32
    L16:
        r106 = r105;
        goto L17
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = r102;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.component.lyric_v2.core.LyricComponentManager$downloadCallback$1] */
    public LyricComponentManager(g r100, k r101, d r102, i r103, c r104, h r105) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.DOWNLOAD_TABLE_NAME);
        Intrinsics.checkNotNullParameter(r101, "parser");
        Intrinsics.checkNotNullParameter(r102, "drawNodeFactory");
        Intrinsics.checkNotNullParameter(r103, "painter");
        Intrinsics.checkNotNullParameter(r104, "styleConfig");
        Intrinsics.checkNotNullParameter(r105, "logger");
        this.f203047f = r100;
        this.f203048g = r101;
        this.f203049h = r102;
        this.f203050i = r103;
        this.f203051j = r104;
        this.f203052k = r105;
        this.f203042a = b.f203054a;
        r103.setSizeChangeListener(new a(this));
        this.f203044c = new LyricComponentManager$downloadCallback$1(this);
        this.f203045d = new LyricComponentManager$parseCallback$1(this);
        this.f203046e = new CopyOnWriteArrayList();
    }
}
