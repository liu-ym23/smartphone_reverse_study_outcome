package com.lynx.jsbridge;

import com.lynx.react.bridge.JavaOnlyArray;

/* JADX INFO: loaded from: classes32.dex */
public class AttributeDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f381251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JavaOnlyArray f381252b;

    public String getName() {
        return this.f381251a;
    }

    public JavaOnlyArray getValue() {
        return this.f381252b;
    }

    public AttributeDescriptor(String r100, JavaOnlyArray r101) {
        this.f381251a = r100;
        this.f381252b = r101;
    }
}
