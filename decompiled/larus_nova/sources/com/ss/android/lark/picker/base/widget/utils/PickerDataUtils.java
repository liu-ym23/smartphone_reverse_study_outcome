package com.ss.android.lark.picker.base.widget.utils;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchLoadingFooterInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0015\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/utils/PickerDataUtils;", "", "<init>", "()V", "TAG", "", "ERROR_CODE_SERVER_ERROR", "", "ERROR_CODE_OFFLINE", "ERROR_CODE_NETWORK", "ERROR_CODE_TIMEOUT", "mergeSearchResultLists", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "oldData", "newData", "isNetSearchError", "", "errorCode", "(Ljava/lang/Integer;)Z", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerDataUtils {
    private static final int ERROR_CODE_NETWORK = 100053;
    private static final int ERROR_CODE_OFFLINE = 100052;
    private static final int ERROR_CODE_SERVER_ERROR = 100012;
    private static final int ERROR_CODE_TIMEOUT = 100054;
    public static final PickerDataUtils INSTANCE = null;
    private static final String TAG = "PickerDataUtils";

    static {
        INSTANCE = new PickerDataUtils();
    }

    private PickerDataUtils() {
    }

    public final boolean isNetSearchError(Integer r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L9;
    L10:
        if (r100 != null) goto L13;
    L14:
        if (r100 != null) goto L17;
    L19:
        return false;
    L17:
        if (r100.intValue() != ERROR_CODE_TIMEOUT) goto L19;
    L20:
        return true;
    L13:
        if (r100.intValue() == ERROR_CODE_NETWORK) goto L20;
    L9:
        if (r100.intValue() == ERROR_CODE_OFFLINE) goto L20;
    L5:
        if (r100.intValue() == 100012) goto L20;
        goto L6
    }

    public final List<SearchBaseInfo> mergeSearchResultLists(List<? extends SearchBaseInfo> r100, List<? extends SearchBaseInfo> r101) {
        Intrinsics.checkNotNullParameter(r100, "oldData");
        Intrinsics.checkNotNullParameter(r101, "newData");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((!(((SearchBaseInfo) r104) instanceof SearchLoadingFooterInfo)) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        List<SearchBaseInfo> r105 = CollectionsKt.toMutableList(r102);
        List<SearchBaseInfo> r106 = r105;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L10:
        if (r108.hasNext() == false) goto L12;
        r107.add(((SearchBaseInfo) r108.next()).getId());
        goto L10
    L12:
        StringBuilder r109 = new StringBuilder("old: ");
        r109.append(r107);
        r109.append(" , new: ");
        List<? extends SearchBaseInfo> r110 = r101;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r112 = r110.iterator();
    L14:
        if (r112.hasNext() == false) goto L16;
        r111.add(((SearchBaseInfo) r112.next()).getId());
        goto L14
    L16:
        r109.append(r111);
        Log.i(TAG, r109.toString());
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r110.iterator();
    L18:
        if (r114.hasNext() == false) goto L22;
        Object r115 = r114.next();
        if ((!r107.contains(((SearchBaseInfo) r115).getId())) == false) goto L18;
        r113.add(r115);
        goto L18
    L22:
        CollectionsKt.addAll(r105, r113);
        return r105;
    }
}
