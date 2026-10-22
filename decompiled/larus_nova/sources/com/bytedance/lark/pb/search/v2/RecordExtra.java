package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class RecordExtra extends Message<RecordExtra, Builder> {
    public static final ProtoAdapter<RecordExtra> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Integer> asl_search_time_dev;
    public final Map<String, String> search_metric_response;

    public static final class Builder extends Message.Builder<RecordExtra, Builder> {
        public Map<String, Integer> asl_search_time_dev;
        public Map<String, String> search_metric_response;

        @Override // com.squareup.wire.Message.Builder
        public RecordExtra build() {
            return new RecordExtra(this.asl_search_time_dev, this.search_metric_response, super.buildUnknownFields());
        }

        public Builder() {
            this.asl_search_time_dev = Internal.newMutableMap();
            this.search_metric_response = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder asl_search_time_dev(Map<String, Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.asl_search_time_dev = r100;
            return this;
        }

        public Builder search_metric_response(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.search_metric_response = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RecordExtra extends ProtoAdapter<RecordExtra> {
        private final ProtoAdapter<Map<String, Integer>> asl_search_time_dev;
        private final ProtoAdapter<Map<String, String>> search_metric_response;

        public ProtoAdapter_RecordExtra() {
            super(FieldEncoding.LENGTH_DELIMITED, RecordExtra.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.asl_search_time_dev = ProtoAdapter.newMapAdapter(r100, ProtoAdapter.INT32);
            this.search_metric_response = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RecordExtra decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.asl_search_time_dev.putAll(this.asl_search_time_dev.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.search_metric_response.putAll(this.search_metric_response.decode(r100));
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
        public int encodedSize2(RecordExtra r100) {
            return (this.asl_search_time_dev.encodedSizeWithTag(1, r100.asl_search_time_dev) + this.search_metric_response.encodedSizeWithTag(2, r100.search_metric_response)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RecordExtra decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RecordExtra r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RecordExtra r101) throws IOException {
            this.asl_search_time_dev.encodeWithTag(r100, 1, r101.asl_search_time_dev);
            this.search_metric_response.encodeWithTag(r100, 2, r101.search_metric_response);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecordExtra r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RecordExtra();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.asl_search_time_dev = Internal.copyOf("asl_search_time_dev", this.asl_search_time_dev);
        r100.search_metric_response = Internal.copyOf("search_metric_response", this.search_metric_response);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RecordExtra.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RecordExtra(Map<String, Integer> r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public RecordExtra(Map<String, Integer> r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.asl_search_time_dev = Internal.immutableCopyOf("asl_search_time_dev", r100);
        this.search_metric_response = Internal.immutableCopyOf("search_metric_response", r101);
    }
}
