package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class ApiProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_Api_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Api_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_Method_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Method_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_Mixin_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Mixin_fieldAccessorTable = null;

    private ApiProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite r100) {
    }

    static {
        Descriptors.FileDescriptor.InternalDescriptorAssigner r100 = new AnonymousClass1();
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019google/protobuf/api.proto\u0012\u000fgoogle.protobuf\u001a$google/protobuf/source_context.proto\u001a\u001agoogle/protobuf/type.proto\"\u0081\u0002\n\u0003Api\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012(\n\u0007methods\u0018\u0002 \u0003(\u000b2\u0017.google.protobuf.Method\u0012(\n\u0007options\u0018\u0003 \u0003(\u000b2\u0017.google.protobuf.Option\u0012\u000f\n\u0007version\u0018\u0004 \u0001(\t\u00126\n\u000esource_context\u0018\u0005 \u0001(\u000b2\u001e.google.protobuf.SourceContext\u0012&\n\u0006mixins\u0018\u0006 \u0003(\u000b2\u0016.google.protobuf.Mixin\u0012'\n\u0006syntax\u0018\u0007 \u0001(\u000e2\u0017.google.protobuf.Syntax\"Õ\u0001\n\u0006Method\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0018\n\u0010request_type_url\u0018\u0002 \u0001(\t\u0012\u0019\n\u0011request_streaming\u0018\u0003 \u0001(\b\u0012\u0019\n\u0011response_type_url\u0018\u0004 \u0001(\t\u0012\u001a\n\u0012response_streaming\u0018\u0005 \u0001(\b\u0012(\n\u0007options\u0018\u0006 \u0003(\u000b2\u0017.google.protobuf.Option\u0012'\n\u0006syntax\u0018\u0007 \u0001(\u000e2\u0017.google.protobuf.Syntax\"#\n\u0005Mixin\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\f\n\u0004root\u0018\u0002 \u0001(\tBu\n\u0013com.google.protobufB\bApiProtoP\u0001Z+google.golang.org/genproto/protobuf/api;api¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[]{SourceContextProto.getDescriptor(), TypeProto.getDescriptor()}, r100);
        Descriptors.Descriptor r101 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 0);
        internal_static_google_protobuf_Api_descriptor = r101;
        internal_static_google_protobuf_Api_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r101, new String[]{"Name", "Methods", "Options", "Version", "SourceContext", "Mixins", "Syntax"});
        Descriptors.Descriptor r102 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 1);
        internal_static_google_protobuf_Method_descriptor = r102;
        internal_static_google_protobuf_Method_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r102, new String[]{"Name", "RequestTypeUrl", "RequestStreaming", "ResponseTypeUrl", "ResponseStreaming", "Options", "Syntax"});
        Descriptors.Descriptor r103 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 2);
        internal_static_google_protobuf_Mixin_descriptor = r103;
        internal_static_google_protobuf_Mixin_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r103, new String[]{"Name", "Root"});
        SourceContextProto.getDescriptor();
        TypeProto.getDescriptor();
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static /* synthetic */ Descriptors.FileDescriptor access$002(Descriptors.FileDescriptor r100) {
        descriptor = r100;
        return r100;
    }

    public static void registerAllExtensions(ExtensionRegistry r100) {
        registerAllExtensions(r100);
    }
}
