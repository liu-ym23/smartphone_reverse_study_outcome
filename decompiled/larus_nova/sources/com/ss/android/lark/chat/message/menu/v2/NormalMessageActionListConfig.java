package com.ss.android.lark.chat.message.menu.v2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@AppConfig(key = "message_menu_list_normal")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003JI\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/NormalMessageActionListConfig;", "", "mobileConfig", "", "Lcom/ss/android/lark/chat/message/menu/v2/ActionGroup;", "mobilePartialConfig", "", "pcFloatingConfig", "Lcom/ss/android/lark/chat/message/menu/v2/PCActionGroup;", "pcRightConfig", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getMobileConfig", "()Ljava/util/List;", "getMobilePartialConfig", "getPcFloatingConfig", "getPcRightConfig", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NormalMessageActionListConfig {

    @SerializedName("mobile_config")
    private final List<ActionGroup> mobileConfig;

    @SerializedName("mobile_partial_config")
    private final List<String> mobilePartialConfig;

    @SerializedName("pc_floating_config")
    private final List<PCActionGroup> pcFloatingConfig;

    @SerializedName("pc_right_config")
    private final List<PCActionGroup> pcRightConfig;

    public NormalMessageActionListConfig() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NormalMessageActionListConfig copy$default(NormalMessageActionListConfig r100, List r101, List r102, List r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.mobileConfig;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.mobilePartialConfig;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.pcFloatingConfig;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.pcRightConfig;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<ActionGroup> component1() {
        return this.mobileConfig;
    }

    public final List<String> component2() {
        return this.mobilePartialConfig;
    }

    public final List<PCActionGroup> component3() {
        return this.pcFloatingConfig;
    }

    public final List<PCActionGroup> component4() {
        return this.pcRightConfig;
    }

    public final NormalMessageActionListConfig copy(List<ActionGroup> r100, List<String> r101, List<PCActionGroup> r102, List<PCActionGroup> r103) {
        Intrinsics.checkNotNullParameter(r100, "mobileConfig");
        Intrinsics.checkNotNullParameter(r101, "mobilePartialConfig");
        Intrinsics.checkNotNullParameter(r102, "pcFloatingConfig");
        Intrinsics.checkNotNullParameter(r103, "pcRightConfig");
        return new NormalMessageActionListConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NormalMessageActionListConfig) == true) goto L8;
        return false;
    L8:
        NormalMessageActionListConfig r101 = (NormalMessageActionListConfig) r100;
        if (Intrinsics.areEqual(this.mobileConfig, r101.mobileConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mobilePartialConfig, r101.mobilePartialConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pcFloatingConfig, r101.pcFloatingConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pcRightConfig, r101.pcRightConfig) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.mobileConfig.hashCode() * 31) + this.mobilePartialConfig.hashCode()) * 31) + this.pcFloatingConfig.hashCode()) * 31) + this.pcRightConfig.hashCode();
    }

    public String toString() {
        return "NormalMessageActionListConfig(mobileConfig=" + this.mobileConfig + ", mobilePartialConfig=" + this.mobilePartialConfig + ", pcFloatingConfig=" + this.pcFloatingConfig + ", pcRightConfig=" + this.pcRightConfig + ')';
    }

    public final List<ActionGroup> getMobileConfig() {
        return this.mobileConfig;
    }

    public final List<String> getMobilePartialConfig() {
        return this.mobilePartialConfig;
    }

    public final List<PCActionGroup> getPcFloatingConfig() {
        return this.pcFloatingConfig;
    }

    public final List<PCActionGroup> getPcRightConfig() {
        return this.pcRightConfig;
    }

    public NormalMessageActionListConfig(List<ActionGroup> r100, List<String> r101, List<PCActionGroup> r102, List<PCActionGroup> r103) {
        Intrinsics.checkNotNullParameter(r100, "mobileConfig");
        Intrinsics.checkNotNullParameter(r101, "mobilePartialConfig");
        Intrinsics.checkNotNullParameter(r102, "pcFloatingConfig");
        Intrinsics.checkNotNullParameter(r103, "pcRightConfig");
        this.mobileConfig = r100;
        this.mobilePartialConfig = r101;
        this.pcFloatingConfig = r102;
        this.pcRightConfig = r103;
    }

    public /* synthetic */ NormalMessageActionListConfig(List r100, List r101, List r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = new ArrayList();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = new ArrayList();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = new ArrayList();
    L14:
        this(r100, r101, r102, r103);
    }
}
