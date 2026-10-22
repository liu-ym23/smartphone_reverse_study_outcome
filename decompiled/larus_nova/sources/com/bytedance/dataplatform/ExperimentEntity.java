package com.bytedance.dataplatform;

import android.text.TextUtils;
import java.io.Serializable;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes15.dex */
public class ExperimentEntity implements Serializable {
    private ij4.a clientDataSource;
    private Object defaultValue;
    private String description;
    private String key;
    private String[] option;
    private Type type;

    public int hashCode() {
        if (TextUtils.isEmpty(this.key) == false) goto L6;
        return 0;
    L6:
        return this.key.hashCode();
    }

    public ij4.a getClientDataSource() {
        return this.clientDataSource;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public String getDescription() {
        return this.description;
    }

    public String getKey() {
        return this.key;
    }

    public String[] getOption() {
        return this.option;
    }

    public Type getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ExperimentEntity) == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(this.key, ((ExperimentEntity) r100).key) == false) goto L7;
        return true;
    }

    public ExperimentEntity withClientDataSource(ij4.a r100) {
        this.clientDataSource = r100;
        return this;
    }

    public ExperimentEntity(String r100, Type r101, Object r102, String r103, String... r104) {
        this.key = r100;
        this.description = r103;
        this.option = r104;
        this.type = r101;
        this.defaultValue = r102;
    }
}
