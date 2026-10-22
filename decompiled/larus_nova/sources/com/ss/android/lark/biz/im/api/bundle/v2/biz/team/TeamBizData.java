package com.ss.android.lark.biz.im.api.bundle.v2.biz.team;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.biz.im.api.bundle.ChatTeamBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.annotation.BundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@BundleKey("data_team_key")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0016\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0019R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\f\"\u0004\b\u000f\u0010\u000e¨\u0006$"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/team/TeamBizData;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/IBundle;", "teamBundle", "Lcom/ss/android/lark/biz/im/api/bundle/ChatTeamBundle;", "isTeamOpenChat", "", "isTeamVisitor", "<init>", "(Lcom/ss/android/lark/biz/im/api/bundle/ChatTeamBundle;ZZ)V", "getTeamBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/ChatTeamBundle;", "()Z", "setTeamOpenChat", "(Z)V", "setTeamVisitor", "putInBundle", "", "bundle", "Landroid/os/Bundle;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TeamBizData implements Parcelable {
    public static final Parcelable.Creator<TeamBizData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatTeamBundle f410056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f410057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f410058c;

    public static final class a implements Parcelable.Creator<TeamBizData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TeamBizData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            ChatTeamBundle r101 = null;
        L6:
            ChatTeamBundle r102 = r101;
            boolean r103 = false;
            if (r100.readInt() == 0) goto L9;
            boolean r104 = true;
        L11:
            if (r100.readInt() == 0) goto L14;
            r103 = true;
        L14:
            return new TeamBizData(r102, r104, r103);
        L9:
            r104 = false;
            goto L11
        L5:
            r101 = ChatTeamBundle.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TeamBizData[] newArray(int r100) {
            return new TeamBizData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TeamBizData() {
        this(null, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TeamBizData) == true) goto L8;
        return false;
    L8:
        TeamBizData r101 = (TeamBizData) r100;
        if (Intrinsics.areEqual(this.f410056a, r101.f410056a) == true) goto L12;
        return false;
    L12:
        if (this.f410057b == r101.f410057b) goto L15;
        return false;
    L15:
        if (this.f410058c == r101.f410058c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        ChatTeamBundle r100 = this.f410056a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.f410057b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f410058c == true) goto L15;
        r103 = 1237;
    L15:
        return r105 + r103;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TeamBizData(teamBundle=" + this.f410056a + ", isTeamOpenChat=" + this.f410057b + ", isTeamVisitor=" + this.f410058c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        ChatTeamBundle r102 = this.f410056a;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeInt(this.f410057b ? 1 : 0);
        r100.writeInt(this.f410058c ? 1 : 0);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public /* synthetic */ TeamBizData(ChatTeamBundle r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, false, false);
    }

    public TeamBizData(ChatTeamBundle r100, boolean r101, boolean r102) {
        this.f410056a = r100;
        this.f410057b = r101;
        this.f410058c = r102;
    }
}
