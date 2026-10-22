package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/ClientStyleConfig;", "Ljava/io/Serializable;", "firstScreenCardNum", "", "backgroundConfig", "Lcom/bytedance/locallife/live/goodsshelves/bean/BackgroundConfig;", "(ILcom/bytedance/locallife/live/goodsshelves/bean/BackgroundConfig;)V", "getBackgroundConfig", "()Lcom/bytedance/locallife/live/goodsshelves/bean/BackgroundConfig;", "getFirstScreenCardNum", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ClientStyleConfig implements Serializable {

    @SerializedName("background_config")
    private final BackgroundConfig backgroundConfig;

    @SerializedName("first_screen_card_num")
    private final int firstScreenCardNum;

    /* JADX WARN: Multi-variable type inference failed */
    public ClientStyleConfig() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ClientStyleConfig copy$default(ClientStyleConfig r100, int r101, BackgroundConfig r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.firstScreenCardNum;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.backgroundConfig;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.firstScreenCardNum;
    }

    public final BackgroundConfig component2() {
        return this.backgroundConfig;
    }

    public final ClientStyleConfig copy(int r100, BackgroundConfig r101) {
        return new ClientStyleConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClientStyleConfig) == true) goto L8;
        return false;
    L8:
        ClientStyleConfig r101 = (ClientStyleConfig) r100;
        if (this.firstScreenCardNum == r101.firstScreenCardNum) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.backgroundConfig, r101.backgroundConfig) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.firstScreenCardNum * 31;
        BackgroundConfig r101 = this.backgroundConfig;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ClientStyleConfig(firstScreenCardNum=" + this.firstScreenCardNum + ", backgroundConfig=" + this.backgroundConfig + ')';
    }

    public final BackgroundConfig getBackgroundConfig() {
        return this.backgroundConfig;
    }

    public final int getFirstScreenCardNum() {
        return this.firstScreenCardNum;
    }

    public ClientStyleConfig(int r100, BackgroundConfig r101) {
        this.firstScreenCardNum = r100;
        this.backgroundConfig = r101;
    }

    public /* synthetic */ ClientStyleConfig(int r100, BackgroundConfig r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 5;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
