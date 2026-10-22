package tr3;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Pattern f547293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f547294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f547295c;

    @Override // java.io.FilenameFilter
    public final boolean accept(File r110, String r111) {
        Matcher r100 = this.f547293a.matcher(r111);
        if (r100.find() == true) goto L5;
        return false;
    L5:
        if (r100.groupCount() != 1) goto L25;
        String r101 = r100.group(1);
        if (r101 != null) goto L10;
        return false;
    L10:
        long r102 = CastLongProtector.parseLong(r101);
        if (r102 > 0) goto L13;
        return false;
    L13:
        if (r102 > this.f547294b) goto L26;
        long r112 = new PolarisFileWrapper(r110, r111).lastModified();
        if (r112 > 0) goto L18;
        return false;
    L18:
        if (r112 < this.f547295c) goto L24;
        return true;
    L24:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    public d(Pattern r100, long r101, long r102) {
        this.f547293a = r100;
        this.f547294b = r101;
        this.f547295c = r102;
    }
}
