package com.ss.android.lark.passport.signinsdk_api.interfaces;

import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public interface IDeviceService {

    public static class Country implements Serializable {
        private long geocodeNameId;
        private String isoCode;

        public long getGeocodeNameId() {
            return this.geocodeNameId;
        }

        public String getIsoCode() {
            return this.isoCode;
        }

        public void setGeocodeNameId(long r100) {
            this.geocodeNameId = r100;
        }

        public void setIsoCode(String r100) {
            this.isoCode = r100;
        }

        public Country(long r100, String r101) {
            this.geocodeNameId = r100;
            this.isoCode = r101;
        }
    }
}
