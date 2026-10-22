package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchDomainResult;", "Landroid/os/Parcelable;", "domainList", "", "Lcom/obric/memorydata/sdk/entity/global/GlobalSearchDomain;", "<init>", "(Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getDomainList", "()Ljava/util/List;", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalAssistantSearchDomainResult implements Parcelable {
    public static final a CREATOR = null;
    private final List<GlobalSearchDomain> domainList;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<GlobalAssistantSearchDomainResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalAssistantSearchDomainResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new GlobalAssistantSearchDomainResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalAssistantSearchDomainResult[] newArray(int r100) {
            return new GlobalAssistantSearchDomainResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<GlobalSearchDomain> getDomainList() {
        return this.domainList;
    }

    public GlobalAssistantSearchDomainResult(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        List r101 = r100.createTypedArrayList(GlobalSearchDomain.CREATOR);
        if (r101 != null) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        this(r101);
    }

    public GlobalAssistantSearchDomainResult(List<GlobalSearchDomain> r100) {
        Intrinsics.checkNotNullParameter(r100, "domainList");
        this.domainList = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeTypedList(this.domainList);
    }
}
