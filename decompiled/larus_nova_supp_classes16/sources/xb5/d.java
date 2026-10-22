package xb5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.lark.dependency.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.keyboard.biz.plus.PlusKBPlugin;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.widget.richtext.RichText;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import hob.j;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements d5b.a {
    public d5b.c a;
    public final Chat b;
    public final Context c;
    public final Function0 d;
    public final m5b.c e;
    public final com.ss.android.lark.keyboard.b f;
    public final String g;

    public final void b() {
    }

    public final void c() {
    }

    public final int e() {
        return 10;
    }

    public final int getIconId() {
        return 2131235963;
    }

    public final boolean isVisible() {
        return true;
    }

    public final /* synthetic */ void showRedDot() {
    }

    public final String getName() {
        return this.c.getString(2131892203);
    }

    public final void d(PlusKBPlugin r1) {
        this.a = r1;
    }

    public final void onClick(View r6) {
        this.a.i();
        int r7 = bc5.a.a;
        Statistics.sendEvent("docs_send");
        Chat r8 = this.b;
        if (r8 == null) goto L5;
        String r9 = r8.getId();
    L6:
        this.a.k(new c());
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.messenger.chatbox_createdocs") == false) goto L9;
        this.d.invoke();
    L9:
        Activity r0 = this.a.getActivity();
        Fragment r1 = this.a.l();
        String r2 = this.g;
        Bundle r3 = new Bundle();
        if (r9 == null) goto L12;
        r3.putString("chat_id", r9);
    L12:
        r3.putString("extra_confirm_text", r2);
        if (r1 == null) goto L18;
        g r4 = f.b(r1);
        if (r4 == null) goto L17;
        onc.b r5 = new onc.b(r3);
        ForsetiNavOptions.a r10 = new ForsetiNavOptions.a();
        r10.d = 2457;
        r4.i(r5, r10.a());
        return;
    L17:
        com.bytedance.ee.bear.lark.selector.a.a(r0, 2457, r3);
        return;
    L18:
        com.bytedance.ee.bear.lark.selector.a.a(r0, 2457, r3);
        return;
    L5:
        r9 = null;
        goto L6
    }

    public final boolean a(Intent r12, int r13) {
        boolean r0 = false;
        if (r12 != null) goto L5;
    L44:
        return false;
    L5:
        if (r13 != 2457) goto L44;
        ArrayList<String> r14 = r12.getStringArrayListExtra("data");
        if (CollectionUtils.isEmpty(r14) == false) goto L10;
        return false;
    L10:
        com.ss.android.lark.keyboard.b r1 = this.f;
        if (r1 != null) goto L47;
    L33:
        if (r0 == false) goto L35;
        return true;
    L35:
        Iterator<String> r16 = r14.iterator();
    L37:
        if (r16.hasNext() == false) goto L42;
        RichText r7 = com.ss.android.lark.widget.richtext.c.c(r16.next());
        m5b.c r3 = this.e;
        if (r3 != null) goto L40;
        ((t) org.koin.java.a.a(t.class)).K2(this.b.getId(), this.a.h(), this.a.d(), r7, this.a.f());
        goto L37
    L40:
        r3.o(this.a.h(), this.a.d(), r7, false, this.a.c(), false, false);
        goto L37
    L42:
        tt5.a.b("DocModule onAc", "p = " + this.a.d() + " , r = " + this.a.h());
        this.a.m();
        return true;
    L47:
        final KeyboardFunctionEditText r2 = r1.L().c();     // Catch: Throwable -> L31
        if ((r2 instanceof KeyboardFunctionEditText) == true) goto L17;
        tt5.a.k("DocSendKBPlusItem", "insert docs to input failed: editText is not KeyboardFunctionEditText");
        goto L33
    L17:
        KeyboardFunctionEditText r4 = r2;
        int r5 = 0;
    L45:
    L29:
        th = move-exception;
        tt5.a.e("DocSendKBPlusItem", "insert docs to input failed", th, false);
        goto L33
    L19:
        if (r5 >= r14.size()) goto L27;
        if (r5 <= 0) goto L26;
        int r6 = r4.getSelectionStart();     // Catch: Throwable -> L29
        Editable r8 = r4.getText();     // Catch: Throwable -> L29
        if (r6 >= 0) goto L25;
        r6 = r4.length();     // Catch: Throwable -> L29
    L25:
        r8.insert(r6, " ");     // Catch: Throwable -> L29
    L26:
        r4.q(eob.a.f).insert(new j((String) ListProtector.get(r14, r5)));     // Catch: Throwable -> L29
        r5 = r5 + 1;     // Catch: Throwable -> L29
        goto L45
    L27:
        r2.post(new b(this, r2));     // Catch: Throwable -> L29
        r0 = true;
    L31:
        th = move-exception;
        tt5.a.e("DocSendKBPlusItem", "insert docs to input failed: get editText error", th, false);
        goto L33
    }

    public d(Context r1, Chat r2, com.ss.android.lark.keyboard.b r3, com.ss.android.lark.integrator.ccm.spacekit.g r4) {
        this.c = r1;
        this.b = r2;
        this.e = null;
        this.f = r3;
        this.g = null;
        this.d = r4;
    }
}
