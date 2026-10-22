package tr3;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements FilenameFilter {
    public final /* synthetic */ Pattern a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    @Override // java.io.FilenameFilter
    public final boolean accept(File r10, String r11) {
        Matcher r0 = this.a.matcher(r11);
        if (r0.find() == true) goto L5;
        return false;
    L5:
        if (r0.groupCount() != 1) goto L25;
        String r1 = r0.group(1);
        if (r1 != null) goto L10;
        return false;
    L10:
        long r2 = CastLongProtector.parseLong(r1);
        if (r2 > 0) goto L13;
        return false;
    L13:
        if (r2 > this.b) goto L26;
        long r12 = new PolarisFileWrapper(r10, r11).lastModified();
        if (r12 > 0) goto L18;
        return false;
    L18:
        if (r12 < this.c) goto L24;
        return true;
    L24:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    public d(Pattern r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
