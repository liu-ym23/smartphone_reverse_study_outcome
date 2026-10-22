package com.bytedance.ee.bear.middleground.drive.rustsdk.init;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.DriveCommonConstants$DriveRustFgConfig;
import com.bytedance.ee.bear.middleground.drive.export.DriveRustFgConfig;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.lark.pb.space.drive.v1.DriveRustConfig;
import com.bytedance.lark.pb.space.drive.v1.InitDriveRequest;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.FileCipherApiProxy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class DriveRustSdkWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f232570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile DriveRustSdkWrapper f232571b;

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

        public static /* synthetic */ CCMCacheConfig access$100(String r100) {
            return parse(r100);
        }

        private static CCMCacheConfig parse(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L20;
            tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "parse CCMCacheConfig null");
            return null;
        L20:
            String r101 = new JSONObject(r100).optString("cache_config");     // Catch: Exception -> L17
            if (TextUtils.isEmpty(r101) == false) goto L10;
            tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "parse CCMCacheConfig cache_config is empty");     // Catch: Exception -> L17
            return null;
        L10:
            String r102 = JSONObjectProtectorUtils.getString(new JSONObject(r101), ChameleonResConstants.CCM_ROOT_DIR);     // Catch: Exception -> L17
            if (TextUtils.isEmpty(r102) == false) goto L14;
            tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "parse CCMCacheConfig ccm is empty");     // Catch: Exception -> L17
            return null;
        L14:
            CCMCacheConfig r103 = (CCMCacheConfig) new Gson().fromJson(r102, CCMCacheConfig.class);     // Catch: Exception -> L17
            if (r103.drive == null) goto L19;
            return r103;
        L19:
            return null;
        L17:
            e = move-exception;
            tt5.a.e("Middleground_Drive_DriveRustSdkWrapper", "parse CCMCacheConfig fail. ", e, false);
            goto L19
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f232572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f232573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f232574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f232575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f232576e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (TextUtils.equals(this.f232572a, r101.f232572a) == true) goto L11;
        L19:
            return false;
        L11:
            if (TextUtils.equals(this.f232573b, r101.f232573b) == false) goto L19;
            if (TextUtils.equals(this.f232574c, r101.f232574c) == false) goto L19;
            if (TextUtils.equals(this.f232575d, r101.f232575d) == false) goto L19;
            if (TextUtils.equals(this.f232576e, r101.f232576e) == false) goto L19;
            return true;
        }

        public a(String r100, String r101, String r102, String r103, String r104) {
            this.f232572a = r100;
            this.f232573b = r101;
            this.f232574c = r102;
            this.f232575d = r103;
            this.f232576e = r104;
        }
    }

    public static DriveRustSdkWrapper b() {
        if (f232571b != null) goto L15;
        monitor-enter(DriveRustSdkWrapper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f232571b != null) goto L9;
        f232571b = new DriveRustSdkWrapper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DriveRustSdkWrapper.class);     // Catch: Throwable -> L11
    L15:
        return f232571b;
    }

    public DriveRustSdkWrapper() {
    }

    public static InitDriveRequest.Builder a(a r110) {
        DriveCommonConstants$DriveRustFgConfig r100 = new DriveCommonConstants$DriveRustFgConfig();     // Catch: Exception -> L12
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;     // Catch: Exception -> L12
        DriveCommonConstants$DriveRustFgConfig r102 = (DriveCommonConstants$DriveRustFgConfig) r101.c("drive_rust_config", DriveCommonConstants$DriveRustFgConfig.class, r100);     // Catch: Exception -> L12
        DriveRustFgConfig r103 = new DriveRustFgConfig(r102.disable_cdn_download, r102.max_thread_size, r102.max_download_part_size, r102.small_upload_file_size, r101.i("spacekit.mobile.drive.pause.background", false));     // Catch: Exception -> L12
        tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "getInitDriveRequest rustConfig = " + r103);     // Catch: Exception -> L12
        com.ss.android.lark.storage.kv.repo.a r104 = ay4.b.c("drive");     // Catch: Exception -> L12
        CCMCacheConfig r105 = CCMCacheConfig.access$100(r104.getString("key_disk_manage_setting", ""));     // Catch: Exception -> L12
        if (r105 == null) goto L6;
        long r106 = r105.drive.timeLimit;     // Catch: Exception -> L12
    L8:
        if (r104.getBoolean("small_disk_on", false) == false) goto L10;
        r106 = (long) (r106 * r104.getFloat("disk_timeout_factor", 1.0f));     // Catch: Exception -> L12
    L10:
        tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "getInitDriveRequest exceedTime = " + r106);     // Catch: Exception -> L12
        DriveRustConfig.Builder r107 = new DriveRustConfig.Builder().max_thread_size(Integer.valueOf(r103.max_thread_size)).max_download_part_size(Integer.valueOf(r103.max_download_part_size)).small_upload_file_size(Integer.valueOf(r103.small_upload_file_size)).pause_background(Boolean.valueOf(r103.pause_background));     // Catch: Exception -> L12
        Boolean r108 = Boolean.TRUE;     // Catch: Exception -> L12
        DriveRustConfig r109 = r107.upload_optimize(r108).not_set_file_size(r108).extra(r103.extra).exceed_time(Integer.valueOf((int) r106)).build();     // Catch: Exception -> L12
        InitDriveRequest.Builder r111 = new InitDriveRequest.Builder();     // Catch: Exception -> L12
        r111.storage_path(r110.f232572a).session(r110.f232573b).user_id(r110.f232574c).tenant_id(r110.f232575d).device_id(r110.f232576e).for_app(Boolean.FALSE).drive_rust_config(r109).disable_cdn_download(Boolean.valueOf(r103.disable_cdn_download));     // Catch: Exception -> L12
        return r111;
    L6:
        r106 = 1296000;
    L12:
        e = move-exception;
        tt5.a.d("Middleground_Drive_DriveRustSdkWrapper", "getInitDriveRequest crash" + e);
        InitDriveRequest.Builder r112 = new InitDriveRequest.Builder();
        r112.storage_path(r110.f232572a).session(r110.f232573b).user_id(r110.f232574c).tenant_id(r110.f232575d).device_id(r110.f232576e).for_app(Boolean.FALSE);
        return r112;
    }

    public static void c(a r100) {
        if (eu5.g.i() == false) goto L6;
        String r101 = r100.f232576e;
        long r102 = CastLongProtector.valueOf(r100.f232574c).longValue();
        String r103 = r100.f232573b;
        int r104 = CipherManager.f456788a;
        FileCipherApiProxy.f456789a.f5(r101, r102, r103);
        return;
    }
}
