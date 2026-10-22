package com.bytedance.lark.pb.im.v1;

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
public final class GetEmojisRequest extends Message<GetEmojisRequest, Builder> {
    public static final ProtoAdapter<GetEmojisRequest> ADAPTER = null;
    public static final Integer DEFAULT_VERSION = null;
    public static final ProtoAdapter_GetEmojisRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> trigger_keys;
    public final Integer version;

    public static final class Builder extends Message.Builder<GetEmojisRequest, Builder> implements d<GetEmojisRequest> {
        public List<String> trigger_keys;
        public Integer version;

        @Override // com.squareup.wire.Message.Builder
        public GetEmojisRequest build() {
            return new GetEmojisRequest(this.version, this.trigger_keys, super.buildUnknownFields());
        }

        public Builder() {
            this.trigger_keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder trigger_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.trigger_keys = r100;
            return this;
        }

        public Builder version(Integer r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetEmojisRequest extends ProtoAdapter<GetEmojisRequest> implements c<GetEmojisRequest> {
        public ProtoAdapter_GetEmojisRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetEmojisRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetEmojisRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.version = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.trigger_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetEmojisRequest r100) {
            Integer r101 = r100.version;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.trigger_keys)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetEmojisRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetEmojisRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetEmojisRequest r101) throws IOException {
            Integer r102 = r101.version;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.trigger_keys);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetEmojisRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetEmojisRequest r100 = new ProtoAdapter_GetEmojisRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_VERSION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.version = this.version;
        r100.trigger_keys = Internal.copyOf("trigger_keys", this.trigger_keys);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetEmojisRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetEmojisRequest(Integer r100, List<String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetEmojisRequest(Integer r100, List<String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.version = r100;
        this.trigger_keys = Internal.immutableCopyOf("trigger_keys", r101);
    }
}
