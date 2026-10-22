package com.ss.android.lark.lynxkit.bridge;

import android.content.Context;
import com.lynx.tasm.LynxView;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolContext;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "lynxView", "Lcom/lynx/tasm/LynxView;", "containerId", "", "builderHandle", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolBuilderHandle;", "containerContext", "Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "<init>", "(Landroid/content/Context;Lcom/lynx/tasm/LynxView;Ljava/lang/String;Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolBuilderHandle;Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;)V", "getContext", "()Landroid/content/Context;", "getLynxView", "()Lcom/lynx/tasm/LynxView;", "getContainerId", "()Ljava/lang/String;", "getBuilderHandle", "()Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolBuilderHandle;", "getContainerContext", "()Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkLynxBridgeProtocolContext {
    private final ILarkLynxBridgeProtocolBuilderHandle builderHandle;
    private final ILynxContainerContext containerContext;
    private final String containerId;
    private final Context context;
    private final LynxView lynxView;

    public static /* synthetic */ LarkLynxBridgeProtocolContext copy$default(LarkLynxBridgeProtocolContext r100, Context r101, LynxView r102, String r103, ILarkLynxBridgeProtocolBuilderHandle r104, ILynxContainerContext r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.context;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.lynxView;
    L8:
        LynxView r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.containerId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.builderHandle;
    L14:
        ILarkLynxBridgeProtocolBuilderHandle r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.containerContext;
    L17:
        Context r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Context component1() {
        return this.context;
    }

    public final LynxView component2() {
        return this.lynxView;
    }

    public final String component3() {
        return this.containerId;
    }

    public final ILarkLynxBridgeProtocolBuilderHandle component4() {
        return this.builderHandle;
    }

    public final ILynxContainerContext component5() {
        return this.containerContext;
    }

    public final LarkLynxBridgeProtocolContext copy(Context r100, LynxView r101, String r110, ILarkLynxBridgeProtocolBuilderHandle r111, ILynxContainerContext r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lynxView");
        Intrinsics.checkNotNullParameter(r110, "containerId");
        return new LarkLynxBridgeProtocolContext(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LarkLynxBridgeProtocolContext) == true) goto L8;
        return false;
    L8:
        LarkLynxBridgeProtocolContext r101 = (LarkLynxBridgeProtocolContext) r100;
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxView, r101.lynxView) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.containerId, r101.containerId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.builderHandle, r101.builderHandle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.containerContext, r101.containerContext) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.context.hashCode() * 31) + this.lynxView.hashCode()) * 31) + this.containerId.hashCode()) * 31;
        ILarkLynxBridgeProtocolBuilderHandle r101 = this.builderHandle;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ILynxContainerContext r105 = this.containerContext;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "LarkLynxBridgeProtocolContext(context=" + this.context + ", lynxView=" + this.lynxView + ", containerId=" + this.containerId + ", builderHandle=" + this.builderHandle + ", containerContext=" + this.containerContext + ')';
    }

    public final ILarkLynxBridgeProtocolBuilderHandle getBuilderHandle() {
        return this.builderHandle;
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

    public final LynxView getLynxView() {
        return this.lynxView;
    }

    public LarkLynxBridgeProtocolContext(Context r100, LynxView r101, String r102, ILarkLynxBridgeProtocolBuilderHandle r103, ILynxContainerContext r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lynxView");
        Intrinsics.checkNotNullParameter(r102, "containerId");
        this.context = r100;
        this.lynxView = r101;
        this.containerId = r102;
        this.builderHandle = r103;
        this.containerContext = r104;
    }

    public /* synthetic */ LarkLynxBridgeProtocolContext(Context r100, LynxView r101, String r110, ILarkLynxBridgeProtocolBuilderHandle r111, ILynxContainerContext r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        ILarkLynxBridgeProtocolBuilderHandle r102 = null;
    L7:
        if ((r113 & 16) == 0) goto L9;
        ILynxContainerContext r103 = null;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
