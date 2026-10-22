package com.bytedance.locallife.cube.api.config;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J;\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050$2\b\u0010%\u001a\u0004\u0018\u00010\u0000J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/bytedance/locallife/cube/api/config/CubeConfig;", "", "activity", "Landroid/app/Activity;", "scene", "", "cubeInitConfig", "Lcom/bytedance/locallife/cube/api/config/CubeInitConfig;", "lynxInitConfig", "Lcom/bytedance/locallife/cube/api/config/LynxInitConfig;", "lynxLoadConfig", "Lcom/bytedance/locallife/cube/api/config/LynxLoadConfig;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/bytedance/locallife/cube/api/config/CubeInitConfig;Lcom/bytedance/locallife/cube/api/config/LynxInitConfig;Lcom/bytedance/locallife/cube/api/config/LynxLoadConfig;)V", "getActivity", "()Landroid/app/Activity;", "getCubeInitConfig", "()Lcom/bytedance/locallife/cube/api/config/CubeInitConfig;", "setCubeInitConfig", "(Lcom/bytedance/locallife/cube/api/config/CubeInitConfig;)V", "getLynxInitConfig", "()Lcom/bytedance/locallife/cube/api/config/LynxInitConfig;", "setLynxInitConfig", "(Lcom/bytedance/locallife/cube/api/config/LynxInitConfig;)V", "getLynxLoadConfig", "()Lcom/bytedance/locallife/cube/api/config/LynxLoadConfig;", "setLynxLoadConfig", "(Lcom/bytedance/locallife/cube/api/config/LynxLoadConfig;)V", "getScene", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "different", "", "cubeConfig", "equals", "", "other", "hashCode", "", "toString", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CubeConfig {
    private final Activity activity;
    private CubeInitConfig cubeInitConfig;
    private LynxInitConfig lynxInitConfig;
    private LynxLoadConfig lynxLoadConfig;
    private final String scene;

    public static /* synthetic */ CubeConfig copy$default(CubeConfig r100, Activity r101, String r102, CubeInitConfig r103, LynxInitConfig r104, LynxLoadConfig r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.activity;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.scene;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.cubeInitConfig;
    L11:
        CubeInitConfig r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.lynxInitConfig;
    L14:
        LynxInitConfig r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.lynxLoadConfig;
    L17:
        Activity r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Activity component1() {
        return this.activity;
    }

    public final String component2() {
        return this.scene;
    }

    public final CubeInitConfig component3() {
        return this.cubeInitConfig;
    }

    public final LynxInitConfig component4() {
        return this.lynxInitConfig;
    }

    public final LynxLoadConfig component5() {
        return this.lynxLoadConfig;
    }

    public final CubeConfig copy(Activity r100, String r101, CubeInitConfig r110, LynxInitConfig r111, LynxLoadConfig r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r110, "cubeInitConfig");
        Intrinsics.checkNotNullParameter(r111, "lynxInitConfig");
        Intrinsics.checkNotNullParameter(r112, "lynxLoadConfig");
        return new CubeConfig(r100, r101, r110, r111, r112);
    }

    public int hashCode() {
        return (((((((this.activity.hashCode() * 31) + this.scene.hashCode()) * 31) + this.cubeInitConfig.hashCode()) * 31) + this.lynxInitConfig.hashCode()) * 31) + this.lynxLoadConfig.hashCode();
    }

    public String toString() {
        return "CubeConfig(activity=" + this.activity + ", cubeInitConfig=" + this.cubeInitConfig + ", lynxInitConfig=" + this.lynxInitConfig + ", lynxLoadConfig=" + this.lynxLoadConfig + ')';
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final CubeInitConfig getCubeInitConfig() {
        return this.cubeInitConfig;
    }

    public final LynxInitConfig getLynxInitConfig() {
        return this.lynxInitConfig;
    }

    public final LynxLoadConfig getLynxLoadConfig() {
        return this.lynxLoadConfig;
    }

    public final String getScene() {
        return this.scene;
    }

    public final List<String> different(CubeConfig r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L7;
        r101.add("CubeConfig");
        return r101;
    L7:
        if (Intrinsics.areEqual(this.activity, r100.activity) == true) goto L10;
        r101.add("CubeConfig.activity");
    L10:
        if (Intrinsics.areEqual(this.scene, r100.scene) == true) goto L12;
        r101.add("CubeConfig.scene");
    L12:
        r101.addAll(this.cubeInitConfig.different(r100.cubeInitConfig));
        r101.addAll(this.lynxInitConfig.different(r100.lynxInitConfig));
        return r101;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(CubeConfig.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.locallife.cube.api.config.CubeConfig");
        CubeConfig r102 = (CubeConfig) r100;
        if (Intrinsics.areEqual(this.activity, r102.activity) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.scene, r102.scene) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.cubeInitConfig, r102.cubeInitConfig) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.lynxInitConfig, r102.lynxInitConfig) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.lynxLoadConfig, r102.lynxLoadConfig) == true) goto L27;
        return false;
    L27:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setCubeInitConfig(CubeInitConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cubeInitConfig = r100;
    }

    public final void setLynxInitConfig(LynxInitConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lynxInitConfig = r100;
    }

    public final void setLynxLoadConfig(LynxLoadConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lynxLoadConfig = r100;
    }

    public CubeConfig(Activity r100, String r101, CubeInitConfig r102, LynxInitConfig r103, LynxLoadConfig r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "cubeInitConfig");
        Intrinsics.checkNotNullParameter(r103, "lynxInitConfig");
        Intrinsics.checkNotNullParameter(r104, "lynxLoadConfig");
        this.activity = r100;
        this.scene = r101;
        this.cubeInitConfig = r102;
        this.lynxInitConfig = r103;
        this.lynxLoadConfig = r104;
    }

    public /* synthetic */ CubeConfig(Activity r310, String r311, CubeInitConfig r312, LynxInitConfig r313, LynxLoadConfig r314, int r410, DefaultConstructorMarker r411) {
        if ((r410 & 4) == 0) goto L5;
        CubeInitConfig r100 = new CubeInitConfig(null, null, 3, null);
    L7:
        if ((r410 & 8) == 0) goto L9;
        LynxInitConfig r101 = new LynxInitConfig(null, null, null, null, false, false, null, false, false, null, false, false, 0, 0, 0, 0, null, false, 0, false, null, false, false, false, 16777215, null);
    L11:
        if ((r410 & 16) == 0) goto L13;
        LynxLoadConfig r102 = new LynxLoadConfig(false, false, null, null, null, false, false, 127, null);
    L14:
        this(r310, r311, r100, r101, r102);
        return;
    L13:
        r102 = r314;
        goto L14
    L9:
        r101 = r313;
        goto L11
    L5:
        r100 = r312;
        goto L7
    }
}
