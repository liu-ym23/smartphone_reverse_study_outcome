package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.x.d;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004¢\u0006\u0002\u0010\nJ\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\fJJ\u0010\u001f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010 J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\"HÖ\u0001J\u0012\u0010(\u001a\u00020\u00012\b\u0010)\u001a\u0004\u0018\u00010&H\u0016J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\"HÖ\u0001R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u00060"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemUserRemindParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "options", "", "Lcom/obric/capabilitykit/common/intent/Options;", "content", "", "title", "candidate", "([Lcom/obric/capabilitykit/common/intent/Options;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getCandidate", "()[Ljava/lang/String;", "setCandidate", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getOptions", "()[Lcom/obric/capabilitykit/common/intent/Options;", "setOptions", "([Lcom/obric/capabilitykit/common/intent/Options;)V", "[Lcom/obric/capabilitykit/common/intent/Options;", "getTitle", d.f25925o, "component1", "component2", "component3", "component4", "copy", "([Lcom/obric/capabilitykit/common/intent/Options;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemUserRemindParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemUserRemindParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemUserRemindParams> CREATOR = null;
    private String[] candidate;
    private String content;
    private Options[] options;
    private String title;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemUserRemindParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemUserRemindParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            Options[] r102 = null;
        L9:
            SystemUserRemindParams r103 = new SystemUserRemindParams(r102, r100.readString(), r100.readString(), r100.createStringArray());
            int r104 = Math.min(r101, 0);
            ClassLoader r105 = a.class.getClassLoader();
            int r106 = 1;
        L10:
            if (r106 > r104) goto L12;
            r106 = r106 + 1;
        L12:
            if (r106 > r101) goto L14;
            joa.a.d(r100, r105);
            r106 = r106 + 1;
            goto L12
        L14:
            return r103;
        L5:
            int r107 = r100.readInt();
            Options[] r108 = new Options[r107];
            int r109 = 0;
        L6:
            if (r109 == r107) goto L8;
            r108[r109] = Options.CREATOR.createFromParcel(r100);
            r109 = r109 + 1;
            goto L6
        L8:
            r102 = r108;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final SystemUserRemindParams[] newArray(int r100) {
            return new SystemUserRemindParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SystemUserRemindParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SystemUserRemindParams copy$default(SystemUserRemindParams r100, Options[] r101, String r102, String r103, String[] r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.options;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.title;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.candidate;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Options[] component1() {
        return this.options;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.title;
    }

    public final String[] component4() {
        return this.candidate;
    }

    public final SystemUserRemindParams copy(Options[] r100, String r101, String r102, String[] r103) {
        return new SystemUserRemindParams(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemUserRemindParams) == true) goto L8;
        return false;
    L8:
        SystemUserRemindParams r101 = (SystemUserRemindParams) r100;
        if (Intrinsics.areEqual(this.options, r101.options) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.candidate, r101.candidate) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Options[] r100 = this.options;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.content;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.title;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String[] r110 = this.candidate;
        if (r110 == null) goto L19;
        r101 = Arrays.hashCode(r110);
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = Arrays.hashCode(r100);
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "SystemUserRemindParams(options=" + Arrays.toString(this.options) + ", content=" + this.content + ", title=" + this.title + ", candidate=" + Arrays.toString(this.candidate) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Options[] r103 = this.options;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L8:
        r100.writeString(this.content);
        r100.writeString(this.title);
        r100.writeStringArray(this.candidate);
        return;
    L5:
        r100.writeInt(1);
        int r104 = r103.length;
        r100.writeInt(r104);
    L6:
        if (r102 == r104) goto L8;
        r103[r102].writeToParcel(r100, r101);
        r102 = r102 + 1;
        goto L6
    }

    public final String[] getCandidate() {
        return this.candidate;
    }

    public final String getContent() {
        return this.content;
    }

    public final Options[] getOptions() {
        return this.options;
    }

    public final String getTitle() {
        return this.title;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemUserRemindParams) == true) goto L5;
        return this;
    L5:
        Options[] r101 = this.options;
        if (r101 != null) goto L8;
        r101 = ((SystemUserRemindParams) r100).options;
    L8:
        String r102 = this.content;
        if (r102 != null) goto L11;
        r102 = ((SystemUserRemindParams) r100).content;
    L11:
        String r103 = this.title;
        if (r103 != null) goto L14;
        r103 = ((SystemUserRemindParams) r100).title;
    L14:
        String[] r104 = this.candidate;
        if (r104 != null) goto L18;
        r104 = ((SystemUserRemindParams) r100).candidate;
    L18:
        return new SystemUserRemindParams(r101, r102, r103, r104);
    }

    public final void setCandidate(String[] r100) {
        this.candidate = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setOptions(Options[] r100) {
        this.options = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public SystemUserRemindParams(Options[] r100, String r101, String r102, String[] r103) {
        this.options = r100;
        this.content = r101;
        this.title = r102;
        this.candidate = r103;
    }

    public /* synthetic */ SystemUserRemindParams(Options[] r100, String r101, String r102, String[] r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
