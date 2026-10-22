package com.bytedance.ee.bear.rn;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
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

        public void setObjType(int r100) {
            this.objType = r100;
        }

        public void setVersion(int r100) {
            this.version = r100;
        }

        public RnPushExtraParam(int r100, int r101) {
            this.version = r100;
            this.objType = r101;
        }
    }

    public static final enum VersionQualifier extends Enum<VersionQualifier> implements mwc.a {
        public static final VersionQualifier Default = null;
        public static final VersionQualifier Specify = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VersionQualifier[] f236495a = null;

        static {
            VersionQualifier r100 = new VersionQualifier("Specify", 0);
            Specify = r100;
            VersionQualifier r101 = new VersionQualifier("Default", 1);
            Default = r101;
            f236495a = new VersionQualifier[]{r100, r101};
        }

        public static VersionQualifier[] values() {
            return (VersionQualifier[]) f236495a.clone();
        }

        @Override // mwc.a
        public String getValue() {
            return name();
        }

        public static VersionQualifier valueOf(String r100) {
            return (VersionQualifier) r27.a.a(VersionQualifier.class, r100);
        }

        public VersionQualifier(String r100, int r101) {
            super(r100, r101);
        }
    }

    void a();

    void b(bu5.a r100);
}
