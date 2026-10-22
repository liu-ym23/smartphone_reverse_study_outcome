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
import com.larus.nova.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class EmojiGifPresenter extends BaseCmtInputPresenter implements vy3.b, g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.comment.write.refactor.g f194513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f194514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f194515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f194516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f194517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public vy3.a f194518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f194519l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.comment.widget.view.d f194520m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.a f194521n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<Object> f194522o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<Object> f194523p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f194524q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView f194525r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CommentMiniPanelAdapter f194526s;

    public static final class a implements dz3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EmojiGifPresenter f194527a;

        @Override // dz3.a
        public final void a() {
            this.f194527a.getClass();
        }

        public a(EmojiGifPresenter r100) {
            this.f194527a = r100;
        }
    }

    public static final class b implements dz3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EmojiGifPresenter f194528a;

        @Override // dz3.a
        public final void a() {
            this.f194528a.getClass();
        }

        public b(EmojiGifPresenter r100) {
            this.f194528a = r100;
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
        int r100 = e.f194533a;
        int r101 = f.f194534a;
        View r102 = this.f194514g;
        if (r102 == null) goto L6;
        r102.setVisibility(0);
    L6:
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d r103 = this.f194520m;
        if (r103 == null) goto L11;
        r103.f194364a.setVisibility(8);
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d.a r104 = r103.f194365b;
        if (r104 == null) goto L11;
        Intrinsics.checkNotNull(r104);
        r104.a(8);
    L11:
        bz3.b r105 = this.f194513f.f194547o;
        if (r105 == null) goto L15;
        r105.d(new a(this));
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseCmtInputPresenter
    public final void I() {
        ImageView r100 = this.f194516i;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
    L6:
        m(this.f194513f.f194540h);
        bz3.b r101 = this.f194513f.f194547o;
        if (r101 == null) goto L10;
        r101.f(new b(this));
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g
    public final void o() {
        bz3.b r100 = this.f194513f.f194547o;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g
    public final com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.a f() {
        return this.f194521n;
    }

    public EmojiGifPresenter(com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r100) {
        Intrinsics.checkNotNullParameter(r100, "inputContext");
        super(r100);
        this.f194513f = r100;
        this.f194515h = LazyKt.lazy(new EmojiGifPresenter$mEditText$2(this));
        y54.a.a();
        v04.a.a().getClass();
        this.f194523p = EmojiValueRes.getRecEmojiList();
        LifecycleOwner r101 = r100.f561864b.f195172d;
        int r102 = xy3.a.f565402a;
        xy3.a.c(g.class, this, r101);
    }

    @Override // az3.a
    public final void A(com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a r100) {
        l r101 = (l) r100;
        Intrinsics.checkNotNullParameter(r101, "viewProvider");
        super.F(r101);
        View r102 = this.f194492e;
        LinearLayout r103 = null;
        if (r102 == null) goto L5;
        ViewGroup r104 = (ViewGroup) r102.findViewById(R.id.mini_emoji_panel_container);
    L6:
        this.f194524q = r104;
        if (r104 != null) goto L10;
    L34:
        View r105 = this.f194492e;
        if (r105 == null) goto L37;
        ImageView r106 = (ImageView) r105.findViewById(R.id.iv_emoji);
    L38:
        this.f194516i = r106;
        if (r106 == null) goto L41;
        r106.setOnClickListener(new com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.b(this));
    L41:
        View r107 = this.f194492e;
        if (r107 == null) goto L44;
        View r108 = r107.findViewById(R.id.layout_content);
    L45:
        this.f194517j = r108;
        View r109 = this.f194492e;
        if (r109 == null) goto L48;
        View r110 = r109.findViewById(R.id.layout_input);
    L49:
        this.f194514g = r110;
        View r111 = this.f194492e;
        if (r111 == null) goto L52;
        r103 = (LinearLayout) r111.findViewById(R.id.panel_container);
    L52:
        this.f194519l = r103;
        if (r103 == null) goto L56;
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d r112 = new com.bytedance.awemeopen.apps.framework.comment.widget.view.d(r103);
        this.f194520m = r112;
        d r113 = new d(this);
        Intrinsics.checkNotNullParameter(r113, "listener");
        r112.f194365b = r113;
        return;
    L56:
        return;
    L48:
        r110 = null;
        goto L49
    L44:
        r108 = null;
        goto L45
    L37:
        r106 = null;
        goto L38
    L10:
        if (this.f194518k != null) goto L16;
        CommentMentionEditText r114 = (CommentMentionEditText) this.f194515h.getValue();
        if (r114 == null) goto L14;
        int r115 = this.f194513f.f194545m;
        vy3.a r116 = new vy3.a(r114, this);
    L15:
        this.f194518k = r116;
        goto L16
    L14:
        r116 = null;
    L16:
        ViewGroup r117 = this.f194524q;
        if (r117 == null) goto L19;
        RecyclerView r118 = (RecyclerView) r117.findViewById(R.id.emoji_recyclerview);
    L20:
        this.f194525r = r118;
        this.f194526s = new CommentMiniPanelAdapter(this.f194518k, null, -1, false);
        CommentMiniPanelItemDecoration r119 = new CommentMiniPanelItemDecoration();
        RecyclerView r120 = this.f194525r;
        if (r120 == null) goto L24;
        r120.setAdapter(this.f194526s);
    L24:
        RecyclerView r121 = this.f194525r;
        if (r121 == null) goto L28;
        r121.setLayoutManager(new LinearLayoutManager(this.f194513f.getContext(), 0, false));
    L28:
        RecyclerView r122 = this.f194525r;
        if (r122 == null) goto L31;
        r122.addItemDecoration(r119);
    L31:
        CommentMiniPanelAdapter r123 = this.f194526s;
        if (r123 == null) goto L34;
        r123.setData(this.f194523p);
        goto L34
    L19:
        r118 = null;
        goto L20
    L5:
        r104 = null;
        goto L6
    }

    @Override // vy3.b
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "emojiText");
        boolean r101 = this.f194513f.f561867e;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g
    public final void m(boolean r100) {
        if (r100 == false) goto L18;
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d r101 = this.f194520m;
        if (r101 == null) goto L8;
        r101.f194364a.setVisibility(0);
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d.a r102 = r101.f194365b;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNull(r102);
        r102.a(0);
    L8:
        ImageView r103 = this.f194516i;
        if (r103 != null) goto L11;
    L15:
        com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.a r104 = this.f194521n;
        if (r104 == null) goto L31;
        r104.a();
        return;
    L31:
        return;
    L11:
        if (n0.c(this.f194513f.getContext()) == false) goto L13;
        int r105 = R.drawable.aos_write_comment_input_dark;
    L14:
        r103.setImageResource(r105);
        goto L15
    L13:
        r105 = R.drawable.aos_write_comment_input;
        goto L14
    L18:
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d r106 = this.f194520m;
        if (r106 == null) goto L23;
        r106.f194364a.setVisibility(4);
        com.bytedance.awemeopen.apps.framework.comment.widget.view.d.a r107 = r106.f194365b;
        if (r107 == null) goto L23;
        Intrinsics.checkNotNull(r107);
        r107.a(4);
    L23:
        ImageView r108 = this.f194516i;
        if (r108 != null) goto L26;
        return;
    L26:
        if (n0.c(this.f194513f.getContext()) == false) goto L28;
        int r109 = R.drawable.aos_write_comment_emoji_dark;
    L29:
        r108.setImageResource(r109);
        return;
    L28:
        r109 = R.drawable.aos_write_comment_emoji;
        goto L29
    }

    @Override // vy3.b
    public final void q(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "emojiText");
        i r102 = this.f194513f.f194550r;
        if (r102 == null) goto L6;
        r102.b();
        return;
    }
}
