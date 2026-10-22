package com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import com.android.ttcjpaysdk.ktextension.CJSchemaExtensionKt;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class ContainerContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f202232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f202233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Activity f202234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f202235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Uri f202236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f202237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f202238g;

    public final Activity getActivity() {
        Activity r100 = this.f202234c;
        if (r100 != null) goto L22;
        Context r101 = this.f202235d;
        if ((r101 instanceof Activity) == false) goto L7;
        Activity r102 = (Activity) r101;
    L8:
        if (r102 != null) goto L21;
        if ((r101 instanceof ContextWrapper) == false) goto L12;
        ContextWrapper r103 = (ContextWrapper) r101;
    L13:
        if (r103 == null) goto L15;
        Context r104 = r103.getBaseContext();
    L17:
        if ((r104 instanceof Activity) == false) goto L24;
        return (Activity) r104;
    L24:
        return null;
    L15:
        r104 = null;
        goto L17
    L12:
        r103 = null;
        goto L13
    L21:
        return r102;
    L7:
        r102 = null;
        goto L8
    L22:
        return r100;
    }

    public final Context getContext() {
        Activity r100 = this.f202234c;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.f202235d;
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Uri r101 = this.f202236e;
        if (r101 != null) goto L5;
        String r102 = CJSchemaExtensionKt.getQueryParameter(this.f202232a, "ttpay_annie_query");
        Uri r103 = new Uri.Builder().encodedQuery(r102).build();
        this.f202236e = r103;
        if (r103 != null) goto L11;
        return null;
    L11:
        return UriProtector.getQueryParameter(r103, r100);
    L5:
        return UriProtector.getQueryParameter(r101, r100);
    }

    public ContainerContext(String r100, String r101, Activity r102, Context r103) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "containerId");
        this.f202232a = r100;
        this.f202233b = r101;
        this.f202234c = r102;
        this.f202235d = r103;
        this.f202237f = LazyKt.lazy(new ContainerContext$commonLogParams$2(this));
    }
}
