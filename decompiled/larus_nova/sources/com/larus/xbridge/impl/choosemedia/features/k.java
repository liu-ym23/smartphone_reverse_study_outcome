package com.larus.xbridge.impl.choosemedia.features;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.StatFs;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class k implements j4a.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<FragmentActivity, Intent, Integer, Unit> f379889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Activity> f379890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j4a.f f379891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f379892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f379893e;

    public k(WeakReference r100, h4a.d r101, i4a.a r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "onFileSelected");
        this.f379889a = r102;
        this.f379890b = r100;
        this.f379891c = r101;
    }

    @Override // j4a.i
    public final boolean onActivityResult(int r100, int r101, Intent r102) {
        if (r100 != 1311211) goto L31;
        if (r101 != 0) goto L8;
        this.f379891c.onFailed(-7, "Failed to capture video");
        return true;
    L8:
        if (this.f379890b.get() != null) goto L11;
        this.f379891c.onFailed(0, "Activity obtained a null");
        return true;
    L11:
        StatFs r103 = null;
        if (r102 == null) goto L14;
        Uri r104 = r102.getData();
    L15:
        if (r104 != null) goto L17;
    L30:
        this.f379891c.onFailed(0, "Video doesn't exist");
        goto L31
    L17:
        if (StringUtils.isEmpty(r104.toString()) == true) goto L30;
        String r105 = this.f379893e;
        if (r105 != null) goto L32;
        r105 = r104.toString();
    L32:
        r103 = new StatFs(new PolarisFileWrapper(r105).getAbsolutePath());     // Catch: IllegalArgumentException -> L25
    L26:
        if (r103 == null) goto L28;
        long r106 = r103.getAvailableBytes();
    L29:
        List<hx7.k.a> r107 = CollectionsKt.listOf(new hx7.k.a(r105, r106, "video"));
        j4a.f r108 = this.f379891c;
        hx7.k r109 = new hx7.k();
        r109.f487517a = r107;
        r108.a(r109);
        goto L31
    L28:
        r106 = 0;
        goto L29
    L14:
        r104 = null;
    L31:
        return true;
    }
}
