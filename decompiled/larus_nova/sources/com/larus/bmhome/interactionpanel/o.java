package com.larus.bmhome.interactionpanel;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f312389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f312390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f312391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InteractionPanelType f312392d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f312389a, r101.f312389a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f312390b, r101.f312390b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f312391c, r101.f312391c) == true) goto L18;
        return false;
    L18:
        if (this.f312392d == r101.f312392d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f312389a.hashCode() * 31) + this.f312390b.hashCode()) * 31) + this.f312391c.hashCode()) * 31) + this.f312392d.hashCode();
    }

    public final String toString() {
        return "InteractionPanelKey(conversationId=" + this.f312389a + ", threadId=" + this.f312390b + ", blockId=" + this.f312391c + ", panelType=" + this.f312392d + ')';
    }

    public o(String r100, String r101, String r102, InteractionPanelType r103) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "threadId");
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.BLOCK_ID);
        Intrinsics.checkNotNullParameter(r103, "panelType");
        this.f312389a = r100;
        this.f312390b = r101;
        this.f312391c = r102;
        this.f312392d = r103;
    }
}
