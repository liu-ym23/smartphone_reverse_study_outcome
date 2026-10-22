package com.lynx.tasm.behavior;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes32.dex */
public class a {
    private final boolean mCreateAsync;
    private final boolean mFlatten;
    private String mName;
    private final boolean mNeedProcessDirection;
    private final boolean mSupportFragmentLayerRender;

    public com.lynx.tasm.a createClassWarmer() {
        return null;
    }

    public LynxFlattenUI createFlattenUI(LynxContext r100) {
        return null;
    }

    public LynxFlattenUI createFlattenUIFiber(LynxContext r100) {
        return null;
    }

    public x6a.e createPlatformRendererHost(LynxContext r100) {
        return null;
    }

    public ShadowNode createShadowNode() {
        return null;
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + " - " + this.mName + "]";
    }

    public String getName() {
        return this.mName;
    }

    public boolean needProcessDirection() {
        return this.mNeedProcessDirection;
    }

    public boolean supportCreateAsync() {
        return this.mCreateAsync;
    }

    public boolean supportFragmentLayerRenderer() {
        return this.mSupportFragmentLayerRender;
    }

    public final boolean supportUIFlatten() {
        return this.mFlatten;
    }

    public a(String r100) {
        this(r100, false, false, false);
    }

    public LynxUI createUI(LynxContext r100) {
        throw new RuntimeException(this.mName + " is a virtual node, do not have real ui!");
    }

    public LynxUI createUIFiber(LynxContext r100) {
        throw new RuntimeException(this.mName + " is a virtual node, do not have real ui!");
    }

    public a(String r100, boolean r101) {
        this(r100, r101, false, false);
    }

    public LynxFlattenUI createFlattenUIWithParams(LynxContext r100, Object r101) {
        return createFlattenUI(r100);
    }

    public LynxUI createUIWithParams(LynxContext r100, Object r101) {
        return createUI(r100);
    }

    public a(String r100, boolean r101, boolean r102) {
        this(r100, r101, r102, false);
    }

    public a(String r100, boolean r101, boolean r102, boolean r110) {
        this(r100, r101, r102, r110, false);
    }

    public a(String r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.mName = r100;
        this.mFlatten = r101;
        this.mCreateAsync = r102;
        this.mNeedProcessDirection = r103;
        this.mSupportFragmentLayerRender = r104;
    }
}
