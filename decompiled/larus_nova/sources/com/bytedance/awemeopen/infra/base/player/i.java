package com.bytedance.awemeopen.infra.base.player;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f198748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f198749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f198750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f198751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f198752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f198753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f198754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f198755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f198756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f198757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f198758k;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "PlayItem(vid='" + this.f198748a + "', codecType='" + this.f198749b + "', gearName='" + this.f198750c + "', qualityType=" + this.f198751d + ", width=" + this.f198752e + ", height=" + this.f198753f + ", dataSize=" + this.f198754g + ", bitRate=" + this.f198755h + ", urlKey='" + this.f198756i + "', urlList=" + this.f198757j + ", fileHash='" + this.f198758k + "')";
    }

    public i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "vid");
        this.f198748a = r100;
        this.f198749b = "";
        this.f198750c = "";
        this.f198756i = r100;
        this.f198758k = "";
    }
}
