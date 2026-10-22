package com.lynx.tasm.ui.image;

import com.facebook.common.internal.Objects;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;

/* JADX INFO: loaded from: classes32.dex */
public final class y<DH extends DraweeHierarchy> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f384069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f384070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DH f384071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f384072d;

    public final String toString() {
        return Objects.toStringHelper(this).add("controllerAttached", this.f384069a).add("holderAttached", this.f384070b).add("drawableVisible", true).toString();
    }

    public y(GenericDraweeHierarchy r100) {
        this.f384069a = false;
        this.f384070b = false;
        this.f384072d = null;
        if (r100 == null) goto L6;
        this.f384071c = r100;
        return;
    }
}
