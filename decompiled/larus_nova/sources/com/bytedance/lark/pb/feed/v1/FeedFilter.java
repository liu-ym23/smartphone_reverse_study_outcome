package com.bytedance.lark.pb.feed.v1;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.bear.drive.biz.cache.manual.model.ManualOfflineSyncData;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class FeedFilter extends Message<FeedFilter, Builder> {
    public static final ProtoAdapter<FeedFilter> ADAPTER = null;
    public static final Type DEFAULT_FILTER_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Type filter_type;

    public static final class Builder extends Message.Builder<FeedFilter, Builder> {
        public Type filter_type;

        @Override // com.squareup.wire.Message.Builder
        public FeedFilter build() {
            return new FeedFilter(this.filter_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder filter_type(Type r100) {
            this.filter_type = r100;
            return this;
        }
    }

    public static final enum ExtType extends Enum<ExtType> implements WireEnum {
        private static final /* synthetic */ ExtType[] $VALUES = null;
        public static final ProtoAdapter<ExtType> ADAPTER = null;
        public static final ExtType BOX = null;
        public static final ExtType SHORTCUTS = null;
        private final int value;

        static {
            ExtType r100 = new ExtType("SHORTCUTS", 0, 100);
            SHORTCUTS = r100;
            ExtType r101 = new ExtType(ManualOfflineSyncData.DRIVE_TYPE, 1, 101);
            BOX = r101;
            $VALUES = new ExtType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(ExtType.class);
        }

        public static ExtType[] values() {
            return (ExtType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ExtType fromValue(int r100) {
            if (r100 == 100) goto L11;
            if (r100 == 101) goto L9;
            return null;
        L9:
            return BOX;
        L11:
            return SHORTCUTS;
        }

        public static ExtType valueOf(String r100) {
            return (ExtType) a.a(ExtType.class, r100);
        }

        private ExtType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class List extends Message<List, Builder> {
        public static final ProtoAdapter<List> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final java.util.List<Integer> types;

        public static final class Builder extends Message.Builder<List, Builder> {
            public java.util.List<Integer> types;

            @Override // com.squareup.wire.Message.Builder
            public List build() {
                return new List(this.types, super.buildUnknownFields());
            }

            public Builder() {
                this.types = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder types(java.util.List<Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.types = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_List extends ProtoAdapter<List> {
            public ProtoAdapter_List() {
                super(FieldEncoding.LENGTH_DELIMITED, List.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public List decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.types.add(ProtoAdapter.INT32.decode(r100));
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
            public int encodedSize2(List r100) {
                return ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(1, r100.types) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ List decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(List r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, List r101) throws IOException {
                ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 1, r101.types);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, List r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_List();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.types = Internal.copyOf("types", this.types);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return List.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public List(java.util.List<Integer> r100) {
            this(r100, ByteString.EMPTY);
        }

        public List(java.util.List<Integer> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.types = Internal.immutableCopyOf("types", r100);
        }
    }

    public static final class ProtoAdapter_FeedFilter extends ProtoAdapter<FeedFilter> {
        public ProtoAdapter_FeedFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedFilter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedFilter decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.filter_type = Type.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.filter_type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FeedFilter r100) {
            Type r101 = r100.filter_type;
            if (r101 == null) goto L5;
            int r102 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedFilter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedFilter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedFilter r101) throws IOException {
            Type r102 = r101.filter_type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedFilter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type ALL_MESSAGE = null;
        public static final Type AT_ME = null;
        public static final Type BOT = null;
        public static final Type CALENDAR_GROUP = null;
        public static final Type COLLAPSED = null;
        public static final Type CRYPTO_CHAT = null;
        public static final Type DELAYED = null;
        public static final Type DOC = null;
        public static final Type DONE = null;
        public static final Type EXPIRED_FOLD = null;
        public static final Type FLAG = null;
        public static final Type GROUP = null;
        public static final Type GROUP_CHAT = null;
        public static final Type HELP_DESK = null;
        public static final Type INBOX = null;
        public static final Type INSTANT_MEETING_GROUP = null;
        public static final Type MARK_AS_DELETED = null;
        public static final Type MESSAGE = null;
        public static final Type MESSAGE_WITHOUT_DOUBAO = null;
        public static final Type MUTE = null;
        public static final Type P2P_CHAT = null;
        public static final Type TAG = null;
        public static final Type TEAM = null;
        public static final Type THREAD = null;
        public static final Type TOPIC_GROUP = null;
        public static final Type UNKNOWN = null;
        public static final Type UNREAD = null;
        public static final Type UNREAD_OVER_DAYS = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("INBOX", 1, 1);
            INBOX = r101;
            Type r102 = new Type("AT_ME", 2, 2);
            AT_ME = r102;
            Type r103 = new Type("UNREAD", 3, 3);
            UNREAD = r103;
            Type r104 = new Type("DELAYED", 4, 4);
            DELAYED = r104;
            Type r105 = new Type(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 5, 5);
            DOC = r105;
            Type r110 = new Type("P2P_CHAT", 6, 6);
            P2P_CHAT = r110;
            Type r111 = new Type("GROUP_CHAT", 7, 7);
            GROUP_CHAT = r111;
            Type r112 = new Type("BOT", 8, 8);
            BOT = r112;
            Type r113 = new Type("HELP_DESK", 9, 9);
            HELP_DESK = r113;
            Type r114 = new Type("TOPIC_GROUP", 10, 10);
            TOPIC_GROUP = r114;
            Type r115 = new Type("DONE", 11, 11);
            DONE = r115;
            Type r106 = new Type("CRYPTO_CHAT", 12, 12);
            CRYPTO_CHAT = r106;
            Type r107 = new Type("MESSAGE", 13, 13);
            MESSAGE = r107;
            Type r108 = new Type("MUTE", 14, 14);
            MUTE = r108;
            Type r109 = new Type("GROUP", 15, 15);
            GROUP = r109;
            Type r116 = new Type("TEAM", 16, 16);
            TEAM = r116;
            Type r117 = new Type("TAG", 17, 18);
            TAG = r117;
            Type r118 = new Type("FLAG", 18, 19);
            FLAG = r118;
            Type r119 = new Type("THREAD", 19, 20);
            THREAD = r119;
            Type r120 = new Type("UNREAD_OVER_DAYS", 20, 21);
            UNREAD_OVER_DAYS = r120;
            Type r121 = new Type("CALENDAR_GROUP", 21, 22);
            CALENDAR_GROUP = r121;
            Type r122 = new Type("INSTANT_MEETING_GROUP", 22, 23);
            INSTANT_MEETING_GROUP = r122;
            Type r123 = new Type("COLLAPSED", 23, 24);
            COLLAPSED = r123;
            Type r124 = new Type("ALL_MESSAGE", 24, 25);
            ALL_MESSAGE = r124;
            Type r125 = new Type("EXPIRED_FOLD", 25, 26);
            EXPIRED_FOLD = r125;
            Type r126 = new Type("MARK_AS_DELETED", 26, 27);
            MARK_AS_DELETED = r126;
            Type r127 = new Type("MESSAGE_WITHOUT_DOUBAO", 27, 28);
            MESSAGE_WITHOUT_DOUBAO = r127;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            switch(r100) {
                case 0: goto L60;
                case 1: goto L58;
                case 2: goto L56;
                case 3: goto L54;
                case 4: goto L52;
                case 5: goto L50;
                case 6: goto L48;
                case 7: goto L46;
                case 8: goto L44;
                case 9: goto L42;
                case 10: goto L40;
                case 11: goto L38;
                case 12: goto L36;
                case 13: goto L34;
                case 14: goto L32;
                case 15: goto L30;
                case 16: goto L28;
                case 17: goto L3;
                case 18: goto L26;
                case 19: goto L24;
                case 20: goto L22;
                case 21: goto L20;
                case 22: goto L18;
                case 23: goto L16;
                case 24: goto L14;
                case 25: goto L12;
                case 26: goto L10;
                case 27: goto L8;
                case 28: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MESSAGE_WITHOUT_DOUBAO;
        L8:
            return MARK_AS_DELETED;
        L10:
            return EXPIRED_FOLD;
        L12:
            return ALL_MESSAGE;
        L14:
            return COLLAPSED;
        L16:
            return INSTANT_MEETING_GROUP;
        L18:
            return CALENDAR_GROUP;
        L20:
            return UNREAD_OVER_DAYS;
        L22:
            return THREAD;
        L24:
            return FLAG;
        L26:
            return TAG;
        L28:
            return TEAM;
        L30:
            return GROUP;
        L32:
            return MUTE;
        L34:
            return MESSAGE;
        L36:
            return CRYPTO_CHAT;
        L38:
            return DONE;
        L40:
            return TOPIC_GROUP;
        L42:
            return HELP_DESK;
        L44:
            return BOT;
        L46:
            return GROUP_CHAT;
        L48:
            return P2P_CHAT;
        L50:
            return DOC;
        L52:
            return DELAYED;
        L54:
            return UNREAD;
        L56:
            return AT_ME;
        L58:
            return INBOX;
        L60:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedFilter();
        DEFAULT_FILTER_TYPE = Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.filter_type = this.filter_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedFilter(Type r100) {
        this(r100, ByteString.EMPTY);
    }

    public FeedFilter(Type r100, ByteString r101) {
        super(ADAPTER, r101);
        this.filter_type = r100;
    }
}
