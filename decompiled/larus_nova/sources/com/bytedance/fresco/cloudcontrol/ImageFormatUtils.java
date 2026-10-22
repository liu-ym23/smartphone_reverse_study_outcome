package com.bytedance.fresco.cloudcontrol;

import com.ss.android.lark.image.entity.LoadParams;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class ImageFormatUtils {
    private static Set<String> customFormats;

    public ImageFormatUtils() {
    }

    static {
        customFormats = new LinkedHashSet(Arrays.asList(new String[]{"webp", LoadParams.ImageFormat.JPEG, LoadParams.ImageFormat.PNG, "image"}));
    }

    public static String getExpectImageFormat() {
        if (CloudControl.getStaticAdaptivePolicy() == null) goto L10;
        String[] r100 = CloudControl.getStaticAdaptivePolicy();
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L14;
        String r103 = r100[r102];
        if (customFormats.contains(r103) == true) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        return r103;
    L14:
        return "image";
    L10:
        return "image";
    }

    public static void addCustomFormat(String r100) {
        customFormats.add(r100);
    }

    public static void setCustomFormats(Set<String> r100) {
        customFormats.addAll(r100);
    }
}
