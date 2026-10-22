package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class SearchTodoExtraInfo extends Message<SearchTodoExtraInfo, Builder> {
    public static final ProtoAdapter<SearchTodoExtraInfo> ADAPTER = null;
    public static final SearchTodoStatus DEFAULT_SEARCH_TODO_STATUS = null;
    private static final long serialVersionUID = 0;
    public final SearchTodoStatus search_todo_status;

    public static final class Builder extends Message.Builder<SearchTodoExtraInfo, Builder> {
        public SearchTodoStatus search_todo_status;

        @Override // com.squareup.wire.Message.Builder
        public SearchTodoExtraInfo build() {
            SearchTodoStatus r100 = this.search_todo_status;
            if (r100 == null) goto L7;
            return new SearchTodoExtraInfo(this.search_todo_status, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "search_todo_status"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder search_todo_status(SearchTodoStatus r100) {
            this.search_todo_status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchTodoExtraInfo extends ProtoAdapter<SearchTodoExtraInfo> {
        public ProtoAdapter_SearchTodoExtraInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchTodoExtraInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchTodoExtraInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.search_todo_status = SearchTodoStatus.NORMAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.search_todo_status = SearchTodoStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
        public int encodedSize2(SearchTodoExtraInfo r100) {
            return SearchTodoStatus.ADAPTER.encodedSizeWithTag(1, r100.search_todo_status) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchTodoExtraInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchTodoExtraInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchTodoExtraInfo r101) throws IOException {
            SearchTodoStatus.ADAPTER.encodeWithTag(r100, 1, r101.search_todo_status);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchTodoExtraInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SearchTodoStatus extends Enum<SearchTodoStatus> implements WireEnum {
        private static final /* synthetic */ SearchTodoStatus[] $VALUES = null;
        public static final ProtoAdapter<SearchTodoStatus> ADAPTER = null;
        public static final SearchTodoStatus NORMAL = null;
        public static final SearchTodoStatus OVER_DEPTH = null;
        private final int value;

        static {
            SearchTodoStatus r100 = new SearchTodoStatus(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            SearchTodoStatus r101 = new SearchTodoStatus("OVER_DEPTH", 1, 1);
            OVER_DEPTH = r101;
            $VALUES = new SearchTodoStatus[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(SearchTodoStatus.class);
        }

        public static SearchTodoStatus[] values() {
            return (SearchTodoStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SearchTodoStatus fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return OVER_DEPTH;
        L10:
            return NORMAL;
        }

        public static SearchTodoStatus valueOf(String r100) {
            return (SearchTodoStatus) a.a(SearchTodoStatus.class, r100);
        }

        private SearchTodoStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchTodoExtraInfo();
        DEFAULT_SEARCH_TODO_STATUS = SearchTodoStatus.NORMAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.search_todo_status = this.search_todo_status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchTodoExtraInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchTodoExtraInfo(SearchTodoStatus r100) {
        this(r100, ByteString.EMPTY);
    }

    public SearchTodoExtraInfo(SearchTodoStatus r100, ByteString r101) {
        super(ADAPTER, r101);
        this.search_todo_status = r100;
    }
}
