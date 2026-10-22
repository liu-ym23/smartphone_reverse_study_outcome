package com.bytedance.lark.pb.basic.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class SystemMessageItemAction extends com.squareup.wire.Message<SystemMessageItemAction, Builder> {
    public static final ProtoAdapter<SystemMessageItemAction> ADAPTER = null;
    public static final FieldOptions FIELD_OPTIONS_CHATTER_TOOLTIP = null;
    public static final FieldOptions FIELD_OPTIONS_INVITE_AT_CHATTERS = null;
    public static final FieldOptions FIELD_OPTIONS_LARK_COMMAND = null;
    public static final FieldOptions FIELD_OPTIONS_URL = null;
    private static final long serialVersionUID = 0;
    public final ChatterTooltip chatter_tooltip;
    public final InviteAtChatters invite_at_chatters;
    public final LarkCommand lark_command;
    public final Url url;

    public static final class Builder extends com.squareup.wire.Message.Builder<SystemMessageItemAction, Builder> {
        public ChatterTooltip chatter_tooltip;
        public InviteAtChatters invite_at_chatters;
        public LarkCommand lark_command;
        public Url url;

        @Override // com.squareup.wire.Message.Builder
        public SystemMessageItemAction build() {
            return new SystemMessageItemAction(this.invite_at_chatters, this.url, this.lark_command, this.chatter_tooltip, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder chatter_tooltip(ChatterTooltip r100) {
            this.chatter_tooltip = r100;
            this.invite_at_chatters = null;
            this.url = null;
            this.lark_command = null;
            return this;
        }

        public Builder invite_at_chatters(InviteAtChatters r100) {
            this.invite_at_chatters = r100;
            this.url = null;
            this.lark_command = null;
            this.chatter_tooltip = null;
            return this;
        }

        public Builder lark_command(LarkCommand r100) {
            this.lark_command = r100;
            this.invite_at_chatters = null;
            this.url = null;
            this.chatter_tooltip = null;
            return this;
        }

        public Builder url(Url r100) {
            this.url = r100;
            this.invite_at_chatters = null;
            this.lark_command = null;
            this.chatter_tooltip = null;
            return this;
        }
    }

    public static final class ChatterTooltip extends com.squareup.wire.Message<ChatterTooltip, Builder> {
        public static final ProtoAdapter<ChatterTooltip> ADAPTER = null;
        public static final Type DEFAULT_CHATTER_TOOLTIP_TYPE = null;
        private static final long serialVersionUID = 0;
        public final Type chatter_tooltip_type;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatterTooltip, Builder> {
            public Type chatter_tooltip_type;

            @Override // com.squareup.wire.Message.Builder
            public ChatterTooltip build() {
                return new ChatterTooltip(this.chatter_tooltip_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chatter_tooltip_type(Type r100) {
                this.chatter_tooltip_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatterTooltip extends ProtoAdapter<ChatterTooltip> {
            public ProtoAdapter_ChatterTooltip() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatterTooltip.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatterTooltip decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chatter_tooltip_type = Type.UNKNOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.chatter_tooltip_type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
            public int encodedSize2(ChatterTooltip r100) {
                Type r101 = r100.chatter_tooltip_type;
                if (r101 == null) goto L5;
                int r102 = Type.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ChatterTooltip decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatterTooltip r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatterTooltip r101) throws IOException {
                Type r102 = r101.chatter_tooltip_type;
                if (r102 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatterTooltip r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type SIMPLIFY_SYSTEM_MESSAGE = null;
            public static final Type UNKNOWN = null;
            private final int value;

            static {
                Type r100 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Type r101 = new Type("SIMPLIFY_SYSTEM_MESSAGE", 1, 1);
                SIMPLIFY_SYSTEM_MESSAGE = r101;
                $VALUES = new Type[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return SIMPLIFY_SYSTEM_MESSAGE;
            L10:
                return UNKNOWN;
            }

            public static Type valueOf(String r100) {
                return (Type) a.a(Type.class, r100);
            }

            private Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatterTooltip();
            DEFAULT_CHATTER_TOOLTIP_TYPE = Type.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chatter_tooltip_type = this.chatter_tooltip_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatterTooltip.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatterTooltip(Type r100) {
            this(r100, ByteString.EMPTY);
        }

        public ChatterTooltip(Type r100, ByteString r101) {
            super(ADAPTER, r101);
            this.chatter_tooltip_type = r100;
        }
    }

    public static final class InviteAtChatters extends com.squareup.wire.Message<InviteAtChatters, Builder> {
        public static final ProtoAdapter<InviteAtChatters> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Long> at_chatter_ids;

        public static final class Builder extends com.squareup.wire.Message.Builder<InviteAtChatters, Builder> {
            public List<Long> at_chatter_ids;

            @Override // com.squareup.wire.Message.Builder
            public InviteAtChatters build() {
                return new InviteAtChatters(this.at_chatter_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.at_chatter_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder at_chatter_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.at_chatter_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_InviteAtChatters extends ProtoAdapter<InviteAtChatters> {
            public ProtoAdapter_InviteAtChatters() {
                super(FieldEncoding.LENGTH_DELIMITED, InviteAtChatters.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public InviteAtChatters decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.at_chatter_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(InviteAtChatters r100) {
                return ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(1, r100.at_chatter_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ InviteAtChatters decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(InviteAtChatters r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, InviteAtChatters r101) throws IOException {
                ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 1, r101.at_chatter_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InviteAtChatters r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_InviteAtChatters();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.at_chatter_ids = Internal.copyOf("at_chatter_ids", this.at_chatter_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return InviteAtChatters.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public InviteAtChatters(List<Long> r100) {
            this(r100, ByteString.EMPTY);
        }

        public InviteAtChatters(List<Long> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.at_chatter_ids = Internal.immutableCopyOf("at_chatter_ids", r100);
        }
    }

    public static final class LarkCommand extends com.squareup.wire.Message<LarkCommand, Builder> {
        public static final ProtoAdapter<LarkCommand> ADAPTER = null;
        public static final Integer DEFAULT_CMD = null;
        public static final ByteString DEFAULT_PAYLOAD = null;
        private static final long serialVersionUID = 0;
        public final Integer cmd;
        public final ByteString payload;

        public static final class Builder extends com.squareup.wire.Message.Builder<LarkCommand, Builder> {
            public Integer cmd;
            public ByteString payload;

            @Override // com.squareup.wire.Message.Builder
            public LarkCommand build() {
                return new LarkCommand(this.payload, this.cmd, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder cmd(Integer r100) {
                this.cmd = r100;
                return this;
            }

            public Builder payload(ByteString r100) {
                this.payload = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_LarkCommand extends ProtoAdapter<LarkCommand> {
            public ProtoAdapter_LarkCommand() {
                super(FieldEncoding.LENGTH_DELIMITED, LarkCommand.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LarkCommand decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.payload = ByteString.EMPTY;
                r101.cmd = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.payload = ProtoAdapter.BYTES.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.cmd = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(LarkCommand r100) {
                ByteString r101 = r100.payload;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.cmd;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ LarkCommand decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LarkCommand r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LarkCommand r101) throws IOException {
                ByteString r102 = r101.payload;
                if (r102 == null) goto L5;
                ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.cmd;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkCommand r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LarkCommand();
            DEFAULT_PAYLOAD = ByteString.EMPTY;
            DEFAULT_CMD = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.payload = this.payload;
            r100.cmd = this.cmd;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LarkCommand.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public LarkCommand(ByteString r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public LarkCommand(ByteString r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.payload = r100;
            this.cmd = r101;
        }
    }

    public static final class ProtoAdapter_SystemMessageItemAction extends ProtoAdapter<SystemMessageItemAction> {
        public ProtoAdapter_SystemMessageItemAction() {
            super(FieldEncoding.LENGTH_DELIMITED, SystemMessageItemAction.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SystemMessageItemAction decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.invite_at_chatters(InviteAtChatters.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.url(Url.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.lark_command(LarkCommand.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.chatter_tooltip(ChatterTooltip.ADAPTER.decode(r100));
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
        public int encodedSize2(SystemMessageItemAction r100) {
            InviteAtChatters r101 = r100.invite_at_chatters;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = InviteAtChatters.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Url r104 = r100.url;
            if (r104 == null) goto L9;
            int r105 = Url.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            LarkCommand r107 = r100.lark_command;
            if (r107 == null) goto L13;
            int r108 = LarkCommand.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ChatterTooltip r110 = r100.chatter_tooltip;
            if (r110 == null) goto L18;
            r102 = ChatterTooltip.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ SystemMessageItemAction decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SystemMessageItemAction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SystemMessageItemAction r101) throws IOException {
            InviteAtChatters r102 = r101.invite_at_chatters;
            if (r102 == null) goto L5;
            InviteAtChatters.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Url r103 = r101.url;
            if (r103 == null) goto L8;
            Url.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            LarkCommand r104 = r101.lark_command;
            if (r104 == null) goto L11;
            LarkCommand.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            ChatterTooltip r105 = r101.chatter_tooltip;
            if (r105 == null) goto L14;
            ChatterTooltip.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SystemMessageItemAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Url extends com.squareup.wire.Message<Url, Builder> {
        public static final ProtoAdapter<Url> ADAPTER = null;
        public static final String DEFAULT_ANDROID = "";
        public static final String DEFAULT_COMMON = "";
        public static final String DEFAULT_IOS = "";
        public static final String DEFAULT_PC = "";
        public static final String DEFAULT_WEB = "";
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: android, reason: collision with root package name */
        public final String f253567android;
        public final String common;
        public final String ios;

        /* JADX INFO: renamed from: pc, reason: collision with root package name */
        public final String f253568pc;

        /* JADX INFO: renamed from: web, reason: collision with root package name */
        public final String f253569web;

        public static final class Builder extends com.squareup.wire.Message.Builder<Url, Builder> {

            /* JADX INFO: renamed from: android, reason: collision with root package name */
            public String f253570android;
            public String common;
            public String ios;

            /* JADX INFO: renamed from: pc, reason: collision with root package name */
            public String f253571pc;

            /* JADX INFO: renamed from: web, reason: collision with root package name */
            public String f253572web;

            @Override // com.squareup.wire.Message.Builder
            public Url build() {
                return new Url(this.ios, this.f253570android, this.f253571pc, this.f253572web, this.common, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder android(String r100) {
                this.f253570android = r100;
                return this;
            }

            public Builder common(String r100) {
                this.common = r100;
                return this;
            }

            public Builder ios(String r100) {
                this.ios = r100;
                return this;
            }

            public Builder pc(String r100) {
                this.f253571pc = r100;
                return this;
            }

            public Builder web(String r100) {
                this.f253572web = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Url extends ProtoAdapter<Url> {
            public ProtoAdapter_Url() {
                super(FieldEncoding.LENGTH_DELIMITED, Url.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Url decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.ios = "";
                r101.f253570android = "";
                r101.f253571pc = "";
                r101.f253572web = "";
                r101.common = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.ios = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.f253570android = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.f253571pc = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.f253572web = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.common = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Url r100) {
                String r101 = r100.ios;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.f253567android;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.f253568pc;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.f253569web;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.common;
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
            public /* bridge */ /* synthetic */ Url decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Url r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Url r101) throws IOException {
                String r102 = r101.ios;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.f253567android;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.f253568pc;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.f253569web;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.common;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Url r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Url();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.ios = this.ios;
            r100.f253570android = this.f253567android;
            r100.f253571pc = this.f253568pc;
            r100.f253572web = this.f253569web;
            r100.common = this.common;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Url.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Url(String r100, String r101, String r110, String r111, String r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public Url(String r100, String r101, String r102, String r103, String r104, ByteString r105) {
            super(ADAPTER, r105);
            this.ios = r100;
            this.f253567android = r101;
            this.f253568pc = r102;
            this.f253569web = r103;
            this.common = r104;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SystemMessageItemAction();
        FIELD_OPTIONS_INVITE_AT_CHATTERS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_URL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_LARK_COMMAND = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_CHATTER_TOOLTIP = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.invite_at_chatters = this.invite_at_chatters;
        r100.url = this.url;
        r100.lark_command = this.lark_command;
        r100.chatter_tooltip = this.chatter_tooltip;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SystemMessageItemAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SystemMessageItemAction(InviteAtChatters r100, Url r101, LarkCommand r102, ChatterTooltip r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SystemMessageItemAction(InviteAtChatters r100, Url r101, LarkCommand r102, ChatterTooltip r103, ByteString r104) {
        super(ADAPTER, r104);
        if (Internal.countNonNull(r100, r101, r102, r103, new Object[0]) > 1) goto L7;
        this.invite_at_chatters = r100;
        this.url = r101;
        this.lark_command = r102;
        this.chatter_tooltip = r103;
        return;
    L7:
        throw new IllegalArgumentException("at most one of invite_at_chatters, url, lark_command, chatter_tooltip may be non-null");
    }
}
