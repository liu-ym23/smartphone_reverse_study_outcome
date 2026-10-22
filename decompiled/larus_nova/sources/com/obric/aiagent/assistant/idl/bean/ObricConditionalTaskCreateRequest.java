package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b'\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003JË\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u00106\u001a\u000207J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u000207HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\u0016\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u000207R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R&\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006C"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/ObricConditionalTaskCreateRequest;", "Landroid/os/Parcelable;", DBDefinition.TASK_ID, "", "instructionType", "createType", "instruction", "originQuery", "shortQuery", "createTime", UserInfo.UPDATE_TIME, "knowledge", "automaticFields", "operateType", "extra", "", "discoverId", "discoverQuery", "userSelectModel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "getInstructionType", "getCreateType", "getInstruction", "getOriginQuery", "getShortQuery", "getCreateTime", "getUpdateTime", "getKnowledge", "getAutomaticFields", "getOperateType", "getExtra", "()Ljava/util/Map;", "getDiscoverId", "getDiscoverQuery", "getUserSelectModel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricConditionalTaskCreateRequest implements Parcelable {
    public static final Parcelable.Creator<ObricConditionalTaskCreateRequest> CREATOR = null;

    @SerializedName("automatic_fields")
    private final String automaticFields;

    @SerializedName("create_time")
    private final String createTime;

    @SerializedName("create_type")
    private final String createType;

    @SerializedName("discover_id")
    private final String discoverId;

    @SerializedName("discover_query")
    private final String discoverQuery;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("instruction")
    private final String instruction;

    @SerializedName("o_omni_instruction_type")
    private final String instructionType;

    @SerializedName("knowledge")
    private final String knowledge;

    @SerializedName("operate_type")
    private final String operateType;

    @SerializedName("origin_query")
    private final String originQuery;

    @SerializedName("short_query")
    private final String shortQuery;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("update_time")
    private final String updateTime;

    @SerializedName("user_select_model")
    private final String userSelectModel;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<ObricConditionalTaskCreateRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ObricConditionalTaskCreateRequest createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            String r104 = r110.readString();
            String r105 = r110.readString();
            String r106 = r110.readString();
            String r107 = r110.readString();
            String r111 = r110.readString();
            String r112 = r110.readString();
            String r113 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            LinkedHashMap r114 = null;
        L9:
            return new ObricConditionalTaskCreateRequest(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r110.readString(), r110.readString(), r110.readString());
        L5:
            int r108 = r110.readInt();
            r114 = new LinkedHashMap(r108);
            int r115 = 0;
        L6:
            if (r115 == r108) goto L9;
            r114.put(r110.readString(), r110.readString());
            r115 = r115 + 1;
            r108 = r108;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ObricConditionalTaskCreateRequest[] newArray(int r100) {
            return new ObricConditionalTaskCreateRequest[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ObricConditionalTaskCreateRequest() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricConditionalTaskCreateRequest copy$default(ObricConditionalTaskCreateRequest r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, Map r218, String r219, String r310, String r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = r110.taskId;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = r110.instructionType;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r102 = r110.createType;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r103 = r110.instruction;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r104 = r110.originQuery;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r105 = r110.shortQuery;
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r106 = r110.createTime;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r107 = r110.updateTime;
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r114 = r110.knowledge;
    L39:
        if ((r312 & 512) == 0) goto L41;
        String r115 = r110.automaticFields;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        String r116 = r110.operateType;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        Map r117 = r110.extra;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        String r118 = r110.discoverId;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        String r119 = r110.discoverQuery;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        String r108 = r110.userSelectModel;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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
        return this.taskId;
    }

    public final String component10() {
        return this.automaticFields;
    }

    public final String component11() {
        return this.operateType;
    }

    public final Map<String, String> component12() {
        return this.extra;
    }

    public final String component13() {
        return this.discoverId;
    }

    public final String component14() {
        return this.discoverQuery;
    }

    public final String component15() {
        return this.userSelectModel;
    }

    public final String component2() {
        return this.instructionType;
    }

    public final String component3() {
        return this.createType;
    }

    public final String component4() {
        return this.instruction;
    }

    public final String component5() {
        return this.originQuery;
    }

    public final String component6() {
        return this.shortQuery;
    }

    public final String component7() {
        return this.createTime;
    }

    public final String component8() {
        return this.updateTime;
    }

    public final String component9() {
        return this.knowledge;
    }

    public final ObricConditionalTaskCreateRequest copy(String r110, String r111, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, Map<String, String> r219, String r310, String r311, String r312) {
        return new ObricConditionalTaskCreateRequest(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricConditionalTaskCreateRequest) == true) goto L8;
        return false;
    L8:
        ObricConditionalTaskCreateRequest r101 = (ObricConditionalTaskCreateRequest) r100;
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.instructionType, r101.instructionType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.createType, r101.createType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.instruction, r101.instruction) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.originQuery, r101.originQuery) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shortQuery, r101.shortQuery) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.knowledge, r101.knowledge) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.automaticFields, r101.automaticFields) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.operateType, r101.operateType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.discoverId, r101.discoverId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.discoverQuery, r101.discoverQuery) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.userSelectModel, r101.userSelectModel) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        String r100 = this.taskId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.instructionType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.createType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.instruction;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.originQuery;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.shortQuery;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.createTime;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.updateTime;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.knowledge;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.automaticFields;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.operateType;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Map<String, String> r134 = this.extra;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.discoverId;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.discoverQuery;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.userSelectModel;
        if (r143 == null) goto L63;
        r101 = r143.hashCode();
    L63:
        return r142 + r101;
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
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

    public String toString() {
        return "ObricConditionalTaskCreateRequest(taskId=" + this.taskId + ", instructionType=" + this.instructionType + ", createType=" + this.createType + ", instruction=" + this.instruction + ", originQuery=" + this.originQuery + ", shortQuery=" + this.shortQuery + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", knowledge=" + this.knowledge + ", automaticFields=" + this.automaticFields + ", operateType=" + this.operateType + ", extra=" + this.extra + ", discoverId=" + this.discoverId + ", discoverQuery=" + this.discoverQuery + ", userSelectModel=" + this.userSelectModel + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.taskId);
        r100.writeString(this.instructionType);
        r100.writeString(this.createType);
        r100.writeString(this.instruction);
        r100.writeString(this.originQuery);
        r100.writeString(this.shortQuery);
        r100.writeString(this.createTime);
        r100.writeString(this.updateTime);
        r100.writeString(this.knowledge);
        r100.writeString(this.automaticFields);
        r100.writeString(this.operateType);
        Map<String, String> r102 = this.extra;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        r100.writeString(this.discoverId);
        r100.writeString(this.discoverQuery);
        r100.writeString(this.userSelectModel);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, String> r104 = r103.next();
        r100.writeString(r104.getKey());
        r100.writeString(r104.getValue());
        goto L7
    }

    public final String getAutomaticFields() {
        return this.automaticFields;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getCreateType() {
        return this.createType;
    }

    public final String getDiscoverId() {
        return this.discoverId;
    }

    public final String getDiscoverQuery() {
        return this.discoverQuery;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getInstruction() {
        return this.instruction;
    }

    public final String getInstructionType() {
        return this.instructionType;
    }

    public final String getKnowledge() {
        return this.knowledge;
    }

    public final String getOperateType() {
        return this.operateType;
    }

    public final String getOriginQuery() {
        return this.originQuery;
    }

    public final String getShortQuery() {
        return this.shortQuery;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getUserSelectModel() {
        return this.userSelectModel;
    }

    public ObricConditionalTaskCreateRequest(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, Map<String, String> r112, String r113, String r114, String r115) {
        this.taskId = r100;
        this.instructionType = r101;
        this.createType = r102;
        this.instruction = r103;
        this.originQuery = r104;
        this.shortQuery = r105;
        this.createTime = r106;
        this.updateTime = r107;
        this.knowledge = r108;
        this.automaticFields = r110;
        this.operateType = r111;
        this.extra = r112;
        this.discoverId = r113;
        this.discoverQuery = r114;
        this.userSelectModel = r115;
    }

    public /* synthetic */ ObricConditionalTaskCreateRequest(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, Map r218, String r219, String r310, String r311, int r312, DefaultConstructorMarker r313) {
        String r100 = null;
        if ((r312 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r312 & 512) == 0) goto L41;
        String r114 = null;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        Map r116 = null;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        String r117 = null;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        String r118 = null;
    L59:
        if ((r312 & 16384) != 0) goto L62;
        r100 = r311;
    L62:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r113, r114, r115, r116, r117, r118, r100);
        return;
    L57:
        r118 = r310;
        goto L59
    L53:
        r117 = r219;
        goto L55
    L49:
        r116 = r218;
        goto L51
    L45:
        r115 = r217;
        goto L47
    L41:
        r114 = r216;
        goto L43
    L37:
        r113 = r215;
        goto L39
    L33:
        r108 = r214;
        goto L35
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
