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
public final class EnumOptions extends com.squareup.wire.Message<EnumOptions, Builder> {
    public static final ProtoAdapter<EnumOptions> ADAPTER = null;
    public static final Boolean DEFAULT_ALLOW_ALIAS = null;
    public static final Boolean DEFAULT_DEPRECATED = null;
    private static final long serialVersionUID = 0;
    public final Boolean allow_alias;
    public final Boolean deprecated;
    public final OptionsExt enum_options;
    public final List<UninterpretedOption> uninterpreted_option;

    public static final class Builder extends com.squareup.wire.Message.Builder<EnumOptions, Builder> {
        public Boolean allow_alias;
        public Boolean deprecated;
        public OptionsExt enum_options;
        public List<UninterpretedOption> uninterpreted_option;

        @Override // com.squareup.wire.Message.Builder
        public EnumOptions build() {
            return new EnumOptions(this.allow_alias, this.deprecated, this.uninterpreted_option, this.enum_options, super.buildUnknownFields());
        }

        public Builder() {
            this.uninterpreted_option = com.squareup.wire.internal.Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder allow_alias(Boolean r100) {
            this.allow_alias = r100;
            return this;
        }

        public Builder deprecated(Boolean r100) {
            this.deprecated = r100;
            return this;
        }

        public Builder enum_options(OptionsExt r100) {
            this.enum_options = r100;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.uninterpreted_option = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EnumOptions extends ProtoAdapter<EnumOptions> {
        public ProtoAdapter_EnumOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, EnumOptions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EnumOptions decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.allow_alias = r102;
            r101.deprecated = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 2) goto L8;
            r101.allow_alias = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 3) goto L10;
            r101.deprecated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 999) goto L12;
            r101.uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r104 != 50002) goto L13;
            r101.enum_options = OptionsExt.ADAPTER.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EnumOptions r100) {
            Boolean r101 = r100.allow_alias;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r101);
        L6:
            Boolean r104 = r100.deprecated;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r104);
        L10:
            int r106 = (r103 + r105) + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, r100.uninterpreted_option);
            OptionsExt r107 = r100.enum_options;
            if (r107 == null) goto L14;
            r102 = OptionsExt.ADAPTER.encodedSizeWithTag(TTVideoEngineInterface.ALGO_OPTION_INT_STOP_TASK_END_PLAY, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EnumOptions decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EnumOptions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EnumOptions r101) throws IOException {
            Boolean r102 = r101.allow_alias;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.deprecated;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(r100, 999, r101.uninterpreted_option);
            OptionsExt r104 = r101.enum_options;
            if (r104 == null) goto L11;
            OptionsExt.ADAPTER.encodeWithTag(r100, TTVideoEngineInterface.ALGO_OPTION_INT_STOP_TASK_END_PLAY, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EnumOptions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EnumOptions();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_ALLOW_ALIAS = r100;
        DEFAULT_DEPRECATED = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.allow_alias = this.allow_alias;
        r100.deprecated = this.deprecated;
        r100.uninterpreted_option = com.squareup.wire.internal.Internal.copyOf("uninterpreted_option", this.uninterpreted_option);
        r100.enum_options = this.enum_options;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EnumOptions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EnumOptions(Boolean r100, Boolean r101, List<UninterpretedOption> r102, OptionsExt r110) {
        this(r100, r101, r102, r110, okio.ByteString.EMPTY);
    }

    public EnumOptions(Boolean r100, Boolean r101, List<UninterpretedOption> r102, OptionsExt r103, okio.ByteString r104) {
        super(ADAPTER, r104);
        this.allow_alias = r100;
        this.deprecated = r101;
        this.uninterpreted_option = com.squareup.wire.internal.Internal.immutableCopyOf("uninterpreted_option", r102);
        this.enum_options = r103;
    }
}
