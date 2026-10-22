package com.bytedance.lark.pb.todo.v1;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SearchTaskRequest extends Message<SearchTaskRequest, Builder> {
    public static final ProtoAdapter<SearchTaskRequest> ADAPTER = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final String DEFAULT_GUID_FOR_EXCLUDE_SUBTASKS = "";
    public static final String DEFAULT_QUERY = "";
    public static final DataRange DEFAULT_RANGE = null;
    public static final String DEFAULT_TOKEN = "";
    public static final ProtoAdapter_SearchTaskRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer count;
    public final String guid_for_exclude_subtasks;
    public final String query;
    public final DataRange range;
    public final String token;

    public static final class Builder extends Message.Builder<SearchTaskRequest, Builder> implements d<SearchTaskRequest> {
        public Integer count;
        public String guid_for_exclude_subtasks;
        public String query;
        public DataRange range;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public SearchTaskRequest build() {
            return new SearchTaskRequest(this.query, this.token, this.count, this.range, this.guid_for_exclude_subtasks, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder guid_for_exclude_subtasks(String r100) {
            this.guid_for_exclude_subtasks = r100;
            return this;
        }

        public Builder query(String r100) {
            this.query = r100;
            return this;
        }

        public Builder range(DataRange r100) {
            this.range = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final enum DataRange extends Enum<DataRange> implements WireEnum {
        private static final /* synthetic */ DataRange[] $VALUES = null;
        public static final ProtoAdapter<DataRange> ADAPTER = null;
        public static final DataRange ALL = null;
        public static final DataRange CAN_EDIT = null;
        public static final DataRange CAN_READ = null;
        private final int value;

        static {
            DataRange r100 = new DataRange(AccountType.ALL, 0, 0);
            ALL = r100;
            DataRange r101 = new DataRange("CAN_READ", 1, 1);
            CAN_READ = r101;
            DataRange r102 = new DataRange("CAN_EDIT", 2, 2);
            CAN_EDIT = r102;
            $VALUES = new DataRange[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(DataRange.class);
        }

        public static DataRange[] values() {
            return (DataRange[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DataRange fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CAN_EDIT;
        L12:
            return CAN_READ;
        L14:
            return ALL;
        }

        public static DataRange valueOf(String r100) {
            return (DataRange) a.a(DataRange.class, r100);
        }

        private DataRange(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_SearchTaskRequest extends ProtoAdapter<SearchTaskRequest> implements c<SearchTaskRequest> {
        public ProtoAdapter_SearchTaskRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchTaskRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchTaskRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.query = "";
            r101.token = "";
            r101.count = 0;
            r101.range = DataRange.ALL;
            r101.guid_for_exclude_subtasks = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.query = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.range = DataRange.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.guid_for_exclude_subtasks = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SearchTaskRequest r100) {
            String r101 = r100.query;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.token;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.count;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            DataRange r110 = r100.range;
            if (r110 == null) goto L17;
            int r111 = DataRange.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.guid_for_exclude_subtasks;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ SearchTaskRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchTaskRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchTaskRequest r101) throws IOException {
            String r102 = r101.query;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.token;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.count;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            DataRange r105 = r101.range;
            if (r105 == null) goto L14;
            DataRange.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.guid_for_exclude_subtasks;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchTaskRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SearchTaskRequest r100 = new ProtoAdapter_SearchTaskRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_COUNT = 0;
        DEFAULT_RANGE = DataRange.ALL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.query = this.query;
        r100.token = this.token;
        r100.count = this.count;
        r100.range = this.range;
        r100.guid_for_exclude_subtasks = this.guid_for_exclude_subtasks;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchTaskRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchTaskRequest(String r100, String r101, Integer r110, DataRange r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public SearchTaskRequest(String r100, String r101, Integer r102, DataRange r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.query = r100;
        this.token = r101;
        this.count = r102;
        this.range = r103;
        this.guid_for_exclude_subtasks = r104;
    }
}
