package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiServiceEntryStruct;", "Ljava/io/Serializable;", "schemaType", "", "url", "", "platformSource", "platformName", "(ILjava/lang/String;ILjava/lang/String;)V", "getPlatformName", "()Ljava/lang/String;", "getPlatformSource", "()I", "getSchemaType", "getUrl", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiServiceEntryStruct implements Serializable {

    @SerializedName("platform_name")
    private final String platformName;

    @SerializedName("platform_source")
    private final int platformSource;

    @SerializedName("schema_type")
    private final int schemaType;

    @SerializedName("url")
    private final String url;

    public final String getPlatformName() {
        return this.platformName;
    }

    public final int getPlatformSource() {
        return this.platformSource;
    }

    public final int getSchemaType() {
        return this.schemaType;
    }

    public final String getUrl() {
        return this.url;
    }

    public PoiServiceEntryStruct(int r100, String r101, int r102, String r103) {
        this.schemaType = r100;
        this.url = r101;
        this.platformSource = r102;
        this.platformName = r103;
    }

    public /* synthetic */ PoiServiceEntryStruct(int r100, String r101, int r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
