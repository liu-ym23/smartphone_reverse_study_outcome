package com.bytedance.ug.sdk.luckycat.impl.popup.utils;

import com.bytedance.ug.sdk.luckycat.impl.model.SchemaUIConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001a\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b9\u0010:R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R$\u0010-\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010 \"\u0004\b/\u0010\"R$\u00100\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R\"\u00103\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010%\u001a\u0004\b3\u0010'\"\u0004\b4\u0010)R\"\u00105\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010%\u001a\u0004\b5\u0010'\"\u0004\b6\u0010)R\"\u00107\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010%\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)¨\u0006="}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/popup/utils/LuckyCatPopupConfig;", "Ljava/io/Serializable;", "", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "widthPercent", "getWidthPercent", "setWidthPercent", "heightPercent", "getHeightPercent", "setHeightPercent", "", "aspectRatio", "D", "getAspectRatio", "()D", "setAspectRatio", "(D)V", "radius", "getRadius", "setRadius", "", "maskColor", "Ljava/lang/String;", "getMaskColor", "()Ljava/lang/String;", "setMaskColor", "(Ljava/lang/String;)V", "", "closeByMask", "Z", "getCloseByMask", "()Z", "setCloseByMask", "(Z)V", "popupEnterType", "getPopupEnterType", "setPopupEnterType", "popupExitType", "getPopupExitType", "setPopupExitType", "originContainerId", "getOriginContainerId", "setOriginContainerId", "isPreload", "setPreload", "isBlockBackPress", "setBlockBackPress", "isUseDialogFullScreenStyle", "setUseDialogFullScreenStyle", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class LuckyCatPopupConfig implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private double aspectRatio;
    private boolean closeByMask;
    private int height;
    private int heightPercent;
    private boolean isBlockBackPress;
    private boolean isPreload;
    private boolean isUseDialogFullScreenStyle;
    private String maskColor;
    private String originContainerId;
    private String popupEnterType;
    private String popupExitType;
    private int radius;
    private int width;
    private int widthPercent;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LuckyCatPopupConfig a(String r110) {
            SchemaUIConfig r111 = SchemaUIConfig.createConfig(r110);
            int r100 = r111.getHeight();
            int r101 = r111.getWidth();
            int r102 = r111.getHeightPercent();
            int r103 = r111.getWidthPercent();
            double r104 = r111.getAspectRatio();
            int r105 = r111.getRadius();
            String r106 = r111.getMaskColor();
            boolean r107 = r111.isCloseByMask();
            String r108 = r111.getPopupEnterType();
            String r112 = r111.getPopupEnterType();
            String r113 = r111.getOriginContainerID();
            boolean r114 = r111.isPreloadPopup();
            boolean r115 = r111.isBlockBackPress();
            r111.isUseDialogFullScreenStyle();
            LuckyCatPopupConfig r116 = new LuckyCatPopupConfig();
            r116.setHeight(r100);
            r116.setWidth(r101);
            r116.setHeightPercent(r102);
            r116.setWidthPercent(r103);
            r116.setAspectRatio(r104);
            r116.setRadius(r105);
            r116.setMaskColor(r106);
            r116.setCloseByMask(r107);
            r116.setPopupEnterType(r108);
            r116.setPopupExitType(r112);
            r116.setOriginContainerId(r113);
            r116.setPreload(r114);
            r116.setBlockBackPress(r115);
            r116.setUseDialogFullScreenStyle(r111.isUseDialogFullScreenStyle());
            return r116;
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final LuckyCatPopupConfig convert(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public LuckyCatPopupConfig() {
        this.maskColor = "";
        this.popupEnterType = "";
        this.popupExitType = "";
    }

    public final double getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getCloseByMask() {
        return this.closeByMask;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getHeightPercent() {
        return this.heightPercent;
    }

    public final String getMaskColor() {
        return this.maskColor;
    }

    public final String getOriginContainerId() {
        return this.originContainerId;
    }

    public final String getPopupEnterType() {
        return this.popupEnterType;
    }

    public final String getPopupExitType() {
        return this.popupExitType;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getWidthPercent() {
        return this.widthPercent;
    }

    public final boolean isBlockBackPress() {
        return this.isBlockBackPress;
    }

    public final boolean isPreload() {
        return this.isPreload;
    }

    public final boolean isUseDialogFullScreenStyle() {
        return this.isUseDialogFullScreenStyle;
    }

    public final void setAspectRatio(double r100) {
        this.aspectRatio = r100;
    }

    public final void setBlockBackPress(boolean r100) {
        this.isBlockBackPress = r100;
    }

    public final void setCloseByMask(boolean r100) {
        this.closeByMask = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setHeightPercent(int r100) {
        this.heightPercent = r100;
    }

    public final void setMaskColor(String r100) {
        this.maskColor = r100;
    }

    public final void setOriginContainerId(String r100) {
        this.originContainerId = r100;
    }

    public final void setPopupEnterType(String r100) {
        this.popupEnterType = r100;
    }

    public final void setPopupExitType(String r100) {
        this.popupExitType = r100;
    }

    public final void setPreload(boolean r100) {
        this.isPreload = r100;
    }

    public final void setRadius(int r100) {
        this.radius = r100;
    }

    public final void setUseDialogFullScreenStyle(boolean r100) {
        this.isUseDialogFullScreenStyle = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public final void setWidthPercent(int r100) {
        this.widthPercent = r100;
    }
}
