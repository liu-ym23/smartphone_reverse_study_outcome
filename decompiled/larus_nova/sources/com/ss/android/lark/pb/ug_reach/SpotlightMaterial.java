package com.ss.android.lark.pb.ug_reach;

import androidx.camera.video.AudioStats;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SpotlightMaterial extends Message<SpotlightMaterial, Builder> {
    public static final ProtoAdapter<SpotlightMaterial> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final MaterialBase mbase;
    public final MaskConfig mspotlight_mask_config;
    public final List<SpotlightMaterialItem> mspotlights;

    public static final class Builder extends Message.Builder<SpotlightMaterial, Builder> {
        public MaterialBase mbase;
        public MaskConfig mspotlight_mask_config;
        public List<SpotlightMaterialItem> mspotlights;

        @Override // com.squareup.wire.Message.Builder
        public SpotlightMaterial build() {
            return new SpotlightMaterial(this.mspotlights, this.mspotlight_mask_config, this.mbase, super.buildUnknownFields());
        }

        public Builder() {
            this.mspotlights = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder base(MaterialBase r100) {
            this.mbase = r100;
            return this;
        }

        public Builder spotlight_mask_config(MaskConfig r100) {
            this.mspotlight_mask_config = r100;
            return this;
        }

        public Builder spotlights(List<SpotlightMaterialItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.mspotlights = r100;
            return this;
        }
    }

    public static final class MaskConfig extends Message<MaskConfig, Builder> {
        public static final ProtoAdapter<MaskConfig> ADAPTER = null;
        public static final Double DEFAULT_ALPHA = null;
        public static final Boolean DEFAULT_MASK_INTERACTION_FORCE_OPEN = null;
        private static final long serialVersionUID = 0;
        public final Double malpha;
        public final Boolean mmask_interaction_force_open;

        public static final class Builder extends Message.Builder<MaskConfig, Builder> {
            public Double malpha;
            public Boolean mmask_interaction_force_open;

            @Override // com.squareup.wire.Message.Builder
            public MaskConfig build() {
                return new MaskConfig(this.malpha, this.mmask_interaction_force_open, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder alpha(Double r100) {
                this.malpha = r100;
                return this;
            }

            public Builder mask_interaction_force_open(Boolean r100) {
                this.mmask_interaction_force_open = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MaskConfig extends ProtoAdapter<MaskConfig> {
            public ProtoAdapter_MaskConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, MaskConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MaskConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.malpha = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
                r101.mmask_interaction_force_open = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.malpha = ProtoAdapter.DOUBLE.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mmask_interaction_force_open = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(MaskConfig r100) {
                Double r101 = r100.malpha;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.DOUBLE.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.mmask_interaction_force_open;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MaskConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MaskConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MaskConfig r101) throws IOException {
                Double r102 = r101.malpha;
                if (r102 == null) goto L5;
                ProtoAdapter.DOUBLE.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.mmask_interaction_force_open;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MaskConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MaskConfig();
            DEFAULT_ALPHA = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            DEFAULT_MASK_INTERACTION_FORCE_OPEN = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.malpha = this.malpha;
            r100.mmask_interaction_force_open = this.mmask_interaction_force_open;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MaskConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MaskConfig(Double r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public MaskConfig(Double r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.malpha = r100;
            this.mmask_interaction_force_open = r101;
        }
    }

    public static final class ProtoAdapter_SpotlightMaterial extends ProtoAdapter<SpotlightMaterial> {
        public ProtoAdapter_SpotlightMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, SpotlightMaterial.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SpotlightMaterial decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mspotlights.add(SpotlightMaterialItem.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mspotlight_mask_config = MaskConfig.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mbase = MaterialBase.ADAPTER.decode(r100);
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
        public int encodedSize2(SpotlightMaterial r100) {
            int r101 = SpotlightMaterialItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mspotlights);
            MaskConfig r102 = r100.mspotlight_mask_config;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = MaskConfig.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            MaterialBase r106 = r100.mbase;
            if (r106 == null) goto L10;
            r103 = MaterialBase.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SpotlightMaterial decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SpotlightMaterial r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SpotlightMaterial r101) throws IOException {
            SpotlightMaterialItem.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mspotlights);
            MaskConfig r102 = r101.mspotlight_mask_config;
            if (r102 == null) goto L5;
            MaskConfig.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            MaterialBase r103 = r101.mbase;
            if (r103 == null) goto L8;
            MaterialBase.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpotlightMaterial r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpotlightMaterial();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mspotlights = Internal.copyOf("mspotlights", this.mspotlights);
        r100.mspotlight_mask_config = this.mspotlight_mask_config;
        r100.mbase = this.mbase;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SpotlightMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SpotlightMaterial(List<SpotlightMaterialItem> r100, MaskConfig r101, MaterialBase r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SpotlightMaterial(List<SpotlightMaterialItem> r100, MaskConfig r101, MaterialBase r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mspotlights = Internal.immutableCopyOf("mspotlights", r100);
        this.mspotlight_mask_config = r101;
        this.mbase = r102;
    }
}
