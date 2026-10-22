package com.ss.android.ugc.route_monitor.impl.route_out;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes40.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f454738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f454739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f454740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f454741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f454742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f454743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f454744g;

    public s(Activity r100) {
        this.f454738a = r100.hashCode();
        this.f454739b = r100.getClass().getName();
        Intent r101 = r100.getIntent();
        String r102 = "";
        if (r101 == null) goto L7;
        String r103 = r101.getAction();
        if (r103 == null) goto L7;
    L8:
        this.f454742e = r103;
        Intent r104 = r100.getIntent();
        if (r104 == null) goto L15;
        Uri r105 = r104.getData();
        if (r105 == null) goto L15;
        String r106 = r105.toString();
        if (r106 == null) goto L15;
        r102 = r106;
    L15:
        this.f454743f = r102;
        Intent r107 = r100.getIntent();
        if (r107 == null) goto L18;
        Bundle r108 = r107.getExtras();
    L19:
        this.f454744g = r108;
        return;
    L18:
        r108 = null;
    L7:
        r103 = "";
        goto L8
    }
}
