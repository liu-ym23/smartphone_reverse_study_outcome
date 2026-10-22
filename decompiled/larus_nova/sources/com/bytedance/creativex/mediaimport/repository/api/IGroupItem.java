package com.bytedance.creativex.mediaimport.repository.api;

import android.os.Parcelable;
import java.util.List;
import ki4.r;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u001f\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0010R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/api/IGroupItem;", "Landroid/os/Parcelable;", "name", "", "getName", "()Ljava/lang/String;", "id", "getId", "getMaterialList", "", "Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;", "addMaterialItem", "", "materialItem", "index", "", "(Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;Ljava/lang/Integer;)V", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IGroupItem extends Parcelable {
    void D0(r r100, Integer r101);

    String getId();

    String getName();

    List<r> x();
}
