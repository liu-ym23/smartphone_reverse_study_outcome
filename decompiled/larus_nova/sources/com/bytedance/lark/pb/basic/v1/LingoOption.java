package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class LingoOption extends com.squareup.wire.Message<LingoOption, Builder> {
    public static final ProtoAdapter<LingoOption> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> highlight_ignore_words;
    public final Map<String, String> pin_info;

    public static final class Builder extends com.squareup.wire.Message.Builder<LingoOption, Builder> {
        public List<String> highlight_ignore_words;
        public Map<String, String> pin_info;

        @Override // com.squareup.wire.Message.Builder
        public LingoOption build() {
            return new LingoOption(this.highlight_ignore_words, this.pin_info, super.buildUnknownFields());
        }

        public Builder() {
            this.highlight_ignore_words = Internal.newMutableList();
            this.pin_info = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder highlight_ignore_words(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.highlight_ignore_words = r100;
            return this;
        }

        public Builder pin_info(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.pin_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LingoOption extends ProtoAdapter<LingoOption> {
        private final ProtoAdapter<Map<String, String>> pin_info;

        public ProtoAdapter_LingoOption() {
            super(FieldEncoding.LENGTH_DELIMITED, LingoOption.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.pin_info = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LingoOption decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.highlight_ignore_words.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.pin_info.putAll(this.pin_info.decode(r100));
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
        public int encodedSize2(LingoOption r100) {
            return (ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.highlight_ignore_words) + this.pin_info.encodedSizeWithTag(2, r100.pin_info)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LingoOption decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LingoOption r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LingoOption r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.highlight_ignore_words);
            this.pin_info.encodeWithTag(r100, 2, r101.pin_info);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LingoOption r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LingoOption();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.highlight_ignore_words = Internal.copyOf("highlight_ignore_words", this.highlight_ignore_words);
        r100.pin_info = Internal.copyOf("pin_info", this.pin_info);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LingoOption.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public LingoOption(List<String> r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public LingoOption(List<String> r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.highlight_ignore_words = Internal.immutableCopyOf("highlight_ignore_words", r100);
        this.pin_info = Internal.immutableCopyOf("pin_info", r101);
    }
}
