package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class TriggerDataCleanResponse extends com.squareup.wire.Message<TriggerDataCleanResponse, Builder> {
    public static final ProtoAdapter<TriggerDataCleanResponse> ADAPTER = null;
    public static final ProtoAdapter_TriggerDataCleanResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Cleaned> cleaned;

    public static final class Builder extends com.squareup.wire.Message.Builder<TriggerDataCleanResponse, Builder> implements d<TriggerDataCleanResponse> {
        public List<Cleaned> cleaned;

        @Override // com.squareup.wire.Message.Builder
        public TriggerDataCleanResponse build() {
            return new TriggerDataCleanResponse(this.cleaned, super.buildUnknownFields());
        }

        public Builder() {
            this.cleaned = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cleaned(List<Cleaned> r100) {
            Internal.checkElementsNotNull(r100);
            this.cleaned = r100;
            return this;
        }
    }

    public static final enum Business extends Enum<Business> implements WireEnum {
        private static final /* synthetic */ Business[] $VALUES = null;
        public static final ProtoAdapter<Business> ADAPTER = null;
        public static final Business AbnormalCheck = null;
        public static final Business CALENDAR = null;
        public static final Business CCM = null;
        public static final Business FEED = null;
        public static final Business LOG = null;
        public static final Business MAIL = null;
        public static final Business MESSAGE = null;
        public static final Business RESOURCE = null;
        public static final Business SEARCH = null;
        public static final Business UNKNOWN = null;
        private final int value;

        static {
            Business r100 = new Business("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Business r101 = new Business("SEARCH", 1, 1);
            SEARCH = r101;
            Business r102 = new Business("MESSAGE", 2, 2);
            MESSAGE = r102;
            Business r103 = new Business("FEED", 3, 3);
            FEED = r103;
            Business r104 = new Business("RESOURCE", 4, 4);
            RESOURCE = r104;
            Business r105 = new Business("MAIL", 5, 5);
            MAIL = r105;
            Business r110 = new Business("CALENDAR", 6, 6);
            CALENDAR = r110;
            Business r111 = new Business("LOG", 7, 7);
            LOG = r111;
            Business r112 = new Business("CCM", 8, 8);
            CCM = r112;
            Business r113 = new Business("AbnormalCheck", 9, 9);
            AbnormalCheck = r113;
            $VALUES = new Business[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            ADAPTER = ProtoAdapter.newEnumAdapter(Business.class);
        }

        public static Business[] values() {
            return (Business[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Business fromValue(int r100) {
            switch(r100) {
                case 0: goto L24;
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L14;
                case 6: goto L12;
                case 7: goto L10;
                case 8: goto L8;
                case 9: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return AbnormalCheck;
        L8:
            return CCM;
        L10:
            return LOG;
        L12:
            return CALENDAR;
        L14:
            return MAIL;
        L16:
            return RESOURCE;
        L18:
            return FEED;
        L20:
            return MESSAGE;
        L22:
            return SEARCH;
        L24:
            return UNKNOWN;
        }

        public static Business valueOf(String r100) {
            return (Business) a.a(Business.class, r100);
        }

        private Business(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Cleaned extends com.squareup.wire.Message<Cleaned, Builder> {
        public static final ProtoAdapter<Cleaned> ADAPTER = null;
        public static final Business DEFAULT_BUSINESS = null;
        public static final Integer DEFAULT_BYTES = null;
        public static final Boolean DEFAULT_COMPLETED = null;
        public static final Integer DEFAULT_COST_TIME = null;
        public static final Integer DEFAULT_COUNT = null;
        private static final long serialVersionUID = 0;
        public final Business business;
        public final Integer bytes;
        public final Boolean completed;
        public final Integer cost_time;
        public final Integer count;

        public static final class Builder extends com.squareup.wire.Message.Builder<Cleaned, Builder> {
            public Business business;
            public Integer bytes;
            public Boolean completed;
            public Integer cost_time;
            public Integer count;

            @Override // com.squareup.wire.Message.Builder
            public Cleaned build() {
                Business r100 = this.business;
                if (r100 == null) goto L9;
                if (this.completed == null) goto L9;
                return new Cleaned(this.business, this.completed, this.cost_time, this.count, this.bytes, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "business", this.completed, "completed"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder business(Business r100) {
                this.business = r100;
                return this;
            }

            public Builder bytes(Integer r100) {
                this.bytes = r100;
                this.count = null;
                return this;
            }

            public Builder completed(Boolean r100) {
                this.completed = r100;
                return this;
            }

            public Builder cost_time(Integer r100) {
                this.cost_time = r100;
                return this;
            }

            public Builder count(Integer r100) {
                this.count = r100;
                this.bytes = null;
                return this;
            }
        }

        public static final class ProtoAdapter_Cleaned extends ProtoAdapter<Cleaned> {
            public ProtoAdapter_Cleaned() {
                super(FieldEncoding.LENGTH_DELIMITED, Cleaned.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Cleaned decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.business = Business.UNKNOWN;
                r101.completed = Boolean.FALSE;
                r101.cost_time = 0;
                r101.count(0);
                r101.bytes(0);
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.business = Business.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.completed = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.count(ProtoAdapter.INT32.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.bytes(ProtoAdapter.INT32.decode(r100));
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.cost_time = ProtoAdapter.INT32.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L24:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Cleaned r100) {
                int r101 = Business.ADAPTER.encodedSizeWithTag(1, r100.business) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.completed);
                Integer r102 = r100.cost_time;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.INT32.encodedSizeWithTag(5, r102);
            L6:
                int r105 = r101 + r104;
                Integer r106 = r100.count;
                if (r106 == null) goto L9;
                int r107 = ProtoAdapter.INT32.encodedSizeWithTag(3, r106);
            L10:
                int r108 = r105 + r107;
                Integer r109 = r100.bytes;
                if (r109 == null) goto L14;
                r103 = ProtoAdapter.INT32.encodedSizeWithTag(4, r109);
            L14:
                return (r108 + r103) + r100.unknownFields().size();
            L9:
                r107 = 0;
                goto L10
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Cleaned decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Cleaned r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Cleaned r101) throws IOException {
                Business.ADAPTER.encodeWithTag(r100, 1, r101.business);
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.completed);
                Integer r102 = r101.cost_time;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 5, r102);
            L5:
                Integer r103 = r101.count;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
            L8:
                Integer r104 = r101.bytes;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Cleaned r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Cleaned();
            DEFAULT_BUSINESS = Business.UNKNOWN;
            DEFAULT_COMPLETED = Boolean.FALSE;
            DEFAULT_COST_TIME = 0;
            DEFAULT_COUNT = 0;
            DEFAULT_BYTES = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.business = this.business;
            r100.completed = this.completed;
            r100.cost_time = this.cost_time;
            r100.count = this.count;
            r100.bytes = this.bytes;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Cleaned.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Cleaned(Business r100, Boolean r101, Integer r110, Integer r111, Integer r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public Cleaned(Business r100, Boolean r101, Integer r102, Integer r103, Integer r104, ByteString r105) {
            super(ADAPTER, r105);
            if (Internal.countNonNull(r103, r104) > 1) goto L7;
            this.business = r100;
            this.completed = r101;
            this.cost_time = r102;
            this.count = r103;
            this.bytes = r104;
            return;
        L7:
            throw new IllegalArgumentException("at most one of count, bytes may be non-null");
        }
    }

    public static final class ProtoAdapter_TriggerDataCleanResponse extends ProtoAdapter<TriggerDataCleanResponse> implements c<TriggerDataCleanResponse> {
        public ProtoAdapter_TriggerDataCleanResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, TriggerDataCleanResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TriggerDataCleanResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.cleaned.add(Cleaned.ADAPTER.decode(r100));
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
        public int encodedSize2(TriggerDataCleanResponse r100) {
            return Cleaned.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.cleaned) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TriggerDataCleanResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TriggerDataCleanResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TriggerDataCleanResponse r101) throws IOException {
            Cleaned.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.cleaned);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TriggerDataCleanResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TriggerDataCleanResponse r100 = new ProtoAdapter_TriggerDataCleanResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cleaned = Internal.copyOf("cleaned", this.cleaned);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TriggerDataCleanResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TriggerDataCleanResponse(List<Cleaned> r100) {
        this(r100, ByteString.EMPTY);
    }

    public TriggerDataCleanResponse(List<Cleaned> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.cleaned = Internal.immutableCopyOf("cleaned", r100);
    }
}
