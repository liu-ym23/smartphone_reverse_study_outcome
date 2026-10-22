package com.bytedance.creativex.mediaimport.repository.internal.main;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.creativex.mediaimport.repository.api.IFolderItem;
import com.bytedance.creativex.mediaimport.repository.api.IGroupItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ki4.a0;
import ki4.m;
import ki4.r;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0010\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\u0019H\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00152\u0006\u0010\u0017\u001a\u00020\fH\u0016J'\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020\u0011H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\u0006\u0010(\u001a\u00020\u0011J\u0016\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006-"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/internal/main/FolderItemInternal;", "Lcom/bytedance/creativex/mediaimport/repository/api/IFolderItem;", "name", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getId", "categoriesMap", "", "Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategoryType;", "Lcom/bytedance/creativex/mediaimport/repository/internal/main/CategoryItemInternal;", "getCategoriesMap$feature_media_import_repository_mainlandRelease", "()Ljava/util/Map;", "size", "", "getSize", "()I", "getGroups", "", "Lcom/bytedance/creativex/mediaimport/repository/api/IGroupItem;", "categoryType", "groupStrategy", "Ljava/lang/Class;", "Lcom/bytedance/creativex/mediaimport/repository/api/IGroupStrategy;", "getMaterialList", "Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;", "addMaterialItem", "", "materialItem", "index", "(Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategoryType;Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;Ljava/lang/Integer;)V", "equals", "", "other", "", "hashCode", "toString", "describeContents", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderItemInternal implements IFolderItem {
    public static final Parcelable.Creator<FolderItemInternal> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f203633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f203634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<a0, CategoryItemInternal> f203635c;

    public static final class a implements Parcelable.Creator<FolderItemInternal> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FolderItemInternal createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new FolderItemInternal(r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final FolderItemInternal[] newArray(int r100) {
            return new FolderItemInternal[r100];
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
        r100.writeString(this.f203633a);
        r100.writeString(this.f203634b);
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IFolderItem
    public final int getSize() {
        Set r100 = ((LinkedHashMap) this.f203635c).entrySet();
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L3:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L10;
        Object r104 = r102.next();
        if (((Map.Entry) r104).getKey() == BuiltInMaterialType.ALL) goto L8;
        r103 = true;
    L8:
        if (r103 == false) goto L3;
        r101.add(r104);
        goto L3
    L10:
        Iterator r105 = r101.iterator();
        int r106 = 0;
    L12:
        if (r105.hasNext() == false) goto L20;
        CategoryItemInternal r107 = (CategoryItemInternal) ((Map.Entry) r105.next()).getValue();
        if (r107 == null) goto L18;
        List<? extends r> r108 = r107.f203630e;
        if (r108 == null) goto L18;
        int r109 = r108.size();
    L19:
        r106 = r106 + r109;
    L18:
        r109 = 0;
        goto L19
    L20:
        return r106;
    }

    public final int hashCode() {
        return (this.f203633a.hashCode() * 31) + this.f203634b.hashCode();
    }

    public final String toString() {
        return "FolderItemInternal(name='" + this.f203633a + "', id='" + this.f203634b + "')";
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IFolderItem
    public final String getId() {
        return this.f203634b;
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IFolderItem
    public final String getName() {
        return this.f203633a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IFolderItem) == true) goto L8;
        return false;
    L8:
        IFolderItem r101 = (IFolderItem) r100;
        if (Intrinsics.areEqual(this.f203633a, r101.getName()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f203634b, r101.getId()) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IFolderItem
    public final List n(BuiltInMaterialType r100) {
        Intrinsics.checkNotNullParameter(r100, "categoryType");
        CategoryItemInternal r101 = (CategoryItemInternal) ((LinkedHashMap) this.f203635c).get(r100);
        if (r101 == null) goto L7;
        List<? extends r> r102 = r101.f203630e;
        if (r102 == null) goto L7;
        return r102;
    L7:
        return CollectionsKt.emptyList();
    }

    public FolderItemInternal(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "id");
        this.f203633a = r100;
        this.f203634b = r101;
        this.f203635c = new LinkedHashMap();
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IFolderItem
    public final List<IGroupItem> p1(a0 r100, Class<? extends m> r101) {
        if (r100 == null) goto L5;
        CategoryItemInternal r102 = (CategoryItemInternal) ((LinkedHashMap) this.f203635c).get(r100);
        if (r102 == null) goto L5;
    L6:
        if (r102 == null) goto L10;
        List<IGroupItem> r103 = r102.B0(r101);
        if (r103 == null) goto L10;
        return r103;
    L10:
        return CollectionsKt.emptyList();
    L5:
        r102 = (CategoryItemInternal) CollectionsKt.firstOrNull(((LinkedHashMap) this.f203635c).values());
        goto L6
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.IFolderItem
    public final void E0(a0 r100, r r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "categoryType");
        Intrinsics.checkNotNullParameter(r101, "materialItem");
        CategoryItemInternal r103 = (CategoryItemInternal) ((LinkedHashMap) this.f203635c).get(r100);
        if (r103 == null) goto L5;
        r103.D0(r101, r102);
    L5:
        BuiltInMaterialType r104 = BuiltInMaterialType.ALL;
        if (r100 == r104) goto L11;
        CategoryItemInternal r105 = (CategoryItemInternal) ((LinkedHashMap) this.f203635c).get(r104);
        if (r105 == null) goto L12;
        r105.D0(r101, r102);
        return;
    L12:
        return;
    }
}
