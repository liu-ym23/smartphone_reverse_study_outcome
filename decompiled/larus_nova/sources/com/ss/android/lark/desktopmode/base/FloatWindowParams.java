package com.ss.android.lark.desktopmode.base;

import android.content.DialogInterface;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class FloatWindowParams extends FragmentParams {
    private final int bgResId;
    private final List<Integer> coordination;
    private float dimAmount;
    private final String floatTag;
    private final int gravity;
    private final boolean isCancelable;
    private boolean isFloatStackBase;
    private DialogInterface.OnClickListener outsideClickListener;
    private boolean showTriangle;
    private final List<Integer> windowSize;

    public static final class a extends FragmentParams.a<a, FloatWindowParams> {
    }

    public int getBgResId() {
        return this.bgResId;
    }

    public List<Integer> getCoordination() {
        return this.coordination;
    }

    public float getDimAmount() {
        return this.dimAmount;
    }

    public String getFloatTag() {
        return this.floatTag;
    }

    public int getGravity() {
        return this.gravity;
    }

    public DialogInterface.OnClickListener getOutsideClickListener() {
        return this.outsideClickListener;
    }

    public List<Integer> getWindowSize() {
        return this.windowSize;
    }

    public boolean isCancelable() {
        return this.isCancelable;
    }

    public boolean isFloatStackBase() {
        return this.isFloatStackBase;
    }

    public boolean isShowTriangle() {
        return this.showTriangle;
    }

    public FloatWindowParams(FloatWindowParams r100) {
        super(r100.containerType, false);
        this.gravity = r100.gravity;
        this.coordination = r100.coordination;
        this.windowSize = r100.windowSize;
        this.isCancelable = r100.isCancelable;
        this.dimAmount = r100.dimAmount;
        this.showTriangle = r100.showTriangle;
        this.floatTag = r100.floatTag;
        this.bgResId = r100.bgResId;
        this.outsideClickListener = r100.outsideClickListener;
    }

    public void setFloatStackBase(boolean r100) {
        this.isFloatStackBase = r100;
    }

    public FloatWindowParams(a r100) {
        throw null;
    }

    public FloatWindowParams(int r100, ContainerType r101, List<Integer> r102, List<Integer> r103, boolean r104, float r105, boolean r106, String r107, int r110, DialogInterface.OnClickListener r111) {
        super(r101, false);
        this.gravity = r100;
        this.coordination = r102;
        this.windowSize = r103;
        this.isCancelable = r104;
        this.dimAmount = r105;
        this.showTriangle = r106;
        this.floatTag = r107;
        this.bgResId = r110;
        this.outsideClickListener = r111;
    }
}
