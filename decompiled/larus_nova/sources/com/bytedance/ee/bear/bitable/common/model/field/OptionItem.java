package com.bytedance.ee.bear.bitable.common.model.field;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes15.dex */
public class OptionItem implements NonProguard {
    private String borderColor;
    private int color;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f209860id;
    private String name;
    private String type;

    public int hashCode() {
        return super.hashCode();
    }

    public OptionItem() {
    }

    public String getBorderColor() {
        return this.borderColor;
    }

    public int getColor() {
        return this.color;
    }

    public String getId() {
        return this.f209860id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L18:
        return false;
    L5:
        if ((r100 instanceof OptionItem) == false) goto L18;
        OptionItem r101 = (OptionItem) r100;
        if (TextUtils.equals(this.f209860id, r101.f209860id) == true) goto L11;
        return false;
    L11:
        if (TextUtils.equals(this.name, r101.name) == true) goto L14;
        return false;
    L14:
        if (this.color == r101.color) goto L16;
        return false;
    L16:
        return true;
    }

    public void setBorderColor(String r100) {
        this.borderColor = r100;
    }

    public void setColor(int r100) {
        this.color = r100;
    }

    public void setId(String r100) {
        this.f209860id = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }

    public OptionItem(String r100, String r101, int r102) {
        this.f209860id = r100;
        this.name = r101;
        this.color = r102;
    }
}
