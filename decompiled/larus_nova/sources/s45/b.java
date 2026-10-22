package s45;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pattern f540548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f540549b;

    public b(String[] r100) {
        this.f540549b = r100;
        if (r100 != null) goto L5;
    L18:
        tt5.a.h("BlackList", "mBlackPathList is null or empty");
        return;
    L5:
        if (r100.length == 0) goto L18;
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L8:
        String[] r103 = this.f540549b;
        if (r102 >= r103.length) goto L15;
        if (r102 != 0) goto L12;
        r101.append(r103[r102]);
    L13:
        r102 = r102 + 1;
        goto L8
    L12:
        r101.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r101.append(this.f540549b[r102]);
        goto L13
    L15:
        if (TextUtils.isEmpty(r101.toString()) == true) goto L17;
        this.f540548a = PatternProtector.compile(r101.toString());
    L17:
        tt5.a.h("BlackList", "init()...patternStr = " + r101);
    }
}
