package com.larus.avatar.impl.manager;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.uaigc.api.a f290811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f290812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f290813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f290814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f290815e;

    public e0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f290811a, r101.f290811a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f290812b, r101.f290812b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f290813c, r101.f290813c) == true) goto L18;
        return false;
    L18:
        if (this.f290814d == r101.f290814d) goto L21;
        return false;
    L21:
        if (this.f290815e == r101.f290815e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        com.larus.uaigc.api.a r100 = this.f290811a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((r101 * 31) + this.f290812b.hashCode()) * 31) + this.f290813c.hashCode()) * 31;
        int r103 = 1231;
        if (this.f290814d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f290815e == true) goto L15;
        r103 = 1237;
    L15:
        return r105 + r103;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DigitalAvatarUiState(aiReplicaInfo=" + this.f290811a + ", createTimeText=" + this.f290812b + ", avatarPreviewImageThumbnailUrls=" + this.f290813c + ", showRedDot=" + this.f290814d + ", showTakeVideoHint=" + this.f290815e + ')';
    }

    public /* synthetic */ e0(int r100) {
        this(null, "", CollectionsKt.emptyList(), false, false);
    }

    public e0(com.larus.uaigc.api.a r100, String r101, List<String> r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "createTimeText");
        Intrinsics.checkNotNullParameter(r102, "avatarPreviewImageThumbnailUrls");
        this.f290811a = r100;
        this.f290812b = r101;
        this.f290813c = r102;
        this.f290814d = r103;
        this.f290815e = r104;
    }
}
