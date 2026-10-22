package com.bytedance.lark.pb.settings.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class NotificationSetting extends Message<NotificationSetting, Builder> {
    public static final ProtoAdapter<NotificationSetting> ADAPTER = null;
    public static final Boolean DEFAULT_ALL = null;
    public static final Boolean DEFAULT_NONE = null;
    public static final FieldOptions FIELD_OPTIONS_ALL = null;
    public static final FieldOptions FIELD_OPTIONS_NONE = null;
    public static final FieldOptions FIELD_OPTIONS_SPECIFIC_MESSAGES = null;
    private static final long serialVersionUID = 0;
    public final Boolean all;
    public final Boolean none;
    public final SpecificMessages specific_messages;

    public static final class Builder extends Message.Builder<NotificationSetting, Builder> {
        public Boolean all;
        public Boolean none;
        public SpecificMessages specific_messages;

        @Override // com.squareup.wire.Message.Builder
        public NotificationSetting build() {
            return new NotificationSetting(this.all, this.specific_messages, this.none, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder all(Boolean r100) {
            this.all = r100;
            this.specific_messages = null;
            this.none = null;
            return this;
        }

        public Builder none(Boolean r100) {
            this.none = r100;
            this.all = null;
            this.specific_messages = null;
            return this;
        }

        public Builder specific_messages(SpecificMessages r100) {
            this.specific_messages = r100;
            this.all = null;
            this.none = null;
            return this;
        }
    }

    public static final class ProtoAdapter_NotificationSetting extends ProtoAdapter<NotificationSetting> {
        public ProtoAdapter_NotificationSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, NotificationSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NotificationSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.all(r102);
            r101.none(r102);
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.all(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.specific_messages(SpecificMessages.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.none(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(NotificationSetting r100) {
            Boolean r101 = r100.all;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            SpecificMessages r104 = r100.specific_messages;
            if (r104 == null) goto L9;
            int r105 = SpecificMessages.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.none;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ NotificationSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NotificationSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NotificationSetting r101) throws IOException {
            Boolean r102 = r101.all;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            SpecificMessages r103 = r101.specific_messages;
            if (r103 == null) goto L8;
            SpecificMessages.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.none;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NotificationSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SpecificMessages extends Message<SpecificMessages, Builder> {
        public static final ProtoAdapter<SpecificMessages> ADAPTER = null;
        public static final Boolean DEFAULT_BUZZ = null;
        public static final Boolean DEFAULT_MENTION = null;
        private static final long serialVersionUID = 0;
        public final Boolean buzz;
        public final Boolean mention;

        public static final class Builder extends Message.Builder<SpecificMessages, Builder> {
            public Boolean buzz;
            public Boolean mention;

            @Override // com.squareup.wire.Message.Builder
            public SpecificMessages build() {
                return new SpecificMessages(this.mention, this.buzz, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder buzz(Boolean r100) {
                this.buzz = r100;
                return this;
            }

            public Builder mention(Boolean r100) {
                this.mention = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SpecificMessages extends ProtoAdapter<SpecificMessages> {
            public ProtoAdapter_SpecificMessages() {
                super(FieldEncoding.LENGTH_DELIMITED, SpecificMessages.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SpecificMessages decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.mention = r102;
                r101.buzz = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L12;
                if (r104 != 1) goto L8;
                r101.mention = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L9;
                r101.buzz = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SpecificMessages r100) {
                Boolean r101 = r100.mention;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.buzz;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SpecificMessages decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SpecificMessages r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SpecificMessages r101) throws IOException {
                Boolean r102 = r101.mention;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.buzz;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpecificMessages r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SpecificMessages();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_MENTION = r100;
            DEFAULT_BUZZ = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mention = this.mention;
            r100.buzz = this.buzz;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SpecificMessages.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SpecificMessages(Boolean r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public SpecificMessages(Boolean r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mention = r100;
            this.buzz = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NotificationSetting();
        FIELD_OPTIONS_ALL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_SPECIFIC_MESSAGES = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_NONE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_ALL = r100;
        DEFAULT_NONE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.all = this.all;
        r100.specific_messages = this.specific_messages;
        r100.none = this.none;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NotificationSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public NotificationSetting(Boolean r100, SpecificMessages r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public NotificationSetting(Boolean r100, SpecificMessages r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        if (Internal.countNonNull(r100, r101, r102) > 1) goto L7;
        this.all = r100;
        this.specific_messages = r101;
        this.none = r102;
        return;
    L7:
        throw new IllegalArgumentException("at most one of all, specific_messages, none may be non-null");
    }
}
