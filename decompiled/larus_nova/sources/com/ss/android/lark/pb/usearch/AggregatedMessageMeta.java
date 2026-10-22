package com.ss.android.lark.pb.usearch;

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
public final class AggregatedMessageMeta extends Message<AggregatedMessageMeta, Builder> {
    public static final ProtoAdapter<AggregatedMessageMeta> ADAPTER = null;
    public static final Integer DEFAULT_ALL_NUMBER = null;
    public static final String DEFAULT_CHATTER_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_FOLD = null;
    public static final Boolean DEFAULT_IS_P2P_CHAT = null;
    private static final long serialVersionUID = 0;
    public final Integer mall_number;
    public final String mchatter_id;
    public final String mid;
    public final Boolean mis_fold;
    public final Boolean mis_p2p_chat;
    public final List<SearchResult> mmessages;

    public static final class Builder extends Message.Builder<AggregatedMessageMeta, Builder> {
        public Integer mall_number;
        public String mchatter_id;
        public String mid;
        public Boolean mis_fold;
        public Boolean mis_p2p_chat;
        public List<SearchResult> mmessages;

        @Override // com.squareup.wire.Message.Builder
        public AggregatedMessageMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new AggregatedMessageMeta(this.mid, this.mall_number, this.mmessages, this.mchatter_id, this.mis_p2p_chat, this.mis_fold, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
            this.mmessages = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder all_number(Integer r100) {
            this.mall_number = r100;
            return this;
        }

        public Builder chatter_id(String r100) {
            this.mchatter_id = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder is_fold(Boolean r100) {
            this.mis_fold = r100;
            return this;
        }

        public Builder is_p2p_chat(Boolean r100) {
            this.mis_p2p_chat = r100;
            return this;
        }

        public Builder messages(List<SearchResult> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmessages = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AggregatedMessageMeta extends ProtoAdapter<AggregatedMessageMeta> {
        public ProtoAdapter_AggregatedMessageMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, AggregatedMessageMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AggregatedMessageMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mall_number = 0;
            r101.mchatter_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.mis_p2p_chat = r102;
            r101.mis_fold = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L13;
            switch(r104) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.mis_fold = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mis_p2p_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.mchatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mmessages.add(SearchResult.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.mall_number = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AggregatedMessageMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            Integer r103 = r100.mall_number;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r103);
        L6:
            int r106 = (r102 + r105) + SearchResult.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.mmessages);
            String r107 = r100.mchatter_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.mis_p2p_chat;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.mis_fold;
            if (r113 == null) goto L18;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r113);
        L18:
            return (r112 + r104) + r100.unknownFields().size();
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AggregatedMessageMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AggregatedMessageMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AggregatedMessageMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            Integer r103 = r101.mall_number;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L5:
            SearchResult.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.mmessages);
            String r104 = r101.mchatter_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            Boolean r105 = r101.mis_p2p_chat;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L11:
            Boolean r106 = r101.mis_fold;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AggregatedMessageMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AggregatedMessageMeta();
        DEFAULT_ALL_NUMBER = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_P2P_CHAT = r100;
        DEFAULT_IS_FOLD = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mall_number = this.mall_number;
        r100.mmessages = Internal.copyOf("mmessages", this.mmessages);
        r100.mchatter_id = this.mchatter_id;
        r100.mis_p2p_chat = this.mis_p2p_chat;
        r100.mis_fold = this.mis_fold;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AggregatedMessageMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AggregatedMessageMeta(String r100, Integer r110, List<SearchResult> r111, String r112, Boolean r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public AggregatedMessageMeta(String r100, Integer r101, List<SearchResult> r102, String r103, Boolean r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mid = r100;
        this.mall_number = r101;
        this.mmessages = Internal.immutableCopyOf("mmessages", r102);
        this.mchatter_id = r103;
        this.mis_p2p_chat = r104;
        this.mis_fold = r105;
    }
}
