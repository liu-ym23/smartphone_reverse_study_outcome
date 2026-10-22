package com.bytedance.creativex.mediaimport.repository.api;

import android.os.Parcelable;
import java.util.List;
import ki4.m;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u001f\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b2\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u0016H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/api/ICategoryItem;", "Landroid/os/Parcelable;", "name", "", "getName", "()Ljava/lang/String;", "categoryType", "Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategoryType;", "getCategoryType", "()Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategoryType;", "getMaterialList", "", "Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;", "addMaterialItem", "", "materialItem", "index", "", "(Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;Ljava/lang/Integer;)V", "getGroups", "Lcom/bytedance/creativex/mediaimport/repository/api/IGroupItem;", "groupStrategy", "Ljava/lang/Class;", "Lcom/bytedance/creativex/mediaimport/repository/api/IGroupStrategy;", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICategoryItem extends Parcelable {
    List<IGroupItem> B0(Class<? extends m> r100);

    String getName();
}
