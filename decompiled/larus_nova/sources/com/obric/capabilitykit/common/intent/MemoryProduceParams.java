package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJJ\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010(J\t\u0010)\u001a\u00020\nHÖ\u0001J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\nHÖ\u0001J\b\u0010.\u001a\u00020\u0006H\u0016J\u0012\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u00010,H\u0016J\t\u00101\u001a\u00020\u0004HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\nHÖ\u0001R&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R(\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001e\u0012\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MemoryProduceParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "needScreenshot", "", "chatHistory", "targets", "subIntent", "", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getChatHistory$annotations", "()V", "getChatHistory", "()Ljava/lang/String;", "setChatHistory", "(Ljava/lang/String;)V", "getNeedScreenshot", "()Ljava/lang/Boolean;", "setNeedScreenshot", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getQuery", "setQuery", "getSubIntent$annotations", "getSubIntent", "()Ljava/lang/Integer;", "setSubIntent", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTargets$annotations", "getTargets", "setTargets", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/MemoryProduceParams;", "describeContents", "equals", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MemoryProduceParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<MemoryProduceParams> CREATOR = null;
    String chatHistory;
    private Boolean needScreenshot;
    private String query;
    Integer subIntent;
    String targets;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<MemoryProduceParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MemoryProduceParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            if (r110.readInt() != 0) goto L7;
            Boolean r102 = null;
        L11:
            MemoryProduceParams r103 = new MemoryProduceParams(r101, r102, null, null, null, 28, null);
            int r104 = Math.min(r100, 3);
            ClassLoader r105 = a.class.getClassLoader();
            int r106 = 1;
        L12:
            if (r106 > r104) goto L27;
            if (r106 != 1) goto L18;
            Object r107 = joa.a.c(r110, r105);
            if (r107 == null) goto L26;
            r103.chatHistory = (String) r107;
        L26:
            r106 = r106 + 1;
            goto L12
        L18:
            if (r106 != 2) goto L22;
            Object r108 = joa.a.c(r110, r105);
            if (r108 == null) goto L26;
            r103.targets = (String) r108;
            goto L26
        L22:
            if (r106 != 3) goto L26;
            Object r109 = joa.a.c(r110, r105);
            if (r109 == null) goto L26;
            r103.subIntent = (Integer) r109;
        L27:
            if (r106 > r100) goto L29;
            joa.a.d(r110, r105);
            r106 = r106 + 1;
            goto L27
        L29:
            return r103;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r111 = true;
        L10:
            r102 = Boolean.valueOf(r111);
            goto L11
        L9:
            r111 = false;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final MemoryProduceParams[] newArray(int r100) {
            return new MemoryProduceParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public MemoryProduceParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MemoryProduceParams copy$default(MemoryProduceParams r100, String r101, Boolean r102, String r103, String r104, Integer r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.query;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.needScreenshot;
    L8:
        Boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.chatHistory;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.targets;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.subIntent;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public static /* synthetic */ void getChatHistory$annotations() {
    }

    public static /* synthetic */ void getSubIntent$annotations() {
    }

    public static /* synthetic */ void getTargets$annotations() {
    }

    public final String component1() {
        return this.query;
    }

    public final Boolean component2() {
        return this.needScreenshot;
    }

    public final String component3() {
        return this.chatHistory;
    }

    public final String component4() {
        return this.targets;
    }

    public final Integer component5() {
        return this.subIntent;
    }

    public final MemoryProduceParams copy(String r100, Boolean r101, String r110, String r111, Integer r112) {
        return new MemoryProduceParams(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MemoryProduceParams) == true) goto L8;
        return false;
    L8:
        MemoryProduceParams r101 = (MemoryProduceParams) r100;
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.needScreenshot, r101.needScreenshot) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.chatHistory, r101.chatHistory) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.targets, r101.targets) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subIntent, r101.subIntent) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.query;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.needScreenshot;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.chatHistory;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.targets;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.subIntent;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "MemoryProduceParams(query=" + this.query + ", needScreenshot=" + this.needScreenshot + ", chatHistory=" + this.chatHistory + ", targets=" + this.targets + ", subIntent=" + this.subIntent + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v6, types: [int] */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(3);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.query);
        Boolean r102 = this.needScreenshot;
        if (r102 != null) goto L6;
        ?? r103 = 0;
    L5:
        r100.writeInt(r103);
        r100.writeValue(this.chatHistory);
        r100.writeValue(this.targets);
        r100.writeValue(this.subIntent);
        return;
    L6:
        r100.writeInt(1);
        r103 = r102.booleanValue();
        goto L5
    }

    public boolean isParamsCompleted() {
        if (this.query == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getChatHistory() {
        return this.chatHistory;
    }

    public final Boolean getNeedScreenshot() {
        return this.needScreenshot;
    }

    public final String getQuery() {
        return this.query;
    }

    public final Integer getSubIntent() {
        return this.subIntent;
    }

    public final String getTargets() {
        return this.targets;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof MemoryProduceParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.query;
        if (r101 != null) goto L8;
        r101 = ((MemoryProduceParams) r100).query;
    L8:
        String r102 = r101;
        Boolean r103 = this.needScreenshot;
        if (r103 != null) goto L11;
        r103 = ((MemoryProduceParams) r100).needScreenshot;
    L11:
        Boolean r104 = r103;
        String r105 = this.chatHistory;
        if (r105 != null) goto L14;
        r105 = ((MemoryProduceParams) r100).chatHistory;
    L14:
        String r106 = r105;
        String r107 = this.targets;
        if (r107 != null) goto L17;
        r107 = ((MemoryProduceParams) r100).targets;
    L17:
        String r108 = r107;
        Integer r109 = this.subIntent;
        if (r109 != null) goto L20;
        Integer r110 = ((MemoryProduceParams) r100).subIntent;
    L22:
        return new MemoryProduceParams(r102, r104, r106, r108, r110);
    L20:
        r110 = r109;
        goto L22
    }

    public final void setChatHistory(String r100) {
        this.chatHistory = r100;
    }

    public final void setNeedScreenshot(Boolean r100) {
        this.needScreenshot = r100;
    }

    public final void setQuery(String r100) {
        this.query = r100;
    }

    public final void setSubIntent(Integer r100) {
        this.subIntent = r100;
    }

    public final void setTargets(String r100) {
        this.targets = r100;
    }

    public MemoryProduceParams(String r100, Boolean r101, String r102, String r103, Integer r104) {
        this.query = r100;
        this.needScreenshot = r101;
        this.chatHistory = r102;
        this.targets = r103;
        this.subIntent = r104;
    }

    public /* synthetic */ MemoryProduceParams(String r100, Boolean r101, String r102, String r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Boolean r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
