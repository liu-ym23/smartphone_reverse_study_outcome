package com.ss.android.lark.pb.ai_engine;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DebugInfoRequest extends Message<DebugInfoRequest, Builder> {
    public static final ProtoAdapter<DebugInfoRequest> ADAPTER = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_QUERY_ID = "";
    public static final String DEFAULT_SCENARIO = "";
    private static final long serialVersionUID = 0;
    public final String mmessage_id;
    public final WorkMode mmode;
    public final String mquery_id;
    public final String mscenario;

    public static final class Builder extends Message.Builder<DebugInfoRequest, Builder> {
        public String mmessage_id;
        public WorkMode mmode;
        public String mquery_id;
        public String mscenario;

        @Override // com.squareup.wire.Message.Builder
        public DebugInfoRequest build() {
            return new DebugInfoRequest(this.mmessage_id, this.mquery_id, this.mmode, this.mscenario, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_id(String r100) {
            this.mmessage_id = r100;
            return this;
        }

        public Builder mode(WorkMode r100) {
            this.mmode = r100;
            return this;
        }

        public Builder query_id(String r100) {
            this.mquery_id = r100;
            return this;
        }

        public Builder scenario(String r100) {
            this.mscenario = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DebugInfoRequest extends ProtoAdapter<DebugInfoRequest> {
        public ProtoAdapter_DebugInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DebugInfoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DebugInfoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmessage_id = "";
            r101.mquery_id = "";
            r101.mscenario = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mmessage_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mquery_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mmode = WorkMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mscenario = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DebugInfoRequest r100) {
            String r101 = r100.mmessage_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mquery_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            WorkMode r107 = r100.mmode;
            if (r107 == null) goto L13;
            int r108 = WorkMode.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mscenario;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ DebugInfoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DebugInfoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DebugInfoRequest r101) throws IOException {
            String r102 = r101.mmessage_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mquery_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            WorkMode r104 = r101.mmode;
            if (r104 == null) goto L11;
            WorkMode.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mscenario;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DebugInfoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DebugInfoRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmessage_id = this.mmessage_id;
        r100.mquery_id = this.mquery_id;
        r100.mmode = this.mmode;
        r100.mscenario = this.mscenario;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DebugInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DebugInfoRequest(String r100, String r101, WorkMode r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public DebugInfoRequest(String r100, String r101, WorkMode r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mmessage_id = r100;
        this.mquery_id = r101;
        this.mmode = r102;
        this.mscenario = r103;
    }
}
