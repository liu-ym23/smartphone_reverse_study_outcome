package com.ss.android.lark.dto.translate;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.MessageSource;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class TranslateState implements Serializable {
    private int errorCode;
    private String errorMsg;
    private boolean isManual;
    private boolean isMessageVersionUpdate;
    private Message message;
    private String messageId;
    private MessageSource messageSource;
    private TranslateInfo translateInfo;

    public boolean isError() {
        return TextUtils.isEmpty(this.errorMsg);
    }

    public TranslateState() {
    }

    public String getError() {
        return this.errorMsg;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public Message getMessage() {
        return this.message;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public MessageSource getMessageSource() {
        return this.messageSource;
    }

    public TranslateInfo getTranslateInfo() {
        return this.translateInfo;
    }

    public boolean isManual() {
        return this.isManual;
    }

    public boolean isMessageVersionUpdate() {
        return this.isMessageVersionUpdate;
    }

    public TranslateState(String r100) {
        this.messageId = r100;
    }

    public void setError(String r100) {
        this.errorMsg = r100;
    }

    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public void setIsMessageVersionUpdate(boolean r100) {
        this.isMessageVersionUpdate = r100;
    }

    public void setManual(boolean r100) {
        this.isManual = r100;
    }

    public void setMessage(Message r100) {
        this.message = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setMessageSource(MessageSource r100) {
        this.messageSource = r100;
    }

    public void setTranslateInfo(TranslateInfo r100) {
        this.translateInfo = r100;
    }
}
