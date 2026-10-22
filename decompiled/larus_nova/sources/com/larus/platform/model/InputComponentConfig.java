package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/InputComponentConfig;", "", "feishuInputConfigEnable", "", "doubaoMainChatInputConfigEnable", "aiFloatChatInputConfigEnable", "<init>", "(ZZZ)V", "getFeishuInputConfigEnable", "()Z", "getDoubaoMainChatInputConfigEnable", "getAiFloatChatInputConfigEnable", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputComponentConfig {

    @SerializedName("ai_float_chat_input_config_enable")
    private final boolean aiFloatChatInputConfigEnable;

    @SerializedName("doubao_main_chat_input_config_enable")
    private final boolean doubaoMainChatInputConfigEnable;

    @SerializedName("feishu_input_config_enable")
    private final boolean feishuInputConfigEnable;

    public InputComponentConfig() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ InputComponentConfig copy$default(InputComponentConfig r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.feishuInputConfigEnable;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.doubaoMainChatInputConfigEnable;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.aiFloatChatInputConfigEnable;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.feishuInputConfigEnable;
    }

    public final boolean component2() {
        return this.doubaoMainChatInputConfigEnable;
    }

    public final boolean component3() {
        return this.aiFloatChatInputConfigEnable;
    }

    public final InputComponentConfig copy(boolean r100, boolean r101, boolean r102) {
        return new InputComponentConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InputComponentConfig) == true) goto L8;
        return false;
    L8:
        InputComponentConfig r101 = (InputComponentConfig) r100;
        if (this.feishuInputConfigEnable == r101.feishuInputConfigEnable) goto L12;
        return false;
    L12:
        if (this.doubaoMainChatInputConfigEnable == r101.doubaoMainChatInputConfigEnable) goto L15;
        return false;
    L15:
        if (this.aiFloatChatInputConfigEnable == r101.aiFloatChatInputConfigEnable) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.feishuInputConfigEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.doubaoMainChatInputConfigEnable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.aiFloatChatInputConfigEnable == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "InputComponentConfig(feishuInputConfigEnable=" + this.feishuInputConfigEnable + ", doubaoMainChatInputConfigEnable=" + this.doubaoMainChatInputConfigEnable + ", aiFloatChatInputConfigEnable=" + this.aiFloatChatInputConfigEnable + ')';
    }

    public final boolean getAiFloatChatInputConfigEnable() {
        return this.aiFloatChatInputConfigEnable;
    }

    public final boolean getDoubaoMainChatInputConfigEnable() {
        return this.doubaoMainChatInputConfigEnable;
    }

    public final boolean getFeishuInputConfigEnable() {
        return this.feishuInputConfigEnable;
    }

    public InputComponentConfig(boolean r100, boolean r101, boolean r102) {
        this.feishuInputConfigEnable = r100;
        this.doubaoMainChatInputConfigEnable = r101;
        this.aiFloatChatInputConfigEnable = r102;
    }

    public /* synthetic */ InputComponentConfig(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
