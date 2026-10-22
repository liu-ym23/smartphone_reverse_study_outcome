package com.ss.android.lark.pb.messages;

import com.google.protobuf.server.FieldOptions;
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

/* JADX INFO: loaded from: classes37.dex */
public final class BatchShareMessageRequest extends Message<BatchShareMessageRequest, Builder> {
    public static final ProtoAdapter<BatchShareMessageRequest> ADAPTER = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_IDS = null;
    private static final long serialVersionUID = 0;
    public final List<String> mchat_ids;
    public final FavShareOption mfav_share_option;
    public final FlagShareOption mflag_share_option;
    public final MessageShareOption mmessage_share_option;
    public final Scene mscene;
    public final List<TargetInfo> mtargets;

    public static final class Builder extends Message.Builder<BatchShareMessageRequest, Builder> {
        public List<String> mchat_ids;
        public FavShareOption mfav_share_option;
        public FlagShareOption mflag_share_option;
        public MessageShareOption mmessage_share_option;
        public Scene mscene;
        public List<TargetInfo> mtargets;

        @Override // com.squareup.wire.Message.Builder
        public BatchShareMessageRequest build() {
            Scene r100 = this.mscene;
            if (r100 == null) goto L7;
            return new BatchShareMessageRequest(this.mchat_ids, this.mtargets, this.mscene, this.mmessage_share_option, this.mfav_share_option, this.mflag_share_option, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mscene"});
        }

        public Builder() {
            this.mchat_ids = Internal.newMutableList();
            this.mtargets = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mchat_ids = r100;
            return this;
        }

        public Builder fav_share_option(FavShareOption r100) {
            this.mfav_share_option = r100;
            return this;
        }

        public Builder flag_share_option(FlagShareOption r100) {
            this.mflag_share_option = r100;
            return this;
        }

        public Builder message_share_option(MessageShareOption r100) {
            this.mmessage_share_option = r100;
            return this;
        }

        public Builder scene(Scene r100) {
            this.mscene = r100;
            return this;
        }

        public Builder targets(List<TargetInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtargets = r100;
            return this;
        }
    }

    public static final class FavShareOption extends Message<FavShareOption, Builder> {
        public static final ProtoAdapter<FavShareOption> ADAPTER = null;
        public static final String DEFAULT_FAV_ID = "";
        public static final String DEFAULT_MESSAGE_ID = "";
        public static final String DEFAULT_RESOURCE_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mfav_id;
        public final String mmessage_id;
        public final String mresource_key;

        public static final class Builder extends Message.Builder<FavShareOption, Builder> {
            public String mfav_id;
            public String mmessage_id;
            public String mresource_key;

