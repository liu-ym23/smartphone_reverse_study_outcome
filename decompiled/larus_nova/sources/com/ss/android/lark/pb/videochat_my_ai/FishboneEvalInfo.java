package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class FishboneEvalInfo extends Message<FishboneEvalInfo, Builder> {
    public static final ProtoAdapter<FishboneEvalInfo> ADAPTER = null;
    public static final Integer DEFAULT_SUBTITLE_TOKENS = null;
    private static final long serialVersionUID = 0;
    public final AILayoutFishBone mfish_bone;
    public final Integer msubtitle_tokens;

    public static final class Builder extends Message.Builder<FishboneEvalInfo, Builder> {
        public AILayoutFishBone mfish_bone;
        public Integer msubtitle_tokens;

        @Override // com.squareup.wire.Message.Builder
        public FishboneEvalInfo build() {
            return new FishboneEvalInfo(this.msubtitle_tokens, this.mfish_bone, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder fish_bone(AILayoutFishBone r100) {
            this.mfish_bone = r100;
            return this;
        }

        public Builder subtitle_tokens(Integer r100) {
            this.msubtitle_tokens = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FishboneEvalInfo extends ProtoAdapter<FishboneEvalInfo> {
        public ProtoAdapter_FishboneEvalInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, FishboneEvalInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FishboneEvalInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msubtitle_tokens = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.msubtitle_tokens = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mfish_bone = AILayoutFishBone.ADAPTER.decode(r100);
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
        public int encodedSize2(FishboneEvalInfo r100) {
            Integer r101 = r100.msubtitle_tokens;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            AILayoutFishBone r104 = r100.mfish_bone;
            if (r104 == null) goto L10;
            r102 = AILayoutFishBone.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FishboneEvalInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FishboneEvalInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FishboneEvalInfo r101) throws IOException {
            Integer r102 = r101.msubtitle_tokens;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            AILayoutFishBone r103 = r101.mfish_bone;
            if (r103 == null) goto L8;
            AILayoutFishBone.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FishboneEvalInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FishboneEvalInfo();
        DEFAULT_SUBTITLE_TOKENS = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msubtitle_tokens = this.msubtitle_tokens;
        r100.mfish_bone = this.mfish_bone;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FishboneEvalInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FishboneEvalInfo(Integer r100, AILayoutFishBone r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FishboneEvalInfo(Integer r100, AILayoutFishBone r101, ByteString r102) {
        super(ADAPTER, r102);
        this.msubtitle_tokens = r100;
        this.mfish_bone = r101;
    }
}
