package com.lynx.tasm;

import android.text.TextUtils;
import com.lynx.devtoolwrapper.LynxDevToolPool;
import com.lynx.jsbridge.LynxBytecodeCallback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.service.security.ILynxSecurityService;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class TemplateBundle implements j8a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f381768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f381769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f381770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f381771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t1 f381772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f381773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LynxDevToolPool f381774g;

    public interface a {
    }

    private static native boolean nativeConstructContext(long r100, int r101);

    private static native boolean nativeGetContainsElementTree(long r100);

    private static native Object nativeGetExtraInfo(long r100);

    private static native void nativeInitWithOption(long r100, int r101, boolean r102);

    private static native long nativeParseTemplateFromByteArray(byte[] r100, Object[] r101, boolean r102, long r103);

    private static native long nativeParseTemplateFromByteBuffer(ByteBuffer r100, Object[] r101, boolean r102, long r103);

    private static native void nativePostJsCacheGenerationTask(long r100, String r101, boolean r102, LynxBytecodeCallback r103);

    private static native void nativeReleaseBundle(long r100);

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        return false;
    }

    public final boolean i() {
        if (this.f381768a == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public TemplateBundle() {
        this.f381768a = 0;
        this.f381769b = null;
        this.f381771d = false;
        this.f381772e = new t1(null);
    }

    public final boolean h() {
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L5;
    L7:
        return false;
    L5:
        if (i() == false) goto L7;
        return nativeGetContainsElementTree(this.f381768a);
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final void k() {
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L5;
    L7:
        boolean r100 = false;
    L9:
        if (r100 == false) goto L20;
        a r101 = this.f381773f;
        if (r101 == null) goto L20;
        u.a r102 = (u.a) r101;
        u r103 = r102.f383805c;
        monitor-enter(r103);
        r102.f383803a.clear();     // Catch: Throwable -> L17
        Map<TemplateBundle, LinkedList<LynxEngine>> r104 = r102.f383805c.f383802a;     // Catch: Throwable -> L17
        HashMap r105 = (HashMap) r104;     // Catch: Throwable -> L17
        r105.remove(r102.f383804b);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        this.f381773f = null;
    L17:
        th = move-exception;
        throw th;
    L20:
        LynxDevToolPool r106 = this.f381774g;
        if (r106 == null) goto L23;
        r106.destroy();
        this.f381774g = null;
    L23:
        if (r100 == false) goto L28;
        nativeReleaseBundle(this.f381768a);
        this.f381768a = 0;
        return;
    L28:
        return;
    L5:
        if (this.f381768a == 0) goto L7;
        r100 = true;
        goto L9
    }

    public final void finalize() throws Throwable {
        k();
    }

    public static TemplateBundle b(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return g(new TemplateBundle(), r100, null, null, null);
    }

    private static Object decodeByteBuffer(ByteBuffer r100) {
        if (r100 == null) goto L5;
        j7a.a.f497652a.getClass();
        return j7a.a.a(r100);
    L5:
        return null;
    }

    public final void d(a2 r100) {
        if (i() == false) goto L8;
        if (r100 == null) goto L9;
        nativeInitWithOption(this.f381768a, r100.f381787a, r100.f381788b);
        return;
    L9:
        return;
    }

    public final void j(String r100) {
        if (i() == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        nativePostJsCacheGenerationTask(this.f381768a, r100, false, null);
        return;
    }

    public static TemplateBundle a(ByteBuffer r100, a2 r101) {
        String r102 = r101.f381790d;
        if (r100.isDirect() == true) goto L6;
        LLog.i("TemplateBundle", "TemplateBundle only supports DirectByteBuffer.");
        TemplateBundle r103 = new TemplateBundle();
        r103.f(0, r100.limit(), "TemplateBundle only supports DirectByteBuffer.", null);
        return r103;
    L6:
        TemplateBundle r104 = g(new TemplateBundle(), null, r100, r102, r101);
        r104.d(r101);
        return r104;
    }

    public static TemplateBundle c(byte[] r100, a2 r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 == null) goto L7;
        String r102 = r101.f381790d;
    L8:
        TemplateBundle r103 = g(new TemplateBundle(), r100, null, r102, r101);
        r103.d(r101);
        return r103;
    L7:
        r102 = null;
        goto L8
    }

    private static TemplateBundle fromNative(long r100, ReadableMap r101) {
        if (r100 != 0) goto L5;
        String r102 = "native TemplateBundle doesn't exist";
    L6:
        String r103 = r102;
        TemplateBundle r104 = new TemplateBundle();
        r104.f(r100, 0, r103, r101);
        return r104;
    L5:
        r102 = null;
        goto L6
    }

    public final boolean e(byte[] r100, a2 r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (this.f381771d == false) goto L7;
        return false;
    L7:
        if (r101 == null) goto L9;
        String r102 = r101.f381790d;
    L10:
        g(this, r100, null, r102, r101);
        d(r101);
        return true;
    L9:
        r102 = null;
        goto L10
    }

    public final synchronized void f(long r100, int r101, String r102, ReadableMap r103) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f381771d == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f381768a = r100;     // Catch: Throwable -> L10
        this.f381770c = r101;     // Catch: Throwable -> L10
        this.f381769b = r102;     // Catch: Throwable -> L10
        this.f381772e = new t1(r103);     // Catch: Throwable -> L10
        this.f381771d = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public static TemplateBundle g(TemplateBundle r110, byte[] r111, ByteBuffer r112, String r113, a2 r114) {
        if (r110 != null) goto L5;
        r110 = new TemplateBundle();
    L5:
        if (r111 != null) goto L7;
        if (r112 != null) goto L7;
    L58:
        return r110;
    L7:
        if (r112 == null) goto L9;
        int r100 = r112.limit();
    L10:
        int r101 = r100;
        TraceEvent.beginSection("TemplateBundle.fromTemplate");
        LynxDevToolPool r102 = null;
    L59:
        th = th;
    L60:
        if (r102 == null) goto L62;
        r102.destroy();
    L62:
        TraceEvent.endSection("TemplateBundle.fromTemplate");
        throw th;
    L12:
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L54;
        ILynxSecurityService r103 = (ILynxSecurityService) i8a.n.c().a(ILynxSecurityService.class);     // Catch: Throwable -> L59
        if (r103 == null) goto L16;
        j8a.b r104 = r103.verifyTASM(r110, r111, r112, r113, ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE);     // Catch: Throwable -> L59
    L18:
        if (r104.f497736a == true) goto L23;
        r110.f(0, r101, "template verify failed, error message: " + r104.f497737b, null);     // Catch: Throwable -> L59
        TraceEvent.endSection("TemplateBundle.fromTemplate");
        return r110;
    L23:
        if (r114 != null) goto L25;
    L27:
        boolean r105 = false;
    L28:
        if (r114 != null) goto L30;
    L32:
        boolean r115 = false;
    L34:
        if (LynxEnv.inst().isLynxDebugEnabled() == true) goto L36;
        LynxDevToolPool r116 = null;
    L65:
        Object[] r106 = new Object[2];     // Catch: Throwable -> L51
        if (r116 == null) goto L42;
        long r107 = r116.getNativePtr();     // Catch: Throwable -> L51
    L43:
        if (r112 == null) goto L45;
        long r117 = nativeParseTemplateFromByteBuffer(r112, r106, r115, r107);     // Catch: Throwable -> L51
    L46:
        r110.f(r117, r101, (String) r106[0], (ReadableMap) r106[1]);     // Catch: Throwable -> L51
        if (r110.i() == false) goto L50;
        r110.f381774g = r116;     // Catch: Throwable -> L51
    L55:
        if (r102 == null) goto L57;
        r102.destroy();
    L57:
        TraceEvent.endSection("TemplateBundle.fromTemplate");
        goto L58
    L50:
        r102 = r116;
        goto L55
    L45:
        r117 = nativeParseTemplateFromByteArray(r111, r106, r115, r107);     // Catch: Throwable -> L51
        goto L46
    L42:
        r107 = 0;
    L51:
        th = th;
        r102 = r116;
        goto L60
    L36:
        r116 = new LynxDevToolPool(r113, r105);     // Catch: Throwable -> L59
        goto L65
    L30:
        if (r114.f381789c == false) goto L32;
        r115 = true;
        goto L34
    L25:
        if (r114.f381791e == false) goto L27;
        r105 = true;
        goto L28
    L16:
        r104 = j8a.b.b();     // Catch: Throwable -> L59
        goto L18
    L54:
        r110.f(0, r101, "Lynx Env is not prepared", null);     // Catch: Throwable -> L59
        goto L55
    L9:
        r100 = r111.length;
        goto L10
    }
}
