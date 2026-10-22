package com.bytedance.lark.pb.contact.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
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
public final class PushContactApplicationBannerAffectEvent extends Message<PushContactApplicationBannerAffectEvent, Builder> {
    public static final ProtoAdapter<PushContactApplicationBannerAffectEvent> ADAPTER = null;
    public static final AffectEventType DEFAULT_EVENT_TYPE = null;
    public static final ProtoAdapter_PushContactApplicationBannerAffectEvent RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AffectEventType event_type;
    public final List<String> target_user_ids;

    public static final enum AffectEventType extends Enum<AffectEventType> implements WireEnum {
        private static final /* synthetic */ AffectEventType[] $VALUES = null;
        public static final ProtoAdapter<AffectEventType> ADAPTER = null;
        public static final AffectEventType BeBlock = null;
        public static final AffectEventType Block = null;
        public static final AffectEventType ContactApplication = null;
        public static final AffectEventType ContactDidChange = null;
        public static final AffectEventType UnknownType = null;
        private final int value;

        static {
            AffectEventType r100 = new AffectEventType("UnknownType", 0, 0);
            UnknownType = r100;
            AffectEventType r101 = new AffectEventType("Block", 1, 1);
            Block = r101;
            AffectEventType r102 = new AffectEventType("ContactApplication", 2, 2);
            ContactApplication = r102;
            AffectEventType r103 = new AffectEventType("ContactDidChange", 3, 3);
            ContactDidChange = r103;
            AffectEventType r104 = new AffectEventType("BeBlock", 4, 4);
            BeBlock = r104;
            $VALUES = new AffectEventType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(AffectEventType.class);
        }

        public static AffectEventType[] values() {
            return (AffectEventType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AffectEventType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return BeBlock;
        L16:
            return ContactDidChange;
        L18:
            return ContactApplication;
        L20:
            return Block;
        L22:
            return UnknownType;
        }

        public static AffectEventType valueOf(String r100) {
            return (AffectEventType) a.a(AffectEventType.class, r100);
        }

        private AffectEventType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<PushContactApplicationBannerAffectEvent, Builder> implements d<PushContactApplicationBannerAffectEvent> {
        public AffectEventType event_type;
        public List<String> target_user_ids;

        @Override // com.squareup.wire.Message.Builder
        public PushContactApplicationBannerAffectEvent build() {
            AffectEventType r100 = this.event_type;
            if (r100 == null) goto L7;
            return new PushContactApplicationBannerAffectEvent(this.event_type, this.target_user_ids, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "event_type"});
        }

        public Builder() {
            this.target_user_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder event_type(AffectEventType r100) {
            this.event_type = r100;
            return this;
        }

        public Builder target_user_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.target_user_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushContactApplicationBannerAffectEvent extends ProtoAdapter<PushContactApplicationBannerAffectEvent> implements c<PushContactApplicationBannerAffectEvent> {
        public ProtoAdapter_PushContactApplicationBannerAffectEvent() {
            super(FieldEncoding.LENGTH_DELIMITED, PushContactApplicationBannerAffectEvent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushContactApplicationBannerAffectEvent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.event_type = AffectEventType.UnknownType;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.event_type = AffectEventType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.target_user_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(PushContactApplicationBannerAffectEvent r100) {
            return (AffectEventType.ADAPTER.encodedSizeWithTag(1, r100.event_type) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.target_user_ids)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushContactApplicationBannerAffectEvent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushContactApplicationBannerAffectEvent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushContactApplicationBannerAffectEvent r101) throws IOException {
            AffectEventType.ADAPTER.encodeWithTag(r100, 1, r101.event_type);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.target_user_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushContactApplicationBannerAffectEvent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushContactApplicationBannerAffectEvent r100 = new ProtoAdapter_PushContactApplicationBannerAffectEvent();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_EVENT_TYPE = AffectEventType.UnknownType;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.event_type = this.event_type;
        r100.target_user_ids = Internal.copyOf("target_user_ids", this.target_user_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushContactApplicationBannerAffectEvent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushContactApplicationBannerAffectEvent(AffectEventType r100, List<String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushContactApplicationBannerAffectEvent(AffectEventType r100, List<String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.event_type = r100;
        this.target_user_ids = Internal.immutableCopyOf("target_user_ids", r101);
    }
}
