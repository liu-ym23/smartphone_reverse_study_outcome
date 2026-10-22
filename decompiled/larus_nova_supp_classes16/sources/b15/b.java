package b15;

import com.bytedance.ee.bear.contract.d;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends a15.a {
    @Override // a15.a
    public final void c() {
        d("ccm_doc_version_deleted_tips_click");
    }

    @Override // a15.a
    public final void e() {
        Intrinsics.checkNotNullParameter("ccm_doc_version_deleted_tips_view", "event");
        q("ccm_doc_version_deleted_tips_view", new HashMap(2));
    }

    @Override // a15.a
    public final void g() {
        Intrinsics.checkNotNullParameter("ccm_doc_delete_version_view", "event");
        q("ccm_doc_delete_version_view", new HashMap(2));
    }

    @Override // a15.a
    public final void j() {
        Intrinsics.checkNotNullParameter("ccm_docs_version_more_menu_view", "event");
        q("ccm_docs_version_more_menu_view", new HashMap(2));
    }

    @Override // a15.a
    public final void m() {
        Intrinsics.checkNotNullParameter("ccm_doc_rename_version_view", "event");
        q("ccm_doc_rename_version_view", new HashMap(2));
    }

    @Override // a15.a
    public final void p() {
        Intrinsics.checkNotNullParameter("ccm_doc_saved_version_view", "event");
        q("ccm_doc_saved_version_view", new HashMap(2));
    }

    public b(d r1) {
        super(r1);
    }

    @Override // a15.a
    public final void f(String r4) {
        Intrinsics.checkNotNullParameter("ccm_doc_delete_version_click", "event");
        HashMap r0 = new HashMap(2);
        r0.put("click", r4);
        r0.put("target", "none");
        q("ccm_doc_delete_version_click", r0);
    }

    @Override // a15.a
    public final void k(String r4) {
        Intrinsics.checkNotNullParameter("ccm_docs_version_page_view", "event");
        HashMap r0 = new HashMap(2);
        r0.put("open_type", r4);
        q("ccm_docs_version_page_view", r0);
    }

    @Override // a15.a
    public final void l(String r4) {
        Intrinsics.checkNotNullParameter("ccm_doc_rename_version_click", "event");
        HashMap r0 = new HashMap(2);
        r0.put("click", r4);
        r0.put("target", "none");
        q("ccm_doc_rename_version_click", r0);
    }

    @Override // a15.a
    public final void n(String r2, String r3, String r4) {
        o("ccm_doc_saved_version_click", r2, r3, r4);
    }

    @Override // a15.a
    public final void h(String r8, String r9, String r10, String r11, String r12) {
        i("ccm_docs_version_more_menu_click", r8, r9, r10, r11, r12);
    }
}
