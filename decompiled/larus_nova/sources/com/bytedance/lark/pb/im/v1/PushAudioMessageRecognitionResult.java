package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushAudioMessageRecognitionResult extends Message<PushAudioMessageRecognitionResult, Builder> {
    public static final ProtoAdapter<PushAudioMessageRecognitionResult> ADAPTER = null;
    public static final Boolean DEFAULT_IS_END = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_RESULT = "";
    public static final Integer DEFAULT_SEQ_ID = null;
    public static final ProtoAdapter_PushAudioMessageRecognitionResult RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Integer> diff_index_slice;
    public final Boolean is_end;
    public final String message_id;
    public final String result;
    public final Integer seq_id;

    public static final class Builder extends Message.Builder<PushAudioMessageRecognitionResult, Builder> implements d<PushAudioMessageRecognitionResult> {
        public List<Integer> diff_index_slice;
        public Boolean is_end;
        public String message_id;
        public String result;
        public Integer seq_id;

        @Override // com.squareup.wire.Message.Builder
        public PushAudioMessageRecognitionResult build() {
            return new PushAudioMessageRecognitionResult(this.message_id, this.seq_id, this.result, this.is_end, this.diff_index_slice, super.buildUnknownFields());
        }

        public Builder() {
            this.diff_index_slice = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder diff_index_slice(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.diff_index_slice = r100;
            return this;
        }

        public Builder is_end(Boolean r100) {
            this.is_end = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder result(String r100) {
            this.result = r100;
            return this;
        }

        public Builder seq_id(Integer r100) {
            this.seq_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushAudioMessageRecognitionResult extends ProtoAdapter<PushAudioMessageRecognitionResult> implements c<PushAudioMessageRecognitionResult> {
        public ProtoAdapter_PushAudioMessageRecognitionResult() {
            super(FieldEncoding.LENGTH_DELIMITED, PushAudioMessageRecognitionResult.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushAudioMessageRecognitionResult decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.seq_id = 0;
            r101.result = "";
            r101.is_end = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.seq_id = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.result = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.is_end = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.diff_index_slice.add(ProtoAdapter.INT32.decode(r100));
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
        public int encodedSize2(PushAudioMessageRecognitionResult r100) {
            String r101 = r100.message_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.seq_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.result;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_end;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            return ((r109 + r102) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(5, r100.diff_index_slice)) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushAudioMessageRecognitionResult decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushAudioMessageRecognitionResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushAudioMessageRecognitionResult r101) throws IOException {
            String r102 = r101.message_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.seq_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.result;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.is_end;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 5, r101.diff_index_slice);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushAudioMessageRecognitionResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushAudioMessageRecognitionResult r100 = new ProtoAdapter_PushAudioMessageRecognitionResult();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SEQ_ID = 0;
        DEFAULT_IS_END = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.seq_id = this.seq_id;
        r100.result = this.result;
        r100.is_end = this.is_end;
        r100.diff_index_slice = Internal.copyOf("diff_index_slice", this.diff_index_slice);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushAudioMessageRecognitionResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushAudioMessageRecognitionResult(String r100, Integer r101, String r110, Boolean r111, List<Integer> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public PushAudioMessageRecognitionResult(String r100, Integer r101, String r102, Boolean r103, List<Integer> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.message_id = r100;
        this.seq_id = r101;
        this.result = r102;
        this.is_end = r103;
        this.diff_index_slice = Internal.immutableCopyOf("diff_index_slice", r104);
    }
}
