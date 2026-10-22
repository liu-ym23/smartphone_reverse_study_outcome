package com.larus.dora.impl.noti_v3.overview.viewmodel;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class e {
    public static final List<a> a() {
        return CollectionsKt.listOf(new a[]{new a("finance_security", true), new a(MonitorConstants.SCHEDULE, true), new a("life_service", true), new a("news_info", false), new a("entertainment_recommendation", false)});
    }
}
