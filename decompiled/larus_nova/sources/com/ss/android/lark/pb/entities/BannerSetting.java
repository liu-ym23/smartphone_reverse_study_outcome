package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BannerSetting extends com.squareup.wire.Message<BannerSetting, Builder> {
    public static final ProtoAdapter<BannerSetting> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Integer DEFAULT_CHAT_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_CHAT_THREAD_POSITION = null;
    public static final Boolean DEFAULT_CLEAN_HISTORY_MESSAGE = null;
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final Integer mchat_message_position;
    public final Integer mchat_thread_position;
    public final Boolean mclean_history_message;
    public final Map<String, String> mi18n_names;

    public static final class Builder extends com.squareup.wire.Message.Builder<BannerSetting, Builder> {
        public Long mchat_id;
        public Integer mchat_message_position;
        public Integer mchat_thread_position;
        public Boolean mclean_history_message;
        public Map<String, String> mi18n_names;

        @Override // com.squareup.wire.Message.Builder
        public BannerSetting build() {
            Long r100 = this.mchat_id;
            if (r100 == null) goto L7;
            return new BannerSetting(this.mchat_id, this.mchat_message_position, this.mchat_thread_position, this.mi18n_names, this.mclean_history_message, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mchat_id"});
        }

        public Builder() {
            this.mi18n_names = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder chat_message_position(Integer r100) {
            this.mchat_message_position = r100;
            return this;
        }

        public Builder chat_thread_position(Integer r100) {
            this.mchat_thread_position = r100;
            return this;
        }

        public Builder clean_history_message(Boolean r100) {
            this.mclean_history_message = r100;
            return this;
        }

        public Builder i18n_names(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_names = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerSetting extends ProtoAdapter<BannerSetting> {
        private final ProtoAdapter<Map<String, String>> mi18n_names;

        public ProtoAdapter_BannerSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerSetting.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mi18n_names = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BannerSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchat_id = 0L;
            r101.mchat_message_position = 0;
            r101.mchat_thread_position = 0;
            r101.mclean_history_message = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mchat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mchat_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mchat_thread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mi18n_names.putAll(this.mi18n_names.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mclean_history_message = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BannerSetting r100) {
            int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.mchat_id);
            Integer r102 = r100.mchat_message_position;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Integer r106 = r100.mchat_thread_position;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.INT32.encodedSizeWithTag(3, r106);
        L10:
            int r108 = (r105 + r107) + this.mi18n_names.encodedSizeWithTag(4, r100.mi18n_names);
            Boolean r109 = r100.mclean_history_message;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
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
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.mchat_id);
            Integer r102 = r101.mchat_message_position;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            Integer r103 = r101.mchat_thread_position;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L8:
            this.mi18n_names.encodeWithTag(r100, 4, r101.mi18n_names);
            Boolean r104 = r101.mclean_history_message;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerSetting();
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_CHAT_MESSAGE_POSITION = 0;
        DEFAULT_CHAT_THREAD_POSITION = 0;
        DEFAULT_CLEAN_HISTORY_MESSAGE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_id = this.mchat_id;
        r100.mchat_message_position = this.mchat_message_position;
        r100.mchat_thread_position = this.mchat_thread_position;
        r100.mi18n_names = Internal.copyOf("mi18n_names", this.mi18n_names);
        r100.mclean_history_message = this.mclean_history_message;
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

    public BannerSetting(Long r100, Integer r101, Integer r110, Map<String, String> r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public BannerSetting(Long r100, Integer r101, Integer r102, Map<String, String> r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mchat_id = r100;
        this.mchat_message_position = r101;
        this.mchat_thread_position = r102;
        this.mi18n_names = Internal.immutableCopyOf("mi18n_names", r103);
        this.mclean_history_message = r104;
    }
}
