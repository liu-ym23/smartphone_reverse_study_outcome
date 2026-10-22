package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JO\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006 "}, d2 = {"Lcom/larus/platform/model/NewcomerGuideItem;", "Ljava/io/Serializable;", "id", "", "titleKey", "type", "actionValue", "titleText", "isLoading", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getTitleKey", "getType", "getActionValue", "getTitleText", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewcomerGuideItem implements Serializable {

    @SerializedName("action_value")
    private final String actionValue;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f365475id;
    private final boolean isLoading;

    @SerializedName("title_key")
    private final String titleKey;

    @SerializedName("title_text")
    private final String titleText;

    @SerializedName("type")
    private final String type;

    public NewcomerGuideItem() {
        this(null, null, null, null, null, false, 63, null);
    }

    public static /* synthetic */ NewcomerGuideItem copy$default(NewcomerGuideItem r100, String r101, String r102, String r103, String r104, String r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f365475id;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.titleKey;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.type;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.actionValue;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.titleText;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.isLoading;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.f365475id;
    }

    public final String component2() {
        return this.titleKey;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.actionValue;
    }

    public final String component5() {
        return this.titleText;
    }

    public final boolean component6() {
        return this.isLoading;
    }

    public final NewcomerGuideItem copy(String r100, String r110, String r111, String r112, String r113, boolean r114) {
        return new NewcomerGuideItem(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NewcomerGuideItem) == true) goto L8;
        return false;
    L8:
        NewcomerGuideItem r101 = (NewcomerGuideItem) r100;
        if (Intrinsics.areEqual(this.f365475id, r101.f365475id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleKey, r101.titleKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionValue, r101.actionValue) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.titleText, r101.titleText) == true) goto L24;
        return false;
    L24:
        if (this.isLoading == r101.isLoading) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.f365475id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.titleKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.type;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.actionValue;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.titleText;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        if (this.isLoading == false) goto L25;
        int r115 = 1231;
    L27:
        return r114 + r115;
    L25:
        r115 = 1237;
        goto L27
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

    public String toString() {
        return "NewcomerGuideItem(id=" + this.f365475id + ", titleKey=" + this.titleKey + ", type=" + this.type + ", actionValue=" + this.actionValue + ", titleText=" + this.titleText + ", isLoading=" + this.isLoading + ')';
    }

    public final String getActionValue() {
        return this.actionValue;
    }

    public final String getId() {
        return this.f365475id;
    }

    public final String getTitleKey() {
        return this.titleKey;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public NewcomerGuideItem(String r100, String r101, String r102, String r103, String r104, boolean r105) {
        this.f365475id = r100;
        this.titleKey = r101;
        this.type = r102;
        this.actionValue = r103;
        this.titleText = r104;
        this.isLoading = r105;
    }

    public /* synthetic */ NewcomerGuideItem(String r100, String r101, String r102, String r103, String r104, boolean r110, int r111, DefaultConstructorMarker r112) {
        String r105 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        String r108 = null;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r105 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        boolean r114 = false;
    L26:
        this(r113, r106, r107, r108, r105, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
