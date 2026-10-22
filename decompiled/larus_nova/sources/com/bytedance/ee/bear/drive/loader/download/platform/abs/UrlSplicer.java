package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import s45.p;

/* JADX INFO: loaded from: classes16.dex */
public class UrlSplicer {
    private static final String TAG = "DrivePlatform_UrlSplicer";

    private UrlSplicer() {
    }

    private static int correctServerPreviewType(int r100) {
        if (r100 != 0) goto L5;
        tt5.a.h(TAG, "correctServerPreviewType() pdf 0 to 9 for download url");
        return 9;
    L5:
        return r100;
    }

    public static String downloadAllUrl(String r100) {
        String r101 = ((b0) org.koin.java.a.a(b0.class)).r();
        boolean r102 = !TextUtils.isEmpty(r101);
        if (r102 == true) goto L6;
        r101 = p.f540584u;
    L6:
        tt5.a.h(TAG, "downloadAllUrl useDriveDomain = " + r102 + ", apiDomain = " + r101);
        String r103 = "https://" + r101 + "/space/api/box/stream/download/all/" + r100;
        tt5.a.h(TAG, "downloadAllUrl url= " + du5.b.f(r103));
        return r103;
    }

    public static synchronized String slicePreviewUrl(LinkedHashMap<String, String> r100) {
        monitor-enter(UrlSplicer.class);
        if (r100 == null) goto L17;
    L14:
        th = move-exception;
        tt5.a.d(TAG, th.getMessage());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L6:
        if (r100.size() <= 0) goto L17;
        Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r101.hasNext() == false) goto L17;
        String r102 = r101.next().getValue();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r102) == true) goto L9;
        monitor-exit(UrlSplicer.class);
        return r102;
    L17:
        monitor-exit(UrlSplicer.class);
        return "";
    }

    public static String spliceV1PreviewSubUrl(f85.a r100) {
        String r101 = "https://" + p.f540584u + "/space/api/box/stream/download/preview_sub/" + ((f85.a.C5868a) r100.f558532a).f558557a + "?version=" + ((f85.a.C5868a) r100.f558532a).f475873p + "&preview_type=" + correctServerPreviewType(r100.f558536e);
        if (TextUtils.isEmpty(((f85.a.C5868a) r100.f558532a).f558564h) == true) goto L6;
        r101 = r101 + "&extra=" + ((f85.a.C5868a) r100.f558532a).f558564h;
    L6:
        if (TextUtils.isEmpty(((f85.a.C5868a) r100.f558532a).f475871n) == true) goto L8;
        r101 = r101 + "&mount_point=" + ((f85.a.C5868a) r100.f558532a).f475871n;
    L8:
        tt5.a.h(TAG, "spliceV1PreviewSubUrl notExpiredUrl = " + du5.b.f(r101));
        return r101;
    }

    public static String spliceV1PreviewUrl(f85.a r100) {
        String r101 = ((b0) org.koin.java.a.a(b0.class)).r();
        boolean r102 = !TextUtils.isEmpty(r101);
        if (r102 == true) goto L6;
        r101 = p.f540584u;
    L6:
        tt5.a.h(TAG, "spliceV1PreviewUrl useDriveDomain = " + r102 + ", apiDomain = " + r101);
        String r103 = "https://" + r101 + "/space/api/box/stream/download/preview/" + ((f85.a.C5868a) r100.f558532a).f558557a + "?version=" + ((f85.a.C5868a) r100.f558532a).f475873p + "&preview_type=" + correctServerPreviewType(r100.f558536e);
        if (TextUtils.isEmpty(((f85.a.C5868a) r100.f558532a).f558564h) == true) goto L10;
        r103 = r103 + "&extra=" + ((f85.a.C5868a) r100.f558532a).f558564h;
    L10:
        if (TextUtils.isEmpty(((f85.a.C5868a) r100.f558532a).f475871n) == true) goto L12;
        r103 = r103 + "&mount_point=" + ((f85.a.C5868a) r100.f558532a).f475871n;
    L12:
        tt5.a.h(TAG, "spliceV1PreviewUrl notExpiredUrl = " + du5.b.f(r103));
        return r103;
    }

    public static String spliceV2PreviewSubUrl(f85.b r100) {
        String r101 = "https://" + p.f540584u + "/space/api/box/stream/sdk/download/preview_sub/?app_id=" + ((f85.b.a) r100.f558532a).f475877m + "&app_file_id=" + ((f85.b.a) r100.f558532a).f558557a + "&preview_type=" + correctServerPreviewType(r100.f558536e);
        if (TextUtils.isEmpty(((f85.b.a) r100.f558532a).f475878n) == true) goto L5;
        r101 = r101 + "&auth_extra=" + ((f85.b.a) r100.f558532a).f475878n;
    L5:
        tt5.a.h(TAG, "spliceV2PreviewUrl url= " + du5.b.f(r101));
        return r101;
    }

    public static String spliceV2PreviewUrl(f85.b r100) {
        String r101 = ((b0) org.koin.java.a.a(b0.class)).r();
        boolean r102 = !TextUtils.isEmpty(r101);
        if (r102 == true) goto L6;
        r101 = p.f540584u;
    L6:
        tt5.a.h(TAG, "spliceV2PreviewUrl useDriveDomain = " + r102 + ", apiDomain = " + r101);
        String r103 = "https://" + r101 + "/space/api/box/stream/sdk/download/preview/?app_id=" + ((f85.b.a) r100.f558532a).f475877m + "&app_file_id=" + ((f85.b.a) r100.f558532a).f558557a + "&preview_type=" + correctServerPreviewType(r100.f558536e);
        if (TextUtils.isEmpty(((f85.b.a) r100.f558532a).f475878n) == true) goto L9;
        r103 = r103 + "&auth_extra=" + ((f85.b.a) r100.f558532a).f475878n;
    L9:
        tt5.a.h(TAG, "spliceV2PreviewUrl url= " + du5.b.f(r103));
        return r103;
    }

    public static String spliceV2SourceUrl(f85.b r100) {
        String r101 = ((b0) org.koin.java.a.a(b0.class)).r();
        boolean r102 = !TextUtils.isEmpty(r101);
        if (r102 == true) goto L6;
        r101 = p.f540584u;
    L6:
        tt5.a.h(TAG, "spliceV2SourceUrl useDriveDomain = " + r102 + ", apiDomain = " + r101);
        String r103 = "https://" + r101 + "/space/api/box/stream/sdk/download/preview/?app_id=" + ((f85.b.a) r100.f558532a).f475877m + "&app_file_id=" + ((f85.b.a) r100.f558532a).f558557a + "&preview_type=16";
        if (TextUtils.isEmpty(((f85.b.a) r100.f558532a).f475878n) == true) goto L9;
        r103 = r103 + "&auth_extra=" + ((f85.b.a) r100.f558532a).f475878n;
    L9:
        tt5.a.h(TAG, "spliceV2SourceUrl url= " + du5.b.f(r103));
        return r103;
    }

    public static String spliceV2SourceUrl(String r100, String r101) {
        String r102 = ((b0) org.koin.java.a.a(b0.class)).r();
        boolean r103 = !TextUtils.isEmpty(r102);
        if (r103 == true) goto L6;
        r102 = p.f540584u;
    L6:
        tt5.a.h(TAG, "spliceV2SourceUrl useDriveDomain = " + r103 + ", apiDomain = " + r102);
        String r104 = "https://" + r102 + "/space/api/box/stream/download/preview/" + r100 + "?version=" + r101 + "&preview_type=16";
        tt5.a.h(TAG, "spliceV2SourceUrl url= " + du5.b.f(r104));
        return r104;
    }

    private static String safeAddParameter(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return r100;
    L7:
        if (r100.contains("&" + r101 + ContainerUtils.KEY_VALUE_DELIMITER) == false) goto L10;
        return r100;
    L10:
        if (r100.contains("?") == false) goto L14;
        return r100 + "&" + r101 + ContainerUtils.KEY_VALUE_DELIMITER + r102;
    L14:
        return r100 + "?" + r101 + ContainerUtils.KEY_VALUE_DELIMITER + r102;
    }

    public static String sliceExtraTranCodeCodeUrl(String r100, String r101, String r102) {
    L13:
        th = move-exception;
        tt5.a.d(TAG, th.getMessage());
        return r100;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r100;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L8;
        String r103 = safeAddParameter(r100, "extra", r101);     // Catch: Throwable -> L13
    L10:
        if (TextUtils.isEmpty(r102) == true) goto L18;
        return safeAddParameter(r103, DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r102);
    L18:
        return r103;
    L8:
        r103 = r100;
        goto L10
    }

    public static Map<String, String> spliceTranscodeUrls(Map<String, String> r100, String r101, String r102) {
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L26;
        HashMap r103 = new HashMap();     // Catch: Exception -> L16
        Iterator<Map.Entry<String, String>> r104 = r100.entrySet().iterator();     // Catch: Exception -> L16
    L8:
        if (r104.hasNext() == false) goto L25;
        Map.Entry<String, String> r105 = r104.next();     // Catch: Exception -> L16
        String r106 = safeAddParameter(r105.getValue(), "extra", r101);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r102) == true) goto L13;
        r106 = safeAddParameter(r106, DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r102);     // Catch: Exception -> L16
    L13:
        r103.put(r105.getKey(), r106);     // Catch: Exception -> L16
        goto L8
    L25:
        return r103;
    L16:
        e = move-exception;
        tt5.a.e(TAG, "spliceTranscodeUrls() build url error", e, false);
        return r100;
    L26:
        return r100;
    }
}
