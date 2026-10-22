package ai.v1;

import androidx.camera.video.AudioStats;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class SuggestionItem extends Message<SuggestionItem, Builder> {
    public static final ProtoAdapter<SuggestionItem> ADAPTER = null;
    public static final Double DEFAULT_CONFIDENCE = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_REASON = "";
    public static final String DEFAULT_SUGGESTION = "";
    private static final long serialVersionUID = 0;
    public final Double confidence;
    public final String id;
    public final String reason;
    public final String suggestion;

    public static final class Builder extends Message.Builder<SuggestionItem, Builder> {
        public Double confidence;
        public String id;
        public String reason;
        public String suggestion;

        public SuggestionItem build() {
            String r0 = this.suggestion;
            if (r0 == null) goto L9;
            if (this.id == null) goto L9;
            return new SuggestionItem(this.suggestion, this.id, this.confidence, this.reason, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "suggestion", this.id, "id"});
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m37build() {
            return build();
        }

        public Builder confidence(Double r1) {
            this.confidence = r1;
            return this;
        }

        public Builder id(String r1) {
            this.id = r1;
            return this;
        }

        public Builder reason(String r1) {
            this.reason = r1;
            return this;
        }

        public Builder suggestion(String r1) {
            this.suggestion = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SuggestionItem extends ProtoAdapter<SuggestionItem> {
        public ProtoAdapter_SuggestionItem() {
            super(FieldEncoding.LENGTH_DELIMITED, SuggestionItem.class);
        }

        public SuggestionItem decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.suggestion = "";
            r0.id = "";
            r0.confidence = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            r0.reason = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.suggestion = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.confidence = (Double) ProtoAdapter.DOUBLE.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.reason = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SuggestionItem r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.suggestion) + r0.encodedSizeWithTag(2, r7.id);
            Double r2 = r7.confidence;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = ProtoAdapter.DOUBLE.encodedSizeWithTag(3, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.reason;
            if (r6 == null) goto L10;
            r3 = r0.encodedSizeWithTag(4, r6);
        L10:
            return (r5 + r3) + r7.unknownFields().size();
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m38decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SuggestionItem) r1);
        }

        public void encode(ProtoWriter r5, SuggestionItem r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.suggestion);
            r0.encodeWithTag(r5, 2, r6.id);
            Double r1 = r6.confidence;
            if (r1 == null) goto L5;
            ProtoAdapter.DOUBLE.encodeWithTag(r5, 3, r1);
        L5:
            String r2 = r6.reason;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 4, r2);
        L8:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SuggestionItem) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SuggestionItem();
        DEFAULT_CONFIDENCE = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.suggestion = this.suggestion;
        r0.id = this.id;
        r0.confidence = this.confidence;
        r0.reason = this.reason;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SuggestionItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m36newBuilder() {
        return newBuilder();
    }

    public SuggestionItem(String r7, String r8, Double r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public SuggestionItem(String r2, String r3, Double r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.suggestion = r2;
        this.id = r3;
        this.confidence = r4;
        this.reason = r5;
    }
}
