package hn4;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.TextUtils;
import com.bytedance.ee.bear.lark.dependency.h0;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f486102a;

    public static class a implements h0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boc.b f486103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f486104b;

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final void c() {
            int r100 = com.suite.lark.emm.impl.a.f460436a;
            com.suite.lark.emm.impl.a.C5524a.a().getClass();
            SCClipboardProvider.a().O0(SCClipboardScene.SCENE_DISABLE_COPY);
        }

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final Boolean f() {
            boc.b r100 = this.f486103a;
            if (r100 != null) goto L7;
            tt5.a.h("SecurityClipboardImpl", "hasPrimaryClip... iscClipboardManager is null");
            return Boolean.FALSE;
        L7:
            return Boolean.valueOf(r100.f());
        }

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final void i() {
            int r100 = com.suite.lark.emm.impl.a.f460436a;
            com.suite.lark.emm.impl.a.C5524a.a().getClass();
            SCClipboardProvider.a().O0(n());
        }

        public final SCClipboardScene n() {
            if (TextUtils.isEmpty(this.f486104b) == true) goto L5;
            SCClipboardScene r100 = SCClipboardScene.SCENE_ENCRYPT;
            r100.setParam(this.f486104b);
            return r100;
        L5:
            return SCClipboardScene.SCENE_DEFAULT;
        }

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final Boolean b() {
            if (n() != SCClipboardScene.SCENE_ENCRYPT) goto L5;
            boolean r100 = true;
        L7:
            return Boolean.valueOf(r100);
        L5:
            r100 = false;
            goto L7
        }

        public a(boc.b r100) {
            this.f486103a = r100;
        }

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final void a(String r100) {
            this.f486104b = r100;
            boc.b r101 = this.f486103a;
            if (r101 == null) goto L5;
            r101.Q0(n());
            return;
        L5:
            tt5.a.h("SecurityClipboardImpl", "setEncryptId... iscClipboardManager is null");
        }

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final void d(ClipboardManager.OnPrimaryClipChangedListener r100) {
            boc.b r101 = this.f486103a;
            if (r101 != null) goto L6;
            tt5.a.h("SecurityClipboardImpl", "removePrimaryClipChangedListener... iscClipboardManager is null");
            return;
        L6:
            r101.d(r100);
        }

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final void e(ClipboardManager.OnPrimaryClipChangedListener r100) {
            boc.b r101 = this.f486103a;
            if (r101 != null) goto L6;
            tt5.a.h("SecurityClipboardImpl", "addPrimaryClipChangedListener... iscClipboardManager is null");
            return;
        L6:
            r101.e(r100);
        }

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final void j(String r100) {
            SCClipboardScene r101 = SCClipboardScene.SCENE_DEFAULT;
            if (TextUtils.isEmpty(r100) == true) goto L5;
            r101 = SCClipboardScene.SCENE_ENCRYPT;
            r101.setParam(r100);
        L5:
            int r102 = com.suite.lark.emm.impl.a.f460436a;
            com.suite.lark.emm.impl.a.C5524a.a().getClass();
            SCClipboardProvider.a().O0(r101);
        }

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final ClipData l(Token r100) {
            boc.b r101 = this.f486103a;
            if (r101 != null) goto L11;
            tt5.a.h("SecurityClipboardImpl", "getPrimaryClip... iscClipboardManager is null");
            return null;
        L11:
            return r101.T0(r100);
        L8:
            e = move-exception;
            tt5.a.f("SecurityClipboardImpl", e, false);
            return null;
        }

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final boolean h(ClipData r100, Token r101) {
            return m(r100, true, r101);
        }

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final ClipData k(String r100, Token r101) {
            if (this.f486103a != null) goto L15;
            tt5.a.h("SecurityClipboardImpl", "getPrimaryClip... iscClipboardManager is null");
            return null;
        L15:
        L12:
            e = move-exception;
            tt5.a.f("SecurityClipboardImpl", e, false);
            return null;
        L7:
            if (TextUtils.isEmpty(r100) == false) goto L9;
            SCClipboardScene r102 = SCClipboardScene.SCENE_DEFAULT;     // Catch: SensitiveAPIException -> L12
        L10:
            this.f486103a.Q0(r102);     // Catch: SensitiveAPIException -> L12
            ClipData r103 = this.f486103a.T0(r101);     // Catch: SensitiveAPIException -> L12
            this.f486103a.Q0(n());     // Catch: SensitiveAPIException -> L12
            return r103;
        L9:
            SCClipboardScene r104 = SCClipboardScene.SCENE_ENCRYPT;     // Catch: SensitiveAPIException -> L12
            r104.setParam(r100);     // Catch: SensitiveAPIException -> L12
            r102 = r104;
            goto L10
        }

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final boolean m(ClipData r100, boolean r101, Token r102) {
            boc.b r103 = this.f486103a;
            boolean r104 = false;
            if (r103 != null) goto L6;
            tt5.a.h("SecurityClipboardImpl", "setPrimaryClip... iscClipboardManager is null");
            return false;
        L6:
            if (r101 == true) goto L15;
            r103.Q0(SCClipboardScene.SCENE_SYSTEM);
        L15:
            this.f486103a.M0(r100, r102);     // Catch: SensitiveAPIException -> L10
            r104 = true;
        L12:
            if (r101 == true) goto L14;
            this.f486103a.Q0(n());
        L14:
            return r104;
        L10:
            e = move-exception;
            tt5.a.f("SecurityClipboardImpl", e, false);
            goto L12
        }

        @Override // com.bytedance.ee.bear.lark.dependency.h0.a
        public final boolean g(String r100, ClipData r101, boolean r102, Token r103) {
            boolean r104 = false;
            if (this.f486103a != null) goto L7;
            tt5.a.h("SecurityClipboardImpl", "setPrimaryClip... iscClipboardManager is null");
            return false;
        L7:
            if (TextUtils.isEmpty(r100) == true) goto L11;
            if (r102 == false) goto L11;
            SCClipboardScene r105 = SCClipboardScene.SCENE_ENCRYPT;
            r105.setParam(r100);
        L12:
            this.f486103a.Q0(r105);
            this.f486103a.M0(r101, r103);     // Catch: SensitiveAPIException -> L15
            r104 = true;
        L17:
            this.f486103a.Q0(n());
            return r104;
        L15:
            e = move-exception;
            tt5.a.f("SecurityClipboardImpl", e, false);
        L11:
            r105 = SCClipboardScene.SCENE_DEFAULT;
            goto L12
        }
    }
}
