package com.google.protobuf;

import com.google.protobuf.MessageLite;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public abstract class Extension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

    public static final enum ExtensionType extends java.lang.Enum<ExtensionType> {
        private static final /* synthetic */ ExtensionType[] $VALUES = null;
        public static final ExtensionType IMMUTABLE = null;
        public static final ExtensionType MUTABLE = null;
        public static final ExtensionType PROTO1 = null;

        static {
            ExtensionType r100 = new ExtensionType("IMMUTABLE", 0);
            IMMUTABLE = r100;
            ExtensionType r101 = new ExtensionType("MUTABLE", 1);
            MUTABLE = r101;
            ExtensionType r102 = new ExtensionType("PROTO1", 2);
            PROTO1 = r102;
            $VALUES = new ExtensionType[]{r100, r101, r102};
        }

        public static ExtensionType[] values() {
            return (ExtensionType[]) $VALUES.clone();
        }

        public static ExtensionType valueOf(String r100) {
            return (ExtensionType) a.a(ExtensionType.class, r100);
        }

        private ExtensionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum MessageType extends java.lang.Enum<MessageType> {
        private static final /* synthetic */ MessageType[] $VALUES = null;
        public static final MessageType PROTO1 = null;
        public static final MessageType PROTO2 = null;

        static {
            MessageType r100 = new MessageType("PROTO1", 0);
            PROTO1 = r100;
            MessageType r101 = new MessageType("PROTO2", 1);
            PROTO2 = r101;
            $VALUES = new MessageType[]{r100, r101};
        }

        public static MessageType[] values() {
            return (MessageType[]) $VALUES.clone();
        }

        public static MessageType valueOf(String r100) {
            return (MessageType) a.a(MessageType.class, r100);
        }

        private MessageType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract Object fromReflectionType(Object r100);

    public abstract Descriptors.FieldDescriptor getDescriptor();

    public abstract ExtensionType getExtensionType();

    @Override // com.google.protobuf.ExtensionLite
    public final boolean isLite() {
        return false;
    }

    public abstract Object singularFromReflectionType(Object r100);

    public abstract Object singularToReflectionType(Object r100);

    public abstract Object toReflectionType(Object r100);

    public Extension() {
    }

    public MessageType getMessageType() {
        return MessageType.PROTO2;
    }
}
