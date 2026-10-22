package gs4;

import com.bytedance.ee.bear.bitable.filter.model.EFilterDuration;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final boolean a(EFilterDuration r100) {
        if (r100 != EFilterDuration.ExactDate) goto L5;
    L8:
        return true;
    L5:
        if (r100 == EFilterDuration.ExactDateRange) goto L8;
        return false;
    }
}
