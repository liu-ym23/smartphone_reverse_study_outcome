package com.bytedance.mobsec.metasec.ml;

import java.util.Map;
import ms.bd.c.a2;
import ms.bd.c.c2;

/* JADX INFO: loaded from: classes3.dex */
public final class MSConfig extends c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c2 f265557a;

    public static class Builder extends a2 {

        /* JADX INFO: loaded from: classes21.dex */
        public interface IFetchedDid {
            String fetchedDid();
        }

        public interface IMsComplianceScene {
            boolean isComplianceScene(String r100);
        }

        /* JADX INFO: loaded from: classes21.dex */
        public interface IMsSettingConfig {
            String settingConfig();
        }

        public Builder addAdvanceInfo(String r100, String r101) {
            addAdvanceInfo0(r100, r101);
            return this;
        }

        public MSConfig build() {
            return new MSConfig(build0());
        }

        public Builder setBDDeviceID(String r100) {
            setBDDeviceID0(r100);
            return this;
        }

        public Builder setChannel(String r100) {
            setChannel0(r100);
            return this;
        }

        public Builder setClientType(int r100) {
            setClientType0(r100);
            return this;
        }

        public Builder setCustomInfo(Map<String, String> r100) {
            setCustomInfo0(r100);
            return this;
        }

        public Builder setDefaultReportHost(String r100) {
            setDefaultReportHost0(r100);
            return this;
        }

        public Builder setDeviceID(String r100) {
            setDeviceID0(r100);
            return this;
        }

        public Builder setFetchedDidInterface(IFetchedDid r100) {
            setFetchedDidInterface0(r100);
            return this;
        }

        public Builder setInstallID(String r100) {
            setInstallID0(r100);
            return this;
        }

        public Builder setMsComplianceScene(IMsComplianceScene r100) {
            setMsComplianceScene0(r100);
            return this;
        }

        public Builder setMsSettingConfig(IMsSettingConfig r100) {
            setMsSettingConfig0(r100);
            return this;
        }

        public Builder setOVRegionType(int r100) {
            setOVRegionType0(r100);
            return this;
        }

        public Builder setSecssionID(String r100) {
            return this;
        }

        public Builder(String r100, String r101) {
            super(r100, r101, 99999);
        }

        public Builder(String r100, String r101, String r102) {
            super(r100, r101, r102, 99999);
        }

        public Builder(String r100, String r101, int r102) {
            super(r100, r101, r102);
        }

        public Builder(String r100, String r101, String r102, int r103) {
            super(r100, r101, r102, r103);
        }
    }

    public final c2 a() {
        return this.f265557a;
    }

    public MSConfig(c2 r100) {
        this.f265557a = r100;
    }
}
