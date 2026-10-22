package com.bytedance.ug.sdk.share.impl.manager;

import android.os.Build;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import oo7.m;
import oo7.q;
import oo7.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f272351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f272352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f272353c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a() {
        ?? r100 = 0;
        r100 = 0;
        if (this.f272351a == false) goto L21;
        if (TextUtils.isEmpty(this.f272352b) == true) goto L21;
        a r101 = a.C3811a.f272314a;
        String r102 = this.f272352b;
        r101.getClass();
        ko7.c r103 = ko7.c.b.f504529a;
        if (r103.f504526a == false) goto L9;
        oo7.k.e("ClipBoardCheckerManager", "checkLock is true");
        goto L21
    L9:
        String r104 = m.a().b("user_copy_content", "");
        if (TextUtils.isEmpty(r104) == false) goto L12;
    L14:
        r101.f272313a = null;
        String r105 = r101.a(r102, true);
        oo7.k.a("ClipBoardCheckerManager", "clipboard command is " + r105);
        if (TextUtils.isEmpty(r105) == true) goto L17;
    L19:
        j.c.f272350a.f272346a = true;
        r103.c(r105, 0);
        goto L21
    L17:
        if (TextUtils.isEmpty(r101.f272313a) == false) goto L19;
        eo7.a r106 = eo7.a.b.f473353a;
        oo7.d.c(2, "正则匹配失败");
        goto L21
    L12:
        if (r102.equals(r104) == false) goto L14;
        oo7.k.e("ClipBoardCheckerManager", "cache text is equal to clipboard text");
        r.a r107 = r.f524639a;
        eo7.a r108 = eo7.a.b.f473353a;
        jo7.c.a(new q("reflow", "cache text is equal to clipboard text", null, r107));
        oo7.d.a();
        oo7.d.c(3, "自己复制的口令");
    L21:
        if (this.f272353c.f272346a == true) goto L35;
        eo7.a r109 = eo7.a.b.f473353a;
        if (r109.f473342p == true) goto L25;
    L27:
        oo7.k.e("TokenCheckerManager", "album parse enable status is " + r100);
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L30
        r110.put("album_parse_switch", r100);     // Catch: Exception -> L30
        r110.put("brand", Build.BRAND);     // Catch: Exception -> L30
        r110.put("system_version", Build.VERSION.SDK_INT);     // Catch: Exception -> L30
        r.c("checkImageToken start", "reflow", r110, r.f524639a);     // Catch: Exception -> L30
    L31:
        if (r100 == 0) goto L35;
        eo7.a r111 = eo7.a.b.f473353a;
        jn7.f r112 = eo7.a.e();
        if (r112 == null) goto L35;
        r112.checkImageToken();
        goto L35
    L25:
        if (((Boolean) r109.c("enable_album_parse", Boolean.TRUE)).booleanValue() == false) goto L27;
        r100 = 1;
    L35:
        this.f272353c.getClass();
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

    public k(j r100, boolean r101, String r102) {
        this.f272353c = r100;
        this.f272351a = r101;
        this.f272352b = r102;
    }
}
