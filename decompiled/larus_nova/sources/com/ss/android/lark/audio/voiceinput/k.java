package com.ss.android.lark.audio.voiceinput;

import com.ss.android.lark.log.Log;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f409258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f409259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f409260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f409261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f409262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f409263f;

    public k() {
        this.f409258a = SetsKt.setOf(new String[]{".", "。"});
        this.f409261d = -1;
        this.f409262e = "SmartPeriodOptimizer";
    }

    public final String b(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return "";
    L11:
        String r102 = String.valueOf(StringsKt.last(r100));
        if (this.f409258a.contains(r102) == true) goto L14;
        return r100;
    L14:
        return StringsKt.removeSuffix(r100, r102);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public final String a(String r110, int r111) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
    L35:
        Log.i(this.f409262e, "addPeriodIfNeed: currentInputResult is empty or isHandleAddPeriod:" + this.f409263f);
        this.f409263f = true;
        this.f409259b = null;
        this.f409261d = -1;
        this.f409260c = null;
        return "";
    L12:
        if (this.f409263f == true) goto L35;
        String r102 = this.f409259b;
        if (r102 == null) goto L37;
        String r103 = this.f409262e;
        StringBuilder r104 = new StringBuilder("addPeriodIfNeed: lastEndSymbol:");
        r104.append(r102);
        r104.append(", cursorPosEqual:");
        if (this.f409261d != r111) goto L19;
        boolean r105 = true;
    L20:
        r104.append(r105);
        r104.append(", resultEqual:");
        r104.append(Intrinsics.areEqual(this.f409260c, r110));
        Log.i(r103, r104.toString());
        if (r111 == this.f409261d) goto L23;
        return "";
    L23:
        if (Intrinsics.areEqual(this.f409260c, r110) == false) goto L39;
        String r112 = this.f409260c;
        if (r112 != null) goto L27;
    L32:
        if (r100 == false) goto L40;
        this.f409263f = true;
        this.f409259b = null;
        this.f409261d = -1;
        this.f409260c = null;
        return r102;
    L40:
        return "";
    L27:
        if (r112.length() <= 0) goto L29;
        boolean r113 = true;
    L30:
        if (r113 != true) goto L32;
        r100 = true;
        goto L32
    L29:
        r113 = false;
        goto L30
    L39:
        return "";
    L19:
        r105 = false;
        goto L20
    L37:
        return "";
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final void c(String r100, String r101, int r102) {
        if (r100 != null) goto L5;
    L19:
        this.f409263f = false;
        return;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        String r104 = String.valueOf(StringsKt.last(r100));
    L12:
        if (this.f409258a.contains(r104) == false) goto L14;
        this.f409259b = r104;
    L14:
        this.f409260c = r101;
        this.f409261d = r102;
        String r105 = this.f409262e;
        StringBuilder r106 = new StringBuilder("updateCacheState: lastEndSymbol:");
        r106.append(this.f409259b);
        r106.append(", cursorPosEqual:");
        r106.append(this.f409261d);
        r106.append(", lastResult.length:");
        String r107 = this.f409260c;
        if (r107 == null) goto L17;
        Integer r108 = Integer.valueOf(r107.length());
    L18:
        r106.append(r108);
        Log.i(r105, r106.toString());
        goto L19
    L17:
        r108 = null;
        goto L18
    L10:
        r104 = "";
        goto L12
    L7:
        r103 = false;
        goto L8
    }
}
