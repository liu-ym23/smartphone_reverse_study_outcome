package com.bytedance.lark.pb.settings.v1;

import androidx.camera.video.AudioStats;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SetDataDisplayWeightRequest extends Message<SetDataDisplayWeightRequest, Builder> {
    public static final ProtoAdapter<SetDataDisplayWeightRequest> ADAPTER = null;
    public static final ProtoAdapter_SetDataDisplayWeightRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Integer, DisplayWeight> data_display_weights;

    public static final class Builder extends Message.Builder<SetDataDisplayWeightRequest, Builder> implements d<SetDataDisplayWeightRequest> {
        public Map<Integer, DisplayWeight> data_display_weights;

        @Override // com.squareup.wire.Message.Builder
        public SetDataDisplayWeightRequest build() {
            return new SetDataDisplayWeightRequest(this.data_display_weights, super.buildUnknownFields());
        }

        public Builder() {
            this.data_display_weights = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder data_display_weights(Map<Integer, DisplayWeight> r100) {
            Internal.checkElementsNotNull(r100);
            this.data_display_weights = r100;
            return this;
        }
    }

    public static final enum DataType extends Enum<DataType> implements WireEnum {
        private static final /* synthetic */ DataType[] $VALUES = null;
        public static final ProtoAdapter<DataType> ADAPTER = null;
        public static final DataType CHAT_MESSAGE = null;
        public static final DataType CHAT_THREAD = null;
        public static final DataType THREAD_MESSAGE = null;
        private final int value;

        static {
            DataType r100 = new DataType("CHAT_MESSAGE", 0, 1);
            CHAT_MESSAGE = r100;
            DataType r101 = new DataType("CHAT_THREAD", 1, 2);
            CHAT_THREAD = r101;
            DataType r102 = new DataType("THREAD_MESSAGE", 2, 3);
            THREAD_MESSAGE = r102;
            $VALUES = new DataType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(DataType.class);
        }

        public static DataType[] values() {
            return (DataType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DataType fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return THREAD_MESSAGE;
        L13:
            return CHAT_THREAD;
        L15:
            return CHAT_MESSAGE;
        }

        public static DataType valueOf(String r100) {
            return (DataType) a.a(DataType.class, r100);
        }

        private DataType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class DisplayWeight extends Message<DisplayWeight, Builder> {
        public static final ProtoAdapter<DisplayWeight> ADAPTER = null;
        public static final Double DEFAULT_MAX_WEIGHT = null;
        private static final long serialVersionUID = 0;
        public final Double max_weight;
        public final Map<Integer, Double> type2max_weights;
        public final Map<Integer, Double> type2weights;

        public static final class Builder extends Message.Builder<DisplayWeight, Builder> {
            public Double max_weight;
            public Map<Integer, Double> type2max_weights;
            public Map<Integer, Double> type2weights;

            @Override // com.squareup.wire.Message.Builder
            public DisplayWeight build() {
                return new DisplayWeight(this.type2weights, this.max_weight, this.type2max_weights, super.buildUnknownFields());
            }

            public Builder() {
                this.type2weights = Internal.newMutableMap();
                this.type2max_weights = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder max_weight(Double r100) {
                this.max_weight = r100;
                return this;
            }

            public Builder type2max_weights(Map<Integer, Double> r100) {
                Internal.checkElementsNotNull(r100);
                this.type2max_weights = r100;
                return this;
            }

            public Builder type2weights(Map<Integer, Double> r100) {
                Internal.checkElementsNotNull(r100);
                this.type2weights = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DisplayWeight extends ProtoAdapter<DisplayWeight> {
            private final ProtoAdapter<Map<Integer, Double>> type2max_weights;
            private final ProtoAdapter<Map<Integer, Double>> type2weights;

            public ProtoAdapter_DisplayWeight() {
                super(FieldEncoding.LENGTH_DELIMITED, DisplayWeight.class);
                ProtoAdapter<Integer> r100 = ProtoAdapter.INT32;
                ProtoAdapter<Double> r101 = ProtoAdapter.DOUBLE;
                this.type2weights = ProtoAdapter.newMapAdapter(r100, r101);
                this.type2max_weights = ProtoAdapter.newMapAdapter(r100, r101);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DisplayWeight decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.max_weight = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.type2weights.putAll(this.type2weights.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.max_weight = ProtoAdapter.DOUBLE.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.type2max_weights.putAll(this.type2max_weights.decode(r100));
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
            public int encodedSize2(DisplayWeight r100) {
                int r101 = this.type2weights.encodedSizeWithTag(1, r100.type2weights);
                Double r102 = r100.max_weight;
                if (r102 == null) goto L5;
                int r103 = ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r102);
            L7:
                return ((r101 + r103) + this.type2max_weights.encodedSizeWithTag(3, r100.type2max_weights)) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DisplayWeight decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DisplayWeight r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DisplayWeight r101) throws IOException {
                this.type2weights.encodeWithTag(r100, 1, r101.type2weights);
                Double r102 = r101.max_weight;
                if (r102 == null) goto L5;
                ProtoAdapter.DOUBLE.encodeWithTag(r100, 2, r102);
            L5:
                this.type2max_weights.encodeWithTag(r100, 3, r101.type2max_weights);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DisplayWeight r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DisplayWeight();
            DEFAULT_MAX_WEIGHT = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type2weights = Internal.copyOf("type2weights", this.type2weights);
            r100.max_weight = this.max_weight;
            r100.type2max_weights = Internal.copyOf("type2max_weights", this.type2max_weights);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DisplayWeight.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DisplayWeight(Map<Integer, Double> r100, Double r101, Map<Integer, Double> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public DisplayWeight(Map<Integer, Double> r100, Double r101, Map<Integer, Double> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.type2weights = Internal.immutableCopyOf("type2weights", r100);
            this.max_weight = r101;
            this.type2max_weights = Internal.immutableCopyOf("type2max_weights", r102);
        }
    }

    public static final class ProtoAdapter_SetDataDisplayWeightRequest extends ProtoAdapter<SetDataDisplayWeightRequest> implements c<SetDataDisplayWeightRequest> {
        private final ProtoAdapter<Map<Integer, DisplayWeight>> data_display_weights;

        public ProtoAdapter_SetDataDisplayWeightRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetDataDisplayWeightRequest.class);
            this.data_display_weights = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, DisplayWeight.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetDataDisplayWeightRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.data_display_weights.putAll(this.data_display_weights.decode(r100));
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
        public int encodedSize2(SetDataDisplayWeightRequest r100) {
            return this.data_display_weights.encodedSizeWithTag(1, r100.data_display_weights) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetDataDisplayWeightRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetDataDisplayWeightRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetDataDisplayWeightRequest r101) throws IOException {
            this.data_display_weights.encodeWithTag(r100, 1, r101.data_display_weights);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetDataDisplayWeightRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetDataDisplayWeightRequest r100 = new ProtoAdapter_SetDataDisplayWeightRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.data_display_weights = Internal.copyOf("data_display_weights", this.data_display_weights);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetDataDisplayWeightRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetDataDisplayWeightRequest(Map<Integer, DisplayWeight> r100) {
        this(r100, ByteString.EMPTY);
    }

    public SetDataDisplayWeightRequest(Map<Integer, DisplayWeight> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.data_display_weights = Internal.immutableCopyOf("data_display_weights", r100);
    }
}
