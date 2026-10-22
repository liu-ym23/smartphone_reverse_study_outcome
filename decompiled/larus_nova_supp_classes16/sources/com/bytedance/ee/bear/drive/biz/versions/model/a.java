package com.bytedance.ee.bear.drive.biz.versions.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.versions.model.a$a, reason: collision with other inner class name */
    public static class C0160a implements a {
        public C0160a() {
        }

        @Override // com.bytedance.ee.bear.drive.biz.versions.model.a
        public int getType() {
            return 1;
        }
    }

    public static class b implements a {
        public final DriveVersionHistoryRecord.RecordBean a;

        @Override // com.bytedance.ee.bear.drive.biz.versions.model.a
        public int getType() {
            return 0;
        }

        public b(DriveVersionHistoryRecord.RecordBean r1) {
            this.a = r1;
        }
    }

    int getType();
}
