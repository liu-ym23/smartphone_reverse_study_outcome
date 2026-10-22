package com.bytedance.kmp.ec.yata.common.log;

import com.bytedance.kmp.ec.yata.common.utils.YataThreadExtKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "SDK内部工具类")
public final class YaTaLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f251436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f251437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f251438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f251439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f251440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f251441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Boolean f251442g;

    /* JADX INFO: renamed from: com.bytedance.kmp.ec.yata.common.log.YaTaLog$d$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 0}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Function0<String> $message;
        final /* synthetic */ String $tag;

        public AnonymousClass1(String r100, Function0<String> r101) {
            this.$tag = r100;
            this.$message = r101;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String r100 = YaTaLog.f251436a;
            a r101 = YaTaLog.f251441f;
            if (r101 == null) goto L6;
            r101.d("YATA-" + this.$tag, this.$message.invoke());
            return;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.kmp.ec.yata.common.log.YaTaLog$e$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 0}, xi = 48)
    public static final class C106261 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Function0<String> $message;
        final /* synthetic */ String $tag;

        public C106261(String r100, Function0<String> r101) {
            this.$tag = r100;
            this.$message = r101;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String r100 = YaTaLog.f251436a;
            a r101 = YaTaLog.f251441f;
            if (r101 == null) goto L6;
            r101.e("YATA-" + this.$tag, this.$message.invoke());
            return;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.kmp.ec.yata.common.log.YaTaLog$e$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Function0<String> $message;
        final /* synthetic */ String $tag;
        final /* synthetic */ Throwable $throwable;

        public AnonymousClass2(String r100, Function0<String> r101, Throwable r102) {
            this.$tag = r100;
            this.$message = r101;
            this.$throwable = r102;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String r100 = YaTaLog.f251436a;
            a r101 = YaTaLog.f251441f;
            if (r101 == null) goto L6;
            r101.e("YATA-" + this.$tag, this.$message.invoke(), this.$throwable);
            return;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.kmp.ec.yata.common.log.YaTaLog$i$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 0}, xi = 48)
    public static final class C106271 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Function0<String> $message;
        final /* synthetic */ String $tag;

        public C106271(String r100, Function0<String> r101) {
            this.$tag = r100;
            this.$message = r101;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String r100 = YaTaLog.f251436a;
            a r101 = YaTaLog.f251441f;
            if (r101 == null) goto L6;
            r101.i("YATA-" + this.$tag, this.$message.invoke());
            return;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public static void c(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
    }

    public static void d(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
    }

    public static void e(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
    }

    public static void g(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
    }

    static {
        f251440e = true;
    }

    public static boolean h() {
        if (f251442g != null) goto L11;
        a r100 = f251441f;
        if (r100 == null) goto L9;
        boolean r101 = true;
        if (r100.b() != true) goto L9;
    L10:
        f251442g = Boolean.valueOf(r101);
    L9:
        r101 = false;
    L11:
        Boolean r102 = f251442g;
        if (r102 != null) goto L14;
        return false;
    L14:
        return r102.booleanValue();
    }

    public static Pair j(Object r100) {
        String r101 = "";
        if (r100 == null) goto L5;
        boolean r102 = true;
        if ((r100 instanceof String) == false) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = r100 instanceof Number;
    L13:
        if (r102 == false) goto L17;
        return new Pair(Boolean.TRUE, "");
    L17:
        if ((r100 instanceof List) == false) goto L31;
        Iterator r104 = ((List) r100).iterator();
    L20:
        if (r104.hasNext() == false) goto L24;
        Pair r105 = j(r104.next());
        if (((Boolean) r105.getFirst()).booleanValue() == true) goto L20;
        Pair r106 = new Pair(Boolean.FALSE, r105.getSecond());
    L26:
        if (((Boolean) r106.getFirst()).booleanValue() == true) goto L29;
        return new Pair(Boolean.FALSE, r106.getSecond());
    L29:
        return new Pair(Boolean.TRUE, "");
    L24:
        r106 = new Pair(Boolean.TRUE, "");
        goto L26
    L31:
        if ((r100 instanceof Map) == false) goto L37;
        Pair r107 = k((Map) r100);
        if (((Boolean) r107.getFirst()).booleanValue() == true) goto L36;
        return new Pair(Boolean.FALSE, r107.getSecond());
    L36:
        return new Pair(Boolean.TRUE, "");
    L37:
        Boolean r108 = Boolean.FALSE;
        String r109 = Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName();
        if (r109 == null) goto L42;
        r101 = r109;
    L42:
        return new Pair(r108, r101);
    L9:
        r103 = r100 instanceof Boolean;
        goto L10
    L5:
        return new Pair(Boolean.TRUE, "");
    }

    @Deprecated(message = "废弃，不要直接使用", replaceWith = @ReplaceWith(expression = "YaTaLog.assertBaseDataType", imports = {}))
    public static Pair k(Map r100) {
        if (r100 == null) goto L5;
        Iterator r101 = r100.entrySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L14;
        Pair r102 = j(((Map.Entry) r101.next()).getValue());
        if (((Boolean) r102.getFirst()).booleanValue() == true) goto L8;
        return new Pair(Boolean.FALSE, r102.getSecond());
    L14:
        return new Pair(Boolean.TRUE, "");
    L5:
        return new Pair(Boolean.TRUE, "");
    }

    public static void a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (f251437b == true) goto L5;
        return;
    L5:
        if (h() == false) goto L12;
        Pair r102 = k(r101);
        if (((Boolean) r102.getFirst()).booleanValue() == false) goto L10;
        return;
    L10:
        throw new IllegalStateException("SDK内部不支持该数据类型" + ((String) r102.getSecond()) + "  触发场景:" + r100);
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f251437b == true) goto L5;
    L9:
        f(r100, new Exception(r100 + ' ' + r101), r101);
        return;
    L5:
        if (h() == false) goto L9;
        throw new IllegalStateException(r100 + ' ' + r101);
    }

    public static void i(final Function0 r100, final Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (f251438c == true) goto L5;
        return;
    L5:
        if (h() == false) goto L9;
        YataThreadExtKt.b(new YaTaLog$openWarningDialogInDebug$1(r100, r101));
        return;
    }

    public static void f(String r100, Throwable r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "msg");
        if (f251440e == false) goto L7;
        a r103 = f251441f;
        if (r103 == null) goto L7;
        r103.ensureNotReachHere(r101, r100 + ' ' + r102);
    L7:
        e(r100, new YaTaLog$ensureNotReachHere$1(r102));
    }
}
