package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/RenderItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "type", "getType", "setType", "equals", "", "other", "", "hashCode", "", "isRecord", "isGroupHeader", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderItem implements NonProguard {
    public static final a Companion = null;
    public static final String TYPE_GROUPHEADER = "groupHeader";
    public static final String TYPE_RECORD = "record";

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f213299id;
    private String type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public int hashCode() {
        return this.f213299id.hashCode();
    }

    public final boolean isGroupHeader() {
        return TextUtils.equals(this.type, TYPE_GROUPHEADER);
    }

    public final boolean isRecord() {
        return TextUtils.equals(this.type, "record");
    }

    public RenderItem() {
        this.f213299id = "";
    }

    public final String getId() {
        return this.f213299id;
    }

    public final String getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(RenderItem.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.infoarch.nativeview.common.RenderItem");
        if (Intrinsics.areEqual(this.f213299id, ((RenderItem) r100).f213299id) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213299id = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
