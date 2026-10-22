package com.bytedance.ee.bear.bitable.core.infoarch.arch;

import android.graphics.Color;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/ThemeModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "themeType", "", "getThemeType", "()Ljava/lang/String;", "setThemeType", "(Ljava/lang/String;)V", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "backgroundImage", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "getBackgroundImage", "()Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "setBackgroundImage", "(Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;)V", "Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/ThemeType;", "getBgColor", "", "()Ljava/lang/Integer;", "getBgImage", "isDefaultTheme", "", "toString", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThemeModel implements NonProguard {
    public static final a Companion = null;
    private static final String TAG = "DashboardThemeModel";
    private String backgroundColor;
    private AttachmentEntity backgroundImage;
    private String themeType;

    public static final class a {
        public a() {
        }

        public static boolean a(ThemeModel r100, ThemeModel r101) {
            if (r100 != null) goto L7;
            if (r101 != null) goto L7;
            return true;
        L7:
            if (r100 == null) goto L31;
            if (r101 == null) goto L31;
            if (Intrinsics.areEqual(r100.m8311getThemeType(), r101.m8311getThemeType()) == false) goto L31;
            if (Intrinsics.areEqual(r100.getBackgroundColor(), r101.getBackgroundColor()) == false) goto L31;
            AttachmentEntity r102 = r100.getBackgroundImage();
            AttachmentEntity r103 = r101.getBackgroundImage();
            if (r102 != null) goto L17;
            if (r103 != null) goto L17;
        L27:
            boolean r104 = true;
        L29:
            if (r104 == false) goto L31;
            return true;
        L17:
            if (r102 == null) goto L28;
            if (r103 == null) goto L28;
            if (Intrinsics.areEqual(r102.getAttachmentToken(), r103.getAttachmentToken()) == false) goto L28;
            if (Intrinsics.areEqual(r102.getMountNodeToken(), r103.getMountNodeToken()) == false) goto L28;
            if (Intrinsics.areEqual(r102.getMountPointType(), r103.getMountPointType()) == false) goto L28;
            if (Intrinsics.areEqual(r102.getExtra(), r103.getExtra()) == true) goto L27;
        L28:
            r104 = false;
        L31:
            return false;
        }
    }

    static {
        Companion = new a();
    }

    public ThemeModel() {
    }

    public final Integer getBgColor() {
        String r100 = this.backgroundColor;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L17;
        return null;
    L17:
        return Integer.valueOf(Color.parseColor(r100));
    L14:
        th = move-exception;
        tt5.a.e(TAG, "DashboardTheme.parseColor err: " + r100, th, false);
        return null;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final AttachmentEntity getBgImage() {
        AttachmentEntity r100 = this.backgroundImage;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.getAttachmentToken().length() <= 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return r100;
    L12:
        return null;
    L8:
        r101 = false;
        goto L9
    }

    public final ThemeType getThemeType() {
        String r100 = this.themeType;
        if (Intrinsics.areEqual(r100, "LIGHT") == false) goto L6;
        return ThemeType.LIGHT;
    L6:
        if (Intrinsics.areEqual(r100, "DARK") == false) goto L9;
        return ThemeType.DARK;
    L9:
        return ThemeType.DEFAULT;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("ThemeModel(themeType=");
        r100.append(this.themeType);
        r100.append(", backgroundColor=");
        r100.append(this.backgroundColor);
        r100.append(", backgroundImage=");
        AttachmentEntity r101 = this.backgroundImage;
        if (r101 == null) goto L5;
        String r102 = r101.getAttachmentToken();
    L6:
        r100.append(du5.b.i(r102));
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final boolean isDefaultTheme() {
        if (getBgImage() == null) goto L5;
    L9:
        return false;
    L5:
        if (getBgColor() != null) goto L9;
        if (getThemeType() != ThemeType.DEFAULT) goto L9;
        return true;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final AttachmentEntity getBackgroundImage() {
        return this.backgroundImage;
    }

    /* JADX INFO: renamed from: getThemeType, reason: collision with other method in class */
    public final String m8311getThemeType() {
        return this.themeType;
    }

    public final void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public final void setBackgroundImage(AttachmentEntity r100) {
        this.backgroundImage = r100;
    }

    public final void setThemeType(String r100) {
        this.themeType = r100;
    }
}
