package com.bytedance.lark.pb.im.v1;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.lark.pb.basic.v1.UrlPreviewAction;
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
public final class PutUrlPreviewActionResponse extends Message<PutUrlPreviewActionResponse, Builder> {
    public static final ProtoAdapter<PutUrlPreviewActionResponse> ADAPTER = null;
    public static final ProtoAdapter_PutUrlPreviewActionResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, UrlPreviewAction> actions;

    public static final class Builder extends Message.Builder<PutUrlPreviewActionResponse, Builder> implements d<PutUrlPreviewActionResponse> {
        public Map<String, UrlPreviewAction> actions;

        @Override // com.squareup.wire.Message.Builder
        public PutUrlPreviewActionResponse build() {
            return new PutUrlPreviewActionResponse(this.actions, super.buildUnknownFields());
        }

        public Builder() {
            this.actions = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder actions(Map<String, UrlPreviewAction> r100) {
            Internal.checkElementsNotNull(r100);
            this.actions = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutUrlPreviewActionResponse extends ProtoAdapter<PutUrlPreviewActionResponse> implements c<PutUrlPreviewActionResponse> {
        private final ProtoAdapter<Map<String, UrlPreviewAction>> actions;

        public ProtoAdapter_PutUrlPreviewActionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutUrlPreviewActionResponse.class);
            this.actions = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, UrlPreviewAction.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutUrlPreviewActionResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.actions.putAll(this.actions.decode(r100));
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
        public int encodedSize2(PutUrlPreviewActionResponse r100) {
            return this.actions.encodedSizeWithTag(1, r100.actions) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutUrlPreviewActionResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutUrlPreviewActionResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutUrlPreviewActionResponse r101) throws IOException {
            this.actions.encodeWithTag(r100, 1, r101.actions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutUrlPreviewActionResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PutUrlPreviewActionResponse r100 = new ProtoAdapter_PutUrlPreviewActionResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.actions = Internal.copyOf(SlcCommonAction.KEY_ACTIONS, this.actions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutUrlPreviewActionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutUrlPreviewActionResponse(Map<String, UrlPreviewAction> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PutUrlPreviewActionResponse(Map<String, UrlPreviewAction> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.actions = Internal.immutableCopyOf(SlcCommonAction.KEY_ACTIONS, r100);
    }
}
