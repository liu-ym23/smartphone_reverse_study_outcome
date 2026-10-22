package com.ss.android.ugc.effectmanager.effect.model;

import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class ComposerNode {
    public static final int NODE_TYPE_FOLDER_0 = 4;
    public static final int NODE_TYPE_FOLDER_1 = 1;
    public static final int NODE_TYPE_ITEM_0 = -1;
    public static final int NODE_TYPE_ITEM_1 = 0;
    public static final int NODE_TYPE_ITEM_BAR_0 = 2;
    public static final int NODE_TYPE_ITEM_BAR_1 = 3;
    public static final String TYPE_LOCAL = "ComposerNode";
    public String UI_name;
    public List<ComposerNode> children;
    public float default_value;
    public Effect effect;
    public String file;
    public String icon;
    public float max_value;
    public float min_value;
    public ComposerNode parent;
    public int switch_mode;
    public String tag_name;
    public int type;

    public boolean isLeaf() {
        int r100 = this.type;
        if (r100 != 4) goto L5;
        return false;
    L5:
        if (r100 == 1) goto L10;
        return true;
    L10:
        return false;
    }

    public ComposerNode() {
        this.type = 0;
        this.effect = null;
    }
}
