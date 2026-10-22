package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class SpacePerm implements NonProguard, Cloneable {
    private static final String TAG = "SpacePerm";

    @JSONField(name = "can_clone")
    public boolean canClone;

    @JSONField(name = "can_copy_content")
    public boolean canCopyContent;

    @JSONField(name = "can_create_space")
    public boolean canCreateSpace;

    @JSONField(name = "can_edit_first_level")
    public boolean canEditFirstLevel;

    @JSONField(name = "can_export")
    public boolean canExport;

    @JSONField(name = "can_manage_space")
    public boolean canManageSpace;

    @JSONField(name = "can_print")
    public boolean canPrint;

    @JSONField(name = "is_wiki_member")
    public boolean isWikiMember;

    public SpacePerm() {
    }

    public SpacePerm clone() {
        return (SpacePerm) super.clone();
    L4:
        e = move-exception;
        tt5.a.e(TAG, "clone rootPermInfo fail. ", e, false);
        return null;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8342clone() throws CloneNotSupportedException {
        return clone();
    }
}
