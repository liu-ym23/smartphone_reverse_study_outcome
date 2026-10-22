package com.bytedance.ee.bear.drive.view.preview.wps;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;

/* JADX INFO: loaded from: classes16.dex */
public final class WpsAccessTokenPuller extends BasePuller<Params, Result> {

    public static class DriveSdkParams extends Params {
        public String app_file_id;
        public String app_id;

        @Override // com.bytedance.ee.bear.drive.view.preview.wps.WpsAccessTokenPuller.Params
        public String toString() {
            return "DriveSdkParams{app_id='" + yu5.c.j(this.app_id) + "', app_file_id='" + yu5.c.j(this.app_file_id) + "', auth_extra='" + yu5.c.j(this.auth_extra) + "', need_edit='" + this.need_edit + "'}";
        }

        public DriveSdkParams setSdkParams(String r100, String r101) {
            this.app_id = r100;
            this.app_file_id = r101;
            return this;
        }

        public DriveSdkParams(String r100, boolean r101, int r102, boolean r110) {
            super("", r100, r101, r102, r110);
        }
    }

    public static class Params extends BasePuller.Params {
        public String auth_extra;
        public String file_token;
        public boolean need_edit;
        public boolean need_url;
        public int third_source;

        public String toString() {
            return "Params{file_token='" + yu5.c.j(this.file_token) + "', auth_extra='" + yu5.c.j(this.auth_extra) + "', need_edit='" + this.need_edit + "', third_source='" + this.third_source + "', need_url='" + this.need_url + "'}";
        }

        public Params(String r100, String r101, boolean r102, int r103, boolean r104) {
            this.file_token = r100;
            this.need_edit = r102;
            if (TextUtils.isEmpty(r101) == false) goto L5;
            r101 = "";
        L5:
            this.auth_extra = r101;
            this.third_source = r103;
            this.need_url = r104;
        }
    }

    public static class Result extends BasePuller.Result {
        public String brand;
        public long expire;
        public boolean has_quota;
        public String token;
        public String url;

        public String toString() {
            return "Result{token='" + yu5.c.j(this.token) + "', has_quota=" + this.has_quota + ", expire=" + this.expire + ", url=" + yu5.c.j(this.url) + ", brand=" + this.brand + '}';
        }

        public Result() {
        }
    }

    public @interface WPSThirdSource {
        public static final int WPS_CENTER_VERSION_SOURCE = 2;
        public static final int WPS_PEARL_RESEARCH_SOURCE = 1;
    }

    public WpsAccessTokenPuller(NetService r100) {
        super(r100, "/api/box/third/access_token/");
    }
}
