package com.bytedance.creativex.mediaimport.repository.internal.main;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.creativex.mediaimport.repository.api.ICategoryItem;
import com.bytedance.creativex.mediaimport.repository.api.IGroupItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ki4.a0;
import ki4.b;
import ki4.m;
import ki4.r;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001c\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000b\u0010\u0004\u001a\u00070\u0005¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u001bH\u0016J\u001f\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u0010%J \u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001b2\u0010\u0010(\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001a\u00020$H\u0016J\b\u0010.\u001a\u00020\u0003H\u0016J\u0006\u0010/\u001a\u00020$J\u0016\u00100\u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\u00070\u0005¢\u0006\u0002\b\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR4\u0010\r\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u000e0\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001e¨\u00064"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/internal/main/CategoryItemInternal;", "Lcom/bytedance/creativex/mediaimport/repository/api/ICategoryItem;", "name", "", "categoryType", "Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategoryType;", "Lkotlinx/android/parcel/RawValue;", "<init>", "(Ljava/lang/String;Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategoryType;)V", "getName", "()Ljava/lang/String;", "getCategoryType", "()Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategoryType;", "strategyToGroupsMap", "", "Ljava/lang/Class;", "Lcom/bytedance/creativex/mediaimport/repository/api/IGroupStrategy;", "Lcom/bytedance/creativex/mediaimport/repository/api/GroupKey;", "Lcom/bytedance/creativex/mediaimport/repository/internal/main/GroupItemInternal;", "getStrategyToGroupsMap$feature_media_import_repository_mainlandRelease", "()Ljava/util/Map;", "internalItems", "", "Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;", "getInternalItems$feature_media_import_repository_mainlandRelease", "()Ljava/util/List;", "items", "", "getItems$feature_media_import_repository_mainlandRelease", "setItems$feature_media_import_repository_mainlandRelease", "(Ljava/util/List;)V", "getMaterialList", "addMaterialItem", "", "materialItem", "index", "", "(Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;Ljava/lang/Integer;)V", "getGroups", "Lcom/bytedance/creativex/mediaimport/repository/api/IGroupItem;", "groupStrategy", "equals", "", "other", "", "hashCode", "toString", "describeContents", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CategoryItemInternal implements ICategoryItem {
    public static final Parcelable.Creator<CategoryItemInternal> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f203626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f203627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<? extends m>, Map<b, GroupItemInternal>> f203628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<r> f203629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends r> f203630e;

    public static final class a implements Parcelable.Creator<CategoryItemInternal> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CategoryItemInternal createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new CategoryItemInternal(r100.readString(), (a0) r100.readValue(CategoryItemInternal.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final CategoryItemInternal[] newArray(int r100) {
            return new CategoryItemInternal[r100];
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
        r100.writeString(this.f203626a);
        r100.writeValue(this.f203627b);
    }

    public final int hashCode() {
        return this.f203626a.hashCode();
    }

    public final String toString() {
        return "CategoryItemInternal(name='" + this.f203626a + "')";
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.ICategoryItem
    public final String getName() {
        return this.f203626a;
    }

    @Override // com.bytedance.creativex.mediaimport.repository.api.ICategoryItem
    public final List<IGroupItem> B0(Class<? extends m> r100) {
        if (r100 == null) goto L7;
        Map r101 = (Map) ((LinkedHashMap) this.f203628c).get(r100);
        if (r101 != null) goto L6;
        r101 = MapsKt.emptyMap();
    L6:
        if (r101 == null) goto L7;
    L8:
        if (r101 == null) goto L14;
        Collection r102 = r101.values();
        if (r102 == null) goto L14;
        List<IGroupItem> r103 = CollectionsKt.toList(r102);
        if (r103 == null) goto L14;
        return r103;
    L14:
        return CollectionsKt.emptyList();
    L7:
        r101 = (Map) CollectionsKt.firstOrNull(((LinkedHashMap) this.f203628c).values());
        goto L8
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ICategoryItem) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f203626a, ((ICategoryItem) r100).getName()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public CategoryItemInternal(String r100, a0 r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "categoryType");
        this.f203626a = r100;
        this.f203627b = r101;
        this.f203628c = new LinkedHashMap();
        this.f203629d = new ArrayList();
        this.f203630e = CollectionsKt.emptyList();
    }

    public final void D0(r r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "materialItem");
        Iterator<T> r102 = this.f203629d.iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        Object r103 = r102.next();
        r r104 = (r) r103;
        if (Intrinsics.areEqual(r104.getPath(), r100.getPath()) == false) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L4;
    L16:
        if (((r) r103) != null) goto L24;
        if (r101 == null) goto L19;
        ListProtector.add(this.f203629d, r101.intValue(), r100);
    L20:
        this.f203630e = CollectionsKt.toList(this.f203629d);
        Iterator<T> r106 = B0(null).iterator();
    L22:
        if (r106.hasNext() == false) goto L31;
        ((IGroupItem) r106.next()).D0(r100, r101);
        goto L22
    L31:
        return;
    L19:
        ((ArrayList) this.f203629d).add(r100);
        goto L20
    L24:
        return;
    L8:
        if (Intrinsics.areEqual(r104.getUri().toString(), r100.getUri().toString()) == true) goto L11;
        r105 = false;
        goto L12
    L14:
        r103 = null;
        goto L16
    }
}
