package com.bytedance.ee.bear.templates.bean;

import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class SceneTemplateData implements NonProguard {
    public String app_link;
    public String collection_id;
    public String cover_download_ur;
    public String cover_token;
    public String description;
    public int heat;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f238862id;
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
        List<Scene> r100 = this.template_collection;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.size() < 1) goto L11;
        SceneTemplatePreviewInfo r101 = new SceneTemplatePreviewInfo();
        r101.collectionId = this.collection_id;
        Scene r102 = (Scene) ListProtector.get(this.template_collection, 0);
        r101.token = r102.obj_token;
        r101.type = r102.obj_type;
        r101.name = r102.name;
        return r101;
    L11:
        return null;
    }
}
