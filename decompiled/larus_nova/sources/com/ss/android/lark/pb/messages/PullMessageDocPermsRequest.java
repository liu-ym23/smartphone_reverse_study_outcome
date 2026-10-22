package com.ss.android.lark.pb.messages;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullMessageDocPermsRequest extends Message<PullMessageDocPermsRequest, Builder> {
    public static final ProtoAdapter<PullMessageDocPermsRequest> ADAPTER = null;
    public static final FieldOptions FIELD_OPTIONS_MMESSAGE_IDS = null;
    private static final long serialVersionUID = 0;
    public final List<String> mmessage_ids;

    public static final class Builder extends Message.Builder<PullMessageDocPermsRequest, Builder> {
        public List<String> mmessage_ids;

        @Override // com.squareup.wire.Message.Builder
        public PullMessageDocPermsRequest build() {
            return new PullMessageDocPermsRequest(this.mmessage_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.mmessage_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmessage_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullMessageDocPermsRequest extends ProtoAdapter<PullMessageDocPermsRequest> {
        public ProtoAdapter_PullMessageDocPermsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullMessageDocPermsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullMessageDocPermsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mmessage_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(PullMessageDocPermsRequest r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.mmessage_ids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullMessageDocPermsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullMessageDocPermsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullMessageDocPermsRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.mmessage_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullMessageDocPermsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullMessageDocPermsRequest();
        FIELD_OPTIONS_MMESSAGE_IDS = new FieldOptions.Builder().FieldInfo("split,type=msg").build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmessage_ids = Internal.copyOf("mmessage_ids", this.mmessage_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullMessageDocPermsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullMessageDocPermsRequest(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PullMessageDocPermsRequest(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mmessage_ids = Internal.immutableCopyOf("mmessage_ids", r100);
    }
}
