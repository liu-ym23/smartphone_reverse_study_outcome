package com.bytedance.ee.bear.office.list;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.list.recent.RecentDocumentFragment;
import com.bytedance.ee.bear.list.star.FavoriteFragment;
import com.bytedance.ee.bear.office.export.space.OfficeListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeListDisplayMode;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEnterContext;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.util.info.AppInfoUtils;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSpaceTab.values().length];
            r0[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[OfficeSpaceTab.MINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[OfficeSpaceTab.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[OfficeSpaceTab.FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public static Fragment a(OfficeSpaceTab r4, OfficeListConfig r5, String r6, OfficeSpaceEnterContext r7) {
        Intrinsics.checkNotNullParameter(r4, "tab");
        Intrinsics.checkNotNullParameter(r5, "listConfig");
        Intrinsics.checkNotNullParameter(r7, "enterContext");
        int r0 = a.a[r4.ordinal()];
        if (r0 != 1) goto L5;
        Fragment r1 = new RecentDocumentFragment();
    L16:
        Bundle r2 = new Bundle();
        r2.putSerializable("office_list_tab", r4);
        r2.putSerializable("office_list_config", r5);
        r2.putString("office_list_runtime_id", r6);
        if (r4 != OfficeSpaceTab.RECENT) goto L22;
        Integer r8 = r5.getRecentFilterTabType();
        if (r8 == null) goto L22;
        r2.putInt("office_recent_filter_tab_type", r8.intValue());
    L22:
        if (AppInfoUtils.f().booleanValue() == true) goto L24;
    L26:
        r1.setArguments(r2);
        return r1;
    L24:
        if (r5.getDisplayMode() != OfficeListDisplayMode.FLOW) goto L26;
        r2.putString("office_enter_trace_id", r7.getEnterTraceId());
        r2.putString("office_enter_method", r7.getEnterMethod());
        r2.putLong("office_click_start_ms", r7.getClickStartMs());
        r2.putString("office_preload_request_key_hash", r7.getPreloadRequestKeyHash());
        r2.putString("office_preload_tab", r4.name());
        goto L26
    L5:
        if (r0 != 2) goto L7;
        r1 = new OfficeMyRootFolderHostFragment();
        goto L16
    L7:
        if (r0 != 3) goto L9;
        r1 = new OfficeSharedHostFragment();
        goto L16
    L9:
        if (r0 != 4) goto L12;
        r1 = new FavoriteFragment();
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
