package com.larus.share.service;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f368893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f368894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f368895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f368896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f368897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f368898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f368899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final JSONObject f368900h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f368893a, r101.f368893a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f368894b, r101.f368894b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f368895c, r101.f368895c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f368896d, r101.f368896d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f368897e, r101.f368897e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f368898f, r101.f368898f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f368899g, r101.f368899g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f368900h, r101.f368900h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f368893a.hashCode() * 31;
        String r101 = this.f368894b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f368895c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f368896d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f368897e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f368898f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f368899g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        JSONObject r120 = this.f368900h;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletSharePanelRequest(activity=" + this.f368893a + ", scene=" + this.f368894b + ", shareLinkUrl=" + this.f368895c + ", shareTitle=" + this.f368896d + ", shareContent=" + this.f368897e + ", shareCoverUrl=" + this.f368898f + ", episodeId=" + this.f368899g + ", trackInfo=" + this.f368900h + ')';
    }

    public final FragmentActivity getActivity() {
        return this.f368893a;
    }

    public a(FragmentActivity r100, String r101, String r102, String r103, String r104, String r105, String r106, JSONObject r107) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f368893a = r100;
        this.f368894b = r101;
        this.f368895c = r102;
        this.f368896d = r103;
        this.f368897e = r104;
        this.f368898f = r105;
        this.f368899g = r106;
        this.f368900h = r107;
    }
}
