package com.bytedance.privacy.attestation;

import com.bytedance.privacy.exception.BdPrivacyException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes6.dex */
public class AttestationConfig {
    private final String customInfo;
    private final boolean devHealthStatusRequired;
    private final boolean[] requestedIdFlags;

    public static class Builder {
        private String customInfo;
        private boolean devHealthStatusRequired;
        private final boolean[] requestedIdFlags;

        public Builder requestDeviceHealthStatus() {
            this.devHealthStatusRequired = true;
            return this;
        }

        public AttestationConfig build() {
            return new AttestationConfig(this, null);
        }

        public Builder() {
            this.requestedIdFlags = new boolean[IdType.values().length];
            this.devHealthStatusRequired = false;
        }

        public static /* synthetic */ boolean[] access$000(Builder r100) {
            return r100.requestedIdFlags;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.customInfo;
        }

        public static /* synthetic */ boolean access$200(Builder r100) {
            return r100.devHealthStatusRequired;
        }

        public Builder customInfo(String r100) throws BdPrivacyException {
            if (r100 == null) goto L12;
            if (r100.isEmpty() == true) goto L12;
            j67.a.b().r();
            if (r100.getBytes(StandardCharsets.UTF_8).length > 1024) goto L10;
            this.customInfo = r100;
            return this;
        L10:
            throw new BdPrivacyException("customInfo too long (max 1024 bytes)");
        L12:
            throw new BdPrivacyException("customInfo must not be null or empty");
        }

        public Builder requestId(IdType r100) {
            this.requestedIdFlags[r100.ordinal()] = true;
            return this;
        }

        public Builder requestIds(IdType... r100) {
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            IdType r103 = r100[r102];
            this.requestedIdFlags[r103.ordinal()] = true;
            r102 = r102 + 1;
            goto L3
        L5:
            return this;
        }
    }

    public static final enum IdType extends Enum<IdType> {
        public static final IdType RPDID = null;
        public static final IdType RPUID = null;
        public static final IdType UDID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IdType[] f266680a = null;

        static {
            IdType r100 = new IdType("UDID", 0);
            UDID = r100;
            IdType r101 = new IdType("RPDID", 1);
            RPDID = r101;
            IdType r102 = new IdType("RPUID", 2);
            RPUID = r102;
            f266680a = new IdType[]{r100, r101, r102};
        }

        public static IdType[] values() {
            return (IdType[]) f266680a.clone();
        }

        public static IdType valueOf(String r100) {
            return (IdType) r27.a.a(IdType.class, r100);
        }

        public IdType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("AttestationConfig{requestedIds=[");
        IdType[] r101 = IdType.values();
        int r102 = r101.length;
        boolean r103 = true;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L10;
        IdType r105 = r101[r104];
        if (this.requestedIdFlags[r105.ordinal()] == false) goto L9;
        if (r103 == true) goto L8;
        r100.append(", ");
    L8:
        r100.append(r105.name());
        r103 = false;
    L9:
        r104 = r104 + 1;
        goto L3
    L10:
        r100.append("]");
        if (this.customInfo == null) goto L13;
        r100.append(", customInfo='");
        r100.append(this.customInfo);
        r100.append('\'');
    L13:
        r100.append(", devHealthStatusRequired=");
        r100.append(this.devHealthStatusRequired);
        r100.append('}');
        return r100.toString();
    }

    public String getCustomInfo() {
        return this.customInfo;
    }

    public boolean isDevHealthStatusRequired() {
        return this.devHealthStatusRequired;
    }

    private AttestationConfig(Builder r100) {
        this.requestedIdFlags = (boolean[]) Builder.access$000(r100).clone();
        this.customInfo = Builder.access$100(r100);
        this.devHealthStatusRequired = Builder.access$200(r100);
    }

    public boolean isIdRequested(IdType r100) {
        return this.requestedIdFlags[r100.ordinal()];
    }

    public /* synthetic */ AttestationConfig(Builder r100, a r101) {
        this(r100);
    }
}
