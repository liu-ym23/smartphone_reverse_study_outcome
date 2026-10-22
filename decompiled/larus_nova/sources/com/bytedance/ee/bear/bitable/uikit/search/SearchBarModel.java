package com.bytedance.ee.bear.bitable.uikit.search;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/search/SearchBarModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "hint", "getHint", "setHint", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchBarModel implements NonProguard {
    private String hint;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f216221id;

    public SearchBarModel() {
    }

    public final String getHint() {
        return this.hint;
    }

    public final String getId() {
        return this.f216221id;
    }

    public final void setHint(String r100) {
        this.hint = r100;
    }

    public final void setId(String r100) {
        this.f216221id = r100;
    }
}
