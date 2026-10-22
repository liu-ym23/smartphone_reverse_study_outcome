package com.ss.android.lark.lynxkit.bridge;

import android.content.Context;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006 "}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/LarkBridgeModuleEntity;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "lynxContainerContext", "Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "bridgeDispatcherTag", "", "bridgeMethodGroupTag", "jsModuleTag", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getLynxContainerContext", "()Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "getBridgeDispatcherTag", "()Ljava/lang/String;", "getBridgeMethodGroupTag", "getJsModuleTag", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkBridgeModuleEntity {
    private final String bridgeDispatcherTag;
    private final String bridgeMethodGroupTag;
    private final Context context;
    private final String jsModuleTag;
    private final ILynxContainerContext lynxContainerContext;

    public static /* synthetic */ LarkBridgeModuleEntity copy$default(LarkBridgeModuleEntity r100, Context r101, ILynxContainerContext r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.context;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.lynxContainerContext;
    L8:
        ILynxContainerContext r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.bridgeDispatcherTag;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.bridgeMethodGroupTag;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.jsModuleTag;
    L17:
        Context r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Context component1() {
        return this.context;
    }

    public final ILynxContainerContext component2() {
        return this.lynxContainerContext;
    }

    public final String component3() {
        return this.bridgeDispatcherTag;
    }

    public final String component4() {
        return this.bridgeMethodGroupTag;
    }

    public final String component5() {
        return this.jsModuleTag;
    }

    public final LarkBridgeModuleEntity copy(Context r100, ILynxContainerContext r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new LarkBridgeModuleEntity(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LarkBridgeModuleEntity) == true) goto L8;
        return false;
    L8:
        LarkBridgeModuleEntity r101 = (LarkBridgeModuleEntity) r100;
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxContainerContext, r101.lynxContainerContext) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bridgeDispatcherTag, r101.bridgeDispatcherTag) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bridgeMethodGroupTag, r101.bridgeMethodGroupTag) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.jsModuleTag, r101.jsModuleTag) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.context.hashCode() * 31;
        ILynxContainerContext r101 = this.lynxContainerContext;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.bridgeDispatcherTag;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.bridgeMethodGroupTag;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.jsModuleTag;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "LarkBridgeModuleEntity(context=" + this.context + ", lynxContainerContext=" + this.lynxContainerContext + ", bridgeDispatcherTag=" + this.bridgeDispatcherTag + ", bridgeMethodGroupTag=" + this.bridgeMethodGroupTag + ", jsModuleTag=" + this.jsModuleTag + ')';
    }

    public final String getBridgeDispatcherTag() {
        return this.bridgeDispatcherTag;
    }

    public final String getBridgeMethodGroupTag() {
        return this.bridgeMethodGroupTag;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getJsModuleTag() {
        return this.jsModuleTag;
    }

    public final ILynxContainerContext getLynxContainerContext() {
        return this.lynxContainerContext;
    }

    public LarkBridgeModuleEntity(Context r100, ILynxContainerContext r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.lynxContainerContext = r101;
        this.bridgeDispatcherTag = r102;
        this.bridgeMethodGroupTag = r103;
        this.jsModuleTag = r104;
    }

    public /* synthetic */ LarkBridgeModuleEntity(Context r100, ILynxContainerContext r101, String r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 2) == 0) goto L5;
        ILynxContainerContext r102 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r113 & 8) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r113 & 16) == 0) goto L17;
        String r105 = null;
    L18:
        this(r100, r102, r103, r104, r105);
        return;
    L17:
        r105 = r112;
        goto L18
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}
