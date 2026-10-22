package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003Jm\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001J\u0013\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0007HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0019\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0019\"\u0004\b\"\u0010\u001d¨\u00063"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/AssigneeBean;", "Ljava/io/Serializable;", "id", "", "name", "avatarKey", "deleteState", "", "deleteQuitWarning", "", "deleteDirect", "showExternal", "isComplete", "completedMilliTime", "", "isShowComplete", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZZJZ)V", "getId", "()Ljava/lang/String;", "getName", "getAvatarKey", "getDeleteState", "()I", "getDeleteQuitWarning", "()Z", "getDeleteDirect", "getShowExternal", "setComplete", "(Z)V", "getCompletedMilliTime", "()J", "setCompletedMilliTime", "(J)V", "setShowComplete", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "", "hashCode", "toString", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssigneeBean implements Serializable {
    private final String avatarKey;
    private long completedMilliTime;
    private final boolean deleteDirect;
    private final boolean deleteQuitWarning;
    private final int deleteState;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f443581id;
    private boolean isComplete;
    private boolean isShowComplete;
    private final String name;
    private final boolean showExternal;

    public static /* synthetic */ AssigneeBean copy$default(AssigneeBean r110, String r111, String r112, String r113, int r114, boolean r115, boolean r116, boolean r117, boolean r210, long r211, boolean r212, int r213, Object r214) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = r110.f443581id;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r102 = r110.avatarKey;
    L15:
        if ((r213 & 8) == 0) goto L17;
        int r103 = r110.deleteState;
    L19:
        if ((r213 & 16) == 0) goto L21;
        boolean r104 = r110.deleteQuitWarning;
    L23:
        if ((r213 & 32) == 0) goto L25;
        boolean r105 = r110.deleteDirect;
    L27:
        if ((r213 & 64) == 0) goto L29;
        boolean r106 = r110.showExternal;
    L31:
        if ((r213 & 128) == 0) goto L33;
        boolean r107 = r110.isComplete;
    L35:
        if ((r213 & 256) == 0) goto L37;
        long r118 = r110.completedMilliTime;
    L39:
        if ((r213 & 512) == 0) goto L41;
        boolean r108 = r110.isShowComplete;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r108);
    L41:
        r108 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.f443581id;
    }

    public final boolean component10() {
        return this.isShowComplete;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.avatarKey;
    }

    public final int component4() {
        return this.deleteState;
    }

    public final boolean component5() {
        return this.deleteQuitWarning;
    }

    public final boolean component6() {
        return this.deleteDirect;
    }

    public final boolean component7() {
        return this.showExternal;
    }

    public final boolean component8() {
        return this.isComplete;
    }

    public final long component9() {
        return this.completedMilliTime;
    }

    public final AssigneeBean copy(String r110, String r111, String r112, int r113, boolean r114, boolean r115, boolean r210, boolean r211, long r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r112, "avatarKey");
        return new AssigneeBean(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AssigneeBean) == true) goto L8;
        return false;
    L8:
        AssigneeBean r101 = (AssigneeBean) r100;
        if (Intrinsics.areEqual(this.f443581id, r101.f443581id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L18;
        return false;
    L18:
        if (this.deleteState == r101.deleteState) goto L21;
        return false;
    L21:
        if (this.deleteQuitWarning == r101.deleteQuitWarning) goto L24;
        return false;
    L24:
        if (this.deleteDirect == r101.deleteDirect) goto L27;
        return false;
    L27:
        if (this.showExternal == r101.showExternal) goto L30;
        return false;
    L30:
        if (this.isComplete == r101.isComplete) goto L33;
        return false;
    L33:
        if (this.completedMilliTime == r101.completedMilliTime) goto L36;
        return false;
    L36:
        if (this.isShowComplete == r101.isShowComplete) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.f443581id.hashCode() * 31) + this.name.hashCode()) * 31) + this.avatarKey.hashCode()) * 31) + this.deleteState) * 31;
        int r101 = 1231;
        if (this.deleteQuitWarning == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.deleteDirect == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.showExternal == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.isComplete == false) goto L17;
        int r108 = 1231;
    L18:
        long r109 = this.completedMilliTime;
        int r110 = (((r107 + r108) * 31) + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        if (this.isShowComplete == true) goto L23;
        r101 = 1237;
    L23:
        return r110 + r101;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "AssigneeBean(id=" + this.f443581id + ", name=" + this.name + ", avatarKey=" + this.avatarKey + ", deleteState=" + this.deleteState + ", deleteQuitWarning=" + this.deleteQuitWarning + ", deleteDirect=" + this.deleteDirect + ", showExternal=" + this.showExternal + ", isComplete=" + this.isComplete + ", completedMilliTime=" + this.completedMilliTime + ", isShowComplete=" + this.isShowComplete + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final long getCompletedMilliTime() {
        return this.completedMilliTime;
    }

    public final boolean getDeleteDirect() {
        return this.deleteDirect;
    }

    public final boolean getDeleteQuitWarning() {
        return this.deleteQuitWarning;
    }

    public final int getDeleteState() {
        return this.deleteState;
    }

    public final String getId() {
        return this.f443581id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getShowExternal() {
        return this.showExternal;
    }

    public final boolean isComplete() {
        return this.isComplete;
    }

    public final boolean isShowComplete() {
        return this.isShowComplete;
    }

    public final void setComplete(boolean r100) {
        this.isComplete = r100;
    }

    public final void setCompletedMilliTime(long r100) {
        this.completedMilliTime = r100;
    }

    public final void setShowComplete(boolean r100) {
        this.isShowComplete = r100;
    }

    public AssigneeBean(String r100, String r101, String r102, int r103, boolean r104, boolean r105, boolean r106, boolean r107, long r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        this.f443581id = r100;
        this.name = r101;
        this.avatarKey = r102;
        this.deleteState = r103;
        this.deleteQuitWarning = r104;
        this.deleteDirect = r105;
        this.showExternal = r106;
        this.isComplete = r107;
        this.completedMilliTime = r110;
        this.isShowComplete = r111;
    }

    public /* synthetic */ AssigneeBean(String r110, String r111, String r112, int r113, boolean r114, boolean r210, boolean r211, boolean r212, long r213, boolean r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 256) == 0) goto L5;
        long r115 = 0;
    L6:
        this(r110, r111, r112, r113, r114, r210, r211, r212, r115, r214);
        return;
    L5:
        r115 = r213;
        goto L6
    }
}
