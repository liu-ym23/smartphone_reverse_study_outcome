package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()I", "setType", "(I)V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "name", "getName", "setName", "src", "getSrc", "setSrc", "isSupport", "", "()Ljava/lang/Boolean;", "setSupport", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontItem implements NonProguard {

    @SerializedName("isSupport")
    private Boolean isSupport;

    @SerializedName("key")
    private String key;

    @SerializedName("name")
    private String name;

    /* JADX INFO: renamed from: src, reason: collision with root package name */
    @SerializedName("src")
    private String f238678src;

    @SerializedName("type")
    private int type;

    public FontItem() {
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSrc() {
        return this.f238678src;
    }

    public final int getType() {
        return this.type;
    }

    public final Boolean isSupport() {
        return this.isSupport;
    }

    public final void setKey(String r100) {
        this.key = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setSrc(String r100) {
        this.f238678src = r100;
    }

    public final void setSupport(Boolean r100) {
        this.isSupport = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }
}
