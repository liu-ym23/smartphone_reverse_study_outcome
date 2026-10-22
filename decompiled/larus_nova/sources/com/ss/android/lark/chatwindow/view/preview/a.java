package com.ss.android.lark.chatwindow.view.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.r0;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements c<C4882a, h2b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f417039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f417040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View.OnLongClickListener f417041c;

    /* JADX INFO: renamed from: com.ss.android.lark.chatwindow.view.preview.a$a, reason: collision with other inner class name */
    public static final class C4882a extends c.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f417042b;

        public C4882a(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public interface b {
        boolean a();

        String b();

        String c();

        String d();

        String e();

        String f();

        void g();

        String getChatId();

        String getP2pChatterId();

        boolean isCrossTenant();

        boolean isGroup();
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final int getPreviewType() {
        return 2;
    }

    public final Context getContext() {
        return this.f417039a;
    }

    public static void c(View r100, View.OnLongClickListener r101) {
        if (r100.hasOnClickListeners() == false) goto L6;
        r100.setOnLongClickListener(r101);
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L10;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L12;
        c(r102.getChildAt(r104), r101);
        r104 = r104 + 1;
        goto L8
    L12:
        return;
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final void a(h2b.a r210, c.a r211) {
        h2b.b r100 = (h2b.b) r210;
        C4882a r101 = (C4882a) r211;
        Object r102 = null;
        if (r100 == null) goto L5;
        DocResult r103 = r100.f483635a;
    L6:
        if (r103 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L53;
        if (r101 == null) goto L15;
        ViewGroup r105 = r101.f417043a;
    L17:
        if (r105 == null) goto L19;
        Object r106 = r105.getTag(R.id.tag_item_holder_view);
    L20:
        ibb.c r107 = (ibb.c) r106;
        if (r107 != null) goto L23;
        ChatCoreModule.a().getCcmDependency().b();
        ibb.c r108 = null;
    L24:
        if (r108 != null) goto L27;
        return;
    L27:
        if (r101 == null) goto L31;
        ViewGroup r109 = r101.f417043a;
        if (r109 == null) goto L31;
        r102 = r109.getTag(R.id.doc_preview_view_tag);
    L31:
        View r110 = (View) r102;
        if (r110 != null) goto L37;
        if (r101 == null) goto L37;
        ViewGroup r111 = r101.f417043a;
        if (r111 == null) goto L37;
        r110 = r108.b(r111);
        r111.addView(r110);
        r111.setTag(R.id.tag_item_holder_view, r108);
        r111.setTag(R.id.doc_preview_view_tag, r110);
    L37:
        if (r101 == null) goto L39;
        r101.f417042b = r110;
    L39:
        if (r101 == null) goto L50;
        View r112 = r101.f417042b;
        if (r112 == null) goto L51;
        if (r100 == null) goto L46;
        DocResult r113 = r100.f483635a;
        if (r113 == null) goto L46;
        String r114 = this.f417040b.e();
        String r115 = this.f417040b.b();
        String r116 = this.f417040b.getP2pChatterId();
        String r117 = this.f417040b.f();
        String r118 = this.f417040b.d();
        String r119 = this.f417040b.getChatId();
        String r120 = this.f417040b.c();
        boolean r121 = this.f417040b.isCrossTenant();
        boolean r122 = this.f417040b.isGroup();
        boolean r123 = this.f417040b.a();
        this.f417040b.g();
        r108.a(r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, false);
    L46:
        r112.setOnLongClickListener(this.f417041c);
        ViewGroup r124 = r101.f417043a;
        if (r124 == null) goto L52;
        c(r124, this.f417041c);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L23:
        r108 = r107;
        goto L24
    L19:
        r106 = null;
        goto L20
    L15:
        r105 = null;
        goto L17
    L53:
        return;
    L8:
        if (r0.f(r100.f483635a, this.f417040b.a()) == false) goto L10;
        r104 = true;
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final c.a b(h2b.a r100, ViewGroup r101) {
        h2b.b r102 = (h2b.b) r100;
        Intrinsics.checkNotNullParameter(r101, "parent");
        if (r102 == null) goto L5;
        DocResult r103 = r102.f483635a;
    L6:
        if (r103 != null) goto L9;
        return null;
    L9:
        return new C4882a(r101);
    L5:
        r103 = null;
        goto L6
    }

    public a(FragmentActivity r100, m7b.a r101, View.OnLongClickListener r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataProvider");
        this.f417039a = r100;
        this.f417040b = r101;
        this.f417041c = r102;
    }
}
