package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class MonitorCallback extends Message<MonitorCallback, Builder> {
    public static final ProtoAdapter<MonitorCallback> ADAPTER = null;
    public static final String DEFAULT_EVENT = "";
    public static final ProtoAdapter_MonitorCallback RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String event;
    public final Map<String, String> params;

    public static final class Builder extends Message.Builder<MonitorCallback, Builder> implements d<MonitorCallback> {
        public String event;
        public Map<String, String> params;

        @Override // com.squareup.wire.Message.Builder
        public MonitorCallback build() {
            String r100 = this.event;
            if (r100 == null) goto L7;
            return new MonitorCallback(this.event, this.params, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "event"});
        }

        public Builder() {
            this.params = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder event(String r100) {
            this.event = r100;
            return this;
        }

        public Builder params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.params = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MonitorCallback extends ProtoAdapter<MonitorCallback> implements c<MonitorCallback> {
        private final ProtoAdapter<Map<String, String>> params;

        public ProtoAdapter_MonitorCallback() {
            super(FieldEncoding.LENGTH_DELIMITED, MonitorCallback.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.params = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MonitorCallback decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.event = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.event = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.params.putAll(this.params.decode(r100));
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
        public int encodedSize2(MonitorCallback r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.event) + this.params.encodedSizeWithTag(2, r100.params)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MonitorCallback decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MonitorCallback r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MonitorCallback r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.event);
            this.params.encodeWithTag(r100, 2, r101.params);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MonitorCallback r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MonitorCallback r100 = new ProtoAdapter_MonitorCallback();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.event = this.event;
        r100.params = Internal.copyOf("params", this.params);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MonitorCallback.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MonitorCallback(String r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MonitorCallback(String r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.event = r100;
        this.params = Internal.immutableCopyOf("params", r101);
    }
}
