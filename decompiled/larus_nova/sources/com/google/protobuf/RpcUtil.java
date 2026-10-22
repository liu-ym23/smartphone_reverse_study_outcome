package com.google.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public final class RpcUtil {

    public static final class AlreadyCalledException extends RuntimeException {
        private static final long serialVersionUID = 5469741279507848266L;

        public AlreadyCalledException() {
            super("This RpcCallback was already called and cannot be called multiple times.");
        }
    }

    private RpcUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <Type extends Message> RpcCallback<Type> specializeCallback(RpcCallback<Message> r100) {
        return r100;
    }

    public static <ParameterType> RpcCallback<ParameterType> newOneTimeCallback(final RpcCallback<ParameterType> r100) {
        return new AnonymousClass2(r100);
    }

    public static /* synthetic */ Message access$000(Message r100, Message r101) {
        return copyAsType(r100, r101);
    }

    private static <Type extends Message> Type copyAsType(Type r100, Message r101) {
        return (Type) r100.newBuilderForType().mergeFrom(r101).build();
    }

    public static <Type extends Message> RpcCallback<Message> generalizeCallback(final RpcCallback<Type> r100, final Class<Type> r101, final Type r102) {
        return new AnonymousClass1(r101, r102, r100);
    }
}
