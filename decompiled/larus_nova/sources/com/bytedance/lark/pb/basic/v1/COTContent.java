package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class COTContent extends com.squareup.wire.Message<COTContent, Builder> {
    public static final ProtoAdapter<COTContent> ADAPTER = null;
    public static final Boolean DEFAULT_COT_EVENTS_INCOMPLETE = null;
    public static final String DEFAULT_COT_ID = "";
    public static final COTStatus DEFAULT_COT_STATUS = null;
    public static final Boolean DEFAULT_VIOLATED = null;
    private static final long serialVersionUID = 0;
    public final List<COTEvent> cot_events;
    public final Boolean cot_events_incomplete;
    public final String cot_id;
    public final COTStatus cot_status;
    public final Boolean violated;

    public static final class Builder extends com.squareup.wire.Message.Builder<COTContent, Builder> {
        public List<COTEvent> cot_events;
        public Boolean cot_events_incomplete;
        public String cot_id;
        public COTStatus cot_status;
        public Boolean violated;

        @Override // com.squareup.wire.Message.Builder
        public COTContent build() {
            String r100 = this.cot_id;
            if (r100 == null) goto L11;
            if (this.cot_status == null) goto L11;
            if (this.violated == null) goto L11;
            return new COTContent(this.cot_id, this.cot_events, this.cot_status, this.violated, this.cot_events_incomplete, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "cot_id", this.cot_status, "cot_status", this.violated, "violated"});
        }

        public Builder() {
            this.cot_events = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cot_events(List<COTEvent> r100) {
            Internal.checkElementsNotNull(r100);
            this.cot_events = r100;
            return this;
        }

        public Builder cot_events_incomplete(Boolean r100) {
            this.cot_events_incomplete = r100;
            return this;
        }

        public Builder cot_id(String r100) {
            this.cot_id = r100;
            return this;
        }

        public Builder cot_status(COTStatus r100) {
            this.cot_status = r100;
            return this;
        }

        public Builder violated(Boolean r100) {
            this.violated = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_COTContent extends ProtoAdapter<COTContent> {
        public ProtoAdapter_COTContent() {
            super(FieldEncoding.LENGTH_DELIMITED, COTContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public COTContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cot_id = "";
            r101.cot_status = COTStatus.COT_STATUS_NONE;
            Boolean r102 = Boolean.FALSE;
            r101.violated = r102;
            r101.cot_events_incomplete = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L24;
            if (r104 != 1) goto L8;
            r101.cot_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.cot_events.add(COTEvent.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.cot_status = COTStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.violated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.cot_events_incomplete = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(COTContent r100) {
            int r101 = (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.cot_id) + COTEvent.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.cot_events)) + COTStatus.ADAPTER.encodedSizeWithTag(3, r100.cot_status);
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            int r103 = r101 + r102.encodedSizeWithTag(4, r100.violated);
            Boolean r104 = r100.cot_events_incomplete;
            if (r104 == null) goto L5;
            int r105 = r102.encodedSizeWithTag(5, r104);
        L7:
            return (r103 + r105) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ COTContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(COTContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, COTContent r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.cot_id);
            COTEvent.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.cot_events);
            COTStatus.ADAPTER.encodeWithTag(r100, 3, r101.cot_status);
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 4, r101.violated);
            Boolean r103 = r101.cot_events_incomplete;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 5, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, COTContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_COTContent();
        DEFAULT_COT_STATUS = COTStatus.COT_STATUS_NONE;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_VIOLATED = r100;
        DEFAULT_COT_EVENTS_INCOMPLETE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cot_id = this.cot_id;
        r100.cot_events = Internal.copyOf("cot_events", this.cot_events);
        r100.cot_status = this.cot_status;
        r100.violated = this.violated;
        r100.cot_events_incomplete = this.cot_events_incomplete;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return COTContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public COTContent(String r100, List<COTEvent> r101, COTStatus r110, Boolean r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public COTContent(String r100, List<COTEvent> r101, COTStatus r102, Boolean r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.cot_id = r100;
        this.cot_events = Internal.immutableCopyOf("cot_events", r101);
        this.cot_status = r102;
        this.violated = r103;
        this.cot_events_incomplete = r104;
    }
}
