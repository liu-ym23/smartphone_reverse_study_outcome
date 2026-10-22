package com.google.protobuf.server;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes23.dex */
public final class MethodOptions extends Message<MethodOptions, Builder> {
    public static final ProtoAdapter<MethodOptions> ADAPTER = null;
    public static final Boolean DEFAULT_DEPRECATED = null;
    private static final long serialVersionUID = 0;
    public final Boolean mdeprecated;
    public final List<UninterpretedOption> muninterpreted_option;

    public static final class Builder extends Message.Builder<MethodOptions, Builder> {
        public Boolean mdeprecated;
        public List<UninterpretedOption> muninterpreted_option;

        @Override // com.squareup.wire.Message.Builder
        public MethodOptions build() {
            return new MethodOptions(this.mdeprecated, this.muninterpreted_option, super.buildUnknownFields());
        }

        public Builder() {
            this.muninterpreted_option = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder deprecated(Boolean r100) {
            this.mdeprecated = r100;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> r100) {
            Internal.checkElementsNotNull(r100);
            this.muninterpreted_option = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MethodOptions extends ProtoAdapter<MethodOptions> {
        public ProtoAdapter_MethodOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, MethodOptions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MethodOptions decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mdeprecated = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 33) goto L8;
            r101.mdeprecated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 999) goto L9;
            r101.muninterpreted_option.add(UninterpretedOption.ADAPTER.decode(r100));
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
        public int encodedSize2(MethodOptions r100) {
            Boolean r101 = r100.mdeprecated;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(33, r101);
        L7:
            return (r102 + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, r100.muninterpreted_option)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MethodOptions decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MethodOptions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MethodOptions r101) throws IOException {
            Boolean r102 = r101.mdeprecated;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 33, r102);
        L5:
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(r100, 999, r101.muninterpreted_option);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MethodOptions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MethodOptions();
        DEFAULT_DEPRECATED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mdeprecated = this.mdeprecated;
        r100.muninterpreted_option = Internal.copyOf("muninterpreted_option", this.muninterpreted_option);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MethodOptions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MethodOptions(Boolean r100, List<UninterpretedOption> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MethodOptions(Boolean r100, List<UninterpretedOption> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mdeprecated = r100;
        this.muninterpreted_option = Internal.immutableCopyOf("muninterpreted_option", r101);
    }
}
