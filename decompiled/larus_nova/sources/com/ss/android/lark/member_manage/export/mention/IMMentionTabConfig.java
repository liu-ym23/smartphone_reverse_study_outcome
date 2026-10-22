package com.ss.android.lark.member_manage.export.mention;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/member_manage/export/mention/IMMentionTabConfig;", "Landroid/os/Parcelable;", "type", "Lcom/ss/android/lark/member_manage/export/mention/IMMentionViewType;", "tabRes", "", "<init>", "(Lcom/ss/android/lark/member_manage/export/mention/IMMentionViewType;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getType", "()Lcom/ss/android/lark/member_manage/export/mention/IMMentionViewType;", "getTabRes", "()Ljava/lang/String;", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "group-member-manage-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMMentionTabConfig implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IMMentionViewType f431656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f431657b;

    public static final class a implements Parcelable.Creator<IMMentionTabConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final IMMentionTabConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Serializable r101 = r100.readSerializable();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.member_manage.export.mention.IMMentionViewType");
            IMMentionViewType r102 = (IMMentionViewType) r101;
            String r103 = r100.readString();
            if (r103 != null) goto L6;
            r103 = "";
        L6:
            return new IMMentionTabConfig(r102, r103);
        }

        @Override // android.os.Parcelable.Creator
        public final IMMentionTabConfig[] newArray(int r100) {
            return new IMMentionTabConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final IMMentionViewType getType() {
        return this.f431656a;
    }

    public IMMentionTabConfig(IMMentionViewType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "tabRes");
        this.f431656a = r100;
        this.f431657b = r101;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeSerializable(this.f431656a);
        r100.writeString(this.f431657b);
    }
}
