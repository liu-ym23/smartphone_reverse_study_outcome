package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SpaceUserPerm implements NonProguard, Cloneable {
    private static final String TAG = "SpaceUserPerm";
    public boolean delete_wiki;
    public boolean edit_wiki_attribute;
    public boolean edit_wiki_collaborator;
    public boolean edit_wiki_info;
    public boolean star_wiki;
    public boolean view_wiki_attribute;
    public boolean view_wiki_collaborator;
    public boolean view_wiki_general_info;
    public boolean view_wiki_info;

    public SpaceUserPerm() {
    }

    public SpaceUserPerm clone() {
        return (SpaceUserPerm) super.clone();
    L4:
        e = move-exception;
        tt5.a.e(TAG, "clone spaceUserPerm fail. ", e, false);
        return null;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m710clone() throws CloneNotSupportedException {
        return clone();
    }
}
