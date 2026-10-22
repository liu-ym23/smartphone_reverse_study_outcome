package com.bytedance.ee.bear.more.protocol3;

import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class f {
    public final String a;
    public final com.bytedance.ee.bear.more.protocol3.d b;

    public static final class a extends f {
        public static final a c = null;

        static {
            c = new a();
        }

        public a() {
            super("ai_summary", 2131888944, 2131254283, null, 24);
        }
    }

    public static final class a0 extends f {
        public static final a0 c = null;

        static {
            c = new a0();
        }

        public a0() {
            super("permission", 2131889204, 2131255650, null, 24);
        }
    }

    public static final class b extends f {
        public static final b c = null;

        static {
            c = new b();
        }

        public b() {
            super("add_shortcut", 2131889880, kac.a.b(2131255216), null, 24);
        }
    }

    public static final class b0 extends f {
        public b0(boolean r5) {
            if (r5 == false) goto L5;
            com.bytedance.ee.bear.more.protocol3.d r6 = new com.bytedance.ee.bear.more.protocol3.d(2131887961, 2131254024, 0, 12);
        L6:
            super("pin", r6);
            return;
        L5:
            r6 = new com.bytedance.ee.bear.more.protocol3.d(2131887878, 2131253905, 0, 12);
            goto L6
        }
    }

    public static final class c extends f {
        public c(boolean r6) {
            String r0 = CommonMoreItemId.ADD_TO_WORKBENCH.getId();
            if (r6 == false) goto L5;
            com.bytedance.ee.bear.more.protocol3.d r7 = new com.bytedance.ee.bear.more.protocol3.d(2131886820, 2131254761, 2131103546, 8);
        L6:
            super(r0, r7);
            return;
        L5:
            r7 = new com.bytedance.ee.bear.more.protocol3.d(2131886824, 2131254762, 0, 12);
            goto L6
        }
    }

    public static final class c0 extends f {
        public static final c0 c = null;

        static {
            c = new c0();
        }

        public c0() {
            super("remove_from_workspace", 2131889886, 2131255224, null, 24);
        }
    }

    public static final class d extends f {
        public static final d c = null;

        static {
            c = new d();
        }

        public d() {
            super("bitable_add_to_workspace", 2131886313, 2131255161, null, 24);
        }
    }

    public static final class d0 extends f {
        public static final d0 c = null;

        static {
            c = new d0();
        }

        public d0() {
            super(CommonMoreItemId.RENAME.getId(), 2131888030, 2131254065, null, 24);
        }
    }

    public static final class e extends f {
        public static final e c = null;

        static {
            c = new e();
        }

        public e() {
            super("bitable_change_workspace", 2131886314, 2131255872, null, 24);
        }
    }

    public static final class e0 extends f {
        public static final e0 c = null;

        static {
            c = new e0();
        }

        public e0() {
            super("retention_label", 2131887217, 2131255254, null, 24);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.protocol3.f$f, reason: collision with other inner class name */
    public static final class C0120f extends f {
        public static final C0120f c = null;

        static {
            c = new C0120f();
        }

        public C0120f() {
            super("bitable_move_out_workspace", 2131886322, 2131255224, null, 24);
        }
    }

    public static final class f0 extends f {
        public static final f0 c = null;

        static {
            c = new f0();
        }

        public f0() {
            super("item_revision_switch", 2131889128, 2131254156, null, 24);
        }
    }

    public static final class g extends f {
        public g(boolean r5) {
            if (r5 == false) goto L5;
            com.bytedance.ee.bear.more.protocol3.d r6 = new com.bytedance.ee.bear.more.protocol3.d(2131887536, 2131256070, 0, 12);
        L6:
            super("clip_top", r6);
            return;
        L5:
            r6 = new com.bytedance.ee.bear.more.protocol3.d(2131887466, 2131254096, 0, 12);
            goto L6
        }
    }

    public static final class g0 extends f {
        public g0(boolean r5) {
            if (r5 == false) goto L5;
            com.bytedance.ee.bear.more.protocol3.d r6 = new com.bytedance.ee.bear.more.protocol3.d(2131889632, 2131256070, 0, 12);
        L6:
            super("sidebar_pin", r6);
            return;
        L5:
            r6 = new com.bytedance.ee.bear.more.protocol3.d(2131889574, 2131254096, 0, 12);
            goto L6
        }
    }

    public static final class h extends f {
        public static final h c = null;

        static {
            c = new h();
        }

        public h() {
            super("copy_link", 2131887882, 2131255013, null, 24);
        }
    }

    public static final class h0 extends f {
        public h0(boolean r5) {
            if (r5 == false) goto L5;
            com.bytedance.ee.bear.more.protocol3.d r6 = new com.bytedance.ee.bear.more.protocol3.d(2131889631, 2131254025, 2131102418, 8);
        L6:
            super("star", r6);
            return;
        L5:
            r6 = new com.bytedance.ee.bear.more.protocol3.d(2131887713, 2131254139, 2131102418, 8);
            goto L6
        }
    }

    public static final class i extends f {
        public i(String r3, int r4, String r5, int r6) {
            if ((r6 & 4) == 0) goto L6;
            r4 = 0;
        L6:
            if ((r6 & 8) == 0) goto L8;
            int r0 = 2131102418;
        L10:
            if ((r6 & 16) == 0) goto L12;
            r5 = null;
        L12:
            Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_ID);
            super(r3, new com.bytedance.ee.bear.more.protocol3.d(0, r4, r0, r5));
            return;
        L8:
            r0 = 0;
            goto L10
        }
    }

    public static final class i0 extends f {
        public static final i0 c = null;

        static {
            c = new i0();
        }

        public i0() {
            super("transfer_apply", 2131889328, 2131255286, null, 24);
        }
    }

    public static final class j extends f {
        public static final j c = null;

        static {
            c = new j();
        }

        public j() {
            super("delete", 2131887736, 2131254201, null, 24);
        }
    }

    public static final class j0 extends f {
        public static final j0 c = null;

        static {
            c = new j0();
        }

        public j0() {
            super("tts", 2131889241, 2131237817, null, 24);
        }
    }

    public static final class k extends f {
        public static final k c = null;

        static {
            c = new k();
        }

        public k() {
            super("delete_shortcut", 2131887529, 2131254201, null, 24);
        }
    }

    public static final class k0 extends f {
        public static final k0 c = null;

        static {
            c = new k0();
        }

        public k0() {
            super("ai_smart", 2131888742, 2131254079, null, 24);
        }
    }

    public static final class l extends f {
        public static final l c = null;

        static {
            c = new l();
        }

        public l() {
            super("disassociate", 2131888958, 2131256059, null, 24);
        }
    }

    public static final class l0 extends f {
        public static final l0 c = null;

        static {
            c = new l0();
        }

        public l0() {
        }
    }

    public static final class m extends f {
        public m(String r7) {
            super("docx_translate", 2131888035, 2131256049, r7, 8);
        }
    }

    public static final class m0 extends f {
        public static final m0 c = null;

        static {
            c = new m0();
        }

        public m0() {
            super("wiki_make_copy", 2131887771, 2131254165, null, 24);
        }
    }

    public static final class n extends f {
        public static final n c = null;

        static {
            c = new n();
        }

        public n() {
            super(OperationName.OPERATION_DOWNLOAD, 2131887287, 2131254269, null, 24);
        }
    }

    public static final class o extends f {
        public static final o c = null;

        static {
            c = new o();
        }

        public o() {
            super("drive_detail_import_as", 2131887762, 2131254247, null, 24);
        }
    }

    public static final class p extends f {
        public static final p c = null;

        static {
            c = new p();
        }

        public p() {
            super("dropdown", 2131889885, 2131254921, null, 24);
        }
    }

    public static final class q extends f {
        public static final q c = null;

        static {
            c = new q();
        }

        public q() {
            super("edition_list", 2131889377, 2131255254, null, 24);
        }
    }

    public static final class r extends f {
        public static final r c = null;

        static {
            c = new r();
        }

        public r() {
            super("expired_content", 2131888824, 2131255844, null, 24);
        }
    }

    public static final class s extends f {
        public static final s c = null;

        static {
            c = new s();
        }

        public s() {
            super("freshNess", 2131888857, 2131256121, null, 24);
        }
    }

    public static final class t extends f {
        public t(int r7) {
            super("import_as", r7, 2131254247, null, 24);
        }
    }

    public static final class u extends f {
        public static final u c = null;

        static {
            c = new u();
        }

        public u() {
            super("make_copy", 2131887771, 2131254165, null, 24);
        }
    }

    public static final class v extends f {
        public static final v c = null;

        static {
            c = new v();
        }

        public v() {
            super("move_to", 2131889143, 2131254940, null, 24);
        }
    }

    public static final class w extends f {
        public w(boolean r5) {
            if (r5 == false) goto L5;
            com.bytedance.ee.bear.more.protocol3.d r6 = new com.bytedance.ee.bear.more.protocol3.d(2131890565, 2131255146, 0, 12);
        L6:
            super("add_main_nav", r6);
            return;
        L5:
            r6 = new com.bytedance.ee.bear.more.protocol3.d(2131890598, 2131255145, 0, 12);
            goto L6
        }
    }

    public static final class x extends f {
        public x(com.bytedance.ee.bear.more.protocol3.d r2) {
            Intrinsics.checkNotNullParameter(r2, "itemRes");
            super("my_ai", r2);
        }
    }

    public static final class y extends f {
        public static final y c = null;

        static {
            c = new y();
        }

        public y() {
            super(CommonMoreItemId.BROWSER_VIEW.getId(), 2131889627, 2131253880, null, 24);
        }
    }

    public static final class z extends f {
        public static final z c = null;

        static {
            c = new z();
        }

        public z() {
            super("item_page_settings", 2131889133, 2131254917, null, 24);
        }
    }

    public f() {
        this.a = "wiki_delete";
        this.b = new com.bytedance.ee.bear.more.protocol3.d(-1, -1, 0, 12);
    }

    public f(String r1, com.bytedance.ee.bear.more.protocol3.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public f(String r2, int r3, int r4, String r5, int r6) {
        if ((r6 & 8) == 0) goto L5;
        int r0 = 2131102418;
    L7:
        if ((r6 & 16) == 0) goto L9;
        r5 = null;
    L9:
        this.a = r2;
        this.b = new com.bytedance.ee.bear.more.protocol3.d(r3, r4, r0, r5);
        return;
    L5:
        r0 = 0;
        goto L7
    }
}
