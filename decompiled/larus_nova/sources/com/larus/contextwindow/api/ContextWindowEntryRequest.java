package com.larus.contextwindow.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowEntryRequest;", "Landroid/os/Parcelable;", "conversationId", "", "anchorMessageId", "botId", "enterFrom", "Lcom/larus/contextwindow/api/ContextWindowEnterFrom;", KtvSubElement.CONTAINER, "Lcom/larus/contextwindow/api/ContextWindowContainer;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/contextwindow/api/ContextWindowEnterFrom;Lcom/larus/contextwindow/api/ContextWindowContainer;)V", "getConversationId", "()Ljava/lang/String;", "getAnchorMessageId", "getBotId", "getEnterFrom", "()Lcom/larus/contextwindow/api/ContextWindowEnterFrom;", "getContainer", "()Lcom/larus/contextwindow/api/ContextWindowContainer;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowEntryRequest implements Parcelable {
    public static final Parcelable.Creator<ContextWindowEntryRequest> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f330237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ContextWindowEnterFrom f330238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ContextWindowContainer f330239e;

    public static final class a implements Parcelable.Creator<ContextWindowEntryRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContextWindowEntryRequest createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ContextWindowEntryRequest(r100.readString(), r100.readString(), r100.readString(), ContextWindowEnterFrom.valueOf(r100.readString()), ContextWindowContainer.valueOf(r100.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final ContextWindowEntryRequest[] newArray(int r100) {
            return new ContextWindowEntryRequest[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContextWindowEntryRequest) == true) goto L8;
        return false;
    L8:
        ContextWindowEntryRequest r101 = (ContextWindowEntryRequest) r100;
        if (Intrinsics.areEqual(this.f330235a, r101.f330235a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330236b, r101.f330236b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f330237c, r101.f330237c) == true) goto L18;
        return false;
    L18:
        if (this.f330238d == r101.f330238d) goto L21;
        return false;
    L21:
        if (this.f330239e == r101.f330239e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f330235a.hashCode() * 31;
        String r101 = this.f330236b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f330237c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((((r104 + r102) * 31) + this.f330238d.hashCode()) * 31) + this.f330239e.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContextWindowEntryRequest(conversationId=" + this.f330235a + ", anchorMessageId=" + this.f330236b + ", botId=" + this.f330237c + ", enterFrom=" + this.f330238d + ", container=" + this.f330239e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f330235a);
        r100.writeString(this.f330236b);
        r100.writeString(this.f330237c);
        r100.writeString(this.f330238d.name());
        r100.writeString(this.f330239e.name());
    }

    public ContextWindowEntryRequest(String r100, String r101, String r102, ContextWindowEnterFrom r103, ContextWindowContainer r104) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r103, "enterFrom");
        Intrinsics.checkNotNullParameter(r104, KtvSubElement.CONTAINER);
        this.f330235a = r100;
        this.f330236b = r101;
        this.f330237c = r102;
        this.f330238d = r103;
        this.f330239e = r104;
    }
}
