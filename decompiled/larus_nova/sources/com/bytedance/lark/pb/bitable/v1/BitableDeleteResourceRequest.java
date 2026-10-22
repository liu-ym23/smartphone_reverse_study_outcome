package com.bytedance.lark.pb.bitable.v1;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class BitableDeleteResourceRequest extends Message<BitableDeleteResourceRequest, Builder> {
    public static final ProtoAdapter<BitableDeleteResourceRequest> ADAPTER = null;
    public static final ProtoAdapter_BitableDeleteResourceRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ResourceType> resource_types;

    public static final class Builder extends Message.Builder<BitableDeleteResourceRequest, Builder> implements d<BitableDeleteResourceRequest> {
        public List<ResourceType> resource_types;

        @Override // com.squareup.wire.Message.Builder
        public BitableDeleteResourceRequest build() {
            return new BitableDeleteResourceRequest(this.resource_types, super.buildUnknownFields());
        }

        public Builder() {
            this.resource_types = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder resource_types(List<ResourceType> r100) {
            Internal.checkElementsNotNull(r100);
            this.resource_types = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BitableDeleteResourceRequest extends ProtoAdapter<BitableDeleteResourceRequest> implements c<BitableDeleteResourceRequest> {
        public ProtoAdapter_BitableDeleteResourceRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, BitableDeleteResourceRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BitableDeleteResourceRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.resource_types.add(ResourceType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BitableDeleteResourceRequest r100) {
            return ResourceType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.resource_types) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BitableDeleteResourceRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BitableDeleteResourceRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BitableDeleteResourceRequest r101) throws IOException {
            ResourceType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.resource_types);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BitableDeleteResourceRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum ResourceType extends Enum<ResourceType> implements WireEnum {
        private static final /* synthetic */ ResourceType[] $VALUES = null;
        public static final ProtoAdapter<ResourceType> ADAPTER = null;
        public static final ResourceType ALL = null;
        public static final ResourceType LocalCS = null;
        public static final ResourceType MainDocBlockInfo = null;
        public static final ResourceType MainDocClientVars = null;
        public static final ResourceType MainDocPage = null;
        private final int value;

        static {
            ResourceType r100 = new ResourceType(AccountType.ALL, 0, 0);
            ALL = r100;
            ResourceType r101 = new ResourceType("LocalCS", 1, 1);
            LocalCS = r101;
            ResourceType r102 = new ResourceType("MainDocClientVars", 2, 2);
            MainDocClientVars = r102;
            ResourceType r103 = new ResourceType("MainDocPage", 3, 3);
            MainDocPage = r103;
            ResourceType r104 = new ResourceType("MainDocBlockInfo", 4, 4);
            MainDocBlockInfo = r104;
            $VALUES = new ResourceType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(ResourceType.class);
        }

        public static ResourceType[] values() {
            return (ResourceType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ResourceType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return MainDocBlockInfo;
        L16:
            return MainDocPage;
        L18:
            return MainDocClientVars;
        L20:
            return LocalCS;
        L22:
            return ALL;
        }

        public static ResourceType valueOf(String r100) {
            return (ResourceType) a.a(ResourceType.class, r100);
        }

        private ResourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_BitableDeleteResourceRequest r100 = new ProtoAdapter_BitableDeleteResourceRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.resource_types = Internal.copyOf("resource_types", this.resource_types);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BitableDeleteResourceRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BitableDeleteResourceRequest(List<ResourceType> r100) {
        this(r100, ByteString.EMPTY);
    }

    public BitableDeleteResourceRequest(List<ResourceType> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.resource_types = Internal.immutableCopyOf("resource_types", r100);
    }
}
