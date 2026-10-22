package com.ss.android.lark.biz.im.api.bundle;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001eHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006)"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/ChatAIBundle;", "Landroid/os/Parcelable;", "disableAIOnboard", "", "query", "", "action", "trackId", "clickType", "applinkScene", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisableAIOnboard", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getQuery", "()Ljava/lang/String;", "getAction", "getTrackId", "getClickType", "getApplinkScene", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/lark/biz/im/api/bundle/ChatAIBundle;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatAIBundle implements Parcelable {
    public static final Parcelable.Creator<ChatAIBundle> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f409902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f409903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f409904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f409905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f409906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f409907f;

    public static final class a implements Parcelable.Creator<ChatAIBundle> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatAIBundle createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L7;
            Boolean r101 = null;
        L5:
            Boolean r102 = r101;
            return new ChatAIBundle(r102, r100.readString(), r100.readString(), r100.readString(), r100.readString(), r100.readString());
        L7:
            if (r100.readInt() == 0) goto L9;
            boolean r103 = true;
        L10:
            r101 = Boolean.valueOf(r103);
            goto L5
        L9:
            r103 = false;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final ChatAIBundle[] newArray(int r100) {
            return new ChatAIBundle[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ChatAIBundle() {
        this(null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatAIBundle) == true) goto L8;
        return false;
    L8:
        ChatAIBundle r101 = (ChatAIBundle) r100;
        if (Intrinsics.areEqual(this.f409902a, r101.f409902a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f409903b, r101.f409903b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f409904c, r101.f409904c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f409905d, r101.f409905d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f409906e, r101.f409906e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f409907f, r101.f409907f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f409902a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f409903b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f409904c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f409905d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f409906e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f409907f;
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
        return "ChatAIBundle(disableAIOnboard=" + this.f409902a + ", query=" + this.f409903b + ", action=" + this.f409904c + ", trackId=" + this.f409905d + ", clickType=" + this.f409906e + ", applinkScene=" + this.f409907f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Boolean r102 = this.f409902a;
        if (r102 != null) goto L6;
        ?? r103 = 0;
    L5:
        r100.writeInt(r103);
        r100.writeString(this.f409903b);
        r100.writeString(this.f409904c);
        r100.writeString(this.f409905d);
        r100.writeString(this.f409906e);
        r100.writeString(this.f409907f);
        return;
    L6:
        r100.writeInt(1);
        r103 = r102.booleanValue();
        goto L5
    }

    public ChatAIBundle(Boolean r100, String r101, String r102, String r103, String r104, String r105) {
        this.f409902a = r100;
        this.f409903b = r101;
        this.f409904c = r102;
        this.f409905d = r103;
        this.f409906e = r104;
        this.f409907f = r105;
    }
}
