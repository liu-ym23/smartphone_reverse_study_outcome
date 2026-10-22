package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public final class GetMoveNodeAuthorizedUserInfoPuller extends b<Params, Result> {

    public static class I18nNames implements NonProguard {
        public String en_us;
        public String ja_jp;
        public String zh_cn;

        public I18nNames() {
        }
    }

    public static class Params implements NonProguard {
        public String space_id;
        public String wiki_token;

        public String toString() {
            return "Params{wiki_token='" + yu5.c.j(this.wiki_token) + "'space_id='" + yu5.c.j(this.space_id) + "'}";
        }

        public Params(String r100, String r101) {
            this.wiki_token = r100;
            this.space_id = r101;
        }
    }

    public static class Result implements NonProguard {
        public String avatar_url;
        public DisplayName display_name;
        public I18nNames i18n_names;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f241685id;
        public String name;
        public String tenant_id;
        public String tenant_name;

        public Result() {
        }

        public String toString() {
            return "Result{id=" + this.f241685id + "tenant_id=" + this.tenant_id + '}';
        }
    }

    public GetMoveNodeAuthorizedUserInfoPuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/tree/move_node_authorized_userinfo/", 2, 1);
    }
}
