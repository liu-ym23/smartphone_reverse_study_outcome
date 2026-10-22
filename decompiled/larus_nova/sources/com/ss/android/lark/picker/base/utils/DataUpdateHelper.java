package com.ss.android.lark.picker.base.utils;

import android.content.Context;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchBottomLoadingViewInfo;
import com.ss.android.lark.search.dto.info.SearchColdAndHotInfo;
import com.ss.android.lark.search.dto.info.a;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018J,\u0010\u0019\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018J*\u0010\u001a\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001d\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016H\u0002J&\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016J\u001e\u0010\u001f\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016J\u001e\u0010 \u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016J\u001e\u0010!\u001a\u00020\t2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006#"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/DataUpdateHelper;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "emptyType", "", "getEmptyType", "()I", "setEmptyType", "(I)V", "bottomLoadingState", "getBottomLoadingState", "setBottomLoadingState", "showResult", "", "dataSet", "Ljava/util/LinkedHashSet;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/LinkedHashSet;", "data", "", "resetResult", "addSearchColdAndHotInfo", "loading", "", "addSearchBottomLoadingViewInfo", "hotToColdLoadingView", "clearFakeData", "resetFakeData", "realSize", "BottomLoadingState", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataUpdateHelper {
    private int bottomLoadingState;
    private final Context context;
    private int emptyType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/DataUpdateHelper$BottomLoadingState;", "", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface BottomLoadingState {
        public static final Companion Companion = null;
        public static final int HIDE = 2;
        public static final int SHOW = 1;
        public static final int UNKNOWN = 0;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/DataUpdateHelper$BottomLoadingState$Companion;", "", "<init>", "()V", "UNKNOWN", "", "SHOW", "HIDE", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final int HIDE = 2;
            public static final int SHOW = 1;
            public static final int UNKNOWN = 0;

            static {
                $$INSTANCE = new Companion();
            }

            private Companion() {
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    public final int getBottomLoadingState() {
        return this.bottomLoadingState;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getEmptyType() {
        return this.emptyType;
    }

    public DataUpdateHelper(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
    }

    private final void addSearchBottomLoadingViewInfo(LinkedHashSet<SearchBaseInfo> r100) {
        if (this.bottomLoadingState != 1) goto L6;
        r100.add(new SearchBottomLoadingViewInfo());
        return;
    }

    public final void clearFakeData(LinkedHashSet<SearchBaseInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSet");
        Iterator<SearchBaseInfo> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if ((r101.next() instanceof a) == false) goto L4;
        r101.remove();
        goto L4
    }

    public final int realSize(LinkedHashSet<SearchBaseInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSet");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        if ((!(((SearchBaseInfo) r103) instanceof a)) == false) goto L4;
        r101.add(r103);
        goto L4
    L9:
        return r101.size();
    }

    public final void resetFakeData(LinkedHashSet<SearchBaseInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSet");
        clearFakeData(r100);
        if (r100.size() <= 0) goto L6;
        addSearchColdAndHotInfo$default(this, r100, false, 2, null);
        return;
    }

    public final void setBottomLoadingState(int r100) {
        this.bottomLoadingState = r100;
    }

    public final void setEmptyType(int r100) {
        this.emptyType = r100;
    }

    private final void addSearchColdAndHotInfo(LinkedHashSet<SearchBaseInfo> r100, boolean r101) {
        int r102 = this.emptyType;
        if (r102 != 2) goto L5;
    L6:
        SearchColdAndHotInfo r103 = new SearchColdAndHotInfo(this.emptyType, r101);
        SearchColdAndHotInfo.Companion.getClass();
        r103.setId(SearchColdAndHotInfo.a.a());
        r100.add(r103);
        return;
    L5:
        if (r102 == 3) goto L6;
    }

    public final void hotToColdLoadingView(boolean r100, LinkedHashSet<SearchBaseInfo> r101) {
        Intrinsics.checkNotNullParameter(r101, "dataSet");
        if (r100 == true) goto L5;
        return;
    L5:
        clearFakeData(r101);
        addSearchColdAndHotInfo(r101, r100);
    }

    public final void resetResult(LinkedHashSet<SearchBaseInfo> r100, List<? extends SearchBaseInfo> r101) {
        Intrinsics.checkNotNullParameter(r100, "dataSet");
        Intrinsics.checkNotNullParameter(r101, "data");
        r100.clear();
        r100.addAll(r101);
        addSearchColdAndHotInfo$default(this, r100, false, 2, null);
        addSearchBottomLoadingViewInfo(r100);
    }

    public final void showResult(LinkedHashSet<SearchBaseInfo> r100, List<? extends SearchBaseInfo> r101) {
        Intrinsics.checkNotNullParameter(r100, "dataSet");
        Intrinsics.checkNotNullParameter(r101, "data");
        clearFakeData(r100);
        r100.addAll(r101);
        addSearchColdAndHotInfo$default(this, r100, false, 2, null);
    }

    public static /* synthetic */ void addSearchColdAndHotInfo$default(DataUpdateHelper r100, LinkedHashSet r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.addSearchColdAndHotInfo(r101, r102);
    }
}
