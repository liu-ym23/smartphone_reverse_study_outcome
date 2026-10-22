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
public final class BotTipsContent extends com.squareup.wire.Message<BotTipsContent, Builder> {
    public static final ProtoAdapter<BotTipsContent> ADAPTER = null;
    public static final Long DEFAULT_ADMIN_ID = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Long madmin_id;
    public final Map<String, String> madmin_name;
    public final Map<String, String> mi18n_msg;
    public final Long mversion;

    public static final class Builder extends com.squareup.wire.Message.Builder<BotTipsContent, Builder> {
        public Long madmin_id;
        public Map<String, String> madmin_name;
        public Map<String, String> mi18n_msg;
        public Long mversion;

        @Override // com.squareup.wire.Message.Builder
        public BotTipsContent build() {
            return new BotTipsContent(this.mversion, this.mi18n_msg, this.madmin_id, this.madmin_name, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_msg = Internal.newMutableMap();
            this.madmin_name = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder admin_id(Long r100) {
            this.madmin_id = r100;
            return this;
        }

        public Builder admin_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.madmin_name = r100;
            return this;
        }

        public Builder i18n_msg(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_msg = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.mversion = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BotTipsContent extends ProtoAdapter<BotTipsContent> {
        private final ProtoAdapter<Map<String, String>> madmin_name;
        private final ProtoAdapter<Map<String, String>> mi18n_msg;

        public ProtoAdapter_BotTipsContent() {
            super(FieldEncoding.LENGTH_DELIMITED, BotTipsContent.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mi18n_msg = ProtoAdapter.newMapAdapter(r100, r100);
            this.madmin_name = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BotTipsContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mversion = 0L;
            r101.madmin_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mversion = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mi18n_msg.putAll(this.mi18n_msg.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.madmin_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.madmin_name.putAll(this.madmin_name.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BotTipsContent r100) {
            Long r101 = r100.mversion;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + this.mi18n_msg.encodedSizeWithTag(2, r100.mi18n_msg);
            Long r105 = r100.madmin_id;
            if (r105 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r105);
        L10:
            return ((r104 + r102) + this.madmin_name.encodedSizeWithTag(4, r100.madmin_name)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BotTipsContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BotTipsContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BotTipsContent r101) throws IOException {
            Long r102 = r101.mversion;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            this.mi18n_msg.encodeWithTag(r100, 2, r101.mi18n_msg);
            Long r103 = r101.madmin_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
        L8:
            this.madmin_name.encodeWithTag(r100, 4, r101.madmin_name);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BotTipsContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BotTipsContent();
        DEFAULT_VERSION = 0L;
        DEFAULT_ADMIN_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mversion = this.mversion;
        r100.mi18n_msg = Internal.copyOf("mi18n_msg", this.mi18n_msg);
        r100.madmin_id = this.madmin_id;
        r100.madmin_name = Internal.copyOf("madmin_name", this.madmin_name);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BotTipsContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public BotTipsContent(Long r100, Map<String, String> r101, Long r102, Map<String, String> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public BotTipsContent(Long r100, Map<String, String> r101, Long r102, Map<String, String> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mversion = r100;
        this.mi18n_msg = Internal.immutableCopyOf("mi18n_msg", r101);
        this.madmin_id = r102;
        this.madmin_name = Internal.immutableCopyOf("madmin_name", r103);
    }
}
