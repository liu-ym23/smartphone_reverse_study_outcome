package com.bytedance.creativex.mediaimport.repository.api;

import android.os.Parcelable;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import ki4.r;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/api/IMediaItem;", "Landroid/os/Parcelable;", "Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;", "id", "", "getId", "()J", "folderId", "", "getFolderId", "()Ljava/lang/String;", "folderName", "getFolderName", "relativePath", "getRelativePath", "name", "getName", PromotionProductPrivilegesStruct.TAGS, "", "getTags", "()Ljava/util/List;", "addTags", "", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMediaItem extends Parcelable, r {
    String getFolderName();

    String getRelativePath();

    @Override // ki4.r
    /* synthetic */ MediaType getType();
}
