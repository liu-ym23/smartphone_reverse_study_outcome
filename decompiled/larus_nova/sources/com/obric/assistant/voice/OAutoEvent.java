package com.obric.assistant.voice;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/voice/OAutoEvent;", "Landroid/os/Parcelable;", "id", "", "content", "stateInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Parcelable;)V", "()V", "getId", "()Ljava/lang/String;", "getContent", "getStateInfo", "()Landroid/os/Parcelable;", "toString", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OAutoEvent implements Parcelable {
    public static final Parcelable.Creator<OAutoEvent> CREATOR = null;

    @SerializedName("content")
    private final String content;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f394364id;

    @SerializedName("stateInfo")
    private final Parcelable stateInfo;

    public static final class a implements Parcelable.Creator<OAutoEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OAutoEvent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new OAutoEvent(r100.readString(), r100.readString(), r100.readParcelable(OAutoEvent.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final OAutoEvent[] newArray(int r100) {
            return new OAutoEvent[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public OAutoEvent() {
        this(null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OAutoEvent) == true) goto L8;
        return false;
    L8:
        OAutoEvent r101 = (OAutoEvent) r100;
        if (Intrinsics.areEqual(this.f394364id, r101.f394364id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.stateInfo, r101.stateInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f394364id;
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
        Parcelable r107 = this.stateInfo;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f394364id);
        r100.writeString(this.content);
        r100.writeParcelable(this.stateInfo, r101);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("id ");
        r100.append(this.f394364id);
        r100.append(" content.length ");
        String r101 = this.content;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.length());
    L6:
        r100.append(r102);
        r100.append(" stateInfo ");
        if (this.stateInfo == null) goto L9;
        boolean r103 = true;
    L10:
        r100.append(r103);
        return r100.toString();
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final String a() {
        return this.content;
    }

    public OAutoEvent(String r100, String r101, Parcelable r102) {
        this.f394364id = r100;
        this.content = r101;
        this.stateInfo = r102;
    }
}
