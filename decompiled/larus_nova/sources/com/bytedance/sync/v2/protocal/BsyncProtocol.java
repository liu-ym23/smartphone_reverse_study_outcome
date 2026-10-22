package com.bytedance.sync.v2.protocal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class BsyncProtocol extends Message<BsyncProtocol, Builder> {
    public static final ProtoAdapter<BsyncProtocol> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.BsyncHeader#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final BsyncHeader header;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.BsyncTopic#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<BsyncTopic> topics;

    public static final class Builder extends Message.Builder<BsyncProtocol, Builder> {
        public BsyncHeader header;
        public List<BsyncTopic> topics;

        @Override // com.squareup.wire.Message.Builder
        public BsyncProtocol build() {
            BsyncHeader r100 = this.header;
            if (r100 == null) goto L7;
            return new BsyncProtocol(this.header, this.topics, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "header"});
        }

        public Builder() {
            this.topics = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder header(BsyncHeader r100) {
            this.header = r100;
            return this;
        }

        public Builder topics(List<BsyncTopic> r100) {
            Internal.checkElementsNotNull(r100);
            this.topics = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BsyncProtocol extends ProtoAdapter<BsyncProtocol> {
        public ProtoAdapter_BsyncProtocol() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncProtocol.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BsyncProtocol decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.header(BsyncHeader.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.topics.add(BsyncTopic.ADAPTER.decode(r100));
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
        public int encodedSize2(BsyncProtocol r100) {
            return (BsyncHeader.ADAPTER.encodedSizeWithTag(1, r100.header) + BsyncTopic.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.topics)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public BsyncProtocol redact2(BsyncProtocol r100) {
            Builder r101 = r100.newBuilder();
            r101.header = BsyncHeader.ADAPTER.redact(r101.header);
            Internal.redactElements(r101.topics, BsyncTopic.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BsyncProtocol decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BsyncProtocol r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BsyncProtocol redact(BsyncProtocol r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BsyncProtocol r101) throws IOException {
            BsyncHeader.ADAPTER.encodeWithTag(r100, 1, r101.header);
            BsyncTopic.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.topics);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BsyncProtocol r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BsyncProtocol();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.topics.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.header = this.header;
        r100.topics = Internal.copyOf(Constants.EXTRA_KEY_TOPICS, this.topics);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", header=");
        r100.append(this.header);
        if (this.topics.isEmpty() == true) goto L5;
        r100.append(", topics=");
        r100.append(this.topics);
    L5:
        StringBuilder r101 = r100.replace(0, 2, "BsyncProtocol{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof BsyncProtocol) == true) goto L8;
        return false;
    L8:
        BsyncProtocol r101 = (BsyncProtocol) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (this.header.equals(r101.header) == false) goto L15;
        if (this.topics.equals(r101.topics) == false) goto L15;
        return true;
    }

    public BsyncProtocol(BsyncHeader r100, List<BsyncTopic> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public BsyncProtocol(BsyncHeader r100, List<BsyncTopic> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.header = r100;
        this.topics = Internal.immutableCopyOf(Constants.EXTRA_KEY_TOPICS, r101);
    }
}
