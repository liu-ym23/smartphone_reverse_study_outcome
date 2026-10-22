package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class TipsContent extends com.squareup.wire.Message<TipsContent, Builder> {
    public static final ProtoAdapter<TipsContent> ADAPTER = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final List<ActionInfo> mactions;
    public final Map<String, String> mi18n_msg;
    public final Map<String, String> mi18n_title;
    public final Long mversion;

    public static final class Builder extends com.squareup.wire.Message.Builder<TipsContent, Builder> {
        public List<ActionInfo> mactions;
        public Map<String, String> mi18n_msg;
        public Map<String, String> mi18n_title;
        public Long mversion;

        @Override // com.squareup.wire.Message.Builder
        public TipsContent build() {
            return new TipsContent(this.mversion, this.mi18n_title, this.mi18n_msg, this.mactions, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_title = Internal.newMutableMap();
            this.mi18n_msg = Internal.newMutableMap();
            this.mactions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder actions(List<ActionInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mactions = r100;
            return this;
        }

        public Builder i18n_msg(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_msg = r100;
            return this;
        }

        public Builder i18n_title(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_title = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.mversion = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TipsContent extends ProtoAdapter<TipsContent> {
        private final ProtoAdapter<Map<String, String>> mi18n_msg;
        private final ProtoAdapter<Map<String, String>> mi18n_title;

        public ProtoAdapter_TipsContent() {
            super(FieldEncoding.LENGTH_DELIMITED, TipsContent.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mi18n_title = ProtoAdapter.newMapAdapter(r100, r100);
            this.mi18n_msg = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TipsContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mversion = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mversion = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mi18n_title.putAll(this.mi18n_title.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mi18n_msg.putAll(this.mi18n_msg.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mactions.add(ActionInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(TipsContent r100) {
            Long r101 = r100.mversion;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L7:
            return (((r102 + this.mi18n_title.encodedSizeWithTag(2, r100.mi18n_title)) + this.mi18n_msg.encodedSizeWithTag(3, r100.mi18n_msg)) + ActionInfo.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mactions)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TipsContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TipsContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TipsContent r101) throws IOException {
            Long r102 = r101.mversion;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            this.mi18n_title.encodeWithTag(r100, 2, r101.mi18n_title);
            this.mi18n_msg.encodeWithTag(r100, 3, r101.mi18n_msg);
            ActionInfo.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mactions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TipsContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TipsContent();
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mversion = this.mversion;
        r100.mi18n_title = Internal.copyOf("mi18n_title", this.mi18n_title);
        r100.mi18n_msg = Internal.copyOf("mi18n_msg", this.mi18n_msg);
        r100.mactions = Internal.copyOf("mactions", this.mactions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TipsContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TipsContent(Long r100, Map<String, String> r101, Map<String, String> r102, List<ActionInfo> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TipsContent(Long r100, Map<String, String> r101, Map<String, String> r102, List<ActionInfo> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mversion = r100;
        this.mi18n_title = Internal.immutableCopyOf("mi18n_title", r101);
        this.mi18n_msg = Internal.immutableCopyOf("mi18n_msg", r102);
        this.mactions = Internal.immutableCopyOf("mactions", r103);
    }
}
