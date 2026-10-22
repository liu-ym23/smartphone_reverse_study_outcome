package com.bytedance.ee.bear;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: classes15.dex */
public class BlockSimpleInfo implements NonProguard {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f206178id;
    private String name;
    private String type;

    public BlockSimpleInfo() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f206178id, this.name});
    }

    public Boolean isDashboard() {
        return Boolean.valueOf(TextUtils.equals(this.type, "DASHBOARD"));
    }

    public Boolean isDocx() {
        return Boolean.valueOf(TextUtils.equals(this.type, "LINKED_DOCX"));
    }

    public Boolean isTable() {
        return Boolean.valueOf(TextUtils.equals(this.type, "BITABLE_TABLE"));
    }

    public String getId() {
        return this.f206178id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        BlockSimpleInfo r101 = (BlockSimpleInfo) r100;
        if (Objects.equals(this.f206178id, r101.f206178id) == true) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.name, r101.name) == false) goto L15;
        return true;
    }

    public void setId(String r100) {
        this.f206178id = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }
}
