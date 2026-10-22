package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class BannerSetting extends com.squareup.wire.Message<BannerSetting, Builder> {
    public static final ProtoAdapter<BannerSetting> ADAPTER = null;
    public static final Integer DEFAULT_CHAT_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_CHAT_THREAD_POSITION = null;
    private static final long serialVersionUID = 0;
    public final Integer chat_message_position;
    public final Integer chat_thread_position;
    public final Map<String, String> i18n_names;

    public static final class Builder extends com.squareup.wire.Message.Builder<BannerSetting, Builder> {
        public Integer chat_message_position;
        public Integer chat_thread_position;
        public Map<String, String> i18n_names;

        @Override // com.squareup.wire.Message.Builder
        public BannerSetting build() {
            return new BannerSetting(this.chat_message_position, this.chat_thread_position, this.i18n_names, super.buildUnknownFields());
        }

        public Builder() {
            this.i18n_names = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder chat_message_position(Integer r100) {
            this.chat_message_position = r100;
            return this;
        }

        public Builder chat_thread_position(Integer r100) {
            this.chat_thread_position = r100;
            return this;
        }

        public Builder i18n_names(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.i18n_names = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerSetting extends ProtoAdapter<BannerSetting> {
        private final ProtoAdapter<Map<String, String>> i18n_names;

        public ProtoAdapter_BannerSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerSetting.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.i18n_names = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BannerSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_message_position = 0;
            r101.chat_thread_position = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chat_thread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.i18n_names.putAll(this.i18n_names.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BannerSetting r100) {
            Integer r101 = r100.chat_message_position;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.chat_thread_position;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + this.i18n_names.encodedSizeWithTag(3, r100.i18n_names)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BannerSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BannerSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BannerSetting r101) throws IOException {
            Integer r102 = r101.chat_message_position;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.chat_thread_position;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            this.i18n_names.encodeWithTag(r100, 3, r101.i18n_names);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerSetting();
        DEFAULT_CHAT_MESSAGE_POSITION = 0;
        DEFAULT_CHAT_THREAD_POSITION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_message_position = this.chat_message_position;
        r100.chat_thread_position = this.chat_thread_position;
        r100.i18n_names = Internal.copyOf("i18n_names", this.i18n_names);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BannerSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public BannerSetting(Integer r100, Integer r101, Map<String, String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public BannerSetting(Integer r100, Integer r101, Map<String, String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_message_position = r100;
        this.chat_thread_position = r101;
        this.i18n_names = Internal.immutableCopyOf("i18n_names", r102);
    }
}
