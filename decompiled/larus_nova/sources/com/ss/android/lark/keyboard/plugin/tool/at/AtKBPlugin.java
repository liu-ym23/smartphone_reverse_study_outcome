package com.ss.android.lark.keyboard.plugin.tool.at;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.edittext2.utils.e;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.i;
import com.ss.android.lark.keyboard.keyboard2.m;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.statistics.PostInputPluginHitPoint;
import com.ss.android.lark.keyboard.statistics.TextInputPluginHitPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import cya.h;
import hob.d;
import hob.j;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class AtKBPlugin extends m implements com.ss.android.lark.keyboard.base.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f429604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f429605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.plugin.tool.at.a f429606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f429607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f429608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f429609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f429610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f429611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Chat f429612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f429613l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f429614m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f429615n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final KeyboardMenuItemKey f429616o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f429617p;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f429618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtKBPlugin f429619b;

        public b(EditText r100, AtKBPlugin r101) {
            this.f429618a = r100;
            this.f429619b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f429618a.requestFocus();     // Catch: Throwable -> L4
            this.f429619b.n().z().z();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements lob.a, mob.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f429620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtKBPlugin f429621b;

        @Override // lob.a, android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // lob.a, android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // lob.a
        public final void r(Editable r100, int r101, int r102) {
        }

        @Override // lob.a
        public final boolean z(int r100, KeyEvent r101) {
            return false;
        }

        public c(AtKBPlugin r100) {
            this.f429621b = r100;
        }

        @Override // mob.b
        public final void a(boolean r100) {
            this.f429620a = r100;
        }

        @Override // lob.a
        public final void j(EditText r100) {
            Intrinsics.checkNotNullParameter(r100, "editText");
        }

        @Override // lob.a, android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r110, int r111) {
            AtKBPlugin r112 = this.f429621b;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L37
            boolean r103 = true;
            if (r112.f429617p == true) goto L6;
        L35:
            r112.J(false, true);     // Catch: Throwable -> L37
            return;
        L6:
            if (this.f429620a == true) goto L35;
            EditText r104 = r112.H().c();     // Catch: Throwable -> L37
            if (r104.isAttachedToWindow() == true) goto L13;
            r112.J(false, true);     // Catch: Throwable -> L37
            return;
        L13:
            if (r112.f429607f == false) goto L15;
            AtKBPlugin.C(r112, r104, r111);     // Catch: Throwable -> L37
        L30:
            if (r112.f429607f == true) goto L32;
        L34:
            Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
        L39:
            Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
            if (r106 == null) goto L44;
            Log.e("AtKBPlugin", "AtKBPlugin's onTextChanged throw Exception", r106);
            return;
        L44:
            return;
        L32:
            if (r112.f429613l.get() == false) goto L34;
            AtKBPlugin.A(r112, r100, r101, r111);     // Catch: Throwable -> L37
            goto L34
        L15:
            if (r111 != 0) goto L17;
            r112.J(false, true);     // Catch: Throwable -> L37
        L17:
            if (r111 != 1) goto L30;
            if (r100 != null) goto L20;
        L22:
            r103 = false;
        L23:
            if (r103 == false) goto L30;
            if (r112.f429606e.a(r112.f429604c, false) != 0) goto L30;
            long r107 = System.currentTimeMillis();     // Catch: Throwable -> L37
            if ((r107 - r112.f429611j) <= 1000) goto L30;
            r112.f429611j = r107;     // Catch: Throwable -> L37
            r112.L();     // Catch: Throwable -> L37
            goto L30
        L20:
            if (r100.charAt(r101) != '@') goto L22;
        L37:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L39
        }
    }

    static {
    }

    public final void L() {
        boolean r100 = true;
        if (J(true, true) == false) goto L7;
        Log.i("AtKBPlugin", "startAtSelector returns for showMentionView.");
        return;
    L7:
        if (this.f429615n == false) goto L9;
        n().z().g();
    L9:
        Chat r101 = this.f429612k;
        if (r101 == null) goto L12;
        boolean r102 = r101.isUserCountVisible();
    L13:
        Log.i("AtKBPlugin", "startAtSelector enable showUserCount: " + r102);
        Bundle r103 = new Bundle();
        Chat r104 = this.f429612k;
        if (r104 != null) goto L16;
    L18:
        r100 = false;
    L19:
        if (r100 == false) goto L21;
        String r105 = "single";
    L22:
        r103.putString("chat_type", r105);
        this.f429606e.e(r102, n(), r103);
        return;
    L21:
        r105 = "group";
        goto L22
    L16:
        if (r104.isP2PChat() != true) goto L18;
    L12:
        r102 = true;
        goto L13
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return R.drawable.ud_icon_at_outlined;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void s() {
        boolean r100 = true;
        int r101 = this.f429606e.a(this.f429604c, true);
        if (this.f429607f == true) goto L5;
        if (r101 != 0) goto L9;
        L();
    L12:
        if (H().getInputType() == InputSupportType.Post) goto L16;
        r100 = false;
    L16:
        if (r100 == false) goto L18;
        new PostInputPluginHitPoint("mention").c();
        return;
    L18:
        new TextInputPluginHitPoint("mention").c();
        return;
    L9:
        if (r101 != 1) goto L12;
        G();
        goto L12
    L5:
        if (this.f429613l.get() == true) goto L12;
        this.f429614m.getAndSet(true);
        G();
        goto L12
    }

    public final void G() {
        EditText r100 = H().c();
        int r101 = r100.getSelectionStart();
        Editable r102 = r100.getEditableText();
        if (r101 >= 0) goto L5;
    L8:
        r102.append("@");
        return;
    L5:
        if (r101 >= r102.length()) goto L8;
        r102.insert(r101, "@");
    }

    public final mob.a H() {
        com.ss.android.lark.keyboard.keyboard2.b r100 = n().L();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.input.base.ISendKeyboardEditor");
        return (mob.a) r100;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final Integer q() {
        return Integer.valueOf(R.string.test_kb_plugin_at);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void u() {
        H().s(new c(this));
        n().e().of(this).d(h.class, new AtKBPlugin$onCreate$2$1(this));
        n().z().v(this).c(new AtKBPlugin$onCreate$3(this));
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return this.f429616o;
    }

    public static /* synthetic */ boolean K(AtKBPlugin r100) {
        return r100.J(false, true);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void w(boolean r100) {
        View r101 = this.f429608g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
        r101 = null;
    L5:
        r101.setEnabled(r100);
        this.f429610i = r100;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(i r100) {
        Intrinsics.checkNotNullParameter(r100, "iconHolder");
        r100.f429551a.setActivated(this.f429605d);
        this.f429608g = r100.f429551a;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void y(boolean r100) {
        this.f429617p = r100;
    }

    public final boolean J(boolean r100, boolean r101) {
        if (this.f429607f == false) goto L11;
        if (r100 == true) goto L7;
        this.f429614m.set(false);
    L7:
        if (this.f429613l.get() == r100) goto L12;
        boolean r102 = this.f429606e.d(r100, r101);
        this.f429613l.getAndSet(r102);
        return true;
    L12:
        return true;
    L11:
        return false;
    }

    @Override // com.ss.android.lark.keyboard.base.b
    public final void e(int r110, Intent r111) {
        Intrinsics.checkNotNullParameter(r111, "data");
        if (r110 == 1638) goto L5;
        return;
    L5:
        boolean r112 = false;
        J(false, true);
        EditText r100 = n().L().c();
        Lazy r101 = KeyboardAtModule.f429622a;
        if (((KeyboardAtModule.a) r101.getValue()).isFeatureGatingEnable("messenger.message.corporate_aite_clouddocuments") == true) goto L8;
    L50:
        com.ss.android.lark.keyboard.plugin.tool.at.a.C5105a r113 = this.f429606e.g(r111);
        if (r113.f429624a.isEmpty() == true) goto L53;
    L57:
        if (r112 == false) goto L60;
        return;
    L60:
        if (((KeyboardAtModule.a) r101.getValue()).isFeatureGatingEnable("messenger.setting.mention_user_group") == false) goto L73;
        if ((!r113.f429625b.isEmpty()) == false) goto L73;
        Iterator<T> r114 = r113.f429625b.iterator();
    L65:
        if (r114.hasNext() == false) goto L73;
        UserGroupEntity r102 = (UserGroupEntity) r114.next();
        long r103 = r102.f253667id.longValue();
        String r104 = r102.display_name;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r104, CommonConstant.KEY_DISPLAY_NAME);
        if ((r100 instanceof FunctionEditText) == false) goto L69;
        FunctionEditText r105 = (FunctionEditText) r100;
    L70:
        if (r105 == null) goto L65;
        ((com.ss.android.lark.keyboard.edittext2.edittors.b) r105.q(com.ss.android.lark.keyboard.edittext2.edittors.b.f429044d)).insert(new d(r103, r104, 1));
        goto L65
    L69:
        r105 = null;
    L73:
        if ((!r113.f429624a.isEmpty()) == false) goto L79;
        Iterator<T> r115 = r113.f429624a.iterator();
    L76:
        if (r115.hasNext() == false) goto L79;
        com.ss.android.lark.keyboard.plugin.tool.at.a.b r106 = (com.ss.android.lark.keyboard.plugin.tool.at.a.b) r115.next();
        this.f429606e.b(r100, r106);
        ExtensionEditTextCompatKt.i(r100, r106.f429627a, r106.f429629c, r106.f429630d, r106.f429631e, r106.f429632f);
    L79:
        if ((!r113.f429626c.isEmpty()) == false) goto L87;
        Iterator<T> r116 = r113.f429626c.iterator();
    L82:
        if (r116.hasNext() == false) goto L87;
        com.ss.android.lark.keyboard.plugin.tool.at.a.c r117 = (com.ss.android.lark.keyboard.plugin.tool.at.a.c) r116.next();
        int r107 = e.c(r100);
        if (r107 < 0) goto L86;
        r100.getEditableText().delete(r107, r107 + 1);
    L86:
        r117.getClass();
        ExtensionEditTextCompatKt.h(r100, null, null, null, true, "");
    L87:
        r100.post(new b(r100, this));
        return;
    L53:
        if (r113.f429625b.isEmpty() == false) goto L57;
        if (r113.f429626c.isEmpty() == false) goto L57;
        r112 = true;
        goto L57
    L8:
        if (r111.getBooleanExtra("IS_NEW_MENTION", false) == false) goto L50;
        Object r118 = r111.getSerializableExtra("MENTION_DATA");
        if (r118 != null) goto L12;
        r118 = CollectionsKt.emptyList();
    L12:
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type kotlin.collections.List<com.ss.android.lark.search.dto.info.SearchBaseInfo>");
        List r119 = (List) r118;
        if (r119.isEmpty() == false) goto L15;
        return;
    L15:
        Iterator r120 = r119.iterator();
    L17:
        if (r120.hasNext() == false) goto L87;
        SearchBaseInfo r121 = (SearchBaseInfo) r120.next();
        if ((r121 instanceof SearchChatterInfo) == true) goto L20;
        boolean r108 = r121 instanceof SearchSpaceInfo;
        if (r108 == true) goto L25;
        if ((r121 instanceof SearchWikiInfo) == false) goto L17;
    L25:
        if (r108 == false) goto L28;
        String r109 = ((SearchSpaceInfo) r121).getDocUrl();
    L31:
        if (r109 == null) goto L17;
        String r122 = r121.getTitle();
        if (r122 == null) goto L17;
        if ((r100 instanceof KeyboardFunctionEditText) == false) goto L39;
        KeyboardFunctionEditText r123 = (KeyboardFunctionEditText) r100;
    L40:
        if (r123 == null) goto L17;
        int r124 = e.c(r100);
        if (r124 < 0) goto L45;
        ((KeyboardFunctionEditText) r100).getEditableText().delete(r124, r124 + 1);
    L45:
        eob.a r125 = (eob.a) r123.q(eob.a.f473406f);
        j r126 = new j(r109);
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        r126.f486340e = r122;
        j.a r127 = r126.f486341f;
        if ((r121 instanceof SearchWikiInfo) == false) goto L48;
        int r128 = R.drawable.ud_icon_wiki_outlined;
    L49:
        r127.f486343a = r128;
        Intrinsics.checkNotNullParameter(r127, "<set-?>");
        r126.f486341f = r127;
        r125.insert(r126);
        goto L17
    L48:
        r128 = R.drawable.ud_icon_doc_outlined;
        goto L49
    L39:
        r123 = null;
        goto L40
    L28:
        if ((r121 instanceof SearchWikiInfo) == false) goto L30;
        r109 = ((SearchWikiInfo) r121).getUrl();
        goto L31
    L30:
        r109 = null;
        goto L31
    L20:
        SearchChatterInfo r129 = (SearchChatterInfo) r121;
        ExtensionEditTextCompatKt.i(r100, r129.getId(), r129.getTitle(), r129.getTitle(), !r129.isInChat(), false);
        goto L17
    }

    public static final void C(AtKBPlugin r100, EditText r110, int r111) {
        if (r100.f429607f == true) goto L6;
        return;
    L6:
        if (r111 > 2) goto L92;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L71
        Editable r113 = r110.getEditableText();     // Catch: Throwable -> L71
        if (r113 == null) goto L84;
        int r101 = r110.getSelectionStart();     // Catch: Throwable -> L71
        boolean r102 = false;
        if (r101 >= 0) goto L14;
    L69:
        r100.J(false, true);     // Catch: Throwable -> L71
        return;
    L14:
        if (r101 > r113.length()) goto L69;
        if (StringsKt.indexOf$default(r113, '@', 0, false, 6, null) >= 0) goto L19;
        r100.J(false, true);     // Catch: Throwable -> L71
        return;
    L19:
        int r103 = r101 - 1;     // Catch: Throwable -> L71
        if (r103 < 0) goto L22;
    L24:
        com.ss.android.lark.keyboard.edittext2.span.a[] r104 = (com.ss.android.lark.keyboard.edittext2.span.a[]) r113.getSpans(0, r103, com.ss.android.lark.keyboard.edittext2.span.a.class);     // Catch: Throwable -> L71
        int r105 = r113.getSpanEnd((com.ss.android.lark.keyboard.edittext2.span.a) ArraysKt.getOrNull(r104, r104.length - 1));     // Catch: Throwable -> L71
        if (r101 != r105) goto L27;
        r100.J(false, true);     // Catch: Throwable -> L71
    L27:
        if (r103 < 0) goto L68;
        if (r103 < (r101 - 10)) goto L68;
        if (r103 <= (r105 - 1)) goto L68;
        char r106 = r113.charAt(r103);     // Catch: Throwable -> L71
        if (r106 == '@') goto L35;
        if (CharsKt.isWhitespace(r106) == true) goto L65;
        r103 = r103 - 1;     // Catch: Throwable -> L71
        goto L27
    L65:
        if (r100.f429613l.get() == false) goto L88;
        r100.J(false, true);     // Catch: Throwable -> L71
        return;
    L88:
        return;
    L35:
        if (r113.charAt(r103) != '@') goto L59;
        if (r103 <= 0) goto L59;
        char r114 = r113.charAt(r103 - 1);     // Catch: Throwable -> L71
        if ('a' <= r114) goto L40;
    L42:
        boolean r107 = false;
    L43:
        if (r107 == false) goto L45;
    L53:
        boolean r115 = true;
    L54:
        if (r115 == false) goto L59;
        if (r100.f429614m.get() == true) goto L59;
        r100.J(false, true);     // Catch: Throwable -> L71
        return;
    L45:
        if ('A' <= r114) goto L47;
    L49:
        boolean r116 = false;
    L50:
        if (r116 == true) goto L53;
        r115 = false;
        goto L54
    L47:
        if (r114 >= '[') goto L49;
        r116 = true;
        goto L50
    L40:
        if (r114 >= '{') goto L42;
        r107 = true;
    L59:
        if (r103 != (r110.getSelectionStart() - 1)) goto L61;
        r102 = true;
    L61:
        r100.J(true, r102);     // Catch: Throwable -> L71
        return;
    L68:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L71
    L73:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L90;
        Log.e("AtKBPlugin", "deal updateMentionViewByCursor failed", r109);
        return;
    L90:
        return;
    L22:
        if (r100.f429613l.get() == false) goto L24;
        r100.J(false, true);     // Catch: Throwable -> L71
        goto L24
    L84:
        return;
    L71:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L73
    }

    public static final void A(AtKBPlugin r100, CharSequence r101, int r102, int r103) {
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L28
        if (r100.f429607f == true) goto L6;
        return;
    L6:
        if (r100.f429613l.get() == false) goto L40;
        if (r101 == null) goto L41;
        if (r103 < 0) goto L42;
        if (r102 < 0) goto L43;
        int r105 = RangesKt.coerceAtMost(r103 + r102, r101.length());     // Catch: Throwable -> L28
        int r106 = r105 - 1;     // Catch: Throwable -> L28
        if (r102 > r105) goto L44;
    L15:
        if (r106 <= 0) goto L22;
        char r107 = r101.charAt(r106);     // Catch: Throwable -> L28
        if (r107 == '@') goto L22;
        if (CharsKt.isWhitespace(r107) == true) goto L22;
        r106 = r106 - 1;     // Catch: Throwable -> L28
    L22:
        int r108 = r106 + 1;     // Catch: Throwable -> L28
        if (r108 <= r105) goto L25;
        CharSequence r109 = "";
    L26:
        r100.f429606e.h(r109.toString());     // Catch: Throwable -> L28
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L45;
        Log.e("AtKBPlugin", "deal dealMentionSearch failed", r111);
        return;
    L45:
        return;
    L25:
        r109 = r101.subSequence(r108, r105);     // Catch: Throwable -> L28
        goto L26
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L28:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    public AtKBPlugin(String r100, boolean r101, com.ss.android.lark.keyboard.plugin.tool.at.a r102, boolean r103, String r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r105 & 16) == 0) goto L9;
        r103 = false;
    L9:
        if ((r105 & 32) == 0) goto L11;
        r104 = "";
    L11:
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r102, "atDependency");
        Intrinsics.checkNotNullParameter(r104, "threadId");
        this.f429604c = r100;
        this.f429605d = r101;
        this.f429606e = r102;
        this.f429607f = r103;
        this.f429609h = true;
        this.f429613l = r102.f();
        this.f429614m = new AtomicBoolean(false);
        this.f429616o = KeyboardMenuItemKey.At;
        this.f429617p = true;
    }
}
