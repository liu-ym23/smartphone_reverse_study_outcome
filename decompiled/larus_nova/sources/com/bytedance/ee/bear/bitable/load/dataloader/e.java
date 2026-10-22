package com.bytedance.ee.bear.bitable.load.dataloader;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppLoader f214533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f214534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f214535c;

    public e(BitableAppLoader r100, String r101, long r102) {
        this.f214533a = r100;
        this.f214534b = r101;
        this.f214535c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        com.bytedance.ee.bear.bitable.rust.c.a r100 = (com.bytedance.ee.bear.bitable.rust.c.a) r110;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f215263b;
    L6:
        boolean r103 = true;
        if (Intrinsics.areEqual(r102, "preload") == true) goto L9;
    L14:
        if (r100 == null) goto L25;
        String r104 = r100.f215267f;
        if (r104 == null) goto L25;
        if (r104.length() > 0) goto L21;
        r103 = false;
    L21:
        if (r103 == true) goto L24;
        r104 = null;
    L24:
        if (r104 == null) goto L25;
    L26:
        BitableAppLoader r111 = this.f214533a;
        String r112 = this.f214534b;
        if (r100 == null) goto L29;
        long r105 = r100.f215265d;
    L30:
        long r106 = r105;
        if (r100 == null) goto L33;
        int r107 = r100.f215266e;
    L34:
        if (r100 == null) goto L36;
        String r108 = r100.f215268g;
    L38:
        if (r108 != null) goto L40;
        String r109 = "";
    L41:
        if (r100 == null) goto L43;
        r101 = r100.f215263b;
    L43:
        if (r101 != null) goto L45;
        String r113 = "";
    L46:
        if (r100 == null) goto L48;
        long r114 = r100.f215264c;
    L49:
        r111.m(r112, new BitableAppLoader.a(r106, r107, r104, r109, r113, r114, "miss"), new Exception(r104));
        return;
    L48:
        r114 = 0;
        goto L49
    L45:
        r113 = r101;
        goto L46
    L40:
        r109 = r108;
        goto L41
    L36:
        r108 = null;
        goto L38
    L33:
        r107 = -1;
        goto L34
    L29:
        r105 = this.f214535c;
    L25:
        r104 = "No preload clientVars available";
        goto L26
    L9:
        if (r100.f215262a.length() <= 0) goto L11;
        boolean r115 = true;
    L12:
        if (r115 == false) goto L14;
        BitableAppLoader r116 = this.f214533a;
        BitableAppLoader.AppResourceType r117 = BitableAppLoader.AppResourceType.ClientVarsData;
        r116.p(r117, new BitableAppLoader.a(r100.f215265d, r100.f215266e, r100.f215267f, r100.f215268g, r100.f215263b, r100.f215264c, BaseHttpRequestInfo.KEY_HIT));
        this.f214533a.o(r117, new BitableAppData(r100.f215262a, this.f214534b, null), null);
        return;
    L11:
        r115 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
