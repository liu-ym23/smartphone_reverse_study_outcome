package com.larus.settings.provider.bootprotector;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/settings/provider/bootprotector/BootProtectorBizCallbackConfig;", "", "enableBizCallback", "", "bizCrashPortraits", "", "Lcom/larus/settings/provider/bootprotector/BizCrashPortraits;", "<init>", "(ZLjava/util/List;)V", "getEnableBizCallback", "()Z", "getBizCrashPortraits", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BootProtectorBizCallbackConfig {

    @SerializedName("biz_crash_portraits")
    private final List<BizCrashPortraits> bizCrashPortraits;

    @SerializedName("enable_biz_callback")
    private final boolean enableBizCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public BootProtectorBizCallbackConfig() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BootProtectorBizCallbackConfig copy$default(BootProtectorBizCallbackConfig r100, boolean r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enableBizCallback;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.bizCrashPortraits;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.enableBizCallback;
    }

    public final List<BizCrashPortraits> component2() {
        return this.bizCrashPortraits;
    }

    public final BootProtectorBizCallbackConfig copy(boolean r100, List<BizCrashPortraits> r101) {
        return new BootProtectorBizCallbackConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BootProtectorBizCallbackConfig) == true) goto L8;
        return false;
    L8:
        BootProtectorBizCallbackConfig r101 = (BootProtectorBizCallbackConfig) r100;
        if (this.enableBizCallback == r101.enableBizCallback) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizCrashPortraits, r101.bizCrashPortraits) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.enableBizCallback == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        List<BizCrashPortraits> r102 = this.bizCrashPortraits;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "BootProtectorBizCallbackConfig(enableBizCallback=" + this.enableBizCallback + ", bizCrashPortraits=" + this.bizCrashPortraits + ')';
    }

    public final List<BizCrashPortraits> getBizCrashPortraits() {
        return this.bizCrashPortraits;
    }

    public final boolean getEnableBizCallback() {
        return this.enableBizCallback;
    }

    public BootProtectorBizCallbackConfig(boolean r100, List<BizCrashPortraits> r101) {
        this.enableBizCallback = r100;
        this.bizCrashPortraits = r101;
    }

    public /* synthetic */ BootProtectorBizCallbackConfig(boolean r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        this(r100, r101);
    }
}
