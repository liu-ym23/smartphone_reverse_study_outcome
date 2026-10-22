package com.ss.android.lark.utils.rxjava;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ReportErrorConsumer {

    /* JADX INFO: renamed from: com.ss.android.lark.utils.rxjava.a$a, reason: collision with other inner class name */
    public static class C5377a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f444759a = null;

        static {
            f444759a = new a(0);
        }
    }

    public a(int r100) {
    }

    @Override // com.ss.android.lark.utils.rxjava.ReportErrorConsumer
    public final void error(Throwable r100) throws Exception {
        Log.e("EmptyErrorConsumer", r100.getMessage(), r100);
    }
}
