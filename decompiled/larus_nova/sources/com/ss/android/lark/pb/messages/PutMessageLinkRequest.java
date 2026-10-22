package com.ss.android.lark.pb.messages;

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

/* JADX INFO: loaded from: classes37.dex */
public final class PutMessageLinkRequest extends Message<PutMessageLinkRequest, Builder> {
    public static final ProtoAdapter<PutMessageLinkRequest> ADAPTER = null;
    public static final Long DEFAULT_FROM_ID = null;
    private static final long serialVersionUID = 0;
    public final List<Long> mcopied_id;
    public final LinkFrom mfrom;
    public final Long mfrom_id;

    public static final class Builder extends Message.Builder<PutMessageLinkRequest, Builder> {
        public List<Long> mcopied_id;
        public LinkFrom mfrom;
        public Long mfrom_id;

        @Override // com.squareup.wire.Message.Builder
        public PutMessageLinkRequest build() {
            Long r100 = this.mfrom_id;
            if (r100 == null) goto L9;
            if (this.mfrom == null) goto L9;
            return new PutMessageLinkRequest(this.mfrom_id, this.mfrom, this.mcopied_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mfrom_id", this.mfrom, "mfrom"});
        }

        public Builder() {
            this.mcopied_id = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder copied_id(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mcopied_id = r100;
            return this;
        }

        public Builder from(LinkFrom r100) {
            this.mfrom = r100;
            return this;
        }

        public Builder from_id(Long r100) {
            this.mfrom_id = r100;
            return this;
        }
    }

    public static final enum LinkFrom extends Enum<LinkFrom> implements WireEnum {
        private static final /* synthetic */ LinkFrom[] $VALUES = null;
        public static final ProtoAdapter<LinkFrom> ADAPTER = null;
        public static final LinkFrom CHAT = null;
        public static final LinkFrom MESSAGE_THREAD = null;
        public static final LinkFrom THREAD = null;
        private final int value;

        static {
            LinkFrom r100 = new LinkFrom("CHAT", 0, 1);
            CHAT = r100;
            LinkFrom r101 = new LinkFrom("THREAD", 1, 2);
            THREAD = r101;
            LinkFrom r102 = new LinkFrom("MESSAGE_THREAD", 2, 3);
            MESSAGE_THREAD = r102;
            $VALUES = new LinkFrom[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(LinkFrom.class);
        }

        public static LinkFrom[] values() {
            return (LinkFrom[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static LinkFrom fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return MESSAGE_THREAD;
        L13:
            return THREAD;
        L15:
            return CHAT;
        }

        public static LinkFrom valueOf(String r100) {
            return (LinkFrom) a.a(LinkFrom.class, r100);
        }

        private LinkFrom(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_PutMessageLinkRequest extends ProtoAdapter<PutMessageLinkRequest> {
        public ProtoAdapter_PutMessageLinkRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutMessageLinkRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutMessageLinkRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mfrom_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mfrom_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mfrom = LinkFrom.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mcopied_id.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PutMessageLinkRequest r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            return ((r101.encodedSizeWithTag(1, r100.mfrom_id) + LinkFrom.ADAPTER.encodedSizeWithTag(2, r100.mfrom)) + r101.asRepeated().encodedSizeWithTag(3, r100.mcopied_id)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutMessageLinkRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutMessageLinkRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutMessageLinkRequest r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.mfrom_id);
            LinkFrom.ADAPTER.encodeWithTag(r100, 2, r101.mfrom);
            r102.asRepeated().encodeWithTag(r100, 3, r101.mcopied_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutMessageLinkRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutMessageLinkRequest();
        DEFAULT_FROM_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mfrom_id = this.mfrom_id;
        r100.mfrom = this.mfrom;
        r100.mcopied_id = Internal.copyOf("mcopied_id", this.mcopied_id);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutMessageLinkRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutMessageLinkRequest(Long r100, LinkFrom r101, List<Long> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PutMessageLinkRequest(Long r100, LinkFrom r101, List<Long> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mfrom_id = r100;
        this.mfrom = r101;
        this.mcopied_id = Internal.immutableCopyOf("mcopied_id", r102);
    }
}
