package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class MGetMyAIExtensionBasicInfoRequest extends Message<MGetMyAIExtensionBasicInfoRequest, Builder> {
    public static final ProtoAdapter<MGetMyAIExtensionBasicInfoRequest> ADAPTER = null;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_MGetMyAIExtensionBasicInfoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> extension_ids;
    public final SyncDataStrategy strategy;

    public static final class Builder extends Message.Builder<MGetMyAIExtensionBasicInfoRequest, Builder> implements d<MGetMyAIExtensionBasicInfoRequest> {
        public List<String> extension_ids;
        public SyncDataStrategy strategy;

        @Override // com.squareup.wire.Message.Builder
        public MGetMyAIExtensionBasicInfoRequest build() {
            return new MGetMyAIExtensionBasicInfoRequest(this.extension_ids, this.strategy, super.buildUnknownFields());
        }

        public Builder() {
            this.extension_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder extension_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extension_ids = r100;
            return this;
        }

        public Builder strategy(SyncDataStrategy r100) {
            this.strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetMyAIExtensionBasicInfoRequest extends ProtoAdapter<MGetMyAIExtensionBasicInfoRequest> implements c<MGetMyAIExtensionBasicInfoRequest> {
        public ProtoAdapter_MGetMyAIExtensionBasicInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetMyAIExtensionBasicInfoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetMyAIExtensionBasicInfoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.strategy = SyncDataStrategy.TRY_LOCAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.extension_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MGetMyAIExtensionBasicInfoRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.extension_ids);
            SyncDataStrategy r102 = r100.strategy;
            if (r102 == null) goto L5;
            int r103 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetMyAIExtensionBasicInfoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetMyAIExtensionBasicInfoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetMyAIExtensionBasicInfoRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.extension_ids);
            SyncDataStrategy r102 = r101.strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetMyAIExtensionBasicInfoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetMyAIExtensionBasicInfoRequest r100 = new ProtoAdapter_MGetMyAIExtensionBasicInfoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STRATEGY = SyncDataStrategy.TRY_LOCAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.extension_ids = Internal.copyOf("extension_ids", this.extension_ids);
        r100.strategy = this.strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetMyAIExtensionBasicInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetMyAIExtensionBasicInfoRequest(List<String> r100, SyncDataStrategy r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MGetMyAIExtensionBasicInfoRequest(List<String> r100, SyncDataStrategy r101, ByteString r102) {
        super(ADAPTER, r102);
        this.extension_ids = Internal.immutableCopyOf("extension_ids", r100);
        this.strategy = r101;
    }
}
