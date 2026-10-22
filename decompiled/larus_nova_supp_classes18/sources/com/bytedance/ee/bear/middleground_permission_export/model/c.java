package com.bytedance.ee.bear.middleground_permission_export.model;

import com.bytedance.ee.bear.middleground_permission_export.model.audit.DriveData;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.ss.android.lark.pb.security_event.AppDetail;
import com.ss.android.lark.pb.security_event.ContainerType;
import com.ss.android.lark.pb.security_event.RenderItem;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(c r7, String r8) {
            r7.h(null, r8, Boolean.FALSE, null, null, null);
        }
    }

    void a(String r1, String r2, Boolean r3, String r4);

    void b(sbb.e r1, String r2, ContainerType r3, String r4);

    void c(sbb.e r1, String r2, AppDetail r3, ContainerType r4, String r5);

    void d(sbb.e r1, String r2, ContainerType r3, String r4);

    void e(sbb.e r1, String r2, ContainerType r3, String r4);

    void f(sbb.e r1, HostDocumentInfo r2, ContainerType r3, String r4, dj5.a r5, List<RenderItem> r6, Boolean r7);

    void g(String r1, String r2, Boolean r3, Boolean r4);

    void h(String r1, String r2, Boolean r3, String r4, Boolean r5, Boolean r6);

    void i(HostDocumentInfo r1, dj5.a r2, DriveData r3, Boolean r4);

    void j(String r1, String r2, Boolean r3);

    void k(String r1, String r2, Boolean r3, String r4);

    void l(sbb.e r1, String r2, String r3);

    void m(String r1, String r2, Boolean r3, String r4, Boolean r5);
}
