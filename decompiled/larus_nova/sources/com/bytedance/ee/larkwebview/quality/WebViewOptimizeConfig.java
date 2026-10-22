package com.bytedance.ee.larkwebview.quality;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@AppConfig(key = "chameleon_webview_optimize_config")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/larkwebview/quality/WebViewOptimizeConfig;", "", "blankScreen", "Lcom/bytedance/ee/larkwebview/quality/BlankScreenConfig;", "hangDetect", "Lcom/bytedance/ee/larkwebview/quality/HangDetectConfig;", "<init>", "(Lcom/bytedance/ee/larkwebview/quality/BlankScreenConfig;Lcom/bytedance/ee/larkwebview/quality/HangDetectConfig;)V", "getBlankScreen", "()Lcom/bytedance/ee/larkwebview/quality/BlankScreenConfig;", "setBlankScreen", "(Lcom/bytedance/ee/larkwebview/quality/BlankScreenConfig;)V", "getHangDetect", "()Lcom/bytedance/ee/larkwebview/quality/HangDetectConfig;", "setHangDetect", "(Lcom/bytedance/ee/larkwebview/quality/HangDetectConfig;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lark-webview-base_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebViewOptimizeConfig {

    @SerializedName("blank_screen")
    private BlankScreenConfig blankScreen;

    @SerializedName("hang_detect")
    private HangDetectConfig hangDetect;

    /* JADX WARN: Multi-variable type inference failed */
    public WebViewOptimizeConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WebViewOptimizeConfig copy$default(WebViewOptimizeConfig r100, BlankScreenConfig r101, HangDetectConfig r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.blankScreen;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.hangDetect;
    L9:
        return r100.copy(r101, r102);
    }

    public final BlankScreenConfig component1() {
        return this.blankScreen;
    }

    public final HangDetectConfig component2() {
        return this.hangDetect;
    }

    public final WebViewOptimizeConfig copy(BlankScreenConfig r100, HangDetectConfig r101) {
        return new WebViewOptimizeConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WebViewOptimizeConfig) == true) goto L8;
        return false;
    L8:
        WebViewOptimizeConfig r101 = (WebViewOptimizeConfig) r100;
        if (Intrinsics.areEqual(this.blankScreen, r101.blankScreen) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hangDetect, r101.hangDetect) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        BlankScreenConfig r100 = this.blankScreen;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        HangDetectConfig r104 = this.hangDetect;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "WebViewOptimizeConfig(blankScreen=" + this.blankScreen + ", hangDetect=" + this.hangDetect + ')';
    }

    public final BlankScreenConfig getBlankScreen() {
        return this.blankScreen;
    }

    public final HangDetectConfig getHangDetect() {
        return this.hangDetect;
    }

    public final void setBlankScreen(BlankScreenConfig r100) {
        this.blankScreen = r100;
    }

    public final void setHangDetect(HangDetectConfig r100) {
        this.hangDetect = r100;
    }

    public WebViewOptimizeConfig(BlankScreenConfig r100, HangDetectConfig r101) {
        this.blankScreen = r100;
        this.hangDetect = r101;
    }

    public /* synthetic */ WebViewOptimizeConfig(BlankScreenConfig r110, HangDetectConfig r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        BlankScreenConfig r100 = new BlankScreenConfig(false, 0, 0.0f, false, false, 0, false, 127, null);
    L7:
        if ((r211 & 2) == 0) goto L9;
        HangDetectConfig r101 = new HangDetectConfig(false, false, 0, 0, 0, 0, 0, 0, 0, 511, null);
    L10:
        this(r100, r101);
        return;
    L9:
        r101 = r210;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
