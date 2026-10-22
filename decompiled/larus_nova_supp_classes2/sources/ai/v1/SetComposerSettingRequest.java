package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class SetComposerSettingRequest extends Message<SetComposerSettingRequest, Builder> {
    public static final ProtoAdapter<SetComposerSettingRequest> ADAPTER = null;
    public static final ProtoAdapter_SetComposerSettingRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ComposerSetting composer_setting;
    public final MobileComposerSetting mobile_composer_setting;

    public static final class Builder extends Message.Builder<SetComposerSettingRequest, Builder> implements d<SetComposerSettingRequest> {
        public ComposerSetting composer_setting;
        public MobileComposerSetting mobile_composer_setting;

        public SetComposerSettingRequest build() {
            ComposerSetting r0 = this.composer_setting;
            if (r0 == null) goto L7;
            return new SetComposerSettingRequest(this.composer_setting, this.mobile_composer_setting, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "composer_setting"});
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m31build() {
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
    }

    public static final class ProtoAdapter_SetComposerSettingRequest extends ProtoAdapter<SetComposerSettingRequest> implements c<SetComposerSettingRequest> {
        public ProtoAdapter_SetComposerSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetComposerSettingRequest.class);
        }

        public SetComposerSettingRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.composer_setting = (ComposerSetting) ComposerSetting.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mobile_composer_setting = (MobileComposerSetting) MobileComposerSetting.ADAPTER.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SetComposerSettingRequest r5) {
            int r0 = ComposerSetting.ADAPTER.encodedSizeWithTag(1, r5.composer_setting);
            MobileComposerSetting r1 = r5.mobile_composer_setting;
            if (r1 == null) goto L5;
            int r2 = MobileComposerSetting.ADAPTER.encodedSizeWithTag(2, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m32decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SetComposerSettingRequest) r1);
        }

        public void encode(ProtoWriter r4, SetComposerSettingRequest r5) throws IOException {
            ComposerSetting.ADAPTER.encodeWithTag(r4, 1, r5.composer_setting);
            MobileComposerSetting r0 = r5.mobile_composer_setting;
            if (r0 == null) goto L5;
            MobileComposerSetting.ADAPTER.encodeWithTag(r4, 2, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SetComposerSettingRequest) r2);
        }
    }

    static {
        ProtoAdapter_SetComposerSettingRequest r0 = new ProtoAdapter_SetComposerSettingRequest();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.composer_setting = this.composer_setting;
        r0.mobile_composer_setting = this.mobile_composer_setting;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SetComposerSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m30newBuilder() {
        return newBuilder();
    }

    public SetComposerSettingRequest(ComposerSetting r2, MobileComposerSetting r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SetComposerSettingRequest(ComposerSetting r2, MobileComposerSetting r3, ByteString r4) {
        super(ADAPTER, r4);
        this.composer_setting = r2;
        this.mobile_composer_setting = r3;
    }
}
