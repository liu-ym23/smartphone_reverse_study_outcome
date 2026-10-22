package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class ChatInfo extends Message<ChatInfo, Builder> {
    public static final ProtoAdapter<ChatInfo> ADAPTER = null;
    public static final String DEFAULT_CHAT_NAME = "";
    public static final String DEFAULT_OPEN_CHAT_ID = "";
    private static final long serialVersionUID = 0;
    public final List<String> chat_avatar_urls;
    public final Map<String, String> chat_i18n_names;
    public final String chat_name;
    public final String open_chat_id;

    public static final class Builder extends Message.Builder<ChatInfo, Builder> {
        public List<String> chat_avatar_urls;
        public Map<String, String> chat_i18n_names;
        public String chat_name;
        public String open_chat_id;

        @Override // com.squareup.wire.Message.Builder
        public ChatInfo build() {
            String r100 = this.open_chat_id;
            if (r100 == null) goto L7;
            return new ChatInfo(this.chat_name, this.chat_i18n_names, this.chat_avatar_urls, this.open_chat_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "open_chat_id"});
        }

        public Builder() {
            this.chat_i18n_names = Internal.newMutableMap();
            this.chat_avatar_urls = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_avatar_urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_avatar_urls = r100;
            return this;
        }

        public Builder chat_i18n_names(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_i18n_names = r100;
            return this;
        }

        public Builder chat_name(String r100) {
            this.chat_name = r100;
            return this;
        }

        public Builder open_chat_id(String r100) {
            this.open_chat_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatInfo extends ProtoAdapter<ChatInfo> {
        private final ProtoAdapter<Map<String, String>> chat_i18n_names;

        public ProtoAdapter_ChatInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.chat_i18n_names = ProtoAdapter.newMapAdapter(r100, r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ChatInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.chat_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chat_i18n_names.putAll(this.chat_i18n_names.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.chat_avatar_urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.open_chat_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ChatInfo r100) {
            String r101 = r100.chat_name;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r103 = r102 + this.chat_i18n_names.encodedSizeWithTag(2, r100.chat_i18n_names);
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            return ((r103 + r104.asRepeated().encodedSizeWithTag(3, r100.chat_avatar_urls)) + r104.encodedSizeWithTag(4, r100.open_chat_id)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatInfo r101) throws IOException {
            String r102 = r101.chat_name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            this.chat_i18n_names.encodeWithTag(r100, 2, r101.chat_i18n_names);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.asRepeated().encodeWithTag(r100, 3, r101.chat_avatar_urls);
            r103.encodeWithTag(r100, 4, r101.open_chat_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_name = this.chat_name;
        r100.chat_i18n_names = Internal.copyOf("chat_i18n_names", this.chat_i18n_names);
        r100.chat_avatar_urls = Internal.copyOf("chat_avatar_urls", this.chat_avatar_urls);
        r100.open_chat_id = this.open_chat_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatInfo(String r100, Map<String, String> r101, List<String> r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ChatInfo(String r100, Map<String, String> r101, List<String> r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chat_name = r100;
        this.chat_i18n_names = Internal.immutableCopyOf("chat_i18n_names", r101);
        this.chat_avatar_urls = Internal.immutableCopyOf("chat_avatar_urls", r102);
        this.open_chat_id = r103;
    }
}