            @Override // com.squareup.wire.Message.Builder
            public FavShareOption build() {
                String r100 = this.mmessage_id;
                if (r100 == null) goto L9;
                if (this.mresource_key == null) goto L9;
                return new FavShareOption(this.mmessage_id, this.mresource_key, this.mfav_id, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "mmessage_id", this.mresource_key, "mresource_key"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder fav_id(String r100) {
                this.mfav_id = r100;
                return this;
            }

            public Builder message_id(String r100) {
                this.mmessage_id = r100;
                return this;
            }

            public Builder resource_key(String r100) {
                this.mresource_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FavShareOption extends ProtoAdapter<FavShareOption> {
            public ProtoAdapter_FavShareOption() {
                super(FieldEncoding.LENGTH_DELIMITED, FavShareOption.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FavShareOption decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mmessage_id = "";
                r101.mresource_key = "";
                r101.mfav_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mmessage_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mresource_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mfav_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(FavShareOption r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.mmessage_id) + r101.encodedSizeWithTag(2, r100.mresource_key);
                String r103 = r100.mfav_id;
                if (r103 == null) goto L5;
                int r104 = r101.encodedSizeWithTag(3, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ FavShareOption decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FavShareOption r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FavShareOption r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.mmessage_id);
                r102.encodeWithTag(r100, 2, r101.mresource_key);
                String r103 = r101.mfav_id;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 3, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FavShareOption r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FavShareOption();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mmessage_id = this.mmessage_id;
            r100.mresource_key = this.mresource_key;
            r100.mfav_id = this.mfav_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FavShareOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public FavShareOption(String r100, String r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public FavShareOption(String r100, String r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mmessage_id = r100;
            this.mresource_key = r101;
            this.mfav_id = r102;
        }
    }

    public static final class FlagShareOption extends Message<FlagShareOption, Builder> {
        public static final ProtoAdapter<FlagShareOption> ADAPTER = null;
        public static final String DEFAULT_MESSAGE_ID = "";
        public static final String DEFAULT_ORIGIN_MERGEFORWARD_ID = "";
        public static final String DEFAULT_RESOURCE_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mmessage_id;
        public final String morigin_mergeforward_id;
        public final String mresource_key;

        public static final class Builder extends Message.Builder<FlagShareOption, Builder> {
            public String mmessage_id;
            public String morigin_mergeforward_id;
            public String mresource_key;

            @Override // com.squareup.wire.Message.Builder
            public FlagShareOption build() {
                String r100 = this.mmessage_id;
                if (r100 == null) goto L9;
                if (this.mresource_key == null) goto L9;
                return new FlagShareOption(this.mmessage_id, this.mresource_key, this.morigin_mergeforward_id, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "mmessage_id", this.mresource_key, "mresource_key"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder message_id(String r100) {
                this.mmessage_id = r100;
                return this;
            }

            public Builder origin_mergeforward_id(String r100) {
                this.morigin_mergeforward_id = r100;
                return this;
            }

            public Builder resource_key(String r100) {
                this.mresource_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FlagShareOption extends ProtoAdapter<FlagShareOption> {
            public ProtoAdapter_FlagShareOption() {
                super(FieldEncoding.LENGTH_DELIMITED, FlagShareOption.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FlagShareOption decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mmessage_id = "";
                r101.mresource_key = "";
                r101.morigin_mergeforward_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mmessage_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mresource_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.morigin_mergeforward_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(FlagShareOption r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.mmessage_id) + r101.encodedSizeWithTag(2, r100.mresource_key);
                String r103 = r100.morigin_mergeforward_id;
                if (r103 == null) goto L5;
                int r104 = r101.encodedSizeWithTag(3, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ FlagShareOption decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FlagShareOption r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FlagShareOption r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.mmessage_id);
                r102.encodeWithTag(r100, 2, r101.mresource_key);
                String r103 = r101.morigin_mergeforward_id;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 3, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FlagShareOption r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FlagShareOption();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mmessage_id = this.mmessage_id;
            r100.mresource_key = this.mresource_key;
            r100.morigin_mergeforward_id = this.morigin_mergeforward_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FlagShareOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public FlagShareOption(String r100, String r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public FlagShareOption(String r100, String r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mmessage_id = r100;
            this.mresource_key = r101;
            this.morigin_mergeforward_id = r102;
        }
    }

    public static final class MessageShareOption extends Message<MessageShareOption, Builder> {
        public static final ProtoAdapter<MessageShareOption> ADAPTER = null;
        public static final String DEFAULT_MESSAGE_ID = "";
        public static final String DEFAULT_ORIGIN_MERGEFORWARD_ID = "";
        public static final String DEFAULT_RESOURCE_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mmessage_id;
        public final String morigin_mergeforward_id;
        public final String mresource_key;

        public static final class Builder extends Message.Builder<MessageShareOption, Builder> {
            public String mmessage_id;
            public String morigin_mergeforward_id;
            public String mresource_key;

            @Override // com.squareup.wire.Message.Builder
            public MessageShareOption build() {
                String r100 = this.mmessage_id;
                if (r100 == null) goto L9;
                if (this.mresource_key == null) goto L9;
                return new MessageShareOption(this.mmessage_id, this.mresource_key, this.morigin_mergeforward_id, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "mmessage_id", this.mresource_key, "mresource_key"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder message_id(String r100) {
                this.mmessage_id = r100;
                return this;
            }

            public Builder origin_mergeforward_id(String r100) {
                this.morigin_mergeforward_id = r100;
                return this;
            }

            public Builder resource_key(String r100) {
                this.mresource_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageShareOption extends ProtoAdapter<MessageShareOption> {
            public ProtoAdapter_MessageShareOption() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageShareOption.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageShareOption decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mmessage_id = "";
                r101.mresource_key = "";
                r101.morigin_mergeforward_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mmessage_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mresource_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.morigin_mergeforward_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(MessageShareOption r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.mmessage_id) + r101.encodedSizeWithTag(2, r100.mresource_key);
                String r103 = r100.morigin_mergeforward_id;
                if (r103 == null) goto L5;
                int r104 = r101.encodedSizeWithTag(3, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageShareOption decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageShareOption r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageShareOption r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.mmessage_id);
                r102.encodeWithTag(r100, 2, r101.mresource_key);
                String r103 = r101.morigin_mergeforward_id;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 3, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageShareOption r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageShareOption();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mmessage_id = this.mmessage_id;
            r100.mresource_key = this.mresource_key;
            r100.morigin_mergeforward_id = this.morigin_mergeforward_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageShareOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageShareOption(String r100, String r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public MessageShareOption(String r100, String r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mmessage_id = r100;
            this.mresource_key = r101;
            this.morigin_mergeforward_id = r102;
        }
    }

    public static final class ProtoAdapter_BatchShareMessageRequest extends ProtoAdapter<BatchShareMessageRequest> {
        public ProtoAdapter_BatchShareMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, BatchShareMessageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BatchShareMessageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L18;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.mscene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mflag_share_option = FlagShareOption.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.mfav_share_option = FavShareOption.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.mmessage_share_option = MessageShareOption.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.mtargets.add(TargetInfo.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.mchat_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BatchShareMessageRequest r100) {
            int r101 = (ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.mchat_ids) + TargetInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mtargets)) + Scene.ADAPTER.encodedSizeWithTag(3, r100.mscene);
            MessageShareOption r102 = r100.mmessage_share_option;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = MessageShareOption.ADAPTER.encodedSizeWithTag(4, r102);
        L6:
            int r105 = r101 + r104;
            FavShareOption r106 = r100.mfav_share_option;
            if (r106 == null) goto L9;
            int r107 = FavShareOption.ADAPTER.encodedSizeWithTag(5, r106);
        L10:
            int r108 = r105 + r107;
            FlagShareOption r109 = r100.mflag_share_option;
            if (r109 == null) goto L14;
            r103 = FlagShareOption.ADAPTER.encodedSizeWithTag(6, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BatchShareMessageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BatchShareMessageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BatchShareMessageRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.mchat_ids);
            TargetInfo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mtargets);
            Scene.ADAPTER.encodeWithTag(r100, 3, r101.mscene);
            MessageShareOption r102 = r101.mmessage_share_option;
            if (r102 == null) goto L5;
            MessageShareOption.ADAPTER.encodeWithTag(r100, 4, r102);
        L5:
            FavShareOption r103 = r101.mfav_share_option;
            if (r103 == null) goto L8;
            FavShareOption.ADAPTER.encodeWithTag(r100, 5, r103);
        L8:
            FlagShareOption r104 = r101.mflag_share_option;
            if (r104 == null) goto L11;
            FlagShareOption.ADAPTER.encodeWithTag(r100, 6, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BatchShareMessageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene CHAT_MESSAGE_SHARE = null;
        public static final Scene FAV_MESSAGE_SHARE = null;
        public static final Scene FLAG_MESSAGE_SHARE = null;
        private final int value;

        static {
            Scene r100 = new Scene("CHAT_MESSAGE_SHARE", 0, 1);
            CHAT_MESSAGE_SHARE = r100;
            Scene r101 = new Scene("FAV_MESSAGE_SHARE", 1, 2);
            FAV_MESSAGE_SHARE = r101;
            Scene r102 = new Scene("FLAG_MESSAGE_SHARE", 2, 3);
            FLAG_MESSAGE_SHARE = r102;
            $VALUES = new Scene[]{r100, r101, r102};
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
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return FLAG_MESSAGE_SHARE;
        L13:
            return FAV_MESSAGE_SHARE;
        L15:
            return CHAT_MESSAGE_SHARE;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class TargetInfo extends Message<TargetInfo, Builder> {
        public static final ProtoAdapter<TargetInfo> ADAPTER = null;
        public static final String DEFAULT_CID = "";
        public static final String DEFAULT_TARGET_ID = "";
        private static final long serialVersionUID = 0;
        public final String mcid;
        public final String mtarget_id;
        public final TargetType mtarget_type;

        public static final class Builder extends Message.Builder<TargetInfo, Builder> {
            public String mcid;
            public String mtarget_id;
            public TargetType mtarget_type;

            @Override // com.squareup.wire.Message.Builder
            public TargetInfo build() {
                return new TargetInfo(this.mcid, this.mtarget_type, this.mtarget_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder cid(String r100) {
                this.mcid = r100;
                return this;
            }

            public Builder target_id(String r100) {
                this.mtarget_id = r100;
                return this;
            }

            public Builder target_type(TargetType r100) {
                this.mtarget_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TargetInfo extends ProtoAdapter<TargetInfo> {
            public ProtoAdapter_TargetInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, TargetInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TargetInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mcid = "";
                r101.mtarget_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mcid = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mtarget_type = TargetType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mtarget_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TargetInfo r100) {
                String r101 = r100.mcid;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                TargetType r104 = r100.mtarget_type;
                if (r104 == null) goto L9;
                int r105 = TargetType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mtarget_id;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TargetInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TargetInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TargetInfo r101) throws IOException {
                String r102 = r101.mcid;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                TargetType r103 = r101.mtarget_type;
                if (r103 == null) goto L8;
                TargetType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mtarget_id;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TargetInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum TargetType extends Enum<TargetType> implements WireEnum {
            private static final /* synthetic */ TargetType[] $VALUES = null;
            public static final ProtoAdapter<TargetType> ADAPTER = null;
            public static final TargetType CHAT = null;
            public static final TargetType THREAD = null;
            private final int value;

            static {
                TargetType r100 = new TargetType("CHAT", 0, 1);
                CHAT = r100;
                TargetType r101 = new TargetType("THREAD", 1, 2);
                THREAD = r101;
                $VALUES = new TargetType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(TargetType.class);
            }

            public static TargetType[] values() {
                return (TargetType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TargetType fromValue(int r100) {
                if (r100 == 1) goto L11;
                if (r100 == 2) goto L9;
                return null;
            L9:
                return THREAD;
            L11:
                return CHAT;
            }

            public static TargetType valueOf(String r100) {
                return (TargetType) a.a(TargetType.class, r100);
            }

            private TargetType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TargetInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mcid = this.mcid;
            r100.mtarget_type = this.mtarget_type;
            r100.mtarget_id = this.mtarget_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TargetInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TargetInfo(String r100, TargetType r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public TargetInfo(String r100, TargetType r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mcid = r100;
            this.mtarget_type = r101;
            this.mtarget_id = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BatchShareMessageRequest();
        FIELD_OPTIONS_MCHAT_IDS = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_ids = Internal.copyOf("mchat_ids", this.mchat_ids);
        r100.mtargets = Internal.copyOf("mtargets", this.mtargets);
        r100.mscene = this.mscene;
        r100.mmessage_share_option = this.mmessage_share_option;
        r100.mfav_share_option = this.mfav_share_option;
        r100.mflag_share_option = this.mflag_share_option;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BatchShareMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BatchShareMessageRequest(List<String> r100, List<TargetInfo> r110, Scene r111, MessageShareOption r112, FavShareOption r113, FlagShareOption r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public BatchShareMessageRequest(List<String> r100, List<TargetInfo> r101, Scene r102, MessageShareOption r103, FavShareOption r104, FlagShareOption r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mchat_ids = Internal.immutableCopyOf("mchat_ids", r100);
        this.mtargets = Internal.immutableCopyOf("mtargets", r101);
        this.mscene = r102;
        this.mmessage_share_option = r103;
        this.mfav_share_option = r104;
        this.mflag_share_option = r105;
    }
}
