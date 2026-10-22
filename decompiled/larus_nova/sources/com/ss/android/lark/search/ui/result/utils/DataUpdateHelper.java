package com.ss.android.lark.search.ui.result.utils;

import android.content.Context;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchColdAndHotInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class DataUpdateHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f440308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f440309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f440310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f440311d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/search/ui/result/utils/DataUpdateHelper$BottomLoadingState;", "", "Companion", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface BottomLoadingState {
        public static final a Companion = null;
        public static final int HIDE = 2;
        public static final int SHOW = 1;
        public static final int UNKNOWN = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f440312a = null;

            static {
                f440312a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f440312a;
        }
    }

    public interface a {
        String a();
    }

    public final Context getContext() {
        return this.f440308a;
    }

    public DataUpdateHelper(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f440308a = r100;
    }

    public static void b(LinkedHashSet r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSet");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if ((((SearchBaseInfo) r101.next()) instanceof com.ss.android.lark.search.dto.info.a) == false) goto L4;
        r101.remove();
        goto L4
    }

    public final void a(LinkedHashSet<SearchBaseInfo> r100, boolean r101) {
        int r102 = this.f440309b;
        if (r102 != 2) goto L5;
    L8:
        SearchColdAndHotInfo r103 = new SearchColdAndHotInfo(this.f440309b, r101);
        a r104 = this.f440311d;
        if (r104 == null) goto L11;
        String r105 = r104.a();
    L12:
        r103.setEmptyShowMsg(r105);
        SearchColdAndHotInfo.Companion.getClass();
        r103.setId(SearchColdAndHotInfo.a.a());
        r100.add(r103);
        return;
    L11:
        r105 = null;
        goto L12
    L5:
        if (r102 == 3) goto L8;
        if (r102 == 6) goto L8;
    }
}
