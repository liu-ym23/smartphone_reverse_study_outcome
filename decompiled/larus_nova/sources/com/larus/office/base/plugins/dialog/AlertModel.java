package com.larus.office.base.plugins.dialog;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 L2\u00020\u0001:\u0003JKLB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010I\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR(\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001e\u0010+\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR \u00104\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR \u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR \u0010:\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR\u001e\u0010=\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010%\"\u0004\b>\u0010'R\u001e\u0010?\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010%\"\u0004\b@\u0010'R\u0011\u0010A\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0011\u0010E\u001a\u00020F8F¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006M"}, d2 = {"Lcom/larus/office/base/plugins/dialog/AlertModel;", "", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", "input", "getInput", "setInput", "options", "Lcom/larus/office/base/plugins/dialog/AlertModel$OptionsBean;", "getOptions", "()Lcom/larus/office/base/plugins/dialog/AlertModel$OptionsBean;", "setOptions", "(Lcom/larus/office/base/plugins/dialog/AlertModel$OptionsBean;)V", "buttonsDirection", "getButtonsDirection", "setButtonsDirection", "buttons", "", "Lcom/larus/office/base/plugins/dialog/AlertModel$ButtonsBean;", "getButtons", "()Ljava/util/List;", "setButtons", "(Ljava/util/List;)V", "checkBoxHint", "getCheckBoxHint", "setCheckBoxHint", "isCancelable", "", "()Z", "setCancelable", "(Z)V", "srcObjToken", "getSrcObjToken", "setSrcObjToken", "srcObjType", "", "getSrcObjType", "()I", "setSrcObjType", "(I)V", "inputState", "getInputState", "setInputState", "tipsMessage", "getTipsMessage", "setTipsMessage", "scene", "getScene", "setScene", "alertAction", "getAlertAction", "setAlertAction", "isAutoDismiss", "setAutoDismiss", "isVerticalMode", "setVerticalMode", "inputStateType", "Lcom/larus/office/base/plugins/dialog/InputState;", "getInputStateType", "()Lcom/larus/office/base/plugins/dialog/InputState;", "alertActionType", "Lcom/larus/office/base/plugins/dialog/AlertActionType;", "getAlertActionType", "()Lcom/larus/office/base/plugins/dialog/AlertActionType;", "toString", "OptionsBean", "ButtonsBean", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlertModel {
    public static final a Companion = null;
    public static final String TAG = "AlertModel";

    @SerializedName("alertAction")
    private String alertAction;

    @SerializedName("buttons")
    private List<ButtonsBean> buttons;

    @SerializedName("buttonsDirection")
    private String buttonsDirection;

    @SerializedName("checkBoxHint")
    private String checkBoxHint;

    @SerializedName("input")
    private String input;

    @SerializedName("inputState")
    private String inputState;

    @SerializedName("autoDismiss")
    private boolean isAutoDismiss;

    @SerializedName("cancelable")
    private boolean isCancelable;

    @SerializedName("verticalMode")
    private boolean isVerticalMode;

    @SerializedName("message")
    private String message;

    @SerializedName("options")
    private OptionsBean options;

    @SerializedName("scene")
    private String scene;

    @SerializedName("srcObjToken")
    private String srcObjToken;

    @SerializedName("srcObjType")
    private int srcObjType;

    @SerializedName("tipsMessage")
    private String tipsMessage;

    @SerializedName("title")
    private String title;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/larus/office/base/plugins/dialog/AlertModel$ButtonsBean;", "", "<init>", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "id", "getId", "setId", "color", "", "getColor", "()I", "setColor", "(I)V", "isAutoDismiss", "", "()Z", "setAutoDismiss", "(Z)V", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ButtonsBean {

        @SerializedName("color")
        private int color;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private String f360737id;

        @SerializedName("autoDismiss")
        private boolean isAutoDismiss;

        @SerializedName("text")
        private String text;

        public String toString() {
            return "ButtonsBean{text='" + this.text + "', id='" + this.f360737id + "', color=" + this.color + '}';
        }

        public ButtonsBean() {
            this.isAutoDismiss = true;
        }

        public final int getColor() {
            return this.color;
        }

        public final String getId() {
            return this.f360737id;
        }

        public final String getText() {
            return this.text;
        }

        public final boolean isAutoDismiss() {
            return this.isAutoDismiss;
        }

        public final void setAutoDismiss(boolean r100) {
            this.isAutoDismiss = r100;
        }

        public final void setColor(int r100) {
            this.color = r100;
        }

        public final void setId(String r100) {
            this.f360737id = r100;
        }

        public final void setText(String r100) {
            this.text = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/office/base/plugins/dialog/AlertModel$OptionsBean;", "", "<init>", "()V", "message_align", "", "getMessage_align", "()I", "setMessage_align", "(I)V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OptionsBean {

        @SerializedName("message_align")
        private int message_align;

        public OptionsBean() {
            this.message_align = 1;
        }

        public final int getMessage_align() {
            return this.message_align;
        }

        public final void setMessage_align(int r100) {
            this.message_align = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final AlertActionType getAlertActionType() {
        if (TextUtils.isEmpty(this.alertAction) == true) goto L9;
        String r100 = this.alertAction;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L6
        return AlertActionType.valueOf(r100.toUpperCase());
    L6:
        th = move-exception;
        FLogger.f375446a.e("AlertModel", "getAlertActionType error, return AlertActionType.SHOW.", th);
    L9:
        return AlertActionType.SHOW;
    }

    public final InputState getInputStateType() {
        if (TextUtils.isEmpty(this.inputState) == true) goto L9;
        String r100 = this.inputState;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L6
        return InputState.valueOf(r100.toUpperCase());
    L6:
        th = move-exception;
        FLogger.f375446a.e("AlertModel", "getInputStateType error, return InputState.NORMAL.", th);
    L9:
        return InputState.NORMAL;
    }

    public String toString() {
        return "AlertModel{title='" + this.title + "', message='" + this.message + "', buttons=" + this.buttons + "', cancelable=" + this.isCancelable + '}';
    }

    public AlertModel() {
        this.isCancelable = true;
        this.isAutoDismiss = true;
    }

    public final String getAlertAction() {
        return this.alertAction;
    }

    public final List<ButtonsBean> getButtons() {
        return this.buttons;
    }

    public final String getButtonsDirection() {
        return this.buttonsDirection;
    }

    public final String getCheckBoxHint() {
        return this.checkBoxHint;
    }

    public final String getInput() {
        return this.input;
    }

    public final String getInputState() {
        return this.inputState;
    }

    public final String getMessage() {
        return this.message;
    }

    public final OptionsBean getOptions() {
        return this.options;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSrcObjToken() {
        return this.srcObjToken;
    }

    public final int getSrcObjType() {
        return this.srcObjType;
    }

    public final String getTipsMessage() {
        return this.tipsMessage;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isAutoDismiss() {
        return this.isAutoDismiss;
    }

    public final boolean isCancelable() {
        return this.isCancelable;
    }

    public final boolean isVerticalMode() {
        return this.isVerticalMode;
    }

    public final void setAlertAction(String r100) {
        this.alertAction = r100;
    }

    public final void setAutoDismiss(boolean r100) {
        this.isAutoDismiss = r100;
    }

    public final void setButtons(List<ButtonsBean> r100) {
        this.buttons = r100;
    }

    public final void setButtonsDirection(String r100) {
        this.buttonsDirection = r100;
    }

    public final void setCancelable(boolean r100) {
        this.isCancelable = r100;
    }

    public final void setCheckBoxHint(String r100) {
        this.checkBoxHint = r100;
    }

    public final void setInput(String r100) {
        this.input = r100;
    }

    public final void setInputState(String r100) {
        this.inputState = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setOptions(OptionsBean r100) {
        this.options = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public final void setSrcObjToken(String r100) {
        this.srcObjToken = r100;
    }

    public final void setSrcObjType(int r100) {
        this.srcObjType = r100;
    }

    public final void setTipsMessage(String r100) {
        this.tipsMessage = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setVerticalMode(boolean r100) {
        this.isVerticalMode = r100;
    }
}
