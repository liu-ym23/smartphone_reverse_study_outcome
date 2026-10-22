package fg9;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final String a(long r100, long r101) {
        if (r101 > 0) goto L6;
        return "N/A";
    L6:
        long r102 = ((r100 * 100) + (r101 / ((long) 2))) / r101;
        return (r102 / 100) + '.' + StringsKt.padStart(String.valueOf(r102 % 100), 2, '0') + Permission.EXECUTE;
    }
}
