package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003JK\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR&\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R$\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000f¨\u0006-"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "Landroid/os/Parcelable;", "isEnable", "", "sessionId", "", "content", "clarifyCount", "", "learningSwitch", "evolutionInfo", "(ZLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;)V", "getClarifyCount", "()I", "getContent", "()Ljava/lang/String;", "getEvolutionInfo$annotations", "()V", "getEvolutionInfo", "setEvolutionInfo", "(Ljava/lang/String;)V", "()Z", "getLearningSwitch$annotations", "getLearningSwitch", "setLearningSwitch", "(Z)V", "getSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TaskKnowledge implements Parcelable {
    public static final Parcelable.Creator<TaskKnowledge> CREATOR = null;
    private final int clarifyCount;
    private final String content;
    public String evolutionInfo;
    private final boolean isEnable;
    public boolean learningSwitch;
    private final String sessionId;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<TaskKnowledge> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TaskKnowledge createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            if (r110.readInt() == 0) goto L5;
            boolean r101 = true;
        L6:
            TaskKnowledge r102 = new TaskKnowledge(r101, r110.readString(), r110.readString(), r110.readInt(), false, null, 48, null);
            int r103 = Math.min(r100, 2);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L7:
            if (r105 > r103) goto L17;
            if (r105 != 1) goto L12;
            Object r106 = joa.a.c(r110, r104);
            if (r106 == null) goto L16;
            r102.learningSwitch = ((Boolean) r106).booleanValue();
        L16:
            r105 = r105 + 1;
            goto L7
        L12:
            if (r105 != 2) goto L16;
            Object r107 = joa.a.c(r110, r104);
            if (r107 == null) goto L16;
            r102.evolutionInfo = (String) r107;
        L17:
            if (r105 > r100) goto L19;
            joa.a.d(r110, r104);
            r105 = r105 + 1;
            goto L17
        L19:
            return r102;
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TaskKnowledge[] newArray(int r100) {
            return new TaskKnowledge[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TaskKnowledge(boolean r100, String r101, String r102, int r103, boolean r104, String r105) {
        this.isEnable = r100;
        this.sessionId = r101;
        this.content = r102;
        this.clarifyCount = r103;
        this.learningSwitch = r104;
        this.evolutionInfo = r105;
    }

    public /* synthetic */ TaskKnowledge(boolean r100, String r101, String r110, int r111, boolean r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 8) == 0) goto L5;
        int r102 = 0;
    L7:
        if ((r114 & 16) == 0) goto L9;
        boolean r103 = true;
    L11:
        if ((r114 & 32) == 0) goto L13;
        r113 = null;
    L13:
        this(r100, r101, r110, r102, r103, r113);
        return;
    L9:
        r103 = r112;
        goto L11
    L5:
        r102 = r111;
        goto L7
    }

    public static /* synthetic */ TaskKnowledge copy$default(TaskKnowledge r100, boolean r101, String r102, String r103, int r104, boolean r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.isEnable;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.sessionId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.clarifyCount;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.learningSwitch;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.evolutionInfo;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public static /* synthetic */ void getEvolutionInfo$annotations() {
    }

    public static /* synthetic */ void getLearningSwitch$annotations() {
    }

    public final boolean component1() {
        return this.isEnable;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final String component3() {
        return this.content;
    }

    public final int component4() {
        return this.clarifyCount;
    }

    public final boolean component5() {
        return this.learningSwitch;
    }

    public final String component6() {
        return this.evolutionInfo;
    }

    public final TaskKnowledge copy(boolean r100, String r110, String r111, int r112, boolean r113, String r114) {
        return new TaskKnowledge(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TaskKnowledge) == true) goto L8;
        return false;
    L8:
        TaskKnowledge r101 = (TaskKnowledge) r100;
        if (this.isEnable == r101.isEnable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (this.clarifyCount == r101.clarifyCount) goto L21;
        return false;
    L21:
        if (this.learningSwitch == r101.learningSwitch) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.evolutionInfo, r101.evolutionInfo) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int getClarifyCount() {
        return this.clarifyCount;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getEvolutionInfo() {
        return this.evolutionInfo;
    }

    public final boolean getLearningSwitch() {
        return this.learningSwitch;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        boolean r100 = this.isEnable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.sessionId;
        int r105 = 0;
        if (r104 != null) goto L8;
        int r106 = 0;
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.content;
        if (r108 != null) goto L12;
        int r109 = 0;
    L13:
        int r110 = (((r107 + r109) * 31) + this.clarifyCount) * 31;
        boolean r111 = this.learningSwitch;
        if (r111 == true) goto L17;
        r101 = r111;
    L17:
        int r112 = (r110 + r101) * 31;
        String r113 = this.evolutionInfo;
        if (r113 == null) goto L22;
        r105 = r113.hashCode();
    L22:
        return r112 + r105;
    L12:
        r109 = r108.hashCode();
        goto L13
    L8:
        r106 = r104.hashCode();
        goto L9
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final void setEvolutionInfo(String r100) {
        this.evolutionInfo = r100;
    }

    public final void setLearningSwitch(boolean r100) {
        this.learningSwitch = r100;
    }

    public String toString() {
        return "TaskKnowledge(isEnable=" + this.isEnable + ", sessionId=" + this.sessionId + ", content=" + this.content + ", clarifyCount=" + this.clarifyCount + ", learningSwitch=" + this.learningSwitch + ", evolutionInfo=" + this.evolutionInfo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(2);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeInt(this.isEnable ? 1 : 0);
        r100.writeString(this.sessionId);
        r100.writeString(this.content);
        r100.writeInt(this.clarifyCount);
        r100.writeValue(Boolean.valueOf(this.learningSwitch));
        r100.writeValue(this.evolutionInfo);
    }
}
