package com.ss.android.lark.picker.config;

import com.alipay.sdk.m.x.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R$\u0010&\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\"R\u001a\u0010(\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010 \"\u0004\b)\u0010\"R\u001a\u0010*\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001a\u0010,\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/ss/android/lark/picker/config/NavigationConfig;", "", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "subTitle", "getSubTitle", "setSubTitle", "subTitleColor", "", "getSubTitleColor", "()Ljava/lang/Integer;", "setSubTitleColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cancelIcon", "getCancelIcon", "setCancelIcon", "cancelText", "getCancelText", "setCancelText", "confirmButtonText", "getConfirmButtonText", "setConfirmButtonText", "showSelectedCount", "", "getShowSelectedCount", "()Z", "setShowSelectedCount", "(Z)V", "isImmersive", "setImmersive", "value", "isEnableMultiChange", "setEnableMultiChange", "isEnableSingle2Multi", "setEnableSingle2Multi", "isEnableMulti2Single", "setEnableMulti2Single", "isConfirmableWhenNotSelected", "setConfirmableWhenNotSelected", "onFinishListener", "Lcom/ss/android/lark/picker/config/OnPickerFinishListener;", "getOnFinishListener", "()Lcom/ss/android/lark/picker/config/OnPickerFinishListener;", "setOnFinishListener", "(Lcom/ss/android/lark/picker/config/OnPickerFinishListener;)V", "onConfirmListener", "Lcom/ss/android/lark/picker/config/OnPickerConfirmListener;", "getOnConfirmListener", "()Lcom/ss/android/lark/picker/config/OnPickerConfirmListener;", "setOnConfirmListener", "(Lcom/ss/android/lark/picker/config/OnPickerConfirmListener;)V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NavigationConfig {
    private Integer cancelIcon;
    private String cancelText;
    private String confirmButtonText;
    private boolean isConfirmableWhenNotSelected;
    private boolean isEnableMulti2Single;
    private boolean isEnableSingle2Multi;
    private boolean isImmersive;
    private OnPickerConfirmListener onConfirmListener;
    private OnPickerFinishListener onFinishListener;
    private boolean showSelectedCount;
    private String subTitle;
    private Integer subTitleColor;
    private String title;

    public final boolean isEnableMultiChange() {
        if (this.isEnableSingle2Multi == true) goto L5;
    L7:
        return false;
    L5:
        if (this.isEnableMulti2Single == false) goto L7;
        return true;
    }

    public NavigationConfig() {
        this.showSelectedCount = true;
    }

    public final Integer getCancelIcon() {
        return this.cancelIcon;
    }

    public final String getCancelText() {
        return this.cancelText;
    }

    public final String getConfirmButtonText() {
        return this.confirmButtonText;
    }

    public final OnPickerConfirmListener getOnConfirmListener() {
        return this.onConfirmListener;
    }

    public final OnPickerFinishListener getOnFinishListener() {
        return this.onFinishListener;
    }

    public final boolean getShowSelectedCount() {
        return this.showSelectedCount;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final Integer getSubTitleColor() {
        return this.subTitleColor;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isConfirmableWhenNotSelected() {
        return this.isConfirmableWhenNotSelected;
    }

    public final boolean isEnableMulti2Single() {
        return this.isEnableMulti2Single;
    }

    public final boolean isEnableSingle2Multi() {
        return this.isEnableSingle2Multi;
    }

    public final boolean isImmersive() {
        return this.isImmersive;
    }

    public final void setCancelIcon(Integer r100) {
        this.cancelIcon = r100;
    }

    public final void setCancelText(String r100) {
        this.cancelText = r100;
    }

    public final void setConfirmButtonText(String r100) {
        this.confirmButtonText = r100;
    }

    public final void setConfirmableWhenNotSelected(boolean r100) {
        this.isConfirmableWhenNotSelected = r100;
    }

    public final void setEnableMulti2Single(boolean r100) {
        this.isEnableMulti2Single = r100;
    }

    public final void setEnableMultiChange(boolean r100) {
        this.isEnableSingle2Multi = r100;
        this.isEnableMulti2Single = r100;
    }

    public final void setEnableSingle2Multi(boolean r100) {
        this.isEnableSingle2Multi = r100;
    }

    public final void setImmersive(boolean r100) {
        this.isImmersive = r100;
    }

    public final void setOnConfirmListener(OnPickerConfirmListener r100) {
        this.onConfirmListener = r100;
    }

    public final void setOnFinishListener(OnPickerFinishListener r100) {
        this.onFinishListener = r100;
    }

    public final void setShowSelectedCount(boolean r100) {
        this.showSelectedCount = r100;
    }

    public final void setSubTitle(String r100) {
        this.subTitle = r100;
    }

    public final void setSubTitleColor(Integer r100) {
        this.subTitleColor = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
