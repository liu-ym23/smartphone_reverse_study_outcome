package com.bytedance.locallife.cube.api.model;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Deprecated(message = "use CubeConfig instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R$\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/DelegateThreadConfig;", "", "readResOnMainThread", "", "renderTemplateOnMainThread", "isAsync", "(ZZZ)V", "isAsync$annotations", "()V", "()Z", "setAsync", "(Z)V", "getReadResOnMainThread", "setReadResOnMainThread", "getRenderTemplateOnMainThread", "setRenderTemplateOnMainThread", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DelegateThreadConfig {
    private boolean isAsync;
    private boolean readResOnMainThread;
    private boolean renderTemplateOnMainThread;

    public DelegateThreadConfig() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ DelegateThreadConfig copy$default(DelegateThreadConfig r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.readResOnMainThread;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.renderTemplateOnMainThread;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.isAsync;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @Deprecated(message = "Please use CubeCreateThreadConfig for thread control")
    public static /* synthetic */ void isAsync$annotations() {
    }

    public final boolean component1() {
        return this.readResOnMainThread;
    }

    public final boolean component2() {
        return this.renderTemplateOnMainThread;
    }

    public final boolean component3() {
        return this.isAsync;
    }

    public final DelegateThreadConfig copy(boolean r100, boolean r101, boolean r102) {
        return new DelegateThreadConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DelegateThreadConfig) == true) goto L8;
        return false;
    L8:
        DelegateThreadConfig r101 = (DelegateThreadConfig) r100;
        if (this.readResOnMainThread == r101.readResOnMainThread) goto L12;
        return false;
    L12:
        if (this.renderTemplateOnMainThread == r101.renderTemplateOnMainThread) goto L15;
        return false;
    L15:
        if (this.isAsync == r101.isAsync) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.readResOnMainThread == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.renderTemplateOnMainThread == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.isAsync == true) goto L15;
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
        return "DelegateThreadConfig(readResOnMainThread=" + this.readResOnMainThread + ", renderTemplateOnMainThread=" + this.renderTemplateOnMainThread + ", isAsync=" + this.isAsync + ')';
    }

    public final boolean getReadResOnMainThread() {
        return this.readResOnMainThread;
    }

    public final boolean getRenderTemplateOnMainThread() {
        return this.renderTemplateOnMainThread;
    }

    public final boolean isAsync() {
        return this.isAsync;
    }

    public final void setAsync(boolean r100) {
        this.isAsync = r100;
    }

    public final void setReadResOnMainThread(boolean r100) {
        this.readResOnMainThread = r100;
    }

    public final void setRenderTemplateOnMainThread(boolean r100) {
        this.renderTemplateOnMainThread = r100;
    }

    public DelegateThreadConfig(boolean r100, boolean r101, boolean r102) {
        this.readResOnMainThread = r100;
        this.renderTemplateOnMainThread = r101;
        this.isAsync = r102;
    }

    public /* synthetic */ DelegateThreadConfig(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = true;
    L11:
        this(r100, r101, r102);
    }
}
