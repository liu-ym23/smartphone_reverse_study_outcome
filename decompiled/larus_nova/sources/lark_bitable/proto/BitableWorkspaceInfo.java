package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class BitableWorkspaceInfo extends Message<BitableWorkspaceInfo, Builder> {
    public static final ProtoAdapter<BitableWorkspaceInfo> ADAPTER = null;
    public static final String DEFAULT_COVER = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_SCOPE = null;
    public static final String DEFAULT_SPACE_DESCRIPTION = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final WorkspaceAllowActions allow_actions;
    public final String cover;
    public final String icon;
    public final String name;
    public final Integer scope;
    public final String space_description;
    public final String token;

    public static final class Builder extends Message.Builder<BitableWorkspaceInfo, Builder> {
        public WorkspaceAllowActions allow_actions;
        public String cover;
        public String icon;
        public String name;
        public Integer scope;
        public String space_description;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public BitableWorkspaceInfo build() {
            String r100 = this.name;
            if (r100 == null) goto L19;
            if (this.icon == null) goto L19;
            if (this.token == null) goto L19;
            if (this.cover == null) goto L19;
            if (this.scope == null) goto L19;
            if (this.space_description == null) goto L19;
            if (this.allow_actions == null) goto L19;
            return new BitableWorkspaceInfo(this.name, this.icon, this.token, this.cover, this.scope, this.space_description, this.allow_actions, super.buildUnknownFields());
        L19:
            throw Internal.missingRequiredFields(new Object[]{r100, "name", this.icon, "icon", this.token, "token", this.cover, "cover", this.scope, "scope", this.space_description, "space_description", this.allow_actions, "allow_actions"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder allow_actions(WorkspaceAllowActions r100) {
            this.allow_actions = r100;
            return this;
        }

        public Builder cover(String r100) {
            this.cover = r100;
            return this;
        }

        public Builder icon(String r100) {
            this.icon = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder scope(Integer r100) {
            this.scope = r100;
            return this;
        }

        public Builder space_description(String r100) {
            this.space_description = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BitableWorkspaceInfo extends ProtoAdapter<BitableWorkspaceInfo> {
        public ProtoAdapter_BitableWorkspaceInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, BitableWorkspaceInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public BitableWorkspaceInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.allow_actions = WorkspaceAllowActions.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.space_description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.scope = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.cover = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.icon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BitableWorkspaceInfo r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((((((r101.encodedSizeWithTag(1, r100.name) + r101.encodedSizeWithTag(2, r100.icon)) + r101.encodedSizeWithTag(3, r100.token)) + r101.encodedSizeWithTag(4, r100.cover)) + ProtoAdapter.INT32.encodedSizeWithTag(5, r100.scope)) + r101.encodedSizeWithTag(6, r100.space_description)) + WorkspaceAllowActions.ADAPTER.encodedSizeWithTag(7, r100.allow_actions)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BitableWorkspaceInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BitableWorkspaceInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BitableWorkspaceInfo r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.name);
            r102.encodeWithTag(r100, 2, r101.icon);
            r102.encodeWithTag(r100, 3, r101.token);
            r102.encodeWithTag(r100, 4, r101.cover);
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r101.scope);
            r102.encodeWithTag(r100, 6, r101.space_description);
            WorkspaceAllowActions.ADAPTER.encodeWithTag(r100, 7, r101.allow_actions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BitableWorkspaceInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BitableWorkspaceInfo();
        DEFAULT_SCOPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.icon = this.icon;
        r100.token = this.token;
        r100.cover = this.cover;
        r100.scope = this.scope;
        r100.space_description = this.space_description;
        r100.allow_actions = this.allow_actions;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BitableWorkspaceInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BitableWorkspaceInfo(String r110, String r111, String r112, String r113, Integer r114, String r115, WorkspaceAllowActions r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public BitableWorkspaceInfo(String r100, String r101, String r102, String r103, Integer r104, String r105, WorkspaceAllowActions r106, ByteString r107) {
        super(ADAPTER, r107);
        this.name = r100;
        this.icon = r101;
        this.token = r102;
        this.cover = r103;
        this.scope = r104;
        this.space_description = r105;
        this.allow_actions = r106;
    }
}
