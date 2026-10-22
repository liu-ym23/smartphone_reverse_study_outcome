package com.larus.bmhome.chat.component.bottom.multimodal;

import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.model.action.DirectSendData;
import com.larus.platform.model.action.SuggestedAction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SuggestedAction f299901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReferenceInfo f299902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DirectSendData f299903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f299904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f299905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f299906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f299907g;

    public m() {
        this(null, null, null, null, false, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f299901a, r101.f299901a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f299902b, r101.f299902b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f299903c, r101.f299903c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f299904d, r101.f299904d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f299905e, r101.f299905e) == true) goto L24;
        return false;
    L24:
        if (this.f299906f == r101.f299906f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f299907g, r101.f299907g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        SuggestedAction r100 = this.f299901a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ReferenceInfo r104 = this.f299902b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        DirectSendData r107 = this.f299903c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        i r110 = this.f299904d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.f299905e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f299906f == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        String r118 = this.f299907g;
        if (r118 == null) goto L31;
        r101 = r118.hashCode();
    L31:
        return r117 + r101;
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MultimodalBizData(suggestedAction=" + this.f299901a + ", referenceInfo=" + this.f299902b + ", directSendData=" + this.f299903c + ", imageEditData=" + this.f299904d + ", resultSourceData=" + this.f299905e + ", isOriginalImageChecked=" + this.f299906f + ", uploadTaskShareTag=" + this.f299907g + ')';
    }

    public m(SuggestedAction r100, DirectSendData r101, i r102, List r103, boolean r104, String r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 32) == 0) goto L18;
        r104 = false;
    L18:
        if ((r106 & 64) == 0) goto L20;
        r105 = null;
    L20:
        this.f299901a = r100;
        this.f299902b = null;
        this.f299903c = r101;
        this.f299904d = r102;
        this.f299905e = r103;
        this.f299906f = r104;
        this.f299907g = r105;
    }
}
