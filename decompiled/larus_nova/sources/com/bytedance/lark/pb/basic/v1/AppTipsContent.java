package com.bytedance.lark.pb.basic.v1;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AppTipsContent extends com.squareup.wire.Message<AppTipsContent, Builder> {
    public static final ProtoAdapter<AppTipsContent> ADAPTER = null;
    public static final String DEFAULT_I18N_MSG = "";
    public static final String DEFAULT_I18N_TITLE = "";
    private static final long serialVersionUID = 0;
    public final List<ActionInfo> actions;
    public final String i18n_msg;
    public final String i18n_title;

    public static final class Builder extends com.squareup.wire.Message.Builder<AppTipsContent, Builder> {
        public List<ActionInfo> actions;
        public String i18n_msg;
        public String i18n_title;

        @Override // com.squareup.wire.Message.Builder
        public AppTipsContent build() {
            return new AppTipsContent(this.i18n_title, this.i18n_msg, this.actions, super.buildUnknownFields());
        }

        public Builder() {
            this.actions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder actions(List<ActionInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.actions = r100;
            return this;
        }

        public Builder i18n_msg(String r100) {
            this.i18n_msg = r100;
            return this;
        }

        public Builder i18n_title(String r100) {
            this.i18n_title = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AppTipsContent extends ProtoAdapter<AppTipsContent> {
        public ProtoAdapter_AppTipsContent() {
            super(FieldEncoding.LENGTH_DELIMITED, AppTipsContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AppTipsContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.i18n_title = "";
            r101.i18n_msg = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.i18n_title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.i18n_msg = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.actions.add(ActionInfo.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AppTipsContent r100) {
            String r101 = r100.i18n_title;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.i18n_msg;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + ActionInfo.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.actions)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AppTipsContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppTipsContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppTipsContent r101) throws IOException {
            String r102 = r101.i18n_title;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.i18n_msg;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ActionInfo.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.actions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppTipsContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppTipsContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.i18n_title = this.i18n_title;
        r100.i18n_msg = this.i18n_msg;
        r100.actions = Internal.copyOf(SlcCommonAction.KEY_ACTIONS, this.actions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppTipsContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppTipsContent(String r100, String r101, List<ActionInfo> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public AppTipsContent(String r100, String r101, List<ActionInfo> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.i18n_title = r100;
        this.i18n_msg = r101;
        this.actions = Internal.immutableCopyOf(SlcCommonAction.KEY_ACTIONS, r102);
    }
}
