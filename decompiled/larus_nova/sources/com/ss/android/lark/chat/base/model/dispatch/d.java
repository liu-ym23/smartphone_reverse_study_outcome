package com.ss.android.lark.chat.base.model.dispatch;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends PreprocessParams {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f411765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f411766e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f411767a = null;

        static {
            int[] r100 = new int[ResourceType.values().length];
            r100[ResourceType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ResourceType.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f411767a = r100;
        }
    }

    @Override // com.ss.android.lark.chat.base.model.dispatch.PreprocessParams
    public final boolean a() {
        return !TextUtils.isEmpty(this.f411765d);
    }

    public final int hashCode() {
        int r100 = this.f411765d.hashCode() * 31;
        if (this.f411766e == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "{ fileType: " + getType() + ", hashedPath: " + ((String) this.f411721c.getValue()) + ", isOrigin: " + this.f411766e + ", " + this.f411720b + " }";
    }

    @Override // com.ss.android.lark.chat.base.model.dispatch.PreprocessParams
    public final String b() {
        int r100 = a.f411767a[getType().ordinal()];
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L11;
        Log.e("PreprocessParams", "toUniqueKey / Invalid fileType, params: " + this);
        return null;
    L11:
        return CompressPathManager.generateCompressFilePath(this.f411765d, Boolean.valueOf(this.f411766e));
    L9:
        return this.f411765d + '_' + this.f411766e;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof d) == false) goto L5;
        d r101 = (d) r100;
    L7:
        if (r101 != null) goto L10;
        return false;
    L10:
        if (getType() == r101.getType()) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f411765d, r101.f411765d) == true) goto L14;
        return false;
    L14:
        if (this.f411766e != r101.f411766e) goto L19;
        return true;
    L19:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public d(ResourceType r100, String r101, boolean r102, f r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r103, "preUploadParams");
        super(r100, r103);
        this.f411765d = r101;
        this.f411766e = r102;
    }
}
