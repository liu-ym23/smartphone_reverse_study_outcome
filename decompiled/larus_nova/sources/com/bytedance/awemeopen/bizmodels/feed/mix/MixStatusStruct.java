package com.bytedance.awemeopen.bizmodels.feed.mix;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fB\t\b\u0016¢\u0006\u0004\b\u000e\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStatusStruct;", "Ljava/io/Serializable;", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "isCollected", "setCollected", "viewedInMix", "getViewedInMix", "setViewedInMix", "<init>", "(III)V", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class MixStatusStruct implements Serializable {
    public static final a Companion = null;
    public static final int STATUS_CHECKING = 1;
    public static final int STATUS_CHECK_PASS = 2;
    public static final int STATUS_CHECK_VISIBLE_TO_SELF = 3;
    public static final int STATUS_DELETED = 4;
    public static final int STATUS_PUBLIC = 5;
    public static final int STATUS_READY_PUBLISH = 0;

    @SerializedName("is_collected")
    private int isCollected;

    @SerializedName("status")
    private int status;

    @SerializedName("viewed_in_mix")
    private int viewedInMix;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MixStatusStruct() {
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getViewedInMix() {
        return this.viewedInMix;
    }

    public final int isCollected() {
        return this.isCollected;
    }

    public final void setCollected(int r100) {
        this.isCollected = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setViewedInMix(int r100) {
        this.viewedInMix = r100;
    }

    public MixStatusStruct(int r100, int r101, int r102) {
        this.status = r100;
        this.isCollected = r101;
        this.viewedInMix = r102;
    }
}
