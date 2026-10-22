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
public final class UpdateUserReactionSkinRequest extends Message<UpdateUserReactionSkinRequest, Builder> {
    public static final ProtoAdapter<UpdateUserReactionSkinRequest> ADAPTER = null;
    public static final ProtoAdapter_UpdateUserReactionSkinRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> reaction_to_skin_key;

    public static final class Builder extends Message.Builder<UpdateUserReactionSkinRequest, Builder> implements d<UpdateUserReactionSkinRequest> {
        public Map<String, String> reaction_to_skin_key;

        @Override // com.squareup.wire.Message.Builder
        public UpdateUserReactionSkinRequest build() {
            return new UpdateUserReactionSkinRequest(this.reaction_to_skin_key, super.buildUnknownFields());
        }

        public Builder() {
            this.reaction_to_skin_key = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder reaction_to_skin_key(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.reaction_to_skin_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateUserReactionSkinRequest extends ProtoAdapter<UpdateUserReactionSkinRequest> implements c<UpdateUserReactionSkinRequest> {
        private final ProtoAdapter<Map<String, String>> reaction_to_skin_key;

        public ProtoAdapter_UpdateUserReactionSkinRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateUserReactionSkinRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.reaction_to_skin_key = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateUserReactionSkinRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.reaction_to_skin_key.putAll(this.reaction_to_skin_key.decode(r100));
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
        public int encodedSize2(UpdateUserReactionSkinRequest r100) {
            return this.reaction_to_skin_key.encodedSizeWithTag(1, r100.reaction_to_skin_key) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateUserReactionSkinRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateUserReactionSkinRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateUserReactionSkinRequest r101) throws IOException {
            this.reaction_to_skin_key.encodeWithTag(r100, 1, r101.reaction_to_skin_key);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateUserReactionSkinRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateUserReactionSkinRequest r100 = new ProtoAdapter_UpdateUserReactionSkinRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.reaction_to_skin_key = Internal.copyOf("reaction_to_skin_key", this.reaction_to_skin_key);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateUserReactionSkinRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateUserReactionSkinRequest(Map<String, String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public UpdateUserReactionSkinRequest(Map<String, String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.reaction_to_skin_key = Internal.immutableCopyOf("reaction_to_skin_key", r100);
    }
}
