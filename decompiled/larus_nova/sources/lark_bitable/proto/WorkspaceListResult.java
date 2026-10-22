package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class WorkspaceListResult extends Message<WorkspaceListResult, Builder> {
    public static final ProtoAdapter<WorkspaceListResult> ADAPTER = null;
    public static final Integer DEFAULT_ACTION = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final String DEFAULT_PAGE_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final Integer action;
    public final Boolean has_more;
    public final List<BitableWorkspaceInfo> items;
    public final String page_token;

    public static final class Builder extends Message.Builder<WorkspaceListResult, Builder> {
        public Integer action;
        public Boolean has_more;
        public List<BitableWorkspaceInfo> items;
        public String page_token;

        @Override // com.squareup.wire.Message.Builder
        public WorkspaceListResult build() {
            Boolean r100 = this.has_more;
            if (r100 == null) goto L11;
            if (this.page_token == null) goto L11;
            if (this.action == null) goto L11;
            return new WorkspaceListResult(this.has_more, this.page_token, this.action, this.items, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "has_more", this.page_token, "page_token", this.action, "action"});
        }

        public Builder() {
            this.items = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(Integer r100) {
            this.action = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder items(List<BitableWorkspaceInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.items = r100;
            return this;
        }

        public Builder page_token(String r100) {
            this.page_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WorkspaceListResult extends ProtoAdapter<WorkspaceListResult> {
        public ProtoAdapter_WorkspaceListResult() {
            super(FieldEncoding.LENGTH_DELIMITED, WorkspaceListResult.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public WorkspaceListResult decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.page_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.action = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.items.add(BitableWorkspaceInfo.ADAPTER.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(WorkspaceListResult r100) {
            return (((ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.has_more) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.page_token)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r100.action)) + BitableWorkspaceInfo.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.items)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WorkspaceListResult decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WorkspaceListResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WorkspaceListResult r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.has_more);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.page_token);
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r101.action);
            BitableWorkspaceInfo.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.items);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WorkspaceListResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WorkspaceListResult();
        DEFAULT_HAS_MORE = Boolean.FALSE;
        DEFAULT_ACTION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.has_more = this.has_more;
        r100.page_token = this.page_token;
        r100.action = this.action;
        r100.items = Internal.copyOf("items", this.items);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WorkspaceListResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WorkspaceListResult(Boolean r100, String r101, Integer r102, List<BitableWorkspaceInfo> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public WorkspaceListResult(Boolean r100, String r101, Integer r102, List<BitableWorkspaceInfo> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.has_more = r100;
        this.page_token = r101;
        this.action = r102;
        this.items = Internal.immutableCopyOf("items", r103);
    }
}
