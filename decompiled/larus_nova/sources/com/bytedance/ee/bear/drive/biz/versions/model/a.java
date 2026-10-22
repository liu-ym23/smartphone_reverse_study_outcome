package com.bytedance.ee.bear.drive.biz.versions.model;

/* JADX INFO: loaded from: classes16.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.versions.model.a$a, reason: collision with other inner class name */
    public static class C3216a implements a {
        public C3216a() {
        }

        @Override // com.bytedance.ee.bear.drive.biz.versions.model.a
        public int getType() {
            return 1;
        }
    }

    public static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DriveVersionHistoryRecord.RecordBean f223999a;

        @Override // com.bytedance.ee.bear.drive.biz.versions.model.a
        public int getType() {
            return 0;
        }

        public b(DriveVersionHistoryRecord.RecordBean r100) {
            this.f223999a = r100;
        }
    }

    int getType();
}
