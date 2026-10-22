package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class StructProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_google_protobuf_ListValue_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_ListValue_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_Struct_FieldsEntry_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Struct_FieldsEntry_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_Struct_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Struct_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_google_protobuf_Value_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_Value_fieldAccessorTable = null;

    private StructProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite r100) {
    }

    static {
        Descriptors.FileDescriptor[] r100 = new Descriptors.FileDescriptor[0];
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cgoogle/protobuf/struct.proto\u0012\u000fgoogle.protobuf\"\u0084\u0001\n\u0006Struct\u00123\n\u0006fields\u0018\u0001 \u0003(\u000b2#.google.protobuf.Struct.FieldsEntry\u001aE\n\u000bFieldsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012%\n\u0005value\u0018\u0002 \u0001(\u000b2\u0016.google.protobuf.Value:\u00028\u0001\"ê\u0001\n\u0005Value\u00120\n\nnull_value\u0018\u0001 \u0001(\u000e2\u001a.google.protobuf.NullValueH\u0000\u0012\u0016\n\fnumber_value\u0018\u0002 \u0001(\u0001H\u0000\u0012\u0016\n\fstring_value\u0018\u0003 \u0001(\tH\u0000\u0012\u0014\n\nbool_value\u0018\u0004 \u0001(\bH\u0000\u0012/\n\fstruct_value\u0018\u0005 \u0001(\u000b2\u0017.google.protobuf.StructH\u0000\u00120\n\nlist_value\u0018\u0006 \u0001(\u000b2\u001a.google.protobuf.ListValueH\u0000B\u0006\n\u0004kind\"3\n\tListValue\u0012&\n\u0006values\u0018\u0001 \u0003(\u000b2\u0016.google.protobuf.Value*\u001b\n\tNullValue\u0012\u000e\n\nNULL_VALUE\u0010\u0000B\u0081\u0001\n\u0013com.google.protobufB\u000bStructProtoP\u0001Z1github.com/golang/protobuf/ptypes/struct;structpbø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, r100, new AnonymousClass1());
        Descriptors.Descriptor r101 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 0);
        internal_static_google_protobuf_Struct_descriptor = r101;
        internal_static_google_protobuf_Struct_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r101, new String[]{"Fields"});
        Descriptors.Descriptor r102 = (Descriptors.Descriptor) ListProtector.get(r101.getNestedTypes(), 0);
        internal_static_google_protobuf_Struct_FieldsEntry_descriptor = r102;
        internal_static_google_protobuf_Struct_FieldsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r102, new String[]{"Key", "Value"});
        Descriptors.Descriptor r103 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 1);
        internal_static_google_protobuf_Value_descriptor = r103;
        internal_static_google_protobuf_Value_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r103, new String[]{"NullValue", "NumberValue", "StringValue", "BoolValue", "StructValue", "ListValue", "Kind"});
        Descriptors.Descriptor r104 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 2);
        internal_static_google_protobuf_ListValue_descriptor = r104;
        internal_static_google_protobuf_ListValue_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r104, new String[]{"Values"});
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
