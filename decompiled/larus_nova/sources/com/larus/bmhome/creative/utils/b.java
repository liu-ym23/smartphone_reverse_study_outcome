package com.larus.bmhome.creative.utils;

import android.net.Uri;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TemplateInfo$TemplateInfo f310762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f310763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f310764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UserCreation f310765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri f310766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f310767f;

    public b() {
        this(null, null, false, null, null, false, 63);
    }

    public b(TemplateInfo$TemplateInfo r100, String r101, boolean r102, UserCreation r103, Uri r104, boolean r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = true;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 32) == 0) goto L20;
        r105 = false;
    L20:
        this.f310762a = r100;
        this.f310763b = r101;
        this.f310764c = r102;
        this.f310765d = r103;
        this.f310766e = r104;
        this.f310767f = r105;
    }
}
