package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes42.dex */
public class UnsupportedZipFeatureException extends ZipException {
    private static final long serialVersionUID = 20161219;
    private final Feature reason;

    public static class Feature implements Serializable {
        public static final Feature DATA_DESCRIPTOR = null;
        public static final Feature ENCRYPTION = null;
        public static final Feature METHOD = null;
        public static final Feature SPLITTING = null;
        public static final Feature UNKNOWN_COMPRESSED_SIZE = null;
        private static final long serialVersionUID = 4112582948775420359L;
        private final String name;

        static {
            ENCRYPTION = new Feature("encryption");
            METHOD = new Feature("compression method");
            DATA_DESCRIPTOR = new Feature("data descriptor");
            SPLITTING = new Feature("splitting");
            UNKNOWN_COMPRESSED_SIZE = new Feature("unknown compressed size");
        }

        public String toString() {
            return this.name;
        }

        private Feature(String r100) {
            this.name = r100;
        }
    }

    public ZipArchiveEntry getEntry() {
        return null;
    }

    public Feature getFeature() {
        return this.reason;
    }

    public UnsupportedZipFeatureException(Feature r100) {
        super("unsupported feature " + r100 + " used in archive.");
        this.reason = r100;
    }

    public UnsupportedZipFeatureException(ZipMethod r100, ZipArchiveEntry r101) {
        StringBuilder r102 = new StringBuilder("unsupported feature method '");
        r102.append(r100.name());
        r102.append("' used in entry ");
        throw null;
    }

    public UnsupportedZipFeatureException(Feature r100, ZipArchiveEntry r101) {
        StringBuilder r102 = new StringBuilder("unsupported feature ");
        r102.append(r100);
        r102.append(" used in entry ");
        throw null;
    }
}
