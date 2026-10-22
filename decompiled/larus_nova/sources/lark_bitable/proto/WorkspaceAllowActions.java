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
public final class WorkspaceAllowActions extends Message<WorkspaceAllowActions, Builder> {
    public static final ProtoAdapter<WorkspaceAllowActions> ADAPTER = null;
    public static final Boolean DEFAULT_EDIT = null;
    public static final Boolean DEFAULT_MANAGE = null;
    public static final Boolean DEFAULT_MOVE_IN = null;
    public static final Boolean DEFAULT_MOVE_OUT = null;
    public static final Boolean DEFAULT_VIEW = null;
    private static final long serialVersionUID = 0;
    public final Boolean edit;
    public final Boolean manage;
    public final Boolean move_in;
    public final Boolean move_out;
    public final Boolean view;

    public static final class Builder extends Message.Builder<WorkspaceAllowActions, Builder> {
        public Boolean edit;
        public Boolean manage;
        public Boolean move_in;
        public Boolean move_out;
        public Boolean view;

        @Override // com.squareup.wire.Message.Builder
        public WorkspaceAllowActions build() {
            Boolean r100 = this.manage;
            if (r100 == null) goto L15;
            if (this.move_in == null) goto L15;
            if (this.move_out == null) goto L15;
            if (this.edit == null) goto L15;
            if (this.view == null) goto L15;
            return new WorkspaceAllowActions(this.manage, this.move_in, this.move_out, this.edit, this.view, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, "manage", this.move_in, "move_in", this.move_out, "move_out", this.edit, "edit", this.view, "view"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder edit(Boolean r100) {
            this.edit = r100;
            return this;
        }

        public Builder manage(Boolean r100) {
            this.manage = r100;
            return this;
        }

        public Builder move_in(Boolean r100) {
            this.move_in = r100;
            return this;
        }

        public Builder move_out(Boolean r100) {
            this.move_out = r100;
            return this;
        }

        public Builder view(Boolean r100) {
            this.view = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WorkspaceAllowActions extends ProtoAdapter<WorkspaceAllowActions> {
        public ProtoAdapter_WorkspaceAllowActions() {
            super(FieldEncoding.LENGTH_DELIMITED, WorkspaceAllowActions.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public WorkspaceAllowActions decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.manage = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.move_in = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.move_out = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.edit = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.view = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(WorkspaceAllowActions r100) {
            ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
            return ((((r101.encodedSizeWithTag(1, r100.manage) + r101.encodedSizeWithTag(2, r100.move_in)) + r101.encodedSizeWithTag(3, r100.move_out)) + r101.encodedSizeWithTag(4, r100.edit)) + r101.encodedSizeWithTag(5, r100.view)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WorkspaceAllowActions decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WorkspaceAllowActions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WorkspaceAllowActions r101) throws IOException {
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 1, r101.manage);
            r102.encodeWithTag(r100, 2, r101.move_in);
            r102.encodeWithTag(r100, 3, r101.move_out);
            r102.encodeWithTag(r100, 4, r101.edit);
            r102.encodeWithTag(r100, 5, r101.view);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WorkspaceAllowActions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WorkspaceAllowActions();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_MANAGE = r100;
        DEFAULT_MOVE_IN = r100;
        DEFAULT_MOVE_OUT = r100;
        DEFAULT_EDIT = r100;
        DEFAULT_VIEW = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.manage = this.manage;
        r100.move_in = this.move_in;
        r100.move_out = this.move_out;
        r100.edit = this.edit;
        r100.view = this.view;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WorkspaceAllowActions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WorkspaceAllowActions(Boolean r100, Boolean r101, Boolean r110, Boolean r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public WorkspaceAllowActions(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.manage = r100;
        this.move_in = r101;
        this.move_out = r102;
        this.edit = r103;
        this.view = r104;
    }
}
