package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class SpaceInfo implements NonProguard, Cloneable {
    public static final int SPACE_TYPE_LIBRARY = 2;
    public static final int SPACE_TYPE_PERSONAL = 0;
    public static final int SPACE_TYPE_TEAM = 1;
    public static final int SPACE_TYPE_VIRTUAL = 3;
    static final String TAG = "SpaceInfo";
    public String create_uid;
    public String description;
    public DisplayTag display_tag;

    @SerializedName("home_page_v2")
    @JSONField(name = "home_page_v2")
    public WikiHomePageV2 homePageV2;
    public boolean is_star;
    public int migrate_status;
    public int open_sharing;
    public int owner_perm_type;
    public SpaceCover space_cover;
    public String space_icon;
    public String space_id;
    public String space_name;
    public int space_type;
    public String tenant_id;
    public int wiki_scope;

    public static class SpaceCover implements NonProguard {
        public String color_value;
        public boolean is_graph_dark;
        public String key;
        public String origin;
        public String thumbnail;

        public SpaceCover() {
        }
    }

    public SpaceInfo() {
    }

    public boolean isDocsLib() {
        if (this.space_type != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isMyLib() {
        if (this.space_type == 2) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.create_uid) == true) goto L9;
        if (TextUtils.equals(this.create_uid, ((b0) org.koin.java.a.a(b0.class)).getUid()) == false) goto L9;
        return true;
    }

    public boolean isOpenSharing() {
        if (this.open_sharing == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isPublicScope() {
        if (this.wiki_scope == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public SpaceInfo clone() {
        SpaceInfo r100 = (SpaceInfo) super.clone();     // Catch: Exception -> L6
        WikiHomePageV2 r101 = this.homePageV2;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r100.homePageV2 = r101.clone();     // Catch: Exception -> L6
        return r100;
    L11:
        return r100;
    L6:
        e = move-exception;
        SpaceInfo r102 = new SpaceInfo();
        tt5.a.e(TAG, "clone spaceInfo fail. ", e, false);
        return r102;
    }

    public String getSpaceName() {
        if (isMyLib() == false) goto L7;
        return eu5.b.a().getString(R.string.LarkCCM_CM_MyLib_Menu);
    L7:
        return this.space_name;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8341clone() throws CloneNotSupportedException {
        return clone();
    }
}
