package com.bytedance.applet.debugger;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, d2 = {"Lcom/bytedance/applet/debugger/AppletDebuggerTraceSpan;", "", "scene", "", "input", "Lcom/bytedance/applet/debugger/AppletDebuggerSceneInfo;", "output", "duration", "", "startTime", "<init>", "(Ljava/lang/String;Lcom/bytedance/applet/debugger/AppletDebuggerSceneInfo;Lcom/bytedance/applet/debugger/AppletDebuggerSceneInfo;Ljava/lang/Long;Ljava/lang/Long;)V", "getScene", "()Ljava/lang/String;", "getInput", "()Lcom/bytedance/applet/debugger/AppletDebuggerSceneInfo;", "getOutput", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/bytedance/applet/debugger/AppletDebuggerSceneInfo;Lcom/bytedance/applet/debugger/AppletDebuggerSceneInfo;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/applet/debugger/AppletDebuggerTraceSpan;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u {

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("input")
    private final t input;

    @SerializedName("output")
    private final t output;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("start_time")
    private final Long startTime;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.input, r6.input) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.output, r6.output) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.startTime, r6.startTime) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.scene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        t r4 = this.input;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        t r7 = this.output;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.duration;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.startTime;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletDebuggerTraceSpan(scene=" + this.scene + ", input=" + this.input + ", output=" + this.output + ", duration=" + this.duration + ", startTime=" + this.startTime + ')';
    }

    public u() {
        this.scene = null;
        this.input = null;
        this.output = null;
        this.duration = null;
        this.startTime = null;
    }

    public final Long a() {
        return this.duration;
    }

    public final t b() {
        return this.input;
    }

    public final t c() {
        return this.output;
    }

    public final String d() {
        return this.scene;
    }

    public final Long e() {
        return this.startTime;
    }
}
