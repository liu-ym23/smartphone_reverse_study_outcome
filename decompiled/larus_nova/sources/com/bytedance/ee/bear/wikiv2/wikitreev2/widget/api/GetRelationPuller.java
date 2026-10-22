package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
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
            StringBuilder r100 = new StringBuilder("Params{space_id='");
            r100.append(yu5.c.j(this.space_id));
            r100.append("', wiki_token='");
            r100.append(yu5.c.j(this.wiki_token));
            r100.append("', with_space=");
            r100.append(this.with_space);
            r100.append(", with_perm=");
            r100.append(this.with_perm);
            r100.append(", expand_shortcut=");
            r100.append(this.expand_shortcut);
            r100.append(", need_shared=");
            r100.append(this.need_shared);
            r100.append(", with_path_resolve=");
            if (this.visibleSpaceId != null) goto L5;
        L7:
            boolean r101 = false;
        L8:
            r100.append(r101);
            r100.append('}');
            return r100.toString();
        L5:
            if (this.pathResolveScene == null) goto L7;
            r101 = true;
            goto L8
        }

        public Params setThumbnailMode(Integer r100) {
            this.thumbnail_mode = r100;
            return this;
        }

        public Params(String r100, String r101) {
            this.with_space = true;
            this.with_perm = true;
            this.thumbnail_mode = Integer.valueOf(AppInfoUtils.f().booleanValue() ? 1 : 0);
            this.space_id = r100;
            this.wiki_token = r101;
            this.expand_shortcut = true;
            this.need_shared = true;
        }

        public Params setPathResolve(String r100, Integer r101) {
            this.visibleSpaceId = r100;
            this.pathResolveScene = r101;
            return this;
        }
    }

    public GetRelationPuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/tree/get_info/", 2, 1);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.b
    public final Map a(Serializable r100) throws Exception {
        Map<String, Object> r101 = super.a((Params) r100);
        HashMap r102 = (HashMap) r101;
        Object r103 = r102.remove("visibleSpaceId");
        if (r103 == null) goto L5;
        r102.put("visible_space_id", r103);
    L5:
        Object r104 = r102.remove("pathResolveScene");
        if (r104 == null) goto L8;
        r102.put("path_resolve_scene", r104);
    L8:
        return r101;
    }
}
