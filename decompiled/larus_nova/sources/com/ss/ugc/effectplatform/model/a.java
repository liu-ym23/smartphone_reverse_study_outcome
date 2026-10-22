package com.ss.ugc.effectplatform.model;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
public class a {
    private String panel;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public String getPanel() {
        return this.panel;
    }

    public a(String r100) {
        this.panel = r100;
    }

    public void setPanel(String r100) {
        this.panel = r100;
    }

    public /* synthetic */ a(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
