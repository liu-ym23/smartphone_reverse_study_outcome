package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class GetSmartComposeResponse extends Message<GetSmartComposeResponse, Builder> {
    public static final ProtoAdapter<GetSmartComposeResponse> ADAPTER = null;
    public static final Boolean DEFAULT_FORCE_DISPLAY = null;
    public static final String DEFAULT_HIDDEN_STATE = "";
    public static final String DEFAULT_LANGUAGE = "";
    public static final Integer DEFAULT_MIN_DISPLAY_CHAR_LEN = null;
    public static final Integer DEFAULT_VID = null;
    public static final ProtoAdapter_GetSmartComposeResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean force_display;
    public final String hidden_state;
    public final String language;
    public final Integer min_display_char_len;
    public final List<SuggestionItem> suggestion;
    public final Integer vid;

    public static final class Builder extends Message.Builder<GetSmartComposeResponse, Builder> implements d<GetSmartComposeResponse> {
        public Boolean force_display;
        public String hidden_state;
        public String language;
        public Integer min_display_char_len;
        public List<SuggestionItem> suggestion;
        public Integer vid;

        public GetSmartComposeResponse build() {
            return new GetSmartComposeResponse(this.hidden_state, this.suggestion, this.vid, this.language, this.force_display, this.min_display_char_len, super.buildUnknownFields());
        }

        public Builder() {
            this.suggestion = Internal.newMutableList();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m19build() {
            return build();
        }

        public Builder force_display(Boolean r1) {
            this.force_display = r1;
            return this;
        }

        public Builder hidden_state(String r1) {
            this.hidden_state = r1;
            return this;
        }

        public Builder language(String r1) {
            this.language = r1;
            return this;
        }

        public Builder min_display_char_len(Integer r1) {
            this.min_display_char_len = r1;
            return this;
        }

        public Builder suggestion(List<SuggestionItem> r1) {
            Internal.checkElementsNotNull(r1);
            this.suggestion = r1;
            return this;
        }

        public Builder vid(Integer r1) {
            this.vid = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSmartComposeResponse extends ProtoAdapter<GetSmartComposeResponse> implements c<GetSmartComposeResponse> {
        public ProtoAdapter_GetSmartComposeResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSmartComposeResponse.class);
        }

        public GetSmartComposeResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.hidden_state = "";
            r0.vid = 0;
            r0.language = "";
            r0.force_display = Boolean.FALSE;
            r0.min_display_char_len = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.min_display_char_len = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L8:
            r0.force_display = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L9:
            r0.language = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.vid = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L11:
            r0.suggestion.add((SuggestionItem) SuggestionItem.ADAPTER.decode(r7));
            goto L3
        L12:
            r0.hidden_state = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(GetSmartComposeResponse r6) {
            String r0 = r6.hidden_state;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            int r3 = r2 + SuggestionItem.ADAPTER.asRepeated().encodedSizeWithTag(2, r6.suggestion);
            Integer r4 = r6.vid;
            if (r4 == null) goto L9;
            int r5 = ProtoAdapter.INT32.encodedSizeWithTag(3, r4);
        L10:
            int r7 = r3 + r5;
            String r8 = r6.language;
            if (r8 == null) goto L13;
            int r9 = ProtoAdapter.STRING.encodedSizeWithTag(4, r8);
        L14:
            int r10 = r7 + r9;
            Boolean r11 = r6.force_display;
            if (r11 == null) goto L17;
            int r12 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r11);
        L18:
            int r13 = r10 + r12;
            Integer r14 = r6.min_display_char_len;
            if (r14 == null) goto L22;
            r1 = ProtoAdapter.INT32.encodedSizeWithTag(6, r14);
        L22:
            return (r13 + r1) + r6.unknownFields().size();
        L17:
            r12 = 0;
            goto L18
        L13:
            r9 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m20decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetSmartComposeResponse) r1);
        }

        public void encode(ProtoWriter r4, GetSmartComposeResponse r5) throws IOException {
            String r0 = r5.hidden_state;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            SuggestionItem.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.suggestion);
            Integer r1 = r5.vid;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r1);
        L8:
            String r2 = r5.language;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r2);
        L11:
            Boolean r3 = r5.force_display;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r3);
        L14:
            Integer r6 = r5.min_display_char_len;
            if (r6 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r4, 6, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetSmartComposeResponse) r2);
        }
    }

    static {
        ProtoAdapter_GetSmartComposeResponse r0 = new ProtoAdapter_GetSmartComposeResponse();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
        DEFAULT_VID = 0;
        DEFAULT_FORCE_DISPLAY = Boolean.FALSE;
        DEFAULT_MIN_DISPLAY_CHAR_LEN = 0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.hidden_state = this.hidden_state;
        r0.suggestion = Internal.copyOf("suggestion", this.suggestion);
        r0.vid = this.vid;
        r0.language = this.language;
        r0.force_display = this.force_display;
        r0.min_display_char_len = this.min_display_char_len;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetSmartComposeResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m18newBuilder() {
        return newBuilder();
    }

    public GetSmartComposeResponse(String r9, List<SuggestionItem> r10, Integer r11, String r12, Boolean r13, Integer r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public GetSmartComposeResponse(String r2, List<SuggestionItem> r3, Integer r4, String r5, Boolean r6, Integer r7, ByteString r8) {
        super(ADAPTER, r8);
        this.hidden_state = r2;
        this.suggestion = Internal.immutableCopyOf("suggestion", r3);
        this.vid = r4;
        this.language = r5;
        this.force_display = r6;
        this.min_display_char_len = r7;
    }
}
