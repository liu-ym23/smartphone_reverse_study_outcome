package com.bytedance.ee.bear.document.alert;

import android.text.TextUtils;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.nova.R;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
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

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f218869id;
        private String text;

        public String toString() {
            return "ButtonsBean{text='" + this.text + "', id='" + this.f218869id + "', color=" + this.color + '}';
        }

        public ButtonsBean() {
            this.autoDismiss = true;
        }

        public int getColor() {
            return this.color;
        }

        public String getId() {
            return this.f218869id;
        }

        public String getText() {
            return this.text;
        }

        public boolean isAutoDismiss() {
            return this.autoDismiss;
        }

        public void setAutoDismiss(boolean r100) {
            this.autoDismiss = r100;
        }

        public void setColor(int r100) {
            this.color = r100;
        }

        public void setId(String r100) {
            this.f218869id = r100;
        }

        public void setText(String r100) {
            this.text = r100;
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

        public void setMessage_align(int r100) {
            this.message_align = r100;
        }
    }

    public static class RadioOptions implements BaseJSModel {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f218870id;
        private String info;
        private boolean isSelected;
        private String title;

        public RadioOptions() {
        }

        public String toString() {
            return "RadioOptions{id='" + this.f218870id + "', title='" + this.title + "', info='" + this.info + "', isSelected=" + this.isSelected + '}';
        }

        public String getId() {
            return this.f218870id;
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

        public void setId(String r100) {
            this.f218870id = r100;
        }

        public void setInfo(String r100) {
            this.info = r100;
        }

        public void setSelected(boolean r100) {
            this.isSelected = r100;
        }

        public void setTitle(String r100) {
            this.title = r100;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f218871a = null;

        static {
            int[] r100 = new int[InputState.values().length];
            f218871a = r100;
            r100[InputState.ACTIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f218871a[InputState.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public AlertActionType getAlertActionType() {
        if (TextUtils.isEmpty(this.alertAction) == true) goto L9;
        return AlertActionType.valueOf(this.alertAction.toUpperCase());
    L6:
        th = move-exception;
        tt5.a.e("AlertModel", "getAlertActionType error, return AlertActionType.SHOW.", th, false);
    L9:
        return AlertActionType.SHOW;
    }

    public int getInputBackgroundRes() {
        int r100 = a.f218871a[getInputStateType().ordinal()];
        if (r100 != 1) goto L5;
        return R.drawable.space_kit_search_bar_float_bg_active;
    L5:
        if (r100 == 2) goto L8;
        return R.drawable.space_kit_search_bar_float_bg;
    L8:
        return R.drawable.space_kit_search_bar_float_bg_error;
    }

    public InputState getInputStateType() {
        if (TextUtils.isEmpty(this.inputState) == true) goto L9;
        return InputState.valueOf(this.inputState.toUpperCase());
    L6:
        th = move-exception;
        tt5.a.e("AlertModel", "getInputStateType error, return InputState.NORMAL.", th, false);
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

    public void setAlertAction(String r100) {
        this.alertAction = r100;
    }

    public void setAutoDismiss(boolean r100) {
        this.autoDismiss = r100;
    }

    public void setButtons(List<ButtonsBean> r100) {
        this.buttons = r100;
    }

    public void setCancelable(boolean r100) {
        this.cancelable = r100;
    }

    public void setCheckBoxHint(String r100) {
        this.checkBoxHint = r100;
    }

    public void setInput(String r100) {
        this.input = r100;
    }

    public void setInputState(String r100) {
        this.inputState = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setOptions(OptionsBean r100) {
        this.options = r100;
    }

    public void setRadioOptions(List<RadioOptions> r100) {
        this.radioOptions = r100;
    }

    public void setScene(String r100) {
        this.scene = r100;
    }

    public void setSrcObjToken(String r100) {
        this.srcObjToken = r100;
    }

    public void setSrcObjType(int r100) {
        this.srcObjType = r100;
    }

    public void setTipsMessage(String r100) {
        this.tipsMessage = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setVerticalMode(boolean r100) {
        this.verticalMode = r100;
    }
}
