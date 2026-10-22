package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v3c.g;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/RelatedContactsBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchChatterInfo;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "mDisableExternalChatter", "", "needBindSummary", "data", "disableExternalChatter", "", "checkDisable", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RelatedContactsBinder extends CommonBinder<SearchChatterInfo> {
    private boolean mDisableExternalChatter;

    public boolean needBindSummary(SearchChatterInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return false;
    }

    public boolean checkDisable(SearchChatterInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.mDisableExternalChatter == true) goto L5;
    L7:
        return false;
    L5:
        if (isExternal(r100) == false) goto L7;
        return true;
    }

    public final void disableExternalChatter(boolean r100) {
        this.mDisableExternalChatter = r100;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ boolean needBindSummary(SearchBaseInfo r100) {
        return needBindSummary((SearchChatterInfo) r100);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ boolean checkDisable(SearchBaseInfo r100) {
        return checkDisable((SearchChatterInfo) r100);
    }

    public RelatedContactsBinder(Context r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mOnItemClickHandler");
        super(r100, r101, null, 4, null);
    }
}
