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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushUrlPreviews extends Message<PushUrlPreviews, Builder> {
    public static final ProtoAdapter<PushUrlPreviews> ADAPTER = null;
    public static final ProtoAdapter_PushUrlPreviews RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, PrivateDescriptionId2Entries> url_preview_entries;

    public static final class Builder extends Message.Builder<PushUrlPreviews, Builder> implements d<PushUrlPreviews> {
        public Map<String, PrivateDescriptionId2Entries> url_preview_entries;

        @Override // com.squareup.wire.Message.Builder
        public PushUrlPreviews build() {
            return new PushUrlPreviews(this.url_preview_entries, super.buildUnknownFields());
        }

        public Builder() {
            this.url_preview_entries = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder url_preview_entries(Map<String, PrivateDescriptionId2Entries> r100) {
            Internal.checkElementsNotNull(r100);
            this.url_preview_entries = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushUrlPreviews extends ProtoAdapter<PushUrlPreviews> implements c<PushUrlPreviews> {
        private final ProtoAdapter<Map<String, PrivateDescriptionId2Entries>> url_preview_entries;

        public ProtoAdapter_PushUrlPreviews() {
            super(FieldEncoding.LENGTH_DELIMITED, PushUrlPreviews.class);
            this.url_preview_entries = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, PrivateDescriptionId2Entries.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushUrlPreviews decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.url_preview_entries.putAll(this.url_preview_entries.decode(r100));
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
        public int encodedSize2(PushUrlPreviews r100) {
            return this.url_preview_entries.encodedSizeWithTag(1, r100.url_preview_entries) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushUrlPreviews decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushUrlPreviews r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushUrlPreviews r101) throws IOException {
            this.url_preview_entries.encodeWithTag(r100, 1, r101.url_preview_entries);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushUrlPreviews r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushUrlPreviews r100 = new ProtoAdapter_PushUrlPreviews();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url_preview_entries = Internal.copyOf("url_preview_entries", this.url_preview_entries);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushUrlPreviews.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushUrlPreviews(Map<String, PrivateDescriptionId2Entries> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushUrlPreviews(Map<String, PrivateDescriptionId2Entries> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.url_preview_entries = Internal.immutableCopyOf("url_preview_entries", r100);
    }
}
