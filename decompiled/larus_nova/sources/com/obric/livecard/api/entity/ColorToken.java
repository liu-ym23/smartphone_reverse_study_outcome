package com.obric.livecard.api.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR,\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR,\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/obric/livecard/api/entity/ColorToken;", "", "blendRes", "", "fluidRes", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "<set-?>", "Lcom/obric/livecard/api/entity/ColorHex;", "blend", "getBlend", "()Lcom/obric/livecard/api/entity/ColorHex;", "value", "getBlendRes", "()Ljava/lang/Integer;", "setBlendRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "fluid", "getFluid", "getFluidRes", "setFluidRes", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ColorToken {
    private ColorHex blend;
    private transient Integer blendRes;
    private ColorHex fluid;
    private transient Integer fluidRes;

    /* JADX WARN: Multi-variable type inference failed */
    public ColorToken() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final ColorHex getBlend() {
        return this.blend;
    }

    public final Integer getBlendRes() {
        return this.blendRes;
    }

    public final ColorHex getFluid() {
        return this.fluid;
    }

    public final Integer getFluidRes() {
        return this.fluidRes;
    }

    public final void setBlendRes(Integer r100) {
        this.blendRes = r100;
        if (r100 == null) goto L5;
        ColorHex r101 = ColorTokenValueResolver.INSTANCE.resolve(r100.intValue());
    L6:
        this.blend = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void setFluidRes(Integer r100) {
        this.fluidRes = r100;
        if (r100 == null) goto L5;
        ColorHex r101 = ColorTokenValueResolver.INSTANCE.resolve(r100.intValue());
    L6:
        this.fluid = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public ColorToken(Integer r100, Integer r101) {
        this.blendRes = r100;
        this.fluidRes = r101;
        ColorHex r102 = null;
        if (r100 == null) goto L5;
        ColorHex r103 = ColorTokenValueResolver.INSTANCE.resolve(r100.intValue());
    L6:
        this.blend = r103;
        if (r101 == null) goto L9;
        r102 = ColorTokenValueResolver.INSTANCE.resolve(r101.intValue());
    L9:
        this.fluid = r102;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public /* synthetic */ ColorToken(Integer r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
