package com.bytedance.creativex.mediaimport.repository.internal.main;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.creativex.mediaimport.repository.api.IGroupItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import ki4.r;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H\u0016J\u001f\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020\u001fH\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\u0006\u0010&\u001a\u00020\u001fJ\u0016\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0019¨\u0006+"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/internal/main/GroupItemInternal;", "Lcom/bytedance/creativex/mediaimport/repository/api/IGroupItem;", "name", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getId", "isIterating", "", "isIterating$feature_media_import_repository_mainlandRelease", "()Z", "setIterating$feature_media_import_repository_mainlandRelease", "(Z)V", "internalItems", "", "Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;", "getInternalItems$feature_media_import_repository_mainlandRelease", "()Ljava/util/List;", "items", "", "getItems$feature_media_import_repository_mainlandRelease", "setItems$feature_media_import_repository_mainlandRelease", "(Ljava/util/List;)V", "getMaterialList", "addMaterialItem", "", "materialItem", "index", "", "(Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;Ljava/lang/Integer;)V", "equals", "other", "", "hashCode", "toString", "describeContents", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupItemInternal implements IGroupItem {
    public static final Parcelable.Creator<GroupItemInternal> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f203636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f203637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<r> f203638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends r> f203639d;

    public static final class a implements Parcelable.Creator<GroupItemInternal> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GroupItemInternal createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new GroupItemInternal(r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final GroupItemInternal[] newArray(int r100) {
            return new GroupItemInternal[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f203636a);
        r100.writeString(this.f203637b);
    }

    public final int hashCode() {
        return (this.f203636a.hashCode() * 31) + this.f203637b.hashCode();
    }

    public final String toString() {
        return "GroupItemInternal(name='" + this.f203636a + "', id='" + this.f203637b + "')";
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IGroupItem
    public final String getId() {
        return this.f203637b;
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IGroupItem
    public final String getName() {
        return this.f203636a;
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IGroupItem
    public final List<r> x() {
        return this.f203639d;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IGroupItem) == true) goto L8;
        return false;
    L8:
        IGroupItem r101 = (IGroupItem) r100;
        if (Intrinsics.areEqual(this.f203636a, r101.getName()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f203637b, r101.getId()) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public GroupItemInternal(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "id");
        this.f203636a = r100;
        this.f203637b = r101;
        this.f203638c = new ArrayList();
        this.f203639d = CollectionsKt.emptyList();
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IGroupItem
    public final void D0(r r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "materialItem");
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
        ListProtector.add(this.f203638c, r102, r100);
    L6:
        this.f203639d = CollectionsKt.toList(this.f203638c);
        return;
    L5:
        ((ArrayList) this.f203638c).add(r100);
        goto L6
    }
}
