package com.bytedance.ee.bear.drive.biz.preview.error._default;

import com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import jg5.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static void a(FailedToRetryView r14, String r16) {
            Intrinsics.checkNotNullParameter(r14, "failedToRetryView");
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (e.a.a.g() == false) goto L9;
            if (s55.a.h(s55.a.a, "DOWNLOAD", "im_file", r16, null, null, null, null, null, null, 504).getAllow() == false) goto L12;
            r14.g();
            return;
        L12:
            return;
        L9:
            if (((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("IM_MSG_FILE_DOWNLOAD", FileBizDomain.FileBizDomainIM, sbb.e.l.b, r16).a == false) goto L13;
            r14.g();
            return;
        }
    }

    static {
    }
}
