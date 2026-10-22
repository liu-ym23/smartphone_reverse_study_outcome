package com.bytedance.crypto.monitor.proto;

import com.alipay.sdk.m.p.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.RuntimeVersion;

/* JADX INFO: loaded from: classes15.dex */
public final class CryptoSDKProto {
    private static Descriptors.FileDescriptor descriptor;
    public static final Descriptors.Descriptor internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_descriptor = null;
    public static final GeneratedMessage.FieldAccessorTable internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_fieldAccessorTable = null;
    public static final Descriptors.Descriptor internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_descriptor = null;
    public static final GeneratedMessage.FieldAccessorTable internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_fieldAccessorTable = null;
    public static final Descriptors.Descriptor internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_descriptor = null;
    public static final GeneratedMessage.FieldAccessorTable internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_fieldAccessorTable = null;
    public static final Descriptors.Descriptor internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_descriptor = null;
    public static final GeneratedMessage.FieldAccessorTable internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_fieldAccessorTable = null;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", CryptoSDKProto.class.getName());
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fcryptosdk.proto\u0012\"com.bytedance.crypto.monitor.proto\"Ò\u0001\n\rCryptoSDKInfo\u0012\u000f\n\u0007version\u0018\u0001 \u0001(\u0005\u0012\u0011\n\ttrain_num\u0018\u0002 \u0001(\r\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003\u0012E\n\fnormal_trace\u0018\u0004 \u0003(\u000b2/.com.bytedance.crypto.monitor.proto.NormalTrace\u0012C\n\u000berror_trace\u0018\u0005 \u0003(\u000b2..com.bytedance.crypto.monitor.proto.ErrorTrace\"¥\u0001\n\nErrorTrace\u0012\u0011\n\tmodule_id\u0018\u0001 \u0001(\r\u0012\u0010\n\bevent_id\u0018\u0002 \u0001(\r\u0012\u0014\n\fpackage_name\u0018\u0003 \u0001(\t\u0012\u0010\n\berr_code\u0018\u0004 \u0001(\u0005\u0012J\n\u000fcloud_sync_data\u0018d \u0001(\u000b21.com.bytedance.crypto.monitor.proto.CloudSyncData\"Â\u0001\n\u000bNormalTrace\u0012\u0011\n\tmodule_id\u0018\u0001 \u0001(\r\u0012\u0010\n\bevent_id\u0018\u0002 \u0001(\r\u0012\u0014\n\fpackage_name\u0018\u0003 \u0001(\t\u0012\u000e\n\u0006app_id\u0018\u0004 \u0001(\t\u0012\u000e\n\u0006userid\u0018\u0005 \u0001(\r\u0012\u0010\n\berr_code\u0018\u0006 \u0001(\u0005\u0012\u0013\n\u000btotal_calls\u0018\u0007 \u0001(\u0005\u0012\u0018\n\u0010time_consumption\u0018\b \u0001(\u0004\u0012\u0017\n\u000ftotal_data_size\u0018\t \u0001(\u0004\"7\n\rCloudSyncData\u0012\u0013\n\u000bcrypto_mode\u0018\u0001 \u0001(\r\u0012\u0011\n\tdata_size\u0018\u0002 \u0001(\rB\u0012B\u000eCryptoSDKProtoP\u0001"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r100 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 0);
        internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_descriptor = r100;
        internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r100, new String[]{"Version", "TrainNum", "Timestamp", "NormalTrace", "ErrorTrace"});
        Descriptors.Descriptor r101 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 1);
        internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_descriptor = r101;
        internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r101, new String[]{"ModuleId", "EventId", "PackageName", "ErrCode", "CloudSyncData"});
        Descriptors.Descriptor r102 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 2);
        internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_descriptor = r102;
        internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r102, new String[]{"ModuleId", "EventId", "PackageName", e.f25660h, "Userid", "ErrCode", "TotalCalls", "TimeConsumption", "TotalDataSize"});
        Descriptors.Descriptor r103 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 3);
        internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_descriptor = r103;
        internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r103, new String[]{"CryptoMode", "DataSize"});
        descriptor.resolveAllFeaturesImmutable();
    }

    private CryptoSDKProto() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r100) {
        registerAllExtensions(r100);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r100) {
    }
}
