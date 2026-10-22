package com.bytedance.ee.bear.wikiv2.more;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.t4;
import com.bytedance.ee.bear.more.export.BizType;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.o;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends com.bytedance.ee.bear.more.protocol3.g {
    public final Activity c;
    public final Document d;
    public TreeNode e;
    public WikNodePerm f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.more.a$a, reason: collision with other inner class name */
    public static final class C0205a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r20) {
            a r1 = this.a;
            TreeNode r2 = r1.e;
            WikNodePerm r11 = r1.f;
            if (r2 == null) goto L18;
            if (r11 == null) goto L18;
            Bundle r13 = new Bundle();
            r13.putInt("srcIsLock", r11.is_locked ? 1 : 0);
            r13.putString("src_space_id", r2.space_id);
            r13.putString("src_parent_token", r2.parent_wiki_token);
            r13.putString("src_token", r2.wiki_token);
            r13.putInt("src_obj_type", r2.obj_type);
            r13.putInt("EXTRA_PAGE_MODE", 2);
            r13.putString("trigger_location", "wiki_tree");
            r13.putBoolean("src_is_shortcut", r2.isShortcut());
            String r4 = null;
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(r1.c);
            qc5.a.j();
            if (r2.isShortcut() == true) goto L12;
            Activity r3 = r1.c;
            String r6 = r2.space_id;
            String r7 = r2.parent_wiki_token;
            String r8 = r2.wiki_token;
            boolean r9 = r2.has_child;
            String r10 = r2.title;
            WikiDetailInfo r5 = r2.detail_info;
            if (r5 == null) goto L11;
            r4 = r5.owner_id;
        L11:
            o.d(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.b(null, r3, r6, r7, r8, r9, r10, r11, 1029, r13, false, t4.a(r4), r2.obj_token, r2.obj_type));
        L19:
            this.a.getHost().a();
            return;
        L12:
            SelectorConfig r12 = new SelectorConfig();
            r12.c(SelectorType.WIKI_MOVE_TO);
            r12.a(SelectorScope.WIKI_ONLY);
            r12.g = 1029;
            r12.d = true;
            Activity r14 = r1.c;
            if (r14 == null) goto L16;
            String r15 = r14.getString(2131889814);
            if (r15 == null) goto L16;
        L17:
            Intrinsics.checkNotNullParameter(r15, "<set-?>");
            r12.b = r15;
            r13.putParcelable("extra_config", r12);
            o.f(null, r13);
            gq5.d.j("move_to", r2.space_id);
        L16:
            r15 = "";
        L18:
            tt5.a.h("ListWikiMoveItem", "doMoveTo, perm or node not found. return. ");
            goto L19
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.e = (TreeNode) r2;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            tt5.a.d("ListWikiMoveItem", "get wiki node fail. " + ((Throwable) r3));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            a r0 = this.a;
            r0.f = (WikNodePerm) r2;
            r0.f();
        }
    }

    public static final class f<T> implements Consumer {
        public static final f<T> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r3) {
            tt5.a.d("ListWikiMoveItem", "get wiki perm fail. " + ((Throwable) r3));
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        com.bytedance.ee.bear.more.protocol3.f.v r1 = com.bytedance.ee.bear.more.protocol3.f.v.c;
        b r5 = new b(this);
        com.bytedance.ee.bear.more.protocol3.j[] r0 = new com.bytedance.ee.bear.more.protocol3.j[3];
        boolean r3 = false;
        r0[0] = new com.bytedance.ee.bear.more.protocol3.checker.d();
        String r4 = e(2131888787);
        if ((c() instanceof oj5.a) == false) goto L11;
        oj5.c r6 = c();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
        oj5.d r7 = ((oj5.a) r6).H;
        if (r7 == null) goto L10;
        Integer r8 = r7.a();
        if (r8 == null) goto L10;
        if (r8.intValue() != BizType.Wiki.getValue()) goto L11;
    L10:
        boolean r9 = true;
    L12:
        r0[1] = new BizChecker(r4, r9);
        Activity r10 = this.c;
        String r11 = xo5.a.c(r10, 2131887930, ResourceData.KEY_TYPE, t0.n(r10, 16));
        WikNodePerm r12 = this.f;
        if (r12 != null) goto L15;
    L17:
        r0[2] = new BizChecker(r11, r3);
        List r13 = CollectionsKt.listOf(r0);
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r1, null, CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.checker.a(r1.a)), r13, r5, 2);
    L15:
        if (r12.show_move != true) goto L17;
        r3 = true;
    L11:
        r9 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public final void create() {
        if (this.d == null) goto L12;
        oj5.c r0 = c();
        if ((r0 instanceof oj5.f) == false) goto L13;
        oj5.d r1 = ((oj5.f) r0).H;
        if (r1 == null) goto L9;
        String r2 = r1.d();
    L10:
        NetService r3 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        new GetNodePuller(r3).d(new GetNodePuller.Params(r2, this.d.d)).subscribe(new c(this), d.a);
        new GetNodePermPuller(r3).d(new GetNodePermPuller.Params(r2, this.d.d)).subscribe(new e(this), f.a);
        return;
    L9:
        r2 = null;
        goto L10
    L13:
        return;
    }

    public final Activity getActivity() {
        return this.c;
    }

    public a(FragmentActivity r1, Document r2) {
        this.c = r1;
        this.d = r2;
    }
}
