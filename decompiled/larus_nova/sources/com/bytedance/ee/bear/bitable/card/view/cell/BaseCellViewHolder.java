package com.bytedance.ee.bear.bitable.card.view.cell;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.ee.bear.bitable.card.model.enums.EFieldUneditableReason;
import com.bytedance.ee.bear.bitable.card.model.enums.EItemViewSceneType;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.AttachmentCellViewHolder;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.bitable.card.view.page.PageCellContainerLayout;
import com.bytedance.ee.bear.bitable.card.view.record.BaseCellAdapter;
import com.bytedance.ee.bear.bitable.card.view.record.RecordCellAdapter;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.documentinfo.BlockInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.menu.PositionAlign;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.pb.security_event.ContainerType;
import com.ss.android.lark.pb.security_event.RenderItem;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import hp4.k;
import hp4.l;
import hp4.m;
import hp4.o;
import hp4.p;
import hp4.r;
import hp4.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class BaseCellViewHolder<V, E> extends RecyclerView.ViewHolder implements com.bytedance.ee.bear.bitable.card.view.cell.b<V, E>, ocb.a, v, com.bytedance.ee.bear.bitable.card.view.cell.a.InterfaceC2991a {
    public static final /* synthetic */ int E = 0;
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gp4.h f207229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final aq4.a f207230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.view.cell.b.a f207231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public dp4.a f207232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public fp4.g f207233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f207234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final hp4.h f207235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final hp4.h f207236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final pcb.a f207237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f207238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f207239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f207240l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f207241m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f207242n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f207243o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f207244p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f207245q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f207246r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f207247s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AppCompatImageView f207248t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final View f207249u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.larksuite.component.universe_design.menu.c f207250v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public m f207251w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public j f207252x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.view.cell.b.InterfaceC2994b f207253y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CompositeDisposable f207254z;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EFieldUneditableReason f207255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BaseCellViewHolder f207256d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            BaseCellViewHolder r101 = this.f207256d;
            if (((PageCellContainerLayout) r101.itemView).f208466c == false) goto L5;
            r101.L4(this.f207255c);
            return;
        L5:
            tt5.a.h("BaseCellViewHolder", "outside hotspot onUneditable");
        }

        public a(BaseCellViewHolder r100, EFieldUneditableReason r101) {
            this.f207256d = r100;
            this.f207255c = r101;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f207257a = null;

        static {
            int[] r100 = new int[EFieldUneditableReason.values().length];
            f207257a = r100;
            r100[EFieldUneditableReason.SUITE_NO_EDIT_PERM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f207257a[EFieldUneditableReason.FIELD_NOT_SUPPORT_EDIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f207257a[EFieldUneditableReason.DRILL_DOWN_NOT_SUPPORT_EDIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f207257a[EFieldUneditableReason.LANDSCAPE_READONLY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f207257a[EFieldUneditableReason.ATTACHMENT_FORBIDDEN_IN_PRO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f207257a[EFieldUneditableReason.BITABLE_IS_NOT_READY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f207257a[EFieldUneditableReason.IS_SYNC_TABLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f207257a[EFieldUneditableReason.IS_EXTEND_FIELD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f207257a[EFieldUneditableReason.OTHERS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseCellViewHolder f207258a;

        public c(BaseCellViewHolder r100) {
            this.f207258a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f207258a.onViewAttachedToWindow();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            this.f207258a.onViewDetachedFromWindow();
        }
    }

    public class d extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseCellViewHolder f207259c;

        public d(BaseCellViewHolder r100) {
            this.f207259c = r100;
            super(800);
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f207259c.a4();
        }
    }

    public class e extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseCellViewHolder f207260c;

        public e(BaseCellViewHolder r100) {
            this.f207260c = r100;
            super(800);
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f207260c.a4();
        }
    }

    public class f extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseCellViewHolder f207261c;

        public f(BaseCellViewHolder r100) {
            this.f207261c = r100;
            super(800);
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (this.f207261c.y4() == false) goto L8;
            BaseCellViewHolder r101 = this.f207261c;
            if (r101.f207234f == true) goto L9;
            r101.Z3();
            return;
        L9:
            return;
        }
    }

    public class g extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseCellViewHolder f207262c;

        public g(BaseCellViewHolder r100) {
            this.f207262c = r100;
            super(800);
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            BaseCellViewHolder r101 = this.f207262c;
            if (((PageCellContainerLayout) r101.itemView).f208466c == true) goto L5;
            tt5.a.h("BaseCellViewHolder", "outside hotspot onEditable");
            return;
        L5:
            if (r101.y4() == false) goto L11;
            BaseCellViewHolder r102 = this.f207262c;
            if (r102.f207234f == true) goto L12;
            r102.Z3();
            return;
        L12:
            return;
        }
    }

    public class h implements com.larksuite.component.universe_design.menu.c.InterfaceC3918c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseCellViewHolder f207263a;

        public h(BaseCellViewHolder r100) {
            this.f207263a = r100;
        }

        @Override // com.larksuite.component.universe_design.menu.c.InterfaceC3918c
        public final void a(PopupWindow r100) {
            BitableAnalytic r101 = this.f207263a.f207229a.q0();
            String r102 = this.f207263a.i4();
            r101.getClass();
            HashMap r103 = new HashMap();
            r103.put("field_type", r102);
            r101.t("ccm_bitable_field_input_action_mobile_view", r103);
        }
    }

    public class i implements com.larksuite.component.universe_design.menu.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseCellViewHolder f207264a;

        @Override // com.larksuite.component.universe_design.menu.c.b
        public final void onDismiss() {
            this.f207264a.c4();
        }

        public i(BaseCellViewHolder r100) {
            this.f207264a = r100;
        }
    }

    public static class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<View> f207265a;

        public final void a() {
            if (this.f207265a.get() != null) goto L5;
            return;
        L5:
            if (this.f207265a.get().isActivated() == false) goto L11;
            this.f207265a.get().setActivated(false);
            if (this.f207265a.get().getBackground() == null) goto L12;
            this.f207265a.get().getBackground().setAlpha(255);
            return;
        L12:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(View r100) {
            this.f207265a = new WeakReference(r100);
        }
    }

    public boolean A4() {
        return false;
    }

    public boolean B4() {
        return false;
    }

    public boolean C4() {
        return this instanceof AttachmentCellViewHolder;
    }

    public void O4() {
    }

    public void Z3() {
        this.f207234f = true;
        ((BaseCellAdapter) this.f207253y).M2(this);
        U3();
        J4(B4());
        if (B4() == false) goto L5;
        this.f207243o.setOnClickListener(new l(this));
    L5:
        E4(true);
        this.f207229a.B();
        tt5.a.h("BaseCellViewHolder", i4() + " : enterEditMode");
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public void b0() {
    }

    public String d4(Object r100, V r101) {
        return "";
    }

    public abstract View getContentView();

    public gp4.g k4() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public void onViewRecycled() {
    }

    public boolean v4() {
        return false;
    }

    public void A() {
        boolean r100 = this.f207236h.f486413e;
        if (this.f207234f == false) goto L6;
        if (r100 == true) goto L6;
        c4();
        rcb.c.d(getContentView());
    L6:
        View r101 = getContentView();
        if (r101 != null) goto L9;
        return;
    L9:
        boolean r102 = true;
        r101.setFocusable(true);
        r101.setFocusableInTouchMode(true);
        if (this.f207239k == false) goto L60;
        boolean r103 = u4();
        boolean r104 = t4();
        EItemViewSceneType r105 = this.f207229a.t();
        if (r105 != EItemViewSceneType.FAST_ADD_RECORD) goto L14;
    L17:
        boolean r106 = true;
    L18:
        int r107 = 8;
        this.f207247s.setVisibility(8);
        if (r106 == false) goto L24;
        if (r104 == false) goto L24;
        if (r103 == false) goto L24;
        this.f207247s.setVisibility(0);
    L33:
        if (C4() == true) goto L35;
    L38:
        boolean r108 = false;
    L39:
        AppCompatImageView r109 = this.f207248t;
        if (r108 == false) goto L42;
        r107 = 0;
    L42:
        r109.setVisibility(r107);
        if (r108 == false) goto L56;
        int r110 = l4() + n.d(32);
        int r111 = j4();
        int r112 = this.f207248t.getLayoutParams().width;
        if (r110 >= r111) goto L48;
        r102 = false;
    L48:
        if (r102 == false) goto L50;
        this.f207248t.getLayoutParams().width = r111;
        this.f207248t.setBackgroundResource(R.drawable.bitable_page_field_empty_value_icon_big_bg);
    L51:
        if (r112 == 0) goto L64;
        if (r112 == this.f207248t.getLayoutParams().width) goto L64;
        this.f207248t.requestLayout();
    L64:
        if ((r101 instanceof EditText) == false) goto L67;
        ((EditText) r101).setCursorVisible(r100);
    L67:
        if (k4() == null) goto L69;
        k4().setIPermissionCopyChecker(this);
    L69:
        if (r100 == true) goto L71;
        q4(this.f207235g.f486410b);
        return;
    L71:
        if (this.C == false) goto L73;
        s4();
    L75:
        if (this.f207235g.f486413e == true) goto L77;
        return;
    L77:
        if (A4() == false) goto L89;
        ViewStub r113 = (ViewStub) this.f207229a.v().findViewById(R.id.keyboard_toolbar_view_stub);
        if (r113 != null) goto L81;
    L83:
        View r114 = this.f207229a.v().findViewById(R.id.keyboard_toolbar_container);
        this.f207240l = r114;
        if (r114 == null) goto L90;
        this.f207241m = r114.findViewById(R.id.keyboard_toolbar_view);
        this.f207242n = this.f207240l.findViewById(R.id.keyboard_toolbar_divider);
        this.f207243o = this.f207240l.findViewById(R.id.keyboard_toolbar_done_btn);
        return;
    L90:
        return;
    L81:
        if (r113.getParent() == null) goto L83;
        r113.inflate();
        goto L83
    L89:
        return;
    L73:
        r4();
        goto L75
    L50:
        ViewGroup.LayoutParams r115 = this.f207248t.getLayoutParams();
        r115.width = n.d(32);
        this.f207248t.setBackgroundResource(R.drawable.bitable_page_field_empty_value_icon_bg);
        goto L51
    L56:
        if ((r101 instanceof BitableAtEditText) == false) goto L64;
        if (r101.hasOnClickListeners() == true) goto L64;
        r101.setOnClickListener(new hp4.i(this));
        goto L64
    L35:
        if (this.f207235g.f486413e == false) goto L38;
        if (r103 == false) goto L38;
        r108 = true;
    L24:
        if (m4() == null) goto L33;
        View r116 = m4();
        if (r103 == true) goto L28;
    L30:
        int r117 = 8;
    L31:
        r116.setVisibility(r117);
        goto L33
    L28:
        if (this.f207235g.f486413e == true) goto L30;
        r117 = 0;
        goto L31
    L14:
        if (r105 == EItemViewSceneType.SUBMIT_MODE) goto L17;
        r106 = false;
        goto L18
    L60:
        if (r100 == false) goto L62;
        this.f207235g.getClass();
        r101.setBackgroundResource(R.drawable.bitable_card_field_item_bg_selector);
        goto L64
    L62:
        this.f207235g.getClass();
        r101.setBackgroundResource(R.drawable.bitable_uneditable_field_item_selector_v2);
        goto L64
    }

    public void F4() {
        View r100 = this.itemView;
        if ((r100 instanceof PageCellContainerLayout) == false) goto L5;
        View r101 = r100.findViewById(R.id.divider);
        TextView r102 = (TextView) this.itemView.findViewById(R.id.warning_text);
        r101.setBackgroundColor(n.h(this.itemView.getContext(), R.color.line_border_card));
        r102.setVisibility(8);
        fp4.g r103 = this.f207233e;
        r103.f478263j = null;
        r103.f478264k = null;
        return;
    L5:
        TextView r104 = (TextView) r100.findViewById(R.id.cell_error_msg);
        if (r104 == null) goto L10;
        View r105 = this.itemView;
        if ((r105 instanceof ViewGroup) == false) goto L10;
        ((ViewGroup) r105).removeView(r104);
    L10:
        fp4.g r106 = this.f207233e;
        r106.f478263j = null;
        r106.f478264k = null;
    }

    public final void H4() {
        if (this.f207236h.f486411c == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        FrameLayout r101 = (FrameLayout) this.itemView.findViewById(R.id.cell_content_container);
        r101.removeAllViews();
        r101.setBackgroundResource(R.drawable.bitable_disable_field_item_selector);
        TextView r102 = new TextView(r101.getContext());
        r102.setGravity(16);
        r102.setPadding(n.d(10), 0, n.d(10), 0);
        r102.setText(this.f207236h.f486411c);
        r102.setTextColor(ContextCompat.getColor(r101.getContext(), R.color.text_placeholder));
        r102.setTextSize(14.0f);
        r101.addView(r102, -1, n.d(40));
        q4(this.f207236h.f486410b);
        return;
    L8:
        A();
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // hp4.v
    public final String P0() {
        gp4.h r100 = this.f207229a;
        if (r100 != null) goto L5;
        return null;
    L5:
        mr4.a r101 = r100.o();
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f514980a;
    }

    public final void a4() {
        if (this.f207235g.f486413e == true) goto L5;
        return;
    L5:
        if (this.f207234f == true) goto L19;
        com.bytedance.ee.bear.bitable.card.view.cell.b.InterfaceC2994b r100 = this.f207253y;
        if ((r100 instanceof RecordCellAdapter) == false) goto L20;
        com.bytedance.ee.bear.bitable.card.view.cell.b r101 = ((RecordCellAdapter) r100).f208626g;
        if (r101 == null) goto L12;
        r101.m2();
        return;
    L12:
        if (CollectionUtils.isEmpty(f4()) == false) goto L14;
    L16:
        Z3();
        return;
    L14:
        if (u4() == true) goto L16;
        this.f207234f = true;
        ((BaseCellAdapter) this.f207253y).M2(this);
        U3();
        E4(true);
        K4(f4());
        return;
    L20:
        return;
    }

    public void c4() {
        if (this.f207234f == true) goto L5;
        return;
    L5:
        this.f207234f = false;
        BaseCellAdapter r100 = (BaseCellAdapter) this.f207253y;
        if (r100.f208626g != this) goto L12;
        r100.f208626g = null;
        if (r100.f208628i == true) goto L12;
        do4.a.InterfaceC5692a r101 = r100.f208627h;
        if (r101 == null) goto L12;
        r101.close();
        r100.f208627h = null;
    L12:
        J4(false);
        View r102 = getContentView();
        if (r102 == null) goto L17;
        r102.clearFocus();
        if (this.C == false) goto L17;
        rcb.c.d(r102);
    L17:
        E4(false);
        this.f207229a.X();
        tt5.a.h("BaseCellViewHolder", i4() + " : exitEditMode");
    }

    @Override // hp4.v
    public final boolean canCopy() {
        return this.f207229a.Q(true).getAllow();
    }

    public final String e4() {
        gp4.h r100 = this.f207229a;
        dp4.a r101 = this.f207232d;
        if (r101 == null) goto L9;
        cp4.a r102 = r101.f469588b;
        if (r102 == null) goto L9;
        cp4.b r103 = r102.f464634a;
        if (r103 == null) goto L9;
        ETableType r104 = r103.f464675s;
    L11:
        if (r100.j(r104) == false) goto L15;
        return "base_add";
    L15:
        if (this.f207229a.N() == false) goto L18;
        return "share_record";
    L18:
        return PullConfiguration.PROCESS_NAME_MAIN;
    L9:
        r104 = null;
        goto L11
    }

    public List<ECellEditMenuItem> f4() {
        return new ArrayList();
    }

    public final boolean g4() {
        return this.f207235g.f486409a;
    }

    @Override // hp4.v
    public final String getEncryptedId() {
        gp4.h r100 = this.f207229a;
        if (r100 != null) goto L5;
        return null;
    L5:
        mr4.a r101 = r100.o();
        if (r101 != null) goto L8;
    L15:
        return null;
    L8:
        if (TextUtils.isEmpty(r101.f514980a) == true) goto L15;
        String r102 = r101.f514980a;
        DocumentInfo r103 = this.f207229a.d();
        if (r103 == null) goto L15;
        BlockInfo r104 = r103.getBlockInfo(r102);
        if (r104 == null) goto L15;
        return r104.getEncryptId();
    }

    public final FieldCompositeType h4() {
        fp4.g r100 = this.f207233e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f478257d;
    }

    public final String i4() {
        fp4.g r100 = this.f207233e;
        if (r100 == null) goto L9;
        FieldCompositeType r101 = r100.f478257d;
        if (r101 == null) goto L9;
        return r101.getReportValue();
    L9:
        return EFieldUIType.NOT_SUPPORT.getReportValue();
    }

    public final int j4() {
        return n.w(this.itemView.getContext()) - (n.d(16) * 2);
    }

    public final int l4() {
        aq4.a r100 = this.f207230b;
        int r101 = 0;
        if (r100 != null) goto L5;
    L7:
        StringBuilder r102 = new StringBuilder("get title view width err, cellTitlePresenter null");
        if (this.f207230b != null) goto L10;
        boolean r103 = true;
    L11:
        r102.append(r103);
        tt5.a.d("BaseCellViewHolder", r102.toString());
    L13:
        return r101 + n.d(12);
    L10:
        r103 = false;
        goto L11
    L5:
        if (r100.getView() == null) goto L7;
        View r104 = this.f207230b.getView();
        r104.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r101 = r104.getMeasuredWidth();
        goto L13
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void m2() {
        if (this.f207234f == false) goto L6;
        c4();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public void onViewAttachedToWindow() {
        pcb.a r100 = this.f207237i;
        if (r100 == null) goto L6;
        r100.c(this);
    L6:
        if (k4() == null) goto L8;
        k4().setIPermissionCopyChecker(this);
    L8:
        View r101 = this.itemView;
        if (r101 == null) goto L15;
        Configuration r102 = r101.getResources().getConfiguration();
        if (r102 == null) goto L15;
        if (r102.orientation != 2) goto L15;
        boolean r103 = true;
    L16:
        M2(r103);
        return;
    L15:
        r103 = false;
        goto L16
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public void onViewDetachedFromWindow() {
        pcb.a r100 = this.f207237i;
        if (r100 == null) goto L6;
        r100.a(this);
    L6:
        if (k4() == null) goto L8;
        k4().setIPermissionCopyChecker(null);
    L8:
        j r101 = this.f207252x;
        if (r101 == null) goto L12;
        com.bytedance.ee.util.ui.j.e(r101);
        this.f207252x = null;
        return;
    }

    @Override // hp4.v
    public final boolean t1() {
        gp4.h r100 = this.f207229a;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.d() == null) goto L14;
        int r101 = com.bytedance.ee.bear.bitable.utils.a.f216263a;
        IDocUserPermission r102 = this.f207229a.d().getDocPermission().f234419a;
        Intrinsics.checkNotNullParameter(r102, "iDocUserPermission");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L10;
        PermissionRequest r103 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).b("COPY_BY_LEADER");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(r103, new UserPermissionEntity(r102, null)).getAllow();
    L10:
        return r102.isCopyAuthByLeader();
    L14:
        return false;
    }

    public boolean t4() {
        dp4.a r100 = this.f207232d;
        if (r100 != null) goto L5;
        return false;
    L5:
        cp4.a r101 = r100.f469588b;
        if (r101 == null) goto L12;
        cp4.b r102 = r101.f464634a;
        if (r102 == null) goto L12;
        if (r102.f464677u == false) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        EFieldUneditableReason r104 = EFieldUneditableReason.BITABLE_IS_NOT_READY;
    L16:
        if (r104 != null) goto L19;
        return false;
    L19:
        if (r104 != EFieldUneditableReason.IS_EXTEND_FIELD) goto L21;
    L22:
        return true;
    L21:
        if (r104 == EFieldUneditableReason.IS_SYNC_TABLE) goto L22;
        return false;
    L15:
        r104 = r100.f469591e;
    L12:
        r103 = false;
        goto L13
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public void u() {
        this.f207230b.u();
        this.f207254z.dispose();
    }

    public boolean u4() {
        dp4.a r100 = this.f207232d;
        if (r100 == null) goto L27;
        V r101 = r100.f469598l;
        if ((r101 instanceof List) == false) goto L8;
        boolean r102 = hu5.a.d((List) r101);
    L23:
        if (r102 == true) goto L28;
        return false;
    L28:
        return true;
    L8:
        if ((r101 instanceof db5.a) == false) goto L20;
        db5.a r103 = (db5.a) r101;
        if (TextUtils.isEmpty(r103.f467804a) == false) goto L22;
        bo4.a[] r104 = r103.f467805b;
        if (r104 != null) goto L14;
    L15:
        db5.j[] r105 = r103.f467806c;
        if (r105 != null) goto L18;
    L21:
        r102 = true;
        goto L23
    L18:
        if (r105.length != 0) goto L22;
    L14:
        if (r104.length == 0) goto L15;
    L22:
        r102 = false;
        goto L23
    L20:
        if (r101 != null) goto L22;
    L27:
        return true;
    }

    public final void w4() {
        this.f207235g.getClass();
    }

    public final boolean y4() {
        return this.f207235g.f486413e;
    }

    public final void U3() {
        F4();
        if (getContentView() == null) goto L6;
        getContentView().setHovered(false);
        return;
    }

    public void b4() {
        if (A4() == false) goto L5;
    L7:
        Z3();
        return;
    L5:
        if (this.f207237i.getVisibleKeyboardHeight() == 0) goto L7;
        rcb.c.d(getContentView());
        this.f207251w = new m(this);
    }

    @Override // hp4.v
    public boolean canEdit() {
        return y4();
    }

    public void r4() {
        View r100 = getContentView();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setOnFocusChangeListener(new p(this));
        r100.setOnClickListener(new f(this));
        View r101 = this.itemView;
        if ((r101 instanceof PageCellContainerLayout) == false) goto L9;
        r101.setOnClickListener(new g(this));
        return;
    }

    public void s4() {
        View r100 = getContentView();
        if (r100 != null) goto L5;
        return;
    L5:
        this.itemView.setOnClickListener(new d(this));
        r100.setOnClickListener(new e(this));
    }

    public View m4() {
        return this.f207246r;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final boolean v2() {
        return this.f207234f;
    }

    public void E4(boolean r100) {
        if (this.f207239k == false) goto L6;
        this.itemView.setSelected(r100);
        return;
    }

    public final void J4(boolean r100) {
        View r101 = this.f207240l;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void K2(boolean r100) {
        this.f207238j = r100;
    }

    public final void K4(List<ECellEditMenuItem> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<ECellEditMenuItem> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(new com.bytedance.ee.bear.bitable.card.view.cell.a(r102.next(), this));
        goto L4
    L6:
        com.larksuite.component.universe_design.menu.c r103 = this.f207250v;
        if (r103 == null) goto L9;
        r103.a();
    L9:
        com.larksuite.component.universe_design.menu.c.f r104 = new com.larksuite.component.universe_design.menu.c.f();
        r104.c(80);
        r104.b(PositionAlign.END);
        r104.f(r101);
        r104.d(new i(this));
        h r105 = new h(this);
        Intrinsics.checkNotNullParameter(r105, "listener");
        r104.f285091e = r105;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.menu.UDMenu.UDMenuBuilder");
        com.larksuite.component.universe_design.menu.c r106 = r104.a();
        this.f207250v = r106;
        r106.b(this.itemView);
    }

    public final void L4(EFieldUneditableReason r100) {
        if (r100 != null) goto L5;
        tt5.a.h("BaseCellViewHolder", "showUneditableReason uneditableReason null");
        return;
    L5:
        String r101 = r100.name().toLowerCase();
        switch(b.f207257a[r100.ordinal()]) {
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L33;
            case 7: goto L32;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L41;
        };
    L8:
        this.f207229a.Z();
        goto L41
    L9:
        fp4.g r102 = this.f207233e;
        String r103 = null;
        if (r102 != null) goto L12;
        cp4.b r104 = null;
    L13:
        dp4.a r105 = this.f207232d;
        if (r105 != null) goto L16;
        cp4.a r106 = null;
    L17:
        if (r104 != null) goto L19;
        String r107 = null;
    L20:
        if (r104 != null) goto L22;
        String r108 = null;
    L23:
        if (r102 != null) goto L25;
        String r109 = null;
    L26:
        if (r106 == null) goto L29;
        r103 = r106.f464635b;
    L29:
        Disposable r110 = this.f207229a.P(r107, r108, r109, r103);
        if (r110 == null) goto L41;
        this.f207254z.add(r110);
        goto L41
    L25:
        r109 = r102.f478255b;
        goto L26
    L22:
        r108 = r104.f464660d;
        goto L23
    L19:
        r107 = r104.f464658b;
        goto L20
    L16:
        r106 = r105.f469588b;
        goto L17
    L12:
        r104 = r102.f478254a;
        goto L13
    L32:
        this.f207229a.a0();
        goto L41
    L33:
        this.f207229a.V();
        r101 = EFieldUneditableReason.BITABLE_IS_NOT_READY.toString();
        goto L41
    L34:
        this.f207229a.S();
        goto L41
    L35:
        this.f207229a.J();
        goto L41
    L36:
        this.f207229a.z();
    L41:
        BitableAnalytic r111 = this.f207229a.q0();
        r111.getClass();
        HashMap r112 = new HashMap();
        r112.put("reason", r101);
        r111.t("ccm_bitable_card_edit_deny_view", r112);
        return;
    L38:
        if (v4() == false) goto L40;
        this.f207229a.D();
        goto L41
    L40:
        this.f207229a.n();
        goto L41
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public void M2(boolean r100) {
        boolean r101 = ku5.c.k(this.itemView.getContext());
        if (r101 == true) goto L8;
        hp4.h r102 = this.f207236h;
        if (r102.f486412d != r100) goto L7;
        return;
    L7:
        boolean r103 = this.f207233e instanceof com.bytedance.ee.bear.bitable.card.model.stmodel.field.b;
        r102.f486412d = r100;
        r102.a(r103);
        H4();
    L8:
        tt5.a.h("BaseCellViewHolder", "BaseCellViewHolder onConfigurationChanged," + r100 + " isPad: " + r101);
    }

    public void M4(EFieldUneditableReason r100) {
        L4(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public boolean O2(MotionEvent r100) {
        if (this.C == true) goto L5;
    L13:
        return false;
    L5:
        if (this.f207234f == false) goto L13;
        if (r100 == null) goto L13;
        if (A4() == false) goto L13;
        Rect r101 = new Rect();
        this.itemView.getGlobalVisibleRect(r101);
        if (r101.contains((int) r100.getRawX(), (int) r100.getRawY()) == true) goto L13;
        rcb.c.d(getContentView());
        J4(false);
        c4();
        return true;
    }

    @Override // hp4.v
    public final boolean S1(int r110) {
        BitableAnalytic r100 = this.f207229a.q0();
        boolean r101 = this.f207235g.f486413e;
        r100.getClass();
        HashMap r102 = new HashMap();
        String r103 = "";
        if (r110 != 16908321) goto L6;
        String r104 = "copy";
    L9:
        r102.put("click", r104);
        if (r101 == false) goto L12;
        r100.t(BitableAnalytic.MenuEvent.BITABLE_MOBILE_EDIT_MENU_CLICK, r102);
    L13:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r105 = jg5.e.a.f499003a.g();
        boolean r106 = false;
        if (r105 == false) goto L24;
        PermissionResponse r107 = this.f207229a.Q(false);
        ph5.e r108 = r107.getCallback();
        gp4.h r109 = this.f207229a;
        if (r109 != null) goto L18;
    L20:
        Context r111 = eu5.b.f474075a;
    L21:
        r108.a(r111, r107);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r107) == true) goto L60;
    L38:
        boolean r112 = true;
        if (this.f207229a.q() == false) goto L41;
        r106 = true;
        goto L60
    L41:
        if (this.f207229a.N() == true) goto L43;
    L45:
        if (r105 == false) goto L55;
        PermissionResponse r113 = this.f207229a.Q(true);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.f(r113) == false) goto L55;
        ph5.e r114 = r113.getCallback();
        gp4.h r115 = this.f207229a;
        if (r115 != null) goto L51;
    L53:
        Context r116 = eu5.b.f474075a;
    L54:
        r114.a(r116, r113);
    L56:
        if (r112 == true) goto L60;
        Toast.showFailureText(this.f207229a.getActivity(), R.string.Bitable_Copy_FeatureDisabledByOwner);
        goto L60
    L51:
        if (r115.getActivity() == null) goto L53;
        r116 = this.f207229a.getActivity();
    L55:
        r112 = false;
        goto L56
    L43:
        if (this.A == true) goto L45;
        Toast.showFailureText(this.f207229a.getActivity(), R.string.Bitable_ShareSingleRecord_CannotCopyRecord_Desc);
    L60:
        int r117 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.audit.enable") == false) goto L83;
        DocViewModel r118 = this.f207229a.H0();
        DocumentInfo r119 = this.f207229a.d();
        BearUrl r120 = r118.getBearUrl();
        BearUrl r121 = r118.getOriginBearUrl();
        boolean r122 = r118.isType(sbb.e.f541303n);
        if (r120 == null) goto L83;
        if (r121 == null) goto L83;
        dj5.a r123 = null;
        if (r119 == null) goto L68;
        HostDocumentInfo r124 = r119.convertToHostDocumentInfo();
    L69:
        if (r122 == false) goto L75;
        WikiInfo r125 = r118.getWikiInfo();
        if (r125 == null) goto L75;
        if (r124 == null) goto L74;
        r124.setWikiToken(r125.getWikiToken());
    L74:
        r123 = new dj5.a(r125.getWikiToken(), r125.getSpaceId(), null, null, r121.f222572m);
    L75:
        dj5.a r126 = r123;
        ArrayList r127 = new ArrayList();
        r127.add(new RenderItem.Builder().Key("content_type").Value("text").build());
        com.bytedance.ee.bear.middleground_permission_export.model.c r128 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.c.class);
        sbb.e r129 = sbb.e.e(r120.f222560a);
        if (r122 == false) goto L78;
        ContainerType r130 = ContainerType.Wiki;
    L79:
        ContainerType r131 = r130;
        if (r122 == false) goto L82;
        r103 = r121.f222561b;
    L82:
        r128.f(r129, r124, r131, r103, r126, r127, Boolean.valueOf(!r106));
        goto L83
    L78:
        r130 = ContainerType.ContainerTypeUnknown;
        goto L79
    L68:
        r124 = null;
    L83:
        return r106;
    L18:
        if (r109.getActivity() == null) goto L20;
        r111 = this.f207229a.getActivity();
        goto L21
    L24:
        gj5.c r132 = this.f207229a.y();
        if (r132 == null) goto L36;
        if (r132.f481503a == true) goto L36;
        FileAuthResultFrom r133 = r132.f481504b;
        if (r133 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L32;
        ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_CONTENT_COPY", FileBizDomain.FileBizDomainCCM, 8, ((DocViewModel) q.a(this.f207229a.getFragment(), DocViewModel.class)).getToken());
        goto L60
    L32:
        if (r133 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L34;
        Toast.showFailureText(this.f207229a.getActivity(), R.string.CreationMobile_ECM_AdminDisableToast);
        goto L60
    L34:
        tt5.a.d("BaseCellViewHolder", "CellViewHolder not allow copy/cut from unknown source");
    L36:
        if (TextUtils.isEmpty(this.f207229a.m()) == true) goto L38;
        Toast.showFailureText(this.f207229a.getActivity(), this.f207229a.m());
        goto L60
    L12:
        r100.t(BitableAnalytic.MenuEvent.BITABLE_MOBILE_READ_MENU_CLICK, r102);
        goto L13
    L6:
        if (r110 != 16908320) goto L8;
        r104 = BitableAnalytic.MenuClickAction.CUT;
        goto L9
    L8:
        r104 = "";
        goto L9
    }

    public final void V3(Object r100) {
        com.bytedance.ee.bear.bitable.card.view.cell.b.a r101 = this.f207231c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f207235g.f486409a == false) goto L9;
        r101.b(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void Z(com.bytedance.ee.bear.bitable.card.view.cell.b.a r100) {
        this.f207231c = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.a.InterfaceC2991a
    public void g3(ECellEditMenuItem r100) {
        com.larksuite.component.universe_design.menu.c r101 = this.f207250v;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        BitableAnalytic r102 = this.f207229a.q0();
        String r103 = i4();
        String r104 = r100.getReportValue();
        r102.getClass();
        HashMap r105 = new HashMap();
        r105.put("field_type", r103);
        r105.put("click", r104);
        r102.t("ccm_bitable_field_input_action_mobile_click", r105);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public void l2(dp4.a<V> r110) {
        if (r110 == null) goto L86;
        this.f207232d = r110;
        fp4.g r100 = r110.f469587a;
        this.f207233e = r100;
        this.f207230b.v(r100);
        boolean r101 = r110.b();
        cp4.a r102 = r110.f469588b;
        boolean r103 = true;
        if (r102 == null) goto L10;
        cp4.b r104 = r102.f464634a;
        if (r104 == null) goto L10;
        if (r104.f464677u == false) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L13;
        EFieldUneditableReason r106 = EFieldUneditableReason.BITABLE_IS_NOT_READY;
    L14:
        String r107 = r110.f469594h;
        hp4.h r108 = this.f207236h;
        boolean r109 = this.f207233e instanceof com.bytedance.ee.bear.bitable.card.model.stmodel.field.b;
        r108.f486409a = r101;
        r108.f486410b = r106;
        r108.f486411c = r107;
        r108.a(r109);
        H4();
        this.f207229a.q0().d(r110.f469600n);
        cp4.a r111 = null;
        if (getContentView() == null) goto L47;
        w4();
        int r112 = r110.f469589c;
        if (r112 == 0) goto L19;
        boolean r113 = true;
    L20:
        if (r113 == true) goto L22;
        U3();
    L46:
        getContentView().post(new k(this));
        goto L47
    L22:
        if (this.f207239k == false) goto L24;
        final View r114 = this.itemView;
    L26:
        if (r112 == 1) goto L30;
        if (r112 != 2) goto L46;
        r114.setHovered(true);
        r114.setActivated(false);
        Context r115 = r114.getContext();
        fp4.g r116 = r110.f469587a;
        T3(r115, r116.f478263j, r116.f478264k);
        goto L46
    L30:
        j r117 = this.f207252x;
        if (r117 == null) goto L33;
        com.bytedance.ee.util.ui.j.e(r117);
        this.f207252x = null;
    L33:
        F4();
        r114.setHovered(false);
        r114.setActivated(true);
        boolean r118 = this.f207239k;
        if (r118 == false) goto L36;
        long r119 = 4000;
    L37:
        if (r118 == false) goto L39;
        View r120 = this.itemView;
    L40:
        j r121 = new j(r120);
        this.f207252x = r121;
        com.bytedance.ee.util.ui.j.d(r121, r119);
        r110.f469589c = 0;
        if (this.f207239k == false) goto L46;
        if (r114.getBackground() == null) goto L46;
        ObjectAnimator.ofInt(r114.getBackground(), "alpha", new int[]{0, 255}).setDuration(1000).start();
        r114.postDelayed(new hp4.n(r114), 3000);
        goto L46
    L39:
        r120 = getContentView();
        goto L40
    L36:
        r119 = 3000;
        goto L37
    L24:
        r114 = getContentView();
        goto L26
    L19:
        r113 = false;
    L47:
        O4();
        if (this.f207239k == true) goto L50;
        return;
    L50:
        if (this.f207229a.N() == false) goto L88;
        int r122 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.mobile.record_share_field_group_enable") == false) goto L91;
        dp4.a r123 = this.f207232d;
        if (r123 == null) goto L57;
        r111 = r123.f469588b;
        String r124 = r123.f469596j;
    L58:
        fp4.g r125 = this.f207233e;
        if (r125 != null) goto L61;
    L63:
        boolean r126 = false;
    L64:
        if (r111 != null) goto L66;
    L73:
        boolean r127 = false;
        r103 = false;
    L74:
        if (r126 == false) goto L76;
        r103 = false;
    L76:
        int r128 = n.c(16.0f);
        int r129 = n.d(22);
        if (r103 == false) goto L79;
        r128 = r128 + r129;
    L79:
        this.itemView.setPadding(r128, this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), this.itemView.getPaddingBottom());
        View r130 = this.f207249u;
        if (r130 == null) goto L89;
        if (r103 == false) goto L84;
        if (r127 == false) goto L84;
        r130.setVisibility(4);
        return;
    L84:
        r130.setVisibility(0);
        return;
    L89:
        return;
    L66:
        if (TextUtils.isEmpty(r124) == true) goto L73;
        if (r111.c(r124) == false) goto L73;
        dp4.a r131 = this.f207232d;
        if (r131 == null) goto L72;
        r127 = r131.f469597k;
        goto L74
    L72:
        r127 = false;
        goto L74
    L61:
        if (r125.f478260g == false) goto L63;
        r126 = true;
        goto L64
    L57:
        r124 = null;
        goto L58
    L91:
        return;
    L88:
        return;
    L13:
        r106 = r110.f469591e;
    L10:
        r105 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void q1(com.bytedance.ee.bear.bitable.card.view.cell.b.InterfaceC2994b r100) {
        this.f207253y = r100;
    }

    public final void q4(EFieldUneditableReason r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f207229a != null) goto L7;
        return;
    L7:
        if (this.C == false) goto L12;
        this.itemView.setOnClickListener(new hp4.q(this, r100));
        View r101 = getContentView();
        if (r101 == null) goto L14;
        r101.setOnClickListener(new r(this, r100));
        return;
    L14:
        return;
    L12:
        n4(this.itemView.findViewById(R.id.cell_content_container), r100);
        n4(getContentView(), r100);
    }

    public void I4(Object r100, String r101) {
        tt5.a.h("BaseCellViewHolder", "saveSubmitValue editType: " + r101);
        if (this.f207232d == null) goto L6;
        tt5.a.b("BaseCellViewHolder", "saveSubmitValue value=" + r100 + " editType=" + r101);
        this.f207232d.f469599m = r100;
        return;
    }

    public void N4(V r100, String r101) {
        dp4.a<V> r102 = this.f207232d;
        if (r102 == null) goto L6;
        r102.f469598l = r100;
        l2(r102);
        return;
    }

    public final void P4(int r100, int r101) {
        View r102 = this.itemView;
        r102.setPadding(r102.getPaddingLeft(), r100, this.itemView.getPaddingRight(), this.itemView.getPaddingBottom());
        View r103 = this.f207249u;
        if (r103 != null) goto L5;
        return;
    L5:
        if ((r103.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f207249u.getLayoutParams())).topMargin = r101;
        return;
    }

    public final void W3(Object r100, V r101) {
        X3(r100, "cover", r101);
    }

    public final void n4(View r100, final EFieldUneditableReason r101) {
        if (r101 == null) goto L11;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f207229a == null) goto L14;
        r100.setOnFocusChangeListener(null);
        r100.setOnClickListener(new hp4.j(this, r101));
        View r102 = this.itemView;
        if ((r102 instanceof PageCellContainerLayout) == false) goto L13;
        r102.setOnClickListener(new a(this, r101));
        return;
    L13:
        return;
    L14:
        return;
    }

    public void T3(Context r100, String r101, HashMap<Integer, ArrayList<String>> r102) {
        View r103 = this.itemView;
        if ((r103 instanceof LinearLayout) == false) goto L10;
        LinearLayout r104 = (LinearLayout) r103;
        if (((TextView) r104.findViewById(R.id.cell_error_msg)) == null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        TextView r105 = (TextView) LayoutInflater.from(r100).inflate(R.layout.bitable_cell_error_msg, null);
        r105.setText(r101);
        r105.setId(R.id.cell_error_msg);
        r104.addView(r105);
        return;
    L16:
        return;
    L10:
        if ((r103 instanceof PageCellContainerLayout) == false) goto L18;
        View r106 = r103.findViewById(R.id.divider);
        TextView r107 = (TextView) this.itemView.findViewById(R.id.warning_text);
        if (TextUtils.isEmpty(r101) == true) goto L19;
        r106.setBackgroundColor(n.h(this.itemView.getContext(), R.color.function_danger_500));
        r107.setText(r101);
        r107.setVisibility(0);
        return;
    L19:
        return;
    }

    public final void X3(Object r100, String r101, V r102) {
        if (this.f207231c != null) goto L5;
        return;
    L5:
        if (g4() == false) goto L30;
        this.f207231c.a(r100, r101);
        if (this.D == false) goto L27;
        I4(r100, r101);
        N4(r102, r101);
        fp4.g r103 = this.f207233e;
        cp4.a r104 = null;
        if (r103 != null) goto L11;
        cp4.b r105 = null;
    L13:
        if (r105 != null) goto L16;
        tt5.a.h("BaseCellViewHolder", "updateTitle break table isNull");
        goto L27
    L16:
        if (TextUtils.equals(r105.f464666j, r103.f478255b) == false) goto L27;
        dp4.a r106 = this.f207232d;
        if (r106 == null) goto L22;
        r104 = r106.f469588b;
    L22:
        if (r104 != null) goto L24;
        tt5.a.h("BaseCellViewHolder", "updateTitle break record isNull");
        goto L27
    L24:
        String r107 = d4(r100, r102);
        tt5.a.h("BaseCellViewHolder", "updateTitle title=" + r107);
        r104.f464637d = r107;
        gp4.h.a r108 = this.f207229a.W();
        if (r108 == null) goto L27;
        r108.a(r107);
        goto L27
    L11:
        r105 = r103.f478254a;
    L27:
        this.f207229a.q0().d(this.f207232d.f469601o);
        return;
    }

    public void Y3(BitableAtEditText r100, CharSequence r101, boolean r102) {
        if (this.B == false) goto L6;
        return;
    L6:
        if (this.f207239k == true) goto L19;
        return;
    L19:
    L15:
        e = move-exception;
        tt5.a.d("BaseCellViewHolder", "correctCellTextViewHint error: " + e.getMessage());
        return;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        if (r102 == false) goto L13;
        r100.setHint(R.string.Bitable_Common_PleaseEnterMobileVer);     // Catch: Exception -> L15
    L18:
        return;
    L13:
        r100.setHint("");     // Catch: Exception -> L15
        goto L18
    }

    @Override // ocb.a
    public void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        if (r101 != 0) goto L5;
        J4(false);
    L5:
        if (getContentView() != null) goto L7;
        return;
    L7:
        if (getContentView().hasFocus() == true) goto L9;
        return;
    L9:
        if (A4() == true) goto L19;
        if (r101 == 0) goto L12;
        return;
    L12:
        if (this.f207234f == true) goto L21;
        m r103 = this.f207251w;
        if (r103 == null) goto L22;
        r103.run();
        this.f207251w = null;
        return;
    L22:
        return;
    L21:
        return;
    }

    public BaseCellViewHolder(View r100, aq4.a r101, gp4.h r102, boolean r103) {
        super(r100);
        hp4.h r104 = new hp4.h();
        this.f207236h = r104;
        boolean r105 = false;
        this.f207239k = false;
        this.f207254z = new CompositeDisposable();
        int r106 = com.bytedance.ee.bear.bitable.c.f207079a;
        this.A = com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.zys.record_copy_support");
        this.B = com.bytedance.ee.bear.bitable.core.usercomponent.b.d("bitable.record.text_hint_correct.disable");
        this.D = false;
        this.f207230b = r101;
        this.f207229a = r102;
        this.f207239k = r103;
        Context r107 = r100.getContext();
        if ((r107 instanceof Activity) == false) goto L5;
        this.f207237i = pcb.a.AbstractC7181a.b((Activity) r107);
    L5:
        this.f207235g = r104;
        if (r103 == false) goto L8;
        this.f207249u = r100.findViewById(R.id.divider);
        this.f207244p = r100.findViewById(R.id.cell_content_container);
        this.f207246r = r100.findViewById(R.id.cell_content_empty_uneditable);
        this.f207247s = r100.findViewById(R.id.fast_add_autofill_tips_view);
        AppCompatImageView r108 = (AppCompatImageView) r100.findViewById(R.id.empty_add_view);
        this.f207248t = r108;
        this.f207245q = r100.findViewById(R.id.cell_content_right_icon_parent);
        r108.setOnClickListener(new o(this));
    L8:
        if (r102 != null) goto L10;
    L12:
        this.D = r105;
        this.C = r103;
        if (r103 == false) goto L16;
        this.f207245q.setVisibility(8);
    L16:
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.itemview.fix.record.memory.leak") == false) goto L19;
        r100.addOnAttachStateChangeListener(new c(this));
        return;
    L19:
        return;
    L10:
        if (r102.w() == false) goto L12;
        r105 = true;
        goto L12
    }
}
