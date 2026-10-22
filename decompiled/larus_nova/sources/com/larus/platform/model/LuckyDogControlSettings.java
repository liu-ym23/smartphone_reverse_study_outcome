package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/LuckyDogControlSettings;", "Ljava/io/Serializable;", "enableTask", "", "enableInterceptor", "interceptPaths", "", "", "settingsRunOnIo", "enableCrossClipboardRead", "<init>", "(ZZLjava/util/List;ZZ)V", "getEnableTask", "()Z", "getEnableInterceptor", "getInterceptPaths", "()Ljava/util/List;", "getSettingsRunOnIo", "getEnableCrossClipboardRead", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LuckyDogControlSettings implements Serializable {

    @SerializedName("enable_cross_clipboard_read")
    private final boolean enableCrossClipboardRead;

    @SerializedName("enable_interceptor")
    private final boolean enableInterceptor;

    @SerializedName("enable_task")
    private final boolean enableTask;

    @SerializedName("intercept_paths")
    private final List<String> interceptPaths;

    @SerializedName("settings_run_on_io")
    private final boolean settingsRunOnIo;

    public LuckyDogControlSettings() {
        this(false, false, null, false, false, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LuckyDogControlSettings copy$default(LuckyDogControlSettings r100, boolean r101, boolean r102, List r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.enableTask;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.enableInterceptor;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.interceptPaths;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.settingsRunOnIo;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.enableCrossClipboardRead;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.enableTask;
    }

    public final boolean component2() {
        return this.enableInterceptor;
    }

    public final List<String> component3() {
        return this.interceptPaths;
    }

    public final boolean component4() {
        return this.settingsRunOnIo;
    }

    public final boolean component5() {
        return this.enableCrossClipboardRead;
    }

    public final LuckyDogControlSettings copy(boolean r100, boolean r101, List<String> r110, boolean r111, boolean r112) {
        return new LuckyDogControlSettings(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LuckyDogControlSettings) == true) goto L8;
        return false;
    L8:
        LuckyDogControlSettings r101 = (LuckyDogControlSettings) r100;
        if (this.enableTask == r101.enableTask) goto L12;
        return false;
    L12:
        if (this.enableInterceptor == r101.enableInterceptor) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.interceptPaths, r101.interceptPaths) == true) goto L18;
        return false;
    L18:
        if (this.settingsRunOnIo == r101.settingsRunOnIo) goto L21;
        return false;
    L21:
        if (this.enableCrossClipboardRead == r101.enableCrossClipboardRead) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableTask == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableInterceptor == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        List<String> r105 = this.interceptPaths;
        if (r105 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r104 + r106) * 31;
        if (this.settingsRunOnIo == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.enableCrossClipboardRead == true) goto L23;
        r100 = 1237;
    L23:
        return r109 + r100;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "LuckyDogControlSettings(enableTask=" + this.enableTask + ", enableInterceptor=" + this.enableInterceptor + ", interceptPaths=" + this.interceptPaths + ", settingsRunOnIo=" + this.settingsRunOnIo + ", enableCrossClipboardRead=" + this.enableCrossClipboardRead + ')';
    }

    public final boolean getEnableCrossClipboardRead() {
        return this.enableCrossClipboardRead;
    }

    public final boolean getEnableInterceptor() {
        return this.enableInterceptor;
    }

    public final boolean getEnableTask() {
        return this.enableTask;
    }

    public final List<String> getInterceptPaths() {
        return this.interceptPaths;
    }

    public final boolean getSettingsRunOnIo() {
        return this.settingsRunOnIo;
    }

    public LuckyDogControlSettings(boolean r100, boolean r101, List<String> r102, boolean r103, boolean r104) {
        this.enableTask = r100;
        this.enableInterceptor = r101;
        this.interceptPaths = r102;
        this.settingsRunOnIo = r103;
        this.enableCrossClipboardRead = r104;
    }

    public /* synthetic */ LuckyDogControlSettings(boolean r100, boolean r101, List r102, boolean r103, boolean r104, int r110, DefaultConstructorMarker r111) {
        boolean r105 = true;
        if ((r110 & 1) == 0) goto L5;
        boolean r112 = true;
    L7:
        if ((r110 & 2) == 0) goto L9;
        boolean r106 = false;
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = null;
    L13:
        List r107 = r102;
        if ((r110 & 8) != 0) goto L18;
        r105 = r103;
    L18:
        if ((r110 & 16) == 0) goto L20;
        boolean r113 = false;
    L21:
        this(r112, r106, r107, r105, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L9:
        r106 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
