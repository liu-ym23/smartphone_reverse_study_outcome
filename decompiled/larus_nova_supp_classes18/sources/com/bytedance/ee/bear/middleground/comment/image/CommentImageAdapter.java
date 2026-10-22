package com.bytedance.ee.bear.middleground.comment.image;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.uitls.CommentUtils;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.ui.RotateLoadingView;
import com.ss.android.lark.vfs.VFSFile;
import if5.f;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CommentImageAdapter extends RecyclerView.Adapter<e> {
    public boolean a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public final com.bytedance.ee.bear.imageviewer.b f;
    public String g;
    public int h;
    public final boolean i;
    public b j;
    public a k;
    public d l;
    public c m;
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> n;
    public final Map<String, String> o;
    public CompositeDisposable p;

    public interface a {
        void a(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r1);
    }

    public interface b {
        void a(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r1);
    }

    public interface c {
        void a(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r1);
    }

    public interface d {
        void a();
    }

    public class e extends RecyclerView.ViewHolder {
        public final CommentImageView a;
        public final ImageView b;
        public final View c;
        public final AppCompatImageView d;
        public gb5.e e;
        public final /* synthetic */ CommentImageAdapter f;

        public class a extends t {
            public final /* synthetic */ View c;
            public final /* synthetic */ e d;

            @Override // com.bytedance.ee.bear.widgets.t
            public final void a(View r3) {
                final CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r4 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) this.c.getTag();
                if (r4 == null) goto L9;
                b r0 = this.d.f.j;
                if (r0 == null) goto L7;
                r0.a(r4);
            L7:
                final CommentImageAdapter r1 = this.d.f;
                r1.getClass();
                j.c(new if5.d(r1, r4));
                return;
            }

            public a(e r1, View r2) {
                this.d = r1;
                this.c = r2;
            }
        }

        public class b extends t {
            public final /* synthetic */ View c;
            public final /* synthetic */ e d;

            @Override // com.bytedance.ee.bear.widgets.t
            public final void a(View r2) {
                CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r3 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) this.c.getTag();
                if (r3 == null) goto L8;
                a r0 = this.d.f.k;
                if (r0 == null) goto L9;
                r0.a(r3);
                return;
            L9:
                return;
            }

            public b(e r1, View r2) {
                this.d = r1;
                this.c = r2;
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, com.bytedance.ee.bear.middleground.comment.image.CommentImageView] */
        public e(CommentImageAdapter r4, final View r5) {
            this.f = r4;
            super(r5);
            ?? r0 = (CommentImageView) r5.findViewById(2131376595);
            this.a = r0;
            this.c = r5.findViewById(2131375021);
            r0.setDownloadImageAnalytic(r4.f);
            r0.setDocToken(r4.g);
            r0.setDocType(r4.h);
            ImageView r1 = (ImageView) r5.findViewById(2131376169);
            this.b = r1;
            r1.setOnClickListener(new a(this, r5));
            r5.setOnLongClickListener(new if5.e(this, r5));
            r5.setOnClickListener(new b(this, r5));
            Glide.with(r0);
            r0.setOnImageLoadFailListener(new f(this, r5));
            if (r4.a == false) goto L5;
            int r6 = 0;
        L6:
            r1.setVisibility(r6);
            this.d = r5.findViewById(2131367312);
            return;
        L5:
            r6 = 8;
            goto L6
        }

        public final void T3(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r8, boolean r9) {
            CommentImageView r0 = this.a;
            String r1 = (String) ((HashMap) this.f.o).get(r8.getSrc());
            String r2 = r8.getOriginalSrc();
            if (r0.c == true) goto L5;
        L10:
            r0.d = r1;
            r0.e = r2;
            r0.c = true;
            if (r9 == true) goto L13;
            tt5.a.h(r0.a, "Image can not preview! ");
            r0.setImageResource(2131232571);
            return;
        L13:
            boolean r3 = false;
            VFSFile r4 = null;
            if (com.bytedance.ee.util.io.e.c(r1) == true) goto L16;
            if (r1 != null) goto L21;
        L33:
            tt5.a.d(r0.a, "Image url is empty! ");
            r0.setImageResource(2131233320);
            r0.o();
            return;
        L21:
            if (r1.length() <= 0) goto L23;
            boolean r10 = true;
        L24:
            if (r10 == false) goto L33;
            tt5.a.b(r0.a, "loadLocalImageFile: ".concat(r1));
            r4 = ay4.d.a().i(r1);     // Catch: Throwable -> L28
        L32:
            r0.n(r4, r2);
            return;
        L28:
            th = move-exception;
            String r5 = r0.a;
            r3 = TextUtils.equals("com.bytedance.ee.docs.sdk.demo", eu5.b.a.getApplicationInfo().packageName);     // Catch: Exception -> L35
        L31:
            tt5.a.e(r5, "parse local file error!", th, true ^ r3);
            goto L32
        L23:
            r10 = false;
            goto L24
        L16:
            if (((v45.a) org.koin.java.a.c(v45.a.class, null, null, 6)).g(r1) == false) goto L18;
            tt5.a.b(r0.a, "driveDownloadForLoad: " + r1);
            r0.l(r1, r2, false);
            return;
        L18:
            tt5.a.b(r0.a, "glideDownloadForLoad: " + r1);
            r0.m(r1, r2, true, true, false);
            return;
        L5:
            if (Objects.equals(r1, r0.d) == true) goto L7;
        L9:
            r0.j();
            goto L10
        L7:
            if (Objects.equals(r2, r0.e) == false) goto L9;
            tt5.a.h(r0.a, "loadImage()... is loading the same url!");
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.n).size();
    }

    public CommentImageAdapter() {
        this.a = true;
        this.d = true;
        this.e = false;
        this.f = new com.bytedance.ee.bear.imageviewer.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class));
        this.i = true ^ com.bytedance.ee.bear.appsetting.c.a.a.i("ccm_mobile_ccm_at_doubao_reverse_in_feishu", false);
        this.n = new ArrayList();
        this.o = new HashMap();
        this.p = new CompositeDisposable();
    }

    public final void onDetachedFromRecyclerView(RecyclerView r1) {
        super.onDetachedFromRecyclerView(r1);
        this.p.dispose();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r3) {
        e r4 = (e) r3;
        super.onViewRecycled(r4);
        tt5.a.b("Comment#CommentImageAdapter", "onViewRecycled()... holder = Holder@" + r4.hashCode());
        r4.a.j();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        y2((e) r2, r3, false);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        return new e(this, LayoutInflater.from(r4.getContext()).inflate(2131559869, r4, false));
    }

    public final void z2(final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r4, final boolean r5) {
        if (r4 != null) goto L4;
    L11:
        if (r5 == true) goto L14;
        ((ArrayList) this.n).clear();
        notifyDataSetChanged();
        return;
    L14:
        return;
    L4:
        if (r4.isEmpty() == true) goto L11;
        if (this.p.isDisposed() == false) goto L9;
        this.p = new CompositeDisposable();
    L9:
        this.p.add(Flowable.just(r4).observeOn(fo5.d.a()).map(new if5.a(this)).observeOn(fo5.d.d()).subscribe(new if5.b(this, r5, r4), new if5.c()));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r1, int r2, List r3) {
        y2((e) r1, r2, !r3.isEmpty());
    }

    public final void y2(e r10, int r11, boolean r12) {
        if (r11 >= 0) goto L4;
        return;
    L4:
        if (r11 >= ((ArrayList) this.n).size()) goto L59;
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r0 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) ListProtector.get(this.n, r11);
        tt5.a.h("Comment#CommentImageAdapter", "onBindViewHolder()... holder = Holder@" + r10.hashCode() + ", position = " + r11 + ", forceReload = " + r12 + ", imageView = ImageView@" + r10.a.hashCode() + ", imageEntity = " + r0);
        if (this.e == false) goto L23;
        r10.c.setVisibility(0);
        if (r10.e != null) goto L21;
        Context r13 = r10.c.getContext();
        if (r10.f.i == false) goto L16;
        View r14 = new AppCompatImageView(r13);
        UDLoadingDrawable r5 = new UDLoadingDrawable(r13);
        r5.setColorSchemeColors(new int[]{y9c.d.c(r13, 2131108721)});
        r5.start();
        r14.setImageDrawable(r5);
        int r15 = UIUtils.dp2px(r13, 42.0f);
        if (r10.f.b <= 0) goto L15;
        ViewGroup.LayoutParams r16 = ((RecyclerView.ViewHolder) r10).itemView.getLayoutParams();
        int r2 = r10.f.b;
        r16.width = r2;
        r16.height = r2;
        ((RecyclerView.ViewHolder) r10).itemView.setLayoutParams(r16);
        r15 = r10.f.b;
    L15:
        ((ViewGroup) r10.c.getParent()).addView(r14, new FrameLayout.LayoutParams(r15, r15, 17));
    L20:
        r10.e = new gb5.e(r14);
        goto L21
    L16:
        r14 = new RotateLoadingView(r13);
        int r17 = UIUtils.dp2px(r13, 42.0f);
        if (r10.f.b <= 0) goto L19;
        ViewGroup.LayoutParams r18 = ((RecyclerView.ViewHolder) r10).itemView.getLayoutParams();
        int r3 = r10.f.b;
        r18.width = r3;
        r18.height = r3;
        ((RecyclerView.ViewHolder) r10).itemView.setLayoutParams(r18);
        r17 = r10.f.b;
    L19:
        ((ViewGroup) r10.c.getParent()).addView(r14, new FrameLayout.LayoutParams(r17, r17, 17));
    L21:
        gb5.e r19 = r10.e;
        r19.getClass();
        tt5.a.h("LazyLoadingHelper", "showLoading");
        j.e(r19.b);
        j.e(r19.c);
        j.d(r19.b, 250);
        return;
    L23:
        r10.c.setVisibility(8);
        gb5.e r110 = r10.e;
        if (r110 == null) goto L26;
        tt5.a.h("LazyLoadingHelper", "hideLoading");
        j.e(r110.b);
        j.e(r110.c);
        j.f(r110.c);
    L26:
        ((RecyclerView.ViewHolder) r10).itemView.setTag(r0);
        if (this.b <= 0) goto L34;
        ViewGroup.LayoutParams r111 = ((RecyclerView.ViewHolder) r10).itemView.getLayoutParams();
        int r1 = this.b;
        r111.width = r1;
        r111.height = r1;
        ((RecyclerView.ViewHolder) r10).itemView.setLayoutParams(r111);
        int r112 = Math.min((int) (((double) this.b) * 0.2d), n.d(20));
        ViewGroup.LayoutParams r4 = r10.d.getLayoutParams();
        if (r4 == null) goto L34;
        if (r112 <= r4.height) goto L34;
        r4.width = r112;
        r4.height = r112;
        r10.d.setLayoutParams(r4);
    L34:
        if (this.c <= 0) goto L37;
        ViewGroup.LayoutParams r113 = r10.b.getLayoutParams();
        int r6 = this.c;
        r113.width = r6;
        r113.height = r6;
        r10.b.setLayoutParams(r113);
    L37:
        if (r0.getLoadFail() == false) goto L47;
        if (r12 == false) goto L43;
        r0.setLoadFail(false);
        c r114 = this.m;
        if (r114 == null) goto L42;
        r114.a(r0);
    L42:
        r10.T3(r0, this.d);
    L48:
        Lazy r115 = CommentUtils.a;
        boolean r116 = ((Boolean) CommentUtils.a(this.h, true).getFirst()).booleanValue();
        if (r0.getAreaMark() != null) goto L51;
        int r117 = 0;
    L52:
        if (r116 == false) goto L55;
        if (r117 <= 0) goto L55;
        r10.d.setVisibility(0);
        return;
    L55:
        r10.d.setVisibility(8);
        return;
    L51:
        r117 = r0.getAreaMark().size();
        goto L52
    L43:
        CommentImageView r118 = r10.a;
        if (r118.c == false) goto L46;
        r118.j();
    L46:
        r118.setImageResource(2131233320);
        goto L48
    L47:
        r10.T3(r0, this.d);
        goto L48
    }
}
