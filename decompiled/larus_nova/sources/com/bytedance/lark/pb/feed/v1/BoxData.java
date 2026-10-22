package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class BoxData extends Message<BoxData, Builder> {
    public static final ProtoAdapter<BoxData> ADAPTER = null;
    public static final Integer DEFAULT_CHATTER_APPLY_COUNT = null;
    public static final Long DEFAULT_DISPLAY_TIME = null;
    public static final Boolean DEFAULT_HAS_FOCUS = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Boolean DEFAULT_IS_SHORTCUT = null;
    public static final String DEFAULT_LOCALIZED_DIGEST_MESSAGE = "";
    public static final Long DEFAULT_RANK_TIME = null;
    public static final Integer DEFAULT_UNREAD_COUNT = null;
    private static final long serialVersionUID = 0;
    public final AtInfo at_info;
    public final List<AtInfo> at_infos;
    public final Integer chatter_apply_count;
    public final Digest digest;
    public final Long display_time;
    public final Boolean has_focus;
    public final Boolean is_remind;
    public final Boolean is_shortcut;
    public final String localized_digest_message;
    public final Long rank_time;
    public final Integer unread_count;

    public static final class Builder extends Message.Builder<BoxData, Builder> {
        public AtInfo at_info;
        public List<AtInfo> at_infos;
        public Integer chatter_apply_count;
        public Digest digest;
        public Long display_time;
        public Boolean has_focus;
        public Boolean is_remind;
        public Boolean is_shortcut;
        public String localized_digest_message;
        public Long rank_time;
        public Integer unread_count;

        @Override // com.squareup.wire.Message.Builder
        public BoxData build() {
            Boolean r100 = this.is_remind;
            if (r100 == null) goto L7;
            return new BoxData(this.is_remind, this.rank_time, this.is_shortcut, this.unread_count, this.display_time, this.localized_digest_message, this.at_info, this.at_infos, this.has_focus, this.digest, this.chatter_apply_count, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "is_remind"});
        }

        public Builder() {
            this.at_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder at_info(AtInfo r100) {
            this.at_info = r100;
            return this;
        }

        public Builder at_infos(List<AtInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.at_infos = r100;
            return this;
        }

        public Builder chatter_apply_count(Integer r100) {
            this.chatter_apply_count = r100;
            return this;
        }

        public Builder digest(Digest r100) {
            this.digest = r100;
            return this;
        }

        public Builder display_time(Long r100) {
            this.display_time = r100;
            return this;
        }

        public Builder has_focus(Boolean r100) {
            this.has_focus = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.is_remind = r100;
            return this;
        }

        public Builder is_shortcut(Boolean r100) {
            this.is_shortcut = r100;
            return this;
        }

        public Builder localized_digest_message(String r100) {
            this.localized_digest_message = r100;
            return this;
        }

        public Builder rank_time(Long r100) {
            this.rank_time = r100;
            return this;
        }

        public Builder unread_count(Integer r100) {
            this.unread_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BoxData extends ProtoAdapter<BoxData> {
        public ProtoAdapter_BoxData() {
            super(FieldEncoding.LENGTH_DELIMITED, BoxData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BoxData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_remind = r102;
            r101.rank_time = 0L;
            r101.is_shortcut = r102;
            r101.unread_count = 0;
            r101.display_time = 0L;
            r101.localized_digest_message = "";
            r101.has_focus = r102;
            r101.chatter_apply_count = 0;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            switch(r104) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L6;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r101.chatter_apply_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.digest = Digest.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.has_focus = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.at_infos.add(AtInfo.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.at_info = AtInfo.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.localized_digest_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.display_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.unread_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.is_shortcut = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BoxData r100) {
            ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
            int r102 = r101.encodedSizeWithTag(1, r100.is_remind);
            Long r103 = r100.rank_time;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.is_shortcut;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Integer r110 = r100.unread_count;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            Long r113 = r100.display_time;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.localized_digest_message;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(7, r116);
        L22:
            int r118 = r115 + r117;
            AtInfo r119 = r100.at_info;
            if (r119 == null) goto L25;
            int r120 = AtInfo.ADAPTER.encodedSizeWithTag(8, r119);
        L26:
            int r121 = (r118 + r120) + AtInfo.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.at_infos);
            Boolean r122 = r100.has_focus;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(10, r122);
        L30:
            int r124 = r121 + r123;
            Digest r125 = r100.digest;
            if (r125 == null) goto L33;
            int r126 = Digest.ADAPTER.encodedSizeWithTag(11, r125);
        L34:
            int r127 = r124 + r126;
            Integer r128 = r100.chatter_apply_count;
            if (r128 == null) goto L38;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(12, r128);
        L38:
            return (r127 + r104) + r100.unknownFields().size();
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ BoxData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BoxData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BoxData r101) throws IOException {
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 1, r101.is_remind);
            Long r103 = r101.rank_time;
            if (r103 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L5:
            Boolean r104 = r101.is_shortcut;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            Integer r105 = r101.unread_count;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r105);
        L11:
            Long r106 = r101.display_time;
            if (r106 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r106);
        L14:
            String r107 = r101.localized_digest_message;
            if (r107 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
        L17:
            AtInfo r108 = r101.at_info;
            if (r108 == null) goto L20;
            AtInfo.ADAPTER.encodeWithTag(r100, 8, r108);
        L20:
            AtInfo.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.at_infos);
            Boolean r109 = r101.has_focus;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 10, r109);
        L23:
            Digest r110 = r101.digest;
            if (r110 == null) goto L26;
            Digest.ADAPTER.encodeWithTag(r100, 11, r110);
        L26:
            Integer r111 = r101.chatter_apply_count;
            if (r111 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r100, 12, r111);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BoxData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BoxData();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_REMIND = r100;
        DEFAULT_RANK_TIME = 0L;
        DEFAULT_IS_SHORTCUT = r100;
        DEFAULT_UNREAD_COUNT = 0;
        DEFAULT_DISPLAY_TIME = 0L;
        DEFAULT_HAS_FOCUS = r100;
        DEFAULT_CHATTER_APPLY_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_remind = this.is_remind;
        r100.rank_time = this.rank_time;
        r100.is_shortcut = this.is_shortcut;
        r100.unread_count = this.unread_count;
        r100.display_time = this.display_time;
        r100.localized_digest_message = this.localized_digest_message;
        r100.at_info = this.at_info;
        r100.at_infos = Internal.copyOf("at_infos", this.at_infos);
        r100.has_focus = this.has_focus;
        r100.digest = this.digest;
        r100.chatter_apply_count = this.chatter_apply_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BoxData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BoxData(Boolean r110, Long r111, Boolean r112, Integer r113, Long r114, String r115, AtInfo r210, List<AtInfo> r211, Boolean r212, Digest r213, Integer r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public BoxData(Boolean r100, Long r101, Boolean r102, Integer r103, Long r104, String r105, AtInfo r106, List<AtInfo> r107, Boolean r110, Digest r111, Integer r112, ByteString r113) {
        super(ADAPTER, r113);
        this.is_remind = r100;
        this.rank_time = r101;
        this.is_shortcut = r102;
        this.unread_count = r103;
        this.display_time = r104;
        this.localized_digest_message = r105;
        this.at_info = r106;
        this.at_infos = Internal.immutableCopyOf("at_infos", r107);
        this.has_focus = r110;
        this.digest = r111;
        this.chatter_apply_count = r112;
    }
}
