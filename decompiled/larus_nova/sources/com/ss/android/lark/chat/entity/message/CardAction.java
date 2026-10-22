package com.ss.android.lark.chat.entity.message;

import com.squareup.wire.WireEnum;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class CardAction implements Serializable {
    private int cmd;
    private Method method;
    private OpenUrl openUrl;
    private CardActionPacket packet;
    private Parameters parameters;
    private RequiredParameters requiredParameters;
    private String url;

    public static class MessageInfo implements Serializable {
        private String messageOpenId;

        public MessageInfo() {
        }

        public String getMessageOpenId() {
            return this.messageOpenId;
        }

        public void setMessageOpenId(String r100) {
            this.messageOpenId = r100;
        }
    }

    public static final enum Method extends Enum<Method> implements WireEnum {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final Method GET = null;
        public static final Method LARK_COMMAND = null;
        public static final Method OPEN_URL = null;
        public static final Method POST = null;
        private final int value;

        static {
            Method r100 = new Method("GET", 0, 1);
            GET = r100;
            Method r101 = new Method("POST", 1, 2);
            POST = r101;
            Method r102 = new Method("LARK_COMMAND", 2, 3);
            LARK_COMMAND = r102;
            Method r103 = new Method("OPEN_URL", 3, 4);
            OPEN_URL = r103;
            $VALUES = new Method[]{r100, r101, r102, r103};
        }

        public static Method[] values() {
            return (Method[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }

        public static Method fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return OPEN_URL;
        L15:
            return LARK_COMMAND;
        L17:
            return POST;
        L19:
            return GET;
        }

        public static Method valueOf(String r100) {
            return (Method) r27.a.a(Method.class, r100);
        }

        private Method(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class OpenUrl implements Serializable {
        private String androidUrl;
        private String iosUrl;
        private String pcUrl;
        private String url;

        public OpenUrl() {
        }

        public String getAndroidUrl() {
            return this.androidUrl;
        }

        public String getIosUrl() {
            return this.iosUrl;
        }

        public String getPcUrl() {
            return this.pcUrl;
        }

        public String getUrl() {
            return this.url;
        }

        public void setAndroidUrl(String r100) {
            this.androidUrl = r100;
        }

        public void setIosUrl(String r100) {
            this.iosUrl = r100;
        }

        public void setPcUrl(String r100) {
            this.pcUrl = r100;
        }

        public void setUrl(String r100) {
            this.url = r100;
        }
    }

    public static class Parameters implements Serializable {
        private String messageId;
        private MessageInfo messageInfo;
        private Map<String, String> parameters;
        private String userId;
        private UserInfo userInfo;

        public Parameters() {
        }

        public String getMessageId() {
            return this.messageId;
        }

        public MessageInfo getMessageInfo() {
            return this.messageInfo;
        }

        public Map<String, String> getParameters() {
            return this.parameters;
        }

        public String getUserId() {
            return this.userId;
        }

        public UserInfo getUserInfo() {
            return this.userInfo;
        }

        public void setMessageId(String r100) {
            this.messageId = r100;
        }

        public void setMessageInfo(MessageInfo r100) {
            this.messageInfo = r100;
        }

        public void setParameters(Map<String, String> r100) {
            this.parameters = r100;
        }

        public void setUserId(String r100) {
            this.userId = r100;
        }

        public void setUserInfo(UserInfo r100) {
            this.userInfo = r100;
        }
    }

    public static class RequiredParameters implements Serializable {
        private boolean needMessageId;
        private boolean needMessageInfo;
        private boolean needUserId;
        private boolean needUserInfo;

        public RequiredParameters() {
        }

        public boolean isNeedMessageId() {
            return this.needMessageId;
        }

        public boolean isNeedMessageInfo() {
            return this.needMessageInfo;
        }

        public boolean isNeedUserId() {
            return this.needUserId;
        }

        public boolean isNeedUserInfo() {
            return this.needUserInfo;
        }

        public void setNeedMessageId(boolean r100) {
            this.needMessageId = r100;
        }

        public void setNeedMessageInfo(boolean r100) {
            this.needMessageInfo = r100;
        }

        public void setNeedUserId(boolean r100) {
            this.needUserId = r100;
        }

        public void setNeedUserInfo(boolean r100) {
            this.needUserInfo = r100;
        }
    }

    public static class UserInfo implements Serializable {
        private String userOpenId;

        public UserInfo() {
        }

        public String getUserOpenId() {
            return this.userOpenId;
        }

        public void setUserOpenId(String r100) {
            this.userOpenId = r100;
        }
    }

    public CardAction() {
    }

    public int getCmd() {
        return this.cmd;
    }

    public Method getMethod() {
        return this.method;
    }

    public OpenUrl getOpenUrl() {
        return this.openUrl;
    }

    public CardActionPacket getPacket() {
        return this.packet;
    }

    public Parameters getParameters() {
        return this.parameters;
    }

    public RequiredParameters getRequiredParameters() {
        return this.requiredParameters;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCmd(int r100) {
        this.cmd = r100;
    }

    public void setMethod(Method r100) {
        this.method = r100;
    }

    public void setOpenUrl(OpenUrl r100) {
        this.openUrl = r100;
    }

    public void setPacket(CardActionPacket r100) {
        this.packet = r100;
    }

    public void setParameters(Parameters r100) {
        this.parameters = r100;
    }

    public void setRequiredParameters(RequiredParameters r100) {
        this.requiredParameters = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
