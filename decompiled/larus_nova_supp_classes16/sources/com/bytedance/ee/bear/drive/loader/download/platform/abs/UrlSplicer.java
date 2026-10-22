package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class UrlSplicer {
    private static final String TAG = "DrivePlatform_UrlSplicer";

    private UrlSplicer() {
    }

    private static int correctServerPreviewType(int r1) {
        if (r1 != 0) goto L5;
        tt5.a.h(TAG, "correctServerPreviewType() pdf 0 to 9 for download url");
        return 9;
    L5:
        return r1;
    }

    public static String downloadAllUrl(String r4) {
        String r0 = ((b0) org.koin.java.a.a(b0.class)).r();
        boolean r1 = !TextUtils.isEmpty(r0);
        if (r1 == true) goto L6;
        r0 = p.u;
    L6:
        tt5.a.h(TAG, "downloadAllUrl useDriveDomain = " + r1 + ", apiDomain = " + r0);
        String r5 = "https://" + r0 + "/space/api/box/stream/download/all/" + r4;
        tt5.a.h(TAG, "downloadAllUrl url= " + du5.b.f(r5));
        return r5;
    }

    public static synchronized String slicePreviewUrl(LinkedHashMap<String, String> r3) {
        monitor-enter(UrlSplicer.class);
        if (r3 == null) goto L17;
    L14:
        th = move-exception;
        tt5.a.d(TAG, th.getMessage());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L6:
        if (r3.size() <= 0) goto L17;
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r4.hasNext() == false) goto L17;
        String r1 = r4.next().getValue();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r1) == true) goto L9;
        monitor-exit(UrlSplicer.class);
        return r1;
    L17:
        monitor-exit(UrlSplicer.class);
        return "";
    }

    public static String spliceV1PreviewSubUrl(f85.a r2) {
        String r0 = "https://" + p.u + "/space/api/box/stream/download/preview_sub/" + ((f85.a.C0229a) r2.a).a + "?version=" + ((f85.a.C0229a) r2.a).p + "&preview_type=" + correctServerPreviewType(r2.e);
        if (TextUtils.isEmpty(((f85.a.C0229a) r2.a).h) == true) goto L6;
        r0 = r0 + "&extra=" + ((f85.a.C0229a) r2.a).h;
    L6:
        if (TextUtils.isEmpty(((f85.a.C0229a) r2.a).n) == true) goto L8;
        r0 = r0 + "&mount_point=" + ((f85.a.C0229a) r2.a).n;
    L8:
        tt5.a.h(TAG, "spliceV1PreviewSubUrl notExpiredUrl = " + du5.b.f(r0));
        return r0;
    }

    public static String spliceV1PreviewUrl(f85.a r4) {
        String r0 = ((b0) org.koin.java.a.a(b0.class)).r();
        boolean r1 = !TextUtils.isEmpty(r0);
        if (r1 == true) goto L6;
        r0 = p.u;
    L6:
        tt5.a.h(TAG, "spliceV1PreviewUrl useDriveDomain = " + r1 + ", apiDomain = " + r0);
        String r2 = "https://" + r0 + "/space/api/box/stream/download/preview/" + ((f85.a.C0229a) r4.a).a + "?version=" + ((f85.a.C0229a) r4.a).p + "&preview_type=" + correctServerPreviewType(r4.e);
        if (TextUtils.isEmpty(((f85.a.C0229a) r4.a).h) == true) goto L10;
        r2 = r2 + "&extra=" + ((f85.a.C0229a) r4.a).h;
    L10:
        if (TextUtils.isEmpty(((f85.a.C0229a) r4.a).n) == true) goto L12;
        r2 = r2 + "&mount_point=" + ((f85.a.C0229a) r4.a).n;
    L12:
        tt5.a.h(TAG, "spliceV1PreviewUrl notExpiredUrl = " + du5.b.f(r2));
        return r2;
    }

    public static String spliceV2PreviewSubUrl(f85.b r2) {
        String r0 = "https://" + p.u + "/space/api/box/stream/sdk/download/preview_sub/?app_id=" + ((f85.b.a) r2.a).m + "&app_file_id=" + ((f85.b.a) r2.a).a + "&preview_type=" + correctServerPreviewType(r2.e);
        if (TextUtils.isEmpty(((f85.b.a) r2.a).n) == true) goto L5;
        r0 = r0 + "&auth_extra=" + ((f85.b.a) r2.a).n;
    L5:
        tt5.a.h(TAG, "spliceV2PreviewUrl url= " + du5.b.f(r0));
        return r0;
    }

    public static String spliceV2PreviewUrl(f85.b r4) {
        String r0 = ((b0) org.koin.java.a.a(b0.class)).r();
        boolean r1 = !TextUtils.isEmpty(r0);
        if (r1 == true) goto L6;
        r0 = p.u;
    L6:
        tt5.a.h(TAG, "spliceV2PreviewUrl useDriveDomain = " + r1 + ", apiDomain = " + r0);
        String r2 = "https://" + r0 + "/space/api/box/stream/sdk/download/preview/?app_id=" + ((f85.b.a) r4.a).m + "&app_file_id=" + ((f85.b.a) r4.a).a + "&preview_type=" + correctServerPreviewType(r4.e);
        if (TextUtils.isEmpty(((f85.b.a) r4.a).n) == true) goto L9;
        r2 = r2 + "&auth_extra=" + ((f85.b.a) r4.a).n;
    L9:
        tt5.a.h(TAG, "spliceV2PreviewUrl url= " + du5.b.f(r2));
        return r2;
    }

    public static String spliceV2SourceUrl(f85.b r4) {
        String r0 = ((b0) org.koin.java.a.a(b0.class)).r();
        boolean r1 = !TextUtils.isEmpty(r0);
        if (r1 == true) goto L6;
        r0 = p.u;
    L6:
        tt5.a.h(TAG, "spliceV2SourceUrl useDriveDomain = " + r1 + ", apiDomain = " + r0);
        String r2 = "https://" + r0 + "/space/api/box/stream/sdk/download/preview/?app_id=" + ((f85.b.a) r4.a).m + "&app_file_id=" + ((f85.b.a) r4.a).a + "&preview_type=16";
        if (TextUtils.isEmpty(((f85.b.a) r4.a).n) == true) goto L9;
        r2 = r2 + "&auth_extra=" + ((f85.b.a) r4.a).n;
    L9:
        tt5.a.h(TAG, "spliceV2SourceUrl url= " + du5.b.f(r2));
        return r2;
    }

    public static String spliceV2SourceUrl(String r4, String r5) {
        String r0 = ((b0) org.koin.java.a.a(b0.class)).r();
        boolean r1 = !TextUtils.isEmpty(r0);
        if (r1 == true) goto L6;
        r0 = p.u;
    L6:
        tt5.a.h(TAG, "spliceV2SourceUrl useDriveDomain = " + r1 + ", apiDomain = " + r0);
        String r6 = "https://" + r0 + "/space/api/box/stream/download/preview/" + r4 + "?version=" + r5 + "&preview_type=16";
        tt5.a.h(TAG, "spliceV2SourceUrl url= " + du5.b.f(r6));
        return r6;
    }

    private static String safeAddParameter(String r4, String r5, String r6) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r4;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return r4;
    L7:
        if (r4.contains("&" + r5 + "=") == false) goto L10;
        return r4;
    L10:
        if (r4.contains("?") == false) goto L14;
        return r4 + "&" + r5 + "=" + r6;
    L14:
        return r4 + "?" + r5 + "=" + r6;
    }

    public static String sliceExtraTranCodeCodeUrl(String r1, String r2, String r3) {
    L13:
        th = move-exception;
        tt5.a.d(TAG, th.getMessage());
        return r1;
    L3:
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return r1;
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L8;
        String r4 = safeAddParameter(r1, "extra", r2);     // Catch: Throwable -> L13
    L10:
        if (TextUtils.isEmpty(r3) == true) goto L18;
        return safeAddParameter(r4, DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r3);
    L18:
        return r4;
    L8:
        r4 = r1;
        goto L10
    }

    public static Map<String, String> spliceTranscodeUrls(Map<String, String> r5, String r6, String r7) {
        if (CollectionUtils.isEmpty(r5) == false) goto L5;
        return r5;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L26;
        HashMap r0 = new HashMap();     // Catch: Exception -> L16
        Iterator<Map.Entry<String, String>> r1 = r5.entrySet().iterator();     // Catch: Exception -> L16
    L8:
        if (r1.hasNext() == false) goto L25;
        Map.Entry<String, String> r2 = r1.next();     // Catch: Exception -> L16
        String r3 = safeAddParameter(r2.getValue(), "extra", r6);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r7) == true) goto L13;
        r3 = safeAddParameter(r3, DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r7);     // Catch: Exception -> L16
    L13:
        r0.put(r2.getKey(), r3);     // Catch: Exception -> L16
        goto L8
    L25:
        return r0;
    L16:
        e = move-exception;
        tt5.a.e(TAG, "spliceTranscodeUrls() build url error", e, false);
        return r5;
    L26:
        return r5;
    }
}
