package com.ss.android.lark.search.dto.info;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.larksuite.framework.utils.e;
import com.larksuite.framework.utils.f;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchCalendarTitleInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", DyPayConstant.KEY_START_TIME, "", "<init>", "(J)V", "getStartTime", "()J", "isToday", "", "()Z", BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY, "", "getDay", "()Ljava/lang/String;", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchCalendarTitleInfo extends SearchBaseInfo {
    private final String day;
    private final boolean isToday;
    private final long startTime;

    public final String getDay() {
        return this.day;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final boolean isToday() {
        return this.isToday;
    }

    public SearchCalendarTitleInfo(long r100) {
        this.startTime = r100;
        Date r101 = new Date(r100);
        long r102 = System.currentTimeMillis();
        f.a r103 = f.f285956a;
        TimeZone r104 = TimeZone.getDefault();
        f.a r105 = f.f285956a;
        boolean r106 = false;
        f.b r107 = r105.c(new Object[]{r104, null});
        Calendar r108 = r107.f285959b;
        f.d(r108, r100);
        int r110 = r108.get(6);
        f.d(r108, r102);
        int r109 = r108.get(6);
        r105.d(r107);
        if (r110 != r109) goto L5;
        r106 = true;
    L5:
        this.isToday = r106;
        setFirstInfoForInit(r106);
        int r111 = e.f285955a;
        Calendar r112 = Calendar.getInstance();
        r112.setTime(r101);
        this.day = String.valueOf(r112.get(5));
    }
}
