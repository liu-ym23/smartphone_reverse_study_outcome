package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class GetComposerSettingResponse extends Message<GetComposerSettingResponse, Builder> {
    public static final ProtoAdapter<GetComposerSettingResponse> ADAPTER = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final ProtoAdapter_GetComposerSettingResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ComposerSetting composer_setting;
    public final MobileComposerSetting mobile_composer_setting;
    public final Long update_time;

    public static final class Builder extends Message.Builder<GetComposerSettingResponse, Builder> implements d<GetComposerSettingResponse> {
        public ComposerSetting composer_setting;
        public MobileComposerSetting mobile_composer_setting;
        public Long update_time;

        public GetComposerSettingResponse build() {
            return new GetComposerSettingResponse(this.composer_setting, this.update_time, this.mobile_composer_setting, super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m13build() {
            return build();
        }

        public Builder composer_setting(ComposerSetting r1) {
            this.composer_setting = r1;
            return this;
        }

        public Builder mobile_composer_setting(MobileComposerSetting r1) {
            this.mobile_composer_setting = r1;
            return this;
        }

        public Builder update_time(Long r1) {
            this.update_time = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetComposerSettingResponse extends ProtoAdapter<GetComposerSettingResponse> implements c<GetComposerSettingResponse> {
        public ProtoAdapter_GetComposerSettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetComposerSettingResponse.class);
        }

        public GetComposerSettingResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.update_time = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.composer_setting = (ComposerSetting) ComposerSetting.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.update_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mobile_composer_setting = (MobileComposerSetting) MobileComposerSetting.ADAPTER.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(GetComposerSettingResponse r6) {
            ComposerSetting r0 = r6.composer_setting;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ComposerSetting.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.update_time;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            MobileComposerSetting r7 = r6.mobile_composer_setting;
            if (r7 == null) goto L14;
            r1 = MobileComposerSetting.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m14decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetComposerSettingResponse) r1);
        }

        public void encode(ProtoWriter r4, GetComposerSettingResponse r5) throws IOException {
            ComposerSetting r0 = r5.composer_setting;
            if (r0 == null) goto L5;
            ComposerSetting.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.update_time;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            MobileComposerSetting r2 = r5.mobile_composer_setting;
            if (r2 == null) goto L11;
            MobileComposerSetting.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetComposerSettingResponse) r2);
        }
    }

    static {
        ProtoAdapter_GetComposerSettingResponse r0 = new ProtoAdapter_GetComposerSettingResponse();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
        DEFAULT_UPDATE_TIME = 0L;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.composer_setting = this.composer_setting;
        r0.update_time = this.update_time;
        r0.mobile_composer_setting = this.mobile_composer_setting;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetComposerSettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m12newBuilder() {
        return newBuilder();
    }

    public GetComposerSettingResponse(ComposerSetting r2, Long r3, MobileComposerSetting r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public GetComposerSettingResponse(ComposerSetting r2, Long r3, MobileComposerSetting r4, ByteString r5) {
        super(ADAPTER, r5);
        this.composer_setting = r2;
        this.update_time = r3;
        this.mobile_composer_setting = r4;
    }
}
