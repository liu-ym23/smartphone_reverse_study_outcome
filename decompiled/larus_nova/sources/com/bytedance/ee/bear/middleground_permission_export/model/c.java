package com.bytedance.ee.bear.middleground_permission_export.model;

import com.bytedance.ee.bear.middleground_permission_export.model.audit.DriveData;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.ss.android.lark.pb.security_event.AppDetail;
import com.ss.android.lark.pb.security_event.ContainerType;
import com.ss.android.lark.pb.security_event.RenderItem;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(c r100, String r101) {
            r100.h(null, r101, Boolean.FALSE, null, null, null);
        }
    }

    void a(String r100, String r101, Boolean r102, String r103);

    void b(sbb.e r100, String r101, ContainerType r102, String r103);

    void c(sbb.e r100, String r101, AppDetail r102, ContainerType r103, String r104);

    void d(sbb.e r100, String r101, ContainerType r102, String r103);

    void e(sbb.e r100, String r101, ContainerType r102, String r103);

    void f(sbb.e r100, HostDocumentInfo r101, ContainerType r102, String r103, dj5.a r104, List<RenderItem> r105, Boolean r106);

    void g(String r100, String r101, Boolean r102, Boolean r103);

    void h(String r100, String r101, Boolean r102, String r103, Boolean r104, Boolean r105);

    void i(HostDocumentInfo r100, dj5.a r101, DriveData r102, Boolean r103);

    void j(String r100, String r101, Boolean r102);

    void k(String r100, String r101, Boolean r102, String r103);

    void l(sbb.e r100, String r101, String r102);

    void m(String r100, String r101, Boolean r102, String r103, Boolean r104);
}
