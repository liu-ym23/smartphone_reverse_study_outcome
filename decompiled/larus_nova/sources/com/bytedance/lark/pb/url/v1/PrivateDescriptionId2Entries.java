package com.bytedance.lark.pb.url.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PrivateDescriptionId2Entries extends Message<PrivateDescriptionId2Entries, Builder> {
    public static final ProtoAdapter<PrivateDescriptionId2Entries> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, UrlPreviewEntries> entries;

    public static final class Builder extends Message.Builder<PrivateDescriptionId2Entries, Builder> {
        public Map<Long, UrlPreviewEntries> entries;

        @Override // com.squareup.wire.Message.Builder
        public PrivateDescriptionId2Entries build() {
            return new PrivateDescriptionId2Entries(this.entries, super.buildUnknownFields());
        }

        public Builder() {
            this.entries = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder entries(Map<Long, UrlPreviewEntries> r100) {
            Internal.checkElementsNotNull(r100);
            this.entries = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PrivateDescriptionId2Entries extends ProtoAdapter<PrivateDescriptionId2Entries> {
        private final ProtoAdapter<Map<Long, UrlPreviewEntries>> entries;

        public ProtoAdapter_PrivateDescriptionId2Entries() {
            super(FieldEncoding.LENGTH_DELIMITED, PrivateDescriptionId2Entries.class);
            this.entries = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, UrlPreviewEntries.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PrivateDescriptionId2Entries decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.entries.putAll(this.entries.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PrivateDescriptionId2Entries r100) {
            return this.entries.encodedSizeWithTag(1, r100.entries) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PrivateDescriptionId2Entries decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PrivateDescriptionId2Entries r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PrivateDescriptionId2Entries r101) throws IOException {
            this.entries.encodeWithTag(r100, 1, r101.entries);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PrivateDescriptionId2Entries r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PrivateDescriptionId2Entries();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.entries = Internal.copyOf("entries", this.entries);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PrivateDescriptionId2Entries.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PrivateDescriptionId2Entries(Map<Long, UrlPreviewEntries> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PrivateDescriptionId2Entries(Map<Long, UrlPreviewEntries> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.entries = Internal.immutableCopyOf("entries", r100);
    }
}
