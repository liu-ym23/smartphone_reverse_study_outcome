package com.ss.android.lark.biz.im.api.bundle;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/ChatTeamBundle;", "Landroid/os/Parcelable;", "teamId", "", "fromTeamFeed", "", "<init>", "(JZ)V", "getTeamId", "()J", "getFromTeamFeed", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTeamBundle implements Parcelable {
    public static final Parcelable.Creator<ChatTeamBundle> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f409960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f409961b;

    public static final class a implements Parcelable.Creator<ChatTeamBundle> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatTeamBundle createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            long r101 = r100.readLong();
            if (r100.readInt() == 0) goto L5;
            boolean r102 = true;
        L7:
            return new ChatTeamBundle(r101, r102);
        L5:
            r102 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ChatTeamBundle[] newArray(int r100) {
            return new ChatTeamBundle[r100];
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
        if ((r100 instanceof ChatTeamBundle) == true) goto L8;
        return false;
    L8:
        ChatTeamBundle r101 = (ChatTeamBundle) r100;
        if (this.f409960a == r101.f409960a) goto L12;
        return false;
    L12:
        if (this.f409961b == r101.f409961b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f409960a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.f409961b == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "ChatTeamBundle(teamId=" + this.f409960a + ", fromTeamFeed=" + this.f409961b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.f409960a);
        r100.writeInt(this.f409961b ? 1 : 0);
    }

    public ChatTeamBundle(long r100, boolean r101) {
        this.f409960a = r100;
        this.f409961b = r101;
    }
}
