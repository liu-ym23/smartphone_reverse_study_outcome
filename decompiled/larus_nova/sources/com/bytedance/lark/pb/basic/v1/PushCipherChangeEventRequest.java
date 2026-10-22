package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
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
public final class PushCipherChangeEventRequest extends com.squareup.wire.Message<PushCipherChangeEventRequest, Builder> {
    public static final ProtoAdapter<PushCipherChangeEventRequest> ADAPTER = null;
    public static final Long DEFAULT_NEW_CURSOR = null;
    public static final Long DEFAULT_PREVIOUS_CURSOR = null;
    public static final ProtoAdapter_PushCipherChangeEventRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<CipherChangedEvent> events;
    public final Long new_cursor;
    public final Long previous_cursor;

    public static final class Builder extends com.squareup.wire.Message.Builder<PushCipherChangeEventRequest, Builder> implements d<PushCipherChangeEventRequest> {
        public List<CipherChangedEvent> events;
        public Long new_cursor;
        public Long previous_cursor;

        @Override // com.squareup.wire.Message.Builder
        public PushCipherChangeEventRequest build() {
            return new PushCipherChangeEventRequest(this.previous_cursor, this.new_cursor, this.events, super.buildUnknownFields());
        }

        public Builder() {
            this.events = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder events(List<CipherChangedEvent> r100) {
            Internal.checkElementsNotNull(r100);
            this.events = r100;
            return this;
        }

        public Builder new_cursor(Long r100) {
            this.new_cursor = r100;
            return this;
        }

        public Builder previous_cursor(Long r100) {
            this.previous_cursor = r100;
            return this;
        }
    }

    public static final class CipherChangedEvent extends com.squareup.wire.Message<CipherChangedEvent, Builder> {
        public static final ProtoAdapter<CipherChangedEvent> ADAPTER = null;
        public static final CipherKeyBusiness DEFAULT_BUSINESS = null;
        private static final long serialVersionUID = 0;
        public final CipherKeyBusiness business;
        public final List<Long> changed_ids;

        public static final class Builder extends com.squareup.wire.Message.Builder<CipherChangedEvent, Builder> {
            public CipherKeyBusiness business;
            public List<Long> changed_ids;

            @Override // com.squareup.wire.Message.Builder
            public CipherChangedEvent build() {
                return new CipherChangedEvent(this.business, this.changed_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.changed_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder business(CipherKeyBusiness r100) {
                this.business = r100;
                return this;
            }

            public Builder changed_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.changed_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CipherChangedEvent extends ProtoAdapter<CipherChangedEvent> {
            public ProtoAdapter_CipherChangedEvent() {
                super(FieldEncoding.LENGTH_DELIMITED, CipherChangedEvent.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CipherChangedEvent decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.business = CipherKeyBusiness.Unknown;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.business = CipherKeyBusiness.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.changed_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CipherChangedEvent r100) {
                CipherKeyBusiness r101 = r100.business;
                if (r101 == null) goto L5;
                int r102 = CipherKeyBusiness.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(2, r100.changed_ids)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CipherChangedEvent decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CipherChangedEvent r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CipherChangedEvent r101) throws IOException {
                CipherKeyBusiness r102 = r101.business;
                if (r102 == null) goto L5;
                CipherKeyBusiness.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 2, r101.changed_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CipherChangedEvent r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CipherChangedEvent();
            DEFAULT_BUSINESS = CipherKeyBusiness.Unknown;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.business = this.business;
            r100.changed_ids = Internal.copyOf("changed_ids", this.changed_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CipherChangedEvent.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CipherChangedEvent(CipherKeyBusiness r100, List<Long> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public CipherChangedEvent(CipherKeyBusiness r100, List<Long> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.business = r100;
            this.changed_ids = Internal.immutableCopyOf("changed_ids", r101);
        }
    }

    public static final class ProtoAdapter_PushCipherChangeEventRequest extends ProtoAdapter<PushCipherChangeEventRequest> implements c<PushCipherChangeEventRequest> {
        public ProtoAdapter_PushCipherChangeEventRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PushCipherChangeEventRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushCipherChangeEventRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.previous_cursor = 0L;
            r101.new_cursor = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.previous_cursor = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.new_cursor = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.events.add(CipherChangedEvent.ADAPTER.decode(r100));
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
        public int encodedSize2(PushCipherChangeEventRequest r100) {
            Long r101 = r100.previous_cursor;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.new_cursor;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + CipherChangedEvent.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.events)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushCipherChangeEventRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushCipherChangeEventRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushCipherChangeEventRequest r101) throws IOException {
            Long r102 = r101.previous_cursor;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.new_cursor;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            CipherChangedEvent.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.events);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushCipherChangeEventRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushCipherChangeEventRequest r100 = new ProtoAdapter_PushCipherChangeEventRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_PREVIOUS_CURSOR = 0L;
        DEFAULT_NEW_CURSOR = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.previous_cursor = this.previous_cursor;
        r100.new_cursor = this.new_cursor;
        r100.events = Internal.copyOf("events", this.events);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushCipherChangeEventRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushCipherChangeEventRequest(Long r100, Long r101, List<CipherChangedEvent> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushCipherChangeEventRequest(Long r100, Long r101, List<CipherChangedEvent> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.previous_cursor = r100;
        this.new_cursor = r101;
        this.events = Internal.immutableCopyOf("events", r102);
    }
}
