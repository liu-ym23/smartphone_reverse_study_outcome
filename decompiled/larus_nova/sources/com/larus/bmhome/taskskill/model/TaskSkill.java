package com.larus.bmhome.taskskill.model;

import android.os.Parcel;
import android.os.Parcelable;
import be8.b;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010/\u001a\u000200J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fHÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010%J\t\u0010<\u001a\u00020\tHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010(J¶\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010@J\u0006\u0010A\u001a\u00020\u000bJ\u0013\u0010B\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\u000bHÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001J\u0016\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0011\u0010\u0013\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001dR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0019R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\u0019¨\u0006L"}, d2 = {"Lcom/larus/bmhome/taskskill/model/TaskSkill;", "Landroid/os/Parcelable;", "name", "", "externalSkillId", "description", "_displayName", "_displayDescription", "recommend", "", "type", "", "visible", "path", ReportCardMonitorPlugin.CATEGORIES, "", "Lcom/larus/bmhome/taskskill/model/TaskSkillCategory;", "lastUsedAtMs", "", "isSuggestionRecommended", "suggestionPosition", "suggestionSkillsLimit", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZLjava/lang/String;Ljava/util/List;Ljava/lang/Long;ZLjava/lang/Integer;Ljava/lang/Integer;)V", "getName", "()Ljava/lang/String;", "getExternalSkillId", "getDescription", "getRecommend", "()Z", "getType", "()I", "getVisible", "getPath", "getCategories", "()Ljava/util/List;", "getLastUsedAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSuggestionPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSuggestionSkillsLimit", CommonConstant.KEY_DISPLAY_NAME, "getDisplayName", "displayDescription", "getDisplayDescription", "toAbilitySkill", "Lcom/larus/bmhome/chat/component/skill/SkillAbilitySkill;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZLjava/lang/String;Ljava/util/List;Ljava/lang/Long;ZLjava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/taskskill/model/TaskSkill;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskSkill implements Parcelable {
    public static final Parcelable.Creator<TaskSkill> CREATOR = null;

    @SerializedName("display_description")
    private final String _displayDescription;

    @SerializedName(IGoogleService.ResponseKey.DISPLAY_NAME)
    private final String _displayName;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f314348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f314349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f314350c;

    @SerializedName(ReportCardMonitorPlugin.CATEGORIES)
    private final List<TaskSkillCategory> categories;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f314351d;

    @SerializedName("description")
    private final String description;

    @SerializedName("external_skill_id")
    private final String externalSkillId;

    @SerializedName("name")
    private final String name;

    @SerializedName("path")
    private final String path;

    @SerializedName("recommend")
    private final boolean recommend;

    @SerializedName("type")
    private final int type;

    @SerializedName("visible")
    private final boolean visible;

    public static final class a implements Parcelable.Creator<TaskSkill> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TaskSkill createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            String r104 = r110.readString();
            if (r110.readInt() == 0) goto L5;
            boolean r105 = true;
        L6:
            int r106 = r110.readInt();
            if (r110.readInt() == 0) goto L9;
            boolean r111 = true;
        L10:
            String r112 = r110.readString();
            if (r110.readInt() != 0) goto L13;
            ArrayList r113 = null;
        L22:
            if (r110.readInt() != 0) goto L24;
            Long r114 = null;
        L26:
            if (r110.readInt() == 0) goto L28;
            boolean r115 = true;
        L30:
            if (r110.readInt() != 0) goto L32;
            Integer r116 = null;
        L34:
            if (r110.readInt() != 0) goto L36;
            Integer r107 = null;
        L38:
            return new TaskSkill(r100, r101, r102, r103, r104, r105, r106, r111, r112, r113, r114, r115, r116, r107);
        L36:
            r107 = Integer.valueOf(r110.readInt());
            goto L38
        L32:
            r116 = Integer.valueOf(r110.readInt());
            goto L34
        L28:
            r115 = false;
            goto L30
        L24:
            r114 = Long.valueOf(r110.readLong());
            goto L26
        L13:
            int r117 = r110.readInt();
            ArrayList r118 = new ArrayList(r117);
            int r119 = 0;
        L14:
            if (r119 == r117) goto L20;
            if (r110.readInt() != 0) goto L18;
            TaskSkillCategory r108 = null;
        L19:
            r118.add(r108);
            r119 = r119 + 1;
            goto L14
        L18:
            r108 = TaskSkillCategory.CREATOR.createFromParcel(r110);
            goto L19
        L20:
            r113 = r118;
            goto L22
        L9:
            r111 = false;
            goto L10
        L5:
            r105 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TaskSkill[] newArray(int r100) {
            return new TaskSkill[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TaskSkill() {
        this(null, null, null, null, false, 0, false, null, null, 16383);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TaskSkill) == true) goto L8;
        return false;
    L8:
        TaskSkill r101 = (TaskSkill) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.externalSkillId, r101.externalSkillId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this._displayName, r101._displayName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this._displayDescription, r101._displayDescription) == true) goto L24;
        return false;
    L24:
        if (this.recommend == r101.recommend) goto L27;
        return false;
    L27:
        if (this.type == r101.type) goto L30;
        return false;
    L30:
        if (this.visible == r101.visible) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.categories, r101.categories) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f314348a, r101.f314348a) == true) goto L42;
        return false;
    L42:
        if (this.f314349b == r101.f314349b) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f314350c, r101.f314350c) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f314351d, r101.f314351d) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.externalSkillId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.description;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this._displayName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this._displayDescription;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        int r116 = 1231;
        if (this.recommend == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (((r115 + r117) * 31) + this.type) * 31;
        if (this.visible == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        String r121 = this.path;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        List<TaskSkillCategory> r124 = this.categories;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        Long r127 = this.f314348a;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        if (this.f314349b == true) goto L46;
        r116 = 1237;
    L46:
        int r130 = (r129 + r116) * 31;
        Integer r131 = this.f314350c;
        if (r131 != null) goto L49;
        int r132 = 0;
    L50:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.f314351d;
        if (r134 == null) goto L55;
        r101 = r134.hashCode();
    L55:
        return r133 + r101;
    L49:
        r132 = r131.hashCode();
        goto L50
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = 1237;
        goto L30
    L25:
        r117 = 1237;
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
        return "TaskSkill(name=" + this.name + ", externalSkillId=" + this.externalSkillId + ", description=" + this.description + ", _displayName=" + this._displayName + ", _displayDescription=" + this._displayDescription + ", recommend=" + this.recommend + ", type=" + this.type + ", visible=" + this.visible + ", path=" + this.path + ", categories=" + this.categories + ", lastUsedAtMs=" + this.f314348a + ", isSuggestionRecommended=" + this.f314349b + ", suggestionPosition=" + this.f314350c + ", suggestionSkillsLimit=" + this.f314351d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.name);
        r100.writeString(this.externalSkillId);
        r100.writeString(this.description);
        r100.writeString(this._displayName);
        r100.writeString(this._displayDescription);
        r100.writeInt(this.recommend ? 1 : 0);
        r100.writeInt(this.type);
        r100.writeInt(this.visible ? 1 : 0);
        r100.writeString(this.path);
        List<TaskSkillCategory> r102 = this.categories;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L12:
        Long r103 = this.f314348a;
        if (r103 != null) goto L15;
        r100.writeInt(0);
    L16:
        r100.writeInt(this.f314349b ? 1 : 0);
        Integer r104 = this.f314350c;
        if (r104 != null) goto L19;
        r100.writeInt(0);
    L20:
        Integer r105 = this.f314351d;
        if (r105 != null) goto L23;
        r100.writeInt(0);
        return;
    L23:
        r100.writeInt(1);
        r100.writeInt(r105.intValue());
        return;
    L19:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        goto L20
    L15:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        goto L16
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<TaskSkillCategory> r106 = r102.iterator();
    L7:
        if (r106.hasNext() == false) goto L12;
        TaskSkillCategory r107 = r106.next();
        if (r107 == null) goto L10;
        r100.writeInt(1);
        r107.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }

    public final String b() {
        String r100 = this._displayDescription;
        if (r100 != null) goto L5;
    L9:
        String r101 = this.description;
        if (r101 != null) goto L14;
        return "";
    L14:
        return r101;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L9;
        return r100;
    }

    public final String c() {
        String r100 = this._displayName;
        if (r100 != null) goto L5;
    L9:
        String r101 = this.name;
        if (r101 != null) goto L14;
        return "";
    L14:
        return r101;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L9;
        return r100;
    }

    public final b h() {
        String r100 = this.name;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r101 = r100;
        String r102 = this.externalSkillId;
        String r103 = c();
        String r104 = b();
        boolean r105 = this.recommend;
        int r106 = this.type;
        String r107 = this.path;
        List<TaskSkillCategory> r108 = this.categories;
        if (r108 == null) goto L14;
        TaskSkillCategory r109 = (TaskSkillCategory) CollectionsKt.firstOrNull(r108);
        if (r109 == null) goto L14;
        String r110 = r109.a();
        if (r110 == null) goto L14;
        if ((!StringsKt.isBlank(r110)) == false) goto L14;
        String r111 = r110;
    L16:
        return new b(r101, r103, r102, r104, "", r105, r106, r107, r111, this.f314348a, this.f314349b, this.f314350c, this.f314351d);
    L14:
        r111 = null;
        goto L16
    }

    public final String d() {
        return this.externalSkillId;
    }

    public final String e() {
        return this.path;
    }

    public final boolean g() {
        return this.recommend;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public static TaskSkill a(TaskSkill r110, Long r210, boolean r211, Integer r212, Integer r213, int r214) {
        List<TaskSkillCategory> r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = r110.name;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = r110.externalSkillId;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = r110.description;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = r110._displayName;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = r110._displayDescription;
    L23:
        if ((r214 & 32) == 0) goto L25;
        boolean r111 = r110.recommend;
    L27:
        if ((r214 & 64) == 0) goto L29;
        int r112 = r110.type;
    L31:
        if ((r214 & 128) == 0) goto L33;
        boolean r113 = r110.visible;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r114 = r110.path;
    L39:
        if ((r214 & 512) == 0) goto L41;
        r100 = r110.categories;
    L41:
        List<TaskSkillCategory> r115 = r100;
        if ((r214 & 1024) == 0) goto L44;
        Long r116 = r110.f314348a;
    L46:
        if ((r214 & 2048) == 0) goto L48;
        boolean r117 = r110.f314349b;
    L50:
        if ((r214 & 4096) == 0) goto L52;
        Integer r118 = r110.f314350c;
    L54:
        if ((r214 & 8192) == 0) goto L56;
        Integer r119 = r110.f314351d;
    L57:
        r110.getClass();
        return new TaskSkill(r101, r102, r103, r104, r105, r111, r112, r113, r114, r115, r116, r117, r118, r119);
    L56:
        r119 = r213;
        goto L57
    L52:
        r118 = r212;
        goto L54
    L48:
        r117 = r211;
        goto L50
    L44:
        r116 = r210;
        goto L46
    L37:
        r114 = null;
        goto L39
    L33:
        r113 = false;
        goto L35
    L29:
        r112 = 0;
        goto L31
    L25:
        r111 = false;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ TaskSkill(String r110, String r210, String r211, String r212, boolean r213, int r214, boolean r215, String r216, List r217, int r218) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r218 & 32) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r218 & 64) == 0) goto L25;
        int r111 = 0;
    L27:
        if ((r218 & 128) == 0) goto L29;
        boolean r112 = false;
    L31:
        if ((r218 & 256) == 0) goto L33;
        String r113 = null;
    L35:
        if ((r218 & 512) == 0) goto L37;
        List r114 = null;
    L38:
        this(r100, r101, r102, r103, null, r104, r111, r112, r113, r114, null, false, null, null);
        return;
    L37:
        r114 = r217;
        goto L38
    L33:
        r113 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r111 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public TaskSkill(String r100, String r101, String r102, String r103, String r104, boolean r105, int r106, boolean r107, String r108, List<TaskSkillCategory> r110, Long r111, boolean r112, Integer r113, Integer r114) {
        this.name = r100;
        this.externalSkillId = r101;
        this.description = r102;
        this._displayName = r103;
        this._displayDescription = r104;
        this.recommend = r105;
        this.type = r106;
        this.visible = r107;
        this.path = r108;
        this.categories = r110;
        this.f314348a = r111;
        this.f314349b = r112;
        this.f314350c = r113;
        this.f314351d = r114;
    }
}
