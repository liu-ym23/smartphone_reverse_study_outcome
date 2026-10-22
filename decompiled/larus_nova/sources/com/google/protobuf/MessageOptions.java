package com.google.protobuf;

import annotation.OptionsExt;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class MessageOptions extends com.squareup.wire.Message<MessageOptions, Builder> {
    public static final ProtoAdapter<MessageOptions> ADAPTER = null;
    public static final Boolean DEFAULT_DEPRECATED = null;
    public static final Boolean DEFAULT_MAP_ENTRY = null;
    public static final Boolean DEFAULT_MESSAGE_SET_WIRE_FORMAT = null;
    public static final Boolean DEFAULT_NO_STANDARD_DESCRIPTOR_ACCESSOR = null;
    private static final long serialVersionUID = 0;
    public final Boolean deprecated;
    public final Boolean map_entry;
    public final OptionsExt message_options;
    public final Boolean message_set_wire_format;
    public final Boolean no_standard_descriptor_accessor;
    public final List<UninterpretedOption> uninterpreted_option;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageOptions, Builder> {
        public Boolean deprecated;
        public Boolean map_entry;
        public OptionsExt message_options;
        public Boolean message_set_wire_format;
        public Boolean no_standard_descriptor_accessor;
        public List<UninterpretedOption> uninterpreted_option;

        @Override // com.squareup.wire.Message.Builder
        public MessageOptions build() {
            return new MessageOptions(this.message_set_wire_format, this.no_standard_descriptor_accessor, this.deprecated, this.map_entry, this.uninterpreted_option, this.message_options, super.buildUnknownFields());
        }

        public Builder() {
            this.uninterpreted_option = com.squareup.wire.internal.Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder deprecated(Boolean r100) {
            this.deprecated = r100;
            return this;
        }

        public Builder map_entry(Boolean r100) {
            this.map_entry = r100;
            return this;
        }

        public Builder message_options(OptionsExt r100) {
            this.message_options = r100;
            return this;
        }

        public Builder message_set_wire_format(Boolean r100) {
            this.message_set_wire_format = r100;
            return this;
        }

        public Builder no_standard_descriptor_accessor(Boolean r100) {
            this.no_standard_descriptor_accessor = r100;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.uninterpreted_option = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageOptions extends ProtoAdapter<MessageOptions> {
        public ProtoAdapter_MessageOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageOptions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageOptions decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.message_set_wire_format = r102;
            r101.no_standard_descriptor_accessor = r102;
            r101.deprecated = r102;
            r101.map_entry = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L24;
            if (r104 != 1) goto L8;
            r101.message_set_wire_format = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.no_standard_descriptor_accessor = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.deprecated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 7) goto L14;
            r101.map_entry = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r104 != 999) goto L16;
            r101.uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(r100));
            goto L3
        L16:
            if (r104 != 50001) goto L17;
            r101.message_options = OptionsExt.ADAPTER.decode(r100);
            goto L3
        L17:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MessageOptions r100) {
            Boolean r101 = r100.message_set_wire_format;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.no_standard_descriptor_accessor;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.deprecated;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.map_entry;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r110);
        L18:
            int r112 = (r109 + r111) + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, r100.uninterpreted_option);
            OptionsExt r113 = r100.message_options;
            if (r113 == null) goto L22;
            r102 = OptionsExt.ADAPTER.encodedSizeWithTag(TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessageOptions decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageOptions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageOptions r101) throws IOException {
            Boolean r102 = r101.message_set_wire_format;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.no_standard_descriptor_accessor;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.deprecated;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.map_entry;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r105);
        L14:
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(r100, 999, r101.uninterpreted_option);
            OptionsExt r106 = r101.message_options;
            if (r106 == null) goto L17;
            OptionsExt.ADAPTER.encodeWithTag(r100, TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageOptions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageOptions();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_MESSAGE_SET_WIRE_FORMAT = r100;
        DEFAULT_NO_STANDARD_DESCRIPTOR_ACCESSOR = r100;
        DEFAULT_DEPRECATED = r100;
        DEFAULT_MAP_ENTRY = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_set_wire_format = this.message_set_wire_format;
        r100.no_standard_descriptor_accessor = this.no_standard_descriptor_accessor;
        r100.deprecated = this.deprecated;
        r100.map_entry = this.map_entry;
        r100.uninterpreted_option = com.squareup.wire.internal.Internal.copyOf("uninterpreted_option", this.uninterpreted_option);
        r100.message_options = this.message_options;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageOptions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageOptions(Boolean r100, Boolean r110, Boolean r111, Boolean r112, List<UninterpretedOption> r113, OptionsExt r114) {
        this(r100, r110, r111, r112, r113, r114, okio.ByteString.EMPTY);
    }

    public MessageOptions(Boolean r100, Boolean r101, Boolean r102, Boolean r103, List<UninterpretedOption> r104, OptionsExt r105, okio.ByteString r106) {
        super(ADAPTER, r106);
        this.message_set_wire_format = r100;
        this.no_standard_descriptor_accessor = r101;
        this.deprecated = r102;
        this.map_entry = r103;
        this.uninterpreted_option = com.squareup.wire.internal.Internal.immutableCopyOf("uninterpreted_option", r104);
        this.message_options = r105;
    }
}
