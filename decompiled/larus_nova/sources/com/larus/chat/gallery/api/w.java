package com.larus.chat.gallery.api;

import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.preview.AttachmentSnapshot;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<AttachmentSnapshot> f324184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f324185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SuggestedAction f324186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f324187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f324188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f324189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f324190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f324191h;

    public w() {
        this(null, null, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f324184a, r101.f324184a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f324185b, r101.f324185b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f324186c, r101.f324186c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f324187d, r101.f324187d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f324188e, r101.f324188e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f324189f, r101.f324189f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f324190g, r101.f324190g) == true) goto L30;
        return false;
    L30:
        if (this.f324191h == r101.f324191h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f324184a.hashCode() * 31) + this.f324185b.hashCode()) * 31;
        SuggestedAction r101 = this.f324186c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f324187d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, String> r108 = this.f324188e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Map<String, String> r111 = this.f324189f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Map<String, String> r114 = this.f324190g;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        long r115 = this.f324191h;
        return ((r113 + r102) * 31) + ((int) (r115 ^ (r115 >>> 32)));
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
        return "PreviewSendSnapshot(attachments=" + this.f324184a + ", text=" + this.f324185b + ", suggestedAction=" + this.f324186c + ", scene=" + this.f324187d + ", messageExt=" + this.f324188e + ", fileForceTraceMap=" + this.f324189f + ", textForceTraceMap=" + this.f324190g + ", createdAt=" + this.f324191h + ')';
    }

    public /* synthetic */ w(List r110, String r111, SuggestedAction r112, String r113, Map r114, Map r115, Map r116, int r210) {
        if ((r210 & 1) == 0) goto L5;
        List r100 = CollectionsKt.emptyList();
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r210 & 4) == 0) goto L13;
        SuggestedAction r102 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Map r104 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Map r105 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Map r106 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        long r107 = System.currentTimeMillis();
    L34:
        this(r100, r101, r102, r103, r104, r105, r106, r107);
        return;
    L33:
        r107 = 0;
        goto L34
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static w a(w r110, String r111, SuggestedAction r112, String r113, Map r114, Map r115, Map r116, int r210) {
        if ((r210 & 1) == 0) goto L5;
        List<AttachmentSnapshot> r100 = r110.f324184a;
    L6:
        List<AttachmentSnapshot> r101 = r100;
        if ((r210 & 2) == 0) goto L9;
        String r102 = r110.f324185b;
    L11:
        if ((r210 & 4) == 0) goto L13;
        SuggestedAction r103 = r110.f324186c;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = r110.f324187d;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Map r105 = r110.f324188e;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Map r106 = r110.f324189f;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Map r117 = r110.f324190g;
    L31:
        if ((r210 & 128) == 0) goto L33;
        long r107 = r110.f324191h;
    L34:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "attachments");
        Intrinsics.checkNotNullParameter(r102, "text");
        return new w(r101, r102, r103, r104, r105, r106, r117, r107);
    L33:
        r107 = 0;
        goto L34
    L29:
        r117 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = null;
        goto L6
    }

    public w(List<AttachmentSnapshot> r100, String r101, SuggestedAction r102, String r103, Map<String, String> r104, Map<String, String> r105, Map<String, String> r106, long r107) {
        Intrinsics.checkNotNullParameter(r100, "attachments");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f324184a = r100;
        this.f324185b = r101;
        this.f324186c = r102;
        this.f324187d = r103;
        this.f324188e = r104;
        this.f324189f = r105;
        this.f324190g = r106;
        this.f324191h = r107;
    }
}
