package com.bytedance.ee.bear.rn;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface RnPushProtocol {

    public static class RnPushExtraParam implements NonProguard {
        private int objType;
        private int version;

        public String toString() {
            return "RnPushExtraParam{version=" + this.version + ", objType=" + this.objType + '}';
        }

        public int getObjType() {
            return this.objType;
        }

        public int getVersion() {
            return this.version;
        }

        public void setObjType(int r1) {
            this.objType = r1;
        }

        public void setVersion(int r1) {
            this.version = r1;
        }

        public RnPushExtraParam(int r1, int r2) {
            this.version = r1;
            this.objType = r2;
        }
    }

    public static final enum VersionQualifier extends Enum<VersionQualifier> implements mwc.a {
        public static final VersionQualifier Default = null;
        public static final VersionQualifier Specify = null;
        public static final /* synthetic */ VersionQualifier[] a = null;

        static {
            VersionQualifier r0 = new VersionQualifier("Specify", 0);
            Specify = r0;
            VersionQualifier r1 = new VersionQualifier("Default", 1);
            Default = r1;
            a = new VersionQualifier[]{r0, r1};
        }

        public static VersionQualifier[] values() {
            return (VersionQualifier[]) a.clone();
        }

        public String getValue() {
            return name();
        }

        public static VersionQualifier valueOf(String r1) {
            return (VersionQualifier) r27.a.a(VersionQualifier.class, r1);
        }

        public VersionQualifier(String r1, int r2) {
            super(r1, r2);
        }
    }

    void a();

    void b(bu5.a r1);
}
