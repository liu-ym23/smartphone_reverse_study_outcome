package com.ss.android.lark.lynxkit.bridge;

import android.content.Context;
import com.lynx.tasm.LynxViewBuilder;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolBuilderContext;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "lynxViewBuilder", "Lcom/lynx/tasm/LynxViewBuilder;", "containerId", "", "containerContext", "Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "<init>", "(Landroid/content/Context;Lcom/lynx/tasm/LynxViewBuilder;Ljava/lang/String;Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;)V", "getContext", "()Landroid/content/Context;", "getLynxViewBuilder", "()Lcom/lynx/tasm/LynxViewBuilder;", "getContainerId", "()Ljava/lang/String;", "getContainerContext", "()Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkLynxBridgeProtocolBuilderContext {
    private final ILynxContainerContext containerContext;
    private final String containerId;
    private final Context context;
    private final LynxViewBuilder lynxViewBuilder;

    public static /* synthetic */ LarkLynxBridgeProtocolBuilderContext copy$default(LarkLynxBridgeProtocolBuilderContext r100, Context r101, LynxViewBuilder r102, String r103, ILynxContainerContext r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.context;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.lynxViewBuilder;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.containerId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.containerContext;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Context component1() {
        return this.context;
    }

    public final LynxViewBuilder component2() {
        return this.lynxViewBuilder;
    }

    public final String component3() {
        return this.containerId;
    }

    public final ILynxContainerContext component4() {
        return this.containerContext;
    }

    public final LarkLynxBridgeProtocolBuilderContext copy(Context r100, LynxViewBuilder r101, String r102, ILynxContainerContext r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lynxViewBuilder");
        Intrinsics.checkNotNullParameter(r102, "containerId");
        return new LarkLynxBridgeProtocolBuilderContext(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LarkLynxBridgeProtocolBuilderContext) == true) goto L8;
        return false;
    L8:
        LarkLynxBridgeProtocolBuilderContext r101 = (LarkLynxBridgeProtocolBuilderContext) r100;
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxViewBuilder, r101.lynxViewBuilder) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.containerId, r101.containerId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.containerContext, r101.containerContext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.context.hashCode() * 31) + this.lynxViewBuilder.hashCode()) * 31) + this.containerId.hashCode()) * 31;
        ILynxContainerContext r101 = this.containerContext;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "LarkLynxBridgeProtocolBuilderContext(context=" + this.context + ", lynxViewBuilder=" + this.lynxViewBuilder + ", containerId=" + this.containerId + ", containerContext=" + this.containerContext + ')';
    }

    public final ILynxContainerContext getContainerContext() {
        return this.containerContext;
    }

    public final String getContainerId() {
        return this.containerId;
    }

    public final Context getContext() {
        return this.context;
    }

    public final LynxViewBuilder getLynxViewBuilder() {
        return this.lynxViewBuilder;
    }

    public LarkLynxBridgeProtocolBuilderContext(Context r100, LynxViewBuilder r101, String r102, ILynxContainerContext r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lynxViewBuilder");
        Intrinsics.checkNotNullParameter(r102, "containerId");
        this.context = r100;
        this.lynxViewBuilder = r101;
        this.containerId = r102;
        this.containerContext = r103;
    }

    public /* synthetic */ LarkLynxBridgeProtocolBuilderContext(Context r100, LynxViewBuilder r101, String r102, ILynxContainerContext r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
