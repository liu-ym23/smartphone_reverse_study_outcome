package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.action.SuggestedActionScene;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f298116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f298117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f298118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SuggestedActionScene f298119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f298120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<UplinkFileEntity> f298121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f298122g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f298116a, r101.f298116a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f298117b, r101.f298117b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f298118c, r101.f298118c) == true) goto L18;
        return false;
    L18:
        if (this.f298119d == r101.f298119d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f298120e, r101.f298120e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f298121f, r101.f298121f) == true) goto L27;
        return false;
    L27:
        if (this.f298122g == r101.f298122g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f298116a.hashCode() * 31) + this.f298117b.hashCode()) * 31;
        a r101 = this.f298118c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((((r100 + r102) * 31) + this.f298119d.hashCode()) * 31) + this.f298120e.hashCode()) * 31) + this.f298121f.hashCode()) * 31;
        if (this.f298122g == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AlbumEduIntentSuggestSnapshot(conversationId=" + this.f298116a + ", firstImageKey=" + this.f298117b + ", firstImageSource=" + this.f298118c + ", baseScene=" + this.f298119d + ", bizScene=" + this.f298120e + ", attachments=" + this.f298121f + ", useDraft=" + this.f298122g + ')';
    }

    public g(String r100, String r101, a r102, SuggestedActionScene r103, String r104, List<UplinkFileEntity> r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "firstImageKey");
        Intrinsics.checkNotNullParameter(r103, "baseScene");
        Intrinsics.checkNotNullParameter(r104, "bizScene");
        Intrinsics.checkNotNullParameter(r105, "attachments");
        this.f298116a = r100;
        this.f298117b = r101;
        this.f298118c = r102;
        this.f298119d = r103;
        this.f298120e = r104;
        this.f298121f = r105;
        this.f298122g = r106;
    }
}
