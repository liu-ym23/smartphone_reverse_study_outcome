package com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@JsonAdapter(ContentWraperTypeAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0001\u0010\u0013¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/ContentWraper;", "Content", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/IContent;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "data", "getData", "()Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/IContent;", "setData", "(Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/IContent;)V", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/IContent;", "dataType", "", "getDataType", "()Ljava/lang/String;", "setDataType", "(Ljava/lang/String;)V", "getContent", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "equals", "", "other", "", "hashCode", "", "middleground-feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentWraper<Content extends IContent> implements NonProguard {
    private Content data;
    private String dataType;

    public final <T> T getContent() {
        Content r100 = this.data;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100;
    }

    public int hashCode() {
        Content r100 = this.data;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.dataType.hashCode();
    L5:
        r101 = 0;
        goto L7
    }

    public ContentWraper() {
        this.dataType = "";
    }

    public final Content getData() {
        return this.data;
    }

    public final String getDataType() {
        return this.dataType;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ContentWraper.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.ContentWraper<*>");
        ContentWraper r102 = (ContentWraper) r100;
        if (Intrinsics.areEqual(this.data, r102.data) == true) goto L16;
        return false;
    L16:
        if (TextUtils.equals(this.dataType, r102.dataType) == false) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setData(Content r100) {
        this.data = r100;
    }

    public final void setDataType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dataType = r100;
    }
}
