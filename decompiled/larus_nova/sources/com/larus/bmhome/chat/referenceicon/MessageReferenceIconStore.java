package com.larus.bmhome.chat.referenceicon;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.collection.LruCache;
import com.bytedance.keva.Keva;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.AccountService;
import hq9.v2;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: classes25.dex */
public final class MessageReferenceIconStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MessageReferenceIconStore f308518a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f308519b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MessageReferenceIconStore$bitmapCache$1 f308520c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LruCache<String, Integer> f308521d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f308522e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ThreadLocal<MessageDigest> f308523f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, CompletableDeferred<a>> f308524g = null;

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore$a$a, reason: collision with other inner class name */
        public static final class C4066a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4066a f308525a = null;

            static {
                f308525a = new C4066a();
            }

            public C4066a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Bitmap f308526a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f308526a, ((b) r100).f308526a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f308526a.hashCode();
            }

            public final String toString() {
                return "Success(bitmap=" + this.f308526a + ')';
            }

            public b(Bitmap r100) {
                Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
                this.f308526a = r100;
            }
        }

        public a() {
        }
    }

    public MessageReferenceIconStore() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore$bitmapCache$1] */
    static {
        f308518a = new MessageReferenceIconStore();
        f308519b = new Object();
        f308520c = new MessageReferenceIconStore$bitmapCache$1();
        f308521d = new LruCache(256);
        f308522e = LazyKt.lazy(new d());
        f308523f = ThreadLocal.withInitial(new e());
        f308524g = new LinkedHashMap();
    }

    public static Keva f() {
        return (Keva) f308522e.getValue();
    }

    public static String b(String r100) {
        return "document:" + r100;
    }

    public static String c(String r110) {
        StringBuilder r100 = new StringBuilder("obj_type:");
        MessageDigest r101 = f308523f.get();
        r101.reset();
        r100.append(ArraysKt.joinToString$default(r101.digest(r110.getBytes(Charsets.UTF_8)), "", null, null, 0, null, new f(), 30, null));
        return r100.toString();
    }

    public static Bitmap e(String r100) {
        Object r101 = f308519b;
        monitor-enter(r101);
        MessageReferenceIconStore$bitmapCache$1 r102 = f308520c;     // Catch: Throwable -> L14
        Bitmap r103 = r102.get(r100);     // Catch: Throwable -> L14
        if (r103 == null) goto L11;
        boolean r104 = r103.isRecycled();     // Catch: Throwable -> L14
        if (r104 == false) goto L9;
        r102.remove(r100);     // Catch: Throwable -> L14
    L9:
        if (r104 == true) goto L11;
    L12:
        monitor-exit(r101);
        return r103;
    L11:
        r103 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public static Integer g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "documentUrl");
        Integer r101 = null;
        if (StringsKt.isBlank(r100) == false) goto L5;
        return null;
    L5:
        String r102 = b(r100);
        String r103 = c(r100);
        Object r104 = f308519b;
        monitor-enter(r104);
        LruCache<String, Integer> r105 = f308521d;     // Catch: Throwable -> L21
        Integer r106 = r105.get(r102);     // Catch: Throwable -> L21
        if (r106 != null) goto L18;
        boolean r107 = false;
        Integer r108 = Integer.valueOf(f().getInt(r103, 0));     // Catch: Throwable -> L21
        if (r108.intValue() == 0) goto L12;
        r107 = true;
    L12:
        if (r107 == true) goto L15;
        r108 = null;
    L15:
        if (r108 == null) goto L19;
        r105.put(r102, Integer.valueOf(r108.intValue()));     // Catch: Throwable -> L21
        r101 = r108;
    L19:
        monitor-exit(r104);
        return r101;
    L18:
        r101 = r106;
    L21:
        th = move-exception;
        throw th;
    }

    public static void k(String r110) {
        LinkedHashSet r100 = new LinkedHashSet(SequencesKt.toList(SequencesKt.filter(SequencesKt.map(StringsKt.lineSequence(f().getString("__document_obj_type_index__", "")), MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$1.INSTANCE), MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$2.INSTANCE)));
        r100.remove(r110);
        r100.add(r110);
    L4:
        if (r100.size() <= 256) goto L9;
        String r111 = (String) CollectionsKt.firstOrNull(r100);
        if (r111 == null) goto L9;
        r100.remove(r111);
        f().erase(r111);
    L9:
        f().storeString("__document_obj_type_index__", CollectionsKt.joinToString$default(r100, "\n", null, null, 0, null, null, 62, null));
    }

    public static void j(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "documentUrl");
        if (StringsKt.isBlank(r100) == true) goto L24;
        if (r101 == 0) goto L27;
        String r102 = b(r100);
        String r103 = c(r100);
        Object r104 = f308519b;
        monitor-enter(r104);
        LruCache<String, Integer> r105 = f308521d;     // Catch: Throwable -> L21
        Integer r106 = r105.get(r102);     // Catch: Throwable -> L21
        if (r106 != null) goto L12;
    L15:
        r105.put(r102, Integer.valueOf(r101));     // Catch: Throwable -> L21
        if (f().getInt(r103, 0) == r101) goto L18;
        f().storeInt(r103, r101);     // Catch: Throwable -> L21
        k(r103);     // Catch: Throwable -> L21
    L18:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r104);
        return;
    L12:
        if (r106.intValue() != r101) goto L15;
        monitor-exit(r104);
        return;
    L21:
        th = move-exception;
        throw th;
    L27:
        return;
    }

    public static String a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.e() == true) goto L5;
    L32:
        return null;
    L5:
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L32;
        if (r102 == null) goto L17;
        Long r104 = StringsKt.toLongOrNull(r102);
        if (r104 == null) goto L17;
        long r105 = r104.longValue();
    L19:
        if (r105 <= 0) goto L32;
        String r106 = AccountService.f365697a.getUserId();
        if ((true ^ StringsKt.isBlank(r106)) == true) goto L25;
        r106 = null;
    L25:
        if (r106 != null) goto L27;
        return null;
    L27:
        v2 r107 = LarkSocialExp.a();
        if (r107 != null) goto L31;
        return null;
    L31:
        return "avatar:" + r106 + ':' + r107.f486794a + ':' + r107.f486795b + ':' + r100 + ':' + r102 + ':' + r101;
    L17:
        r105 = 0;
        goto L19
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r103 = false;
        goto L11
    }

    public static void d(String r100, CompletableDeferred r101, a r102) {
        Object r103 = f308519b;
        monitor-enter(r103);
        Map<String, CompletableDeferred<a>> r104 = f308524g;     // Catch: Throwable -> L11
        if (((LinkedHashMap) r104).get(r100) != r101) goto L7;
        r104.remove(r100);     // Catch: Throwable -> L11
    L7:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r103);
        r101.complete(r102);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00b7 -> B:51:0x00ba). Please report as a decompilation issue!!! */
    public final Object h(String r110, Function1<? super Continuation<? super Bitmap>, ? extends Object> r111, Continuation<? super Bitmap> r112) {
        if ((r112 instanceof MessageReferenceIconStore$getOrLoad$1) == false) goto L7;
        MessageReferenceIconStore$getOrLoad$1 r100 = (MessageReferenceIconStore$getOrLoad$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        Bitmap r104 = null;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L21;
        if (r103 != 2) goto L20;
        CompletableDeferred<a> r114 = (CompletableDeferred) r100.L$1;
        String r115 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L15 CancellationException -> L17
    L64:
        Bitmap r116 = (Bitmap) r113;     // Catch: Throwable -> L15 CancellationException -> L17
        if (r116 != null) goto L67;
    L69:
        r116 = null;
    L70:
        if (r116 == null) goto L90;
        Object r105 = f308519b;     // Catch: Throwable -> L15 CancellationException -> L17
        monitor-enter(r105);     // Catch: Throwable -> L15 CancellationException -> L17
        MessageReferenceIconStore$bitmapCache$1 r106 = f308520c;     // Catch: Throwable -> L87
        Bitmap r107 = r106.get(r115);     // Catch: Throwable -> L87
        if (r107 == null) goto L80;
        boolean r108 = r107.isRecycled();     // Catch: Throwable -> L87
        if (r108 == false) goto L78;
        r106.remove(r115);     // Catch: Throwable -> L87
    L78:
        if (r108 == true) goto L80;
        r104 = r107;
    L80:
        if (r104 != null) goto L83;
        r106.put(r115, r116);     // Catch: Throwable -> L87
    L84:
        monitor-exit(r105);     // Catch: Throwable -> L15 CancellationException -> L17
        d(r115, r114, new a.b(r116));     // Catch: Throwable -> L15 CancellationException -> L17
        return r116;
    L83:
        r116 = r104;
    L87:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15 CancellationException -> L17
    L90:
        d(r115, r114, a.C4066a.f308525a);     // Catch: Throwable -> L15 CancellationException -> L17
        return r116;
    L67:
        if (r116.isRecycled() == true) goto L69;
    L17:
        CancellationException e100 = e;
    L98:
        d(r115, r114, a.C4066a.f308525a);
        throw e100;
    L15:
        Throwable th10 = th;
    L94:
        d(r115, r114, a.C4066a.f308525a);
        throw th10;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        Function1<? super Continuation<? super Bitmap>, ? extends Object> r117 = (Function1) r100.L$1;
        String r118 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
        r111 = r117;
        r110 = r118;
    L51:
        a r119 = (a) r113;
        if ((r119 instanceof a.b) == false) goto L56;
        return ((a.b) r119).f308526a;
    L56:
        if (Intrinsics.areEqual(r119, a.C4066a.f308525a) == true) goto L23;
        throw new NoWhenBranchMatchedException();
    L23:
        Ref.ObjectRef r120 = new Ref.ObjectRef();
        Ref.BooleanRef r109 = new Ref.BooleanRef();
        Object r121 = f308519b;
        monitor-enter(r121);
        MessageReferenceIconStore$bitmapCache$1 r122 = f308520c;     // Catch: Throwable -> L100
        Bitmap r123 = r122.get(r110);     // Catch: Throwable -> L100
        if (r123 == null) goto L33;
        boolean r124 = r123.isRecycled();     // Catch: Throwable -> L100
        if (r124 == false) goto L31;
        r122.remove(r110);     // Catch: Throwable -> L100
    L31:
        if (Boxing.boxBoolean(r124).booleanValue() == true) goto L33;
        T r125 = r123;
    L34:
        r120.element = r125;     // Catch: Throwable -> L100
        if (r125 == 0) goto L37;
        CompletableDeferred<a> r126 = null;
    L40:
        monitor-exit(r121);
        Bitmap r127 = (Bitmap) r120.element;
        if (r127 != null) goto L43;
        if (r126 == null) goto L23;
        if (r109.element == true) goto L107;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.label = 1;
        r113 = r126.await(r100);
        if (r113 != r102) goto L51;
        return r102;
    L107:
        r100.L$0 = r110;     // Catch: Throwable -> L92 CancellationException -> L96
        r100.L$1 = r126;     // Catch: Throwable -> L92 CancellationException -> L96
        r100.label = 2;     // Catch: Throwable -> L92 CancellationException -> L96
        r113 = r111.invoke(r100);     // Catch: Throwable -> L92 CancellationException -> L96
        if (r113 != r102) goto L63;
        return r102;
    L63:
        r115 = r110;
        r114 = r126;
        goto L64
    L96:
        e = move-exception;
        e100 = e;
        r115 = r110;
        r114 = r126;
    L92:
        th = move-exception;
        th10 = th;
        r115 = r110;
        r114 = r126;
        goto L94
    L43:
        return r127;
    L37:
        Map<String, CompletableDeferred<a>> r128 = f308524g;     // Catch: Throwable -> L100
        r126 = (CompletableDeferred) ((LinkedHashMap) r128).get(r110);     // Catch: Throwable -> L100
        if (r126 != null) goto L40;
        r126 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L100
        r128.put(r110, r126);     // Catch: Throwable -> L100
        r109.element = true;     // Catch: Throwable -> L100
    L33:
        r125 = 0;
    L100:
        th = move-exception;
        throw th;
    L22:
        ResultKt.throwOnFailure(r113);
    L7:
        r100 = new MessageReferenceIconStore$getOrLoad$1(this, r112);
        goto L8
    }

    public final Object i(Context r110, String r111, String r112, String r113, Continuation<? super Bitmap> r114) {
        if ((r114 instanceof MessageReferenceIconStore$loadAvatar$1) == false) goto L7;
        MessageReferenceIconStore$loadAvatar$1 r100 = (MessageReferenceIconStore$loadAvatar$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r105 = (String) r100.L$3;
        String r106 = (String) r100.L$2;
        String r107 = (String) r100.L$1;
        String r108 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L21:
        Bitmap r109 = (Bitmap) r102;
        if (r109 != null) goto L24;
        return null;
    L24:
        if (Intrinsics.areEqual(r105, a(r108, r107, r106)) == true) goto L26;
        return null;
    L26:
        return r109;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r115 = a(r111, r112, r113);
        if (r115 != null) goto L17;
        return null;
    L17:
        Function1<? super Continuation<? super Bitmap>, ? extends Object> r116 = new MessageReferenceIconStore$loadAvatar$bitmap$1(r115, r111, r112, r113, r110, null);
        r100.L$0 = r111;
        r100.L$1 = r112;
        r100.L$2 = r113;
        r100.L$3 = r115;
        r100.label = 1;
        Object r117 = h(r115, r116, r100);
        if (r117 != r103) goto L20;
        return r103;
    L20:
        r105 = r115;
        r102 = r117;
        r108 = r111;
        r107 = r112;
        r106 = r113;
    L7:
        r100 = new MessageReferenceIconStore$loadAvatar$1(this, r114);
        goto L8
    }
}
