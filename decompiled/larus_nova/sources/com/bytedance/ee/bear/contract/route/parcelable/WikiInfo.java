package com.bytedance.ee.bear.contract.route.parcelable;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class WikiInfo extends Result<Info> implements NonProguard {

    @JSONField(serialize = false)
    public boolean from_cache;

    @JSONField(serialize = false)
    public String log_id;

    public static class Info implements NonProguard {
        public boolean in_space;
        public String obj_token;
        public int obj_type;
        public String space_id;
        public UpgradeInfo upgrade_info;
        public String wiki_token;

        public String toString() {
            return "WikiInfo{wiki_token='" + du5.b.g(this.wiki_token) + "', obj_token='" + du5.b.g(this.obj_token) + "', obj_type=" + this.obj_type + ", in_space=" + this.in_space + '}';
        }

        public Info() {
            this.obj_type = -1;
            this.upgrade_info = null;
        }
    }

    public static class UpgradeInfo implements NonProguard {
        public String obj_token;
        public int obj_type;

        public UpgradeInfo() {
            this.obj_type = -1;
            this.obj_token = null;
        }
    }

    @JSONField(serialize = false)
    public boolean getInSpace() {
        DATA r100 = this.data;
        if (r100 != 0) goto L5;
    L7:
        return false;
    L5:
        if (((Info) r100).in_space == false) goto L7;
        return true;
    }

    @JSONField(serialize = false)
    public String getObjToken() {
        DATA r100 = this.data;
        if (r100 != 0) goto L6;
        return null;
    L6:
        return ((Info) r100).obj_token;
    }

    @JSONField(serialize = false)
    public int getObjType() {
        DATA r100 = this.data;
        if (r100 != 0) goto L6;
        return -1;
    L6:
        return ((Info) r100).obj_type;
    }

    @JSONField(serialize = false)
    public String getSpaceId() {
        DATA r100 = this.data;
        if (r100 != 0) goto L6;
        return null;
    L6:
        return ((Info) r100).space_id;
    }

    @JSONField(serialize = false)
    public String getWikiToken() {
        DATA r100 = this.data;
        if (r100 != 0) goto L6;
        return null;
    L6:
        return ((Info) r100).wiki_token;
    }

    @JSONField(serialize = false)
    public boolean isValid() {
        if (this.code == 0) goto L5;
    L15:
        return false;
    L5:
        if (TextUtils.isEmpty(getObjToken()) == true) goto L15;
        if (getObjType() == (-1)) goto L15;
        if (TextUtils.isEmpty(getSpaceId()) == true) goto L15;
        if (TextUtils.isEmpty(getWikiToken()) == true) goto L15;
        if (getInSpace() == true) goto L15;
        return true;
    }

    @JSONField(serialize = false)
    public boolean isValidObjInfo() {
        if (this.code == 0) goto L5;
    L15:
        return false;
    L5:
        if (TextUtils.isEmpty(getObjToken()) == true) goto L15;
        if (getObjType() == (-1)) goto L15;
        if (getInSpace() == true) goto L13;
        if (TextUtils.isEmpty(getSpaceId()) == true) goto L15;
    L13:
        if (TextUtils.isEmpty(getWikiToken()) == true) goto L15;
        return true;
    }

    public String toString() {
        return "WikiInfo{code=" + this.code + ", hash=" + hashCode() + ", msg='" + this.msg + "', data=" + this.data + ", from_cache=" + this.from_cache + '}';
    }

    @JSONField(serialize = false)
    public String getObjTypeString() {
        return sbb.e.f(getObjType());
    }

    public WikiInfo() {
    }

    public void setInSpace(boolean r100) {
        if (this.data != 0) goto L5;
        this.data = new Info();
    L5:
        ((Info) this.data).in_space = r100;
    }

    public void setObjToken(String r100) {
        if (this.data != 0) goto L5;
        this.data = new Info();
    L5:
        ((Info) this.data).obj_token = r100;
    }

    public void setObjType(int r100) {
        if (this.data != 0) goto L5;
        this.data = new Info();
    L5:
        ((Info) this.data).obj_type = r100;
    }

    public void setSpaceId(String r100) {
        if (this.data != 0) goto L5;
        this.data = new Info();
    L5:
        ((Info) this.data).space_id = r100;
    }

    public void setWikiToken(String r100) {
        if (this.data != 0) goto L5;
        this.data = new Info();
    L5:
        ((Info) this.data).wiki_token = r100;
    }
}
