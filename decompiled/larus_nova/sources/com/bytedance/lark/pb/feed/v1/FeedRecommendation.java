package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class FeedRecommendation extends Message<FeedRecommendation, Builder> {
    public static final ProtoAdapter<FeedRecommendation> ADAPTER = null;
    public static final String DEFAULT_IMPR_ID = "";
    public static final Boolean DEFAULT_IS_NEW_BOX = null;
    public static final String DEFAULT_SCENE = "";
    private static final long serialVersionUID = 0;
    public final String impr_id;
    public final Boolean is_new_box;
    public final String scene;

    public static final class Builder extends Message.Builder<FeedRecommendation, Builder> {
        public String impr_id;
        public Boolean is_new_box;
        public String scene;

        @Override // com.squareup.wire.Message.Builder
        public FeedRecommendation build() {
            return new FeedRecommendation(this.impr_id, this.scene, this.is_new_box, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder impr_id(String r100) {
            this.impr_id = r100;
            return this;
        }

        public Builder is_new_box(Boolean r100) {
            this.is_new_box = r100;
            return this;
        }

        public Builder scene(String r100) {
            this.scene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedRecommendation extends ProtoAdapter<FeedRecommendation> {
        public ProtoAdapter_FeedRecommendation() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedRecommendation.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedRecommendation decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.impr_id = "";
            r101.scene = "";
            r101.is_new_box = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.impr_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.scene = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.is_new_box = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(FeedRecommendation r100) {
            String r101 = r100.impr_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.scene;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_new_box;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedRecommendation decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedRecommendation r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedRecommendation r101) throws IOException {
            String r102 = r101.impr_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.scene;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_new_box;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedRecommendation r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedRecommendation();
        DEFAULT_IS_NEW_BOX = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.impr_id = this.impr_id;
        r100.scene = this.scene;
        r100.is_new_box = this.is_new_box;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedRecommendation.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedRecommendation(String r100, String r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FeedRecommendation(String r100, String r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.impr_id = r100;
        this.scene = r101;
        this.is_new_box = r102;
    }
}
