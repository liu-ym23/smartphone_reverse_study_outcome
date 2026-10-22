package com.ss.android.ugc.effectmanager.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/utils/TimeUtils;", "", "()V", "currentTime", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class TimeUtils {
    public static final TimeUtils INSTANCE = null;

    private TimeUtils() {
    }

    static {
        INSTANCE = new TimeUtils();
    }

    public final String currentTime() {
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS").format(new Date());
    }
}
