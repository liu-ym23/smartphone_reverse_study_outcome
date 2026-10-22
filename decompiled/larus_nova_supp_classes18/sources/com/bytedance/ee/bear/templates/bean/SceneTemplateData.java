package com.bytedance.ee.bear.templates.bean;

import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SceneTemplateData implements NonProguard {
    public String app_link;
    public String collection_id;
    public String cover_download_ur;
    public String cover_token;
    public String description;
    public int heat;
    public String id;
    public String name;
    public List<Scene> template_collection;

    public static class Extra implements NonProguard {
        public String decrypt_key;
        public String thumbnail;
        public int type;

        public Extra() {
        }
    }

    public static class Scene implements NonProguard {
        public String cover_download_url;
        public int display_type;
        public String name;
        public String obj_token;
        public int obj_type;
        public Extra thumbnail_extra;

        public Scene() {
            this.thumbnail_extra = new Extra();
        }
    }

    public static class SceneTemplatePreviewInfo implements NonProguard {
        public String collectionId;
        public String name;
        public String token;
        public int type;

        public SceneTemplatePreviewInfo() {
        }
    }

    public SceneTemplateData() {
    }

    public SceneTemplatePreviewInfo getSceneTemplatePreviewInfo() {
        List<Scene> r0 = this.template_collection;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.size() < 1) goto L11;
        SceneTemplatePreviewInfo r1 = new SceneTemplatePreviewInfo();
        r1.collectionId = this.collection_id;
        Scene r2 = (Scene) ListProtector.get(this.template_collection, 0);
        r1.token = r2.obj_token;
        r1.type = r2.obj_type;
        r1.name = r2.name;
        return r1;
    L11:
        return null;
    }
}
