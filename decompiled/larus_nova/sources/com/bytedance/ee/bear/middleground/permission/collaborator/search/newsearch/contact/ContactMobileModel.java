package com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.contact;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/newsearch/contact/ContactMobileModel;", "Landroid/os/Parcelable;", "mobilePhone", "", "<init>", "(Ljava/lang/String;)V", "getMobilePhone", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactMobileModel implements Parcelable {
    public static final Parcelable.Creator<ContactMobileModel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f233476a;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<ContactMobileModel> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContactMobileModel createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ContactMobileModel(r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ContactMobileModel[] newArray(int r100) {
            return new ContactMobileModel[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContactMobileModel) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f233476a, ((ContactMobileModel) r100).f233476a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f233476a.hashCode();
    }

    public final String toString() {
        return "ContactMobileModel(mobilePhone=" + this.f233476a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f233476a);
    }

    public ContactMobileModel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mobilePhone");
        this.f233476a = r100;
    }
}
