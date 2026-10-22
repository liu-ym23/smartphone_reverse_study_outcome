package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\bJ \u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\u0012\u0010\u0015\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000fHÖ\u0001R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeSearchLarkContactInfoByAsrParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "audioFiles", "", "", "([Ljava/lang/String;)V", "getAudioFiles", "()[Ljava/lang/String;", "setAudioFiles", "[Ljava/lang/String;", "component1", "copy", "([Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/OfficeSearchLarkContactInfoByAsrParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfficeSearchLarkContactInfoByAsrParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<OfficeSearchLarkContactInfoByAsrParams> CREATOR = null;
    private String[] audioFiles;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<OfficeSearchLarkContactInfoByAsrParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OfficeSearchLarkContactInfoByAsrParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            OfficeSearchLarkContactInfoByAsrParams r102 = new OfficeSearchLarkContactInfoByAsrParams(r100.createStringArray());
            int r103 = Math.min(r101, 0);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L5;
            r105 = r105 + 1;
        L5:
            if (r105 > r101) goto L7;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L5
        L7:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final OfficeSearchLarkContactInfoByAsrParams[] newArray(int r100) {
            return new OfficeSearchLarkContactInfoByAsrParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSearchLarkContactInfoByAsrParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OfficeSearchLarkContactInfoByAsrParams copy$default(OfficeSearchLarkContactInfoByAsrParams r100, String[] r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.audioFiles;
    L6:
        return r100.copy(r101);
    }

    public final String[] component1() {
        return this.audioFiles;
    }

    public final OfficeSearchLarkContactInfoByAsrParams copy(String[] r100) {
        return new OfficeSearchLarkContactInfoByAsrParams(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSearchLarkContactInfoByAsrParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.audioFiles, ((OfficeSearchLarkContactInfoByAsrParams) r100).audioFiles) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String[] r100 = this.audioFiles;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r100);
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "OfficeSearchLarkContactInfoByAsrParams(audioFiles=" + Arrays.toString(this.audioFiles) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeStringArray(this.audioFiles);
    }

    public final String[] getAudioFiles() {
        return this.audioFiles;
    }

    public OfficeSearchLarkContactInfoByAsrParams(String[] r100) {
        this.audioFiles = r100;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof OfficeSearchLarkContactInfoByAsrParams) == true) goto L5;
        return this;
    L5:
        String[] r101 = this.audioFiles;
        if (r101 != null) goto L9;
        r101 = ((OfficeSearchLarkContactInfoByAsrParams) r100).audioFiles;
    L9:
        return new OfficeSearchLarkContactInfoByAsrParams(r101);
    }

    public final void setAudioFiles(String[] r100) {
        this.audioFiles = r100;
    }

    public /* synthetic */ OfficeSearchLarkContactInfoByAsrParams(String[] r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
