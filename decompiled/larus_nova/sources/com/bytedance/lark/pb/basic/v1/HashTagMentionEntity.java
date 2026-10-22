package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class HashTagMentionEntity extends com.squareup.wire.Message<HashTagMentionEntity, Builder> {
    public static final ProtoAdapter<HashTagMentionEntity> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final MentionAction click_action;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253501id;
    public final MentionContent name;

    public static final class Builder extends com.squareup.wire.Message.Builder<HashTagMentionEntity, Builder> {
        public MentionAction click_action;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253502id;
        public MentionContent name;

        @Override // com.squareup.wire.Message.Builder
        public HashTagMentionEntity build() {
            return new HashTagMentionEntity(this.f253502id, this.name, this.click_action, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder click_action(MentionAction r100) {
            this.click_action = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253502id = r100;
            return this;
        }

        public Builder name(MentionContent r100) {
            this.name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HashTagMentionEntity extends ProtoAdapter<HashTagMentionEntity> {
        public ProtoAdapter_HashTagMentionEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, HashTagMentionEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public HashTagMentionEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253502id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.f253502id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.name = MentionContent.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.click_action = MentionAction.ADAPTER.decode(r100);
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
        public int encodedSize2(HashTagMentionEntity r100) {
            String r101 = r100.f253501id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            MentionContent r104 = r100.name;
            if (r104 == null) goto L9;
            int r105 = MentionContent.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            MentionAction r107 = r100.click_action;
            if (r107 == null) goto L14;
            r102 = MentionAction.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ HashTagMentionEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HashTagMentionEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HashTagMentionEntity r101) throws IOException {
            String r102 = r101.f253501id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            MentionContent r103 = r101.name;
            if (r103 == null) goto L8;
            MentionContent.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            MentionAction r104 = r101.click_action;
            if (r104 == null) goto L11;
            MentionAction.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HashTagMentionEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HashTagMentionEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253502id = this.f253501id;
        r100.name = this.name;
        r100.click_action = this.click_action;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HashTagMentionEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public HashTagMentionEntity(String r100, MentionContent r101, MentionAction r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public HashTagMentionEntity(String r100, MentionContent r101, MentionAction r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f253501id = r100;
        this.name = r101;
        this.click_action = r102;
    }
}
