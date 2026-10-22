package com.ss.android.lark.ka.message.api.model;

/* JADX INFO: loaded from: classes36.dex */
public class MessageInfo {
    private String channelId;
    private String key;
    private final String messageId;
    private String mime;
    private String name;
    private final long size;
    private final MessageType type;

    /* JADX INFO: renamed from: com.ss.android.lark.ka.message.api.model.MessageInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private String channelId;
        private String key;
        private String messageId;
        private String mime;
        private String name;
        private long size;
        private MessageType type;

        public MessageInfo build() {
            return new MessageInfo(this, null);
        }

        public Builder() {
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.key;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.messageId;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.channelId;
        }

        public static /* synthetic */ MessageType access$300(Builder r100) {
            return r100.type;
        }

        public static /* synthetic */ String access$400(Builder r100) {
            return r100.name;
        }

        public static /* synthetic */ long access$500(Builder r100) {
            return r100.size;
        }

        public static /* synthetic */ String access$600(Builder r100) {
            return r100.mime;
        }

        public Builder channelId(String r100) {
            this.channelId = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder messageId(String r100) {
            this.messageId = r100;
            return this;
        }

        public Builder mime(String r100) {
            this.mime = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder size(long r100) {
            this.size = r100;
            return this;
        }

        public Builder type(MessageType r100) {
            this.type = r100;
            return this;
        }
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getMime() {
        return this.mime;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public MessageType getType() {
        return this.type;
    }

    private MessageInfo(Builder r100) {
        if (Builder.access$000(r100) == null) goto L6;
        this.key = Builder.access$000(r100);
    L6:
        if (Builder.access$100(r100) == null) goto L22;
        this.messageId = Builder.access$100(r100);
        if (Builder.access$200(r100) == null) goto L11;
        this.channelId = Builder.access$200(r100);
    L11:
        if (Builder.access$300(r100) == null) goto L20;
        this.type = Builder.access$300(r100);
        if (Builder.access$400(r100) == null) goto L15;
        this.name = Builder.access$400(r100);
    L15:
        this.size = Builder.access$500(r100);
        if (Builder.access$600(r100) == null) goto L23;
        this.mime = Builder.access$600(r100);
        return;
    L23:
        return;
    L20:
        throw new IllegalStateException("type is null");
    L22:
        throw new IllegalStateException("messageId is null");
    }

    public /* synthetic */ MessageInfo(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
