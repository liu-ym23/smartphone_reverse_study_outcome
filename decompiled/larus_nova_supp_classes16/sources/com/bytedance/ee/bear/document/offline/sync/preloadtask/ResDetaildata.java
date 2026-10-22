package com.bytedance.ee.bear.document.offline.sync.preloadtask;

import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010$\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001e\u0010!\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/preloadtask/ResDetaildata;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "mimeType", "", "getMimeType", "()Ljava/lang/String;", "setMimeType", "(Ljava/lang/String;)V", "name", "getName", "setName", "size", "", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "token", "getToken", "setToken", "width", "", "getWidth", "()Ljava/lang/Integer;", "setWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "height", "getHeight", "setHeight", "scale", "getScale", "setScale", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResDetaildata implements NonProguard {
    private Integer height;
    private String mimeType;
    private String name;
    private Long scale;
    private Long size;
    private String token;
    private Integer width;

    public ResDetaildata() {
    }

    public String toString() {
        return "ResDetaildata(mimeType=" + this.mimeType + ", name=" + this.name + ", size=" + this.size + ", token=" + b.g(this.token) + ", width=" + this.width + ", height=" + this.height + ", scale=" + this.scale + ')';
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getScale() {
        return this.scale;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getToken() {
        return this.token;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setHeight(Integer r1) {
        this.height = r1;
    }

    public final void setMimeType(String r1) {
        this.mimeType = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setScale(Long r1) {
        this.scale = r1;
    }

    public final void setSize(Long r1) {
        this.size = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }

    public final void setWidth(Integer r1) {
        this.width = r1;
    }
}
