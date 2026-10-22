package com.bytedance.lark.pb.tool.v1;

import com.bytedance.lark.pb.basic.v1.NetDecorator;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SetCustomParamsRequest extends Message<SetCustomParamsRequest, Builder> {
    public static final ProtoAdapter<SetCustomParamsRequest> ADAPTER = null;
    public static final ProtoAdapter_SetCustomParamsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<NetDecorator> net_decorators;

    public static final class Builder extends Message.Builder<SetCustomParamsRequest, Builder> implements b<SetCustomParamsRequest> {
        public List<NetDecorator> net_decorators;

        @Override // com.squareup.wire.Message.Builder
        public SetCustomParamsRequest build() {
            return new SetCustomParamsRequest(this.net_decorators, super.buildUnknownFields());
        }

        public Builder() {
            this.net_decorators = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder net_decorators(List<NetDecorator> r100) {
            Internal.checkElementsNotNull(r100);
            this.net_decorators = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetCustomParamsRequest extends ProtoAdapter<SetCustomParamsRequest> implements a<SetCustomParamsRequest> {
        public ProtoAdapter_SetCustomParamsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetCustomParamsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetCustomParamsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.net_decorators.add(NetDecorator.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SetCustomParamsRequest r100) {
            return NetDecorator.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.net_decorators) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetCustomParamsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetCustomParamsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetCustomParamsRequest r101) throws IOException {
            NetDecorator.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.net_decorators);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetCustomParamsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetCustomParamsRequest r100 = new ProtoAdapter_SetCustomParamsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.net_decorators = Internal.copyOf("net_decorators", this.net_decorators);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetCustomParamsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetCustomParamsRequest(List<NetDecorator> r100) {
        this(r100, ByteString.EMPTY);
    }

    public SetCustomParamsRequest(List<NetDecorator> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.net_decorators = Internal.immutableCopyOf("net_decorators", r100);
    }
}
