package com.ss.android.lark.forwardv3.messageforward;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/ss/android/lark/forwardv3/messageforward/SingleMessageForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "singleSource", "", "getSingleSource$annotations", "getSingleSource", "()I", "setSingleSource", "(I)V", "originMergeForwardId", "", "getOriginMergeForwardId", "()Ljava/lang/String;", "setOriginMergeForwardId", "(Ljava/lang/String;)V", "favoriteId", "getFavoriteId", "setFavoriteId", "isThreadRootMsg", "", "()Z", "setThreadRootMsg", "(Z)V", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleMessageForwardContent implements IForwardContent {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f425421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f425422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f425423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f425424d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f425425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f425426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f425427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f425428d;

        public a() {
            this.f425426b = "";
            this.f425427c = "";
        }
    }

    public static final class b implements Parcelable.Creator<SingleMessageForwardContent> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final SingleMessageForwardContent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            SingleMessageForwardContent r101 = new SingleMessageForwardContent();
            r101.f425421a = r100.readInt();
            String r102 = r100.readString();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.f425422b = r102;
            String r104 = r100.readString();
            if (r104 == null) goto L9;
            r103 = r104;
        L9:
            r101.f425423c = r103;
            boolean r105 = true;
            if (r100.readInt() == 1) goto L13;
            r105 = false;
        L13:
            r101.f425424d = r105;
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final SingleMessageForwardContent[] newArray(int r100) {
            return new SingleMessageForwardContent[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public SingleMessageForwardContent() {
        this.f425422b = "";
        this.f425423c = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f425421a);
        r100.writeString(this.f425422b);
        r100.writeString(this.f425423c);
        r100.writeInt(this.f425424d ? 1 : 0);
    }
}
