package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class MentionAction extends com.squareup.wire.Message<MentionAction, Builder> {
    public static final ProtoAdapter<MentionAction> ADAPTER = null;
    public static final ActionType DEFAULT_ACTION_TYPE = null;
    public static final String DEFAULT_REDIRECT_URL = "";
    private static final long serialVersionUID = 0;
    public final ActionType action_type;
    public final String redirect_url;

    public static final enum ActionType extends Enum<ActionType> implements WireEnum {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ProtoAdapter<ActionType> ADAPTER = null;
        public static final ActionType none = null;
        public static final ActionType redirect = null;
        private final int value;

        static {
            ActionType r100 = new ActionType("none", 0, 0);
            none = r100;
            ActionType r101 = new ActionType("redirect", 1, 1);
            redirect = r101;
            $VALUES = new ActionType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(ActionType.class);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ActionType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return redirect;
        L10:
            return none;
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) a.a(ActionType.class, r100);
        }

        private ActionType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<MentionAction, Builder> {
        public ActionType action_type;
        public String redirect_url;

        @Override // com.squareup.wire.Message.Builder
        public MentionAction build() {
            ActionType r100 = this.action_type;
            if (r100 == null) goto L7;
            return new MentionAction(this.action_type, this.redirect_url, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "action_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder action_type(ActionType r100) {
            this.action_type = r100;
            return this;
        }

        public Builder redirect_url(String r100) {
            this.redirect_url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MentionAction extends ProtoAdapter<MentionAction> {
        public ProtoAdapter_MentionAction() {
            super(FieldEncoding.LENGTH_DELIMITED, MentionAction.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MentionAction decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.action_type = ActionType.none;
            r101.redirect_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.action_type = ActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.redirect_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MentionAction r100) {
            int r101 = ActionType.ADAPTER.encodedSizeWithTag(1, r100.action_type);
            String r102 = r100.redirect_url;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MentionAction decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MentionAction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MentionAction r101) throws IOException {
            ActionType.ADAPTER.encodeWithTag(r100, 1, r101.action_type);
            String r102 = r101.redirect_url;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MentionAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MentionAction();
        DEFAULT_ACTION_TYPE = ActionType.none;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.action_type = this.action_type;
        r100.redirect_url = this.redirect_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MentionAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MentionAction(ActionType r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MentionAction(ActionType r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.action_type = r100;
        this.redirect_url = r101;
    }
}
