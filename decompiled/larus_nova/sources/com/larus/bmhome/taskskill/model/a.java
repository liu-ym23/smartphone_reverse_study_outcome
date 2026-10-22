package com.larus.bmhome.taskskill.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\r¨\u0006%"}, d2 = {"Lcom/larus/bmhome/taskskill/model/ExposedSkillSlot;", "", "slot", "", "skillName", "", "skillDisplayName", "skillType", "skillId", "source", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getSlot", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSkillName", "()Ljava/lang/String;", "getSkillDisplayName", "getSkillType", "getSkillId", "getSource", "toTaskSkill", "Lcom/larus/bmhome/taskskill/model/TaskSkill;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/taskskill/model/ExposedSkillSlot;", "equals", "", "other", "hashCode", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f314352a = 0;

    @SerializedName("skill_display_name")
    private final String skillDisplayName;

    @SerializedName("skill_id")
    private final String skillId;

    @SerializedName("skill_name")
    private final String skillName;

    @SerializedName("skill_type")
    private final Integer skillType;

    @SerializedName("slot")
    private final Integer slot;

    @SerializedName("source")
    private final Integer source;

    /* JADX INFO: renamed from: com.larus.bmhome.taskskill.model.a$a, reason: collision with other inner class name */
    public static final class C4104a {
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.slot, r101.slot) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.skillName, r101.skillName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.skillDisplayName, r101.skillDisplayName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.skillType, r101.skillType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.skillId, r101.skillId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.slot;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.skillName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.skillDisplayName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.skillType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.skillId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.source;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "ExposedSkillSlot(slot=" + this.slot + ", skillName=" + this.skillName + ", skillDisplayName=" + this.skillDisplayName + ", skillType=" + this.skillType + ", skillId=" + this.skillId + ", source=" + this.source + ')';
    }

    public final TaskSkill b() {
        String r100 = this.skillName;
        if (r100 != null) goto L5;
    L16:
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        String r101 = r100;
    L8:
        if (r101 == null) goto L16;
        String r102 = this.skillId;
        String r103 = this.skillDisplayName;
        Integer r104 = this.skillType;
        if (r104 == null) goto L13;
        int r105 = r104.intValue();
    L15:
        return new TaskSkill(r101, r102, null, r103, false, r105, true, null, null, 16148);
    L13:
        r105 = SkillType.SYSTEM.getValue();
        goto L15
    L7:
        r101 = null;
        goto L8
    }

    public final Integer a() {
        return this.slot;
    }

    public a(Integer r100, String r101, String r102, Integer r103, String r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = null;
    L17:
        this.slot = r100;
        this.skillName = r101;
        this.skillDisplayName = r102;
        this.skillType = r103;
        this.skillId = r104;
        this.source = null;
    }
}
