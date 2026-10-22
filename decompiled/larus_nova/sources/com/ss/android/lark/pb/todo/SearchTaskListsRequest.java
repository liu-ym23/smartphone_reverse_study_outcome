package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class SearchTaskListsRequest extends Message<SearchTaskListsRequest, Builder> {
    public static final ProtoAdapter<SearchTaskListsRequest> ADAPTER = null;
    public static final String DEFAULT_AGENT_ID = "";
    public static final Long DEFAULT_COUNT = null;
    public static final String DEFAULT_QUERY = "";
    private static final long serialVersionUID = 0;
    public final String magent_id;
    public final Long mcount;
    public final String mquery;
    public final Scene mscene;

    public static final class Builder extends Message.Builder<SearchTaskListsRequest, Builder> {
        public String magent_id;
        public Long mcount;
        public String mquery;
        public Scene mscene;

        @Override // com.squareup.wire.Message.Builder
        public SearchTaskListsRequest build() {
            return new SearchTaskListsRequest(this.mscene, this.mquery, this.mcount, this.magent_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder agent_id(String r100) {
            this.magent_id = r100;
            return this;
        }

        public Builder count(Long r100) {
            this.mcount = r100;
            return this;
        }

        public Builder query(String r100) {
            this.mquery = r100;
            return this;
        }

        public Builder scene(Scene r100) {
            this.mscene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchTaskListsRequest extends ProtoAdapter<SearchTaskListsRequest> {
        public ProtoAdapter_SearchTaskListsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchTaskListsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchTaskListsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mquery = "";
            r101.mcount = 0L;
            r101.magent_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mscene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mquery = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mcount = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.magent_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SearchTaskListsRequest r100) {
            Scene r101 = r100.mscene;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Scene.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mquery;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.mcount;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.magent_id;
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
        public /* bridge */ /* synthetic */ SearchTaskListsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchTaskListsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchTaskListsRequest r101) throws IOException {
            Scene r102 = r101.mscene;
            if (r102 == null) goto L5;
            Scene.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mquery;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.mcount;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.magent_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchTaskListsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene EDITABLE = null;
        public static final Scene READABLE = null;
        private final int value;

        static {
            Scene r100 = new Scene("READABLE", 0, 1);
            READABLE = r100;
            Scene r101 = new Scene("EDITABLE", 1, 2);
            EDITABLE = r101;
            $VALUES = new Scene[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return EDITABLE;
        L11:
            return READABLE;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchTaskListsRequest();
        DEFAULT_COUNT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mscene = this.mscene;
        r100.mquery = this.mquery;
        r100.mcount = this.mcount;
        r100.magent_id = this.magent_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchTaskListsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchTaskListsRequest(Scene r100, String r101, Long r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SearchTaskListsRequest(Scene r100, String r101, Long r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mscene = r100;
        this.mquery = r101;
        this.mcount = r102;
        this.magent_id = r103;
    }
}
