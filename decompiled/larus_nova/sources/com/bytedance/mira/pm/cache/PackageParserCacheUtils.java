package com.bytedance.mira.pm.cache;

import android.content.pm.PackageParser;
import com.bytedance.mira.util.OSUtil;

/* JADX INFO: loaded from: classes21.dex */
public class PackageParserCacheUtils {
    public PackageParserCacheUtils() {
    }

    public static PackageParser.Package readPackageWithFile(String r100) {
        if (OSUtil.isAndroidOHigher() == false) goto L7;
        return PackageParserComponentUUUtils.readPackageWithFile(r100);
    L7:
        return PackageParserComponentUtils.readPackageWithFile(r100);
    }

    public static boolean writePackageWithFile(PackageParser.Package r100, String r101) {
        if (OSUtil.isAndroidOHigher() == false) goto L7;
        return PackageParserComponentUUUtils.writePackageWithFile(r100, r101);
    L7:
        return PackageParserComponentUtils.writePackageWithFile(r100, r101);
    }
}
