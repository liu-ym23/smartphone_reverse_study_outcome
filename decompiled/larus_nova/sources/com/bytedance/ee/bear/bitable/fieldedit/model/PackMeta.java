package com.bytedance.ee.bear.bitable.fieldedit.model;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/PackMeta;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "iconURL", "getIconURL", "setIconURL", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PackMeta implements NonProguard {
    private String iconURL;
    private String name;

    public PackMeta() {
    }

    public final String getIconURL() {
        return this.iconURL;
    }

    public final String getName() {
        return this.name;
    }

    public final void setIconURL(String r100) {
        this.iconURL = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }
}
