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
public final class CustomSummaryItem extends Message<CustomSummaryItem, Builder> {
    public static final ProtoAdapter<CustomSummaryItem> ADAPTER = null;
    public static final Boolean DEFAULT_IS_FINAL = null;
    private static final long serialVersionUID = 0;
    public final CustomSubType mcustom_sub_type;
    public final List<CustomSummaryGoldenSentences> mgolden_sentences;
    public final Boolean mis_final;
    public final CustomSummaryKeypoint mkey_point;
    public final List<CustomSummaryMyTodo> mmy_todo;
    public final CustomSummarySelfPerformance mself_performance;
    public final List<CustomSummarySpeakerSummary> mspeaker_summary;

    public static final class Builder extends Message.Builder<CustomSummaryItem, Builder> {
        public CustomSubType mcustom_sub_type;
        public List<CustomSummaryGoldenSentences> mgolden_sentences;
        public Boolean mis_final;
        public CustomSummaryKeypoint mkey_point;
        public List<CustomSummaryMyTodo> mmy_todo;
        public CustomSummarySelfPerformance mself_performance;
        public List<CustomSummarySpeakerSummary> mspeaker_summary;

        @Override // com.squareup.wire.Message.Builder
        public CustomSummaryItem build() {
            return new CustomSummaryItem(this.mcustom_sub_type, this.mmy_todo, this.mkey_point, this.mspeaker_summary, this.mgolden_sentences, this.mis_final, this.mself_performance, super.buildUnknownFields());
        }

        public Builder() {
            this.mmy_todo = Internal.newMutableList();
            this.mspeaker_summary = Internal.newMutableList();
            this.mgolden_sentences = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder custom_sub_type(CustomSubType r100) {
            this.mcustom_sub_type = r100;
            return this;
        }

        public Builder golden_sentences(List<CustomSummaryGoldenSentences> r100) {
            Internal.checkElementsNotNull(r100);
            this.mgolden_sentences = r100;
            return this;
        }

        public Builder is_final(Boolean r100) {
            this.mis_final = r100;
            return this;
        }

        public Builder key_point(CustomSummaryKeypoint r100) {
            this.mkey_point = r100;
            return this;
        }

        public Builder my_todo(List<CustomSummaryMyTodo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmy_todo = r100;
            return this;
        }

        public Builder self_performance(CustomSummarySelfPerformance r100) {
            this.mself_performance = r100;
            return this;
        }

        public Builder speaker_summary(List<CustomSummarySpeakerSummary> r100) {
            Internal.checkElementsNotNull(r100);
            this.mspeaker_summary = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummaryItem extends ProtoAdapter<CustomSummaryItem> {
        public ProtoAdapter_CustomSummaryItem() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummaryItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomSummaryItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mis_final = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L19;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r101.mcustom_sub_type = CustomSubType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mself_performance = CustomSummarySelfPerformance.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.mis_final = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.mgolden_sentences.add(CustomSummaryGoldenSentences.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.mspeaker_summary.add(CustomSummarySpeakerSummary.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.mkey_point = CustomSummaryKeypoint.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.mmy_todo.add(CustomSummaryMyTodo.ADAPTER.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CustomSummaryItem r100) {
            CustomSubType r101 = r100.mcustom_sub_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = CustomSubType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + CustomSummaryMyTodo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mmy_todo);
            CustomSummaryKeypoint r105 = r100.mkey_point;
            if (r105 == null) goto L9;
            int r106 = CustomSummaryKeypoint.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            int r107 = ((r104 + r106) + CustomSummarySpeakerSummary.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mspeaker_summary)) + CustomSummaryGoldenSentences.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.mgolden_sentences);
            Boolean r108 = r100.mis_final;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r108);
        L14:
            int r110 = r107 + r109;
            CustomSummarySelfPerformance r111 = r100.mself_performance;
            if (r111 == null) goto L18;
            r102 = CustomSummarySelfPerformance.ADAPTER.encodedSizeWithTag(7, r111);
        L18:
            return (r110 + r102) + r100.unknownFields().size();
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomSummaryItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomSummaryItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomSummaryItem r101) throws IOException {
            CustomSubType r102 = r101.mcustom_sub_type;
            if (r102 == null) goto L5;
            CustomSubType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            CustomSummaryMyTodo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mmy_todo);
            CustomSummaryKeypoint r103 = r101.mkey_point;
            if (r103 == null) goto L8;
            CustomSummaryKeypoint.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            CustomSummarySpeakerSummary.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mspeaker_summary);
            CustomSummaryGoldenSentences.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.mgolden_sentences);
            Boolean r104 = r101.mis_final;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r104);
        L11:
            CustomSummarySelfPerformance r105 = r101.mself_performance;
            if (r105 == null) goto L14;
            CustomSummarySelfPerformance.ADAPTER.encodeWithTag(r100, 7, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomSummaryItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummaryItem();
        DEFAULT_IS_FINAL = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcustom_sub_type = this.mcustom_sub_type;
        r100.mmy_todo = Internal.copyOf("mmy_todo", this.mmy_todo);
        r100.mkey_point = this.mkey_point;
        r100.mspeaker_summary = Internal.copyOf("mspeaker_summary", this.mspeaker_summary);
        r100.mgolden_sentences = Internal.copyOf("mgolden_sentences", this.mgolden_sentences);
        r100.mis_final = this.mis_final;
        r100.mself_performance = this.mself_performance;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomSummaryItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomSummaryItem(CustomSubType r110, List<CustomSummaryMyTodo> r111, CustomSummaryKeypoint r112, List<CustomSummarySpeakerSummary> r113, List<CustomSummaryGoldenSentences> r114, Boolean r115, CustomSummarySelfPerformance r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public CustomSummaryItem(CustomSubType r100, List<CustomSummaryMyTodo> r101, CustomSummaryKeypoint r102, List<CustomSummarySpeakerSummary> r103, List<CustomSummaryGoldenSentences> r104, Boolean r105, CustomSummarySelfPerformance r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mcustom_sub_type = r100;
        this.mmy_todo = Internal.immutableCopyOf("mmy_todo", r101);
        this.mkey_point = r102;
        this.mspeaker_summary = Internal.immutableCopyOf("mspeaker_summary", r103);
        this.mgolden_sentences = Internal.immutableCopyOf("mgolden_sentences", r104);
        this.mis_final = r105;
        this.mself_performance = r106;
    }
}
