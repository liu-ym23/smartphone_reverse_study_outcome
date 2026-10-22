package com.ss.android.lark.passport.signinsdk_api.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class PermissionScope implements Serializable {
    public boolean isSelected;
    public String key;
    public boolean required;
    public String text;

    public PermissionScope() {
        this.isSelected = true;
    }
}
