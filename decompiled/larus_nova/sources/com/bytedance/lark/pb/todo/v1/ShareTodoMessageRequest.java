package com.bytedance.lark.pb.todo.v1;

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
public final class ShareTodoMessageRequest extends Message<ShareTodoMessageRequest, Builder> {
    public static final ProtoAdapter<ShareTodoMessageRequest> ADAPTER = null;
    public static final ShareType DEFAULT_SHARE_TYPE = null;
    public static final String DEFAULT_TODO_GUID = "";
    public static final ProtoAdapter_ShareTodoMessageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> chat_ids;
    public final ShareType share_type;
    public final List<ShareTodoMessageRequestThreadInfo> thread_infos;
    public final String todo_guid;

    public static final class Builder extends Message.Builder<ShareTodoMessageRequest, Builder> implements d<ShareTodoMessageRequest> {
        public List<String> chat_ids;
        public ShareType share_type;
        public List<ShareTodoMessageRequestThreadInfo> thread_infos;
        public String todo_guid;

        @Override // com.squareup.wire.Message.Builder
        public ShareTodoMessageRequest build() {
            return new ShareTodoMessageRequest(this.todo_guid, this.chat_ids, this.share_type, this.thread_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.chat_ids = Internal.newMutableList();
            this.thread_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_ids = r100;
            return this;
        }

        public Builder share_type(ShareType r100) {
            this.share_type = r100;
            return this;
        }

        public Builder thread_infos(List<ShareTodoMessageRequestThreadInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.thread_infos = r100;
            return this;
        }

        public Builder todo_guid(String r100) {
            this.todo_guid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ShareTodoMessageRequest extends ProtoAdapter<ShareTodoMessageRequest> implements c<ShareTodoMessageRequest> {
        public ProtoAdapter_ShareTodoMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ShareTodoMessageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ShareTodoMessageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.todo_guid = "";
            r101.share_type = ShareType.UNKNOWN_SHARE_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.todo_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.share_type = ShareType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.thread_infos.add(ShareTodoMessageRequestThreadInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(ShareTodoMessageRequest r100) {
            String r101 = r100.todo_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.chat_ids);
            ShareType r105 = r100.share_type;
            if (r105 == null) goto L10;
            r102 = ShareType.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            return ((r104 + r102) + ShareTodoMessageRequestThreadInfo.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.thread_infos)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ShareTodoMessageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ShareTodoMessageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ShareTodoMessageRequest r101) throws IOException {
            String r102 = r101.todo_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.chat_ids);
            ShareType r103 = r101.share_type;
            if (r103 == null) goto L8;
            ShareType.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            ShareTodoMessageRequestThreadInfo.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.thread_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareTodoMessageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum ShareType extends Enum<ShareType> implements WireEnum {
        private static final /* synthetic */ ShareType[] $VALUES = null;
        public static final ProtoAdapter<ShareType> ADAPTER = null;
        public static final ShareType CREATE = null;
        public static final ShareType SHARE = null;
        public static final ShareType UNKNOWN_SHARE_TYPE = null;
        private final int value;

        static {
            ShareType r100 = new ShareType("UNKNOWN_SHARE_TYPE", 0, 1);
            UNKNOWN_SHARE_TYPE = r100;
            ShareType r101 = new ShareType("SHARE", 1, 2);
            SHARE = r101;
            ShareType r102 = new ShareType("CREATE", 2, 3);
            CREATE = r102;
            $VALUES = new ShareType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ShareType.class);
        }

        public static ShareType[] values() {
            return (ShareType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ShareType fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return CREATE;
        L13:
            return SHARE;
        L15:
            return UNKNOWN_SHARE_TYPE;
        }

        public static ShareType valueOf(String r100) {
            return (ShareType) a.a(ShareType.class, r100);
        }

        private ShareType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_ShareTodoMessageRequest r100 = new ProtoAdapter_ShareTodoMessageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SHARE_TYPE = ShareType.UNKNOWN_SHARE_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo_guid = this.todo_guid;
        r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
        r100.share_type = this.share_type;
        r100.thread_infos = Internal.copyOf("thread_infos", this.thread_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ShareTodoMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ShareTodoMessageRequest(String r100, List<String> r101, ShareType r102, List<ShareTodoMessageRequestThreadInfo> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ShareTodoMessageRequest(String r100, List<String> r101, ShareType r102, List<ShareTodoMessageRequestThreadInfo> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.todo_guid = r100;
        this.chat_ids = Internal.immutableCopyOf("chat_ids", r101);
        this.share_type = r102;
        this.thread_infos = Internal.immutableCopyOf("thread_infos", r103);
    }
}
