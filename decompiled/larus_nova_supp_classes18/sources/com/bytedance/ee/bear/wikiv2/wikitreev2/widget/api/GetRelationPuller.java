package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class GetRelationPuller extends b<Params, WikiRelation> {

    public static class Params implements NonProguard {
        public boolean expand_shortcut;
        public boolean need_shared;
        public Integer pathResolveScene;
        public String space_id;
        public Integer thumbnail_mode;
        public String visibleSpaceId;
        public String wiki_token;
        public boolean with_perm;
        public boolean with_space;

        public String toString() {
            StringBuilder r0 = new StringBuilder("Params{space_id='");
            r0.append(yu5.c.j(this.space_id));
            r0.append("', wiki_token='");
            r0.append(yu5.c.j(this.wiki_token));
            r0.append("', with_space=");
            r0.append(this.with_space);
            r0.append(", with_perm=");
            r0.append(this.with_perm);
            r0.append(", expand_shortcut=");
            r0.append(this.expand_shortcut);
            r0.append(", need_shared=");
            r0.append(this.need_shared);
            r0.append(", with_path_resolve=");
            if (this.visibleSpaceId != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r0.append(r1);
            r0.append('}');
            return r0.toString();
        L5:
            if (this.pathResolveScene == null) goto L7;
            r1 = true;
            goto L8
        }

        public Params setThumbnailMode(Integer r1) {
            this.thumbnail_mode = r1;
            return this;
        }

        public Params(String r3, String r4) {
            this.with_space = true;
            this.with_perm = true;
            this.thumbnail_mode = Integer.valueOf(AppInfoUtils.f().booleanValue() ? 1 : 0);
            this.space_id = r3;
            this.wiki_token = r4;
            this.expand_shortcut = true;
            this.need_shared = true;
        }

        public Params setPathResolve(String r1, Integer r2) {
            this.visibleSpaceId = r1;
            this.pathResolveScene = r2;
            return this;
        }
    }

    public GetRelationPuller(NetService r4) {
        super(r4, "/space/api/wiki/v2/tree/get_info/", 2, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.b
    public final Map a(Serializable r4) throws Exception {
        Map<String, Object> r5 = super.a((Params) r4);
        HashMap r0 = (HashMap) r5;
        Object r1 = r0.remove("visibleSpaceId");
        if (r1 == null) goto L5;
        r0.put("visible_space_id", r1);
    L5:
        Object r2 = r0.remove("pathResolveScene");
        if (r2 == null) goto L8;
        r0.put("path_resolve_scene", r2);
    L8:
        return r5;
    }
}
