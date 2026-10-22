package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UserMainLanguageConfig extends Message<UserMainLanguageConfig, Builder> {
    public static final ProtoAdapter<UserMainLanguageConfig> ADAPTER = null;
    public static final String DEFAULT_MAIN_LANGUAGE = "";
    public static final Integer DEFAULT_MESSAGE_CHARACTER_THRESHOLD = null;
    private static final long serialVersionUID = 0;
    public final String main_language;
    public final Integer message_character_threshold;

    public static final class Builder extends Message.Builder<UserMainLanguageConfig, Builder> {
        public String main_language;
        public Integer message_character_threshold;

        @Override // com.squareup.wire.Message.Builder
        public UserMainLanguageConfig build() {
            String r100 = this.main_language;
            if (r100 == null) goto L7;
            return new UserMainLanguageConfig(this.main_language, this.message_character_threshold, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "main_language"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder main_language(String r100) {
            this.main_language = r100;
            return this;
        }

        public Builder message_character_threshold(Integer r100) {
            this.message_character_threshold = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserMainLanguageConfig extends ProtoAdapter<UserMainLanguageConfig> {
        public ProtoAdapter_UserMainLanguageConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, UserMainLanguageConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserMainLanguageConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.main_language = "";
            r101.message_character_threshold = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.main_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.message_character_threshold = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(UserMainLanguageConfig r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.main_language);
            Integer r102 = r100.message_character_threshold;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserMainLanguageConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserMainLanguageConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserMainLanguageConfig r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.main_language);
            Integer r102 = r101.message_character_threshold;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserMainLanguageConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserMainLanguageConfig();
        DEFAULT_MESSAGE_CHARACTER_THRESHOLD = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.main_language = this.main_language;
        r100.message_character_threshold = this.message_character_threshold;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserMainLanguageConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserMainLanguageConfig(String r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UserMainLanguageConfig(String r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.main_language = r100;
        this.message_character_threshold = r101;
    }
}
