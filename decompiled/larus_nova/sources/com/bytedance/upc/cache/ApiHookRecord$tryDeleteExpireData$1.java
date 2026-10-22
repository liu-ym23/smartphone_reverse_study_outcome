package com.bytedance.upc.cache;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class ApiHookRecord$tryDeleteExpireData$1 extends Lambda implements Function0<Unit> {
    public static final ApiHookRecord$tryDeleteExpireData$1 INSTANCE = null;

    static {
        INSTANCE = new ApiHookRecord$tryDeleteExpireData$1();
    }

    public ApiHookRecord$tryDeleteExpireData$1() {
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.ArrayList] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ApiMultiProcessSharedProvider.b r100 = ApiHookRecord.a();
        if (r100 == null) goto L45;
        Calendar r101 = Calendar.getInstance(Locale.US);
        long r102 = r101.getTimeInMillis();
        Integer r103 = Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME);
        r103.intValue();
        r101.setTimeInMillis(r102 - (((long) r103.intValue()) * 86400000));
        String r104 = ApiHookRecord.f272435b.format(r101.getTime());
        Set r105 = r100.d("date");
        if (r105 == null) goto L15;
        Set r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L8:
        if (r107.hasNext() == false) goto L16;
        Object r108 = r107.next();
        if (((String) r108).compareTo(r104) <= 0) goto L12;
        boolean r109 = true;
    L13:
        if (r109 == false) goto L8;
        r106.add(r108);
        goto L8
    L12:
        r109 = false;
    L16:
        Set<String> r110 = ApiHookRecord.f272434a;
        Set r111 = r100.d("date");
        if (r111 == null) goto L27;
        Set r112 = new ArrayList();
        Iterator r113 = r111.iterator();
    L20:
        if (r113.hasNext() == false) goto L29;
        Object r114 = r113.next();
        if (((String) r114).compareTo(r104) >= 0) goto L24;
        boolean r115 = true;
    L25:
        if (r115 == false) goto L20;
        r112.add(r114);
        goto L20
    L24:
        r115 = false;
    L29:
        if (r112.isEmpty() == false) goto L49;
        return;
    L49:
        ApiMultiProcessSharedProvider.a r116 = new ApiMultiProcessSharedProvider.a(r100.f272448a);     // Catch: Throwable -> L46
        Set<String> r117 = ApiHookRecord.f272434a;     // Catch: Throwable -> L46
        r116.c("date", TypeIntrinsics.asMutableSet(r106));     // Catch: Throwable -> L46
        Iterator r118 = ((Iterable) r112).iterator();     // Catch: Throwable -> L46
    L33:
        if (r118.hasNext() == false) goto L38;
        String r119 = (String) r118.next();     // Catch: Throwable -> L46
        Iterator r120 = ApiHookRecord.f272434a.iterator();     // Catch: Throwable -> L46
    L36:
        if (r120.hasNext() == false) goto L33;
        String r121 = (String) r120.next();     // Catch: Throwable -> L46
        String r122 = ApiHookRecord.b(r119, r121);     // Catch: Throwable -> L46
        r116.f272447b.putNull(r122);     // Catch: Throwable -> L46
        String r123 = ApiHookRecord.c(r119, r121);     // Catch: Throwable -> L46
        r116.f272447b.putNull(r123);     // Catch: Throwable -> L46
        goto L36
    L38:
        monitor-enter(r116);     // Catch: Throwable -> L46
        r116.a();     // Catch: Throwable -> L42
        monitor-exit(r116);     // Catch: Throwable -> L46
        return;
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L63:
        return;
    L27:
        r112 = SetsKt.emptySet();
        goto L29
    L15:
        r106 = SetsKt.emptySet();
        goto L16
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
