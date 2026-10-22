package com.bytedance.ee.bear.document.alert;

import android.text.TextUtils;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AlertModel implements NonProguard {
    public static final String TAG = "AlertModel";
    private String alertAction;
    private boolean autoDismiss;
    private List<ButtonsBean> buttons;
    private boolean cancelable;
    private String checkBoxHint;
    private String input;
    private String inputState;
    private String message;
    private OptionsBean options;
    private List<RadioOptions> radioOptions;
    private String scene;
    private String srcObjToken;
    private int srcObjType;
    private String tipsMessage;
    private String title;
    private boolean verticalMode;

    public static class ButtonsBean implements BaseJSModel {
        private boolean autoDismiss;
        private int color;
        private String id;
        private String text;

        public String toString() {
            return "ButtonsBean{text='" + this.text + "', id='" + this.id + "', color=" + this.color + '}';
        }

        public ButtonsBean() {
            this.autoDismiss = true;
        }

        public int getColor() {
            return this.color;
        }

        public String getId() {
            return this.id;
        }

        public String getText() {
            return this.text;
        }

        public boolean isAutoDismiss() {
            return this.autoDismiss;
        }

        public void setAutoDismiss(boolean r1) {
            this.autoDismiss = r1;
        }

        public void setColor(int r1) {
            this.color = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setText(String r1) {
            this.text = r1;
        }
    }

    public static class OptionsBean implements BaseJSModel {
        private int message_align;

        public OptionsBean() {
            this.message_align = 1;
        }

        public int getMessage_align() {
            return this.message_align;
        }

        public void setMessage_align(int r1) {
            this.message_align = r1;
        }
    }

    public static class RadioOptions implements BaseJSModel {
        private String id;
        private String info;
        private boolean isSelected;
        private String title;

        public RadioOptions() {
        }

        public String toString() {
            return "RadioOptions{id='" + this.id + "', title='" + this.title + "', info='" + this.info + "', isSelected=" + this.isSelected + '}';
        }

        public String getId() {
            return this.id;
        }

        public String getInfo() {
            return this.info;
        }

        public String getTitle() {
            return this.title;
        }

        public boolean isSelected() {
            return this.isSelected;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setInfo(String r1) {
            this.info = r1;
        }

        public void setSelected(boolean r1) {
            this.isSelected = r1;
        }

        public void setTitle(String r1) {
            this.title = r1;
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[InputState.values().length];
            a = r0;
            r0[InputState.ACTIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[InputState.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public AlertActionType getAlertActionType() {
        if (TextUtils.isEmpty(this.alertAction) == true) goto L9;
        return AlertActionType.valueOf(this.alertAction.toUpperCase());
    L6:
        th = move-exception;
        tt5.a.e(TAG, "getAlertActionType error, return AlertActionType.SHOW.", th, false);
    L9:
        return AlertActionType.SHOW;
    }

    public int getInputBackgroundRes() {
        int r0 = a.a[getInputStateType().ordinal()];
        if (r0 != 1) goto L5;
        return 2131248269;
    L5:
        if (r0 == 2) goto L8;
        return 2131248268;
    L8:
        return 2131248270;
    }

    public InputState getInputStateType() {
        if (TextUtils.isEmpty(this.inputState) == true) goto L9;
        return InputState.valueOf(this.inputState.toUpperCase());
    L6:
        th = move-exception;
        tt5.a.e(TAG, "getInputStateType error, return InputState.NORMAL.", th, false);
    L9:
        return InputState.NORMAL;
    }

    public String toString() {
        return "AlertModel{title='" + this.title + "', message='" + this.message + "', buttons=" + this.buttons + "', radioOptions=" + this.radioOptions + "', cancelable=" + this.cancelable + '}';
    }

    public AlertModel() {
        this.checkBoxHint = null;
        this.cancelable = true;
        this.autoDismiss = true;
        this.verticalMode = false;
    }

    public String getAlertAction() {
        return this.alertAction;
    }

    public List<ButtonsBean> getButtons() {
        return this.buttons;
    }

    public String getCheckBoxHint() {
        return this.checkBoxHint;
    }

    public String getInput() {
        return this.input;
    }

    public String getInputState() {
        return this.inputState;
    }

    public String getMessage() {
        return this.message;
    }

    public OptionsBean getOptions() {
        return this.options;
    }

    public List<RadioOptions> getRadioOptions() {
        return this.radioOptions;
    }

    public String getScene() {
        return this.scene;
    }

    public String getSrcObjToken() {
        return this.srcObjToken;
    }

    public int getSrcObjType() {
        return this.srcObjType;
    }

    public String getTipsMessage() {
        return this.tipsMessage;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isAutoDismiss() {
        return this.autoDismiss;
    }

    public boolean isCancelable() {
        return this.cancelable;
    }

    public boolean isVerticalMode() {
        return this.verticalMode;
    }

    public void setAlertAction(String r1) {
        this.alertAction = r1;
    }

    public void setAutoDismiss(boolean r1) {
        this.autoDismiss = r1;
    }

    public void setButtons(List<ButtonsBean> r1) {
        this.buttons = r1;
    }

    public void setCancelable(boolean r1) {
        this.cancelable = r1;
    }

    public void setCheckBoxHint(String r1) {
        this.checkBoxHint = r1;
    }

    public void setInput(String r1) {
        this.input = r1;
    }

    public void setInputState(String r1) {
        this.inputState = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setOptions(OptionsBean r1) {
        this.options = r1;
    }

    public void setRadioOptions(List<RadioOptions> r1) {
        this.radioOptions = r1;
    }

    public void setScene(String r1) {
        this.scene = r1;
    }

    public void setSrcObjToken(String r1) {
        this.srcObjToken = r1;
    }

    public void setSrcObjType(int r1) {
        this.srcObjType = r1;
    }

    public void setTipsMessage(String r1) {
        this.tipsMessage = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setVerticalMode(boolean r1) {
        this.verticalMode = r1;
    }
}
