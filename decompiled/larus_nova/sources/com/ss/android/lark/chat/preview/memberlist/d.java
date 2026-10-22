package com.ss.android.lark.chat.preview.memberlist;

import com.larksuite.arch.jack.j;
import com.larksuite.arch.jack.m;
import com.larksuite.arch.jack.s;
import com.ss.android.lark.chat.entity.preview.PullUrlPreviewChatterListResponse;
import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f416296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larksuite.arch.jack.a<PullUrlPreviewChatterListResponse> f416297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<ChatterPreviewChatterInfo> f416298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f416299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f416300e;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f416296a, r101.f416296a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f416297b, r101.f416297b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f416298c, r101.f416298c) == true) goto L18;
        return false;
    L18:
        if (this.f416299d == r101.f416299d) goto L21;
        return false;
    L21:
        if (this.f416300e == r101.f416300e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f416296a.hashCode() * 31) + this.f416297b.hashCode()) * 31) + this.f416298c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f416299d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f416300e == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MemberListState(title=" + this.f416296a + ", request=" + this.f416297b + ", chatterInfoList=" + this.f416298c + ", showEmptyView=" + this.f416299d + ", showErrorView=" + this.f416300e + ')';
    }

    public final boolean b() {
        PullUrlPreviewChatterListResponse r100 = this.f416297b.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getHasMore();
    }

    public final String c() {
        PullUrlPreviewChatterListResponse r100 = this.f416297b.a();
        if (r100 == null) goto L6;
        String r101 = r100.getNextToken();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public /* synthetic */ d(int r100) {
        this("", s.f282824a, new ArrayList(), false, false);
    }

    public d(String r100, com.larksuite.arch.jack.a<PullUrlPreviewChatterListResponse> r101, ArrayList<ChatterPreviewChatterInfo> r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "chatterInfoList");
        this.f416296a = r100;
        this.f416297b = r101;
        this.f416298c = r102;
        this.f416299d = r103;
        this.f416300e = r104;
    }

    public static d a(d r100, String r101, m r102, ArrayList r103, boolean r110, boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f416296a;
    L5:
        String r104 = r101;
        com.larksuite.arch.jack.a<PullUrlPreviewChatterListResponse> r105 = r102;
        if ((r112 & 2) == 0) goto L8;
        r105 = r100.f416297b;
    L8:
        com.larksuite.arch.jack.a<PullUrlPreviewChatterListResponse> r106 = r105;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.f416298c;
    L11:
        ArrayList r107 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.f416299d;
    L14:
        boolean r108 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.f416300e;
    L17:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "title");
        Intrinsics.checkNotNullParameter(r106, "request");
        Intrinsics.checkNotNullParameter(r107, "chatterInfoList");
        return new d(r104, r106, r107, r108, r111);
    }
}
