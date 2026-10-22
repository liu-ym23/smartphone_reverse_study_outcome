package com.bytedance.ee.bear.document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface x2 extends com.bytedance.ee.bear.browser.plugin.i {

    public interface a {
        void a(String r1);
    }

    public interface b {
        void onLoadCancel();

        void onLoadFail(int r1, Throwable r2);

        void onLoadStart();

        void onLoadSuccess();

        void onSSRLoadSuccess();
    }

    public static class c implements b {
        public c() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public void onLoadCancel() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public void onLoadFail(int r1, Throwable r2) {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public void onLoadStart() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public void onLoadSuccess() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public /* synthetic */ void onSSRLoadSuccess() {
        }
    }

    void S(b r1);

    void S3(b r1);

    void bi(boolean r1);

    void load();

    void onDestroy();

    void onPause();
}
