package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class BaseEnum extends Message<BaseEnum, Builder> {
    public static final ProtoAdapter<BaseEnum> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<BaseEnum, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public BaseEnum build() {
            return new BaseEnum(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final enum LocalAbility extends Enum<LocalAbility> implements WireEnum {
        private static final /* synthetic */ LocalAbility[] $VALUES = null;
        public static final ProtoAdapter<LocalAbility> ADAPTER = null;
        public static final LocalAbility CHAT = null;
        public static final LocalAbility CHATTER = null;
        public static final LocalAbility CHATTER_AND_CHAT = null;
        public static final LocalAbility MESSAGE = null;
        private final int value;

        static {
            LocalAbility r100 = new LocalAbility("CHATTER", 0, 1);
            CHATTER = r100;
            LocalAbility r101 = new LocalAbility("CHAT", 1, 2);
            CHAT = r101;
            LocalAbility r102 = new LocalAbility("CHATTER_AND_CHAT", 2, 3);
            CHATTER_AND_CHAT = r102;
            LocalAbility r103 = new LocalAbility("MESSAGE", 3, 4);
            MESSAGE = r103;
            $VALUES = new LocalAbility[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(LocalAbility.class);
        }

        public static LocalAbility[] values() {
            return (LocalAbility[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static LocalAbility fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return MESSAGE;
        L15:
            return CHATTER_AND_CHAT;
        L17:
            return CHAT;
        L19:
            return CHATTER;
        }

        public static LocalAbility valueOf(String r100) {
            return (LocalAbility) a.a(LocalAbility.class, r100);
        }

        private LocalAbility(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum MergePolicy extends Enum<MergePolicy> implements WireEnum {
        private static final /* synthetic */ MergePolicy[] $VALUES = null;
        public static final ProtoAdapter<MergePolicy> ADAPTER = null;
        public static final MergePolicy COMBINE_LOCAL_AND_SERVER = null;
        public static final MergePolicy LOCAL_ONLY = null;
        public static final MergePolicy SERVER_ONLY = null;
        private final int value;

        static {
            MergePolicy r100 = new MergePolicy("LOCAL_ONLY", 0, 1);
            LOCAL_ONLY = r100;
            MergePolicy r101 = new MergePolicy("SERVER_ONLY", 1, 2);
            SERVER_ONLY = r101;
            MergePolicy r102 = new MergePolicy("COMBINE_LOCAL_AND_SERVER", 2, 3);
            COMBINE_LOCAL_AND_SERVER = r102;
            $VALUES = new MergePolicy[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(MergePolicy.class);
        }

        public static MergePolicy[] values() {
            return (MergePolicy[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static MergePolicy fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return COMBINE_LOCAL_AND_SERVER;
        L13:
            return SERVER_ONLY;
        L15:
            return LOCAL_ONLY;
        }

        public static MergePolicy valueOf(String r100) {
            return (MergePolicy) a.a(MergePolicy.class, r100);
        }

        private MergePolicy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_BaseEnum extends ProtoAdapter<BaseEnum> {
        public ProtoAdapter_BaseEnum() {
            super(FieldEncoding.LENGTH_DELIMITED, BaseEnum.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BaseEnum decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L6;
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L6:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BaseEnum r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BaseEnum decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BaseEnum r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BaseEnum r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BaseEnum r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum QueryInputState extends Enum<QueryInputState> implements WireEnum {
        private static final /* synthetic */ QueryInputState[] $VALUES = null;
        public static final ProtoAdapter<QueryInputState> ADAPTER = null;
        public static final QueryInputState COMPOSE = null;
        public static final QueryInputState EXPAND = null;
        public static final QueryInputState SHRINK = null;
        private final int value;

        static {
            QueryInputState r100 = new QueryInputState("EXPAND", 0, 1);
            EXPAND = r100;
            QueryInputState r101 = new QueryInputState("SHRINK", 1, 2);
            SHRINK = r101;
            QueryInputState r102 = new QueryInputState("COMPOSE", 2, 4);
            COMPOSE = r102;
            $VALUES = new QueryInputState[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(QueryInputState.class);
        }

        public static QueryInputState[] values() {
            return (QueryInputState[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static QueryInputState fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 4) goto L11;
            return null;
        L11:
            return COMPOSE;
        L13:
            return SHRINK;
        L15:
            return EXPAND;
        }

        public static QueryInputState valueOf(String r100) {
            return (QueryInputState) a.a(QueryInputState.class, r100);
        }

        private QueryInputState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BaseEnum();
    }

    public BaseEnum() {
        this(ByteString.EMPTY);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BaseEnum.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BaseEnum(ByteString r100) {
        super(ADAPTER, r100);
    }
}
