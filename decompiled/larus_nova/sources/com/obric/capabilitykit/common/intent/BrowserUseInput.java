package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000eJb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/intent/BrowserUseInput;", "Landroid/os/Parcelable;", "index", "", "selector", "", "text", "xpath", "value", "clear_first", "", LocationMonitorConst.SUBMIT, "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getClear_first", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSelector", "()Ljava/lang/String;", "getSubmit", "getText", "getValue", "getXpath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/BrowserUseInput;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BrowserUseInput implements Parcelable {
    public static final Parcelable.Creator<BrowserUseInput> CREATOR = null;
    private final Boolean clear_first;
    private final Integer index;
    private final String selector;
    private final Boolean submit;
    private final String text;
    private final String value;
    private final String xpath;

    public static final class a implements Parcelable.Creator<BrowserUseInput> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BrowserUseInput createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            if (r110.readInt() != 0) goto L5;
            Integer r101 = null;
        L6:
            String r102 = r110.readString();
            String r103 = r110.readString();
            String r104 = r110.readString();
            String r105 = r110.readString();
            int r111 = 1;
            if (r110.readInt() != 0) goto L10;
            Boolean r106 = null;
        L15:
            if (r110.readInt() != 0) goto L18;
            Boolean r112 = null;
        L22:
            BrowserUseInput r107 = new BrowserUseInput(r101, r102, r103, r104, r105, r106, r112);
            int r108 = Math.min(r100, 0);
            ClassLoader r109 = a.class.getClassLoader();
        L23:
            if (r111 > r108) goto L25;
            r111 = r111 + 1;
        L25:
            if (r111 > r100) goto L27;
            joa.a.d(r110, r109);
            r111 = r111 + 1;
            goto L25
        L27:
            return r107;
        L18:
            if (r110.readInt() == 0) goto L20;
            boolean r113 = true;
        L21:
            r112 = Boolean.valueOf(r113);
            goto L22
        L20:
            r113 = false;
            goto L21
        L10:
            if (r110.readInt() == 0) goto L12;
            boolean r114 = true;
        L13:
            r106 = Boolean.valueOf(r114);
            goto L15
        L12:
            r114 = false;
            goto L13
        L5:
            r101 = Integer.valueOf(r110.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final BrowserUseInput[] newArray(int r100) {
            return new BrowserUseInput[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ BrowserUseInput copy$default(BrowserUseInput r100, Integer r101, String r102, String r103, String r104, String r110, Boolean r111, Boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.index;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.selector;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.text;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.xpath;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.value;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.clear_first;
    L20:
        Boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.submit;
    L23:
        Integer r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Integer component1() {
        return this.index;
    }

    public final String component2() {
        return this.selector;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.xpath;
    }

    public final String component5() {
        return this.value;
    }

    public final Boolean component6() {
        return this.clear_first;
    }

    public final Boolean component7() {
        return this.submit;
    }

    public final BrowserUseInput copy(Integer r110, String r111, String r112, String r113, String r114, Boolean r115, Boolean r116) {
        return new BrowserUseInput(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BrowserUseInput) == true) goto L8;
        return false;
    L8:
        BrowserUseInput r101 = (BrowserUseInput) r100;
        if (Intrinsics.areEqual(this.index, r101.index) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.selector, r101.selector) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.xpath, r101.xpath) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.clear_first, r101.clear_first) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.submit, r101.submit) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.index;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.selector;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.text;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.xpath;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.value;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.clear_first;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.submit;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "BrowserUseInput(index=" + this.index + ", selector=" + this.selector + ", text=" + this.text + ", xpath=" + this.xpath + ", value=" + this.value + ", clear_first=" + this.clear_first + ", submit=" + this.submit + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        ?? r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Integer r103 = this.index;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.selector);
        r100.writeString(this.text);
        r100.writeString(this.xpath);
        r100.writeString(this.value);
        Boolean r104 = this.clear_first;
        if (r104 != null) goto L9;
        r100.writeInt(0);
    L10:
        Boolean r105 = this.submit;
        if (r105 != null) goto L13;
    L12:
        r100.writeInt(r102);
        return;
    L13:
        r100.writeInt(1);
        r102 = r105.booleanValue();
        goto L12
    L9:
        r100.writeInt(1);
        r100.writeInt(r104.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L6
    }

    public final Boolean getClear_first() {
        return this.clear_first;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final String getSelector() {
        return this.selector;
    }

    public final Boolean getSubmit() {
        return this.submit;
    }

    public final String getText() {
        return this.text;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getXpath() {
        return this.xpath;
    }

    public BrowserUseInput(Integer r100, String r101, String r102, String r103, String r104, Boolean r105, Boolean r106) {
        this.index = r100;
        this.selector = r101;
        this.text = r102;
        this.xpath = r103;
        this.value = r104;
        this.clear_first = r105;
        this.submit = r106;
    }
}
