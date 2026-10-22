package com.bytedance.ee.bear.wikiv2.home.api;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SpaceBean implements NonProguard {
    public String browse_time;
    public String description;
    public DisplayTag display_tag;
    public boolean is_star;
    public int open_sharing;
    public String root_token;
    public SpaceCover space_cover;
    public String space_icon;
    public String space_icon_info;
    public String space_id;
    public String space_name;
    public int space_type;
    public String tenant_id;
    public int wiki_scope;

    public SpaceBean() {
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
}
