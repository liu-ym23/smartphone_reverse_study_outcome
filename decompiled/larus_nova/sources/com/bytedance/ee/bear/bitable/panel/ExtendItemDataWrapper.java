package com.bytedance.ee.bear.bitable.panel;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/ExtendItemDataWrapper;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "data", "Lcom/bytedance/ee/bear/bitable/panel/ExtendItemData;", "getData", "()Lcom/bytedance/ee/bear/bitable/panel/ExtendItemData;", "setData", "(Lcom/bytedance/ee/bear/bitable/panel/ExtendItemData;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtendItemDataWrapper implements NonProguard {
    private ExtendItemData data;
    private boolean enable;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f214830id;

    public ExtendItemDataWrapper() {
        this.f214830id = "";
        this.enable = true;
    }

    public final ExtendItemData getData() {
        return this.data;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getId() {
        return this.f214830id;
    }

    public final void setData(ExtendItemData r100) {
        this.data = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f214830id = r100;
    }
}
