package com.larus.bmhome.view.actionbar.edit;

import android.net.Uri;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TemplateInfo$TemplateInfo f316727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f316728b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f316727a, r101.f316727a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f316728b, r101.f316728b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f316727a.hashCode() * 31;
        Uri r101 = this.f316728b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "InstructionPhotoTemplateWrapper(templateInfo=" + this.f316727a + ", localImagePath=" + this.f316728b + ')';
    }

    public m(TemplateInfo$TemplateInfo r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, "templateInfo");
        this.f316727a = r100;
        this.f316728b = r101;
    }
}
