package com.bytedance.ee.bear.middleground.drive.rustsdk.init;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.DriveCommonConstants;
import com.bytedance.ee.bear.middleground.drive.export.DriveRustFgConfig;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.lark.pb.space.drive.v1.DriveRustConfig;
import com.bytedance.lark.pb.space.drive.v1.InitDriveRequest;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.FileCipherApiProxy;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DriveRustSdkWrapper {
    public static volatile a a;
    public static volatile DriveRustSdkWrapper b;

    public static final class CCMCacheConfig implements NonProguard {
        public ConfigItem drive;

        public static final class ConfigItem implements NonProguard {

            @SerializedName("time_limit")
            public long timeLimit;

            private ConfigItem() {
            }
        }

        private CCMCacheConfig() {
        }

        public static /* synthetic */ CCMCacheConfig access$100(String r0) {
            return parse(r0);
        }

        private static CCMCacheConfig parse(String r4) {
            if (TextUtils.isEmpty(r4) == false) goto L20;
            tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "parse CCMCacheConfig null");
            return null;
        L20:
            String r5 = new JSONObject(r4).optString("cache_config");     // Catch: Exception -> L17
            if (TextUtils.isEmpty(r5) == false) goto L10;
            tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "parse CCMCacheConfig cache_config is empty");     // Catch: Exception -> L17
            return null;
        L10:
            String r6 = JSONObjectProtectorUtils.getString(new JSONObject(r5), "ccm");     // Catch: Exception -> L17
            if (TextUtils.isEmpty(r6) == false) goto L14;
            tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "parse CCMCacheConfig ccm is empty");     // Catch: Exception -> L17
            return null;
        L14:
            CCMCacheConfig r7 = (CCMCacheConfig) new Gson().fromJson(r6, CCMCacheConfig.class);     // Catch: Exception -> L17
            if (r7.drive == null) goto L19;
            return r7;
        L19:
            return null;
        L17:
            e = move-exception;
            tt5.a.e("Middleground_Drive_DriveRustSdkWrapper", "parse CCMCacheConfig fail. ", e, false);
            goto L19
        }
    }

    public static class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (TextUtils.equals(this.a, r6.a) == true) goto L11;
        L19:
            return false;
        L11:
            if (TextUtils.equals(this.b, r6.b) == false) goto L19;
            if (TextUtils.equals(this.c, r6.c) == false) goto L19;
            if (TextUtils.equals(this.d, r6.d) == false) goto L19;
            if (TextUtils.equals(this.e, r6.e) == false) goto L19;
            return true;
        }

        public a(String r1, String r2, String r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static DriveRustSdkWrapper b() {
        if (b != null) goto L15;
        monitor-enter(DriveRustSdkWrapper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new DriveRustSdkWrapper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DriveRustSdkWrapper.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public DriveRustSdkWrapper() {
    }

    public static InitDriveRequest.Builder a(a r13) {
        DriveCommonConstants.DriveRustFgConfig r3 = new DriveCommonConstants.DriveRustFgConfig();     // Catch: Exception -> L12
        com.bytedance.ee.bear.appsetting.c r4 = com.bytedance.ee.bear.appsetting.c.a.a;     // Catch: Exception -> L12
        DriveCommonConstants.DriveRustFgConfig r5 = r4.c("drive_rust_config", DriveCommonConstants.DriveRustFgConfig.class, r3);     // Catch: Exception -> L12
        DriveRustFgConfig r6 = new DriveRustFgConfig(r5.disable_cdn_download, r5.max_thread_size, r5.max_download_part_size, r5.small_upload_file_size, r4.i("spacekit.mobile.drive.pause.background", false));     // Catch: Exception -> L12
        tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "getInitDriveRequest rustConfig = " + r6);     // Catch: Exception -> L12
        com.ss.android.lark.storage.kv.repo.a r2 = ay4.b.c(DocumentType.VALUE_DRIVE);     // Catch: Exception -> L12
        CCMCacheConfig r7 = CCMCacheConfig.access$100(r2.getString("key_disk_manage_setting", ""));     // Catch: Exception -> L12
        if (r7 == null) goto L6;
        long r8 = r7.drive.timeLimit;     // Catch: Exception -> L12
    L8:
        if (r2.getBoolean("small_disk_on", false) == false) goto L10;
        r8 = (long) (r8 * r2.getFloat("disk_timeout_factor", 1.0f));     // Catch: Exception -> L12
    L10:
        tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "getInitDriveRequest exceedTime = " + r8);     // Catch: Exception -> L12
        DriveRustConfig.Builder r1 = new DriveRustConfig.Builder().max_thread_size(Integer.valueOf(r6.max_thread_size)).max_download_part_size(Integer.valueOf(r6.max_download_part_size)).small_upload_file_size(Integer.valueOf(r6.small_upload_file_size)).pause_background(Boolean.valueOf(r6.pause_background));     // Catch: Exception -> L12
        Boolean r9 = Boolean.TRUE;     // Catch: Exception -> L12
        DriveRustConfig r10 = r1.upload_optimize(r9).not_set_file_size(r9).extra(r6.extra).exceed_time(Integer.valueOf((int) r8)).build();     // Catch: Exception -> L12
        InitDriveRequest.Builder r11 = new InitDriveRequest.Builder();     // Catch: Exception -> L12
        r11.storage_path(r13.a).session(r13.b).user_id(r13.c).tenant_id(r13.d).device_id(r13.e).for_app(Boolean.FALSE).drive_rust_config(r10).disable_cdn_download(Boolean.valueOf(r6.disable_cdn_download));     // Catch: Exception -> L12
        return r11;
    L6:
        r8 = 1296000;
    L12:
        e = move-exception;
        tt5.a.d("Middleground_Drive_DriveRustSdkWrapper", "getInitDriveRequest crash" + e);
        InitDriveRequest.Builder r0 = new InitDriveRequest.Builder();
        r0.storage_path(r13.a).session(r13.b).user_id(r13.c).tenant_id(r13.d).device_id(r13.e).for_app(Boolean.FALSE);
        return r0;
    }

    public static void c(a r4) {
        if (eu5.g.i() == false) goto L6;
        String r0 = r4.e;
        long r1 = CastLongProtector.valueOf(r4.c).longValue();
        String r5 = r4.b;
        int r3 = CipherManager.a;
        FileCipherApiProxy.a.f5(r0, r1, r5);
        return;
    }
}
