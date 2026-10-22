package com.bytedance.sync.v2.protocal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes22.dex */
public final class BsyncPayload extends Message<BsyncPayload, Builder> {
    public static final ProtoAdapter<BsyncPayload> ADAPTER = null;
    public static final Integer DEFAULT_BUSINESS = null;
    public static final ConsumeType DEFAULT_CONSUME_TYPE = null;
    public static final ByteString DEFAULT_DATA = null;
    public static final String DEFAULT_MD5 = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 1)
    public final Integer business;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.ConsumeType#ADAPTER", tag = 2)
    public final ConsumeType consume_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 4)
    public final ByteString data;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f270531md5;

    public static final class Builder extends Message.Builder<BsyncPayload, Builder> {
        public Integer business;
        public ConsumeType consume_type;
        public ByteString data;

        /* JADX INFO: renamed from: md5, reason: collision with root package name */
        public String f270532md5;

        @Override // com.squareup.wire.Message.Builder
        public BsyncPayload build() {
            Integer r100 = this.business;
            if (r100 == null) goto L7;
            return new BsyncPayload(this.business, this.consume_type, this.f270532md5, this.data, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "business"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder business(Integer r100) {
            this.business = r100;
            return this;
        }

        public Builder consume_type(ConsumeType r100) {
            this.consume_type = r100;
            return this;
        }

        public Builder data(ByteString r100) {
            this.data = r100;
            return this;
        }

        public Builder md5(String r100) {
            this.f270532md5 = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BsyncPayload extends ProtoAdapter<BsyncPayload> {
        public ProtoAdapter_BsyncPayload() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncPayload.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BsyncPayload decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.business(ProtoAdapter.INT32.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.consume_type(ConsumeType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.md5(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.data(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BsyncPayload r100) {
            return (((ProtoAdapter.INT32.encodedSizeWithTag(1, r100.business) + ConsumeType.ADAPTER.encodedSizeWithTag(2, r100.consume_type)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.f270531md5)) + ProtoAdapter.BYTES.encodedSizeWithTag(4, r100.data)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public BsyncPayload redact2(BsyncPayload r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BsyncPayload decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BsyncPayload r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BsyncPayload redact(BsyncPayload r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BsyncPayload r101) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.business);
            ConsumeType.ADAPTER.encodeWithTag(r100, 2, r101.consume_type);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.f270531md5);
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r101.data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BsyncPayload r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BsyncPayload();
        DEFAULT_BUSINESS = 0;
        DEFAULT_CONSUME_TYPE = ConsumeType.OneByOne;
        DEFAULT_DATA = ByteString.EMPTY;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L17;
        int r101 = ((unknownFields().hashCode() * 37) + this.business.hashCode()) * 37;
        ConsumeType r102 = this.consume_type;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this.f270531md5;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        ByteString r109 = this.data;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        int r110 = r108 + r103;
        this.hashCode = r110;
        return r110;
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L17:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.business = this.business;
        r100.consume_type = this.consume_type;
        r100.f270532md5 = this.f270531md5;
        r100.data = this.data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", business=");
        r100.append(this.business);
        if (this.consume_type == null) goto L6;
        r100.append(", consume_type=");
        r100.append(this.consume_type);
    L6:
        if (this.f270531md5 == null) goto L9;
        r100.append(", md5=");
        r100.append(this.f270531md5);
    L9:
        if (this.data == null) goto L11;
        r100.append(", data=");
        r100.append(this.data);
    L11:
        StringBuilder r101 = r100.replace(0, 2, "BsyncPayload{");
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
        if ((r100 instanceof BsyncPayload) == true) goto L8;
        return false;
    L8:
        BsyncPayload r101 = (BsyncPayload) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (this.business.equals(r101.business) == false) goto L19;
        if (Internal.equals(this.consume_type, r101.consume_type) == false) goto L19;
        if (Internal.equals(this.f270531md5, r101.f270531md5) == false) goto L19;
        if (Internal.equals(this.data, r101.data) == false) goto L19;
        return true;
    }

    public BsyncPayload(Integer r100, ConsumeType r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public BsyncPayload(Integer r100, ConsumeType r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.business = r100;
        this.consume_type = r101;
        this.f270531md5 = r102;
        this.data = r103;
    }
}
