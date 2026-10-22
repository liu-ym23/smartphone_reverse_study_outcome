package com.bytedance.ee.bear.bitable.uikit.tree;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "type", "getType", "setType", "level", "", "getLevel", "()I", "setLevel", "(I)V", "equals", "", "other", "", "hashCode", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderItem implements NonProguard {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f216229id;
    private int level;
    private String type;

    public int hashCode() {
        int r100 = this.f216229id.hashCode() * 31;
        String r101 = this.type;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) * 31) + this.level;
    L5:
        r102 = 0;
        goto L7
    }

    public RenderItem() {
        this.f216229id = "";
    }

    public final String getId() {
        return this.f216229id;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getType() {
        return this.type;
    }

    public RenderItem(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f216229id = r100;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof RenderItem) == false) goto L7;
        return TextUtils.equals(this.f216229id, ((RenderItem) r100).f216229id);
    L7:
        return super.equals(r100);
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f216229id = r100;
    }

    public final void setLevel(int r100) {
        this.level = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
