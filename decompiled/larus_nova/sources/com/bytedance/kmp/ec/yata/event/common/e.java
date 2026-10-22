package com.bytedance.kmp.ec.yata.event.common;

import com.bytedance.kmp.ec.yata.chain.trigger.ChainStartSource;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.common.platform.o;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f251660a = null;

    public static final class a {
        public a() {
        }

        public final f a(YataStoreWrapper r110, o r111, String r112, String r113, Map<String, ? extends Object> r114, String r115) {
            Intrinsics.checkNotNullParameter(r110, "instance");
            Intrinsics.checkNotNullParameter(r115, "bizMonitorTag");
            return b(this, r110, r111, r112, r113, r114, "biz", r115, false, null, 384);
        }

        public static f b(a r110, YataStoreWrapper r111, o r112, String r113, String r114, Map r115, String r116, String r210, boolean r211, String r212, int r213) {
            if ((r213 & 32) == 0) goto L5;
            String r100 = ChainStartSource.YATA;
        L7:
            if ((r213 & 64) == 0) goto L9;
            String r117 = "sdkBuild";
        L11:
            if ((r213 & 128) == 0) goto L13;
            boolean r118 = false;
        L15:
            if ((r213 & 512) == 0) goto L17;
            String r101 = null;
        L18:
            r110.getClass();
            Intrinsics.checkNotNullParameter(r111, "storeWrapper");
            Intrinsics.checkNotNullParameter(r100, "chainStartSource");
            Intrinsics.checkNotNullParameter(r117, "monitorTag");
            YaTaLog.a("EventInput.consumeData", r115);
            return new f(r111, r112, r113, r114, r115, r100, r101, r117, r118, null);
        L17:
            r101 = r212;
            goto L18
        L13:
            r118 = r211;
            goto L15
        L9:
            r117 = r210;
            goto L11
        L5:
            r100 = r116;
            goto L7
        }
    }

    static {
        f251660a = new a();
    }

    @Deprecated(message = "调试工具")
    public abstract void a(String r100, Function0<? extends Object> r101);

    @Deprecated(message = "废弃, 历史老逻辑，不要用，很容易出错")
    public abstract void b(String r100, Object r101);

    public abstract Map<String, Object> c();

    public abstract Map<String, Object> d();

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public abstract String i();

    public abstract String k();

    public abstract YataStoreWrapper l();

    public abstract o m();

    public abstract String n();

    public abstract com.bytedance.kmp.ec.yata.common.protocol.data.g o();

    public abstract Map<String, Object> q();

    public abstract void s(Map<String, ? extends Object> r100);

    public abstract void t(Map<String, ? extends Object> r100);

    public abstract void u(Map<String, ? extends Object> r100);

    public abstract void v(Map<String, ? extends Object> r100);

    public final String h() {
        Object r100 = p(Reflection.getOrCreateKotlinClass(String.class), "operator_type");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final com.bytedance.kmp.ec.yata.store.node.c j() {
        String r100 = k();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return null;
    L13:
        return l().o(r100);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final String r() {
        com.bytedance.kmp.ec.yata.common.protocol.data.g r100 = o();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getType();
    }

    public e() {
    }

    @Deprecated(message = "SDK内部调用，业务不可以调用，因为是内联函数，所以必须开放权限", replaceWith = @ReplaceWith(expression = "getYataEventField<T>(key)", imports = {}))
    public final Object p(KClass<?> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L10;
        Map<String, Object> r102 = q();
        if (r102 == null) goto L33;
        Object r103 = r102.get(r101);
        if (r103 == null) goto L33;
        return com.bytedance.kmp.ec.yata.common.utils.d.d(r103);
    L33:
        return null;
    L10:
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L17;
        Map<String, Object> r104 = q();
        if (r104 == null) goto L33;
        Object r105 = r104.get(r101);
        if (r105 == null) goto L33;
        return com.bytedance.kmp.ec.yata.common.utils.d.e(r105);
    L17:
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L24;
        Map<String, Object> r106 = q();
        if (r106 == null) goto L33;
        Object r107 = r106.get(r101);
        if (r107 == null) goto L33;
        return com.bytedance.kmp.ec.yata.common.utils.d.a(r107);
    L24:
        if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Map<String, Object> r108 = q();
        if (r108 == null) goto L33;
        Object r109 = r108.get(r101);
        if (r109 == null) goto L33;
        return com.bytedance.kmp.ec.yata.common.utils.d.c(r109);
    L30:
        Map<String, Object> r110 = q();
        if (r110 == null) goto L33;
        return r110.get(r101);
    }
}
