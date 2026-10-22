package kb5;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.bytedance.ee.bear.basesdk.config.CcmOverWordConfig;
import com.bytedance.ee.bear.lark.dependency.h0;
import com.bytedance.ee.bear.sheet.cellcontent.view.SheetCellContentView;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.utils.TextViewMenuUtilsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements fu5.a {
    public final h0.a a;
    public CcmOverWordConfig b;

    public class a extends ActionMode.Callback2 {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ b b;

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r1, MenuItem r2) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r1, Menu r2) {
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r1) {
        }

        public a(b r1, Function0 r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r2, Menu r3) {
            if (this.b.o() == true) goto L5;
            int r4 = com.suite.lark.emm.impl.a.a;
            com.suite.lark.emm.impl.a.a.a().getClass();
            SCClipboardProvider.a().N0(r3);
            return true;
        L5:
            b.x(this.b, r3, this.a);
            return true;
        }
    }

    /* JADX INFO: renamed from: kb5.b$b, reason: collision with other inner class name */
    public class ActionModeCallbackC0245b implements ActionMode.Callback {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ b b;

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r1, MenuItem r2) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r1, Menu r2) {
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r1) {
        }

        public ActionModeCallbackC0245b(b r1, Function0 r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r2, Menu r3) {
            if (this.b.o() == true) goto L5;
            int r4 = com.suite.lark.emm.impl.a.a;
            com.suite.lark.emm.impl.a.a.a().getClass();
            SCClipboardProvider.a().N0(r3);
            return true;
        L5:
            b.x(this.b, r3, this.a);
            return true;
        }
    }

    public final boolean b() {
        return this.a.b().booleanValue();
    }

    public final void c() {
        this.a.c();
    }

    public final Boolean f() {
        return this.a.f();
    }

    public final void i() {
        this.a.i();
    }

    public final boolean s() {
        int r0 = com.suite.lark.emm.impl.a.a;
        com.suite.lark.emm.impl.a.a.a().getClass();
        return !SCClipboardProvider.a().L0();
    }

    public b() {
        this.a = ((h0) org.koin.java.a.a(h0.class)).a();
    }

    public final boolean o() {
        return FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.menu_display_strategy_opt");
    }

    public final void a(String r2) {
        this.a.a(r2);
    }

    public final void d(ClipboardManager.OnPrimaryClipChangedListener r2) {
        this.a.d(r2);
    }

    public final void e(ClipboardManager.OnPrimaryClipChangedListener r2) {
        this.a.e(r2);
    }

    public final void j(String r2) {
        this.a.j(r2);
    }

    public final ClipData l(Token r2) {
        return this.a.l(r2);
    }

    public final ActionMode.Callback r(ActionMode.Callback r3) {
        int r0 = com.suite.lark.emm.impl.a.a;
        com.suite.lark.emm.impl.a.a.a().getClass();
        return SCClipboardProvider.a().P0(r3, Boolean.FALSE);
    }

    public final ActionMode.Callback t(Function0<Boolean> r3) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return new a(this, r3);
    L7:
        return new ActionModeCallbackC0245b(this, r3);
    }

    public final boolean w(String r12) {
        boolean r1 = true;
        if (TextUtils.isEmpty(r12) == false) goto L6;
        return true;
    L6:
        if (this.b != null) goto L9;
        this.b = (CcmOverWordConfig) SettingManager.getInstance().get(CcmOverWordConfig.class);
    L9:
        if (r12.length() <= this.b.getMaxCharWithSpaceCount()) goto L11;
        return true;
    L11:
        char[] r13 = r12.toCharArray();
        int r0 = r13.length;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        boolean r7 = true;
    L12:
        if (r3 >= r0) goto L49;
        char r8 = r13[r3];
        Character.UnicodeBlock r9 = Character.UnicodeBlock.of(r8);
        if (r9 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L16;
    L37:
        boolean r10 = true;
    L38:
        if (r10 == false) goto L42;
        r4 = r4 + 1;
        r6 = r6 + 1;
    L40:
        r7 = true;
    L47:
        r3 = r3 + 1;
        goto L12
    L42:
        if (Character.isWhitespace(r8) == true) goto L40;
        if (r7 == false) goto L46;
        r5 = r5 + 1;
    L46:
        r6 = r6 + 1;
        r7 = false;
        goto L47
    L16:
        if (r9 == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L37;
        if (r9 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L37;
        if (r9 == Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L37;
        if (r9 == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L37;
        if (r9 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L37;
        if (r9 == Character.UnicodeBlock.HANGUL_SYLLABLES) goto L37;
        if (r9 == Character.UnicodeBlock.BOPOMOFO) goto L37;
        if (r9 == Character.UnicodeBlock.BOPOMOFO_EXTENDED) goto L37;
        if (r9 == Character.UnicodeBlock.HIRAGANA) goto L37;
        if (r9 == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS) goto L37;
        r10 = false;
        goto L38
    L49:
        if (r4 <= this.b.getEnWordCount()) goto L51;
    L56:
        tt5.a.d("ClipboardServiceImp", "isWordOver " + r1 + "  " + r4 + " : " + r5 + " : " + r6);
        return r1;
    L51:
        if (r5 > this.b.getWordCount()) goto L56;
        if (r6 > this.b.getMaxCharCount()) goto L56;
        r1 = false;
        goto L56
    }

    public final boolean h(ClipData r2, Token r3) {
        return this.a.h(r2, r3);
    }

    public final ClipData k(String r2, Token r3) {
        return this.a.k(r2, r3);
    }

    public final boolean p(String r2, Token r3) {
        return n(r2, true, r3);
    }

    public final ActionMode q(ActionMode r3, Function0<Boolean> r4) {
        if (r3 != null) goto L4;
    L13:
        return r3;
    L4:
        if (TextViewMenuUtilsKt.f() == true) goto L8;
        if (((Boolean) TextViewMenuUtilsKt.c.getValue()).booleanValue() == false) goto L13;
    L8:
        if (Build.VERSION.SDK_INT != 31) goto L13;
        if (s() == false) goto L13;
        kb5.a r0 = new kb5.a(r3, r4);
        r0.invalidate();
        return r0;
    }

    public final boolean u(SheetCellContentView r5, Token r6) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r1 = r5.getSelectionStart();
        int r2 = r5.getSelectionEnd();
        if (r2 <= r1) goto L16;
        if (r1 < 0) goto L16;
        if (r2 > r5.getText().length()) goto L16;
        String r7 = r5.getText().toString();
        if (TextUtils.isEmpty(r7) == false) goto L14;
        return false;
    L14:
        h(ClipData.newPlainText("text", r7.substring(r1, r2)), r6);
        return true;
    L16:
        return false;
    }

    public final boolean v(Context r3, Intent r4) {
        if (TextViewMenuUtilsKt.f() == true) goto L5;
        return false;
    L5:
        int r0 = com.suite.lark.emm.impl.a.a;
        com.suite.lark.emm.impl.a.a.a().getClass();
        if (SCClipboardProvider.a().L0() == false) goto L8;
    L11:
        return false;
    L8:
        if (TextViewMenuUtilsKt.e(r4) == false) goto L11;
        UDToast.show(r3, 2131889628);
        return true;
    }

    public static void x(b r3, Menu r4, Function0 r5) {
        r3.getClass();
        boolean r6 = ((Boolean) r5.invoke()).booleanValue();
        int r0 = 0;
    L4:
        if (r0 >= r4.size()) goto L11;
        MenuItem r1 = r4.getItem(r0);
        if (TextViewMenuUtilsKt.g(r1) == false) goto L9;
        if (r6 == false) goto L9;
        r1.setVisible(false);
    L10:
        r0 = r0 + 1;
    L9:
        r1.setVisible(true);
        goto L10
    }

    public final boolean m(ClipData r2, boolean r3, Token r4) {
        return this.a.m(r2, r3, r4);
    }

    public final boolean n(String r2, boolean r3, Token r4) {
        return m(ClipData.newPlainText("url", r2), r3, r4);
    }

    public final boolean g(String r2, ClipData r3, boolean r4, Token r5) {
        return this.a.g(r2, r3, r4, r5);
    }
}
