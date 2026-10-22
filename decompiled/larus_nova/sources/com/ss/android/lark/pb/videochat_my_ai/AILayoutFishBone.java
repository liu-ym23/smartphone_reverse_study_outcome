package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class AILayoutFishBone extends Message<AILayoutFishBone, Builder> {
    public static final ProtoAdapter<AILayoutFishBone> ADAPTER = null;
    public static final Integer DEFAULT_FISH_BONE_VERSION = null;
    public static final Integer DEFAULT_SUMMARY_VERSION = null;
    public static final Integer DEFAULT_TOPIC_VERSION = null;
    private static final long serialVersionUID = 0;
    public final List<AILayoutFishBoneItem> mfish_bone_items;
    public final Integer mfish_bone_version;
    public final Integer msummary_version;
    public final List<AILayoutTopicItem> mtopic_items;
    public final Integer mtopic_version;

    public static final class Builder extends Message.Builder<AILayoutFishBone, Builder> {
        public List<AILayoutFishBoneItem> mfish_bone_items;
        public Integer mfish_bone_version;
        public Integer msummary_version;
        public List<AILayoutTopicItem> mtopic_items;
        public Integer mtopic_version;

        @Override // com.squareup.wire.Message.Builder
        public AILayoutFishBone build() {
            return new AILayoutFishBone(this.mfish_bone_items, this.mtopic_items, this.mfish_bone_version, this.msummary_version, this.mtopic_version, super.buildUnknownFields());
        }

        public Builder() {
            this.mfish_bone_items = Internal.newMutableList();
            this.mtopic_items = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder fish_bone_items(List<AILayoutFishBoneItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfish_bone_items = r100;
            return this;
        }

        public Builder fish_bone_version(Integer r100) {
            this.mfish_bone_version = r100;
            return this;
        }

        public Builder summary_version(Integer r100) {
            this.msummary_version = r100;
            return this;
        }

        public Builder topic_items(List<AILayoutTopicItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtopic_items = r100;
            return this;
        }

        public Builder topic_version(Integer r100) {
            this.mtopic_version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AILayoutFishBone extends ProtoAdapter<AILayoutFishBone> {
        public ProtoAdapter_AILayoutFishBone() {
            super(FieldEncoding.LENGTH_DELIMITED, AILayoutFishBone.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AILayoutFishBone decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mfish_bone_version = 0;
            r101.msummary_version = 0;
            r101.mtopic_version = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mfish_bone_items.add(AILayoutFishBoneItem.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtopic_items.add(AILayoutTopicItem.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mfish_bone_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.msummary_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mtopic_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AILayoutFishBone r100) {
            int r101 = AILayoutFishBoneItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mfish_bone_items) + AILayoutTopicItem.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mtopic_items);
            Integer r102 = r100.mfish_bone_version;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            Integer r106 = r100.msummary_version;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.INT32.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            Integer r109 = r100.mtopic_version;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.INT32.encodedSizeWithTag(5, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AILayoutFishBone decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AILayoutFishBone r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AILayoutFishBone r101) throws IOException {
            AILayoutFishBoneItem.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mfish_bone_items);
            AILayoutTopicItem.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mtopic_items);
            Integer r102 = r101.mfish_bone_version;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r102);
        L5:
            Integer r103 = r101.msummary_version;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r103);
        L8:
            Integer r104 = r101.mtopic_version;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AILayoutFishBone r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AILayoutFishBone();
        DEFAULT_FISH_BONE_VERSION = 0;
        DEFAULT_SUMMARY_VERSION = 0;
        DEFAULT_TOPIC_VERSION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mfish_bone_items = Internal.copyOf("mfish_bone_items", this.mfish_bone_items);
        r100.mtopic_items = Internal.copyOf("mtopic_items", this.mtopic_items);
        r100.mfish_bone_version = this.mfish_bone_version;
        r100.msummary_version = this.msummary_version;
        r100.mtopic_version = this.mtopic_version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AILayoutFishBone.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AILayoutFishBone(List<AILayoutFishBoneItem> r100, List<AILayoutTopicItem> r101, Integer r110, Integer r111, Integer r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public AILayoutFishBone(List<AILayoutFishBoneItem> r100, List<AILayoutTopicItem> r101, Integer r102, Integer r103, Integer r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mfish_bone_items = Internal.immutableCopyOf("mfish_bone_items", r100);
        this.mtopic_items = Internal.immutableCopyOf("mtopic_items", r101);
        this.mfish_bone_version = r102;
        this.msummary_version = r103;
        this.mtopic_version = r104;
    }
}
