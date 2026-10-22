package com.ss.android.lark.forwardv3.plugins;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.forwardv3.plugins.at.ForwardAtStrategy;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.span.ClickLinkMovementMethod;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import z5c.r;
import z5c.z2;

/* JADX INFO: loaded from: classes36.dex */
public final class ForwardAtPlugin implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f425433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KeyboardFunctionEditText f425434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f425435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f425436d;

    public static final class a {
    }

    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForwardAtPlugin f425437a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public b(ForwardAtPlugin r100) {
            this.f425437a = r100;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            ForwardAtPlugin r104 = this.f425437a;
            qqb.a.h("");     // Catch: Throwable -> L14
            boolean r105 = true;
            if (r103 != 1) goto L12;
            if (r100 != null) goto L7;
        L9:
            r105 = false;
        L10:
            if (r105 == false) goto L12;
            r104.f425433a.a();     // Catch: Throwable -> L14
            goto L12
        L7:
            if (r100.charAt(r101) != '@') goto L9;
        L12:
            qqb.a.a();
            return;
        L14:
            th = move-exception;
            qqb.a.a();
            throw th;
        }
    }

    public static final class c implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f425438a = null;

        static {
            f425438a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (r101 == false) goto L5;
            s5c.a r102 = r.f570329j;
            s5c.h r103 = s5c.h.f540777a;
            s5c.a r104 = z2.f570435h;
            int r105 = zib.e.f572329a;
            r102.getClass();
            zib.e.a.e(s5c.d.b.b(r102, r103).plus(r104));
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void c() {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void d() {
    }

    public ForwardAtPlugin(com.ss.android.lark.forwardv3.plugins.a r100) {
        Intrinsics.checkNotNullParameter(r100, "atDependency");
        this.f425433a = r100;
        this.f425436d = "";
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void a(Intent r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        Serializable r111 = r110.getSerializableExtra("EXTRA_KEY_CHATTER_INFO");
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.collections.List<com.ss.android.lark.search.dto.info.SearchBaseInfo>");
        List r112 = (List) r111;
        ArrayList r100 = new ArrayList();
        if ((!r112.isEmpty()) == false) goto L23;
        Iterator r113 = r112.iterator();
    L8:
        if (r113.hasNext() == false) goto L23;
        SearchBaseInfo r101 = (SearchBaseInfo) r113.next();
        String r102 = r101.getTitle();
        if (com.ss.android.lark.forwardv3.utils.b.b() == true) goto L12;
    L20:
        boolean r103 = false;
    L21:
        r100.add(new g.a(r101.getId(), r102, r103));
        goto L8
    L12:
        if ((r101 instanceof SearchChatterInfo) == false) goto L14;
        SearchChatterInfo r104 = (SearchChatterInfo) r101;
    L15:
        if (r104 == null) goto L17;
        boolean r105 = r104.isInChat();
    L18:
        if (r105 == true) goto L20;
        r103 = true;
        goto L21
    L17:
        r105 = true;
        goto L18
    L14:
        r104 = null;
    L23:
        if (CollectionUtils.isEmpty(r100) == false) goto L25;
        return;
    L25:
        this.f425435c = true;
        Iterator r114 = r100.iterator();
    L27:
        if (r114.hasNext() == false) goto L40;
        g.a r106 = (g.a) r114.next();
        KeyboardFunctionEditText r107 = this.f425434b;
        if (r107 == null) goto L27;
        com.ss.android.lark.keyboard.edittext2.edittors.a r108 = (com.ss.android.lark.keyboard.edittext2.edittors.a) r107.q(com.ss.android.lark.keyboard.edittext2.edittors.a.f428974e);
        String r109 = r106.f425507a;
        String r115 = r106.f425508b;
        String r116 = r106.f425509c;
        boolean r117 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.alert_support_at", false);
        Log.i("FGUtils", "FG key: core.forward.alert_support_at: " + r117);
        if (r117 == true) goto L33;
    L38:
        boolean r118 = r106.f425510d;
    L39:
        hob.c r119 = new hob.c(r109, r115, r116, r118, r106.f425511e);
        r119.f486313f = false;
        r108.insert(r119);
        goto L27
    L33:
        if (this.f425436d.length() != 0) goto L35;
        boolean r120 = true;
    L36:
        if (r120 == false) goto L38;
        r118 = false;
        goto L39
    L35:
        r120 = false;
        goto L36
    L40:
        KeyboardFunctionEditText r121 = this.f425434b;
        if (r121 == null) goto L52;
        r121.post(new com.ss.android.lark.forwardv3.plugins.b(this));
        return;
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void e(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (TextUtils.isEmpty((CharSequence) r100) == true) goto L6;
        this.f425436d = (String) r100;
        return;
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final i b(FragmentActivity r100, Fragment r101, View r102) {
        Intrinsics.checkNotNullParameter(r102, "pluginTarget");
        if ((r102 instanceof KeyboardFunctionEditText) == false) goto L5;
        this.f425434b = (KeyboardFunctionEditText) r102;
    L6:
        KeyboardFunctionEditText r103 = this.f425434b;
        if (r103 == null) goto L9;
        r103.setHint(R.string.Lark_Forward_NoteMention);
    L9:
        KeyboardFunctionEditText r104 = this.f425434b;
        if (r104 == null) goto L12;
        r104.addTextChangedListener(new b(this));
    L12:
        KeyboardFunctionEditText r105 = this.f425434b;
        if (r105 == null) goto L16;
        r105.setOnFocusChangeListener(c.f425438a);
    L16:
        if (com.ss.android.lark.forwardv3.utils.b.b() == false) goto L20;
        KeyboardFunctionEditText r106 = this.f425434b;
        if (r106 == null) goto L20;
        r106.setMovementMethod(new ClickLinkMovementMethod(r106));
        ArrayList r107 = new ArrayList();
        r107.add(new ForwardAtStrategy(new ForwardAtPlugin$attachToTargetView$3$1(this)));
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) r106.q(com.ss.android.lark.keyboard.edittext2.edittors.a.f428974e)).W(r107);
    L20:
        return this;
    L5:
        Log.e("ForwardAtPlugin", "ForwardAtPlugin do not support this view");
        goto L6
    }
}
