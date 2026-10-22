package com.bytedance.creativex.mediaimport.repository.api;

import android.os.Parcelable;
import java.util.List;
import ki4.a0;
import ki4.m;
import ki4.r;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H&J'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\u0015J.\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0012\b\u0002\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\u0019H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/api/IFolderItem;", "Landroid/os/Parcelable;", "name", "", "getName", "()Ljava/lang/String;", "id", "getId", "size", "", "getSize", "()I", "getMaterialList", "", "Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;", "categoryType", "Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategoryType;", "addMaterialItem", "", "materialItem", "index", "(Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategoryType;Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;Ljava/lang/Integer;)V", "getGroups", "Lcom/bytedance/creativex/mediaimport/repository/api/IGroupItem;", "groupStrategy", "Ljava/lang/Class;", "Lcom/bytedance/creativex/mediaimport/repository/api/IGroupStrategy;", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFolderItem extends Parcelable {

    public static final class a {
        public static /* synthetic */ List a(IFolderItem r100, a0 r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.p1(r101, null);
        }
    }

    void E0(a0 r100, r r101, Integer r102);

    String getId();

    String getName();

    int getSize();

    List n(BuiltInMaterialType r100);

    List<IGroupItem> p1(a0 r100, Class<? extends m> r101);
}
