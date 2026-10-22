package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class TranslateMessageDisplayRule extends com.squareup.wire.Message<TranslateMessageDisplayRule, Builder> {
    public static final ProtoAdapter<TranslateMessageDisplayRule> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DisplayRule mrule;

    public static final class Builder extends com.squareup.wire.Message.Builder<TranslateMessageDisplayRule, Builder> {
        public DisplayRule mrule;

        @Override // com.squareup.wire.Message.Builder
        public TranslateMessageDisplayRule build() {
            DisplayRule r100 = this.mrule;
            if (r100 == null) goto L7;
            return new TranslateMessageDisplayRule(this.mrule, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mrule"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder rule(DisplayRule r100) {
            this.mrule = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslateMessageDisplayRule extends ProtoAdapter<TranslateMessageDisplayRule> {
        public ProtoAdapter_TranslateMessageDisplayRule() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateMessageDisplayRule.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslateMessageDisplayRule decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.mrule = DisplayRule.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
        public int encodedSize2(TranslateMessageDisplayRule r100) {
            return DisplayRule.ADAPTER.encodedSizeWithTag(1, r100.mrule) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TranslateMessageDisplayRule decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslateMessageDisplayRule r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslateMessageDisplayRule r101) throws IOException {
            DisplayRule.ADAPTER.encodeWithTag(r100, 1, r101.mrule);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateMessageDisplayRule r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TranslateMessageDisplayRule();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mrule = this.mrule;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslateMessageDisplayRule.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslateMessageDisplayRule(DisplayRule r100) {
        this(r100, ByteString.EMPTY);
    }

    public TranslateMessageDisplayRule(DisplayRule r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mrule = r100;
    }
}
