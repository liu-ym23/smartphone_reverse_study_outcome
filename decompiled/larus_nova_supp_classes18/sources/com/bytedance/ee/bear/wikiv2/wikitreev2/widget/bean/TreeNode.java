package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.SpaceEntity;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TreeNode implements NonProguard, Parcelable, Cloneable, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.c {
    public static final Parcelable.Creator<TreeNode> CREATOR = null;
    public static final int LEVEL_ROOT = 0;
    public static final String TAG = "Wiki_TreeNode";
    public WikiDetailInfo detail_info;
    public int entity_delete_flag;
    public boolean has_child;
    public String iconInfo;
    public boolean isSpaceDocument;

    @SerializedName("is_wiki_home_page")
    @JSONField(name = "is_wiki_home_page")
    public boolean isWikiHomePage;
    public boolean is_explorer_pin;
    public boolean is_explorer_star;
    public boolean is_star;
    public String obj_token;
    public int obj_type;
    public boolean origin_is_external;
    public String origin_space_id;
    public String origin_title;
    public String origin_wiki_token;
    public String parent_wiki_token;
    public WikNodePerm perm;
    public boolean secret_key_delete;
    public double sort_id;
    public SpaceEntity spaceDocumentEntity;
    public String space_id;
    public String title;
    public String url;
    public int wiki_node_type;
    public String wiki_token;

    public class a implements Parcelable.Creator<TreeNode> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TreeNode createFromParcel(Parcel r2) {
            return new TreeNode(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final TreeNode[] newArray(int r1) {
            return new TreeNode[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public TreeNode clone() {
        TreeNode r0 = new TreeNode();
        return (TreeNode) super.clone();
    L5:
        e = move-exception;
        tt5.a.e(TAG, "clone treeNode fail.", e, false);
        return r0;
    }

    public int getNodeType() {
        Intrinsics.checkNotNullParameter(this, "node");
        int r0 = this.wiki_node_type;
        boolean r2 = true;
        if (r0 != (-5)) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return WikNodeType.TITLE_ROOT.getValue();
    L9:
        if (r0 != (-6)) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L15;
        return WikNodeType.TITLE.getValue();
    L15:
        if (r0 != (-7)) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L21;
        return WikNodeType.SPACE.getValue();
    L21:
        if (r0 != (-8)) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == false) goto L27;
        return WikNodeType.DOCUMENT.getValue();
    L27:
        if (c.c(r0) == false) goto L30;
        return WikNodeType.ROOT.getValue();
    L30:
        if (this.wiki_node_type == (-3)) goto L33;
        r2 = false;
    L33:
        if (r2 == false) goto L36;
        return WikNodeType.NONE.getValue();
    L36:
        if (this.has_child == false) goto L39;
        return WikNodeType.DIR.getValue();
    L39:
        return WikNodeType.LEAF.getValue();
    L23:
        r5 = false;
        goto L24
    L17:
        r4 = false;
        goto L18
    L11:
        r3 = false;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public boolean getOriginIsDeleted() {
        if (this.entity_delete_flag == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String getUrl() {
        if (TextUtils.isEmpty(this.url) == false) goto L7;
        return p.a().A9(sbb.e.n.getType(), this.wiki_token);
    L7:
        return this.url;
    }

    public boolean isShortcut() {
        if (this.wiki_node_type == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isSortIdNativeGenerate() {
        if (this.sort_id >= 1000.0d) goto L5;
        return true;
    L5:
        return false;
    }

    public String getObjUrl() {
        return p.a().A9(sbb.e.f(this.obj_type), this.obj_token);
    }

    public String getOriginSpaceId() {
        if (isShortcut() == false) goto L6;
        return this.origin_space_id;
    L6:
        return this.space_id;
    }

    public String getOriginTitle() {
        if (isShortcut() == false) goto L6;
        return this.origin_title;
    L6:
        return this.title;
    }

    public String getOriginToken() {
        if (isShortcut() == false) goto L11;
        if (this.origin_is_external == false) goto L9;
        return this.obj_token;
    L9:
        return this.origin_wiki_token;
    L11:
        return this.wiki_token;
    }

    public TreeNode() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.c
    public String getSpaceId() {
        return this.space_id;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m711clone() throws CloneNotSupportedException {
        return clone();
    }

    public TreeNode(Parcel r4) {
        this.space_id = r4.readString();
        this.wiki_token = r4.readString();
        this.obj_token = r4.readString();
        this.obj_type = r4.readInt();
        this.title = r4.readString();
        this.parent_wiki_token = r4.readString();
        this.sort_id = r4.readDouble();
        this.wiki_node_type = r4.readInt();
        this.origin_wiki_token = r4.readString();
        this.origin_space_id = r4.readString();
        boolean r1 = true;
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.is_star = r0;
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.has_child = r2;
        if (r4.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.secret_key_delete = r3;
        if (r4.readByte() == 0) goto L17;
        boolean r5 = true;
    L18:
        this.is_explorer_star = r5;
        if (r4.readByte() == 0) goto L21;
        boolean r6 = true;
    L22:
        this.is_explorer_pin = r6;
        if (r4.readByte() == 0) goto L25;
        boolean r7 = true;
    L26:
        this.origin_is_external = r7;
        if (r4.readByte() == 0) goto L29;
        boolean r8 = true;
    L30:
        this.isSpaceDocument = r8;
        this.detail_info = (WikiDetailInfo) r4.readParcelable(WikiDetailInfo.class.getClassLoader());
        this.iconInfo = r4.readString();
        if (r4.readByte() != 0) goto L34;
        r1 = false;
    L34:
        this.isWikiHomePage = r1;
        return;
    L29:
        r8 = false;
        goto L30
    L25:
        r7 = false;
        goto L26
    L21:
        r6 = false;
        goto L22
    L17:
        r5 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public void setOriginToken(String r1) {
        this.origin_wiki_token = r1;
    }

    public static TreeNode createNone(String r1, String r2) {
        TreeNode r0 = new TreeNode();
        r0.space_id = r1;
        r0.wiki_token = String.valueOf(r0.hashCode());
        r0.wiki_node_type = -3;
        r0.parent_wiki_token = r2;
        r0.obj_type = sbb.e.e.b;
        return r0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.space_id);
        r3.writeString(this.wiki_token);
        r3.writeString(this.obj_token);
        r3.writeInt(this.obj_type);
        r3.writeString(this.title);
        r3.writeString(this.parent_wiki_token);
        r3.writeDouble(this.sort_id);
        r3.writeInt(this.wiki_node_type);
        r3.writeString(this.origin_wiki_token);
        r3.writeString(this.origin_space_id);
        r3.writeByte(this.is_star ? 1 : 0);
        r3.writeByte(this.has_child ? 1 : 0);
        r3.writeByte(this.secret_key_delete ? 1 : 0);
        r3.writeByte(this.is_explorer_star ? 1 : 0);
        r3.writeByte(this.is_explorer_pin ? 1 : 0);
        r3.writeByte(this.origin_is_external ? 1 : 0);
        r3.writeByte(this.isSpaceDocument ? 1 : 0);
        r3.writeParcelable(this.detail_info, r4);
        r3.writeString(this.iconInfo);
        r3.writeByte(this.isWikiHomePage ? 1 : 0);
    }

    public static TreeNode createVirtualRoot(String r1, String r2, int r3) {
        TreeNode r0 = new TreeNode();
        r0.space_id = r1;
        r0.wiki_token = r2;
        r0.wiki_node_type = r3;
        r0.parent_wiki_token = "";
        r0.obj_type = sbb.e.e.b;
        return r0;
    }
}
