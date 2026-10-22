package com.bytedance.ee.bear.document.editionmanager.data;

import android.text.TextUtils;
import com.bytedance.ee.bear.common.DisplayName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class UsersBean implements Serializable {
    private DisplayName display_name;
    private String en_name;
    private String name;
    private String user_id;

    public UsersBean() {
    }

    public String toString() {
        return "UsersBean{en_name='" + TextUtils.isEmpty(this.en_name) + "', name='" + TextUtils.isEmpty(this.name) + "', user_id='" + this.user_id + "', display_name='" + this.display_name + "'}";
    }

    public DisplayName getDisplay_name() {
        return this.display_name;
    }

    public String getEn_name() {
        return this.en_name;
    }

    public String getName() {
        return this.name;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setDisplay_name(DisplayName r100) {
        this.display_name = r100;
    }

    public void setEn_name(String r100) {
        this.en_name = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setUser_id(String r100) {
        this.user_id = r100;
    }
}
