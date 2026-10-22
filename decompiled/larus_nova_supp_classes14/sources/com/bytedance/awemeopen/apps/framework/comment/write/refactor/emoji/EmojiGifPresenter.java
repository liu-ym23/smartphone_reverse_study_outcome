package com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.comment.adapter.CommentMiniPanelItemDecoration;
import com.bytedance.awemeopen.apps.framework.comment.adapter.minichoose.CommentMiniPanelAdapter;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import com.bytedance.awemeopen.apps.framework.comment.write.i;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseCmtInputPresenter;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.l;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.emojires.EmojiValueRes;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class EmojiGifPresenter extends BaseCmtInputPresenter implements vy3.b, g {
    public final com.bytedance.awemeopen.apps.framework.comment.write.refactor.g f;
    public View g;
    public final Lazy h;
    public ImageView i;
    public View j;
    public vy3.a k;
    public LinearLayout l;
    public com.bytedance.awemeopen.apps.framework.comment.widget.view.d m;
    public com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.a n;
    public List<Object> o;
    public final List<Object> p;
    public ViewGroup q;
    public RecyclerView r;
    public CommentMiniPanelAdapter s;

    public static final class a implements dz3.a {
        public final /* synthetic */ EmojiGifPresenter a;

        @Override // dz3.a
        public final void a() {
            this.a.getClass();
        }

        public a(EmojiGifPresenter r1) {
            this.a = r1;
        }
    }

    public static final class b implements dz3.a {
        public final /* synthetic */ EmojiGifPresenter a;

        @Override // dz3.a
        public final void a() {
            this.a.getClass();
        }

        public b(EmojiGifPresenter r1) {
            this.a = r1;
        }
    }

    @Override // az3.a
    public final void C() {
    }

    @Override // az3.a
    public final void D() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseCmtInputPresenter
    public final void G() {
        int r0 = e.a;
        int r1 = f.a;
        View r2 = this.g;
        if (r2 == null) goto L6;
        r2.setVisibility(0);
    L6:
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d r3 = this.m;
        if (r3 == null) goto L11;
        r3.a.setVisibility(8);
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d.a r4 = r3.b;
        if (r4 == null) goto L11;
        Intrinsics.checkNotNull(r4);
        r4.a(8);
    L11:
        bz3.b r5 = this.f.o;
        if (r5 == null) goto L15;
        r5.d(new a(this));
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseCmtInputPresenter
    public final void I() {
        ImageView r0 = this.i;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        m(this.f.h);
        bz3.b r1 = this.f.o;
        if (r1 == null) goto L10;
        r1.f(new b(this));
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g
    public final void o() {
        bz3.b r0 = this.f.o;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g
    public final com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.a f() {
        return this.n;
    }

    public EmojiGifPresenter(com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r2) {
        Intrinsics.checkNotNullParameter(r2, "inputContext");
        super(r2);
        this.f = r2;
        this.h = LazyKt.lazy(new EmojiGifPresenter$mEditText$2(this));
        y54.a.a();
        v04.a.a().getClass();
        this.p = EmojiValueRes.getRecEmojiList();
        LifecycleOwner r3 = r2.b.d;
        int r0 = xy3.a.a;
        xy3.a.c(g.class, this, r3);
    }

    @Override // az3.a
    public final void A(com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a r6) {
        l r7 = (l) r6;
        Intrinsics.checkNotNullParameter(r7, "viewProvider");
        super.F(r7);
        View r8 = this.e;
        LinearLayout r0 = null;
        if (r8 == null) goto L5;
        ViewGroup r9 = (ViewGroup) r8.findViewById(2131380142);
    L6:
        this.q = r9;
        if (r9 != null) goto L10;
    L34:
        View r10 = this.e;
        if (r10 == null) goto L37;
        ImageView r11 = (ImageView) r10.findViewById(2131376206);
    L38:
        this.i = r11;
        if (r11 == null) goto L41;
        r11.setOnClickListener(new com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.b(this));
    L41:
        View r12 = this.e;
        if (r12 == null) goto L44;
        View r13 = r12.findViewById(2131377472);
    L45:
        this.j = r13;
        View r14 = this.e;
        if (r14 == null) goto L48;
        View r15 = r14.findViewById(2131377522);
    L49:
        this.g = r15;
        View r16 = this.e;
        if (r16 == null) goto L52;
        r0 = (LinearLayout) r16.findViewById(2131381866);
    L52:
        this.l = r0;
        if (r0 == null) goto L56;
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d r17 = new com.bytedance.awemeopen.apps.framework.comment.widget.view.d(r0);
        this.m = r17;
        d r1 = new d(this);
        Intrinsics.checkNotNullParameter(r1, "listener");
        r17.b = r1;
        return;
    L56:
        return;
    L48:
        r15 = null;
        goto L49
    L44:
        r13 = null;
        goto L45
    L37:
        r11 = null;
        goto L38
    L10:
        if (this.k != null) goto L16;
        CommentMentionEditText r18 = (CommentMentionEditText) this.h.getValue();
        if (r18 == null) goto L14;
        int r2 = this.f.m;
        vy3.a r3 = new vy3.a(r18, this);
    L15:
        this.k = r3;
        goto L16
    L14:
        r3 = null;
    L16:
        ViewGroup r19 = this.q;
        if (r19 == null) goto L19;
        RecyclerView r20 = (RecyclerView) r19.findViewById(2131371544);
    L20:
        this.r = r20;
        this.s = new CommentMiniPanelAdapter(this.k, null, -1, false);
        CommentMiniPanelItemDecoration r21 = new CommentMiniPanelItemDecoration();
        RecyclerView r4 = this.r;
        if (r4 == null) goto L24;
        r4.setAdapter(this.s);
    L24:
        RecyclerView r5 = this.r;
        if (r5 == null) goto L28;
        r5.setLayoutManager(new LinearLayoutManager(this.f.getContext(), 0, false));
    L28:
        RecyclerView r22 = this.r;
        if (r22 == null) goto L31;
        r22.addItemDecoration(r21);
    L31:
        CommentMiniPanelAdapter r23 = this.s;
        if (r23 == null) goto L34;
        r23.setData(this.p);
        goto L34
    L19:
        r20 = null;
        goto L20
    L5:
        r9 = null;
        goto L6
    }

    @Override // vy3.b
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "emojiText");
        boolean r3 = this.f.e;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g
    public final void m(boolean r3) {
        if (r3 == false) goto L18;
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d r4 = this.m;
        if (r4 == null) goto L8;
        r4.a.setVisibility(0);
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d.a r5 = r4.b;
        if (r5 == null) goto L8;
        Intrinsics.checkNotNull(r5);
        r5.a(0);
    L8:
        ImageView r6 = this.i;
        if (r6 != null) goto L11;
    L15:
        com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.a r7 = this.n;
        if (r7 == null) goto L31;
        r7.a();
        return;
    L31:
        return;
    L11:
        if (n0.c(this.f.getContext()) == false) goto L13;
        int r0 = 2131231640;
    L14:
        r6.setImageResource(r0);
        goto L15
    L13:
        r0 = 2131231639;
        goto L14
    L18:
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d r8 = this.m;
        if (r8 == null) goto L23;
        r8.a.setVisibility(4);
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d.a r9 = r8.b;
        if (r9 == null) goto L23;
        Intrinsics.checkNotNull(r9);
        r9.a(4);
    L23:
        ImageView r10 = this.i;
        if (r10 != null) goto L26;
        return;
    L26:
        if (n0.c(this.f.getContext()) == false) goto L28;
        int r1 = 2131231638;
    L29:
        r10.setImageResource(r1);
        return;
    L28:
        r1 = 2131231637;
        goto L29
    }

    @Override // vy3.b
    public final void q(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "emojiText");
        i r3 = this.f.r;
        if (r3 == null) goto L6;
        r3.b();
        return;
    }
}
