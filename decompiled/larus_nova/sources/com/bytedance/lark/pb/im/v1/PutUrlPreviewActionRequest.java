package com.bytedance.lark.pb.im.v1;

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
public final class PutUrlPreviewActionRequest extends Message<PutUrlPreviewActionRequest, Builder> {
    public static final ProtoAdapter<PutUrlPreviewActionRequest> ADAPTER = null;
    public static final String DEFAULT_ACTION_ID = "";
    public static final String DEFAULT_PREVIEW_ID = "";
    public static final String DEFAULT_SOURCE_ID = "";
    public static final ProtoAdapter_PutUrlPreviewActionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String action_id;
    public final Map<String, String> parameters;
    public final String preview_id;
    public final String source_id;

    public static final class Builder extends Message.Builder<PutUrlPreviewActionRequest, Builder> implements d<PutUrlPreviewActionRequest> {
        public String action_id;
        public Map<String, String> parameters;
        public String preview_id;
        public String source_id;

        @Override // com.squareup.wire.Message.Builder
        public PutUrlPreviewActionRequest build() {
            String r100 = this.source_id;
            if (r100 == null) goto L11;
            if (this.preview_id == null) goto L11;
            if (this.action_id == null) goto L11;
            return new PutUrlPreviewActionRequest(this.source_id, this.preview_id, this.action_id, this.parameters, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "source_id", this.preview_id, "preview_id", this.action_id, "action_id"});
        }

        public Builder() {
            this.parameters = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_id(String r100) {
            this.action_id = r100;
            return this;
        }

        public Builder parameters(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.parameters = r100;
            return this;
        }

        public Builder preview_id(String r100) {
            this.preview_id = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutUrlPreviewActionRequest extends ProtoAdapter<PutUrlPreviewActionRequest> implements c<PutUrlPreviewActionRequest> {
        private final ProtoAdapter<Map<String, String>> parameters;

        public ProtoAdapter_PutUrlPreviewActionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutUrlPreviewActionRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.parameters = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutUrlPreviewActionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_id = "";
            r101.preview_id = "";
            r101.action_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.preview_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.action_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.parameters.putAll(this.parameters.decode(r100));
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
        public int encodedSize2(PutUrlPreviewActionRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.encodedSizeWithTag(1, r100.source_id) + r101.encodedSizeWithTag(2, r100.preview_id)) + r101.encodedSizeWithTag(3, r100.action_id)) + this.parameters.encodedSizeWithTag(4, r100.parameters)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutUrlPreviewActionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutUrlPreviewActionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutUrlPreviewActionRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.source_id);
            r102.encodeWithTag(r100, 2, r101.preview_id);
            r102.encodeWithTag(r100, 3, r101.action_id);
            this.parameters.encodeWithTag(r100, 4, r101.parameters);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutUrlPreviewActionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PutUrlPreviewActionRequest r100 = new ProtoAdapter_PutUrlPreviewActionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_id = this.source_id;
        r100.preview_id = this.preview_id;
        r100.action_id = this.action_id;
        r100.parameters = Internal.copyOf("parameters", this.parameters);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutUrlPreviewActionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutUrlPreviewActionRequest(String r100, String r101, String r102, Map<String, String> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PutUrlPreviewActionRequest(String r100, String r101, String r102, Map<String, String> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.source_id = r100;
        this.preview_id = r101;
        this.action_id = r102;
        this.parameters = Internal.immutableCopyOf("parameters", r103);
    }
}
