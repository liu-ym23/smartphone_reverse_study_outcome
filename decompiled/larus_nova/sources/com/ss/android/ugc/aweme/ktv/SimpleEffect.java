package com.ss.android.ugc.aweme.ktv;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\f¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/aweme/ktv/SimpleEffect;", "Ljava/io/Serializable;", "id", "", "resId", "name", "path", "isItalic", "", "defaultColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getDefaultColor", "()Ljava/lang/String;", "setDefaultColor", "(Ljava/lang/String;)V", "getId", "()Z", "setItalic", "(Z)V", "getName", "getPath", "getResId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class SimpleEffect implements Serializable {
    private String defaultColor;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f450958id;
    private boolean isItalic;
    private final String name;
    private final String path;
    private final String resId;

    public static /* synthetic */ SimpleEffect copy$default(SimpleEffect r100, String r101, String r102, String r103, String r104, boolean r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f450958id;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.resId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.name;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.path;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.isItalic;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.defaultColor;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.f450958id;
    }

    public final String component2() {
        return this.resId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.path;
    }

    public final boolean component5() {
        return this.isItalic;
    }

    public final String component6() {
        return this.defaultColor;
    }

    public final SimpleEffect copy(String r100, String r110, String r111, String r112, boolean r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r110, "resId");
        Intrinsics.checkNotNullParameter(r112, "path");
        return new SimpleEffect(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SimpleEffect) == false) goto L18;
        SimpleEffect r101 = (SimpleEffect) r100;
        if (Intrinsics.areEqual(this.f450958id, r101.f450958id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.resId, r101.resId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L14;
        return false;
    L14:
        if (this.isItalic == r101.isItalic) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.defaultColor, r101.defaultColor) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public int hashCode() {
        String r100 = this.f450958id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.resId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.name;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.path;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.isItalic;
        ?? r114 = r113;
        if (r113 == false) goto L21;
        r114 = 1;
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.defaultColor;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SimpleEffect(id=" + this.f450958id + ", resId=" + this.resId + ", name=" + this.name + ", path=" + this.path + ", isItalic=" + this.isItalic + ", defaultColor=" + this.defaultColor + ")";
    }

    public final String getDefaultColor() {
        return this.defaultColor;
    }

    public final String getId() {
        return this.f450958id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getResId() {
        return this.resId;
    }

    public final boolean isItalic() {
        return this.isItalic;
    }

    public final void setDefaultColor(String r100) {
        this.defaultColor = r100;
    }

    public final void setItalic(boolean r100) {
        this.isItalic = r100;
    }

    public SimpleEffect(String r100, String r101, String r102, String r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "resId");
        Intrinsics.checkNotNullParameter(r103, "path");
        this.f450958id = r100;
        this.resId = r101;
        this.name = r102;
        this.path = r103;
        this.isItalic = r104;
        this.defaultColor = r105;
    }

    public /* synthetic */ SimpleEffect(String r100, String r101, String r110, String r111, boolean r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 16) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r114 & 32) == 0) goto L9;
        r113 = null;
    L9:
        this(r100, r101, r110, r111, r102, r113);
        return;
    L5:
        r102 = r112;
        goto L7
    }
}
