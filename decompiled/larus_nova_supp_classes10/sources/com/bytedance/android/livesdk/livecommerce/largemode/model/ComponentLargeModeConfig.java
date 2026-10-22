package com.bytedance.android.livesdk.livecommerce.largemode.model;

import com.google.gson.annotations.SerializedName;
import hi2.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/largemode/model/ComponentLargeModeConfig;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutLargeModeConfig;", "component2", "Lhi2/a;", "component3", "componentName", "layoutConfig", "textConfig", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getComponentName", "()Ljava/lang/String;", "Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutLargeModeConfig;", "getLayoutConfig", "()Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutLargeModeConfig;", "Lhi2/a;", "getTextConfig", "()Lhi2/a;", "<init>", "(Ljava/lang/String;Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutLargeModeConfig;Lhi2/a;)V", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class ComponentLargeModeConfig implements Serializable {

    @SerializedName("component_name")
    private final String componentName;

    @SerializedName("layout")
    private final LayoutLargeModeConfig layoutConfig;

    @SerializedName("text")
    private final a textConfig;

    public static /* synthetic */ ComponentLargeModeConfig copy$default(ComponentLargeModeConfig r0, String r1, LayoutLargeModeConfig r2, a r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.componentName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.layoutConfig;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.textConfig;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.componentName;
    }

    public final LayoutLargeModeConfig component2() {
        return this.layoutConfig;
    }

    public final a component3() {
        return this.textConfig;
    }

    public final ComponentLargeModeConfig copy(String r2, LayoutLargeModeConfig r3, a r4) {
        return new ComponentLargeModeConfig(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ComponentLargeModeConfig) == false) goto L12;
        ComponentLargeModeConfig r4 = (ComponentLargeModeConfig) r3;
        if (Intrinsics.areEqual(this.componentName, r4.componentName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.layoutConfig, r4.layoutConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.textConfig, r4.textConfig) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.componentName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        LayoutLargeModeConfig r4 = this.layoutConfig;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        a r7 = this.textConfig;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ComponentLargeModeConfig(componentName=" + this.componentName + ", layoutConfig=" + this.layoutConfig + ", textConfig=" + this.textConfig + ")";
    }

    public final String getComponentName() {
        return this.componentName;
    }

    public final LayoutLargeModeConfig getLayoutConfig() {
        return this.layoutConfig;
    }

    public final a getTextConfig() {
        return this.textConfig;
    }

    public ComponentLargeModeConfig(String r1, LayoutLargeModeConfig r2, a r3) {
        this.componentName = r1;
        this.layoutConfig = r2;
        this.textConfig = r3;
    }

    public /* synthetic */ ComponentLargeModeConfig(String r2, LayoutLargeModeConfig r3, a r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }
}
