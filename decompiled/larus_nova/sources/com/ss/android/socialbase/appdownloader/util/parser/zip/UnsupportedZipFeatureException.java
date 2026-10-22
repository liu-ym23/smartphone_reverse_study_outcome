package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.io.Serializable;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes38.dex */
public class UnsupportedZipFeatureException extends ZipException {
    private static final long serialVersionUID = 20161221;
    private final transient ZipEntry entry;
    private final Feature reason;

    public static class Feature implements Serializable {
        public static final Feature DATA_DESCRIPTOR = null;
        public static final Feature ENCRYPTION = null;
        public static final Feature METHOD = null;
        private final String name;

        static {
            ENCRYPTION = new Feature("encryption");
            METHOD = new Feature("compression method");
            DATA_DESCRIPTOR = new Feature("data descriptor");
        }

        public String toString() {
            return this.name;
        }

        private Feature(String r100) {
            this.name = r100;
        }
    }

    public ZipEntry getEntry() {
        return this.entry;
    }

    public Feature getFeature() {
        return this.reason;
    }

    public UnsupportedZipFeatureException(Feature r100, ZipEntry r101) {
        super("unsupported feature " + r100 + " used in entry " + r101.getName());
        this.reason = r100;
        this.entry = r101;
    }
}
